package com.wisewin.circle.util;

import com.wisewin.circle.entity.bo.UserMemberBO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxw on 2018/10/26.
 */

@Service("ReadExcel")
@Transactional
public class ReadExcel {


        // 总行数


        private int totalRows = 0;

        // 总条数

        private int totalCells = 0;

        // 错误信息接收器

        private String errorMsg;



        // 构造方法

        public ReadExcel() {

        }



        // 获取总行数

        public int getTotalRows() {

            return totalRows;

        }



        // 获取总列数

        public int getTotalCells() {

            return totalCells;

        }



        // 获取错误信息

        public String getErrorInfo() {

            return errorMsg;

        }



        /**

         * 读EXCEL文件，获取信息集合

         *


         * @return

         */

        public List<UserMemberBO> getExcelInfo(MultipartFile mFile) throws IOException, ParseException {

            String fileName = mFile.getOriginalFilename();// 获取文件名

                if (!validateExcel(fileName)) {// 验证文件名是否合格

                    return null;

                }

                boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本

                if (isExcel2007(fileName)) {

                    isExcel2003 = false;

                }
            List<UserMemberBO> userList = createExcel(mFile.getInputStream(), isExcel2003);


            return userList;

        }



        /**

         * 根据excel里面的内容读取客户信息

         *


         * @param isExcel2003 excel是2003还是2007版本

         * @return

         * @throws IOException

         */

        public List<UserMemberBO> createExcel(InputStream is, boolean isExcel2003) throws IOException, ParseException {


                Workbook wb = null;

                if (isExcel2003) {// 当excel是2003时,创建excel2003

                    wb = new HSSFWorkbook(is);

                } else {// 当excel是2007时,创建excel2007

                    wb = new XSSFWorkbook(is);

                }

                List<UserMemberBO> userList = readExcelValue(wb);// 读取Excel里面客户的信息


            return userList;

        }



        /**

         * 读取Excel里面客户的信息

         *

         * @param wb

         * @return

         */

        private List<UserMemberBO> readExcelValue(Workbook wb) throws ParseException {

            // 得到第一个shell

            Sheet sheet = wb.getSheetAt(0);

            // 得到Excel的行数

            this.totalRows = sheet.getPhysicalNumberOfRows();

            // 得到Excel的列数(前提是有行数)

            if (totalRows > 1 && sheet.getRow(0) != null) {

                this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();

            }

            List<UserMemberBO> userList = new ArrayList<UserMemberBO>();

            // 循环Excel行数

            for (int r = 1; r < totalRows; r++) {

                Row row = sheet.getRow(r);

                if (row == null) {

                    continue;

                }

                UserMemberBO user = new UserMemberBO();

                // 循环Excel的列

                for (int c = 0; c < this.totalCells; c++) {

                    Cell cell = row.getCell(c);

                    if (null != cell) {

                        if (c == 0) {

                            // 如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25

                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                String name = String.valueOf(cell.getNumericCellValue());

                                user.setName(name.substring(0, name.length() - 2 > 0 ? name.length() - 2 : 1));// 名称

                            } else {

                                user.setName(cell.getStringCellValue());// 名称

                            }

                        } else if (c == 1) {

                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                                DecimalFormat df = new DecimalFormat("0");
                                user.setPhoneNumber(df.format(cell.getNumericCellValue()));

                            } else {

                                user.setPhoneNumber(cell.getStringCellValue());// 性别

                            }

                        } else if (c == 2) {

                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                user.setBirthday(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));// 生日

                            } else {
                                String birthday=cell.getStringCellValue();
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                user.setBirthday(sdf.parse(birthday));// 生日
                            }

                        }else  if(c == 3){
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                String CertificateId = String.valueOf(cell.getNumericCellValue());

                                user.setCertificateId(Integer.valueOf(CertificateId.substring(0, CertificateId.length() - 2 > 0 ? CertificateId.length() - 2 : 1)));// 性别

                            } else {

                                user.setCertificateId(Integer.valueOf(cell.getStringCellValue()));

                            }

                        }else  if (c ==4){
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                DecimalFormat df = new DecimalFormat("0");
                                user.setCredentialNo(df.format(cell.getNumericCellValue()));
                            } else {

                                user.setCredentialNo(cell.getStringCellValue());

                            }
                        }else if (c==5){
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                String value = String.valueOf(cell.getNumericCellValue());

                                user.setGender(value.substring(0, value.length() - 2 > 0 ? value.length() - 2 : 1));// 性别

                            } else {

                                user.setGender(cell.getStringCellValue());

                            }

                        }else  if (c==6){
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                String value = String.valueOf(cell.getNumericCellValue());

                                user.setAddress(value.substring(0, value.length() - 2 > 0 ? value.length() - 2 : 1));// 性别

                            } else {

                                user.setAddress(cell.getStringCellValue());

                            }
                        }else  if (c==7){
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                String value = String.valueOf(cell.getNumericCellValue());

                                user.setSalesperson(value.substring(0, value.length() - 2 > 0 ? value.length() - 2 : 1));// 性别

                            } else {

                                user.setSalesperson(cell.getStringCellValue());

                            }
                        }else  if (c==8){
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                String value = String.valueOf(cell.getNumericCellValue());

                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                user.setCreateTime(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                            } else {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                user.setCreateTime(sdf.parse(cell.getStringCellValue()));

                            }
                        }else if (c==9){
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                String value = String.valueOf(cell.getNumericCellValue());

                                user.setCart(value.substring(0, value.length() - 2 > 0 ? value.length() - 2 : 1));
                            } else {
                               user.setCart(cell.getStringCellValue());

                            }

                        }else if (c==10) {
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

                                String value = String.valueOf(cell.getNumericCellValue());

                                user.setRemark(value.substring(0, value.length() - 2 > 0 ? value.length() - 2 : 1));// 性别

                            } else {
                                user.setRemark(cell.getStringCellValue());

                            }
                        }

                    }

                }

                // 添加到list

                userList.add(user);

            }

            return userList;

        }



        /**

         * 验证EXCEL文件

         * @param filePath

         * @return

         */

        public boolean validateExcel(String filePath) {

            if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {

                errorMsg = "文件名不是excel格式";

                return false;

            }

            return true;

        }



        // @描述：是否是2003的excel，返回true是2003

        public static boolean isExcel2003(String filePath) {

            return filePath.matches("^.+\\.(?i)(xls)$");

        }



        // @描述：是否是2007的excel，返回true是2007

        public static boolean isExcel2007(String filePath) {

            return filePath.matches("^.+\\.(?i)(xlsx)$");

        }

    }



