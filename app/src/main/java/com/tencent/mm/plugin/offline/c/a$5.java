package com.tencent.mm.plugin.offline.c;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import java.util.Comparator;

class a$5 implements Comparator<Bankcard> {
    a$5() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Bankcard) obj).field_bindSerial.compareToIgnoreCase(((Bankcard) obj2).field_bindSerial);
    }
}
