import com.example.Feline;
import com.example.Lion;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    private Lion lion;

    @Before
    public void createLion() throws Exception {
        lion = new Lion(feline, "Самец");
    }

    @Test
    public void getKittensReturnsOne(){
        int kittensCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        assertEquals("Метод getKittens класса Lion должен вернуть количество котят: " + kittensCount,
                kittensCount, lion.getKittens());
    }

    @Test
    public void getFoodReturnsMeat() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals("Метод getFood класса Lion должен вернуть список еды: " + food,
                food, lion.getFood());
    }
}
