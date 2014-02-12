import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionGUI extends JFrame
{
	
	public QuestionGUI()
	{
		InitGUI();
	}
	
	private void InitGUI()
	{
		JPanel panel = new JPanel();
		
		getContentPane().add(panel);
		
		panel.setLayout(null);
		
		//Creating the text field
		final JTextField txtField = new JTextField();
		
		txtField.setBounds(20, 50, 300, 30);
		
		panel.add(txtField);
		
		//Creating the button and its event listener
		JButton okButton = new JButton("OK");	
		
		okButton.setBounds(150,100,80,30);
		
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String tmp = txtField.getText();
				
				if(tmp.equals("42"))
				{
					setVisible(false); 
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong answer, try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panel.add(okButton);
		
		//Creating a label for the window
		JLabel label = new JLabel("What is the answer to life, the universe, and everything?");
		
		label.setBounds(20, 10, 400, 20);
		
		panel.add(label);
		
		//Setting up the window
		setSize(400,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}

}
