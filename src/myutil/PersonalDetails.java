package myutil;

public class PersonalDetails
{
    private  String status,courses, username, name, password, address, DOB , first_name, last_name,middle_name, email,mobile_no;

    private int id;
    public PersonalDetails(){

    }

    public PersonalDetails(String name,String status,String password)
    {
        this.name = name;
        this.status = status;
        this.password = password;


    }
    public PersonalDetails(String username,String status)
    {
        this.username = username;
        this.status = status;


    }
    public  void setId(int id){this.id = id;}
    public   void setName(String name)
    {
        this.name = name;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setStatus(String status) {this.status = status;}
    public void setFirstName(String first_name) {this.first_name = first_name;}
    public void setMiddleName(String middle_name) {this.middle_name = middle_name;}
    public void setLastName(String last_name) {this.last_name = last_name;}
    public void setDOB(String status) {this.DOB = DOB;}
    public void setAddress(String address) {this.address = address;}
    public void setEmail(String email) {this.email = email;}
    public  void setUsername(String username){this.username = username;}

    public  void setMobileNo(String mobile_no){this.mobile_no = mobile_no;}
    public  void setCourses(String courses){this.courses = courses;}

    public String getStatus()
    {
        return  this.status;
    }
    public String getPassword()
    {
        return  this.password;
    }
    public String getName()
    {
        return  this.name;
    }
    public String getFirstName() {return this.first_name;}
    public String getMiddleName() { return this.middle_name ;}
    public String getLastName() { return this.last_name ;}
    public String getDOB() { return this.DOB = DOB;}
    public String getAddress() { return this.address ;}
    public String getEmail() { return this.email;}
    public  String getMobileNo(){ return this.mobile_no;}
    public  String  getUsername(){return  this.username;}
    public  String getCourses(){return  this.courses;}
    public  int getId(){return this.id;}

    public void showPersonalDetails()
    {
        System.out.println("------------------------------------------------------");
        System.out.println("ID : " + this.id);
        System.out.println("Name : " + this.first_name + " " + this.middle_name + " "+this.last_name);
        System.out.println("Username : " + this.username);
        System.out.println("Password : " + this.password);
        System.out.println("Email : " +this.email);
        System.out.println("Address : " + this.address);
        System.out.println("Mobile : "+this.mobile_no);
        System.out.println("------------------------------------------------------");



    }


}