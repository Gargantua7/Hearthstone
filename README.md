# Hearthstone
###### [HANAMI ( HANAMI233 )](https://www.github.com/HANAMI233)
[Click to JavaDoc](JavaDoc/index.html)
***
Base Info
--
-|-
---:|:---:
Language|Java
Version|1.8.0_231
***
File Structure
--
- **hearthstone**
    - [Demo.java](src/hearthstone/Demo.java)
    - [Player.java](src/hearthstone/Player.java)
    - [Minion.java](src/hearthstone/Minion.java)
    - [Battlefield.java](src/hearthstone/Battlefield.java)
    - [Configuration.java](src/hearthstone/Configuration.java)
***
Input Format
--
- &lt;Command line number&gt; (int)
- &lt;action&gt; &lt;arg1&gt; &lt;arg2&gt; ... 
    - summon &lt;position&gt; &lt;attack&gt; &lt;health&gt;
        >Summon a minion at &lt;position&gt; (int)<br/>
         This minion's Attack Power is &lt;attack&gt; (int)<br/>
         And Initial Health is &lt;health&gt; (int)
    - attack &lt;attacker&gt; &lt;defender&gt;
        >Make your minion with position &lt;attacker&gt; (int)<br/>
         Attack a follower with position &lt;defender&gt (int)
    - end
        >End your round and Start your enemy's round
***
Output Format
--
>&lt;Results&gt;<br/>
>&lt;1st Health&gt;<br/>
>&lt;1st Minions&gt; &lt;M1 Health&gt; &lt;M2 Health&gt; ....<br/>
>&lt;2st Health&gt;<br/>
>&lt;2st Minions&gt; &lt;M1 Health&gt; &lt;M2 Health&gt; ....
- 1st Line 
    - &lt;Game Results&gt;
        >The winner of this game<br/>
         1 - First Gamer; 0 - Nobody; -1 - Last Gamer
- 2nd Line
    - &lt;1st Health&gt;
        >First Gamer's health when the game over
- 3rd Line
    - &lt;1st Minions&gt;
        >First Gamer's minions number when the game over
    - &lt;M($n) Health&gt;
        >First Gamer's minion's health with position-n when the game over
- 4th Line & 5 Line
    > Like 2nd Line or 3rd Line
***


