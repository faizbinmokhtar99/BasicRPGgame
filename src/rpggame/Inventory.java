package rpggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import rpggame.Profile;
import rpggame.LoginForm;
import rpggame.Handler;
import rpggame.gfx.Assets;
import rpggame.gfx.Text;
import rpggame.items.Item;
import rpggame.shop.shop;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
    private shop open;
    public static String username;

    private int invX = 64, invY = 48,
            invWidth = 512, invHeight = 384,
            invListCenterX = invX + 171,
            invListCenterY = invY + invHeight / 2 + 5,
            invListSpacing = 30;

    private int invImageX = 452, invImageY = 82,
            invImageWidth = 64, invImageHeight = 64;

    private int invCountX = 484, invCountY = 172;

    private int selectedItem = 0;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
    }

    public void tick() {
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_F)) {
            open = new shop();
        }
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_G)) {
            open.setVisible(false);
        }

        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
            active = !active;
        }
        if (!active) {
            return;
        }
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
            selectedItem--;
        }
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
            selectedItem++;
        }

        if (selectedItem < 0) {
            selectedItem = inventoryItems.size() - 1;
        } else if (selectedItem >= inventoryItems.size()) {
            selectedItem = 0;
        }

    }

    public void render(Graphics g) {
        if (!active) {
            return;
        }

        g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);

        int len = inventoryItems.size();
        if (len == 0) {
            return;
        }

        for (int i = -5; i < 6; i++) {
            if (selectedItem + i < 0 || selectedItem + i >= len) {
                continue;
            }
            if (i == 0) {
                Text.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
            } else {
                Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
            }
        }

        Item item = inventoryItems.get(selectedItem);
        g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
        Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);

        //JOptionPane.showMessageDialog(null, LoginForm.username);
        //LoginForm lg = new LoginForm();
        //String uname = lg
    }
    private static Scanner x;
    // Inventory methods

    public void addcoin() throws IOException {
        String username1 = LoginForm.username;
        Item item = inventoryItems.get(selectedItem);

        String name = "";
        String pass = "";
        String role = "";
        String attack = "";
        String defense = "";
        String speed = "";
        int coin = 0;
        int PotionPrice = 1;
        int tempcoin = 0;

        String filename = username1 + ".txt";

        File f1 = new File(filename);
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filename));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                name = x.next();
                pass = x.next();
                role = x.next();
                attack = x.next();
                defense = x.next();
                speed = x.next();
                coin = x.nextInt();
                for (Item i : inventoryItems) {
                    if (i.getId() == item.getId()) {
                        tempcoin = item.getCount();
                        coin = tempcoin + coin;
                        pw.println(username1 + "," + pass + "," + role + "," + attack + "," + defense + "," + speed + "," + coin);

                        x.close();
                        pw.flush();;
                        f1.delete();
                        pw.close();

                        JOptionPane.showMessageDialog(null, "potion obtain ");

                    } else {
                        JOptionPane.showMessageDialog(null, "coin not obtain");
                    }
                }
            }
        }catch (Exception e) {
            
        }
        }


	

    public void addItem(Item item) {
        for (Item i : inventoryItems) {
            if (i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());

                return;
            }
        }

        inventoryItems.add(item);

    }

    // GETTERS SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }

}
