package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting.GetSettingTask;

class JsApiGetSetting$GetSettingTask$2 implements Creator<GetSettingTask> {
    JsApiGetSetting$GetSettingTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetSettingTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetSettingTask[i];
    }
}
