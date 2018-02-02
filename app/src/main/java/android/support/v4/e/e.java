package android.support.v4.e;

public final class e<E> implements Cloneable {
    public static final Object wg = new Object();
    public int hX;
    public boolean wh;
    public long[] wi;
    public Object[] wj;

    public final /* synthetic */ Object clone() {
        return bF();
    }

    public e() {
        this((byte) 0);
    }

    private e(byte b) {
        this.wh = false;
        int Z = b.Z(10);
        this.wi = new long[Z];
        this.wj = new Object[Z];
        this.hX = 0;
    }

    private e<E> bF() {
        try {
            e<E> eVar = (e) super.clone();
            try {
                eVar.wi = (long[]) this.wi.clone();
                eVar.wj = (Object[]) this.wj.clone();
                return eVar;
            } catch (CloneNotSupportedException e) {
                return eVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E get(long j) {
        int a = b.a(this.wi, this.hX, j);
        return (a < 0 || this.wj[a] == wg) ? null : this.wj[a];
    }

    private void gc() {
        int i = this.hX;
        long[] jArr = this.wi;
        Object[] objArr = this.wj;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != wg) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.wh = false;
        this.hX = i2;
    }

    public final void put(long j, E e) {
        int a = b.a(this.wi, this.hX, j);
        if (a >= 0) {
            this.wj[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.hX || this.wj[a] != wg) {
            if (this.wh && this.hX >= this.wi.length) {
                gc();
                a = b.a(this.wi, this.hX, j) ^ -1;
            }
            if (this.hX >= this.wi.length) {
                int Z = b.Z(this.hX + 1);
                Object obj = new long[Z];
                Object obj2 = new Object[Z];
                System.arraycopy(this.wi, 0, obj, 0, this.wi.length);
                System.arraycopy(this.wj, 0, obj2, 0, this.wj.length);
                this.wi = obj;
                this.wj = obj2;
            }
            if (this.hX - a != 0) {
                System.arraycopy(this.wi, a, this.wi, a + 1, this.hX - a);
                System.arraycopy(this.wj, a, this.wj, a + 1, this.hX - a);
            }
            this.wi[a] = j;
            this.wj[a] = e;
            this.hX++;
            return;
        }
        this.wi[a] = j;
        this.wj[a] = e;
    }

    public final int size() {
        if (this.wh) {
            gc();
        }
        return this.hX;
    }

    private long keyAt(int i) {
        if (this.wh) {
            gc();
        }
        return this.wi[i];
    }

    public final E valueAt(int i) {
        if (this.wh) {
            gc();
        }
        return this.wj[i];
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hX * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hX; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            e valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
