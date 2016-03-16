package org.freeworld.logchanger.model;

public class LogData implements Comparable<LogData>{
    
    private String logger;
    private String logLevel;
    
    public String getLogger() {
        return logger;
    }
    public void setLogger(String logger) {
        this.logger = logger;
    }
    public String getLogLevel() {
        return logLevel;
    }
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
    public int compareTo(LogData o) {
        String logger = ((LogData) o).getLogger(); 
        int result = logger.compareTo(this.logger);
        return result;
    }
    
    
    

}
