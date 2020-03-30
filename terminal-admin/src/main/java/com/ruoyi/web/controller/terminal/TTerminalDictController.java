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
import com.ruoyi.terminal.domain.TTerminalDict;
import com.ruoyi.terminal.service.ITTerminalDictService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位卡字典Controller
 * 
 * @author ruoyi
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/terminal/dict")
public class TTerminalDictController extends BaseController
{
    private String prefix = "terminal/dict";

    @Autowired
    private ITTerminalDictService tTerminalDictService;

    @RequiresPermissions("terminal:dict:view")
    @GetMapping()
    public String dict()
    {
        return prefix + "/dict";
    }

    /**
     * 查询定位卡字典列表
     */
    @RequiresPermissions("terminal:dict:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTerminalDict tTerminalDict)
    {
        startPage();
        List<TTerminalDict> list = tTerminalDictService.selectTTerminalDictList(tTerminalDict);
        return getDataTable(list);
    }

    /**
     * 导出定位卡字典列表
     */
    @RequiresPermissions("terminal:dict:export")
    @Log(title = "定位卡字典", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TTerminalDict tTerminalDict)
    {
        List<TTerminalDict> list = tTerminalDictService.selectTTerminalDictList(tTerminalDict);
        ExcelUtil<TTerminalDict> util = new ExcelUtil<TTerminalDict>(TTerminalDict.class);
        return util.exportExcel(list, "dict");
    }

    /**
     * 新增定位卡字典
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存定位卡字典
     */
    @RequiresPermissions("terminal:dict:add")
    @Log(title = "定位卡字典", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTerminalDict tTerminalDict)
    {
        tTerminalDict.setTerminalDictCode(UUID.randomUUID().toString());
        return toAjax(tTerminalDictService.insertTTerminalDict(tTerminalDict));
    }

    /**
     * 修改定位卡字典
     */
    @GetMapping("/edit/{terminalDictCode}")
    public String edit(@PathVariable("terminalDictCode") String terminalDictCode, ModelMap mmap)
    {
        TTerminalDict tTerminalDict = tTerminalDictService.selectTTerminalDictById(terminalDictCode);
        mmap.put("tTerminalDict", tTerminalDict);
        return prefix + "/edit";
    }

    /**
     * 修改保存定位卡字典
     */
    @RequiresPermissions("terminal:dict:edit")
    @Log(title = "定位卡字典", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTerminalDict tTerminalDict)
    {
        return toAjax(tTerminalDictService.updateTTerminalDict(tTerminalDict));
    }

    /**
     * 删除定位卡字典
     */
    @RequiresPermissions("terminal:dict:remove")
    @Log(title = "定位卡字典", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tTerminalDictService.deleteTTerminalDictByIds(ids));
    }
}
