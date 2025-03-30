import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    private Feline feline = new Feline();

    @Test
    public void eatMeatReturnsMeat() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
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
        assertEquals("Метод getKittens без параметров класса Feline должен вернуть количество котят: " + count,
                count, feline.getKittens());
    }
}
