package com.example.demo.dao;

import com.example.demo.entity.Record;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RecordDao extends JpaRepository<Record, Long> {
    List<Record> findRecordsByUid(Long uid);

    @Transactional
    void deleteRecordsByUrl(String url);
}
