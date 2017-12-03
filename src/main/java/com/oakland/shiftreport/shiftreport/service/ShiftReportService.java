package com.oakland.shiftreport.shiftreport.service;

import com.oakland.shiftreport.shiftreport.model.ShiftReport;

import java.util.List;

public interface ShiftReportService {
    List<ShiftReport> getShiftReports();

    void createShiftReport(ShiftReport shiftReport);
}
