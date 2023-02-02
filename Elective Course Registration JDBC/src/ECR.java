import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame{

    JLabel name, usn, phone, dept, gender, pelective, oelective;
    JLabel title;
    JTextField sname, susn, sphone;
    JComboBox<String> sdept, sgender, spelective, soelective, sodept;
    JButton submit;
    JLabel msg;

    MyFrame(){
        setTitle("Elective Registration Form");
        setSize(700,500);
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
        String depts[] = {"Computer Science and Engineering", "Information Science and Engineering", "Electronics and Communication Engineering", "Electrical and Electronics Engineering", "Aeronautical Engineering", "Mechanical Engineering", "Civil Engineering"};
        sdept = new JComboBox<String>(depts);
        sdept.setFont(new Font("Consolas", Font.BOLD, 15));
        sdept.setBounds(250,245,325,20);
        c.add(sdept);

        gender = new JLabel("Gender");
        gender.setBounds(20,300,100,20);
        gender.setFont(new Font("Consolas", Font.BOLD, 20));
        c.add(gender);
        String genders[] = {"Male", "Female", "Others"};
        sgender = new JComboBox<String>(genders);
        sgender.setFont(new Font("Consolas", Font.BOLD, 15));
        sgender.setBounds(250,295,150,20);
        c.add(sgender);

        
        // displaying content of professional elective according to branch selected
        String CSEpelective[] = {"Advanced Web Programming","Advanced Algorithms","Data Warehousing and Mining", "Advanced Java"};
        String ISEpelective[] = CSEpelective;
        String ECpelective[] = {"Power Electronics", "System Modelling", "Speech Processing", "Artificial Neural Networks", "Cryptography and Network Security"};
        String EEpelective[] = {"Fuzzy Logic","Modern Control Theory", "Design of Electical Machines","Special Electrical Machines", "Electrical and Electronics Measurements"};
        String AEpelective[] = {"Control Engineering", "Finite Element Analysis", "Fracture Mechanics", "Turbo Machines", "Aircraft System and Instrumentation"};
        String MEpelective[] = {"Theory of Elasticity", "Mechanics of Composite Materials","Energy Engineering", "IC Engines", "Industrial Engineering and Ergonomics","Non-Traditional Machining","Machine Drawing"};
        String CEpelective[] = {"Theory of Elasticity", "Open Channel Hydraulics", "Railways, Airports and Harbours", "Wastewater Engineering", "Alternative Building Materials"};
        sdept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String selectedOption = (String) sdept.getSelectedItem();
                switch(selectedOption){
                    case "Computer Science and Engineering": spelective.setModel(new DefaultComboBoxModel<>(CSEpelective));
                    break;
                    case "Information Science and Engineering": spelective.setModel(new DefaultComboBoxModel<>(ISEpelective));
                    break;
                    case "Electronics and Communication Engineering": spelective.setModel(new DefaultComboBoxModel<>(ECpelective));
                    break;
                    case "Electrical and Electronics Engineering": spelective.setModel(new DefaultComboBoxModel<>(EEpelective));
                    break;
                    case "Aeronautical Engineering": spelective.setModel(new DefaultComboBoxModel<>(AEpelective));
                    break;
                    case "Mechanical Engineering": spelective.setModel(new DefaultComboBoxModel<>(MEpelective));
                    break;
                    case "Civil Engineering": spelective.setModel(new DefaultComboBoxModel<>(CEpelective));
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
        String sodepts[] = {"CSE","ISE","ECE","EEE","AE","ME","CE"};
        sodept = new JComboBox<>(sodepts);
        sodept.setFont(new Font("Consolas", Font.BOLD, 15));
        sodept.setBounds(250,395,50,20);
        c.add(sodept);
        soelective = new JComboBox<String>();
        soelective.setFont(new Font("Consolas", Font.BOLD, 15));
        soelective.setBounds(300,395,300,20);
        c.add(soelective);

        // Dynamic Open Elective Implementation
        String CSEoelective[] = {"NoSQL","Enterprise Resource Planning","Project Management","Principles of Cyber Security"};
        String ISEoelective[] = CSEoelective;
        String ECoelective[] = {"Consumer Electronics","Fuzzy Logic and Applications","Heterogeneous Computing", "Requirements Engineering"};
        String EEoelective[] = {"Renewable Energy Sources","Illumination Engineering","PLC and Industrial Automation", "Special Electric Machines","Embedded Systems"};
        String AEoelective[] = {"Wind Tunnel Techniques","Measurement and Metrology","Composite Materials"};
        String MEoelective[] = {"Product Design & Rapid Prototyping", "Automotive Engg. and Current Tech.","Mechatronics","Statistics for Engineers"};
        String CEoelective[] = {"Environmental Impace Assesment","Road Safety"};
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

        setVisible(true);
    }

}

public class ECR {
    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();
    }
}
