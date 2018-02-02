package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.bv.a;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;
import java.util.ArrayList;

public class MMAutoSwitchEditTextView extends LinearLayout {
    private int luh = 100;
    private Context mContext;
    private int mScreenWidth;
    private int nQj;
    private int pJr;
    private int xZD;
    private String xZE;
    public ArrayList<MMAutoSwitchEditText> xZF = new ArrayList();
    private c xZG = new c(this, (byte) 0);
    public a xZH;
    public b xZI;

    public MMAutoSwitchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.eZw);
        this.xZD = obtainStyledAttributes.getInteger(m.gYR, 3);
        this.nQj = obtainStyledAttributes.getInteger(m.gYS, 4);
        this.pJr = obtainStyledAttributes.getInteger(m.gYT, 2);
        int resourceId = obtainStyledAttributes.getResourceId(m.gYU, 0);
        if (resourceId != 0) {
            this.xZE = context.getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (context instanceof Activity) {
            this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
            this.luh = ((this.mScreenWidth - 80) - ((this.xZD - 1) * 20)) / this.xZD;
        }
        setPadding(a.fromDPToPix(context, 20), 0, a.fromDPToPix(context, 20), 0);
        coV();
    }

    private void coV() {
        for (int i = 0; i < this.xZD; i++) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) View.inflate(this.mContext, h.gXa, null);
            mMAutoSwitchEditText.setInputType(this.pJr);
            if (this.xZE != null && this.xZE.length() > 0) {
                mMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.xZE));
            }
            mMAutoSwitchEditText.xZy.mIndex = i;
            mMAutoSwitchEditText.xZy.xZC = this.nQj;
            mMAutoSwitchEditText.xZy.xZz = this.xZG;
            mMAutoSwitchEditText.xZy.xZA = this.xZG;
            mMAutoSwitchEditText.xZy.xZB = this.xZG;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.luh, -2);
            if (i > 0) {
                layoutParams.leftMargin = 20;
            } else {
                layoutParams.leftMargin = 0;
            }
            layoutParams.weight = 1.0f;
            mMAutoSwitchEditText.setLayoutParams(layoutParams);
            this.xZF.add(mMAutoSwitchEditText);
            addView(mMAutoSwitchEditText);
        }
    }
}
