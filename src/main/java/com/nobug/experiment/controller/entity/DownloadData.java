package com.nobug.experiment.controller.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DownloadData {
    @ExcelProperty("字符串标题")
    private String stringTitle;
    @ExcelProperty("日期标题")
    private Date dataTitle;
    @ExcelProperty("数字标题")
    private Double doubleTitle;
}
