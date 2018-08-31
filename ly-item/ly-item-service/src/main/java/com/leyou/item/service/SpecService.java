package com.leyou.item.service;


import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author: LieutenantChen
 * @create: 2018-08-31 18:30
 **/
@Service
public class SpecService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;

    public List<SpecGroup> querySpecGroupByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return specGroupMapper.select(specGroup);
    }
    public List<SpecParam> querySpecParamByGid(Long group_id, Long cid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(group_id);
        specParam.setCid(cid);
        return specParamMapper.select(specParam);
    }
}
