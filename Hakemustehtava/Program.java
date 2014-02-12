
public class Program {

	public static void main(String[] args)
	{
		QuestionGUI q = new QuestionGUI();
		q.setVisible(true);
		
		while(q.isVisible())
		{
			//Just loop here until the QuestionGUI gets closed
		}
		
		MainGUI g = new MainGUI();
		g.setVisible(true);
	}

}
