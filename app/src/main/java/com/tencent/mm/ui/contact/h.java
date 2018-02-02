package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;
import java.util.List;

public final class h extends o {
    private Cursor iiG = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().cK(this.ySm);
    private List<String> ySm;

    public h(MMBaseSelectContactUI mMBaseSelectContactUI, boolean z, List<String> list) {
        super(mMBaseSelectContactUI, new ArrayList(), true, z);
        this.ySm = list;
        g.Dk();
    }

    public final int getCount() {
        return this.iiG.getCount();
    }

    protected final a jb(int i) {
        if (i < 0 || !this.iiG.moveToPosition(i)) {
            x.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        a dVar = new d(i);
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        xVar.b(this.iiG);
        dVar.jLe = xVar;
        dVar.ySW = btz();
        return dVar;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.CustomContactAdapter", "finish!");
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
    }
}
