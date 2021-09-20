package org.practice.refactor.duplication.data;

import java.util.Collections;
import java.util.List;

public class LastSubmittedDataService {


    public boolean isDataChange() {
        return false;
    }

    public List<Integer> getLastSubmittedDataFull() {
        return Collections.emptyList();
    }

    public List<Integer> getLastSubmittedDifferntial() {
        return Collections.emptyList();
    }
}
