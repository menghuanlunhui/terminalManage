package com.ruoyi.terminal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位卡电子围栏配置对象 t_terminal_fence
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public class TTerminalFence extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String terminalFenceId;

    /** 卡片主键 */
    @Excel(name = "卡片主键")
    private String terminalId;

    /** 卡片名称 */
    @Excel(name = "卡片名称")
    private String terminalName;

    /** 电子围栏类型：0圆形，1椭圆形，2线条形 */
    @Excel(name = "电子围栏类型：0圆形，1椭圆形，2线条形")
    private String terminalFenceType;

    /** 电子围栏顶点经纬度(多个顶点多条记录或者一条符号分隔开) */
    @Excel(name = "电子围栏顶点经纬度(多个顶点多条记录或者一条符号分隔开)")
    private String terminalFencePoint;

    /** 启用禁用标志：0 禁用，1启用 */
    @Excel(name = "启用禁用标志：0 禁用，1启用")
    private Integer enableFlag;

    public void setTerminalFenceId(String terminalFenceId) 
    {
        this.terminalFenceId = terminalFenceId;
    }

    public String getTerminalFenceId() 
    {
        return terminalFenceId;
    }
    public void setTerminalId(String terminalId) 
    {
        this.terminalId = terminalId;
    }

    public String getTerminalId() 
    {
        return terminalId;
    }
    public void setTerminalFenceType(String terminalFenceType) 
    {
        this.terminalFenceType = terminalFenceType;
    }

    public String getTerminalFenceType() 
    {
        return terminalFenceType;
    }
    public void setTerminalFencePoint(String terminalFencePoint) 
    {
        this.terminalFencePoint = terminalFencePoint;
    }

    public String getTerminalFencePoint() 
    {
        return terminalFencePoint;
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
            .append("terminalFenceId", getTerminalFenceId())
            .append("terminalId", getTerminalId())
            .append("terminalName", getTerminalName())
            .append("terminalFenceType", getTerminalFenceType())
            .append("terminalFencePoint", getTerminalFencePoint())
            .append("enableFlag", getEnableFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
