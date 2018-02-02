package com.tencent.mm.plugin.record;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.b.g;

public class PluginRecord extends f implements b, c, a {
    private e pEU;
    private d pEV;

    public void parallelsDependency() {
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        this.pEU = new g(com.tencent.mm.kernel.g.Dj().gQj);
        this.pEV = new com.tencent.mm.plugin.record.b.e(com.tencent.mm.kernel.g.Dj().gQj);
    }

    public void onAccountRelease() {
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public d getRecordMsgCDNStorage() {
        return this.pEV;
    }

    public e getRecordMsgInfoStorage() {
        return this.pEU;
    }
}
