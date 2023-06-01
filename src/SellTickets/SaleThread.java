package SellTickets;

public class SaleThread extends Thread{
    private Orders orders;
    private TicketsPool ticketsPool;

    public SaleThread(Orders orders, TicketsPool ticketsPool, String name){
        super(name);
        this.orders = orders;
        this.ticketsPool = ticketsPool;
    }

    public void run(){
        while (true){
            One_Order order = orders.pull();
            boolean access = ticketsPool.to_book(order.r, order.c, order.num);
            if(access){
                System.out.println(this.getName()+"售出："+order);
            }else {
                System.out.println(this.getName()+"处理订单："+order+"失败，有座位已经售出");
            }
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
