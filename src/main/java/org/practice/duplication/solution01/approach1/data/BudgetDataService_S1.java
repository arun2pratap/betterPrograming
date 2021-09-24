package org.practice.duplication.solution01.approach1.data;

import java.util.Collections;
import java.util.List;

public class BudgetDataService_S1 implements DataService{

    @Override
    public boolean isFirstDataPull() {
        return false;
    }
@Override
    public List<Integer> getDataFull() {
        return Collections.emptyList();
    }
@Override
    public List<Integer> getDataDifferential() {
        return Collections.emptyList();
    }
}
