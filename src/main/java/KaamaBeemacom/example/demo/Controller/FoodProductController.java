package KaamaBeemacom.example.demo.Controller;

import KaamaBeemacom.example.demo.Enum.TableNames;
import KaamaBeemacom.example.demo.Model.FoodProduct;
import KaamaBeemacom.example.demo.Service.FoodProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/foodProducts")
public class FoodProductController extends BaseController{

    @Autowired
    private FoodProductService foodProductService;

    @GetMapping
    public ResponseEntity getAllFoodProducts(){
        return getSuccessResponse(foodProductService.getAllFoodProducts());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getFoodProductById(@PathVariable("id") Integer foodProductId){
        FoodProduct foodProduct=foodProductService.getFoodProductById(foodProductId);
        if (foodProduct!=null)
            return getSuccessResponse(foodProduct);
        else
            return getNotFoundErrorResponse(TableNames.FOOD_PRODUCT.getName(), "id", String.valueOf(foodProductId));
    }

    @GetMapping(path = "/vendorId")
    public ResponseEntity getFoodProductsByVendorId(@PathVariable("vendorId") Integer vendorId){
        List<FoodProduct> foodProductList=foodProductService.getFoodProductByVendorId(vendorId);
        if (!foodProductList.isEmpty())
            return getSuccessResponse(foodProductList);
        else
            return getNotFoundErrorResponse(TableNames.FOOD_PRODUCT.getName(), "Vendor Id", String.valueOf(vendorId));
    }

    @GetMapping(path = "/productName")
    public ResponseEntity getFoodProductsByName(@PathVariable("name") String productName){
        FoodProduct foodProduct=foodProductService.getFoodProductByName(productName);
        if (foodProduct!=null)
            return getSuccessResponse(foodProduct);
        else
            return getNotFoundErrorResponse(TableNames.FOOD_INFORMATION.getName(), "Product Name", productName);
    }

    @PostMapping
    public ResponseEntity addFoodProduct(@RequestBody FoodProduct foodProduct){
        return getSuccessResponse(foodProductService.addFoodProduct(foodProduct));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteFoodProduct(@PathVariable("id") Integer id){
        FoodProduct foodProduct=foodProductService.getFoodProductById(id);
        if (foodProduct!=null){
            foodProductService.deleteProductById(id);
            return getSuccessResponse(foodProduct);
        }
        else
            return getNotFoundErrorResponse(TableNames.FOOD_INFORMATION.getName(), "id",String.valueOf(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateFoodProduct(
            @PathVariable("id") Integer id,
            @RequestBody FoodProduct foodProduct
    ){
        FoodProduct existingFoodProduct=foodProductService.getFoodProductById(id);
        if (existingFoodProduct!=null){
            foodProductService.updateProduct(foodProduct,id);
            return getSuccessResponse(foodProductService.getFoodProductById(id));
        }
        else
            return getNotFoundErrorResponse(TableNames.FOOD_INFORMATION.getName(), "id", String.valueOf(id));
    }

}
