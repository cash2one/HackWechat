package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan extends Standard implements f<Integer>, g<Integer> {
    private final boolean tVD;
    private final int tVE;

    public final /* synthetic */ f bXw() {
        return new IndentationSpan(this.tVE, this.tVD);
    }

    public final /* synthetic */ Object getValue() {
        return Integer.valueOf(this.tVE);
    }

    private IndentationSpan(int i, boolean z) {
        super(i);
        this.tVE = i;
        this.tVD = z;
    }

    public int getLeadingMargin(boolean z) {
        return this.tVD ? 0 : this.tVE;
    }
}
