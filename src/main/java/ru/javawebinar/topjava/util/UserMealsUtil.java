package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field
        return clamsyWay(mealList, startTime, endTime, caloriesPerDay);
    }


    private static List<UserMealWithExceed>  clamsyWay(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        //самый очевидный способ (на мой взгляд).
        // Единственное, что выполнил - сложность алгоритма O(n), но коэффициент ~ 3 и куча дополнительных объектов.
        //но результат правильный
        //попробовал использовать stream для группировки но получается в 1.5 раза дольше
        //для 10E7 значений в случае обычного цикла - 4.5сек, для stream - 6.6сек
//        Map<LocalDate, List<UserMeal>> map = mealList.stream().collect(Collectors.groupingBy(user -> user.getDateTime().toLocalDate()));
        Map<LocalDate, List<UserMeal>> map = new HashMap<>();
        for (UserMeal userMeal : mealList) {
            List<UserMeal> list;
            if (!map.containsKey(userMeal.getDateTime().toLocalDate())) {
                list = new ArrayList<>();
                list.add(userMeal);
                map.put(userMeal.getDateTime().toLocalDate(), list);
            } else {
                list = map.get(userMeal.getDateTime().toLocalDate());
                list.add(userMeal);
            }
        }
        List<UserMealWithExceed> resultList = new ArrayList<>();
        for (Map.Entry<LocalDate, List<UserMeal>> entry : map.entrySet()) {
            int sum = 0;
            for (UserMeal userMeal : entry.getValue()) {
                sum += userMeal.getCalories();
            }
            boolean exceed = false;
            if (sum > caloriesPerDay) exceed = true;
            for (UserMeal meal : entry.getValue()) {
                if (TimeUtil.isBetween(meal.getDateTime().toLocalTime(), startTime, endTime))
                    resultList.add(new UserMealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(), exceed));
            }

        }
        return resultList;
    }
}
