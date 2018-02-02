package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l implements d {
    private int aef = -1;
    float aew = 1.0f;
    private ByteBuffer agF = afA;
    private k ahO;
    private ShortBuffer ahP = this.buffer.asShortBuffer();
    long ahQ;
    long ahR;
    private int ahd = -1;
    private boolean ahh;
    private ByteBuffer buffer = afA;
    float pitch = 1.0f;

    public final boolean r(int i, int i2, int i3) {
        if (i3 != 2) {
            throw new a(i, i2, i3);
        } else if (this.ahd == i && this.aef == i2) {
            return false;
        } else {
            this.ahd = i;
            this.aef = i2;
            return true;
        }
    }

    public final boolean isActive() {
        return Math.abs(this.aew - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f;
    }

    public final int iy() {
        return this.aef;
    }

    public final int iz() {
        return 2;
    }

    public final void b(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.ahQ += (long) remaining;
            k kVar = this.ahO;
            int remaining2 = asShortBuffer.remaining() / kVar.aht;
            int i = (kVar.aht * remaining2) * 2;
            kVar.bZ(remaining2);
            asShortBuffer.get(kVar.ahz, kVar.ahG * kVar.aht, i / 2);
            kVar.ahG += remaining2;
            kVar.iW();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int i2 = (this.ahO.ahH * this.aef) * 2;
        if (i2 > 0) {
            if (this.buffer.capacity() < i2) {
                this.buffer = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
                this.ahP = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.ahP.clear();
            }
            k kVar2 = this.ahO;
            ShortBuffer shortBuffer = this.ahP;
            remaining2 = Math.min(shortBuffer.remaining() / kVar2.aht, kVar2.ahH);
            shortBuffer.put(kVar2.ahB, 0, kVar2.aht * remaining2);
            kVar2.ahH -= remaining2;
            System.arraycopy(kVar2.ahB, remaining2 * kVar2.aht, kVar2.ahB, 0, kVar2.aht * kVar2.ahH);
            this.ahR += (long) i2;
            this.buffer.limit(i2);
            this.agF = this.buffer;
        }
    }

    public final void iA() {
        k kVar = this.ahO;
        int i = kVar.ahG;
        int i2 = kVar.ahH + ((int) ((((((float) i) / (kVar.aew / kVar.pitch)) + ((float) kVar.ahI)) / kVar.pitch) + 0.5f));
        kVar.bZ((kVar.ahw * 2) + i);
        for (int i3 = 0; i3 < (kVar.ahw * 2) * kVar.aht; i3++) {
            kVar.ahz[(kVar.aht * i) + i3] = (short) 0;
        }
        kVar.ahG += kVar.ahw * 2;
        kVar.iW();
        if (kVar.ahH > i2) {
            kVar.ahH = i2;
        }
        kVar.ahG = 0;
        kVar.ahJ = 0;
        kVar.ahI = 0;
        this.ahh = true;
    }

    public final ByteBuffer iB() {
        ByteBuffer byteBuffer = this.agF;
        this.agF = afA;
        return byteBuffer;
    }

    public final boolean it() {
        return this.ahh && (this.ahO == null || this.ahO.ahH == 0);
    }

    public final void flush() {
        this.ahO = new k(this.ahd, this.aef);
        this.ahO.aew = this.aew;
        this.ahO.pitch = this.pitch;
        this.agF = afA;
        this.ahQ = 0;
        this.ahR = 0;
        this.ahh = false;
    }

    public final void reset() {
        this.ahO = null;
        this.buffer = afA;
        this.ahP = this.buffer.asShortBuffer();
        this.agF = afA;
        this.aef = -1;
        this.ahd = -1;
        this.ahQ = 0;
        this.ahR = 0;
        this.ahh = false;
    }
}
