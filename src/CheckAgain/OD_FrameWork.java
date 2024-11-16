package CheckAgain;

import SelectType.SICT_Menu;
import StartPage.BaskinRobbins_Main;
import StartPage.FrameWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import static SelectType.Select_Taste.ST_Main.getPanel4;

public class OD_FrameWork {
    static float f = 1.69160305F;

    static JPanel Opanel = new JPanel();
    static JScrollPane OscrollPane;
    static JLabel Moremenu;

    static int total_price = 0;

    static int SG_price = 3900;
    static int SG_count = 1;

    public static void Panel(JPanel panel5, JFrame frame) {
        panel5.setLayout(null);
        panel5.setBounds(frame.getBounds());
        panel5.setBackground(new Color(247, 247, 247));
        frame.add(panel5);
        panel5.setVisible(true);

        // 기본 사진 넣기
        JLabel Background = new JLabel();
        Background.setOpaque(false);
        Background.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon BackgroundI = new ImageIcon("Img/CheckAgain/Background.png");
        Image Background_img = BackgroundI.getImage();
        Image Background_logo = Background_img.getScaledInstance(1138 / 2, 1743 / 2, Image.SCALE_SMOOTH);
        Background.setIcon(new ImageIcon(Background_logo));

        // "처음으로" 버튼 기능 구축
        JLabel ToStart = new JLabel();
        ToStart.setBounds(11, 11, (int) (74 / f), (int) (84 / f));
        ToStart.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                SICT_Menu.clearLpanel2();
                panel5.setVisible(false);
                JPanel panel1 = BaskinRobbins_Main.getPanel1();
                panel1.setVisible(true);
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

        // "맛을 선택해 주세요." 라벨 추가
        JLabel CO = new JLabel("주문 내용을 확인해 주세요.");
        CO.setOpaque(true);
        CO.setBackground(new Color(243, 243, 243));
        CO.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 10, 115, 250, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            CO.setFont(BMJUA.deriveFont(24f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // "먹고가기" or "가져가기" 라벨 선정 및 추가
        JLabel OrderLabel = new JLabel();
        OrderLabel.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 10, 135, 160, 50);
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

        // 내부 패널 설정
        Opanel.setOpaque(false);
        Opanel.setLayout(null); // null 레이아웃 사용

        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(916 / 2, 2100 / 2));
        layeredPane.setLayout(null);

        // SG 패널 설정 (검은색 네모)
        SGPane(Opanel,panel5);

        Moremenu = new JLabel();
        Moremenu.setOpaque(false);
        Moremenu.setBounds(10, 10 + 123, 1012 / 2, 178 / 2);
        ImageIcon MoremenuI = new ImageIcon("Img/CheckAgain/MoreMenu.png");
        Image Moremenu_img = MoremenuI.getImage();
        Image Moremenu_logo = Moremenu_img.getScaledInstance(1012 / 2, 178 / 2, Image.SCALE_SMOOTH);
        Moremenu.setIcon(new ImageIcon(Moremenu_logo));
        Opanel.add(Moremenu);

        // Opanel에 layeredPane 추가
        Opanel.add(layeredPane);

        // 스크롤 패널 생성 및 설정
        OscrollPane = new JScrollPane(Opanel);
        OscrollPane.setBounds(5, 200, 565, 456);
        OscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        OscrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        OscrollPane.setBorder(BorderFactory.createEmptyBorder());
        OscrollPane.getViewport().setOpaque(false);
        OscrollPane.setOpaque(false);

        panel5.add(OscrollPane,0);

        panel5.add(CO);
        panel5.add(OrderLabel);
        panel5.add(ToStart);
        panel5.add(Background);
    }
    public static void SGPane(JPanel Opanel,JPanel panel5){
        JPanel SG = new JPanel();
        SG.setBounds(0, 10, 1122/ 2, 246 / 2); // 위치와 크기 설정
        SG.setLayout(null);

        JLabel RSLabel = new JLabel();
        RSLabel.setOpaque(false);
        RSLabel.setBounds(0, 0, 1122/ 2, 246 / 2);
        ImageIcon RSLabelI = new ImageIcon("Img/CheckAgain/RSLabel.png");
        Image RSLabel_img = RSLabelI.getImage();
        Image RSLabel_logo = RSLabel_img.getScaledInstance(1122/ 2, 246/ 2, Image.SCALE_SMOOTH);
        RSLabel.setIcon(new ImageIcon(RSLabel_logo));

        JLabel SG_Price = new JLabel(String.valueOf(SG_price));
        SG_Price.setForeground(Color.black);
        SG_Price.setBounds(490,61,100,70);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            SG_Price.setFont(BMJUA.deriveFont(22f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel SG_Count = new JLabel(String.valueOf(SG_count));
        SG_Count.setForeground(Color.black);
        SG_Count.setBounds(56,54,100,70);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            SG_Count.setFont(BMJUA.deriveFont(16f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel RSwon = new JLabel("₩");
        RSwon.setForeground(Color.black);
        RSwon.setBounds(457,63,100,70);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Jalnan2.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            RSwon.setFont(BMJUA.deriveFont(18f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JLabel RSedit = new JLabel();
        RSedit.setBounds(498,11,25,25);
        RSedit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {


                // 여기에 새로운 패너러 만들기
                //JPanel panel4 = getPanel4();
                //panel4.setVisible(true);

                panel5.revalidate();
                panel5.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                RSedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                RSedit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });


        JLabel RSdelete = new JLabel();
        RSdelete.setBounds(527,13,23,23);
        RSdelete.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Opanel.remove(SG);

                Moremenu.setLocation(Moremenu.getX(),Moremenu.getY() - 123);

                panel5.revalidate();
                panel5.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                RSdelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                RSdelete.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel RSplus = new JLabel();
        RSplus.setBounds(75,84,16,16);
        RSplus.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                SG_price += 3900;
                SG_count++;

                SG_Count.setText(String.valueOf(SG_count));
                SG_Price.setText(String.valueOf(SG_price));

                panel5.revalidate();
                panel5.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                RSplus.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                RSplus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel RSminus = new JLabel();
        RSminus.setBounds(29,84,16,16);
        RSminus.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                SG_price -= 3900;
                SG_count--;
                if(SG_price <= 3900){
                    SG_price = 3900;
                }
                if(SG_count <= 1){
                    SG_count = 1;
                }
                SG_Count.setText(String.valueOf(SG_count));
                SG_Price.setText(String.valueOf(SG_price));

                panel5.revalidate();
                panel5.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                RSminus.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                RSminus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        SG.add(RSminus);
        SG.add(RSplus);
        SG.add(RSedit);
        SG.add(RSdelete);
        SG.add(RSwon);
        SG.add(SG_Count);
        SG.add(SG_Price);
        SG.add(RSLabel);
        Opanel.add(SG);
    }

}