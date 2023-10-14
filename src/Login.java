import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import myutil.PersonalDetails;
import myutil.SetImageIcon;
import  myutil.GradientPanel;

public class Login  extends MyFrame implements ActionListener  ,MouseListener , KeyListener {


    final  int LOGIN_CONTENT_X = 120;
    final  int LOGIN_CONTENT_Y = 180;

    Container login_page;
    JPanel image_panel ,login_head;
    JPanel loading_panel;
    GradientPanel login_content;
    private  Timer timer;
    private  Timer function_timer;

    JLabel username_label , password_label;
    JTextField username_input;
    JPasswordField password_input;
    JButton login_button;
    JRadioButton admin,user;
    JButton forget_pass_btn;

    JLabel toast ;
    boolean login_status = false;
    JButton sign_up;
    char pass_echo_char;
    Login()
    {
        super("Login");
        login_page = getContentPane();

        image_panel = new JPanel();
        image_panel.setBounds(0,0,getWidth()-500,getHeight());
        image_panel.setBackground(Color.white);

        image_panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        JLabel title = new JLabel("Welcome Back." ,SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(340,100));
        title.setFont(new Font("Serif", Font.BOLD,40));
        title.setForeground(new Color(0x1A1A54));

        image_panel.add(title,gbc);

        image_panel.add(new JSeparator());
        ImageIcon icon_gif = new ImageIcon("D:\\LibraryManagementSystem\\images\\computer.gif");
        gbc.gridx = 0;
        gbc.gridy = 1;

        image_panel.add(new SetImageIcon(icon_gif,350,getHeight()-300) , gbc);


      //-----------------------------------------

        login_content = new GradientPanel(new Color(0xBFBFF6));
        login_content.setBounds(getWidth()-500,0,getWidth()-500,getHeight());
        login_content.setBackground(new Color(0xBFBFF6));
        login_content.setLayout(null);



        login_head = new JPanel();
        ImageIcon icon = new ImageIcon("D:\\LibraryManagementSystem\\images\\human_face3.png");
        login_head.add(new SetImageIcon(icon,100,100));
        login_head.setBackground(new Color(0xDDDDFF));
        login_head.setBounds(200,10,100,105);

        login_content.add(login_head);


        //login choice between for admin and user
        JLabel login_as = new JLabel("Login As");
        login_as.setBounds(LOGIN_CONTENT_X,LOGIN_CONTENT_Y-40,100,30);
        login_content.add(login_as);

        ButtonGroup radio_btn = new ButtonGroup();


        user  = new JRadioButton("User");
        user.setBounds(LOGIN_CONTENT_X+100,LOGIN_CONTENT_Y-35,70,20);
        user.setFocusPainted(false);
        user.setBackground(new Color(0xDDDDFF));

//        user.setOpaque(true);
        user.setSelected(true);
        user.addMouseListener(this);
        login_content.add(user);

        admin  = new JRadioButton("Admin");
        admin.setBounds(LOGIN_CONTENT_X+180,LOGIN_CONTENT_Y-35,70,20);
        admin.setBackground(new Color(0xDCDCFF));

        admin.setFocusPainted(false);
        admin.addMouseListener(this);
        login_content.add(admin);

        radio_btn.add(admin);
        radio_btn.add(user);


//        JComboBox comboBox = new JComboBox();
//        comboBox.addItem("Admin");
//        comboBox.addItem("User");
//        comboBox.setBounds( LOGIN_CONTENT_X + 100 ,   LOGIN_CONTENT_Y-40 , 150, 25);
//        login_content.add(comboBox);


        username_label = new JLabel("Username");
        username_label.setBounds(LOGIN_CONTENT_X,LOGIN_CONTENT_Y,100,30);
        username_input = new JTextField();
        username_input.setBounds( LOGIN_CONTENT_X + 100 ,   LOGIN_CONTENT_Y , 150, 25);
        username_input.setBorder(new LineBorder(Color.black,2,true));

        username_input.addMouseListener(this);
        username_input.addKeyListener(this);
        username_input.setText("Enter Username");

        password_label = new JLabel("Password");
        password_label.setBounds(LOGIN_CONTENT_X  ,   LOGIN_CONTENT_Y + 50,100,30);
        password_input = new JPasswordField();
        password_input.setBounds( LOGIN_CONTENT_X + 100 ,   LOGIN_CONTENT_Y + 50 , 150, 25);
        password_input.setBorder(new LineBorder(Color.black,2,true));
        password_input.addMouseListener(this);
        password_input.addKeyListener(this);
        pass_echo_char = password_input.getEchoChar();
        password_input.setEchoChar((char)0); //to show the password
        password_input.setText("Enter Password");

        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBounds( LOGIN_CONTENT_X + 100 ,   LOGIN_CONTENT_Y + 80 , 100,15);
        showPassword.setFont(new Font("Arial",Font.TRUETYPE_FONT,10));
        showPassword.setBackground(new Color(0xDDDDFF));
        showPassword.setFocusPainted(false);
        showPassword.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(showPassword.isSelected())
                {
                    password_input.setEchoChar((char)0);
                }
                else{
                    password_input.setEchoChar(pass_echo_char);
                }
            }
        });
        login_content.add(showPassword);



        login_button = new JButton("Login");
        login_button.setBounds(LOGIN_CONTENT_X + 100 ,LOGIN_CONTENT_Y +110  ,70,30);
        login_button.setBackground(new Color(0x1414E0));
        login_button.setForeground(new Color(0xF7F7F8));
        login_button.setFont(new Font("Arial",Font.BOLD,12));
        login_button.setBorder(new LineBorder(Color.white,2,true));
        login_button.addActionListener(this);
        login_button.addMouseListener(this);
        login_button.setFocusPainted(false);


        JSeparator separator  = new JSeparator();
        separator.setBounds(LOGIN_CONTENT_X , LOGIN_CONTENT_Y + 150,270,5);
        login_content.add(separator);
        JLabel forget_pass_label  = new JLabel("Forget Password");
        forget_pass_label.setBounds(LOGIN_CONTENT_X+10,LOGIN_CONTENT_Y+160,100,20);
        login_content.add(forget_pass_label);

        forget_pass_btn  = new JButton("click ");
        forget_pass_btn.setBounds(LOGIN_CONTENT_X+20,LOGIN_CONTENT_Y+185,70,30);
        forget_pass_btn.setBackground(new Color(0xEF2D2D));
        forget_pass_btn.setForeground(new Color(0xF7F7F8));
        forget_pass_btn.setBorder( new BevelBorder(BevelBorder.RAISED));
        forget_pass_btn.setBorder(new LineBorder(Color.white,2,true));
        forget_pass_btn.addMouseListener(this);
        forget_pass_btn.setFocusPainted(false);

        login_content.add(forget_pass_btn);

        JLabel sign_up_label  = new JLabel("SignUp");
        sign_up_label.setBounds(LOGIN_CONTENT_X+210,LOGIN_CONTENT_Y+160,100,20);
        login_content.add(sign_up_label);

        sign_up  = new JButton("click");
        sign_up.setBounds(LOGIN_CONTENT_X+200,LOGIN_CONTENT_Y+185,70,30);
        sign_up.setBackground(new Color(0x91F589));
        sign_up.setForeground(new Color(0x0F162D));
