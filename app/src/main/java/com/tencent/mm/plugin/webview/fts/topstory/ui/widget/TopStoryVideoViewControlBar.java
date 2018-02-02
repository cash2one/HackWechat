package com.tencent.mm.plugin.webview.fts.topstory.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoViewControlBar;
import com.tencent.mm.sdk.platformtools.ac;

public class TopStoryVideoViewControlBar extends FtsWebVideoViewControlBar {
    public TextView tqA;
    private ViewGroup tqB;
    private int tqC;
    public a tqD;
    public View tqz;

    public TopStoryVideoViewControlBar(Context context) {
        super(context);
    }

    public TopStoryVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopStoryVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final int getLayoutId() {
        return R.i.dtf;
    }

    protected final void init() {
        super.init();
        this.tqz = this.contentView.findViewById(R.h.cNM);
        this.tqA = (TextView) this.contentView.findViewById(R.h.ckq);
        this.tqB = (ViewGroup) findViewById(R.h.cCJ);
        this.tqC = a.fromDPToPix(ac.getContext(), 20);
    }

    public final void bQi() {
        super.bQi();
        this.tqz.setVisibility(0);
        this.tqA.setVisibility(0);
        this.tqB.setPadding(0, 0, this.tqC, 0);
    }

    public final void ags() {
        super.ags();
        this.tqz.setVisibility(8);
        this.tqA.setVisibility(8);
        this.tqB.setPadding(0, 0, 0, 0);
    }

    public final void ki(boolean z) {
        this.trw.setVisibility(0);
        super.ki(z);
    }

    protected final void Af(int i) {
        super.Af(i);
        if (this.tqD != null) {
            this.tqD.update(i, this.qum.getWidth());
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            if (this.tqD != null) {
                this.tqD.bQa();
            }
        } else if (i == 0 && this.tqD != null) {
            this.tqD.bPZ();
        }
    }
}
