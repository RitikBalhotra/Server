package com.Rb.Controller;

public class Testing {
    public static void main(String[] args) {

        for (int i=1;i<=10;i++){
            System.out.println("final Stage before Add id Into Db : "+idGenerator("Car"));
            System.out.println("====================================");
        }
    }
    public static int idGenerator(String name) {
        int GT_ID=getId();
        if (name.equals("Car")) {

            System.out.println("inside IdGeneratorMethod : "+GT_ID);
            int DB_ID = 1868617;
            if (DB_ID==GT_ID) {
                System.out.println("inside if condition"+GT_ID);
                while(DB_ID!=GT_ID){
                    GT_ID=getId();

                }
                return GT_ID;
            }
            return GT_ID;
        } else if (name.equals("User")) {
            return 0;
        } else {
            return 0;
        }


    }

    public static int getId(){
        double id=0;
        for (int i=1;i<=20;i++){
            double random= Math.random();
            id=1868617+random;
        }
        System.out.println("Inside getId Method : "+id);
        return Integer.valueOf((int) id);
    }
}
