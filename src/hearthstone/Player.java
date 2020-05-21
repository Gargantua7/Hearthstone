package hearthstone;

/**
 * 玩家类
 *
 * @author GongShuotao
 */
public class Player {
    
    /** 当前生命值 */
    private int health;
    /** 随从区数据 */
    private final Battlefield battlefield;
    
    public Player() {
        health = Configuration.PLAYER_INITIAL_HEALTH;
        battlefield = new Battlefield();
    }
    
    /**
     * 召唤随从
     *
     * @param position    随从位置
     * @param attackPower 随从攻击力
     * @param health      随从初始生命值
     */
    public void summon(int position, int attackPower, int health) {
        battlefield.add(position, attackPower, health);
    }
    
    /**
     * 攻击敌方单位
     *
     * @param attacker 攻击随从
     * @param defender 被攻击随从
     * @param enemy    对方玩家对象
     */
    public void attack(int attacker, int defender, Player enemy) {
        
        Minion attackerMinion = getMinion(attacker);
        int attackerPower = attackerMinion.getAttackPower();
        if (defender == -1)
            enemy.hurt(attackerPower);
        else {
            Minion defenderMinion = enemy.getMinion(defender);
            int defenderPower = defenderMinion.getAttackPower();
            attackerMinion.hurt(defenderPower);
            defenderMinion.hurt(attackerPower);
            if (attackerMinion.getAlive())
                clean(attacker);
            if (defenderMinion.getAlive())
                enemy.clean(defender);
        }
    }
    
    /**
     * 受到伤害
     *
     * @param attack 受到伤害值
     */
    public void hurt(int attack) {
        health -= attack;
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
     * 获取当前战场类对象
     *
     * @return 当前战场类对象
     */
    public int[] settlement() {
        return battlefield.settlement();
    }
    
    /**
     * 获取场上某个位置的随从
     *
     * @param position 位置
     * @return 此位置的随从对象
     */
    public Minion getMinion(int position) {
        return battlefield.minions[position];
    }
    
    /**
     * 清理死亡随从
     *
     * @param position 死亡随从位置
     */
    public void clean(int position) {
        battlefield.clean(position);
    }
}
