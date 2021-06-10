package com.valueplus.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valueplus.drug.entity.Billinfo;
import com.valueplus.drug.mapper.BillinfoMapper;
import com.valueplus.drug.service.IBillinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 药品退货service实现类
 */
@Service
public class BillinfoServiceImpl extends ServiceImpl<BillinfoMapper, Billinfo> implements IBillinfoService {
    @Autowired
    private BillinfoMapper billinfoMapper;


    /**
     * 分页查询数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    查询参数条件-药品名称
     * @return
     */
    @Override
    public IPage<Billinfo> selectBillinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Billinfo> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            //根据供应商名称精确查询
            queryWrapper.eq("sname",param);
        }
        Page<Billinfo> page = new Page<>(pageNum,pageSize);
        return billinfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条数据
     *
     * @param billinfo
     */
    @Override
    public int addBillinfo(Billinfo billinfo) {
        return billinfoMapper.insert(billinfo);
    }

    /**
     * 修改数据
     *
     * @param billinfo
     * @return
     */
    @Override
    public int editBillinfo(Billinfo billinfo) {
        return billinfoMapper.updateById(billinfo);
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public Billinfo queryBillinfoById(Integer id) {
        return billinfoMapper.selectById(id);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delBillinfoByid(Integer id) {
        return billinfoMapper.deleteById(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Billinfo> queryBillinfoList() {
        return billinfoMapper.selectList(null);
    }
}
