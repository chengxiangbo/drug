package com.valueplus.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.valueplus.drug.common.ResultMapUtil;
import com.valueplus.drug.entity.Returnsupplier;
import com.valueplus.drug.service.IReturnsupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 退货给供应商相关controller
 */
@Controller
@RequestMapping(value = "/returnsupplier")
public class ReturnsupplierController {
    @Autowired
    private IReturnsupplierService returnsupplierService;
    /**
     * 转向退货给供应商退货界面
     */
    @RequestMapping
    public String returnsupplier(){
        return "/returnsupplier";
    }

    /**
     * 分页查询退货给供应商列表
     */
    @RequestMapping(value = "/returnsupplierQueryPage")
    @ResponseBody
    public Object returnsupplierQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Returnsupplier> ipage = returnsupplierService.selectReturnsupplierPage(pageNum, pageSize, param);
            System.out.println(ipage.getRecords());
            return ResultMapUtil.getHashMapMysqlPage(ipage);
        }catch (Exception e){
            return  ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向退货给供应商新增界面
     */
    @RequestMapping(value = "/returnsupplierPage")
    public String returnsupplierPage(){
        return "/returnsupplierPage";
    }

    /**
     * 新增退货给供应商方法
     */
    @RequestMapping(value = "/returnsupplierAdd")
    @ResponseBody
    public Object returnsupplierAdd(Returnsupplier returnsupplier){
        try {
//            returnsupplier.setCreatetime(new Date());
            int i = returnsupplierService.addReturnsupplier(returnsupplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向退货给供应商编辑界面
     */
    @RequestMapping(value = "/returnsupplierQueryById")
    public String returnsupplierQueryById(@RequestParam(name="id",required = true)Integer id, Model model){
        Returnsupplier returnsupplier = returnsupplierService.queryReturnsupplierById(id);
        model.addAttribute("obj",returnsupplier);
        return "/returnsupplierPage";
    }
    /**
     * 修改退货给供应商方法
     */
    @RequestMapping(value = "/returnsupplierEdit")
    @ResponseBody
    public Object returnsupplierEdit(Returnsupplier returnsupplier){
        try {
            int i = returnsupplierService.editReturnsupplier(returnsupplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除退货给供应商方法
     */
    @RequestMapping(value = "/returnsupplierDelById")
    @ResponseBody
    public Object returnsupplierDelById(Integer id){
        try {
            int i = returnsupplierService.delReturnsupplierByid(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有退货给供应商方法
     */
    @RequestMapping(value = "/returnsupplierList")
    @ResponseBody
    public Object supplierList(){
        List<Returnsupplier> returnsuppliers = returnsupplierService.queryReturnsupplierList();
        return ResultMapUtil.getHashMapList(returnsuppliers);
    }

    /**
     * 转向药品保质期检查画面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }

}
