package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService (MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, int userId) {
        return repository.save(userId, meal);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public Meal get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public void update(Meal meal, int userId) {
        checkNotFoundWithId(repository.save(userId, meal), meal.getId());
    }

    public List<MealTo> getAll(int userId, int calories) {
        return MealsUtil.getTos(repository.getAll(userId), calories);
    }

    public List<MealTo> getAllByDate(int UserId, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, int calories) {
        final List<Meal> allByDate = repository.getAllByDate(UserId, DateTimeUtil.getDateOrMin(startDate), DateTimeUtil.getDateOrMax(endDate));
        return MealsUtil.getFilteredTos(allByDate, calories, startTime, endTime);
    }
}