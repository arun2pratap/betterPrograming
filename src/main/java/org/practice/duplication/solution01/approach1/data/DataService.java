package org.practice.duplication.solution01.approach1.data;

import java.util.List;

public interface DataService {
    List<Integer> getDataFull();

    boolean isFirstDataPull();

    List<Integer> getDataDifferential();
}
