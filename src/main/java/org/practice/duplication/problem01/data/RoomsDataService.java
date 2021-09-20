package org.practice.duplication.problem01.data;

import java.util.Collections;
import java.util.List;

public class RoomsDataService {

    public List<Integer> getRoomsDataFull(){
        return List.of(0);
    }

    public boolean isDataChange() {
        return false;
    }

    public List<Integer> getRoomsDataDifferntial() {
        return Collections.emptyList();
    }
}
