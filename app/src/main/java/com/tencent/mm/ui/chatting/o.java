package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Looper;
import android.os.Vibrator;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.h;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.subapp.c.i;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.List;

public final class o implements b {
    public static boolean ysd = true;
    private x jLe;
    private ToneGenerator kEa;
    private Vibrator kEd;
    private final ak kEu = new ak(new a(this) {
        final /* synthetic */ o ysq;

        {
            this.ysq = r1;
        }

        public final boolean uF() {
            this.ysq.one.Ck(this.ysq.ysh.getMaxAmplitude());
            return true;
        }
    }, true);
    private final ak kEv = new ak(new 10(this), true);
    private final h.a kEy = new 1(this);
    private Object lock = new Object();
    private AppPanel.a onQ = new 12(this);
    private ChatFooter one;
    private final h.b onj = new 5(this);
    private boolean ypn;
    ListView yse;
    private q ysf;
    private ChattingUI.a ysg;
    private h ysh;
    private String ysi;
    private String ysj;
    private boolean ysk;
    private boolean ysl;
    public boolean ysm;
    private volatile boolean ysn = false;
    private volatile boolean yso = false;
    private boolean ysp = false;

    static /* synthetic */ void k(o oVar) {
        oVar.ysg.enableOptionMenu(false);
        oVar.ysg.enableBackMenu(false);
        if (oVar.ysh != null) {
            ae.Vc("keep_app_silent");
            oVar.one.Sz(oVar.ysg.getString(R.l.dQd));
            oVar.ysh.cJ(oVar.crz());
            oVar.ysj = oVar.ysh.getFileName();
            oVar.ysh.a(oVar.onj);
            oVar.kEd.vibrate(50);
            oVar.ysf.notifyDataSetChanged();
            oVar.mE(true);
            oVar.ysh.a(oVar.kEy);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
    }

    public o(ListView listView, q qVar, p pVar, ChatFooter chatFooter, String str) {
        this.yse = listView;
        this.ysf = qVar;
        this.ysg = (ChattingUI.a) pVar;
        this.one = chatFooter;
        this.ysi = str;
        ar.Hg();
        this.jLe = c.EY().WO(str);
        this.ysk = this.ysg.crz().endsWith("@chatroom");
        this.ysl = s.gA(this.ysg.crz());
        boolean z = this.ysk || this.ysl;
        this.ypn = z;
        this.kEd = (Vibrator) this.ysg.getContext().getSystemService("vibrator");
        if (s.ha(this.ysi)) {
            this.ysh = new i();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
        } else {
            String str2 = this.ysi;
            if (s.hl(str2)) {
                z = true;
            } else {
                af WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str2);
                if (WO != null && WO.cia()) {
                    d jS = f.jS(WO.field_username);
                    if (jS != null) {
                        d.b bI = jS.bI(false);
                        if (bI != null) {
                            if (bI.hou != null) {
                                bI.hoy = "1".equals(bI.hou.optString("CanReceiveSpeexVoice"));
                            }
                            if (bI.hoy) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + WO.field_username + " canReceiveSpeexVoice");
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (z) {
                this.ysh = new com.tencent.mm.e.b.h(this.ysg.getContext(), true);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
            } else {
                this.ysh = new com.tencent.mm.e.b.h(this.ysg.getContext(), false);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
            }
        }
        this.ysh.a(this.onj);
        this.ysh.a(this.kEy);
        chatFooter.a(this.onQ);
    }

    public final boolean aYF() {
        synchronized (this.lock) {
            this.ysn = true;
        }
        if (this.yso) {
            this.yso = false;
            releaseWakeLock();
            if (cry()) {
                this.one.aJO();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
            } else {
                this.one.cbr();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
            }
            this.ysf.ysR.crd();
            this.ysg.yvL.FE(4);
            this.ysg.yvL.stopSignalling();
            Fs(1);
            this.ysg.mK(false);
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
    }

    public final boolean aYH() {
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
        synchronized (this.lock) {
            this.ysn = true;
        }
        if (this.yso) {
            this.yso = false;
            releaseWakeLock();
            this.ysg.enableOptionMenu(true);
            this.ysg.enableBackMenu(true);
            if (this.ysh != null) {
                this.ysh.cancel();
                this.kEu.TG();
                this.kEv.TG();
            }
            this.one.aJO();
            this.ysf.ysR.crd();
            this.ysg.yvL.FE(4);
            this.ysg.yvL.stopSignalling();
            Fs(1);
            this.ysg.mK(false);
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
    }

    public final boolean aYI() {
        if (com.tencent.mm.p.a.aW(this.ysg.getContext()) || com.tencent.mm.p.a.aU(this.ysg.getContext())) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingFooterEventImpl", "voip is running, cann't record voice");
            return false;
        }
        ar.Hg();
        if (c.isSDCardAvailable()) {
            if (!com.tencent.mm.compatible.e.b.yY()) {
                com.tencent.mm.ui.base.h.a(this.ysg.getContext(), this.ysg.getString(R.l.dGM), this.ysg.getString(R.l.dFL), this.ysg.getString(R.l.dFN), true, new 6(this));
            }
            if (this.ysh != null) {
                if (this.kEa == null) {
                    try {
                        this.kEa = new ToneGenerator(3, (int) ((((float) this.ysg.getStreamMaxVolume(3)) / ((float) this.ysg.getStreamVolume(3))) * 100.0f));
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "init tone");
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "init tone failed");
                    }
                }
                if (this.kEa != null) {
                    this.kEa.startTone(24);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "start tone");
                }
                this.yse.postDelayed(new 8(this), 200);
            }
            synchronized (this.lock) {
                this.ysn = false;
            }
            new com.tencent.mm.sdk.platformtools.af(Looper.myLooper()).postDelayed(new 7(this), 200);
            return true;
        }
        u.fI(this.ysg.getContext());
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        return false;
    }

    public final boolean Eg(String str) {
        mE(false);
        crx();
        return this.ysg.ywb.dm(str, 0);
    }

    public final void aYJ() {
        mE(false);
        crx();
    }

    public final void aYK() {
        mE(false);
        crx();
    }

    public final void aYL() {
        mE(false);
        crx();
    }

    private void crx() {
        this.yse.smoothScrollBy(0, 0);
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    private void mE(boolean z) {
        this.yse.postDelayed(new 11(this, true, z), 10);
    }

    private void releaseWakeLock() {
        this.yse.setKeepScreenOn(false);
    }

    private boolean cry() {
        this.ysg.enableOptionMenu(true);
        this.ysg.enableBackMenu(true);
        if (this.ysh != null) {
            boolean z;
            boolean vo;
            au auVar;
            long Q;
            if (this.ysh.isRecording()) {
                z = this.jLe.field_username.equals("medianote") && (q.FW() & 16384) == 0;
                if (z) {
                    z = true;
                    vo = this.ysh.vo();
                    this.kEu.TG();
                    this.kEv.TG();
                    if (z) {
                        auVar = new au();
                        auVar.dS("medianote");
                        auVar.setType(34);
                        auVar.eR(1);
                        auVar.dT(this.ysj);
                        auVar.eQ(2);
                        auVar.setContent(n.b(q.FS(), (long) this.ysh.vx(), false));
                        auVar.aq(ba.hR("medianote"));
                        if (this.ysh.vA() == 2) {
                            auVar.dY("SOURCE_SILK_FILE");
                        }
                        ar.Hg();
                        Q = c.Fa().Q(auVar);
                        if (Q > 0) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
                        } else {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + Q);
                        }
                    }
                    ae.Vd("keep_app_silent");
                    return vo;
                }
            }
            z = false;
            vo = this.ysh.vo();
            this.kEu.TG();
            this.kEv.TG();
            if (z) {
                auVar = new au();
                auVar.dS("medianote");
                auVar.setType(34);
                auVar.eR(1);
                auVar.dT(this.ysj);
                auVar.eQ(2);
                auVar.setContent(n.b(q.FS(), (long) this.ysh.vx(), false));
                auVar.aq(ba.hR("medianote"));
                if (this.ysh.vA() == 2) {
                    auVar.dY("SOURCE_SILK_FILE");
                }
                ar.Hg();
                Q = c.Fa().Q(auVar);
                if (Q > 0) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + Q);
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
                }
            }
            ae.Vd("keep_app_silent");
            return vo;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
        return false;
    }

    public final String crz() {
        if (this.jLe == null || !x.gy(this.jLe.field_username)) {
            return this.jLe == null ? null : this.jLe.field_username;
        } else {
            return this.ysi;
        }
    }

    public final void release() {
        if (this.kEa != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.kEa.release();
            this.kEa = null;
        }
    }

    public final void onPause() {
        if (this.kEa != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.kEa.release();
            this.kEa = null;
        }
        cry();
        this.kEu.TG();
        this.kEv.TG();
    }

    public final void gx(boolean z) {
        if (z) {
            this.ysg.yvL.keepSignalling();
        } else {
            this.ysg.yvL.stopSignalling();
        }
    }

    private static void Fs(int i) {
        com.tencent.mm.sdk.b.b muVar = new mu();
        muVar.fES.state = i;
        com.tencent.mm.sdk.b.a.xef.m(muVar);
    }

    public final void crA() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.CAMERA", 22, "", "")), bh.cgy(), this.ysg.thisActivity()});
        if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.CAMERA", 22, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 22, "", "")), bh.cgy(), this.ysg.thisActivity()});
            if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 22, "", "")) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
                Intent intent = new Intent();
                if (com.tencent.mm.pluginsdk.q.a.vcw.DC(crz())) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
                    Toast.makeText(ac.getContext(), R.l.epu, 0).show();
                    return;
                }
                if (crz() != null) {
                    boolean z;
                    List<String> Fu = com.tencent.mm.pluginsdk.q.a.vcx.Fu(crz());
                    ar.Hg();
                    String str = (String) c.CU().get(2, null);
                    boolean Fs = com.tencent.mm.pluginsdk.q.a.vcx.Fs(crz());
                    for (String str2 : Fu) {
                        if (str != null && str.equals(str2)) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (Fu.size() < 9 || z) {
                        if (z) {
                            if (com.tencent.mm.pluginsdk.q.a.vcx.bct()) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
                                Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewo), 0).show();
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
                        }
                        if (com.tencent.mm.pluginsdk.q.a.vcx.bcI()) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
                            Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewo), 0).show();
                            return;
                        } else if (Fs) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
                            com.tencent.mm.ui.base.h.a(this.ysg.getContext(), this.ysg.getString(R.l.ewK), "", this.ysg.getString(R.l.evY), this.ysg.getString(R.l.evV), new 2(this), null);
                            return;
                        }
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
                    Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewu, new Object[]{Integer.valueOf(9)}), 0).show();
                    return;
                }
                intent.putExtra("chatroomName", crz());
                intent.putExtra("key_need_gallery", true);
                intent.putExtra("titile", this.ysg.getString(R.l.ewB));
                com.tencent.mm.bm.d.b(this.ysg.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", intent);
            }
        }
    }

    public final void Ft(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.CAMERA", 18, "", "")), bh.cgy(), this.ysg.thisActivity()});
        if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.CAMERA", 18, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 18, "", "")), bh.cgy(), this.ysg.thisActivity()});
            if (!com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 18, "", "")) {
                return;
            }
            if (com.tencent.mm.sdk.a.b.ceK() || r.iem) {
                l lVar = new l(this.ysg.getContext());
                lVar.rKC = new 3(this);
                lVar.rKD = new 4(this, i);
                lVar.bBX();
            } else if (!r.ien) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                k.a(this.ysg, new Intent(), crz(), i);
            }
        }
    }

    public final void crB() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 83, "", "")), bh.cgy(), this.ysg.thisActivity()});
        if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 83, "", "")) {
            if (this.one.cbN()) {
                this.one.cbP();
            }
            com.tencent.mm.sdk.b.b spVar = new sp();
            spVar.fKq.fuL = 5;
            spVar.fKq.talker = crz();
            spVar.fKq.context = this.ysg.getContext();
            spVar.fKq.fKl = 3;
            com.tencent.mm.sdk.b.a.xef.m(spVar);
            com.tencent.mm.plugin.report.service.g.pQN.h(11033, new Object[]{Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0)});
        }
    }

    public final void crC() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.CAMERA", 21, "", "")), bh.cgy(), this.ysg.thisActivity()});
        if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.CAMERA", 21, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 21, "", "")), bh.cgy(), this.ysg.thisActivity()});
            if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 21, "", "")) {
                if (this.one.cbN()) {
                    this.one.cbP();
                }
                com.tencent.mm.sdk.b.b spVar = new sp();
                spVar.fKq.fuL = 5;
                spVar.fKq.talker = crz();
                spVar.fKq.context = this.ysg.getContext();
                spVar.fKq.fKl = 2;
                com.tencent.mm.sdk.b.a.xef.m(spVar);
            }
        }
    }

    public final void bjB() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 82, "", "")), bh.cgy(), this.ysg.thisActivity()});
        if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 82, "", "")) {
            com.tencent.mm.sdk.b.b spVar = new sp();
            spVar.fKq.fuL = 5;
            spVar.fKq.talker = crz();
            spVar.fKq.context = this.ysg.getContext();
            spVar.fKq.fKl = 4;
            if (this.one.cbN()) {
                this.one.cbP();
            }
            com.tencent.mm.sdk.b.a.xef.m(spVar);
        }
    }

    public final void bjC() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.CAMERA", 19, "", "")), bh.cgy(), this.ysg.thisActivity()});
        if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.CAMERA", 19, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 19, "", "")), bh.cgy(), this.ysg.thisActivity()});
            if (com.tencent.mm.pluginsdk.g.a.a(this.ysg.thisActivity(), "android.permission.RECORD_AUDIO", 19, "", "")) {
                com.tencent.mm.sdk.b.b spVar = new sp();
                spVar.fKq.fuL = 5;
                spVar.fKq.talker = crz();
                spVar.fKq.context = this.ysg.getContext();
                spVar.fKq.fKl = 2;
                if (this.one.cbN()) {
                    this.one.cbP();
                }
                com.tencent.mm.sdk.b.a.xef.m(spVar);
            }
        }
    }

    public final void crD() {
        this.ysg.yvM.mP(false);
        this.one.cbP();
    }

    public final void crE() {
        if (!k.a(this.ysg, e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText(this.ysg.getContext(), this.ysg.getString(R.l.eJu), 1).show();
        }
    }
}
