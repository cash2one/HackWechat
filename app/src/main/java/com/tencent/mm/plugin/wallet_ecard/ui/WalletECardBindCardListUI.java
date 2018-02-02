package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class WalletECardBindCardListUI extends WalletECardBaseUI {
    private int sMe;
    private ListView sZG;
    private TextView sZH;
    private List<ey> sZI = new ArrayList();
    private c sZJ;

    private class a {
        TextView jVy;
        final /* synthetic */ WalletECardBindCardListUI sZK;

        public a(WalletECardBindCardListUI walletECardBindCardListUI, View view) {
            this.sZK = walletECardBindCardListUI;
            this.jVy = (TextView) view.findViewById(f.ujM);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zIY.ji(1988);
        this.sMe = this.vf.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.sYX, 2);
        x.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[]{Integer.valueOf(this.sMe)});
        setMMTitle(i.uIW);
        initView();
        x.i("MicroMsg.WalletECardBindCardListUI", "load Data");
        r(new com.tencent.mm.plugin.wallet_ecard.a.f("WEB_DEBIT", this.sMe));
    }

    protected final void initView() {
        this.sZG = (ListView) findViewById(f.ufA);
        View inflate = LayoutInflater.from(this).inflate(g.uBI, this.sZG, false);
        this.sZH = (TextView) inflate.findViewById(f.ujN);
        this.sZG.addHeaderView(inflate, null, false);
        this.sZJ = new c(this, (byte) 0);
        this.sZG.setAdapter(this.sZJ);
        this.sZG.setOnItemClickListener(new 1(this));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.f)) {
            return false;
        }
        com.tencent.mm.plugin.wallet_ecard.a.f fVar = (com.tencent.mm.plugin.wallet_ecard.a.f) kVar;
        if (i == 0 && i2 == 0) {
            if (!bh.ov(fVar.sZB.wGo)) {
                this.sZH.setText(fVar.sZB.wGo);
            }
            if (fVar.sZB.kLO == 0) {
                x.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[]{Integer.valueOf(fVar.sZB.wGp.size())});
                x.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[]{fVar.sZB.sKt});
                this.vf.putString(com.tencent.mm.plugin.wallet_ecard.a.a.sZo, fVar.sZB.sKt);
                if (fVar.sZB.wGp.size() == 0) {
                    this.vf.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.sZb, com.tencent.mm.plugin.wallet_ecard.a.a.sZr);
                    com.tencent.mm.wallet_core.a.j(this.mController.xIM, null);
                    return true;
                }
                this.sZI.clear();
                this.sZI.addAll(fVar.sZB.wGp);
                this.sZJ.notifyDataSetChanged();
                return true;
            } else if (b.a(this, fVar.sZB.vLL)) {
                return true;
            } else {
                h.b(this.mController.xIM, b.d(this.mController.xIM, new String[]{fVar.sZB.kLP, str}), "", false);
                return true;
            }
        }
        x.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[]{fVar});
        h.b(this.mController.xIM, b.d(this.mController.xIM, new String[]{str}), "", false);
        return true;
    }

    protected final int getLayoutId() {
        return g.uBH;
    }

    public void onDestroy() {
        super.onDestroy();
        this.zIY.jj(1988);
    }

    protected final boolean bKa() {
        return true;
    }
}
