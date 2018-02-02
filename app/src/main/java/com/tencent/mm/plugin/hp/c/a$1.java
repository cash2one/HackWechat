package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ nn nBb;
    final /* synthetic */ a nBc;

    a$1(a aVar, nn nnVar) {
        this.nBc = aVar;
        this.nBb = nnVar;
    }

    public final void a(boolean z, b bVar) {
        if (!z || bVar == null) {
            Context context = ac.getContext();
            context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", this.nBc.nAW).apply();
            g.ai(ac.getContext(), "");
            return;
        }
        this.nBc.nBa = bVar;
        this.nBb.vWt = this.nBc.nBa.nBq;
        x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[]{this.nBc.nBa.nBq, this.nBc.nAX});
        com.tencent.mm.plugin.report.service.g.pQN.a(614, 71, 1, false);
    }
}
