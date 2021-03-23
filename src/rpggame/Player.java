package rpggame;

import java.util.Random;
import static rpggame.Ingamechat.rounds;

public class Player{

    private String name;
    public String player_class;
    public String test;
    private int level;
    private int gold;
    
    public int currentHp;
    public int attack;
    public double defense;
    private double speed;  
    
    
    
    Player(String name, String player_class){
        
        this.name = name;
        this.player_class = player_class;
        test = player_class;
        this.level = 1;
        this.gold = 0;
        this.currentHp = 0;
        this.attack = 0;
        this.defense = 0;
        this.speed = 0;
        setAttributes();
        
        
    }

    Player() {
        
    }

   
    public void setAttributes(){
        
        switch(rolegetNumber()){
            case 1: currentHp = 50; attack = 20; defense = 10; speed = 5; break;
            case 2: currentHp = 50; attack = 10; defense = 20; speed = 2; break;
            case 3: currentHp = 50; attack = 20; defense = 5; speed = 10; break;
        }        
    }
    
    private int rolegetNumber(){
        if(player_class.equalsIgnoreCase("PALADINS")){
            return 1;
        }else if(player_class.equalsIgnoreCase("GUARDIAN")){
            return 2;
        }else if(player_class.equalsIgnoreCase("ASSASSINS")){
            return 3;
        }else{
            return 0;
        }
    }
    
   public int getLife(){
       return currentHp;
   }
   
   public String getTest(){
       return test;
   }
   
   public void setLife(int life){
       currentHp = life;
   }
    
   public void setDefense(){
       defense += 1;
   }
   
   public void resetDefense(){
       defense -= 1;
   }
   
   public void setAttack(){
       attack += 2;
   }
   
   public void resetAttack(){
       attack -= 2;
   }
   
   public String getName(){
       return name;
   }
   
   public String getRole(){
       return player_class;
   }
   
   public double getSpeed(){
       return speed;
   }
   
   public void getStronger(){
       setAttributes();
       Random rand = new Random();
       currentHp += 5 * rounds;
       attack += rand.nextInt(5)+1 * 2;
       defense += rand.nextInt(5)+1 * 2 ;
       speed += rand.nextInt(5)+1 * 2 ;
   }
   
}
