package StartPage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // 기본 프레임 및 패널 작성
        JFrame frame = new JFrame("Baskin Robbins");
        JPanel panel = new JPanel();

        // 프레임, 패널 편집
        FrameWork.Frame(frame);
        FrameWork.Panel(panel,frame);
        
        // 리로드
        panel.revalidate();
        panel.repaint();
    }
}
