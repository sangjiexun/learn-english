package recitation_others;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class mykey implements KeyListener {

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		System.out.println("jkj");
		if(e.getKeyChar()=='a'){
			System.out.println("sdfsf");
		}
	}

	public void keyReleased(KeyEvent e) {

	}

}
