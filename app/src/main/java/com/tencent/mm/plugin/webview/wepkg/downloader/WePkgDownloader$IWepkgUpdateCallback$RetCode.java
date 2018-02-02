package com.tencent.mm.plugin.webview.wepkg.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum WePkgDownloader$IWepkgUpdateCallback$RetCode implements Parcelable {
    OK,
    LOCAL_FILE_NOT_FOUND,
    PKG_INTEGRITY_FAILED,
    PKG_INVALID,
    FAILED,
    CANCEL;
    
    public static final Creator<WePkgDownloader$IWepkgUpdateCallback$RetCode> CREATOR = null;

    static {
        CREATOR = new Creator<WePkgDownloader$IWepkgUpdateCallback$RetCode>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return WePkgDownloader$IWepkgUpdateCallback$RetCode.values()[parcel.readInt()];
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WePkgDownloader$IWepkgUpdateCallback$RetCode[i];
            }
        };
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
