package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class TranslateCommentTextView extends LinearLayout {
    public SnsTranslateResultView rAY;
    public MaskTextView rNa;

    public TranslateCommentTextView(Context context) {
        super(context);
        init();
    }

    public TranslateCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(g.qIn, this);
        this.rNa = (MaskTextView) findViewById(f.qBH);
        this.rAY = (SnsTranslateResultView) findViewById(f.qFD);
        this.rAY.setVisibility(8);
    }
}
