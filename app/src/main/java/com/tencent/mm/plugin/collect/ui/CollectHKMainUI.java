package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.z.q;

public class CollectHKMainUI extends CollectMainUI {
    private boolean lme = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lmZ.setVisibility(8);
        findViewById(f.uiv).setVisibility(0);
        findViewById(f.uiN).setVisibility(8);
        cCh().ji(1335);
        addIconOptionMenu(0, e.udW, new 1(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        cCh().jj(1335);
    }

    protected final void azo() {
        g.Dk();
        this.lmB = (String) g.Dj().CU().get(a.xvt, "");
        k mVar = new m(q.FZ());
        if (bh.ov(this.lmB)) {
            x.i("MicroMsg.CollectHKMainUI", "force load payurl");
            this.lme = true;
            cCh().a(mVar, true, 1);
            return;
        }
        cCh().a(mVar, false, 1);
    }

    protected final String azp() {
        return this.lmC;
    }

    protected final String azq() {
        if (bh.ov(this.lmD)) {
            this.lmD = u.cBD();
        }
        return this.lmD;
    }

    public final boolean g(int i, int i2, String str, k kVar) {
        if (kVar instanceof m) {
            m mVar = (m) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[]{kVar});
            } else if (mVar.liH == 0) {
                this.lmB = mVar.liJ;
                this.lmC = mVar.liV;
                this.lmD = mVar.liS;
                amg();
                if (bh.ov(mVar.liP)) {
                    this.lmZ.setVisibility(8);
                } else {
                    this.lmW.setText(mVar.liP);
                    this.lmZ.setOnClickListener(new 2(this, mVar));
                    this.lmZ.setVisibility(0);
                }
                if (bh.ov(mVar.liT)) {
                    this.lmy.setVisibility(8);
                } else {
                    this.lmy.setText(mVar.liT);
                    this.lmy.setOnClickListener(new 3(this, mVar));
                    this.lmy.setVisibility(0);
                }
                return true;
            }
            if (!this.lme) {
                return true;
            }
        }
        return false;
    }

    protected final void azr() {
        ImageView imageView = (ImageView) this.lkr.findViewById(f.uiK);
        ImageView imageView2 = (ImageView) this.lkr.findViewById(f.uiB);
        LayoutParams layoutParams = (LayoutParams) imageView2.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.addRule(13);
        imageView2.setLayoutParams(layoutParams);
        if (w.cfi().equals("zh_HK")) {
            imageView.setImageResource(a$h.uGw);
            imageView2.setImageResource(a$h.uGs);
            return;
        }
        imageView.setImageResource(a$h.uGv);
        imageView2.setImageResource(a$h.uGr);
    }

    protected final void azs() {
        super.azs();
        if (this.lmJ) {
            findViewById(f.uiv).setVisibility(8);
        } else {
            findViewById(f.uiv).setVisibility(0);
        }
    }
}
