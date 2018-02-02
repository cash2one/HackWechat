package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref extends Preference {
    private MMActivity fmM;
    private TextView jQj;
    TextView kmC;
    String mkE;
    OnClickListener sHA;
    private TextView sHv;
    TextView sHw;
    String sHx;
    String sHy;
    OnClickListener sHz;

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fmM = (MMActivity) context;
    }

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sHz = null;
        this.sHA = null;
        this.fmM = (MMActivity) context;
        setLayoutResource(g.uFL);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        x.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
        this.jQj = (TextView) view.findViewById(f.cuM);
        this.sHv = (TextView) view.findViewById(f.caP);
        this.sHw = (TextView) view.findViewById(f.ujz);
        this.kmC = (TextView) view.findViewById(f.uAe);
        au();
        if (!(this.sHw == null || this.sHz == null)) {
            this.sHw.setOnClickListener(this.sHz);
        }
        if (this.kmC != null && this.sHA != null) {
            this.kmC.setOnClickListener(this.sHA);
        }
    }

    final void au() {
        if (!(bh.ov(this.mkE) || this.jQj == null)) {
            this.jQj.setText(this.mkE);
            this.jQj.setVisibility(0);
        }
        if (!(bh.ov(this.sHx) || this.sHv == null)) {
            this.sHv.setText(this.sHx);
            this.sHv.setVisibility(0);
        }
        if (!(bh.ov(this.sHy) || this.sHw == null)) {
            this.sHw.setText(this.sHy);
            this.sHw.setVisibility(0);
        }
        if (bh.ov(this.sHy) && this.sHw != null) {
            this.sHw.setVisibility(8);
        }
    }
}
