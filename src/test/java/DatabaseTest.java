import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

public class DatabaseTest {
    private Database database = new Database();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAvailableBuns() {
        List<Bun> buns = database.availableBuns();
        Assert.assertFalse(buns.isEmpty());
    }

    @Test
    public void testAvailableIngredients(){
        List<Ingredient> ingredients = database.availableIngredients();
        Assert.assertFalse(ingredients.isEmpty());
    }

}
