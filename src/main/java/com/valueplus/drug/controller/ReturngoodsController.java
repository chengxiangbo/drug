package com.valueplus.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.valueplus.drug.common.ResultMapUtil;
import com.valueplus.drug.entity.Returngoods;
import com.valueplus.drug.service.IReturngoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 药品退货相关controller
 */
@Controller
@RequestMapping(value = "/returngoods")
public class ReturngoodsController {
    @Autowired
    private IReturngoodsService returngoodsService;
    /**
     * 转向药品退货界面
     */
    @RequestMapping
    public String returngoods(){
        return "/returngoods";
    }

    /**
     * 分页查询药品退货列表
     */
    @RequestMapping(value = "/returngoodsQueryPage")
    @ResponseBody
    public Object returngoodsQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Returngoods> ipage = returngoodsService.selectReturngoodsPage(pageNum, pageSize, param);
            System.out.println(ipage.getRecords());
            return ResultMapUtil.getHashMapMysqlPage(ipage);
        }catch (Exception e){
            return  ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品退货新增界面
     */
    @RequestMapping(value = "/returngoodsPage")
    public String returngoodsPage(){
        return "/returngoodsPage";
    }

    /**
     * 新增药品退货方法
     */
    @RequestMapping(value = "/returngoodsAdd")
    @ResponseBody
    public Object returngoodsAdd(Returngoods returngoods){
        try {
//            returngoods.setCreatetime(new Date());
            int i = returngoodsService.addReturngoods(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向药品退货编辑界面
     */
    @RequestMapping(value = "/returngoodsQueryById")
    public String returngoodsQueryById(@RequestParam(name="id",required = true)Integer id, Model model){
        Returngoods returngoods = returngoodsService.queryReturngoodsById(id);
        model.addAttribute("obj",returngoods);
        return "/returngoodsPage";
    }
    /**
     * 修改药品退货方法
     */
    @RequestMapping(value = "/returngoodsEdit")
    @ResponseBody
    public Object returngoodsEdit(Returngoods returngoods){
        try {
            int i = returngoodsService.editReturngoods(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除药品退货方法
     */
    @RequestMapping(value = "/returngoodsDelById")
    @ResponseBody
    public Object returngoodsDelById(Integer id){
        try {
            int i = returngoodsService.delReturngoodsByid(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有药品退货方法
     */
    @RequestMapping(value = "/returngoodsList")
    @ResponseBody
    public Object supplierList(){
        List<Returngoods> returngoodss = returngoodsService.queryReturngoodsList();
        return ResultMapUtil.getHashMapList(returngoodss);
    }

    /**
     * 转向药品保质期检查画面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }

}
