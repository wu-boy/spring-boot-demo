package com.wu.springboot.demo.web.rest.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * 新增用户参数
 * @author wusq
 * @date 2019/11/28
 */
@ApiModel("新增用户参数")
public class UserInsertDto {

    @ApiModelProperty(value = "生日", required = true)
    @NotNull(message = "日期不能为空")
    //@Future(message = "需要一个将来的日期")
    //@Past(message = "需要一个以前的日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ApiModelProperty(value = "Double值", required = true)
    @NotNull(message = "Double值不能为空")
    @DecimalMin(value = "0.1", message = "Double值不能小于0.1")
    @DecimalMax(value = "100.00", message = "Double值不能大于100")
    private Double doubleValue;

    @ApiModelProperty(value = "Integer值", required = true)
    @NotNull(message = "Integer值不能为空")
    @Min(value = 1, message = "Integer值最小值为1")
    @Max(value = 100, message = "Integer值最大值为100")
    private Integer integerValue;

    @ApiModelProperty("range值")
    @Range( min = 1, max = 100, message = "range范围为1至100")
    private Integer range;

    @ApiModelProperty(value = "邮箱", required = true)
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    @Size(min = 8, max = 64, message = "邮箱长度要求8至64之间")
    private String email;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
