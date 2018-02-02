package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class PluginDescription$1 implements Creator<PluginDescription> {
    PluginDescription$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PluginDescription(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PluginDescription[i];
    }
}
