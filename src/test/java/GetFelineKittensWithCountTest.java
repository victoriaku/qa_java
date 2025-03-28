import com.example.Feline;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetFelineKittensWithCountTest {

    private final int kittensCount;
    private Feline feline;

    public GetFelineKittensWithCountTest(int kittensCount){
        this.kittensCount = kittensCount;
        feline = new Feline();
    }

    @Parameterized.Parameters
    public static Object[] kittensCounts() {
        return new Object[]{ 0, 2, 10 };
    }

    @Test
    public void getKittensWithCountReturnsCount(){
        assertEquals(String.format("Метод getKittens с параметром %d класса Feline должен вернуть количество котят: %d",
                        kittensCount, kittensCount),
                kittensCount, feline.getKittens(kittensCount));
    }
}
