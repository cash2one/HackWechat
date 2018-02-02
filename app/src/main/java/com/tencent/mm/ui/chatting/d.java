package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.g;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.g.b;
import com.tencent.mm.ae.g.c;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.b.ae;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ad;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d implements a, b, c, com.tencent.mm.ae.g.d, f.a, com.tencent.mm.modelvoice.c, SensorController.a, ad {
    private static SensorController kCP;
    p fhr;
    private int fjw;
    private boolean fjy = false;
    public boolean kCS;
    private ay kCT;
    long kCU = -1;
    private boolean kCZ = false;
    boolean kEw = false;
    public g mql;
    private af yqA = new 3(this, Looper.getMainLooper());
    private List<au> yql;
    public long yqm = -1;
    private q yqn;
    public u yqo;
    ae yqp;
    public q yqq;
    public boolean yqr;
    public boolean yqs = true;
    public boolean yqt = false;
    private long yqu = 0;
    private long yqv = 0;
    public boolean yqw = false;
    private boolean yqx = false;
    public com.tencent.mm.sdk.b.c yqy = new 1(this);
    private af yqz = new 2(this, Looper.getMainLooper());

    public d(p pVar, ae aeVar, String str) {
        this.yqo = pVar.csq();
        this.fhr = pVar;
        this.yqp = aeVar;
        if (kCP == null) {
            kCP = new SensorController(this.yqo.thisActivity().getApplicationContext());
        }
        if (this.kCT == null) {
            this.kCT = new ay(this.yqo.thisActivity().getApplicationContext());
        }
        YZ(str);
        com.tencent.mm.sdk.b.a.xef.b(this.yqy);
        ar.ux().a(this);
    }

    public final void YZ(String str) {
        x.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", Boolean.valueOf(this.yqt));
        if (!this.yqt && this.yqo != null) {
            this.yql = new LinkedList();
            this.kEw = false;
            this.yqm = -1;
            this.kCS = false;
            this.kCU = -1;
            this.yqr = false;
            this.fjw = 0;
            if (s.ha(str)) {
                this.fjw = 1;
                this.mql = new com.tencent.mm.e.a.a(this.yqo.thisActivity(), 1);
                return;
            }
            this.fjw = 0;
            this.mql = new com.tencent.mm.e.a.a(this.yqo.thisActivity(), 0);
        }
    }

    public final void crc() {
        x.d("MicroMsg.AutoPlay", "clear play list, stack: %s", bh.cgy());
        if (this.yqn != null) {
            this.yqn.dismiss();
        }
        this.yql.clear();
    }

    public final void Fo(int i) {
        while (this.yqo != null) {
            q csy = this.fhr.csy();
            if (csy == null) {
                x.e("MicroMsg.AutoPlay", "add next failed: null adapter");
                return;
            }
            x.d("MicroMsg.AutoPlay", "position : " + i + "adapter getCount = " + csy.getCount());
            if (i >= 0 && i < csy.getCount()) {
                au auVar = (au) csy.getItem(i);
                if (auVar != null) {
                    if (auVar.ciW() && auVar.field_isSend == 0 && !com.tencent.mm.modelvoice.q.C(auVar) && !com.tencent.mm.modelvoice.q.D(auVar)) {
                        ah(auVar);
                    }
                    i++;
                } else {
                    return;
                }
            }
            return;
        }
        x.e("MicroMsg.AutoPlay", "context is null");
    }

    public final void ah(au auVar) {
        if (auVar != null) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                int size = this.yql.size();
                int i = 0;
                while (i < size) {
                    if (((au) this.yql.get(i)).field_msgId != auVar.field_msgId) {
                        i++;
                    } else {
                        return;
                    }
                }
                if (this.yqr || this.yql.size() == 0) {
                    this.yql.add(auVar);
                }
                x.d("MicroMsg.AutoPlay", "add voice msg :" + this.yql.size());
            } else if (this.yql.size() > 0) {
                this.yql.clear();
                com.tencent.mm.ui.base.u.fI(this.yqo.thisActivity());
            }
        }
    }

    public final void a(int i, au auVar) {
        if (auVar != null) {
            crc();
            ar.Hg();
            Boolean bool = (Boolean) com.tencent.mm.z.c.CU().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(4115, Boolean.valueOf(true));
                cri();
                this.yqq = com.tencent.mm.ui.base.u.a(this.yqo.thisActivity(), this.yqo.getString(R.l.dSj), 4000);
            }
            if (this.mql.isPlaying() && auVar.field_msgId == this.yqm) {
                crh();
                return;
            }
            ah(auVar);
            if (auVar.field_isSend == 0 && !com.tencent.mm.modelvoice.q.C(auVar)) {
                Fo(i + 1);
            }
            bdr();
        }
    }

    public final void b(int i, au auVar) {
        if (auVar != null) {
            crc();
            ar.Hg();
            Boolean bool = (Boolean) com.tencent.mm.z.c.CU().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(4115, Boolean.valueOf(true));
                cri();
                this.yqq = com.tencent.mm.ui.base.u.a(this.yqo.thisActivity(), this.yqo.getString(R.l.dSj), 4000);
            }
            if (this.mql.isPlaying() && auVar.field_msgId == this.yqm) {
                crh();
                return;
            }
            ah(auVar);
            if (auVar.field_isSend == 0 && !com.tencent.mm.modelvoice.q.C(auVar)) {
                Fo(i + 1);
            }
            bdr();
        }
    }

    public final void A(au auVar) {
        if ((!this.yqs || !this.yql.isEmpty()) && auVar != null && auVar.ciW() && auVar.field_isSend != 1 && auVar.field_talker != null && auVar.field_talker.equals(this.fhr.crz()) && ar.CG().foreground && !this.yqo.isFinishing()) {
            if (com.tencent.mm.modelvoice.q.D(auVar)) {
                x.e("MicroMsg.AutoPlay", "should not in this route");
                return;
            }
            ah(auVar);
            if (!this.kEw && !this.mql.isPlaying() && bh.bF(this.yqo.thisActivity())) {
                bdr();
            }
        }
    }

    public final void crd() {
        this.kEw = false;
        bdr();
    }

    private void cre() {
        int size = this.yql.size();
        int i = 0;
        int i2 = -1;
        while (i < size) {
            int i3;
            if (((au) this.yql.get(i)).field_msgId == this.yqm) {
                i3 = i;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 != -1) {
            this.yql.remove(i2);
        }
        x.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.yql.size());
    }

    public final void bdr() {
        x.d("MicroMsg.AutoPlay", "play next: size = " + this.yql.size());
        if (this.yql.size() <= 0) {
            this.yqz.sendEmptyMessageDelayed(0, 1000);
            return;
        }
        if (!f.xG().xR()) {
            f.xG();
            if (f.xO()) {
                f.xG().a((f.a) this);
                int xI = f.xG().xI();
                this.fjy = true;
                if (!(xI == -1 || xI == 0)) {
                    x.i("MicroMsg.AutoPlay", "play next: ret = " + xI);
                    this.yqA.sendEmptyMessageDelayed(0, 1000);
                    return;
                }
            }
        }
        crf();
    }

    public final void crf() {
        try {
            x.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.yql.size());
            if (this.yql.size() <= 0) {
                this.yqz.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            long j = ((au) this.yql.get(0)).field_createTime;
            int size = this.yql.size();
            int i = 1;
            int i2 = 0;
            while (i < size) {
                long j2;
                int i3;
                if (j > ((au) this.yql.get(i)).field_createTime) {
                    j2 = ((au) this.yql.get(i)).field_createTime;
                    i3 = i;
                } else {
                    long j3 = j;
                    i3 = i2;
                    j2 = j3;
                }
                i++;
                i2 = i3;
                j = j2;
            }
            au auVar = (au) this.yql.get(i2);
            if (auVar != null) {
                boolean z;
                if (auVar == null || !(auVar.ciW() || auVar.cjn() || auVar.cjo() || auVar.cjp())) {
                    z = false;
                } else {
                    z = true;
                }
                Assert.assertTrue(z);
                x.i("MicroMsg.AutoPlay", "start play msg: %d", Long.valueOf(auVar.field_msgId));
                if (!kCP.xic) {
                    kCP.a(this);
                    if (this.kCT.O(new 4(this))) {
                        this.kCU = 0;
                    } else {
                        this.kCU = -1;
                    }
                }
                ar.Hg();
                if (com.tencent.mm.z.c.isSDCardAvailable() || bh.ov(auVar.field_imgPath)) {
                    ar.Hg();
                    if (com.tencent.mm.z.c.isSDCardAvailable() && this.yqp.kCV) {
                        if (this.yqn != null) {
                            this.yqn.dismiss();
                        }
                        x.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b", Boolean.valueOf(f.xG().xR()), Boolean.valueOf(f.xG().xL()));
                        if (f.xG().xR() || !r2) {
                            this.yqn = com.tencent.mm.ui.base.u.a(this.yqo.thisActivity(), R.k.dBj, this.yqo.getString(R.l.dQc));
                        } else {
                            this.yqn = com.tencent.mm.ui.base.u.a(this.yqo.thisActivity(), R.k.dBd, this.yqo.getString(R.l.dQb));
                        }
                    }
                    com.tencent.mm.sdk.platformtools.ae.Vc("keep_app_silent");
                    com.tencent.mm.modelvoice.q.E(auVar);
                    this.mql.aL(true);
                    this.yqp.fhr.csx().setKeepScreenOn(true);
                    if (f.xG().xR() || f.xG().xL()) {
                        x.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(f.xG().xR()), Boolean.valueOf(f.xG().xL()));
                        this.kCS = false;
                    }
                    String str = auVar.field_imgPath;
                    String aJ = this.fjw == 1 ? h.aJ(str, false) : com.tencent.mm.modelvoice.q.getFullPath(str);
                    x.i("MicroMsg.AutoPlay", "startplay");
                    boolean oa = com.tencent.mm.modelvoice.q.oa(auVar.field_imgPath);
                    if (!oa) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 175, 1, false);
                    }
                    if (oa && this.mql.a(aJ, this.kCS, true, -1)) {
                        this.mql.aN(this.yql.size() > 1);
                        this.mql.a(this);
                        this.mql.a(this);
                        this.mql.a(this);
                        this.mql.a(this);
                        this.yqm = auVar.field_msgId;
                        this.yqv = new n(auVar.field_content).time;
                        this.yqu = System.currentTimeMillis();
                    } else {
                        this.yqm = -1;
                        if (this.fjy) {
                            f.xG().xJ();
                            this.fjy = false;
                        }
                        f.xG().b((f.a) this);
                        crc();
                        Toast.makeText(this.yqo.thisActivity(), this.yqo.getString(R.l.dSB), 0).show();
                    }
                    cpl();
                    this.yqt = false;
                    return;
                }
                this.yql.clear();
                com.tencent.mm.ui.base.u.fI(this.yqo.thisActivity());
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
        }
    }

    public final void crg() {
        if (this.mql != null && this.mql.isPlaying()) {
            x.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", Boolean.valueOf(this.kCS), Boolean.valueOf(this.mql.isPlaying()));
            this.mql.aM(this.kCS);
        }
    }

    public final void release() {
        x.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
        if (this.kCT != null) {
            this.kCT.cgg();
        }
    }

    public final void crh() {
        x.i("MicroMsg.AutoPlay", "stop play");
        com.tencent.mm.sdk.platformtools.ae.Vd("keep_app_silent");
        this.mql.stop();
    }

    private void cpl() {
        ag.y(new 5(this));
    }

    public final boolean isPlaying() {
        return this.mql.isPlaying();
    }

    public final void vh() {
        x.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", Boolean.valueOf(this.kCS), Long.valueOf(this.yqm), Long.valueOf(this.yqv));
        com.tencent.mm.plugin.report.service.g.pQN.h(15160, Long.valueOf(this.yqm), Long.valueOf(this.yqv), Long.valueOf(this.yqv), Integer.valueOf(0));
        if (this.yqo != null) {
            x.i("MicroMsg.AutoPlay", "stop play complete");
            com.tencent.mm.sdk.platformtools.ae.Vd("keep_app_silent");
            this.yqp.releaseWakeLock();
            cre();
            if (this.yql.isEmpty() && this.fjy) {
                f.xG().xJ();
                this.fjy = false;
            }
            f.xG().b((f.a) this);
            if (this.yql.isEmpty()) {
                kCP.cgf();
                this.kCT.cgg();
            }
            cpl();
            this.yqm = -1;
            cri();
            this.yqp.releaseWakeLock();
            bdr();
        }
    }

    public final void onError() {
        x.e("MicroMsg.AutoPlay", "voice play error");
        crh();
        bdr();
    }

    public final void bB(boolean z) {
        x.w("MicroMsg.AutoPlay", "voice play pause. %b", Boolean.valueOf(z));
        onStop();
    }

    public final void onStop() {
        int i = 1;
        x.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", Long.valueOf(this.yqm), Long.valueOf(this.yqv), Long.valueOf(bh.bz(this.yqu)), Boolean.valueOf(this.yqx), Boolean.valueOf(this.yqw), bh.cgy());
        if (this.yqm > 0) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(this.yqm);
            objArr[1] = Long.valueOf(this.yqv);
            objArr[2] = Long.valueOf(bh.bz(this.yqu));
            if (this.yqx) {
                i = 3;
            } else if (!this.yqw) {
                i = 2;
            }
            objArr[3] = Integer.valueOf(i);
            gVar.h(15160, objArr);
        }
        this.yqx = false;
        this.yqw = false;
        this.yqp.releaseWakeLock();
        cre();
        if (this.fjy) {
            f.xG().xJ();
            this.fjy = false;
        }
        f.xG().b((f.a) this);
        if (this.yql.isEmpty()) {
            kCP.cgf();
            this.kCT.cgg();
        }
        cpl();
        this.yqm = -1;
        cri();
        this.yqt = false;
    }

    public final void dT(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + z + "  hasSkip:" + this.kCZ + " tick:" + bh.bA(this.kCU) + "  lt:" + this.kCU);
        if (this.kCZ) {
            if (z) {
                z2 = false;
            }
            this.kCZ = z2;
        } else if (this.yqo == null) {
            kCP.cgf();
        } else {
            x.i("MicroMsg.AutoPlay", "isScreenOn: %s", Boolean.valueOf(this.yqo.isScreenEnable()));
            if (z || this.kCU == -1 || bh.bA(this.kCU) <= 400) {
                this.kCZ = false;
                if (!this.mql.vd()) {
                    if (ar.Hh().xL()) {
                        cri();
                        x.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
                        return;
                    } else if (this.yqp.kCV) {
                        this.kCS = false;
                        if (this.yqm != -1) {
                            this.yqo.setScreenEnable(z);
                            this.yqt = z;
                        } else {
                            this.yqo.setScreenEnable(true);
                            this.yqt = true;
                        }
                        crg();
                        return;
                    } else {
                        if (this.yqm != -1) {
                            if (this.yqo.isScreenEnable() != z) {
                                this.yqo.setScreenEnable(z);
                                this.yqt = z;
                                new ak(new 6(this, z), false).J(50, 50);
                            } else {
                                return;
                            }
                        }
                        x.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", Boolean.valueOf(this.yqt));
                        return;
                    }
                }
                return;
            }
            this.kCZ = true;
        }
    }

    public final void cri() {
        if (this.yqq != null) {
            this.yqq.dismiss();
        }
    }

    public final void GO() {
        x.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
        this.yqx = false;
    }

    public final void GP() {
        x.i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
        this.yqx = true;
        crh();
        crc();
        try {
            if (kCP != null) {
                kCP.cgf();
            }
            if (this.kCT != null) {
                this.kCT.cgg();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "reset sensor error: %s", e.getMessage());
        }
    }

    public final void er(int i) {
        x.i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.fjy));
        switch (i) {
            case 1:
                if (this.yqA.hasMessages(0)) {
                    this.yqA.removeMessages(0);
                    this.yqA.sendEmptyMessage(0);
                    return;
                }
                return;
            case 2:
            case 4:
                if (this.yqA.hasMessages(0)) {
                    this.yqA.removeMessages(0);
                }
                if (this.fjy) {
                    f.xG().xJ();
                    this.fjy = false;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
