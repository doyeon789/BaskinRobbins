package StartPage;

import javax.swing.*;

public class Main {
    static JFrame frame;
    static JPanel panel;

    public static void main(String[] args) {
        // 기본 프레임 및 패널 작성
        frame = new JFrame("Baskin Robbins");
        panel = new JPanel();

        // 프레임, 패널 편집
        FrameWork.Frame(frame);
        FrameWork.Panel(panel,frame);

        // 리로드
        panel.revalidate();
        panel.repaint();
    }
    // 다른 클래스에 이 프레임을 전달하기 위한 함수
    public JFrame getFrame() {
        return frame;
    }
}
