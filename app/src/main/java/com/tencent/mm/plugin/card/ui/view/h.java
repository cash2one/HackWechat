package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.g;

public abstract class h implements ab {
    protected g kWw;
    protected MMActivity kaY;

    public abstract boolean awX();

    public abstract boolean awY();

    public h(g gVar, MMActivity mMActivity) {
        this.kWw = gVar;
        this.kaY = mMActivity;
    }

    public void c(ViewGroup viewGroup, b bVar) {
        if (awX()) {
            TextView textView = (TextView) viewGroup.findViewById(R.h.bWC);
            String str = this.kWw.code;
            if (bVar.atv() || (!g.AA(str) && str.length() <= 40)) {
                textView.setText(m.wW(str));
                if (bVar.atq()) {
                    textView.setVisibility(0);
                    textView.setOnLongClickListener(new 1(this, bVar));
                    this.kWw.d(c.kXx);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        if (awY()) {
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.h.bWq);
            if (bVar == null || bVar.atB() == null || bVar.atB().vSm == null || bh.ov(bVar.atB().vSm.title)) {
                relativeLayout.setVisibility(8);
                return;
            }
            viewGroup.findViewById(R.h.bWo).setVisibility(8);
            relativeLayout.setVisibility(0);
            oq oqVar = bVar.atB().vSm;
            TextView textView2 = (TextView) viewGroup.findViewById(R.h.bWs);
            textView2.setText(oqVar.title);
            String str2 = bVar.atB().hbM;
            if (!g.AA(str2)) {
                textView2.setTextColor(l.wO(str2));
            }
            textView2 = (TextView) viewGroup.findViewById(R.h.bWr);
            CharSequence charSequence = oqVar.kJR;
            if (TextUtils.isEmpty(charSequence)) {
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else if (textView2 != null) {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
            }
            relativeLayout.setOnClickListener(new 2(this, bVar));
        }
    }

    public boolean i(b bVar) {
        return true;
    }

    public void d(ViewGroup viewGroup) {
    }
}
