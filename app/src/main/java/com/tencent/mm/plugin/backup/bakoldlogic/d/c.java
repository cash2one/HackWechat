package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.aq.g;
import com.tencent.mm.by.h;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.t;
import com.tencent.mm.z.ae;
import com.tencent.mm.z.b;

public final class c {
    String gQi;
    public h gQj = null;
    t kpK;
    ar kpL;
    com.tencent.mm.plugin.messenger.foundation.a.a.c kpM;
    as kpN;
    g kpO;
    d kpP;
    public f kpQ;
    s kpR;
    ae kpS;
    public k kpT;
    public i kpU;
    com.tencent.mm.pluginsdk.model.app.c kpV;
    be ksw;
    com.tencent.mm.by.g ksx = null;
    Boolean ksy = null;
    public int uin = 0;

    public final t CU() {
        if (this.uin != 0) {
            return this.kpK;
        }
        throw new b();
    }

    public final ar EY() {
        if (this.uin != 0) {
            return this.kpL;
        }
        throw new b();
    }

    public final com.tencent.mm.plugin.messenger.foundation.a.a.c Fa() {
        if (this.uin != 0) {
            return this.kpM;
        }
        throw new b();
    }

    public final as Fd() {
        if (this.uin != 0) {
            return this.kpN;
        }
        throw new b();
    }

    public final g aqb() {
        if (this.uin != 0) {
            return this.kpO;
        }
        throw new b();
    }

    public final d aqc() {
        if (this.uin != 0) {
            return this.kpP;
        }
        throw new b();
    }

    public final s TU() {
        if (this.uin != 0) {
            return this.kpR;
        }
        throw new b();
    }

    public final String Fp() {
        if (this.uin != 0) {
            return this.gQi + "emoji/";
        }
        throw new b();
    }

    public final com.tencent.mm.pluginsdk.model.app.c aqd() {
        if (this.uin != 0) {
            return this.kpV;
        }
        throw new b();
    }

    public final void aqQ() {
        x.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[]{this.ksy, this.gQj, this.ksx, bh.cgy()});
        if (this.ksy == null || this.ksy.booleanValue()) {
            if (this.gQj != null) {
                x.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[]{this.gQj});
                this.gQj.ES();
                this.gQj = null;
            }
            if (this.ksx != null) {
                com.tencent.mm.by.g gVar = this.ksx;
                com.tencent.mm.by.g.xBj = bh.cgy().toString();
                if (gVar.xAK != null) {
                    gVar.xAK.close();
                    gVar.xAK = null;
                }
                this.ksx = null;
            }
            this.ksy = null;
            return;
        }
        this.ksy = null;
    }
}
