package com.google.android.gms.c;

import java.io.IOException;

public abstract class be {
    protected volatile int bak = -1;

    public static final <T extends be> T a(T t, byte[] bArr, int i) {
        try {
            aw awVar = new aw(bArr, 0, i);
            t.a(awVar);
            awVar.du(0);
            return t;
        } catch (bd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] c(be beVar) {
        byte[] bArr = new byte[beVar.qt()];
        try {
            ax m = ax.m(bArr, 0, bArr.length);
            beVar.a(m);
            if (m.aZY.remaining() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public abstract be a(aw awVar);

    public void a(ax axVar) {
    }

    public /* synthetic */ Object clone() {
        return qi();
    }

    protected int pw() {
        return 0;
    }

    public be qi() {
        return (be) super.clone();
    }

    public final int qs() {
        if (this.bak < 0) {
            qt();
        }
        return this.bak;
    }

    public final int qt() {
        int pw = pw();
        this.bak = pw;
        return pw;
    }

    public String toString() {
        return bf.d(this);
    }
}
