package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;

public class d$a extends a {
    final /* synthetic */ d ltO;

    public d$a(d dVar, Context context, View view) {
        this.ltO = dVar;
        super(context, view);
    }

    protected final void aAn() {
        this.lto.setVisibility(8);
        this.ltq.setVisibility(8);
        this.ltp.setVisibility(0);
        this.ltr.setVisibility(8);
        this.ltv.setVisibility(8);
        this.ltw.setVisibility(8);
        this.ltn.setVisibility(0);
        this.jJn.setVisibility(0);
        this.ltt.setVisibility(0);
        this.lts.setVisibility(0);
        this.lts.setBackgroundDrawable(null);
        this.ltu.setVisibility(0);
    }

    protected final int[] aAo() {
        int aa = a.aa(this.mContext, R.f.bxf);
        return new int[]{aa, aa};
    }

    protected final int aAp() {
        return a.aa(this.mContext, R.f.bxg);
    }

    protected final boolean aAw() {
        return true;
    }
}
