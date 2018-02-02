package com.tencent.mm.plugin.wear.model.e;

import android.graphics.Bitmap;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.bq.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bxw;
import com.tencent.mm.protocal.c.bxx;
import com.tencent.mm.protocal.c.byo;
import com.tencent.mm.protocal.c.byp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class g extends a {
    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE));
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final byte[] n(int i, byte[] bArr) {
        Throwable e;
        InputStream bk;
        byte[] bArr2 = null;
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL) {
            bxw com_tencent_mm_protocal_c_bxw = new bxw();
            try {
                com_tencent_mm_protocal_c_bxw.aF(bArr);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e2, "", new Object[0]);
            }
            bxx com_tencent_mm_protocal_c_bxx = new bxx();
            Bitmap NL = h.NL(com_tencent_mm_protocal_c_bxw.vIy);
            if (NL != null) {
                com_tencent_mm_protocal_c_bxx.wYw = System.currentTimeMillis();
                byte[] M = h.M(NL);
                x.i("MicroMsg.Wear.HttpImageServer", "return avatar data username=%s", com_tencent_mm_protocal_c_bxw.vIy);
                com_tencent_mm_protocal_c_bxx.ksB = new b(M);
                try {
                    return com_tencent_mm_protocal_c_bxx.toByteArray();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e3, "", new Object[0]);
                    return bArr2;
                }
            }
            x.w("MicroMsg.Wear.HttpImageServer", "get avatar fail, %s", com_tencent_mm_protocal_c_bxw.vIy);
            return bArr2;
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED) {
            try {
                EmojiInfo yc = ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yc(new String(bArr, "utf8"));
                if (yc == null) {
                    return bArr2;
                }
                if (yc.Yz()) {
                    return h.M(yc.fo(ac.getContext()));
                }
                if (yc.field_catalog != EmojiGroupInfo.xAb) {
                    return ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().a(yc);
                }
                try {
                    bk = EmojiInfo.bk(ac.getContext(), yc.getName());
                    try {
                        bArr2 = com.tencent.mm.loader.stub.b.d(bk);
                        e.c(bk);
                        return bArr2;
                    } catch (Exception e4) {
                        e3 = e4;
                        try {
                            x.e("MicroMsg.Wear.HttpImageServer", "exception:%s", bh.i(e3));
                            e.c(bk);
                            return bArr2;
                        } catch (Throwable th) {
                            e3 = th;
                            e.c(bk);
                            throw e3;
                        }
                    }
                } catch (Exception e5) {
                    e3 = e5;
                    bk = bArr2;
                    x.e("MicroMsg.Wear.HttpImageServer", "exception:%s", bh.i(e3));
                    e.c(bk);
                    return bArr2;
                } catch (Throwable th2) {
                    e3 = th2;
                    bk = bArr2;
                    e.c(bk);
                    throw e3;
                }
            } catch (Throwable e32) {
                x.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e32, "", new Object[0]);
                return bArr2;
            }
        } else if (i != TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE) {
            return bArr2;
        } else {
            byo com_tencent_mm_protocal_c_byo = new byo();
            try {
                com_tencent_mm_protocal_c_byo.aF(bArr);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e22, "", new Object[0]);
            }
            ar.Hg();
            cf dH = com.tencent.mm.z.c.Fa().dH(com_tencent_mm_protocal_c_byo.wYH);
            String m;
            if (com_tencent_mm_protocal_c_byo.wYL) {
                byp com_tencent_mm_protocal_c_byp = new byp();
                com_tencent_mm_protocal_c_byp.wYw = System.currentTimeMillis();
                com.tencent.mm.aq.e bi;
                if (dH.field_isSend == 1) {
                    bi = o.Pw().bi(dH.field_msgId);
                    m = o.Pw().m(o.Pw().d(bi), "", "");
                    if (!FileOp.bO(m)) {
                        m = o.Pw().m(bi.hzQ, "", "");
                    }
                } else {
                    bi = o.Pw().bh(dH.field_msgSvrId);
                    if (bi.Pd()) {
                        if (bi.Pe()) {
                            m = o.Pw().m(o.Pw().d(bi), "", "");
                        }
                        m = bArr2;
                        if (bh.ov(m)) {
                            String m2 = o.Pw().m(bi.hzQ, "", "");
                            if (FileOp.bO(m2)) {
                                m = m2;
                            }
                        }
                    }
                    m = bArr2;
                }
                if (bh.ov(m)) {
                    return bArr2;
                }
                com_tencent_mm_protocal_c_byp.ksB = new b(FileOp.d(m, 0, -1));
                try {
                    return com_tencent_mm_protocal_c_byp.toByteArray();
                } catch (IOException e6) {
                    return bArr2;
                }
            }
            m = o.Pw().lm(dH.field_imgPath);
            if (bh.ov(m)) {
                return bArr2;
            }
            byp com_tencent_mm_protocal_c_byp2 = new byp();
            com_tencent_mm_protocal_c_byp2.wYw = System.currentTimeMillis();
            com_tencent_mm_protocal_c_byp2.ksB = new b(FileOp.d(m, 0, -1));
            try {
                return com_tencent_mm_protocal_c_byp2.toByteArray();
            } catch (IOException e7) {
                return bArr2;
            }
        }
    }
}
