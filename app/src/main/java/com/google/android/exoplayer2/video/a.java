package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.h.b;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.o;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public final float aCj;
    public final List<byte[]> adX;
    public final int alo;
    public final int height;
    public final int width;

    public static a m(j jVar) {
        int i = -1;
        int i2 = 0;
        try {
            jVar.cV(4);
            int readUnsignedByte = (jVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                throw new IllegalStateException();
            }
            int i3;
            List arrayList = new ArrayList();
            int readUnsignedByte2 = jVar.readUnsignedByte() & 31;
            for (i3 = 0; i3 < readUnsignedByte2; i3++) {
                arrayList.add(n(jVar));
            }
            i3 = jVar.readUnsignedByte();
            while (i2 < i3) {
                arrayList.add(n(jVar));
                i2++;
            }
            float f = 1.0f;
            if (readUnsignedByte2 > 0) {
                b j = h.j((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                i = j.width;
                i3 = j.height;
                f = j.aCj;
            } else {
                i3 = -1;
            }
            return new a(arrayList, readUnsignedByte, i, i3, f);
        } catch (Throwable e) {
            throw new o("Error parsing AVC config", e);
        }
    }

    private a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.adX = list;
        this.alo = i;
        this.width = i2;
        this.height = i3;
        this.aCj = f;
    }

    private static byte[] n(j jVar) {
        int readUnsignedShort = jVar.readUnsignedShort();
        int i = jVar.position;
        jVar.cV(readUnsignedShort);
        return c.i(jVar.data, i, readUnsignedShort);
    }
}
