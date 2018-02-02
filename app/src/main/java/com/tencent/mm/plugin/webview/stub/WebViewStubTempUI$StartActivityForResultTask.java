package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class WebViewStubTempUI$StartActivityForResultTask implements Parcelable {
    public static final Creator<WebViewStubTempUI$StartActivityForResultTask> CREATOR = new Creator<WebViewStubTempUI$StartActivityForResultTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WebViewStubTempUI$StartActivityForResultTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewStubTempUI$StartActivityForResultTask[i];
        }
    };
    int fyV;
    String qbl;
    int ttA;
    String tvR;
    Intent tvS;
    boolean tvT;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.qbl);
        parcel.writeString(this.tvR);
        parcel.writeParcelable(this.tvS, i);
        parcel.writeInt(this.fyV);
        parcel.writeByte(this.tvT ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.ttA);
    }

    WebViewStubTempUI$StartActivityForResultTask() {
    }

    WebViewStubTempUI$StartActivityForResultTask(Parcel parcel) {
        this.qbl = parcel.readString();
        this.tvR = parcel.readString();
        this.tvS = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.fyV = parcel.readInt();
        this.tvT = parcel.readByte() != (byte) 0;
        this.ttA = parcel.readInt();
    }
}
