package com.tencent.mm.plugin.wallet_index.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.wallet_index.b.a.a;

class a$1 extends BroadcastReceiver {
    final /* synthetic */ a taH;

    a$1(a aVar) {
        this.taH = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(action)) {
            a.a(this.taH, a.a(intent, a.a(this.taH)));
        } else if ("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(action)) {
            a.b(this.taH).a(intent, new 1(this, intent.getBooleanExtra("is_direct", true)));
        }
    }
}
