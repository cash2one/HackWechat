package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.bq.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public final class c extends b {
    private static int progress;
    private String filePath;
    private int hlp = 0;
    private byte[] key;
    public x koS = new x();
    private y koT = new y();
    private f krA = null;
    private byte[] krB;
    private int offset = 0;
    private int start = 0;
    private int type;

    public c(String str, int i, LinkedList<er> linkedList, String str2, f fVar, byte[] bArr) {
        this.koS.ktR = str;
        this.koS.ktS = i;
        this.type = i;
        if (i == 1) {
            es esVar = new es();
            esVar.ksP = linkedList;
            esVar.ksO = linkedList.size();
            try {
                this.krB = esVar.toByteArray();
                this.hlp = this.krB.length;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.BakSceneDataPush", e, "", new Object[0]);
            }
        } else {
            this.filePath = str2;
            this.hlp = e.bN(str2);
        }
        int i2 = this.hlp % 16;
        this.koS.ktT = (16 - i2) + this.hlp;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[]{this.koS.ktR, Integer.valueOf(this.koS.ktS), Integer.valueOf(this.hlp), Integer.valueOf(this.koS.ktT)});
        this.krA = fVar;
        this.key = bArr;
    }

    public static void setProgress(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[]{Integer.valueOf(i)});
        progress = i;
    }

    public final boolean apQ() {
        int i;
        byte[] bArr;
        long j = 524288;
        if (this.type == 1) {
            i = this.hlp;
            bArr = this.krB;
        } else {
            if (((long) (this.hlp - this.offset)) <= 524288) {
                j = (long) (this.hlp - this.offset);
            }
            i = (int) j;
            bArr = null;
            int i2 = 3;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0 && bArr == null) {
                    if (!bh.ov(this.filePath)) {
                        String str = this.filePath;
                        ar.Hg();
                        if (str.startsWith(com.tencent.mm.z.c.Fp())) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[]{this.filePath.substring(this.filePath.lastIndexOf("/") + 1)});
                            EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(r4);
                            if (yc == null || (yc.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
                                bArr = e.d(this.filePath, this.offset, i);
                                i2 = i3;
                            } else {
                                bArr = new byte[i];
                                System.arraycopy(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(yc), this.offset, bArr, 0, i);
                                i2 = i3;
                            }
                        }
                    }
                    bArr = e.d(this.filePath, this.offset, i);
                    i2 = i3;
                } else if (bArr == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[]{Integer.valueOf(this.offset), Integer.valueOf(i)});
                }
            }
            if (bArr == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[]{Integer.valueOf(this.offset), Integer.valueOf(i)});
            }
        }
        this.start = this.offset;
        this.offset = i + this.start;
        if (this.key != null) {
            boolean z;
            byte[] bArr2 = this.key;
            if (this.offset == this.hlp) {
                z = true;
            } else {
                z = false;
            }
            bArr = AesEcb.aesCryptEcb(bArr, bArr2, true, z);
        }
        this.koS.ktU = this.start;
        this.koS.ktV = (bArr == null ? 0 : bArr.length) + this.start;
        this.koS.ksB = new com.tencent.mm.bq.b(bArr);
        this.koS.ktX = progress;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[]{this.koS.ktR, Integer.valueOf(this.hlp), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.koS.ktV)});
        return super.apQ();
    }

    public final a apH() {
        return this.koT;
    }

    public final a apI() {
        return this.koS;
    }

    public final void mL(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[]{this.koT.ktR, Integer.valueOf(this.koT.ktS), Integer.valueOf(this.koT.ktU), Integer.valueOf(this.koT.ktV), Integer.valueOf(this.koT.ktm)});
        if (this.koT.ktm != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[]{Integer.valueOf(this.koT.ktm)});
            f(4, this.koT.ktm, "error");
            return;
        }
        this.krA.a(this.koS.ktV - this.koS.ktU, this.hlp, this);
        if (this.offset == this.hlp) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[]{this.koS.ktR, Integer.valueOf(this.hlp)});
            f(0, 0, "success");
            return;
        }
        apQ();
    }

    public final int getType() {
        return 5;
    }
}
