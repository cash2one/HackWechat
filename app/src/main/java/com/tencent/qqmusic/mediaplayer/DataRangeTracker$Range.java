package com.tencent.qqmusic.mediaplayer;

class DataRangeTracker$Range {
    private final long first;
    private final long second;

    private DataRangeTracker$Range(long j, long j2) {
        this.first = j;
        this.second = j2;
    }

    public String toString() {
        return "[" + this.first + ", " + this.second + ']';
    }
}
