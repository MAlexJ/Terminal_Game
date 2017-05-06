/**
 * @author malex
 */
public class Controller {


    /**
     * Player the action
     *
     * @param x coordinate X
     * @param y coordinate Y
     */
    public static void setStep(int x, int y) {

        // check coordinate X
        if (x > 1 || x < -1) {
            throw new IllegalArgumentException("Incorrect coordinate x");
        }

        // check coordinate y
        if (y > 1 || y < -1) {
            throw new IllegalArgumentException("Incorrect coordinate x");
        }

        int[][] arr = Memory.arr;

        int x1;
        int y1;

        // coordinate point
        int x_memory = 0;
        int y_memory = 0;

        // find coordinate
        for (x1 = arr.length - 1; x1 >= 0; x1--) {
            for (y1 = 0; y1 < arr.length; y1++) {
                if (arr[x1][y1] == Constant.PLAYER) {
                    x_memory = x1;
                    y_memory = y1;
                }
            }
        }

        // Movement at the coordinates X+
        if (x > Constant.START_POSITION && y == Constant.START_POSITION) {
            int new_coordinate = x_memory + x;
            if (new_coordinate < arr.length) {
                arr[new_coordinate][y_memory] = Constant.PLAYER;
                arr[x_memory][y_memory] = Constant.EMPTY_FIELD;
            }
        }

        // Movement at the coordinates X-
        if (x < Constant.START_POSITION && y == Constant.START_POSITION) {
            int new_coordinate = x_memory + x;

            // start coordinate
            if (x_memory == Constant.START_POSITION) {
                return;
            }

            if (new_coordinate > Constant.START_POSITION) {
                arr[new_coordinate][y_memory] = Constant.PLAYER;
            } else {
                arr[Constant.START_POSITION][y_memory] = Constant.PLAYER;
            }
            arr[x_memory][y_memory] = Constant.EMPTY_FIELD;
        }

        // Movement at the coordinates Y+
        if (y > Constant.START_POSITION && x == Constant.START_POSITION) {
            int new_coordinate = y_memory + y;
            if (new_coordinate < arr.length) {
                arr[x_memory][new_coordinate] = Constant.PLAYER;
                arr[x_memory][y_memory] = Constant.EMPTY_FIELD;
            }
        }

        // Movement at the coordinates Y-
        if (y < Constant.START_POSITION && x == Constant.START_POSITION) {
            int new_coordinate = y_memory + y;

            // start position
            if (y_memory == Constant.START_POSITION) {
                return;
            }

            // set new position
            if (new_coordinate > Constant.START_POSITION) {
                arr[x_memory][new_coordinate] = Constant.PLAYER;
            } else {
                arr[x_memory][Constant.START_POSITION] = Constant.PLAYER;
            }
            arr[x_memory][y_memory] = Constant.EMPTY_FIELD;

        }

    }


    /**
     * Display array
     */
    public static void display() {
        int[][] arr = Memory.arr;
        int x;
        int y;
        for (x = arr.length - 1; x >= 0; x--) {
            for (y = 0; y < arr.length; y++) {
                System.out.print(arr[y][x] + " ");
            }
            System.out.println();
        }

    }

}
