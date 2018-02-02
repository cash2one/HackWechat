package com.tencent.mm.plugin.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.chatroom.d.o;
import com.tencent.mm.plugin.chatroom.ui.a.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;

class a$2 implements e {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ boolean lcg = false;
    final /* synthetic */ a lch;
    final /* synthetic */ Activity oZ;

    a$2(boolean z, ProgressDialog progressDialog, Activity activity, a aVar) {
        this.lao = progressDialog;
        this.oZ = activity;
        this.lch = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(482, this);
        if (!this.lcg) {
            this.lao.cancel();
        }
        boolean z = false;
        this.oZ.getString(R.l.eGw);
        o oVar = (o) kVar;
        if (i == 0 && i2 == 0) {
            ar.Hg();
            q hD = c.Fh().hD(oVar.chatroomName);
            if (hD == null) {
                hD = new q();
            }
            hD.fC(com.tencent.mm.z.q.FS(), oVar.kZy);
            m.a(hD);
            z = true;
        }
        if (this.lch != null) {
            this.lch.i(z, oVar.kZz);
        }
    }
}