//        sign_up.setBorder( new BevelBorder(BevelBorder.RAISED));
        sign_up.setBorder(new LineBorder(Color.white,2,true));
        sign_up.addMouseListener(this);
        sign_up.setFocusPainted(false);

        sign_up.addActionListener(this);
        login_content.add(sign_up);


        loading_panel = new JPanel();
        ImageIcon loading_icon = new ImageIcon("D:\\LibraryManagementSystem\\images\\loading.gif");
        loading_panel.setBounds(LOGIN_CONTENT_X+50,LOGIN_CONTENT_Y+250,50,25);
        loading_panel.add(new SetImageIcon(loading_icon,50,25));
        loading_panel.setBackground(new Color(0xDDDDFF));
        login_content.add(loading_panel);
        loading_panel.setVisible(false);

        toast = new JLabel("");
        toast.setBounds(LOGIN_CONTENT_X + 120,LOGIN_CONTENT_Y+250,100,20);
        login_content.add(toast);


        login_content.add(login_button);
        login_content.add(username_label);
        login_content.add(username_input);
        login_content.add(password_label);
        login_content.add(password_input);

        login_page.add(login_content);
        login_page.add(image_panel);
        this.setResizable(false);

        setVisible(true);

    }

    public boolean getStatus()
    {
        return  login_status;
    }

    public  void giveHomePageAccess()
    {
        String db_username = username_input.getText();
        String db_password = new String(password_input.getPassword());
        loading_panel.setVisible(true);

        Database student_db = new Database();
        PersonalDetails personalDetails =student_db.authenticate(db_username,db_password);

        if(personalDetails!=null)
        {
            toast.setText("Login Successful.");
            toast.setFont(new Font("Serif", Font.BOLD,10));
            toast.setForeground(new Color(0x00411A));

            String status =null;
            if(admin.isSelected()) {
                status = "Admin";
            } else if(user.isSelected())
            {
                status = "User";
            }

            personalDetails.setStatus(status);
            Home home = new Home();
            home.setPersonalDetails(personalDetails);
            home.initHome();

            System.out.println("this is from login");
            System.out.println(personalDetails.getName());
            System.out.println(personalDetails.getStatus());
            home.setVisible(true);
            this.dispose();
        }
        else{
            toast.setText("Login Failed");
            loading_panel.setVisible(false);
        }
    }
    public  void actionPerformed(ActionEvent event)
    {

        if(event.getSource()==login_button) {
          giveHomePageAccess();
        }

        if(event.getSource()==sign_up)
        {
            System.out.println("SignUp");
            SignUp signUp = new SignUp();
            signUp.setVisible(true);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Login();
    }


    //all event handling

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource()==login_button) {
            login_button.setBorder(new LineBorder(new Color(0x7C7CF1), 2, true));

        }
        else if(e.getSource()==sign_up)
        {
            sign_up.setBorder(new LineBorder(new Color(0x7C7CF1), 2, true));

        }
        else if(e.getSource()==forget_pass_btn)
        {
            forget_pass_btn.setBorder(new LineBorder(new Color(0x7C7CF1), 2, true));

        }
        else if(e.getSource()==username_input)
        {
            username_input.setBorder(new LineBorder(new Color(0x7C7CF1), 2, true));
            if (username_input.getText().equalsIgnoreCase("Enter Username"))
                username_input.setText("");

        } else if(e.getSource()==password_input)
        {
            password_input.setBorder(new LineBorder(new Color(0x7C7CF1), 2, true));

            String pass  = new String(password_input.getPassword());
            if(pass.equalsIgnoreCase("Enter Password")) {
                password_input.setText("");
                password_input.setEchoChar(pass_echo_char);
            }

        }

        else if(e.getSource()==admin)
        {
            admin.setBackground(new Color(0xCACAD2));
        }
        else if(e.getSource()==user)
        {
            user.setBackground(new Color(0xCACAD2));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        login_button.setBorder(new LineBorder(Color.white,2,true));
        if(e.getSource()==login_button) {
            login_button.setBorder(new LineBorder(Color.white,2,true));

        }
        else if(e.getSource()==sign_up)
        {
            sign_up.setBorder(new LineBorder(Color.white,2,true));
        }
        else if(e.getSource()==forget_pass_btn)
        {
            forget_pass_btn.setBorder(new LineBorder(Color.white,2,true));
        }else if(e.getSource()==username_input)
        {
            username_input.setBorder(new LineBorder(Color.black,2,true));
            if(username_input.getText().isEmpty())
                username_input.setText("Enter Username");
        }else if(e.getSource()==password_input)
        {
            password_input.setBorder(new LineBorder(Color.black,2,true));

            if(password_input.getPassword().length==0) {
                password_input.setText("Enter Password");
                password_input.setEchoChar((char) 0);
            }
        }
        else if(e.getSource()==admin)
        {
            admin.setBackground(new Color(0xDCDCFF));
        }
        else if(e.getSource()==user)
        {
            user.setBackground(new Color(0xDDDDFF));
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()==username_input || e.getSource()==password_input) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               giveHomePageAccess();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
