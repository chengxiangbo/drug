package com.valueplus.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.valueplus.drug.common.ResultMapUtil;
import com.valueplus.drug.entity.Druginfo;
import com.valueplus.drug.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 药品相关controller
 */
@Controller
@RequestMapping(value = "/druginfo")
public class DruginfoController {
    @Autowired
    private IDruginfoService druginfoService;
    /**
     * 转向药品界面
     */
    @RequestMapping
    public String druginfo(){
        return "/druginfo";
    }

    /**
     * 分页查询药品列表
     */
    @RequestMapping(value = "/druginfoQueryPage")
    @ResponseBody
    public Object druginfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Druginfo> ipage = druginfoService.selectDruginfoPage(pageNum, pageSize, param);
            System.out.println(ipage.getRecords());
            return ResultMapUtil.getHashMapMysqlPage(ipage);
        }catch (Exception e){
            return  ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品新增界面
     */
    @RequestMapping(value = "/druginfoPage")
    public String druginfoPage(){
        return "/druginfoPage";
    }

    /**
     * 新增药品方法
     */
    @RequestMapping(value = "/druginfoAdd")
    @ResponseBody
    public Object druginfoAdd(Druginfo druginfo){
        try {
//            druginfo.setCreatetime(new Date());
            int i = druginfoService.addDruginfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向药品编辑界面
     */
    @RequestMapping(value = "/druginfoQueryById")
    public String druginfoQueryById(@RequestParam(name="id",required = true)Integer id, Model model){
        Druginfo druginfo = druginfoService.queryDruginfoById(id);
        model.addAttribute("obj",druginfo);
        return "/druginfoPage";
    }
    /**
     * 修改药品方法
     */
    @RequestMapping(value = "/druginfoEdit")
    @ResponseBody
    public Object druginfoEdit(Druginfo druginfo){
        try {
            int i = druginfoService.editDruginfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除药品方法
     */
    @RequestMapping(value = "/druginfoDelById")
    @ResponseBody
    public Object druginfoDelById(Integer id){
        try {
            int i = druginfoService.delDruginfoByid(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有供应商方法
     */
    @RequestMapping(value = "/druginfoList")
    @ResponseBody
    public Object supplierList(){
        List<Druginfo> druginfos = druginfoService.queryDruginfoList();
        return ResultMapUtil.getHashMapList(druginfos);
    }

    /**
     * 转向药品保质期检查画面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }

}
