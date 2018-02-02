package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.wallet.balance.a.a.i;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.protocal.c.ape;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;
import java.util.List;

class WalletLqtSaveFetchUI$11 implements c {
    final /* synthetic */ g nal;
    final /* synthetic */ List oYY;
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$11(WalletLqtSaveFetchUI walletLqtSaveFetchUI, List list, g gVar) {
        this.sBv = walletLqtSaveFetchUI;
        this.oYY = list;
        this.nal = gVar;
    }

    public final void a(n nVar) {
        int size = this.oYY.size();
        for (int i = 0; i < size; i++) {
            String str;
            CharSequence spannableString;
            String str2;
            Bankcard bankcard = (Bankcard) this.oYY.get(i);
            String str3 = "";
            e h = b.h(this.sBv, bankcard.field_bankcardType, bankcard.bKO());
            if (h != null) {
                str = h.oPH;
            } else {
                str = str3;
            }
            Bitmap a = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
            j.a(new 1(this, str, nVar));
            Bitmap bitmap = null;
            str3 = "";
            if (!bh.ov(bankcard.field_forbidWord)) {
                str3 = bankcard.field_forbidWord;
            }
            if (bh.ov(bankcard.field_forbid_title)) {
                spannableString = new SpannableString(str3);
                str2 = str3;
            } else {
                str3 = str3 + " ";
                spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                2 2 = new 2(this, this.sBv);
                int length = str3.length();
                int length2 = str3.length() + bankcard.field_forbid_title.length();
                spannableString.setSpan(new ForegroundColorSpan(this.sBv.getResources().getColor(a.c.ubF)), length, length2, 33);
                spannableString.setSpan(2, length, length2, 33);
                str2 = str3;
            }
            CharSequence charSequence = bankcard.field_desc;
            if (bankcard.bKP()) {
                x.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
                nVar.a(i, charSequence, spannableString, this.sBv.getResources().getDrawable(a.e.udF), !bh.ov(str2));
            } else {
                if (a != null) {
                    bitmap = d.a(a, this.sBv.getResources().getDimensionPixelOffset(a.d.ucs), this.sBv.getResources().getDimensionPixelOffset(a.d.ucs), true, false);
                }
                x.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
                nVar.a(i, charSequence, spannableString, bitmap == null ? null : new BitmapDrawable(bitmap), !bh.ov(str2));
            }
            if (bitmap == null) {
                WalletLqtSaveFetchUI.d(this.sBv).put(str, Integer.valueOf(i));
            }
        }
        i iVar = i.syp;
        boolean z = WalletLqtSaveFetchUI.e(this.sBv) == 1;
        iVar.jw(z);
        ape com_tencent_mm_protocal_c_ape = z ? iVar.syj : iVar.syk;
        if (com_tencent_mm_protocal_c_ape != null ? com_tencent_mm_protocal_c_ape.wvS : false) {
            x.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
        } else if (WalletLqtSaveFetchUI.e(this.sBv) == 1) {
            nVar.a(size, this.sBv.getString(a.i.uSX), "", this.sBv.getResources().getDrawable(a.e.udE), false);
        } else if (WalletLqtSaveFetchUI.e(this.sBv) == 2) {
            nVar.a(size, this.sBv.getString(a.i.uSB), "", this.sBv.getResources().getDrawable(a.e.udE), false);
        }
    }
}
