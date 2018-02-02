package com.tencent.mm.modelfriend;

import android.content.Intent;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class af$3 extends c<ox> {
    final /* synthetic */ af hxt;

    af$3(af afVar) {
        this.hxt = afVar;
        this.xen = ox.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ox oxVar = (ox) bVar;
        Intent intent = oxVar.fGO.intent;
        String str = oxVar.fGO.username;
        if (intent == null || str == null || str.length() == 0) {
            x.e("MicroMsg.AccountSyncUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
        } else {
            ad lc = af.OI().lc(str);
            if (lc != null) {
                intent.putExtra("Contact_Uin", lc.hwR);
                intent.putExtra("Contact_QQNick", lc.getDisplayName());
            }
            b kR = af.OD().kR(str);
            if (kR != null) {
                intent.putExtra("Contact_Mobile_MD5", kR.Nr());
            }
        }
        return false;
    }
}
