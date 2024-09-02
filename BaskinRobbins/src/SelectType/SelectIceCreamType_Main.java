package SelectType;

import javax.swing.*;

public class SelectIceCreamType_Main {
    public static void SICT_main() {

        // 기본 프레임 및 패널 작성
        JFrame frame = new JFrame("Baskin Robbins");
        JPanel panel = new JPanel();

        // 프레임, 패널 편집
        SICT_FrameWork.Frame(frame);
        SICT_FrameWork.Panel(panel,frame);

        // 리로드
        panel.revalidate();
        panel.repaint();
    }
}







