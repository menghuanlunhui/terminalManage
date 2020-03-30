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
import com.ruoyi.terminal.domain.TTerminalFence;
import com.ruoyi.terminal.service.ITTerminalFenceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位卡电子围栏配置Controller
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/terminal/fence")
public class TTerminalFenceController extends BaseController
{
    private String prefix = "terminal/fence";

    @Autowired
    private ITTerminalFenceService tTerminalFenceService;

    @RequiresPermissions("terminal:fence:view")
    @GetMapping()
    public String fence()
    {
        return prefix + "/fence";
    }

    /**
     * 查询定位卡电子围栏配置列表
     */
    @RequiresPermissions("terminal:fence:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTerminalFence tTerminalFence)
    {
        startPage();
        List<TTerminalFence> list = tTerminalFenceService.selectTTerminalFenceList(tTerminalFence);
        return getDataTable(list);
    }

    /**
     * 导出定位卡电子围栏配置列表
     */
    @RequiresPermissions("terminal:fence:export")
    @Log(title = "定位卡电子围栏配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TTerminalFence tTerminalFence)
    {
        List<TTerminalFence> list = tTerminalFenceService.selectTTerminalFenceList(tTerminalFence);
        ExcelUtil<TTerminalFence> util = new ExcelUtil<TTerminalFence>(TTerminalFence.class);
        return util.exportExcel(list, "fence");
    }

    /**
     * 新增定位卡电子围栏配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存定位卡电子围栏配置
     */
    @RequiresPermissions("terminal:fence:add")
    @Log(title = "定位卡电子围栏配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTerminalFence tTerminalFence)
    {
        tTerminalFence.setTerminalFenceId(UUID.randomUUID().toString());
        return toAjax(tTerminalFenceService.insertTTerminalFence(tTerminalFence));
    }

    /**
     * 修改定位卡电子围栏配置
     */
    @GetMapping("/edit/{terminalFenceId}")
    public String edit(@PathVariable("terminalFenceId") String terminalFenceId, ModelMap mmap)
    {
        TTerminalFence tTerminalFence = tTerminalFenceService.selectTTerminalFenceById(terminalFenceId);
        mmap.put("tTerminalFence", tTerminalFence);
        return prefix + "/edit";
    }

    /**
     * 修改保存定位卡电子围栏配置
     */
    @RequiresPermissions("terminal:fence:edit")
    @Log(title = "定位卡电子围栏配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTerminalFence tTerminalFence)
    {
        return toAjax(tTerminalFenceService.updateTTerminalFence(tTerminalFence));
    }

    /**
     * 删除定位卡电子围栏配置
     */
    @RequiresPermissions("terminal:fence:remove")
    @Log(title = "定位卡电子围栏配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tTerminalFenceService.deleteTTerminalFenceByIds(ids));
    }
}
