package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.z.q;

class d$2 implements OnClickListener {
    final /* synthetic */ d kuO;

    d$2(d dVar) {
        this.kuO = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j jVar = a.vcu;
        if (jVar != null) {
            jVar.M(this.kuO.openId, q.FV(), this.kuO.appId);
        }
        this.kuO.kuN.dP(false);
    }
}
