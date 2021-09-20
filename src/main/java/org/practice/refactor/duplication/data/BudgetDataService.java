package org.practice.refactor.duplication.data;

import java.util.Collections;
import java.util.List;

public class BudgetDataService {

    public boolean isDataChange() {
        return false;
    }

    public List<Integer> getBudgetDataFull() {
        return Collections.emptyList();
    }

    public List<Integer> getBudgetDataDifferntial() {
        return Collections.emptyList();
    }
}
