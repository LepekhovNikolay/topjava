package ru.javawebinar.topjava;

import org.assertj.core.api.Assertions;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final int MEAL1_USER_ID = START_SEQ + 2;
    public static final int MEAL2_USER_ID = START_SEQ + 3;
    public static final int MEAL3_USER_ID = START_SEQ + 4;
    public static final int MEAL4_USER_ID = START_SEQ + 5;
    public static final int MEAL5_USER_ID = START_SEQ + 6;
    public static final int MEAL6_USER_ID = START_SEQ + 7;

    public static final Meal MEAL1_USER = new Meal(MEAL1_USER_ID, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500);
    public static final Meal MEAL2_USER = new Meal(MEAL2_USER_ID, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000);
    public static final Meal MEAL3_USER = new Meal(MEAL3_USER_ID, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500);
    public static final Meal MEAL4_USER = new Meal(MEAL4_USER_ID, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000);
    public static final Meal MEAL5_USER = new Meal(MEAL5_USER_ID, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500);
    public static final Meal MEAL6_USER = new Meal(MEAL6_USER_ID, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        Arrays.sort(expected, Comparator.comparing(Meal::getDateTime).reversed());
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual)
    }
}
