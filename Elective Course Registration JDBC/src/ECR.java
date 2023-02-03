import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.regex.Pattern;

class MyFrame extends JFrame{

    JLabel name, usn, phone, dept, gender, pelective, oelective;
    JLabel title;
    JTextField sname, susn, sphone;
    JComboBox<String> sdept, sgender, spelective, soelective, sodept;
    JButton submit, delete, reset;
    JLabel msg;

    MyFrame(){
        setTitle("Elective Registration Form");
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Elective Course Registration");
        title.setBounds(33,10,700,50);
        title.setFont(new Font("Consolas", Font.BOLD, 40));
        c.add(title);

        name = new JLabel("Name");
        name.setBounds(20, 100, 100, 20);
        name.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(name);
        sname = new JTextField();
        sname.setBounds(250,95,250,25);
        sname.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(sname);

        usn = new JLabel("USN");
        usn.setBounds(20,150,100,20);
        usn.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(usn);
        susn = new JTextField();
        susn.setBounds(250,145,250,25);
        susn.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(susn);

        phone = new JLabel("Phone");
        phone.setBounds(20,200,100,20);
        phone.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(phone);
        sphone = new JTextField();
        sphone.setBounds(250,195,250,25);
        sphone.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(sphone);

        dept = new JLabel("Department");
        dept.setBounds(20,250,200,20);
        dept.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(dept);
        String depts[] = {"None","Computer Science and Engineering", "Information Science and Engineering", "Electronics and Communication Engineering", "Electrical and Electronics Engineering", "Aeronautical Engineering", "Mechanical Engineering", "Civil Engineering"};
        sdept = new JComboBox<String>(depts);
        sdept.setFont(new Font("Consolas", Font.BOLD, 15));
        sdept.setBounds(250,245,325,20);
        c.add(sdept);

        gender = new JLabel("Gender");
        gender.setBounds(20,300,100,20);
        gender.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(gender);
        String genders[] = {"None","Male", "Female", "Others"};
        sgender = new JComboBox<String>(genders);
        sgender.setFont(new Font("Consolas", Font.BOLD, 15));
        sgender.setBounds(250,295,150,20);
        c.add(sgender);

        
        // displaying content of professional elective according to branch selected
        String CSEpelective[] = {"None","Advanced Web Programming","Advanced Algorithms","Data Warehousing and Mining", "Advanced Java"};
        String ISEpelective[] = CSEpelective;
        String ECpelective[] = {"None","Power Electronics", "System Modelling", "Speech Processing", "Artificial Neural Networks", "Cryptography and Network Security"};
        String EEpelective[] = {"None","Fuzzy Logic","Modern Control Theory", "Design of Electical Machines","Special Electrical Machines", "Electrical and Electronics Measurements"};
        String AEpelective[] = {"None","Control Engineering", "Finite Element Analysis", "Fracture Mechanics", "Turbo Machines", "Aircraft System and Instrumentation"};
        String MEpelective[] = {"None","Theory of Elasticity", "Mechanics of Composite Materials","Energy Engineering", "IC Engines", "Industrial Engineering and Ergonomics","Non-Traditional Machining","Machine Drawing"};
        String CEpelective[] = {"None","Theory of Elasticity", "Open Channel Hydraulics", "Railways, Airports and Harbours", "Wastewater Engineering", "Alternative Building Materials"};
        
        String notCSE[] = {"None","ECE","EEE","AE","ME","CE"};
        String notISE[] = notCSE;
        String notECE[] = {"None","CSE","ISE","EEE","AE","ME","CE"};
        String notEEE[] = {"None","CSE","ISE","ECE","AE","ME","CE"};
        String notAE[] = {"None","CSE","ISE","ECE","EEE","ME","CE"};
        String notME[] = {"None","CSE","ISE","ECE","EEE","AE","CE"};
        String notCE[] = {"None","CSE","ISE","ECE","EEE","AE","ME"};
        
        sdept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String selectedOption = (String) sdept.getSelectedItem();
                switch(selectedOption){
                    case "Computer Science and Engineering": spelective.setModel(new DefaultComboBoxModel<>(CSEpelective));
                                                             sodept.setModel(new DefaultComboBoxModel<>(notCSE));
                    break;
                    case "Information Science and Engineering": spelective.setModel(new DefaultComboBoxModel<>(ISEpelective));
                                                             sodept.setModel(new DefaultComboBoxModel<>(notISE));
                    break;
                    case "Electronics and Communication Engineering": spelective.setModel(new DefaultComboBoxModel<>(ECpelective));
                                                             sodept.setModel(new DefaultComboBoxModel<>(notECE));
                    break;
                    case "Electrical and Electronics Engineering": spelective.setModel(new DefaultComboBoxModel<>(EEpelective));
                                                             sodept.setModel(new DefaultComboBoxModel<>(notEEE));
                    break;
                    case "Aeronautical Engineering": spelective.setModel(new DefaultComboBoxModel<>(AEpelective));
                                                             sodept.setModel(new DefaultComboBoxModel<>(notAE));
                    break;
                    case "Mechanical Engineering": spelective.setModel(new DefaultComboBoxModel<>(MEpelective));
                                                             sodept.setModel(new DefaultComboBoxModel<>(notME));
                    break;
                    case "Civil Engineering": spelective.setModel(new DefaultComboBoxModel<>(CEpelective));
                                                             sodept.setModel(new DefaultComboBoxModel<>(notCE));
                }
            }
        });

        pelective = new JLabel("Pro. Elective");
        pelective.setBounds(20,350,200,20);
        pelective.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(pelective);
        spelective = new JComboBox<String>();
        spelective.setFont(new Font("Consolas", Font.BOLD, 15));
        spelective.setBounds(250,345,200,20);
        c.add(spelective);

        oelective = new JLabel("Open Elective");
        oelective.setBounds(20,400,200,20);
        oelective.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(oelective);
        
        String sodepts[] = {"None","CSE","ISE","ECE","EEE","AE","ME","CE"};
        
        sodept = new JComboBox<>(sodepts);
        sodept.setFont(new Font("Consolas", Font.BOLD, 15));
        sodept.setBounds(250,395,60,20);
        c.add(sodept);
        soelective = new JComboBox<String>();
        soelective.setFont(new Font("Consolas", Font.BOLD, 15));
        soelective.setBounds(310,395,300,20);
        c.add(soelective);
        
        // Dynamic Open Elective Implementation
        String CSEoelective[] = {"None","NoSQL","Enterprise Resource Planning","Project Management","Principles of Cyber Security"};
        String ISEoelective[] = CSEoelective;
        String ECoelective[] = {"None","Consumer Electronics","Fuzzy Logic and Applications","Heterogeneous Computing", "Requirements Engineering"};
        String EEoelective[] = {"None","Renewable Energy Sources","Illumination Engineering","PLC and Industrial Automation", "Special Electric Machines","Embedded Systems"};
        String AEoelective[] = {"None","Wind Tunnel Techniques","Measurement and Metrology","Composite Materials"};
        String MEoelective[] = {"None","Product Design & Rapid Prototyping", "Automotive Engg. and Current Tech.","Mechatronics","Statistics for Engineers"};
        String CEoelective[] = {"None","Environmental Impace Assesment","Road Safety"};
        
        sodept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String selectedOption = (String) sodept.getSelectedItem();
                switch(selectedOption){
                    case "CSE": soelective.setModel(new DefaultComboBoxModel<>(CSEoelective));
                    break;
                    case "ISE": soelective.setModel(new DefaultComboBoxModel<>(ISEoelective));
                    break;
                    case "ECE": soelective.setModel(new DefaultComboBoxModel<>(ECoelective));
                    break;
                    case "EEE": soelective.setModel(new DefaultComboBoxModel<>(EEoelective));
                    break;
                    case "AE": soelective.setModel(new DefaultComboBoxModel<>(AEoelective));
                    break;
                    case "ME": soelective.setModel(new DefaultComboBoxModel<>(MEoelective));
                    break;
                    case "CE": soelective.setModel(new DefaultComboBoxModel<>(CEoelective));
                }
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(20,450,100,30);
        c.add(submit);

        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = sname.getText();
                String usn = susn.getText();
                String phone = sphone.getText();
                String dept = (String)sdept.getSelectedItem();
                String gender = (String)sgender.getSelectedItem();
                String professionalElective = (String)spelective.getSelectedItem();
                String openElective = (String)soelective.getSelectedItem();

                try {
                    Connection con = ConnectionProvider.createConnection(); 
                    String submit_query = "insert into Student(susn,sname,sphone,sdept,sgender,spelective,soelective) values(?,?,?,?,?,?,?)";

                    //preparedStatement
                    PreparedStatement pstmt = con.prepareStatement(submit_query);
                    
                    //set the values of parameter
                    if(Pattern.matches("[a-zA-Z]+", name)== true && usn != "" && name != "" && phone != "" && dept != "None" && gender != "None" && professionalElective != "None" && openElective != "None"){
                        pstmt.setString(1, usn);
                        pstmt.setString(2, name);
                        pstmt.setString(3, phone);
                        pstmt.setString(4, dept);
                        pstmt.setString(5, gender);
                        pstmt.setString(6, professionalElective);
                        pstmt.setString(7, openElective);

                        //execute
                        pstmt.executeUpdate();

                        System.out.println("Added succesfully!!");
                    }
                    else{
                        System.out.println("Fields can't be empty!");
                    }

                } catch (Exception except) {
                    except.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(150,450,100,30);
        c.add(delete);
        
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Connection con = ConnectionProvider.createConnection(); 
                    String delete_query = "delete from Student where susn = ?";

                    //preparedStatement
                    PreparedStatement pstmt = con.prepareStatement(delete_query);
                    String toDeleteUSN = (String)susn.getText();
                    pstmt.setString(1, toDeleteUSN);
                    
                    //execute
                    pstmt.executeUpdate();
                    
                    System.out.println("Deleted Succesfully!");
                        
                }
                catch(Exception except){
                    except.printStackTrace();
                }
                
            }
        });

        reset = new JButton("Reset");
        reset.setBounds(280,450,100,30);
        c.add(reset);

        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sname.setText("");
                susn.setText("");
                sphone.setText("");
                sdept.setSelectedItem("None");
                sgender.setSelectedItem("None");
                spelective.setSelectedItem("None");
                soelective.setSelectedItem("None");
                sodept.setSelectedItem("None");
            }
        });
        setVisible(true);
    }

}

public class ECR {
    public static void main(String[] args) {
         MyFrame frame = new MyFrame();
    }
}