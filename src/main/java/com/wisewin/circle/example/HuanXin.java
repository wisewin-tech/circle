package com.wisewin.circle.example;
 
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisewin.circle.example.api.impl.EasemobIMUsers;
import com.wisewin.circle.example.entity.RegUser;
import io.swagger.client.model.RegisterUsers;
public class HuanXin {
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
 
    private final static  EasemobIMUsers easemobIMUsers = new EasemobIMUsers();
 
      public static void main(String[] args){
          //添加IM人员
          RegUser regUser = new RegUser();
          regUser.setUsername("huajian");
          regUser.setPassword("123456");
          reg(regUser);
      }
      public static void reg(RegUser regUser){
          RegisterUsers registerUsers = new RegisterUsers();
          io.swagger.client.model.User p = new io.swagger.client.model.User().username(regUser.getUsername()).password(regUser.getPassword());
          registerUsers.add(p);
          Object result = easemobIMUsers.createNewIMUserSingle(registerUsers);
          System.out.println(gson.toJson(result));
      }
     
 
}
