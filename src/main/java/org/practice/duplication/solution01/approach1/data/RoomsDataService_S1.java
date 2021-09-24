package org.practice.duplication.solution01.approach1.data;

import java.util.Collections;
import java.util.List;

public class RoomsDataService_S1 implements DataService {

    @Override
    public List<Integer> getDataFull() {
        return List.of(0);
    }

    @Override
    public boolean isFirstDataPull() {
        return false;
    }

    @Override
    public List<Integer> getDataDifferential() {
        return Collections.emptyList();
    }

}
