package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g extends Preference {
    private static int pcU;
    private static float pcV = 16.0f;
    f jKn;
    private View mView = null;
    String pcW;
    private String[] pcX;
    private TruncateAt pcY;
    private boolean pcZ = false;

    static /* synthetic */ TextView a(g gVar, String str) {
        TextView textView = new TextView(gVar.mContext);
        textView.setText(str);
        textView.setTextSize(pcV);
        textView.setTextColor(pcU);
        if (gVar.pcZ) {
            textView.setSingleLine(true);
            textView.setEllipsize(gVar.pcY);
        } else {
            textView.setSingleLine(false);
        }
        return textView;
    }

    public g(Context context) {
        super(context);
        setLayoutResource(com.tencent.mm.plugin.wxpay.a.g.uCX);
        pcU = context.getResources().getColor(c.ubf);
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
        TextView textView = (TextView) view.findViewById(a.f.uqo);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.uqn);
        ((TextView) view.findViewById(a.f.uqp)).setText(getTitle());
        if (this.pcX == null || this.pcX.length <= 1) {
            textView.setTextColor(pcU);
        } else {
            textView.setOnClickListener(new 1(this, textView, linearLayout));
        }
        textView.setText(this.pcW);
    }

    public final void a(String[] strArr, TruncateAt truncateAt) {
        this.pcX = strArr;
        this.pcY = truncateAt;
        this.pcZ = true;
    }
}
