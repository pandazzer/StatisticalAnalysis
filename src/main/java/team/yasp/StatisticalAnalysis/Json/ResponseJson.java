package team.yasp.StatisticalAnalysis.Json;

public class ResponseJson {
    private String min;
    private String max;
    private String count;

    public ResponseJson(String min, String max, String count) {
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
