package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.z.s;
import java.util.List;

public final class t extends o implements b {
    private Cursor iiG;
    private int pOu;
    private List<String> yTX;
    private int yTY;
    private boolean yTZ;
    private int yUa;

    public t(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list) {
        this(mMBaseSelectContactUI, list, true, false, false, 0);
    }

    public t(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, boolean z3, int i) {
        super(mMBaseSelectContactUI, list, z, z2);
        this.yUa = 0;
        x.i("MicroMsg.RecentConversationAdapter", "create!");
        this.yTZ = z3;
        this.yUa = i;
        aJh();
        ((h) g.h(h.class)).Fd().a(this);
    }

    private void aJh() {
        int i;
        int i2 = 0;
        x.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
        if (s.fa(this.yUa, 4)) {
            this.iiG = ((h) g.h(h.class)).Fd().b(s.hfo, this.kiU, this.yTm, "");
        } else if (s.fa(this.yUa, 16)) {
            this.iiG = ((h) g.h(h.class)).Fd().b(s.hfq, this.kiU, this.yTm, "");
        } else {
            this.iiG = ((h) g.h(h.class)).Fd().b(s.hfk, this.kiU, this.yTm, "");
        }
        if (this.yTZ) {
            i = 2;
        } else {
            i = 0;
        }
        if (this.yTX != null) {
            i2 = this.yTX.size();
        }
        this.yTY = i2;
        this.pOu = i + this.yTY;
        clearCache();
    }

    public final int getCount() {
        return (this.iiG.getCount() + this.pOu) + 1;
    }

    protected final a jb(int i) {
        a gVar;
        a gVar2;
        if (this.pOu > this.yTY) {
            if (i == this.yTY) {
                gVar = new com.tencent.mm.ui.contact.a.g(i);
                gVar.mPH = this.ySV.getActivity().getResources().getString(com.tencent.mm.plugin.selectcontact.a.h.qfP);
            } else if (i == this.yTY + 1) {
                gVar = new com.tencent.mm.ui.contact.a.b(i);
                String string = this.ySV.getActivity().getResources().getString(com.tencent.mm.plugin.selectcontact.a.h.qfP);
                gVar.mPo = com.tencent.mm.plugin.selectcontact.a.g.lok;
                gVar.bgo = string;
            }
            if (i == this.pOu) {
                gVar2 = new com.tencent.mm.ui.contact.a.g(i);
                gVar2.mPH = this.ySV.getActivity().getResources().getString(com.tencent.mm.plugin.selectcontact.a.h.qfK);
                return gVar2;
            } else if (i < this.yTY) {
                if (this.yTX != null || i < 0 || i >= this.yTX.size()) {
                    return null;
                }
                gVar2 = new com.tencent.mm.ui.contact.a.b(i);
                gVar2.username = (String) this.yTX.get(i);
                return gVar2;
            } else if (i > this.pOu || !this.iiG.moveToPosition((i - this.pOu) - 1)) {
                x.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
                return gVar;
            } else {
                gVar2 = new e(i);
                aj aeVar = new ae();
                aeVar.b(this.iiG);
                g.Dk();
                gVar2.jLe = ((h) g.h(h.class)).EY().WJ(aeVar.field_username);
                if (gVar2.jLe == null) {
                    g.Dk();
                    gVar2.jLe = ((h) g.h(h.class)).EY().WN(aeVar.field_username);
                }
                gVar2.ySW = btz();
                return gVar2;
            }
        }
        gVar = null;
        if (i == this.pOu) {
            gVar2 = new com.tencent.mm.ui.contact.a.g(i);
            gVar2.mPH = this.ySV.getActivity().getResources().getString(com.tencent.mm.plugin.selectcontact.a.h.qfK);
            return gVar2;
        } else if (i < this.yTY) {
            return this.yTX != null ? null : null;
        } else {
            if (i > this.pOu) {
            }
            x.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return gVar;
        }
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
        ((h) g.h(h.class)).Fd().b(this);
    }

    public final void a(int i, m mVar, Object obj) {
        aJh();
        notifyDataSetChanged();
    }
}
