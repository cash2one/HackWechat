package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingTransformView extends LinearLayout {
    private ImageView tOJ;
    private TextView yvq;
    private a yvr;
    private boolean yvs;

    public ChattingTransformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yvr = null;
        this.yvs = false;
        init();
    }

    public ChattingTransformView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        init();
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
        a aVar = a.yvu;
        if (this.yvs) {
            super.setVisibility(8);
        } else if (this.yvr != aVar) {
            x.d("MicroMsg.ChattingTransformView", "from status %s to status %s", new Object[]{this.yvr, aVar});
            this.yvr = aVar;
            switch (1.yvt[aVar.ordinal()]) {
                case 1:
                    super.setVisibility(8);
                    break;
                case 2:
                    super.setVisibility(0);
                    this.tOJ.setImageResource(R.k.dBl);
                    this.yvq.setText(R.l.dTh);
                    break;
            }
            invalidate();
        }
    }
}
