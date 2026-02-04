import org.example.SpringConfig;
import org.example.dao.TraineeDaoImpl;
import org.example.domain.Trainee;
import org.example.persistence.GymMap;;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GymCrmTest {

    private TraineeDaoImpl traineeDaoImpl;
    private GymMap gymMap;

    private Trainee trainee;

    @BeforeEach
    public void setup() {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class)) {
            traineeDaoImpl = applicationContext.getBean(TraineeDaoImpl.class);
            gymMap = applicationContext.getBean(GymMap.class);
        }

        trainee = new Trainee(
                "Jane",
                "Smith",
                true,
                "20-01-1990",
                "ocean street",
                3L
        );
    }

    @Test
    @DisplayName("Create Trainee")
    public void testCreateTrainee() {
        //ARRANGE

        //ACT
        traineeDaoImpl.create(trainee);

        //ASSERT
        assertEquals(gymMap.getGymMapTrainee().get(trainee.getUserId()), trainee, "Objects do not match");
    }

    @Test
    @DisplayName("Search for Duplicates")
    public void testSearchForDuplicates() {
        //ARRANGE
        gymMap.getGymMapTrainee().put(trainee.getUserId(), trainee);
        Trainee trainee2 = new Trainee(
                "Jane",
                "Smith",
                true,
                "20-01-1990",
                "ocean",
                4L
        );

        //ACT
        Trainee duplicateTrainee = traineeDaoImpl.searchDuplicates(trainee2);

        //ASSERT
        assertEquals(trainee.getUserName() + "1", duplicateTrainee.getUserName());
    }

    @Test
    @DisplayName("Select Trainee")
    public void testSelectTrainee() {
        //ARRANGE
        gymMap.getGymMapTrainee().put(trainee.getUserId(), trainee);

        //ACT
        Trainee selectedTrainee = traineeDaoImpl.select(trainee.getUserId());

        //ASSERT
        assertEquals(trainee.getUserId(), selectedTrainee.getUserId());
    }

    @Test
    @DisplayName("Remove Trainee")
    public void testRemoveTrainee() {
        //ARRANGE
        gymMap.getGymMapTrainee().put(trainee.getUserId(), trainee);

        //ACT
        Trainee removedTrainee = traineeDaoImpl.delete(trainee.getUserId());

        //ASSERT
        assertEquals(trainee.getUserId(), removedTrainee.getUserId());
    }

    @Test
    @DisplayName("Update Trainee")
    public void testUpdateTrainee() {
        //ARRANGE
        gymMap.getGymMapTrainee().put(trainee.getUserId(), trainee);
        Trainee trainee2 = new Trainee(
                "Jane",
                "Smith",
                true,
                "20-01-1990",
                "smith street",
                3L
        );

        //ACT
        traineeDaoImpl.update(trainee2);

        //ASSERT
        assertEquals(trainee2.getAddress(), gymMap.getGymMapTrainee().get(3L).getAddress());
    }
}
