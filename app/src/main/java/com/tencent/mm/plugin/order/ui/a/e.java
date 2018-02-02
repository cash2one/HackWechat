package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    public OnClickListener mOnClickListener = null;
    private View mView = null;
    public String pcP;

    public e(Context context) {
        super(context);
        setLayoutResource(a$g.uCV);
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
        TextView textView = (TextView) view.findViewById(f.uqj);
        textView.setText(this.pcP);
        textView.setOnClickListener(this.mOnClickListener);
    }
}
