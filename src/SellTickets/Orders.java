package SellTickets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Orders {
    //包含所有订单
    LinkedList<One_Order> ordersList;

    public Orders(){
        ordersList = new LinkedList<>();
    }

    public synchronized One_Order pull(){
        while (ordersList.isEmpty()){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return ordersList.removeLast();
    }

    public void push(One_Order order){
        ordersList.add(order);
    }
}
