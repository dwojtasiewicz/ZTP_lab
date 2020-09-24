package com.example.demo.service;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Missing;
import com.example.demo.entity.User;
import com.example.demo.repo.CatRepo;
import com.example.demo.repo.MissingRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatService {
    private CatRepo catRepo;
    private MissingRepo missingRepo;
    private UserRepo userRepo;

    public CatService(CatRepo catRepo, MissingRepo missingRepo, UserRepo userRepo) {
        this.catRepo = catRepo;
        this.missingRepo = missingRepo;
        this.userRepo = userRepo;
    }

    public void addMissing(long cat_id, Missing missing){
        Cat cat;
        cat=catRepo.findById(cat_id);
        cat.setMissing(missing);
        missing.setCat(cat);
        missingRepo.save(missing);
        catRepo.save(cat);

    }

    public void removeMissing(long id){
        Missing miss;
        miss= missingRepo.findById(id);
        Cat cat;
        cat=miss.getCat();
        cat.setMissing(null);
        missingRepo.delete(miss);
        catRepo.save(cat);

    }

    public void addCat(Cat cat, long user_id){
        cat.setName(cat.getName());
        cat.setSex(cat.getSex());
        cat.setOld(cat.getOld());
        cat.setBreed(cat.getBreed());
        cat.setChipNumber(cat.getChipNumber());
        User user;
        user=userRepo.findById(user_id);
        cat.setUser(user);

        List<Cat> cats= user.getCats();
        cats.add(cat);
        user.setCats(cats);

        catRepo.save(cat);
        userRepo.save(user);
    }

    public void updateCat(Cat cat){
        Cat updateCat= catRepo.findById(cat.getId());
        updateCat.setName(cat.getName());
        updateCat.setSex(cat.getSex());
        updateCat.setOld(cat.getOld());
        updateCat.setBreed(cat.getBreed());
        updateCat.setChipNumber(cat.getChipNumber());
        catRepo.save(updateCat);
    }

    public Cat getCat(String chip){
        return catRepo.findCatByChipNumber(chip);
    }

    public List<Cat> getCat(String sex,String old,String breed){
        return catRepo.findBySexAndOldAndBreed(sex,old,breed);
    }

    public List<Cat> getCats(){
        return (List<Cat>) catRepo.findAll();
    }

    public boolean isMissing(long id){
        Cat cat;
        cat=catRepo.findById(id);
        return !(cat.getMissing() == null);
    }

    public void removeCat(long id){
        Cat cat ;
        cat = catRepo.findById(id);
        if(!(cat.getMissing() ==null)){
            Missing miss;
            miss= cat.getMissing();
            missingRepo.delete(miss);
        }
        catRepo.delete(cat);
    }
}

