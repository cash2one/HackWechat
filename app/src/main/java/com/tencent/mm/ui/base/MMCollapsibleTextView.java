package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;

public class MMCollapsibleTextView extends LinearLayout {
    private Context context;
    private boolean hasCheck = true;
    private TextView inu;
    private Runnable mrT = new 2(this);
    private int qQY;
    private TextView rrY;
    private String rrZ;
    private String rsa;
    private SparseIntArray xZM = new SparseIntArray();

    static /* synthetic */ void c(MMCollapsibleTextView mMCollapsibleTextView) {
        mMCollapsibleTextView.hasCheck = true;
        switch (mMCollapsibleTextView.xZM.get(mMCollapsibleTextView.qQY, -1)) {
            case 0:
                mMCollapsibleTextView.rrY.setVisibility(8);
                return;
            case 1:
                mMCollapsibleTextView.inu.setMaxLines(10);
                mMCollapsibleTextView.rrY.setVisibility(0);
                mMCollapsibleTextView.rrY.setText(mMCollapsibleTextView.rrZ);
                return;
            case 2:
                mMCollapsibleTextView.inu.setMaxLines(Integer.MAX_VALUE);
                mMCollapsibleTextView.rrY.setVisibility(0);
                mMCollapsibleTextView.rrY.setText(mMCollapsibleTextView.rsa);
                return;
            default:
                mMCollapsibleTextView.hasCheck = false;
                mMCollapsibleTextView.rrY.setVisibility(8);
                mMCollapsibleTextView.inu.setMaxLines(11);
                return;
        }
    }

    public MMCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.rrZ = this.context.getString(k.gYI);
        this.rsa = this.context.getString(k.gYH);
        View inflate = inflate(this.context, h.gXu, this);
        inflate.setPadding(0, -3, 0, 0);
        this.inu = (TextView) inflate.findViewById(g.caS);
        this.rrY = (TextView) inflate.findViewById(g.gVt);
        this.rrY.setOnClickListener(new 1(this));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.hasCheck) {
            this.hasCheck = true;
            if (this.inu.getLineCount() <= 10) {
                this.xZM.put(this.qQY, 0);
                return;
            }
            this.xZM.put(this.qQY, 1);
            post(this.mrT);
        }
    }
}
