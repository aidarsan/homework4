package com.company;

import java.util.Random;

public class Main {

    public static int[] heroesHealth = {270, 280, 250};
    public static String[] heroesNames = {"Lu Kang ", "Jax ",
            "Scorpion "};
    public static int[] heroesStrike ={20, 15, 25};

    public static String bossName = "Shao Kahn ";
    public static int bossHealth = 700;
    public static int bossStrike = 50;
    public static String superStrike = "";
    public static int roundNumber = 0;
    //Домашнее задание
    public static String toHeal = "";

    //Домашнее задание
    public static String medikName = "Lekar";
    public static int medikHealth = 300;

    public static void main(String[] args) {
	// write your code here
        printStatistics();
        System.out.println("------The game started-------");

        while (!isGameFinished()){
            round();
        }
    }

    public static void round(){
        roundNumber++;
        System.out.println("-----Round " + roundNumber + "-----");
        superStrike = getSuperStrikeHero();
        bossHits();
        //Домашнее задание
        bossHitMedik();
        heroesHits();
        //Домашнее задание
        medikToHeal();
        toHeal = getToHealHero();
        System.out.println("Lekar to heal " + toHeal);
        printStatistics();
    }

    public static boolean isGameFinished(){
        if (bossHealth <= 0){
            System.out.println("Heroes won!!! " +
                    "Mortal Kombat finished");
            return true;
        }

        boolean allHeroesDead = true;

        for (int heroHealth: heroesHealth) {
            if (heroHealth > 0){
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead){
            System.out.println(bossName +
                    " Won!!! Mortal Combat finished");
        }
        return allHeroesDead;
    }

    public static void heroesHits(){
        Random random = new Random();
        int coeff = random.nextInt(9) + 2;
        for (int i = 0; i < heroesStrike.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0){
                if (superStrike == heroesNames[i]){
                    bossHealth = bossHealth - heroesStrike[i] * coeff;
                    System.out.println("Super strike damage "+
                            superStrike + " " + (heroesStrike[i] * coeff));
                } else {
                    bossHealth = bossHealth - heroesStrike[i];
                }
            }
            if (bossHealth < 0){
                bossHealth = 0;
            }
        }
    }

    //Домашнее задание
    public static void medikToHeal() {
        Random random = new Random();
        int heal = random.nextInt(29) + 10;
        for (int i = 0; i < heroesNames.length; i++) {
            if (heroesHealth[i] <= 100) {
                if (toHeal == heroesNames[i]) {
                heroesHealth[i] = heroesHealth[i] + heal;
            }
                }
            }
        }
    //Домашнее задание
    public static String getToHealHero(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesNames.length);
        return heroesNames[randomIndex];
    }



    public static void bossHits(){
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0){
                heroesHealth[i] = heroesHealth[i] - bossStrike;
            }
            if (heroesHealth[i] < 0){
                heroesHealth[i] = 0;
            }
        }
    }

    //Домашнее задание
    public static void bossHitMedik() {
        if (medikHealth > 0 && bossHealth > 0) {
            medikHealth = medikHealth - bossStrike;
        }
        if (medikHealth < 0){
            medikHealth = 0;
        }

    }


    public static String getSuperStrikeHero(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesNames.length);
        return heroesNames[randomIndex];
    }

    public static void printStatistics(){
        System.out.println(bossName + "= health " + bossHealth +
                " strike [" + bossStrike + "]");
        for (int i = 0; i < heroesNames.length; i++) {
            System.out.println(heroesNames[i] + "= health " +
                    heroesHealth[i] + " strike [" +
                    heroesStrike[i] + "]");
        }
        System.out.println(medikName + " = health " + medikHealth);
    }




}
