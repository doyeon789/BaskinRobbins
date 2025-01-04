package Payment;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class P_Price {
    public static void Money_Label(JPanel panel_payment) {
        JLabel OrderMoney_T = new JLabel("주문 금액");
        OrderMoney_T.setOpaque(false);
        OrderMoney_T.setForeground(new Color(65, 65, 65));
        OrderMoney_T.setBounds(40, 665, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            OrderMoney_T.setFont(BMJUA.deriveFont(19f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel OrderPice_won = new JLabel("₩");
        OrderPice_won.setForeground(new Color(35, 35, 35));
        OrderPice_won.setForeground(Color.black);
        OrderPice_won.setBounds(184, 646, 100, 70);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Jalnan2.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            OrderPice_won.setFont(BMJUA.deriveFont(18f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel OrderPrice_T = new JLabel("33,900");
        OrderPrice_T.setOpaque(false);
        OrderPrice_T.setForeground(new Color(35, 35, 35));
        OrderPrice_T.setBounds(210, 664, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            OrderPrice_T.setFont(BMJUA.deriveFont(21f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel Minus = new JLabel("-");
        Minus.setOpaque(false);
        Minus.setForeground(new Color(153,0,56));
        Minus.setBounds(300, 663, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Minus.setFont(BMJUA.deriveFont(24f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel Discount_T = new JLabel("할인 금액");
        Discount_T.setOpaque(false);
        Discount_T.setForeground(new Color(65,65,65));
        Discount_T.setBounds(335, 664, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Discount_T.setFont(BMJUA.deriveFont(19f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }


        JLabel Discount_won = new JLabel("₩");
        Discount_won.setForeground(new Color(35,35,35));
        Discount_won.setForeground(Color.black);
        Discount_won.setBounds(480,646,100,70);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Jalnan2.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Discount_won.setFont(BMJUA.deriveFont(16f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel Discount_Money_T = new JLabel("0");
        Discount_Money_T.setOpaque(false);
        Discount_Money_T.setForeground(new Color(65,65,65));
        Discount_Money_T.setBounds(500, 664, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Discount_Money_T.setFont(BMJUA.deriveFont(19f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }


        JLabel Total_Price = new JLabel("총 결제 금액");
        Total_Price.setOpaque(false);
        Total_Price.setForeground(new Color(65,65,65));
        Total_Price.setBounds(285, 750, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Total_Price.setFont(BMJUA.deriveFont(23f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel Total_won = new JLabel("₩");
        Total_won.setForeground(new Color(35,35,35));
        Total_won.setForeground(Color.black);
        Total_won.setBounds(413,732,100,70);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Jalnan2.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Total_won.setFont(BMJUA.deriveFont(18f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel Total_Price_Money = new JLabel("33,900");
        Total_Price_Money.setOpaque(false);
        Total_Price_Money.setForeground(new Color(35,35,35));
        Total_Price_Money.setBounds(440, 750, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Total_Price_Money.setFont(BMJUA.deriveFont(23f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        panel_payment.add(Discount_Money_T,0);
        panel_payment.add(Discount_won,0);
        panel_payment.add(Discount_T,0);
        panel_payment.add(Minus,0);
        panel_payment.add(Total_Price,0);
        panel_payment.add(Total_won,0);
        panel_payment.add(Total_Price_Money,0);
        panel_payment.add(OrderPrice_T);
        panel_payment.add(OrderPice_won);
        panel_payment.add(OrderMoney_T);
    }
}