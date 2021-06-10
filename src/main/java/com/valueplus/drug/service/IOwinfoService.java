package com.valueplus.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.Owinfo;
import com.valueplus.drug.entity.Owinfo;

import java.util.List;

/**
 * 出入库表service接口
 */
public interface IOwinfoService extends IService<Owinfo> {
    /**
     * 分页查询数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 查询参数条件-药品名称
     * @return
     */
    public IPage<Owinfo> selectOwinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条数据
     * @param owinfo
     */
    public int addOwinfo(Owinfo owinfo);

    /**
     * 修改数据
     * @param owinfo
     * @return
     */
    public int editOwinfo(Owinfo owinfo);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Owinfo queryOwinfoById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delOwinfoByid(Integer id);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Owinfo> queryOwinfoList();
}
