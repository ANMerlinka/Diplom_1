import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private String bunName;
    private float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name="Bun Name = {0}, Price = {1}")
    public static Object[][] data(){
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Мегагалактическая вселенско-масштабная булочка с кунжутом", 250},
                {"@Флюоресцентная булка R2-D3_¯\\_(ツ)_/¯!", 250},
                {"", 250},
                {null, 250},
                {"Мегагалактическая вселенско-масштабная булочка с кунжутом", 299.99f},
                {"Флюоресцентная булка R2-D3", 0},
                {"Флюоресцентная булка R2-D3", -988},
                {"Флюоресцентная булка R2-D3", Float.MAX_VALUE},
                {"Флюоресцентная булка R2-D3", -Float.MAX_VALUE},
        };
    }

    @Test
    public void testGetBunName() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), 0.00f);
    }
}
