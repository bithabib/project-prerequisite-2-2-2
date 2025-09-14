package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCars(@RequestParam(name = "count", required = false) Integer count, Model model) {
        int numberOfCars = (count != null) ? count : carService.getCars(5).size();
        model.addAttribute("cars", carService.getCars(numberOfCars));
        return "cars";
    }
}
