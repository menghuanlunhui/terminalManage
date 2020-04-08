package com.ruoyi.web.controller.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.json.JSONObject;
import com.ruoyi.terminal.domain.TTerminalGpsLog;
import com.ruoyi.terminal.domain.TTerminalGroup;
import com.ruoyi.terminal.service.ITTerminalGpsLogService;
import com.ruoyi.terminal.service.ITTerminalGroupService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.terminal.domain.TTerminalInfo;
import com.ruoyi.terminal.service.ITTerminalInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位卡基础信息Controller
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/terminal/info")
public class TTerminalInfoController extends BaseController
{
    private String prefix = "terminal/info";

    @Autowired
    private ITTerminalInfoService tTerminalInfoService;

    @Autowired
    private ITTerminalGroupService tTerminalGroupService;

    @Autowired
    private ITTerminalGpsLogService tTerminalGpsLogService;

    @RequiresPermissions("terminal:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询定位卡基础信息列表
     */
    @RequiresPermissions("terminal:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTerminalInfo tTerminalInfo)
    {
        startPage();
        List<TTerminalInfo> list = tTerminalInfoService.selectTTerminalInfoList(tTerminalInfo);
        return getDataTable(list);
    }

    /**
     * 导出定位卡基础信息列表
     */
    @RequiresPermissions("terminal:info:export")
    @Log(title = "定位卡基础信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TTerminalInfo tTerminalInfo)
    {
        List<TTerminalInfo> list = tTerminalInfoService.selectTTerminalInfoList(tTerminalInfo);
        ExcelUtil<TTerminalInfo> util = new ExcelUtil<TTerminalInfo>(TTerminalInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增定位卡基础信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        TTerminalGroup tTerminalGroup = new TTerminalGroup();
        tTerminalGroup.setEnableFlag(1);
        List<TTerminalGroup> list = tTerminalGroupService.selectTTerminalGroupList(tTerminalGroup);
        mmap.put("list", list);
        return prefix + "/add";
    }

    /**
     * 新增保存定位卡基础信息
     */
    @RequiresPermissions("terminal:info:add")
    @Log(title = "定位卡基础信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTerminalInfo tTerminalInfo)
    {
        tTerminalInfo.setTerminalId(UUID.randomUUID().toString());
        return toAjax(tTerminalInfoService.insertTTerminalInfo(tTerminalInfo));
    }

    /**
     * 修改定位卡基础信息
     */
    @GetMapping("/edit/{terminalId}")
    public String edit(@PathVariable("terminalId") String terminalId, ModelMap mmap)
    {
        TTerminalInfo tTerminalInfo = tTerminalInfoService.selectTTerminalInfoById(terminalId);
        mmap.put("tTerminalInfo", tTerminalInfo);

        TTerminalGroup tTerminalGroup = new TTerminalGroup();
        tTerminalGroup.setEnableFlag(1);
        List<TTerminalGroup> list = tTerminalGroupService.selectTTerminalGroupList(tTerminalGroup);
        mmap.put("list", list);
        return prefix + "/edit";
    }

    /**
     * 修改保存定位卡基础信息
     */
    @RequiresPermissions("terminal:info:edit")
    @Log(title = "定位卡基础信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTerminalInfo tTerminalInfo)
    {
        return toAjax(tTerminalInfoService.updateTTerminalInfo(tTerminalInfo));
    }

    /**
     * 删除定位卡基础信息
     */
    @RequiresPermissions("terminal:info:remove")
    @Log(title = "定位卡基础信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tTerminalInfoService.deleteTTerminalInfoByIds(ids));
    }



    /**
     * 导航信息
     */
    @GetMapping("/gpsLog/{terminalId}")
    public String gpsLog(@PathVariable("terminalId") String terminalId, ModelMap mmap)
    {
        mmap.put("terminalId", terminalId);
        return prefix + "/gpsLog";
    }

    @RequiresPermissions("terminal:info:edit")
    @Log(title = "地图导航信息")
    @PostMapping( "/gpsLogList")
    @ResponseBody
    public Object gpsLogList( String terminalId)
    {
        JSONObject jsonObject = new JSONObject();
        TTerminalGpsLog tTerminalGpsLog = new TTerminalGpsLog();
        tTerminalGpsLog.setTerminalId(terminalId);
        List<TTerminalGpsLog> list = tTerminalGpsLogService.selectTTerminalGpsLogList(tTerminalGpsLog);
        jsonObject.put("data",list);
        jsonObject.put("status",1);
        return jsonObject;

    }

}
