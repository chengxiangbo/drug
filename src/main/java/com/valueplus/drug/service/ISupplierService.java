package com.valueplus.drug.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.Supplier;
import java.util.List;

/**
 * 供应商表service接口
 */
public interface ISupplierService extends IService<Supplier> {
    /**
     * 分页查询数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 查询参数条件-供应商名称
     * @return
     */
    public IPage<Supplier> selectSupplierPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条数据
     * @param supplier
     */
    public int addSupplier(Supplier supplier);

    /**
     * 修改数据
     * @param supplier
     * @return
     */
    public int editSupplier(Supplier supplier);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Supplier querySupplierById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delSupplierByid(Integer id);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Supplier> querySupplierList();
}
