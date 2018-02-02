package com.tencent.tinker.a.c;

public final class a implements Cloneable {
    private static final boolean[] Agg = new boolean[0];
    private static final int[] bfR = new int[0];
    private boolean[] Agh;
    private int hX;
    private int[] wA;

    public final /* synthetic */ Object clone() {
        return cGU();
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.wA = new int[10];
        this.Agh = new boolean[10];
        this.hX = 0;
    }

    private static int Iz(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private a cGU() {
        try {
            a aVar = (a) super.clone();
            try {
                aVar.wA = (int[]) this.wA.clone();
                aVar.Agh = (boolean[]) this.Agh.clone();
                return aVar;
            } catch (CloneNotSupportedException e) {
                return aVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void IA(int i) {
        int a = a(this.wA, this.hX, i);
        if (a >= 0) {
            this.Agh[a] = true;
            return;
        }
        int i2 = a ^ -1;
        int[] iArr = this.wA;
        int i3 = this.hX;
        if (i3 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
            iArr[i2] = i;
        } else {
            Object obj = new int[Iz(i3)];
            System.arraycopy(iArr, 0, obj, 0, i2);
            obj[i2] = i;
            System.arraycopy(iArr, i2, obj, i2 + 1, iArr.length - i2);
            Object obj2 = obj;
        }
        this.wA = iArr;
        boolean[] zArr = this.Agh;
        i3 = this.hX;
        if (i3 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            zArr[i2] = true;
        } else {
            obj = new boolean[Iz(i3)];
            System.arraycopy(zArr, 0, obj, 0, i2);
            obj[i2] = 1;
            System.arraycopy(zArr, i2, obj, i2 + 1, zArr.length - i2);
            obj2 = obj;
        }
        this.Agh = zArr;
        this.hX++;
    }

    public final boolean IB(int i) {
        return a(this.wA, this.hX, i) >= 0;
    }

    private static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    public final String toString() {
        if (this.hX <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hX * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hX; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.wA[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.Agh[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
