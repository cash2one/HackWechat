package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.e;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class ak$a implements a {
    private String appId;
    private int jcN;
    private d mWb;

    ak$a(d dVar, int i, String str) {
        this.mWb = dVar;
        this.jcN = i;
        this.appId = str;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (this.mWb != null) {
            if (i == 0 && i2 == 0) {
                amb com_tencent_mm_protocal_c_amb = (amb) bVar.hmh.hmo;
                if (com_tencent_mm_protocal_c_amb == null || com_tencent_mm_protocal_c_amb.wsK == null || com_tencent_mm_protocal_c_amb.wsK.fts != 0) {
                    sj(com.tencent.mm.plugin.game.gamewebview.a.d.BA("pre_verify_jsapi:fail_" + str));
                    return;
                }
                d dVar = this.mWb;
                String str2 = this.appId;
                if (!(bh.ov(str2) || bh.ov(dVar.aPk()))) {
                    dVar.mZx.put(d.BQ(dVar.aPk()), str2);
                }
                c.d dVar2 = new c.d();
                dVar2.appId = this.appId;
                dVar2.tGI = com_tencent_mm_protocal_c_amb.wsY;
                d dVar3 = this.mWb;
                if (!bh.ov(dVar3.aPk())) {
                    dVar3.mZy.put(dVar3.aPk(), dVar2);
                }
                Object obj = com_tencent_mm_protocal_c_amb.wsX;
                d dVar4 = this.mWb;
                JsapiPermissionWrapper Pj = dVar4.mYW != null ? dVar4.mYW.Pj(dVar4.aPk()) : null;
                if (Pj == null) {
                    sj(com.tencent.mm.plugin.game.gamewebview.a.d.BA("pre_verify_jsapi:ok"));
                    return;
                }
                if (!bh.cA(obj)) {
                    Iterator it = obj.iterator();
                    while (it.hasNext()) {
                        bsb com_tencent_mm_protocal_c_bsb = (bsb) it.next();
                        com.tencent.mm.plugin.game.gamewebview.jsapi.c cVar = (com.tencent.mm.plugin.game.gamewebview.jsapi.c) e.aOM().get(com_tencent_mm_protocal_c_bsb.wsE);
                        if (!(cVar == null || Pj.CF(cVar.aOI()) == com_tencent_mm_protocal_c_bsb.state)) {
                            Pj.a(cVar.aOI(), (byte) com_tencent_mm_protocal_c_bsb.state);
                        }
                    }
                }
                sj(com.tencent.mm.plugin.game.gamewebview.a.d.BA("pre_verify_jsapi:ok"));
                return;
            }
            x.e("MicroMsg.GameJsApiPreVerify", "errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            sj(com.tencent.mm.plugin.game.gamewebview.a.d.BA("pre_verify_jsapi:fail_" + str));
        }
    }

    private void sj(String str) {
        this.mWb.E(this.jcN, str);
        this.mWb = null;
        this.appId = null;
    }
}
