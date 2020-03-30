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
import com.ruoyi.terminal.domain.TTerminalAlarm;
import com.ruoyi.terminal.service.ITTerminalAlarmService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位卡关联闹钟信息Controller
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/terminal/alarm")
public class TTerminalAlarmController extends BaseController
{
    private String prefix = "terminal/alarm";

    @Autowired
    private ITTerminalAlarmService tTerminalAlarmService;

    @RequiresPermissions("terminal:alarm:view")
    @GetMapping()
    public String alarm()
    {
        return prefix + "/alarm";
    }

    /**
     * 查询定位卡关联闹钟信息列表
     */
    @RequiresPermissions("terminal:alarm:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTerminalAlarm tTerminalAlarm)
    {
        startPage();
        List<TTerminalAlarm> list = tTerminalAlarmService.selectTTerminalAlarmList(tTerminalAlarm);
        return getDataTable(list);
    }

    /**
     * 导出定位卡关联闹钟信息列表
     */
    @RequiresPermissions("terminal:alarm:export")
    @Log(title = "定位卡关联闹钟信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TTerminalAlarm tTerminalAlarm)
    {
        List<TTerminalAlarm> list = tTerminalAlarmService.selectTTerminalAlarmList(tTerminalAlarm);
        ExcelUtil<TTerminalAlarm> util = new ExcelUtil<TTerminalAlarm>(TTerminalAlarm.class);
        return util.exportExcel(list, "alarm");
    }

    /**
     * 新增定位卡关联闹钟信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存定位卡关联闹钟信息
     */
    @RequiresPermissions("terminal:alarm:add")
    @Log(title = "定位卡关联闹钟信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTerminalAlarm tTerminalAlarm)
    {
        tTerminalAlarm.setTerminalAlarmId(UUID.randomUUID().toString());
        return toAjax(tTerminalAlarmService.insertTTerminalAlarm(tTerminalAlarm));
    }

    /**
     * 修改定位卡关联闹钟信息
     */
    @GetMapping("/edit/{terminalAlarmId}")
    public String edit(@PathVariable("terminalAlarmId") String terminalAlarmId, ModelMap mmap)
    {
        TTerminalAlarm tTerminalAlarm = tTerminalAlarmService.selectTTerminalAlarmById(terminalAlarmId);
        mmap.put("tTerminalAlarm", tTerminalAlarm);
        return prefix + "/edit";
    }

    /**
     * 修改保存定位卡关联闹钟信息
     */
    @RequiresPermissions("terminal:alarm:edit")
    @Log(title = "定位卡关联闹钟信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTerminalAlarm tTerminalAlarm)
    {
        return toAjax(tTerminalAlarmService.updateTTerminalAlarm(tTerminalAlarm));
    }

    /**
     * 删除定位卡关联闹钟信息
     */
    @RequiresPermissions("terminal:alarm:remove")
    @Log(title = "定位卡关联闹钟信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tTerminalAlarmService.deleteTTerminalAlarmByIds(ids));
    }
}
