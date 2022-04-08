package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carService = new CarService();

    private final List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("Lada", 1, "red"));
        carList.add(new Car("Gaz", 2, "blue"));
        carList.add(new Car("Yaz", 3, "orange"));
        carList.add(new Car("Maz", 4, "green"));
        carList.add(new Car("Mazda", 5, "yellow"));
    }

    @GetMapping("/cars")
    public String getCountCars(@RequestParam(defaultValue = "5") int count, ModelMap model) {
        model.addAttribute("carList", carService.getCountCars(carList, count));
        return "cars";
    }
}
