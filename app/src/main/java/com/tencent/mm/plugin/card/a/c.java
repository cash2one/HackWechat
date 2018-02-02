package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    private int kIA;
    private int kIB;
    private int kIC = 60;
    private boolean kID = false;
    private ak kIE = new ak(new 1(this), false);
    private ak kIF = new ak(new a(this) {
        final /* synthetic */ c kIG;

        {
            this.kIG = r1;
        }

        public final boolean uF() {
            x.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
            c cVar = this.kIG;
            x.i("MicroMsg.CardCodeMgr", "onCodeChange()");
            if (cVar.kIv != null) {
                for (int i = 0; i < cVar.kIv.size(); i++) {
                    WeakReference weakReference = (WeakReference) cVar.kIv.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.atT();
                        }
                    }
                }
            }
            this.kIG.atR();
            return true;
        }
    }, false);
    List<WeakReference<a>> kIv = new ArrayList();
    String kIw = "";
    public LinkedList<String> kIx = new LinkedList();
    public int kIy;
    private int kIz;

    public final void release() {
        ar.CG().b(577, this);
        this.kIx.clear();
        this.kID = false;
        this.kIw = "";
        this.kIy = 0;
        this.kIz = 0;
        this.kIA = 0;
        this.kIB = 0;
        atQ();
        atS();
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

    private void onSuccess() {
        x.i("MicroMsg.CardCodeMgr", "onSuccess()");
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.onSuccess();
                    }
                }
            }
        }
    }

    private void vU(String str) {
        x.i("MicroMsg.CardCodeMgr", "onFail()");
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.vU(str);
                    }
                }
            }
        }
    }

    public final String getCode() {
        if (this.kIx == null || this.kIx.size() == 0) {
            x.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return "";
        } else if (this.kIy >= this.kIx.size()) {
            x.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            vV(this.kIw);
            return "";
        } else {
            if (this.kIA >= this.kIx.size() - this.kIy) {
                x.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
                vV(this.kIw);
            }
            x.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.kIy + " request_count:" + this.kIA + " codes size:" + this.kIx.size());
            LinkedList linkedList = this.kIx;
            int i = this.kIy;
            this.kIy = i + 1;
            return (String) linkedList.get(i);
        }
    }

    public final boolean isEmpty() {
        if (this.kIx == null || this.kIx.size() == 0) {
            x.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return true;
        } else if (this.kIy < this.kIx.size()) {
            return false;
        } else {
            x.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            return true;
        }
    }

    public final void vV(String str) {
        if (this.kID) {
            x.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
        } else if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
        } else {
            x.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id " + str);
            this.kID = true;
            this.kIw = str;
            ar.CG().a(new ac(this.kIw), 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof ac) {
                this.kID = false;
                x.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.kIw);
                ac acVar = (ac) kVar;
                this.kIz = acVar.kIz;
                this.kIA = acVar.kIA;
                this.kIB = acVar.kIB;
                if (acVar.kIx != null) {
                    this.kIx.clear();
                    this.kIx.addAll(acVar.kIx);
                    this.kIy = 0;
                }
                onSuccess();
                atP();
                if (this.kIB != 0) {
                    atR();
                }
            }
        } else if (kVar instanceof ac) {
            this.kID = false;
            x.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.kIw);
            vU(str);
        }
    }

    public final void atP() {
        atQ();
        x.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.kIz);
        if (this.kIz <= 0 || TextUtils.isEmpty(this.kIw)) {
            x.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
            return;
        }
        long j = (long) (this.kIz * 1000);
        this.kIE.J(j, j);
        x.i("MicroMsg.CardCodeMgr", "start request code timer!");
    }

    private void atQ() {
        x.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
        if (!this.kIE.cfK()) {
            this.kIE.TG();
        }
    }

    public final void atR() {
        atS();
        x.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.kIB);
        if (this.kIB > 0) {
            long j = (long) (this.kIB * 1000);
            this.kIF.J(j, j);
            x.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
            return;
        }
        j = (long) (this.kIC * 1000);
        this.kIF.J(j, j);
        x.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    }

    public final void atS() {
        x.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
        if (!this.kIF.cfK()) {
            this.kIF.TG();
        }
    }
}
