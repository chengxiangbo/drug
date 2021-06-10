package com.valueplus.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.Returngoods;
import com.valueplus.drug.entity.Returngoods;

import java.util.List;

/**
 * 药品退货表service接口
 */
public interface IReturngoodsService extends IService<Returngoods> {
    /**
     * 分页查询数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 查询参数条件-药品名称
     * @return
     */
    public IPage<Returngoods> selectReturngoodsPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条数据
     * @param returngoods
     */
    public int addReturngoods(Returngoods returngoods);

    /**
     * 修改数据
     * @param returngoods
     * @return
     */
    public int editReturngoods(Returngoods returngoods);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Returngoods queryReturngoodsById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delReturngoodsByid(Integer id);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Returngoods> queryReturngoodsList();
}
