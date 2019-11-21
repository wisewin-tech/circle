package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

public class IncidentMsgBO extends BaseModel {
    private String origin;//起点
    private String destination;//终点
    private String incidentTime;//时间
    private String incident;//事件

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(String incidentTime) {
        this.incidentTime = incidentTime;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }
}
