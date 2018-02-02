package com.tencent.mm.ui.d;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class a extends b {
    String mUrl = null;
    private String nMi = null;
    private boolean xWD = false;
    private com.tencent.mm.z.b.b.b xWE = null;
    private String xWF = "";

    public a(Context context, com.tencent.mm.z.b.b.b bVar) {
        super(context);
        this.xWE = bVar;
        refresh();
    }

    public final int getLayoutId() {
        return R.i.den;
    }

    private void refresh() {
        ar.Hg().FH();
        if (com.tencent.mm.z.b.b.a(this.xWE)) {
            x.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[]{this.xWE, this.nMi, this.mUrl, Boolean.valueOf(this.xWD)});
            if (this.xWE == com.tencent.mm.z.b.b.b.his) {
                ar.Hg().FH();
                this.nMi = com.tencent.mm.z.b.b.Ip();
                ar.Hg().FH();
                this.mUrl = com.tencent.mm.z.b.b.Iq();
                ar.Hg().FH();
                this.xWD = com.tencent.mm.z.b.b.Ir();
            } else {
                ar.Hg().FH();
                this.nMi = com.tencent.mm.z.b.b.Im();
                ar.Hg().FH();
                this.mUrl = com.tencent.mm.z.b.b.In();
                ar.Hg().FH();
                this.xWD = com.tencent.mm.z.b.b.Io();
            }
            TextView textView = (TextView) getView().findViewById(R.h.bUG);
            ImageView imageView = (ImageView) getView().findViewById(R.h.bWl);
            if (bh.ov(this.nMi)) {
                textView.setText(R.l.dHc);
            } else {
                textView.setText(this.nMi);
            }
            textView.setSelected(true);
            if (bh.ov(this.mUrl)) {
                getView().findViewById(R.h.cxf).setBackgroundResource(R.e.btX);
                imageView.setImageResource(R.g.bDM);
                textView.setTextColor(ac.getContext().getResources().getColor(R.e.white));
            } else {
                getView().findViewById(R.h.cxf).setBackgroundResource(R.g.bGT);
                imageView.setImageResource(R.g.bDN);
                textView.setTextColor(ac.getContext().getResources().getColor(R.e.btY));
            }
            getView().setOnClickListener(new 1(this));
            if (getView().getVisibility() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                g.Dh();
                this.xWF = stringBuilder.append(com.tencent.mm.kernel.a.Cg()).append("_").append(System.currentTimeMillis()).toString();
                Ek(0);
            }
            setVisibility(0);
            if (this.xWD) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new 2(this));
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        x.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
        setVisibility(8);
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
        getView().findViewById(R.h.cxf).setVisibility(i);
    }

    public final boolean alg() {
        refresh();
        return super.alg();
    }

    public final void destroy() {
    }

    final void Ek(int i) {
        int i2 = 1;
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = this.xWF;
        objArr[1] = Integer.valueOf(i);
        if (this.xWE == com.tencent.mm.z.b.b.b.hir) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        gVar.h(14439, objArr);
        com.tencent.mm.plugin.report.service.g.pQN.a(633, (long) i, 1, false);
    }
}
