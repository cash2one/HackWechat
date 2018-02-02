package com.tencent.mm.protocal;

import com.tencent.mm.a.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class o$a extends d implements b {
    public int fDt = 0;
    public int fuL = 0;
    public int hOH = 0;
    public String vBA = "";
    public byte[] vBB = new byte[0];

    private byte[] cdJ() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(this.hOH);
            dataOutputStream.writeShort(this.vBA.getBytes().length);
            dataOutputStream.write(this.vBA.getBytes());
            dataOutputStream.writeShort(this.vBB.length);
            dataOutputStream.write(this.vBB);
            dataOutputStream.close();
        } catch (IOException e) {
            x.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + e.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] bf(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(this.fuL);
            dataOutputStream.writeByte(this.fDt);
            dataOutputStream.write(bArr);
            dataOutputStream.close();
        } catch (IOException e) {
            x.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + e.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final byte[] Hq() {
        byte[] cdJ = cdJ();
        PByteArray pByteArray = new PByteArray();
        c.a(pByteArray, cdJ, o.Tp(this.vBi));
        return bf(pByteArray.value);
    }

    public final int Hr() {
        return 10;
    }

    public final int getCmdId() {
        return 8;
    }

    public final boolean cdI() {
        return true;
    }

    public final boolean KH() {
        return false;
    }
}
