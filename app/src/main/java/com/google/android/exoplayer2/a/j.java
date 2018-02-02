package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class j implements d {
    private int aef = -1;
    private ByteBuffer agF = afA;
    private int ahd = -1;
    private boolean ahh;
    private ByteBuffer buffer = afA;
    private int encoding = 0;

    public final boolean r(int i, int i2, int i3) {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new a(i, i2, i3);
        } else if (this.ahd == i && this.aef == i2 && this.encoding == i3) {
            return false;
        } else {
            this.ahd = i;
            this.aef = i2;
            this.encoding = i3;
            if (i3 == 2) {
                this.buffer = afA;
            }
            return true;
        }
    }

    public final boolean isActive() {
        return (this.encoding == 0 || this.encoding == 2) ? false : true;
    }

    public final int iy() {
        return this.aef;
    }

    public final int iz() {
        return 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        switch (this.encoding) {
            case Integer.MIN_VALUE:
                i = (i / 3) * 2;
                break;
            case 3:
                i *= 2;
                break;
            case 1073741824:
                i /= 2;
                break;
            default:
                throw new IllegalStateException();
        }
        if (this.buffer.capacity() < i) {
            this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        switch (this.encoding) {
            case Integer.MIN_VALUE:
                while (position < limit) {
                    this.buffer.put(byteBuffer.get(position + 1));
                    this.buffer.put(byteBuffer.get(position + 2));
                    position += 3;
                }
                break;
            case 3:
                while (position < limit) {
                    this.buffer.put((byte) 0);
                    this.buffer.put((byte) ((byteBuffer.get(position) & 255) - 128));
                    position++;
                }
                break;
            case 1073741824:
                for (i = position; i < limit; i += 4) {
                    this.buffer.put(byteBuffer.get(i + 2));
                    this.buffer.put(byteBuffer.get(i + 3));
                }
                break;
            default:
                throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
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
        this.ahd = -1;
        this.aef = -1;
        this.encoding = 0;
    }
}
