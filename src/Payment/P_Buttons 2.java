package Payment;

import SelectType.SICT_Menu;
import StartPage.BaskinRobbins_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class P_Buttons {

    public static JLabel Black_S;
    public static JLabel Black_A;
    public static JLabel SamsungPay_L;
    public static JLabel ApplepayL;

    public static volatile int ordernumber = 788;

    public static JLabel BillL;
    public static JLabel OrderDone_L;
    public static JLabel OrderDone_T;

    static boolean action = false;

    public static void Bill(JPanel panel_payment) {
        ordernumber++;

        BillL = new JLabel();
        BillL.setOpaque(false);
        BillL.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon Bill_I = new ImageIcon("Img/Payment/BILL.PNG");
        Image Bill_img = Bill_I.getImage();
        Image Bill_logo = Bill_img.getScaledInstance(1138 / 2, 1743 / 2, Image.SCALE_SMOOTH);
        BillL.setIcon(new ImageIcon(Bill_logo));
        BillL.setVisible(false);

        OrderDone_L = new JLabel();
        OrderDone_L.setOpaque(false);
        OrderDone_L.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon OrderDone_L_I = new ImageIcon("Img/Payment/Orderdone.PNG");
        Image OrderDone_L_img = OrderDone_L_I.getImage();
        Image OrderDone_L_logo = OrderDone_L_img.getScaledInstance(1138 / 2, 1743 / 2, Image.SCALE_SMOOTH);
        OrderDone_L.setIcon(new ImageIcon(OrderDone_L_logo));
        OrderDone_L.setVisible(false);

        OrderDone_T = new JLabel(String.valueOf(ordernumber));
        OrderDone_T.setOpaque(false);
        OrderDone_T.setBounds(240, 430, 400, 50);
        OrderDone_T.setForeground(new Color(183, 0, 84));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            OrderDone_T.setFont(BMJUA.deriveFont(52f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        OrderDone_T.setVisible(false);

        JLabel Print = new JLabel();
        Print.setOpaque(false);
        Print.setBounds(98, 624, 179, 47);
        Print.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (BillL.isVisible()) {
                    BillL.setVisible(false);
                    OrderDone_L.setVisible(true);
                    OrderDone_T.setVisible(true);

                    // Timer 설정
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            SICT_Menu.clearLpanel2();
                            panel_payment.setVisible(false);
                            JPanel panel1 = BaskinRobbins_Main.getPanel1();

                            BillL.setVisible(false);
                            OrderDone_L.setVisible(false);
                            OrderDone_T.setVisible(false);

                            P_Buttons.action = false;
                            P_Buttons.Black_S.setVisible(false);
                            P_Buttons.Black_A.setVisible(false);
                            P_Buttons.SamsungPay_L.setVisible(false);
                            P_Buttons.ApplepayL.setVisible(false);

                            panel_payment.revalidate();
                            panel_payment.repaint();

                            panel1.setVisible(true);
                        }
                    }, 2500);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Print.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Print.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel Yes = new JLabel();
        Yes.setOpaque(false);
        Yes.setBounds(302, 624, 179, 47);
        Yes.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (BillL.isVisible()) {
                    System.out.println("yes");
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Yes.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Yes.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel_payment.add(BillL, 0);
        panel_payment.add(OrderDone_L, 0);
        panel_payment.add(OrderDone_T, 0);
        panel_payment.add(Print, 0);
        panel_payment.add(Yes, 0);
    }

    public static void CreditCard_SamsungPay(JPanel panel_payment){
        // 배경을 어둡게 하기
        Black_S = new JLabel();
        Black_S.setBounds(0, 0, panel_payment.getWidth(), panel_payment.getHeight());
        Black_S.setBackground(new Color(0, 0, 0, 128)); // 검은색 반투명 배경
        Black_S.setOpaque(true);
        Black_S.setVisible(false);

        SamsungPay_L = new JLabel();
        SamsungPay_L.setOpaque(false);
        SamsungPay_L.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon SamsungPay_L_I = new ImageIcon("Img/Payment/SamsungpayL.PNG");
        Image SamsungPay_L_img = SamsungPay_L_I.getImage();
        Image SamsungPay_L_logo = SamsungPay_L_img.getScaledInstance(1138 / 2, 1743 / 2, Image.SCALE_SMOOTH);
        SamsungPay_L.setIcon(new ImageIcon(SamsungPay_L_logo));
        SamsungPay_L.setVisible(false);

        JLabel CreditCard_SamsungPay_T = new JLabel("신용카드/삼성페이");
        CreditCard_SamsungPay_T.setOpaque(false);
        CreditCard_SamsungPay_T.setBounds(94, 351, 400, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            CreditCard_SamsungPay_T.setFont(BMJUA.deriveFont(24f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        JLabel CreditCard_SamsungPay_L = new JLabel();
        CreditCard_SamsungPay_L.setOpaque(false);
        CreditCard_SamsungPay_L.setBounds(72,250,214,158);

        CreditCard_SamsungPay_T.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CreditCard_SamsungPay_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CreditCard_SamsungPay_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        CreditCard_SamsungPay_L.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(!action){
                    action = true;
                    Black_S.setVisible(true);
                    SamsungPay_L.setVisible(true);

                    panel_payment.revalidate();
                    panel_payment.repaint();

                    Loading(panel_payment);
                }
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CreditCard_SamsungPay_L.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CreditCard_SamsungPay_L.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel_payment.add(CreditCard_SamsungPay_L);
        panel_payment.add(CreditCard_SamsungPay_T);
        panel_payment.add(Black_S,0);
        panel_payment.add(SamsungPay_L,0);
    }
    public static void Coupon_QR(JPanel panel_payment){
        JLabel Coupon_QR_L = new JLabel();
        Coupon_QR_L.setOpaque(false);
        Coupon_QR_L.setBounds(297,250,214,158);

        JLabel Coupon_QR_T1 = new JLabel("모바일 교환권 쿠폰");
        Coupon_QR_T1.setOpaque(false);
        Coupon_QR_T1.setBounds(326, 346, 400, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Coupon_QR_T1.setFont(BMJUA.deriveFont(21f));
        } catch (FontFormatException | IOException e) {

        }
        JLabel Coupon_QR_T2 = new JLabel("바코드 QR");
        Coupon_QR_T2.setOpaque(false);
        Coupon_QR_T2.setBounds(362, 370, 400, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Coupon_QR_T2.setFont(BMJUA.deriveFont(21f));
        } catch (FontFormatException | IOException e) {
        }

        Coupon_QR_L.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("모바일 교환권 쿠폰_바코드 QR");
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Coupon_QR_L.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Coupon_QR_L.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        Coupon_QR_T1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("모바일 교환권 쿠폰_바코드 QR");
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Coupon_QR_T1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Coupon_QR_T1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        Coupon_QR_T2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("신용카드/삼섬페이");
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Coupon_QR_T2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Coupon_QR_T2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });



        panel_payment.add(Coupon_QR_L);
        panel_payment.add(Coupon_QR_T1);
        panel_payment.add(Coupon_QR_T2);
    }
    public static void Apple_T_SPC(JPanel panel_payment){

        // 배경을 어둡게 하기
        Black_A = new JLabel();
        Black_A.setBounds(0, 0, panel_payment.getWidth(), panel_payment.getHeight());
        Black_A.setBackground(new Color(0, 0, 0, 128)); // 검은색 반투명 배경
        Black_A.setOpaque(true);
        Black_A.setVisible(false);

        ApplepayL = new JLabel();
        ApplepayL.setOpaque(false);
        ApplepayL.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon ApplepayL_I = new ImageIcon("Img/Payment/ApplepayL.PNG");
        Image ApplepayL_img = ApplepayL_I.getImage();
        Image ApplepayL_logo = ApplepayL_img.getScaledInstance(1138 / 2, 1743 / 2, Image.SCALE_SMOOTH);
        ApplepayL.setIcon(new ImageIcon(ApplepayL_logo));
        ApplepayL.setVisible(false);

        JLabel Apple_T_SPC_L = new JLabel();
        Apple_T_SPC_L.setOpaque(false);
        Apple_T_SPC_L.setBounds(72,423,214,158);


        JLabel Apple_T_SPC_T1 = new JLabel("애플페이 교통카드");
        Apple_T_SPC_T1.setOpaque(false);
        Apple_T_SPC_T1.setBounds(107, 513, 400, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Apple_T_SPC_T1.setFont(BMJUA.deriveFont(21f));
        } catch (FontFormatException | IOException e) {

        }
        JLabel Apple_T_SPC_T2 = new JLabel("SPC 사원증");
        Apple_T_SPC_T2.setOpaque(false);
        Apple_T_SPC_T2.setBounds(130, 537, 400, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Apple_T_SPC_T2.setFont(BMJUA.deriveFont(21f));
        } catch (FontFormatException | IOException e) {

        }

        Apple_T_SPC_L.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(!action){
                    action = true;
                    Black_A.setVisible(true);
                    ApplepayL.setVisible(true);

                    panel_payment.revalidate();
                    panel_payment.repaint();

                    Loading(panel_payment);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Apple_T_SPC_L.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Apple_T_SPC_L.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        Apple_T_SPC_T1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Apple_T_SPC_T1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Apple_T_SPC_T1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        Apple_T_SPC_T2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Apple_T_SPC_T2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Apple_T_SPC_T2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });


        panel_payment.add(Apple_T_SPC_L);
        panel_payment.add(Apple_T_SPC_T1);
        panel_payment.add(Apple_T_SPC_T2);
        panel_payment.add(Black_A,0);
        panel_payment.add(ApplepayL,0);
    }
    public static void Card_Point(JPanel panel_payment) {
        JLabel Card_Point_L = new JLabel();
        Card_Point_L.setOpaque(false);
        Card_Point_L.setBounds(297, 423, 214, 158);

        JLabel CreditCard_SamsungPay_T = new JLabel("카드사 포인트");
        CreditCard_SamsungPay_T.setOpaque(false);
        CreditCard_SamsungPay_T.setBounds(342, 524, 400, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            CreditCard_SamsungPay_T.setFont(BMJUA.deriveFont(24f));
        } catch (FontFormatException | IOException e) {

        }
        Card_Point_L.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("카드사 포인트");
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Card_Point_L.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Card_Point_L.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        CreditCard_SamsungPay_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("카드사 포인트");
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CreditCard_SamsungPay_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CreditCard_SamsungPay_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel_payment.add(Card_Point_L);
        panel_payment.add(CreditCard_SamsungPay_T);
    }

    public static void Loading(JPanel panel_payment) {
        String[] Loading_img = {
                "Img/Payment/Loading/loading1.PNG",
                "Img/Payment/Loading/loading2.PNG",
                "Img/Payment/Loading/loading3.PNG",
                "Img/Payment/Loading/loading4.PNG",
                "Img/Payment/Loading/loading5.PNG",
                "Img/Payment/Loading/loading6.PNG",
                "Img/Payment/Loading/loading7.PNG"
        };



        JLabel loadingLabel = new JLabel();
        loadingLabel.setBounds(0,0,1138/2,1743/2);
        panel_payment.add(loadingLabel, 0);
        panel_payment.revalidate();
        panel_payment.repaint();

        Timer timer = new Timer();
        final int[] currentIndex = {0};

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerTask imageSwitcher = new TimerTask() {
                    @Override
                    public void run() {
                        if (currentIndex[0] < Loading_img.length) {
                            ImageIcon icon = new ImageIcon(Loading_img[currentIndex[0]]);
                            Image img = icon.getImage().getScaledInstance(1138/2, 1743/2, Image.SCALE_SMOOTH);
                            loadingLabel.setIcon(new ImageIcon(img));
                            panel_payment.repaint();
                            currentIndex[0]++;
                        }
                        else {
                            timer.cancel();

                            loadingLabel.setVisible(false);
                            SamsungPay_L.setVisible(false);
                            ApplepayL.setVisible(false);

                            BillL.setVisible(true);

                            panel_payment.revalidate();
                            panel_payment.repaint();
                        }
                    }
                };
                timer.scheduleAtFixedRate(imageSwitcher, 0, 170);
            }
        }, 1500);
    }
}
