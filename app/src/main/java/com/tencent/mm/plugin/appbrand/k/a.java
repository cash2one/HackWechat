package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class a extends InputStream {
    public final ByteBuffer jGP;
    private int jGQ;

    public a(ByteBuffer byteBuffer) {
        this.jGP = byteBuffer;
    }

    public final int available() {
        return this.jGP.remaining();
    }

    public final int read() {
        return this.jGP.hasRemaining() ? this.jGP.get() & 255 : -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (!this.jGP.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.jGP.remaining());
        this.jGP.get(bArr, i, min);
        return min;
    }

    public final void close() {
        super.close();
        i(this.jGP);
    }

    public final synchronized void mark(int i) {
        this.jGQ = this.jGP.position();
    }

    public final synchronized void seek(int i) {
        this.jGP.position(i);
    }

    public final synchronized void reset() {
        this.jGP.position(this.jGQ);
    }

    public final boolean markSupported() {
        return true;
    }

    public static void i(ByteBuffer byteBuffer) {
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                Method declaredMethod = byteBuffer.getClass().getDeclaredMethod("free", new Class[0]);
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(byteBuffer, new Object[0]);
                declaredMethod.setAccessible(isAccessible);
            } catch (Exception e) {
                x.d("MicroMsg.ByteBufferBackedInputStream", "free ByteBuffer, exp = %s", new Object[]{e});
            }
        }
        System.gc();
    }
}
