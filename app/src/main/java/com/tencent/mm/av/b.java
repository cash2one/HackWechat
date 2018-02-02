package com.tencent.mm.av;

import com.tencent.mm.g.a.jr;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;

public final class b {
    public static final void xS() {
        ag.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jrVar = new jr();
                jrVar.fAt.action = 1;
                a.xef.m(jrVar);
            }
        });
    }

    public static final void xT() {
        ag.y(new 2());
    }

    public static final void Qo() {
        ag.y(new 3());
    }

    public static final void Qp() {
        ag.y(new 4());
    }

    public static final void a(final asv com_tencent_mm_protocal_c_asv) {
        ag.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jrVar = new jr();
                jrVar.fAt.action = 6;
                jrVar.fAt.fAv = com_tencent_mm_protocal_c_asv;
                a.xef.m(jrVar);
            }
        });
    }

    public static boolean Qq() {
        com.tencent.mm.sdk.b.b jrVar = new jr();
        jrVar.fAt.action = -3;
        a.xef.m(jrVar);
        return jrVar.fAu.fnI;
    }

    public static boolean Qr() {
        com.tencent.mm.sdk.b.b jrVar = new jr();
        jrVar.fAt.action = 9;
        a.xef.m(jrVar);
        return jrVar.fAu.fnI;
    }

    public static asv Qs() {
        com.tencent.mm.sdk.b.b jrVar = new jr();
        jrVar.fAt.action = -2;
        a.xef.m(jrVar);
        return jrVar.fAu.fAv;
    }

    public static void b(asv com_tencent_mm_protocal_c_asv) {
        ag.y(new 6(com_tencent_mm_protocal_c_asv));
    }

    public static void c(asv com_tencent_mm_protocal_c_asv) {
        ag.y(new 8(com_tencent_mm_protocal_c_asv));
    }

    public static boolean d(asv com_tencent_mm_protocal_c_asv) {
        if (com_tencent_mm_protocal_c_asv == null) {
            return false;
        }
        switch (com_tencent_mm_protocal_c_asv.wAi) {
            case 1:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean if(int i) {
        com.tencent.mm.sdk.b.b jrVar = new jr();
        jrVar.fAt.action = 7;
        jrVar.fAt.position = i;
        a.xef.m(jrVar);
        return jrVar.fAu.fnI;
    }

    public static d Qt() {
        com.tencent.mm.sdk.b.b jrVar = new jr();
        jrVar.fAt.action = 8;
        a.xef.m(jrVar);
        return jrVar.fAu.fAy;
    }
}
