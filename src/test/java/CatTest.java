import com.example.Feline;
import com.example.Cat;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    private Cat cat;

    @Before
    public void createCat(){
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow(){
        String catsSound = "Мяу";
        assertEquals("Метод getSound класса Cat должен вернуть: " + catsSound,
                catsSound, cat.getSound());
    }

    @Test
    public void getFoodReturnsMeat() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        assertEquals("Метод getFood класса Cat должен вернуть список еды: " + food,
                food, cat.getFood());
    }
}
