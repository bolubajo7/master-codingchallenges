import org.junit.Test;

import static org.junit.Assert.*;

public class CheckersMoveTest {

    @Test
    public void solution1() {
        String [] B = {"..X...","......","....X.",".X....","..X.X.","...O.."};
        assertEquals(2, new CheckersMove().solution(B));
    }

    @Test
    public void solution2() {
       String [] B = {"X....",".X...","..O..","...X.","....."};
       assertEquals(0, new CheckersMove().solution(B));
    }
}