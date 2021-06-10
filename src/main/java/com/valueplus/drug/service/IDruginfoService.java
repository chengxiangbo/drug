package com.valueplus.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.Druginfo;

import java.util.List;

/**
 * 药品表service接口
 */
public interface IDruginfoService extends IService<Druginfo> {
    /**
     * 分页查询数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 查询参数条件-药品名称
     * @return
     */
    public IPage<Druginfo> selectDruginfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条数据
     * @param druginfo
     */
    public int addDruginfo(Druginfo druginfo);

    /**
     * 修改数据
     * @param druginfo
     * @return
     */
    public int editDruginfo(Druginfo druginfo);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Druginfo queryDruginfoById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delDruginfoByid(Integer id);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Druginfo> queryDruginfoList();
}
