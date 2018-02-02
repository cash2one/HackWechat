package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class g$98 implements Runnable {
    final /* synthetic */ String hAS;
    final /* synthetic */ g tIj;
    final /* synthetic */ String tJq;
    final /* synthetic */ File tJr;

    g$98(g gVar, File file, String str, String str2) {
        this.tIj = gVar;
        this.tJr = file;
        this.hAS = str;
        this.tJq = str2;
    }

    public final void run() {
        String i = g.i(this.tJr);
        ar.Hg();
        String H = EmojiLogic.H(c.Fp(), "", i);
        if (!FileOp.bO(H)) {
            FileOp.x(this.tJr.getAbsolutePath(), H);
        }
        g.a(this.tIj, i, this.hAS, this.tJq);
    }
}
