package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.ui.tools.CustomFitTextView;
import com.tencent.mm.w.a.d;

public class WalletPayUSecurityQuestionView extends LinearLayout {
    private Context mContext;
    private TextView tdS;
    private CustomFitTextView tdT;
    String tdU;

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        CharSequence charSequence;
        super(context, attributeSet);
        this.mContext = context;
        String str = "";
        String str2 = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, k.uYD, -1, 0);
            int resourceId = obtainStyledAttributes.getResourceId(k.uYL, 0);
            if (resourceId != 0) {
                str = this.mContext.getString(resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(k.uYK, 0);
            if (resourceId != 0) {
                str2 = this.mContext.getString(resourceId);
            }
            boolean z2 = obtainStyledAttributes.getBoolean(k.uYG, false);
            obtainStyledAttributes.recycle();
            z = z2;
            charSequence = str;
        } else {
            z = false;
            Object obj = str;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(g.uDu, this, true);
        this.tdS = (TextView) inflate.findViewById(f.cRV);
        this.tdT = (CustomFitTextView) inflate.findViewById(f.utE);
        this.tdS.setText(charSequence);
        CustomFitTextView customFitTextView = this.tdT;
        customFitTextView.a(str2, customFitTextView.maxLines, customFitTextView.zhZ, customFitTextView.zhX, customFitTextView.getResources().getColor(d.bsO));
        if (z) {
            this.tdT.setEnabled(false);
            this.tdT.setTextColor(getResources().getColor(c.ubw));
            this.tdT.setFocusable(false);
            this.tdT.setClickable(false);
            this.tdT.setBackgroundResource(e.bHb);
            setBackgroundResource(e.bBx);
            return;
        }
        this.tdT.setEnabled(false);
        this.tdT.setFocusable(false);
        this.tdT.setClickable(false);
        this.tdT.setBackgroundResource(e.bHb);
        setBackgroundResource(e.bDp);
    }

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void NB(String str) {
        this.tdU = str;
        KeyListener keyListener = this.tdT.getKeyListener();
        this.tdT.setInputType(1);
        this.tdT.setKeyListener(null);
        this.tdT.b(str, 3, false, -1);
        this.tdT.setKeyListener(keyListener);
    }
}
