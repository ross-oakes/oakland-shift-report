package com.oakland.shiftreport.shiftreport.controllers;

import com.oakland.shiftreport.shiftreport.model.Shift;
import com.oakland.shiftreport.shiftreport.model.ShiftReport;
import com.oakland.shiftreport.shiftreport.service.ShiftReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ShiftReportController {

    ShiftReportService shiftReportService;

    public ShiftReportController(ShiftReportService shiftReportService) {
        this.shiftReportService = shiftReportService;
    }

    @GetMapping(path = "/shiftReport")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ShiftReport> getShiftReports() {
        return shiftReportService.getShiftReports();
    }

    @PostMapping(path= "/shiftReport", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void createShiftReports(@Valid @RequestBody ShiftReport shiftReport) {
        shiftReportService.createShiftReport(shiftReport);
    }
}
