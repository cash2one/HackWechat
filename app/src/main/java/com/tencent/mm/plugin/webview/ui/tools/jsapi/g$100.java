package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class g$100 implements Runnable {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ String tJp;
    final /* synthetic */ String tJq;

    g$100(g gVar, String str, i iVar, String str2) {
        this.tIj = gVar;
        this.tJp = str;
        this.tIg = iVar;
        this.tJq = str2;
    }

    public final void run() {
        x.i("MicroMsg.MsgHandler", "doShareEmoticon use base64DataString");
        int indexOf = this.tJp.indexOf(";base64,");
        String str = "";
        if (indexOf != -1) {
            str = this.tJp.substring(indexOf + 8, this.tJp.length());
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (bh.bw(decode)) {
                g.a(this.tIj, this.tIg, "shareEmoticon:fail", null);
                return;
            }
            String s = g.s(decode);
            if (bh.ov(s)) {
                g.a(this.tIj, this.tIg, "shareEmoticon:fail empty buffer", null);
                return;
            }
            ar.Hg();
            String H = EmojiLogic.H(c.Fp(), "", s);
            if (!(e.bO(H) && g.bV(H).equalsIgnoreCase(s))) {
                e.b(H, decode, decode.length);
            }
            g.a(this.tIj, s, this.tJq);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doShareEmoticon error:" + e.getMessage());
            g.a(this.tIj, this.tIg, "shareEmoticon:fail_" + e.getMessage(), null);
        }
    }
}
