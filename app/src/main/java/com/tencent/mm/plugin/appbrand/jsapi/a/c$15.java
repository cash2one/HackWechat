package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.8;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class c$15 implements OnClickListener {
    final /* synthetic */ c jgI;

    c$15(c cVar) {
        this.jgI = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "confirm bind phone number");
        dialogInterface.dismiss();
        c cVar = this.jgI;
        x.i("MicroMsg.JsApiGetPhoneNumber", "doBindPhoneNumber()");
        Intent intent = new Intent(cVar.jgr.mContext, AppBrandRedirectUI.class);
        intent.putExtra("key_from_scene", 0);
        MMActivity mMActivity = (MMActivity) cVar.jgr.mContext;
        mMActivity.jwN = new 8(cVar, mMActivity);
        mMActivity.startActivityForResult(intent, 100);
    }
}
