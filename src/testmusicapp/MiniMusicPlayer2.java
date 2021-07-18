package testmusicapp;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer2  {
    static JFrame frame = new JFrame("My first music clip");
    static MyDrawPanel m;

    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void setUpGui(){
        m = new MyDrawPanel();
        frame.setContentPane(m);
        frame.setBounds(30,30,300,300);
        frame.setVisible(true);
    }

    private void go() {
        setUpGui();

        try {
            //create and open
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(m,new int[] {127});
            //create sequence and track
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            int r =0;

            //create a group of events so that notes continue to rise(from 4 to 61)
            for (int i = 0; i < 60; i+=4) {
                r= (int)((Math.random() * 50) + 1);
                track.add(makeEvent(144,1, r,100,i));
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128,1, r,100,i+2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event =new MidiEvent(a,tick);
        } catch (Exception e) { }
        return event;
    }



    class MyDrawPanel extends JPanel implements ControllerEventListener{
        boolean msg = false;
        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if(msg){
                Graphics2D g2 = (Graphics2D) g;

                int r = (int)(Math.random() * 250);
                int gr = (int)(Math.random() * 250);
                int b = (int)(Math.random() * 250);

                g.setColor(new Color(r, gr, b));

                int ht = (int) ((Math.random() * 120) + 10);
                int wight = (int) ((Math.random() * 120) + 10);
                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);
                g.fillRect(x,y,ht,wight);
                msg = false;
            }
        }
    }
}
