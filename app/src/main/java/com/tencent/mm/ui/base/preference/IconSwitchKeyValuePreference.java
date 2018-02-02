package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.w.a.j;

public class IconSwitchKeyValuePreference extends IconPreference {
    private TextView pjN;
    private int status;

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.pjN = (TextView) view.findViewById(16908304);
        au();
    }

    public final void Fe(int i) {
        this.status = i;
        au();
    }

    private void au() {
        if (this.pjN != null) {
            int b = b.b(this.mContext, 2.0f);
            this.pjN.setTextColor(r.gc(this.mContext));
            if (this.status == 0) {
                this.pjN.setCompoundDrawablesWithIntrinsicBounds(j.gYu, 0, 0, 0);
                this.pjN.setCompoundDrawablePadding(b);
            } else if (this.status == 1) {
                this.pjN.setCompoundDrawablesWithIntrinsicBounds(j.gYs, 0, 0, 0);
                this.pjN.setCompoundDrawablePadding(b);
            } else if (this.status == 2) {
                this.pjN.setCompoundDrawablesWithIntrinsicBounds(j.gYt, 0, 0, 0);
                this.pjN.setCompoundDrawablePadding(b);
            } else {
                this.pjN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
    }
}
