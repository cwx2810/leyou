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

    /**
     * 查询规格组
     * @param cid
     * @return
     */
    public List<SpecGroup> querySpecGroupByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        List<SpecGroup> groups = this.specGroupMapper.select(specGroup);
        groups.forEach(group -> {
            SpecParam specParam = new SpecParam();
            specParam.setGroupId(group.getId());
            List<SpecParam> params = this.specParamMapper.select(specParam);
            group.setParams(params);
        });
        return groups;
    }

    /**
     * 查询规格参数
     * @param group_id
     * @param cid
     * @param generic
     * @param searching
     * @return
     */
    public List<SpecParam> querySpecParam(Long group_id, Long cid, Boolean generic, Boolean searching) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(group_id);
        specParam.setCid(cid);
        specParam.setGeneric(generic);
        specParam.setSearching(searching);
        return specParamMapper.select(specParam);
    }
}
