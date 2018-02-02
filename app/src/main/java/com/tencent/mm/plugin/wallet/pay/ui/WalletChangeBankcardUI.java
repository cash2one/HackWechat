package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.c;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@a(3)
public class WalletChangeBankcardUI extends WalletBaseUI implements a.a {
    public static int sEK = 1;
    protected int fCV = 0;
    protected TextView kTr;
    public String mzL;
    protected Button pNB;
    public Orders pPl = null;
    public Authen sCY = null;
    protected ListView sEL;
    public int sEM;
    public f sEN = null;
    public PayInfo sEO = null;
    protected String sEP = null;
    public FavorPayInfo sEQ;
    private a sER;
    c sES = null;
    private com.tencent.mm.sdk.b.c sET = new 1(this);
    public m szh;
    public ArrayList<Bankcard> szk;
    public Bankcard szl = null;

    private void ze(int i) {
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null) {
            ag.d(this, 1);
        } else {
            finish();
        }
        b tgVar = new tg();
        tgVar.fLJ.result = -1;
        com.tencent.mm.sdk.b.a.xef.m(tgVar);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == sEK) {
            ze(-1);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uWH);
        Bundle bundle2 = this.vf;
        bundle2.putInt("key_err_code", 0);
        this.sEM = bundle2.getInt("key_support_bankcard", 1);
        this.sCY = (Authen) bundle2.getParcelable("key_authen");
        this.pPl = (Orders) bundle2.getParcelable("key_orders");
        this.sEO = (PayInfo) bundle2.getParcelable("key_pay_info");
        this.sEQ = (FavorPayInfo) bundle2.getParcelable("key_favor_pay_info");
        this.fCV = this.sEO == null ? 0 : this.sEO.fCV;
        x.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[]{Integer.valueOf(this.fCV)});
        if (this.vf.getBoolean("key_is_filter_bank_type")) {
            jC(true);
        } else {
            this.szk = jB(bJW());
        }
        if (!(this.pPl == null || this.pPl.sNW == null || this.pPl.sNW.size() <= 0)) {
            this.sEP = getString(i.uQK, new Object[]{e.d(this.pPl.pNX, this.pPl.paz), ((Commodity) this.pPl.sNW.get(0)).desc});
        }
        bJX();
        initView();
        p.ft(7, 0);
        com.tencent.mm.sdk.b.a.xef.b(this.sET);
        if (this.vf.getBoolean("key_is_filter_bank_type") && this.sEN != null) {
            this.sEN.sTa = false;
        }
    }

    private ArrayList<Bankcard> jB(boolean z) {
        if (this.fCV == 8) {
            com.tencent.mm.plugin.wallet.a.p.bJN();
            return com.tencent.mm.plugin.wallet.a.p.bJO().jJ(z);
        }
        com.tencent.mm.plugin.wallet.a.p.bJN();
        return com.tencent.mm.plugin.wallet.a.p.bJO().jB(z);
    }

    public void onDestroy() {
        if (this.sER != null) {
            this.sER.bJV();
            this.sER.release();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.sET);
        this.sES = null;
        super.onDestroy();
    }

    private boolean bJW() {
        return (this.sEO == null || this.sEO.fCV == 11) ? false : true;
    }

    protected final void bJX() {
        if (this.szk != null) {
            Collections.sort(this.szk, new 2(this));
        }
    }

    public final void initView() {
        this.pNB = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.usN);
        this.pNB.setEnabled(false);
        this.pNB.setOnClickListener(new 3(this));
        if (bh.ov(this.vf.getString("key_pwd1"))) {
            this.pNB.setText(i.dFU);
        } else {
            this.pNB.setText(i.uVs);
        }
        this.sEL = (ListView) findViewById(com.tencent.mm.plugin.wxpay.a.f.cMt);
        this.sEN = bJY();
        this.sEL.setAdapter(this.sEN);
        this.sEL.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletChangeBankcardUI sEU;

            {
                this.sEU = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.sEU.zf(i);
            }
        });
        au();
    }

    public f bJY() {
        bJX();
        return new f(this, this.szk, this.sEM, this.pPl);
    }

    public final void au() {
        this.kTr = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.ula);
        if (this.sEQ != null && !bh.ov(this.sEQ.sMX)) {
            this.kTr.setVisibility(0);
            this.kTr.setText(this.sEQ.sMX);
        } else if (this.vf.getInt("key_main_bankcard_state", 0) != 0) {
            this.kTr.setVisibility(0);
            this.kTr.setText(this.sEP);
        } else {
            this.kTr.setVisibility(8);
        }
    }

    protected void zf(int i) {
        int i2 = 0;
        int size = this.szk != null ? this.szk.size() : 0;
        if (this.szk != null && i < size) {
            Bankcard bankcard = (Bankcard) this.szk.get(i);
            this.szl = bankcard;
            if (this.sEO != null) {
                i2 = this.sEO.fCV;
            }
            t.d(i2, this.sEO == null ? "" : this.sEO.fuH, 13, this.szl.field_bindSerial);
            this.sEN.sSZ = bankcard.field_bindSerial;
            this.pNB.setEnabled(true);
            this.sEN.notifyDataSetChanged();
            bJZ();
        } else if (size == i) {
            g bKX = g.bKX();
            if (bKX.aHh()) {
                h.b(this, bKX.oZB, getString(i.dGO), true);
                return;
            }
            if (this.sEO != null) {
                i2 = this.sEO.fCV;
            }
            t.d(i2, this.sEO == null ? "" : this.sEO.fuH, 14, "");
            this.vf.putInt("key_err_code", -1003);
            com.tencent.mm.wallet_core.a.j(this, this.vf);
        }
    }

    public void onResume() {
        this.vf.putInt("key_err_code", 0);
        super.onResume();
        if (this.sES != null) {
            this.sES.bMp();
        }
    }

    public final boolean aYf() {
        if (super.aYf()) {
            return true;
        }
        if (this.sEO == null || !this.sEO.ncX) {
            return false;
        }
        if (this.sEO.ncX) {
            return true;
        }
        com.tencent.mm.plugin.wallet.a.p.bJN();
        if (com.tencent.mm.plugin.wallet.a.p.bJO().bLM()) {
            return false;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uEL;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && this.sEQ != null && this.szk.size() == 0) {
            FavorPayInfo favorPayInfo = this.sEQ;
            boolean z = (favorPayInfo == null || favorPayInfo.sMU == 0) ? false : true;
            if (z) {
                x.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
                String string = this.vf.getString("key_is_cur_bankcard_bind_serial");
                if (bh.ov(string)) {
                    x.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
                    return super.onKeyUp(i, keyEvent);
                }
                List jB = jB(true);
                if (jB != null && this.szl == null) {
                    for (int i2 = 0; i2 < jB.size(); i2++) {
                        if (string.equals(((Bankcard) jB.get(i2)).field_bindSerial)) {
                            x.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:" + string);
                            this.szl = (Bankcard) jB.get(i2);
                            break;
                        }
                    }
                    if (this.szl == null) {
                        x.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                        return super.onKeyUp(i, keyEvent);
                    }
                }
                bJZ();
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putString("pwd", this.mzL);
            this.vf.putBoolean("key_need_verify_sms", false);
            ((l) com.tencent.mm.kernel.g.h(l.class)).a(this.sCY.pCn.vzy == 1, true, bundle);
            switch (i2) {
                case 100000:
                case 100001:
                case 100102:
                    this.sEO.vzA = i2;
                    bJZ();
                    return true;
                case 100100:
                case 100101:
                    this.sEO.vzA = i2;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.sER == null) {
                        this.sER = new a(this, this);
                    }
                    this.sER.a(z, this.sEO.fwX, this.sEO.fuH);
                    x.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.e) {
            return true;
        } else {
            if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                Bundle bundle2 = this.vf;
                com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                if (!bh.ov(this.mzL)) {
                    bundle2.putString("key_pwd1", this.mzL);
                }
                bundle2.putString("kreq_token", bVar.token);
                bundle2.putParcelable("key_authen", bVar.sEt);
                bundle2.putBoolean("key_need_verify_sms", !bVar.sEr);
                bundle2.putParcelable("key_pay_info", this.sEO);
                bundle2.putInt("key_pay_flag", 3);
                Parcelable parcelable = bVar.oWt;
                if (parcelable != null) {
                    bundle2.putParcelable("key_realname_guide_helper", parcelable);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("pwd", this.mzL);
                ((l) com.tencent.mm.kernel.g.h(l.class)).a(bVar.bJS(), true, bundle3);
                if (bVar.sFA) {
                    bundle2.putParcelable("key_orders", bVar.sEs);
                    if (this.sEO != null && this.sEO.fCV == 8) {
                        b sxVar = new sx();
                        sxVar.fLn.fLo = this.sCY.oZA;
                        com.tencent.mm.sdk.b.a.xef.m(sxVar);
                    }
                }
                com.tencent.mm.wallet_core.a.j(this, bundle2);
                return true;
            }
        }
        return false;
    }

    public void bJZ() {
        x.d("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
        String string = this.vf.getString("key_pwd1");
        if (bh.ov(string)) {
            uD(4);
            this.szh = m.a(this, this.pPl, this.sEQ, this.szl, this.sEO, new 5(this), new 6(this), new 7(this));
            this.sES = this.szh;
            return;
        }
        MM(string);
    }

    public void MM(String str) {
        this.sCY.sKs = str;
        if (this.szl != null) {
            this.vf.putString("key_mobile", this.szl.field_mobile);
            this.vf.putParcelable("key_bankcard", this.szl);
            this.sCY.oZA = this.szl.field_bindSerial;
            this.sCY.oZz = this.szl.field_bankcardType;
            if (this.sEQ != null) {
                this.sCY.sKE = this.sEQ.sMT;
            } else {
                this.sCY.sKE = null;
            }
            if (this.pPl.sNX != null) {
                this.sCY.sKD = this.pPl.sNX.sDq;
            }
            if (this.pPl != null && this.pPl.sIJ == 3) {
                boolean z;
                if (this.szl.bKS()) {
                    this.sCY.fDt = 3;
                } else {
                    this.sCY.fDt = 6;
                }
                Bundle bundle = this.vf;
                String str2 = "key_is_oversea";
                if (this.szl.bKS()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.vf.putString("key_pwd1", str);
        this.vf.putParcelable("key_authen", this.sCY);
        k a = com.tencent.mm.plugin.wallet.pay.a.a.a(this.sCY, this.pPl, false);
        if (a != null) {
            a.gOs = "PayProcess";
            a.vf = this.vf;
            if (this.sEO.fCV == 6 && this.sEO.vzu == 100) {
                a.irz = 100;
            } else {
                a.irz = this.sEO.fCV;
            }
            l(a);
        }
    }

    protected final boolean bKa() {
        return true;
    }

    public final void uw(int i) {
        if (i == 0) {
            bKb();
        } else if (i == 1) {
            this.vf.putString("key_pwd1", "");
            bJZ();
        } else {
            x.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
        }
    }

    public final void bKb() {
        cBZ();
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null) {
            ag.b(this, this.vf);
        } else {
            finish();
        }
    }

    protected int getForceOrientation() {
        return 1;
    }

    protected final void jC(boolean z) {
        this.szk = jB(bJW());
        if (this.sEQ != null) {
            Object obj;
            if (this.sEQ.sMU != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && z) {
                String str = this.sEQ.sMV;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.szk.size(); i++) {
                    Bankcard bankcard = (Bankcard) this.szk.get(i);
                    if (bh.ov(str)) {
                        if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                            arrayList.add(bankcard);
                        }
                    } else if (bankcard.field_bankcardType.equals(str)) {
                        arrayList.add(bankcard);
                    }
                }
                this.szk = arrayList;
                bJX();
            }
        }
    }

    protected final boolean aYi() {
        return true;
    }

    public final void c(boolean z, String str, String str2) {
        x.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
        if (z) {
            x.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
            this.sEO.fwZ = str;
            this.sEO.fxa = str2;
            MM(this.mzL);
            return;
        }
        x.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
        MM(this.mzL);
    }

    public void onPause() {
        super.onPause();
        if (this.sES != null) {
            this.sES.bMq();
        }
    }
}
