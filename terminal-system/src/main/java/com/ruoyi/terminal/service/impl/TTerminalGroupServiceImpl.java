package com.ruoyi.terminal.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.terminal.mapper.TTerminalGroupMapper;
import com.ruoyi.terminal.domain.TTerminalGroup;
import com.ruoyi.terminal.service.ITTerminalGroupService;
import com.ruoyi.common.core.text.Convert;

/**
 * 定位卡分组信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Service
public class TTerminalGroupServiceImpl implements ITTerminalGroupService 
{
    @Autowired
    private TTerminalGroupMapper tTerminalGroupMapper;

    /**
     * 查询定位卡分组信息
     * 
     * @param terminalGroupId 定位卡分组信息ID
     * @return 定位卡分组信息
     */
    @Override
    public TTerminalGroup selectTTerminalGroupById(String terminalGroupId)
    {
        return tTerminalGroupMapper.selectTTerminalGroupById(terminalGroupId);
    }

    /**
     * 查询定位卡分组信息列表
     * 
     * @param tTerminalGroup 定位卡分组信息
     * @return 定位卡分组信息
     */
    @Override
    public List<TTerminalGroup> selectTTerminalGroupList(TTerminalGroup tTerminalGroup)
    {
        return tTerminalGroupMapper.selectTTerminalGroupList(tTerminalGroup);
    }

    /**
     * 新增定位卡分组信息
     * 
     * @param tTerminalGroup 定位卡分组信息
     * @return 结果
     */
    @Override
    public int insertTTerminalGroup(TTerminalGroup tTerminalGroup)
    {
        tTerminalGroup.setCreateTime(DateUtils.getNowDate());
        return tTerminalGroupMapper.insertTTerminalGroup(tTerminalGroup);
    }

    /**
     * 修改定位卡分组信息
     * 
     * @param tTerminalGroup 定位卡分组信息
     * @return 结果
     */
    @Override
    public int updateTTerminalGroup(TTerminalGroup tTerminalGroup)
    {
        tTerminalGroup.setUpdateTime(DateUtils.getNowDate());
        return tTerminalGroupMapper.updateTTerminalGroup(tTerminalGroup);
    }

    /**
     * 删除定位卡分组信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalGroupByIds(String ids)
    {
        return tTerminalGroupMapper.deleteTTerminalGroupByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除定位卡分组信息信息
     * 
     * @param terminalGroupId 定位卡分组信息ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalGroupById(String terminalGroupId)
    {
        return tTerminalGroupMapper.deleteTTerminalGroupById(terminalGroupId);
    }
}
