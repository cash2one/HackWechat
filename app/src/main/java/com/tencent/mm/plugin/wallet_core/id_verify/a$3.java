package com.tencent.mm.plugin.wallet_core.id_verify;

import android.text.SpannableString;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class a$3 extends e {
    final /* synthetic */ a sJh;

    a$3(a aVar, MMActivity mMActivity, g gVar) {
        this.sJh = aVar;
        super(mMActivity, gVar);
    }

    public final CharSequence um(int i) {
        if (i != 0) {
            return null;
        }
        String string = this.zHU.getString(i.uVy);
        String string2 = this.zHU.getString(i.uVx);
        string = this.zHU.getString(i.uVA, new Object[]{string, string2});
        com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this.zHU);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(gVar, string.length() - string2.length(), string.length(), 33);
        return spannableString.subSequence(0, spannableString.length());
    }

    public final boolean k(Object... objArr) {
        return false;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
