package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact.GetUserDataTask;

class JsApiChooseWeChatContact$GetUserDataTask$1 implements Creator<GetUserDataTask> {
    JsApiChooseWeChatContact$GetUserDataTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetUserDataTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetUserDataTask[i];
    }
}
