package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m$b;
import com.tencent.mm.plugin.wallet_core.ui.i.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Vector;

class i$a$1 extends m<String> {
    final /* synthetic */ a sTK;

    i$a$1(a aVar) {
        this.sTK = aVar;
    }

    public final String a(Vector<m$b> vector, int i) {
        if (vector == null) {
            x.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < vector.size(); i2++) {
            int i3 = ((m$b) vector.get(i2)).sNq;
            if (i2 == i || i3 == m.a.sNm) {
                stringBuilder.append(((String) ((m$b) vector.get(i2)).sNp) + "-");
            }
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
