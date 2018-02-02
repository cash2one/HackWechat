package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    private OnClickListener lXn;
    public View ltB;
    private View mView = null;
    public String ndc;
    public boolean ndg;
    private int pcQ = Integer.MAX_VALUE;
    private int pcR = -1;
    private int pcS = -1;

    public d(Context context) {
        super(context, null);
        setLayoutResource(g.uCb);
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
        TextView textView = (TextView) view.findViewById(f.uxq);
        ((TextView) view.findViewById(f.ulr)).setText(getTitle());
        this.ltB = view;
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
            g gVar = new g(this.mContext);
            CharSequence spannableString = new SpannableString(this.ndc);
            gVar.sTw = new 1(this);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(gVar, this.pcR, this.pcS, 33);
            textView.setText(spannableString);
        }
    }
}
