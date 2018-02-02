package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.protocal.c.sz;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.z.ar;
import java.io.File;

public final class g extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;
    public String hBn;
    boolean hnr;
    private int irz;
    public String lyH;
    public String lyI;
    public String lyJ;
    private int lyK;
    private a lyL;
    EmojiGroupInfo lyM;

    static /* synthetic */ void ac(String str, boolean z) {
        if (!bh.ov(str)) {
            x.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "[cpan] publicStoreEmojiDownLoadTaskEvent productId:%s success:%b", new Object[]{str, Boolean.valueOf(z)});
            com.tencent.mm.sdk.b.b cqVar = new cq();
            cqVar.fqQ.fqR = str;
            cqVar.fqQ.fpr = 2;
            cqVar.fqQ.success = z;
            com.tencent.mm.sdk.b.a.xef.m(cqVar);
        }
    }

    private g(String str, String str2, String str3, int i, int i2) {
        this.hBn = "";
        this.lyL = new 1(this);
        this.lyH = str;
        this.lyI = str3;
        this.lyJ = str2;
        this.lyM = null;
        this.lyK = i;
        this.irz = i2;
        b.a aVar = new b.a();
        aVar.hmj = new sz();
        aVar.hmk = new ta();
        aVar.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
        aVar.hmi = 423;
        aVar.hml = c.CTRL_INDEX;
        aVar.hmm = 1000000213;
        this.gJQ = aVar.JZ();
    }

    public g(String str, String str2, String str3) {
        this(str, str2, str3, 0, 0);
    }

    public g(String str, String str2) {
        this(str, null, str2, 0, 0);
    }

    public g(String str) {
        this(str, null, "", 1, 0);
    }

    public g(String str, byte b) {
        this(str, null, "", 1, 1);
    }

    public final int getType() {
        return 423;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            if (this.irz == 0) {
                File file = new File(com.tencent.mm.compatible.util.e.gHs);
                if (!file.exists()) {
                    file.mkdirs();
                }
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                ar.Hg();
                this.hBn = d.a("downzip", currentTimeMillis, stringBuilder.append(com.tencent.mm.z.c.Cg()).toString(), "emoji");
                sg sgVar = ((ta) this.gJQ.hmh.hmo).wbq;
                i iVar = new i();
                iVar.field_mediaId = this.hBn;
                iVar.field_fullpath = com.tencent.mm.compatible.util.e.gHs + this.lyH;
                iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
                iVar.field_totalLen = sgVar.vYh;
                iVar.field_aesKey = sgVar.vZO;
                iVar.field_fileId = sgVar.nfX;
                iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                iVar.htt = this.lyL;
                iVar.field_needStorage = true;
                this.hnr = false;
                if (!com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1)) {
                    x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
                }
            } else {
                x.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
            }
            this.gOB.a(i2, i3, str, this);
            ar.CG().a(new k(this.lyH), 0);
            return;
        }
        this.gOB.a(i2, i3, str, this);
        f(this.lyH, -1, 0, this.hBn);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
        this.gOB = eVar2;
        if (this.irz == 0) {
            f(this.lyH, 6, 0, this.hBn);
        }
        sz szVar = (sz) this.gJQ.hmg.hmo;
        szVar.vIR = this.lyH;
        szVar.wbo = this.lyJ;
        szVar.wbp = this.lyK;
        szVar.rYW = this.irz;
        return a(eVar, this.gJQ, this);
    }

    static void f(String str, int i, int i2, String str2) {
        com.tencent.mm.plugin.emoji.model.i.aBG().f(str, i, i2, str2);
    }

    protected final void cancel() {
        super.cancel();
        this.hnr = true;
    }
}
