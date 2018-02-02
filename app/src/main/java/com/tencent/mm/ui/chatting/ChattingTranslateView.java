package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingTranslateView extends LinearLayout {
    private String fHV;
    private ImageView tOJ;
    private TextView yvq;
    private boolean yvs;
    private boolean yvy;
    private a yvz;

    public enum a {
        NoTranslate,
        Translating,
        Translated
    }

    public ChattingTranslateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yvy = false;
        this.yvz = null;
        this.yvs = false;
        init();
    }

    public ChattingTranslateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        init();
    }

    public final void mG(boolean z) {
        this.yvs = z;
        if (z) {
            super.setVisibility(8);
        }
    }

    private void init() {
        int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.tOJ = new ImageView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(applyDimension, applyDimension, 0, applyDimension);
        this.tOJ.setLayoutParams(layoutParams);
        addView(this.tOJ);
        this.yvq = new TextView(getContext());
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(applyDimension, applyDimension, applyDimension, applyDimension);
        layoutParams.gravity = 16;
        this.yvq.setLayoutParams(layoutParams);
        this.yvq.setTextSize(1, 11.0f);
        this.yvq.setTextColor(-1);
        addView(this.yvq);
        setBackgroundResource(R.g.bAO);
        a(a.NoTranslate);
    }

    public final void csb() {
        a(a.NoTranslate);
    }

    public final void csc() {
        a(a.Translating);
    }

    public final void Zc(String str) {
        if (!bh.ou(this.fHV).equals(bh.ou(str))) {
            this.yvy = true;
        }
        this.fHV = str;
        a(a.Translated);
    }

    private void a(a aVar) {
        if (this.yvs) {
            super.setVisibility(8);
        } else if (this.yvz != aVar || this.yvy) {
            this.yvy = false;
            x.d("MicroMsg.ChattingTranslateView", "from status %s to status %s", new Object[]{this.yvz, aVar});
            this.yvz = aVar;
            switch (1.yvA[aVar.ordinal()]) {
                case 1:
                    super.setVisibility(8);
                    break;
                case 2:
                    super.setVisibility(0);
                    this.tOJ.setImageResource(R.k.dBl);
                    this.yvq.setText(R.l.dTk);
                    break;
                case 3:
                    super.setVisibility(0);
                    this.tOJ.setImageResource(R.k.dBk);
                    if (!bh.ov(this.fHV)) {
                        this.yvq.setText(this.fHV);
                        break;
                    } else {
                        this.yvq.setText(R.l.dTj);
                        break;
                    }
            }
            invalidate();
        }
    }
}
