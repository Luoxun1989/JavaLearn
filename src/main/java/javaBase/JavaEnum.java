package javaBase;

/**
 * “Go Further进无止境” <br>
 * 〈〉
 *
 * @author Luoxun
 * @create 2020/4/26
 * @since 1.0.0
 */
public class JavaEnum {
    public static void main(String[] args) {
        System.out.println(PizzaStatus.ORDERED.name());//ORDERED
        System.out.println(PizzaStatus.DELIVERED);//ORDERED
        System.out.println(PizzaStatus.ORDERED.name().getClass());//class java.lang.String
        System.out.println(PizzaStatus.READY.getClass());//class shuang.kou.enumdemo.enumtest.PizzaStatus

        JavaEnum testPz = new JavaEnum();
        testPz.setStatus(JavaEnum.PizzaStatus.READY);
//        assertTrue(testPz.isDeliverable());
    }
    private PizzaStatus status;

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    enum PizzaStatus {
        ORDERED(5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public PizzaStatus getStatus() {
        return this.status;
    }
    /*public Boolean isDelivered(){
        if (getStatus() == PizzaStatus.DELIVERED){
            return true;
        }
        return false;
    }*/
    public boolean isDeliverable() {
        return this.status.isReady();
    }

}
