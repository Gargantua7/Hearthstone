package hearthstone;

/**
 * 随从类
 *
 * @author GongShuotao
 */
public class Minion {
    /** 攻击力 */
    private final int attackPower;
    /** 当前生命值 */
    private int health;
    /** 是否存活 */
    private boolean alive;
    
    public Minion(int attackPower, int health) {
        this.attackPower = attackPower;
        this.health = health;
        alive = true;
    }
    
    /**
     * 获取随从攻击力
     *
     * @return 随从攻击力
     */
    public int getAttackPower() {
        return attackPower;
    }
    
    /**
     * 随从受伤
     *
     * @param attack 受到的伤害
     */
    public void hurt(int attack) {
        health -= attack;
        if (health <= 0)
            alive = false;
    }
    
    /**
     * 获取当前生命值
     *
     * @return 当前生命值
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * 是否存活
     *
     * @return 存活返回false，否则true
     */
    public boolean getAlive() {
        return !alive;
    }
}