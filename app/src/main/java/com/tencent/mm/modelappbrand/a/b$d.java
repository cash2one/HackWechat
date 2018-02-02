package com.tencent.mm.modelappbrand.a;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class b$d {
    private final af hka;
    final Map<String, List<a>> hkb;
    final Map<String, Boolean> hkc;

    private b$d(af afVar) {
        this.hkb = new HashMap();
        this.hkc = new HashMap();
        this.hka = afVar;
    }

    final void iH(String str) {
        if (!bh.ov(str)) {
            List<a> list = (List) this.hkb.remove(str);
            if (!bh.cA(list)) {
                for (a Jp : list) {
                    Jp.Jp();
                }
            }
        }
    }

    final void iI(String str) {
        if (!bh.ov(str)) {
            this.hkc.remove(str);
        }
    }

    final void a(String str, a aVar) {
        if (!bh.ov(str) && aVar != null) {
            List list = (List) this.hkb.get(str);
            if (list != null) {
                list.remove(aVar);
            }
        }
    }

    final void iJ(String str) {
        if (!bh.ov(str)) {
            List<a> list = (List) this.hkb.remove(str);
            if (!bh.cA(list)) {
                for (a Jq : list) {
                    Jq.Jq();
                }
                list.clear();
            }
        }
    }

    final void i(Runnable runnable) {
        this.hka.post(runnable);
    }
}
