package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$b {
    final SparseIntArray RF = new SparseIntArray();
    private boolean RG = false;

    public abstract int ba(int i);

    final int H(int i, int i2) {
        if (!this.RG) {
            return G(i, i2);
        }
        int i3 = this.RF.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = G(i, i2);
        this.RF.put(i, i3);
        return i3;
    }

    public int G(int i, int i2) {
        int ba = ba(i);
        if (ba == i2) {
            return 0;
        }
        int size;
        int i3;
        int i4;
        if (this.RG && this.RF.size() > 0) {
            size = this.RF.size() - 1;
            i3 = 0;
            while (i3 <= size) {
                i4 = (i3 + size) >>> 1;
                if (this.RF.keyAt(i4) < i) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            size = i3 - 1;
            size = (size < 0 || size >= this.RF.size()) ? -1 : this.RF.keyAt(size);
            if (size >= 0) {
                i3 = this.RF.get(size) + ba(size);
                size++;
                i4 = size;
                while (i4 < i) {
                    size = ba(i4);
                    i3 += size;
                    if (i3 == i2) {
                        size = 0;
                    } else if (i3 <= i2) {
                        size = i3;
                    }
                    i4++;
                    i3 = size;
                }
                if (i3 + ba > i2) {
                    return i3;
                }
                return 0;
            }
        }
        size = 0;
        i3 = 0;
        i4 = size;
        while (i4 < i) {
            size = ba(i4);
            i3 += size;
            if (i3 == i2) {
                size = 0;
            } else if (i3 <= i2) {
                size = i3;
            }
            i4++;
            i3 = size;
        }
        if (i3 + ba > i2) {
            return 0;
        }
        return i3;
    }

    public final int I(int i, int i2) {
        int ba = ba(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            int ba2 = ba(i3);
            i5 += ba2;
            if (i5 == i2) {
                i4++;
                ba2 = 0;
            } else if (i5 > i2) {
                i4++;
            } else {
                ba2 = i5;
            }
            i3++;
            i5 = ba2;
        }
        if (i5 + ba > i2) {
            return i4 + 1;
        }
        return i4;
    }
}
