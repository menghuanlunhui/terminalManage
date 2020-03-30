package com.ruoyi.terminal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位卡字典对象 t_terminal_dict
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public class TTerminalDict extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 终端字典编码 */
    private String terminalDictCode;

    /** 终端字典名称 */
    @Excel(name = "终端字典名称")
    private String terminalDictName;

    /** 终端字典备注信息 */
    @Excel(name = "终端字典备注信息")
    private String terminalDictMemo;

    /** 终端字典类型:0终端厂商字典，1终端设备类型 */
    @Excel(name = "终端字典类型:0终端厂商字典，1终端设备类型")
    private Integer terminalDictType;

    /** 启用禁用标志：0=禁用；1=启用 */
    @Excel(name = "启用禁用标志：0=禁用；1=启用")
    private Integer enableFlag;

    public void setTerminalDictCode(String terminalDictCode) 
    {
        this.terminalDictCode = terminalDictCode;
    }

    public String getTerminalDictCode() 
    {
        return terminalDictCode;
    }
    public void setTerminalDictName(String terminalDictName) 
    {
        this.terminalDictName = terminalDictName;
    }

    public String getTerminalDictName() 
    {
        return terminalDictName;
    }
    public void setTerminalDictMemo(String terminalDictMemo) 
    {
        this.terminalDictMemo = terminalDictMemo;
    }

    public String getTerminalDictMemo() 
    {
        return terminalDictMemo;
    }
    public void setTerminalDictType(Integer terminalDictType) 
    {
        this.terminalDictType = terminalDictType;
    }

    public Integer getTerminalDictType() 
    {
        return terminalDictType;
    }
    public void setEnableFlag(Integer enableFlag) 
    {
        this.enableFlag = enableFlag;
    }

    public Integer getEnableFlag() 
    {
        return enableFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("terminalDictCode", getTerminalDictCode())
            .append("terminalDictName", getTerminalDictName())
            .append("terminalDictMemo", getTerminalDictMemo())
            .append("terminalDictType", getTerminalDictType())
            .append("enableFlag", getEnableFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
