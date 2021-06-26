package mat4pat;

import org.junit.Test;

public class CreateObjectsHere {

    //For each object that is created add on to numOfObjectsCreated.

    @Test
    public static boolean returnRandomizedNumbers(int max,int minimum) {

            NumberRandomizer object = new NumberRandomizer();
            NumberRandomizer object2 = new NumberRandomizer();
            NumberRandomizer object3 = new NumberRandomizer();
            NumberRandomizer object4 = new NumberRandomizer();

        //The range of the randomly generated numbers will be based on two factors:
        //1. How many objects were created in class NumberRandomizer - max
        //2. User input - min
        return NumberRandomizer.randomizeNumbersAndReturnResults(NumberRandomizer.numOfObjectsCreated, minimum);
    }

    public static void main(String[] args) {
        System.out.print("Were all numbers been chosen only once ? " + returnRandomizedNumbers(NumberRandomizer.numOfObjectsCreated, 1));
    }
}
