import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class JavaAudioPlaySoundExample extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static boolean play = true;
    static AudioStream BGM;
	ImageIcon img = new ImageIcon("musicplayer.png");
	JButton b;
	static Integer r;

	public static void main(String[] args){
		new JavaAudioPlaySoundExample().setVisible(true);
	}
	
	JavaAudioPlaySoundExample(){
		setSize(500, 300);
        setTitle("Music Player");
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        b = new JButton(img);
        add(b).setBounds(-3, -10, 500, 300);
        
        if(play)
        	b.setActionCommand("Play");
        b.addActionListener (this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String Action;
        Action = e.getActionCommand ();
        if (Action.equals ("Play"))
        {
            if(!play){
            	img = new ImageIcon("musicplayer.png");
            	b.setIcon(img);
            	add(b).setBounds(-3, -10, 500, 300);
            	AudioPlayer.player.stop(BGM);
            	play = !play;
            }
            else{
        	img = new ImageIcon("musicplayer.gif");
        	b = new JButton(img);
        	add(b).setBounds(-3, -10, 500, 300);
        	music();
//        	String s = "Tumi na thakle sokal ta eto mishti hoto na, tmi na thakle...";
//
//        	MarqueePanel mp = new MarqueePanel(s, 60);
//        	
//        	add(mp).setBounds(30, 20, 420, 50);
//        	mp.start();
        	play = !play;
            }
        }
	}
	
    public static void music() 
    {       
        try
        {
        	r = 1 + (int)(Math.random()*9);
        	System.out.println("\nPlaying Song - "+r);
           	InputStream test = new FileInputStream("music/"+r+".wav");
           	BGM = new AudioStream(test);
           	AudioPlayer.player.start(BGM);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error){
            System.out.print(error.toString());
        }
    	
//    	try {
//            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("abc.wav"));
//            Clip clip = AudioSystem.getClip();
//            clip.open(audio);
//           	clip.start();
//           	
//           	long startTime = System.currentTimeMillis();
//           	while ((System.currentTimeMillis()-startTime)< 0.5*60*1000){
//           	  if(!play) break;
//           	}
//           	
//           	clip.stop();
//            
//        }
//
//        catch(UnsupportedAudioFileException uae) {
//            System.out.println(uae);
//        }
//        catch(IOException ioe) {
//            System.out.println(ioe);
//        }
//        catch(LineUnavailableException lua) {
//            System.out.println(lua);
//        }
    }
}

//class MarqueePanel extends JPanel implements ActionListener {
//
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private static final int RATE = 12;
//    private final Timer timer = new Timer(1000 / RATE, this);
//    private final JLabel label = new JLabel();
//    private final String s;
//    private final int n;
//    private int index;
//
//    public MarqueePanel(String s, int n) {
//        if (s == null || n < 1) {
//            throw new IllegalArgumentException("Null string or n < 1");
//        }
//        StringBuilder sb = new StringBuilder(n);
//        for (int i = 0; i < n; i++) {
//            sb.append(' ');
//        }
//        this.s = sb + s + sb;
//        this.n = n;
//        label.setText(sb.toString());
//        this.add(label);
//    }
//
//    public void start() {
//        timer.start();
//    }
//
//    public void stop() {
//        timer.stop();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        index++;
//        if (index > s.length() - n) {
//            index = 0;
//        }
//        label.setText(s.substring(index, index + n));
//    }
//}



