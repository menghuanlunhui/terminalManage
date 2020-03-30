package com.ruoyi.terminal.service;

import java.util.List;
import com.ruoyi.terminal.domain.TTerminalDict;

/**
 * 定位卡字典Service接口
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public interface ITTerminalDictService 
{
    /**
     * 查询定位卡字典
     * 
     * @param terminalDictCode 定位卡字典ID
     * @return 定位卡字典
     */
    public TTerminalDict selectTTerminalDictById(String terminalDictCode);

    /**
     * 查询定位卡字典列表
     * 
     * @param tTerminalDict 定位卡字典
     * @return 定位卡字典集合
     */
    public List<TTerminalDict> selectTTerminalDictList(TTerminalDict tTerminalDict);

    /**
     * 新增定位卡字典
     * 
     * @param tTerminalDict 定位卡字典
     * @return 结果
     */
    public int insertTTerminalDict(TTerminalDict tTerminalDict);

    /**
     * 修改定位卡字典
     * 
     * @param tTerminalDict 定位卡字典
     * @return 结果
     */
    public int updateTTerminalDict(TTerminalDict tTerminalDict);

    /**
     * 批量删除定位卡字典
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTerminalDictByIds(String ids);

    /**
     * 删除定位卡字典信息
     * 
     * @param terminalDictCode 定位卡字典ID
     * @return 结果
     */
    public int deleteTTerminalDictById(String terminalDictCode);
}
