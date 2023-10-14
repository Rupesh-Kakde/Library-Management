import mypanel.DashboardPanel;
import myutil.GradientPanel;
import myutil.PersonalDetails;
import myutil.RoundedBorderPanel;
import myutil.SetImageIcon;

import javax.net.ssl.SNIHostName;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;


class NewspaperPanel extends GradientPanel
{
    Color color1 = new Color(0xFCFCFC);
    Color color2 = new Color(0xC9A7DA);
    NewspaperPanel()
    {
        super();
        this.setStartColor(color1);
        this.setEndColor(color2);

        JLabel label = new JLabel("NewspaperPanel");
//        setBackground(new Color(0x41F87B));

        this.add(label);

    }

}class ReturnedPanel extends GradientPanel
{
    Color color1 = new Color(0xFCFCFC);
    Color color2 = new Color(0xC295DA);
    ReturnedPanel()
    {
        super();
        this.setStartColor(color1);
        this.setEndColor(color2);
        JLabel label = new JLabel("ReturnedPanel");


        this.add(label);
    }
}
class NotReturnedPanel extends GradientPanel
{
    Color color1 = new Color(0xFCFCFC);
    Color color2 = new Color(0xBF86DC);
    NotReturnedPanel()
    {
        super();
        this.setStartColor(color1);
        this.setEndColor(color2);
        JLabel label = new JLabel("NotReturned");
        this.add(label);
    }
}
class MagazinePanel extends GradientPanel
{
    Color color1 = new Color(0xFCFCFC);
    Color color2 = new Color(0xB76FDC);
    MagazinePanel()
    {
        super();
        this.setStartColor(color1);
        this.setEndColor(color2);
        JLabel label = new JLabel("MagazinePanel");


        this.add(label);
    }
}
class MemberPanel extends GradientPanel
{
    Color color1 = new Color(0xFCFCFC);
    Color color2 =new Color(0xB15DDC);
    MemberPanel()
    {
        super();
        this.setStartColor(color1);
        this.setEndColor(color2);
        JLabel label = new JLabel("MemberPanel");
//        setBackground(new Color(0xAAE1F5));
        this.add(label);
    }
}
class BooksPanel extends GradientPanel
{
    Color color1 = new Color(0xFCFCFC);
    Color color2 = new Color(0xA94CD9);
    BooksPanel()
    {
        super();
        this.setStartColor(color1);
        this.setEndColor(color2);
        JLabel label = new JLabel("BooksPanel");
        this.add(label);
    }
}class IssuedPanel extends GradientPanel
{
    Color color1 = new Color(0xFCFCFC);
    Color color2 = new Color(0xCEAFDE);
    IssuedPanel()
    {
        super();
        this.setStartColor(color1);
        this.setEndColor(color2);
        JLabel label = new JLabel("IssuedPanel");

        this.add(label);
    }
}
public class Home extends MyFrame implements WindowStateListener, MouseListener {
    Container home;

    JPanel side_menus_foot;
    JPanel side_menus_panel;
    JPanel list_panel;
    JPanel profile_panel;
    JPanel main_panel;
    JPanel foot_panel;
    JPanel head_panel;
    CardLayout card;
    JLabel dashboard,member,books,magazines,newspapers,returned,notReturned,issued;

    SetImageIcon dashboard_icon , member_icon,books_icon,magazine_icon,newspaper_icon,returned_icon,notReturned_icon,issued_icon;

    LineBorder PROFILE_PANEL_BORDER = new LineBorder(new Color(0x0F46E0), 1, true);

    private String username;
    private String  status;
    final Color LABLE_COLOR = new Color(0xE4E4EC);

