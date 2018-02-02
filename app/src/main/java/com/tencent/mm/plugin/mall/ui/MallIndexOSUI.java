package com.tencent.mm.plugin.mall.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.mall.a.c;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bwx;
import com.tencent.mm.protocal.c.bwy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

public class MallIndexOSUI extends MallIndexBaseUI {
    private boolean joQ = false;
    private long lastUpdateTime = 0;
    private a[] omi = new a[4];
    private ac omj = new ac();
    private TextView omk = null;
    private View oml = null;
    private boolean omm = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oml = View.inflate(this, g.uCM, null);
        this.oml.setClickable(false);
        this.oml.setEnabled(false);
        this.omk = (TextView) this.oml.findViewById(a$f.uAc);
        this.omj = o.bLw().zm(this.okQ);
        ji(1577);
        x.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
        k cVar = new c();
        if (this.omj != null) {
            ac acVar = this.omj;
            boolean z = acVar.sPN == null || acVar.sPN.wiJ == null || acVar.sPN.wiJ.size() == 0;
            if (!z) {
                b(cVar, false);
                return;
            }
        }
        r(cVar);
    }

    protected final void aYl() {
        e.a(this.olW, "1", this.omj.sPS, this.omj.odh);
    }

    public final void a(MallFunction mallFunction, int i) {
        super.a(mallFunction, i);
        com.tencent.mm.plugin.report.service.g.pQN.h(13720, mallFunction.nvp, Long.valueOf(bh.VJ(mallFunction.pBK)));
    }

    protected final void aYc() {
        String str = this.omj.sPQ;
        String str2 = this.omj.sPR;
        setMMTitle(str);
        setMMSubTitle(str2);
    }

    protected final void cp(View view) {
        this.omi[0] = new a(this);
        this.omi[0].view = view.findViewById(a$f.urY);
        this.omi[0].old = (CdnImageView) view.findViewById(a$f.urZ);
        this.omi[0].lbS = (TextView) view.findViewById(a$f.usb);
        this.omi[0].oms = (TextView) view.findViewById(a$f.ukb);
        this.omi[0].old.setVisibility(4);
        this.omi[1] = new a(this);
        this.omi[1].view = view.findViewById(a$f.ueJ);
        this.omi[1].old = (CdnImageView) view.findViewById(a$f.ueS);
        this.omi[1].lbS = (TextView) view.findViewById(a$f.ueV);
        this.omi[1].oms = (TextView) view.findViewById(a$f.ueR);
        this.omi[1].old.setVisibility(4);
        this.omi[2] = new a(this);
        this.omi[2].view = view.findViewById(a$f.ufc);
        this.omi[2].old = (CdnImageView) view.findViewById(a$f.uft);
        this.omi[2].lbS = (TextView) view.findViewById(a$f.ufw);
        this.omi[2].oms = (TextView) view.findViewById(a$f.ukc);
        this.omi[2].old.setVisibility(4);
        this.omi[3] = new a(this);
        this.omi[3].view = view.findViewById(a$f.ulV);
        this.omi[3].old = (CdnImageView) view.findViewById(a$f.ump);
        this.omi[3].lbS = (TextView) view.findViewById(a$f.umB);
        this.omi[3].old.setVisibility(4);
        this.omi[3].view.setVisibility(8);
    }

    protected final void aYd() {
    }

    protected final void aYe() {
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", Integer.valueOf(com.tencent.mm.k.g.zY().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000), Long.valueOf(this.lastUpdateTime), Long.valueOf(System.currentTimeMillis()));
        if (System.currentTimeMillis() - this.lastUpdateTime >= ((long) (com.tencent.mm.k.g.zY().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000))) {
            this.lastUpdateTime = System.currentTimeMillis();
            b(new c(), false);
        }
        aYc();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1577);
    }

    protected final boolean aYg() {
        bwx com_tencent_mm_protocal_c_bwx = this.omj.sPN;
        for (int i = 0; i < this.omi.length; i++) {
            this.omi[i].view.setVisibility(8);
            this.omi[i].old.setImageBitmap(null);
        }
        int i2 = 0;
        while (i2 < com_tencent_mm_protocal_c_bwx.wiJ.size() && i2 < this.omi.length) {
            bwy com_tencent_mm_protocal_c_bwy = (bwy) com_tencent_mm_protocal_c_bwx.wiJ.get(i2);
            this.omi[i2].view.setVisibility(0);
            this.omi[i2].old.setUrl(n.a(com_tencent_mm_protocal_c_bwy.wXM));
            this.omi[i2].old.setVisibility(0);
            this.omi[i2].lbS.setText(n.a(com_tencent_mm_protocal_c_bwy.wXL));
            x.i("MicroMsg.MallIndexOSUI", "item %d url %s", Integer.valueOf(i2), n.a(com_tencent_mm_protocal_c_bwy.wXM));
            this.omi[i2].oms.setVisibility(8);
            CharSequence a = n.a(com_tencent_mm_protocal_c_bwy.wXO);
            if (!bh.ov(a)) {
                this.omi[i2].oms.setText(a);
                this.omi[i2].oms.setVisibility(0);
            }
            this.omi[i2].view.setOnClickListener(new 1(this, com_tencent_mm_protocal_c_bwy));
            i2++;
        }
        if (!(this.olR == null || this.oml == null || this.omm)) {
            this.olR.addFooterView(this.oml);
            this.omm = true;
        }
        if (!bh.ov(this.omj.sPT)) {
            this.omk.setText(this.omj.sPT);
            this.omk.setVisibility(0);
        }
        return true;
    }

    protected final void aYm() {
    }

    protected final void aYo() {
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, a.e.bDI, new 2(this));
    }

    protected final void aYp() {
    }

    public void finish() {
        this.joQ = true;
        super.finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        super.d(i, i2, str, kVar);
        if (kVar.getType() == 1577) {
            this.omj = o.bLw().zm(this.okQ);
            aYl();
            aYg();
            aYc();
        }
        return true;
    }
}
