import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CourseForm{
	public static ArrayList<Course> courses = new ArrayList<Course>();
	Course course = new Course((String) null, (String) null, 0);
	JFrame frame = new JFrame("CourseForm");
	JPanel panel = new JPanel();
	JButton btnOK = new JButton("OK");
	final JTextField code = new JTextField(25);
	final JTextField title = new JTextField(25);
	final JTextField credit = new JTextField(25);
	ButtonListener btnListener = new ButtonListener(); 

	public CourseForm(ArrayList<Course> courses){
		this.courses = courses;

		panel.add(code);
		panel.add(title);
		panel.add(credit);
		panel.add(btnOK);

		panel.setLayout(new GridLayout(4,1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 

		btnOK.addActionListener(btnListener);
	}

	private class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			try{
				course.setCode(code.getText());
				course.setTitle(title.getText());
				course.setCredit(Integer.parseInt(credit.getText()));
				courses.add(course);
				JOptionPane.showMessageDialog(null, course);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}
			// frame.destroy();
		}
	}
}