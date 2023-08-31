package player;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerAnalyzerTest {

    private final PlayerAnalyzer playerAnalyzer = new PlayerAnalyzer();

    private final static Player NORMAL_PLAYER = new Player();

    private final static Player JUNIOR_PLAYER = new Player();

    private final static Player SENIOR_PLAYER = new Player();

    private final static double NORMAL_PLAYER_SCORE = 250;

    private final static double JUNIOR_PLAYER_SCORE = 67.5;

    private final static double SENIOR_PLAYER_SCORE = 2520;

    @BeforeAll
    static void setUp() {
        NORMAL_PLAYER.setAge(25);
        NORMAL_PLAYER.setExperience(5);
        NORMAL_PLAYER.setSkills(List.of(2, 2, 2));

        JUNIOR_PLAYER.setAge(15);
        JUNIOR_PLAYER.setExperience(3);
        JUNIOR_PLAYER.setSkills(List.of(3, 3, 3));

        SENIOR_PLAYER.setAge(35);
        SENIOR_PLAYER.setExperience(15);
        SENIOR_PLAYER.setSkills(List.of(4, 4, 4));
    }

    @Test
    void NormalPlayerTest() {
        assertEquals(NORMAL_PLAYER_SCORE, playerAnalyzer.calculateScore(List.of(NORMAL_PLAYER)));
    }

    @Test
    void JuniorPlayerTest() {
        assertEquals(JUNIOR_PLAYER_SCORE, playerAnalyzer.calculateScore(List.of(JUNIOR_PLAYER)));
    }

    @Test
    void SeniorPlayerTest() {
        assertEquals(SENIOR_PLAYER_SCORE, playerAnalyzer.calculateScore(List.of(SENIOR_PLAYER)));
    }

    @Test
    void MultiplePlayersTest() {
        assertEquals(NORMAL_PLAYER_SCORE + JUNIOR_PLAYER_SCORE + SENIOR_PLAYER_SCORE,
                playerAnalyzer.calculateScore(List.of(NORMAL_PLAYER, JUNIOR_PLAYER, SENIOR_PLAYER)));
    }

    @Test
    void NullSkillsTest() {
        Player player = new Player();
        player.setSkills(null);
        List<Player> players = List.of(player);
        assertThrows(RuntimeException.class, () -> playerAnalyzer.calculateScore(players));
    }

    @Test
    void EmptyListTest() {
        assertEquals(0, playerAnalyzer.calculateScore(List.of()));
    }
}
