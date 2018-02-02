package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.bv.a;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

public final class n extends b {
    private boolean hEW = false;
    TextView iiq;
    private TextView iir;
    private ProgressDialog iln = null;
    private ImageView jCP;
    View kpZ = null;
    private TextView rYg;
    int sfj = 0;
    private TextView zbi;
    private TextView zbj;
    private ImageView zbk;
    private ImageView zbl;
    private ImageView zbm;
    private ProgressBar zbn;
    String zbo;
    private boolean zbp = false;
    int zbq;
    boolean zbr;
    boolean zbs;
    boolean zbt;
    String zbu;
    ak zbv;
    c<kc> zbw;
    boolean zbx = false;

    static /* synthetic */ void a(n nVar, int i) {
        Intent intent = new Intent();
        intent.putExtra("diagnose_state", i);
        intent.putExtra("diagnose_percent", nVar.zbq);
        intent.putExtra("diagnose_kvInfo", nVar.zbu);
        x.i("MicroMsg.NetWarnView", "put state: %d, process: %d, kv: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(nVar.zbq), nVar.zbu});
        d.b((Context) nVar.voC.get(), "traceroute", ".ui.NetworkDiagnoseAllInOneUI", intent);
    }

    public n(Context context) {
        super(context);
        initialize();
    }

    public final int getLayoutId() {
        return R.i.doP;
    }

    private void initialize() {
        if (!this.zbp && this.view != null) {
            this.kpZ = this.view.findViewById(R.h.cBx);
            this.iiq = (TextView) this.view.findViewById(R.h.cBs);
            this.iir = (TextView) this.view.findViewById(R.h.cBt);
            this.rYg = (TextView) this.view.findViewById(R.h.cBu);
            this.zbi = (TextView) this.view.findViewById(R.h.cBr);
            this.zbn = (ProgressBar) this.view.findViewById(R.h.cBw);
            this.jCP = (ImageView) this.view.findViewById(R.h.cBv);
            this.zbk = (ImageView) this.view.findViewById(R.h.bWl);
            this.zbl = (ImageView) this.view.findViewById(R.h.cjc);
            this.zbm = (ImageView) this.view.findViewById(R.h.cOy);
            this.zbj = (TextView) this.view.findViewById(R.h.cep);
            this.zbk.setVisibility(8);
            this.zbp = true;
        }
    }

    final void cwR() {
        if (this.zbv != null) {
            this.zbv.TG();
            this.zbv = null;
        }
    }

    public final boolean alg() {
        boolean z;
        int i = 0;
        int Km = ar.CG().Km();
        String networkServerIp = ar.CG().getNetworkServerIp();
        this.zbo = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.vAz), com.tencent.mm.protocal.d.DEVICE_TYPE, q.FS(), networkServerIp, w.cfi()});
        initialize();
        x.i("MicroMsg.NetWarnView", "update st:%d", new Object[]{Integer.valueOf(Km)});
        switch (Km) {
            case 0:
                this.iiq.setText(R.l.exE);
                this.iir.setVisibility(8);
                this.zbi.setVisibility(8);
                this.zbn.setVisibility(8);
                this.jCP.setVisibility(0);
                this.kpZ.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ n zby;

                    {
                        this.zby = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("title", ((Context) this.zby.voC.get()).getString(R.l.exE));
                        intent.putExtra("rawUrl", ((Context) this.zby.voC.get()).getString(R.l.exB));
                        intent.putExtra("showShare", false);
                        d.b((Context) this.zby.voC.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
                z = true;
                break;
            case 2:
                if (this.sfj == 1) {
                    this.iiq.setText(((Context) this.voC.get()).getResources().getString(R.l.exD, new Object[]{Integer.valueOf(this.zbq)}));
                } else {
                    this.iiq.setText(R.l.exC);
                }
                this.iir.setVisibility(8);
                this.zbi.setVisibility(8);
                this.zbn.setVisibility(8);
                this.jCP.setVisibility(0);
                this.kpZ.setOnClickListener(new 4(this));
                z = true;
                break;
            case 3:
                this.iiq.setText(R.l.exA);
                this.iir.setVisibility(8);
                this.zbi.setVisibility(8);
                this.zbn.setVisibility(0);
                this.jCP.setVisibility(0);
                z = true;
                break;
            case 5:
                this.iiq.setText(R.l.exF);
                this.iir.setText(((Context) this.voC.get()).getString(R.l.exG));
                this.iir.setVisibility(0);
                this.zbi.setVisibility(8);
                this.zbn.setVisibility(8);
                this.jCP.setVisibility(0);
                this.kpZ.setOnClickListener(new 5(this));
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.rYg.setVisibility(8);
            this.iiq.setVisibility(0);
            this.kpZ.setBackgroundResource(R.g.bGS);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jCP.getLayoutParams());
            layoutParams.setMargins(a.fromDPToPix((Context) this.voC.get(), 10), 0, a.fromDPToPix((Context) this.voC.get(), 4), 0);
            this.jCP.setLayoutParams(layoutParams);
            this.jCP.setImageResource(R.k.dBi);
            this.zbl.setVisibility(8);
            this.zbm.setVisibility(8);
            this.zbj.setVisibility(8);
        } else {
            ar.Hg();
            if (com.tencent.mm.z.c.ET()) {
                ar.Hg();
                if (com.tencent.mm.modelsimple.q.ir(com.tencent.mm.z.c.EU())) {
                    com.tencent.mm.ae.n CG = ar.CG();
                    ar.Hg();
                    CG.a(new com.tencent.mm.modelsimple.q(com.tencent.mm.z.c.EU()), 0);
                }
            }
            ar.Hg();
            if (!(!com.tencent.mm.z.c.ET() || t.ov(com.tencent.mm.modelsimple.q.hNg) || com.tencent.mm.modelsimple.q.RR())) {
                this.kpZ.setBackgroundResource(R.g.bGT);
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.jCP.getLayoutParams());
                layoutParams2.setMargins(a.fromDPToPix((Context) this.voC.get(), 22), 0, a.fromDPToPix((Context) this.voC.get(), 20), 0);
                this.jCP.setLayoutParams(layoutParams2);
                this.iiq.setVisibility(8);
                this.iir.setVisibility(8);
                this.rYg.setVisibility(0);
                if (q.gL(q.FY())) {
                    if (com.tencent.mm.modelsimple.q.RU() || !com.tencent.mm.modelsimple.q.RS()) {
                        this.rYg.setText(com.tencent.mm.modelsimple.q.hNg);
                    } else {
                        this.rYg.setText(com.tencent.mm.modelsimple.q.hNn);
                    }
                } else if (com.tencent.mm.modelsimple.q.RU() || !com.tencent.mm.modelsimple.q.RS()) {
                    this.rYg.setText(com.tencent.mm.modelsimple.q.hNj);
                } else {
                    this.rYg.setText(com.tencent.mm.modelsimple.q.hNo);
                }
                this.zbi.setVisibility(8);
                this.zbn.setVisibility(8);
                this.jCP.setPadding(0, 0, 0, 0);
                if (com.tencent.mm.modelsimple.q.RQ() == 1) {
                    this.jCP.setImageResource(R.k.dyi);
                } else if (com.tencent.mm.modelsimple.q.RQ() == 2) {
                    if (com.tencent.mm.modelsimple.q.RS()) {
                        this.jCP.setImageResource(R.k.dyh);
                    } else {
                        this.jCP.setImageResource(R.k.dyg);
                    }
                } else if (com.tencent.mm.modelsimple.q.RQ() == 3) {
                    this.jCP.setImageResource(R.k.dyf);
                } else {
                    this.jCP.setImageResource(R.k.dBe);
                }
                this.jCP.setVisibility(0);
                this.zbl.setVisibility(8);
                this.zbm.setVisibility(8);
                TextView textView = this.zbj;
                if (q.gL(q.FY())) {
                    Km = 8;
                } else {
                    Km = 0;
                }
                textView.setVisibility(Km);
                Intent intent = new Intent();
                intent.putExtra("intent.key.online_version", com.tencent.mm.modelsimple.q.RT());
                this.kpZ.setOnClickListener(new 6(this, intent));
                z = true;
            }
        }
        if (!z) {
            this.zbk.setVisibility(8);
            if (r.icN) {
                boolean z2;
                int backgroundLimitType = an.getBackgroundLimitType((Context) this.voC.get());
                if (!an.isLimited(backgroundLimitType) || this.zbx) {
                    this.zbk.setVisibility(8);
                    z2 = z;
                } else {
                    this.iiq.setText(((Context) this.voC.get()).getString(R.l.eBd));
                    this.iir.setText(((Context) this.voC.get()).getString(R.l.eBc));
                    this.iir.setVisibility(0);
                    this.zbi.setVisibility(8);
                    this.zbn.setVisibility(8);
                    this.jCP.setVisibility(0);
                    this.zbk.setVisibility(0);
                    this.kpZ.setOnClickListener(new 7(this, backgroundLimitType));
                    this.zbk.setOnClickListener(new 8(this, backgroundLimitType));
                    z2 = true;
                }
                z = z2;
            }
        }
        this.zbm.setImageResource(R.k.dxn);
        this.zbk.setImageResource(R.g.bzF);
        View view = this.kpZ;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        return z;
    }

    public final void destroy() {
        cwR();
        if (this.zbw != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.zbw);
        }
    }

    public final void setVisibility(int i) {
        if (this.kpZ != null) {
            this.kpZ.setVisibility(i);
        }
    }

    public final int getOrder() {
        return 2;
    }
}
