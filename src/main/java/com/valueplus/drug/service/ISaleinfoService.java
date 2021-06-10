package com.valueplus.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.Saleinfo;
import com.valueplus.drug.entity.Saleinfo;

import java.util.List;

/**
 * 销售记录表service接口
 */
public interface ISaleinfoService extends IService<Saleinfo> {
    /**
     * 分页查询数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 查询参数条件-药品名称
     * @return
     */
    public IPage<Saleinfo> selectSaleinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条数据
     * @param saleinfo
     */
    public int addSaleinfo(Saleinfo saleinfo);

    /**
     * 修改数据
     * @param saleinfo
     * @return
     */
    public int editSaleinfo(Saleinfo saleinfo);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Saleinfo querySaleinfoById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delSaleinfoByid(Integer id);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Saleinfo> querySaleinfoList();
}
