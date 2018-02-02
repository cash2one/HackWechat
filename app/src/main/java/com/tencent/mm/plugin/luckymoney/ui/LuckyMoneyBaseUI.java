package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.ui.j.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.d;

public abstract class LuckyMoneyBaseUI extends MMActivity implements d {
    public i ogp = null;
    private j ogq = null;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ogp = new i(this, this);
        this.ogp.ji(1554);
        this.ogp.ji(1575);
        this.ogp.ji(1668);
        this.ogp.ji(1581);
        this.ogp.ji(1685);
        this.ogp.ji(1585);
        this.ogp.ji(1514);
        this.ogp.ji(1682);
        this.ogp.ji(1612);
        this.ogp.ji(1643);
        this.ogp.ji(1558);
        this.ogq = new j(this);
        this.ogq.okn = 1;
        j jVar = this.ogq;
        a G = j.G(jVar.iqt, jVar.okn);
        if (jVar.iqt.getSupportActionBar() != null) {
            if (G.okp != null) {
                jVar.iqt.getSupportActionBar().setBackgroundDrawable(G.okp);
            }
            View customView = jVar.iqt.getSupportActionBar().getCustomView();
            if (customView != null) {
                View findViewById = customView.findViewById(f.divider);
                if (!(findViewById == null || G.kdK == 0)) {
                    findViewById.setBackgroundColor(G.kdK);
                }
                TextView textView = (TextView) customView.findViewById(16908308);
                if (!(textView == null || G.okq == 0)) {
                    textView.setTextColor(G.okq);
                }
                textView = (TextView) customView.findViewById(16908309);
                if (!(textView == null || G.okr == 0)) {
                    textView.setTextColor(G.okr);
                }
                ImageView imageView = (ImageView) customView.findViewById(f.bIW);
                if (!(imageView == null || G.oks == 0)) {
                    imageView.setImageResource(G.oks);
                }
            }
            if (G.okt != 0) {
                jVar.sm(G.okt);
            }
        }
        getLayoutId();
    }

    public final void r(Drawable drawable) {
        j jVar = this.ogq;
        if (jVar.iqt.getSupportActionBar() != null) {
            jVar.iqt.getSupportActionBar().setBackgroundDrawable(drawable);
        }
    }

    public final void aXy() {
        j jVar = this.ogq;
        if (jVar.iqt.getSupportActionBar() != null) {
            jVar.iqt.getSupportActionBar().show();
        }
        jVar = this.ogq;
        a G = j.G(jVar.iqt, jVar.okn);
        if (G.okt != 0) {
            jVar.sm(G.okt);
        }
    }

    public final void aXz() {
        j jVar = this.ogq;
        if (jVar.iqt.getSupportActionBar() != null) {
            jVar.iqt.getSupportActionBar().hide();
        }
        jVar = this.ogq;
        jVar.sm(jVar.oko);
    }

    public void onDestroy() {
        this.ogp.jj(1554);
        this.ogp.jj(1575);
        this.ogp.jj(1668);
        this.ogp.jj(1581);
        this.ogp.jj(1685);
        this.ogp.jj(1585);
        this.ogp.jj(1514);
        this.ogp.jj(1682);
        this.ogp.jj(1612);
        this.ogp.jj(1643);
        this.ogp.jj(1558);
        this.ogq = null;
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ogp.aXd()) {
                this.ogp.aXc();
            }
            if (this.mController.contentView.getVisibility() == 8 || this.mController.contentView.getVisibility() == 4) {
                finish();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (!d(i, i2, str, kVar)) {
            if (i != 0 || i2 != 0) {
                h.bu(this, str);
                finish();
            }
        }
    }

    public final void ji(int i) {
        this.ogp.ji(i);
    }

    public final void jj(int i) {
        this.ogp.jj(i);
    }

    public final void b(k kVar, boolean z) {
        this.ogp.b(kVar, z);
    }

    public final void l(k kVar) {
        this.ogp.b(kVar, true);
    }
}
