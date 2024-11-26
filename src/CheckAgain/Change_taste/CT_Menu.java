package CheckAgain.Change_taste;

import CheckAgain.OrderDone_Main;
import SelectType.Option.Option_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CT_Menu {
    static float f = 1.69160305F;


    static JPanel Lpanel = new JPanel();
    static JScrollPane scrollPane;

    static JLabel Select_Done;
    static JLabel Select_Done_Gray;
    static int i = 0;

    // 아이스크림 이미지 경로 배열
    static String[] IceCreamPath = {
            "Img/SICTImg/Select_Taste/IceCreamsLabel/31yogurt.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/alponsomango.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/amIainsypener.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/amondbongbong.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/applemint.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/areyouT.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/bonjour_maca.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/cherryjubellay.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/chitos_milkshake_ice.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/chocolate.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/chocolate_chip.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/chocolate_mooth.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/disappear_with_wind.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/fallinlovestrawberry.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/greentea.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/jamokaamondfuji.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/jjondeuk_goonghab.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/mintchocolatechip.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/mymotherisalian.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/najubea_sorubea.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/newyork_cheesecake.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/oreocookieandcream.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/pastachioamond.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/rainbow_syabet.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/salut_milk_icecream.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/shooting_star.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/strange_country_cloud_candy.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/sweet_potato.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/witchssecret.png",
            "Img/SICTImg/Select_Taste/IceCreamsLabel/youaresodalgona.png",
    };

    static int order_count = 0;

    public CT_Menu(JPanel panel_change) {
        panel_change.setVisible(true);

        GridLayout layout = new GridLayout(0,4,7,11); // 4열, 행은 자동으로 증가, 가로 간격 7px, 세로 간격 11px
        // 내부 패널 설정
        Lpanel.setOpaque(false);
        Lpanel.setLayout(layout);
        // 스크롤 패널 생성 및 설정
        scrollPane = new JScrollPane(Lpanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);

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
        panel_change.revalidate();
        panel_change.repaint();

        // 메인 패널에 스크롤 패널 추가
        panel_change.setLayout(null);
        panel_change.setOpaque(false);
        panel_change.add(Select_Done);
        panel_change.add(Select_Done_Gray);
        panel_change.add(scrollPane);
    }

    public static void IceCreamsMenu(JPanel panel_change){
        loadImages(panel_change,IceCreamPath);
    }

    // 이미지 로드 함수
    private static void loadImages(JPanel panel_change, String[] imagePaths) {

        // 이미지 수에 따라 scrollPane의 크기 설정
        if(imagePaths.length >= 14){
            scrollPane.setBounds(114, 185, 425, 413); // 위치 및 크기 설정 (이미지가 많을 때)
        } else {
            scrollPane.setBounds(114, 185, 425, 275); // 위치 및 크기 설정 (이미지가 적을 때)
        }

        Lpanel.removeAll(); // 패널에 있는 모든 컴포넌트 제거
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
            Image label_logo = label_img.getScaledInstance(188 / 2, 196 / 2, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(label_logo));

            // 마우스 이벤트 리스너 수정
            label.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    order_count++;

                    // 이미지 복사 및 Lpanel에 추가
                    ImageIcon copiedIcon = new ImageIcon(label_logo);
                    JLabel copiedLabel = new JLabel(copiedIcon);
                    copiedLabel.setHorizontalAlignment(JLabel.CENTER);
                    copiedLabel.setVerticalAlignment(JLabel.CENTER);
                    copiedLabel.setBorder(BorderFactory.createEmptyBorder());

                    System.out.println(path);

                    // 아이스크림 보이게 하기

                    Select_Done.setVisible(true);
                    if(Select_Done.isVisible()){

                        Select_Done.addMouseListener(new MouseAdapter() {
                            public void mousePressed(MouseEvent e){
                                panel_change.setVisible(false);
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
                    Lpanel.revalidate();
                    Lpanel.repaint();
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

        panel_change.revalidate();  // 패널 리로드
        panel_change.repaint();

    }
    public static void clearLpanel(){
        Lpanel.removeAll();
    }
}
