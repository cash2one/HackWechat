package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j implements e {
    private List<WeakReference<a>> kIv = new ArrayList();
    public ArrayList<String> kJs = new ArrayList();
    public ArrayList<String> kJt = new ArrayList();
    public af kJu = new af();
    public HashMap<String, Runnable> kJv = new LinkedHashMap();

    public j() {
        ar.CG().a(907, this);
        this.kJs.clear();
        this.kJt.clear();
        this.kJv.clear();
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

    private void a(String str, b bVar) {
        x.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
        if (this.kIv != null) {
            if (this.kJs.contains(str) || this.kJt.contains(str)) {
                for (int i = 0; i < this.kIv.size(); i++) {
                    WeakReference weakReference = (WeakReference) this.kIv.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            if (this.kJs.contains(str)) {
                                aVar.b(str, bVar);
                            } else if (this.kJt.contains(str)) {
                                aVar.wa(str);
                            }
                        }
                    }
                }
                return;
            }
            x.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
        }
    }

    private void bN(String str, String str2) {
        x.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
        if (this.kIv != null) {
            if (!this.kJs.contains(str) || this.kJt.contains(str)) {
                x.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
                return;
            }
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bO(str, str2);
                    }
                }
            }
        }
    }

    private void vY(String str) {
        x.i("MicroMsg.CardMarkCodeMgr", "removeId()");
        if (this.kJs.contains(str) && !this.kJt.contains(str)) {
            this.kJs.remove(str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is " + str);
        }
        if (!this.kJs.contains(str) && this.kJt.contains(str)) {
            this.kJt.remove(str);
            Runnable runnable = (Runnable) this.kJv.get(str);
            this.kJv.remove(str);
            this.kJu.removeCallbacks(runnable);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
        }
    }

    private void vZ(String str) {
        x.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
        if (this.kJt.contains(str)) {
            this.kJt.remove(str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
        }
        if (this.kJv.containsKey(str)) {
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
            Runnable runnable = (Runnable) this.kJv.get(str);
            this.kJv.remove(str);
            this.kJu.removeCallbacks(runnable);
        }
    }

    public final void A(String str, int i, int i2) {
        x.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
        vZ(str);
        if (!this.kJs.contains(str)) {
            this.kJs.add(str);
        }
        g(str, i, 1, i2);
    }

    public final void aV(String str, int i) {
        x.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
        vZ(str);
        this.kJt.add(str);
        Runnable 1 = new 1(this, str, 0, 0, i);
        this.kJu.postDelayed(1, (long) (bh.getInt(g.zZ().F("ShareCard", "UnMarkDelay"), 0) * 1000));
        this.kJv.put(str, 1);
        x.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + str + " system.time:" + System.currentTimeMillis());
    }

    static void g(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
            return;
        }
        x.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
        ar.CG().a(new f(str, i, i2, i3), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        f fVar;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof f) {
                fVar = (f) kVar;
                b bVar = new b();
                bVar.kJA = fVar.kJA;
                bVar.kJB = fVar.kJB;
                bVar.kJC = fVar.kJC;
                bVar.kJD = fVar.kJD;
                bVar.kJE = fVar.kJE;
                x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + fVar.kNg);
                x.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + bVar.kJA + " mark_succ:" + bVar.kJB + " mark_card_id:" + bVar.kJC + " expire_time:" + bVar.kJD + " pay_qrcode_wording:" + bVar.kJE);
                a(fVar.kNg, bVar);
                vY(fVar.kNg);
            }
        } else if (kVar instanceof f) {
            fVar = (f) kVar;
            x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + fVar.kNg);
            bN(fVar.kNg, str);
            vY(fVar.kNg);
        }
    }
}
