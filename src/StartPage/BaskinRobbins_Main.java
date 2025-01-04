package StartPage;

import javax.swing.*;

public class BaskinRobbins_Main {
    public static JFrame frame;
    static JPanel panel1;

    public BaskinRobbins_Main(){
        // 기본 프레임 및 패널 작성
        frame = new JFrame("Baskin Robbins");
        panel1 = new JPanel();

        // 프레임, 패널 편집
        FrameWork.Frame(frame);
        FrameWork.Panel(panel1,frame);

        // 리로드
        panel1.revalidate();
        panel1.repaint();
    }

    // 다른 클래스에 이 프레임을 전달하기 위한 함수
    public static JFrame getFrame() {
        return frame;
    }
    // 다른 클래스에 이 패널을 전달하기 위한 함수
    public static JPanel getPanel1() {
        return panel1;
    }
}