    Home()
    {
        super("Home");
//        setSize(1200,800);
//        setLocation(100,50);
    }
    public  void initHome()
    {

        JLabel label = new JLabel("Welcome on home page");
        label.setBounds(100,100,200,30);
        setLayout(new BorderLayout());
        home = getContentPane();


        Color c1 = new Color(0xB3212A4B, true);
        Color c2 = new Color(0xFF0F162D);
        head_panel = new GradientPanel(c2,c1,getWidth(),40);
//      head_panel = new JPanel();
        FlowLayout f =new FlowLayout(FlowLayout.LEFT);
        f.setHgap(20);
        f.setVgap(8);
        head_panel.setLayout(f);
        JLabel head_panel_title = new JLabel("Library Management");
        head_panel_title.setFont(new Font("Arial",Font.BOLD,18));
        head_panel_title.setForeground(Color.white);
//        head_panel.setBackground(new Color(0x0F162D));


        head_panel.add(head_panel_title);

//        head_panel.setPreferredSize(new Dimension(getWidth(), 50));
//        head_panel.setBackground(new Color(0x0F162D));

        side_menus_panel  = getSideMenuPanel();

        main_panel = new JPanel();
        card = new CardLayout();
        main_panel.setLayout(card);

        DashboardPanel dashboardPanel = new DashboardPanel();
        dashboardPanel = dashboardPanel.initDashBoardPanel();
//        dashboardPanel.setBorder(PROFILE_PANEL_BORDER);

        MemberPanel  memberPanel = new MemberPanel();

        main_panel.add(dashboardPanel,"dashboard");
        main_panel.add(memberPanel,"member");
        main_panel.add(new NewspaperPanel(),"newspapers");
        main_panel.add(new ReturnedPanel(),"returned");
        main_panel.add(new NotReturnedPanel(),"notReturned");
        main_panel.add(new MagazinePanel(),"magazines");

        main_panel.add(new BooksPanel(),"books");
        main_panel.add(new IssuedPanel(),"issued");


        main_panel.setBackground(new Color(0xF2F2FF));

//        foot_panel = new GradientPanel();
        GradientPanel gp =  new GradientPanel(new Color(0x396CE3),getWidth(),40);
        gp.setDirectionLeft();
        foot_panel =gp;

        foot_panel.setPreferredSize(new Dimension(getWidth(), 30));
//        foot_panel.setBackground(new Color(0x2EBDEA));

        home.add(side_menus_panel , BorderLayout.WEST);
        home.add(main_panel , BorderLayout.CENTER);
        home.add(foot_panel , BorderLayout.SOUTH);
        home.add(head_panel , BorderLayout.NORTH);

//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu  = new JMenu("Save");
//
//        menuBar.setBackground(new Color(0x7C7CF1));
//        JMenuItem it = new JMenuItem("edit");
//        menu.add(it);
//        menuBar.add(menu);
//        setJMenuBar(menuBar);




        this.addWindowStateListener(this);
        setVisible(true);

    }

