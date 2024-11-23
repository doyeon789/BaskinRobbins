package StartPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Timer;

//SeelctType 파일의 SelecIceCreamType_Main 함수 콜
import SelectType.SelectIceCreamType_Main;

public class FrameWork {
    static float f = 1.69160305F;
    static String ordervlaue;

    static JLabel OrderB1;
    static JLabel OrderB2;
    static JLabel X_bt;


    // 기본 프레임 설정
    public static void Frame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //사이즈 설정
        frame.setSize(570, 900);
        int x = 50;
        int y = ((screenSize.height - 900) / 2) - 20;
        frame.setLocation(x, y);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 패널 작성 코드
    public static void Panel(JPanel panel1, JFrame frame) {
        panel1.setLayout(null);
        panel1.setBounds(0,0,570,900);
        panel1.setBackground(new Color(247, 247, 247));
        panel1.setVisible(true);
        frame.add(panel1);

        //주문 버튼1 작성 코드
        JLabel Order1 = new JLabel();
        Order1.setBounds((570 / 2) - ((int) (804 / f) / 2) + 20, 640, 190, 171);
        ImageIcon od1 = new ImageIcon("Img/StartStepImg/Order1.png");
        Image od_img1 = od1.getImage();
        Image od_logo1 = od_img1.getScaledInstance(190, 171, 4);
        Order1.setIcon(new ImageIcon(od_logo1));
        Order1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                OrderUI(panel1);
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Order1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Order1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // 주문 버튼2 작성코드
        JLabel Order2 = new JLabel();
        Order2.setBounds((570 / 2) + 20, 640, 190, 171);
        ImageIcon od2 = new ImageIcon("Img/StartStepImg/Order2.png");
        Image od_img2 = od2.getImage();
        Image od_logo2 = od_img2.getScaledInstance(190, 171, 4);
        Order2.setIcon(new ImageIcon(od_logo2));
        Order2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                OrderUI(panel1);
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Order2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Order2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });


        // 메이커 라벨 작성
        JLabel maker = new JLabel("made by. doyeon");
        maker.setFont(new Font("Arial", Font.BOLD, 14));
        maker.setForeground(new Color(240, 81, 160));
        maker.setBounds(15, 845, 130, 20);
        maker.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String url = "https://www.instagram.com/7._d.yn/";
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (URISyntaxException | IOException var4) {
                    throw new RuntimeException(var4);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                maker.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                maker.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel backgroundW = new JLabel();
        backgroundW.setOpaque(true);
        backgroundW.setBounds((570 - (int) (804 / f)) / 2, 12, (int) (804 / f), (int) (1046 / f));
        backgroundW.setBackground(Color.WHITE);

        // 광고창 함수 호출
        Advertisement(panel1);

        panel1.add(backgroundW);
        panel1.add(Order1);
        panel1.add(Order2);
        panel1.add(maker);

        panel1.revalidate();
        panel1.repaint();
    }

    public static void Advertisement(JPanel panel) {
        // 광고 순서 정렬
        final String[] Img_path1 = {"Img/StartStepImg/Ad1.png","Img/StartStepImg/Ad3.png","Img/StartStepImg/Ad2.png"};
        final String[] Img_path2 = {"Img/StartStepImg/Ad2.png","Img/StartStepImg/Ad1.png","Img/StartStepImg/Ad3.png"};

        final int width = (int) (804 / f);
        final int panelWidth1 = 0;
        final int panelWidth2 = panel.getWidth();

        // 광고 프레임
        JLabel backframe = new JLabel();
        backframe.setBounds((570 - (int) (804 / f)) / 2, 12, (int) (804 / f), (int) (1046 / f));
        ImageIcon bfI = new ImageIcon("Img/StartStepImg/backframe.png");
        Image bf_img = bfI.getImage();
        Image bf_logo = bf_img.getScaledInstance((int) (804 / f), (int) (1046 / f), Image.SCALE_SMOOTH);
        backframe.setIcon(new ImageIcon(bf_logo));

        // 광고 넘어가는 공간 가리기1 (왼쪽)
        JLabel backside1 = new JLabel();
        backside1.setBounds(0, 12,47,(int) (1046 / f));
        backside1.setBackground(new Color(247,247,247));
        backside1.setOpaque(true);
        panel.add(backside1);
        // 광고 넘어가는 공간 가리기2 (오른쪽)
        JLabel backside2 = new JLabel();
        backside2.setBounds( ((570 - (int) (804 / f)) / 2) +  (int) (804/f), 12,48,(int) (1046 / f));
        backside2.setBackground(new Color(247,247,247));
        backside2.setOpaque(true);
        panel.add(backside2);

        // 임시 광고 창1
        JLabel Ad1 = new JLabel();
        Ad1.setBounds((570 - (int) (804 / f)) / 2, 12, (int) (804 / f), (int) (1046 / f));
        ImageIcon ad1I = new ImageIcon(Img_path1[0]);
        Image ad1_img = ad1I.getImage();
        Image ad1_logo = ad1_img.getScaledInstance((int) (804 / f), (int) (1046 / f), Image.SCALE_SMOOTH);
        Ad1.setIcon(new ImageIcon(ad1_logo));

        // 임시 광고 창2
        JLabel Ad2 = new JLabel();
        Ad2.setBounds(panel.getWidth(), 12, (int) (804 / f), (int) (1046 / f));
        ImageIcon ad2I = new ImageIcon(Img_path2[0]);
        Image ad2_img = ad2I.getImage();
        Image ad2_logo = ad2_img.getScaledInstance((int) (804 / f), (int) (1046 / f), Image.SCALE_SMOOTH);
        Ad2.setIcon(new ImageIcon(ad2_logo));

        // 광고 넘어가는 코드 작성
        Timer animation_m = new Timer();
        TimerTask animationTimer = new TimerTask() {
            int path_cnt1 = 0;
            int path_cnt2 = 0;

            int xPos1 = panelWidth1;
            int xPos2 = (panelWidth2) - 44;

            @Override
            public void run() {
                // 광고 넘기기1
                if (xPos1 > -width) {
                    xPos1 -= 6;
                    Ad1.setLocation(xPos1, 12);

                    panel.revalidate();
                    panel.repaint();
                }
                else {
                    xPos1 = panel.getWidth();

                    // 광고 임시 창에 광고 바꾸기1
                    path_cnt1++;
                    if (path_cnt1 >= Img_path1.length) {
                        path_cnt1 = 0;
                    }

                    ImageIcon ad1I = new ImageIcon(Img_path1[path_cnt1]);
                    Image ad1_img = ad1I.getImage();
                    Image ad1_logo = ad1_img.getScaledInstance((int) (804 / f), (int) (1046 / f), Image.SCALE_SMOOTH);
                    Ad1.setIcon(new ImageIcon(ad1_logo));

                    xPos2 = (570 - (int) (804 / f)) / 2;
                    panel.revalidate();
                    panel.repaint();

                    try {
                        // 5초 대기
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                // 광고 넘긱기 2
                if (xPos2 > -(width)){
                    xPos2 -= 6;
                    Ad2.setLocation(xPos2, 12);

                    panel.revalidate();
                    panel.repaint();
                }
                else {
                    xPos2 = panel.getWidth();

                    // 광고 임시 창에 광고 바꾸기1
                    path_cnt2++;
                    if (path_cnt2 >= Img_path2.length) {
                        path_cnt2 = 0;
                    }
                    ImageIcon ad2I = new ImageIcon(Img_path2[path_cnt2]);
                    Image ad2_img = ad2I.getImage();
                    Image ad2_logo = ad2_img.getScaledInstance((int) (804 / f), (int) (1046 / f), Image.SCALE_SMOOTH);
                    Ad2.setIcon(new ImageIcon(ad2_logo));

                    xPos1 = (570 - (int) (804 / f)) / 2;
                    panel.revalidate();
                    panel.repaint();

                    try {
                        //6초 대기
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };
        animation_m.schedule(animationTimer, 6000,16);

        panel.add(backframe);
        panel.add(Ad1);
        panel.add(Ad2);
    }

    // 주문 버튼 눌렀을때 작동
    public static void OrderUI(JPanel panel1) {

        // 배경을 어둡게 하기
        JLabel Black = new JLabel();
        Black.setBounds(0, 0, panel1.getWidth(), panel1.getHeight());
        Black.setBackground(new Color(0, 0, 0, 128)); // 검은색 반투명 배경
        Black.setOpaque(true);

        // 주문 기본 창
        JLabel TogoForhere = new JLabel();
        TogoForhere.setBounds((panel1.getWidth() - (int) (724 / f))/2 , 135, (int) (724 / f), (int) (1002 / f));
        ImageIcon tfI = new ImageIcon("Img/StartStepImg/TogoForhere.png");
        Image ad2_img = tfI.getImage();
        Image ad2_logo = ad2_img.getScaledInstance((int) (724 / f), (int) (1002 / f), Image.SCALE_SMOOTH);
        TogoForhere.setIcon(new ImageIcon(ad2_logo));

        // 가져가기 버튼
        OrderB1 = new JLabel();
        OrderB1.setBounds(108, 370, 145,145);
        OrderB1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                ordervlaue = "가져가기";
                panel1.setVisible(false);
                SelectIceCreamType_Main.SICT_main();

                panel1.remove(Black);
                panel1.remove(TogoForhere);
                panel1.remove(X_bt);
                panel1.remove(OrderB1);
                panel1.remove(OrderB2);

                panel1.revalidate();
                panel1.repaint();
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                OrderB1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                OrderB1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // 먹고가기 버튼
        OrderB2 = new JLabel();
        OrderB2.setBounds(301, 370, 145,145);
        OrderB2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                ordervlaue = "먹고가기";
                panel1.setVisible(false);
                SelectIceCreamType_Main.SICT_main();

                panel1.remove(Black);
                panel1.remove(TogoForhere);
                panel1.remove(X_bt);
                panel1.remove(OrderB1);
                panel1.remove(OrderB2);

                panel1.revalidate();
                panel1.repaint();
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                OrderB2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                OrderB2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // 취소 버튼
        X_bt = new JLabel();
        X_bt.setBounds(459,140,35,35);
        X_bt.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                panel1.remove(Black);
                panel1.remove(TogoForhere);
                panel1.remove(X_bt);
                panel1.remove(OrderB1);
                panel1.remove(OrderB2);

                panel1.revalidate();
                panel1.repaint();
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                X_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                X_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel1.add(Black, 0);
        panel1.add(TogoForhere,0);
        panel1.add(X_bt,0);
        panel1.add(OrderB1,0);
        panel1.add(OrderB2,0);

        panel1.revalidate();
        panel1.repaint();
    }

    public String Ordervalue() {
        return ordervlaue;
    }
}