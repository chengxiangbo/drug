package com.valueplus.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.valueplus.drug.common.ResultMapUtil;
import com.valueplus.drug.entity.Billinfo;
import com.valueplus.drug.service.IBillinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 账单信息相关controller
 */
@Controller
@RequestMapping(value = "/billinfo")
public class BillinfoController {
    @Autowired
    private IBillinfoService billinfoService;
    /**
     * 转向账单信息界面
     */
    @RequestMapping
    public String billinfo(){
        return "/billinfo";
    }

    /**
     * 分页查询账单信息列表
     */
    @RequestMapping(value = "/billinfoQueryPage")
    @ResponseBody
    public Object billinfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Billinfo> ipage = billinfoService.selectBillinfoPage(pageNum, pageSize, param);
            System.out.println(ipage.getRecords());
            return ResultMapUtil.getHashMapMysqlPage(ipage);
        }catch (Exception e){
            return  ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向账单信息新增界面
     */
    @RequestMapping(value = "/billinfoPage")
    public String billinfoPage(){
        return "/billinfoPage";
    }

    /**
     * 新增账单信息方法
     */
    @RequestMapping(value = "/billinfoAdd")
    @ResponseBody
    public Object billinfoAdd(Billinfo billinfo){
        try {
//            billinfo.setCreatetime(new Date());
            int i = billinfoService.addBillinfo(billinfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向账单信息编辑界面
     */
    @RequestMapping(value = "/billinfoQueryById")
    public String billinfoQueryById(@RequestParam(name="id",required = true)Integer id, Model model){
        Billinfo billinfo = billinfoService.queryBillinfoById(id);
        model.addAttribute("obj",billinfo);
        return "/billinfoPage";
    }
    /**
     * 修改账单信息方法
     */
    @RequestMapping(value = "/billinfoEdit")
    @ResponseBody
    public Object billinfoEdit(Billinfo billinfo){
        try {
            int i = billinfoService.editBillinfo(billinfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除账单信息方法
     */
    @RequestMapping(value = "/billinfoDelById")
    @ResponseBody
    public Object billinfoDelById(Integer id){
        try {
            int i = billinfoService.delBillinfoByid(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有账单信息方法
     */
    @RequestMapping(value = "/billinfoList")
    @ResponseBody
    public Object supplierList(){
        List<Billinfo> billinfos = billinfoService.queryBillinfoList();
        return ResultMapUtil.getHashMapList(billinfos);
    }

}
