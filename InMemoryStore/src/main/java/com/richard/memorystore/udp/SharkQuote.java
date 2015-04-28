package com.richard.memorystore.udp;

public class SharkQuote {
    private String sharkName;
    private Double sharkRate;
    
    /**
     * @param sharkName
     * @param sharkRate
     */
    public SharkQuote(String sharkName, double sharkRate) {
        super();
        this.sharkName = sharkName;
        this.sharkRate = sharkRate;
    }
    /**
     * @return the sharkName
     */
    public String getSharkName() {
        return sharkName;
    }
    /**
     * @param sharkName the sharkName to set
     */
    public void setSharkName(String sharkName) {
        this.sharkName = sharkName;
    }
    /**
     * @return the sharkRate
     */
    public Double getSharkRate() {
        return sharkRate;
    }
    /**
     * @param sharkRate the sharkRate to set
     */
    public void setSharkRate(Double sharkRate) {
        this.sharkRate = sharkRate;
    }
}
