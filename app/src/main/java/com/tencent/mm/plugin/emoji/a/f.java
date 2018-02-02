package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.bh;

public class f extends a {
    private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    public boolean ltV = false;
    public boolean ltW = true;
    public boolean ltX = false;
    public boolean ltY = true;

    public f(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.luC);
        return aVar;
    }

    public final void clear() {
        super.clear();
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        a aVar = (a) view.getTag();
        com.tencent.mm.plugin.emoji.a.a.f oG = oG(i);
        if (this.ltX) {
            oG.luT = true;
            oG.luR = false;
            oG.luS = false;
        }
        if (!(aVar == null || oG == null)) {
            oG.luS = this.ltY;
            sf sfVar = oG.luO;
            if (sfVar == null) {
                aVar.oC(0);
                z = false;
            } else {
                aVar.setTitle(sfVar.fon);
                aVar.xS(sfVar.nfe);
                if (!bh.ov(sfVar.nfT)) {
                    o.PA().a(sfVar.nfT, aVar.aAq(), com.tencent.mm.plugin.emoji.e.f.cg("", sfVar.nfT));
                }
                if (bh.ov(sfVar.wal)) {
                    aVar.oA(8);
                } else {
                    o.PA().a(sfVar.wal, aVar.aAr(), com.tencent.mm.plugin.emoji.e.f.cg("", sfVar.wal));
                    aVar.oA(0);
                }
                aVar.oC(8);
            }
            if (!z) {
                so soVar = oG.luN;
                if (soVar != null) {
                    aVar.setTitle(soVar.war);
                    if (com.tencent.mm.plugin.emoji.h.a.d(soVar)) {
                        o.PA().a("", aVar.aAq());
                        aVar.oz(R.g.bCY);
                    } else {
                        o.PA().a(soVar.nfT, aVar.aAq(), com.tencent.mm.plugin.emoji.e.f.cg(soVar.vIR, soVar.nfT));
                    }
                    boolean co = e.co(soVar.wav, 2);
                    if (!TextUtils.isEmpty(soVar.wbc)) {
                        aVar.aAr().setImageDrawable(null);
                        aVar.aAr().setVisibility(0);
                        o.PA().a(soVar.wbc, aVar.aAr(), com.tencent.mm.plugin.emoji.e.f.cg("", soVar.wbc));
                    } else if (co) {
                        aVar.oA(0);
                        aVar.oB(R.g.bBY);
                    } else {
                        aVar.oA(8);
                    }
                    aVar.xS(soVar.wbb);
                    if (this.ltV && aVar.ltm != null) {
                        aVar.ltm.setBackgroundResource(R.g.bBy);
                    }
                }
            }
        }
        return view;
    }

    public int aAE() {
        return 0;
    }

    public void oD(int i) {
    }

    public int aAF() {
        return 0;
    }

    public void oE(int i) {
    }

    public int aAG() {
        return 0;
    }

    public void oF(int i) {
    }
}
