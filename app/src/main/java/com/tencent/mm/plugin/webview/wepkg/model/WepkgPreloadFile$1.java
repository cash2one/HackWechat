package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class WepkgPreloadFile$1 implements Creator<WepkgPreloadFile> {
    WepkgPreloadFile$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WepkgPreloadFile(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WepkgPreloadFile[i];
    }
}
