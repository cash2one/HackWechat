package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import java.util.ArrayList;

final class JsApiChooseImage$ChooseResult extends ProcessResult {
    public static final Creator<JsApiChooseImage$ChooseResult> CREATOR = new 1();
    int bjW;
    ArrayList<AppBrandLocalMediaObject> jmK;

    protected final void h(Parcel parcel) {
        this.bjW = parcel.readInt();
        this.jmK = parcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bjW);
        parcel.writeTypedList(this.jmK);
    }

    JsApiChooseImage$ChooseResult() {
    }

    JsApiChooseImage$ChooseResult(Parcel parcel) {
        super(parcel);
    }
}
