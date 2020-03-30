package com.ruoyi.terminal.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.terminal.mapper.TTerminalDictMapper;
import com.ruoyi.terminal.domain.TTerminalDict;
import com.ruoyi.terminal.service.ITTerminalDictService;
import com.ruoyi.common.core.text.Convert;

/**
 * 定位卡字典Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Service
public class TTerminalDictServiceImpl implements ITTerminalDictService 
{
    @Autowired
    private TTerminalDictMapper tTerminalDictMapper;

    /**
     * 查询定位卡字典
     * 
     * @param terminalDictCode 定位卡字典ID
     * @return 定位卡字典
     */
    @Override
    public TTerminalDict selectTTerminalDictById(String terminalDictCode)
    {
        return tTerminalDictMapper.selectTTerminalDictById(terminalDictCode);
    }

    /**
     * 查询定位卡字典列表
     * 
     * @param tTerminalDict 定位卡字典
     * @return 定位卡字典
     */
    @Override
    public List<TTerminalDict> selectTTerminalDictList(TTerminalDict tTerminalDict)
    {
        return tTerminalDictMapper.selectTTerminalDictList(tTerminalDict);
    }

    /**
     * 新增定位卡字典
     * 
     * @param tTerminalDict 定位卡字典
     * @return 结果
     */
    @Override
    public int insertTTerminalDict(TTerminalDict tTerminalDict)
    {
        tTerminalDict.setCreateTime(DateUtils.getNowDate());
        return tTerminalDictMapper.insertTTerminalDict(tTerminalDict);
    }

    /**
     * 修改定位卡字典
     * 
     * @param tTerminalDict 定位卡字典
     * @return 结果
     */
    @Override
    public int updateTTerminalDict(TTerminalDict tTerminalDict)
    {
        tTerminalDict.setUpdateTime(DateUtils.getNowDate());
        return tTerminalDictMapper.updateTTerminalDict(tTerminalDict);
    }

    /**
     * 删除定位卡字典对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalDictByIds(String ids)
    {
        return tTerminalDictMapper.deleteTTerminalDictByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除定位卡字典信息
     * 
     * @param terminalDictCode 定位卡字典ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalDictById(String terminalDictCode)
    {
        return tTerminalDictMapper.deleteTTerminalDictById(terminalDictCode);
    }
}
