package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class a extends b {
    private c jeX;
    private TextView oNh;

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.oNh = (TextView) this.view.findViewById(R.h.cyg);
            this.view.setOnClickListener(new 1(this));
        }
        this.jeX = new 2(this);
        com.tencent.mm.sdk.b.a.xef.b(this.jeX);
    }

    public final int getLayoutId() {
        return R.i.cyh;
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.cyh).setVisibility(i);
        }
    }

    public final boolean alg() {
        return beF();
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.jeX);
    }

    private boolean beF() {
        int i = 8;
        if (com.tencent.mm.av.b.Qq()) {
            asv Qs = com.tencent.mm.av.b.Qs();
            CharSequence charSequence = ac.getContext().getString(R.l.ewO) + ac.getContext().getString(R.l.ewP) + Qs.wAk;
            if (this.oNh != null) {
                this.oNh.setText(charSequence);
            }
            if (!Qs.wAB) {
                i = 0;
            }
            setVisibility(i);
            if (Qs.wAB) {
                return false;
            }
            return true;
        }
        com.tencent.mm.sdk.b.b jrVar = new jr();
        jrVar.fAt.action = 10;
        com.tencent.mm.sdk.b.a.xef.m(jrVar);
        if (jrVar.fAu.fnI) {
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }

    public final int getOrder() {
        return 1;
    }
}
