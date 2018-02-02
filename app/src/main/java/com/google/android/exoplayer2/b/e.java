package com.google.android.exoplayer2.b;

import java.nio.ByteBuffer;

public class e extends a {
    public final b aie = new b();
    public ByteBuffer aif;
    public long aig;
    public final int aih;

    public e(int i) {
        this.aih = i;
    }

    public final void cc(int i) {
        if (this.aif == null) {
            this.aif = cd(i);
            return;
        }
        int capacity = this.aif.capacity();
        int position = this.aif.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer cd = cd(i2);
            if (position > 0) {
                this.aif.position(0);
                this.aif.limit(position);
                cd.put(this.aif);
            }
            this.aif = cd;
        }
    }

    public final boolean jd() {
        return cb(1073741824);
    }

    public final void je() {
        this.aif.flip();
    }

    public final void clear() {
        super.clear();
        if (this.aif != null) {
            this.aif.clear();
        }
    }

    private ByteBuffer cd(int i) {
        if (this.aih == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.aih == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.aif == null ? 0 : this.aif.capacity()) + " < " + i + ")");
    }
}
