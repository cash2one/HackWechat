package com.tencent.mm.ui.conversation;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class g$e {
    private boolean initialized;
    private x jLe;
    private String talker;
    private Integer yXm;
    final /* synthetic */ g yYI;

    public g$e(g gVar) {
        this.yYI = gVar;
        this.initialized = false;
        this.talker = null;
        this.initialized = false;
        this.jLe = null;
        this.yXm = null;
    }

    public final void dS(String str) {
        this.talker = str;
        this.jLe = null;
        this.yXm = null;
        this.initialized = false;
        if (!t.ov(str)) {
            this.initialized = true;
        }
    }

    public final x cwD() {
        if (this.initialized && this.jLe == null && ar.Hj()) {
            ar.Hg();
            this.jLe = c.EY().WO(this.talker);
        }
        return this.jLe;
    }
}
