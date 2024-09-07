package SelectType;

import StartPage.*;

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

        // "처음으로" 버튼 생성 및 기능 구축
        JLabel ToStart = new JLabel();
        ToStart.setOpaque(true);
        ToStart.setBounds(0,0,(int) (74 / f), (int) (84 / f));
        ImageIcon ToStartI = new ImageIcon("Img/SICTImg/ToStart.png");
        Image ToStartI_img = ToStartI.getImage();
        Image ToStartI_logo = ToStartI_img.getScaledInstance((int) (74 / f), (int) (84 / f), Image.SCALE_SMOOTH);
        ToStart.setIcon(new ImageIcon(ToStartI_logo));
        ToStart.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
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

        // 주문 상태창 이미지 업로드
        JLabel State = new JLabel();
        State.setOpaque(true);
        State.setBounds((frame.getWidth() - (int) (920 / f))/2, 53,(int) (920 / f), (int) (78 / f));
        ImageIcon StateI = new ImageIcon("Img/SICTImg/State.png");
        Image State_img = StateI.getImage();
        Image State_logo = State_img.getScaledInstance((int) (920 / f), (int) (78 / f), Image.SCALE_SMOOTH);
        State.setIcon(new ImageIcon(State_logo));

        // "메뉴를 선택해 주세요." 라벨 추가
        // PSM = Plese Selec Menu
        JLabel PSM = new JLabel("메뉴를 선택해 주세요.");
        PSM.setBounds((frame.getWidth() - (int) (920 / f))/2,110,300,50);
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            PSM.setFont(BMJUA.deriveFont(28f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // "먹고가기" or "가져가기" 라벨 선정 및 추가
        JLabel OrderLabel = new JLabel();
        OrderLabel.setBounds((frame.getWidth() - (int) (920 / f))/2,140,100,50);
        OrderLabel.setForeground(new Color(182,182,182));
        FrameWork frameWork = new FrameWork();
        String ordervalue = frameWork.Ordervalue();
        if(ordervalue.equals("먹고가기")){
            OrderLabel.setText("먹고가기");
        }
        if(ordervalue.equals("가져가기")){
            OrderLabel.setText("가져가기");
        }
        try {
            Font BMJUA = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/BMJUA_otf.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(BMJUA);
            OrderLabel.setFont(BMJUA.deriveFont(19f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // 메뉴 선택란 배경
        JLabel GrayLabel = new JLabel();
        GrayLabel.setOpaque(true);
        GrayLabel.setBounds((frame.getWidth() - (int) (920 / f))/2, 230,(int) (148 / f), (int) (646 / f));
        ImageIcon GrayLabelI = new ImageIcon("Img/SICTImg/GrayLabel.png");
        Image GrayLabel_img = GrayLabelI.getImage();
        Image GrayLabel_logo = GrayLabel_img.getScaledInstance((int) (148 / f), (int) (646 / f), Image.SCALE_SMOOTH);
        GrayLabel.setIcon(new ImageIcon(GrayLabel_logo));

        // 얼마나 주문했는지 알려주는 라벨
        JLabel Count = new JLabel();
        Count.setOpaque(true);
        Count.setBounds((frame.getWidth() - (int) (920 / f))/2, 640,(int) (196 / f), (int) (68 / f));
        ImageIcon CountI = new ImageIcon("Img/SICTImg/Count.png");
        Image Count_img = CountI.getImage();
        Image Count_logo = Count_img.getScaledInstance((int) (196 / f), (int) (68 / f), Image.SCALE_SMOOTH);
        Count.setIcon(new ImageIcon(Count_logo));
        // Count에 들어가는 글자
        JLabel Count_Str = new JLabel("총     개");
        Count_Str.setBounds((frame.getWidth() - (int) (920 / f))/2+40,633,300,50);
        try {
            Font AppleSDGothicNeoR = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/AppleSDGothicNeoR.otf"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(AppleSDGothicNeoR);
            Count_Str.setFont(AppleSDGothicNeoR.deriveFont(19f));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        Count_Str.setForeground(Color.WHITE);


        panel.add(Count);
        panel.add(Count_Str,0);
        panel.add(GrayLabel);
        panel.add(OrderLabel);
        panel.add(PSM);
        panel.add(State);
        panel.add(ToStart);
    }
}
