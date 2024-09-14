package SelectType;

import SelectType.SICT_Menu;
import StartPage.FrameWork;
import StartPage.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class SICT_FrameWork {
    static float f = 1.69160305F;

    public static void Frame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // 처음 Main화면 지우기
        Main main = new Main();
        JFrame StartPage_frame = main.getFrame();
        StartPage_frame.dispose();

        // frame 기본 설정
        frame.setSize(570, 900);
        int x = 50;
        int y = ((screenSize.height - 900) / 2) - 20;
        frame.setLocation(x, y);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void Panel(JPanel panel, JFrame frame) {
        // panel 기본 설정
        panel.setLayout(null);
        panel.setBounds(frame.getBounds());
        panel.setBackground(new Color(247, 247, 247));
        frame.add(panel);

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
                Main main = new Main();
                main.main(new String[]{});
                frame.dispose();
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

        // 메뉴 추가 창 추가 하는 곳
        SICT_Menu menu = new SICT_Menu();
        menu.IceCream(panel, frame);

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
            OrderLabel.setFont(BMJUA.deriveFont(17f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        panel.add(OrderLabel);
        panel.add(PSM);
        panel.add(ToStart);
        panel.add(Background);
    }
}
