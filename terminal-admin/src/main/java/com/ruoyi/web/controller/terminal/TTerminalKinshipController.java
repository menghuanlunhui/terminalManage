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
import com.ruoyi.terminal.domain.TTerminalKinship;
import com.ruoyi.terminal.service.ITTerminalKinshipService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位卡关联亲情号码Controller
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/terminal/kinship")
public class TTerminalKinshipController extends BaseController
{
    private String prefix = "terminal/kinship";

    @Autowired
    private ITTerminalKinshipService tTerminalKinshipService;

    @RequiresPermissions("terminal:kinship:view")
    @GetMapping()
    public String kinship()
    {
        return prefix + "/kinship";
    }

    /**
     * 查询定位卡关联亲情号码列表
     */
    @RequiresPermissions("terminal:kinship:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTerminalKinship tTerminalKinship)
    {
        startPage();
        List<TTerminalKinship> list = tTerminalKinshipService.selectTTerminalKinshipList(tTerminalKinship);
        return getDataTable(list);
    }

    /**
     * 导出定位卡关联亲情号码列表
     */
    @RequiresPermissions("terminal:kinship:export")
    @Log(title = "定位卡关联亲情号码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TTerminalKinship tTerminalKinship)
    {
        List<TTerminalKinship> list = tTerminalKinshipService.selectTTerminalKinshipList(tTerminalKinship);
        ExcelUtil<TTerminalKinship> util = new ExcelUtil<TTerminalKinship>(TTerminalKinship.class);
        return util.exportExcel(list, "kinship");
    }

    /**
     * 新增定位卡关联亲情号码
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存定位卡关联亲情号码
     */
    @RequiresPermissions("terminal:kinship:add")
    @Log(title = "定位卡关联亲情号码", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTerminalKinship tTerminalKinship)
    {
        tTerminalKinship.setTerminalKinshipId(UUID.randomUUID().toString());
        return toAjax(tTerminalKinshipService.insertTTerminalKinship(tTerminalKinship));
    }

    /**
     * 修改定位卡关联亲情号码
     */
    @GetMapping("/edit/{terminalKinshipId}")
    public String edit(@PathVariable("terminalKinshipId") String terminalKinshipId, ModelMap mmap)
    {
        TTerminalKinship tTerminalKinship = tTerminalKinshipService.selectTTerminalKinshipById(terminalKinshipId);
        mmap.put("tTerminalKinship", tTerminalKinship);
        return prefix + "/edit";
    }

    /**
     * 修改保存定位卡关联亲情号码
     */
    @RequiresPermissions("terminal:kinship:edit")
    @Log(title = "定位卡关联亲情号码", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTerminalKinship tTerminalKinship)
    {
        return toAjax(tTerminalKinshipService.updateTTerminalKinship(tTerminalKinship));
    }

    /**
     * 删除定位卡关联亲情号码
     */
    @RequiresPermissions("terminal:kinship:remove")
    @Log(title = "定位卡关联亲情号码", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tTerminalKinshipService.deleteTTerminalKinshipByIds(ids));
    }
}
