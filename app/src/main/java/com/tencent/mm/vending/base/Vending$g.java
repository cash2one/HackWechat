package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.b;
import java.util.HashMap;

class Vending$g<K, V> extends HashMap<K, V> {
    b zBA = null;

    Vending$g() {
    }

    public final void clear() {
        super.clear();
        if (this.zBA != null) {
            this.zBA.czI();
        }
    }
}
