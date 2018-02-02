package android.support.v7.widget;

class s$a {
    long QE = 0;
    s$a QF;

    s$a() {
    }

    final void set(int i) {
        while (i >= 64) {
            eG();
            this = this.QF;
            i -= 64;
        }
        this.QE |= 1 << i;
    }

    private void eG() {
        if (this.QF == null) {
            this.QF = new s$a();
        }
    }

    final void clear(int i) {
        while (i >= 64) {
            if (this.QF != null) {
                this = this.QF;
                i -= 64;
            } else {
                return;
            }
        }
        this.QE &= (1 << i) ^ -1;
    }

    final boolean get(int i) {
        while (i >= 64) {
            eG();
            this = this.QF;
            i -= 64;
        }
        return (this.QE & (1 << i)) != 0;
    }

    final void g(int i, boolean z) {
        while (true) {
            if (i >= 64) {
                eG();
                this = this.QF;
                i -= 64;
            } else {
                boolean z2 = (this.QE & Long.MIN_VALUE) != 0;
                long j = (1 << i) - 1;
                this.QE = (((j ^ -1) & this.QE) << 1) | (this.QE & j);
                if (z) {
                    set(i);
                } else {
                    clear(i);
                }
                if (z2 || this.QF != null) {
                    eG();
                    this = this.QF;
                    i = 0;
                    z = z2;
                } else {
                    return;
                }
            }
        }
    }

    final boolean aV(int i) {
        while (i >= 64) {
            eG();
            this = this.QF;
            i -= 64;
        }
        long j = 1 << i;
        boolean z = (this.QE & j) != 0;
        this.QE &= j ^ -1;
        j--;
        this.QE = Long.rotateRight((j ^ -1) & this.QE, 1) | (this.QE & j);
        if (this.QF != null) {
            if (this.QF.get(0)) {
                set(63);
            }
            this.QF.aV(0);
        }
        return z;
    }

    final int aW(int i) {
        if (this.QF == null) {
            if (i >= 64) {
                return Long.bitCount(this.QE);
            }
            return Long.bitCount(this.QE & ((1 << i) - 1));
        } else if (i < 64) {
            return Long.bitCount(this.QE & ((1 << i) - 1));
        } else {
            return this.QF.aW(i - 64) + Long.bitCount(this.QE);
        }
    }

    public final String toString() {
        return this.QF == null ? Long.toBinaryString(this.QE) : this.QF.toString() + "xx" + Long.toBinaryString(this.QE);
    }
}
