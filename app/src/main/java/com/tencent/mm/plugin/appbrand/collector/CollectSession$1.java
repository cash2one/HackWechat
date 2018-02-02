package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class CollectSession$1 implements Creator<CollectSession> {
    CollectSession$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        CollectSession collectSession = new CollectSession();
        collectSession.groupId = parcel.readString();
        collectSession.id = parcel.readString();
        collectSession.iLG = (TimePoint) parcel.readParcelable(CollectSession.class.getClassLoader());
        collectSession.iLJ = parcel.readString();
        Bundle readBundle = parcel.readBundle();
        if (readBundle != null) {
            collectSession.fxd.putAll(readBundle);
        }
        TimePoint timePoint = collectSession.iLG;
        if (timePoint != null) {
            collectSession.iLI.put(timePoint.name, timePoint);
            while (timePoint.iLT.get() != null) {
                timePoint = (TimePoint) timePoint.iLT.get();
                collectSession.iLI.put(timePoint.name, timePoint);
            }
            collectSession.iLH = timePoint;
        }
        return collectSession;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CollectSession[i];
    }
}
