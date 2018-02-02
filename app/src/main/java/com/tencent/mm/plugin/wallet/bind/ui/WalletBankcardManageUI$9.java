package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class WalletBankcardManageUI$9 implements OnItemClickListener {
    final /* synthetic */ WalletBankcardManageUI sCF;

    WalletBankcardManageUI$9(WalletBankcardManageUI walletBankcardManageUI) {
        this.sCF = walletBankcardManageUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Bankcard bankcard = (Bankcard) adapterView.getAdapter().getItem(i);
        e.HF(18);
        if (bankcard != null) {
            String str;
            a b = WalletBankcardManageUI.b(this.sCF);
            if (b.sBU != null && !b.sBU.isEmpty()) {
                for (String str2 : b.sBU) {
                    if (str2.equals(bankcard.field_bindSerial)) {
                        x.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[]{str2});
                        b.sBU.remove(str2);
                        g.Dk();
                        g.Dj().CU().a(a.xwi, bh.d(b.sBU, ","));
                        break;
                    }
                }
            }
            if (bankcard.bKO()) {
                Bundle bundle;
                if (bankcard.field_wxcreditState == 0) {
                    if (b.a(bankcard) && bankcard != null) {
                        g.Dk();
                        str2 = (String) g.Dj().CU().get(196659, null);
                        StringBuilder stringBuilder = new StringBuilder();
                        if (TextUtils.isEmpty(str2)) {
                            stringBuilder.append(bankcard.field_bankcardType);
                        } else {
                            stringBuilder.append(str2);
                            stringBuilder.append("&");
                            stringBuilder.append(bankcard.field_bankcardType);
                        }
                        g.Dk();
                        g.Dj().CU().set(196659, stringBuilder.toString());
                    }
                    bundle = new Bundle();
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_username", bankcard.field_bizUsername);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a(this.sCF, "WXCreditOpenProcess", bundle, null);
                } else {
                    bundle = new Bundle();
                    bundle.putParcelable("key_bankcard", bankcard);
                    com.tencent.mm.wallet_core.a.a(this.sCF, "WXCreditManagerProcess", bundle, null);
                }
            } else if (bankcard.bKT()) {
                x.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
                Intent intent = new Intent();
                intent.putExtra("key_card_no", bankcard.field_bindSerial);
                d.b(this.sCF, "honey_pay", ".ui.HoneyPayCardBackUI", intent);
            } else {
                x.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[]{Boolean.valueOf((o.bLq().bLQ().sPW & Downloads.RECV_BUFFER_SIZE) > 0), Integer.valueOf(o.bLq().bLQ().sPW)});
                if ((o.bLq().bLQ().sPW & Downloads.RECV_BUFFER_SIZE) > 0) {
                    x.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                    g.Dk();
                    str2 = (String) g.Dj().CU().get(a.xrm, "");
                    g.Dk();
                    long longValue = ((Long) g.Dj().CU().get(a.xrn, Long.valueOf(0))).longValue();
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (bh.ov(str2) || currentTimeMillis - longValue >= 7200) {
                        x.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
                        com.tencent.mm.sdk.b.a.xef.b(new 1(this, bankcard));
                    } else {
                        x.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                        this.sCF.b(bankcard);
                    }
                } else {
                    this.sCF.c(bankcard);
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(14422, new Object[]{Integer.valueOf(1), bankcard.field_bankcardType});
            return;
        }
        this.sCF.bJH();
        com.tencent.mm.plugin.report.service.g.pQN.h(14422, new Object[]{Integer.valueOf(2)});
    }
}
