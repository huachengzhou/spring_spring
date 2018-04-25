package com.domin;


import javax.inject.Inject;

/**
 * 计数器
 * @author zhou
 */
public class Counter {
    private double multiplier;
    private String song;

    @Inject //@Autowired @Resource
    private Instrument instrument;

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public  Counter(double multiplier, String song,Instrument instrument) {
        this.multiplier = multiplier;
        this.song = song;
        this.instrument=instrument;
    }
}
