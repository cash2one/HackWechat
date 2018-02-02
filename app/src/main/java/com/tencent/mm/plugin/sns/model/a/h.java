package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.io.OutputStream;

public final class h extends b {
    public h(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String KK(String str) {
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p(InputStream inputStream) {
        OutputStream iE;
        Throwable e;
        x.i("MicroMsg.SnsDownloadSightForAdShort", "download sight. %s ", new Object[]{f.mm(this.qYF.getPath() + this.qYF.bwf())});
        try {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            iE = FileOp.iE(f.mm(this.qYF.getPath() + this.qYF.bwf()));
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.qYQ.value = "";
                boolean z = false;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    if (read > this.qYR) {
                        this.qYR = read;
                        this.qYS = bh.Wo();
                    }
                    if (this.qYT == 0) {
                        this.qYT = bh.bz(this.qYU);
                    }
                    if (!i.JP(ae.FC())) {
                        break;
                    }
                    iE.write(bArr, 0, read);
                    this.qYZ += read;
                    if (a(this.qYZ, currentTimeMillis, this.qYQ)) {
                        currentTimeMillis = System.currentTimeMillis();
                        z = false;
                    } else {
                        z = true;
                    }
                }
                iE.close();
                inputStream.close();
                if (iE == null) {
                    return false;
                }
                try {
                    iE.close();
                    return false;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e2, "", new Object[0]);
                    return false;
                }
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            e2 = e4;
            iE = null;
            try {
                x.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e2, "snscdndownload fail : " + e2.getMessage(), new Object[0]);
                x.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e2, "", new Object[0]);
                if (iE == null) {
                    return false;
                }
                try {
                    iE.close();
                    return false;
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e22, "", new Object[0]);
                    return false;
                }
            } catch (Throwable th) {
                e22 = th;
                if (iE != null) {
                    try {
                        iE.close();
                    } catch (Throwable e5) {
                        x.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e5, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th2) {
            e22 = th2;
            iE = null;
            if (iE != null) {
                iE.close();
            }
            throw e22;
        }
    }

    public final boolean bwh() {
        FileOp.g(this.qYF.getPath(), this.qYF.bwf(), i.j(this.fHC));
        return true;
    }

    protected final int bwi() {
        return 2;
    }
}
