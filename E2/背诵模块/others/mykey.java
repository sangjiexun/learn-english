package others;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class mykey implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("jkj");
		if(e.getKeyChar()=='a'){
			System.out.println("sdfsf");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
