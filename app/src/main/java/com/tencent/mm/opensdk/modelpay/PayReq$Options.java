package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.a;

public class PayReq$Options {
    public static final int INVALID_FLAGS = -1;
    public String callbackClassName;
    public int callbackFlags = -1;

    public void fromBundle(Bundle bundle) {
        this.callbackClassName = a.b(bundle, "_wxapi_payoptions_callback_classname");
        this.callbackFlags = a.a(bundle, "_wxapi_payoptions_callback_flags");
    }

    public void toBundle(Bundle bundle) {
        bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
        bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
    }
}
