package com.ruoyi.terminal.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.terminal.mapper.TTerminalFenceMapper;
import com.ruoyi.terminal.domain.TTerminalFence;
import com.ruoyi.terminal.service.ITTerminalFenceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 定位卡电子围栏配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Service
public class TTerminalFenceServiceImpl implements ITTerminalFenceService 
{
    @Autowired
    private TTerminalFenceMapper tTerminalFenceMapper;

    /**
     * 查询定位卡电子围栏配置
     * 
     * @param terminalFenceId 定位卡电子围栏配置ID
     * @return 定位卡电子围栏配置
     */
    @Override
    public TTerminalFence selectTTerminalFenceById(String terminalFenceId)
    {
        return tTerminalFenceMapper.selectTTerminalFenceById(terminalFenceId);
    }

    /**
     * 查询定位卡电子围栏配置列表
     * 
     * @param tTerminalFence 定位卡电子围栏配置
     * @return 定位卡电子围栏配置
     */
    @Override
    public List<TTerminalFence> selectTTerminalFenceList(TTerminalFence tTerminalFence)
    {
        return tTerminalFenceMapper.selectTTerminalFenceList(tTerminalFence);
    }

    /**
     * 新增定位卡电子围栏配置
     * 
     * @param tTerminalFence 定位卡电子围栏配置
     * @return 结果
     */
    @Override
    public int insertTTerminalFence(TTerminalFence tTerminalFence)
    {
        tTerminalFence.setCreateTime(DateUtils.getNowDate());
        return tTerminalFenceMapper.insertTTerminalFence(tTerminalFence);
    }

    /**
     * 修改定位卡电子围栏配置
     * 
     * @param tTerminalFence 定位卡电子围栏配置
     * @return 结果
     */
    @Override
    public int updateTTerminalFence(TTerminalFence tTerminalFence)
    {
        tTerminalFence.setUpdateTime(DateUtils.getNowDate());
        return tTerminalFenceMapper.updateTTerminalFence(tTerminalFence);
    }

    /**
     * 删除定位卡电子围栏配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalFenceByIds(String ids)
    {
        return tTerminalFenceMapper.deleteTTerminalFenceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除定位卡电子围栏配置信息
     * 
     * @param terminalFenceId 定位卡电子围栏配置ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalFenceById(String terminalFenceId)
    {
        return tTerminalFenceMapper.deleteTTerminalFenceById(terminalFenceId);
    }
}
