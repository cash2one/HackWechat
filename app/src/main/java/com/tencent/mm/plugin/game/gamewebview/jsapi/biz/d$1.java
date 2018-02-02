package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ String fgU;
    final /* synthetic */ com.tencent.mm.plugin.game.gamewebview.jsapi.a.a mWw;
    final /* synthetic */ d mWx;
    final /* synthetic */ Context val$context;

    d$1(d dVar, com.tencent.mm.plugin.game.gamewebview.jsapi.a.a aVar, Context context, String str) {
        this.mWx = dVar;
        this.mWw = aVar;
        this.val$context = context;
        this.fgU = str;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.GameJsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            amj com_tencent_mm_protocal_c_amj = (amj) bVar.hmh.hmo;
            com.tencent.mm.plugin.game.gamewebview.jsapi.a.a aVar;
            d dVar;
            if (com_tencent_mm_protocal_c_amj == null || com_tencent_mm_protocal_c_amj.wte == null) {
                aVar = this.mWw;
                dVar = this.mWx;
                aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorize:fail", null));
                return;
            }
            int i3 = com_tencent_mm_protocal_c_amj.wte.fts;
            String str2 = com_tencent_mm_protocal_c_amj.wte.ftt;
            x.i("MicroMsg.GameJsApiAuthorize", "jsErrcode = %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                ag.y(new 1(this, com_tencent_mm_protocal_c_amj.whQ, com_tencent_mm_protocal_c_amj.niZ, com_tencent_mm_protocal_c_amj.vFW));
                return;
            } else if (i3 == 0) {
                aVar = this.mWw;
                dVar = this.mWx;
                aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorize:ok", null));
                return;
            } else {
                x.e("MicroMsg.GameJsApiAuthorize", "ERROR = %s", new Object[]{str2});
                aVar = this.mWw;
                dVar = this.mWx;
                aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorize:fail", null));
                return;
            }
        }
        this.mWw.sj(d.BA("authorize:fail"));
    }
}
