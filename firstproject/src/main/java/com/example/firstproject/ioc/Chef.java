package com.example.firstproject.ioc;

import org.springframework.stereotype.Component;

@Component
public class Chef {

    private final IngredientFactory ingredientFactory;
    public Chef(IngredientFactory ingredientFactory){
          this.ingredientFactory = ingredientFactory;
    }

    // 셰프가 식재료 공장과 협업하기 위한 DI
    public String cook(String menu) {
        // 재료 준비
        Ingredient ingredient = ingredientFactory.get(menu);
        // 요리 변환
        return ingredient.getName() + "으로 만든 " + menu;


    }
}
