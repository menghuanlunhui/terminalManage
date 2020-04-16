package com.ruoyi.terminal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位卡定位记录对象 t_terminal_gps_log
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public class TTerminalGpsLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** GPS记录主键id */
    private String serialId;

    /** 定位卡主键 */
    @Excel(name = "定位卡主键")
    private String terminalId;

    /** 定位卡名称 */
    @Excel(name = "定位卡名称")
    private String terminalName;

    /** 经度 */
    @Excel(name = "经度")
    private Double longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private Double latitude;

    private String startTime;

    private String endTime;

    /** 上报时的电量百分比（0到100之间） */
    @Excel(name = "上报时的电量百分比", readConverterExp = "0=到100之间")
    private Double batteryPercentage;

    /** 电子围栏标志:0 不在围栏内，1在围栏内，2未设置围栏 */
    @Excel(name = "电子围栏标志:0 不在围栏内，1在围栏内，2未设置围栏")
    private Integer fenceFlag;

    public void setSerialId(String serialId) 
    {
        this.serialId = serialId;
    }

    public String getSerialId() 
    {
        return serialId;
    }
    public void setTerminalId(String terminalId) 
    {
        this.terminalId = terminalId;
    }

    public String getTerminalId() 
    {
        return terminalId;
    }
    public void setLongitude(Double longitude) 
    {
        this.longitude = longitude;
    }

    public Double getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(Double latitude) 
    {
        this.latitude = latitude;
    }

    public Double getLatitude() 
    {
        return latitude;
    }
    public void setBatteryPercentage(Double batteryPercentage) 
    {
        this.batteryPercentage = batteryPercentage;
    }

    public Double getBatteryPercentage() 
    {
        return batteryPercentage;
    }
    public void setFenceFlag(Integer fenceFlag) 
    {
        this.fenceFlag = fenceFlag;
    }

    public Integer getFenceFlag() 
    {
        return fenceFlag;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("serialId", getSerialId())
            .append("terminalId", getTerminalId())
            .append("terminalName", getTerminalName())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("batteryPercentage", getBatteryPercentage())
            .append("fenceFlag", getFenceFlag())
            .append("createTime", getCreateTime())
            .toString();
    }
}
