package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment.GetIsEnrolledTask;

class JsApiCheckBioEnrollment$GetIsEnrolledTask$1 implements Creator<GetIsEnrolledTask> {
    JsApiCheckBioEnrollment$GetIsEnrolledTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetIsEnrolledTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetIsEnrolledTask[i];
    }
}
