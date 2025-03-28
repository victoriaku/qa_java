import com.example.Feline;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Spy;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnsMeat() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals("Метод eatMeat класса Feline должен вернуть список еды: " + food,
                food, feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFeline(){
        String family = "Кошачьи";
        assertEquals("Метод getFamily класса Feline должен вернуть семейство: " + family,
                family, feline.getFamily());
    }

    @Test
    public void getKittensWithoutCountReturnsOne(){
        int count = 1;
        Mockito.when(feline.getKittens(count)).thenReturn(count);
        assertEquals("Метод getKittens без параметров класса Feline должен вернуть количество котят: " + count,
                count, feline.getKittens());
    }
}
