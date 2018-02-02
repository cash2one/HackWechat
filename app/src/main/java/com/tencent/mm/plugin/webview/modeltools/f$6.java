package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class f$6 extends c<ck> {
    final /* synthetic */ f tuZ;

    f$6(f fVar) {
        this.tuZ = fVar;
        this.xen = ck.class.getName().hashCode();
    }

    private static boolean a(ck ckVar) {
        if (ckVar instanceof ck) {
            Editor edit = ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
            String value = g.zY().getValue("WebviewDownloadTbs");
            String value2 = g.zY().getValue("WebviewEnableTbs");
            String value3 = g.zY().getValue("WebviewSupportedTbsVersionSection");
            x.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", new Object[]{value, value2, value3});
            if (value != null) {
                edit.putString("tbs_download", value);
            }
            edit.apply();
            if ("1".equals(value) && "1".equals(value2)) {
                j.pY(1);
            }
            if (value != null) {
                try {
                    if ("0".equals(value)) {
                        x.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(ac.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                        ac.getContext().sendBroadcast(intent);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", new Object[]{e.getMessage()});
                }
            }
        }
        return false;
    }
}
