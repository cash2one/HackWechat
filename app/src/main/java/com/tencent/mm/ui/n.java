package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.l;

final class n extends Dialog implements DialogInterface {
    private View jVx = this.xHY.findViewById(g.gVN);
    private TextView lVg = ((TextView) this.xHY.findViewById(g.gVM));
    private Context mContext;
    private boolean qoX;
    Button sVn = ((Button) this.xHY.findViewById(g.cwl));
    private LinearLayout xHY = ((LinearLayout) v.fv(this.mContext).inflate(h.gXp, null));
    TextView xHZ = ((TextView) this.xHY.findViewById(g.cwf));
    private TextView xIa = ((TextView) this.xHY.findViewById(g.gVL));
    LinearLayout xIb = ((LinearLayout) this.xHY.findViewById(g.cwg));
    private LinearLayout xIc = ((LinearLayout) this.xHY.findViewById(g.gVK));

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ DialogInterface.OnClickListener xId;
        final /* synthetic */ boolean xIe = true;
        final /* synthetic */ n xIf;

        AnonymousClass1(n nVar, DialogInterface.OnClickListener onClickListener, boolean z) {
            this.xIf = nVar;
            this.xId = onClickListener;
        }

        public final void onClick(View view) {
            if (this.xId != null) {
                this.xId.onClick(this.xIf, -1);
            }
            if (this.xIe) {
                this.xIf.dismiss();
            }
        }
    }

    public n(Context context) {
        super(context, l.eYV);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.xHY);
    }

    public final void setTitle(CharSequence charSequence) {
        this.jVx.setVisibility(0);
        this.lVg.setVisibility(0);
        this.lVg.setMaxLines(2);
        this.lVg.setText(charSequence);
        DO(d.gUw);
    }

    public final void setTitle(int i) {
        this.jVx.setVisibility(0);
        this.lVg.setVisibility(0);
        this.lVg.setMaxLines(2);
        this.lVg.setText(i);
        DO(d.gUw);
    }

    private void DO(int i) {
        if (this.xHZ != null) {
            this.xHZ.setTextColor(this.xHZ.getContext().getResources().getColor(i));
        }
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.qoX = z;
        setCanceledOnTouchOutside(this.qoX);
    }

    public final void cmN() {
        super.setCancelable(true);
    }

    public final void show() {
        try {
            super.show();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LiteDependDialog", e, "", new Object[0]);
        }
    }

    public final void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ag.y(new Runnable(this) {
                final /* synthetic */ n xIf;

                {
                    this.xIf = r1;
                }

                public final void run() {
                    this.xIf.dismiss();
                }
            });
            x.e("MicroMsg.LiteDependDialog", bh.cgy().toString());
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
