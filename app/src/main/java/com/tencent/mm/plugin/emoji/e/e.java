package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class e {
    public static e lvG;
    private String aAM;
    boolean bgH = false;

    public static e aAR() {
        if (lvG == null) {
            synchronized (e.class) {
                lvG = new e();
            }
        }
        return lvG;
    }

    public final String aAS() {
        if (bh.ov(this.aAM)) {
            this.aAM = i.aBE().lwL.getKey();
        }
        return this.aAM;
    }

    public final boolean isEnable() {
        if (bh.ov(aAS())) {
            return false;
        }
        return true;
    }

    public final boolean c(EmojiInfo emojiInfo, boolean z) {
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
            return false;
        } else if (isEnable()) {
            String ckB = emojiInfo.ckB();
            if (com.tencent.mm.a.e.bO(ckB)) {
                boolean z2 = false;
                byte[] d = com.tencent.mm.a.e.d(ckB, 0, 10);
                if (d != null) {
                    try {
                        if (d.length >= 10) {
                            z2 = p.bp(d);
                        }
                    } catch (Throwable th) {
                        x.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                        z2 = false;
                    }
                }
                if (z || r2) {
                    int i;
                    long currentTimeMillis = System.currentTimeMillis();
                    int bN = com.tencent.mm.a.e.bN(ckB);
                    if (bN > 1024) {
                        i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    } else {
                        i = bN;
                    }
                    Object d2 = com.tencent.mm.a.e.d(ckB, 0, bN);
                    Object aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.d(ckB, 0, i), aAS().getBytes(), true, false);
                    if (bh.bw(aesCryptEcb) || bh.bw(d2)) {
                        i = -1;
                    } else {
                        System.arraycopy(aesCryptEcb, 0, d2, 0, i);
                        i = com.tencent.mm.a.e.b(ckB, d2, d2.length);
                    }
                    if (i == 0) {
                        g.pQN.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        g.pQN.a(252, 6, 1, false);
                        emojiInfo.field_reserved4 |= EmojiInfo.xAz;
                        emojiInfo.field_size = bN;
                        i.aBE().lwL.q(emojiInfo);
                        x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(d2.length), Long.valueOf(r8)});
                        return true;
                    }
                    x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    g.pQN.a(252, 3, 1, false);
                    return false;
                }
                x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
                return true;
            }
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", new Object[]{ckB});
            emojiInfo.field_reserved4 = 0;
            i.aBE().lwL.q(emojiInfo);
            return false;
        } else {
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
            return false;
        }
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return null;
        }
        String ckB = emojiInfo.ckB();
        Object d = com.tencent.mm.a.e.d(ckB, 0, com.tencent.mm.a.e.bN(ckB));
        if (com.tencent.mm.a.e.bN(ckB) <= 0 || d == null || d.length < 10) {
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", new Object[]{ckB});
            return null;
        }
        Object obj = new byte[10];
        System.arraycopy(d, 0, obj, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz || p.bp(obj)) {
            return d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int bN = com.tencent.mm.a.e.bN(ckB);
        if (bN > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            bN = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] d2 = com.tencent.mm.a.e.d(ckB, 0, bN);
        Object obj2 = null;
        if (!bh.ov(aAS())) {
            obj2 = AesEcb.aesCryptEcb(d2, aAS().getBytes(), false, false);
        }
        if (bh.bw(obj2) || bh.bw(d)) {
            g.pQN.a(252, 2, 1, false);
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", new Object[]{ckB});
            return d;
        }
        System.arraycopy(obj2, 0, d, 0, bN);
        g.pQN.a(252, 0, System.currentTimeMillis() - currentTimeMillis, false);
        g.pQN.a(252, 5, 1, false);
        x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(d.length), Long.valueOf(r8)});
        return d;
    }

    public final boolean b(EmojiInfo emojiInfo) {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return false;
        }
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        String ckB = emojiInfo.ckB();
        int bN = com.tencent.mm.a.e.bN(ckB);
        if (bN <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            i = bN;
        }
        Object d = com.tencent.mm.a.e.d(ckB, 0, i);
        if (com.tencent.mm.a.e.bN(ckB) > 0 && d != null && d.length >= 10) {
            Object obj = new byte[10];
            System.arraycopy(d, 0, obj, 0, 10);
            if (p.bp(obj)) {
                z = true;
            } else if ((emojiInfo.field_reserved4 & EmojiInfo.xAz) == EmojiInfo.xAz) {
                byte[] bArr = null;
                if (!bh.ov(aAS())) {
                    bArr = AesEcb.aesCryptEcb(d, aAS().getBytes(), false, false);
                }
                if (!bh.bw(bArr) && p.bp(bArr)) {
                    z = true;
                }
            }
            x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z)});
            return z;
        }
        z = false;
        x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z)});
        return z;
    }
}
