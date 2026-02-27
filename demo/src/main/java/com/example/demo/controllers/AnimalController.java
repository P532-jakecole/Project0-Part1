package com.example.demo.controllers;
import com.example.demo.model.AnimalData;
import com.example.demo.repository.AnimalRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostMapping
    public boolean add(@RequestBody AnimalData data){
        try{
            return animalRepository.add(data);
        }catch (IOException e){
            return false;
        }
    }

    @GetMapping
    public List<AnimalData> findAll(){
        try{
            return animalRepository.findAll();
        }catch (IOException e){
            return null;
        }
    }

    @GetMapping("/search")
    public List<AnimalData> search(@RequestParam String name, @RequestParam String picture, @RequestParam String location){
        try{
            System.out.println(name);
            System.out.println(picture);
            System.out.println(location);
            return animalRepository.find(name, picture, location);
        } catch (IOException e) {
            return null;
        }
    }
}
