package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.c.c;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import java.io.File;

class c$1 implements c {
    final /* synthetic */ c lxq;

    c$1(c cVar) {
        this.lxq = cVar;
    }

    public final void a(boolean z, Object... objArr) {
        boolean f;
        Throwable e;
        if (objArr == null || objArr.length < 2) {
            x.w("MicroMsg.emoji.EmojiAppMsgDownloadService", "extra obj error");
            return;
        }
        rw rwVar;
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        if (objArr[0] instanceof rw) {
            rwVar = (rw) objArr[0];
        } else {
            rwVar = null;
        }
        if (rwVar == null) {
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msginfo or  emojiInfo");
        } else if (z) {
            c cVar;
            File file;
            int bN;
            byte[] d;
            ar.Hg();
            String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", rwVar.vZL);
            String str = H + "_encrypt";
            if (booleanValue) {
                if (e.bN(str) > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str2;
                    String str3;
                    Object[] objArr2;
                    try {
                        f = a.f(Base64.encodeToString(bh.VD(rwVar.vZO), 0), str, H);
                        if (f) {
                            try {
                                com.tencent.mm.plugin.emoji.c.cm(7);
                            } catch (Exception e2) {
                                e = e2;
                                x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", new Object[]{bh.i(e)});
                                com.tencent.mm.plugin.emoji.c.cm(8);
                                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                if (f) {
                                    str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                    str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                    objArr2 = new Object[5];
                                    objArr2[0] = rwVar.vZL;
                                    objArr2[1] = Integer.valueOf(e.bN(str));
                                    objArr2[2] = g.bV(str) != null ? "" : g.bV(str);
                                    objArr2[3] = rwVar.vZO;
                                    objArr2[4] = rwVar.vZN;
                                    x.i(str2, str3, objArr2);
                                    com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 3, 0, 1, "", 1, "");
                                    b.deleteFile(str);
                                    cVar = this.lxq;
                                    c.bf(rwVar.vZL, 2);
                                    return;
                                }
                                b.deleteFile(str);
                                file = new File(H);
                                bN = e.bN(H);
                                d = e.d(H, 0, 10);
                                if (bN > 0) {
                                }
                                c.a(this.lxq, rwVar, booleanValue);
                                return;
                            }
                            x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (f) {
                                str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                objArr2 = new Object[5];
                                objArr2[0] = rwVar.vZL;
                                objArr2[1] = Integer.valueOf(e.bN(str));
                                if (g.bV(str) != null) {
                                }
                                objArr2[2] = g.bV(str) != null ? "" : g.bV(str);
                                objArr2[3] = rwVar.vZO;
                                objArr2[4] = rwVar.vZN;
                                x.i(str2, str3, objArr2);
                                com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 3, 0, 1, "", 1, "");
                                b.deleteFile(str);
                                cVar = this.lxq;
                                c.bf(rwVar.vZL, 2);
                                return;
                            }
                            b.deleteFile(str);
                        } else {
                            com.tencent.mm.plugin.emoji.c.cm(8);
                            x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (f) {
                                b.deleteFile(str);
                            } else {
                                str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                objArr2 = new Object[5];
                                objArr2[0] = rwVar.vZL;
                                objArr2[1] = Integer.valueOf(e.bN(str));
                                if (g.bV(str) != null) {
                                }
                                objArr2[2] = g.bV(str) != null ? "" : g.bV(str);
                                objArr2[3] = rwVar.vZO;
                                objArr2[4] = rwVar.vZN;
                                x.i(str2, str3, objArr2);
                                com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 3, 0, 1, "", 1, "");
                                b.deleteFile(str);
                                cVar = this.lxq;
                                c.bf(rwVar.vZL, 2);
                                return;
                            }
                        }
                    } catch (Throwable e3) {
                        Throwable th = e3;
                        f = false;
                        e = th;
                        x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", new Object[]{bh.i(e)});
                        com.tencent.mm.plugin.emoji.c.cm(8);
                        x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (f) {
                            b.deleteFile(str);
                            file = new File(H);
                            bN = e.bN(H);
                            d = e.d(H, 0, 10);
                            if (bN > 0) {
                            }
                            c.a(this.lxq, rwVar, booleanValue);
                            return;
                        }
                        str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                        str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                        objArr2 = new Object[5];
                        objArr2[0] = rwVar.vZL;
                        objArr2[1] = Integer.valueOf(e.bN(str));
                        if (g.bV(str) != null) {
                        }
                        objArr2[2] = g.bV(str) != null ? "" : g.bV(str);
                        objArr2[3] = rwVar.vZO;
                        objArr2[4] = rwVar.vZN;
                        x.i(str2, str3, objArr2);
                        com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 3, 0, 1, "", 1, "");
                        b.deleteFile(str);
                        cVar = this.lxq;
                        c.bf(rwVar.vZL, 2);
                        return;
                    }
                }
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[]{rwVar.vZL});
                com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 3, 1, 1, "", 1, "");
                cVar = this.lxq;
                c.bf(rwVar.vZL, 2);
                return;
            }
            file = new File(H);
            bN = e.bN(H);
            d = e.d(H, 0, 10);
            if (bN > 0 || d == null) {
                c.a(this.lxq, rwVar, booleanValue);
                return;
            }
            String i = g.i(file);
            if (bh.ov(i) || !i.equalsIgnoreCase(rwVar.vZL)) {
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", new Object[]{i, rwVar.vZL, rwVar.nfX});
                file.delete();
                cVar = this.lxq;
                c.bf(rwVar.vZL, 2);
                if (booleanValue) {
                    com.tencent.mm.plugin.emoji.c.cm(5);
                    com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 3, 0, 1, "", 1, "");
                    return;
                }
                com.tencent.mm.plugin.emoji.c.cm(5);
                com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 2, 0, 1, "", 1, "");
                return;
            }
            if (booleanValue) {
                com.tencent.mm.plugin.emoji.c.cm(4);
                com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 3, 0, 0, "", 0, "");
            } else {
                com.tencent.mm.plugin.emoji.c.cm(4);
                com.tencent.mm.plugin.emoji.c.a(rwVar.vZL, 2, 0, 0, "", 1, "");
            }
            int i2 = EmojiInfo.xAp;
            if (p.bo(d)) {
                i2 = EmojiInfo.xAo;
            } else {
                i2 = EmojiInfo.xAp;
            }
            EmojiInfo XU = i.aBE().lwL.XU(i);
            if (XU == null) {
                XU = new EmojiInfo();
                XU.field_md5 = i;
                XU.field_catalog = EmojiInfo.xAe;
                XU.field_size = e.bN(H);
            }
            XU.field_type = i2;
            XU.field_state = EmojiInfo.xAs;
            i.aBE().lwL.p(XU);
            c.bf(rwVar.vZL, 1);
            EmojiLogic.a(ac.getContext(), null, XU.Nr(), XU.pol, XU);
        } else {
            c.a(this.lxq, rwVar, booleanValue);
        }
    }
}
