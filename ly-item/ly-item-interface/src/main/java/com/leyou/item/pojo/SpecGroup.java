package com.leyou.item.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author: LieutenantChen
 * @create: 2018-08-31 17:46
 **/
@Table(name = "tb_spec_group")
public class SpecGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 商品分类id
     */
    private Long cid;
    /**
     * 规格组的名称
     */
    private String name;

    /**
     * 规格组下组参数
     */
    @Transient
    private List<SpecParam> params;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCid() {
        return cid;
    }
    public void setCid(Long cid) {
        this.cid = cid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<SpecParam> getParams() {
        return params;
    }
    public void setParams(List<SpecParam> params) {
        this.params = params;
    }
}
