package com.valueplus.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.Returnsupplier;

import java.util.List;

/**
 * 退货给供应商表service接口
 */
public interface IReturnsupplierService extends IService<Returnsupplier> {
    /**
     * 分页查询数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 查询参数条件-药品名称
     * @return
     */
    public IPage<Returnsupplier> selectReturnsupplierPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条数据
     * @param returnsupplier
     */
    public int addReturnsupplier(Returnsupplier returnsupplier);

    /**
     * 修改数据
     * @param returnsupplier
     * @return
     */
    public int editReturnsupplier(Returnsupplier returnsupplier);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Returnsupplier queryReturnsupplierById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delReturnsupplierByid(Integer id);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Returnsupplier> queryReturnsupplierList();
}
