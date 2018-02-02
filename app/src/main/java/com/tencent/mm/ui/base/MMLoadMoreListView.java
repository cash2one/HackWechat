package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class MMLoadMoreListView extends ListView {
    public View lBB = null;
    public a ybX = null;
    private boolean ybY = false;
    public TextView ybZ;
    public boolean yca = false;

    public MMLoadMoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void cpo() {
        this.lBB = View.inflate(getContext(), h.dns, null);
        this.ybZ = (TextView) this.lBB.findViewById(g.gVw);
        this.lBB.setVisibility(8);
    }

    private void init() {
        if (this.lBB == null) {
            cpo();
            addFooterView(this.lBB);
            this.lBB.setVisibility(8);
        }
    }

    public final void cpp() {
        this.ybY = true;
        setOnScrollListener(new 1(this));
    }

    public final void cpq() {
        if (this.lBB != null) {
            this.ybZ.setVisibility(8);
            this.lBB.setVisibility(8);
        }
    }

    public final void cpr() {
        this.ybZ.setVisibility(0);
        this.lBB.setVisibility(0);
    }
}
