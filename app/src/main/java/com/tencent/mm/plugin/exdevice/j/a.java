package com.tencent.mm.plugin.exdevice.j;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a {
    private final int lZl = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    private ByteBuffer lZm;
    private ByteBuffer lZn;

    public a(int i) {
        boolean z;
        boolean z2 = true;
        x.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = " + i);
        Assert.assertTrue(i >= 0);
        this.lZn = ByteBuffer.allocate(i);
        this.lZm = this.lZn.asReadOnlyBuffer();
        if (this.lZn != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.lZm == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
    }

    public final int getSize() {
        x.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.lZn.position());
        return this.lZn.position();
    }

    public final short readShort() {
        if (getSize() <= 1) {
            throw new IOException("There is only one byte in array");
        }
        short s = this.lZm.getShort();
        x.d("MicroMsg.exdevice.AutoBuffer", "getShort = " + s);
        return s;
    }

    public final void I(byte[] bArr, int i) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr.length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (bArr.length >= i + 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.lZm.remaining() < i) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        x.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0" + " byteCount = " + i);
        this.lZm.get(bArr, 0, i);
    }

    public final void J(byte[] bArr, int i) {
        boolean z = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0" + " byteCount = " + i);
        if (i > this.lZn.remaining()) {
            x.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
            x.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.lZn.capacity());
            ByteBuffer allocate = ByteBuffer.allocate((this.lZn.capacity() + i) + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            int position = this.lZm.position();
            allocate.put(this.lZn.array());
            allocate.put(bArr, 0, i);
            this.lZn = allocate;
            this.lZm = allocate.asReadOnlyBuffer();
            this.lZm.position(position);
            return;
        }
        this.lZn.put(bArr, 0, i);
    }
}
