package com.tencent.mm.plugin.card.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements e {
    public c kIR;
    public int kIS;
    public ak kIT = new ak(new 1(this), false);
    public List<WeakReference<a>> kIv = new ArrayList();

    public final void release() {
        this.kIS = 0;
        atS();
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
        ar.CG().b(1382, (e) this);
        ar.CG().b(1275, (e) this);
    }

    public final void a(b bVar, q qVar) {
        if (!g(bVar)) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
            R(2, "");
        } else if (!l.isNetworkAvailable(ac.getContext())) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
            R(-1, "");
        } else if (this.kIS >= 3) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.kIS + ",cannot request!");
        } else {
            a(bVar.atF(), qVar);
            this.kIS++;
        }
    }

    public final void a(q qVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", Integer.valueOf(qVar.scene));
        List<CardInfo> aup = am.auA().aup();
        if (aup.isEmpty()) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", Integer.valueOf(qVar.scene));
            return;
        }
        for (CardInfo cardInfo : aup) {
            if (cardInfo == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", Integer.valueOf(qVar.scene));
            } else if (qVar == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
            } else {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", cardInfo.atF(), Integer.valueOf(qVar.scene));
                if (g(cardInfo)) {
                    int i;
                    String atF = cardInfo.atF();
                    i wg = am.auP().wg(atF);
                    if (wg == null) {
                        i = 1;
                    } else {
                        List wh = am.auO().wh(atF);
                        if (wh.isEmpty()) {
                            i = 1;
                        } else if (wh.size() < wg.field_lower_bound) {
                            this.kIR = c.kXw;
                            i = 1;
                        } else if (a(wg)) {
                            this.kIR = c.kXq;
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", cardInfo.atF(), Integer.valueOf(qVar.scene));
                    } else {
                        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", Integer.valueOf(qVar.scene));
                        a(cardInfo.atF(), qVar);
                    }
                } else {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", cardInfo.atF());
                }
            }
        }
    }

    public final void b(com.tencent.mm.plugin.card.model.g gVar) {
        String str = gVar.field_card_id;
        com.tencent.mm.plugin.card.model.l auO = am.auO();
        List wh;
        k wj;
        if (gVar.kLt) {
            wh = am.auO().wh(str);
            wj = auO.wj(str);
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", str);
            if (auO.iF(str)) {
                if (wj != null) {
                    x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", str);
                    b(c.kXv);
                }
                a(str, wh, c.kXv);
                return;
            }
            return;
        }
        List<com.tencent.mm.plugin.card.model.g.c> wh2 = gVar.kLu;
        if (wh2 == null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", str);
            return;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", str, Integer.valueOf(wh2.size()));
        wj = auO.wj(str);
        LinkedList linkedList = new LinkedList();
        for (com.tencent.mm.plugin.card.model.g.c cVar : wh2) {
            if (am.auO().bP(str, cVar.kLC)) {
                linkedList.add(b(str, cVar.kLC, c.kXv));
            }
        }
        if (wj != null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", str, wj.field_code_id);
            b(c.kXv);
        }
        if (!linkedList.isEmpty()) {
            C(linkedList);
        }
    }

    public static boolean a(i iVar) {
        if (System.currentTimeMillis() - iVar.field_fetch_time <= ((long) (iVar.field_expire_time_interval * 1000))) {
            return false;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(iVar.field_fetch_time), Integer.valueOf(iVar.field_expire_time_interval));
        return true;
    }

    public final void atS() {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
        if (!this.kIT.cfK()) {
            this.kIT.TG();
        }
    }

    private static boolean g(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.atC() != null && bVar.atC().vRt) {
            return true;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
        return false;
    }

    private void a(String str, q qVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneGetDynamicQrcode, cardId:" + str + ",scene :" + (qVar == null ? 0 : qVar.scene));
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        com.tencent.mm.ae.k aeVar = new ae(linkedList, qVar == null ? 0 : qVar.scene);
        ar.CG().a(1382, (e) this);
        ar.CG().a(aeVar, 0);
    }

    private void a(String str, List<k> list, c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (k kVar : list) {
            linkedList.add(b(str, kVar.field_code_id, cVar));
        }
        C(linkedList);
    }

    public final void a(String str, String str2, c cVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(b(str, str2, cVar));
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", Integer.valueOf(linkedList.size()), Integer.valueOf(cVar.action));
        C(linkedList);
    }

    private void C(LinkedList<auy> linkedList) {
        ar.CG().a(1275, (e) this);
        ar.CG().a(new ah(linkedList), 0);
    }

    private static auy b(String str, String str2, c cVar) {
        auy com_tencent_mm_protocal_c_auy = new auy();
        com_tencent_mm_protocal_c_auy.fGU = str;
        com_tencent_mm_protocal_c_auy.kLC = str2;
        com_tencent_mm_protocal_c_auy.wCK = new Long(System.currentTimeMillis() / 1000).intValue();
        com_tencent_mm_protocal_c_auy.wCL = cVar == null ? -1 : cVar.action;
        return com_tencent_mm_protocal_c_auy;
    }

    private void a(azg com_tencent_mm_protocal_c_azg) {
        if (com_tencent_mm_protocal_c_azg != null) {
            String str = com_tencent_mm_protocal_c_azg.fGU;
            if (am.auP().wg(str) == null) {
                am.auP().b(b(com_tencent_mm_protocal_c_azg));
            } else {
                am.auP().c(b(com_tencent_mm_protocal_c_azg), new String[0]);
            }
            List wh = am.auO().wh(str);
            if (!(wh.isEmpty() || !am.auO().iF(str) || this.kIR == null)) {
                a(str, wh, this.kIR);
            }
            Iterator it = com_tencent_mm_protocal_c_azg.wGn.iterator();
            while (it.hasNext()) {
                azf com_tencent_mm_protocal_c_azf = (azf) it.next();
                com.tencent.mm.sdk.e.c kVar = new k();
                kVar.field_card_id = str;
                kVar.field_code_id = com_tencent_mm_protocal_c_azf.kLC;
                kVar.field_code = com.tencent.mm.plugin.card.b.e.bW(str, com_tencent_mm_protocal_c_azf.data);
                am.auO().b(kVar);
            }
        }
    }

    private static i b(azg com_tencent_mm_protocal_c_azg) {
        i iVar = new i();
        iVar.field_card_id = com_tencent_mm_protocal_c_azg.fGU;
        iVar.field_lower_bound = com_tencent_mm_protocal_c_azg.wGi;
        iVar.field_expire_time_interval = com_tencent_mm_protocal_c_azg.wGl;
        iVar.field_need_insert_show_timestamp = com_tencent_mm_protocal_c_azg.wGj;
        iVar.field_show_expire_interval = com_tencent_mm_protocal_c_azg.wGm;
        iVar.field_show_timestamp_encrypt_key = com_tencent_mm_protocal_c_azg.wGk;
        iVar.field_fetch_time = System.currentTimeMillis();
        return iVar;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + ",NetSceneBase=" + (kVar != null ? kVar.getClass() : ""));
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + (kVar != null ? kVar.getType() : 0) + "  NetSceneBase=" + (kVar != null ? kVar.getClass() : ""));
            if (kVar instanceof ae) {
                R(i2, str);
                ar.CG().b(1382, (e) this);
                return;
            }
            ar.CG().b(1275, (e) this);
        } else if (kVar instanceof ae) {
            azg com_tencent_mm_protocal_c_azg = ((ae) kVar).kMe;
            if (com_tencent_mm_protocal_c_azg == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
                return;
            }
            a(com_tencent_mm_protocal_c_azg);
            a(this.kIR);
            ar.CG().b(1382, (e) this);
        } else {
            ar.CG().b(1275, (e) this);
        }
    }

    private void a(c cVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.c(cVar);
                    }
                }
            }
        }
    }

    public final void R(int i, String str) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
        if (this.kIv != null) {
            for (int i2 = 0; i2 < this.kIv.size(); i2++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.S(i, str);
                    }
                }
            }
        }
    }

    private void b(c cVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.b(cVar);
                    }
                }
            }
        }
    }
}
