import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void testSetStep() {

        // Coordinate x
        Controller.setStep(1, 0);
        Controller.setStep(0, 0);
        Controller.setStep(-1, 0);

        // Coordinate Y
        Controller.setStep(0, 1);
        Controller.setStep(0, 0);
        Controller.setStep(0, -1);

        // Coordinate X, Y
        Controller.setStep(-1, 1);
        Controller.setStep(1, -1);

    }

    @Test
    public void failTest() {

        // Coordinate X
        setCoordinateFail(2, 0);
        setCoordinateFail(-2, 0);
        setCoordinateFail(10, 0);
        setCoordinateFail(-10, 0);

        // Coordinate Y
        setCoordinateFail(0, -2);
        setCoordinateFail(0, 2);
        setCoordinateFail(1, 10);
        setCoordinateFail(1, -12);

    }

    @Test
    public void moveToCoordinateX() {

        // set player
        Memory.arr[0][0] = Constant.PLAYER;

        //**************** POSITIVE X ******************

        // step 1
        Controller.setStep(1, 0);
        assertEquals(Memory.arr[1][0], Constant.PLAYER);

        // step 2
        Controller.setStep(1, 0);
        assertEquals(Memory.arr[2][0], Constant.PLAYER);

        // step 3
        Controller.setStep(1, 0);
        assertEquals(Memory.arr[3][0], Constant.PLAYER);

        // step 4
        Controller.setStep(1, 0);
        assertEquals(Memory.arr[3][0], Constant.PLAYER);

        //**************** NEGATIVE X ******************

        // set player
        Memory.arr[0][0] = Constant.PLAYER;

        // step 1
        Controller.setStep(-1, 0);
        assertEquals(Memory.arr[0][0], Constant.PLAYER);

        // step 2
        Controller.setStep(1, 0);
        assertEquals(Memory.arr[1][0], Constant.PLAYER);

        // step 3
        Controller.setStep(-1, 0);
        assertEquals(Memory.arr[0][0], Constant.PLAYER);

        // set player
        Memory.arr[0][0] = Constant.PLAYER;

        Controller.setStep(1, 0);
        Controller.setStep(1, 0);
        Controller.setStep(1, 0);

        Controller.setStep(-1, 0);
        assertEquals(Memory.arr[2][0], Constant.PLAYER);

        Controller.setStep(-1, 0);
        assertEquals(Memory.arr[1][0], Constant.PLAYER);

        Controller.setStep(-1, 0);
        assertEquals(Memory.arr[0][0], Constant.PLAYER);
    }

    @Test
    public void moveToCoordinateY() {

        // set player
        Memory.arr[0][0] = Constant.PLAYER;

        //**************** POSITIVE Y ******************

        // step 1
        Controller.setStep(0, 1);
        assertEquals(Memory.arr[0][1], Constant.PLAYER);

        // step 2
        Controller.setStep(0, 1);
        assertEquals(Memory.arr[0][2], Constant.PLAYER);

        // step 3
        Controller.setStep(0, 1);
        assertEquals(Memory.arr[0][3], Constant.PLAYER);

        // step 3
        Controller.setStep(0, 1);
        assertEquals(Memory.arr[0][3], Constant.PLAYER);

        //**************** NEGATIVE Y ******************

        // set player
        Memory.arr[0][0] = Constant.PLAYER;



    }

    // **************** UTIL **********************

    // fail test
    private void setCoordinateFail(int x, int y) {
        try {
            Controller.setStep(x, y);
            fail();
        } catch (IllegalArgumentException ex) {
            // ignore
        }
    }
}