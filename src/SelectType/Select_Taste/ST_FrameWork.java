package SelectType.Select_Taste;

import SelectType.SICT_Menu;
import StartPage.BaskinRobbins_Main;
import StartPage.FrameWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class ST_FrameWork {
    static float f = 1.69160305F;

    static JLabel Recommend;
    static JLabel All;
    static JLabel Fruit;
    static JLabel Chocolate;
    static JLabel MilkCheese;
    static JLabel CoffeCaramelTea;
    static JLabel VanillaMint;
    static JLabel GrainNuts;

    public static void Panel(JPanel panel4,JFrame frame){

        // panel2 기본 설정
        panel4.setLayout(null);
        panel4.setBounds(frame.getBounds());
        panel4.setBackground(new Color(247, 247, 247));
        frame.add(panel4);

        // 기본 사진 넣기
        JLabel Background = new JLabel();
        Background.setOpaque(false);
        Background.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon BackgroundI = new ImageIcon("Img/SICTImg/Select_Taste/T_Background.png");
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
                panel4.setVisible(false);
                // 가장 처음 패널 보이게 설정
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

        //다음 버튼 기본
        JLabel Select_Done_Gray = new JLabel("");
        Select_Done_Gray.setBounds(250,800, (int) (494/f)-10, (int) (80/f));
        ImageIcon Select_Done_GrayI = new ImageIcon("Img/SICTImg/SelectDone_Gray.png");;
        Image Select_Done_Gray_img = Select_Done_GrayI.getImage();
        Image Select_Done_Gray_logo = Select_Done_Gray_img.getScaledInstance((int) (494/f)-10, (int) (80/f),Image.SCALE_SMOOTH);
        Select_Done_Gray.setIcon(new ImageIcon(Select_Done_Gray_logo));

        //다음 버튼 핑크
        JLabel Select_Done = new JLabel("");
        Select_Done.setBounds(250,800, (int) (494/f)-10, (int) (80/f));
        ImageIcon Select_DoneI = new ImageIcon("Img/SICTImg/SelectDone_Pink.png");;
        Image Select_Done_img = Select_DoneI.getImage();
        Image Select_Done_logo = Select_Done_img.getScaledInstance((int) (494/f)-10, (int) (80/f),Image.SCALE_SMOOTH);
        Select_Done.setIcon(new ImageIcon(Select_Done_logo));
        Select_Done.setVisible(false);

        // "맛을 선택해 주세요." 라벨 추가
        JLabel PST = new JLabel("맛을 선택해 주세요.");
        PST.setOpaque(true);
        PST.setBackground(new Color(247, 247, 247));
        PST.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 10, 115, 200, 30);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            PST.setFont(BMJUA.deriveFont(24f));
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
        Recommend = new JLabel("추천 맛");
        Recommend.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 31, 215, 100, 50);
        Recommend.setForeground(new Color(240, 81, 160));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Recommend.setFont(BMJUA.deriveFont(14f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        Recommend.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214); // 106/2
                CoffeCaramelTea.setForeground(new Color(30,33,39));
                MilkCheese.setForeground(new Color(30,33,39));
                Chocolate.setForeground(new Color(30,33,39));
                Fruit.setForeground(new Color(30,33,39));
                All.setForeground(new Color(30,33,39));
                Recommend.setForeground(new Color(240, 81, 160));
                VanillaMint.setForeground(new Color(30,33,39));
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Recommend.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Recommend.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        All = new JLabel("전체 맛");
        All.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 31, 214+(106/2)*1, 100, 50);
        All.setForeground(new Color(30,33,39));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            All.setFont(BMJUA.deriveFont(14f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        All.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2));
                Recommend.setForeground(new Color(30,33,39));
                CoffeCaramelTea.setForeground(new Color(30,33,39));
                MilkCheese.setForeground(new Color(30,33,39));
                Chocolate.setForeground(new Color(30,33,39));
                Fruit.setForeground(new Color(30,33,39));
                All.setForeground(new Color(240, 81, 160));
                VanillaMint.setForeground(new Color(30,33,39));
                GrainNuts.setForeground(new Color(30,33,39));
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                All.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                All.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Fruit = new JLabel("과일", JLabel.CENTER);
        Fruit.setBounds(((frame.getWidth() - (int) (920 / f)) / 2)-2, 322, 100, 50);
        Fruit.setForeground(new Color(30, 33, 39));
        Fruit.setHorizontalAlignment(JLabel.CENTER);
        Fruit.setVerticalAlignment(JLabel.CENTER);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Fruit.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        Fruit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                // 케이크 메뉴창 불러오기
                //menu.Recommend_or_Cake();
                // 주문한 케이크 처리 함수 불러오기
                //menu.Ordered_Menu();

                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*2);
                Recommend.setForeground(new Color(30,33,39));
                CoffeCaramelTea.setForeground(new Color(30,33,39));
                MilkCheese.setForeground(new Color(30,33,39));
                Chocolate.setForeground(new Color(30,33,39));
                Fruit.setForeground(new Color(240, 81, 160));
                All.setForeground(new Color(30,33,39));
                VanillaMint.setForeground(new Color(30,33,39));
                GrainNuts.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Fruit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Fruit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Chocolate = new JLabel("초콜릿");
        Chocolate.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 31, 374, 100, 50);
        Chocolate.setForeground(new Color(30,33,39));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            Chocolate.setFont(BMJUA.deriveFont(14f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        Chocolate.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*3);
                CoffeCaramelTea.setForeground(new Color(30,33,39));
                MilkCheese.setForeground(new Color(30,33,39));
                Chocolate.setForeground(new Color(240, 81, 160));
                Fruit.setForeground(new Color(30,33,39));
                All.setForeground(new Color(30,33,39));
                Recommend.setForeground(new Color(30,33,39));
                VanillaMint.setForeground(new Color(30,33,39));
                GrainNuts.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Chocolate.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Chocolate.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        MilkCheese = new JLabel("우유 치즈", JLabel.CENTER);
        MilkCheese.setBounds(((frame.getWidth() - (int) (920 / f)) / 2)-2, 427, 100, 50);
        MilkCheese.setForeground(new Color(30, 33, 39));
        MilkCheese.setHorizontalAlignment(JLabel.CENTER);
        MilkCheese.setVerticalAlignment(JLabel.CENTER);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            MilkCheese.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        MilkCheese.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*4);
                CoffeCaramelTea.setForeground(new Color(30,33,39));
                MilkCheese.setForeground(new Color(240, 81, 160));
                Chocolate.setForeground(new Color(30,33,39));
                Fruit.setForeground(new Color(30,33,39));
                All.setForeground(new Color(30,33,39));
                Recommend.setForeground(new Color(30,33,39));
                VanillaMint.setForeground(new Color(30,33,39));
                GrainNuts.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                MilkCheese.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                MilkCheese.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        CoffeCaramelTea = new JLabel("<html><body style='text-align:center;'>커피 카라멜<br />티</body></html>\"");
        CoffeCaramelTea.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 20, 481, 100, 50);
        CoffeCaramelTea.setForeground(new Color(30,33,39));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            CoffeCaramelTea.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        CoffeCaramelTea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*5);
                CoffeCaramelTea.setForeground(new Color(240, 81, 160));
                MilkCheese.setForeground(new Color(30,33,39));
                Chocolate.setForeground(new Color(30,33,39));
                Fruit.setForeground(new Color(30,33,39));
                All.setForeground(new Color(30,33,39));
                Recommend.setForeground(new Color(30,33,39));
                VanillaMint.setForeground(new Color(30,33,39));
                GrainNuts.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CoffeCaramelTea.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CoffeCaramelTea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });


        VanillaMint = new JLabel("<html><body style='text-align:center;'>바닐라<br />민트</body></html>\"");
        VanillaMint.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 31, 481+54, 100, 50);
        VanillaMint.setForeground(new Color(30,33,39));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            VanillaMint.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        VanillaMint.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*6);
                VanillaMint.setForeground(new Color(240, 81, 160));
                CoffeCaramelTea.setForeground(new Color(30,33,39));
                MilkCheese.setForeground(new Color(30,33,39));
                Chocolate.setForeground(new Color(30,33,39));
                Fruit.setForeground(new Color(30,33,39));
                All.setForeground(new Color(30,33,39));
                Recommend.setForeground(new Color(30,33,39));
                GrainNuts.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                VanillaMint.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                VanillaMint.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        GrainNuts = new JLabel("<html><body style='text-align:center;'>곡물<br />견과류</body></html>\"");
        GrainNuts.setBounds(((frame.getWidth() - (int) (920 / f)) / 2) + 31, 481+54*2, 100, 50);
        GrainNuts.setForeground(new Color(30,33,39));
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            GrainNuts.setFont(BMJUA.deriveFont(13f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        GrainNuts.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Selected.setLocation(((frame.getWidth() - (int) (920 / f)) / 2)+9 ,214+(106/2)*7+5);
                GrainNuts.setForeground(new Color(240, 81, 160));
                VanillaMint.setForeground(new Color(30,33,39));
                CoffeCaramelTea.setForeground(new Color(30,33,39));
                MilkCheese.setForeground(new Color(30,33,39));
                Chocolate.setForeground(new Color(30,33,39));
                Fruit.setForeground(new Color(30,33,39));
                All.setForeground(new Color(30,33,39));
                Recommend.setForeground(new Color(30,33,39));
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                VanillaMint.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                VanillaMint.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });



        panel4.add(Select_Done);
        panel4.add(Select_Done_Gray);

        panel4.add(Recommend);
        panel4.add(All);
        panel4.add(Fruit);
        panel4.add(Chocolate);
        panel4.add(MilkCheese);
        panel4.add(CoffeCaramelTea);
        panel4.add(VanillaMint);
        panel4.add(GrainNuts);
        panel4.add(Selected);

        panel4.add(PST);
        panel4.add(OrderLabel);
        panel4.add(ToStart);
        panel4.add(Background);
    }


}