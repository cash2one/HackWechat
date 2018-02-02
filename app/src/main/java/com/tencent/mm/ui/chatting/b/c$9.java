package com.tencent.mm.ui.chatting.b;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.b.c.a;

class c$9 implements a {
    final /* synthetic */ c yyQ;

    c$9(c cVar) {
        this.yyQ = cVar;
    }

    public final boolean ctl() {
        if (this.yyQ.yyL == null) {
            g.a(this.yyQ.fhr.csq(), R.h.cVQ);
            this.yyQ.yyL = (RelativeLayout) this.yyQ.fhr.csq().findViewById(R.h.bNS);
            this.yyQ.yyM = (TextView) this.yyQ.fhr.csq().findViewById(R.h.bNT);
            this.yyQ.yyM.setText(R.l.dQg);
        }
        this.yyQ.yyL.setVisibility(0);
        this.yyQ.fhr.css().postDelayed(new 1(this), 5000);
        return true;
    }
}
