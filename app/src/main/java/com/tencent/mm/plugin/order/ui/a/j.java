package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j extends Preference {
    OnClickListener mOnClickListener = null;
    private View mView = null;
    List<HelpCenter> oZZ = new LinkedList();
    String pdh;
    OnClickListener pdi = null;

    public j(Context context) {
        super(context);
        setLayoutResource(g.uDd);
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
        LinearLayout linearLayout = (LinearLayout) view.findViewById(f.uqu);
        linearLayout.removeAllViews();
        if (this.oZZ != null) {
            int size;
            int i;
            View view2;
            if (bh.ov(this.pdh) || this.pdi == null) {
                size = this.oZZ.size() - 1;
            } else {
                size = this.oZZ.size();
            }
            if (size == 0) {
                i = -1;
            } else {
                i = size;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.oZZ.size(); i3++) {
                HelpCenter helpCenter = (HelpCenter) this.oZZ.get(i3);
                View textView = new TextView(this.mContext);
                textView.setTextColor(this.mContext.getResources().getColor(c.black));
                textView.setTextSize(0, (float) a.aa(this.mContext, d.bvK));
                textView.setIncludeFontPadding(false);
                textView.setText(helpCenter.name);
                textView.setTag(helpCenter);
                textView.setGravity(17);
                textView.setOnClickListener(this.mOnClickListener);
                if (i2 == i) {
                    textView.setTextColor(this.mContext.getResources().getColor(c.bsE));
                }
                linearLayout.addView(textView, new LayoutParams(0, -2, 1.0f));
                if (i2 < i) {
                    view2 = new View(this.mContext);
                    view2.setBackgroundColor(this.mContext.getResources().getColor(c.btQ));
                    linearLayout.addView(view2, new LayoutParams(a.aa(this.mContext, d.ubI), -1));
                }
                i2++;
            }
            if (!bh.ov(this.pdh) && this.pdi != null) {
                view2 = new TextView(this.mContext);
                view2.setTextColor(this.mContext.getResources().getColor(c.black));
                view2.setTextSize(0, (float) a.aa(this.mContext, d.bvK));
                view2.setIncludeFontPadding(false);
                view2.setText(this.pdh);
                view2.setGravity(17);
                view2.setOnClickListener(this.pdi);
                if (i2 == i) {
                    view2.setTextColor(this.mContext.getResources().getColor(c.bsE));
                }
                linearLayout.addView(view2, new LayoutParams(0, -2, 1.0f));
            }
        }
    }
}
