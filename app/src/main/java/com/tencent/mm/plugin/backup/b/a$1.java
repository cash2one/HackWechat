package com.tencent.mm.plugin.backup.b;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.lan_cs.Server.a;
import com.tencent.mm.plugin.backup.f.b;
import java.io.IOException;

class a$1 implements a {
    final /* synthetic */ a kja;

    public a$1(a aVar) {
        this.kja = aVar;
    }

    public final void gH(int i) {
        if (a.a(this.kja) == 1) {
            b.mN(i);
        }
    }

    public final void onRecv(String str, int i, byte[] bArr) {
        a.a(this.kja, str);
        a.a(this.kja, i);
        try {
            a.a(this.kja, bArr);
        } catch (IOException e) {
            a.a(this.kja, 10006, ("server readErr:" + e.toString()).getBytes());
        }
    }

    public final void En() {
        a.a(this.kja, CdnLogic.kMediaTypeBeatificFile, "listen server onDisconnect".getBytes());
    }

    public final void onConnect(String str, int i) {
        a.a(this.kja, str);
        a.a(this.kja, i);
    }
}
