package org.practice.duplication.problem01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.practice.duplication.problem01.data.BudgetDataService;
import org.practice.duplication.problem01.data.LastSubmittedDataService;
import org.practice.duplication.problem01.data.RoomsDataService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RoomsReportServiceTest {
    @Mock
    private RoomsDataService roomsDataService;
    @Mock
    private BudgetDataService budgetDataService;
    @Mock
    private LastSubmittedDataService lastSubmittedDataService;
    @InjectMocks
    private RoomsReportService roomsReportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getActiveRoomsDataFull() {
        when(roomsDataService.isDataChange()).thenReturn(false);
        when(roomsDataService.getRoomsDataFull()).thenReturn(List.of(3,4));
        assertEquals("Add header: Add PropertyName: Data:[3, 4]: Total rows-2: Add Footer", roomsReportService.getActiveRoomsData());
    }

    @Test
    void getActiveRoomsDataDifferential() {
        when(roomsDataService.isDataChange()).thenReturn(true);
        when(roomsDataService.getRoomsDataDifferntial()).thenReturn(List.of(4));
        assertEquals("Add header: Add PropertyName: Data:[4]: Total rows-1: Add Footer", roomsReportService.getActiveRoomsData());
    }
}