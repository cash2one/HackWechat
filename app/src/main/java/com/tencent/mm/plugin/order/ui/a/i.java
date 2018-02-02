package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class i extends Preference {
    private View mView = null;
    private int pdf = Integer.MAX_VALUE;
    String pdg;

    public i(Context context) {
        super(context);
        setLayoutResource(g.uDa);
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
        TextView textView = (TextView) view.findViewById(f.uqr);
        ((TextView) view.findViewById(f.uqs)).setText(getTitle());
        textView.setText(this.pdg);
        if (this.pdf != Integer.MAX_VALUE) {
            textView.setTextColor(this.pdf);
        }
    }

    public final void Hp(String str) {
        try {
            this.pdf = Color.parseColor(str);
        } catch (Exception e) {
            this.pdf = -1;
        }
    }
}
