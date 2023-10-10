package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealStorage {

    Meal save(Meal meal);

    Meal read(int id);

    List<Meal> readAll();

    void delete(int id);
}
