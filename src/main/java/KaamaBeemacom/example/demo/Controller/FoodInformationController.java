package KaamaBeemacom.example.demo.Controller;


import KaamaBeemacom.example.demo.Enum.TableNames;
import KaamaBeemacom.example.demo.Model.FoodInformation;
import KaamaBeemacom.example.demo.Service.FoodInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/foodInformation")
public class FoodInformationController extends BaseController{


    @Autowired
    private FoodInformationService foodInformationService;

    @GetMapping
    public ResponseEntity getFoodInformation(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "name", required = false) String name
    ){
        if (id!=null && name!=null)
            return null;
        else if(id!=null)
            return getFoodInformationById(id);
        else if (name!=null)
            return getFoodInformationByName(name);
        else
            return getAllFoodInformation();
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteFoodInformation(@PathVariable("id") Integer id){
        FoodInformation foodInformation=foodInformationService.getFoodInformationById(id);
        if (foodInformation!=null){
            foodInformationService.deleteFoodInformation(id);
            return ResponseEntity.status(HttpStatus.OK.value()).body(foodInformation);
        }
        else
            return getNotFoundErrorResponse(TableNames.FOOD_INFORMATION.getName(), "id",String.valueOf(id));
    }

    @PostMapping
    public ResponseEntity addFoodInformation(@RequestBody FoodInformation foodInformation){
        return ResponseEntity.status(HttpStatus.OK.value()).body(foodInformationService.addFoodInformation(foodInformation));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateFoodInformation(
            @PathVariable("id") Integer foodInformationIdToUpdate,
            @RequestBody FoodInformation foodInformationToUpdate
    ){
        FoodInformation existingFoodInformation=foodInformationService.getFoodInformationById(foodInformationIdToUpdate);
        if (existingFoodInformation!=null){
            foodInformationService.updateFoodInformation(foodInformationToUpdate,foodInformationIdToUpdate);
            return ResponseEntity
                    .status(HttpStatus.OK.value())
                    .body(foodInformationService.getFoodInformationById(foodInformationIdToUpdate));
        }
        else
            return getNotFoundErrorResponse(TableNames.FOOD_INFORMATION.getName(), "id",String.valueOf(foodInformationIdToUpdate));
    }

    private ResponseEntity getAllFoodInformation(){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(foodInformationService.getAllFoodInformation());
    }

    private ResponseEntity getFoodInformationById(Integer id){
        FoodInformation foodInformation=foodInformationService.getFoodInformationById(id);
        if (foodInformation!=null)
            return ResponseEntity.status(HttpStatus.OK.value()).body(foodInformation);
        else
            return getNotFoundErrorResponse(TableNames.FOOD_INFORMATION.getName(), "id",String.valueOf(id));
    }

    private ResponseEntity getFoodInformationByName( String foodName){
        FoodInformation foodInformation=foodInformationService.getFoodInformationByName(foodName);
        if (foodInformation!=null)
            return ResponseEntity.status(HttpStatus.OK.value()).body(foodInformation);
        else
            return getNotFoundErrorResponse(TableNames.FOOD_INFORMATION.getName(),"name", foodName);
    }


}
