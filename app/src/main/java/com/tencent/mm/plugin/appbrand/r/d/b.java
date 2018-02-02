package com.tencent.mm.plugin.appbrand.r.d;

import com.tencent.mm.plugin.appbrand.r.c.c;
import com.tencent.mm.plugin.appbrand.r.d.d.a;
import java.nio.ByteBuffer;

public final class b extends e implements a {
    static final ByteBuffer jTU = ByteBuffer.allocate(0);
    private int code;
    private String jTV;

    public b() {
        super(a.jUb);
        dl(true);
    }

    public b(int i, String str) {
        String str2;
        super(a.jUb);
        dl(true);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i != 1005) {
            byte[] uO = com.tencent.mm.plugin.appbrand.r.f.b.uO(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(uO.length + 2);
            allocate2.put(allocate);
            allocate2.put(uO);
            allocate2.rewind();
            u(allocate2);
        } else if (str2.length() > 0) {
            throw new com.tencent.mm.plugin.appbrand.r.c.b("A close frame must have a closecode if it has a reason");
        }
    }

    public final int alU() {
        return this.code;
    }

    public final String getMessage() {
        return this.jTV;
    }

    public final String toString() {
        return super.toString() + "code: " + this.code;
    }

    public final void u(ByteBuffer byteBuffer) {
        super.u(byteBuffer);
        this.code = 1005;
        ByteBuffer alV = super.alV();
        alV.mark();
        if (alV.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(alV.getShort());
            allocate.position(0);
            this.code = allocate.getInt();
            if (this.code == 1006 || this.code == 1015 || this.code == 1005 || this.code > 4999 || this.code < 1000 || this.code == 1004) {
                throw new c("closecode must not be sent over the wire: " + this.code);
            }
        }
        alV.reset();
        if (this.code == 1005) {
            this.jTV = com.tencent.mm.plugin.appbrand.r.f.b.v(super.alV());
            return;
        }
        allocate = super.alV();
        int position = allocate.position();
        try {
            allocate.position(allocate.position() + 2);
            this.jTV = com.tencent.mm.plugin.appbrand.r.f.b.v(allocate);
            allocate.position(position);
        } catch (Throwable e) {
            throw new c(e);
        } catch (Throwable th) {
            allocate.position(position);
        }
    }

    public final ByteBuffer alV() {
        if (this.code == 1005) {
            return jTU;
        }
        return super.alV();
    }
}
