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
import com.ruoyi.terminal.domain.TTerminalGroup;
import com.ruoyi.terminal.service.ITTerminalGroupService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位卡分组信息Controller
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/terminal/group")
public class TTerminalGroupController extends BaseController
{
    private String prefix = "terminal/group";

    @Autowired
    private ITTerminalGroupService tTerminalGroupService;

    @RequiresPermissions("terminal:group:view")
    @GetMapping()
    public String group()
    {
        return prefix + "/group";
    }

    /**
     * 查询定位卡分组信息列表
     */
    @RequiresPermissions("terminal:group:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTerminalGroup tTerminalGroup)
    {
        startPage();
        List<TTerminalGroup> list = tTerminalGroupService.selectTTerminalGroupList(tTerminalGroup);
        return getDataTable(list);
    }

    /**
     * 导出定位卡分组信息列表
     */
    @RequiresPermissions("terminal:group:export")
    @Log(title = "定位卡分组信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TTerminalGroup tTerminalGroup)
    {
        List<TTerminalGroup> list = tTerminalGroupService.selectTTerminalGroupList(tTerminalGroup);
        ExcelUtil<TTerminalGroup> util = new ExcelUtil<TTerminalGroup>(TTerminalGroup.class);
        return util.exportExcel(list, "group");
    }

    /**
     * 新增定位卡分组信息
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
     * 新增保存定位卡分组信息
     */
    @RequiresPermissions("terminal:group:add")
    @Log(title = "定位卡分组信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTerminalGroup tTerminalGroup)
    {
        tTerminalGroup.setTerminalGroupId(UUID.randomUUID().toString());
        return toAjax(tTerminalGroupService.insertTTerminalGroup(tTerminalGroup));
    }

    /**
     * 修改定位卡分组信息
     */
    @GetMapping("/edit/{terminalGroupId}")
    public String edit(@PathVariable("terminalGroupId") String terminalGroupId, ModelMap mmap)
    {
        TTerminalGroup tTerminalGroup = tTerminalGroupService.selectTTerminalGroupById(terminalGroupId);
        mmap.put("tTerminalGroup", tTerminalGroup);
        TTerminalGroup tTerminalGroup2 = new TTerminalGroup();
        tTerminalGroup2.setEnableFlag(1);
        List<TTerminalGroup> list = tTerminalGroupService.selectTTerminalGroupList(tTerminalGroup2);
        mmap.put("list", list);
        return prefix + "/edit";
    }

    /**
     * 修改保存定位卡分组信息
     */
    @RequiresPermissions("terminal:group:edit")
    @Log(title = "定位卡分组信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTerminalGroup tTerminalGroup)
    {
        return toAjax(tTerminalGroupService.updateTTerminalGroup(tTerminalGroup));
    }

    /**
     * 删除定位卡分组信息
     */
    @RequiresPermissions("terminal:group:remove")
    @Log(title = "定位卡分组信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tTerminalGroupService.deleteTTerminalGroupByIds(ids));
    }
}
