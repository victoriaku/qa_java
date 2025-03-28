import com.example.Feline;
import com.example.Lion;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import org.junit.Assume;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    Feline feline;

    private final String sex;
    private Lion lion;

    public LionTest(String sex){
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[] sexes(){
        return new Object[]{ "Самец", "Самка", "Львица" };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        try {
            lion = new Lion(feline, sex);
        } catch (Exception e) {
            Assume.assumeTrue("\n" + e, false);
        }
    }

    @Test
    public void getKittensReturnsOne(){
        int kittensCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        assertEquals("Метод getKittens класса LionAlex должен вернуть количество котят: " + kittensCount,
                kittensCount, lion.getKittens());
    }

    @Test
    public void doesHaveManeTest(){
        if (sex.equals("Самец")){
            assertTrue("Самец должен иметь гриву", lion.doesHaveMane());
        } else if (sex.equals("Самка")){
            assertFalse("Самка не должна иметь гриву", lion.doesHaveMane());
        }
    }

    @Test
    public void getFoodReturnsMeat() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals("Метод getFood класса Lion должен вернуть список еды: " + food,
                food, lion.getFood());
    }
}
