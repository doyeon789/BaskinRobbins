package SelectType;

import StartPage.BaskinRobbins_Main;
import StartPage.FrameWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class SICT_FrameWork {
    static float f = 1.69160305F;

    static JLabel IceCream;
    static JLabel Dessert;
    static JLabel BeverageBlast;
    static JLabel WhatYouWantCake;
    static JLabel IceCreamCake;
    static JLabel ReadyPackBlockPack;

    static boolean IorC = false;

    public static void Panel(JPanel panel2, JFrame frame) {

        IorC = false;

        // panel2 기본 설정
        panel2.setLayout(null);
        panel2.setBounds(0,0,570, 900);
        panel2.setBackground(new Color(247, 247, 247));
        panel2.setVisible(true);
        frame.add(panel2);

        // 기본 사진 넣기
        JLabel Background = new JLabel();
        Background.setOpaque(false);
        Background.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon BackgroundI = new ImageIcon("Img/SICTImg/BackGround.png");
        Image Background_img = BackgroundI.getImage();
        Image Background_logo = Background_img.getScaledInstance(1138 / 2, 1743 / 2, Image.SCALE_SMOOTH);
        Background.setIcon(new ImageIcon(Background_logo));

        // "처음으로" 버튼 기능 구축
        JLabel ToStart = new JLabel();
        ToStart.setBounds(11, 11, (int) (74 / f), (int) (84 / f));
        ToStart.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                SICT_Menu.clearLpanel2();
                // 현제 패널 안보이게 설정
                panel2.setVisible(false);
                // 가장 처음 패널 보이게 설정

                new BaskinRobbins_Main();
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

        // 메뉴 창 추가를 위해 클래스 불러오기
        SICT_Menu menu = new SICT_Menu(panel2,IorC);
        // 기본적으로 아이스키림 메뉴로 시작
        SICT_Menu.IceCream_or_Cake(); //IorC = false -> 아이스크림
        // 주문한 케이크 처리 함수 불러오기
        //menu.Ordered_Menu();


        // "메뉴를 선택해 주세요." 라벨 추가
        JLabel PSM = new JLabel("메뉴를 선택해 주세요.");
        PSM.setOpaque(true);
        PSM.setBackground(new Color(247, 247, 247));
        PSM.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 10, 115, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            PSM.setFont(BMJUA.deriveFont(24f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // "먹고가기" or "가져가기" 라벨 선정 및 추가
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

        // 선택된 상태 확인
        JLabel Selected =  new JLabel();
        Selected.setBounds(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214,158/2,106/2);
        ImageIcon SelectedI = new ImageIcon("Img/SICTImg/Selected.png");
        Image Selected_img = SelectedI.getImage();
        Image Selected_logo = Selected_img.getScaledInstance(158 / 2, 106 / 2, Image.SCALE_SMOOTH);
        Selected.setIcon(new ImageIcon(Selected_logo));


        // 메뉴 선택란
        IceCream = new JLabel("아이스크림");
        IceCream.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 21, 215, 100, 50);
        IceCream.setForeground(new Color(240, 81, 160));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            IceCream.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        IceCream.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                IorC = false;
                // 아이스크림 메뉴창 불러오기
                SICT_Menu.IceCream_or_Cake();
                // 주문한 케이크 처리 함수 불러오기

                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214); // 106/2
                Dessert.setForeground(new Color(30,33,39));
                BeverageBlast.setForeground(new Color(30,33,39));
                WhatYouWantCake.setForeground(new Color(30,33,39));
                IceCreamCake.setForeground(new Color(30,33,39));
                ReadyPackBlockPack.setForeground(new Color(30,33,39));
                IceCream.setForeground(new Color(240, 81, 160));
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                IceCream.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                IceCream.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        ReadyPackBlockPack = new JLabel("<html>레디팩<br>블록팩</html>");
        ReadyPackBlockPack.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 31, 267, 100, 50);
        ReadyPackBlockPack.setForeground(new Color(30,33,39));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            ReadyPackBlockPack.setFont(BMJUA.deriveFont(14f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        ReadyPackBlockPack.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2));
                IceCream.setForeground(new Color(30,33,39));
                Dessert.setForeground(new Color(30,33,39));
                BeverageBlast.setForeground(new Color(30,33,39));
                WhatYouWantCake.setForeground(new Color(30,33,39));
                IceCreamCake.setForeground(new Color(30,33,39));
                ReadyPackBlockPack.setForeground(new Color(240, 81, 160));
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ReadyPackBlockPack.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ReadyPackBlockPack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        IceCreamCake = new JLabel("<html><body style='text-align:center;'>아이스크림<br />케이크</body></html>", JLabel.CENTER);
        IceCreamCake.setBounds(((frame.getWidth() - (int) (920 / f)) / 2)-2, 322, 100, 50);
        IceCreamCake.setForeground(new Color(30, 33, 39));
        IceCreamCake.setHorizontalAlignment(JLabel.CENTER);
        IceCreamCake.setVerticalAlignment(JLabel.CENTER);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            IceCreamCake.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        IceCreamCake.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                IorC = true;
                // 케이크 메뉴창 불러오기
                menu.IceCream_or_Cake();
                // 주문한 케이크 처리 함수 불러오기
                //menu.Ordered_Menu();

                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*2);
                IceCream.setForeground(new Color(30,33,39));
                Dessert.setForeground(new Color(30,33,39));
                BeverageBlast.setForeground(new Color(30,33,39));
                WhatYouWantCake.setForeground(new Color(30,33,39));
                IceCreamCake.setForeground(new Color(240, 81, 160));
                ReadyPackBlockPack.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                IceCreamCake.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                IceCreamCake.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        WhatYouWantCake = new JLabel("<html>와츄원<br>케이크</html>");
        WhatYouWantCake.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 31, 374, 100, 50);
        WhatYouWantCake.setForeground(new Color(30,33,39));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            WhatYouWantCake.setFont(BMJUA.deriveFont(14f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        WhatYouWantCake.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*3);
                Dessert.setForeground(new Color(30,33,39));
                BeverageBlast.setForeground(new Color(30,33,39));
                WhatYouWantCake.setForeground(new Color(240, 81, 160));
                IceCreamCake.setForeground(new Color(30,33,39));
                ReadyPackBlockPack.setForeground(new Color(30,33,39));
                IceCream.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                WhatYouWantCake.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                WhatYouWantCake.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        BeverageBlast = new JLabel("<html><body style='text-align:center;'>음료<br />블라스트</body></html>", JLabel.CENTER);
        BeverageBlast.setBounds(((frame.getWidth() - (int) (920 / f)) / 2)-2, 427, 100, 50);
        BeverageBlast.setForeground(new Color(30, 33, 39));
        BeverageBlast.setHorizontalAlignment(JLabel.CENTER);
        BeverageBlast.setVerticalAlignment(JLabel.CENTER);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            BeverageBlast.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        BeverageBlast.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*4);
                Dessert.setForeground(new Color(30,33,39));
                BeverageBlast.setForeground(new Color(240, 81, 160));
                WhatYouWantCake.setForeground(new Color(30,33,39));
                IceCreamCake.setForeground(new Color(30,33,39));
                ReadyPackBlockPack.setForeground(new Color(30,33,39));
                IceCream.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                BeverageBlast.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                BeverageBlast.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Dessert = new JLabel("디저트");
        Dessert.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 33, 481, 100, 50);
        Dessert.setForeground(new Color(30,33,39));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Dessert.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        Dessert.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*5);
                Dessert.setForeground(new Color(240, 81, 160));
                BeverageBlast.setForeground(new Color(30,33,39));
                WhatYouWantCake.setForeground(new Color(30,33,39));
                IceCreamCake.setForeground(new Color(30,33,39));
                ReadyPackBlockPack.setForeground(new Color(30,33,39));
                IceCream.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Dessert.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Dessert.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel2.add(Dessert);
        panel2.add(BeverageBlast);
        panel2.add(WhatYouWantCake);
        panel2.add(IceCreamCake);
        panel2.add(ReadyPackBlockPack);
        panel2.add(IceCream);
        panel2.add(Selected);

        panel2.add(OrderLabel);
        panel2.add(PSM);
        panel2.add(ToStart);
        panel2.add(Background);
    }
}

