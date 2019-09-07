import org.junit.Test;

import static org.junit.Assert.*;

public class FlightTurbulenceTest {

    @Test
    public void solution1() {
        int [] numArray = {9,4,2,10,7,8,8,1,9};
        assertEquals(5, new FlightTurbulence().solution(numArray));
    }

    @Test
    public void solution2() {
        int [] numArray = {4,8,12,16};
        assertEquals(2, new FlightTurbulence().solution(numArray));
    }


    @Test
    public void solution3() {
        int [] numArray = {100};
        assertEquals(1, new FlightTurbulence().solution(numArray));
    }

    @Test
    public void solution4() {
        int [] numArray = {1,2,1,2,1};
        assertEquals(5, new FlightTurbulence().solution(numArray));
    }

}