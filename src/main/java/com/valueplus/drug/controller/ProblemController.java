package com.valueplus.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.valueplus.drug.common.ResultMapUtil;
import com.valueplus.drug.entity.Problem;
import com.valueplus.drug.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 问题药品相关controller
 */
@Controller
@RequestMapping(value = "/problem")
public class ProblemController {
    @Autowired
    private IProblemService problemService;
    /**
     * 转向问题药品界面
     */
    @RequestMapping
    public String problem(){
        return "/problem";
    }

    /**
     * 分页查询问题药品列表
     */
    @RequestMapping(value = "/problemQueryPage")
    @ResponseBody
    public Object problemQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Problem> ipage = problemService.selectProblemPage(pageNum, pageSize, param);
            System.out.println(ipage.getRecords());
            return ResultMapUtil.getHashMapMysqlPage(ipage);
        }catch (Exception e){
            return  ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向新增问题药品界面
     */
    @RequestMapping(value = "/problemPage")
    public String problemPage(){
        return "/problemPage";
    }

    /**
     * 新增问题药品方法
     */
    @RequestMapping(value = "/problemAdd")
    @ResponseBody
    public Object problemAdd(Problem problem){
        try {
            problem.setCreatetime(new Date());
            int i = problemService.addProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向问题药品编辑界面
     */
    @RequestMapping(value = "/problemQueryById")
    public String problemQueryById(@RequestParam(name="id",required = true)Integer id, Model model){
        Problem problem = problemService.queryProblemById(id);
        model.addAttribute("obj",problem);
        return "/problemPage";
    }
    /**
     * 修改问题药品方法
     */
    @RequestMapping(value = "/problemEdit")
    @ResponseBody
    public Object problemEdit(Problem problem){
        try {
            int i = problemService.editProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除问题药品方法
     */
    @RequestMapping(value = "/problemDelById")
    @ResponseBody
    public Object problemDelById(Integer id){
        try {
            int i = problemService.delProblemByid(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}
