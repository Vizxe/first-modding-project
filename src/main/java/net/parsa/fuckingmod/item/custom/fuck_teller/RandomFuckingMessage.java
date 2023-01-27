package net.parsa.fuckingmod.item.custom.fuck_teller;

import net.minecraft.util.math.random.Random;

public class RandomFuckingMessage {

    private final static String[] fuckingKeyWords = {
            "cockalorum",
            "snollygoster",
            "pillock",
            "lickspittle",
            "smellfungus",
            "ninnyhamme",
            "mumpsimus",
            "milksop",
            "hobbledehoy",
            "pettifogger",
            "mooncalf",
            "saltimbanco",
            "smell-feast"
    };

    private final static String modifier = "Fucking ";


    /**
     * Used by the fuck teller item.
     * @return A random fucking message.
     */
    public static String getRandomFuckingMessage() {
       return modifier + fuckingKeyWords[ranNum(fuckingKeyWords.length-1)];
    }

    private static int ranNum(int upperBound) {
        return Random.createLocal().nextInt(upperBound);
    }

}
