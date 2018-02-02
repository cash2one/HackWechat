package android.support.v7.widget;

final class ag {
    int Wu = 0;
    int Wv = 0;
    int Ww = Integer.MIN_VALUE;
    int Wx = 0;
    int Wy = 0;
    boolean Wz = false;
    boolean gl = false;
    int wq = Integer.MIN_VALUE;

    ag() {
    }

    public final void ag(int i, int i2) {
        this.Ww = i;
        this.wq = i2;
        this.Wz = true;
        if (this.gl) {
            if (i2 != Integer.MIN_VALUE) {
                this.Wu = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.Wv = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.Wu = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.Wv = i2;
        }
    }
}
