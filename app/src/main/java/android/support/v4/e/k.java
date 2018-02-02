package android.support.v4.e;

public final class k<E> implements Cloneable {
    private static final Object wg = new Object();
    private int hX;
    private int[] wA;
    private boolean wh;
    private Object[] wj;

    public final /* synthetic */ Object clone() {
        return bI();
    }

    public k() {
        this(10);
    }

    public k(int i) {
        this.wh = false;
        if (i == 0) {
            this.wA = b.wd;
            this.wj = b.wf;
        } else {
            int Y = b.Y(i);
            this.wA = new int[Y];
            this.wj = new Object[Y];
        }
        this.hX = 0;
    }

    private k<E> bI() {
        try {
            k<E> kVar = (k) super.clone();
            try {
                kVar.wA = (int[]) this.wA.clone();
                kVar.wj = (Object[]) this.wj.clone();
                return kVar;
            } catch (CloneNotSupportedException e) {
                return kVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E get(int i) {
        int a = b.a(this.wA, this.hX, i);
        return (a < 0 || this.wj[a] == wg) ? null : this.wj[a];
    }

    public final void remove(int i) {
        int a = b.a(this.wA, this.hX, i);
        if (a >= 0 && this.wj[a] != wg) {
            this.wj[a] = wg;
            this.wh = true;
        }
    }

    public final void removeAt(int i) {
        if (this.wj[i] != wg) {
            this.wj[i] = wg;
            this.wh = true;
        }
    }

    private void gc() {
        int i = this.hX;
        int[] iArr = this.wA;
        Object[] objArr = this.wj;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != wg) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.wh = false;
        this.hX = i2;
    }

    public final void put(int i, E e) {
        int a = b.a(this.wA, this.hX, i);
        if (a >= 0) {
            this.wj[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.hX || this.wj[a] != wg) {
            if (this.wh && this.hX >= this.wA.length) {
                gc();
                a = b.a(this.wA, this.hX, i) ^ -1;
            }
            if (this.hX >= this.wA.length) {
                int Y = b.Y(this.hX + 1);
                Object obj = new int[Y];
                Object obj2 = new Object[Y];
                System.arraycopy(this.wA, 0, obj, 0, this.wA.length);
                System.arraycopy(this.wj, 0, obj2, 0, this.wj.length);
                this.wA = obj;
                this.wj = obj2;
            }
            if (this.hX - a != 0) {
                System.arraycopy(this.wA, a, this.wA, a + 1, this.hX - a);
                System.arraycopy(this.wj, a, this.wj, a + 1, this.hX - a);
            }
            this.wA[a] = i;
            this.wj[a] = e;
            this.hX++;
            return;
        }
        this.wA[a] = i;
        this.wj[a] = e;
    }

    public final int size() {
        if (this.wh) {
            gc();
        }
        return this.hX;
    }

    public final int keyAt(int i) {
        if (this.wh) {
            gc();
        }
        return this.wA[i];
    }

    public final E valueAt(int i) {
        if (this.wh) {
            gc();
        }
        return this.wj[i];
    }

    public final int indexOfKey(int i) {
        if (this.wh) {
            gc();
        }
        return b.a(this.wA, this.hX, i);
    }

    public final void clear() {
        int i = this.hX;
        Object[] objArr = this.wj;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.hX = 0;
        this.wh = false;
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
            k valueAt = valueAt(i);
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
