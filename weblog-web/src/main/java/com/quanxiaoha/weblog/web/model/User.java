package com.quanxiaoha.weblog.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: wangyoulang
 * @url: www.quanxiaoha.com
 * @date: 2023-08-10 10:35
 * @description: TODO
 * 以下是 JSR 380 中提供的主要验证注解及其描述：
 *
 * @NotNull: 验证对象值不应为 null。
 * @AssertTrue: 验证布尔值是否为 true。
 * @AssertFalse: 验证布尔值是否为 false。
 * @Min(value): 验证数字是否不小于指定的最小值。
 * @Max(value): 验证数字是否不大于指定的最大值。
 * @DecimalMin(value): 验证数字值（可以是浮点数）是否不小于指定的最小值。
 * @DecimalMax(value): 验证数字值（可以是浮点数）是否不大于指定的最大值。
 * @Positive: 验证数字值是否为正数。
 * @PositiveOrZero: 验证数字值是否为正数或零。
 * @Negative: 验证数字值是否为负数。
 * @NegativeOrZero: 验证数字值是否为负数或零。
 * @Size(min, max): 验证元素（如字符串、集合或数组）的大小是否在给定的最小值和最大值之间。
 * @Digits(integer, fraction): 验证数字是否在指定的位数范围内。例如，可以验证一个数字是否有两位整数和三位小数。
 * @Past: 验证日期或时间是否在当前时间之前。
 * @PastOrPresent: 验证日期或时间是否在当前时间或之前。
 * @Future: 验证日期或时间是否在当前时间之后。
 * @FutureOrPresent: 验证日期或时间是否在当前时间或之后。
 * @Pattern(regexp): 验证字符串是否与给定的正则表达式匹配。
 * @NotEmpty: 验证元素（如字符串、集合、Map 或数组）不为 null，并且其大小/长度大于0。
 * @NotBlank: 验证字符串不为 null，且至少包含一个非空白字符。
 * @Email: 验证字符串是否符合有效的电子邮件格式。
 **/
@Data
@ApiModel(value = "用户实体类")
public class User {
    // 用户名
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;
    // 性别
    @NotNull(message = "性别不能为空")
    @ApiModelProperty(value = "用户性别")
    private Integer sex;

    // 年龄
    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "年龄必须大于或等于 18")
    @Max(value = 100, message = "年龄必须小于等于 100")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    // 邮箱
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱")
    private String email;

    // 创建时间
    private LocalDateTime createTime;
    // 更新日期
    private LocalDate updateDate;
    // 时间
    private LocalTime time;
}
