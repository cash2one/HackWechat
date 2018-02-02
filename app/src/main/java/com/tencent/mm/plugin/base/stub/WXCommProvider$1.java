package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$1 extends BroadcastReceiver {
    final /* synthetic */ WXCommProvider kvd;

    WXCommProvider$1(WXCommProvider wXCommProvider) {
        this.kvd = wXCommProvider;
    }

    public void onReceive(Context context, Intent intent) {
        ap apVar;
        if (System.currentTimeMillis() - ap.vfF >= 600000) {
            x.e("MicroMsg.AppUtil", "hy: get comm model time expired");
            apVar = null;
        } else {
            apVar = ap.vfE;
        }
        if (apVar != null) {
            x.i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
            Cursor a = this.kvd.a(apVar.uri, apVar.projection, apVar.selection, apVar.selectionArgs, apVar.vfC, apVar.code, apVar.vfD);
            if (a != null) {
                a.close();
            }
            p.bYM();
        }
    }
}
