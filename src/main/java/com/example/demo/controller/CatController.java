package com.example.demo.controller;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Missing;
import com.example.demo.service.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {

    private CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping(path ="/add/{user_id}", produces = "application/json")
    public void addCat(@RequestBody HashMap<String, String> newCat, @PathVariable long user_id) {

            if (newCat.containsKey("name")&& newCat.containsKey("sex") &&newCat.containsKey("old")&&newCat.containsKey("breed")&&newCat.containsKey("chipNumber")) {
                Cat cat = new Cat();
                cat.setName(newCat.get("name"));
                cat.setSex(newCat.get("sex"));
                cat.setOld(newCat.get("old"));
                cat.setBreed(newCat.get("breed"));
                cat.setChipNumber(newCat.get("chipNumber"));
                catService.addCat(cat,user_id);
            }
            else throw new SecurityException("Number of parameter is bad");

    }

    @PostMapping(path="/update/{id}",produces = "application/json")
    public void update(@PathVariable long id, @RequestBody HashMap<String, String> updateCat)
    {

            if (updateCat.containsKey("name")&& updateCat.containsKey("sex") &&updateCat.containsKey("old")&&updateCat.containsKey("breed")&&updateCat.containsKey("chipNumber")) {
                    Cat cat = new Cat();
                    cat.setId(id);
                    cat.setName(updateCat.get("name"));
                    cat.setSex(updateCat.get("sex"));
                    cat.setOld(updateCat.get("old"));
                    cat.setBreed(updateCat.get("breed"));
                    cat.setChipNumber(updateCat.get("chipNumber"));
                    catService.updateCat(cat);
            }
            else throw new SecurityException("Number of parameter is bad");
    }

    @PostMapping(path="/missing/{id}",produces = "application/json")
    public void addMissing(@PathVariable long id, @RequestBody HashMap<String, String> miss)
    {
            if (miss.containsKey("lat")&& miss.containsKey("lng"))
            {
                Missing missing=new Missing();
                missing.setLng(miss.get("lng"));
                missing.setLat(miss.get("lat"));
                catService.addMissing(id,missing);
            }
            else throw new SecurityException("Number of parameter is bad");
    }

    @PostMapping(path = "/findBy",produces = "application/json")
    public List<Cat> findBy(@RequestBody HashMap<String, String> by)
    {
            if (by.containsKey("sex")&& by.containsKey("old")&& by.containsKey("breed"))
            {
                String sex=by.get("sex");
                if((!sex.equals("kotka")) && !sex.equals("kot") ){
                    throw new SecurityException("Sex format is wrong");
                }
                String old=by.get("old");
                String breed=by.get("breed");
                return catService.getCat(sex,old,breed);
            }
            else throw new SecurityException("Number of parameter is bad");

    }

    @GetMapping(path = "/all",produces =  "application/json")
    public List<Cat> getAllCats(){
        return catService.getCats();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Cat getCat(@PathVariable String id){
        return catService.getCat(id);
    }

    @GetMapping(path="/isMissing/{id}", produces = "application/json")
    public boolean isMissing(@PathVariable long id){
        return catService.isMissing(id);
    }

    @DeleteMapping(path ="/missing/{id}", produces = "application/json")
    public void removeMissing(@PathVariable long id){
        catService.removeMissing(id);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void removeCat(@PathVariable long id)  {
        catService.removeCat(id);
    }


}
