package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.profile.ui.a.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class CommonChatroomInfoUI extends MMBaseSelectContactUI {
    private x jLe;
    private a phx;
    private b phy;

    protected final void WT() {
        super.WT();
        String stringExtra = getIntent().getStringExtra("Select_Talker_Name");
        ar.Hg();
        this.jLe = c.EY().WO(stringExtra);
    }

    protected final void initView() {
        super.initView();
        a aVar = this.phx;
        g gVar = new g();
        gVar.fDj = aVar.jLe.field_username;
        gVar.mLZ = aVar;
        gVar.handler = aVar.handler;
        gVar.mLR = 6;
        gVar.mLY = new a(aVar, (byte) 0);
        ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
    }

    protected final boolean WU() {
        return true;
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        if (this.jLe.fWf == 1) {
            return getString(R.l.dUK);
        }
        if (this.jLe.fWf == 2) {
            return getString(R.l.dUJ);
        }
        return getString(R.l.dUM);
    }

    protected final o WX() {
        if (this.phx == null) {
            this.phx = new a(this, this.scene, this.jLe);
        }
        return this.phx;
    }

    protected final com.tencent.mm.ui.contact.m WY() {
        if (this.phy == null) {
            this.phy = new b(this, this.scene, this.jLe);
        }
        return this.phy;
    }

    public final void ja(int i) {
        d.a((Context) this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", ((e) this.prJ.getAdapter().getItem(i)).jLe.field_username).putExtra("finish_direct", true));
    }
}
