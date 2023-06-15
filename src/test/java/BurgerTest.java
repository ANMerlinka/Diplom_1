import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    praktikum.Burger burger = new praktikum.Burger();

    @Test
    public void testAddIngredients(){
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient(){
        Ingredient ingredientFirst = new Ingredient(SAUCE, "Соус фирменный Space Sauce", 80);
        Ingredient ingredientSecond = new Ingredient(FILLING, "Филе Люминесцентного тетраодонтимформа", 988);

        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(1, 0);

        Assert.assertEquals(ingredientSecond.name, burger.ingredients.get(0).name);
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        float price = 80;
        Mockito.when(bun.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        Assert.assertEquals(price * 2, burger.getPrice(), 0);
    }


    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        String expectedReceipt = "(==== Флюоресцентная булка R2-D3 ====)\n" +
                "= sauce Соус фирменный Space Sauce =\n" +
                "= filling Филе Люминесцентного тетраодонтимформа =\n" +
                "(==== Флюоресцентная булка R2-D3 ====)\n" +
                "\n" +
                "Price: 3044,000000\n";

        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988));
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        burger.setBuns(bun);

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
