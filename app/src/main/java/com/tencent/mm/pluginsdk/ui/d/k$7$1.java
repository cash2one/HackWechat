package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.k.7;
import com.tencent.mm.ui.base.h.c;

class k$7$1 implements c {
    final /* synthetic */ String kVP;
    final /* synthetic */ 7 vuO;

    k$7$1(7 7, String str) {
        this.vuO = 7;
        this.kVP = str;
    }

    public final void jl(int i) {
        if (this.vuO.vuJ != null) {
            this.vuO.vuJ.onDismiss(null);
        }
        switch (i) {
            case 0:
                if (k.ccq()) {
                    Context context = this.vuO.val$context;
                    String str = this.kVP;
                    Intent intent = new Intent("android.intent.action.INSERT");
                    intent.setType("vnd.android.cursor.dir/contact");
                    intent.putExtra("phone", str);
                    context.startActivity(intent);
                    g.pQN.k(10113, "1");
                    return;
                }
                k.be(this.vuO.val$context, this.kVP);
                g.pQN.k(10114, "1");
                return;
            case 1:
                k.be(this.vuO.val$context, this.kVP);
                g.pQN.k(10114, "1");
                return;
            default:
                return;
        }
    }
}
