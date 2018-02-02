package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseMedia$ChooseResult extends ProcessResult {
    public static final Creator<JsApiChooseMedia$ChooseResult> CREATOR = new Creator<JsApiChooseMedia$ChooseResult>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiChooseMedia$ChooseResult(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiChooseMedia$ChooseResult[i];
        }
    };
    int bjW;
    String jnd;
    String type;

    protected final void h(Parcel parcel) {
        this.bjW = parcel.readInt();
        this.type = parcel.readString();
        this.jnd = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bjW);
        parcel.writeString(this.type);
        parcel.writeString(this.jnd);
    }

    JsApiChooseMedia$ChooseResult() {
    }

    JsApiChooseMedia$ChooseResult(Parcel parcel) {
        h(parcel);
    }
}
