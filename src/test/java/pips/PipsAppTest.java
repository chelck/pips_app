package pips;

import java.math.BigDecimal;
import org.junit.*;
import static org.junit.Assert.*;

public class PipsTest {

    @Test
    public void testFF_FFPPqq() {
        PipsApp app = new PipAapp();

        assertEquals(bd("0.000000"), app.pips.zero);
        assertEquals(bd("0.000001"), app.pips.epsilon);
        assertEquals(bd("0.000025"), app.pips.increment);
        assertEquals(bd("0.010000"), app.pips.oneBigFigure);
        assertEquals(bd("0.000100"), app.pips.onePip);

        assertEquals(bd("56.781000"), app.pips.normalize(bd("56.781")));

	assertTrue(app.pips.isValid(bd("56.781200")));
	assertTrue(app.pips.isValid(bd("56.781225")));
	assertFalse(app.pips.isValid(bd("56.781230")));

	assertTrue(app.pips.isValid(bd("-56.781200")));
	assertTrue(app.pips.isValid(bd("-56.781225")));
	assertFalse(app.pips.isValid(bd("-56.781230")));

	BigDecimal price = bd("56.781250");

        assertEquals(bd("0.001250"), app.pips.getApp.Pips(price));
        assertEquals(bd("56.780000"), app.pips.getBigFigure(price));

	assertEquals(bd("56.781275"), app.pips.up(price));
	assertEquals(bd("56.781375"), app.pips.up(price, 5));

	assertEquals("down", bd("56.781225"), app.pips.down(price));
	assertEquals("down+", bd("56.781125"), app.pips.down(price, 5));

	assertEquals(bd("0.001000"), app.pips.expandApp.Pips("1"));
	assertEquals(bd("0.001200"), app.pips.expandApp.Pips("12"));
	assertEquals(bd("0.001230"), app.pips.expandApp.Pips("123"));
	assertEquals(bd("0.001235"), app.pips.expandPips("1235"));
    }

    private BigDecimal bd(String s) {
        return new BigDecimal(s);
    }
}