    public  JPanel getSideMenuPanel()
    {
        //parent panel for both
        JPanel side_menus_panel  = new JPanel();
        side_menus_panel.setPreferredSize(new Dimension(200,getHeight()));
        side_menus_panel.setLayout(new BorderLayout());
        side_menus_panel.setBackground(new Color(0xF23E3E48, true));
//        side_menus_panel.setBorder(PROFILE_PANEL_BORDER);

        //profile panel to show image and name

        FlowLayout f1=  new FlowLayout();

//        f1.setVgap(10);


        profile_panel = new JPanel(new BorderLayout());
        profile_panel.setPreferredSize(new Dimension(side_menus_panel.getWidth(), 100));
        profile_panel.setBackground(Color.white);


//        GradientPanel image_panel = new GradientPanel(new Color(0xBDBDF6),100,100);
        GradientPanel image_panel = new GradientPanel(new Color(0xFF081031, true),100,100);
        image_panel.setDirectionLeft();
        image_panel.add(new SetImageIcon(new ImageIcon("images/human_face1.jpg"),90,90)) ;
        profile_panel.add(image_panel , BorderLayout.WEST);

//        JPanel info = new GradientPanel(new Color(0xBDBDF6),100,100);
        JPanel info = new GradientPanel(new Color(0xE7E7EE),100,100);
        info.setLayout(new GridBagLayout());
        info.setPreferredSize(new Dimension(100,100));
        info.setBackground(new Color(0xD0F8D5));


        TitledBorder roundedTitledBorder = new TitledBorder(PROFILE_PANEL_BORDER, "Title");
//        image_panel.setBorder(roundedLineBorder);
//        info.setBorder(roundedLineBorder);
//        profile_panel.setBorder(PROFILE_PANEL_BORDER);
        GridBagConstraints info_gbc = new GridBagConstraints();

        info_gbc.gridx = 0;
        info_gbc.gridy = 0;
        info_gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        info_gbc.insets.left=10;
        info_gbc.insets.top=0;
        info_gbc.weightx=1;
//        info_gbc.weighty=1;

        JLabel status = new JLabel(this.status);
        info.add(status,info_gbc);
        info_gbc.insets.top=10;

        info_gbc.gridx = 0;
        info_gbc.gridy = 1;


        String user  = this.username;
//        JTextArea name = new JTextArea(username);
//        name.setPreferredSize(new Dimension(80,10));
//        name.setLineWrap(true);
//        name.setEditable(false);
//        name.setFont(new Font("Arial",Font.BOLD,10));
//        name.setOpaque(true);
        JLabel name = new JLabel(user);
        name.setForeground(new Color(0xE3336A));
        info.add(name,info_gbc);


        profile_panel.add(info,BorderLayout.CENTER);


        //foot panel for adding extra padding
        side_menus_foot = new JPanel();
        side_menus_foot.setPreferredSize(new Dimension(side_menus_panel.getWidth(),280));
        side_menus_foot.setBackground(new Color(0xF23E3E48, true));
        side_menus_foot.setVisible(false);

        //list panel to show all the menu
        list_panel = new JPanel();
        list_panel.setLayout(new GridBagLayout());
        list_panel.setPreferredSize(new Dimension(500, side_menus_panel.getHeight()-100));
        list_panel.setBackground(new Color(0xF23E3E48, true));



        GridBagConstraints gbc = new GridBagConstraints();
        ImageIcon icon = new ImageIcon("images/dashboard_icon.png");
        final int icon_width = 25;
        final int icon_height =25;

        //dashboard start
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy  = 1;
        gbc.weightx = 1;
        dashboard_icon = new SetImageIcon(icon ,icon_width,icon_height);
        list_panel.add(dashboard_icon,gbc);

        gbc.gridx = 1;
        gbc.gridy  = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        dashboard  = new JLabel("Dashboard");
//        dashboard.setBackground(new Color(0x0F46E0));
        dashboard.setForeground(LABLE_COLOR);
        dashboard.setOpaque(false);
        dashboard.addMouseListener(this);
        list_panel.add(dashboard,gbc);

        //member start
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy  = 2;
        gbc.ipady = 1;
        member_icon = new SetImageIcon(new ImageIcon("images/members_icon2.png"),icon_width,icon_height);
        list_panel.add(member_icon,gbc);


        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy  = 2;
        gbc.ipady=20;
        member  = new JLabel("Member");
        member.setForeground(LABLE_COLOR);
        member.setBackground(new Color(0xF3306A));
        member.setOpaque(false);
        list_panel.add(member,gbc);


        //books start
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy  = 3;
        gbc.ipady=1;
        books_icon = new SetImageIcon(new ImageIcon("images/books_icon.png"),icon_width,icon_height);
        list_panel.add(books_icon ,gbc);


        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy  = 3;
        gbc.ipady=20;
        books  = new JLabel("Books");
        books.setForeground(LABLE_COLOR);
        books.setBackground(new Color(0x0F152D));
        books.setOpaque(false);
        list_panel.add(books,gbc);


        //magazine start
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy  = 4;
        gbc.ipady=1;
        magazine_icon = new SetImageIcon(new ImageIcon("images/magazine_icon.png"),icon_width,icon_height);
        list_panel.add(magazine_icon,gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy  = 4;
        gbc.ipady=20;
        magazines  = new JLabel("Magazine");
        magazines.setForeground(LABLE_COLOR);
        magazines.setBackground(new Color(0x7C7CF1));
        magazines.setOpaque(false);
        list_panel.add(magazines,gbc);

        //newspaper
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy  = 5;
        gbc.ipady=1;
        newspaper_icon = new SetImageIcon(new ImageIcon("images/newspaper_icon.png"),icon_width,icon_height);
        list_panel.add( newspaper_icon,gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy  = 5;
        gbc.ipady=20;
        newspapers  = new JLabel("Newspaper");
        newspapers.setForeground(LABLE_COLOR);
        list_panel.add(newspapers,gbc);


        //issued
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy  = 6;
        gbc.ipady=1;
        issued_icon = new SetImageIcon(new ImageIcon("images/issued_icon.png"),icon_width,icon_height);
        list_panel.add(issued_icon ,gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy  = 6;
        gbc.ipady=20;
        issued  = new JLabel("Issued");
        issued.setForeground(LABLE_COLOR);
        list_panel.add(issued,gbc);


        //return books
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy  = 7;
        gbc.ipady=1;
        returned_icon = new SetImageIcon(new ImageIcon("images/return_book.png"),icon_width,icon_height);
        list_panel.add(returned_icon,gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy  = 7;
        gbc.ipady=20;
        returned  = new JLabel("Returned");
        returned.setForeground(LABLE_COLOR);
        list_panel.add(returned,gbc);


        //not returned books
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy  = 8;
        gbc.ipady=1;
        notReturned_icon = new SetImageIcon(new ImageIcon("images/not_return_icon.png") ,icon_width,icon_height);
        list_panel.add(notReturned_icon,gbc);


        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy  = 8;
        gbc.ipady=20;
        notReturned  = new JLabel("Not Returned");
        notReturned.setForeground(LABLE_COLOR);
        list_panel.add(notReturned,gbc);



        member.addMouseListener(this);
        newspapers.addMouseListener(this);
        magazines.addMouseListener(this);
        returned.addMouseListener(this);
        notReturned.addMouseListener(this);
        issued.addMouseListener(this);
        books.addMouseListener(this);

        member_icon.addMouseListener(this);
        newspaper_icon.addMouseListener(this);
        magazine_icon.addMouseListener(this);
        returned_icon.addMouseListener(this);
        notReturned_icon.addMouseListener(this);
        issued_icon.addMouseListener(this);
        books_icon.addMouseListener(this);

        side_menus_panel.add(profile_panel,BorderLayout.NORTH);
        side_menus_panel.add(list_panel ,BorderLayout.CENTER);
        side_menus_panel.add(side_menus_foot,BorderLayout.SOUTH);

        return  side_menus_panel;
    }

    public  void setPersonalDetails(PersonalDetails personalDetails)
    {
        this.username = personalDetails.getUsername();
        this.status = personalDetails.getStatus();

        System.out.println("this is from home");
        System.out.println(personalDetails.getName());
        System.out.println(personalDetails.getStatus());
        System.out.println(personalDetails.getUsername());
    }




    @Override
    public void windowStateChanged(WindowEvent e) {
        side_menus_foot.setVisible(e.getWindow().getHeight() > 800);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        Color c = new Color(0x589BE8);
//        Color c = new Color(0xB7D5FF);
//        Color c = new Color(0x9FC3EE);
//        Color c = new Color(0x5AEEB2);
//        Color c = new Color(0x5AEEB2);
//        Color c = new Color(0x021036);
        if(e.getSource()==dashboard || e.getSource()==dashboard_icon)
        {
            card.show(main_panel,"dashboard");
        }
        else if(e.getSource()==member|| e.getSource()==member_icon)
        {
            card.show(main_panel,"member");
        }
        else if(e.getSource()==newspapers || e.getSource()==newspapers)
        {
            card.show(main_panel,"newspapers");
        }
        else if(e.getSource()==magazines || e.getSource()==magazine_icon)
        {
            card.show(main_panel,"magazines");
        }
        else if(e.getSource()==returned || e.getSource()==returned_icon)
        {
            card.show(main_panel,"returned");
        }
        else if(e.getSource()==notReturned || e.getSource()==notReturned_icon)
        {
            card.show(main_panel,"notReturned");
        }else if(e.getSource()==books || e.getSource()==books_icon)
        {
            card.show(main_panel,"books");
        }else if(e.getSource()==issued || e.getSource()==issued_icon)
        {
            card.show(main_panel,"issued");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {

//        Home home = new Home();
//        home.setPersonalDetails(new PersonalDetails("Harish","Admin"));
//        home.initHome();
        new Login();

    }
}
/*
 get details of all books
 manage subscription of student

 */