package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;

public class f$a extends a {
    final /* synthetic */ f ltZ;

    public f$a(f fVar, Context context, View view) {
        this.ltZ = fVar;
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

    protected final int[] aAo() {
        int aa = a.aa(this.mContext, R.f.bxd);
        return new int[]{aa, aa};
    }

    protected final int aAp() {
        return a.aa(this.mContext, R.f.bxc);
    }

    protected final boolean aAw() {
        return f.a(this.ltZ);
    }
}
