package org.practice.duplication.solution01.approach2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.practice.duplication.solution01.approach2.data.BudgetDataService_S2;
import org.practice.duplication.solution01.approach2.data.LastSubmittedDataService_S2;
import org.practice.duplication.solution01.approach2.data.RoomsDataService_S2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoomsReportService_S2Test {


    @Mock
    private RoomsDataService_S2 roomsDataService;
    @Mock
    private BudgetDataService_S2 budgetDataService;
    @Mock
    private LastSubmittedDataService_S2 lastSubmittedDataService;
    @InjectMocks
    private RoomsReportService_S2 roomsReportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getActiveRoomsDataFull() {
        when(roomsDataService.isFirstDataPull()).thenReturn(true);
        when(roomsDataService.getRoomsDataFull()).thenReturn(List.of(3, 4));
        assertEquals("Add header: Add PropertyName: Data:[3, 4]: Total rows-2: Add Footer", roomsReportService.getActiveRoomsData());
        verify(roomsDataService,never()).getRoomsDataDifferntial();
    }

    @Test
    void getActiveRoomsDataDifferential() {
        when(roomsDataService.isFirstDataPull()).thenReturn(false);
        when(roomsDataService.getRoomsDataDifferntial()).thenReturn(List.of(4));
        assertEquals("Add header: Add PropertyName: Data:[4]: Total rows-1: Add Footer", roomsReportService.getActiveRoomsData());
        verify(roomsDataService,never()).getRoomsDataFull();
    }

    @Test
    void getBudgetRoomsDataFull() {
        when(budgetDataService.isFirstDataPull()).thenReturn(true);
        List<Integer> value = new ArrayList<>();
        value.add(9);
        value.add(20);
        when(budgetDataService.getBudgetDataFull()).thenReturn(value);
        assertEquals("Add header: Add PropertyName: Data:[9, 20, 7]: Total rows-3: Add Footer", roomsReportService.getBudgetRoomsData());
        verify(roomsDataService,never()).getRoomsDataDifferntial();
    }

}