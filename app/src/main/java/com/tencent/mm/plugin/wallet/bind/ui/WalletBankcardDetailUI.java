package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

public class WalletBankcardDetailUI extends WalletBaseUI {
    public Bankcard sAg;
    protected TextView sCk;
    private TextView sCl;
    private View sCm;
    protected LinearLayout sCn;
    protected LinearLayout sCo;
    protected LinearLayout sCp;

    protected final int getLayoutId() {
        return g.uEy;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(621);
        setMMTitle(i.uPI);
        initView();
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        jj(621);
        super.onDestroy();
    }

    protected final void initView() {
        this.sAg = (Bankcard) this.vf.getParcelable("key_bankcard");
        if (this.sAg != null) {
            this.sCn = (LinearLayout) findViewById(f.uxK);
            this.sCo = (LinearLayout) findViewById(f.uxR);
            this.sCp = (LinearLayout) findViewById(f.uxP);
            this.sCl = (TextView) findViewById(f.uxN);
            this.sCm = findViewById(f.uxW);
            this.sCm.setOnClickListener(new 1(this));
            if (1 == this.sAg.field_bankcardState) {
                bJE();
                return;
            }
            String str;
            if (this.sAg.bKS()) {
                jy(true);
                this.sCk = (TextView) findViewById(f.uxJ);
                p.bJN();
                p.bJO();
                str = this.sAg.field_bindSerial;
                this.sCk.setVisibility(8);
            } else {
                jy(false);
                this.sCk = (TextView) findViewById(f.uxO);
                p.bJN();
                p.bJO();
                str = this.sAg.field_bindSerial;
                this.sCk.setVisibility(8);
            }
            addIconOptionMenu(0, a$e.bDI, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletBankcardDetailUI sCq;

                {
                    this.sCq = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    p.bJN();
                    List bLX = p.bJO().bLX();
                    if (bLX != null && bLX.size() > 1) {
                        p.bJN();
                        p.bJO();
                        String str = this.sCq.sAg.field_bindSerial;
                    }
                    List arrayList = new ArrayList();
                    h.a(this.sCq, null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.sCq.getString(i.uSc), false, new 1(this));
                    return true;
                }
            });
        }
    }

    public final void jy(boolean z) {
        if (z) {
            this.sCn.setVisibility(8);
            this.sCo.setVisibility(0);
            ((TextView) findViewById(f.uxI)).setOnClickListener(new 2(this));
            TextView textView = (TextView) findViewById(f.uxV);
            TextView textView2 = (TextView) findViewById(f.uxS);
            TextView textView3 = (TextView) findViewById(f.uxT);
            ((TextView) findViewById(f.uxU)).setText(e.d(this.sAg.field_onceQuotaKind, null));
            textView.setText(e.d(this.sAg.field_onceQuotaVirtual, null));
            textView2.setText(e.d(this.sAg.field_dayQuotaKind, null));
            textView3.setText(e.d(this.sAg.field_dayQuotaVirtual, null));
            if (!bh.ov(this.sAg.field_repay_url)) {
                this.sCl.setVisibility(0);
                this.sCm.setVisibility(0);
                return;
            }
            return;
        }
        this.sCn.setVisibility(8);
        this.sCo.setVisibility(8);
        this.sCp.setVisibility(0);
    }

    public final void bJE() {
        this.sCn.setVisibility(0);
        this.sCo.setVisibility(8);
        ((TextView) findViewById(f.uxL)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI sCq;

            {
                this.sCq = r1;
            }

            public final void onClick(View view) {
                this.sCq.showDialog(0);
            }
        });
        ((TextView) findViewById(f.uxY)).setOnClickListener(new 4(this));
    }

    private void jz(boolean z) {
        if (q.Gf() || z || ((b) com.tencent.mm.kernel.g.h(b.class)).bNy()) {
            this.vf.putBoolean("offline_pay", false);
            a.j(this, this.vf);
            return;
        }
        e.HF(0);
        h.a(this, i.uPK, -1, i.uPJ, i.uPL, true, new 6(this), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI sCq;

            {
                this.sCq = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.sCq.jz(true);
                e.HF(2);
            }
        });
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return h.a(this.mController.xIM, getString(i.uPG), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.uau), "", new 8(this));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) {
                if (this.sCk == null) {
                    return false;
                }
                this.sCk.setVisibility(0);
                return false;
            } else if (!(kVar instanceof com.tencent.mm.plugin.wallet.bind.a.a)) {
                return false;
            } else {
                com.tencent.mm.plugin.wallet.bind.a.a aVar = (com.tencent.mm.plugin.wallet.bind.a.a) kVar;
                x.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + aVar.sBK);
                switch (aVar.sBK) {
                    case 2:
                    case 3:
                        h.a(this, aVar.sBL, null, false, new 9(this, aVar.sBK));
                        return false;
                    default:
                        jz(false);
                        return false;
                }
            }
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet.bind.a.a)) {
            return false;
        } else {
            x.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
            jz(false);
            return true;
        }
    }
}
