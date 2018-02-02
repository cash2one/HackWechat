package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public class CollectSession implements Parcelable {
    public static final Creator<CollectSession> CREATOR = new 1();
    public final Bundle fxd = new Bundle();
    String groupId;
    TimePoint iLG;
    TimePoint iLH;
    final Map<String, TimePoint> iLI = new HashMap();
    String iLJ;
    String id;

    CollectSession() {
    }

    public CollectSession(String str) {
        this.id = str;
    }

    public final void qk(String str) {
        Assert.assertNull(this.iLG);
        this.iLG = new TimePoint(str, System.nanoTime());
        this.iLH = this.iLG;
        this.iLG.iLR.set(1);
        this.iLI.put(str, this.iLG);
    }

    public final void ql(String str) {
        Assert.assertNotNull(this.iLH);
        long nanoTime = System.nanoTime();
        TimePoint timePoint = (TimePoint) this.iLI.get(str);
        if (timePoint == null) {
            timePoint = new TimePoint(str, nanoTime);
            timePoint.iLR.set(1);
            this.iLI.put(str, timePoint);
            this.iLH.iLT.set(timePoint);
            this.iLH = timePoint;
            return;
        }
        timePoint.iLS.set((nanoTime + (timePoint.iLS.get() * ((long) timePoint.iLR.get()))) / ((long) (timePoint.iLR.get() + 1)));
        timePoint.iLR.incrementAndGet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.iLG, i);
        parcel.writeString(this.iLJ);
        parcel.writeBundle(this.fxd);
    }
}
