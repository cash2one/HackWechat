package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Map;

public final class j implements t {
    public static boolean vdo = false;
    private static j vdp;
    public a vdq;

    public interface a {
        void a(m mVar);
    }

    public static class b {
        public String vdr;
    }

    private j() {
    }

    public static j bYn() {
        if (vdp == null) {
            vdp = new j();
        }
        return vdp;
    }

    public final void bYo() {
        if (ar.Hj()) {
            an.aRi().a(14, this);
            vdo = true;
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (ar.Hj()) {
            x.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (wVar == null) {
                x.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (wVar.getType()) {
                    case 14:
                        if (ac.getContext() == null || com.tencent.mm.plugin.y.a.a.a.bis() == null) {
                            x.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
                            return;
                        }
                        x.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        m mVar = (m) wVar;
                        if (this.vdq != null) {
                            this.vdq.a(mVar);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static b Ru(String str) {
        if (str == null) {
            return null;
        }
        Map y = bi.y(str, "PersonalAppSetting");
        if (y == null) {
            return null;
        }
        String str2 = (String) y.get(".PersonalAppSetting.OpenID");
        if (bh.ov(str2)) {
            return null;
        }
        b bVar = new b();
        bVar.vdr = str2;
        return bVar;
    }
}
