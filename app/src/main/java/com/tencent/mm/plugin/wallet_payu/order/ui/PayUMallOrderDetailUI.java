package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.awj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI extends WalletBaseUI {
    private TextView jCB;
    private String oWp = "";
    private TextView oid;
    private TextView pMD;
    private LinearLayout tcA;
    private LinearLayout tcB;
    private LinearLayout tcC;
    private LinearLayout tcD;
    private LinearLayout tcE;
    private TextView tcF;
    private TextView tcG;
    private TextView tcH;
    private TextView tcI;
    private awj tcx;
    private LinearLayout tcy;
    private LinearLayout tcz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1520);
        this.oWp = this.vf.getString("key_trans_id");
        if (bh.ov(this.oWp)) {
            x.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
            finish();
        }
        l(new c(this.oWp));
        this.tcy = (LinearLayout) findViewById(a$f.ujv);
        this.tcz = (LinearLayout) findViewById(a$f.ujj);
        this.tcA = (LinearLayout) findViewById(a$f.ujm);
        this.tcB = (LinearLayout) findViewById(a$f.ujp);
        this.tcC = (LinearLayout) findViewById(a$f.ujt);
        this.tcD = (LinearLayout) findViewById(a$f.ujr);
        this.tcE = (LinearLayout) findViewById(a$f.ujx);
        this.tcF = (TextView) findViewById(a$f.ujw);
        this.tcG = (TextView) findViewById(a$f.ujk);
        this.tcH = (TextView) findViewById(a$f.ujn);
        this.pMD = (TextView) findViewById(a$f.ujq);
        this.oid = (TextView) findViewById(a$f.uju);
        this.jCB = (TextView) findViewById(a$f.ujs);
        this.tcI = (TextView) findViewById(a$f.ujy);
        bNv();
    }

    private void bNv() {
        if (this.tcx != null) {
            if (bh.ov(this.tcx.pbi)) {
                this.tcy.setVisibility(8);
            } else {
                this.tcy.setVisibility(0);
                this.tcF.setText(this.tcx.pbi);
            }
            if (bh.ov(this.tcx.pbs)) {
                this.tcz.setVisibility(8);
            } else {
                this.tcz.setVisibility(0);
                this.tcG.setText(this.tcx.pbs);
            }
            if (bh.ov(this.tcx.pbk)) {
                this.tcA.setVisibility(8);
            } else {
                this.tcA.setVisibility(0);
                this.tcH.setText(this.tcx.pbk);
            }
            if (bh.ov(this.tcx.pbo)) {
                this.tcB.setVisibility(8);
            } else {
                this.tcB.setVisibility(0);
                this.pMD.setText(e.d(((double) this.tcx.wEa) / 100.0d, this.tcx.pbo));
            }
            if (this.tcx.pbl >= 0) {
                this.tcC.setVisibility(0);
                this.oid.setText(e.HD(this.tcx.pbl));
            } else {
                this.tcC.setVisibility(8);
            }
            if (bh.ov(this.tcx.pbm)) {
                this.tcD.setVisibility(8);
            } else {
                this.tcD.setVisibility(0);
                this.jCB.setText(this.tcx.pbm);
            }
            switch (this.tcx.pbq) {
                case 3:
                    this.tcI.setText(i.uPn);
                    return;
                case 5:
                    this.tcI.setText(i.uSb);
                    return;
                default:
                    this.tcI.setText(i.uVc);
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof c) {
            this.tcx = ((c) kVar).tcw;
            bNv();
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1520);
    }

    protected final int getLayoutId() {
        return g.uDn;
    }
}
