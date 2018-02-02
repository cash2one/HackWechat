package com.tencent.mm.plugin.appbrand.r.d;

import com.tencent.mm.plugin.appbrand.r.d.d.a;
import com.tencent.mm.plugin.appbrand.r.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
    protected static byte[] jUd = new byte[0];
    protected boolean jUe;
    protected a jUf;
    private ByteBuffer jUg;
    protected boolean jUh;

    public e(a aVar) {
        this.jUf = aVar;
        this.jUg = ByteBuffer.wrap(jUd);
    }

    public e(d dVar) {
        this.jUe = dVar.alW();
        this.jUf = dVar.alY();
        this.jUg = dVar.alV();
        this.jUh = dVar.alX();
    }

    public final boolean alW() {
        return this.jUe;
    }

    public final a alY() {
        return this.jUf;
    }

    public final boolean alX() {
        return this.jUh;
    }

    public ByteBuffer alV() {
        return this.jUg;
    }

    public final void dl(boolean z) {
        this.jUe = z;
    }

    public final void a(a aVar) {
        this.jUf = aVar;
    }

    public void u(ByteBuffer byteBuffer) {
        this.jUg = byteBuffer;
    }

    public final void dm(boolean z) {
        this.jUh = z;
    }

    public final void e(d dVar) {
        ByteBuffer alV = dVar.alV();
        if (this.jUg == null) {
            this.jUg = ByteBuffer.allocate(alV.remaining());
            alV.mark();
            this.jUg.put(alV);
            alV.reset();
        } else {
            alV.mark();
            this.jUg.position(this.jUg.limit());
            this.jUg.limit(this.jUg.capacity());
            if (alV.remaining() > this.jUg.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(alV.remaining() + this.jUg.capacity());
                this.jUg.flip();
                allocate.put(this.jUg);
                allocate.put(alV);
                this.jUg = allocate;
            } else {
                this.jUg.put(alV);
            }
            this.jUg.rewind();
            alV.reset();
        }
        this.jUe = dVar.alW();
    }

    public String toString() {
        return "Framedata{ optcode:" + this.jUf + ", fin:" + this.jUe + ", payloadlength:[pos:" + this.jUg.position() + ", len:" + this.jUg.remaining() + "], payload:" + Arrays.toString(b.uO(new String(this.jUg.array()))) + "}";
    }
}
