package SelectType;

import SelectType.Option.Option_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static SelectType.SelectIceCreamType_Main.panel2;

public class SICT_Menu {

    static JPanel Lpanel = new JPanel();  // 내부 패널
    static boolean IorC;
    static JScrollPane scrollPane1; // scrollPane을 클래스 수준 변수로 선언

    static int order_count = 0;

    public SICT_Menu(JPanel panel2, boolean IorC) {
        panel2.setVisible(true);
        this.IorC = IorC;
        GridLayout layout = new GridLayout(0, 3, 10, 15); // 3열, 행은 자동으로 증가, 가로 간격 10px, 세로 간격 15px

        // 내부 패널 설정
        Lpanel.setOpaque(false);
        Lpanel.setLayout(layout);

        // 스크롤 패널 생성 및 설정
        scrollPane1 = new JScrollPane(Lpanel);  // 클래스 변수로 선언된 scrollPane1 사용
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setOpaque(false);

        // 패널 리로드
        panel2.revalidate();
        panel2.repaint();

        // 메인 패널에 스크롤 패널 추가
        panel2.setLayout(null);
        panel2.setOpaque(false);
        panel2.add(scrollPane1);
    }

    // 아이스크림 또는 케이크 선택 함수
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

        // 이미지 경로에 따라 이미지 로드
        loadImages(panel2, IorC ? CakePath : IceCreamPath);
    }

    // 이미지 로드 함수
    private static void loadImages(JPanel panel2, String[] imagePaths) {

        // 이미지 수에 따라 scrollPane의 크기 설정
        if(imagePaths.length >= 14){
            scrollPane1.setBounds(114, 185, 425, 413); // 위치 및 크기 설정 (이미지가 많을 때)
        } else {
            scrollPane1.setBounds(114, 185, 425, 275); // 위치 및 크기 설정 (이미지가 적을 때)
        }

        Lpanel.removeAll(); // 패널에 있는 모든 컴포넌트 제거
        System.gc();  // 가비지 컬렉터 호출
        System.gc();
        System.gc();

        int i = 0; // 이미지 인덱스 변수

        // 이미지 추가
        for (String path : imagePaths) {
            ImageIcon icon = new ImageIcon(path);
            JLabel label = new JLabel(icon);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setBorder(BorderFactory.createEmptyBorder());

            // 이미지 크기 조정
            ImageIcon labelI = new ImageIcon(path);
            Image label_img = labelI.getImage();
            Image label_logo = label_img.getScaledInstance(245 / 2, 255 / 2, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(label_logo));

            int finalI = i;
            // 마우스 이벤트 리스너 추가
            label.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if(imagePaths.length >= 14){ // 케이크 선택 시
                        System.out.println("cake : " + finalI + "번째 사진 선택함");

                        // 주문한 갯수 카운트
                        order_count++;
                    }
                    else { // 아이스크림 선택 시
                        System.out.println("icecream : " + finalI + "번째 사진 선택함");

                        // 아이스크림 컵 or 컵 선택
                        //주문 창 옵션 선택 클래스 불러오기
                        Option_Main optionMain = new Option_Main();
                        optionMain.O_main(IorC);
                    }

                }
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    label.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 변경
                }

                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 마우스 커서 기본값으로 변경
                }
            });

            i++;
            Lpanel.add(label); // 패널에 이미지 추가
        }

        Lpanel.revalidate();
        Lpanel.repaint();
        panel2.revalidate();  // 패널 리로드
        panel2.repaint();

        IorC = !IorC; // IorC 값을 반전
    }

    // 선택한 메뉴 처리 함수
    public static void Ordered_Menu(){

    }
}
