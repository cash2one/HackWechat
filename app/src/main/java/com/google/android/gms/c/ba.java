package com.google.android.gms.c;

final class ba implements Cloneable {
    static final bb bac = new bb();
    boolean bad;
    int[] bae;
    bb[] baf;
    int hX;

    public ba() {
        this(10);
    }

    private ba(int i) {
        this.bad = false;
        int Y = Y(i);
        this.bae = new int[Y];
        this.baf = new bb[Y];
        this.hX = 0;
    }

    static int Y(int i) {
        int i2 = i * 4;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    public final /* synthetic */ Object clone() {
        return qj();
    }

    public final bb dH(int i) {
        if (this.bad) {
            gc();
        }
        return this.baf[i];
    }

    final int dI(int i) {
        int i2 = 0;
        int i3 = this.hX - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.bae[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ba)) {
            return false;
        }
        ba baVar = (ba) obj;
        if (size() != baVar.size()) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.bae;
        int[] iArr2 = baVar.bae;
        int i2 = this.hX;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            bb[] bbVarArr = this.baf;
            bb[] bbVarArr2 = baVar.baf;
            i2 = this.hX;
            for (i = 0; i < i2; i++) {
                if (!bbVarArr[i].equals(bbVarArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final void gc() {
        int i = this.hX;
        int[] iArr = this.bae;
        bb[] bbVarArr = this.baf;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            bb bbVar = bbVarArr[i3];
            if (bbVar != bac) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    bbVarArr[i2] = bbVar;
                    bbVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.bad = false;
        this.hX = i2;
    }

    public final int hashCode() {
        if (this.bad) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.hX; i2++) {
            i = (((i * 31) + this.bae[i2]) * 31) + this.baf[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final ba qj() {
        int i = 0;
        int size = size();
        ba baVar = new ba(size);
        System.arraycopy(this.bae, 0, baVar.bae, 0, size);
        while (i < size) {
            if (this.baf[i] != null) {
                baVar.baf[i] = this.baf[i].qk();
            }
            i++;
        }
        baVar.hX = size;
        return baVar;
    }

    public final int size() {
        if (this.bad) {
            gc();
        }
        return this.hX;
    }
}
