package android.support.v4.e;

import java.util.Map;

public class j<K, V> {
    static Object[] wu;
    static int wv;
    static Object[] ww;
    static int wx;
    int hX;
    int[] wy;
    Object[] wz;

    private int indexOf(Object obj, int i) {
        int i2 = this.hX;
        if (i2 == 0) {
            return -1;
        }
        int a = b.a(this.wy, i2, i);
        if (a < 0 || obj.equals(this.wz[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.wy[i3] == i) {
            if (obj.equals(this.wz[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.wy[a] == i) {
            if (obj.equals(this.wz[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int bH() {
        int i = this.hX;
        if (i == 0) {
            return -1;
        }
        int a = b.a(this.wy, i, 0);
        if (a < 0 || this.wz[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.wy[i2] == 0) {
            if (this.wz[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.wy[a] == 0) {
            if (this.wz[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    final void ac(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (a.class) {
                if (ww != null) {
                    objArr = ww;
                    this.wz = objArr;
                    ww = (Object[]) objArr[0];
                    this.wy = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    wx--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (wu != null) {
                    objArr = wu;
                    this.wz = objArr;
                    wu = (Object[]) objArr[0];
                    this.wy = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    wv--;
                    return;
                }
            }
        }
        this.wy = new int[i];
        this.wz = new Object[(i << 1)];
    }

    static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (wx < 10) {
                    objArr[0] = ww;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    ww = objArr;
                    wx++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (wv < 10) {
                    objArr[0] = wu;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    wu = objArr;
                    wv++;
                }
            }
        }
    }

    public j() {
        this.wy = b.wd;
        this.wz = b.wf;
        this.hX = 0;
    }

    public j(int i) {
        if (i == 0) {
            this.wy = b.wd;
            this.wz = b.wf;
        } else {
            ac(i);
        }
        this.hX = 0;
    }

    public void clear() {
        if (this.hX != 0) {
            a(this.wy, this.wz, this.hX);
            this.wy = b.wd;
            this.wz = b.wf;
            this.hX = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? bH() : indexOf(obj, obj.hashCode());
    }

    final int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.hX * 2;
        Object[] objArr = this.wz;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.wz[(indexOfKey << 1) + 1] : null;
    }

    public final K keyAt(int i) {
        return this.wz[i << 1];
    }

    public final V valueAt(int i) {
        return this.wz[(i << 1) + 1];
    }

    public final V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.wz[i2];
        this.wz[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.hX <= 0;
    }

    public V put(K k, V v) {
        int bH;
        int i;
        int i2 = 8;
        if (k == null) {
            bH = bH();
            i = 0;
        } else {
            i = k.hashCode();
            bH = indexOf(k, i);
        }
        if (bH >= 0) {
            int i3 = (bH << 1) + 1;
            V v2 = this.wz[i3];
            this.wz[i3] = v;
            return v2;
        }
        bH ^= -1;
        if (this.hX >= this.wy.length) {
            if (this.hX >= 8) {
                i2 = this.hX + (this.hX >> 1);
            } else if (this.hX < 4) {
                i2 = 4;
            }
            Object obj = this.wy;
            Object obj2 = this.wz;
            ac(i2);
            if (this.wy.length > 0) {
                System.arraycopy(obj, 0, this.wy, 0, obj.length);
                System.arraycopy(obj2, 0, this.wz, 0, obj2.length);
            }
            a(obj, obj2, this.hX);
        }
        if (bH < this.hX) {
            System.arraycopy(this.wy, bH, this.wy, bH + 1, this.hX - bH);
            System.arraycopy(this.wz, bH << 1, this.wz, (bH + 1) << 1, (this.hX - bH) << 1);
        }
        this.wy[bH] = i;
        this.wz[bH << 1] = k;
        this.wz[(bH << 1) + 1] = v;
        this.hX++;
        return null;
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public final V removeAt(int i) {
        int i2 = 8;
        V v = this.wz[(i << 1) + 1];
        if (this.hX <= 1) {
            a(this.wy, this.wz, this.hX);
            this.wy = b.wd;
            this.wz = b.wf;
            this.hX = 0;
        } else if (this.wy.length <= 8 || this.hX >= this.wy.length / 3) {
            this.hX--;
            if (i < this.hX) {
                System.arraycopy(this.wy, i + 1, this.wy, i, this.hX - i);
                System.arraycopy(this.wz, (i + 1) << 1, this.wz, i << 1, (this.hX - i) << 1);
            }
            this.wz[this.hX << 1] = null;
            this.wz[(this.hX << 1) + 1] = null;
        } else {
            if (this.hX > 8) {
                i2 = this.hX + (this.hX >> 1);
            }
            Object obj = this.wy;
            Object obj2 = this.wz;
            ac(i2);
            this.hX--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.wy, 0, i);
                System.arraycopy(obj2, 0, this.wz, 0, i << 1);
            }
            if (i < this.hX) {
                System.arraycopy(obj, i + 1, this.wy, i, this.hX - i);
                System.arraycopy(obj2, (i + 1) << 1, this.wz, i << 1, (this.hX - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.hX;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.hX) {
            try {
                Object keyAt = keyAt(i);
                Object valueAt = valueAt(i);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 != null || !map.containsKey(keyAt)) {
                        return false;
                    }
                } else if (!valueAt.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.wy;
        Object[] objArr = this.wz;
        int i = this.hX;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hX * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hX; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            j keyAt = keyAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            keyAt = valueAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
