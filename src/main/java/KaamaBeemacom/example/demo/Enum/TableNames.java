package KaamaBeemacom.example.demo.Enum;

public enum TableNames {

    VISITOR("visitor"),
    VENDOR("vendor"),
    RATING_AND_REVIEW("ratingandreview"),
    COMPLAINT("complaint"),
    FOOD_INFORMATION("foodinformation"),
    FOOD_PRODUCT("foodproduct"),
    ORDER("order")
    ;

    private final String name;

    TableNames(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

}
