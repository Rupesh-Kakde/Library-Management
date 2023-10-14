import myutil.GradientPanel;
import myutil.PersonalDetails;
import myutil.SetImageIcon;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Date;

public class SignUp extends MyFrame implements ActionListener, MouseListener ,FocusListener{

    private JLabel gender;
    private JLabel message;
    private JButton submit;
    private JCheckBox check_terms_and_condition;

    private JTextArea input_address;
    private final Container container;
    ButtonGroup gender_group;

    JTextField input_name, input_mobile,first_name,middle_name,last_name,username_input,email_input;
    JButton exit;

    JRadioButton male, female;
    

    JComboBox day, month, year,courses_list;
    JPasswordField password_input;


    JPanel gif_panel;;
    GradientPanel signup_panel;
    final  LineBorder INPUT_BORDER = new LineBorder(new Color(0x0F162D),1,true);
   final LineBorder HOVER_BORDER=new LineBorder(new Color(0x7C7CF1),2,true);
   final LineBorder COMBO_BOX_BORDER = new LineBorder(new Color(0x0F162D),1,true);;

   final LineBorder RED_BORDER  = new LineBorder(new Color(0xEA2E4E),2,true);;

    final  Font LABEL_FONT = new Font("Times New Roman", Font.BOLD, 14);

    final  int SIGNUP_CONTENT_X = 100;
    final  int SIGNUP_CONTENT_Y = 20;
    char pass_echo_char;

    public  void oldSignUpForm()
    {
//        signup_panel = new GradientPanel(new Color(0x7F7FE8));
        signup_panel = new GradientPanel(new Color(0x41F87B));
        signup_panel.setBounds(500,0,600,getHeight());
        signup_panel.setLayout(null);
        container.add(signup_panel);

        JLabel header = new JLabel("Create Account");
        header.setBounds(200, 30, 250, 30);
        header.setFont(new Font("Times New Roman", Font.BOLD, 18));
        signup_panel.add(header);


        Font label_font = new Font("Times New Roman", Font.BOLD, 14);

        JLabel name = new JLabel("Name");
        name.setBounds(100, 100, 100, 25);
        name.setFont(label_font);
        signup_panel.add(name);

        input_name = new JTextField(15);
        input_name.setBounds(200, 100, 200, 25);
        signup_panel.add(input_name);

        JLabel mobile = new JLabel("Mobile");
        mobile.setBounds(100, 150, 100, 25);
        mobile.setFont(label_font);
        signup_panel.add(mobile);

        input_mobile = new JTextField(15);
        input_mobile.setBounds(200, 150, 200, 25);
        signup_panel.add(input_mobile);

        gender = new JLabel("Gender");
        gender.setBounds(100, 200, 100, 25);
        gender.setFont(label_font);
        signup_panel.add(gender);

        gender_group = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(200, 200, 100, 25);
        signup_panel.add(male);

        female = new JRadioButton("Female");
        female.setBounds(300, 200, 100, 25);
        signup_panel.add(female);
        gender_group.add(male);
        gender_group.add(female);


        JLabel DOB = new JLabel("DOB");
        DOB.setBounds(100, 250, 100, 25);
        DOB.setFont(label_font);
        signup_panel.add(DOB);


        day = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            day.addItem(Integer.toString(i));
        }
        day.setBounds(200, 250, 50, 25);
        signup_panel.add(day);

