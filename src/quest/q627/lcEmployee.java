package quest.q627;

public class lcEmployee extends lcCompany {
    private int empNum;
    private String empName;
    private int price;
    private long start, end, total;

    public int getEmpNum() { return empNum; }
    public void setEmpNum(int empNum) { this.empNum = empNum; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public long getStart() { return start; }
    public void setStart(long start) { this.start = start; }

    public long getEnd() { return end;}
    public void setEnd(long end) { this.end = end;}

    public long getTotal() { return total; }
    public void setTotal(long total) { this.total = total; }
}
