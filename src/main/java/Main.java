/**
 * @author malex
 */
public class Main {

    public static void main(String[] args) {

        int[][] arr = Memory.arr;
        arr[0][0] = Constant.PLAYER;
        Controller.display();                                         System.out.println();

        Controller.setStep(0,-1);       Controller.display();         System.out.println();

        Controller.setStep(0,1);       Controller.display();         System.out.println();
        Controller.setStep(0,1);       Controller.display();         System.out.println();
        Controller.setStep(0,1);       Controller.display();         System.out.println();

        Controller.setStep(0,-1);       Controller.display();            System.out.println();
        Controller.setStep(0,-1);       Controller.display();            System.out.println();
        Controller.setStep(0,-1);       Controller.display();            System.out.println();
        Controller.setStep(0,-1);       Controller.display();            System.out.println();



    }


}
