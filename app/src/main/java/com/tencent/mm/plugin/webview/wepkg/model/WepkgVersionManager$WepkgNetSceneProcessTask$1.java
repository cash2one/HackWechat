package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager.WepkgNetSceneProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.WepkgRunCgi.a;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.sdk.platformtools.x;

class WepkgVersionManager$WepkgNetSceneProcessTask$1 implements a {
    final /* synthetic */ WepkgNetSceneProcessTask tNQ;

    WepkgVersionManager$WepkgNetSceneProcessTask$1(WepkgNetSceneProcessTask wepkgNetSceneProcessTask) {
        this.tNQ = wepkgNetSceneProcessTask;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            try {
                d.Dm().F(new 1(this, (ny) bVar.hmh.hmo));
                return;
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.WepkgVersionManager", "get checkwepkgversion error");
                return;
            }
        }
        x.e("MicroMsg.Wepkg.WepkgVersionManager", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo);
    }
}
