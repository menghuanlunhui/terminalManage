package com.ruoyi.terminal.service;

import java.util.List;
import com.ruoyi.terminal.domain.TTerminalKinship;

/**
 * 定位卡关联亲情号码Service接口
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public interface ITTerminalKinshipService 
{
    /**
     * 查询定位卡关联亲情号码
     * 
     * @param terminalKinshipId 定位卡关联亲情号码ID
     * @return 定位卡关联亲情号码
     */
    public TTerminalKinship selectTTerminalKinshipById(String terminalKinshipId);

    /**
     * 查询定位卡关联亲情号码列表
     * 
     * @param tTerminalKinship 定位卡关联亲情号码
     * @return 定位卡关联亲情号码集合
     */
    public List<TTerminalKinship> selectTTerminalKinshipList(TTerminalKinship tTerminalKinship);

    /**
     * 新增定位卡关联亲情号码
     * 
     * @param tTerminalKinship 定位卡关联亲情号码
     * @return 结果
     */
    public int insertTTerminalKinship(TTerminalKinship tTerminalKinship);

    /**
     * 修改定位卡关联亲情号码
     * 
     * @param tTerminalKinship 定位卡关联亲情号码
     * @return 结果
     */
    public int updateTTerminalKinship(TTerminalKinship tTerminalKinship);

    /**
     * 批量删除定位卡关联亲情号码
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTerminalKinshipByIds(String ids);

    /**
     * 删除定位卡关联亲情号码信息
     * 
     * @param terminalKinshipId 定位卡关联亲情号码ID
     * @return 结果
     */
    public int deleteTTerminalKinshipById(String terminalKinshipId);
}
