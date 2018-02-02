package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;

public final class b extends q {
    private String chatroomName;
    private String fDj;
    private String[] iiF;
    private Cursor iiG;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        this.chatroomName = str;
        ar.Hg();
        List hH = c.Fh().hH(this.chatroomName);
        if (hH != null) {
            this.iiF = bh.cz(hH);
        }
    }

    public final void a(String str, int[] iArr, boolean z) {
        x.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[]{str});
        clearCache();
        this.fDj = str;
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
        if (!(bh.ov(this.fDj) || this.iiF == null)) {
            ar.Hg();
            this.iiG = c.EY().a(this.iiF, "@all.chatroom", this.fDj, null, null);
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
        a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.jLe = xVar;
        aVar.ySW = btz();
        aVar.fDj = this.fDj;
        return aVar;
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
