package com.ruoyi.terminal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 定位卡基础信息对象 t_terminal_info
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public class TTerminalInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 卡片编码 */
    private String terminalId;

    /** 卡片名称 */
    @Excel(name = "卡片名称")
    private String terminalName;

    /** 卡片分组id */
    @Excel(name = "卡片分组id")
    private String terminalGroupId;

    /** 卡片分组名称 */
    @Excel(name = "卡片分组名称")
    private String terminalGroupName;

    /** 卡片状态：0 在线 1离线 */
    @Excel(name = "卡片状态：0 在线 1离线")
    private Integer terminalStatus;

    /** 启用禁用标志：0 禁用，1启用 */
    @Excel(name = "启用禁用标志：0 禁用，1启用")
    private Integer enableFlag;

    /** 电量百分比（0到100之间） */
    @Excel(name = "电量百分比", readConverterExp = "0=到100之间")
    private Double batteryPercentage;

    /** 卡片到期时间 */
    @Excel(name = "卡片到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireTime;

    public void setTerminalId(String terminalId) 
    {
        this.terminalId = terminalId;
    }

    public String getTerminalId() 
    {
        return terminalId;
    }
    public void setTerminalName(String terminalName) 
    {
        this.terminalName = terminalName;
    }

    public String getTerminalName() 
    {
        return terminalName;
    }
    public void setTerminalGroupId(String terminalGroupId) 
    {
        this.terminalGroupId = terminalGroupId;
    }

    public String getTerminalGroupId() 
    {
        return terminalGroupId;
    }
    public void setTerminalStatus(Integer terminalStatus) 
    {
        this.terminalStatus = terminalStatus;
    }

    public Integer getTerminalStatus() 
    {
        return terminalStatus;
    }
    public void setEnableFlag(Integer enableFlag) 
    {
        this.enableFlag = enableFlag;
    }

    public Integer getEnableFlag() 
    {
        return enableFlag;
    }
    public void setBatteryPercentage(Double batteryPercentage) 
    {
        this.batteryPercentage = batteryPercentage;
    }

    public Double getBatteryPercentage() 
    {
        return batteryPercentage;
    }
    public void setExpireTime(Date expireTime) 
    {
        this.expireTime = expireTime;
    }

    public Date getExpireTime() 
    {
        return expireTime;
    }

    public String getTerminalGroupName() {
        return terminalGroupName;
    }

    public void setTerminalGroupName(String terminalGroupName) {
        this.terminalGroupName = terminalGroupName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("terminalId", getTerminalId())
            .append("terminalName", getTerminalName())
            .append("terminalGroupId", getTerminalGroupId())
            .append("terminalGroupName", getTerminalGroupName())
            .append("terminalStatus", getTerminalStatus())
            .append("enableFlag", getEnableFlag())
            .append("batteryPercentage", getBatteryPercentage())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("expireTime", getExpireTime())
            .toString();
    }
}
