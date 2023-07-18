package quiz.q06.q626;

public class bfDto {
    private bfDto() { }
    private long start, end, total;
    private static bfDto instance;

    public static bfDto getInstance() {
        if (instance == null) instance = new bfDto();

        return instance;
    }

    public long getStart() { return start; }
    public void setStart(long start) { this.start = start; }

    public long getEnd() { return end; }
    public void setEnd(long end) { this.end = end; }

    public long getTotal() { return total; }
    public void setTotal(long total) { this.total = total; }
}
