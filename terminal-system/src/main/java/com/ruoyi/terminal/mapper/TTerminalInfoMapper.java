package com.ruoyi.terminal.mapper;

import java.util.List;
import com.ruoyi.terminal.domain.TTerminalInfo;

/**
 * 定位卡基础信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
public interface TTerminalInfoMapper 
{
    /**
     * 查询定位卡基础信息
     * 
     * @param terminalId 定位卡基础信息ID
     * @return 定位卡基础信息
     */
    public TTerminalInfo selectTTerminalInfoById(String terminalId);

    /**
     * 查询定位卡基础信息列表
     * 
     * @param tTerminalInfo 定位卡基础信息
     * @return 定位卡基础信息集合
     */
    public List<TTerminalInfo> selectTTerminalInfoList(TTerminalInfo tTerminalInfo);

    /**
     * 新增定位卡基础信息
     * 
     * @param tTerminalInfo 定位卡基础信息
     * @return 结果
     */
    public int insertTTerminalInfo(TTerminalInfo tTerminalInfo);

    /**
     * 修改定位卡基础信息
     * 
     * @param tTerminalInfo 定位卡基础信息
     * @return 结果
     */
    public int updateTTerminalInfo(TTerminalInfo tTerminalInfo);

    /**
     * 删除定位卡基础信息
     * 
     * @param terminalId 定位卡基础信息ID
     * @return 结果
     */
    public int deleteTTerminalInfoById(String terminalId);

    /**
     * 批量删除定位卡基础信息
     * 
     * @param terminalIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTerminalInfoByIds(String[] terminalIds);
}
