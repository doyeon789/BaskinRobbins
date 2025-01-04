package SelectType;

import CheckAgain.OrderDone_Main;
import SelectType.Option.Option_Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static SelectType.SelectIceCreamType_Main.panel2;

public class SICT_Menu {
    static float f = 1.69160305F;

    static JPanel Lpanel1 = new JPanel();  // 내부 패널1
    static JPanel Lpanel2 = new JPanel(); // 내부 패널2
    static boolean IorC;
    static JScrollPane scrollPane1; // scrollPane을 클래스 수준 변수로 선언
    static JScrollPane scrollPane2;
    static JLabel Select_Done;
    static JLabel Select_Done_Gray;
    static int i = 0;

    // 아이스크림 이미지 경로 배열
    static String[] IceCreamPath = {
            "Img/SICTImg/Menu/Icecream/SingleRegular.png",
            "Img/SICTImg/Menu/Icecream/SingleKing.png",
            "Img/SICTImg/Menu/Icecream/Pint.png",
            "Img/SICTImg/Menu/Icecream/Quarter.png",
            "Img/SICTImg/Menu/Icecream/Family.png"
    };

    // 케이크 이미지 경로 배열
    static String[] CakePath = {
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

    static int order_count = 0;

    public SICT_Menu(JPanel panel2, boolean IorC) {
        panel2.setVisible(true);
        SICT_Menu.IorC = IorC;

        GridLayout layout1 = new GridLayout(0, 3, 10, 15); // 3열, 행은 자동으로 증가, 가로 간격 10px, 세로 간격 15px
        // 내부 패널 설정
        Lpanel1.setOpaque(false);
        Lpanel1.setLayout(layout1);
        // 스크롤 패널 생성 및 설정
        scrollPane1 = new JScrollPane(Lpanel1);  // 클래스 변수로 선언된 scrollPane1 사용
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setOpaque(false);

        // 내부 패널 설정
        Lpanel2.setOpaque(false);
        Lpanel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
        // 스크롤 패널 생성 및 설정2
        scrollPane2 = new JScrollPane(Lpanel2);
        scrollPane2.setBounds(0, 650, 530, 350);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Allow horizontal scrolling
        scrollPane2.setBorder(BorderFactory.createEmptyBorder());
        scrollPane2.getViewport().setOpaque(false);
        scrollPane2.setOpaque(false);

        //다음 버튼 기본
        Select_Done_Gray = new JLabel("");
        Select_Done_Gray.setBounds(250,800, (int) (494/f)-10, (int) (80/f));
        ImageIcon Select_Done_GrayI = new ImageIcon("Img/SICTImg/SelectDone_Gray.png");
        Image Select_Done_Gray_img = Select_Done_GrayI.getImage();
        Image Select_Done_Gray_logo = Select_Done_Gray_img.getScaledInstance((int) (494/f)-10, (int) (80/f),Image.SCALE_SMOOTH);
        Select_Done_Gray.setIcon(new ImageIcon(Select_Done_Gray_logo));

        //다음 버튼 핑크
        Select_Done = new JLabel("");
        Select_Done.setBounds(250,800, (int) (494/f)-10, (int) (80/f));
        ImageIcon Select_DoneI = new ImageIcon("Img/SICTImg/SelectDone_Pink.png");
        Image Select_Done_img = Select_DoneI.getImage();
        Image Select_Done_logo = Select_Done_img.getScaledInstance((int) (494/f)-10, (int) (80/f),Image.SCALE_SMOOTH);
        Select_Done.setIcon(new ImageIcon(Select_Done_logo));
        Select_Done.setVisible(false);

        // 패널 리로드
        panel2.revalidate();
        panel2.repaint();

        // 메인 패널에 스크롤 패널 추가
        panel2.setLayout(null);
        panel2.setOpaque(false);
        panel2.add(Select_Done);
        panel2.add(Select_Done_Gray);
        panel2.add(scrollPane1);
        panel2.add(scrollPane2);
    }

    // 아이스크림 또는 케이크 선택 함수
    public static void IceCream_or_Cake() {
        // 이미지 경로에 따라 이미지 로드
        loadImages1(panel2, IorC ? CakePath : IceCreamPath);
    }

    // 이미지 로드 함수
    private static void loadImages1(JPanel panel2, String[] imagePaths) {

        // 이미지 수에 따라 scrollPane의 크기 설정
        if(imagePaths.length >= 14){
            scrollPane1.setBounds(114, 185, 425, 413); // 위치 및 크기 설정 (이미지가 많을 때)
        } else {
            scrollPane1.setBounds(114, 185, 425, 275); // 위치 및 크기 설정 (이미지가 적을 때)
        }

        Lpanel1.removeAll(); // 패널에 있는 모든 컴포넌트 제거
        System.gc();  // 가비지 컬렉터 호출
        System.gc();
        System.gc();

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

            // 마우스 이벤트 리스너 수정
            label.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (imagePaths.length >= 14) { // 케이크 선택 시
                        // 주문한 갯수 카운트
                        order_count++;

                        // 이미지 복사 및 Lpanel2에 추가
                        ImageIcon copiedIcon = new ImageIcon(label_logo);
                        JLabel copiedLabel = new JLabel(copiedIcon);
                        copiedLabel.setHorizontalAlignment(JLabel.CENTER);
                        copiedLabel.setVerticalAlignment(JLabel.CENTER);
                        copiedLabel.setBorder(BorderFactory.createEmptyBorder());

                        Lpanel2.add(copiedLabel);  // Lpanel2에 추가
                    } else { // 아이스크림 선택 시
                        // 아이스크림 컵 or 컵 선택
                        //주문 창 옵션 선택 클래스 불러오기
                        Option_Main.O_main();

                        // 이미지 복사 및 Lpanel2에 추가
                        ImageIcon copiedIcon = new ImageIcon(label_logo);
                        JLabel copiedLabel = new JLabel(copiedIcon);
                        copiedLabel.setHorizontalAlignment(JLabel.CENTER);
                        copiedLabel.setVerticalAlignment(JLabel.CENTER);
                        copiedLabel.setBorder(BorderFactory.createEmptyBorder());

                        Lpanel2.add(copiedLabel);  // Lpanel2에 추가
                    }

                    Select_Done.setVisible(true);
                    if(Select_Done.isVisible()){

                        Select_Done.addMouseListener(new MouseAdapter() {
                            public void mousePressed(MouseEvent e){
                                panel2.setVisible(false);
                                // 메뉴 선태 확인
                                OrderDone_Main.OD_main();
                            }

                            public void mouseEntered(MouseEvent e) {
                                super.mouseEntered(e);
                                Select_Done.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            }

                            public void mouseExited(MouseEvent e) {
                                super.mouseExited(e);
                                Select_Done.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            }
                        });
                    }

                    // Lpanel2를 다시 그려서 추가한 컴포넌트가 보이도록 함
                    Lpanel2.revalidate();
                    Lpanel2.repaint();
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
            Lpanel1.add(label); // 패널에 이미지 추가
        }

        Lpanel1.revalidate();
        Lpanel1.repaint();

        Lpanel2.revalidate();
        Lpanel2.repaint();

        panel2.revalidate();  // 패널 리로드
        panel2.repaint();

        IorC = !IorC; // IorC 값을 반전
    }
    public static void clearLpanel2(){
        Lpanel2.removeAll();
    }
}
