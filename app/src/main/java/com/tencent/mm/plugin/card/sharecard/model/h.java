package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.a.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.protocal.c.bic;
import com.tencent.mm.protocal.c.bid;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;

public final class h extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public h() {
        a aVar = new a();
        aVar.hmj = new bic();
        aVar.hmk = new bid();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecardsync";
        aVar.hmi = 906;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bic com_tencent_mm_protocal_c_bic = (bic) this.gJQ.hmg.hmo;
        ar.Hg();
        com_tencent_mm_protocal_c_bic.wLF = ((Long) c.CU().get(w.a.xor, Long.valueOf(0))).longValue();
    }

    public final int getType() {
        return 906;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(906), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            bid com_tencent_mm_protocal_c_bid = (bid) this.gJQ.hmh.hmo;
            List<bib> list = com_tencent_mm_protocal_c_bid.hdX == null ? null : com_tencent_mm_protocal_c_bid.hdX;
            String str2 = "MicroMsg.NetSceneShareCardSync";
            String str3 = "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bid.wLG);
            objArr[2] = Long.valueOf(com_tencent_mm_protocal_c_bid.wLE);
            x.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
                com.tencent.mm.plugin.card.sharecard.a.a auH = am.auH();
                x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[]{Boolean.valueOf(true)});
                synchronized (auH.gSF) {
                    auH.kIs.addAll(auH.kIt);
                    auH.kIt.clear();
                }
                auH.atO();
            } else {
                int i4 = 0;
                for (bib a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[]{Integer.valueOf(i4)});
                am.auH().atO();
            }
            ar.Hg();
            c.CU().a(w.a.xor, Long.valueOf(com_tencent_mm_protocal_c_bid.wLE));
            am.auH().kMV = com_tencent_mm_protocal_c_bid.kMV;
            if (com_tencent_mm_protocal_c_bid.wLG > 0) {
                x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bid.wLG)});
                com.tencent.mm.plugin.card.sharecard.a.a auH2 = am.auH();
                auH2.mHandler.post(new 2(auH2));
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gJT.a(i2, i3, str, this);
    }

    private static boolean a(bib com_tencent_mm_protocal_c_bib) {
        if (com_tencent_mm_protocal_c_bib == null) {
            x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
            return false;
        }
        x.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[]{com_tencent_mm_protocal_c_bib.fGU, Long.valueOf(com_tencent_mm_protocal_c_bib.wLE)});
        try {
            x.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bib.kNd)});
            switch (com_tencent_mm_protocal_c_bib.kNd) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    com.tencent.mm.plugin.card.sharecard.a.a auH = am.auH();
                    if (com_tencent_mm_protocal_c_bib != null) {
                        long j;
                        ShareCardInfo wv = am.auI().wv(com_tencent_mm_protocal_c_bib.fGU);
                        String str = "MicroMsg.ShareCardBatchGetCardMgr";
                        String str2 = "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = com_tencent_mm_protocal_c_bib.fGU;
                        if (wv == null) {
                            j = 0;
                        } else {
                            j = wv.field_updateSeq;
                        }
                        objArr[1] = Long.valueOf(j);
                        objArr[2] = Long.valueOf(com_tencent_mm_protocal_c_bib.wLE);
                        x.i(str, str2, objArr);
                        if (wv != null && wv.field_updateSeq == com_tencent_mm_protocal_c_bib.wLE) {
                            x.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
                            break;
                        }
                        com.tencent.mm.sdk.e.c b = n.b(com_tencent_mm_protocal_c_bib);
                        synchronized (auH.gSF) {
                            if (!auH.kIs.contains(b)) {
                                if (!auH.kIt.contains(b)) {
                                    auH.kIs.add(b);
                                    boolean b2 = am.auJ().b(b);
                                    x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[]{Boolean.valueOf(b2)});
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                    }
                    x.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
                    break;
                case 6:
                    com.tencent.mm.plugin.card.sharecard.a.a auH2 = am.auH();
                    if (com_tencent_mm_protocal_c_bib != null) {
                        com.tencent.mm.plugin.card.base.b wv2 = am.auI().wv(com_tencent_mm_protocal_c_bib.fGU);
                        am.auI().wu(com_tencent_mm_protocal_c_bib.fGU);
                        x.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + com_tencent_mm_protocal_c_bib.fGU);
                        if (wv2 != null) {
                            com.tencent.mm.plugin.card.sharecard.a.b.a(ac.getContext(), wv2);
                        } else {
                            x.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
                        }
                        auH2.asi();
                        break;
                    }
                    x.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
                    break;
                default:
                    x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bib.kNd)});
                    return false;
            }
            if (!(com_tencent_mm_protocal_c_bib.kNd == 0 || com_tencent_mm_protocal_c_bib.kNd == 5)) {
                ar.Hg();
                String str3 = (String) c.CU().get(w.a.xoz, "");
                ar.Hg();
                boolean booleanValue = ((Boolean) c.CU().get(w.a.xoA, Boolean.valueOf(false))).booleanValue();
                if (booleanValue && !TextUtils.isEmpty(str3) && str3.equals(com_tencent_mm_protocal_c_bib.fGU)) {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
                    l.auo();
                } else if (booleanValue) {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
                } else {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is false");
                }
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
