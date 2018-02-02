package com.google.android.gms.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class bb implements Cloneable {
    private az<?, ?> bag;
    private Object bah;
    List<bg> bai = new ArrayList();

    bb() {
    }

    private byte[] toByteArray() {
        byte[] bArr = new byte[pw()];
        a(ax.m(bArr, 0, bArr.length));
        return bArr;
    }

    final void a(ax axVar) {
        if (this.bah != null) {
            this.bag.a(this.bah, axVar);
            return;
        }
        for (bg bgVar : this.bai) {
            axVar.dE(bgVar.tag);
            axVar.l(bgVar.bal);
        }
    }

    public final /* synthetic */ Object clone() {
        return qk();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        if (this.bah != null && bbVar.bah != null) {
            return this.bag == bbVar.bag ? !this.bag.baa.isArray() ? this.bah.equals(bbVar.bah) : this.bah instanceof byte[] ? Arrays.equals((byte[]) this.bah, (byte[]) bbVar.bah) : this.bah instanceof int[] ? Arrays.equals((int[]) this.bah, (int[]) bbVar.bah) : this.bah instanceof long[] ? Arrays.equals((long[]) this.bah, (long[]) bbVar.bah) : this.bah instanceof float[] ? Arrays.equals((float[]) this.bah, (float[]) bbVar.bah) : this.bah instanceof double[] ? Arrays.equals((double[]) this.bah, (double[]) bbVar.bah) : this.bah instanceof boolean[] ? Arrays.equals((boolean[]) this.bah, (boolean[]) bbVar.bah) : Arrays.deepEquals((Object[]) this.bah, (Object[]) bbVar.bah) : false;
        } else {
            if (this.bai != null && bbVar.bai != null) {
                return this.bai.equals(bbVar.bai);
            }
            try {
                return Arrays.equals(toByteArray(), bbVar.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final int pw() {
        if (this.bah != null) {
            return this.bag.ak(this.bah);
        }
        int i = 0;
        for (bg bgVar : this.bai) {
            i = (bgVar.bal.length + (ax.dF(bgVar.tag) + 0)) + i;
        }
        return i;
    }

    public final bb qk() {
        int i = 0;
        bb bbVar = new bb();
        try {
            bbVar.bag = this.bag;
            if (this.bai == null) {
                bbVar.bai = null;
            } else {
                bbVar.bai.addAll(this.bai);
            }
            if (this.bah != null) {
                if (this.bah instanceof be) {
                    bbVar.bah = ((be) this.bah).qi();
                } else if (this.bah instanceof byte[]) {
                    bbVar.bah = ((byte[]) this.bah).clone();
                } else if (this.bah instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.bah;
                    Object obj = new byte[bArr.length][];
                    bbVar.bah = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.bah instanceof boolean[]) {
                    bbVar.bah = ((boolean[]) this.bah).clone();
                } else if (this.bah instanceof int[]) {
                    bbVar.bah = ((int[]) this.bah).clone();
                } else if (this.bah instanceof long[]) {
                    bbVar.bah = ((long[]) this.bah).clone();
                } else if (this.bah instanceof float[]) {
                    bbVar.bah = ((float[]) this.bah).clone();
                } else if (this.bah instanceof double[]) {
                    bbVar.bah = ((double[]) this.bah).clone();
                } else if (this.bah instanceof be[]) {
                    be[] beVarArr = (be[]) this.bah;
                    Object obj2 = new be[beVarArr.length];
                    bbVar.bah = obj2;
                    while (i < beVarArr.length) {
                        obj2[i] = beVarArr[i].qi();
                        i++;
                    }
                }
            }
            return bbVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
