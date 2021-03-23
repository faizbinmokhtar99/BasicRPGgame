package rpggame;

import java.util.Random;
import static rpggame.Ingamechat.rounds;


public class Enemy{
    
    public int currentHp ;
    public int attack ;
    public int defense;
    private double speed;
  

    public Enemy(){
      setAttributes();
    }
    
    public void setAttributes(){
       currentHp = 50;
       attack = 15;
       defense = 10;
       speed = 3;
    }
    
    
    public int getLife(){
        return currentHp;
    }
    
    public int getTest(){
        return currentHp;
    }
    
    public void setLife(int life){
       currentHp = life;
   }
    
    public double getSpeed(){
        return speed;
    }
    
    public void getStronger(){
        setAttributes();
        Random rand = new Random();
        currentHp += 5 * rounds;
        attack += 2 * rand.nextInt(5)+1 ;
        defense += 2 * rand.nextInt(5)+1 ;
        speed += 2 * rand.nextInt(5)+1 ;      
    }
    
}
