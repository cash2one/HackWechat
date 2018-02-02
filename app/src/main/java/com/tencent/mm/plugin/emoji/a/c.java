package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a {
    private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
    private ProgressDialog ltM;

    public c(Context context) {
        super(context);
    }

    public final void notifyDataSetChanged() {
        if (this.luB == null) {
            this.luB = a(null);
        }
        super.notifyDataSetChanged();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f oG = oG(i);
        if (!(aVar == null || oG == null)) {
            so soVar = oG.luN;
            if (soVar != null) {
                if (com.tencent.mm.plugin.emoji.h.a.d(soVar)) {
                    aVar.setTitle(R.l.ebe);
                    aVar.oz(R.g.bCY);
                } else {
                    if (bh.ov(soVar.war)) {
                        aVar.setTitle(soVar.vIR);
                    } else {
                        aVar.setTitle(soVar.war);
                    }
                    if (bh.ov(soVar.nfT)) {
                        x.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
                    } else {
                        o.PA().a(soVar.nfT, aVar.aAq(), com.tencent.mm.plugin.emoji.e.f.cg(soVar.vIR, soVar.nfT));
                    }
                }
                if (i + 1 == getCount()) {
                    aVar.ltm.setBackgroundResource(R.g.bBy);
                } else {
                    aVar.ltm.setBackgroundResource(R.g.bBx);
                }
            }
        }
        return view;
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.luC);
        return aVar;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.c a(com.tencent.mm.plugin.emoji.model.f fVar) {
        return new d(fVar);
    }

    public final void bc(String str, int i) {
        if (i == 7) {
            super.bc(str, i);
        }
    }

    public final void clear() {
        if (this.ltM != null) {
            this.ltM.cancel();
        }
        super.clear();
    }

    protected final void aAD() {
        super.aAD();
    }

    public final int aAE() {
        return 0;
    }

    public final void oD(int i) {
    }

    public final int aAF() {
        return 0;
    }

    public final void oE(int i) {
    }

    public final int aAG() {
        return 0;
    }

    public final void oF(int i) {
    }
}