        String months_str[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        month = new JComboBox(months_str);
        month.setBounds(260, 250, 50, 25);
        signup_panel.add(month);

        year = new JComboBox();
        for (int i = 1999; i <= 2023; i++) {
            year.addItem(Integer.toString(i));
        }
        year.setBounds(320, 250, 60, 25);
        signup_panel.add(year);

        JLabel address = new JLabel("Address");
        address.setBounds(100, 350, 100, 25);
        address.setFont(label_font);
        signup_panel.add(address);

        input_address = new JTextArea();
        input_address.setBounds(200, 300, 200, 120);
        input_address.setLineWrap(true);
        signup_panel.add(input_address);

        check_terms_and_condition = new JCheckBox();
        check_terms_and_condition.setBounds(120, 430, 20, 20);
        check_terms_and_condition.setSize(20, 20);

        signup_panel.add(check_terms_and_condition);

        JLabel check_box_label = new JLabel("Please Accept terms and Conditions");
        check_box_label.setBounds(145, 420, 300, 40);
        signup_panel.add(check_box_label);

        submit = new JButton("Submit");
        submit.setBounds(250, 480, 80, 30);
        signup_panel.add(submit);

        submit.addActionListener(this);


        message = new JLabel("hello");
        message.setBounds(200, 450, 400, 30);
        signup_panel.add(message);

       /* data = new JTextArea();
        data.setBounds(500, 0, 500, 500);
        data.setLineWrap(true);
        data.setFont(new Font("Arial" , Font.BOLD , 10));
//        container.add(data);*/

//        gif_panel = new JPanel();
//        gif_panel.setLayout(new BorderLayout());
//        ImageIcon image = new ImageIcon("images/document_icon.gif");
//        gif_panel.setBounds(50,150,400,400);
//
//
////        gif_panel.add( new SetImageIcon(image,400,400));
//
//        container.setBackground(Color.white);
//        container.add(gif_panel);
//        input_mobile.addActionListener(this);
//        input_name.addActionListener(this);
    }
    SignUp(){
        super("SignUp");
        container = getContentPane();
        setGIFPanel();
        newSignUpForm();
        setVisible(true);
    }
    
    public  void initSignUpPanel()
    {
        signup_panel = new GradientPanel(new Color(0xBFBFF6));
        signup_panel.setBounds(400,0,600,getHeight());
        signup_panel.setLayout(null);
        container.add(signup_panel);
    }
    public  void newSignUpForm()
    {
        initSignUpPanel();
        setTitle();
        setNameFields();
        setUsernameFields();
        setDOBFields();
        setCoursesFields();
        setMobileNumberFields();
        setEmailFields();
        setAddressFields();
        setPasswordFields();
        addSeparatorLine();
        checkTermsAndCondition();
        setButtonFields();
    }
    public  void setGIFPanel()
    {
        //gif panel codding
        gif_panel = new JPanel();
        gif_panel.setLayout(new BorderLayout());

        ImageIcon image = new ImageIcon("images/document_icon.gif");
        gif_panel.setBounds(20,150,400,400);
        gif_panel.add( new SetImageIcon(image,400,500));

        JLabel title = new JLabel("Let's Grow Together" ,SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD,40));
        title.setForeground(new Color(0x1A1A54));
        title.setBounds(20,100,400,50);

