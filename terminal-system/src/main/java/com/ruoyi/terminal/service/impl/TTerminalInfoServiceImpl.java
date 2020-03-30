package com.ruoyi.terminal.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.terminal.mapper.TTerminalInfoMapper;
import com.ruoyi.terminal.domain.TTerminalInfo;
import com.ruoyi.terminal.service.ITTerminalInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 定位卡基础信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Service
public class TTerminalInfoServiceImpl implements ITTerminalInfoService 
{
    @Autowired
    private TTerminalInfoMapper tTerminalInfoMapper;

    /**
     * 查询定位卡基础信息
     * 
     * @param terminalId 定位卡基础信息ID
     * @return 定位卡基础信息
     */
    @Override
    public TTerminalInfo selectTTerminalInfoById(String terminalId)
    {
        return tTerminalInfoMapper.selectTTerminalInfoById(terminalId);
    }

    /**
     * 查询定位卡基础信息列表
     * 
     * @param tTerminalInfo 定位卡基础信息
     * @return 定位卡基础信息
     */
    @Override
    public List<TTerminalInfo> selectTTerminalInfoList(TTerminalInfo tTerminalInfo)
    {
        return tTerminalInfoMapper.selectTTerminalInfoList(tTerminalInfo);
    }

    /**
     * 新增定位卡基础信息
     * 
     * @param tTerminalInfo 定位卡基础信息
     * @return 结果
     */
    @Override
    public int insertTTerminalInfo(TTerminalInfo tTerminalInfo)
    {
        tTerminalInfo.setCreateTime(DateUtils.getNowDate());
        return tTerminalInfoMapper.insertTTerminalInfo(tTerminalInfo);
    }

    /**
     * 修改定位卡基础信息
     * 
     * @param tTerminalInfo 定位卡基础信息
     * @return 结果
     */
    @Override
    public int updateTTerminalInfo(TTerminalInfo tTerminalInfo)
    {
        tTerminalInfo.setUpdateTime(DateUtils.getNowDate());
        return tTerminalInfoMapper.updateTTerminalInfo(tTerminalInfo);
    }

    /**
     * 删除定位卡基础信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalInfoByIds(String ids)
    {
        return tTerminalInfoMapper.deleteTTerminalInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除定位卡基础信息信息
     * 
     * @param terminalId 定位卡基础信息ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalInfoById(String terminalId)
    {
        return tTerminalInfoMapper.deleteTTerminalInfoById(terminalId);
    }
}
