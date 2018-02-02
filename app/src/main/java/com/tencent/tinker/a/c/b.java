package com.tencent.tinker.a.c;

public final class b implements Cloneable {
    private static final int[] bfR = new int[0];
    public int[] Agi;
    public int hX;
    public int[] wA;

    public final /* synthetic */ Object clone() {
        return cGV();
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.wA = new int[10];
        this.Agi = new int[this.wA.length];
        this.hX = 0;
    }

    private static int Iz(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private b cGV() {
        try {
            b bVar = (b) super.clone();
            try {
                bVar.wA = (int[]) this.wA.clone();
                bVar.Agi = (int[]) this.Agi.clone();
                return bVar;
            } catch (CloneNotSupportedException e) {
                return bVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void put(int i, int i2) {
        int a = a(this.wA, this.hX, i);
        if (a >= 0) {
            this.Agi[a] = i2;
            return;
        }
        a ^= -1;
        this.wA = b(this.wA, this.hX, a, i);
        this.Agi = b(this.Agi, this.hX, a, i2);
        this.hX++;
    }

    public final int indexOfKey(int i) {
        return a(this.wA, this.hX, i);
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

    public static int[] d(int[] iArr, int i, int i2) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        }
        if (i + 1 > iArr.length) {
            Object obj = new int[Iz(i)];
            System.arraycopy(iArr, 0, obj, 0, i);
            iArr = obj;
        }
        iArr[i] = i2;
        return iArr;
    }

    private static int[] b(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            Object obj = new int[Iz(i)];
            System.arraycopy(iArr, 0, obj, 0, i2);
            obj[i2] = i3;
            System.arraycopy(iArr, i2, obj, i2 + 1, iArr.length - i2);
            return obj;
        }
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
            stringBuilder.append(this.Agi[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
