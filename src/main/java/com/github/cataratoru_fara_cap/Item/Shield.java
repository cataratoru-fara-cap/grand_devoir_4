package com.github.cataratoru_fara_cap.Item;

import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.characters.Character;
import com.github.cataratoru_fara_cap.Effect;

public class Shield extends Item {
    public Shield(String name, Rarity rarity) {
        super(name, Effect.DEFENSE, rarity);
    }

    @Override
    public void use(Character character) {
        double value = 30 * rarity.getMultiplier();
        character.defense += value;
        System.out.println("You ate another sword and are now stronger by " + value );
    }
}
