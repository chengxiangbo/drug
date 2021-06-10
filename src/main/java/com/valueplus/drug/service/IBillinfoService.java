package com.valueplus.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.Billinfo;

import java.util.List;

/**
 * 账单信息表service接口
 */
public interface IBillinfoService extends IService<Billinfo> {
    /**
     * 分页查询数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 查询参数条件-药品名称
     * @return
     */
    public IPage<Billinfo> selectBillinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条数据
     * @param billinfo
     */
    public int addBillinfo(Billinfo billinfo);

    /**
     * 修改数据
     * @param billinfo
     * @return
     */
    public int editBillinfo(Billinfo billinfo);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Billinfo queryBillinfoById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delBillinfoByid(Integer id);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Billinfo> queryBillinfoList();
}
