package projetocomputacaografica;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Title extends Base{
	public Title (String url) {
		super(url);
	}
	
	@Override
	public void draw(Graphics2D g) {
        g.drawImage(img.getImage(), (int)x, (int)y, null);
	}
}
