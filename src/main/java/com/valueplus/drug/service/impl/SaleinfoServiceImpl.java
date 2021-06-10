package com.valueplus.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valueplus.drug.entity.Saleinfo;
import com.valueplus.drug.mapper.SaleinfoMapper;
import com.valueplus.drug.service.ISaleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 药品销售记录service实现类
 */
@Service
public class SaleinfoServiceImpl extends ServiceImpl<SaleinfoMapper, Saleinfo> implements ISaleinfoService {
    @Autowired
    private SaleinfoMapper saleinfoMapper;


    /**
     * 分页查询数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    查询参数条件-药品名称
     * @return
     */
    @Override
    public IPage<Saleinfo> selectSaleinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Saleinfo> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Saleinfo> page = new Page<>(pageNum,pageSize);
        return saleinfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条数据
     *
     * @param saleinfo
     */
    @Override
    public int addSaleinfo(Saleinfo saleinfo) {
        return saleinfoMapper.insert(saleinfo);
    }

    /**
     * 修改数据
     *
     * @param saleinfo
     * @return
     */
    @Override
    public int editSaleinfo(Saleinfo saleinfo) {
        return saleinfoMapper.updateById(saleinfo);
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public Saleinfo querySaleinfoById(Integer id) {
        return saleinfoMapper.selectById(id);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delSaleinfoByid(Integer id) {
        return saleinfoMapper.deleteById(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Saleinfo> querySaleinfoList() {
        return saleinfoMapper.selectList(null);
    }
}
