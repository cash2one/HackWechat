package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.aq.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashSet;

public final class k implements a {
    private static k yGE;
    HashSet<Long> yGF = new HashSet();
    a yGG;

    private k() {
    }

    public static k cvm() {
        if (yGE == null) {
            yGE = new k();
        }
        return yGE;
    }

    public final boolean go(long j) {
        return this.yGF.contains(Long.valueOf(j));
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.ae.k kVar) {
        if (this.yGG != null) {
            this.yGG.a(j, j2, i, i2, obj, i3, i4, kVar);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.ae.k kVar) {
        if (this.yGG != null) {
            this.yGG.a(j, j2, i, i2, obj, i3, i4, str, kVar);
        } else {
            ar.Hg();
            x.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[]{Long.valueOf(c.Fa().dH(j2).field_msgId)});
            b.b(ac.getContext(), r2, false);
        }
        this.yGF.remove(Long.valueOf(j2));
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        if (this.yGG != null) {
            this.yGG.a(j, j2, i, i2, obj);
        }
        this.yGF.remove(Long.valueOf(j2));
    }
}
