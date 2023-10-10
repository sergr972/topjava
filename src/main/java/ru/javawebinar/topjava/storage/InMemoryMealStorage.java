package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMealStorage implements MealStorage {
    private final Map<Integer, Meal> mealStorage = new ConcurrentHashMap<>();
    private final AtomicInteger count = new AtomicInteger(0);

    {
        MealsUtil.getMealList().forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.getId() == null) {
            meal.setId(count.incrementAndGet());
            mealStorage.put((meal.getId()), meal);
            return meal;
        }
        return mealStorage.computeIfPresent(meal.getId(), (id, old) -> meal);
    }

    @Override
    public Meal read(int id) {
        return mealStorage.get(id);
    }

    @Override
    public List<Meal> readAll() {
        return new ArrayList<>(mealStorage.values());
    }

    @Override
    public void delete(int id) {
        mealStorage.remove(id);
    }
}
