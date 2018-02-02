package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;

public abstract class a {
    public abstract List<Integer> bOG();

    protected abstract byte[] n(int i, byte[] bArr);

    public final void b(int i, int i2, int i3, byte[] bArr) {
        if (zC(i3) && bArr != null) {
            bArr = com.tencent.mm.plugin.wear.model.a.bOt().thH.aW(bArr);
            if (bArr == null) {
                x.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
                return;
            }
        }
        byte[] n = n(i3, bArr);
        if (bOH()) {
            if (zB(i3)) {
                n = com.tencent.mm.plugin.wear.model.a.bOt().thH.aX(n);
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(i);
                dataOutputStream.writeInt(i2);
                dataOutputStream.writeInt(i3);
                if (n == null || n.length <= 0) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(n.length);
                    dataOutputStream.write(n);
                }
                n = byteArrayOutputStream.toByteArray();
                x.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(n.length)});
                if (zD(i3)) {
                    e.post(new 1(this, n), "WearSendResponseTask");
                } else {
                    com.tencent.mm.plugin.wear.model.a.bOt().thH.aV(n);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    protected boolean zB(int i) {
        return false;
    }

    protected boolean zC(int i) {
        return false;
    }

    public boolean zD(int i) {
        return false;
    }

    public boolean bOH() {
        return true;
    }
}
