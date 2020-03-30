package com.ruoyi.web.controller.terminal;

import java.util.List;
import java.util.UUID;

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
import com.ruoyi.terminal.domain.TTerminalGpsLog;
import com.ruoyi.terminal.service.ITTerminalGpsLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位卡定位记录Controller
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/terminal/log")
public class TTerminalGpsLogController extends BaseController
{
    private String prefix = "terminal/log";

    @Autowired
    private ITTerminalGpsLogService tTerminalGpsLogService;

    @RequiresPermissions("terminal:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询定位卡定位记录列表
     */
    @RequiresPermissions("terminal:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTerminalGpsLog tTerminalGpsLog)
    {
        startPage();
        List<TTerminalGpsLog> list = tTerminalGpsLogService.selectTTerminalGpsLogList(tTerminalGpsLog);
        return getDataTable(list);
    }

    /**
     * 导出定位卡定位记录列表
     */
    @RequiresPermissions("terminal:log:export")
    @Log(title = "定位卡定位记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TTerminalGpsLog tTerminalGpsLog)
    {
        List<TTerminalGpsLog> list = tTerminalGpsLogService.selectTTerminalGpsLogList(tTerminalGpsLog);
        ExcelUtil<TTerminalGpsLog> util = new ExcelUtil<TTerminalGpsLog>(TTerminalGpsLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增定位卡定位记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存定位卡定位记录
     */
    @RequiresPermissions("terminal:log:add")
    @Log(title = "定位卡定位记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTerminalGpsLog tTerminalGpsLog)
    {
        tTerminalGpsLog.setSerialId(UUID.randomUUID().toString());
        return toAjax(tTerminalGpsLogService.insertTTerminalGpsLog(tTerminalGpsLog));
    }

    /**
     * 修改定位卡定位记录
     */
    @GetMapping("/edit/{serialId}")
    public String edit(@PathVariable("serialId") String serialId, ModelMap mmap)
    {
        TTerminalGpsLog tTerminalGpsLog = tTerminalGpsLogService.selectTTerminalGpsLogById(serialId);
        mmap.put("tTerminalGpsLog", tTerminalGpsLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存定位卡定位记录
     */
    @RequiresPermissions("terminal:log:edit")
    @Log(title = "定位卡定位记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTerminalGpsLog tTerminalGpsLog)
    {
        return toAjax(tTerminalGpsLogService.updateTTerminalGpsLog(tTerminalGpsLog));
    }

    /**
     * 删除定位卡定位记录
     */
    @RequiresPermissions("terminal:log:remove")
    @Log(title = "定位卡定位记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tTerminalGpsLogService.deleteTTerminalGpsLogByIds(ids));
    }
}
