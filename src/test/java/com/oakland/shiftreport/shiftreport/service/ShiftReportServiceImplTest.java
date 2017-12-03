package com.oakland.shiftreport.shiftreport.service;

import com.oakland.shiftreport.shiftreport.model.ShiftReport;
import com.oakland.shiftreport.shiftreport.repository.ShiftReportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShiftReportServiceImplTest {

    @Mock
    ShiftReportRepository shiftReportRepository;

    @InjectMocks
    private ShiftReportServiceImpl shiftReportService;

    @Test
    public void getShiftReports() throws Exception {
        ShiftReport shiftReport1 = new ShiftReport();
        ShiftReport shiftReport2 = new ShiftReport();

        List<ShiftReport> expectations = Arrays.asList(shiftReport1, shiftReport2);

        when(shiftReportRepository.findAll()).thenReturn(expectations);

        assertThat(shiftReportService.getShiftReports()).containsExactlyElementsOf(expectations);
    }

    @Test
    public void createShiftReports() throws Exception {
        ShiftReport shiftReport = new ShiftReport();

        shiftReportService.createShiftReport(shiftReport);
        verify(shiftReportRepository, times(1)).save(shiftReport);
    }
}