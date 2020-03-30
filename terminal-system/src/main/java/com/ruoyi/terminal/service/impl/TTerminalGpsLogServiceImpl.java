package com.ruoyi.terminal.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.terminal.mapper.TTerminalGpsLogMapper;
import com.ruoyi.terminal.domain.TTerminalGpsLog;
import com.ruoyi.terminal.service.ITTerminalGpsLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 定位卡定位记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Service
public class TTerminalGpsLogServiceImpl implements ITTerminalGpsLogService 
{
    @Autowired
    private TTerminalGpsLogMapper tTerminalGpsLogMapper;

    /**
     * 查询定位卡定位记录
     * 
     * @param serialId 定位卡定位记录ID
     * @return 定位卡定位记录
     */
    @Override
    public TTerminalGpsLog selectTTerminalGpsLogById(String serialId)
    {
        return tTerminalGpsLogMapper.selectTTerminalGpsLogById(serialId);
    }

    /**
     * 查询定位卡定位记录列表
     * 
     * @param tTerminalGpsLog 定位卡定位记录
     * @return 定位卡定位记录
     */
    @Override
    public List<TTerminalGpsLog> selectTTerminalGpsLogList(TTerminalGpsLog tTerminalGpsLog)
    {
        return tTerminalGpsLogMapper.selectTTerminalGpsLogList(tTerminalGpsLog);
    }

    /**
     * 新增定位卡定位记录
     * 
     * @param tTerminalGpsLog 定位卡定位记录
     * @return 结果
     */
    @Override
    public int insertTTerminalGpsLog(TTerminalGpsLog tTerminalGpsLog)
    {
        tTerminalGpsLog.setCreateTime(DateUtils.getNowDate());
        return tTerminalGpsLogMapper.insertTTerminalGpsLog(tTerminalGpsLog);
    }

    /**
     * 修改定位卡定位记录
     * 
     * @param tTerminalGpsLog 定位卡定位记录
     * @return 结果
     */
    @Override
    public int updateTTerminalGpsLog(TTerminalGpsLog tTerminalGpsLog)
    {
        return tTerminalGpsLogMapper.updateTTerminalGpsLog(tTerminalGpsLog);
    }

    /**
     * 删除定位卡定位记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalGpsLogByIds(String ids)
    {
        return tTerminalGpsLogMapper.deleteTTerminalGpsLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除定位卡定位记录信息
     * 
     * @param serialId 定位卡定位记录ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalGpsLogById(String serialId)
    {
        return tTerminalGpsLogMapper.deleteTTerminalGpsLogById(serialId);
    }
}
