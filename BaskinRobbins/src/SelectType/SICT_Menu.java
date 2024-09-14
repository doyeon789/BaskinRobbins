package SelectType;

import javax.swing.*;
import java.awt.*;

public class SICT_Menu {
    static float f = 1.69160305F;

    public static void IceCream(JPanel panel, JFrame frame) {
        // 이미지 경로 배열
        String[] IceCreamPath = {
                "Img/SICTImg/Menu/Icecream/SingleRegular.png",
                "Img/SICTImg/Menu/Icecream/SingleKing.png",
                "Img/SICTImg/Menu/Icecream/Pint.png",
                "Img/SICTImg/Menu/Icecream/Quarter.png",
                "Img/SICTImg/Menu/Icecream/Family.png"
        };

        GridLayout layout = new GridLayout(0, 3, 10, 15); // 3열, 행은 자동 증가, 간격 10px

        // 스크롤 패널 생성
        JPanel Lpanel = new JPanel();
        Lpanel.setOpaque(false); // Lpanel을 투명하게 설정
        Lpanel.setLayout(layout);

        // 이미지 추가
        for (String path : IceCreamPath) {
            ImageIcon icon = new ImageIcon(path);
            JLabel label = new JLabel(icon);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setBorder(BorderFactory.createEmptyBorder());

            // 이미지 사이즈 조정
            Image img = icon.getImage(); // Image 객체 가져오기
            Image scaledImg = img.getScaledInstance(245 / 2, 255 / 2, Image.SCALE_SMOOTH); // 사이즈 조정
            icon = new ImageIcon(scaledImg); // 다시 ImageIcon으로 설정
            label.setIcon(icon);
            Lpanel.add(label); // 사진을 패널에 추가
        }

        // 스크롤 패널 생성 및 설정
        JScrollPane scrollPane = new JScrollPane(Lpanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(114, 185, 425, 275); // 원하는 위치와 크기로 설정

        // 스크롤 패널의 경계 제거 및 배경 투명화
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false); // JScrollPane도 투명하게 설정

        // 패널에 스크롤 패널 추가
        panel.setLayout(null); // 레이아웃 관리자를 null로 설정
        panel.setOpaque(false); // panel도 투명하게 설정
        panel.add(scrollPane);
    }
}
