package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements OnClickListener {
    final /* synthetic */ int gOK;
    final /* synthetic */ b hnV;
    final /* synthetic */ p jdJ;
    final /* synthetic */ dw jgY;
    final /* synthetic */ f jhc;

    f$3(f fVar, dw dwVar, p pVar, int i, b bVar) {
        this.jhc = fVar;
        this.jgY = dwVar;
        this.jdJ = pVar;
        this.gOK = i;
        this.hnV = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
        this.jgY.vJr = true;
        this.jdJ.E(this.gOK, this.jhc.e("ok", null));
        com.tencent.mm.ipcinvoker.wx_extension.b.a(this.hnV, new a(this) {
            final /* synthetic */ f$3 jhd;

            {
                this.jhd = r1;
            }

            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
                    x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                    return;
                }
                x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
            }
        });
    }
}
