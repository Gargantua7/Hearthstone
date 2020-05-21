package hearthstone;

import java.util.Scanner;

/**
 * 测试类
 *
 * @author GongShuotao
 */
public class Demo {
	
	public static void main(String[] args) {
		
		Player p1 = new Player(); //先手玩家
		Player p2 = new Player(); //后手玩家
		
		Player nowPlayer = p1; //当前回合的玩家
		Player enemyPlayer = p2; //当前回合的玩家的对方玩家
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String command = sc.nextLine(); //读取指令
			String[] commands = command.split(" ");
			if(commands[0].equals("summon")) {
				int position = Integer.parseInt(commands[1]) - 1;
				int attackPower = Integer.parseInt(commands[2]);
				int health = Integer.parseInt(commands[3]);
				nowPlayer.summon(position, attackPower, health);
			}
			if(commands[0].equals("attack")) {
				int attcker = Integer.parseInt(commands[1]) - 1;
				int defender = Integer.parseInt(commands[2]) - 1;
				nowPlayer.attack(attcker, defender, enemyPlayer);
			}
			if(commands[0].equals("end")) {
				Player p = nowPlayer;
				nowPlayer = enemyPlayer;
				enemyPlayer = p;
			}
			if(p1.getHealth() <= 0 || p2.getHealth() <= 0) //检查是否有玩家死亡
				break;
		}
		
		sc.close();
		
		if(p1.getHealth() <= 0)
			System.out.println("2");
		else if(p2.getHealth() <= 0)
			System.out.println("1");
		else
			System.out.println("0");
		
		
		int [] p1M = p1.settlement(); //结算先手玩家数据
		System.out.println(p1.getHealth());
		for(int i : p1M) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		int [] p2M = p2.settlement(); //结算后手玩家数据
		System.out.println(p2.getHealth());
		for(int i : p2M) {
			System.out.print(i + " ");
		}
	}
}
