package org.practice.duplication.solution01.approach1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.practice.duplication.solution01.approach1.data.BudgetDataService_S1;
import org.practice.duplication.solution01.approach1.data.LastSubmittedDataService_S1;
import org.practice.duplication.solution01.approach1.data.RoomsDataService_S1;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoomsReportService_S1Test {

    @Mock
    private RoomsDataService_S1 roomsDataService;
    @Mock
    private BudgetDataService_S1 budgetDataService;
    @Mock
    private LastSubmittedDataService_S1 lastSubmittedDataService;
    @InjectMocks
    private RoomsReportService_S1 roomsReportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getActiveRoomsDataFull() {
        when(roomsDataService.isFirstDataPull()).thenReturn(true);
        when(roomsDataService.getDataFull()).thenReturn(List.of(3, 4));
        assertEquals("Add header: Add PropertyName: Data:[3, 4]: Total rows-2: Add Footer", roomsReportService.getActiveRoomsData());
        verify(roomsDataService,never()).getDataDifferential();
    }

    @Test
    void getActiveRoomsDataDifferential() {
        when(roomsDataService.isFirstDataPull()).thenReturn(false);
        when(roomsDataService.getDataDifferential()).thenReturn(List.of(4));
        assertEquals("Add header: Add PropertyName: Data:[4]: Total rows-1: Add Footer", roomsReportService.getActiveRoomsData());
        verify(roomsDataService,never()).getDataFull();
    }

    @Test
    void getBudgetRoomsDataFull() {
        when(budgetDataService.isFirstDataPull()).thenReturn(true);
        when(budgetDataService.getDataFull()).thenReturn(List.of(9, 20));
        assertEquals("Add header: Add PropertyName: Data:[9, 20]: Total rows-2: Add Footer", roomsReportService.getBudgetRoomsData());
        verify(roomsDataService,never()).getDataDifferential();
    }

    // TODO: test for budget and lastSubmitted getData
}