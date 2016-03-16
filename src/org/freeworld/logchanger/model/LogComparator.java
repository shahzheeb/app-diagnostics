package org.freeworld.logchanger.model;

import java.util.Comparator;

public class LogComparator implements Comparator<LogData> {

    public int compare(LogData obj1, LogData obj2) {
        if (obj1 == obj2) {
            return 0;
        }
        if (obj1 == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return obj1.compareTo(obj2);
    }

}
