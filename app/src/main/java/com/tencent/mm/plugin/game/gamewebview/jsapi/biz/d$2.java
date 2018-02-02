package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a.a;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements b$a {
    final /* synthetic */ int iTc;
    final /* synthetic */ a mWw;
    final /* synthetic */ d mWx;

    d$2(d dVar, a aVar, int i) {
        this.mWx = dVar;
        this.mWw = aVar;
        this.iTc = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.GameJsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        a aVar;
        d dVar;
        if (i != 0 || i2 != 0) {
            aVar = this.mWw;
            dVar = this.mWx;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorizefail", null));
        } else if (this.iTc == 2) {
            x.d("MicroMsg.GameJsApiAuthorize", "press reject button");
            aVar = this.mWw;
            dVar = this.mWx;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorizefail", null));
        } else {
            amh com_tencent_mm_protocal_c_amh = (amh) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_amh == null || com_tencent_mm_protocal_c_amh.wte == null) {
                aVar = this.mWw;
                dVar = this.mWx;
                aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorizefail", null));
                return;
            }
            int i3 = com_tencent_mm_protocal_c_amh.wte.fts;
            String str2 = com_tencent_mm_protocal_c_amh.wte.ftt;
            x.i("MicroMsg.GameJsApiAuthorize", "jsErrcode = %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                aVar = this.mWw;
                dVar = this.mWx;
                aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorizeok", null));
                return;
            }
            x.e("MicroMsg.GameJsApiAuthorize", "ERROR = %s", new Object[]{str2});
            aVar = this.mWw;
            dVar = this.mWx;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("authorizefail", null));
        }
    }
}
