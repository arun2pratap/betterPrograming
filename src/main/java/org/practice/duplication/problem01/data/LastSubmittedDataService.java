package org.practice.duplication.problem01.data;

import java.util.Collections;
import java.util.List;

public class LastSubmittedDataService {


    public boolean isFirstDataPull() {
        return false;
    }

    public List<Integer> getLastSubmittedDataFull() {
        return Collections.emptyList();
    }

    public List<Integer> getLastSubmittedDifferntial() {
        return Collections.emptyList();
    }
}
