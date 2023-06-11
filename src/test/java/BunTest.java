import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void testGetBunName() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        bun.getName();
        Assert.assertEquals("Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        bun.getPrice();
        Assert.assertEquals(988, bun.getPrice(), 0);
    }
}
