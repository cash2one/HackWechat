package com.tencent.mm.plugin.webview.modeltools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class WebViewClipBoardHelper$ClipBoardDataWrapper implements Parcelable {
    public static final Creator<WebViewClipBoardHelper$ClipBoardDataWrapper> CREATOR = new 1();
    int length;
    String url;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.length);
    }

    WebViewClipBoardHelper$ClipBoardDataWrapper() {
    }

    WebViewClipBoardHelper$ClipBoardDataWrapper(Parcel parcel) {
        this.url = parcel.readString();
        this.length = parcel.readInt();
    }
}
