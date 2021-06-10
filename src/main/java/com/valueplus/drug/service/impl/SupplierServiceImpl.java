package com.valueplus.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valueplus.drug.entity.Supplier;
import com.valueplus.drug.mapper.SupplierMapper;
import com.valueplus.drug.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 供应商service实现类
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {
    @Autowired
    private SupplierMapper supplierMapper;


    /**
     * 分页查询数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    查询参数条件-供应商名称
     * @return
     */
    @Override
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Supplier> page = new Page<>(pageNum,pageSize);
        return supplierMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条数据
     *
     * @param supplier
     */
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    /**
     * 修改数据
     *
     * @param supplier
     * @return
     */
    @Override
    public int editSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public Supplier querySupplierById(Integer id) {
        return supplierMapper.selectById(id);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delSupplierByid(Integer id) {
        return supplierMapper.deleteById(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Supplier> querySupplierList() {
        return supplierMapper.selectList(null);
    }
}
