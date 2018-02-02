package g.a.c;

public final class a {
    public short[] AzC;
    public int AzD;

    public a(int i) {
        this.AzD = i;
        this.AzC = new short[(1 << i)];
    }

    public final int a(b bVar) {
        int i = 1;
        for (int i2 = this.AzD; i2 != 0; i2--) {
            i = bVar.d(this.AzC, i) + (i << 1);
        }
        return i - (1 << this.AzD);
    }
}
