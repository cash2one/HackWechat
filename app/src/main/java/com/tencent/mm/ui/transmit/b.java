package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.z.q;

public final class b extends m {
    String fDj;
    private af handler = new af(Looper.getMainLooper());
    h mLO;
    private a mMa;
    private MMCreateChatroomUI znY;
    private k znZ = new 1(this);

    public b(MMCreateChatroomUI mMCreateChatroomUI, int i) {
        super(mMCreateChatroomUI, false, i);
        this.znY = mMCreateChatroomUI;
    }

    public final void a(String str, int[] iArr, boolean z) {
        this.fDj = str;
        g gVar = new g();
        gVar.handler = this.handler;
        gVar.mLZ = this.znZ;
        gVar.fDj = str;
        gVar.mLY = com.tencent.mm.plugin.fts.a.c.b.mMz;
        gVar.mLU = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        gVar.mLX.add("filehelper");
        gVar.mLX.add(q.FS());
        gVar.mLX.addAll(this.znY.zoc.cyh());
        this.mMa = ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).search(2, gVar);
    }

    public final void aaS() {
        if (this.mMa != null) {
            ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).cancelSearchTask(this.mMa);
        }
        this.fDj = null;
    }

    protected final com.tencent.mm.ui.contact.a.a jb(int i) {
        com.tencent.mm.ui.contact.a.a hVar;
        j jVar = (j) this.mLO.mMc.get(i);
        if (jVar.mLs.equals("no_result​")) {
            hVar = new com.tencent.mm.ui.contact.a.h(i);
        } else {
            com.tencent.mm.ui.contact.a.a dVar = new d(i);
            dVar.iVU = jVar;
            dVar.mMb = this.mLO.mMb;
            dVar.ySW = btz();
            dVar.rVq = true;
            dVar.mPy = i + 1;
            dVar.cC(dVar.iVU.type, dVar.iVU.mLr);
            hVar = dVar;
        }
        hVar.fDj = this.fDj;
        hVar.scene = this.scene;
        hVar.ySW = false;
        return hVar;
    }

    public final int getCount() {
        if (this.mLO == null || this.mLO.mMc == null) {
            return 0;
        }
        return this.mLO.mMc.size();
    }
}
