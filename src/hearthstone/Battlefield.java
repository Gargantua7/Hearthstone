package hearthstone;

/**
 * 战场类
 *
 * @author GongShuotao
 */
public class Battlefield {

	Minion[] minions; /**随从数组*/
	int length; /**随从数量*/
	
	public Battlefield() {
		length = 0;
		minions = new Minion[Configuration.MAX_MINIONS];
	}
	
	/**
	 * 增加随从
	 *
	 * @param position 位置
	 * @param attackPower 攻击力
	 * @param health 生命值
	 */
	public void add(int position, int attackPower, int health) {
		//将次位置后的随从置后一个位置
		if (length - position >= 0)
			System.arraycopy(minions, position, minions, position + 1, length - position);
		minions[position] = new Minion(attackPower, health);
		length++;
	}
	
	/**
	 * 随从死亡
	 *
	 * @param position 死亡随从位置
	 */
	public void clean(int position) {
		//将此位置后的随从置前一个位置
		if (length - position >= 0)
			System.arraycopy(minions, position + 1, minions, position, length - position);
		length--;
	}
	
	/**
	 * 统计所有随从生命值
	 *
	 * @return int[]
	 */
	public int[] settlement() {
		int[] minionHealth = new int[length + 1];
		minionHealth[0] = length;
		for (int i = 1; i <= length; i++) {
			if(minions[i - 1] != null)
			minionHealth[i] = minions[i - 1].getHealth(); //得到所有的在场随从生命值
		}
		return minionHealth;
	}
	
}
