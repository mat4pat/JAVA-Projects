public class NumberRandomizerMaxAndMin {

    /*
    This method generates random numbers, the numbers are between and include: max & min.
    If all numbers that have been generated have been generated ONLY ONCE, then return TRUE,
    if not return FALSE.
    Example NO.1: max=5, min=1, generated numbers: (5,1,2,4,3) - true.
    Example NO.2: max=6, min=2, generated numbers: (4,3,2,2,1,6) - false
     */

    public static boolean randomizeNumbersAndReturnResults(int max, int min) {

        int[] previousNumbers = new int [max*max*max];
        int[] RandomNumber = new int [max+(max-min)+1];
        int NumberWasTakenOnce=0;
        RandomNumber[0]=-1;

        for (int Index = max; Index <= max+(max-min); Index++) {

        RandomNumber[Index] = (int)Math.floor(Math.random()*(max-min+1)+min);

            //Check all previous generated numbers for duplicates
            //and assign the index place to previousNumbers
            for (int Index2=1; Index2 <= max; Index2++) {
                if (RandomNumber[Index - Index2] == RandomNumber[Index]) {
                    previousNumbers[Index]=Index-Index2;
                }
            }

            //Checking for previously found duplicates and checks them again,
            //if yes, then print out that it is a duplicate.
            if (RandomNumber[previousNumbers[Index]] == RandomNumber[Index]) {
                System.out.printf("RandomNumber[%d] = %d - dupe\n",Index-max,RandomNumber[Index]);
                NumberWasTakenOnce--;
            }
            //If not a duplicate, then print out a regular message of the
            //index of the array and its value & add 1 to NumberWasTakenOnce.
            else if (RandomNumber[Index] >= min && RandomNumber[Index] <= max) {
                System.out.printf("RandomNumber[%d] = %d\n",Index-max,RandomNumber[Index]);
                NumberWasTakenOnce++;
            }
        }
        //If all numbers were generated once return true
        if (NumberWasTakenOnce >= (max-min+1) ) {
            return true;
        }
        else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println("\nWere all the numbers generated only once? " + randomizeNumbersAndReturnResults(3,1));

    }
}
