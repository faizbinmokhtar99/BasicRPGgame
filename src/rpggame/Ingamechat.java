package rpggame;

import rpggame.Enemy;
import java.util.Random;
import java.util.Scanner;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import static rpggame.Ingamechat.rounds;
import rpggame.LoginForm;
import static rpggame.LoginForm.role2;
import static rpggame.RegisterForm.role1;

public class Ingamechat {

    //Display
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel,
            playerPanel, rolePanel, enemyRolePanel, enemyHpPanel;
    JLabel titleNameLabel, roleLabel, hpLabel, hpLabelNumber, enemyRoleLabel,
            enemyHpLabel, ehpLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int hp;
    String role, position;
    Timer time;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    //Game
    Player player;
    Enemy enemy;
    

    Scanner sc = new Scanner(System.in);
    public static int rounds = 1;
    double dmg = 0, dmgTook = 0;

    public Ingamechat() {
        
//        String uname;
//        String pass;
//        String role;
//        //JOptionPane.showMessageDialog(null, LoginForm.username);
//        String tempname = LoginForm.username +".txt" ;
//        
//        int coin;
//                try {
//            BufferedReader br = new BufferedReader(new FileReader(tempname));
//            String s = "";
//            while ((s = br.readLine()) != null) {
//                String data[] = new String[7];
//                data = s.split(",");
//                for (int i = 0; i < 7; i++) {
//                    if (i == 0) {
//                        uname = data[i];
//                    } else if (i == 1) {
//                        pass = data[i];
//                    } else if (i == 2) {
//                        role = data[i];
//                    } else if (i == 3) {
//                        this.attack = Integer.parseInt(data[i]);
//                    } else if (i == 4) {
//                        defense = Integer.parseInt(data[i]);
//                    } else if (i == 5) {
//                        speed = Integer.parseInt(data[i]);
//
//                    } else if (i == 6) {
//                        coin = Integer.parseInt(data[i]);
//
//                    }
//
//                }
//
//            }
//
//        } catch (Exception e) {
//        }
//        
        
        player = new Player("RONALDO", role2);
        enemy = new Enemy();

        window = new JFrame();
        window.setSize(800, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        window.setVisible(true);

    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(300, 300, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 450, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(3, 1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Attack");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Defense");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Run");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        rolePanel = new JPanel();
        rolePanel.setBounds(15, 10, 150, 35);
        rolePanel.setBackground(Color.black);
        con.add(rolePanel);
        roleLabel = new JLabel(player.getRole());
        roleLabel.setFont(normalFont);
        roleLabel.setForeground(Color.white);
        rolePanel.add(roleLabel);

        enemyRolePanel = new JPanel();
        enemyRolePanel.setBounds(620, 10, 150, 35);
        enemyRolePanel.setBackground(Color.black);
        con.add(enemyRolePanel);
        enemyRoleLabel = new JLabel("MONSTER");
        enemyRoleLabel.setFont(normalFont);
        enemyRoleLabel.setForeground(Color.white);
        enemyRolePanel.add(enemyRoleLabel);

        playerPanel = new JPanel();
        playerPanel.setBounds(20, 60, 110, 25);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 1));
        con.add(playerPanel);
        hpLabel = new JLabel("HP :");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel(" " + player.getLife());
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        enemyHpPanel = new JPanel();
        enemyHpPanel.setBounds(650, 60, 110, 25);
        enemyHpPanel.setBackground(Color.black);
        enemyHpPanel.setLayout(new GridLayout(1, 1));
        con.add(enemyHpPanel);
        enemyHpLabel = new JLabel("HP :");
        enemyHpLabel.setFont(normalFont);
        enemyHpLabel.setForeground(Color.white);
        enemyHpPanel.add(enemyHpLabel);
        ehpLabel = new JLabel(" " + enemy.getTest());
        ehpLabel.setFont(normalFont);
        ehpLabel.setForeground(Color.white);
        enemyHpPanel.add(ehpLabel);

        //time = new Timer();
        fighting();
    }

    public void fighting() {
        position = "fighting";
        mainTextArea.setText(" What is your Action?");

    }

