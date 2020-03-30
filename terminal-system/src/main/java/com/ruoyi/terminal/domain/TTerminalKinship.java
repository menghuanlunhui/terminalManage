package com.ruoyi.terminal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位卡关联亲情号码对象 t_terminal_kinship
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public class TTerminalKinship extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String terminalKinshipId;

    /** 卡片主键 */
    @Excel(name = "卡片主键")
    private String terminalId;

    /** 卡片名称 */
    @Excel(name = "卡片名称")
    private String terminalName;

    /** 亲情手机号 */
    @Excel(name = "亲情手机号")
    private String terminalKinshipPhone;

    /** 亲情联络人姓名 */
    @Excel(name = "亲情联络人姓名")
    private String terminalKinshipContactor;

    /** 号码类型：0亲情号,1sos号码 */
    @Excel(name = "号码类型：0亲情号,1sos号码")
    private Integer terminalKinshipType;

    public void setTerminalKinshipId(String terminalKinshipId) 
    {
        this.terminalKinshipId = terminalKinshipId;
    }

    public String getTerminalKinshipId() 
    {
        return terminalKinshipId;
    }
    public void setTerminalId(String terminalId) 
    {
        this.terminalId = terminalId;
    }

    public String getTerminalId() 
    {
        return terminalId;
    }
    public void setTerminalKinshipPhone(String terminalKinshipPhone) 
    {
        this.terminalKinshipPhone = terminalKinshipPhone;
    }

    public String getTerminalKinshipPhone() 
    {
        return terminalKinshipPhone;
    }
    public void setTerminalKinshipContactor(String terminalKinshipContactor) 
    {
        this.terminalKinshipContactor = terminalKinshipContactor;
    }

    public String getTerminalKinshipContactor() 
    {
        return terminalKinshipContactor;
    }
    public void setTerminalKinshipType(Integer terminalKinshipType) 
    {
        this.terminalKinshipType = terminalKinshipType;
    }

    public Integer getTerminalKinshipType() 
    {
        return terminalKinshipType;
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
            .append("terminalKinshipId", getTerminalKinshipId())
            .append("terminalId", getTerminalId())
            .append("terminalName", getTerminalName())
            .append("terminalKinshipPhone", getTerminalKinshipPhone())
            .append("terminalKinshipContactor", getTerminalKinshipContactor())
            .append("terminalKinshipType", getTerminalKinshipType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
