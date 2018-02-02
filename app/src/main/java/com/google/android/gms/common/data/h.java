package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class h<T> extends a<T> {
    private boolean aMA = false;
    private ArrayList<Integer> aMB;

    public h(DataHolder dataHolder) {
        super(dataHolder);
    }

    private int dn(int i) {
        if (i >= 0 && i < this.aMB.size()) {
            return ((Integer) this.aMB.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    private void oA() {
        synchronized (this) {
            if (!this.aMA) {
                int i = this.aMc.aMn;
                this.aMB = new ArrayList();
                if (i > 0) {
                    this.aMB.add(Integer.valueOf(0));
                    String oz = oz();
                    String c = this.aMc.c(oz, 0, this.aMc.dl(0));
                    int i2 = 1;
                    while (i2 < i) {
                        int dl = this.aMc.dl(i2);
                        String c2 = this.aMc.c(oz, i2, dl);
                        if (c2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + oz + ", at row: " + i2 + ", for window: " + dl);
                        }
                        if (c2.equals(c)) {
                            c2 = c;
                        } else {
                            this.aMB.add(Integer.valueOf(i2));
                        }
                        i2++;
                        c = c2;
                    }
                }
                this.aMA = true;
            }
        }
    }

    public abstract T av(int i, int i2);

    public final T get(int i) {
        int i2;
        oA();
        int dn = dn(i);
        if (i < 0 || i == this.aMB.size()) {
            i2 = 0;
        } else {
            i2 = i == this.aMB.size() + -1 ? this.aMc.aMn - ((Integer) this.aMB.get(i)).intValue() : ((Integer) this.aMB.get(i + 1)).intValue() - ((Integer) this.aMB.get(i)).intValue();
            if (i2 == 1) {
                this.aMc.dl(dn(i));
            }
        }
        return av(dn, i2);
    }

    public final int getCount() {
        oA();
        return this.aMB.size();
    }

    public abstract String oz();
}
