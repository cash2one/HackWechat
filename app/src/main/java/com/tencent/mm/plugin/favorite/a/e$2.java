package com.tencent.mm.plugin.favorite.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.s.a;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.mm.z.u;

class e$2 implements a {
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ f mpD;
    final /* synthetic */ Context val$context;

    public e$2(f fVar, Context context, Runnable runnable) {
        this.mpD = fVar;
        this.val$context = context;
        this.fgd = runnable;
    }

    public final void a(SparseArray<String> sparseArray) {
        String str = (String) sparseArray.get(this.mpD.field_id);
        x.d("MicroMsg.FavSendLogic", "on finish, favid %d, url %s", new Object[]{Integer.valueOf(this.mpD.field_id), str});
        if (!bh.ov(str)) {
            if (4 == this.mpD.field_type) {
                uq p = j.p(this.mpD);
                String az = bh.az(p.title, this.val$context.getString(R.l.egS));
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_link", str);
                intent.putExtra("Ksnsupload_title", az);
                intent.putExtra("Ksnsupload_imgbuf", e.e(j.i(p), 0, -1));
                d.ifs.m(intent, this.val$context);
                str = "fav_" + q.FS() + "_" + this.mpD.field_id;
                String hz = u.hz(str);
                u.GK().t(hz, true).o("prePublishId", str);
                intent.putExtra("reportSessionId", hz);
                g.pQN.h(10651, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0)});
            } else {
                x.w("MicroMsg.FavSendLogic", "unknown type %d, fav id %d", new Object[]{Integer.valueOf(this.mpD.field_type), Integer.valueOf(this.mpD.field_id)});
            }
        }
        if (this.fgd != null) {
            ag.y(this.fgd);
        }
    }
}
