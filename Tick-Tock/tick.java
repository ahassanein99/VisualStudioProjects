import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class tick extends JApplet implements MouseMotionListener ,MouseListener ,ActionListener, KeyListener
{
 JButton start;
 JButton stop;
 JButton reset;

 JButton Speed;
 JButton Ballstart;
 JButton Ballstop;

 JLabel stoptime;
 JLabel nonstop;

 int x = 30;
 int y = 150;

 Timer mytime;
 Timer circletime;

 int time;

 int oldspeedx = 1;
 int oldspeedy = 1;

 int ball = 0;

 int speedx = 1;
 int speedy = 1;

 int mytimeint = 1000;


 int R = (int) (Math.random( )*256);
 int G = (int)(Math.random( )*256);
 int B= (int)(Math.random( )*256);

 public void init()
 {
  setContentPane(new DrawingPanel());

  start = new JButton("Start");
  stop = new JButton("Stop");
  reset = new JButton("Reset");

  Speed = new JButton("Speeeed");
  Ballstart = new JButton("Start Animation");
  Ballstop = new JButton("Stop Animation");

  stoptime = new JLabel("StopWatch");
  nonstop = new JLabel("Proof");

  mytime = new Timer(1000,this);
  circletime = new Timer(5, this);


  start.addActionListener(this);
  stop.addActionListener(this);
  reset.addActionListener(this);

  Speed.addActionListener(this);
  Ballstart.addActionListener(this);
  Ballstop.addActionListener(this);

  add(start);
  add(stop);
  add(reset);
  add(stoptime);
  add(Ballstart);
  add(Speed);
  add(Ballstop);
  add(nonstop);

  addMouseListener(this);
  addMouseMotionListener(this);
  addKeyListener(this);

  setFocusable(true);

  Color randomColor = new Color(R, G, B);
 }
 public void actionPerformed(ActionEvent e)
 {
  if (e.getSource() == Ballstart)
  {
   speedx = oldspeedx;
   speedy = oldspeedy;
   circletime.start();
   repaint();
  }
  if (x > 1200)
  {
   speedx = speedx * (-1);
  }
  if (y > 900)
  {
   speedy = speedy * (-1);
  }
  if (x < 0)
  {
   speedx = speedx * (-1);
  }
  if (y < 0)
  {
   speedy = speedy * (-1);
  }
  if (e.getSource() == Ballstop)
  {
   oldspeedx = speedx;
   oldspeedy = speedy;
   speedx = speedx - speedx;
   speedy = speedy - speedy;
   repaint();
  }
  if (e.getSource() == Speed)
  {
   speedx = speedx + 65;
   speedy = speedy + 65;
   System.out.print(mytimeint);
   repaint();
  }
  if (e.getSource() == circletime)
  {
    x = x + speedx;
    y = y + speedy;
    ball++;
   nonstop.setText("The timer is still going: " + ball);
    repaint();
  }
  if (e.getSource() == mytime)
  {
   time++;
    stoptime.setText("Time: " + time + " second(s)");
  }

  if (e.getSource() == start)
  {
   mytime.start();
  }
  if (e.getSource() == stop)
  {
   mytime.stop();
  }
  if (e.getSource() == reset)
  {
   time = 0;
   mytime.stop();
   speedx = speedx - speedx;
   speedy = speedy - speedy;
   stoptime.setText("Time: " + time + " second(s)");
   x = 30;
   y = 150;
   ball = ball - ball;
   nonstop.setText("The timer is still going: " + ball);
   circletime.stop();
   repaint();
  }
 }
 public void mouseDragged(MouseEvent e)
 {

 }
 public void mouseMoved(MouseEvent e)
 {
 }
 public void keyPressed(KeyEvent e)
 {

 }
 public void keyReleased(KeyEvent e)
 {

 }
 public void keyTyped(KeyEvent e)
 {

 }
 public void mouseClicked(MouseEvent e)
 {

 }
 public void mousePressed(MouseEvent e)
 {

 }
 public void mouseReleased(MouseEvent e)
 {

 }
 public void mouseEntered(MouseEvent e)
 {

 }
 public void mouseExited(MouseEvent e)
 {
 }
 public class DrawingPanel extends JPanel
 {
  public void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   g.fillOval(x,y,500,500);
  }
 }
}