import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class CardLayoutTest
{

	private static void createAndShowGUI()
	{
		JFrame frame = new JFrame("Card Layout Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		// This JPanel is the base for CardLayout for other JPanels.
		final JPanel contentPane = new JPanel();
		contentPane.setLayout(new CardLayout(20,20));

		MainWindow win1 = new MainWindow();
		contentPane.add(win1, "Welcome");
		FlappyBird2 win2 = new FlappyBird2();
		contentPane.add(win2, "play");


		JPanel buttonPanel = new JPanel(); 
		final JButton previousButton = new JButton("Start");
		previousButton.setBackground(Color.BLACK);
		previousButton.setForeground(Color.WHITE);

		buttonPanel.add(previousButton);

		previousButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.previous(contentPane);
			}
		});

		frame.add(contentPane, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.PAGE_END);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String... args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
} 
//
//class Window1 extends JPanel
//{
//    /*
//     * Here this is our first Card of CardLayout, which will
//     * be added to the contentPane object of JPanel, which
//     * has the LayoutManager set to CardLayout.
//     * This card consists of Two JButtons.
//     */  
//    private ActionListener action;
//
//    public Window1() 
//    {
//        init();
//    }
//
//    private void init() 
//    {
//        final JButton clickButton = new JButton("CLICK ME");
//        final JButton dontClickButton = new JButton("DON\'T CLICK ME");     
//
//        action = new ActionListener()
//        {
//            public void actionPerformed(ActionEvent ae)
//            {
//                if (ae.getSource() == clickButton)
//                {
//                    JOptionPane.showMessageDialog(null, "Hello there dude!"
//                                                , "Right Button", JOptionPane.INFORMATION_MESSAGE);
//                }
//                else if (ae.getSource() == dontClickButton)
//                {
//                    JOptionPane.showMessageDialog(null, "I told you not to click me!"
//                                                        , "Wrong Button", JOptionPane.PLAIN_MESSAGE);
//                }
//            }
//        };
//
//        clickButton.addActionListener(action);
//        dontClickButton.addActionListener(action);
//
//        add(clickButton);
//        add(dontClickButton);
//    }
//}
//
//class Window2 extends JPanel implements ActionListener 
//{
//    /*
//     * Here this is our second Card of CardLayout, which will
//     * be added to the contentPane object of JPanel, which
//     * has the LayoutManager set to CardLayout.
//     * This card consists of a JLabel and a  JTextField
//     * with GridLayout.
//     */  
//
//    private JTextField textField;
//
//    public Window2() 
//    {
//        init();
//    }
//
//    private void init() 
//    {
//        setLayout(new GridLayout(1, 2));
//        JLabel userLabel = new JLabel("Your Name : ");
//        textField = new JTextField();
//        textField.addActionListener(this);
//
//        add(userLabel);
//        add(textField);
//    }
//
//    public void actionPerformed(ActionEvent e) 
//    {            
//        if (textField.getDocument().getLength() > 0)
//            JOptionPane.showMessageDialog(null, "Your Name is : " + textField.getText()
//                                                                            , "User\'s Name : ", JOptionPane.QUESTION_MESSAGE);
//    }
//}
//
//class Window3 extends JPanel
//{
//    /*
//     * Here this is our third Card of CardLayout, which will
//     * be added to the contentPane object of JPanel, which
//     * has the LayoutManager set to CardLayout.
//     * This card consists of Two JLabels and two JCheckBox
//     * with GridLayout.
//     */  
//    private ActionListener state;
//
//    public Window3()
//    {
//        init();
//    }
//
//    public void init()
//    {
//        setLayout(new GridLayout(2, 2));
//        JLabel maleLabel = new JLabel("MALE", JLabel.CENTER);
//        final JCheckBox maleBox = new JCheckBox();
//        JLabel femaleLabel = new JLabel("FEMALE", JLabel.CENTER);
//        final JCheckBox femaleBox = new JCheckBox();
//
//        state = new ActionListener()
//        {
//            public void actionPerformed(ActionEvent ae)
//            {
//                if (maleBox == (JCheckBox) ae.getSource())
//                {
//                    femaleBox.setSelected(false);
//                    JOptionPane.showMessageDialog(null, "Congrats you are a Male"
//                                                , "Gender : ", JOptionPane.INFORMATION_MESSAGE);                            
//                }
//                else if (femaleBox == (JCheckBox) ae.getSource())
//                {
//                    maleBox.setSelected(false);
//                    JOptionPane.showMessageDialog(null, "Congrats you are a Female"
//                                            , "Gender : ", JOptionPane.INFORMATION_MESSAGE);                        
//                }
//            }
//        };
//
//        maleBox.addActionListener(state);
//        femaleBox.addActionListener(state);
//        add(maleLabel);
//        add(maleBox);
//        add(femaleLabel);
//        add(femaleBox);
//    }
//}