package com.valueplus.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valueplus.drug.entity.Returnsupplier;
import com.valueplus.drug.mapper.ReturnsupplierMapper;
import com.valueplus.drug.service.IReturnsupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 退货给供应商service实现类
 */
@Service
public class ReturnsupplierServiceImpl extends ServiceImpl<ReturnsupplierMapper, Returnsupplier> implements IReturnsupplierService {
    @Autowired
    private ReturnsupplierMapper returnsupplierMapper;


    /**
     * 分页查询数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    查询参数条件-药品名称
     * @return
     */
    @Override
    public IPage<Returnsupplier> selectReturnsupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Returnsupplier> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Returnsupplier> page = new Page<>(pageNum,pageSize);
        return returnsupplierMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条数据
     *
     * @param returnsupplier
     */
    @Override
    public int addReturnsupplier(Returnsupplier returnsupplier) {
        return returnsupplierMapper.insert(returnsupplier);
    }

    /**
     * 修改数据
     *
     * @param returnsupplier
     * @return
     */
    @Override
    public int editReturnsupplier(Returnsupplier returnsupplier) {
        return returnsupplierMapper.updateById(returnsupplier);
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public Returnsupplier queryReturnsupplierById(Integer id) {
        return returnsupplierMapper.selectById(id);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delReturnsupplierByid(Integer id) {
        return returnsupplierMapper.deleteById(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Returnsupplier> queryReturnsupplierList() {
        return returnsupplierMapper.selectList(null);
    }
}
