package com.wei.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author VitamineG
 * @DateTime 2022/9/13 11:21
 */
public class TestRead {
    public static void main(String[] args) {
        String filename = "D://wei.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(filename, User.class, new ExcelListener())
                .sheet().doRead();
    }
}
