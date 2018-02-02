package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.api.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.m.a;
import java.util.List;

public final class p extends q {
    private String fDj;
    private af handler = new af(Looper.getMainLooper());
    private Cursor iiG;
    private String kGH;
    private a ySU;
    private List<String> yTn = null;

    public p(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, 0);
        this.kGH = str;
        x.i("MicroMsg.MMSearchContactAdapter", "Create!");
        WT();
    }

    public final void a(a aVar) {
        this.ySU = aVar;
    }

    public final void bo(String str, boolean z) {
        if (this.ySU != null) {
            this.ySU.r(str, getCount(), z);
        }
    }

    private void WT() {
        x.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.fDj = null;
        clearCache();
    }

    public final int getCount() {
        return this.iiG == null ? 0 : this.iiG.getCount();
    }

    protected final com.tencent.mm.ui.contact.a.a jb(int i) {
        if (i < 0 || !this.iiG.moveToPosition(i)) {
            x.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        com.tencent.mm.ui.contact.a.a aVar = new com.tencent.mm.ui.bizchat.a(i);
        c cVar = new c();
        cVar.b(this.iiG);
        if (aVar.kGB == -1) {
            aVar.kGB = cVar.field_bizChatLocalId;
            if (cVar.Mt()) {
                aVar.iil = cVar.field_chatName;
                aVar.yni = cVar.field_headImageUrl;
                aVar.username = cVar.field_brandUserName;
            } else {
                j ca = ((g) com.tencent.mm.kernel.g.h(g.class)).ca(cVar.field_bizChatServId);
                if (ca != null) {
                    aVar.iil = ca.field_userName;
                    aVar.yni = ca.field_headImageUrl;
                    aVar.username = ca.field_brandUserName;
                }
            }
            if (bh.M(aVar.iil)) {
                aVar.iil = this.ySV.getActivity().getResources().getString(h.qfQ);
            }
            if (bh.ov(aVar.username)) {
                aVar.username = cVar.field_brandUserName;
            }
        }
        return aVar;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.MMSearchContactAdapter", "finish!");
        WT();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
