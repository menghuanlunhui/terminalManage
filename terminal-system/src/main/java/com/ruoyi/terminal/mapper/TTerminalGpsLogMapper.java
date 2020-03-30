package com.ruoyi.terminal.mapper;

import java.util.List;
import com.ruoyi.terminal.domain.TTerminalGpsLog;

/**
 * 定位卡定位记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public interface TTerminalGpsLogMapper 
{
    /**
     * 查询定位卡定位记录
     * 
     * @param serialId 定位卡定位记录ID
     * @return 定位卡定位记录
     */
    public TTerminalGpsLog selectTTerminalGpsLogById(String serialId);

    /**
     * 查询定位卡定位记录列表
     * 
     * @param tTerminalGpsLog 定位卡定位记录
     * @return 定位卡定位记录集合
     */
    public List<TTerminalGpsLog> selectTTerminalGpsLogList(TTerminalGpsLog tTerminalGpsLog);

    /**
     * 新增定位卡定位记录
     * 
     * @param tTerminalGpsLog 定位卡定位记录
     * @return 结果
     */
    public int insertTTerminalGpsLog(TTerminalGpsLog tTerminalGpsLog);

    /**
     * 修改定位卡定位记录
     * 
     * @param tTerminalGpsLog 定位卡定位记录
     * @return 结果
     */
    public int updateTTerminalGpsLog(TTerminalGpsLog tTerminalGpsLog);

    /**
     * 删除定位卡定位记录
     * 
     * @param serialId 定位卡定位记录ID
     * @return 结果
     */
    public int deleteTTerminalGpsLogById(String serialId);

    /**
     * 批量删除定位卡定位记录
     * 
     * @param serialIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTerminalGpsLogByIds(String[] serialIds);
}
