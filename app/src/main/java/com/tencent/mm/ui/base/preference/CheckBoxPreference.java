package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn$a;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class CheckBoxPreference extends Preference {
    private TextView sHZ;
    private int sIa;
    private String sIb;
    private int sIc;
    private MMSwitchBtn tPM;
    public boolean tSw;

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tSw = false;
        this.sIa = -1;
        this.sIb = "";
        this.sIc = 8;
        setLayoutResource(h.gXT);
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.tPM = (MMSwitchBtn) view.findViewById(g.checkbox);
        this.tPM.zvp = new MMSwitchBtn$a(this) {
            final /* synthetic */ CheckBoxPreference yhU;

            {
                this.yhU = r1;
            }

            public final void cw(boolean z) {
                this.yhU.callChangeListener(Boolean.valueOf(z));
            }
        };
        this.tPM.nB(this.tSw);
        if (!isEnabled()) {
            this.tPM.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(d.bry));
        }
        this.sHZ = (TextView) view.findViewById(g.gWA);
        cq(this.sIb, this.sIa);
        zg(this.sIc);
    }

    public final boolean isChecked() {
        if (this.tPM != null) {
            return this.tPM.zvg;
        }
        return this.tSw;
    }

    public final void mv(boolean z) {
        if (this.tPM != null) {
            this.tSw = z;
            this.tPM.nB(z);
        }
    }

    public void cq(String str, int i) {
        this.sIa = i;
        this.sIb = str;
        if (this.sHZ != null) {
            if (i > 0) {
                this.sHZ.setBackgroundResource(this.sIa);
            }
            if (!TextUtils.isEmpty(this.sIb)) {
                this.sHZ.setText(this.sIb);
            }
        }
    }

    public void zg(int i) {
        this.sIc = i;
        if (this.sHZ != null) {
            this.sHZ.setVisibility(this.sIc);
        }
    }
}
