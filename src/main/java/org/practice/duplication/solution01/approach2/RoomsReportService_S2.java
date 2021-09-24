package org.practice.duplication.solution01.approach2;

import org.practice.duplication.solution01.approach2.data.BudgetDataService_S2;
import org.practice.duplication.solution01.approach2.data.LastSubmittedDataService_S2;
import org.practice.duplication.solution01.approach2.data.RoomsDataService_S2;

import java.util.List;
import java.util.function.Supplier;

public class RoomsReportService_S2 {
    private final RoomsDataService_S2 roomsDataService;
    private final BudgetDataService_S2 budgetDataService;
    private final LastSubmittedDataService_S2 lastSubmittedDataService;

    public RoomsReportService_S2(RoomsDataService_S2 roomsDataService, BudgetDataService_S2 budgetDataService, LastSubmittedDataService_S2 lastSubmittedDataService) {
        this.roomsDataService = roomsDataService;
        this.budgetDataService = budgetDataService;
        this.lastSubmittedDataService = lastSubmittedDataService;
    }

    public String getActiveRoomsData() {
        StringBuilder result = new StringBuilder();
        addHeader(result);
        Supplier<Boolean> firstDataPull = () -> roomsDataService.isFirstDataPull();
        Supplier<List<Integer>> roomsDataFull = () -> roomsDataService.getRoomsDataFull();
        Supplier<List<Integer>> roomsDataDifferntial = () -> roomsDataService.getRoomsDataDifferntial();
        List<Integer> roomsData = getDAta(firstDataPull, roomsDataFull, roomsDataDifferntial);
        addFooter(result, roomsData);
        return result.toString();
    }

    public String getBudgetRoomsData() {
        StringBuilder result = new StringBuilder();
        addHeader(result);
        Supplier<Boolean> firstDataPull = budgetDataService::isFirstDataPull;
        Supplier<List<Integer>> budgetDataFull = () -> {
            List<Integer> budgetDataFull1 = budgetDataService.getBudgetDataFull();
            budgetDataFull1.add(7);
            return budgetDataFull1;
        };
        Supplier<List<Integer>> budgetDataDifferntial = () -> budgetDataService.getBudgetDataDifferntial();
        List<Integer> roomsData = getDAta(firstDataPull, budgetDataFull, budgetDataDifferntial);
        addFooter(result, roomsData);
        return result.toString();
    }

    private List<Integer> getDAta(Supplier<Boolean> firstDataPull, Supplier<List<Integer>> roomsDataFull, Supplier<List<Integer>> roomsDataDifferntial) {
        List<Integer> roomsData;
        if (firstDataPull.get()) {
            roomsData = roomsDataFull.get();
        } else {
            roomsData = roomsDataDifferntial.get();
        }
        return roomsData;
    }

    private void addHeader(StringBuilder result) {
        result.append("Add header");
        result.append(": Add PropertyName");
    }

    private void addFooter(StringBuilder result, List<Integer> roomsData) {
        result.append(roomsData == null ? ": No Data" : ": Data:" + roomsData.toString());
        result.append(": Total rows-" + roomsData.size());
        result.append(": Add Footer");
    }


}
