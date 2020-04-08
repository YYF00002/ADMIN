package com.tima.admin.dto;

import com.tima.admin.validateInterface.IAddWeb;
import com.tima.admin.validateInterface.IDeleteWeb;
import com.tima.admin.validateInterface.ISelect;
import com.tima.admin.validateInterface.IUpdateWeb;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author WY
 * @since 2018-07-17
 */
@Getter
@Setter
public class VehicleBrandDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	@ApiModelProperty(value = "品牌编码")
	private String no;

	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@ApiModelProperty(value = "制造商id")
	private Long makerId;

	@ApiModelProperty(value = "制造商编码")
	private String makerNo;

	@ApiModelProperty(value = "图片类型")
	private String type;

	@ApiModelProperty(value = "车系编码")
	private String vehicleModelNo;

	@ApiModelProperty(value = "是否是主推车系")
	private Integer highlyRecommend;
	
	@ApiModelProperty(value = "排序")
	private Integer sort;
	
	@ApiModelProperty(value = "移动类型，0上移 1下移")
	private Integer sortType;

	/*
	 * @ApiModelProperty(value = "创建人") private String createdBy;
	 * 
	 * @ApiModelProperty(value = "创建时间") private Date createdDate;
	 * 
	 * @ApiModelProperty(value = "修改人") private String lastModifiedBy;
	 * 
	 * @ApiModelProperty(value = "最后修改时间") private Date lastModifiedDate;
	 * 
	 * @ApiModelProperty(value = "版本号") private Long version;
	 * 
	 * @ApiModelProperty(value = "逻辑删除") private String deleteFlag;
	 */

	@ApiModelProperty(value = "用户默认品牌集合")
	private String brands;

}
