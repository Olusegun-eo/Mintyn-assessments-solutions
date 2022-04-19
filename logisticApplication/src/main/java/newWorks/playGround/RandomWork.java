package newWorks.playGround;

public class RandomWork {
    public static void main(String[] args) {
        checkWrappers();
        controlFlow(5000);

        calculateScore(true, 800, 5, 200);
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 5;

        
        int results = calculateHighScorePosition(1500);
        displayHighScorePosition("Okikiola", results);

         results = calculateHighScorePosition(900);
        displayHighScorePosition("God'sWill ", results);

         results = calculateHighScorePosition(400);
        displayHighScorePosition("Desmond", results);

         results = calculateHighScorePosition(50);
        displayHighScorePosition("Nathaniel", results);

        results = calculateHighScorePosition(1000);
        displayHighScorePosition("Dennis", results);

        results = calculateHighScorePosition(500);
        displayHighScorePosition("Tim", results);

        results = calculateHighScorePosition(100);
        displayHighScorePosition("Gabriel", results);


         positiveNegativeZero(5);
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        if(gameOver){
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Final Score = " + finalScore);
            return finalScore;
        }
        return -1;
    }

    public static void controlFlow(int score){
        if(score < 5000 && score > 1000){
            System.out.println("The score is was correct");
        } else if(score > 1000){
            System.out.println("The score is 1000");
        }
        else{
            System.out.println("Got nothing");
        }

    }

    public static void checkWrappers(){
        int minInteger = Integer.MIN_VALUE;
        int maxInteger = Integer.MAX_VALUE;
        System.out.println("Minimum-Integer = " + minInteger + "\n" + "Maximum-Integer = " + maxInteger);

        double firstVariable = 20.00D;
        double secondVariable = 80.00D;
        double result = (firstVariable + secondVariable) * 100;
        double remainder = result % 40.00;
        boolean variable = (remainder == 0) ? true : false;
        System.out.println("The boolean =" + variable);

        if(!variable){
            System.out.println("Got some remainder");
        }
    }

    public static void displayHighScorePosition(String playerName, int playerPosition){
        System.out.println( playerName + " into position = " + playerPosition + " on the high score table");
    }

    public static int calculateHighScorePosition(int playerScore){

        int position = 4; //Assuming position 4 will bed returned
//        if(playerScore >= 1000){
//            return 1;
//        }
//        else if(playerScore >= 500){
//            return 2;
//        }
//        else if(playerScore >= 100){
//            return 3;
//        }
//        return 4;

        if(playerScore >= 1000){
            position = 1;
        }
        else if(playerScore  >= 500){
            position = 2;
        }
        else if(playerScore >= 100){
            position = 3;
        }
        return position;
   }


   public static void positiveNegativeZero(int number){
        if(number > 0){
            System.out.println("positve");
        }
        else if(number < 0){
            System.out.println("negative");
        }
        else if(number == 0){
            System.out.println("zero");
        }
   }
}
