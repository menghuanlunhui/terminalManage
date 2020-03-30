package com.ruoyi.terminal.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.terminal.mapper.TTerminalKinshipMapper;
import com.ruoyi.terminal.domain.TTerminalKinship;
import com.ruoyi.terminal.service.ITTerminalKinshipService;
import com.ruoyi.common.core.text.Convert;

/**
 * 定位卡关联亲情号码Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Service
public class TTerminalKinshipServiceImpl implements ITTerminalKinshipService 
{
    @Autowired
    private TTerminalKinshipMapper tTerminalKinshipMapper;

    /**
     * 查询定位卡关联亲情号码
     * 
     * @param terminalKinshipId 定位卡关联亲情号码ID
     * @return 定位卡关联亲情号码
     */
    @Override
    public TTerminalKinship selectTTerminalKinshipById(String terminalKinshipId)
    {
        return tTerminalKinshipMapper.selectTTerminalKinshipById(terminalKinshipId);
    }

    /**
     * 查询定位卡关联亲情号码列表
     * 
     * @param tTerminalKinship 定位卡关联亲情号码
     * @return 定位卡关联亲情号码
     */
    @Override
    public List<TTerminalKinship> selectTTerminalKinshipList(TTerminalKinship tTerminalKinship)
    {
        return tTerminalKinshipMapper.selectTTerminalKinshipList(tTerminalKinship);
    }

    /**
     * 新增定位卡关联亲情号码
     * 
     * @param tTerminalKinship 定位卡关联亲情号码
     * @return 结果
     */
    @Override
    public int insertTTerminalKinship(TTerminalKinship tTerminalKinship)
    {
        tTerminalKinship.setCreateTime(DateUtils.getNowDate());
        return tTerminalKinshipMapper.insertTTerminalKinship(tTerminalKinship);
    }

    /**
     * 修改定位卡关联亲情号码
     * 
     * @param tTerminalKinship 定位卡关联亲情号码
     * @return 结果
     */
    @Override
    public int updateTTerminalKinship(TTerminalKinship tTerminalKinship)
    {
        tTerminalKinship.setUpdateTime(DateUtils.getNowDate());
        return tTerminalKinshipMapper.updateTTerminalKinship(tTerminalKinship);
    }

    /**
     * 删除定位卡关联亲情号码对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalKinshipByIds(String ids)
    {
        return tTerminalKinshipMapper.deleteTTerminalKinshipByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除定位卡关联亲情号码信息
     * 
     * @param terminalKinshipId 定位卡关联亲情号码ID
     * @return 结果
     */
    @Override
    public int deleteTTerminalKinshipById(String terminalKinshipId)
    {
        return tTerminalKinshipMapper.deleteTTerminalKinshipById(terminalKinshipId);
    }
}
