package com.tencent.qqmusic.mediaplayer.perf;

class PerformanceTracer$BufferSizeCheck {
    private int lastSize = 0;
    private int maxMismatch = 0;
    private final String name;
    private int sizeMismatchCount = 0;

    public PerformanceTracer$BufferSizeCheck(String str) {
        this.name = str;
    }

    void onStart(int i) {
        this.lastSize = i;
    }

    void onEnd(int i) {
        if (i != this.lastSize) {
            int i2 = this.lastSize - i;
            if (Math.abs(i2) > this.maxMismatch) {
                this.maxMismatch = i2;
            }
            this.sizeMismatchCount++;
        }
    }

    public int getMaxMismatch() {
        return this.maxMismatch;
    }

    public String getName() {
        return this.name;
    }

    public int getSizeMismatchCount() {
        return this.sizeMismatchCount;
    }
}
