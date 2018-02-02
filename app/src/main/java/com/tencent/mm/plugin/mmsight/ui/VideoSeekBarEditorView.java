package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.u.a$d;
import com.tencent.mm.plugin.u.a$e;
import com.tencent.mm.ui.v;

public class VideoSeekBarEditorView extends LinearLayout {
    Button mkk;
    RecyclerThumbSeekBar oDw;
    Button oDx;
    private LinearLayout oDy;

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.oDy = (LinearLayout) v.fv(context).inflate(a$e.oFc, this, true);
        this.oDw = (RecyclerThumbSeekBar) findViewById(a$d.oEV);
        this.mkk = (Button) findViewById(a$d.oEA);
        this.oDx = (Button) findViewById(a$d.oEB);
    }

    public final void bbI() {
        this.oDw.release();
        ViewParent parent = this.oDw.getParent();
        if (parent instanceof LinearLayout) {
            LayoutParams layoutParams = (LayoutParams) this.oDw.getLayoutParams();
            ((LinearLayout) parent).removeView(this.oDw);
            this.oDw = new RecyclerThumbSeekBar(getContext());
            ((LinearLayout) parent).addView(this.oDw, 0, layoutParams);
        }
    }
}
