package com.tencent.mm.plugin.remittance.ui;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;

public final class c extends o implements b {
    private int fromScene;
    private Cursor iiG;
    int pOt;
    int pOu;
    private List<String> pOv;
    private int pOw = 0;

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, int i) {
        super(mMBaseSelectContactUI, list2, true, false);
        this.pOv = list;
        this.fromScene = i;
        x.i("MicroMsg.RecentConversationAdapter", "create!");
        aJh();
        ((h) g.h(h.class)).Fd().a(this);
    }

    private void aJh() {
        int i;
        Cursor cL;
        List list;
        x.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
        this.pOw = 0;
        List arrayList = new ArrayList();
        this.pOt = -1;
        this.pOu = -1;
        if (this.pOv == null || this.pOv.size() <= 0) {
            i = 0;
        } else {
            g.Dk();
            cL = ((h) g.h(h.class)).EY().cL(this.pOv);
            arrayList.add(cL);
            int count = cL.getCount();
            if (count > 0) {
                this.pOt = this.ySV.btG().getHeaderViewsCount();
                this.pOw++;
                i = count;
            } else {
                this.pOt = -1;
                i = count;
            }
        }
        List list2 = this.kiU;
        if (list2 != null) {
            list2.addAll(this.pOv);
            list = list2;
        } else {
            list = this.pOv;
        }
        if (this.fromScene == 1) {
            cL = ((h) g.h(h.class)).Fd().b(s.hfk, list, this.yTm, "");
        } else {
            cL = ((h) g.h(h.class)).Fd().b(s.hfo, list, this.yTm, "");
        }
        if (cL.getCount() > 0) {
            this.pOw++;
            if (i > 0) {
                this.pOu = (i + this.pOt) + 1;
            } else {
                this.pOu = this.ySV.btG().getHeaderViewsCount();
            }
        } else {
            this.pOu = -1;
        }
        arrayList.add(cL);
        this.iiG = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
    }

    protected final a jb(int i) {
        if (i == this.pOu || i == this.pOt) {
            a gVar = new com.tencent.mm.ui.contact.a.g(i);
            if (i == this.pOt) {
                if (this.fromScene == 1) {
                    gVar.mPH = this.ySV.getActivity().getResources().getString(i.uHg);
                    return gVar;
                }
                gVar.mPH = this.ySV.getActivity().getResources().getString(i.uNY);
                return gVar;
            } else if (i != this.pOu) {
                return gVar;
            } else {
                gVar.mPH = this.ySV.getActivity().getResources().getString(i.uWA);
                return gVar;
            }
        }
        int i2;
        if (this.pOw == 2) {
            if (i > this.pOu) {
                i2 = i - 2;
            } else {
                i2 = i - 1;
            }
        } else if (this.pOw == 1) {
            i2 = i - 1;
        } else {
            x.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[]{Integer.valueOf(i)});
            i2 = i;
        }
        if (!this.iiG.moveToPosition(i2)) {
            return null;
        }
        a eVar = new e(i);
        aj aeVar = new ae();
        aeVar.b(this.iiG);
        g.Dk();
        eVar.jLe = ((h) g.h(h.class)).EY().WJ(aeVar.field_username);
        if (eVar.jLe == null) {
            g.Dk();
            eVar.jLe = ((h) g.h(h.class)).EY().WN(aeVar.field_username);
        }
        return eVar;
    }

    public final int getCount() {
        return this.iiG.getCount() + this.pOw;
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
