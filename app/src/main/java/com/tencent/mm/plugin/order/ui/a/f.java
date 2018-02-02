package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference {
    private OnClickListener lXn;
    private View mView = null;
    private String ndc;
    private boolean ndg;
    private int pcQ = Integer.MAX_VALUE;
    private int pcR = -1;
    private int pcS = -1;

    public f(Context context) {
        super(context);
        setLayoutResource(g.uCW);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.uqk);
        ((TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.uql)).setText(getTitle());
        if (this.pcQ != Integer.MAX_VALUE) {
            textView.setTextColor(this.pcQ);
        }
        if (!this.ndg) {
            textView.setOnClickListener(null);
            textView.setText(i.b(this.mContext, this.ndc, textView.getTextSize()));
        } else if (this.pcR < 0 || this.pcS <= 0) {
            textView.setTextColor(this.mContext.getResources().getColor(c.ubc));
            textView.setOnClickListener(this.lXn);
            textView.setText(i.b(this.mContext, this.ndc, textView.getTextSize()));
        } else {
            a aVar = new a(this.mContext);
            CharSequence spannableString = new SpannableString(this.ndc);
            aVar.pdj = new 1(this);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(aVar, this.pcR, this.pcS, 33);
            textView.setText(spannableString);
        }
    }

    public final void Ho(String str) {
        try {
            this.pcQ = Color.parseColor(str);
        } catch (Exception e) {
            this.pcQ = Integer.MAX_VALUE;
        }
    }

    public final void setContent(String str) {
        this.ndc = str;
        this.ndg = false;
    }

    public final void a(String str, int i, int i2, OnClickListener onClickListener) {
        this.ndc = str;
        this.ndg = true;
        this.pcR = i;
        this.pcS = i2;
        this.lXn = onClickListener;
    }
}
