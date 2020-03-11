import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String expected = hamletText;
        String actual = hamletParser.changeHamletToLeon(expected);
        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = hamletText;
        String actual = hamletParser.changeHoratioToTariq(expected);
        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void testFindHoratio() {
        boolean actual = hamletParser.findHoratio(hamletText);
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        boolean actual = hamletParser.findHamlet(hamletText);
        Assert.assertTrue(actual);
    }
}