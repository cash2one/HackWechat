package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.protocal.c.so;

public final class e {
    public static boolean a(so soVar) {
        if (soVar == null) {
            return false;
        }
        return co(soVar.waw, 1);
    }

    public static boolean b(so soVar) {
        if (!(soVar == null ? false : co(soVar.wav, 4))) {
            if (!(soVar == null ? false : co(soVar.wav, 8))) {
                return false;
            }
        }
        return true;
    }

    public static boolean oK(int i) {
        return co(i, 4) || co(i, 8);
    }

    public static boolean co(int i, int i2) {
        return (i & i2) == i2;
    }
}
