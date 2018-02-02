package com.tencent.qqmusic.mediaplayer.perf;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PerformanceTracer {
    private long lastTimeStampNanoSecond = 0;
    private File mediaFile;
    private long playStartTimestampNanoSec = 0;
    private final Map<String, SpeedCheck> speedMap = new LinkedHashMap();
    private long totalPcmInByte;
    private long totalTimeCostInNanoSec = 0;

    public void init(File file) {
        this.mediaFile = file;
        this.lastTimeStampNanoSecond = 0;
        for (SpeedCheck reset : this.speedMap.values()) {
            reset.reset();
        }
    }

    public void playStart() {
        this.totalPcmInByte = 0;
    }

    public void playEnd() {
    }

    public void roundStart() {
        this.playStartTimestampNanoSec = System.nanoTime();
    }

    public void roundEnd(int i) {
        this.totalPcmInByte += (long) i;
        this.totalTimeCostInNanoSec += System.nanoTime() - this.playStartTimestampNanoSec;
    }

    public void start(String str) {
        getSpeedCheck(str);
        this.lastTimeStampNanoSecond = System.nanoTime();
    }

    public void end(String str, int i) {
        SpeedCheck.access$000(getSpeedCheck(str), i, System.nanoTime() - this.lastTimeStampNanoSecond);
    }

    public void accept(Visitor visitor) {
        List<SpeedCheck> arrayList = new ArrayList(this.speedMap.values());
        for (SpeedCheck access$100 : arrayList) {
            SpeedCheck.access$100(access$100);
        }
        visitor.visitSpeedCheck(arrayList, new OverallInfo(this.mediaFile, Math.round(((double) this.totalTimeCostInNanoSec) / 1000000.0d), this.totalPcmInByte));
    }

    private SpeedCheck getSpeedCheck(String str) {
        SpeedCheck speedCheck = (SpeedCheck) this.speedMap.get(str);
        if (speedCheck != null) {
            return speedCheck;
        }
        speedCheck = new SpeedCheck(str, null);
        this.speedMap.put(str, speedCheck);
        return speedCheck;
    }
}
