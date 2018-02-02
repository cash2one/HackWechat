package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.sdk.b.b;

public class c$a extends a {
    final /* synthetic */ c ltN;

    public c$a(c cVar, Context context, View view) {
        this.ltN = cVar;
        super(context, view);
    }

    protected final void aAn() {
        this.lto.setVisibility(8);
        aAs();
        this.ltr.setVisibility(8);
        this.ltv.setVisibility(8);
        this.ltw.setVisibility(8);
        this.ltn.setVisibility(0);
        this.jJn.setVisibility(0);
        this.ltt.setVisibility(0);
        this.lts.setVisibility(0);
        this.ltu.setVisibility(0);
    }

    protected final boolean a(a aVar, View view) {
        aAu();
        return super.a(aVar, view);
    }

    protected final void b(a aVar, View view) {
        super.b(aVar, view);
        if (com.tencent.mm.plugin.emoji.h.a.yO(aAt())) {
            b csVar = new cs();
            csVar.fqU.fqV = aAt();
            csVar.fqU.status = com.tencent.mm.plugin.emoji.h.a.aCY() ? 7 : 3;
            csVar.fqU.progress = getProgress();
            csVar.fqU.fqW = this.ltl.luQ;
            com.tencent.mm.sdk.b.a.xef.m(csVar);
        }
    }

    protected final int[] aAo() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.buq);
        return new int[]{dimensionPixelSize, dimensionPixelSize};
    }

    protected final int aAp() {
        return -1;
    }

    protected final boolean aAw() {
        return true;
    }

    public final void aAz() {
        if (this.ltl != null) {
            switch (aAu()) {
                case 0:
                case 3:
                    this.ltr.setVisibility(8);
                    this.lts.setBackgroundResource(R.g.bAb);
                    this.lts.setVisibility(0);
                    this.ltu.setVisibility(0);
                    this.ltu.setText(R.l.eas);
                    this.ltu.setTextColor(this.mContext.getResources().getColorStateList(R.e.bul));
                    this.ltv.setVisibility(4);
                    this.ltv.setImageResource(R.g.bBO);
                    this.ltw.setVisibility(4);
                    return;
                case 6:
                    aAx();
                    return;
                default:
                    this.ltr.setVisibility(8);
                    this.lts.setBackgroundResource(R.g.bAe);
                    this.lts.setVisibility(0);
                    this.ltu.setVisibility(0);
                    this.ltu.setText(R.l.ebf);
                    this.ltu.setTextColor(this.mContext.getResources().getColorStateList(R.e.brz));
                    this.ltv.setVisibility(4);
                    this.ltv.setImageResource(R.g.bBO);
                    this.ltw.setVisibility(4);
                    return;
            }
        }
    }
}
