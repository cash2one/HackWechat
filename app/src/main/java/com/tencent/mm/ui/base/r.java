package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.l;

public class r extends s {
    private View Iv;
    public ProgressBar jVF;
    private Context mContext;
    private int style;
    private TextView xHZ;

    public r(Context context, int i, int i2) {
        int i3;
        super(context, i);
        this.mContext = context;
        this.style = i2;
        switch (this.style) {
            case 0:
                i3 = h.gXV;
                break;
            case 1:
                i3 = h.gXW;
                break;
            case 2:
                i3 = h.gXV;
                break;
            default:
                i3 = h.gXV;
                break;
        }
        this.Iv = v.fv(this.mContext).inflate(i3, null);
        this.xHZ = (TextView) this.Iv.findViewById(g.cwq);
        this.jVF = (ProgressBar) this.Iv.findViewById(g.cwp);
        setCanceledOnTouchOutside(true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.Iv, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        if (this.style == 2) {
            getWindow().addFlags(2);
            attributes.dimAmount = 0.65f;
        }
        onWindowAttributesChanged(attributes);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public void setMessage(CharSequence charSequence) {
        this.xHZ.setText(charSequence);
    }

    public static r a(Context context, CharSequence charSequence, boolean z, int i, OnCancelListener onCancelListener) {
        int i2;
        switch (i) {
            case 0:
                i2 = l.eYV;
                break;
            case 1:
                i2 = l.eYV;
                break;
            case 2:
                i2 = l.eYV;
                break;
            default:
                i2 = l.gYQ;
                break;
        }
        r rVar = new r(context, i2, i);
        rVar.setMessage(charSequence);
        rVar.setCancelable(z);
        rVar.setOnCancelListener(onCancelListener);
        rVar.setCanceledOnTouchOutside(false);
        return rVar;
    }

    public static r b(Context context, CharSequence charSequence, boolean z, int i, OnCancelListener onCancelListener) {
        r a = a(context, charSequence, z, i, onCancelListener);
        a.show();
        return a;
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMProgressDialog", e, "", new Object[0]);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
