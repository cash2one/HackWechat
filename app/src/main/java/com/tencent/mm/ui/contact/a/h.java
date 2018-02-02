package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.ui.contact.a.a.b;

public final class h extends a {
    private CharSequence mPM;
    private b yVy = new b(this);
    a$a yVz = new a(this);

    public class a extends a$a {
        public TextView mPP;
        final /* synthetic */ h yVA;

        public a(h hVar) {
            this.yVA = hVar;
            super(hVar);
        }
    }

    public h(int i) {
        super(6, i);
    }

    public final void bH(Context context) {
        this.mPM = f.a(context.getString(com.tencent.mm.plugin.selectcontact.a.h.eIE), context.getString(com.tencent.mm.plugin.selectcontact.a.h.eID), com.tencent.mm.plugin.fts.d.b.a.d(this.fDj, this.fDj)).mQk;
    }

    public final b WQ() {
        return this.yVy;
    }

    protected final a$a WR() {
        return this.yVz;
    }
}
