package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class z {
    public p fhr;
    private View yBZ;
    private ViewGroup yCa;
    public boolean yCb;
    public boolean yCc;
    private final long yCd = 259200000;
    public b yCe = new 2(this);

    public z(p pVar) {
        this.fhr = pVar;
    }

    public final void i(Boolean bool) {
        LayoutParams layoutParams;
        this.yCa = (ViewGroup) this.fhr.csq().findViewById(R.h.bTE);
        this.yBZ = View.inflate(this.fhr.csq().getContext(), R.i.dpa, null);
        TextView textView = (TextView) this.yBZ.findViewById(R.h.cAd);
        if (bool.booleanValue()) {
            textView.setText(this.fhr.csq().getContext().getString(R.l.eJW));
            this.yBZ.setBackgroundResource(R.g.bEv);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
        } else {
            textView.setText(this.fhr.csq().getContext().getString(R.l.eJY));
            this.yBZ.setBackgroundResource(R.g.bEu);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        }
        if (this.yCa != null && this.yBZ != null) {
            this.yCa.addView(this.yBZ, layoutParams);
            this.yBZ.startAnimation(AnimationUtils.loadAnimation(this.fhr.csq().getContext(), R.a.bqw));
            this.yBZ.setOnClickListener(new 1(this, bool));
        }
    }

    public final void c(Boolean bool, Boolean bool2) {
        if (this.yBZ != null) {
            this.yBZ.clearAnimation();
            this.yBZ.setVisibility(8);
            if (bool2.booleanValue()) {
                if (bool.booleanValue()) {
                    ar.Hg();
                    c.CU().set(340228, Boolean.valueOf(true));
                    g.pQN.a(232, 1, 1, false);
                }
            } else if (bool.booleanValue()) {
                ar.Hg();
                c.CU().set(340229, Boolean.valueOf(true));
                g.pQN.a(232, 2, 1, false);
            }
        }
    }
}
