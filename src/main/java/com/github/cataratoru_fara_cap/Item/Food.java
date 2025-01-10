package com.github.cataratoru_fara_cap.Item;

import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.characters.Character;
import com.github.cataratoru_fara_cap.Effect;


public class Food extends Item {
    public Food(String name, Rarity rarity) {
        super(name, Effect.HEALTH, rarity);
    }

    @Override
    public void use(Character character) {
        double value = 30 * rarity.getMultiplier();
        character.health += value;
        System.out.println("You ate " + this.getName());
    }
}
