package com.github.cataratoru_fara_cap.characters;

import java.util.HashMap;
import java.util.Scanner;

import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.Item.*;

public class Enemy extends Characters {
    public Enemy(String name, double attack, double defense, double health) {
        this.name = name;
        this.isAlive = true;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.Items = new HashMap<String, Item>();
       
        if (Math.random() < 0.3){ 
            Item sword = new Sword("CoolSword", Rarity.getRandom());
            this.Items.put("CoolSword", sword);
        }
        if (Math.random() < 0.3) {
            Item shield = new Shield("CoolShield", Rarity.getRandom());
            this.Items.put("CoolShield", shield);
        }
        if (Math.random() < 0.3){ 
            Item food = new Food("CoolFood", Rarity.getRandom());
            this.Items.put("CoolFood", food);
        }
    }

    public void damage(Character player) {
        player.health -= this.attack / player.defense;
        if (player.health <= 0) {
            player.die();
        }
    }

    public void takeDamage(Character player) {
        this.health -= player.attack / this.defense;
        if (this.health <= 0) {
            if (!this.Items.isEmpty()) {
                Item droppedItem = this.dropItem();
                
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Enemy dropped an item: " + droppedItem.getName() +
                                        ". Do you want to add it to your inventory? (yes/no)");
                    String response = scanner.nextLine();
                    
                    if (response.equalsIgnoreCase("yes")) {
                        player.Items.put(droppedItem.getName(), droppedItem);
                        System.out.println("Item added to your inventory.");
                    } else {
                        System.out.println("Item not added to your inventory.");
                    }
                }
            }
            this.die();
        }
    }

    public Item dropItem() {
        // Function that randomly drops an inventory item upon death 
        Item item = null;
        Object[] itemsArray = this.Items.values().toArray();
        int randomIndex = (int) (Math.random() * itemsArray.length);
        item = (Item) itemsArray[randomIndex];
        
        return item;
    }

    public void die() {
        this.isAlive = false;
    }

    public String toString() {
        return "Enemy: " + this.name + " Health: " + this.health + " Attack: " + this.attack + " Defense: "
                + this.defense;
    }
}
