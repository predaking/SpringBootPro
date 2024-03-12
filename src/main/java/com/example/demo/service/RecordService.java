package com.example.demo.service;

import com.example.demo.entity.Record;
import com.example.demo.util.Result;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface RecordService {
    Result<Record> saveRecord(List<Record> records, HttpSession session);

    Result<List<Record>> listRecords(HttpSession session);

    Result<Record> deleteRecords(String url);
}
