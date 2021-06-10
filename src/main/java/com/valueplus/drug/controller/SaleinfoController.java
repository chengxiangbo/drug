package com.valueplus.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.valueplus.drug.common.ResultMapUtil;
import com.valueplus.drug.entity.Saleinfo;
import com.valueplus.drug.service.ISaleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 药品销售记录相关controller
 */
@Controller
@RequestMapping(value = "/saleinfo")
public class SaleinfoController {
    @Autowired
    private ISaleinfoService saleinfoService;
    /**
     * 转向销售记录界面
     */
    @RequestMapping
    public String saleinfo(){
        return "/saleinfo";
    }

    /**
     * 分页查询销售记录列表
     */
    @RequestMapping(value = "/saleinfoQueryPage")
    @ResponseBody
    public Object saleinfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Saleinfo> ipage = saleinfoService.selectSaleinfoPage(pageNum, pageSize, param);
            System.out.println(ipage.getRecords());
            return ResultMapUtil.getHashMapMysqlPage(ipage);
        }catch (Exception e){
            return  ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向销售记录新增界面
     */
    @RequestMapping(value = "/saleinfoPage")
    public String saleinfoPage(){
        return "/saleinfoPage";
    }

    /**
     * 新增销售记录方法
     */
    @RequestMapping(value = "/saleinfoAdd")
    @ResponseBody
    public Object saleinfoAdd(Saleinfo saleinfo){
        try {
//            saleinfo.setOperatetime(new Date());
            int i = saleinfoService.addSaleinfo(saleinfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向销售记录编辑界面
     */
    @RequestMapping(value = "/saleinfoQueryById")
    public String saleinfoQueryById(@RequestParam(name="id",required = true)Integer id, Model model){
        Saleinfo saleinfo = saleinfoService.querySaleinfoById(id);
        model.addAttribute("obj",saleinfo);
        return "/saleinfoPage";
    }
    /**
     * 修改销售记录方法
     */
    @RequestMapping(value = "/saleinfoEdit")
    @ResponseBody
    public Object saleinfoEdit(Saleinfo saleinfo){
        try {
            int i = saleinfoService.editSaleinfo(saleinfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除药品方法
     */
    @RequestMapping(value = "/saleinfoDelById")
    @ResponseBody
    public Object saleinfoDelById(Integer id){
        try {
            int i = saleinfoService.delSaleinfoByid(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有供应商方法
     */
    @RequestMapping(value = "/saleinfoList")
    @ResponseBody
    public Object supplierList(){
        List<Saleinfo> saleinfos = saleinfoService.querySaleinfoList();
        return ResultMapUtil.getHashMapList(saleinfos);
    }

    /**
     * 转向药品保质期检查画面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }

}
