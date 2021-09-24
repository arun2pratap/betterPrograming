package org.practice.duplication.solution01.approach1;

import org.practice.duplication.solution01.approach1.data.BudgetDataService_S1;
import org.practice.duplication.solution01.approach1.data.DataService;
import org.practice.duplication.solution01.approach1.data.LastSubmittedDataService_S1;
import org.practice.duplication.solution01.approach1.data.RoomsDataService_S1;

import java.util.List;

public class RoomsReportService_S1 {
    private final RoomsDataService_S1 roomsDataService;
    private final BudgetDataService_S1 budgetDataService;
    private final LastSubmittedDataService_S1 lastSubmittedDataService;

    public RoomsReportService_S1(RoomsDataService_S1 roomsDataService, BudgetDataService_S1 budgetDataService, LastSubmittedDataService_S1 lastSubmittedDataService) {
        this.roomsDataService = roomsDataService;
        this.budgetDataService = budgetDataService;
        this.lastSubmittedDataService = lastSubmittedDataService;
    }

    public String getActiveRoomsData() {
        StringBuilder result = new StringBuilder();
        addHeader(result);
        List<Integer> roomsData = getData(roomsDataService);
        addFooter(result, roomsData);
        return result.toString();
    }


    public String getBudgetRoomsData() {
        StringBuilder result = new StringBuilder();
        addHeader(result);
        List<Integer> roomsData = getData(budgetDataService);
        addFooter(result, roomsData);
        return result.toString();
    }

    private List<Integer> getData(DataService dataService) {
        List<Integer> roomsData;
        if (dataService.isFirstDataPull()) {
            roomsData = dataService.getDataFull();
        } else {
            roomsData = dataService.getDataDifferential();
        }
        return roomsData;
    }

    private void addFooter(StringBuilder result, List<Integer> roomsData) {
        result.append(roomsData == null ? ": No Data" : ": Data:" + roomsData.toString());
        result.append(": Total rows-" + roomsData.size());
        result.append(": Add Footer");
    }

    private void addHeader(StringBuilder result) {
        result.append("Add header");
        result.append(": Add PropertyName");
    }

}
