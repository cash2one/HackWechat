package com.tencent.mm.plugin.s;

import android.util.Pair;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class f {
    List<g> ifb;
    List<Pair> ifc;
    RandomAccessFile opm;
    g opn;
    int opo;
    int opp;

    public final int w(ByteBuffer byteBuffer) {
        int read;
        Throwable e;
        if (this.opo >= this.opp) {
            return -1;
        }
        try {
            this.opm.seek(this.opn.start);
            byte[] bArr = new byte[this.opn.size];
            read = this.opm.read(bArr);
            try {
                if (read < this.opn.size) {
                    return -1;
                }
                bArr[0] = (byte) 0;
                bArr[1] = (byte) 0;
                bArr[2] = (byte) 0;
                bArr[3] = (byte) 1;
                int i = 0;
                while (i < read) {
                    if (bArr[i] == Byte.MIN_VALUE && i + 4 < read && bArr[i + 1] == (byte) 0 && bArr[i + 2] == (byte) 0) {
                        bArr[i + 3] = (byte) 0;
                        bArr[i + 4] = (byte) 1;
                    }
                    i++;
                }
                byteBuffer.clear();
                byteBuffer.put(bArr, 0, read).flip();
                return read;
            } catch (Exception e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.Mp4Extractor", e, "read sample data error", new Object[0]);
                return read;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            read = -1;
            e = th;
            x.printErrStackTrace("MicroMsg.Mp4Extractor", e, "read sample data error", new Object[0]);
            return read;
        }
    }
}
