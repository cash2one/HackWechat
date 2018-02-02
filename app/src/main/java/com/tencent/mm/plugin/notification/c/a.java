package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.z.d;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.plugin.notification.d.b;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class a<T> implements c {
    public Context mContext;
    public b oTZ;
    protected FailSendMsgNotification oUa;
    protected boolean oUb;
    protected ArrayList<Long> oUc;
    protected ArrayList<Long> oUd;
    protected ArrayList<Long> oUe;
    private ArrayList<ak> oUf;
    private ak oUg;
    private c oUh;

    public abstract void K(ArrayList<Long> arrayList);

    public abstract String U(int i, int i2, int i3);

    public abstract long bD(T t);

    public abstract ArrayList<Long> bE(T t);

    public abstract void bgx();

    public abstract String cZ(int i, int i2);

    public abstract void dT(long j);

    public abstract boolean dU(long j);

    public abstract String da(int i, int i2);

    public abstract int getType();

    public abstract String ui(int i);

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, mMsgList.size:%d", Integer.valueOf(aVar.oTZ.oUk.size()));
        aVar.bgp();
        if (VERSION.SDK_INT >= 16) {
            aVar.oUa.GO(aVar.ui(aVar.oTZ.oUk.size()));
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, after check, mMsgList.size:%d", Integer.valueOf(aVar.oTZ.oUk.size()));
    }

    static /* synthetic */ void a(a aVar, long j) {
        while (!aVar.dU(j)) {
            aVar.oUd.add(Long.valueOf(j));
            x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, msg:%d not exist", Long.valueOf(j));
            aVar.bgl();
            j = aVar.oTZ.bgB();
            if (j == -1) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg error, finalMsgId is -1, may be resend finish");
                if (aVar.oUc.size() + aVar.oUd.size() >= aVar.oTZ.oUk.size()) {
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, resend finish");
                    aVar.bgm();
                    return;
                }
                return;
            }
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, finalMsgId:%d", Long.valueOf(j));
        aVar.dT(j);
        ak akVar = new ak(new 8(aVar, j), false);
        akVar.J(1800000, 1800000);
        aVar.oUf.add(akVar);
    }

    public a() {
        this.oTZ = null;
        this.oUa = null;
        this.oUb = false;
        this.mContext = null;
        this.oUc = null;
        this.oUd = null;
        this.oUe = null;
        this.oUf = new ArrayList();
        this.oUg = null;
        this.oUh = new 1(this);
        this.oTZ = new b();
        this.oUa = new FailSendMsgNotification(getType());
        this.oUb = false;
        this.mContext = ac.getContext();
        this.oUc = new ArrayList();
        this.oUd = new ArrayList();
        this.oUe = new ArrayList();
        this.oUa.oUT = new 2(this);
        this.oUa.oUU = new 3(this);
        this.oUa.oUV = new 4(this);
        bgj();
    }

    private void bgj() {
        this.oUg = new ak(Looper.getMainLooper(), new 5(this), true);
    }

    public final void bB(T t) {
        if (t != null) {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", Long.valueOf(bD(t)), bgs(), Boolean.valueOf(this.oUb));
            if (this.oUb) {
                if (this.oTZ.dW(bD(t)) && !this.oUd.contains(Long.valueOf(bD(t)))) {
                    this.oUd.add(Long.valueOf(bD(t)));
                }
                if (!this.oTZ.dW(bD(t))) {
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
                    this.oTZ.dV(bD(t));
                }
                bgl();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.oUc.size()), Integer.valueOf(this.oUd.size()));
                if (this.oUc.size() + this.oUd.size() < this.oTZ.oUk.size()) {
                    long bgB = this.oTZ.bgB();
                    if (bgB == -1) {
                        x.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(bgB));
                    bgw();
                    dS(bgB);
                    return;
                }
                bgm();
            } else if (this.oUe.contains(Long.valueOf(bD(t)))) {
                this.oUe.remove(Long.valueOf(bD(t)));
            } else if (t == null) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
            } else {
                Collection bE = bE(t);
                if (bE == null || bE.size() <= 0) {
                    x.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
                    return;
                }
                aTU();
                b bVar = this.oTZ;
                if (bE != null && bE.size() > 0) {
                    bVar.oUk.addAll(bE);
                }
                bgw();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", Integer.valueOf(this.oTZ.oUk.size()), bgs());
                g.pQN.h(11426, Integer.valueOf(getType()));
                ag.h(new 6(this), 1000);
            }
        }
    }

    private void bgk() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", Boolean.valueOf(f.bgI()));
        this.oUa.oUX = ui(this.oTZ.oUk.size());
        this.oUa.bgN();
        if (!f.bgI() && !this.oUa.oVc) {
            this.oUa.oUW = ui(this.oTZ.oUk.size());
            this.oUa.bgM();
            this.oUa.bgL();
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
            this.oUa.show();
            com.tencent.mm.sdk.b.a.xef.c(this.oUh);
            com.tencent.mm.sdk.b.a.xef.b(this.oUh);
        } else if (this.oUa.oVc) {
            this.oUa.bgM();
            this.oUa.bgL();
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
            this.oUa.GO(ui(this.oTZ.oUk.size()));
            com.tencent.mm.sdk.b.a.xef.c(this.oUh);
            com.tencent.mm.sdk.b.a.xef.b(this.oUh);
        } else {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", Boolean.valueOf(f.bgI()));
        }
    }

    public final void bC(T t) {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", Long.valueOf(bD(t)), bgs());
        if (this.oTZ.dW(bD(t))) {
            long bD = bD(t);
            if (this.oUe.contains(Long.valueOf(bD)) && this.oUd.contains(Long.valueOf(bD))) {
                x.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
                this.oUe.remove(Long.valueOf(bD));
                this.oUd.remove(Long.valueOf(bD));
            }
            if (this.oUb) {
                this.oUc.add(Long.valueOf(bD));
                bgl();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.oUc.size()), Integer.valueOf(this.oUd.size()));
                if (this.oUc.size() + this.oUd.size() < this.oTZ.oUk.size()) {
                    bD = this.oTZ.bgB();
                    if (bD == -1) {
                        x.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(bD));
                    bgw();
                    dS(bD);
                    return;
                }
                bgm();
                return;
            }
            this.oTZ.remove(bD(t));
            if (this.oTZ.oUk.size() == 0) {
                this.oUa.dismiss();
                aTU();
                b.uk(getType());
                return;
            }
            x.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
            this.oUa.GO(ui(this.oTZ.oUk.size()));
        }
    }

    private void bgl() {
        if (VERSION.SDK_INT >= 16) {
            this.oUa.oUX = ui(this.oTZ.oUk.size());
            if (this.oUd.size() <= 0) {
                this.oUa.GO(cZ(this.oTZ.oUk.size(), this.oUc.size() + this.oUd.size()));
            } else {
                this.oUa.GO(U(this.oTZ.oUk.size(), this.oUc.size() + this.oUd.size(), this.oUd.size()));
            }
        }
    }

    private void bgm() {
        this.oUb = false;
        x.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", Integer.valueOf(this.oTZ.oUk.size()), Integer.valueOf(this.oUd.size()), Integer.valueOf(this.oUc.size()));
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.oTZ.oUk.size()), Integer.valueOf(this.oUc.size()), Integer.valueOf(this.oUd.size()));
        bgp();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.oUc.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (!dU(l.longValue())) {
                arrayList.add(l);
            }
        }
        it = arrayList.iterator();
        while (it.hasNext()) {
            this.oUc.remove((Long) it.next());
        }
        arrayList.clear();
        it = this.oUd.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!dU(l.longValue())) {
                arrayList.add(l);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.oUd.remove((Long) it2.next());
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.oTZ.oUk.size()), Integer.valueOf(this.oUc.size()), Integer.valueOf(this.oUd.size()));
        if (this.oUd.size() <= 0 || VERSION.SDK_INT < 16) {
            b.uk(getType());
        }
        g.pQN.h(11425, Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.oUc.size()), Integer.valueOf(this.oUd.size()));
        if (VERSION.SDK_INT >= 16) {
            this.oUa.bgM();
            this.oUa.oUX = ui(this.oTZ.oUk.size());
            FailSendMsgNotification failSendMsgNotification = this.oUa;
            this.oTZ.oUk.size();
            failSendMsgNotification.GO(da(this.oUc.size(), this.oUd.size()));
            this.oUa.bgL();
            if (this.oUd.size() > 0) {
                this.oUa.bgN();
                this.oUa.show();
                bgu();
                bgw();
            }
        }
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.fBy.type = getType();
        com.tencent.mm.sdk.b.a.xef.m(keVar);
        if (this.oUg != null) {
            this.oUg.TG();
        } else {
            x.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
        }
        bgq();
        com.tencent.mm.sdk.b.a.xef.c(this.oUh);
        bgn();
    }

    public void bgn() {
    }

    public final void bgo() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", Integer.valueOf(this.oTZ.oUk.size()));
        this.oUb = true;
        if (VERSION.SDK_INT >= 16) {
            FailSendMsgNotification failSendMsgNotification = this.oUa;
            failSendMsgNotification.oVe = false;
            failSendMsgNotification.oUQ = new d(failSendMsgNotification.mContext);
            failSendMsgNotification.bgK();
            failSendMsgNotification.show();
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
            failSendMsgNotification = this.oUa;
            failSendMsgNotification.oUQ.c(2, true);
            failSendMsgNotification.oVd = true;
            failSendMsgNotification.show();
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
            this.oUa.GO(cZ(this.oTZ.oUk.size(), 0));
        }
        this.oTZ.currentIndex = 0;
        bgq();
        com.tencent.mm.sdk.b.a.xef.c(this.oUh);
        com.tencent.mm.sdk.b.a.xef.b(this.oUh);
        dS(this.oTZ.bgB());
        if (this.oUg != null) {
            this.oUg.J(300000, 300000);
        } else {
            x.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
        }
    }

    void bgp() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.oTZ.oUk.size(); i++) {
            long j = this.oTZ.get(i);
            if (!dU(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.oTZ.remove(((Long) it.next()).longValue());
            }
        }
    }

    final void dS(long j) {
        ag.h(new 7(this, j), 200);
    }

    private void bgq() {
        Iterator it = this.oUf.iterator();
        while (it.hasNext()) {
            ((ak) it.next()).TG();
        }
        this.oUf.clear();
        this.oUe.clear();
    }

    public final void bgr() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", Integer.valueOf(this.oTZ.oUk.size()));
        if (this.oTZ.oUk.size() > 0) {
            b bVar = this.oTZ;
            ArrayList arrayList = new ArrayList();
            Iterator it = bVar.oUk.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Long) it.next()).longValue()));
            }
            K(arrayList);
        }
    }

    private void aTU() {
        this.oTZ.clear();
        this.oUb = false;
        this.oUc.clear();
        this.oUd.clear();
        bgq();
    }

    private String bgs() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < this.oTZ.oUk.size(); i++) {
            stringBuilder.append(this.oTZ.get(i) + ", ");
        }
        return stringBuilder.toString();
    }

    public final FailSendMsgNotification bgt() {
        return this.oUa;
    }

    private void bgu() {
        this.oTZ.currentIndex = 0;
        if (this.oUc.size() > 0) {
            Iterator it = this.oUc.iterator();
            while (it.hasNext()) {
                this.oTZ.remove(((Long) it.next()).longValue());
            }
        }
        this.oUc.clear();
        this.oUd.clear();
    }

    protected final void bgv() {
        if (this.oTZ == null || this.oTZ.oUk.size() == 0) {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
            com.tencent.mm.plugin.notification.d.b.a uj = b.uj(getType());
            if (uj == null) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
                return;
            }
            if (this.oUg == null) {
                bgj();
            }
            b bVar = uj.oUm;
            Collection collection = uj.oUo;
            Collection collection2 = uj.oUp;
            int i = uj.oUn;
            if (collection.size() == 0 && collection2.size() == 0 && i == 0) {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
                this.oTZ.clear();
                this.oTZ = bVar;
                this.oUc.clear();
                this.oUd.clear();
                bgk();
            } else if (collection.size() + collection2.size() >= bVar.oUk.size()) {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
                bgm();
            } else {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
                this.oTZ.clear();
                this.oTZ = bVar;
                this.oTZ.currentIndex = i;
                this.oUc.clear();
                this.oUc.addAll(collection);
                this.oUd.clear();
                this.oUd.addAll(collection2);
                bgl();
            }
        }
    }

    private void bgw() {
        b.a(getType(), new com.tencent.mm.plugin.notification.d.b.a(this.oTZ, this.oTZ.currentIndex, this.oUc, this.oUd));
    }
}
