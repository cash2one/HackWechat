package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.b.3;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.InputStream;
import java.io.OutputStream;

public final class d extends b {
    private long qZc = 0;
    private int qZd = 0;

    public d(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String KK(String str) {
        return str;
    }

    public final boolean bwg() {
        return false;
    }

    public final u b(u uVar) {
        this.qZc = 0;
        if (this.qZc > 0) {
            x.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.qZc);
            uVar.setRequestProperty("RANGE", "bytes=" + this.qZc + "-");
        }
        return uVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p(InputStream inputStream) {
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            String str = this.qYF.getPath() + this.qYF.bwf();
            x.i("MicroMsg.SnsDownloadAdSight", "getdatabegin " + FileOp.me(f.mm(str)));
            outputStream = FileOp.mc(str);
            long currentTimeMillis = System.currentTimeMillis();
            this.qYQ.value = "";
            int i = 1;
            Object obj = null;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                if (this.qYT == 0) {
                    this.qYT = bh.bz(this.qYU);
                }
                if (read > this.qYR) {
                    this.qYR = read;
                    this.qYS = bh.Wo();
                }
                if (!i.JP(ae.FC())) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                this.qYZ += read;
                if (this.qYZ - this.qZd > Downloads.SPLIT_RANGE_SIZE_WAP * i) {
                    ae.aNT().post(new 3(ae.bvq(), this.qYF.mediaId, str));
                    this.qZd = this.qYZ;
                    i++;
                }
                obj = 1;
                if (b.a(this.qYZ, currentTimeMillis, this.qYQ)) {
                    currentTimeMillis = System.currentTimeMillis();
                    obj = null;
                }
            }
            x.i("MicroMsg.SnsDownloadAdSight", "read data");
            outputStream.close();
            inputStream.close();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e, "", new Object[0]);
                }
            }
            return false;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "snscdndownload fail : " + e2.getMessage(), new Object[0]);
            x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e22, "", new Object[0]);
                }
            }
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e3, "", new Object[0]);
                }
            }
        }
    }

    public final boolean bwh() {
        long me = FileOp.me(this.qYF.getPath() + this.qYF.bwf());
        x.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + me + " " + this.qYW);
        if (me < ((long) this.qYW) + this.qZc) {
            return false;
        }
        FileOp.g(this.qYF.getPath(), this.qYF.bwf(), i.k(this.fHC));
        return true;
    }

    protected final int bwi() {
        return 4;
    }
}
