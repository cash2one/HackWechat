package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static StringBuilder a(TimePoint timePoint) {
        StringBuilder stringBuilder = new StringBuilder();
        if (timePoint == null) {
            x.i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
            return stringBuilder;
        }
        stringBuilder.append(0).append(". ").append(timePoint.name).append(" : ");
        stringBuilder.append(timePoint.iLS);
        stringBuilder.append(", ");
        stringBuilder.append(timePoint.iLR.get());
        stringBuilder.append(", ");
        stringBuilder.append(timePoint.iLS.get() - timePoint.iLS.get());
        int i = 0;
        TimePoint timePoint2 = timePoint;
        while (timePoint2.iLT.get() != null) {
            TimePoint timePoint3 = (TimePoint) timePoint2.iLT.get();
            stringBuilder.append("\n");
            stringBuilder.append(i + 1).append(". ").append(timePoint3.name).append(" : ");
            stringBuilder.append(((double) (timePoint3.iLS.get() - timePoint2.iLS.get())) / 1000000.0d);
            i++;
            timePoint2 = timePoint3;
        }
        stringBuilder.append("\n");
        stringBuilder.append("total cost : ").append(((double) (timePoint2.iLS.get() - timePoint.iLS.get())) / 1000000.0d);
        return stringBuilder;
    }
}
