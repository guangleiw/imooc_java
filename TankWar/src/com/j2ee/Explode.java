package com.j2ee;
import java.awt.*;
/**
 * 爆炸类
 * 用来定义爆炸的各种属性 和方法
 * @author wangguanglei1
 *
 */

public class Explode {
	int x, y;
	private boolean live = true;

	private TankClient tc;
	private static Toolkit tk = Toolkit.getDefaultToolkit();

	// int[] diameter = {4, 7, 12, 18, 26, 32, 49, 30, 14, 6};
	private static Image imgs[] = { tk.getImage(Explode.class.getClassLoader().getResource("images/0.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/1.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/2.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/3.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/4.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/5.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/6.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/7.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/8.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/9.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("images/10.gif")) };
	int step = 0;

	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}

	public void draw(Graphics g) {
		if (!live) {
			tc.explodes.remove(this);
			return;
		}

		if (step == imgs.length) {
			live = false;
			step = 0;
			return;
		}

		g.drawImage(imgs[step], x, y, null);

		step++;
	}
}
