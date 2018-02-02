package com.tencent.mm.plugin.backup.b;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.lan_cs.Client.a;
import java.io.IOException;

class a$2 implements a {
    final /* synthetic */ a kja;

    a$2(a aVar) {
        this.kja = aVar;
    }

    public final void onRecv(String str, int i, byte[] bArr) {
        a.a(this.kja, str);
        a.a(this.kja, i);
        try {
            a.a(this.kja, bArr);
        } catch (IOException e) {
            a.a(this.kja, 10006, ("client readErr:" + e.toString()).getBytes());
        }
    }

    public final void En() {
        a.a(this.kja, CdnLogic.kMediaTypeBeatificFile, "client onDisconnect".getBytes());
    }
}
