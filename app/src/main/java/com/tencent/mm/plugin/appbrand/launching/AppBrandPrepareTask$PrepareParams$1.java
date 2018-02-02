package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams;

class AppBrandPrepareTask$PrepareParams$1 implements Creator<PrepareParams> {
    AppBrandPrepareTask$PrepareParams$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PrepareParams(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PrepareParams[i];
    }
}
