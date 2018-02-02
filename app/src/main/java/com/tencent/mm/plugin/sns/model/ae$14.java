package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.ci;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ae$14 extends c<ci> {
    final /* synthetic */ ae qWL;

    ae$14(ae aeVar) {
        this.qWL = aeVar;
        this.xen = ci.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        g.Dk();
        String str = g.Dj().cachePath;
        g.Dk();
        String str2 = g.Dj().gQh;
        x.i("MicroMsg.SnsCore", "dump %s", new Object[]{str2});
        str = str + "SnsMicroMsg.db";
        FileOp.deleteFile(str2 + "sns.dump");
        FileOp.x(str, str2 + "sns.dump");
        return false;
    }
}
