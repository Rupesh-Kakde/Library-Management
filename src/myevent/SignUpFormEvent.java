//package myevent;
//
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import java.awt.*;
//import java.awt.event.FocusEvent;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//public class SignUpFormEvent extends JFrame implements MouseListener {
//
//    SignUpFormEvent()
//    public  void performedMouseEvent(MouseEvent e)
//    {
//        if(e.getSource()==submit) {
//            submit.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==exit)
//        {
//            exit.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==day)
//        {
//            day.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==month)
//        {
//            month.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==year)
//        {
//            year.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==courses_list)
//        {
//            courses_list.setBorder(HOVER_BORDER);
//        }
//
//        if(e.getSource()==first_name)
//        {
//            if(first_name.getText().equalsIgnoreCase("First Name"))
//                first_name.setText("");
//
//            first_name.setBorder(HOVER_BORDER);
//        }
//
//
//        if(e.getSource()==middle_name) {
//            if (middle_name.getText().equalsIgnoreCase("Middle Name"))
//            {
//                middle_name.setText("");
//            }
//
//            middle_name.setBorder(HOVER_BORDER);
//
//        }
//
//        if(e.getSource()==last_name) {
//            if (last_name.getText().equalsIgnoreCase("Last Name"))
//                last_name.setText("");
//
//            last_name.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==username_input) {
//            if (username_input.getText().equalsIgnoreCase("Enter Username"))
//                username_input.setText("");
//
//            username_input.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==input_mobile) {
//            if (input_mobile.getText().equalsIgnoreCase("Enter Mobile Number"))
//                input_mobile.setText("");
//
//            input_mobile.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==email_input)
//        {
//            if (email_input.getText().equalsIgnoreCase("Enter Email"))
//                email_input.setText("");
//
//            email_input.setBorder(HOVER_BORDER);
//
//        }if(e.getSource()==input_address) {
//        if (input_address.getText().equalsIgnoreCase("Enter Address"))
//            input_address.setText("");
//
//        input_address.setBorder(HOVER_BORDER);
//    }
//
//        if(e.getSource()==password_input)
//        {
//
//            String pass  = new String(password_input.getPassword());
////            if(pass.length()==0)
////            {
////                password_input.setText("Enter pass");
////                password_input.setEchoChar((char) 0);
////            }
//            if(pass.equalsIgnoreCase("Enter Password")) {
//                password_input.setText("");
//                password_input.setEchoChar(pass_echo_char);
//            }
//
//            password_input.setBorder(HOVER_BORDER);
//
//
//        }
//    }
//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//        performedMouseEvent(e);
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        performedMouseEvent(e);
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        if(e.getSource()==first_name)
//        {
//            if(first_name.getText().isEmpty())
//            {
//                first_name.setText("First Name");
//            }
//
//            first_name.setBorder(INPUT_BORDER);
//        }
//        else
//        if(e.getSource()==middle_name)
//        {
//            if(middle_name.getText().isEmpty())
//                middle_name.setText("Middle Name");
//
//            middle_name.setBorder(INPUT_BORDER);
//
//        }
//        else
//        if(e.getSource()==last_name)
//        {
//            if(last_name.getText().isEmpty())
//                last_name.setText("Last Name");
//
//            last_name.setBorder(INPUT_BORDER);
//
//
//        }
//        else if(e.getSource()==username_input)
//        {
//            if(username_input.getText().isEmpty())
//                username_input.setText("Enter Username");
//
//            username_input.setBorder(INPUT_BORDER);
//
//
//        }
//        if(e.getSource()==input_mobile)
//        {
//            if(input_mobile.getText().isEmpty())
//                input_mobile.setText("Enter Mobile Number");
//
//            input_mobile.setBorder(INPUT_BORDER);
//
//
//        }if(e.getSource()==email_input)
//        {
//            if(email_input.getText().isEmpty())
//                email_input.setText("Enter Email");
//
//            email_input.setBorder(INPUT_BORDER);
//
//
//        }if(e.getSource()==input_address)
//        {
//            if(input_address.getText().isEmpty())
//                input_address.setText("Enter Address");
//
//            input_address.setBorder(new LineBorder(Color.black ,1,true));
//
//        }if(e.getSource()==password_input)
//        {
//
//            if(password_input.getPassword().length==0) {
//                password_input.setText("Enter Password");
//                password_input.setEchoChar((char) 0);
//            }
//            password_input.setBorder(INPUT_BORDER);
//
//        }
//
//        if(e.getSource()==day)
//        {
//            day.setBorder(COMBO_BOX_BORDER);
//        }
//        if(e.getSource()==month)
//        {
//            month.setBorder(COMBO_BOX_BORDER);
//        }  if(e.getSource()==year)
//        {
//            year.setBorder(COMBO_BOX_BORDER);
//        }
//        if(e.getSource()==exit)
//        {
//            exit.setBorder(new LineBorder(Color.white,2,true));
//        }else if(e.getSource()==submit)
//        {
//            submit.setBorder(new LineBorder(Color.white,2,true));
//
//        }
//
//        if(e.getSource()==courses_list)
//        {
//            courses_list.setBorder(COMBO_BOX_BORDER);
//        }
//
//    }
//
//    @Override
//    public void focusGained(FocusEvent e) {
//        performedMouseFocusEvent(e);
//    }
//
//    @Override
//    public void focusLost(FocusEvent e) {
//        if(e.getSource()==first_name)
//        {
//            if(first_name.getText().isEmpty())
//            {
//                first_name.setText("First Name");
//            }
//
//            first_name.setBorder(INPUT_BORDER);
//        }
//        else
//        if(e.getSource()==middle_name)
//        {
//            if(middle_name.getText().isEmpty())
//                middle_name.setText("Middle Name");
//
//            middle_name.setBorder(INPUT_BORDER);
//
//        }
//        else
//        if(e.getSource()==last_name)
//        {
//            if(last_name.getText().isEmpty())
//                last_name.setText("Last Name");
//
//            last_name.setBorder(INPUT_BORDER);
//
//
//        }
//        else if(e.getSource()==username_input)
//        {
//            if(username_input.getText().isEmpty())
//                username_input.setText("Enter Username");
//
//            username_input.setBorder(INPUT_BORDER);
//
//
//        }
//        if(e.getSource()==input_mobile)
//        {
//            if(input_mobile.getText().isEmpty())
//                input_mobile.setText("Enter Mobile Number");
//
//            input_mobile.setBorder(INPUT_BORDER);
//
//
//        }if(e.getSource()==email_input)
//        {
//            if(email_input.getText().isEmpty())
//                email_input.setText("Enter Email");
//
//            email_input.setBorder(INPUT_BORDER);
//
//
//        }if(e.getSource()==input_address)
//        {
//            if(input_address.getText().isEmpty())
//                input_address.setText("Enter Address");
//
//            input_address.setBorder(new LineBorder(Color.black ,1,true));
//
//        }if(e.getSource()==password_input)
//        {
//
//            if(password_input.getPassword().length==0) {
//                password_input.setText("Enter Password");
//                password_input.setEchoChar((char) 0);
//            }
//            password_input.setBorder(INPUT_BORDER);
//
//        }
//
//        if(e.getSource()==day)
//        {
//            day.setBorder(COMBO_BOX_BORDER);
//        }
//        if(e.getSource()==month)
//        {
//            month.setBorder(COMBO_BOX_BORDER);
//        }  if(e.getSource()==year)
//        {
//            year.setBorder(COMBO_BOX_BORDER);
//        }
//        if(e.getSource()==exit)
//        {
//            exit.setBorder(new LineBorder(Color.white,2,true));
//        }else if(e.getSource()==submit)
//        {
//            submit.setBorder(new LineBorder(Color.white,2,true));
//
//        }
//
//        if(e.getSource()==courses_list)
//        {
//            courses_list.setBorder(COMBO_BOX_BORDER);
//        }
//    }
//
//    public  void performedMouseFocusEvent(FocusEvent e)
//    {
//        if(e.getSource()==submit) {
//            submit.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==exit)
//        {
//            exit.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==day)
//        {
//            day.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==month)
//        {
//            month.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==year)
//        {
//            year.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==courses_list)
//        {
//            courses_list.setBorder(HOVER_BORDER);
//        }
//
//        if(e.getSource()==first_name)
//        {
//            if(first_name.getText().equalsIgnoreCase("First Name"))
//                first_name.setText("");
//
//            first_name.setBorder(HOVER_BORDER);
//        }
//
//
//        if(e.getSource()==middle_name) {
//            if (middle_name.getText().equalsIgnoreCase("Middle Name"))
//            {
//                middle_name.setText("");
//            }
//
//            middle_name.setBorder(HOVER_BORDER);
//
//        }
//
//        if(e.getSource()==last_name) {
//            if (last_name.getText().equalsIgnoreCase("Last Name"))
//                last_name.setText("");
//
//            last_name.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==username_input) {
//            if (username_input.getText().equalsIgnoreCase("Enter Username"))
//                username_input.setText("");
//
//            username_input.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==input_mobile) {
//            if (input_mobile.getText().equalsIgnoreCase("Enter Mobile Number"))
//                input_mobile.setText("");
//
//            input_mobile.setBorder(HOVER_BORDER);
//        }
//        if(e.getSource()==email_input)
//        {
//            if (email_input.getText().equalsIgnoreCase("Enter Email"))
//                email_input.setText("");
//
//            email_input.setBorder(HOVER_BORDER);
//
//        }if(e.getSource()==input_address) {
//        if (input_address.getText().equalsIgnoreCase("Enter Address"))
//            input_address.setText("");
//
//        input_address.setBorder(HOVER_BORDER);
//    }
//
//        if(e.getSource()==password_input)
//        {
//
//            String pass  = new String(password_input.getPassword());
////            if(pass.length()==0)
////            {
////                password_input.setText("Enter pass");
////                password_input.setEchoChar((char) 0);
////            }
//            if(pass.equalsIgnoreCase("Enter Password")) {
//                password_input.setText("");
//                password_input.setEchoChar(pass_echo_char);
//            }
//
//            password_input.setBorder(HOVER_BORDER);
//
//
//        }
//    }
//}
