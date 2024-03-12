package com.example.demo.controller;

import com.example.demo.entity.Record;
import com.example.demo.service.RecordService;
import com.example.demo.util.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordController {
    @Resource
    private RecordService recordService;

    @PostMapping("/save")
    public Result<Record> saveRecord(@RequestBody List<Record> records, HttpServletRequest request) {
        return recordService.saveRecord(records, request.getSession());
    }

    @GetMapping("/list")
    public Result<List<Record>> listRecords(HttpServletRequest request) {
        return recordService.listRecords(request.getSession());
    }

    @GetMapping("/delete")
    public Result<Record> deleteRecords(@RequestParam String url) {
        System.out.println("url: " + url);
        return recordService.deleteRecords(url);
    }
}
