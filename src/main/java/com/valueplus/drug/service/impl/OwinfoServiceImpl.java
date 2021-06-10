package com.valueplus.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valueplus.drug.entity.Owinfo;
import com.valueplus.drug.mapper.OwinfoMapper;
import com.valueplus.drug.service.IOwinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 出入库表service实现类
 */
@Service
public class OwinfoServiceImpl extends ServiceImpl<OwinfoMapper, Owinfo> implements IOwinfoService {
    @Autowired
    private OwinfoMapper owinfoMapper;


    /**
     * 分页查询数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    查询参数条件-药品名称
     * @return
     */
    @Override
    public IPage<Owinfo> selectOwinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Owinfo> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Owinfo> page = new Page<>(pageNum,pageSize);
        return owinfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条数据
     *
     * @param owinfo
     */
    @Override
    public int addOwinfo(Owinfo owinfo) {
        return owinfoMapper.insert(owinfo);
    }

    /**
     * 修改数据
     *
     * @param owinfo
     * @return
     */
    @Override
    public int editOwinfo(Owinfo owinfo) {
        return owinfoMapper.updateById(owinfo);
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public Owinfo queryOwinfoById(Integer id) {
        return owinfoMapper.selectById(id);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public int delOwinfoByid(Integer id) {
        return owinfoMapper.deleteById(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Owinfo> queryOwinfoList() {
        return owinfoMapper.selectList(null);
    }
}
