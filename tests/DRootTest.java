import org.junit.Test;

import static org.junit.Assert.*;

public class DRootTest {

    @Test
    public void digital_root() {
        assertEquals( "Nope!" , 7, DRoot.digital_root(16));
        assertEquals( "Nope!" , 6, DRoot.digital_root(456));
        assertEquals( "Nope!" , 6, DRoot.digital_root(51));
        assertEquals( "Nope!" , 0, DRoot.digital_root(0));
    }
}