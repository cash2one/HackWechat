package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.plugin.sns.model.ae;

public final class h {
    public static m Ll(String str) {
        if (u.Jv(str)) {
            return ae.bvv().eR(u.LF(str));
        }
        e eK = ae.bvy().eK(u.LF(str));
        if (eK != null) {
            return eK.bxX();
        }
        return null;
    }

    public static boolean a(String str, m mVar) {
        if (u.Jv(str)) {
            return ae.bvv().b(u.LF(str), mVar);
        }
        return ae.bvy().b(u.LF(str), mVar.byB());
    }

    public static m Lm(String str) {
        if (u.Jv(str)) {
            return ae.bvv().xo(u.LG(str));
        }
        e xk = ae.bvy().xk(u.LG(str));
        if (xk != null) {
            return xk.bxX();
        }
        return null;
    }
}
