package org.practice.refactor.duplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomsDataReportServiceTest {
    private RoomsDataReportService roomsDataReportService;

    @BeforeEach
    void setUp() {
        roomsDataReportService = new RoomsDataReportService();
    }

    @Test
    void getActiveRoomsData() {

        assertEquals("", roomsDataReportService.getActiveRoomsData());
    }
}