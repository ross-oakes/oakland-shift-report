package com.oakland.shiftreport.shiftreport.controllers;

import com.oakland.shiftreport.shiftreport.model.ShiftReport;
import com.oakland.shiftreport.shiftreport.service.ShiftReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShiftReportController.class)
public class ShiftReportControllerTest {

    @MockBean
    private ShiftReportService service;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shiftReportController_getShiftReport_canCallEndPoint() throws Exception {
        ShiftReport shiftReport = new ShiftReport();
        shiftReport.setId(1);
        shiftReport.setUnitsMade(10);

        when(service.getShiftReports()).thenReturn(Collections.singletonList(shiftReport));

        mvc.perform(get("/shiftReport"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].unitsMade").value(10));
    }

    @Test
    public void shiftReportController_createShiftReport_canCallEndPoint() throws Exception {
        String content = "{\n" +
                "  \"id\":\"1\",\n" +
                "  \"date\":\"2017-01-01\",\n" +
                "  \"shift\":\"MORNING\",\n" +
                "  \"shiftManager\":\"Ross\",\n" +
                "  \"unitsMade\":\"10\"\n" +
                "}";

        mvc.perform(post("/shiftReport").content(content).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void shiftReportController_createShiftReport_missingValueCausesFailure() throws Exception {
        String content = "{\n" +
                "  \"id\":\"1\",\n" +
                "  \"date\":\"2017-01-01\",\n" +
                "  \"shift\":\"MORNING\",\n" +
                "  \"shiftManager\":\"Ross\"\n" +
                "}";

        mvc.perform(post("/shiftReport").content(content).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }
}