package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.LoadParams;

class RuntimeLoadModuleTask$LoadParams$1 implements Creator<LoadParams> {
    RuntimeLoadModuleTask$LoadParams$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LoadParams(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LoadParams[i];
    }
}
