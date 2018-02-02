package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.a.e;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.byc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS));
        arrayList.add(Integer.valueOf(11004));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        InputStream open;
        Throwable e;
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS) {
            bya com_tencent_mm_protocal_c_bya = new bya();
            try {
                com_tencent_mm_protocal_c_bya.aF(bArr);
            } catch (IOException e2) {
            }
            if (b.cgX().xkx > com_tencent_mm_protocal_c_bya.wlf) {
                try {
                    open = ac.getContext().getAssets().open("color_emoji");
                    try {
                        byte[] d = com.tencent.mm.loader.stub.b.d(open);
                        e.c(open);
                        return d;
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            x.printErrStackTrace("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                            e.c(open);
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            e.c(open);
                            throw e;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    open = null;
                    x.printErrStackTrace("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                    e.c(open);
                    return null;
                } catch (Throwable th2) {
                    e = th2;
                    open = null;
                    e.c(open);
                    throw e;
                }
            }
        } else if (i == 11004) {
            a.zA(9);
            byb com_tencent_mm_protocal_c_byb = new byb();
            try {
                com_tencent_mm_protocal_c_byb.aF(bArr);
            } catch (IOException e5) {
            }
            byc com_tencent_mm_protocal_c_byc = new byc();
            if (((c) g.k(c.class)).getEmojiMgr() != null) {
                List<EmojiInfo> ye = ((c) g.k(c.class)).getEmojiMgr().ye(com_tencent_mm_protocal_c_byb.vPA);
                if (ye != null) {
                    for (EmojiInfo emojiInfo : ye) {
                        if (!bh.ov(emojiInfo.Nr())) {
                            com_tencent_mm_protocal_c_byc.vJK.add(emojiInfo.Nr());
                        }
                    }
                }
            }
            if (com_tencent_mm_protocal_c_byc.vJK.size() == 0) {
                com.tencent.mm.sdk.b.b tkVar = new tk();
                String[] strArr = new String[]{com_tencent_mm_protocal_c_byb.vPA};
                tkVar.fLY.fLZ = strArr;
                tkVar.fLY.fpr = 1;
                com.tencent.mm.sdk.b.a.xef.m(tkVar);
            }
            try {
                return com_tencent_mm_protocal_c_byc.toByteArray();
            } catch (IOException e6) {
            }
        }
        return null;
    }
}
