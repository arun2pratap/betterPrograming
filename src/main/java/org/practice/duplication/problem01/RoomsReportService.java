package org.practice.duplication.problem01;

import org.practice.duplication.problem01.data.BudgetDataService;
import org.practice.duplication.problem01.data.RoomsDataService;
import org.practice.duplication.problem01.data.LastSubmittedDataService;

import java.util.List;

public class RoomsReportService {
    private final RoomsDataService roomsDataService;
    private final BudgetDataService budgetDataService;
    private final LastSubmittedDataService lastSubmittedDataService;

    public RoomsReportService(RoomsDataService roomsDataService, BudgetDataService budgetDataService, LastSubmittedDataService lastSubmittedDataService) {
        this.roomsDataService = roomsDataService;
        this.budgetDataService = budgetDataService;
        this.lastSubmittedDataService = lastSubmittedDataService;
    }

    public String getActiveRoomsData() {
        StringBuilder result = new StringBuilder();
        List<Integer> roomsData;
        result.append("Add header");
        result.append(": Add PropertyName");
        if (!roomsDataService.isDataChange()) {
            roomsData = roomsDataService.getRoomsDataFull();
        } else {
            roomsData = roomsDataService.getRoomsDataDifferntial();
        }
        result.append( roomsData == null ? ": No Data" : ": Data:" + roomsData.toString());
        result.append(": Total rows-" + roomsData.size());
        result.append(": Add Footer");
        return result.toString();
    }

    public String getBudgetRoomsData() {
        StringBuilder result = new StringBuilder();
        List<Integer> roomsData;
        result.append("Add header");
        result.append(": Add PropertyName");
        if (!budgetDataService.isDataChange()) {
            roomsData = budgetDataService.getBudgetDataFull();
        } else {
            roomsData = budgetDataService.getBudgetDataDifferntial();
        }
        result.append( roomsData == null ? ": No Data" : ": Data:" + roomsData.toString());
        result.append(": Total rows-" + roomsData.size());
        result.append(": Add Footer");
        return result.toString();
    }

    public String getLastSubmittedRoomsData() {
        StringBuilder result = new StringBuilder();
        List<Integer> roomsData;
        result.append("Add header");
        result.append(": Add PropertyName");
        if (!lastSubmittedDataService.isDataChange()) {
            roomsData = lastSubmittedDataService.getLastSubmittedDataFull();
        } else {
            roomsData = lastSubmittedDataService.getLastSubmittedDifferntial();
        }
        result.append( roomsData == null ? ": No Data" : ": Data:" + roomsData.toString());
        result.append(": Total rows-" + roomsData.size());
        result.append(": Add Footer");
        return result.toString();
    }
}
