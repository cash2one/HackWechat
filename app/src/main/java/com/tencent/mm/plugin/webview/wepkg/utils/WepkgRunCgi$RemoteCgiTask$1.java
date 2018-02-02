package com.tencent.mm.plugin.webview.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.utils.WepkgRunCgi.RemoteCgiTask;

class WepkgRunCgi$RemoteCgiTask$1 implements Creator<RemoteCgiTask> {
    WepkgRunCgi$RemoteCgiTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RemoteCgiTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RemoteCgiTask[i];
    }
}
