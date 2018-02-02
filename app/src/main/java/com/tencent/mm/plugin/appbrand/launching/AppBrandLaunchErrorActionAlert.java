package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;

final class AppBrandLaunchErrorActionAlert extends AppBrandLaunchErrorAction {
    final String jwG;
    final String jwH;

    AppBrandLaunchErrorActionAlert(String str, int i, String str2, String str3) {
        super(str, i);
        this.jwG = str2;
        this.jwH = str3;
    }

    @Keep
    AppBrandLaunchErrorActionAlert(Parcel parcel) {
        super(parcel);
        this.jwG = parcel.readString();
        this.jwH = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.jwG);
        parcel.writeString(this.jwH);
    }

    final void ca(Context context) {
        String str = this.jwH;
        String str2 = this.jwG;
        if (context instanceof Activity) {
            h.a(context, str, str2, false, null);
        } else {
            a.a(null, str, str2, ac.getResources().getString(j.dFU), "", null, null, null);
        }
    }
}
