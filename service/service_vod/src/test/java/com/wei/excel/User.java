package com.wei.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author VitamineG
 * @DateTime 2022/9/12 15:25
 */
@Data
public class User {

    @ExcelProperty(value = "用户编号")
    private int id;

    @ExcelProperty("用户名称")
    private String name;
}