    public void setMAINtext() {
        position = "fighting";
        
        mainTextArea.setText(player.getRole() + " dealt " + String.format("%4.2f", dmg) + " damage to MONSTER\n"
                + "MONSTER   dealt " + String.format("%4.2f", dmgTook) + " damage to " + player.getRole() + "\n");
        
        if (player.getLife() > 0) {
            hpLabelNumber.setText(" " + player.getLife());
        } else {
            hpLabelNumber.setText(" 0");
            mainTextArea.setText("You Died Please Leave this Game :(");
        }
        if (enemy.getLife() > 0) {
            ehpLabel.setText(" " + enemy.getLife());
        } else {
            ehpLabel.setText(" 0");
        }
        
    }

    public boolean fight(String str) {

        if (player.getLife() > 0 && enemy.getLife() > 0) {

            if (str.equalsIgnoreCase("c1")) {

                isAttack();

            } else if (str.equalsIgnoreCase("c2")) {

                isDefense();

            } else if (str.equalsIgnoreCase("c3")) {

                if (player.getSpeed() >= enemy.getSpeed()) {
                    running();
                    return false;
                } else {
                    failRunning();
                    return false;
                }

            }

            if (dmgTook < 0) {
                dmg -= dmgTook / 2;
                dmgTook = 0;
            }
            if (dmg < 0) {
                dmg = 0;
            }

            //deal damage
            player.currentHp -= dmgTook;
            enemy.currentHp -= dmg;

            //check 
            if (player.currentHp <= 0) {
                playerDied();

            }
            if (enemy.currentHp <= 0) {
                enemyDied();

            } else {
                setMAINtext();
            }
            
        }
        return true;

    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "fighting":
                    switch (yourChoice) {
                        case "c1":
                            if (player.getLife() > 0 || enemy.getLife() > 0) {
                                fight(yourChoice);
                            } else {
                                System.out.println("Fight ends");
                            }
                            break;
                        case "c2":
                            if (player.getLife() > 0 || enemy.getLife() > 0) {
                                fight(yourChoice);
                            } else {
                                System.out.println("Fight ends");
                            }
                            break;
                        case "c3":
                            if (player.getLife() > 0 || enemy.getLife() > 0) {
                                fight(yourChoice);
                            } else {
                                
                            }
                            break;

                    }

            }
        }

    }

    public void isAttack() {
        player.setAttack();
        dmg = (player.attack * randFactor()) - enemy.defense;
        dmgTook = (enemy.attack * randFactor()) - player.defense;
        player.resetAttack();
    }

    public void isDefense() {
        player.setDefense();
        dmgTook = enemy.attack - player.defense * randFactor();
        dmg = player.attack - enemy.defense * randFactor();
        player.resetDefense();
    }

    public void playerDied() {
        position = "fighting";
        if (player.getLife() > 0) {
            hpLabelNumber.setText(" " + player.getLife());
        } else {
            hpLabelNumber.setText(" 0");
        }
        if (enemy.getLife() > 0) {
            ehpLabel.setText(" " + enemy.getLife());
        } else {
            ehpLabel.setText(" 0");
        }
       mainTextArea.setText("You Died Please Leave this Game :(");
    }

    public void enemyDied() {
        position = "fighting";
        if (player.getLife() > 0) {
            hpLabelNumber.setText(" " + player.getLife());
        } else {
            hpLabelNumber.setText(" 0");
        }
        if (enemy.getLife() > 0) {
            ehpLabel.setText(" " + enemy.getLife());
        } else {
            ehpLabel.setText(" 0");
        }
        mainTextArea.setText("YOU WINN !!! CONGRATULATIONS, STAGE " + rounds + " \nCLEARED");
        rounds++;
        player.getStronger();
        enemy.getStronger();
    }

    public void running() {
        position = "fighting";
        mainTextArea.setText("Succedeed in running you may leave this page");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void failRunning(){
        position = "fighting";
        mainTextArea.setText("You Failed to Run Proceed with the Game");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public double randFactor() {
        Random rand = new Random();
        double num = (Math.random() * (1.2 - 0.8)) + 0.8;
        return num;
    }

}
