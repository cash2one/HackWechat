package com.tencent.mm.be;

import com.tencent.mm.a.f;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements e {
    public static int chatType = 0;
    private static d hPd;
    private static final f<Integer, a> hdO = new f(5);
    private int hJm = 3;
    public boolean hjs = false;

    public static String getPrefix() {
        switch (chatType) {
            case 0:
                return "single_";
            case 1:
                return "chatroom_";
            case 2:
                return "app_";
            default:
                return "single_";
        }
    }

    public static int mI(String str) {
        int i = 5;
        if (!(str == null || str.length() == 0)) {
            if (str.startsWith("single")) {
            }
            if (str.startsWith("chatroom")) {
                i = 7;
            }
            if (str.startsWith("app")) {
                i = 8;
            }
            x.d("upload", "type " + i);
        }
        return i;
    }

    public static d SD() {
        if (hPd == null) {
            hPd = new d();
        }
        return hPd;
    }

    public final void release() {
        this.hjs = false;
        g.CG().b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof m) || ((m) kVar).Kl() != 9) {
            x.d("upload", "another scene");
        } else if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            if (i == 0 && i2 == 0) {
                g.Dk();
                g.Dj().CU().set(81944, Long.valueOf(bh.Wo()));
            } else {
                int i3 = this.hJm - 1;
                this.hJm = i3;
                if (i3 < 0) {
                    g.Dk();
                    g.Dj().CU().set(81944, Long.valueOf(((bh.Wp() - 86400000) + 3600000) / 1000));
                    this.hJm = 3;
                }
            }
            release();
        }
    }

    public static void SE() {
        g.Dk();
        g.Dj().CU().set(16646145, Integer.valueOf(0));
    }

    public static void SF() {
        g.Dk();
        Integer valueOf = Integer.valueOf(bh.e((Integer) g.Dj().CU().get(16646145, null)));
        if (valueOf.intValue() < 0) {
            valueOf = Integer.valueOf(0);
        }
        g.Dk();
        g.Dj().CU().set(16646145, Integer.valueOf(valueOf.intValue() + 1));
    }
}
