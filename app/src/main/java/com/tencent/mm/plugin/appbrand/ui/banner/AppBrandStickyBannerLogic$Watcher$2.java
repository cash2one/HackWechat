package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.Watcher;

class AppBrandStickyBannerLogic$Watcher$2 implements Creator<Watcher> {
    AppBrandStickyBannerLogic$Watcher$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Watcher watcher = new Watcher();
        watcher.f(parcel);
        return watcher;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Watcher[i];
    }
}
