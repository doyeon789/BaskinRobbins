package SelectType;

import javax.swing.*;
import java.awt.*;

import static SelectType.SelectIceCreamType_Main.panel;

public class SICT_Menu {
     static JPanel Lpanel = new JPanel();
     static boolean IorC;
     public SICT_Menu(JPanel panel, boolean IorC){
        this.IorC = IorC;
        System.out.println("test");
        GridLayout layout = new GridLayout(0, 3, 10, 15); // 3열, 행은 자동 증가, 가로 간격 10px, 세로 간격 15px

        // 내부 패널
        Lpanel.setOpaque(false);
        Lpanel.setLayout(layout);

        // 스크롤 패널 생성 및 설정
        JScrollPane scrollPane = new JScrollPane(Lpanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(114, 185, 425, 275); // 위치 및 크기 설정
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);

        // 리로드
        panel.revalidate();
        panel.repaint();

        // 패널에 스크롤 패널 추가
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(scrollPane);

    }
    public static void IceCream_or_Cake() {

        // 아이스크림 이미지 경로 배열
        String[] IceCreamPath = {
                "Img/SICTImg/Menu/Icecream/SingleRegular.png",
                "Img/SICTImg/Menu/Icecream/SingleKing.png",
                "Img/SICTImg/Menu/Icecream/Pint.png",
                "Img/SICTImg/Menu/Icecream/Quarter.png",
                "Img/SICTImg/Menu/Icecream/Family.png"
        };

        // 케이크 이미지 경로 배열
        String[] CakePath = {
                "Img/SICTImg/Menu/Cake/AllAboutChocolate.png",
                "Img/SICTImg/Menu/Cake/AwesomeLionInSafari.png",
                "Img/SICTImg/Menu/Cake/BlueSufferBeachCake.png",
                "Img/SICTImg/Menu/Cake/Choose27Cake.png",
                "Img/SICTImg/Menu/Cake/HappyBirthdayCake.png",
                "Img/SICTImg/Menu/Cake/HappyHipoInSafari.png",
                "Img/SICTImg/Menu/Cake/HappyJoyCube.png",
                "Img/SICTImg/Menu/Cake/HappySmileForYou.png",
                "Img/SICTImg/Menu/Cake/Heart_ShapedSandCake.png",
                "Img/SICTImg/Menu/Cake/MiniHappyBirthdayCake.png",
                "Img/SICTImg/Menu/Cake/SharingCubeWYW.png",
                "Img/SICTImg/Menu/Cake/SweetStrawberryPopBear.png",
                "Img/SICTImg/Menu/Cake/TheBestNo.6.png",
                "Img/SICTImg/Menu/Cake/TwinkleZanmangLoopy.png"
        };

        // 초기화 및 이미지 로드 함수
        loadImages(panel, IorC ? CakePath : IceCreamPath);


    }

    private static void loadImages(JPanel panel, String[] imagePaths) {

        System.out.println("kbs :"+imagePaths.length);

        Lpanel.removeAll(); // 패널에 있는 모든 컴포넌트 제거
        System.gc();
        System.gc();
        System.gc();

        // 이미지 추가
        for (String path : imagePaths) {
            ImageIcon icon = new ImageIcon(path);
            JLabel label = new JLabel(icon);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setBorder(BorderFactory.createEmptyBorder());

            // 이미지 변경
            ImageIcon labelI = new ImageIcon(path);
            Image label_img = labelI.getImage();
            Image label_logo = label_img.getScaledInstance(245 / 2, 255 / 2, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(label_logo));
            Lpanel.add(label);
            System.out.println(path);
        }
        for(Component c : Lpanel.getComponents()){
            if(c instanceof JLabel)
                System.out.println("kbs1 : "+ c);
        }

        Lpanel.revalidate();
        Lpanel.repaint();
        // 리로드
        panel.revalidate();
        panel.repaint();

        IorC = !IorC;
    }
}
