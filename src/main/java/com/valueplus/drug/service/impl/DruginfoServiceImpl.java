package com.valueplus.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valueplus.drug.entity.Druginfo;
import com.valueplus.drug.mapper.DruginfoMapper;
import com.valueplus.drug.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 药品service实现类
 */
@Service
public class DruginfoServiceImpl extends ServiceImpl<DruginfoMapper, Druginfo> implements IDruginfoService {
    @Autowired
    private DruginfoMapper druginfoMapper;


    /**
     * 分页查询数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    查询参数条件-药品名称
     * @return
     */
    @Override
    public IPage<Druginfo> selectDruginfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Druginfo> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Druginfo> page = new Page<>(pageNum,pageSize);
        return druginfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条数据
     *
     * @param druginfo
     */
    @Override
    public int addDruginfo(Druginfo druginfo) {
        return druginfoMapper.insert(druginfo);
    }

    /**
     * 修改数据
     *
     * @param druginfo
     * @return
     */
    @Override
    public int editDruginfo(Druginfo druginfo) {
        return druginfoMapper.updateById(druginfo);
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public Druginfo queryDruginfoById(Integer id) {
        return druginfoMapper.selectById(id);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delDruginfoByid(Integer id) {
        return druginfoMapper.deleteById(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Druginfo> queryDruginfoList() {
        return druginfoMapper.selectList(null);
    }
}
