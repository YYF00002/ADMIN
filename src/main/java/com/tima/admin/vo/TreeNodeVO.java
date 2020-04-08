package com.tima.admin.vo;

import com.tima.admin.util.TreeChildren;
import com.tima.admin.util.TreeExtend;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TreeNodeVO {
    @ApiModelProperty(value = "节点主键")
    private Long id;
    @ApiModelProperty(value = "编码")
    private String no;
    @ApiModelProperty(value = "节点编码")
    private String menuCode;
    @ApiModelProperty(value = "节点内容")
    private String menuName;
    @ApiModelProperty(value = "父节点主键")
    private String menuIco;
    @ApiModelProperty(value = "父节点主键")
    private Long parentId;
    @ApiModelProperty(value = "菜单url地址")
    private String url;
    @ApiModelProperty(value = "菜单接口地址")
    private String uri;
    @ApiModelProperty(value = "是否是菜单：0：不是：1：是")
    private Integer isMenu;
    @ApiModelProperty(value = "是否是末节点：N：不是：Y：是")
    private String isEnd;
    @ApiModelProperty(value = "菜单级别 ")
    private Integer menuLevel;
    @ApiModelProperty(value = "子层级")
    private TreeChildren children = new TreeChildren();
    @ApiModelProperty(value = "扩展信息 ")
    private TreeExtend extend;
}
