package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderOpenApi$1 extends bc<MatrixCursor> {
    final /* synthetic */ String[] gIP;
    final /* synthetic */ ExtControlProviderOpenApi lZX;

    ExtControlProviderOpenApi$1(ExtControlProviderOpenApi extControlProviderOpenApi, String[] strArr) {
        this.lZX = extControlProviderOpenApi;
        this.gIP = strArr;
        super(20000, null, true);
    }

    protected final /* synthetic */ Object run() {
        return aFK();
    }

    private MatrixCursor aFK() {
        try {
            x.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
            b ewVar = new ew();
            ewVar.ftK.ftM = this.gIP;
            ewVar.fqI = new 1(this, ewVar);
            if (!a.xef.m(ewVar)) {
                x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
                bX(com.tencent.mm.pluginsdk.e.a.a.By(8));
            }
        } catch (Exception e) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", e);
            bX(com.tencent.mm.pluginsdk.e.a.a.By(12));
        }
        return null;
    }
}
