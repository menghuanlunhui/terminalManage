package com.ruoyi.terminal.service;

import java.util.List;
import com.ruoyi.terminal.domain.TTerminalGroup;

/**
 * 定位卡分组信息Service接口
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public interface ITTerminalGroupService 
{
    /**
     * 查询定位卡分组信息
     * 
     * @param terminalGroupId 定位卡分组信息ID
     * @return 定位卡分组信息
     */
    public TTerminalGroup selectTTerminalGroupById(String terminalGroupId);

    /**
     * 查询定位卡分组信息列表
     * 
     * @param tTerminalGroup 定位卡分组信息
     * @return 定位卡分组信息集合
     */
    public List<TTerminalGroup> selectTTerminalGroupList(TTerminalGroup tTerminalGroup);

    /**
     * 新增定位卡分组信息
     * 
     * @param tTerminalGroup 定位卡分组信息
     * @return 结果
     */
    public int insertTTerminalGroup(TTerminalGroup tTerminalGroup);

    /**
     * 修改定位卡分组信息
     * 
     * @param tTerminalGroup 定位卡分组信息
     * @return 结果
     */
    public int updateTTerminalGroup(TTerminalGroup tTerminalGroup);

    /**
     * 批量删除定位卡分组信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTerminalGroupByIds(String ids);

    /**
     * 删除定位卡分组信息信息
     * 
     * @param terminalGroupId 定位卡分组信息ID
     * @return 结果
     */
    public int deleteTTerminalGroupById(String terminalGroupId);
}
