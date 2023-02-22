package KaamaBeemacom.example.demo.Service;

import KaamaBeemacom.example.demo.Model.FoodProduct;
import KaamaBeemacom.example.demo.Repository.FoodProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodProductService {

    @Autowired
    private FoodProductRepository foodProductRepository;

    public List<FoodProduct> getAllFoodProducts(){
        return foodProductRepository.findAll();
    }

    public FoodProduct getFoodProductById(Integer id){
        return foodProductRepository.findById(id).orElse(null);
    }

    public FoodProduct getFoodProductByName(String name){
        return foodProductRepository.getFoodProductByName(name);
    }

    public List<FoodProduct> getFoodProductByVendorId(Integer vendorId){
        return foodProductRepository.getFoodProductByVendorId(vendorId);
    }

    public FoodProduct addFoodProduct(FoodProduct foodProduct){
        return foodProductRepository.save(foodProduct);
    }

    public void deleteProductById(Integer foodProductId){
        FoodProduct foodProduct=foodProductRepository.findById(foodProductId).orElse(null);
        if (foodProduct!=null)
            foodProductRepository.deleteById(foodProductId);
    }

    public FoodProduct updateProduct(FoodProduct foodProduct, Integer existingFoodProductId){
        FoodProduct existingFoodProduct=foodProductRepository.findById(existingFoodProductId).orElse(null);
        if (existingFoodProduct!=null){
            existingFoodProduct.setProductName(foodProduct.getProductName());
            existingFoodProduct.setIngredients(foodProduct.getIngredients());
            existingFoodProduct.setAllergyTriggers(foodProduct.getAllergyTriggers());
            existingFoodProduct.setDietType(foodProduct.getDietType());
            existingFoodProduct.setVendorId(foodProduct.getVendorId());

            foodProductRepository.save(existingFoodProduct);
            return existingFoodProduct;
        }
        else return null;
    }
}
