package testing.forum.statistics;

import com.kodilla.testing.forum.statistics.StatisticCalculator;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    private StatisticCalculator statisticCalculator;

    @BeforeEach
    void before() {
        statisticCalculator = new StatisticCalculator();
    }

    private List<String> generateUsers(int usersCount) {
        List<String> users = new ArrayList<>();
        for (int n = 1; n <= usersCount; n++ ){
            users.add("User" + n);
        }
        return users;
    }

    @Test
    void testAvgIf0Posts() {

        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);

        statisticCalculator.calculateAdvStatistics(statisticsMock);

        assertEquals(0.0, statisticCalculator.getAvgPostsPerUser(), 0.0001);
        assertEquals(0.1, statisticCalculator.getAvgCommentsPerUser(), 0.0001);
        assertEquals(0.0, statisticCalculator.getAvgCommentsPerPost(), 0.0001);
    }

    @Test
    void testAvgIf1000Posts() {

        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);

        statisticCalculator.calculateAdvStatistics(statisticsMock);

        assertEquals(10.0, statisticCalculator.getAvgPostsPerUser(), 0.0001);
        assertEquals(0.1, statisticCalculator.getAvgCommentsPerUser(), 0.0001);
        assertEquals(0.01, statisticCalculator.getAvgCommentsPerPost(), 0.0001);
    }

    @Test
    void testAvgIf0Comments() {
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);

        statisticCalculator.calculateAdvStatistics(statisticsMock);

        assertEquals(10.0, statisticCalculator.getAvgPostsPerUser(), 0.0001);
        assertEquals(0.0, statisticCalculator.getAvgCommentsPerUser(), 0.0001);
        assertEquals(0.0, statisticCalculator.getAvgCommentsPerPost(), 0.0001);
    }

    @Test
    void testAvgIfPostGreater() {
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);

        statisticCalculator.calculateAdvStatistics(statisticsMock);

        assertEquals(10.0, statisticCalculator.getAvgPostsPerUser(), 0.0001);
        assertEquals(1.0, statisticCalculator.getAvgCommentsPerUser(), 0.0001);
        assertEquals(0.1, statisticCalculator.getAvgCommentsPerPost(), 0.0001);
    }

    @Test
    void testAvgIfCommentsGreater() {
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        statisticCalculator.calculateAdvStatistics(statisticsMock);

        assertEquals(1.0, statisticCalculator.getAvgPostsPerUser(), 0.0001);
        assertEquals(10.0, statisticCalculator.getAvgCommentsPerUser(), 0.0001);
        assertEquals(10.0, statisticCalculator.getAvgCommentsPerPost(), 0.0001);
    }

    @Test
    void testAvgIf0Users() {
        when(statisticsMock.usersNames()).thenReturn(generateUsers(0));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        statisticCalculator.calculateAdvStatistics(statisticsMock);

        assertEquals(0.0, statisticCalculator.getAvgPostsPerUser(), 0.0001);
        assertEquals(0.0, statisticCalculator.getAvgCommentsPerUser(), 0.0001);
        assertEquals(10.0, statisticCalculator.getAvgCommentsPerPost(), 0.0001);
    }

    @Test
    void testAvgIf100Users() {
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        statisticCalculator.calculateAdvStatistics(statisticsMock);

        assertEquals(1.0, statisticCalculator.getAvgPostsPerUser(), 0.0001);
        assertEquals(10.0, statisticCalculator.getAvgCommentsPerUser(), 0.0001);
        assertEquals(10.0, statisticCalculator.getAvgCommentsPerPost(), 0.0001);
    }
}
