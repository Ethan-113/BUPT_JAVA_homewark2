package SellTickets;

public class Main {
    public static void main(String[] args){
        TicketsPool ticketsPool = new TicketsPool();
        Orders orders = new Orders();

        //往订单列表中加入订单
        for(int i = 0; i<10; i++){
            orders.push(new One_Order(i, 0, 3));
        }
        for (int i = 0; i<10; i++){
            orders.push(new One_Order(i, 5, 2));
        }
        orders.push(new One_Order(3, 9, 1));
        orders.push(new One_Order(6, 2, 4));
        orders.push(new One_Order(2, 4, 1));
        orders.push(new One_Order(7, 8, 2));
        orders.push(new One_Order(9, 9, 1));

        new SaleThread(orders, ticketsPool, "销售点一").start();
        new SaleThread(orders, ticketsPool, "销售点二").start();
        new SaleThread(orders, ticketsPool, "销售点三").start();
    }
}
