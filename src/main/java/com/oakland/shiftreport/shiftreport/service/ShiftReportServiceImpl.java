package com.oakland.shiftreport.shiftreport.service;

import com.oakland.shiftreport.shiftreport.model.ShiftReport;
import com.oakland.shiftreport.shiftreport.repository.ShiftReportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShiftReportServiceImpl implements ShiftReportService {

    ShiftReportRepository shiftReportRepository;

    public ShiftReportServiceImpl(ShiftReportRepository shiftReportRepository) {
        this.shiftReportRepository = shiftReportRepository;
    }

    @Override
    public List<ShiftReport> getShiftReports() {
        return StreamSupport.stream(shiftReportRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void createShiftReport(ShiftReport shiftReport) {
        shiftReportRepository.save(shiftReport);
    }
}
