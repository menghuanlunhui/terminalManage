package com.ruoyi.terminal.service;

import java.util.List;
import com.ruoyi.terminal.domain.TTerminalFence;

/**
 * 定位卡电子围栏配置Service接口
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public interface ITTerminalFenceService 
{
    /**
     * 查询定位卡电子围栏配置
     * 
     * @param terminalFenceId 定位卡电子围栏配置ID
     * @return 定位卡电子围栏配置
     */
    public TTerminalFence selectTTerminalFenceById(String terminalFenceId);

    /**
     * 查询定位卡电子围栏配置列表
     * 
     * @param tTerminalFence 定位卡电子围栏配置
     * @return 定位卡电子围栏配置集合
     */
    public List<TTerminalFence> selectTTerminalFenceList(TTerminalFence tTerminalFence);

    /**
     * 新增定位卡电子围栏配置
     * 
     * @param tTerminalFence 定位卡电子围栏配置
     * @return 结果
     */
    public int insertTTerminalFence(TTerminalFence tTerminalFence);

    /**
     * 修改定位卡电子围栏配置
     * 
     * @param tTerminalFence 定位卡电子围栏配置
     * @return 结果
     */
    public int updateTTerminalFence(TTerminalFence tTerminalFence);

    /**
     * 批量删除定位卡电子围栏配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTerminalFenceByIds(String ids);

    /**
     * 删除定位卡电子围栏配置信息
     * 
     * @param terminalFenceId 定位卡电子围栏配置ID
     * @return 结果
     */
    public int deleteTTerminalFenceById(String terminalFenceId);
}
