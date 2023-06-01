package SellTickets;

public class One_Order {
    //记录每哥订单的信息
    public int r;
    public int c;
    public int num;
    public One_Order(int r, int c, int num){
        this.r = r;
        this.c = c;
        this.num = num;
    }

    public String toString(){
        return "第"+r+"行，第"+c+"号开始，连续"+num+"张票";
    }
}
