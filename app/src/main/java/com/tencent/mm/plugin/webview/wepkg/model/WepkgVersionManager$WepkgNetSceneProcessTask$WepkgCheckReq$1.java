package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager.WepkgNetSceneProcessTask.WepkgCheckReq;

class WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq$1 implements Creator<WepkgCheckReq> {
    WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WepkgCheckReq(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WepkgCheckReq[i];
    }
}
