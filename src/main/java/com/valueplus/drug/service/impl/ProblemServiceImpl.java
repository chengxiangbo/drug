package com.valueplus.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valueplus.drug.entity.Problem;
import com.valueplus.drug.mapper.ProblemMapper;
import com.valueplus.drug.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 问题药品表service实现类
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements IProblemService {
    @Autowired
    private ProblemMapper problemMapper;


    /**
     * 分页查询数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    查询参数条件-药品名称
     * @return
     */
    @Override
    public IPage<Problem> selectProblemPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Problem> page = new Page<>(pageNum,pageSize);
        return problemMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条数据
     *
     * @param problem
     */
    @Override
    public int addProblem(Problem problem) {
        return problemMapper.insert(problem);
    }

    /**
     * 修改数据
     *
     * @param problem
     * @return
     */
    @Override
    public int editProblem(Problem problem) {
        return problemMapper.updateById(problem);
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public Problem queryProblemById(Integer id) {
        return problemMapper.selectById(id);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delProblemByid(Integer id) {
        return problemMapper.deleteById(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Problem> queryProblemList() {
        return problemMapper.selectList(null);
    }
}
