package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.secinforeport.a.a;

class JsApiSetClipboardData$ReportClipBoardTask extends MainProcessTask {
    public static final Creator<JsApiSetClipboardData$ReportClipBoardTask> CREATOR = new Creator<JsApiSetClipboardData$ReportClipBoardTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiSetClipboardData$ReportClipBoardTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetClipboardData$ReportClipBoardTask[i];
        }
    };
    private String iZW;
    private String mAppId;
    private int mLength;

    public JsApiSetClipboardData$ReportClipBoardTask(String str, String str2, int i) {
        this.mAppId = str;
        this.iZW = str2;
        this.mLength = i;
    }

    public final void Yr() {
        int i = a.qff;
        a.s(this.mLength, this.mAppId, this.iZW);
    }

    public JsApiSetClipboardData$ReportClipBoardTask(Parcel parcel) {
        f(parcel);
    }

    public final void f(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.iZW = parcel.readString();
        this.mLength = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeString(this.iZW);
        parcel.writeInt(this.mLength);
    }
}
