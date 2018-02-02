package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;

public class HelperHeaderPreference extends Preference {
    private a vts = new a();

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.h.bLL);
        TextView textView = (TextView) view.findViewById(R.h.cPu);
        TextView textView2 = (TextView) view.findViewById(R.h.cAn);
        TextView textView3 = (TextView) view.findViewById(R.h.coC);
        if (imageView != null) {
            b.a(imageView, this.vts.fDC);
        }
        if (textView != null) {
            switch (this.vts.status) {
                case 0:
                    textView.setVisibility(0);
                    textView.setTextColor(r.gc(this.mContext));
                    textView.setText(R.l.eMF);
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.g.bGw, 0, 0, 0);
                    break;
                case 1:
                    textView.setVisibility(0);
                    textView.setTextColor(r.gb(this.mContext));
                    textView.setText(R.l.eMy);
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.g.bGx, 0, 0, 0);
                    break;
                case 2:
                    textView.setVisibility(8);
                    break;
            }
        }
        if (textView2 != null) {
            textView2.setText(this.vts.gBL);
        }
        if (textView3 != null) {
            textView3.setText(this.vts.vtt);
        }
        super.onBindView(view);
    }

    public final void ae(String str, String str2, String str3) {
        this.vts.fDC = str;
        this.vts.gBL = str2;
        this.vts.vtt = str3;
        super.callChangeListener(null);
    }

    public final void nx(int i) {
        this.vts.status = i;
        super.callChangeListener(null);
    }
}
