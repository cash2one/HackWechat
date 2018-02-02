package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;

class AppBrandTaskUsageRecorder$LaunchCheckParams$1 implements Creator<LaunchCheckParams> {
    AppBrandTaskUsageRecorder$LaunchCheckParams$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LaunchCheckParams(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LaunchCheckParams[i];
    }
}
