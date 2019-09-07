public class FlightTurbulence {
    private int turbulenceCount;
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        if(A.length == 1) {
            result = 1;
        }
        else {
            checkForTurbulence(A);
        }
        return result;
    }

    private void checkForTurbulence(int [] A) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] < A[i + 1]) {

            }
        }

    }

}
