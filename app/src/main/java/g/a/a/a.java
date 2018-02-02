package g.a.a;

import java.io.OutputStream;

public final class a {
    public int AvW;
    public byte[] AyV;
    public int AyW = 0;
    public int AyX;
    public OutputStream AyY;

    public final void cKr() {
        cKs();
        this.AyY = null;
    }

    public final void cKs() {
        int i = this.AvW - this.AyX;
        if (i != 0) {
            this.AyY.write(this.AyV, this.AyX, i);
            if (this.AvW >= this.AyW) {
                this.AvW = 0;
            }
            this.AyX = this.AvW;
        }
    }

    public final byte Jo(int i) {
        int i2 = (this.AvW - i) - 1;
        if (i2 < 0) {
            i2 += this.AyW;
        }
        return this.AyV[i2];
    }
}
