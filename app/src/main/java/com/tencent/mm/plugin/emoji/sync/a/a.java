package com.tencent.mm.plugin.emoji.sync.a;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import java.io.File;
import java.security.Key;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a extends d {
    private EmojiInfo kqm;
    private String lAa;
    private String lAb;
    private String lAc;
    private String lAd;
    private com.tencent.mm.plugin.emoji.d.a lAe;
    private com.tencent.mm.aq.a.b.a lAf;
    private String lyT;
    private String lyU;
    private String lyx;
    private e lzY;
    private String lzZ;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (bh.ov(str)) {
            x.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
        }
        this.lzZ = str;
        this.lAa = str2;
        this.lAb = str3;
        this.lyT = str4;
        this.lAc = str5;
        this.lAd = str6;
        this.lyx = str7;
        this.lyU = str8;
        this.kqm = i.aBE().lwL.XU(this.lzZ);
        if (this.kqm == null) {
            this.kqm = new EmojiInfo();
            this.kqm.field_md5 = this.lzZ;
            this.kqm.field_cdnUrl = this.lAa;
            this.kqm.field_thumbUrl = this.lAb;
            this.kqm.field_designerID = this.lyT;
            this.kqm.field_encrypturl = this.lAc;
            this.kqm.field_aeskey = this.lAd;
            this.kqm.field_groupId = this.lyx;
        }
        if (bh.ov(this.lAa)) {
            this.lAa = this.kqm.field_cdnUrl;
        } else {
            this.kqm.field_cdnUrl = this.lAa;
        }
        if (bh.ov(this.lAc)) {
            this.lAc = this.kqm.field_encrypturl;
            this.lAd = this.kqm.field_aeskey;
        } else {
            this.kqm.field_encrypturl = this.lAc;
            this.kqm.field_aeskey = this.lAd;
        }
        if (!bh.ov(this.lyT)) {
            this.kqm.field_designerID = this.lyT;
        }
        if (!bh.ov(this.lyx)) {
            this.kqm.field_groupId = this.lyx;
        }
        if (!bh.ov(this.lAb)) {
            this.kqm.field_thumbUrl = this.lAb;
        }
        if (!bh.ov(this.lyU)) {
            this.kqm.field_activityid = this.lyU;
        }
        this.lAe = new com.tencent.mm.plugin.emoji.d.a();
        this.lAf = new com.tencent.mm.aq.a.b.a();
    }

    public final void run() {
        String str;
        if (this.lzY != null) {
            this.lzY.yC(this.lzZ);
        } else {
            x.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        }
        x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", new Object[]{this.kqm.Nr(), this.kqm.field_cdnUrl, this.kqm.field_thumbUrl, this.kqm.field_designerID, this.kqm.field_encrypturl, this.kqm.field_groupId});
        if (bh.ov(this.lAa) && bh.ov(this.lAc)) {
            g.pQN.a(164, 10, 1, false);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.lzZ);
            ar.CG().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
            aCf();
        } else {
            boolean z;
            String str2 = this.lAa;
            if (bh.ov(this.lAc) || bh.ov(this.lAd)) {
                str = str2;
                z = false;
            } else {
                str = this.lAc;
                z = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b lA = this.lAe.lA(str);
            if (lA == null || bh.bw(lA.data)) {
                x.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                aCf();
            } else {
                x.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                byte[] bArr = lA.data;
                if (z) {
                    try {
                        byte[] bArr2 = lA.data;
                        byte[] decode = Base64.decode(Base64.encodeToString(bh.VD(this.lAd), 0).getBytes(), 0);
                        Key secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                        bArr = instance.doFinal(bArr2);
                    } catch (Throwable e) {
                        x.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", new Object[]{bh.i(e)});
                    }
                }
                Bitmap decodeByteArray = com.tencent.mm.sdk.platformtools.d.decodeByteArray(bArr, 10, 10);
                boolean a = this.lAf.a(str, bArr, f.h(this.kqm.ckB(), new Object[0]));
                File file = new File(this.kqm.ckB());
                if (decodeByteArray != null && a && file.exists()) {
                    str = com.tencent.mm.a.g.i(file);
                    if (bh.ov(str) || !str.equalsIgnoreCase(this.kqm.Nr())) {
                        if (file.exists()) {
                            file.delete();
                        }
                        aCf();
                        if (z) {
                            c.cm(8);
                            c.a(this.lzZ, 3, 0, 1, this.lyx, 1, this.lyT);
                        } else {
                            c.cm(5);
                            c.a(this.lzZ, 2, 0, 1, this.lyx, 1, this.lyT);
                        }
                    } else {
                        this.kqm.field_size = bArr.length;
                        this.kqm.field_state = EmojiInfo.xAs;
                        this.kqm.field_temp = 0;
                        this.kqm.field_catalog = EmojiInfo.xAk;
                        this.kqm.field_type = EmojiLogic.aj(bArr);
                        int ckI = i.aBE().lwL.ckI();
                        this.kqm.field_idx = ckI < n.aBn() ? n.aBn() : ckI + 1;
                        i.aBE().lwL.p(this.kqm);
                        com.tencent.mm.storage.emotion.a aVar = i.aBE().lwM;
                        if (!com.tencent.mm.storage.emotion.a.ckh()) {
                            i.aBE().lwM.cki();
                        }
                        com.tencent.mm.sdk.b.b cqVar = new cq();
                        cqVar.fqQ.fqR = this.lzZ;
                        cqVar.fqQ.fpr = 0;
                        cqVar.fqQ.success = true;
                        com.tencent.mm.sdk.b.a.xef.m(cqVar);
                        if (z) {
                            c.cm(7);
                            c.cm(4);
                            c.a(this.lzZ, 3, 0, 0, this.lyx, 0, this.lyT);
                        } else {
                            c.cm(2);
                            c.cm(4);
                            c.a(this.lzZ, 2, 0, 0, this.lyx, 1, this.lyT);
                        }
                        com.tencent.mm.plugin.emoji.e.e.aAR().c(this.kqm, true);
                    }
                } else {
                    aCf();
                    if (z) {
                        c.cm(8);
                        c.a(this.lzZ, 3, 0, 1, this.lyx, 1, this.lyT);
                    } else {
                        c.cm(3);
                        c.a(this.lzZ, 2, 1, 1, this.lyx, 1, this.lyT);
                    }
                }
            }
        }
        if (!bh.ov(this.kqm.field_thumbUrl)) {
            b lA2 = this.lAe.lA(this.kqm.field_thumbUrl);
            if (lA2 != null) {
                com.tencent.mm.aq.a.b.a aVar2 = this.lAf;
                str = this.kqm.field_thumbUrl;
                byte[] bArr3 = lA2.data;
                String str3 = this.kqm.field_thumbUrl;
                aVar2.a(str, bArr3, f.h(this.kqm.ckB() + "_cover", new Object[0]));
            }
        }
    }

    private void aCf() {
        x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
        com.tencent.mm.sdk.b.b cqVar = new cq();
        cqVar.fqQ.fqR = this.lzZ;
        cqVar.fqQ.fpr = 0;
        cqVar.fqQ.success = false;
        com.tencent.mm.sdk.b.a.xef.m(cqVar);
        if (this.kqm != null) {
            x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", new Object[]{this.kqm.Nr()});
            this.kqm.field_state = EmojiInfo.xAt;
            this.kqm.field_catalog = EmojiInfo.xAe;
            i.aBE().lwL.p(this.kqm);
        }
    }

    public final String getKey() {
        return this.lzZ;
    }

    public final void a(e eVar) {
        this.lzY = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (!(bh.ov(this.lzZ) || bh.ov(aVar.lzZ) || !this.lzZ.equals(aVar.lzZ))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
