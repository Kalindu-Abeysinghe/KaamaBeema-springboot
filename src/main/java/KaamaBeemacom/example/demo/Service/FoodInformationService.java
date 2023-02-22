package KaamaBeemacom.example.demo.Service;


import KaamaBeemacom.example.demo.Model.FoodInformation;
import KaamaBeemacom.example.demo.Repository.FoodInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodInformationService {

    @Autowired
    private FoodInformationRepository foodInformationRepository;

    public List<FoodInformation> getAllFoodInformation(){
        return foodInformationRepository.findAll();
    }

    public FoodInformation getFoodInformationById(Integer foodInformationId){
        return foodInformationRepository.findById(foodInformationId).orElse(null);
    }

    public FoodInformation getFoodInformationByName(String foodInformationName){
        return foodInformationRepository.findByName(foodInformationName);
    }

    public FoodInformation addFoodInformation(FoodInformation foodInformation){
        return foodInformationRepository.save(foodInformation);
    }

    public void deleteFoodInformation(Integer foodInformationId){

        FoodInformation foodInformation=foodInformationRepository.findById(foodInformationId).orElse(null);
        if (foodInformation!=null)
            foodInformationRepository.deleteById(foodInformationId);
    }

    public FoodInformation updateFoodInformation(FoodInformation foodInformationToUpdate, Integer existingFoodInformationId){

        FoodInformation existingFoodInformation=foodInformationRepository.findById(existingFoodInformationId).orElse(null);
        if (existingFoodInformation!=null){
            existingFoodInformation.setFoodName(foodInformationToUpdate.getFoodName());
            existingFoodInformation.setIngredients(foodInformationToUpdate.getIngredients());
            existingFoodInformation.setAllergyTriggers(foodInformationToUpdate.getAllergyTriggers());
            existingFoodInformation.setDietType(foodInformationToUpdate.getDietType());

            foodInformationRepository.save(existingFoodInformation);
            return existingFoodInformation;
        }
        else return null;
    }
}
