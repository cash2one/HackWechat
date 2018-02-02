package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.SpeedCheck;
import java.util.List;

public interface PerformanceTracer$Visitor {
    void visitSpeedCheck(List<SpeedCheck> list, PerformanceTracer$OverallInfo performanceTracer$OverallInfo);
}
