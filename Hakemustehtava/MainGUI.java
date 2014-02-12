import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainGUI extends JFrame
{

	public MainGUI()
	{
		initGUI();
	}
	
	private void initGUI()
	{
		final EncodeDecode ed = new EncodeDecode();
		
		JPanel panel = new JPanel();
		
		getContentPane().add(panel);
		
		panel.setLayout(null);
		
		//Creating the text are
		final JTextArea txtArea = new JTextArea();
		
		txtArea.setLineWrap(true);
		txtArea.setBounds(20, 50, 350, 200);
		
		panel.add(txtArea);
		
		//Creating the buttons and their event listeners
		JButton encodeButton = new JButton("Encode");
		JButton decodeButton = new JButton("Decode");
		
		encodeButton.setBounds(50,300,80,30);
		decodeButton.setBounds(250,300,80,30);
		
		encodeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String tmp = txtArea.getText();
					tmp = ed.Encode(tmp);
					txtArea.setText(tmp);
				}
				catch (Exception ex)
				{
					 JOptionPane.showMessageDialog(null, "An error has occured. Maybe you meant to decode?", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		decodeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String tmp = txtArea.getText();
					tmp = ed.Decode(tmp);
					txtArea.setText(tmp);
				}
				catch (Exception ex)
				{
					 JOptionPane.showMessageDialog(null, "An error has occured. Maybe you meant to encode?", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panel.add(encodeButton);
		panel.add(decodeButton);
		
		//Creating a label for the window
		JLabel label = new JLabel("Insert text to be decoded or encoded");
		
		label.setBounds(20, 10, 300, 20);
		
		panel.add(label);
		
		//Setting up the window
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
