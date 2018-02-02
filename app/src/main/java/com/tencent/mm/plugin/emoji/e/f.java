package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class f {
    private static final c lvI;

    public static c cg(String str, String str2) {
        return b(str, str2, new Object[0]);
    }

    public static c b(String str, String str2, Object... objArr) {
        ar.Hg();
        String G = EmojiLogic.G(com.tencent.mm.z.c.Fp(), str, str2);
        if (bh.ov(G)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDy = true;
        aVar.hDA = true;
        aVar.hDC = G;
        aVar.hEd = objArr;
        return aVar.PK();
    }

    public static c o(String str, String str2, int i) {
        ar.Hg();
        String G = EmojiLogic.G(com.tencent.mm.z.c.Fp(), str, str2);
        if (bh.ov(G)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDy = true;
        aVar.hDA = true;
        aVar.hDC = G;
        aVar.hDH = i;
        aVar.hDG = i;
        return aVar.PK();
    }

    public static c aAT() {
        a aVar = new a();
        aVar.hDy = true;
        aVar.hDA = false;
        aVar.hDF = 3;
        return aVar.PK();
    }

    public static c c(String str, String str2, Object... objArr) {
        ar.Hg();
        String FC = com.tencent.mm.z.c.FC();
        ar.Hg();
        String G = EmojiLogic.G(com.tencent.mm.z.c.Fp(), str, str2);
        if (bh.ov(G)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDy = true;
        aVar.hDA = true;
        aVar.hDC = G;
        aVar.hDD = FC;
        aVar.hEd = objArr;
        return aVar.PK();
    }

    static {
        a aVar = new a();
        aVar.hDy = true;
        aVar.hDF = 1;
        aVar.hDX = false;
        lvI = aVar.PK();
    }

    public static c h(String str, Object... objArr) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDA = true;
        aVar.hDC = str;
        aVar.hEd = objArr;
        return aVar.PK();
    }

    public static c i(String str, Object... objArr) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDA = true;
        aVar.hDC = str;
        aVar.hEb = false;
        aVar.hEd = objArr;
        return aVar.PK();
    }

    public static c a(String str, int i, Object... objArr) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDA = true;
        aVar.hDC = str;
        aVar.hDH = i;
        aVar.hDG = i;
        aVar.hEd = objArr;
        return aVar.PK();
    }

    public static c ch(String str, String str2) {
        ar.Hg();
        String G = EmojiLogic.G(com.tencent.mm.z.c.Fp(), str, str2);
        if (bh.ov(G)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDy = true;
        aVar.hDA = true;
        aVar.hDC = G;
        aVar.hDY = true;
        return aVar.PK();
    }

    public static c ci(String str, String str2) {
        ar.Hg();
        String G = EmojiLogic.G(com.tencent.mm.z.c.Fp(), str, str2);
        if (bh.ov(G)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDy = true;
        aVar.hDA = true;
        aVar.hDC = G;
        aVar.hDY = false;
        return aVar.PK();
    }

    public static c g(String str, String str2, Object... objArr) {
        ar.Hg();
        String G = EmojiLogic.G(com.tencent.mm.z.c.Fp(), str, str2);
        if (bh.ov(G)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDy = false;
        aVar.hDA = true;
        aVar.hDC = G;
        aVar.hEd = objArr;
        return aVar.PK();
    }

    public static c h(String str, String str2, Object... objArr) {
        ar.Hg();
        String G = EmojiLogic.G(com.tencent.mm.z.c.Fp(), str, str2);
        if (bh.ov(G)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hDy = true;
        aVar.hDA = true;
        aVar.hDC = G;
        aVar.hEd = objArr;
        return aVar.PK();
    }
}
