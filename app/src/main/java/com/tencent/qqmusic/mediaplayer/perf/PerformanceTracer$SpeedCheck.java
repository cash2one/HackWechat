package com.tencent.qqmusic.mediaplayer.perf;

import java.util.Locale;

public class PerformanceTracer$SpeedCheck {
    private static final double f = 1000000.0d;
    private double avg;
    private double max;
    private double min;
    private final String name;
    private long totalBufferLength;
    private long totalTimeNanoSecond;

    public String getName() {
        return this.name;
    }

    public double getAvg() {
        return this.avg;
    }

    public double getMax() {
        return this.max;
    }

    public double getMin() {
        return this.min;
    }

    public long getTotalTimeMs() {
        return Math.round(((double) this.totalTimeNanoSecond) / f);
    }

    public long getTotalBufferLength() {
        return this.totalBufferLength;
    }

    private PerformanceTracer$SpeedCheck(String str) {
        this.name = str;
    }

    private void update(int i, long j) {
        this.totalBufferLength += (long) i;
        this.totalTimeNanoSecond += j;
        double d = (((double) i) * f) / ((double) j);
        if (d > this.max || this.max == 0.0d) {
            this.max = d;
        } else if (d < this.min || this.min == 0.0d) {
            this.min = d;
        }
    }

    private void compute() {
        this.avg = (((double) this.totalBufferLength) * f) / ((double) this.totalTimeNanoSecond);
    }

    void reset() {
        this.avg = 0.0d;
        this.max = 0.0d;
        this.min = 0.0d;
        this.totalTimeNanoSecond = 0;
        this.totalBufferLength = 0;
    }

    public String toString() {
        compute();
        return String.format(Locale.getDefault(), "%10s%15.2f%15.2f%15.2f%10d%15d", new Object[]{this.name, Double.valueOf(this.avg), Double.valueOf(this.max), Double.valueOf(this.min), Long.valueOf(this.totalTimeNanoSecond), Long.valueOf(this.totalBufferLength)});
    }
}