        container.add(title);
        container.setBackground(Color.white);
        container.add(gif_panel);
    }
    public  void setTitle()
    {
        JLabel header = new JLabel("Create Account");
        header.setBounds(SIGNUP_CONTENT_X+150, SIGNUP_CONTENT_Y, 250, 30);
        header.setFont(new Font("Times New Roman", Font.BOLD, 18));
        signup_panel.add(header);
    }
    public  void setNameFields()
    {
        JLabel name = new JLabel("Name");
        name.setBounds(SIGNUP_CONTENT_X, SIGNUP_CONTENT_Y + 50, 100, 25);
        signup_panel.add(name);

        //--------------------------------
        first_name = new JTextField();
        first_name.setBounds(SIGNUP_CONTENT_X+70,SIGNUP_CONTENT_Y+50,100,30);
        first_name.setBorder(INPUT_BORDER);
        first_name.setText("First Name");

        signup_panel.add(first_name);

        first_name.addMouseListener(this);
        first_name.addFocusListener(this);

        //--------------------------------
        middle_name = new JTextField();
        middle_name.setBounds(SIGNUP_CONTENT_X+180,SIGNUP_CONTENT_Y+50,100,30);
        middle_name.setBorder(INPUT_BORDER);
        middle_name.setText("Middle Name");
        signup_panel.add(middle_name);
        middle_name.addMouseListener(this);
        middle_name.addFocusListener(this);

        //--------------------------------
        last_name = new JTextField();
        last_name.setBounds(SIGNUP_CONTENT_X+290,SIGNUP_CONTENT_Y+50,100,30);
        last_name.setBorder(INPUT_BORDER);
        last_name.setText("Last Name");

        signup_panel.add(last_name);

        last_name.addMouseListener(this);
        last_name.addFocusListener(this);

    }

    //username
    public  void setUsernameFields()
    {
        JLabel username_label = new JLabel("Username");
        username_label.setBounds(SIGNUP_CONTENT_X,SIGNUP_CONTENT_Y+90,150,30);
        signup_panel.add(username_label);

        //----------------------------------
        username_input = new JTextField();
        username_input.setBounds(SIGNUP_CONTENT_X+70,SIGNUP_CONTENT_Y+90,100,30);
        username_input.setBorder(INPUT_BORDER);
        username_input.setText("Enter Username");

        signup_panel.add(username_input);

        username_input.addMouseListener(this);
        username_label.addFocusListener(this);

    }
    //dob
    public  void setDOBFields()
    {

        JLabel DOB = new JLabel("DOB");
        DOB.setBounds(SIGNUP_CONTENT_X+180, SIGNUP_CONTENT_Y + 90, 50, 25);
        DOB.setFont(LABEL_FONT);
        signup_panel.add(DOB);

        //--------------------------------
        day = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            day.addItem(Integer.toString(i));
        }
        day.setBounds(SIGNUP_CONTENT_X+220,SIGNUP_CONTENT_Y+90,50,25);
        day.setBorder(COMBO_BOX_BORDER);

        //--------------------------------
        String [] months_str= {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        month = new JComboBox(months_str);
        month.setBounds(SIGNUP_CONTENT_X+275,SIGNUP_CONTENT_Y+90,50,25);
        month.setBorder(COMBO_BOX_BORDER);

        //--------------------------------
        year = new JComboBox();
        Date date = new Date();
        int current_year = 1900+date.getYear();
        for (int i = current_year; i >=1923; i--) {
            year.addItem(Integer.toString(i));
        }
        year.setBounds(SIGNUP_CONTENT_X+330,SIGNUP_CONTENT_Y+90,60,25);
        year.setBorder(COMBO_BOX_BORDER);


        day.addMouseListener(this);
        month.addMouseListener(this);
        year.addMouseListener(this);

        day.addFocusListener(this);
        month.addFocusListener(this);
        year.addFocusListener(this);

        signup_panel.add(day);
        signup_panel.add(month);
        signup_panel.add(year);

    }
    public void setCoursesFields()
    {
        JLabel courses_label = new JLabel("Courses");
        courses_label.setBounds(SIGNUP_CONTENT_X, SIGNUP_CONTENT_Y+140, 100, 25);
        courses_label.setFont(LABEL_FONT);
        signup_panel.add(courses_label);

       //------------------------------
        String []courses = {"Select Course","BSC","BCS","BCOM","11th","12th"};
        courses_list = new JComboBox(courses);
        courses_list.setBounds(SIGNUP_CONTENT_X+70, SIGNUP_CONTENT_Y+140 , 150, 25);
        courses_list.setBorder(COMBO_BOX_BORDER);

        courses_list.addMouseListener(this);
        courses_list.addFocusListener(this);

        signup_panel.add(courses_list);
    }
    public  void setMobileNumberFields()
    {
        JLabel mobile = new JLabel("Mob");
        mobile.setBounds(SIGNUP_CONTENT_X+230, SIGNUP_CONTENT_Y+140, 50, 25);
        mobile.setFont(LABEL_FONT);
        signup_panel.add(mobile);

        //----------------------------------
        input_mobile = new JTextField(15);
        input_mobile.setBounds(SIGNUP_CONTENT_X+270, SIGNUP_CONTENT_Y+140, 120, 25);
        input_mobile.setBorder(INPUT_BORDER);
        input_mobile.setText("Enter Mobile Number");

        signup_panel.add(input_mobile);

        input_mobile.addMouseListener(this);
        input_mobile.addFocusListener(this);
    }
    public  void setEmailFields()
    {
        JLabel email_label = new JLabel("Email");
        email_label.setBounds(SIGNUP_CONTENT_X,SIGNUP_CONTENT_Y + 180 , 100,25);
        signup_panel.add(email_label);
        email_input = new JTextField();

        //----------------------------------
        email_input.setBounds(SIGNUP_CONTENT_X+70,SIGNUP_CONTENT_Y+180,320,30);
        email_input.setBorder(INPUT_BORDER);
        email_input.setText("Enter Email");

        email_input.addMouseListener(this);
        email_input.addFocusListener(this);
        signup_panel.add(email_input);
    }
    public  void setAddressFields()
    {
        JLabel address = new JLabel("Address");
        address.setBounds(SIGNUP_CONTENT_X, SIGNUP_CONTENT_Y+220, 100, 25);
        address.setFont(LABEL_FONT);
        signup_panel.add(address);

        //----------------------------------
        input_address = new JTextArea();
        input_address.setBounds(SIGNUP_CONTENT_X+70, SIGNUP_CONTENT_Y+220, 320, 100);
        input_address.setLineWrap(true);
        input_address.setBorder(new LineBorder(Color.black,1,true));
        input_address.setText("Enter Address");

        input_address.addMouseListener(this);
        input_address.addFocusListener(this);

        signup_panel.add(input_address);
    }
    
    public  void setPasswordFields()
    {
        JLabel password_label = new JLabel("Password");
        password_label.setBounds(SIGNUP_CONTENT_X  ,   SIGNUP_CONTENT_Y + 330,100,30);

        //----------------------------------
        password_input = new JPasswordField();
        password_input.setBounds( SIGNUP_CONTENT_X + 70 ,   SIGNUP_CONTENT_Y + 330 , 150, 25);
        password_input.setBorder(INPUT_BORDER);
        password_input.setText("Enter Password");
        pass_echo_char = password_input.getEchoChar();
        password_input.setEchoChar((char)0); //to show the password
        
        signup_panel.add(password_label);
        signup_panel.add(password_input);

        password_input.addMouseListener(this);
        password_input.addFocusListener(this);

        //----------------------------------
        //to show the entered password on checked box
        JCheckBox showPass= new JCheckBox("Show Password");
        showPass.setBounds( SIGNUP_CONTENT_X + 70 ,   SIGNUP_CONTENT_Y + 360 , 100,13);
        showPass.setFont(new Font("Arial",Font.TRUETYPE_FONT,10));
        showPass.setBackground(new Color(0xE6E6F1));
        showPass.setFocusPainted(false);

        showPass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(showPass.isSelected())
                {
                    password_input.setEchoChar((char) 0);
                }
                else{
                    String pass = new String(password_input.getPassword());
                    if(!pass.equalsIgnoreCase("Enter Password")) {
                        password_input.setEchoChar(pass_echo_char);
                    }
                }
            }
        });
        signup_panel.add(showPass);
        
    }
    public void addSeparatorLine()
    {
        JSeparator separator = new JSeparator();
        separator.setBounds(SIGNUP_CONTENT_X , SIGNUP_CONTENT_Y + 420, 400, 1);
        separator.setBackground(Color.black);
        signup_panel.add(separator);
    }
    public  void checkTermsAndCondition()
    {
        check_terms_and_condition = new JCheckBox("Please Accept terms and Conditions");
        check_terms_and_condition.setBounds(SIGNUP_CONTENT_X + 70, SIGNUP_CONTENT_Y + 390, 250, 15);
//        check_terms_and_condition.setSize(20, 20);
        check_terms_and_condition.setFont(new Font("Arial",Font.HANGING_BASELINE,13));
        check_terms_and_condition.setBackground(new Color(0xDDDDFF));
        check_terms_and_condition.setOpaque(true);


        check_terms_and_condition.setFocusPainted(false);

        signup_panel.add(check_terms_and_condition);
    }
    public  void setButtonFields()
    {
        submit = new JButton("Submit");
        submit.setBounds(SIGNUP_CONTENT_X + 100, SIGNUP_CONTENT_Y + 430, 80, 30);
        submit.setBackground(new Color(0x1414E0));
        submit.setForeground(new Color(0xF7F7F8));
        submit.setFont(new Font("Arial",Font.BOLD,12));
        submit.setBorder(new LineBorder(Color.white,2,true));
        submit.setFocusPainted(false);

        submit.addMouseListener(this);
        submit.addActionListener(this);
        submit.addFocusListener(this);

        signup_panel.add(submit);

        //-----------------------------------------
        exit = new JButton("Exit");
        exit.setBounds(SIGNUP_CONTENT_X + 250, SIGNUP_CONTENT_Y + 430, 80, 30);

        exit.setBackground(new Color(0x4F4F56));
        exit.setForeground(new Color(0xF7F7F8));
        exit.setFont(new Font("Arial",Font.BOLD,12));
        exit.setBorder(new LineBorder(Color.white,2,true));
        exit.setFocusPainted(false);

        exit.addMouseListener(this);
        exit.addFocusListener(this);

        signup_panel.add(exit);
    }

    public void actionPerformed(ActionEvent e) {
        boolean isAllFilled = true;
        if (check_terms_and_condition.isSelected()) {
            String f_name = first_name.getText();
            String m_name = middle_name.getText();
            String l_name = last_name.getText();
            String mobile = input_mobile.getText();
            String address = input_address.getText();
            String username = username_input.getText();
            String DOB = day.getSelectedItem() + " " + month.getSelectedItem() + " " + year.getSelectedItem();
            String email = email_input.getText();
            String full_name = f_name + " " + m_name + " " + l_name;
            String password = new String(password_input.getPassword());

            String course = courses_list.getSelectedItem().toString();

            if (f_name.equalsIgnoreCase("First Name")) {
                isAllFilled = false;
                first_name.setBorder(RED_BORDER);
            }
            if (m_name.equalsIgnoreCase("Middle Name")) {
                isAllFilled = false;
                middle_name.setBorder(RED_BORDER);
            }
            if (l_name.equalsIgnoreCase("Last Name")) {
                isAllFilled = false;
                last_name.setBorder(RED_BORDER);
            }
            if (email.equalsIgnoreCase("Enter Email")) {
                isAllFilled = false;
                email_input.setBorder(RED_BORDER);
            }
            if (password.equalsIgnoreCase("Enter Password")) {
                isAllFilled = false;
                password_input.setBorder(RED_BORDER);
            }


            if (mobile.equalsIgnoreCase("Enter Mobile Number")) {
                isAllFilled = false;
                input_mobile.setBorder(RED_BORDER);

            }
            if (address.equalsIgnoreCase("Enter Address")) {
                isAllFilled = false;
                input_address.setBorder(RED_BORDER);

            }
            if (username.equalsIgnoreCase("Enter Username")) {
                isAllFilled = false;
                username_input.setBorder(RED_BORDER);
            }
            if (course.equalsIgnoreCase("Select Course")) {
                isAllFilled = false;
                courses_list.setBorder(RED_BORDER);
            }

//            System.out.println(DOB);
//
//            System.out.println(full_name);
//            System.out.println(mobile);
//            System.out.println(address);
//            System.out.println(DOB);
//            System.out.println(email);

                if (isAllFilled) {

                    PersonalDetails personalDetails = new PersonalDetails();
                    personalDetails.setFirstName(f_name);
                    personalDetails.setMiddleName(m_name);
                    personalDetails.setLastName(l_name);
                    personalDetails.setAddress(address);
                    personalDetails.setEmail(email);
                    personalDetails.setDOB(DOB);
                    personalDetails.setMobileNo(mobile);
                    personalDetails.setStatus("User");
                    personalDetails.setUsername(username);
                    personalDetails.setPassword(password);
                    personalDetails.setCourses(courses_list.getSelectedItem().toString());
                    System.out.println(personalDetails.getCourses());
//
//            message.setText("Registration Successful..!!");
//            message.setForeground(new Color(0x227E01));


//            int msg =  JOptionPane.showInformationDialog(container,"Account Created Successfully","SignUp",JOptionPane.PLAIN_MESSAGE);

                    Object[] options = {"Ok", "Cancel"};

                    ImageIcon optionPaneIcon = new ImageIcon("images/return_book.png");

                    int msg = JOptionPane.showOptionDialog(container, "Account Created Successfully", "SignUp",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);

                    System.out.println(msg);
                    System.out.println(JOptionPane.OK_OPTION);

                    if (msg == JOptionPane.OK_OPTION) {
                        Database student_db = new Database();
                        student_db.addUserDetails(personalDetails);
                        Home home = new Home();
                        home.setPersonalDetails(personalDetails);
                        home.initHome();
                        home.setVisible(true);
                        this.dispose();
                    }
                }


            } else {

                JOptionPane.showMessageDialog(container, "Please accept terms and conditions first", "Error", JOptionPane.ERROR_MESSAGE);
//            message.setForeground(new Color(0xE3336A));
            }

    }

