package com.tencent.mm.plugin.offline.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

class WalletOfflineCoinPurseUI$28 implements c {
    final /* synthetic */ g nal;
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;
    final /* synthetic */ List oYY;

    WalletOfflineCoinPurseUI$28(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, List list, g gVar) {
        this.oYH = walletOfflineCoinPurseUI;
        this.oYY = list;
        this.nal = gVar;
    }

    public final void a(n nVar) {
        for (int i = 0; i < this.oYY.size(); i++) {
            String str;
            CharSequence spannableString;
            String str2;
            CharSequence charSequence;
            Drawable bVar;
            Drawable drawable;
            boolean z;
            Bankcard bankcard = (Bankcard) this.oYY.get(i);
            String Ha = a.Ha(bankcard.field_bankcardType);
            if (!bankcard.bKQ() || bankcard.sLn == null) {
                str = Ha;
            } else {
                str = bankcard.sLn.oPH;
            }
            Bitmap a = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
            j.a(new 1(this, str, nVar));
            Ha = "";
            if (!bh.ov(bankcard.field_forbidWord)) {
                Ha = bankcard.field_forbidWord;
            }
            if (bh.ov(Ha) && !bankcard.field_support_micropay) {
                Ha = bh.ov(bankcard.field_no_micro_word) ? "" : bankcard.field_no_micro_word;
            }
            if (bh.ov(bankcard.field_forbid_title)) {
                spannableString = new SpannableString(Ha);
                str2 = Ha;
            } else {
                Ha = Ha + " ";
                spannableString = new SpannableString(Ha + bankcard.field_forbid_title);
                2 2 = new 2(this, this.oYH, bankcard);
                int length = Ha.length();
                int length2 = Ha.length() + bankcard.field_forbid_title.length();
                spannableString.setSpan(new ForegroundColorSpan(this.oYH.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.ubF)), length, length2, 33);
                spannableString.setSpan(2, length, length2, 33);
                str2 = Ha;
            }
            if ((bankcard.bKP() || bankcard.bKQ()) && bankcard.sLf >= 0.0d) {
                charSequence = bankcard.field_desc + this.oYH.getString(i.uPj, new Object[]{e.u(bankcard.sLf)});
            } else {
                charSequence = bankcard.field_desc;
            }
            if (bankcard.bKT()) {
                bVar = new b(bankcard.sLr, 0.06f);
            } else if (a != null) {
                bVar = new BitmapDrawable(d.a(a, this.oYH.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.ucs), this.oYH.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.ucs), true, false));
            } else {
                bVar = null;
            }
            if (bVar == null) {
                WalletOfflineCoinPurseUI.J(this.oYH).put(str, Integer.valueOf(i));
            }
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
            if (bVar == null) {
                drawable = null;
            } else {
                drawable = bVar;
            }
            if (bh.ov(str2)) {
                z = false;
            } else {
                z = true;
            }
            nVar.a(i, charSequence, spannableString, drawable, z);
        }
    }
}
