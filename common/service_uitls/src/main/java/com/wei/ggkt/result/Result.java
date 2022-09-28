package com.wei.ggkt.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VitamineG
 * @DateTime 2022/9/7 21:26
 */
@Data
@NoArgsConstructor
public class Result<T> {

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 建立一个构建操作
     */
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = new Result<T>();
        if (body != null) {
            result.setData(body);
        }
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 需要数据返回的成功操作
     */
    public static <T> Result<T> ok(T data) {
        return build(data, 20000, "成功");
    }

    /**
     * 无需数据返回的成功操作
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 需要数据返回的失败操作
     */
    public static <T> Result<T> fail(T data) {
        return build(data, 20001, "失败");
    }

    /**
     * 无需数据返回的成功操作
     */
    public static <T> Result<T> fail() {
        return fail(null);
    }

    public Result<T> message(String msg) {
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }
}
