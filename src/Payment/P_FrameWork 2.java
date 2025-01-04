package Payment;

import CheckAgain.Add_taste.AM_Menu;
import Discount.Discount_Main;
import SelectType.SICT_Menu;
import StartPage.BaskinRobbins_Main;
import StartPage.FrameWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class P_FrameWork {
    static float f = 1.69160305F;

    public static void Panel(JPanel panel_payment, JFrame frame) {
        panel_payment.setVisible(true);
        panel_payment.setLayout(null);
        panel_payment.setBounds(0, 0, 570, 900);
        frame.add(panel_payment);
        panel_payment.setVisible(true);
        panel_payment.setOpaque(false);

        JLabel maker = new JLabel("made by. doyeon");
        maker.setFont(new Font("Arial", Font.BOLD, 14));
        maker.setForeground(new Color(240, 81, 160));
        maker.setBounds(15, 845, 130, 20);
        panel_payment.add(maker);

        // 기본 사진 넣기
        JLabel Background = new JLabel();
        Background.setOpaque(false);
        Background.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon BackgroundI = new ImageIcon("Img/Payment/background.png");
        Image Background_img = BackgroundI.getImage();
        Image Background_logo = Background_img.getScaledInstance(1138 / 2, 1743 / 2, Image.SCALE_SMOOTH);
        Background.setIcon(new ImageIcon(Background_logo));

        JLabel GoBack = new JLabel();
        GoBack.setOpaque(false);
        GoBack.setBounds(35, 800, 180, 48);
        panel_payment.add(GoBack);
        GoBack.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(!P_Buttons.action){
                    panel_payment.setVisible(false);
                    JPanel panel_change = Discount_Main.getPanel_discount();
                    panel_change.setVisible(true);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GoBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GoBack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // "처음으로" 버튼 기능 구축
        JLabel ToStart = new JLabel();
        ToStart.setBounds(11, 11, (int) (74 / f), (int) (84 / f));
        ToStart.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(!P_Buttons.action){
                    SICT_Menu.clearLpanel2();
                    panel_payment.setVisible(false);
                    JPanel panel1 = BaskinRobbins_Main.getPanel1();

                    P_Buttons.action = false;
                    P_Buttons.Black_S.setVisible(false);
                    P_Buttons.Black_A.setVisible(false);
                    P_Buttons.SamsungPay_L.setVisible(false);
                    P_Buttons.ApplepayL.setVisible(false);

                    panel_payment.revalidate();
                    panel_payment.repaint();

                    SICT_Menu.order_count = 0;
                    AM_Menu.order_count = 0;

                    panel1.setVisible(true);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ToStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ToStart.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // "결제 수단을 선택해주세요." 라벨 추가
        JLabel TEXT_L = new JLabel("결제 수단을 선택히주세요.");
        TEXT_L.setOpaque(true);
        TEXT_L.setBackground(new Color(245, 245, 245));
        TEXT_L.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 10, 115, 400, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            TEXT_L.setFont(BMJUA.deriveFont(24f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel OrderLabel = new JLabel();
        OrderLabel.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 10, 135, 100, 50);
        OrderLabel.setForeground(new Color(182, 182, 182));
        FrameWork frameWork = new FrameWork();
        String ordervalue = frameWork.Ordervalue();
        if (ordervalue.equals("먹고가기")) {
            OrderLabel.setText("먹고가기");
        }
        if (ordervalue.equals("가져가기")) {
            OrderLabel.setText("가져가기");
        }
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            OrderLabel.setFont(BMJUA.deriveFont(20f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel Select_Done = new JLabel("");
        Select_Done.setBounds(250, 800, (int) (494 / f) - 10, (int) (80 / f));
        Select_Done.setOpaque(false);
        Select_Done.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(!P_Buttons.action){
                    panel_payment.setVisible(false);
                    SICT_Menu.clearLpanel2();
                    panel_payment.setVisible(false);
                    JPanel panel1 = BaskinRobbins_Main.getPanel1();
                    panel1.setVisible(true);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Select_Done.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Select_Done.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        P_Price.Money_Label(panel_payment);

        P_Buttons.CreditCard_SamsungPay(panel_payment);
        P_Buttons.Apple_T_SPC(panel_payment);
        P_Buttons.Coupon_QR(panel_payment);
        P_Buttons.Card_Point(panel_payment);
        P_Buttons.Bill(panel_payment);


        panel_payment.add(TEXT_L);
        panel_payment.add(Select_Done);
        panel_payment.add(OrderLabel);
        panel_payment.add(ToStart);
        panel_payment.add(GoBack);
        panel_payment.add(Background);
    }
}
