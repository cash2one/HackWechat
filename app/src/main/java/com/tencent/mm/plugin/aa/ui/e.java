package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.q;
import java.util.List;

public final class e extends q {
    private String chatroomName;
    private String fDj;
    private String[] iiF;
    private Cursor iiG;

    public e(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        this.chatroomName = str;
        List hH = ((b) g.h(b.class)).Fh().hH(this.chatroomName);
        if (hH != null) {
            this.iiF = bh.cz(hH);
        }
    }

    public final void a(String str, int[] iArr, boolean z) {
        x.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[]{str});
        clearCache();
        this.fDj = str;
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
        if (!(bh.ov(this.fDj) || this.iiF == null)) {
            g.Dk();
            this.iiG = ((h) g.h(h.class)).EY().a(this.iiF, "@all.chatroom", this.fDj, null, null);
        }
        notifyDataSetChanged();
        bo(str, true);
    }

    protected final a jb(int i) {
        if (!this.iiG.moveToPosition(i)) {
            return null;
        }
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        xVar.b(this.iiG);
        a dVar = new d(i);
        dVar.jLe = xVar;
        dVar.ySW = true;
        return dVar;
    }

    public final void finish() {
        super.finish();
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
    }

    public final int getCount() {
        if (this.iiG == null) {
            return 0;
        }
        return this.iiG.getCount();
    }
}
