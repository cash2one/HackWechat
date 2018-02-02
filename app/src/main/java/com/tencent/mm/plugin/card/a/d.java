package com.tencent.mm.plugin.card.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.a.l.a;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d implements e, a, com.tencent.mm.plugin.card.base.d {
    public WeakReference<Context> Zt;
    public HashMap<a, Boolean> kIH = new HashMap();
    public HashMap<String, Boolean> kII = new HashMap();
    public HashMap<String, Boolean> kIJ = new HashMap();
    public b kIK = null;
    public boolean kIL = false;
    public String kIM;
    public List<WeakReference<a>> kIv = new ArrayList();

    public final void release() {
        ar.CG().b(910, (e) this);
        am.auH().b(this);
        b auz = am.auz();
        if (auz.kIv != null && this != null) {
            for (int i = 0; i < auz.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) auz.kIv.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.base.d dVar = (com.tencent.mm.plugin.card.base.d) weakReference.get();
                    if (dVar != null && dVar.equals(this)) {
                        auz.kIv.remove(weakReference);
                        break;
                    }
                }
            }
        }
        this.kIv.clear();
        this.kIH.clear();
        this.kIJ.clear();
        this.kIL = false;
    }

    public final void a(a aVar) {
        if (this.kIv == null) {
            this.kIv = new ArrayList();
        }
        if (aVar != null) {
            this.kIv.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kIv != null && aVar != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kIv.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public final void d(b bVar) {
        this.kIK = bVar;
        if (!(!this.kIL || this.kIK == null || bVar.atF() == null || bVar.atF().equals(this.kIK.atF()))) {
            this.kIL = false;
        }
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.kIH.get(aVar);
                    if (!(aVar == null || bool == null || bool.booleanValue())) {
                        aVar.f(bVar);
                    }
                }
            }
        }
    }

    public final void a(a aVar, boolean z) {
        if (this.kIH == null) {
            this.kIH = new HashMap();
        }
        this.kIH.put(aVar, Boolean.valueOf(z));
    }

    public final void c(a aVar) {
        if (this.kIH == null) {
            this.kIH = new HashMap();
        }
        this.kIH.remove(aVar);
    }

    public final void atM() {
        x.i("MicroMsg.CardConsumedMgr", "onDBchange()");
        if (this.kIK == null) {
            x.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
            return;
        }
        if (this.kIK.ath()) {
            b wv = am.auI().wv(this.kIK.atF());
        } else {
            Object wf = am.auA().wf(this.kIK.atF());
        }
        if (wv != null && wv.atC() != null && this.kIK != null && this.kIK.atC() != null) {
            x.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", Integer.valueOf(this.kIK.atC().status), Integer.valueOf(wv.atC().status), Boolean.valueOf(this.kIL), Boolean.valueOf(this.kIK.ath()));
            if (this.kIK.ath() && (this.kIK instanceof ShareCardInfo)) {
                x.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", Integer.valueOf(((ShareCardInfo) this.kIK).field_status));
            } else if (this.kIK.ath()) {
                x.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
            }
            if (wv.atC().status != r2) {
                atU();
                if (this.kIK.ath() && !this.kIL && wv.atC().status == 1) {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
                    Boolean bool = (Boolean) this.kII.get(this.kIK.atF());
                    if (bool == null || !bool.booleanValue()) {
                        x.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
                        long currentTimeMillis = System.currentTimeMillis();
                        Context context = (Context) this.Zt.get();
                        x.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kIK.atF());
                        com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.kIK);
                        this.kII.put(this.kIK.atF(), Boolean.valueOf(true));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(281);
                        iDKey.SetKey(30);
                        iDKey.SetValue(1);
                        IDKey iDKey2 = new IDKey();
                        iDKey2.SetID(281);
                        iDKey2.SetKey(31);
                        iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                        arrayList.add(iDKey);
                        arrayList.add(iDKey2);
                        g.pQN.a(arrayList, true);
                    } else {
                        x.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                    }
                    atW();
                } else if (this.kIK.ath() && this.kIL) {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
                } else {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
                    atV();
                }
                x.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
            }
            this.kIK = wv;
            e(this.kIK);
        }
    }

    public final void asi() {
        atU();
    }

    public final void a(com.tencent.mm.plugin.card.model.g gVar) {
        x.i("MicroMsg.CardConsumedMgr", "onChange()");
        x.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.kIK == null) {
            x.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
            atV();
            return;
        }
        x.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.kIK.atg() && gVar.field_card_id != null && gVar.field_card_id.equals(this.kIK.atF()) && gVar.kLs == 3) {
            x.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
            atV();
        } else if (!this.kIK.ath()) {
            x.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
            atV();
        } else if (gVar.kLs == 3 || !(gVar.field_card_id == null || !gVar.field_card_id.equals(this.kIK.atF()) || TextUtils.isEmpty(gVar.field_consumed_box_id))) {
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
            kg atC;
            if (gVar.field_card_id != null && gVar.field_card_id.equals(this.kIK.atF())) {
                b wv = am.auI().wv(this.kIK.atF());
                if (!(wv == null || wv.atC() == null)) {
                    int i = this.kIK.atC().status;
                    x.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", Integer.valueOf(i), Integer.valueOf(wv.atC().status), Integer.valueOf(((ShareCardInfo) this.kIK).field_status));
                    if (wv.atC().status != i) {
                        atU();
                    } else if (i != 1) {
                        x.i("MicroMsg.CardConsumedMgr", "share card oldState status is " + i);
                        atC = this.kIK.atC();
                        atC.status = 1;
                        ((ShareCardInfo) this.kIK).field_status = 1;
                        this.kIK.a(atC);
                        l.j(this.kIK);
                    }
                }
            } else if (gVar.field_card_id != null) {
                b wv2 = am.auI().wv(gVar.field_card_id);
                if (wv2 == null || wv2.atC() == null) {
                    x.w("MicroMsg.CardConsumedMgr", "tempCard is null");
                } else {
                    x.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", Integer.valueOf(wv2.atC().status), Integer.valueOf(wv2.field_status));
                    if (wv2.atC().status != 1) {
                        atC = wv2.atC();
                        atC.status = 1;
                        wv2.field_status = 1;
                        wv2.a(atC);
                        l.j(wv2);
                    }
                }
            }
            e(this.kIK);
            Boolean bool = (Boolean) this.kII.get(this.kIK.atF());
            if (bool == null || !bool.booleanValue()) {
                Context context = (Context) this.Zt.get();
                x.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kIK.atF());
                com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.kIK);
                this.kII.put(this.kIK.atF(), Boolean.valueOf(true));
                long currentTimeMillis2 = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                IDKey iDKey = new IDKey();
                iDKey.SetID(281);
                iDKey.SetKey(30);
                iDKey.SetValue(1);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(281);
                iDKey2.SetKey(31);
                iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                g.pQN.a(arrayList, true);
            } else {
                x.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
            }
            atW();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) kVar;
                if (TextUtils.isEmpty(dVar.kLN)) {
                    x.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
                } else {
                    vW(dVar.kLN);
                }
                this.kIL = false;
                x.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
                atV();
            }
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
            this.kIL = false;
            x.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
            atV();
        }
    }

    private void vW(String str) {
        x.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
        if (this.kIv != null) {
            int i = 0;
            boolean z = false;
            while (i < this.kIv.size()) {
                boolean z2;
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.kIH.get(aVar);
                    if (!(aVar == null || bool == null || !bool.booleanValue())) {
                        aVar.vX(str);
                        z2 = true;
                        i++;
                        z = z2;
                    }
                }
                z2 = z;
                i++;
                z = z2;
            }
            Boolean bool2 = (Boolean) this.kII.get(this.kIK.atF());
            if (z) {
                x.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
                this.kIM = "";
            } else if (bool2 != null && bool2.booleanValue()) {
                x.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
                this.kIM = str;
                this.kIJ.put(this.kIK.atF(), Boolean.valueOf(true));
            }
        }
    }

    private void e(b bVar) {
        x.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.f(bVar);
                    }
                }
            }
        }
    }

    private void atU() {
        x.i("MicroMsg.CardConsumedMgr", "doVibrate()");
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.atY();
                    }
                }
            }
        }
    }

    private void atV() {
        x.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.atZ();
                    }
                }
            }
        }
    }

    private void atW() {
        x.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
        atX();
    }

    private synchronized void atX() {
        if (this.kIL) {
            x.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is true, is doing NetSceneGetShareCardConsumedInfo. return");
        } else {
            x.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is false, do NetSceneGetShareCardConsumedInfo. ");
            this.kIL = true;
            ar.CG().a(new com.tencent.mm.plugin.card.sharecard.model.d(this.kIK.atF(), "", ""), 0);
        }
    }
}
