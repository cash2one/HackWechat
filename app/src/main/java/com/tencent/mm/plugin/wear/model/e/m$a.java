package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.e.b.g.a;
import com.tencent.mm.e.c.c;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.bzg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class m$a extends d {
    private bzg tiR;

    public m$a(bzg com_tencent_mm_protocal_c_bzg) {
        this.tiR = com_tencent_mm_protocal_c_bzg;
    }

    protected final void execute() {
        String nV = q.nV(this.tiR.wYG);
        x.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[]{nV});
        x.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[]{q.M(nV, false)});
        InputStream byteArrayInputStream = new ByteArrayInputStream(this.tiR.vIA.toByteArray());
        c cVar = new c(8000, 16000);
        cVar.cL(r0);
        byte[] bArr = new byte[320];
        int i = 0;
        while (true) {
            try {
                i = byteArrayInputStream.read(bArr, 0, 320);
            } catch (IOException e) {
            }
            if (i > 0) {
                cVar.a(new a(bArr, i), 0, false);
            } else {
                cVar.vE();
                x.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
                q.aa(nV, (int) this.tiR.wZb);
                m.UF().run();
                x.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
                ar.Hg();
                com.tencent.mm.z.c.Fd().Xa(this.tiR.wYG);
                return;
            }
        }
    }

    public final String getName() {
        return "SendVioceMsgTask";
    }
}
