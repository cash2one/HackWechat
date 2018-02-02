package com.tencent.mm.plugin.music.model.b;

import java.util.BitSet;

public class c$a {
    public static BitSet aB(byte[] bArr) {
        BitSet bitSet = new BitSet(bArr.length * 8);
        int i = 0;
        for (byte b : bArr) {
            int i2 = 7;
            while (i2 >= 0) {
                boolean z;
                int i3 = i + 1;
                if (((b & (1 << i2)) >> i2) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bitSet.set(i, z);
                i2--;
                i = i3;
            }
        }
        return bitSet;
    }
}
