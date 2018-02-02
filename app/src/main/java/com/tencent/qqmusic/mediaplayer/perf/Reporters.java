package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.SpeedCheck;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Reporters {
    public static Visitor detail(AudioInformation audioInformation, Map<String, String> map) {
        return new 1(audioInformation, map);
    }

    private static void generateDetailedPerformance(List<SpeedCheck> list, StringBuilder stringBuilder, long j) {
        stringBuilder.append("\n详细性能数据:\n");
        stringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15s%15s%15s%15s", new Object[]{"名称", "平均速度(byte/ms)", "耗时(ms)", "数据量(byte)", "占总耗时比"}));
        for (SpeedCheck speedCheck : list) {
            stringBuilder.append("\n");
            stringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15.0f%15.0f%15.0f%15d%15d%13.2f", new Object[]{speedCheck.getName(), Double.valueOf(speedCheck.getAvg()), Double.valueOf(speedCheck.getMax()), Double.valueOf(speedCheck.getMin()), Long.valueOf(speedCheck.getTotalTimeMs()), Long.valueOf(speedCheck.getTotalBufferLength()), Double.valueOf(((double) speedCheck.getTotalTimeMs()) / ((double) j))}));
        }
        stringBuilder.append("\n");
    }
}
