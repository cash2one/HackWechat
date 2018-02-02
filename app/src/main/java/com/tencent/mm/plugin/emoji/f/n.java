package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.at;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private final int irz;
    public byte[] lyZ;
    public int lzb;
    private boolean lzc;
    private ArrayList<so> lzd;
    public final int mType;

    public n(int i, int i2) {
        this(i, null, i2);
    }

    public n(int i, byte[] bArr, int i2) {
        this(i, bArr, i2, false);
    }

    public n(int i, byte[] bArr, int i2, boolean z) {
        this.lzc = false;
        this.lzd = new ArrayList();
        this.lyZ = null;
        a aVar = new a();
        aVar.hmj = new aby();
        aVar.hmk = new abz();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionlist";
        aVar.hmi = 411;
        aVar.hml = i.CTRL_INDEX;
        aVar.hmm = 1000000210;
        this.gJQ = aVar.JZ();
        this.lyZ = bArr;
        this.mType = i;
        this.irz = i2;
        this.lzc = z;
    }

    public final int getType() {
        return 411;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        aby com_tencent_mm_protocal_c_aby = (aby) this.gJQ.hmg.hmo;
        if (this.lyZ != null) {
            com_tencent_mm_protocal_c_aby.vHG = com.tencent.mm.platformtools.n.N(this.lyZ);
        } else {
            com_tencent_mm_protocal_c_aby.vHG = new bdn();
        }
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", com_tencent_mm_protocal_c_aby.vHG == null ? "Buf is NULL" : com_tencent_mm_protocal_c_aby.vHG.toString());
        com_tencent_mm_protocal_c_aby.vLh = this.mType;
        com_tencent_mm_protocal_c_aby.rYW = this.irz;
        if (this.mType == 7) {
            com_tencent_mm_protocal_c_aby.wkG = this.lzb;
        }
        return a(eVar, this.gJQ, this);
    }

    public final abz aBU() {
        return this.gJQ == null ? null : (abz) this.gJQ.hmh.hmo;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + i2 + "   errCode:" + i3);
        if (this.mType == 8) {
            if (i2 == 0 && i3 == 0) {
                ar.Hg();
                c.CU().a(w.a.xni, Long.valueOf(System.currentTimeMillis()));
            } else {
                ar.Hg();
                c.CU().a(w.a.xni, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            }
        }
        if (this.mType == 11) {
            if (i2 == 0 && i3 == 0) {
                ar.Hg();
                c.CU().a(w.a.xnm, Long.valueOf(System.currentTimeMillis()));
            } else {
                ar.Hg();
                c.CU().a(w.a.xnm, Long.valueOf((System.currentTimeMillis() - 28800000) + 600000));
            }
            com.tencent.mm.plugin.emoji.model.i.aBE().lwO.a(this.mType, aBU());
        }
        if (i2 == 0 || i2 == 4) {
            abz com_tencent_mm_protocal_c_abz = (abz) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_abz.vHG != null) {
                this.lyZ = com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_abz.vHG);
            }
            if (this.mType == 8) {
                if (i3 == 0) {
                    aBV();
                    r(this.lzd);
                    ar.Hg();
                    c.CU().a(w.a.xni, Long.valueOf(System.currentTimeMillis()));
                } else if (i3 == 2) {
                    aBV();
                    ((aby) ((b) qVar).hmg.hmo).vHG = ((abz) ((b) qVar).hmh.hmo).vHG;
                    a(this.hmA, this.gJT);
                } else if (i3 == 3) {
                    if (this.lzd != null) {
                        this.lzd.clear();
                    }
                    ((aby) ((b) qVar).hmg.hmo).vHG = new bdn();
                    a(this.hmA, this.gJT);
                }
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public static f a(abz com_tencent_mm_protocal_c_abz) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
        if (com_tencent_mm_protocal_c_abz == null) {
            return null;
        }
        f fVar = new f();
        if (com_tencent_mm_protocal_c_abz != null) {
            fVar.lxB = com_tencent_mm_protocal_c_abz.wkH;
            List arrayList = new ArrayList();
            if (!(com_tencent_mm_protocal_c_abz.wkI == null || com_tencent_mm_protocal_c_abz.wkI.isEmpty())) {
                Object[] toArray = com_tencent_mm_protocal_c_abz.wkI.toArray();
                if (toArray != null && toArray.length > 0) {
                    for (Object obj : toArray) {
                        if (obj != null && (obj instanceof so)) {
                            so soVar = (so) obj;
                            if (!(soVar == null || bh.ov(soVar.vIR))) {
                                arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(soVar));
                            }
                        }
                    }
                }
            }
            fVar.lxC = arrayList;
            fVar.lxD = com_tencent_mm_protocal_c_abz.wkJ;
            fVar.lxE = com_tencent_mm_protocal_c_abz.wkL;
            Collection collection = com_tencent_mm_protocal_c_abz.wkT;
            if (fVar.lxG == null) {
                fVar.lxG = new LinkedList();
                fVar.lxG.addAll(collection);
            }
            fVar.lxF = com_tencent_mm_protocal_c_abz.wkP;
        }
        return fVar;
    }

    protected final int Bh() {
        return 100;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    private void aBV() {
        abz aBU = aBU();
        if (aBU == null || aBU.wkI == null || aBU.wkI.size() <= 0) {
            x.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
        } else {
            this.lzd.addAll(aBU.wkI);
        }
    }

    private void r(ArrayList<so> arrayList) {
        com.tencent.mm.storage.emotion.a aVar = com.tencent.mm.plugin.emoji.model.i.aBE().lwM;
        if (aVar == null) {
            x.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
            return;
        }
        long j;
        h hVar;
        so soVar;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (aVar.gJP instanceof h) {
            h hVar2 = (h) aVar.gJP;
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", new Object[]{Long.valueOf(hVar2.dz(Thread.currentThread().getId()))});
            j = r4;
            hVar = hVar2;
        } else {
            j = -1;
            hVar = null;
        }
        Iterator it;
        EmojiGroupInfo emojiGroupInfo;
        if (arrayList == null || arrayList.size() <= 0) {
            it = aVar.cke().iterator();
            while (it.hasNext()) {
                emojiGroupInfo = (EmojiGroupInfo) it.next();
                if (emojiGroupInfo.field_sync > 0) {
                    x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[]{emojiGroupInfo.field_productID});
                    aVar.XQ(emojiGroupInfo.field_productID);
                }
            }
            aVar.XQ("com.tencent.xin.emoticon.tusiji");
        } else if (arrayList == null || arrayList.size() <= 0) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
        } else {
            Map ckd = aVar.ckd();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[]{Integer.valueOf(arrayList.size())});
            for (int i = 0; i < r13; i++) {
                soVar = (so) arrayList.get(i);
                if (soVar == null || bh.ov(soVar.vIR)) {
                    x.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                } else {
                    com.tencent.mm.sdk.e.c cVar;
                    x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[]{soVar.vIR});
                    arrayList2.add(soVar.vIR);
                    if (ckd.containsKey(soVar.vIR)) {
                        cVar = (EmojiGroupInfo) ckd.get(soVar.vIR);
                        if (cVar == null) {
                            cVar = new EmojiGroupInfo();
                        }
                        cVar.field_productID = soVar.vIR;
                    } else if (soVar.vIR.equals("com.tencent.xin.emoticon.tusiji")) {
                        cVar = (EmojiGroupInfo) ckd.get(String.valueOf(EmojiGroupInfo.xAb));
                        if (cVar == null) {
                            cVar = new EmojiGroupInfo();
                        }
                        cVar.field_productID = String.valueOf(EmojiGroupInfo.xAb);
                    } else {
                        cVar = new EmojiGroupInfo();
                        cVar.field_productID = soVar.vIR;
                    }
                    if (soVar.vIR.equals("com.tencent.xin.emoticon.tusiji")) {
                        cVar.field_flag = 0;
                        cVar.field_packName = "emoji_custom_all";
                        cVar.field_type = EmojiGroupInfo.TYPE_SYSTEM;
                    } else {
                        cVar.field_packName = soVar.war;
                        cVar.field_type = EmojiGroupInfo.xzY;
                    }
                    cVar.field_packIconUrl = soVar.nfT;
                    cVar.field_packGrayIconUrl = soVar.waE;
                    cVar.field_packCoverUrl = soVar.waz;
                    cVar.field_packDesc = soVar.was;
                    cVar.field_packAuthInfo = soVar.wat;
                    cVar.field_packPrice = soVar.wau;
                    cVar.field_packType = soVar.wav;
                    cVar.field_packFlag = soVar.waw;
                    cVar.field_packExpire = (long) soVar.waA;
                    cVar.field_packTimeStamp = (long) soVar.waZ;
                    cVar.field_sort = 1;
                    cVar.field_idx = i;
                    if (cVar.field_sync == 0) {
                        if (cVar.field_status == 7 && cVar.field_packStatus == 1) {
                            cVar.field_sync = 2;
                        } else {
                            cVar.field_sync = 1;
                        }
                    }
                    if (cVar.field_sync == 2) {
                        cVar.field_status = 7;
                    }
                    if (cVar.field_sync == 2 && !soVar.vIR.equals("com.tencent.xin.emoticon.tusiji")) {
                        com.tencent.mm.sdk.b.b atVar = new at();
                        atVar.foS.type = 1;
                        atVar.foS.foV = soVar.vIR;
                        com.tencent.mm.sdk.b.a.xef.m(atVar);
                        if (!atVar.foT.fnI) {
                            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[]{soVar.vIR});
                            cVar.field_sync = 1;
                        }
                    }
                    x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[]{cVar.field_productID, Long.valueOf(cVar.field_lastUseTime), Integer.valueOf(cVar.field_sort)});
                    aVar.a(cVar);
                }
            }
            for (EmojiGroupInfo emojiGroupInfo2 : ckd.values()) {
                if (!(emojiGroupInfo2 == null || bh.ov(emojiGroupInfo2.field_productID) || emojiGroupInfo2.field_productID.equals(String.valueOf(EmojiGroupInfo.xAc)))) {
                    if (emojiGroupInfo2.field_productID.equals(String.valueOf(EmojiGroupInfo.xAb))) {
                        if (!arrayList2.contains("com.tencent.xin.emoticon.tusiji")) {
                            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[]{"com.tencent.xin.emoticon.tusiji"});
                            arrayList3.add("com.tencent.xin.emoticon.tusiji");
                        }
                    } else if (!arrayList2.contains(emojiGroupInfo2.field_productID)) {
                        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[]{emojiGroupInfo2.field_productID});
                        arrayList3.add(emojiGroupInfo2.field_productID);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    aVar.XQ((String) it.next());
                }
            }
            aVar.b("event_update_group", 0, bh.cgy().toString());
        }
        if (hVar != null) {
            hVar.fS(j);
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - valueOf.longValue())});
        aVar.b("event_update_group", 0, bh.cgy().toString());
        ArrayList arrayList4;
        Iterator it2;
        if (!this.lzc) {
            ArrayList arrayList5 = (ArrayList) aVar.cko();
            if (arrayList5.size() > 0) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[]{Integer.valueOf(arrayList5.size())});
                arrayList4 = new ArrayList();
                it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!bh.ov(str)) {
                        if (str.equals(String.valueOf(EmojiGroupInfo.xAb))) {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                        } else {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(str));
                        }
                    }
                }
                com.tencent.mm.plugin.emoji.model.i.aBB().t(arrayList4);
                if (!com.tencent.mm.plugin.emoji.model.i.aBB().lzq.lzG) {
                    com.tencent.mm.plugin.emoji.model.i.aBB().lzq.aBZ();
                }
            }
        } else if (arrayList != null && arrayList.size() > 0) {
            x.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[]{Integer.valueOf(arrayList.size())});
            arrayList4 = new ArrayList();
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                soVar = (so) it2.next();
                if (!(soVar == null || bh.ov(soVar.vIR))) {
                    if (soVar.vIR.equals(String.valueOf(EmojiGroupInfo.xAb))) {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                    } else {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(soVar.vIR, (byte) 0));
                    }
                }
            }
            com.tencent.mm.plugin.emoji.model.i.aBB().t(arrayList4);
            if (!com.tencent.mm.plugin.emoji.model.i.aBB().lzq.lzG) {
                com.tencent.mm.plugin.emoji.model.i.aBB().lzq.aBZ();
            }
        }
    }
}
