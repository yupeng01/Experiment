package com.nobug.experiment.controller;

import com.alibaba.excel.EasyExcel;
import com.nobug.experiment.controller.entity.DownloadData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("excel")
@RestController
public class ExcelController {
    @GetMapping("download")
    public void downLoadExcel (HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("测试", "utf-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DownloadData.class)
                .sheet("模板")
                .doWrite(buildDownloadDataList());
        response.getOutputStream().close();
    }

    private List<DownloadData> buildDownloadDataList () {
        List<DownloadData> list = new ArrayList<>();
        return list;
    }

    private static String getNowTimeStamp () {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        return year + "-" + month + "-" + day;
    }

    public static void main(String[] args) {
        System.out.println(getNowTimeStamp());
    }
}
