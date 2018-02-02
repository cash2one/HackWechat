package com.tencent.mm.plugin.webview.modeltools;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper.ClipBoardDataWrapper;

class WebViewClipBoardHelper$ClipBoardDataWrapper$1 implements Creator<ClipBoardDataWrapper> {
    WebViewClipBoardHelper$ClipBoardDataWrapper$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ClipBoardDataWrapper(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ClipBoardDataWrapper[i];
    }
}
