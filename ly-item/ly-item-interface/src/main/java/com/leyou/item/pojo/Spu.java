package com.leyou.item.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: LieutenantChen
 * @create: 2018-08-30 17:11
 **/
@Table(name = "tb_spu")
public class Spu implements CharSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 子标题
     */
    private String subTitle;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    /**
     * 商品所属品牌id
     */
    private Long brandId;
    /**
     * 是否上架
     */
    private Boolean saleable;
    /**
     * 是否有效
     */
    private Boolean valid;
    /**
     * 添加时间
     */
    private Date createTime;
    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;
    /**
     * 商品所属分类全路径
     */
    @Transient
    private String cname;
    /**
     * 商品所属的品牌名称
     */
    @Transient
    private String bname;
    /**
     * 抽象商品具体
     */
    @Transient
    private SpuDetail spuDetail;
    /**
     * 具体的商品
     */
    @Transient
    private List<Sku> skus;
    public String getBname() {
        return bname;
    }
    public void setBname(String bname) {
        this.bname = bname;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubTitle() {
        return subTitle;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public Long getCid1() {
        return cid1;
    }
    public void setCid1(Long cid1) {
        this.cid1 = cid1;
    }
    public Long getCid2() {
        return cid2;
    }
    public void setCid2(Long cid2) {
        this.cid2 = cid2;
    }
    public Long getCid3() {
        return cid3;
    }
    public void setCid3(Long cid3) {
        this.cid3 = cid3;
    }
    public Long getBrandId() {
        return brandId;
    }
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    public Boolean getSaleable() {
        return saleable;
    }
    public void setSaleable(Boolean saleable) {
        this.saleable = saleable;
    }
    public Boolean getValid() {
        return valid;
    }
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public SpuDetail getSpuDetail() {
        return spuDetail;
    }
    public void setSpuDetail(SpuDetail spuDetail) {
        this.spuDetail = spuDetail;
    }
    public List<Sku> getSkus() {
        return skus;
    }
    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
