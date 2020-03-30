package com.ruoyi.terminal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位卡关联闹钟信息对象 t_terminal_alarm
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public class TTerminalAlarm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String terminalAlarmId;

    /** 卡片主键 */
    @Excel(name = "卡片主键")
    private String terminalId;

    /** 卡片名称 */
    @Excel(name = "卡片名称")
    private String terminalName;

    /** 闹钟周期设置:0周日，1周一，2周二，3周三，4周四，5周五，6周六；多个逗号分隔 */
    @Excel(name = "闹钟周期设置:0周日，1周一，2周二，3周三，4周四，5周五，6周六；多个逗号分隔")
    private String terminalAlarmCycleDay;

    /** 闹钟提醒时间点 */
    @Excel(name = "闹钟提醒时间点")
    private String terminalAlarmPoint;

    /** 类型：0 闹钟 1整点报时 */
    @Excel(name = "类型：0 闹钟 1整点报时")
    private Integer terminalAlarmType;

    /** 启用禁用标志：0 禁用，1启用 */
    @Excel(name = "启用禁用标志：0 禁用，1启用")
    private Integer enableFlag;

    public void setTerminalAlarmId(String terminalAlarmId) 
    {
        this.terminalAlarmId = terminalAlarmId;
    }

    public String getTerminalAlarmId() 
    {
        return terminalAlarmId;
    }
    public void setTerminalId(String terminalId) 
    {
        this.terminalId = terminalId;
    }

    public String getTerminalId() 
    {
        return terminalId;
    }
    public void setTerminalAlarmCycleDay(String terminalAlarmCycleDay) 
    {
        this.terminalAlarmCycleDay = terminalAlarmCycleDay;
    }

    public String getTerminalAlarmCycleDay() 
    {
        return terminalAlarmCycleDay;
    }
    public void setTerminalAlarmPoint(String terminalAlarmPoint) 
    {
        this.terminalAlarmPoint = terminalAlarmPoint;
    }

    public String getTerminalAlarmPoint() 
    {
        return terminalAlarmPoint;
    }
    public void setTerminalAlarmType(Integer terminalAlarmType) 
    {
        this.terminalAlarmType = terminalAlarmType;
    }

    public Integer getTerminalAlarmType() 
    {
        return terminalAlarmType;
    }
    public void setEnableFlag(Integer enableFlag) 
    {
        this.enableFlag = enableFlag;
    }

    public Integer getEnableFlag() 
    {
        return enableFlag;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("terminalAlarmId", getTerminalAlarmId())
            .append("terminalId", getTerminalId())
            .append("terminalName", getTerminalName())
            .append("terminalAlarmCycleDay", getTerminalAlarmCycleDay())
            .append("terminalAlarmPoint", getTerminalAlarmPoint())
            .append("terminalAlarmType", getTerminalAlarmType())
            .append("enableFlag", getEnableFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
