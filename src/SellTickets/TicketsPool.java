package SellTickets;

public class TicketsPool {
    private int[][] pool = new int[10][10];

    //初始化票池
    public TicketsPool(){
        for(int r = 0; r<10; r++){
            for (int c = 0; c<10; c++){
                pool[r][c] = 0;
            }
        }
    }

    //判断是否已经预定，0为未预定，返回true，否则false
    public boolean if_booked(int r, int c){
        if(pool[r][c] == 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean if_over(int r, int c, int num){
        if(r<10 & r>=0 & c<10 & c>=0 & num<10 & num>0 & (c+num)<=10){
            return true;
        }else {
            return false;
        }
    }

    //r为第几行，c为第几列开始，num为往后连续几张
    public synchronized boolean to_book(int r, int c, int num){
        boolean access = true;

        if(if_over(r, c, num)){
            for(int i = 0; i<num; i++){
                if(!if_booked(r, c+i)){
                    access = false;
                }
            }

            if(access == true){
                for(int i = 0; i<num; i++){
                    pool[r][c+i] = 1;
                }
            }
        }
        this.notifyAll();
        return access;
    }
}
