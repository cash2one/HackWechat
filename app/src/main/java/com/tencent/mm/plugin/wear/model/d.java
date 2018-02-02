package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.plugin.wear.model.a.b;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d {
    b thW = new a();
    com.tencent.mm.plugin.wear.model.e.b thX = new com.tencent.mm.plugin.wear.model.e.b();
    public i thY = new i();
    j thZ = new j();
    p tia = new p();

    public final boolean bOy() {
        return bOz() != null && bOz().bOD().size() > 0;
    }

    public final b bOz() {
        if (this.thW.isAvailable() && this.thW.bOE()) {
            return this.thW;
        }
        return null;
    }

    public final boolean aV(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (!bOy()) {
            return false;
        }
        String format = String.format("/wechat/%s/%d", new Object[]{"phone", Long.valueOf(System.currentTimeMillis())});
        b bOz = bOz();
        if (bOz == null) {
            return false;
        }
        b.a t;
        if (bArr.length > 92160) {
            t = bOz.t(format, bArr);
        } else {
            t = bOz.s(format, bArr);
        }
        if (t.code == 0) {
            return true;
        }
        return false;
    }

    public final byte[] aW(byte[] bArr) {
        byte[] bArr2 = null;
        byte[] CF = this.thX.CF();
        if (!(bArr == null || CF == null)) {
            try {
                x.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[]{g.s(CF)});
                Key secretKeySpec = new SecretKeySpec(CF, "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(2, secretKeySpec);
                bArr2 = instance.doFinal(bArr);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
            }
        }
        return bArr2;
    }

    public final byte[] aX(byte[] bArr) {
        byte[] bArr2 = null;
        byte[] CF = this.thX.CF();
        if (!(bArr == null || CF == null)) {
            try {
                x.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[]{g.s(CF)});
                bArr2 = com.tencent.mm.plugin.wear.a.a.f(bArr, CF);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
            }
        }
        return bArr2;
    }
}
