package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;

public class SnsPostDescPreloadTextView extends PLTextView {
    private static int hitCount = 0;
    private static int missCount = 0;
    private boolean rRL = false;
    public int rRM = 0;

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final a Ef() {
        this.rRL = true;
        return d.bCF().bCE();
    }

    public final void setMaxLines(int i) {
        boolean z = true;
        if (getText() == null) {
            super.setMaxLines(i);
        }
        if (i <= 6) {
            if (this.rRL) {
                b(d.bCF().bCG());
                this.rRL = false;
            }
            z = false;
        } else {
            if (!this.rRL) {
                b(d.bCF().bCE());
                this.rRL = true;
            }
            z = false;
        }
        if (z) {
            f a = c.gTj.a(Ee(), getText());
            if (a == null) {
                int bCH = this.rRM > 0 ? this.rRM : d.bCF().bCH();
                if (bCH > 0) {
                    a = d.a(getText(), bCH, Ee()).Ec();
                }
            }
            if (a != null) {
                b(a);
            }
        }
    }

    protected final void p(CharSequence charSequence) {
        super.p(charSequence);
        hitCount++;
    }

    protected final void o(CharSequence charSequence) {
        if (charSequence != null) {
            setText(e.a(getContext(), charSequence.toString(), Ee().gUh), true);
        }
        missCount++;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
