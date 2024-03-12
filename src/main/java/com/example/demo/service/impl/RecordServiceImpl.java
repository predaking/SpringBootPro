package com.example.demo.service.impl;

import com.example.demo.controller.UserController;
import com.example.demo.dao.RecordDao;
import com.example.demo.entity.Record;
import com.example.demo.entity.User;
import com.example.demo.service.RecordService;
import com.example.demo.util.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordDao recordDao;
    public Result<Record> saveRecord(List<Record> records, HttpSession session) {
        User user = (User) session.getAttribute(UserController.SESSION_NAME);
        if (user == null) {
            return Result.error(40020, "未能识别当前用户");
        }
        Long uid = user.getUid();
        for (Record record: records) {
            record.setUid(uid);
        }
        try {
            recordDao.saveAll(records);
            return Result.success();
        } catch (Exception exception) {
            return Result.error(40021, "已保存过的不再重复保存");
        }
    }

    public Result<List<Record>> listRecords(HttpSession session) {
        User user = (User) session.getAttribute(UserController.SESSION_NAME);
        if (user == null) {
            return Result.error(40020, "未能识别当前用户");
        }
        Long uid = user.getUid();
        List<Record> records = recordDao.findRecordsByUid(uid);
        return Result.success(records);
    }

    public Result<Record> deleteRecords(String url) {
        recordDao.deleteRecordsByUrl(url);
        return Result.success(null, "删除成功");
    }
}
