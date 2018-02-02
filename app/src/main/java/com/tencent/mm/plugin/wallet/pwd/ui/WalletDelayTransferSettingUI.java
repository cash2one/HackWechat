package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a$l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.asb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WalletDelayTransferSettingUI extends MMPreference implements e {
    private f ilB;
    private long llS;
    private String mTitle;
    private String pMl;
    private Preference sGB;
    private Preference sGC;
    private Preference sGD;
    private Preference sGE;
    private String sGF;
    private int sGG = 0;

    public void onCreate(Bundle bundle) {
        boolean a;
        super.onCreate(bundle);
        this.ilB = this.yjd;
        this.ilB.addPreferencesFromResource(a$l.vas);
        g.Dk();
        this.llS = ((Long) g.Dj().CU().get(147457, Long.valueOf(0))).longValue();
        initView();
        g.Dk();
        g.Di().gPJ.a(385, this);
        g.Dk();
        this.sGF = (String) g.Dj().CU().get(a.xtp, "");
        g.Dk();
        this.mTitle = (String) g.Dj().CU().get(a.xto, "");
        g.Dk();
        this.pMl = (String) g.Dj().CU().get(a.xtr, "");
        g.Dk();
        this.sGG = ((Integer) g.Dj().CU().get(a.xts, Integer.valueOf(0))).intValue();
        if (bh.ov(this.sGF) || bh.ov(this.mTitle) || bh.ov(this.pMl)) {
            a = ad.a(true, null);
        } else {
            this.sGE.setTitle(this.sGF);
            setMMTitle(this.mTitle);
            bKv();
            a = ad.a(false, null);
        }
        com.tencent.mm.wallet_core.ui.e.cCf();
        if (!a) {
            x.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
            g.Dk();
            g.Di().gPJ.b(385, this);
        }
    }

    private void bKv() {
        if (this.sGG != 1 || bh.ov(this.pMl)) {
            this.mController.removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, a$e.udW, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletDelayTransferSettingUI sGH;

                {
                    this.sGH = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.wallet_core.ui.e.l(this.sGH.mController.xIM, this.sGH.pMl, false);
                    return false;
                }
            });
        }
    }

    protected final void initView() {
        this.sGB = this.ilB.YN("wallet_transfer_realtime");
        this.sGC = this.ilB.YN("wallet_transfer_2h");
        this.sGD = this.ilB.YN("wallet_transfer_24h");
        this.sGE = this.ilB.YN("wallet_transfer_title_tips");
        bKw();
        setBackBtn(new 2(this));
    }

    protected void onDestroy() {
        int i = 1;
        super.onDestroy();
        x.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[]{Long.valueOf(this.llS)});
        if (!uR(16)) {
            i = uR(32) ? 2 : 0;
        }
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_asb = new asb();
        com_tencent_mm_protocal_c_asb.pQk = i;
        ((h) g.h(h.class)).EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, com_tencent_mm_protocal_c_asb));
        g.Dk();
        g.Di().gPJ.b(385, this);
    }

    public final int XB() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if ("wallet_transfer_realtime".equals(str)) {
            this.llS &= -17;
            this.llS &= -33;
        } else if ("wallet_transfer_2h".equals(str)) {
            this.llS &= -33;
            this.llS |= 16;
        } else if ("wallet_transfer_24h".equals(str)) {
            this.llS &= -17;
            this.llS |= 32;
        }
        bKw();
        g.Dk();
        g.Dj().CU().set(147457, Long.valueOf(this.llS));
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof ad) {
            if (i == 0 && i2 == 0) {
                this.sGF = ((ad) kVar).sIU;
                this.mTitle = ((ad) kVar).sIT;
                this.pMl = ((ad) kVar).sIW;
                this.sGG = ((ad) kVar).sIX;
                if (bh.ov(this.sGF)) {
                    x.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
                    this.sGE.setTitle(i.uRq);
                } else {
                    this.sGE.setTitle(this.sGF);
                }
                if (bh.ov(this.mTitle)) {
                    x.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
                    setMMTitle(i.uTX);
                } else {
                    setMMTitle(this.mTitle);
                }
                bKv();
            } else {
                x.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
                this.sGE.setTitle(i.uRq);
                setMMTitle(i.uTX);
            }
            this.ilB.notifyDataSetChanged();
            return;
        }
        x.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    }

    private boolean uR(int i) {
        return (this.llS & ((long) i)) != 0;
    }

    private void bKw() {
        if (uR(16)) {
            this.sGB.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.doa);
            this.sGC.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.dnZ);
            this.sGD.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.doa);
        } else if (uR(32)) {
            this.sGB.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.doa);
            this.sGC.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.doa);
            this.sGD.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.dnZ);
        } else {
            this.sGB.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.dnZ);
            this.sGC.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.doa);
            this.sGD.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.doa);
        }
    }
}
