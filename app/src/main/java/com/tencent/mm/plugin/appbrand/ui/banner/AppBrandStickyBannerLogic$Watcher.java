package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

final class AppBrandStickyBannerLogic$Watcher extends MainProcessTask {
    public static final Creator<AppBrandStickyBannerLogic$Watcher> CREATOR = new 2();
    private static final transient Map<String, f> jOD = new HashMap();
    String jOA;
    String jOB;
    int jOC;

    public final void Yr() {
        if (!bh.ov(this.jOA)) {
            synchronized (jOD) {
                if (jOD.containsKey(this.jOA)) {
                    b.c((f) jOD.get(this.jOA));
                }
                f 1 = new 1(this);
                b.d(1);
                jOD.put(this.jOA, 1);
            }
        }
    }

    public final void Ys() {
        a.aL(this.jOB, this.jOC);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jOA);
        parcel.writeString(this.jOB);
        parcel.writeInt(this.jOC);
    }

    public final void f(Parcel parcel) {
        this.jOA = parcel.readString();
        this.jOB = parcel.readString();
        this.jOC = parcel.readInt();
    }

    AppBrandStickyBannerLogic$Watcher() {
    }
}
