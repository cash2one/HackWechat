package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect.GetIsSupportFaceTask;

class JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask$1 implements Creator<GetIsSupportFaceTask> {
    JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetIsSupportFaceTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetIsSupportFaceTask[i];
    }
}
