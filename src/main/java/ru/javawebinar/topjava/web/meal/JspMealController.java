package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDate;
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTime;

@Controller
@RequestMapping("/meals")
public class JspMealController extends AbstractMealController {
    private static final Logger log = LoggerFactory.getLogger(JspMealController.class);

    public JspMealController(MealService service) {
        super(service);
    }

    @GetMapping()
    public String getMeals(Model model) {
        log.info("meals");
        model.addAttribute("meals", super.getAll());
        return "meals";
    }

    @PostMapping("/meals")
    public String Update(HttpServletRequest request) {
        Meal meal = new Meal(
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));

        if (request.getParameter("id").isEmpty()) {
            super.create(meal);
        } else {
            super.update(meal, getId(request));
        }
        return "redirect:/meals";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/meals";

    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("meal", super.get(getId(request)));
        return "mealForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("meal", new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), "", 1000));
        return "mealForm";
    }

    @GetMapping("/filter")
    public String getBetween(HttpServletRequest request, Model model) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
        LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
        model.addAttribute("meals", super.getBetween(startDate, startTime, endDate, endTime));
        return "meals";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
