package com.domin;

/**
 * @author zhou
 * 钢琴
 */
public class Piano extends Instrument {
    private String name="Piano";//乐器名称
    private String sound;//声音

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Piano{" +
                "name='" + name + '\'' +
                ", sound='" + sound + '\'' +
                '}';
    }
}
