package com.domin;

import java.io.Serializable;

/**
 * @author zhou
 * 乐器
 */
public class Instrument implements Serializable {
    private String name;//乐器名称
    private String sound;//声音

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return super.toString()+getName()+" "+getSound();
    }
}
