package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.o;

public final class d extends o implements b {
    private Cursor iiG;
    private String kGH;
    private int pOu;

    public d(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, false);
        x.i("MicroMsg.RecentConversationAdapter", "create!");
        this.kGH = str;
        aJh();
    }

    private void aJh() {
        x.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
        this.iiG = y.Mi().kj(this.kGH);
        this.pOu = 0;
    }

    public final int getCount() {
        return this.iiG.getCount() + 1;
    }

    protected final a jb(int i) {
        a gVar;
        if (i == this.pOu) {
            gVar = new g(i);
            gVar.mPH = this.ySV.getActivity().getResources().getString(R.l.eJm);
            return gVar;
        } else if (i <= this.pOu || !this.iiG.moveToPosition((i - this.pOu) - 1)) {
            x.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            return null;
        } else {
            gVar = new a(i);
            com.tencent.mm.ag.a.a aVar = new com.tencent.mm.ag.a.a();
            aVar.b(this.iiG);
            if (gVar.kGB != -1) {
                return gVar;
            }
            gVar.kGB = aVar.field_bizChatId;
            c ag = y.Mh().ag(aVar.field_bizChatId);
            if (ag.Mt()) {
                gVar.iil = ag.field_chatName;
                gVar.yni = ag.field_headImageUrl;
                gVar.username = ag.field_brandUserName;
            } else {
                j ca = y.Mj().ca(ag.field_bizChatServId);
                if (ca != null) {
                    gVar.iil = ca.field_userName;
                    gVar.yni = ca.field_headImageUrl;
                    gVar.username = ca.field_brandUserName;
                }
            }
            if (bh.M(gVar.iil)) {
                gVar.iil = this.ySV.getActivity().getResources().getString(R.l.eFx);
            }
            if (!bh.ov(gVar.username)) {
                return gVar;
            }
            gVar.username = aVar.field_brandUserName;
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
    }

    public final void a(int i, m mVar, Object obj) {
        aJh();
        notifyDataSetChanged();
    }
}
