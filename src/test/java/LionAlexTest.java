import com.example.Feline;
import com.example.LionAlex;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Feline feline;

    private LionAlex lionAlex;

    @Before
    public void createAlex() throws Exception {
        lionAlex = new LionAlex(feline);
    }

    @Test
    public void getFriendsReturnsFriendsNames(){
        List<String> friends = List.of("Марти", "Глория", "Мелман");
        assertEquals("Метод getFriends класса LionAlex должен вернуть список друзей: " + friends,
                friends, lionAlex.getFriends());
    }
    
    @Test
    public void getPlaceOfLivingReturnsNewYorkZoo(){
        String place = "Нью-Йоркский зоопарк";
        assertEquals("Метод getPlaceOfLiving класса LionAlex должен вернуть место проживания: " + place,
                place, lionAlex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero(){
        int kittensCount = 0;
        assertEquals("Метод getKittens класса LionAlex должен вернуть количество котят: " + kittensCount,
                kittensCount, lionAlex.getKittens());
    }
}
