package com.ruoyi.terminal.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.terminal.mapper.TTerminalAlarmMapper;
import com.ruoyi.terminal.domain.TTerminalAlarm;
import com.ruoyi.terminal.service.ITTerminalAlarmService;
import com.ruoyi.common.core.text.Convert;

/**
 * 定位卡关联闹钟信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Service
public class TTerminalAlarmServiceImpl implements ITTerminalAlarmService 
{
    @Autowired
    private TTerminalAlarmMapper tTerminalAlarmMapper;

    /**
     * 查询定位卡关联闹钟信息
     * 
     * @param terminalAlarmId 定位卡关联闹钟信息ID
     * @return 定位卡关联闹钟信息
     */
    @Override
    public TTerminalAlarm selectTTerminalAlarmById(String terminalAlarmId)
    {
        return tTerminalAlarmMapper.selectTTerminalAlarmById(terminalAlarmId);
    }

    /**
     * 查询定位卡关联闹钟信息列表
     * 
     * @param tTerminalAlarm 定位卡关联闹钟信息
     * @return 定位卡关联闹钟信息
     */
    @Override
    public List<TTerminalAlarm> selectTTerminalAlarmList(TTerminalAlarm tTerminalAlarm)
    {
        return tTerminalAlarmMapper.selectTTerminalAlarmList(tTerminalAlarm);
    }

    /**
     * 新增定位卡关联闹钟信息
     * 
     * @param tTerminalAlarm 定位卡关联闹钟信息
     * @return 结果
     */
    @Override
    public int insertTTerminalAlarm(TTerminalAlarm tTerminalAlarm)
    {
        tTerminalAlarm.setCreateTime(DateUtils.getNowDate());
        return tTerminalAlarmMapper.insertTTerminalAlarm(tTerminalAlarm);
    }

    /**
     * 修改定位卡关联闹钟信息
     * 
     * @param tTerminalAlarm 定位卡关联闹钟信息
     * @return 结果
     */
    @Override
    public int updateTTerminalAlarm(TTerminalAlarm tTerminalAlarm)
    {
        tTerminalAlarm.setUpdateTime(DateUtils.getNowDate());
        return tTerminalAlarmMapper.updateTTerminalAlarm(tTerminalAlarm);
    }

    /**
     * 删除定位卡关联闹钟信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalAlarmByIds(String ids)
    {
        return tTerminalAlarmMapper.deleteTTerminalAlarmByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除定位卡关联闹钟信息信息
     * 
     * @param terminalAlarmId 定位卡关联闹钟信息ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalAlarmById(String terminalAlarmId)
    {
        return tTerminalAlarmMapper.deleteTTerminalAlarmById(terminalAlarmId);
    }
}
