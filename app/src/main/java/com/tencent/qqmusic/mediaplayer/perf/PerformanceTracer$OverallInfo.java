package com.tencent.qqmusic.mediaplayer.perf;

import java.io.File;

public class PerformanceTracer$OverallInfo {
    public final File mediaFile;
    public final long timeCostInMs;
    public final long totalPcmToBePlayed;

    public PerformanceTracer$OverallInfo(File file, long j, long j2) {
        this.mediaFile = file;
        this.timeCostInMs = j;
        this.totalPcmToBePlayed = j2;
    }
}
