package com.company;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        //Assuming input is either D or U only as per question
        char[] string = {'D','D','U','U','D','D','U','U','U','D'};
        char[] string2 = {'D','U','D','D','U','U','U','U','D','D'};
        System.out.println("Total valleys traversed: "+countingValleys(string2));

    }

    private static int countingValleys(char[] input){

        LogManager lgmngr = LogManager.getLogManager();

        // lgmngr now contains a reference to the log manager.
        Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // Getting the global application level logger
        // from the Java Log Manager

        int countMountain = 0;
        int countValley = 0;

        char firstStep = input[0];
        int level = 1;  //Since first step is already taken into account level will be 1
        int opposite = 0;

        for (int i = 1; i <input.length ; i++) {
            if (input[i] == firstStep){ //Continuing the path
                level++; //Increase the level
            }
            else {
                opposite++; //Moving into opposite direction
                if (level==opposite){ //Reached sea level
                    if (firstStep=='D') { //Valley
                        countValley++;
                        log.log(Level.INFO, "Level of Valley traversal: "+level);
//                        System.out.println("Level of Valley traversal: "+level);
                    }
                    else {  //Mountain
                        countMountain++;
                        log.log(Level.INFO, "Level of Mountain traversal: "+level);
//                        System.out.println("Level of Mountain traversal: "+level);
                    }
                    opposite=0;
                    if (i==input.length-1){
                        break;
                    }
                    firstStep = input[i+1];
                    level=1; //Next step taken into account
                    i=i+1;  //Skip the step taken into account
                }
            }
        }

        return countValley;

    }
}
