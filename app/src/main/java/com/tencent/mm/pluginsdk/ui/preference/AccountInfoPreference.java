package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.s;

public class AccountInfoPreference extends Preference {
    public String userName;
    public SpannableString vsS;
    public String vsT;
    private int vsU;
    public OnClickListener vsV;

    public AccountInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vsV = null;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.h.bLL);
        if (!(this.userName == null || imageView == null || !g.Dh().Cy())) {
            b.a(imageView, this.userName);
        }
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) view.findViewById(R.h.cAk);
        if (!(this.userName == null || noMeasuredTextView == null)) {
            noMeasuredTextView.ygb = true;
            noMeasuredTextView.O((float) a.aa(this.mContext, R.f.bvK));
            noMeasuredTextView.setTextColor(a.Z(this.mContext, R.e.btv));
            noMeasuredTextView.setText(this.vsS == null ? this.userName : this.vsS);
        }
        TextView textView = (TextView) view.findViewById(R.h.cUk);
        if (this.vsT != null && textView != null) {
            textView.setText(view.getResources().getString(R.l.dDJ, new Object[]{this.vsT}));
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        textView = (TextView) view.findViewById(R.h.cIe);
        if (textView != null) {
            if (this.vsU > 99) {
                textView.setText(this.mContext.getString(R.l.eQs));
                textView.setBackgroundResource(s.gd(this.mContext));
                textView.setVisibility(0);
            } else if (this.vsU > 0) {
                textView.setText(this.vsU);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        if (this.vsV != null) {
            ((ImageView) view.findViewById(R.h.bIw)).setOnClickListener(this.vsV);
        }
    }
}
