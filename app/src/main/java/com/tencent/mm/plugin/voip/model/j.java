package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver$a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.n.5;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;

public final class j implements a, k.a, p, c, f, com.tencent.mm.plugin.voip.video.j.a {
    public b flu;
    public String gAb;
    public af jKT;
    private boolean mIsMute = false;
    private int mUIType;
    public TelephonyManager nCb;
    public PhoneStateListener nCc = new 17(this);
    public com.tencent.mm.sdk.b.c nCd = new 10(this);
    private long nEt = 0;
    private boolean osv = false;
    public com.tencent.mm.plugin.voip.b.c slK;
    public HeadsetPlugReceiver slL;
    com.tencent.mm.plugin.voip.ui.b slM;
    private com.tencent.mm.plugin.voip.video.a slN;
    private CaptureView slO;
    private a slP = null;
    private boolean slQ = false;
    private Object slR = new Object();
    public x slS;
    public boolean slT;
    public boolean slU;
    public boolean slV = false;
    private int slW = Downloads.RECV_BUFFER_SIZE;
    private boolean slX = false;
    public int slY = 1;
    private long slZ = -1;
    private boolean sma = false;
    public boolean smb = false;
    private boolean smc = false;
    private boolean smd = false;
    private int sme = 0;
    public com.tencent.mm.plugin.voip.video.j smf = new com.tencent.mm.plugin.voip.video.j();
    private ak smg = null;
    private ag smh;
    private boolean smi = false;
    private boolean smj = false;
    private int smk = 0;
    private boolean sml = false;
    public boolean smm = false;
    private com.tencent.mm.plugin.voip.widget.b smn;
    private boolean smo = false;
    private boolean smp = false;
    public String smq = null;
    public BroadcastReceiver smr = new 1(this);
    public HeadsetPlugReceiver$a sms = new 12(this);
    public com.tencent.mm.sdk.b.c smt = new 9(this);

