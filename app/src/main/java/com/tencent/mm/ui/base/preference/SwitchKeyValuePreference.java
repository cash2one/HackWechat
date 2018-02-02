package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.w.a.h;

public class SwitchKeyValuePreference extends Preference {
    public boolean fqP;
    private TextView pjN;

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fqP = true;
        setLayoutResource(h.dnt);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.pjN = (TextView) view.findViewById(16908304);
        au();
    }

    public final void au() {
        if (this.pjN != null) {
            if (this.fqP) {
                this.pjN.setTextColor(r.gb(this.mContext));
            } else {
                this.pjN.setTextColor(r.gc(this.mContext));
            }
        }
    }
}
