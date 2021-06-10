package com.valueplus.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valueplus.drug.entity.Returngoods;
import com.valueplus.drug.mapper.ReturngoodsMapper;
import com.valueplus.drug.service.IReturngoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 药品退货service实现类
 */
@Service
public class ReturngoodsServiceImpl extends ServiceImpl<ReturngoodsMapper, Returngoods> implements IReturngoodsService {
    @Autowired
    private ReturngoodsMapper returngoodsMapper;


    /**
     * 分页查询数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    查询参数条件-药品名称
     * @return
     */
    @Override
    public IPage<Returngoods> selectReturngoodsPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Returngoods> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Returngoods> page = new Page<>(pageNum,pageSize);
        return returngoodsMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条数据
     *
     * @param returngoods
     */
    @Override
    public int addReturngoods(Returngoods returngoods) {
        return returngoodsMapper.insert(returngoods);
    }

    /**
     * 修改数据
     *
     * @param returngoods
     * @return
     */
    @Override
    public int editReturngoods(Returngoods returngoods) {
        return returngoodsMapper.updateById(returngoods);
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public Returngoods queryReturngoodsById(Integer id) {
        return returngoodsMapper.selectById(id);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delReturngoodsByid(Integer id) {
        return returngoodsMapper.deleteById(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Returngoods> queryReturngoodsList() {
        return returngoodsMapper.selectList(null);
    }
}
