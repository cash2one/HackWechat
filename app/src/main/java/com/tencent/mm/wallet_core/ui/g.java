package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$j;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;

public final class g extends s {
    private View Iv = null;
    private ProgressBar jVF;
    private Context mContext;
    private TextView xHZ;

    private g(Context context, int i) {
        super(context, i);
        this.mContext = context;
        if (this.Iv == null) {
            this.Iv = View.inflate(this.mContext, com.tencent.mm.plugin.wxpay.a.g.uFG, null);
            this.xHZ = (TextView) this.Iv.findViewById(f.cwq);
            this.jVF = (ProgressBar) this.Iv.findViewById(f.cwp);
            setCanceledOnTouchOutside(true);
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.Iv, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().addFlags(2);
        attributes.dimAmount = 0.65f;
        onWindowAttributesChanged(attributes);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public final void setMessage(CharSequence charSequence) {
        this.xHZ.setText(charSequence);
    }

    public static Dialog a(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener) {
        Dialog gVar = new g(context, a$j.eYV);
        gVar.setMessage(charSequence);
        gVar.setCancelable(z);
        gVar.setOnCancelListener(onCancelListener);
        gVar.setCanceledOnTouchOutside(false);
        gVar.show();
        return gVar;
    }

    public static Dialog b(Context context, String str, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, com.tencent.mm.plugin.wxpay.a.g.uFH, null);
        ((TextView) inflate.findViewById(f.ujA)).setText(str);
        Dialog kVar = new k(context, a$j.uYB);
        kVar.setCancelable(false);
        kVar.setContentView(inflate);
        kVar.setOnCancelListener(onCancelListener);
        kVar.show();
        return kVar;
    }

    public static Dialog a(Context context, boolean z, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, com.tencent.mm.plugin.wxpay.a.g.uFH, null);
        Dialog kVar = new k(context, a$j.uYB);
        kVar.setCancelable(z);
        kVar.setContentView(inflate);
        kVar.setOnCancelListener(onCancelListener);
        kVar.show();
        return kVar;
    }

    public static Dialog e(Context context, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, com.tencent.mm.plugin.wxpay.a.g.uFH, null);
        Dialog kVar = new k(context, a$j.uYB);
        kVar.setCancelable(true);
        kVar.setContentView(inflate);
        kVar.setCanceledOnTouchOutside(false);
        kVar.setOnCancelListener(onCancelListener);
        kVar.show();
        return kVar;
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
