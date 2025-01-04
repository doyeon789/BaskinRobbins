package SelectType.Option;

import SelectType.SICT_Menu;
import SelectType.SelectIceCreamType_Main;
import SelectType.Select_Taste.ST_Main;
import StartPage.BaskinRobbins_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Option_FrameWork {

    static float f = 1.69160305F;

    static int cup_num = 0;
    static int corn_num = 0;


    public static void Panel(JPanel panel3, JFrame frame){

        // panel3 기본 설정
        panel3.setLayout(null);
        panel3.setBounds(0,0,570, 900);
        panel3.setBackground(new Color(247, 247, 247));
        panel3.setVisible(true);
        frame.add(panel3);

        JPanel panel2 = SelectIceCreamType_Main.getPanel2();
        panel2.setVisible(false);

        // 기본 사진 넣기
        JLabel Background = new JLabel();
        Background.setOpaque(false);
        Background.setBounds(0, 0, 1138 / 2, 1743 / 2);
        ImageIcon BackgroundI = new ImageIcon("Img/SICTImg/Option/Option_Background.png");
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
                panel3.setVisible(false);
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
        ImageIcon Select_Done_GrayI = new ImageIcon("Img/SICTImg/SelectDone_Gray.png");
        Image Select_Done_Gray_img = Select_Done_GrayI.getImage();
        Image Select_Done_Gray_logo = Select_Done_Gray_img.getScaledInstance((int) (494/f)-10, (int) (80/f),Image.SCALE_SMOOTH);
        Select_Done_Gray.setIcon(new ImageIcon(Select_Done_Gray_logo));

        //다음 버튼 핑크
        JLabel Select_Done = new JLabel("");
        Select_Done.setBounds(250,800, (int) (494/f)-10, (int) (80/f));
        ImageIcon Select_DoneI = new ImageIcon("Img/SICTImg/SelectDone_Pink.png");
        Image Select_Done_img = Select_DoneI.getImage();
        Image Select_Done_logo = Select_Done_img.getScaledInstance((int) (494/f)-10, (int) (80/f),Image.SCALE_SMOOTH);
        Select_Done.setIcon(new ImageIcon(Select_Done_logo));
        Select_Done.setVisible(false);

        // 선택된 창 핑크색으로 바꾸기(cup)
        JLabel Selected_cup = new JLabel("");
        Selected_cup.setOpaque(false);
        Selected_cup.setBounds(65, 278, 362 / 2+1, 362 / 2+1);
        ImageIcon Selected_cupI = new ImageIcon("Img/SICTImg/Option/Selected_Pink.png");
        Image Selected_cup_img = Selected_cupI.getImage();
        Image Selected_cup_logo = Selected_cup_img.getScaledInstance(362 / 2+1, 362 / 2+1, Image.SCALE_SMOOTH);
        Selected_cup.setIcon(new ImageIcon(Selected_cup_logo));
        Selected_cup.setVisible(false);

        // 선택된 창 핑크색으로 바꾸기(corn)
        JLabel Selected_corn = new JLabel("");
        Selected_corn.setOpaque(false);
        Selected_corn.setBounds(315, 278, 362 / 2+1, 362 / 2+1);
        ImageIcon Selected_cornI = new ImageIcon("Img/SICTImg/Option/Selected_Pink.png");
        Image Selected_corn_img = Selected_cornI.getImage();
        Image Selected_corn_logo = Selected_corn_img.getScaledInstance(362 / 2+1, 362 / 2+1, Image.SCALE_SMOOTH);
        Selected_corn.setIcon(new ImageIcon(Selected_corn_logo));
        Selected_corn.setVisible(false);

        cup_num = 0;
        corn_num = 0;

        // 컵 숫자 출력
        JLabel cup_number = new JLabel("");
        cup_number.setText(String.valueOf(corn_num));
        cup_number.setBounds(104+44,398,32,32);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            cup_number.setFont(BMJUA.deriveFont(24f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // 콘 숫자 출력
        JLabel corn_number = new JLabel("");
        corn_number.setText(String.valueOf(corn_num));
        corn_number.setBounds(355+44,398,32,32);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            corn_number.setFont(BMJUA.deriveFont(24f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }



        // 컵 -
        JLabel cup_m = new JLabel("");
        cup_m.setBounds(104, 398,32,32);
        cup_m.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                cup_num--;
                if(cup_num <= 0) {
                    Selected_cup.setVisible(false);
                    cup_num = 0;
                }
                cup_number.setText(String.valueOf(cup_num));
                Select_Done.setVisible(false);

            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cup_m.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                cup_m.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // 컵 +
        JLabel cup_p = new JLabel("");
        cup_p.setBounds(104 + 72,398,32,32);
        cup_p.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                cup_num++;
                Selected_cup.setVisible(true);
                cup_number.setText(String.valueOf(cup_num));
                Select_Done.setVisible(true);
                Select_Done.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        // 맛 고르기
                        ST_Main.ST_main();

                        // 현제 패널 안보이게 설정
                        panel3.setVisible(false);
                        // 이전 패널 보이게 설정
                        //panel2.setVisible(true);

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
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cup_p.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                cup_p.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // 콘 -
        JLabel corn_m = new JLabel("");
        corn_m.setBounds(355,398,32,32);
        corn_m.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                corn_num--;
                if(corn_num <= 0){
                    Selected_corn.setVisible(false);
                    corn_num = 0;
                }
                corn_number.setText(String.valueOf(corn_num));
                Select_Done.setVisible(false);
            }

            public void mouseEntered(MouseEvent e){
                super.mouseEntered(e);
                corn_m.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                corn_m.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // 콘 +
        JLabel corn_p = new JLabel("");
        corn_p.setBounds(355  + 72,398,32,32);
        corn_p.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                corn_num++;
                Selected_corn.setVisible(true);
                corn_number.setText(String.valueOf(corn_num));
                Select_Done.setVisible(true);
                Select_Done.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        // 맛 고르기
                        ST_Main.ST_main();

                        // 현제 패널 안보이게 설정
                        panel3.setVisible(false);
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
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                corn_p.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                corn_p.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel3.add(Select_Done);
        panel3.add(Select_Done_Gray);

        panel3.add(corn_number);
        panel3.add(cup_number);
        panel3.add(corn_m);
        panel3.add(corn_p);
        panel3.add(cup_m);
        panel3.add(cup_p);
        panel3.add(ToStart);
        panel3.add(Selected_cup,panel3.getComponentCount()-1);
        panel3.add(Selected_corn,panel3.getComponentCount()-1);
        panel3.add(Background);
    }
}
