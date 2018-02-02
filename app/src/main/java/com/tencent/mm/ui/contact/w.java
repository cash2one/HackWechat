package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;

public final class w extends o {
    private Cursor iiG = ((h) g.h(h.class)).EY().c(this.yPI, "", this.kiU);
    private String yPI;

    public w(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, new ArrayList(), false, false);
        this.yPI = str;
        g.Dk();
    }

    public final int getCount() {
        return this.iiG.getCount();
    }

    protected final a jb(int i) {
        if (i < 0 || !this.iiG.moveToPosition(i)) {
            x.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
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
        x.i("MicroMsg.SpecialContactAdapter", "finish!");
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
    }
}
