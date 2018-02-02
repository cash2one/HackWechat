package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sight.draft.ui.b.d;

public class SightDraftContainerView extends ListView {
    private boolean qvR;
    a qvS;
    b qvT;

    public SightDraftContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SightDraftContainerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundColor(getResources().getColor(R.e.black));
        setSelector(R.e.transparent);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvS);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bvv);
        View textView = new TextView(getContext());
        textView.setText(R.l.ePH);
        textView.setTextSize(0, (float) a.aa(getContext(), R.f.bvs));
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(R.e.bsP));
        textView.setTextSize(1, 11.0f);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        addFooterView(textView);
        setOnTouchListener(new 1(this));
    }

    public final void bto() {
        if (this.qvR) {
            this.qvT.qvD = 12;
            this.qvT.a(d.qvJ, false);
            this.qvT.a(null, null);
            setSelection(0);
            return;
        }
        this.qvR = true;
        this.qvT = new b(getContext(), this.qvS);
        this.qvT.qvD = 12;
        setAdapter(this.qvT);
    }
}
