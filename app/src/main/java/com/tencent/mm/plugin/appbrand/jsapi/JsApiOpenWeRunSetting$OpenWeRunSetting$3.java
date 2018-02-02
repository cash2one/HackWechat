package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting;

class JsApiOpenWeRunSetting$OpenWeRunSetting$3 implements Creator<OpenWeRunSetting> {
    JsApiOpenWeRunSetting$OpenWeRunSetting$3() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OpenWeRunSetting(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OpenWeRunSetting[i];
    }
}
