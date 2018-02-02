package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;

public class PopEmojiView extends LinearLayout {
    private ViewGroup jFk;
    public MMEmojiView vsC;
    private ProgressBar vsD;

    public PopEmojiView(Context context) {
        super(context);
        init(context);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.jFk = (ViewGroup) inflate(getContext(), f.lJz, null);
        this.vsC = (MMEmojiView) this.jFk.findViewById(e.image);
        this.vsC.vsA = true;
        this.vsC.vsy = context.getResources().getDimensionPixelSize(c.lnJ) - (context.getResources().getDimensionPixelSize(c.bvB) * 3);
        this.vsD = (ProgressBar) this.jFk.findViewById(e.progress);
        addView(this.jFk, -1, -1);
    }

    public final void Ct(int i) {
        switch (1.vsE[i - 1]) {
            case 1:
                this.vsC.setVisibility(4);
                this.vsD.setVisibility(0);
                return;
            case 2:
                this.vsC.setVisibility(0);
                this.vsD.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
