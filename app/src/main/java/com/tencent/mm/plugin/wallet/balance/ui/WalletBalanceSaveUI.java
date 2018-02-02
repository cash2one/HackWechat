package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.a.c;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.z.q;
import java.util.ArrayList;

@a(3)
public class WalletBalanceSaveUI extends WalletBaseUI {
    private final int iiI = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 270);
    private View kND;
    protected Button lRZ;
    protected WalletFormView llY;
    public double pLR;
    private ArrayList<Bankcard> szk;
    protected Bankcard szl;
    private String szm;
    public WalletFormView szo;

    static /* synthetic */ void d(WalletBalanceSaveUI walletBalanceSaveUI) {
        if (walletBalanceSaveUI.kND != null) {
            int[] iArr = new int[2];
            walletBalanceSaveUI.lRZ.getLocationInWindow(iArr);
            int eB = (com.tencent.mm.bv.a.eB(walletBalanceSaveUI) - r0) - com.tencent.mm.bv.a.fromDPToPix(walletBalanceSaveUI, 30);
            x.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + walletBalanceSaveUI.lRZ.getHeight()), Integer.valueOf(com.tencent.mm.bv.a.eB(walletBalanceSaveUI)), Integer.valueOf(eB), Integer.valueOf(walletBalanceSaveUI.iiI)});
            if (eB > 0 && eB < walletBalanceSaveUI.iiI) {
                x.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(walletBalanceSaveUI.iiI - eB)});
                walletBalanceSaveUI.kND.post(new 4(walletBalanceSaveUI, r0));
            }
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof c) {
                String str2;
                boolean a;
                c cVar = (c) kVar;
                if ("1".equals(cVar.fKP)) {
                    x.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    String str3 = cVar.fKQ;
                    str3 = cVar.fKR;
                    str2 = cVar.fKS;
                    aYf();
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 0);
                } else if ("2".equals(cVar.fKP)) {
                    x.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, cVar.fKQ, cVar.fKT, cVar.fKR, cVar.fKS, aYf(), null);
                } else {
                    x.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + cVar.fKP);
                    a = false;
                }
                if (!a) {
                    String str4 = ((c) kVar).fwY;
                    t.j(11, str4, i2);
                    if (com.tencent.mm.plugin.wallet.b.a.bKG()) {
                        str2 = this.szl == null ? "" : this.szl.field_bindSerial;
                        String str5 = "";
                        double d = this.pLR;
                        if (!bh.ov(str4)) {
                            PayInfo a2 = h.a(str4, str5, null, null, 11, 0);
                            a2.vzG = d;
                            h.a(this, true, str2, a2, 1);
                        }
                    } else {
                        h.a(this, this.szl == null ? "" : this.szl.field_bindSerial, str4, "", 11, 1);
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
                bnw();
                au();
            }
        } else if (kVar instanceof c) {
            t.j(11, "", i2);
        }
        return false;
    }

    private void bnw() {
        int i;
        p.bJN();
        ag bJO = p.bJO();
        this.szk = bJO.bLZ();
        this.szl = bJO.a(this.szk, null, false, true);
        if (this.szl != null && bh.ov(this.szl.field_forbidWord)) {
            this.szl = null;
            i = 0;
            while (i < this.szk.size()) {
                if (this.szk.get(i) != null && bh.ov(((Bankcard) this.szk.get(i)).field_forbidWord)) {
                    this.szl = (Bankcard) this.szk.get(i);
                    break;
                }
                i++;
            }
        }
        if (!(this.szl == null || bh.ov(this.szl.field_forbidWord))) {
            this.szl = null;
        }
        ArrayList arrayList = this.szk;
        if (arrayList != null) {
            for (i = 0; i < arrayList.size(); i++) {
                x.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[]{Integer.valueOf(i), ((Bankcard) arrayList.get(i)).field_forbidWord});
            }
        }
    }

    protected final int getLayoutId() {
        return g.uEt;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!q.Gf()) {
            if (com.tencent.mm.plugin.wallet.b.a.bKG()) {
                b(new aa(), false);
            } else {
                b(new com.tencent.mm.plugin.wallet_core.c.x(null, 3), false);
            }
        }
        bnw();
        this.szm = getString(i.uPy);
        initView();
        au();
        com.tencent.mm.wallet_core.c.p.ft(3, 0);
    }

    protected final void initView() {
        setMMTitle(i.uPB);
        this.kND = findViewById(f.uwp);
        this.llY = (WalletFormView) findViewById(f.urG);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.llY);
        this.llY.jJn.setText(u.cBD());
        e(this.llY, 2, false);
        this.lRZ = (Button) findViewById(f.cAg);
        this.lRZ.setOnClickListener(new 1(this));
        this.szo = (WalletFormView) findViewById(f.ueK);
        if (this.szo != null) {
            com.tencent.mm.wallet_core.ui.formview.a.g(this.szo);
            this.szo.setOnClickListener(new 2(this));
        }
        this.ofE = new com.tencent.mm.wallet_core.ui.a(this) {
            final /* synthetic */ WalletBalanceSaveUI sAi;

            {
                this.sAi = r1;
            }

            public final void hA(boolean z) {
                if (z) {
                    WalletBalanceSaveUI.d(this.sAi);
                } else {
                    this.sAi.kND.scrollTo(0, 0);
                }
            }
        };
    }

    private void au() {
        if (this.szo == null) {
            return;
        }
        if (this.szl != null) {
            this.szo.setText(getString(i.uPw, new Object[]{this.szl.field_bankName, this.szl.field_bankcardTail}));
            this.szo.xv(this.szl.field_bankcardTypeName);
            String str = this.szl.field_avail_save_wording;
            if (this.szo.pEj == null) {
                x.e("MicroMsg.WalletBalanceSaveUI", "why layout is null !!!???");
                return;
            } else if (bh.ov(str)) {
                x.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
                this.szo.pEj.setText("");
                return;
            } else {
                this.szo.pEj.setText(this.szl.field_avail_save_wording);
                return;
            }
        }
        this.szo.setText(this.szm);
        if (this.szo.pEj != null) {
            this.szo.pEj.setText("");
        }
        this.szo.xv(getString(i.uPv));
    }

    public void bJy() {
        if (this.szl != null) {
            l(new c(this.pLR, "CNY", this.szl.field_bindSerial, this.szl.field_bankcardType));
            return;
        }
        com.tencent.mm.plugin.wallet_core.model.g bKX = com.tencent.mm.plugin.wallet_core.model.g.bKX();
        if (bKX.aHh()) {
            com.tencent.mm.ui.base.h.b(this, bKX.oZB, getString(i.dGO), true);
        } else {
            l(new c(this.pLR, "CNY", "", ""));
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
