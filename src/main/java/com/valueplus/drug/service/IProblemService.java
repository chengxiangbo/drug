package com.valueplus.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.Problem;

import java.util.List;

/**
 * 问题药品表service接口
 */
public interface IProblemService extends IService<Problem> {
    /**
     * 分页查询数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 查询参数条件-药品名称
     * @return
     */
    public IPage<Problem> selectProblemPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条数据
     * @param problem
     */
    public int addProblem(Problem problem);

    /**
     * 修改数据
     * @param problem
     * @return
     */
    public int editProblem(Problem problem);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Problem queryProblemById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delProblemByid(Integer id);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Problem> queryProblemList();
}
