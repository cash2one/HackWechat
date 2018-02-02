package com.tencent.mm.ui.bindqq;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.af;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.modelfriend.ac;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class StartUnbindQQ extends MMWizardActivity implements e {
    private i qiD;
    private String qjT = null;
    private r tipDialog;
    private View ymO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(253, (e) this);
        this.qjT = getIntent().getStringExtra("notice");
    }

    public void onDestroy() {
        ar.CG().b(253, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dsR;
    }

    protected final void initView() {
        setMMTitle(R.l.eRF);
        this.ymO = findViewById(R.h.cMd);
        setBackBtn(new 1(this));
        this.ymO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StartUnbindQQ ymP;

            {
                this.ymP = r1;
            }

            public final void onClick(View view) {
                if (this.ymP.qiD == null) {
                    this.ymP.qiD = h.a(this.ymP, this.ymP.getString(R.l.eKC), null, new 1(this), new 2(this));
                } else {
                    this.ymP.qiD.show();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (kVar.getType() == 253) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0) {
                ar.Hg();
                int a = bh.a((Integer) c.CU().get(9, null), 0);
                x.d("MicroMsg.StartUnbindQQ", "iBindUin " + a);
                if (a != 0) {
                    ar.Hg();
                    c.Fg().jL(new o(a) + "@qqim");
                }
                ar.Hg();
                Object obj = c.CU().get(102407, null);
                if (obj != null && ((String) obj).length() > 0) {
                    ar.Hg();
                    c.CU().set(102407, null);
                }
                try {
                    a.xef.m(new af());
                    ar.Hg();
                    String str2 = new o(bh.a((Integer) c.CU().get(9, null), 0)) + "@qqim";
                    ar.Hg();
                    c.Fg().jL(str2);
                    ar.Hg();
                    c.EY().WU(str2);
                    n.JQ().jn(str2);
                    String str3 = q.FS() + "@qqim";
                    n.JQ().jn(str3);
                    n.Jz();
                    d.y(str2, false);
                    n.Jz();
                    d.y(str2, true);
                    n.Jz();
                    d.y(str3, false);
                    n.Jz();
                    d.y(str3, true);
                    ac OG = com.tencent.mm.modelfriend.af.OG();
                    x.d("MicroMsg.QQGroupStorage", "delete all");
                    if (OG.hhp.delete("qqgroup", null, null) > 0) {
                        OG.doNotify();
                    }
                    com.tencent.mm.plugin.c.a.ift.um();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                    x.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                }
                ar.Hg();
                c.CU().set(9, Integer.valueOf(0));
                b saVar = new sa();
                saVar.fJK.fJL = false;
                saVar.fJK.fJM = true;
                a.xef.m(saVar);
                if (bh.ov(this.qjT)) {
                    DU(1);
                } else {
                    h.a(this, this.qjT, "", getString(R.l.dBP), new 3(this));
                }
            }
            com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
            if (eA != null) {
                eA.a(this, null, null);
            }
        }
    }
}
