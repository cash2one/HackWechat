package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.e;

public final class b extends k implements OnClickListener {
    private int irz;
    protected View kND;
    private OnClickListener pOr;

    private b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        super(context, j.uYC);
        this.irz = 0;
        int i = g.uEb;
        if (i > 0) {
            this.kND = View.inflate(context, i, null);
        }
        setContentView(this.kND);
        ((Button) this.kND.findViewById(a$f.bPo)).setOnClickListener(this);
        ((Button) this.kND.findViewById(a$f.ukT)).setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (view.getId() != a$f.cBC) {
            x.i("RemittanceChargeDialog", "click cancel");
            dismiss();
        }
        if (view.getId() != a$f.bPo) {
            return;
        }
        if (this.irz == 1) {
            com.tencent.mm.plugin.report.service.g.pQN.h(12689, Integer.valueOf(11), Integer.valueOf(1));
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(12689, Integer.valueOf(2), Integer.valueOf(1));
    }

    public static void a(Context context, int i, String str, double d) {
        x.i("RemittanceChargeDialog", "showAlert");
        Dialog bVar = new b(context);
        bVar.irz = i;
        x.i("RemittanceChargeDialog", "showTips");
        TextView textView = (TextView) bVar.findViewById(a$f.uvO);
        if (bh.ov(str)) {
            x.e("RemittanceChargeDialog", "desc is null");
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        ((TextView) bVar.findViewById(a$f.ukV)).setText(context.getResources().getString(i.uNS, new Object[]{e.u(d)}));
        bVar.findViewById(a$f.uxd).setVisibility(0);
        bVar.findViewById(a$f.ukW).setVisibility(0);
        bVar.show();
        h.a(context, bVar);
    }

    public static b a(Context context, int i, double d, double d2, double d3, String str, OnClickListener onClickListener) {
        x.i("RemittanceChargeDialog", "showCostDetail");
        Dialog bVar = new b(context);
        bVar.irz = i;
        if (d == 0.0d) {
            x.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
        }
        ((TextView) bVar.findViewById(a$f.uwj)).setText(e.u(d));
        ((TextView) bVar.findViewById(a$f.uka)).setText(e.u(d2));
        if (d3 == 0.0d) {
            x.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
        }
        ((TextView) bVar.findViewById(a$f.uxm)).setText(e.u(d3));
        bVar.findViewById(a$f.uvD).setVisibility(0);
        if (!bh.ov(str)) {
            TextView textView = (TextView) bVar.findViewById(a$f.uvO);
            textView.setText(str);
            textView.setVisibility(0);
        }
        bVar.findViewById(a$f.uxf).setVisibility(0);
        bVar.pOr = onClickListener;
        bVar.findViewById(a$f.cBC).setOnClickListener(new 1(bVar));
        bVar.show();
        h.a(context, bVar);
        if (i == 1) {
            com.tencent.mm.plugin.report.service.g.pQN.h(12689, Integer.valueOf(10), Integer.valueOf(1));
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(12689, Integer.valueOf(1), Integer.valueOf(1));
        }
        return bVar;
    }
}
