package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g implements d {
    private int aef = -1;
    private ByteBuffer agF = afA;
    private int ahd = -1;
    int[] ahe;
    private boolean ahf;
    private int[] ahg;
    private boolean ahh;
    private ByteBuffer buffer = afA;

    public final boolean r(int i, int i2, int i3) {
        boolean z = !Arrays.equals(this.ahe, this.ahg);
        this.ahg = this.ahe;
        if (this.ahg == null) {
            this.ahf = false;
            return z;
        } else if (i3 != 2) {
            throw new a(i, i2, i3);
        } else if (!z && this.ahd == i && this.aef == i2) {
            return false;
        } else {
            this.ahd = i;
            this.aef = i2;
            if (i2 != this.ahg.length) {
                z = true;
            } else {
                z = false;
            }
            this.ahf = z;
            int i4 = 0;
            while (i4 < this.ahg.length) {
                int i5 = this.ahg[i4];
                if (i5 >= i2) {
                    throw new a(i, i2, i3);
                }
                this.ahf = (i5 != i4 ? 1 : 0) | this.ahf;
                i4++;
            }
            return true;
        }
    }

    public final boolean isActive() {
        return this.ahf;
    }

    public final int iy() {
        return this.ahg == null ? this.aef : this.ahg.length;
    }

    public final int iz() {
        return 2;
    }

    public final void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.aef * 2)) * this.ahg.length) * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        while (position < limit) {
            for (int i : this.ahg) {
                this.buffer.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.aef * 2;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.agF = this.buffer;
    }

    public final void iA() {
        this.ahh = true;
    }

    public final ByteBuffer iB() {
        ByteBuffer byteBuffer = this.agF;
        this.agF = afA;
        return byteBuffer;
    }

    public final boolean it() {
        return this.ahh && this.agF == afA;
    }

    public final void flush() {
        this.agF = afA;
        this.ahh = false;
    }

    public final void reset() {
        flush();
        this.buffer = afA;
        this.aef = -1;
        this.ahd = -1;
        this.ahg = null;
        this.ahf = false;
    }
}