//    public static void main(String[] args) throws IOException {
//
//        new SignUp();
//    }

    //----------------------- Event Methods start ------------------
    //this is common for clicked and entered
    public  void performedMouseEvent(MouseEvent e)
    {

        if(e.getSource()==submit) {
            submit.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==exit)
        {
            exit.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==day)
        {
            day.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==month)
        {
            month.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==year)
        {
            year.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==courses_list)
        {
            courses_list.setBorder(HOVER_BORDER);
        }

        if(e.getSource()==first_name)
        {
            if(first_name.getText().equalsIgnoreCase("First Name"))
                first_name.setText("");

            first_name.setBorder(HOVER_BORDER);
        }


        if(e.getSource()==middle_name) {
            if (middle_name.getText().equalsIgnoreCase("Middle Name"))
            {
                middle_name.setText("");
            }

            middle_name.setBorder(HOVER_BORDER);

        }

        if(e.getSource()==last_name) {
            if (last_name.getText().equalsIgnoreCase("Last Name"))
                last_name.setText("");

            last_name.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==username_input) {
            if (username_input.getText().equalsIgnoreCase("Enter Username"))
                username_input.setText("");

            username_input.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==input_mobile) {
            if (input_mobile.getText().equalsIgnoreCase("Enter Mobile Number"))
                input_mobile.setText("");


            input_mobile.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==email_input)
        {
            if (email_input.getText().equalsIgnoreCase("Enter Email"))
                email_input.setText("");

            email_input.setBorder(HOVER_BORDER);

        }if(e.getSource()==input_address) {
        if (input_address.getText().equalsIgnoreCase("Enter Address"))
            input_address.setText("");

        input_address.setBorder(HOVER_BORDER);
    }

        if(e.getSource()==password_input)
        {

            String pass  = new String(password_input.getPassword());
            if(pass.equalsIgnoreCase("Enter Password")) {
                password_input.setText("");
                password_input.setEchoChar(pass_echo_char);
            }

            password_input.setBorder(HOVER_BORDER);


        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

//       performedMouseEvent(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        performedMouseEvent(e);
    }

    public  boolean isNotValidString(String str)
    {
        String special_char = "@!#$%^&*()_+=/><,.123456789";
        for(int i=0;i<str.length();i++)
        {
            if(special_char.indexOf(str.charAt(i))!=-1)
            {
                return true;
            }
        }
        return false;

    }
    public  boolean isNotValidMobileNumber(String str)
    {
        //adb123
        //123
       if(str.equalsIgnoreCase("Enter Mobile Number"))
            return false;

        String special_char = " +1234567890";
        int mobile_number_length = str.length();
        for(int i=0;i<mobile_number_length;i++)
        {
            if(special_char.indexOf(str.charAt(i))==-1 || mobile_number_length>10)
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==first_name)
        {
            if(first_name.getText().isEmpty())
            {
                first_name.setText("First Name");
            }
            if(isNotValidString(first_name.getText()))
            {
                first_name.setBorder(RED_BORDER);
            }
            else{
                first_name.setBorder(INPUT_BORDER);

            }


        }
       else
        if(e.getSource()==middle_name)
        {
            if(middle_name.getText().isEmpty()) {
                middle_name.setText("Middle Name");
            }
            if(isNotValidString(middle_name.getText()))
            {
                middle_name.setBorder(RED_BORDER);
            }
            else{
                middle_name.setBorder(INPUT_BORDER);
            }


        }
       else
        if(e.getSource()==last_name)
        {
            if(last_name.getText().isEmpty()) {
                last_name.setText("Last Name");
            }
            if(isNotValidString(last_name.getText()))
            {
                last_name.setBorder(RED_BORDER);
            }
            else{
                last_name.setBorder(INPUT_BORDER);
            }
        }
        else if(e.getSource()==username_input)
        {
            if(username_input.getText().isEmpty())
                username_input.setText("Enter Username");
            username_input.setBorder(INPUT_BORDER);

        }
        if(e.getSource()==input_mobile)
        {
            if(input_mobile.getText().isEmpty()) {
                input_mobile.setText("Enter Mobile Number");
            }
            if(isNotValidMobileNumber(input_mobile.getText()))
            {
                input_mobile.setBorder(RED_BORDER);
            }
            else{
                input_mobile.setBorder(INPUT_BORDER);

            }


        }if(e.getSource()==email_input)
        {
            if(email_input.getText().isEmpty())
                email_input.setText("Enter Email");

            email_input.setBorder(INPUT_BORDER);


        }if(e.getSource()==input_address)
        {
            if(input_address.getText().isEmpty())
                input_address.setText("Enter Address");

            input_address.setBorder(new LineBorder(Color.black ,1,true));

        }if(e.getSource()==password_input)
        {

            if(password_input.getPassword().length==0) {
                password_input.setText("Enter Password");
                password_input.setEchoChar((char) 0);
            }
            password_input.setBorder(INPUT_BORDER);

        }

        if(e.getSource()==day)
        {
            day.setBorder(COMBO_BOX_BORDER);
        }
        if(e.getSource()==month)
        {
            month.setBorder(COMBO_BOX_BORDER);
        }  if(e.getSource()==year)
        {
            year.setBorder(COMBO_BOX_BORDER);
        }
        if(e.getSource()==exit)
        {
            exit.setBorder(new LineBorder(Color.white,2,true));
        }else if(e.getSource()==submit)
        {
            submit.setBorder(new LineBorder(Color.white,2,true));

        }

        if(e.getSource()==courses_list)
        {
            courses_list.setBorder(COMBO_BOX_BORDER);
        }

    }


    //Focus Listener start
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==submit) {
            submit.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==exit)
        {
            exit.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==day)
        {
            day.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==month)
        {
            month.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==year)
        {
            year.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==courses_list)
        {
            courses_list.setBorder(HOVER_BORDER);
        }

        if(e.getSource()==first_name)
        {
            if(first_name.getText().equalsIgnoreCase("First Name"))
                first_name.setText("");

            first_name.setBorder(HOVER_BORDER);
        }


        if(e.getSource()==middle_name) {
            if (middle_name.getText().equalsIgnoreCase("Middle Name"))
            {
                middle_name.setText("");
            }

            middle_name.setBorder(HOVER_BORDER);

        }

        if(e.getSource()==last_name) {
            if (last_name.getText().equalsIgnoreCase("Last Name"))
                last_name.setText("");

            last_name.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==username_input) {
            if (username_input.getText().equalsIgnoreCase("Enter Username"))
                username_input.setText("");

            username_input.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==input_mobile) {
            if (input_mobile.getText().equalsIgnoreCase("Enter Mobile Number"))
                input_mobile.setText("");


            input_mobile.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==email_input)
        {
            if (email_input.getText().equalsIgnoreCase("Enter Email"))
                email_input.setText("");

            email_input.setBorder(HOVER_BORDER);

        }if(e.getSource()==input_address) {
            if (input_address.getText().equalsIgnoreCase("Enter Address"))
                input_address.setText("");

            input_address.setBorder(HOVER_BORDER);
        }

        if(e.getSource()==password_input)
        {

            String pass  = new String(password_input.getPassword());
            if(pass.equalsIgnoreCase("Enter Password")) {
                password_input.setText("");
                password_input.setEchoChar(pass_echo_char);
            }

            password_input.setBorder(HOVER_BORDER);


        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource()==first_name)
        {
            if(first_name.getText().isEmpty())
            {
                first_name.setText("First Name");
            }
            if(isNotValidString(first_name.getText()))
            {
                first_name.setBorder(RED_BORDER);
            }
            else{
                first_name.setBorder(INPUT_BORDER);

            }
        }
        else
        if(e.getSource()==middle_name)
        {
            if(middle_name.getText().isEmpty()) {
                middle_name.setText("Middle Name");
            }
            if(isNotValidString(middle_name.getText()))
            {
                middle_name.setBorder(RED_BORDER);
            }
            else{
                middle_name.setBorder(INPUT_BORDER);
            }
        }
        else
        if(e.getSource()==last_name)
        {
            if(last_name.getText().isEmpty()) {
                last_name.setText("Last Name");
            }

            if(isNotValidString(last_name.getText().toString()))
            {
                last_name.setBorder(RED_BORDER);
            }
            else{
                last_name.setBorder(INPUT_BORDER);
            }
        }
        else if(e.getSource()==username_input)
        {
            if(username_input.getText().isEmpty())
                username_input.setText("Enter Username");

            username_input.setBorder(INPUT_BORDER);


        }
        if(e.getSource()==input_mobile)
        {

            if(input_mobile.getText().isEmpty()) {
                input_mobile.setText("Enter Mobile Number");
            }
            if(isNotValidMobileNumber(input_mobile.getText()))
            {
                input_mobile.setBorder(RED_BORDER);
            }
            else{
                input_mobile.setBorder(INPUT_BORDER);

            }


        }if(e.getSource()==email_input)
        {
            if(email_input.getText().isEmpty())
                email_input.setText("Enter Email");

            email_input.setBorder(INPUT_BORDER);


        }if(e.getSource()==input_address)
        {
            if(input_address.getText().isEmpty())
                input_address.setText("Enter Address");

            input_address.setBorder(new LineBorder(Color.black ,1,true));

        }if(e.getSource()==password_input)
        {

            if(password_input.getPassword().length==0) {
                password_input.setText("Enter Password");
                password_input.setEchoChar((char) 0);
            }
            password_input.setBorder(INPUT_BORDER);

        }

        if(e.getSource()==day)
        {
            day.setBorder(COMBO_BOX_BORDER);
        }
        if(e.getSource()==month)
        {
            month.setBorder(COMBO_BOX_BORDER);
        }  if(e.getSource()==year)
        {
            year.setBorder(COMBO_BOX_BORDER);
        }
        if(e.getSource()==exit)
        {
            exit.setBorder(new LineBorder(Color.white,2,true));
        }else if(e.getSource()==submit)
        {
            submit.setBorder(new LineBorder(Color.white,2,true));

        }

        if(e.getSource()==courses_list)
        {
            courses_list.setBorder(COMBO_BOX_BORDER);
        }
    }

   /* public  void performedMouseFocusEvent(FocusEvent e)
    {
        if(e.getSource()==submit) {
            submit.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==exit)
        {
            exit.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==day)
        {
            day.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==month)
        {
            month.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==year)
        {
            year.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==courses_list)
        {
            courses_list.setBorder(HOVER_BORDER);
        }

        if(e.getSource()==first_name)
        {
            if(first_name.getText().equalsIgnoreCase("First Name"))
                first_name.setText("");
            first_name.setBorder(HOVER_BORDER);
        }

        if(e.getSource()==middle_name) {
            if (middle_name.getText().equalsIgnoreCase("Middle Name"))
                middle_name.setText("");
            middle_name.setBorder(HOVER_BORDER);

        }

        if(e.getSource()==last_name) {

            if (last_name.getText().equalsIgnoreCase("Last Name"))
                last_name.setText("");
            last_name.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==username_input) {

            if (username_input.getText().equalsIgnoreCase("Enter Username"))
                username_input.setText("");
            username_input.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==input_mobile) {
            if (input_mobile.getText().equalsIgnoreCase("Enter Mobile Number"))
                input_mobile.setText("");
            input_mobile.setBorder(HOVER_BORDER);
        }
        if(e.getSource()==email_input)
        {
            if (email_input.getText().equalsIgnoreCase("Enter Email"))
                email_input.setText("");
            email_input.setBorder(HOVER_BORDER);

        }
        if(e.getSource()==input_address) {
          if (input_address.getText().equalsIgnoreCase("Enter Address"))
              input_address.setText("");
          input_address.setBorder(HOVER_BORDER);
        }

        if(e.getSource()==password_input)
        {

            String pass  = new String(password_input.getPassword());
            if(pass.equalsIgnoreCase("Enter Password")) {
                password_input.setText("");
                password_input.setEchoChar(pass_echo_char);
            }
            password_input.setBorder(HOVER_BORDER);
        }
    }*/

}
//            }if(f_name.equalsIgnoreCase("First Name"))
//            {
//                isAllFilled = false;
//            }if(f_name.equalsIgnoreCase("First Name"))
//            {
//                isAllFilled = false;
//            }

//            System.out.println(year.getSelectedItem());
//  Date DOB_date = new Date(year.getSelectedItem(),month.getSelectedItem(),day.getSelectedItem());


//            int d = Integer.parseInt(new String(day.getSelectedItem().toString()));
//            int m = Integer.parseInt(new String(month.getSelectedItem().toString()));
//            int y = Integer.parseInt(new String(year.getSelectedItem().toString()));
//
//            System.out.println(d);
//            System.out.println(m);
//            System.out.println(y);
//            Date dd = new Date(y,m,d);

//            System.out.println(dd);



//
//            String all_data = "Name : " + Name + "\n" +
//                    "Mobile Number : " + Mobile + "\n" +
//                    "Address : " + Address + "\n" +
//                    "Gender : " + Gender + "\n" +
//                    "Date Of Birth : " + DOB + "\n";
//            data.setText(all_data);
//            container.setBackground(new Color(0xA7F18E));

//            String Gender = " ";
//            if (male.isSelected())
//                Gender = "Male";
//            else
//                Gender = "Female";