    static /* synthetic */ void e(j jVar, boolean z) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "do minimizeVoip");
        if (2 != jVar.mUIType || VERSION.SDK_INT >= 24) {
            jVar.mUIType = 2;
            jVar.sme++;
            jVar.smn = new com.tencent.mm.plugin.voip.widget.b(jVar, jVar.slK.mState, jVar.slS, jVar.slU, jVar.slT, z);
            if (GameJsApiLaunchApplication.CTRL_BYTE == jVar.slK.mState || 6 == jVar.slK.mState) {
                ar.Hg();
                if (1 == com.tencent.mm.z.c.CU().getInt(327948, 0)) {
                    Toast.makeText(jVar.getContext(), jVar.getContext().getString(R.l.eVU), 0).show();
                } else {
                    Toast.makeText(jVar.getContext(), jVar.getContext().getString(R.l.eVT), 1).show();
                    ar.Hg();
                    com.tencent.mm.z.c.CU().setInt(327948, 1);
                }
            }
            if (jVar.slK.mState == 0 || 2 == jVar.slK.mState || 256 == jVar.slK.mState) {
                jVar.bHc();
            }
            d.bGj().stopRing();
            d.bGj().B(true, z);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipMgr", "already is widget");
    }

    static /* synthetic */ void w(j jVar) {
        if (com.tencent.mm.plugin.voip.b.b.yS(jVar.slK.mState)) {
            jVar.smf.suX = jVar.smj;
            jVar.smf.suY = jVar.smk;
            com.tencent.mm.plugin.voip.video.j jVar2 = jVar.smf;
            int[] iArr = new int[2];
            if (jVar.sml) {
                iArr[0] = 1;
                iArr[1] = 0;
            } else {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.asIntBuffer().put(iArr);
            byte[] array = allocate.array();
            if (jVar2.smF.setAppCmd(13, array, array.length) >= 0) {
                int length = (array.length % 4 == 0 ? 0 : 1) + (array.length / 4);
                ByteBuffer allocate2 = ByteBuffer.allocate(length * 4);
                allocate2.put(array);
                allocate2.order(ByteOrder.nativeOrder());
                allocate2.rewind();
                int[] iArr2 = new int[length];
                allocate2.asIntBuffer().get(iArr2);
                int i = iArr2[0];
                length = iArr2[1];
                if (i + length != 0) {
                    com.tencent.mm.plugin.voip.video.j.b bVar = new com.tencent.mm.plugin.voip.video.j.b(jVar2);
                    bVar = new com.tencent.mm.plugin.voip.video.j.b(jVar2);
                    bVar.svb = i & 65535;
                    bVar.svc = (i >> 16) & 65535;
                    bVar.svd = length & 65535;
                    bVar.sve = (length >> 16) & 65535;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[]{bVar});
                    Iterator it = jVar2.kwZ.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.voip.video.j.a) it.next()).a(new int[]{bVar.svb, bVar.svc, bVar.svd, bVar.sve}, jVar2.suX, jVar2.suY);
                    }
                    return;
                }
                Iterator it2 = jVar2.kwZ.iterator();
                while (it2.hasNext()) {
                    ((com.tencent.mm.plugin.voip.video.j.a) it2.next()).a(null, jVar2.suX, jVar2.suY);
                }
            }
        }
    }

    public final void er(int i) {
        int i2 = 1;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.smb)});
        switch (i) {
            case 1:
                ar.Hh().b(false, d.bGj().bGh());
                d.bGj().jd(false);
                d.bGj().jj(false);
                i2 = 4;
                break;
            case 2:
                ar.Hh().xJ();
                jf(bbU());
                if (!bbU()) {
                    i2 = 2;
                    break;
                }
                break;
            case 3:
                ar.Hh().xI();
                return;
            case 4:
                ar.Hh().xJ();
                ar.Hh().xH();
                jf(bbU());
                if (!bbU()) {
                    i2 = 2;
                }
                yB(i2);
                return;
            default:
                return;
        }
        yB(i2);
    }

    private boolean bbU() {
        if (d.bGj().bHv() && this.slU) {
            return true;
        }
        if (this.slT || !this.slU) {
            return false;
        }
        return true;
    }

    private void yB(int i) {
        this.slY = i;
        if (this.slM != null) {
            this.slM.yL(this.slY);
        }
    }

    private void jf(boolean z) {
        com.tencent.mm.sdk.platformtools.x.j("MicroMsg.Voip.VoipMgr", "enableSpeaker: " + z, new Object[0]);
        this.sma = z;
        this.smb = z;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + ar.Hh().xP());
        if (ar.Hh().xL()) {
            z = false;
        }
        if (q.gFV.gCG) {
            q.gFV.dump();
            if (q.gFV.gCH > 0) {
                d.bGj().jd(z);
            }
        }
        if (q.gFV.gDj >= 0 || q.gFV.gDk >= 0) {
            d.bGj().jd(z);
        }
        ar.Hh().b(z, d.bGj().bGh());
        d.bGj().jj(z);
        this.smc = z;
    }

    public final void jg(boolean z) {
        int i;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        if (d.bGj().bHv()) {
            jf(z);
        } else {
            n nVar = d.bGj().smS;
            if (nVar.snl != null) {
                nVar.snl.jp(z);
            }
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        yB(i);
        g gVar = g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(0);
        gVar.h(11080, objArr);
    }

    public final void gM(boolean z) {
        int i = 1;
        g gVar;
        if (z) {
            gVar = d.bGj().smS.siL.skg;
            if (gVar.oFS != null) {
                gVar.oFS.aQ(true);
            }
            d.bGj().yw(9);
            d.bGj().ji(true);
        } else {
            gVar = d.bGj().smS.siL.skg;
            if (gVar.oFS != null) {
                gVar.oFS.aQ(false);
            }
            d.bGj().yw(8);
            d.bGj().ji(false);
        }
        this.mIsMute = z;
        g gVar2 = g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(0);
        if (z) {
            i = 2;
        }
        objArr[2] = Integer.valueOf(i);
        gVar2.h(11080, objArr);
    }

    public final boolean bGJ() {
        if (!this.slK.yV(4103)) {
            return false;
        }
        yC(4103);
        d.bGj().bHz();
        return true;
    }

    public final boolean bGK() {
        if (!this.slK.yV(4101)) {
            return false;
        }
        d.bGj().stopRing();
        d.bGj().yw(1);
        d.bGj().C(true, this.slU);
        g gVar = g.pQN;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Long.valueOf(d.bGj().bHq());
        objArr[2] = Integer.valueOf(d.bGj().smS.siL.ske.nDx);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(this.slT ? 1 : 0);
        gVar.h(11046, objArr);
        g.pQN.h(11080, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
        kL(4111);
        kL(4101);
        kL(4100);
        return true;
    }

    public final boolean bGL() {
        int i = 0;
        if (!this.slK.yV(4099)) {
            return false;
        }
        String str = this.slS.field_username;
        String str2 = this.slU ? au.xzd : au.xzc;
        if (this.slT) {
            i = 1;
        }
        l.a(str, str2, i, 6, ac.getContext().getString(R.l.eUo));
        d.bGj().stopRing();
        d.bGj().smS.bHE();
        kL(4099);
        bGV();
        return true;
    }

    public final boolean bGM() {
        if (!this.slK.yV(4100)) {
            return false;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
        d.bGj().stopRing();
        d.bGj().C(false, this.slU);
        kL(4100);
        return true;
    }

    public final boolean bGN() {
        int i = 0;
        if (!this.slK.yV(4099)) {
            return false;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
        String str = this.slS.field_username;
        String str2 = this.slU ? au.xzd : au.xzc;
        if (this.slT) {
            i = 1;
        }
        l.a(str, str2, i, 6, ac.getContext().getString(R.l.eUo));
        d.bGj().stopRing();
        d.bGj().smS.bHE();
        kL(4099);
        bGV();
        return true;
    }

    public final boolean bGO() {
        if (!this.slK.yV(4100)) {
            return false;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
        d.bGj().stopRing();
        d.bGj().C(true, this.slU);
        kL(4111);
        kL(4100);
        return true;
    }

    public final boolean bGP() {
        if (!this.slK.yV(4098)) {
            return false;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
        yC(4098);
        d.bGj().bHz();
        return true;
    }

    public final boolean bGQ() {
        if (!this.slK.yV(4098)) {
            return false;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
        yC(4098);
        d.bGj().bHz();
        return true;
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar, int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated");
        if (1 == i && this.slM != null) {
            this.slM.uninit();
        }
        this.slM = bVar;
        this.mUIType = i;
        int i2 = 320;
        int i3 = 240;
        if (this.slN == null && com.tencent.mm.plugin.voip.b.b.yT(this.slK.mState)) {
            this.slO = new CaptureView(ac.getContext());
            if (v2protocal.snY) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                i2 = 640;
                i3 = 480;
            }
            this.slN = new com.tencent.mm.plugin.voip.video.a(i2, i3);
            this.slN.a((f) this, true);
            this.slN.a(this.slO);
            d.bGj().yH(this.slN.bIA());
            this.jKT.postDelayed(new 13(this), 50);
        }
        this.slM.a(this.slO);
        this.slM.dQ(-1, this.slK.mState);
        this.slM.fe(this.slZ);
        this.slM.yL(this.slY);
        this.slM.setMute(this.mIsMute);
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
        if (this.slM == bVar) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
            this.slM = null;
        }
        if (this.jKT != null) {
            this.jKT = null;
        }
    }

    public final void bGR() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
        if (this.slN != null) {
            this.slN.bIu();
        }
        g.pQN.h(11079, new Object[]{Integer.valueOf(1)});
    }

    private void yC(int i) {
        String string;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
        if (true == bHd()) {
            this.slW = i;
        }
        Context context = ac.getContext();
        if (com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState)) {
            string = context.getString(R.l.eUl, new Object[]{bp(bh.by(this.slZ))});
        } else if (this.slT) {
            string = context.getString(R.l.eUh);
        } else {
            string = context.getString(R.l.eUg);
        }
        l.a(this.slS.field_username, this.slU ? au.xzd : au.xzc, this.slT ? 1 : 0, 6, string);
        if (!this.slT || com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState)) {
            e.post(new 14(this), "VoipMgr_play_end_sound");
            this.slQ = true;
            d.bGj().bHo();
            if (Downloads.RECV_BUFFER_SIZE == this.slW) {
                kL(i);
                bGV();
                return;
            }
            return;
        }
        d.bGj().stopRing();
        if (this.slT && !com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
            n nVar = d.bGj().smS;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + nVar.siL.ske.nDx);
            if (nVar.siL.ske.nDx == 0 && nVar.siL.ske.nDA == 0) {
                nVar.reset();
            } else {
                nVar.siL.ske.spH.skR = nVar.siL.bGo();
                nVar.siL.ske.spH.sld = 3;
                if (nVar.siL.mStatus < 6) {
                    nVar.siL.ske.spH.slf = 1;
                }
                g gVar = g.pQN;
                Object[] objArr = new Object[6];
                objArr[0] = Integer.valueOf(d.bGj().smS.siL.ske.nDx);
                objArr[1] = Long.valueOf(d.bGj().bHq());
                objArr[2] = Long.valueOf(d.bGj().bHr());
                objArr[3] = Integer.valueOf(nVar.siL.mStatus == 5 ? 2 : 1);
                objArr[4] = Long.valueOf(System.currentTimeMillis());
                objArr[5] = Long.valueOf(System.currentTimeMillis());
                gVar.a(11521, true, true, objArr);
                nVar.bHD();
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
        d.bGj().bHo();
        if (Downloads.RECV_BUFFER_SIZE == this.slW) {
            kL(i);
            bGV();
        }
    }

    public final boolean bGS() {
        if (d.bGj().smS.siL.ske.nDx != 0) {
            return bGT();
        }
        this.slX = true;
        return true;
    }

    private boolean bGT() {
        int i = 4;
        int i2 = 0;
        if (!this.slK.yV(4101)) {
            return false;
        }
        Object[] objArr;
        g gVar;
        int i3;
        Object[] objArr2;
        int i4;
        Object[] objArr3;
        kL(4101);
        Object[] objArr4;
        if (261 == this.slK.mState || 7 == this.slK.mState) {
            d.bGj().yw(1);
            g gVar2 = g.pQN;
            Object[] objArr5 = new Object[5];
            objArr5[0] = Integer.valueOf(2);
            objArr5[1] = Long.valueOf(d.bGj().bHq());
            objArr5[2] = Integer.valueOf(d.bGj().smS.siL.ske.nDx);
            objArr5[3] = Integer.valueOf(0);
            objArr5[4] = Integer.valueOf(this.slT ? 1 : 0);
            gVar2.h(11046, objArr5);
            gVar2 = g.pQN;
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(2);
            objArr[1] = Integer.valueOf(0);
            gVar = gVar2;
            i3 = 11080;
            objArr2 = objArr;
            objArr4 = objArr;
            i4 = 2;
            objArr3 = objArr4;
        } else {
            if (1 == this.slK.mState || 3 == this.slK.mState) {
                d.bGj().yw(1);
                gVar = g.pQN;
                i3 = 11046;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(1);
                objArr[1] = Long.valueOf(d.bGj().bHq());
                objArr[2] = Integer.valueOf(d.bGj().smS.siL.ske.nDx);
                objArr[3] = Integer.valueOf(0);
                if (this.slT) {
                    i2 = 1;
                    objArr3 = objArr;
                    objArr[i] = Integer.valueOf(i2);
                    gVar.h(i3, objArr3);
                } else {
                    objArr3 = objArr;
                    objArr4 = objArr;
                    i4 = 4;
                    objArr2 = objArr4;
                }
            }
            d.bGj().bHs();
            d.bGj().bHt();
            return true;
        }
        int i5 = i4;
        objArr = objArr2;
        i = i5;
        objArr[i] = Integer.valueOf(i2);
        gVar.h(i3, objArr3);
        d.bGj().bHs();
        d.bGj().bHt();
        return true;
    }

    public final void bGU() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
        if (this.slX && d.bGj().smS.siL.ske.nDx != 0) {
            this.slX = false;
            bGT();
        }
        if (this.slT) {
            kL(4097);
        }
    }

    private void kL(int i) {
        com.tencent.mm.sdk.platformtools.x.j("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yP(i), com.tencent.mm.plugin.voip.b.b.yP(this.slK.mState)});
        if (4101 == i && com.tencent.mm.plugin.voip.b.b.yT(this.slK.mState)) {
            bHc();
        }
        boolean z = 4111 == i ? true : 4101 == i && (com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState) || this.slT);
        if (z && 1 == this.mUIType && 1 == this.slY) {
            this.smp = true;
            jf(false);
            yB(2);
        }
        com.tencent.mm.plugin.voip.b.c cVar = this.slK;
        if (cVar.yV(i)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yP(cVar.mState), com.tencent.mm.plugin.voip.b.b.yP(((Integer) ((Map) cVar.ssF.get(Integer.valueOf(cVar.mState))).get(Integer.valueOf(i))).intValue()), com.tencent.mm.plugin.voip.b.b.yP(i)});
            cVar.mState = r0;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
        }
        this.jKT.post(new 15(this, i));
        if (6 == this.slK.mState || GameJsApiLaunchApplication.CTRL_BYTE == this.slK.mState) {
            aGl();
        }
        switch (this.slK.mState) {
            case 258:
            case 259:
                yD(5);
                return;
            case 262:
                yD(6);
                return;
            default:
                return;
        }
    }

    private static void yD(int i) {
        com.tencent.mm.sdk.b.b tmVar = new tm();
        tmVar.fMb.fpr = i;
        com.tencent.mm.sdk.b.a.xef.m(tmVar);
    }

    public final void onError(int i, String str) {
        if (this.slU) {
            d.bGj().dO(R.k.dAl, 0);
        } else {
            d.bGj().dO(R.k.dAl, 1);
        }
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE && bh.ov(str)) {
            str = getContext().getString(R.l.eVG);
        }
        if (this.slM != null) {
            this.slM.aJ(i, str);
        }
        kL(4109);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(d.bGj().smS.siL.ske.nDx)});
        Context context = ac.getContext();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode" + i);
        String string = i == 235 ? context.getString(R.l.eUq) : i == 233 ? context.getString(R.l.eUj) : i == bd.CTRL_BYTE ? context.getString(R.l.eUq) : i == JsApiGetSetting.CTRL_INDEX ? context.getString(R.l.eUj) : i == h.CTRL_INDEX ? context.getString(R.l.eUp) : context.getString(R.l.eUi);
        String str2;
        String str3;
        int i2;
        if (d.bGj().smS.siL.ske.nDx != 0 && d.bGj().smX.get(Integer.valueOf(d.bGj().smS.siL.ske.nDx)) == null) {
            str2 = this.slS.field_username;
            str3 = this.slU ? au.xzd : au.xzc;
            i2 = this.slT ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState)) {
                string = ac.getContext().getString(R.l.eUm, new Object[]{bp(bh.by(this.slZ))});
            }
            d.bGj().smX.put(Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(l.a(str2, str3, i2, 6, string, true)));
        } else if (d.bGj().smS.siL.ske.nDx == 0) {
            str2 = this.slS.field_username;
            str3 = this.slU ? au.xzd : au.xzc;
            i2 = this.slT ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState)) {
                string = ac.getContext().getString(R.l.eUm, new Object[]{bp(bh.by(this.slZ))});
            }
            l.a(str2, str3, i2, 6, string, true);
        }
        d.bGj().bHz();
        bGV();
    }

    public final void aSR() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "on accept");
        d.bGj().stopRing();
        kL(4100);
    }

    public final void onReject() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onReject");
        kL(4099);
        l.a(this.slS.field_username, this.slU ? au.xzd : au.xzc, this.slT ? 1 : 0, 6, ac.getContext().getString(R.l.eUs));
        bGV();
    }

    private void bGV() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "delayFinish");
        this.smq = null;
        this.jKT.postDelayed(new 16(this), 2000);
    }

    public final void fz(boolean z) {
        m bGj;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "finish");
        this.smm = false;
        this.smo = false;
        if (this.sme != -1) {
            g.pQN.h(11700, new Object[]{Integer.valueOf(this.sme), Long.valueOf(bh.by(this.slZ))});
            this.sme = -1;
        }
        try {
            ac.getContext().unregisterReceiver(this.smr);
        } catch (Exception e) {
        }
        com.tencent.mm.sdk.b.a.xef.c(this.nCd);
        com.tencent.mm.sdk.b.a.xef.c(this.smt);
        if (this.slM != null) {
            this.slM.uninit();
            this.slM = null;
        }
        this.slO = null;
        ar.Hh().b(this);
        ar.Hh().xJ();
        if (d.bGj() != null) {
            d.bGj().stopRing();
            if (z) {
                d.bGj().smS.bHG();
            } else {
                d.bGj().bHo();
            }
            if (this.slU) {
                d.bGj().a(false, true, this.gAb);
            } else {
                d.bGj().a(false, false, this.gAb);
            }
            bGj = d.bGj();
            Context context = ac.getContext();
            n nVar = bGj.smS;
            if (context == nVar.siL.kaK && this == nVar.siL.skf) {
                nVar.siL.kaK = null;
                nVar.siL.skf = p.snF;
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", "detach ui........");
                com.tencent.mm.plugin.voip.b.a.bIl();
            } else {
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
            }
        }
        bGj = d.bGj();
        bGj.smT = null;
        bGj.snb = null;
        bGj.snc = false;
        if (this.slQ) {
            this.slP = new a(this);
            e.post(this.slP, "VoipMgr_clean");
        } else {
            bHb();
        }
        if (!(this.nCb == null || this.nCc == null)) {
            this.nCb.listen(this.nCc, 0);
            this.nCc = null;
        }
        if (this.slL != null) {
            this.slL.dA(ac.getContext());
        }
        this.nCb = null;
        ar.ux().wA();
        k.bHh().bHj();
        k.bHh().smH = null;
        ar.getNotification().cancel(40);
    }

    public final void bGW() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onNoResp");
        kL(4105);
        l.a(this.slS.field_username, this.slU ? au.xzd : au.xzc, this.slT ? 1 : 0, 4, ac.getContext().getString(R.l.eUr));
        g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(6), Integer.valueOf(an.getNetWorkType(getContext()))});
        bGV();
    }

    public final void onConnected() {
        kL(4102);
        this.slZ = bh.Wo();
        if (this.slM != null) {
            this.slM.fe(this.slZ);
        }
        boolean bGs = d.bGj().smS.siL.bGs();
        boolean bGr = d.bGj().smS.siL.bGr();
        if (this.slU && this.slT && !bGr && !bGs) {
            d.bGj().yw(1);
        }
        if (!com.tencent.mm.plugin.voip.b.b.yT(this.slK.mState)) {
            g.pQN.h(11080, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        }
        n nVar = d.bGj().smS;
        if (nVar.snl != null) {
            com.tencent.mm.plugin.voip.video.h hVar = nVar.snl;
            bh.m(hVar.mContext, hVar.mContext.getSharedPreferences(ac.cfs(), 0).getBoolean("settings_shake", true));
        }
        m bGj = d.bGj();
        int i = d.bGj().smS.siL.ske.son;
        n nVar2 = bGj.smS;
        nVar2.bni = null;
        nVar2.sns = null;
        nVar2.snq = 0;
        if (i > 0) {
            n.sno = i;
        }
        nVar2.bni = (WifiManager) ac.getContext().getApplicationContext().getSystemService("wifi");
        nVar2.snr = new Timer();
        nVar2.snr.schedule(new n$6(nVar2), 0, (long) (n.sno * 1000));
        TelephonyManager telephonyManager = (TelephonyManager) ac.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(new 5(nVar2, telephonyManager), 256);
        }
        k.bHh().bHi();
        k.bHh().smH = this;
    }

    public final void bGX() {
        int i = 0;
        g gVar = g.pQN;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(d.bGj().smS.siL.ske.nDx);
        objArr[1] = Long.valueOf(d.bGj().bHq());
        objArr[2] = Long.valueOf(d.bGj().bHr());
        if (!this.slT) {
            i = 1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(1);
        gVar.a(11522, true, true, objArr);
    }

    public final void bGY() {
        String string;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onShutDown");
        if (com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState)) {
            string = ac.getContext().getString(R.l.eUl, new Object[]{bp(bh.by(this.slZ))});
        } else {
            string = ac.getContext().getString(R.l.eUi);
        }
        if (this.slT || com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState)) {
            l.a(this.slS.field_username, this.slU ? au.xzd : au.xzc, 0, 6, string);
        }
        if (this.slU) {
            d.bGj().dO(R.k.dAl, 0);
        } else {
            d.bGj().dO(R.k.dAl, 1);
        }
        if (bHd()) {
            this.slW = 4106;
        } else {
            kL(4106);
            bGV();
        }
        d.bGj().bHz();
    }

    public final void yE(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[]{Integer.valueOf(i)});
        if (1 == i || 3 == i || 5 == i || 6 == i || 7 == i) {
            kL(4101);
            d.bGj().bHs();
            d.bGj().bHt();
        }
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        if (this.slM != null) {
            this.slM.b(i, i2, iArr);
        }
    }

    public final void bGZ() {
        if (this.slM != null) {
            this.slM.bGZ();
        }
    }

    public final void yF(int i) {
        boolean z = false;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: " + i);
        if (this.slK.yV(4110)) {
            m bGj = d.bGj();
            boolean z2 = i == 1;
            if (i == 1) {
                z = true;
            }
            bGj.C(z2, z);
            d.bGj().stopRing();
            if (i == 1 && com.tencent.mm.plugin.voip.b.b.yT(this.slK.mState)) {
                kL(4101);
            }
            kL(4110);
        }
    }

    public final void bHa() {
        boolean z = false;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
        if (ar.Hh().xR() || ar.Hh().xL()) {
            jf(false);
            return;
        }
        boolean z2 = 1 == this.slY;
        if (!this.smp) {
            if (this.slU) {
                z = true;
            } else {
                z = z2;
            }
        }
        jf(z);
    }

    private static String bp(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        if (!this.smd) {
            int i4;
            int i5 = this.slN.bIy() ? OpenGlRender.suk : 0;
            int i6 = this.slN.bIz() ? OpenGlRender.suj : OpenGlRender.sui;
            int i7 = (int) j;
            g gVar = d.bGj().smS.siL.skg;
            if (gVar.skA != 2) {
                i4 = 0;
            } else if (gVar.siL.bGv()) {
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = gVar.siL.ske;
                com_tencent_mm_plugin_voip_model_v2protocal.spp++;
                i4 = gVar.siL.ske.videoEncodeToSend(bArr, i7, i, i2, i3);
            } else {
                i4 = 0;
            }
            if (this.slM != null) {
                this.slM.a(bArr, j, i, i2, i3, i5, i6, i4);
            }
            this.smj = i5 == OpenGlRender.suk;
            this.smk = i6 == OpenGlRender.suj ? 270 : 90;
            com.tencent.mm.plugin.voip.video.j jVar = this.smf;
            jVar.sva = i2;
            jVar.suZ = i;
        }
    }

    private void bHb() {
        synchronized (this.slR) {
            d.bGj().stopRing();
            bHc();
            ar.Hh().setMode(0);
            if (this.flu != null) {
                this.flu.zd();
            }
        }
    }

    private void bHc() {
        com.tencent.mm.sdk.platformtools.x.j("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
        if (this.slN != null) {
            if (this.smf != null) {
                com.tencent.mm.plugin.voip.video.j jVar = this.smf;
                if (jVar.kwZ.contains(this)) {
                    jVar.kwZ.remove(this);
                }
            }
            if (this.smg != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
                this.smg.TG();
            }
            if (this.smh != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
                this.smh.oAt.getLooper().quit();
            }
            try {
                this.slN.bIw();
                com.tencent.mm.plugin.voip.video.a.bIx();
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + e.toString());
            }
            this.slN = null;
        }
    }

    public final void aSW() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
        if (this.slM != null) {
            this.slM.bIb();
        }
        if (!com.tencent.mm.plugin.voip.b.b.yT(this.slK.mState) && !this.smc) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.nEt > 30000) {
                this.nEt = currentTimeMillis;
                d.bGj().yI(R.k.dBA);
            }
        }
    }

    public final void aSX() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
        if (this.slM != null) {
            this.slM.aUI();
        }
    }

    private boolean bHd() {
        if (!com.tencent.mm.plugin.voip.b.b.yS(this.slK.mState)) {
            return false;
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
        if (sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
            return false;
        }
        String value = com.tencent.mm.k.g.zY().getValue("VOIPShortcutAutoadd");
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[]{value});
        if (value != null && value.equals("0") && bh.by(this.slZ) > 30) {
            int i = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i >= 3 || z) {
                return false;
            }
            Context context = getContext();
            View inflate = View.inflate(context, R.i.dnm, null);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cwc);
            checkBox.setChecked(false);
            TextView textView = (TextView) inflate.findViewById(R.h.cwe);
            if (1 == bh.getInt(com.tencent.mm.k.g.zY().getValue("VOIPCallType"), 0)) {
                textView.setText(R.l.eTZ);
            } else {
                textView.setText(R.l.eUa);
            }
            com.tencent.mm.ui.base.h.a(context, false, context.getString(R.l.dGO), inflate, context.getString(R.l.dHd), context.getString(R.l.dFR), new 2(this), new 3(this, checkBox));
            sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
            return true;
        } else if (value == null || !value.equals("1") || bh.by(this.slZ) <= 15) {
            return false;
        } else {
            c(sharedPreferences);
            return false;
        }
    }

    private void c(SharedPreferences sharedPreferences) {
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        Object intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.addFlags(67108864);
        if (1 == bh.getInt(com.tencent.mm.k.g.zY().getValue("VOIPCallType"), 0)) {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.l.dFg));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), R.g.bHG));
            intent.putExtra("shortcut_icon_resource_id", R.g.bHG);
        } else {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.l.dFh));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), R.g.bHO));
            intent.putExtra("shortcut_icon_resource_id", R.g.bHO);
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        com.tencent.mm.plugin.base.model.b.o(getContext(), intent);
        sharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
    }

    private Context getContext() {
        Context context = null;
        if (this.slM != null) {
            context = this.slM.bIa();
        }
        if (context == null) {
            return ac.getContext();
        }
        return context;
    }

    public final boolean jh(boolean z) {
        if (!this.smo || z) {
            com.tencent.mm.sdk.platformtools.x.j("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[]{Boolean.valueOf(z)});
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
            if (this.slM != null) {
                this.slM.uninit();
                this.slM = null;
            }
            this.jKT.post(new 4(this, z));
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
        return false;
    }

    public final void bHe() {
        if (256 == this.slK.mState || 257 == this.slK.mState) {
            ar.Hg();
            if (com.tencent.mm.z.c.CU().getInt(327945, 0) != 0 || this.slM.bIa() == null) {
                d.M(ac.getContext(), R.l.eVq);
                bHg();
                return;
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().setInt(327945, 1);
            i a = com.tencent.mm.ui.base.h.a(this.slM.bIa(), R.l.eVq, R.l.dGO, new 5(this));
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public final void bHf() {
        this.smi = !this.smi;
        if (this.smi) {
            this.smg.TG();
        } else {
            aGl();
        }
    }

    public final void bHg() {
        d.bGj().smY = d.bGj().smS.siL.ske.nDx;
        l.a(this.slS.field_username, this.slU ? au.xzd : au.xzc, this.slT ? 1 : 0, 6, ac.getContext().getString(R.l.eUn));
        d.bGj().stopRing();
        kL(4108);
        this.jKT.postDelayed(new 6(this), 2000);
    }

    public final void bdd() {
        if (true == this.osv || this.slM == null || this.slM.bIa() == null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.e.b.za()) {
            int i;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
            g gVar = g.pQN;
            Object[] objArr = new Object[2];
            if (this.slU) {
                i = 0;
            } else {
                i = 1;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(0);
            gVar.h(11306, objArr);
            i h = com.tencent.mm.ui.base.h.h(this.slM.bIa(), R.l.eVA, R.l.dGO);
            if (h == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
                return;
            }
            h.setCancelable(false);
            h.setCanceledOnTouchOutside(false);
            h.show();
            this.osv = true;
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
        }
    }

    private void aGl() {
        if (this.smg == null) {
            this.smh = new ag("faceDetect");
            this.smg = new ak(this.smh.oAt.getLooper(), new ak.a(this) {
                final /* synthetic */ j smu;

                {
                    this.smu = r1;
                }

                public final boolean uF() {
                    j.w(this.smu);
                    return true;
                }
            }, true);
        }
        this.smg.J(2000, 2000);
        this.smi = false;
    }

    public final void a(int[] iArr, boolean z, int i) {
        ag.y(new 8(this, iArr, z, i));
    }
}
