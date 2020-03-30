package com.ruoyi.terminal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位卡分组信息对象 t_terminal_group
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public class TTerminalGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 卡片分组主键id */
    private String terminalGroupId;

    /** 卡片分组名称 */
    @Excel(name = "卡片分组名称")
    private String terminalGroupName;

    /** 分组层级，从0开始递增；0=root节点； */
    @Excel(name = "分组层级，从0开始递增；0=root节点；")
    private Integer terminalGroupLevel;

    /** 上级分组id */
    @Excel(name = "上级分组id")
    private String parentTerminalGroupId;

    /** 上级分组id */
    @Excel(name = "上级分组名称")
    private String parentTerminalGroupName;


    /** 启用禁用标志：:0 禁用，1启用 */
    @Excel(name = "启用禁用标志：:0 禁用，1启用")
    private Integer enableFlag;

    public void setTerminalGroupId(String terminalGroupId) 
    {
        this.terminalGroupId = terminalGroupId;
    }

    public String getTerminalGroupId() 
    {
        return terminalGroupId;
    }
    public void setTerminalGroupName(String terminalGroupName) 
    {
        this.terminalGroupName = terminalGroupName;
    }

    public String getTerminalGroupName() 
    {
        return terminalGroupName;
    }
    public void setTerminalGroupLevel(Integer terminalGroupLevel) 
    {
        this.terminalGroupLevel = terminalGroupLevel;
    }

    public Integer getTerminalGroupLevel() 
    {
        return terminalGroupLevel;
    }
    public void setParentTerminalGroupId(String parentTerminalGroupId) 
    {
        this.parentTerminalGroupId = parentTerminalGroupId;
    }

    public String getParentTerminalGroupId() 
    {
        return parentTerminalGroupId;
    }
    public void setEnableFlag(Integer enableFlag) 
    {
        this.enableFlag = enableFlag;
    }

    public Integer getEnableFlag() 
    {
        return enableFlag;
    }

    public String getParentTerminalGroupName() {
        return parentTerminalGroupName;
    }

    public void setParentTerminalGroupName(String parentTerminalGroupName) {
        this.parentTerminalGroupName = parentTerminalGroupName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("terminalGroupId", getTerminalGroupId())
            .append("terminalGroupName", getTerminalGroupName())
            .append("terminalGroupLevel", getTerminalGroupLevel())
            .append("parentTerminalGroupId", getParentTerminalGroupId())
            .append("parentTerminalGroupName", getParentTerminalGroupName())
            .append("enableFlag", getEnableFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
