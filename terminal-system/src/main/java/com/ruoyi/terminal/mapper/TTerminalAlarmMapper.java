package com.ruoyi.terminal.mapper;

import java.util.List;
import com.ruoyi.terminal.domain.TTerminalAlarm;

/**
 * 定位卡关联闹钟信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public interface TTerminalAlarmMapper 
{
    /**
     * 查询定位卡关联闹钟信息
     * 
     * @param terminalAlarmId 定位卡关联闹钟信息ID
     * @return 定位卡关联闹钟信息
     */
    public TTerminalAlarm selectTTerminalAlarmById(String terminalAlarmId);

    /**
     * 查询定位卡关联闹钟信息列表
     * 
     * @param tTerminalAlarm 定位卡关联闹钟信息
     * @return 定位卡关联闹钟信息集合
     */
    public List<TTerminalAlarm> selectTTerminalAlarmList(TTerminalAlarm tTerminalAlarm);

    /**
     * 新增定位卡关联闹钟信息
     * 
     * @param tTerminalAlarm 定位卡关联闹钟信息
     * @return 结果
     */
    public int insertTTerminalAlarm(TTerminalAlarm tTerminalAlarm);

    /**
     * 修改定位卡关联闹钟信息
     * 
     * @param tTerminalAlarm 定位卡关联闹钟信息
     * @return 结果
     */
    public int updateTTerminalAlarm(TTerminalAlarm tTerminalAlarm);

    /**
     * 删除定位卡关联闹钟信息
     * 
     * @param terminalAlarmId 定位卡关联闹钟信息ID
     * @return 结果
     */
    public int deleteTTerminalAlarmById(String terminalAlarmId);

    /**
     * 批量删除定位卡关联闹钟信息
     * 
     * @param terminalAlarmIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTerminalAlarmByIds(String[] terminalAlarmIds);
}
