package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult;

class AppBrandPrepareTask$PrepareResult$1 implements Creator<PrepareResult> {
    AppBrandPrepareTask$PrepareResult$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PrepareResult(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PrepareResult[i];
    }
}
