package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StaggeredGridLayoutManager$LazySpanLookup {
    List<FullSpanItem> Yf;
    int[] mData;

    final int bE(int i) {
        if (this.Yf != null) {
            for (int size = this.Yf.size() - 1; size >= 0; size--) {
                if (((FullSpanItem) this.Yf.get(size)).mPosition >= i) {
                    this.Yf.remove(size);
                }
            }
        }
        return bF(i);
    }

    final int bF(int i) {
        if (this.mData == null) {
            return -1;
        }
        if (i >= this.mData.length) {
            return -1;
        }
        int i2;
        if (this.Yf != null) {
            FullSpanItem bH = bH(i);
            if (bH != null) {
                this.Yf.remove(bH);
            }
            int size = this.Yf.size();
            int i3 = 0;
            while (i3 < size) {
                if (((FullSpanItem) this.Yf.get(i3)).mPosition >= i) {
                    break;
                }
                i3++;
            }
            i3 = -1;
            if (i3 != -1) {
                bH = (FullSpanItem) this.Yf.get(i3);
                this.Yf.remove(i3);
                i2 = bH.mPosition;
                if (i2 != -1) {
                    Arrays.fill(this.mData, i, this.mData.length, -1);
                    return this.mData.length;
                }
                Arrays.fill(this.mData, i, i2 + 1, -1);
                return i2 + 1;
            }
        }
        i2 = -1;
        if (i2 != -1) {
            Arrays.fill(this.mData, i, i2 + 1, -1);
            return i2 + 1;
        }
        Arrays.fill(this.mData, i, this.mData.length, -1);
        return this.mData.length;
    }

    final void bG(int i) {
        if (this.mData == null) {
            this.mData = new int[(Math.max(i, 10) + 1)];
            Arrays.fill(this.mData, -1);
        } else if (i >= this.mData.length) {
            Object obj = this.mData;
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            this.mData = new int[length];
            System.arraycopy(obj, 0, this.mData, 0, obj.length);
            Arrays.fill(this.mData, obj.length, this.mData.length, -1);
        }
    }

    final void clear() {
        if (this.mData != null) {
            Arrays.fill(this.mData, -1);
        }
        this.Yf = null;
    }

    final void ai(int i, int i2) {
        if (this.mData != null && i < this.mData.length) {
            bG(i + i2);
            System.arraycopy(this.mData, i + i2, this.mData, i, (this.mData.length - i) - i2);
            Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
            if (this.Yf != null) {
                int i3 = i + i2;
                for (int size = this.Yf.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.Yf.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.Yf.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i2;
                        }
                    }
                }
            }
        }
    }

    final void aj(int i, int i2) {
        if (this.mData != null && i < this.mData.length) {
            bG(i + i2);
            System.arraycopy(this.mData, i, this.mData, i + i2, (this.mData.length - i) - i2);
            Arrays.fill(this.mData, i, i + i2, -1);
            if (this.Yf != null) {
                for (int size = this.Yf.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.Yf.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }
    }

    public final void a(FullSpanItem fullSpanItem) {
        if (this.Yf == null) {
            this.Yf = new ArrayList();
        }
        int size = this.Yf.size();
        for (int i = 0; i < size; i++) {
            FullSpanItem fullSpanItem2 = (FullSpanItem) this.Yf.get(i);
            if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                this.Yf.remove(i);
            }
            if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                this.Yf.add(i, fullSpanItem);
                return;
            }
        }
        this.Yf.add(fullSpanItem);
    }

    public final FullSpanItem bH(int i) {
        if (this.Yf == null) {
            return null;
        }
        for (int size = this.Yf.size() - 1; size >= 0; size--) {
            FullSpanItem fullSpanItem = (FullSpanItem) this.Yf.get(size);
            if (fullSpanItem.mPosition == i) {
                return fullSpanItem;
            }
        }
        return null;
    }

    public final FullSpanItem q(int i, int i2, int i3) {
        if (this.Yf == null) {
            return null;
        }
        int size = this.Yf.size();
        for (int i4 = 0; i4 < size; i4++) {
            FullSpanItem fullSpanItem = (FullSpanItem) this.Yf.get(i4);
            if (fullSpanItem.mPosition >= i2) {
                return null;
            }
            if (fullSpanItem.mPosition >= i && (i3 == 0 || fullSpanItem.Yg == i3 || fullSpanItem.Yi)) {
                return fullSpanItem;
            }
        }
        return null;
    }
}
