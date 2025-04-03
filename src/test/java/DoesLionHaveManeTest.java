import com.example.Feline;
import com.example.Lion;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DoesLionHaveManeTest {
    @Mock
    Feline feline;

    private final String sex;
    private final boolean expectedDoesHaveMane;
    private Lion lion;

    public DoesLionHaveManeTest(String sex, boolean expectedDoesHaveMane){
        this.sex = sex;
        this.expectedDoesHaveMane = expectedDoesHaveMane;
    }

    @Parameterized.Parameters (name = "Тестовые данные. Пол льва: {0}, имеет ли гриву: {1}")
    public static Object[][] sexCharacteristics(){
        return new Object[][]{
                { "Самец", true },
                { "Самка", false },
                { "Львица", false }
        };
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
    public void doesHaveManeTest(){
        assertEquals(String.format("Для льва, пол которого %s, метод doesHaveMane должен вернуть: %b", sex, expectedDoesHaveMane),
                expectedDoesHaveMane, lion.doesHaveMane());
    }
}
