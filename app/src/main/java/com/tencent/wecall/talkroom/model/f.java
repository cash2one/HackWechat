package com.tencent.wecall.talkroom.model;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.e.a.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.au;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.pb.common.b.a.a.q;
import com.tencent.pb.common.b.a.a.r;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.FileUtils;
import com.tencent.wecall.talkroom.a.j;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.model.g.1;
import com.tencent.wecall.talkroom.model.g.11;
import com.tencent.wecall.talkroom.model.g.15;
import com.tencent.wecall.talkroom.model.g.16;
import com.tencent.wecall.talkroom.model.g.17;
import com.tencent.wecall.talkroom.model.g.18;
import com.tencent.wecall.talkroom.model.g.20;
import com.tencent.wecall.talkroom.model.g.6;
import com.tencent.wecall.talkroom.model.g.7;
import com.tencent.wecall.talkroom.model.g.8;
import com.tencent.wecall.talkroom.model.g.9;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public final class f implements Callback, com.tencent.e.a.d, com.tencent.pb.common.b.b {
    public static String[] AnQ = new String[]{"GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other"};
    public static List<Integer> Anm = new ArrayList();
    private static int Ant = 30000;
    private static e zMs = null;
    private a AmO;
    private int AnA = 0;
    private long AnB = 0;
    private boolean AnC = true;
    private int AnD = 0;
    int AnE = -1;
    public h AnF = h.AoQ;
    b AnG;
    private talk.a AnH;
    private TimerTask AnI;
    private TimerTask AnJ;
    private Timer AnK = new Timer("TalkRoomService_HelloTimer");
    private TimerTask AnL;
    private Timer AnM = new Timer("TalkRoomService_talkDurationTimer");
    g AnN = new g();
    private int AnO = 0;
    private boolean AnP = false;
    public String AnR = null;
    HashSet<Long> AnS = new HashSet();
    public boolean AnT = false;
    public boolean AnU = true;
    public boolean AnV = true;
    private short[] AnW = null;
    private int[] AnX = null;
    private short[] AnY = null;
    private int[] AnZ = null;
    f Anl;
    private Map<String, e> Ann = new HashMap();
    private final int Ano = 1;
    private final int Anp = 2;
    private final int Anq = 3;
    private final int Anr = 4;
    public final int Ans = 6;
    private boolean Anu = false;
    private boolean Anv = false;
    public String Anw;
    public long Anx;
    private int Any = 0;
    private int Anz = 0;
    private int Aoa = 0;
    public boolean Aob = false;
    public boolean Aoc = true;
    private Runnable Aod = new 8(this);
    private com.tencent.pb.common.b.d Aoe = null;
    private Runnable Aof = new 9(this);
    Handler mHandler;
    boolean mIsMute = false;
    public int nJW;
    boolean nTK = false;
    public String nln;
    boolean slT = false;
    int state = 0;
    int zMg;

    public enum b {
        OK,
        NOT_AUTH,
        NOT_BIND,
        NOT_MATCH,
        NO_NETWORK,
        BUSY,
        NOT_VALID_STATE,
        GROUP_NOT_VALID,
        UNINIT_SERVICE_FAILED,
        INIT_ENGINE_FAILED
    }

    class d {
        long Anx;
        int nJW;
        String nln;
    }

    static /* synthetic */ void a(f fVar, m mVar) {
        if (fVar.AnJ == null) {
            fVar.AnJ = new 3(fVar, mVar);
            fVar.AnK.schedule(fVar.AnJ, 120000);
        }
    }

    static /* synthetic */ void a(f fVar, int[] iArr) {
        if (iArr == null) {
            c.m("TalkRoomService", new Object[]{"onMebersChangedToEngineByIds members is null"});
            return;
        }
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "engine onMebersChangedToEngineByIds members.length: ";
        objArr[1] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        c.m(str, objArr);
        if (fVar.AnG == null) {
            c.m("TalkRoomService", new Object[]{"onMebersChangedToEngine engine is null"});
        } else {
            fVar.AnG.OnMembersChanged(iArr);
        }
    }

    static /* synthetic */ void e(f fVar) {
        if (fVar.AnG == null) {
            c.e("TalkRoomService", new Object[]{"the engine should not be null."});
            return;
        }
        c.d("TalkRoomService", new Object[]{"initMediaComponent"});
        com.tencent.pb.common.c.f.w(411, 1, "1");
        fVar.cHX();
        fVar.aTQ();
    }

    static /* synthetic */ m j(f fVar) {
        if (TextUtils.isEmpty(fVar.nln)) {
            c.m("TalkRoomService", new Object[]{"doHelloVoiceRoom mGroupId is null"});
            return null;
        }
        c.m("TalkRoomService", new Object[]{"doHelloVoiceRoom mGroupId: ", fVar.nln, " mRoomId: ", Integer.valueOf(fVar.nJW), " mRoomKey: ", Long.valueOf(fVar.Anx), " selfMemberId: ", Integer.valueOf(c.cHH().abV(fVar.nln)), " mCallData: ", Integer.valueOf(fVar.AnD)});
        m mVar = new m(fVar.nln, fVar.nJW, fVar.Anx, r6, fVar.AnD);
        com.tencent.pb.common.b.e.cCE().a(mVar);
        return mVar;
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        switch (message.what) {
            case 1:
                obj = message.obj;
                if (this.state != 4) {
                    if (!(obj instanceof d)) {
                        c.m("TalkRoomService", new Object[]{"handlerInviteTimeOut obj is not GroupRoomInfo"});
                        break;
                    }
                    d dVar = (d) obj;
                    if (dVar.nln != null) {
                        c.d("TalkRoomService", new Object[]{"handlerInviteTimeOut"});
                        if (dVar.nln.equals(this.nln) && dVar.nJW == this.nJW && dVar.Anx == this.Anx) {
                            h.cIc();
                            this.AnF.Jh(HardCoderJNI.SCENE_DB);
                            b(dVar.nln, dVar.nJW, dVar.Anx, 7);
                            c.m("TalkRoomService", new Object[]{"handlerInviteTimeOut groupRoomInfo.mGroupId: ", dVar.nln});
                            break;
                        }
                    }
                    c.m("TalkRoomService", new Object[]{"handlerInviteTimeOut groupRoomInfo.mGroupId is null"});
                    break;
                }
                c.m("TalkRoomService", new Object[]{"handlerInviteTimeOut state: ", Integer.valueOf(this.state)});
                break;
            case 2:
                obj = message.obj;
                if (this.state == 1) {
                    if (!(obj instanceof a)) {
                        c.m("TalkRoomService", new Object[]{"handlerCreateGroup obj is not CreateGroupObj"});
                        break;
                    }
                    a aVar = (a) obj;
                    if (g.fU(aVar.groupId, this.nln)) {
                        String str = aVar.groupId;
                        String[] strArr = aVar.Aos;
                        ay ayVar = aVar.Aot;
                        int i = aVar.zMR;
                        int i2 = aVar.type;
                        long j = aVar.Aou;
                        String str2 = aVar.Aov;
                        boolean z = aVar.Aow;
                        String str3 = aVar.Aox;
                        this.AnF.cIb();
                        String str4 = "";
                        TalkRoom abU = c.cHH().abU(str);
                        if (abU != null) {
                            str4 = abU.AmW == null ? "" : abU.AmW.name;
                        }
                        boolean a = com.tencent.pb.common.b.e.cCE().a(new com.tencent.wecall.talkroom.a.d(str, strArr, this.AnG.cHF(), str4, ayVar, i, i2, j, str2, z, str3));
                        this.AnF.Q(new String[]{"create", "req", String.valueOf(a), String.valueOf(this.state)});
                        c.m("TalkRoomService", new Object[]{"sendCreateSence groupId: ", str, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(i2), " playId: ", Long.valueOf(j), " name: ", str4, " ret: ", Boolean.valueOf(a)});
                        break;
                    }
                }
                c.m("TalkRoomService", new Object[]{"handlerCreateGroup state: ", Integer.valueOf(this.state)});
                break;
                break;
            case 3:
                obj = message.obj;
                if (this.state == 3) {
                    if (!(obj instanceof c)) {
                        c.m("TalkRoomService", new Object[]{"handlerCreateGroup obj is not CreateGroupObj"});
                        break;
                    }
                    c cVar = (c) obj;
                    if (b(cVar.groupId, cVar.nDx, cVar.nDy, false)) {
                        b(cVar.groupId, cVar.nDx, cVar.nDy, cVar.zMR, cVar.zMY);
                        break;
                    }
                }
                c.m("TalkRoomService", new Object[]{"handlerEnterGroup state: ", Integer.valueOf(this.state)});
                break;
                break;
            case 4:
                com.tencent.pb.common.c.f.cCU();
                break;
        }
        return true;
    }

    public f() {
        com.tencent.pb.common.b.e.cCE().a(201, this);
        com.tencent.pb.common.b.e.cCE().a(202, this);
        com.tencent.pb.common.b.e.cCE().a(203, this);
        com.tencent.pb.common.b.e.cCE().a(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(207, this);
        com.tencent.pb.common.b.e.cCE().a(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(i.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(h.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(JsApiCheckIsSupportFaceDetect.CTRL_INDEX, this);
        com.tencent.pb.common.b.e.cCE().a(800, this);
        c cHH = c.cHH();
        g gVar = this.AnN;
        try {
            new Throwable("trace caller").getStackTrace();
        } catch (Exception e) {
            c.d("TalkRoomManager", new Object[]{"setTalkServerCallback caller stack: ", r2});
        }
        cHH.And = gVar;
        HandlerThread handlerThread = new HandlerThread("TalkRoomService");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        if (this.AmO == null) {
            this.AmO = (a) com.tencent.e.f.abQ("EventCenter");
        }
        c.d("TalkRoomService", new Object[]{"syscall", "register", Boolean.valueOf(true)});
        this.AmO.a(this, AnQ);
    }

    final boolean cHQ() {
        c.d("TalkRoomService", new Object[]{"initService"});
        e eVar = zMs;
        if (eVar != null) {
            eVar.bbV();
        }
        this.AnG = new b();
        this.AnR = this.nln;
        this.AnH = new 1(this);
        return true;
    }

    public final void nY(boolean z) {
        int uninitLive;
        String cHZ;
        this.AnF.groupId = this.nln;
        this.AnF.zMM = this.Anw;
        if (g.AA(this.AnF.groupId)) {
            this.AnF.groupId = "";
        }
        if (g.AA(this.AnF.zMM)) {
            this.AnF.zMM = "";
        }
        this.AnF.soo = 1;
        this.AnF.nDx = this.nJW;
        this.AnF.nDy = this.Anx;
        c.d("TalkRoomService", new Object[]{"uninitService isUpload: ", Boolean.valueOf(z)});
        c.d("TalkRoomService", new Object[]{"releaseConpent"});
        try {
            vi();
        } catch (Throwable th) {
            c.m("TalkRoomService", new Object[]{"releaseConpent ", th});
        }
        try {
            cHS();
        } catch (Throwable th2) {
            c.m("TalkRoomService", new Object[]{"releaseConpent ", th2});
        }
        this.Ann.remove(this.nln);
        this.AnO = 0;
        this.mIsMute = false;
        setState(0);
        this.Anv = false;
        a(this.Anw, 0, 0, null);
        this.Anw = null;
        this.zMg = 0;
        this.Any = 0;
        this.Anz = 0;
        this.AnA = 0;
        this.AnC = true;
        this.AnU = true;
        this.AnB = 0;
        this.AnD = 0;
        this.Anu = false;
        this.Aob = false;
        this.Aoc = true;
        cHR();
        this.mHandler.removeMessages(1);
        if (this.AnG != null) {
            b bVar = this.AnG;
            if (com.tencent.pb.common.a.a.zLH) {
                bVar.AmY.field_capInfo = null;
            }
        }
        cHW();
        cHV();
        try {
            c.m("TalkRoomService", new Object[]{"cancelTalkDurationTimerTask"});
            if (this.AnL != null) {
                this.AnL.cancel();
            }
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"cancelTalkDurationTimerTask: ", e});
        }
        this.AnL = null;
        this.mHandler.removeCallbacks(this.Aof);
        this.Aoe = null;
        this.nTK = false;
        this.AnT = false;
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        if (this.AnG != null) {
            try {
                this.AnO = this.AnG.cHG();
                i = this.AnG.Close();
            } catch (Throwable th3) {
                c.m("TalkRoomService", new Object[]{"uninitService", th3});
            }
            c.m("TalkRoomService", new Object[]{"uninitService mid", Integer.valueOf(i)});
        }
        if (this.AnG != null) {
            try {
                uninitLive = this.AnG.uninitLive();
            } catch (Exception e2) {
                c.m("TalkRoomService", new Object[]{"uninitService 2", e2});
            }
            this.AnG = null;
            if (z) {
                cHZ = this.AnF.cHZ();
                if (!(TextUtils.isEmpty(this.AnF.groupId) && TextUtils.isEmpty(this.AnF.zMM))) {
                    h.acc(cHZ);
                    this.mHandler.removeMessages(4);
                    this.mHandler.sendEmptyMessageDelayed(4, 0);
                }
                cHT();
                try {
                    ((AudioManager) com.tencent.pb.common.c.d.ssG.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
                    c.m("TalkRoomService", new Object[]{"resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn())});
                } catch (Throwable th22) {
                    c.m("TalkRoomService", new Object[]{"resumeAudioConfig ", th22});
                }
            }
            c.d("TalkRoomService", new Object[]{"uninitService end error", Integer.valueOf(uninitLive)});
        }
        uninitLive = i;
        this.AnG = null;
        if (z) {
            cHZ = this.AnF.cHZ();
            h.acc(cHZ);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0);
            cHT();
            ((AudioManager) com.tencent.pb.common.c.d.ssG.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
            c.m("TalkRoomService", new Object[]{"resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn())});
        }
        c.d("TalkRoomService", new Object[]{"uninitService end error", Integer.valueOf(uninitLive)});
    }

    public final void cHR() {
        try {
            c.m("TalkRoomService", new Object[]{"stopHoldeOnPusher "});
            if (this.Aod != null) {
                this.mHandler.removeCallbacks(this.Aod);
            }
        } catch (Throwable th) {
            c.m("TalkRoomService", new Object[]{" stopTimer: ", th});
        }
    }

    final void setState(int i) {
        c.m("TalkRoomService", new Object[]{"setState newState: ", Integer.valueOf(i)});
        if (this.state != i) {
            this.state = i;
            g gVar = this.AnN;
            Runnable 9 = new 9(gVar, i);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                9.run();
            } else {
                gVar.handler.post(9);
            }
        }
    }

    static String[] dL(List<String> list) {
        if (list == null || list.size() <= 0) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        int i = 0;
        for (String str : list) {
            int i2 = i + 1;
            strArr[i] = str;
            i = i2;
        }
        return strArr;
    }

    public final b a(Activity activity, String str, int i, long j, int i2, int i3) {
        c.m("TalkRoomService", new Object[]{"enterTalkRoom", str, Integer.valueOf(this.nJW), Integer.valueOf(i), Long.valueOf(this.Anx), Long.valueOf(j), Integer.valueOf(i3), "needConfirm", Boolean.valueOf(false)});
        if (com.tencent.pb.a.a.a.cCW()) {
            com.tencent.pb.common.b.h.isNetworkConnected();
            if (Jb(i3) && i3 != 100 && bGq()) {
                h.a(str, "", this.nJW, this.Anx, new String[]{"enter", "req", "false", String.valueOf(i3), "isBusy"});
                c.m("TalkRoomService", new Object[]{"enterTalkRoom isBusy"});
                return b.BUSY;
            }
            boolean acb = i3 == 100 ? true : Jb(i3) ? this.state == 0 : i3 == 1 ? acb(str) : false;
            if (!acb) {
                c.m("TalkRoomService", new Object[]{"exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(i3), " state: ", Integer.valueOf(this.state)});
                h.a(str, "", this.nJW, this.Anx, new String[]{"enter", "req", "false", String.valueOf(i3), "isNotValidEnterState"});
                return b.NOT_VALID_STATE;
            } else if (TextUtils.isEmpty(str)) {
                c.m("TalkRoomService", new Object[]{"exitTalkRoom enterTalkRoom groupId is null"});
                h.a(str, "", this.nJW, this.Anx, new String[]{"enter", "req", "false", String.valueOf(i3), "groupIdnull"});
                return b.GROUP_NOT_VALID;
            } else {
                if (Jb(i3)) {
                    cHT();
                    nY(false);
                }
                cHQ();
                if (bES()) {
                    this.nln = str;
                    if (Jb(i3)) {
                        this.nJW = i;
                        this.Anx = j;
                    } else {
                        e aca = aca(str);
                        this.nJW = aca == null ? 0 : aca.nDx;
                        this.Anx = aca == null ? 0 : aca.nDy;
                    }
                    this.AnR = str;
                    this.zMg = i2;
                    setState(3);
                    this.slT = Jb(i3);
                    if (this.slT) {
                        this.AnF.cIa();
                    }
                    if (!this.slT || c.cHH().bt(this.nln, true)) {
                        b(str, this.nJW, this.Anx, i2, i3);
                    } else {
                        c cVar = new c(this);
                        cVar.groupId = str;
                        cVar.nDx = i;
                        cVar.nDy = j;
                        cVar.zMY = i3;
                        cVar.zMR = i2;
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = cVar;
                        this.mHandler.sendMessageDelayed(obtain, 0);
                    }
                    return b.OK;
                }
                c.m("TalkRoomService", new Object[]{"exitTalkRoom enterTalkRoom initEngine fail"});
                if (Jb(i3)) {
                    h.a(str, "", this.nJW, this.Anx, new String[]{"enter", "req", "false", "initEnginefail"});
                    nY(false);
                } else {
                    this.AnF.Q(new String[]{"enter", "req", "false", "initEnginefail"});
                }
                return b.INIT_ENGINE_FAILED;
            }
        }
        c.m("TalkRoomService", new Object[]{"enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.cCW()), " isBindMobile: ", Boolean.valueOf(true)});
        h.a(str, "", this.nJW, this.Anx, new String[]{"enter", "req", "false", String.valueOf(i3), "noAuth"});
        return b.NOT_AUTH;
    }

    private void b(String str, int i, long j, int i2, int i3) {
        c.m("TalkRoomService", new Object[]{"sendEnterGroupScence groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " enterType: ", Integer.valueOf(i3), " isSenceCircle: ", Boolean.valueOf(true)});
        if (i == 0 || j == 0) {
            c.e("TalkRoomService", new Object[]{"roomId or roomkey is 0..return."});
            return;
        }
        if (!Jb(i3)) {
            h hVar = this.AnF;
            c.d(h.TAG, new Object[]{"endAnswerTime", Long.valueOf(hVar.Apg)});
            if (hVar.Apg == 0) {
                hVar.nET = 0;
            } else {
                hVar.nET = System.currentTimeMillis() - hVar.Apg;
            }
        }
        this.AnF.cIb();
        com.tencent.pb.common.b.d eVar = new com.tencent.wecall.talkroom.a.e(str, i, j, this.AnG.cHF(), i2, i3);
        com.tencent.pb.common.b.e.cCE().a(eVar);
        this.mHandler.removeCallbacks(this.Aof);
        this.Aoe = eVar;
        this.mHandler.postDelayed(this.Aof, 3000);
    }

    public final boolean b(String str, int i, long j, int i2) {
        c.m("TalkRoomService", new Object[]{"rejectTalkRoom groupId: ", str, " mGroupId: ", this.nln, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " reason: ", Integer.valueOf(i2)});
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!(3 != (1 == i2 ? 1 : 3) || i2 == 7 || this.AnB == 0)) {
            System.currentTimeMillis();
        }
        boolean a = com.tencent.pb.common.b.e.cCE().a(new com.tencent.wecall.talkroom.a.i(str, i, j, i2));
        if (b(str, i, j, false)) {
            this.AnF.Q(new String[]{"reject", "req", String.valueOf(a), String.valueOf(this.state)});
        } else {
            h.a(str, i, j, new String[]{"reject", "req", String.valueOf(a), String.valueOf(this.state)});
        }
        a(str, i, j, false);
        c.m("TalkRoomService", new Object[]{"rejectTalkRoom ret: ", Boolean.valueOf(a)});
        return a;
    }

    private boolean dL(String str, int i) {
        c.m("TalkRoomService", new Object[]{"cancelCreateTalkRoom clientGroupId: ", str});
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.cCE().a(new com.tencent.wecall.talkroom.a.c(str, i, this.zMg));
        this.AnF.Q(new String[]{"cancel", "req", String.valueOf(a), String.valueOf(this.state)});
        a(str, this.nJW, this.Anx, true);
        c.m("TalkRoomService", new Object[]{"cancelCreateTalkRoom ret: ", Boolean.valueOf(a)});
        return a;
    }

    public final boolean a(String str, int i, long j, int i2, boolean z) {
        c.m("TalkRoomService", new Object[]{"exitTalkRoom", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        if (TextUtils.isEmpty(str)) {
            c.d("TalkRoomService", new Object[]{"exitTalkRoom: has exited"});
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.cCE().a(new com.tencent.wecall.talkroom.a.f(str, i, j, i2));
        this.AnF.Q(new String[]{"exit", "req", String.valueOf(a), String.valueOf(this.state)});
        a(str, i, j, z);
        c.m("TalkRoomService", new Object[]{"exitTalkRoom ret: ", Boolean.valueOf(a)});
        return a;
    }

    private boolean cHS() {
        boolean bbX;
        try {
            e eVar = zMs;
            if (eVar != null) {
                this.AnF.soC = eVar.bbZ();
                this.AnF.sos = eVar.bcc();
                bbX = eVar.bbX();
                c.d("TalkRoomService", new Object[]{"stopPlayer ret: ", Boolean.valueOf(bbX)});
                return bbX;
            }
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"stopPlayer: ", e});
        }
        bbX = false;
        c.d("TalkRoomService", new Object[]{"stopPlayer ret: ", Boolean.valueOf(bbX)});
        return bbX;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.b bVar) {
        int i3 = -100;
        try {
            e eVar = zMs;
            if (eVar != null) {
                i3 = eVar.a(i, i2, bVar);
            }
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"startPlayer: ", Integer.valueOf(i), Integer.valueOf(i2), e});
        }
        c.d("TalkRoomService", new Object[]{"startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3)});
        return i3;
    }

    private boolean vi() {
        boolean bbY;
        try {
            e eVar = zMs;
            if (eVar != null) {
                this.AnF.sov = eVar.bca();
                this.AnF.sor = eVar.bcb();
                bbY = eVar.bbY();
                c.d("TalkRoomService", new Object[]{"stopRecord ret: ", Boolean.valueOf(bbY)});
                return bbY;
            }
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"stopRecord: ", e});
        }
        bbY = false;
        c.d("TalkRoomService", new Object[]{"stopRecord ret: ", Boolean.valueOf(bbY)});
        return bbY;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
        int i3 = -100;
        try {
            e eVar = zMs;
            if (eVar != null) {
                i3 = eVar.a(i, i2, cVar);
            }
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"startRecord: ", e});
        }
        c.d("TalkRoomService", new Object[]{"startRecord samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3)});
        return i3;
    }

    public final void a(int i, int i2, String str, com.tencent.pb.common.b.d dVar) {
        Map x;
        String str2 = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "CLTNOT onNetSceneEnd errCode:";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " errType: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " scene.getType(): ";
        objArr[5] = dVar != null ? Integer.valueOf(dVar.getType()) : "";
        c.d(str2, objArr);
        if (i == 1 || i == 2) {
            x = com.tencent.pb.common.c.b.x(new Integer[]{Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX), Integer.valueOf(TXLiveConstants.PUSH_ERR_AUDIO_ENCODE_FAIL), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX), Integer.valueOf(-1512), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX), Integer.valueOf(-1522), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX), Integer.valueOf(-1532), Integer.valueOf(i.CTRL_INDEX), Integer.valueOf(-1542)});
            int type = dVar.getType();
            if (x.containsKey(Integer.valueOf(type))) {
                h.Jd(((Integer) x.get(Integer.valueOf(type))).intValue());
            }
        }
        k kVar;
        if (i2 == -1) {
            try {
                if (dVar.getType() == 201) {
                    com.tencent.wecall.talkroom.a.d dVar2 = (com.tencent.wecall.talkroom.a.d) dVar;
                    if (g.fU(this.Anw, dVar2.Anw)) {
                        this.AnF.Jh(301);
                        this.AnF.Q(new String[]{"create", "resp", "-1", String.valueOf(this.state)});
                        dL(dVar2.Anw, 1001);
                        if (!dVar2.Apr) {
                            this.AmO.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.AnN.g(-100, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX) {
                    this.AnN.dK(((com.tencent.wecall.talkroom.a.g) dVar).nln, i2);
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.a aVar = (com.tencent.wecall.talkroom.a.a) dVar;
                    if (!b(aVar.nln, aVar.nJW, aVar.Anx, false)) {
                        h.a(aVar.nln, aVar.nJW, aVar.Anx, new String[]{"ack", "resp", "-1", String.valueOf(this.state)});
                    }
                    this.AnN.a(aVar.Apq, c.cHH().abZ(aVar.nln));
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.b bVar = (com.tencent.wecall.talkroom.a.b) dVar;
                    if (b(bVar.nln, bVar.nJW, bVar.Anx, false)) {
                        this.AnF.Q(new String[]{"add", "resp", "-1", String.valueOf(this.state)});
                        this.AnN.g(-300, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 202) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) dVar;
                    if (b(eVar.nln, eVar.nJW, eVar.Anx, Jb(eVar.Aps)) && this.state == 3) {
                        this.AnF.Jh(HardCoderJNI.SCENE_QUIT_CHATTING);
                        this.AnN.g(-200, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                    this.AnN.dK(null);
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX) {
                    if (g.equals(((j) dVar).nln, this.nln)) {
                        this.AnF.Q(new String[]{"sendmsg", "resp", "-1", String.valueOf(this.state)});
                        this.AnN.g(-700, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == h.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.h hVar = (com.tencent.wecall.talkroom.a.h) dVar;
                    if (b(hVar.groupId, hVar.nDx, hVar.nDy, false)) {
                        this.AnF.Q(new String[]{"redirect", "resp", "-1", String.valueOf(this.state)});
                        return;
                    }
                    return;
                } else if (dVar.getType() == JsApiCheckIsSupportFaceDetect.CTRL_INDEX) {
                    l lVar = (l) dVar;
                    if (b(lVar.nln, lVar.nJW, lVar.Anx, false)) {
                        this.AnN.g(-800, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 800) {
                    kVar = (k) dVar;
                    if (b(kVar.nln, kVar.nJW, kVar.Anx, false)) {
                        this.AnN.g(-1600, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } catch (Exception e) {
                c.m("TalkRoomService", new Object[]{"cancelCreateTalkRoom: ", e});
                return;
            }
        }
        Map x2;
        g gVar;
        Runnable 6;
        int i3;
        Runnable 18;
        if (dVar.getType() == 201) {
            com.tencent.wecall.talkroom.a.d dVar3 = (com.tencent.wecall.talkroom.a.d) dVar;
            if (!(dVar3 == null || dVar3.zMe == null)) {
                Object obj;
                z zVar = (z) dVar3.zMe;
                c.m("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(i2), Integer.valueOf(dVar3.mType), dVar3.Anw});
                if (dVar3.Apr) {
                    obj = null;
                } else {
                    obj = 1;
                }
                x2 = com.tencent.pb.common.c.b.x(new Integer[]{Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009)});
                if (x2.containsKey(Integer.valueOf(i2))) {
                    h.Jd(((Integer) x2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 14002) {
                    Anm = null;
                    if (i2 != 0) {
                        if (g.fU(this.Anw, dVar3.Anw)) {
                            if (i2 != -1) {
                                this.AnF.Jh(321);
                                this.AnF.Q(new String[]{"create", "resp", String.valueOf(i2), String.valueOf(this.state)});
                            }
                            if (this.state != 1) {
                                c.m("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(i2), dVar3.Anw});
                                if (obj != null) {
                                    this.AmO.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            } else {
                                a(this.nln, this.nJW, this.Anx, true);
                                if (i2 == 14051) {
                                    this.AnN.g(-900, null);
                                } else if (i2 == 14052) {
                                    this.AnN.g(-1100, null);
                                } else if (i2 == 14053) {
                                    this.AnN.g(-1300, zVar);
                                } else if (i2 == 14504) {
                                    this.AnN.g(-1400, null);
                                } else {
                                    this.AnN.g(-100, null);
                                }
                                if (obj != null) {
                                    this.AmO.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            }
                        } else {
                            c.m("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.Anw, " createScene.mClientGroupId: ", dVar3.Anw, " errCode: ", Integer.valueOf(i2)});
                            if (obj != null) {
                                this.AmO.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        }
                    } else if (g.fU(this.Anw, zVar.zMM)) {
                        this.AnF.Q(new String[]{"create", "resp", String.valueOf(i2), String.valueOf(this.state)});
                        if (this.state != 1) {
                            h.Jd(-1003);
                            c.m("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), zVar.zMM, Integer.valueOf(zVar.slB), Long.valueOf(zVar.slC)});
                            if (obj != null) {
                                this.AmO.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else if (zVar.zOf == null || zVar.zOf.length == 0) {
                            c.m("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(i2), zVar.zMM, Integer.valueOf(zVar.slB), Long.valueOf(zVar.slC)});
                            h.Jd(-1605);
                            this.AnF.swo = 329;
                            a(zVar.groupId, zVar.slB, zVar.slC, 116, true);
                            if (obj != null) {
                                this.AmO.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                            this.AnN.g(-100, null);
                        } else {
                            a(zVar.zMM, zVar.slB, zVar.slC, zVar.groupId);
                            this.AnR = zVar.groupId;
                            this.zMg = zVar.zMR;
                            setState(4);
                            a(zVar.zOf, zVar.zOm, zVar.zOn);
                            a(zVar.groupId, zVar.zMM, zVar.zMR, zVar.slB, zVar.slC, zVar.zNs, zVar.zOg, zVar.zMO, false, true);
                            if (this.AnN != null) {
                                gVar = this.AnN;
                                6 = new 6(gVar, c.cHH().abZ(zVar.groupId));
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    6.run();
                                } else {
                                    gVar.handler.post(6);
                                }
                            }
                            byte[] bArr = new byte[zVar.zOi.length];
                            for (i3 = 0; i3 < zVar.zOi.length; i3++) {
                                bArr[i3] = (byte) zVar.zOi[i3];
                            }
                            a(0, zVar.zNs, zVar.zNt, bArr, (zVar.zOh & 2) != 0, zVar.groupId, zVar.slB, zVar.slC, zVar.zOo, zVar.zOp, zVar.zOq);
                            if (zVar.zOl != 0) {
                                c.l("TalkRoomService", new Object[]{"get helloFreqSeconds:" + zVar.zOl});
                                Ant = zVar.zOl * 1000;
                            }
                            cHU();
                            h(zVar.groupId, zVar.slB, zVar.slC);
                            if (obj != null) {
                                x = new HashMap();
                                x.put("result", Boolean.valueOf(true));
                                x.put("shareUrl", new String(zVar.zMO.zPa, Charset.forName(ProtocolPackage.ServerEncoding)));
                                x.put("smsShortUrl", new String(zVar.zMO.zPb, Charset.forName(ProtocolPackage.ServerEncoding)));
                                x.put("groupId", zVar.groupId);
                                this.AmO.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, x);
                            }
                            c.m("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd", this.nln, Integer.valueOf(this.nJW), Long.valueOf(this.Anx)});
                        }
                    } else {
                        c.m("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.Anw, " resp.clientGroupId: ", zVar.zMM, Integer.valueOf(zVar.slB), Long.valueOf(zVar.slC)});
                        a(zVar.groupId, zVar.slB, zVar.slC, 110, false);
                        if (obj != null) {
                            this.AmO.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    }
                }
            }
        }
        if (dVar.getType() == 202) {
            com.tencent.wecall.talkroom.a.e eVar2 = (com.tencent.wecall.talkroom.a.e) dVar;
            if (!(eVar2 == null || eVar2.zMe == null)) {
                a(i2, (aa) eVar2.zMe, eVar2);
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.b bVar2 = (com.tencent.wecall.talkroom.a.b) dVar;
            if (!(bVar2 == null || bVar2.zMe == null)) {
                x xVar = (x) bVar2.zMe;
                c.m("TalkRoomService", new Object[]{"handleAddVoiceGroupMemberEnd", this.nln, Integer.valueOf(this.nJW), Long.valueOf(this.Anx), " errCode: ", Integer.valueOf(i2)});
                x2 = com.tencent.pb.common.c.b.x(new Integer[]{Integer.valueOf(14600), Integer.valueOf(TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL), Integer.valueOf(14601), Integer.valueOf(TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL), Integer.valueOf(14602), Integer.valueOf(TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL)});
                if (x2.containsKey(Integer.valueOf(i2))) {
                    h.Jd(((Integer) x2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 == 0) {
                    str2 = "TalkRoomService";
                    objArr = new Object[2];
                    objArr[0] = "handleAddVoiceGroupMemberEnd  resp.members length: ";
                    objArr[1] = Integer.valueOf(xVar.zOe == null ? 0 : xVar.zOe.length);
                    c.m(str2, objArr);
                    if (b(xVar.groupId, xVar.slB, xVar.slC, false)) {
                        this.AnF.Q(new String[]{"add", "resp", String.valueOf(i2), String.valueOf(this.state)});
                    } else {
                        c.m("TalkRoomService", new Object[]{"handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", xVar.groupId, this.nln, " resp.roomid: ", Integer.valueOf(xVar.slB), Integer.valueOf(this.nJW)});
                        h.Jd(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED);
                    }
                    a(xVar.groupId, null, this.zMg, xVar.slB, xVar.slC, xVar.zOe, null, xVar.zMO, true, true);
                } else if (b(bVar2.nln, bVar2.nJW, bVar2.Anx, false)) {
                    this.AnF.Q(new String[]{"add", "resp", String.valueOf(i2), String.valueOf(this.state)});
                    this.AnN.g(-300, null);
                }
            }
        }
        if (dVar.getType() == 203) {
            com.tencent.wecall.talkroom.a.f fVar = (com.tencent.wecall.talkroom.a.f) dVar;
            if (!(fVar == null || fVar.zMe == null)) {
                ab abVar = (ab) fVar.zMe;
                c.d("TalkRoomService", new Object[]{"handleExitVoiceRoomEnd", abVar.groupId, this.nln, Integer.valueOf(this.nJW), Long.valueOf(this.Anx), " errCode: ", Integer.valueOf(i2)});
                x = com.tencent.pb.common.c.b.x(new Integer[]{Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204)});
                if (x.containsKey(Integer.valueOf(i2))) {
                    h.Jd(((Integer) x.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 0) {
                    c.m("TalkRoomService", new Object[]{"handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(i2)});
                }
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX) {
            m mVar = (m) dVar;
            if (!(mVar == null || mVar.zMe == null)) {
                ak akVar = (ak) mVar.zMe;
                c.d("TalkRoomService", new Object[]{"handleHelloEnd", akVar.groupId, this.nln, Integer.valueOf(this.nJW), Long.valueOf(this.Anx), Integer.valueOf(i2), Integer.valueOf(i)});
                cHV();
                i3 = 0;
                if (i2 == 14800) {
                    i3 = -1401;
                } else if (i2 == 14801) {
                    i3 = -1402;
                }
                if (i3 != 0) {
                    this.AnF.Jh(p.CTRL_INDEX);
                    h.Jd(i3);
                }
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.a aVar2 = (com.tencent.wecall.talkroom.a.a) dVar;
            if (!(aVar2 == null || aVar2.zMe == null)) {
                c.m("TalkRoomService", new Object[]{"CLTNOT handleAckEnd errCode is ", Integer.valueOf(i2), " groupId: ", aVar2.nln, " roomid: ", Integer.valueOf(aVar2.nJW), " roomKey: ", Long.valueOf(aVar2.Anx)});
                MultiTalkGroup abZ;
                if (i2 == 18950) {
                    if (!b(aVar2.nln, aVar2.nJW, aVar2.Anx, false)) {
                        h.a(aVar2.nln, aVar2.nJW, aVar2.Anx, new String[]{"ack", "resp", String.valueOf(i2), String.valueOf(this.state)});
                    }
                    abZ = c.cHH().abZ(aVar2.nln);
                    c.m("TalkRoomService", new Object[]{"CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", aVar2.nln, " multiTalkGroup: ", abZ});
                    if (abZ != null) {
                        this.AnN.a(aVar2.Apq, abZ);
                    }
                } else {
                    if (i2 == 0) {
                        this.Anu = true;
                    }
                    if (!bGq()) {
                        c.m("TalkRoomService", new Object[]{"CLTNOT handleAckEnd is working groupId: ", aVar2.nln});
                        cHT();
                        nY(false);
                        this.AnF.Q(new String[]{"ack", "resp", String.valueOf(i2), String.valueOf(this.state)});
                        this.slT = false;
                        this.nln = aVar2.nln;
                        this.AnR = this.nln;
                        this.nJW = aVar2.nJW;
                        this.Anx = aVar2.Anx;
                        this.zMg = aVar2.zMg;
                        setState(2);
                        this.AnB = System.currentTimeMillis();
                        h hVar2 = this.AnF;
                        c.d(h.TAG, new Object[]{"beginNotifyTime"});
                        hVar2.Apg = System.currentTimeMillis();
                        if (i2 == 18900) {
                            h.Jd(-1521);
                        }
                    } else if (g.equals(aVar2.nln, this.nln)) {
                        c.m("TalkRoomService", new Object[]{"CLTNOT handleAckEnd groupid same return ", this.nln});
                    }
                    e eVar3 = new e(this);
                    eVar3.groupId = aVar2.nln;
                    eVar3.nDx = aVar2.nJW;
                    eVar3.nDy = aVar2.Anx;
                    this.Ann.put(aVar2.nln, eVar3);
                    abZ = c.cHH().abZ(aVar2.nln);
                    c.m("TalkRoomService", new Object[]{"CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", aVar2.nln, " multiTalkGroup: ", abZ});
                    if (abZ != null) {
                        gVar = this.AnN;
                        6 = new 20(gVar, abZ);
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            6.run();
                        } else {
                            gVar.handler.post(6);
                        }
                    } else {
                        a(aVar2.nln, aVar2.nJW, aVar2.Anx, false, false, false);
                    }
                }
            }
        }
        if (dVar.getType() == 207) {
            com.tencent.wecall.talkroom.a.i iVar = (com.tencent.wecall.talkroom.a.i) dVar;
            if (!(iVar == null || iVar.zMe == null)) {
                if (i2 == 18100) {
                    h.Jd(-1501);
                }
                c.m("TalkRoomService", new Object[]{"handleRejectEnd  errCode is ", Integer.valueOf(i2)});
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.c cVar = (com.tencent.wecall.talkroom.a.c) dVar;
            if (!(cVar == null || cVar.zMe == null)) {
                if (i2 == 18300) {
                    h.Jd(-1531);
                }
                c.m("TalkRoomService", new Object[]{"handleCancelCreateEnd errCode is ", Integer.valueOf(i2)});
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.g gVar2 = (com.tencent.wecall.talkroom.a.g) dVar;
            if (!(gVar2 == null || gVar2.zMe == null)) {
                ac acVar = (ac) gVar2.zMe;
                if (i2 == 17900) {
                    h.Jd(-1511);
                }
                if (i2 != 0) {
                    this.AnN.dK(gVar2.nln, i2);
                    c.m("TalkRoomService", new Object[]{"handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(i2)});
                } else {
                    TalkRoom abU = c.cHH().abU(acVar.groupId);
                    if (abU != null) {
                        c.m("TalkRoomService", new Object[]{"handleVoiceGroupMemberChange handleModifyVoiceGroupEnd"});
                        a(acVar.groupId, null, abU.cHy(), TalkRoom.cHz(), TalkRoom.bHq(), null, null, acVar.zMO, true, false);
                    } else {
                        a(acVar.groupId, null, 0, 0, 0, null, null, acVar.zMO, true, false);
                    }
                    this.AnN.dK(acVar.groupId, 0);
                }
            }
        }
        if (dVar.getType() == i.CTRL_INDEX) {
            c.d("TalkRoomService", new Object[]{"talkHoldonResp", Integer.valueOf(i), Integer.valueOf(i2)});
            if (i2 == 19100) {
                h.Jd(-1541);
            }
        }
        if (dVar.getType() == h.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.h hVar3 = (com.tencent.wecall.talkroom.a.h) dVar;
            if (hVar3 != null) {
                a(i, i2, dVar.zMe, hVar3);
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
            a(i2, (ah) dVar.zMe);
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX) {
            j jVar = (j) dVar;
            c.m("TalkRoomService", new Object[]{"handleSendMsg errCode: ", Integer.valueOf(i2)});
            if (i2 != 0) {
                if (g.equals(jVar.nln, this.nln)) {
                    this.AnF.Q(new String[]{"sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state)});
                    this.AnN.g(-700, null);
                }
            } else if (g.equals(jVar.nln, this.nln)) {
                this.AnF.Q(new String[]{"sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state)});
                gVar = this.AnN;
                18 = new 18(gVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    18.run();
                } else {
                    gVar.handler.post(18);
                }
            }
        }
        if (dVar.getType() == JsApiCheckIsSupportFaceDetect.CTRL_INDEX) {
            af afVar = (af) dVar.zMe;
            l lVar2 = (l) dVar;
            c.m("TalkRoomService", new Object[]{"handleSwitchVideoGroup errCode: ", Integer.valueOf(i2)});
            if (b(lVar2.nln, lVar2.nJW, lVar2.Anx, false)) {
                if (this.AnG != null) {
                    c.d("TalkRoomService", new Object[]{"setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(new int[]{afVar.zOs, afVar.zOt, afVar.zOu, afVar.zOv, afVar.zOw, afVar.zOx}[0]), Integer.valueOf(new int[]{afVar.zOs, afVar.zOt, afVar.zOu, afVar.zOv, afVar.zOw, afVar.zOx}[1]), Integer.valueOf(new int[]{afVar.zOs, afVar.zOt, afVar.zOu, afVar.zOv, afVar.zOw, afVar.zOx}[2]), Integer.valueOf(new int[]{afVar.zOs, afVar.zOt, afVar.zOu, afVar.zOv, afVar.zOw, afVar.zOx}[3]), Integer.valueOf(new int[]{afVar.zOs, afVar.zOt, afVar.zOu, afVar.zOv, afVar.zOw, afVar.zOx}[4]), Integer.valueOf(new int[]{afVar.zOs, afVar.zOt, afVar.zOu, afVar.zOv, afVar.zOw, afVar.zOx}[5])});
                    this.AnG.AmY.setMVSvrCfg(r5, 6);
                }
                if (i2 == 0) {
                    g gVar3 = this.AnN;
                    6 = new 15(gVar3, afVar.zOs);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        6.run();
                    } else {
                        gVar3.handler.post(6);
                    }
                } else if (i2 == 24301) {
                    this.AnN.g(-1700, Integer.valueOf(afVar.zOz));
                } else {
                    this.AnN.g(-800, null);
                }
            } else {
                c.m("TalkRoomService", new Object[]{"handleSwitchVideoGroup isCurrentRoom is not same", lVar2.nln, Integer.valueOf(lVar2.nJW)});
            }
        }
        if (dVar.getType() == 800) {
            kVar = (k) dVar;
            c.m("TalkRoomService", new Object[]{"handleSubscribeLargeVideo errCode: ", Integer.valueOf(i2)});
            if (!b(kVar.nln, kVar.nJW, kVar.Anx, false)) {
                c.m("TalkRoomService", new Object[]{"handleSubscribeLargeVideo isCurrentRoom is not same", kVar.nln, Integer.valueOf(kVar.nJW)});
            } else if (i2 == 0) {
                gVar = this.AnN;
                18 = new 16(gVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    18.run();
                } else {
                    gVar.handler.post(18);
                }
            } else {
                this.AnN.g(-1600, null);
            }
        }
    }

    private void a(int i, ah ahVar) {
        c.m("TalkRoomService", new Object[]{"handleGetGroupInfoBatch errCode: ", Integer.valueOf(i)});
        if (i != 0) {
            this.AnN.dK(null);
            return;
        }
        au[] auVarArr = ahVar.zOA;
        if (auVarArr == null || auVarArr.length == 0) {
            c.m("TalkRoomService", new Object[]{"handleGetGroupInfoBatch resp.groupInfoList is null"});
            return;
        }
        List arrayList = new ArrayList();
        for (au auVar : auVarArr) {
            if (auVar != null) {
                a(auVar.groupId, null, 0, auVar.slB, auVar.slC, auVar.zOe, null, null, false, false);
                arrayList.add(c.cHH().abZ(auVar.groupId));
            }
        }
        c.m("TalkRoomService", new Object[]{"handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(arrayList.size())});
        this.AnN.dK(arrayList);
    }

    private void a(int i, int i2, Object obj, com.tencent.wecall.talkroom.a.h hVar) {
        c.d("TalkRoomService", new Object[]{"handleRedirectResp", Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 != 0 || obj == null) {
            c.e("TalkRoomService", new Object[]{"handleRedirectResp err", Integer.valueOf(i), Integer.valueOf(i2)});
            if (b(hVar.groupId, hVar.nDx, hVar.nDy, false)) {
                this.AnF.Q(new String[]{"redirect", "resp", "-1", String.valueOf(this.state)});
                return;
            }
            return;
        }
        aj ajVar = (aj) obj;
        if (b(ajVar.groupId, ajVar.slB, ajVar.slC, false)) {
            this.AnF.Q(new String[]{"redirect", "resp", String.valueOf(i2), String.valueOf(this.state)});
            a(ajVar.groupId, null, this.zMg, ajVar.slB, ajVar.slC, ajVar.zOe, ajVar.zOg, ajVar.zMO, false, false);
            byte[] bArr = new byte[ajVar.zOi.length];
            for (int i3 = 0; i3 < ajVar.zOi.length; i3++) {
                bArr[i3] = (byte) ajVar.zOi[i3];
            }
            a(ajVar.zOf, ajVar.zOm, ajVar.zOn);
            this.AnG.Close();
            a(0, ajVar.zOe, ajVar.zNt, bArr, (ajVar.zOh & 2) != 0, ajVar.groupId, ajVar.slB, ajVar.slC, ajVar.zOo, ajVar.zOp, ajVar.zOq);
            return;
        }
        c.e("TalkRoomService", new Object[]{"handleRedirectResp roomid error", Integer.valueOf(ajVar.slB), Integer.valueOf(this.nJW)});
    }

    private void a(int i, aa aaVar, com.tencent.wecall.talkroom.a.e eVar) {
        c.d("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd", eVar.nln, Integer.valueOf(eVar.nJW), Long.valueOf(eVar.Anx), " errCode: ", Integer.valueOf(i), " state: ", Integer.valueOf(this.state)});
        Map x = com.tencent.pb.common.c.b.x(new Integer[]{Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111)});
        if (x.containsKey(Integer.valueOf(i))) {
            h.Jd(((Integer) x.get(Integer.valueOf(i))).intValue());
        }
        if (i == 14255) {
            c.e("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), aaVar.groupId, Integer.valueOf(aaVar.slB), Long.valueOf(aaVar.slC)});
            this.AnN.g(-14255, aaVar);
        } else if (i == 14256) {
            c.e("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), aaVar.groupId, Integer.valueOf(aaVar.slB), Long.valueOf(aaVar.slC)});
            this.AnN.g(-14256, aaVar);
        } else if (i == 0 || i == 14204) {
            if (i == 14204 && this.state == 4) {
                c.m("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", aaVar.groupId, Integer.valueOf(aaVar.slB), Long.valueOf(aaVar.slC)});
            } else if (!b(aaVar.groupId, aaVar.slB, aaVar.slC, Jb(aaVar.zMY))) {
                c.m("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", aaVar.groupId, " mGroupId: ", this.nln, Integer.valueOf(aaVar.slB), Integer.valueOf(this.nJW), Long.valueOf(aaVar.slC), Long.valueOf(this.Anx)});
                a(aaVar.groupId, aaVar.slB, aaVar.slC, 111, false);
                h.Jd(-1110);
            } else if (this.state != 3) {
                c.m("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), aaVar.groupId, Integer.valueOf(aaVar.slB), Long.valueOf(aaVar.slC)});
            } else {
                this.AnF.Q(new String[]{"enter", "resp", String.valueOf(i), String.valueOf(this.state)});
                if (aaVar.zOf == null || aaVar.zOf.length == 0) {
                    c.m("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(i), aaVar.groupId, Integer.valueOf(aaVar.slB), Long.valueOf(aaVar.slC)});
                    h.Jd(-1605);
                    this.AnF.swo = 329;
                    a(aaVar.groupId, aaVar.slB, aaVar.slC, 116, true);
                    this.AnN.g(-200, null);
                    return;
                }
                this.nln = aaVar.groupId;
                this.AnR = aaVar.groupId;
                this.nJW = aaVar.slB;
                this.Anx = aaVar.slC;
                setState(4);
                a(aaVar.zOf, aaVar.zOm, aaVar.zOn);
                a(aaVar.groupId, null, this.zMg, aaVar.slB, aaVar.slC, aaVar.zOe, aaVar.zOg, aaVar.zMO, false, true);
                g gVar = this.AnN;
                Runnable 7 = new 7(gVar, c.cHH().abZ(aaVar.groupId));
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    7.run();
                } else {
                    gVar.handler.post(7);
                }
                byte[] bArr = new byte[aaVar.zOi.length];
                for (int i2 = 0; i2 < aaVar.zOi.length; i2++) {
                    bArr[i2] = (byte) aaVar.zOi[i2];
                }
                a(0, aaVar.zOe, aaVar.zNt, bArr, (aaVar.zOh & 2) != 0, aaVar.groupId, aaVar.slB, aaVar.slC, aaVar.zOo, aaVar.zOp, aaVar.zOq);
                if (aaVar.zOl != 0) {
                    c.l("TalkRoomService", new Object[]{"get helloFreqSeconds:" + aaVar.zOl});
                    Ant = aaVar.zOl * 1000;
                }
                cHU();
                c.m("TalkRoomService", new Object[]{"handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.nln, Integer.valueOf(this.nJW), Long.valueOf(this.Anx)});
            }
        } else if (!b(eVar.nln, eVar.nJW, eVar.Anx, Jb(eVar.Aps))) {
            c.m("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(i), " enterScene.mGroupId: ", eVar.nln, " mGroupId: ", this.nln, Integer.valueOf(eVar.nJW), Integer.valueOf(this.nJW), Long.valueOf(eVar.Anx), Long.valueOf(this.Anx)});
        } else if (3 != this.state) {
            c.m("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(i), eVar.nln, Integer.valueOf(eVar.nJW), Long.valueOf(eVar.Anx)});
        } else {
            this.AnF.Q(new String[]{"enter", "resp", String.valueOf(i), String.valueOf(this.state)});
            this.AnF.Jh(322);
            c.m("TalkRoomService", new Object[]{"exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(i), eVar.nln, Integer.valueOf(eVar.nJW), Long.valueOf(eVar.Anx)});
            a(eVar.nln, eVar.nJW, eVar.Anx, true);
            if (i == 14251) {
                this.AnN.g(DownloadResult.CODE_UNDEFINED, null);
            } else if (i == 14252) {
                this.AnN.g(-1200, null);
            } else if (i == 14253) {
                Object valueOf = Integer.valueOf(60);
                if (aaVar != null) {
                    valueOf = Integer.valueOf(aaVar.zOk);
                }
                this.AnN.g(-1500, valueOf);
            } else {
                this.AnN.g(-200, null);
            }
        }
    }

    private void a(String str, String str2, int i, int i2, long j, av[] avVarArr, aw[] awVarArr, at atVar, boolean z, boolean z2) {
        Integer num;
        String str3;
        boolean z3;
        if (avVarArr == null) {
            c.m("TalkRoomService", new Object[]{"printMembersLog members is null groupId: ", str, "  roomid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j)});
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (av avVar : avVarArr) {
                if (avVar != null) {
                    stringBuffer.append(" memberId:" + avVar.nEd + " uuid: " + avVar.zOC + " status: " + avVar.status + "   mem.inviteTime:" + avVar.zPv + "  mem.reason: " + avVar.aAk + "  mem.inviteuuid: " + avVar.zPH + "\n");
                }
            }
            c.m("TalkRoomService", new Object[]{"printMembersLog groupId: ", str, "  romid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j), "  members.length: ", Integer.valueOf(avVarArr.length), "  ", stringBuffer.toString()});
        }
        c cHH = c.cHH();
        if (i == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i);
        }
        boolean z4 = this.nln != null && this.nln.equals(str);
        c.d("TalkRoomManager", new Object[]{"newOrUpdateGroup groupId: ", str, " isActive: ", Boolean.valueOf(z4)});
        if (TextUtils.isEmpty(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (TextUtils.isEmpty(str3)) {
            c.m("TalkRoomManager", new Object[]{"newOrUpdateGroup invalid groupId"});
            z3 = false;
        } else {
            if (j.acg(str2)) {
                cHH.Anc.put(str2, str3);
            }
            TalkRoom talkRoom = (TalkRoom) cHH.Anb.get(str3);
            if (TextUtils.isEmpty(str2) || talkRoom == null || atVar == null || atVar.fvx == 100) {
                TalkRoom talkRoom2;
                if (talkRoom == null) {
                    if (j.acg(str2)) {
                        talkRoom2 = (TalkRoom) cHH.Anb.get(str2);
                    } else {
                        talkRoom2 = talkRoom;
                    }
                    if (talkRoom2 != null) {
                        cHH.Anb.put(str3, talkRoom2);
                    }
                } else {
                    talkRoom2 = talkRoom;
                }
                if (talkRoom2 != null && z4) {
                    int cId = j.cId();
                    long cIe = j.cIe();
                    c.d("TalkRoomManager", new Object[]{"check current active group roomId: ", Integer.valueOf(cId), " and roomKey: ", Long.valueOf(j)});
                    if (cId != 0 && cId != i2) {
                        c.m("TalkRoomManager", new Object[]{"diff roomId: ", Integer.valueOf(cId), " -> ", Integer.valueOf(i2)});
                        z3 = false;
                    } else if (!(0 == cIe || cIe == j)) {
                        c.m("TalkRoomManager", new Object[]{"diff roomKey: ", Long.valueOf(cIe), " -> ", Long.valueOf(j)});
                        z3 = false;
                    }
                }
                if (talkRoom2 == null) {
                    c.d("TalkRoomManager", new Object[]{"newOrUpdateGroup create groupId: ", str3});
                    cHH.Anb.put(str3, TalkRoom.a(str3, str2, num, i2, j, atVar, avVarArr, awVarArr));
                } else {
                    c.d("TalkRoomManager", new Object[]{"newOrUpdateGroup update groupId: ", str3});
                    TalkRoom.a(talkRoom2, str3, str2, num, i2, j, atVar, avVarArr, awVarArr);
                }
                if (cHH.And != null && z) {
                    cHH.And.g(cHH.abZ(str3));
                }
                c.cHI();
                z3 = true;
            } else {
                c.m("TalkRoomManager", new Object[]{"newOrUpdateGroup clientGroupId is not empty , room is not null"});
                z3 = false;
            }
        }
        String str4 = "TalkRoomService";
        Object[] objArr = new Object[16];
        objArr[0] = "engine handleVoiceGroupMemberChange";
        objArr[1] = str;
        objArr[2] = this.nln;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(this.nJW);
        objArr[5] = Long.valueOf(j);
        objArr[6] = Long.valueOf(this.Anx);
        objArr[7] = Boolean.valueOf(z3);
        objArr[8] = " isCurrentRoom: ";
        objArr[9] = Boolean.valueOf(b(str, i2, j, false));
        objArr[10] = " members.length: ";
        objArr[11] = Integer.valueOf(avVarArr != null ? avVarArr.length : 0);
        objArr[12] = " isCallBackEngine: ";
        objArr[13] = Boolean.valueOf(z2);
        objArr[14] = " mFirstGetAudioData: ";
        objArr[15] = Boolean.valueOf(this.AnC);
        c.d(str4, objArr);
        if (c.cHH().bt(this.nln, false)) {
            c.m("TalkRoomService", new Object[]{"handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.AnC), " mGroupId: ", this.nln, " roomId: ", Integer.valueOf(i2)});
            if (this.AnC) {
                this.AnC = false;
                this.nTK = true;
                this.AnP = k.cIf();
                this.AnA = this.Any;
                if (this.AnL != null) {
                    c.m("TalkRoomService", new Object[]{"refreashTalkingTime mTalkDurationTimerTask is null"});
                } else {
                    c.m("TalkRoomService", new Object[]{"refreashTalkingTime mTalkRoomTalkingCallBack: ", this.Anl, " mIsHoldOn: ", Boolean.valueOf(this.Aob)});
                    this.AnL = new 7(this);
                    this.AnM.scheduleAtFixedRate(this.AnL, 1000, 1000);
                }
            }
        }
        if (avVarArr != null && z2 && b(str, i2, j, false) && avVarArr.length > 0 && this.AnG != null) {
            a(avVarArr);
        }
    }

    private void a(av[] avVarArr) {
        if (avVarArr == null) {
            c.m("TalkRoomService", new Object[]{"onMebersChangedToEngine members is null"});
            return;
        }
        int[] iArr = new int[avVarArr.length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < avVarArr.length; i++) {
            iArr[i] = avVarArr[i].nEd;
            stringBuffer.append(avVarArr[i].nEd);
            stringBuffer.append(",");
        }
        c.m("TalkRoomService", new Object[]{"engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", stringBuffer.toString()});
        if (this.AnG == null) {
            c.m("TalkRoomService", new Object[]{"onMebersChangedToEngine engine is null"});
            return;
        }
        this.AnG.OnMembersChanged(iArr);
    }

    private void a(o[] oVarArr, o[] oVarArr2, int i) {
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "handleRelayData addrs length: ";
        objArr[1] = Integer.valueOf(oVarArr == null ? 0 : oVarArr.length);
        c.d(str, objArr);
        if (oVarArr != null && oVarArr.length > 0) {
            this.AnX = new int[oVarArr.length];
            this.AnW = new short[oVarArr.length];
            this.AnZ = new int[oVarArr2.length];
            this.AnY = new short[oVarArr2.length];
            this.Aoa = i;
            c.m("TalkRoomService", new Object[]{"handleRelayData tcpStartTime: ", Integer.valueOf(this.Aoa)});
            int i2 = 0;
            for (o oVar : oVarArr) {
                this.AnX[i2] = oVar.zNp;
                this.AnW[i2] = (short) oVar.port;
                c.m("TalkRoomService", new Object[]{"handleRelayData ip: ", Integer.valueOf(oVar.zNp), " addr.port: ", Integer.valueOf(oVar.port)});
                i2++;
            }
            i2 = 0;
            for (o oVar2 : oVarArr2) {
                this.AnZ[i2] = oVar2.zNp;
                this.AnY[i2] = (short) oVar2.port;
                c.m("TalkRoomService", new Object[]{"handleRelayData tcpIp: ", Integer.valueOf(oVar2.zNp), " tcpAddr.port: ", Integer.valueOf(oVar2.port)});
                i2++;
            }
            c.d("TalkRoomService", new Object[]{"handleRelayData", Arrays.toString(this.AnX), Arrays.toString(this.AnW), this.nln, this.nln, Integer.valueOf(this.nJW), Long.valueOf(this.Anx), Arrays.toString(this.AnZ), Arrays.toString(this.AnY), Integer.valueOf(this.Aoa)});
        }
    }

    public final int bS(byte[] bArr) {
        com.tencent.pb.common.b.a.a.p pVar;
        try {
            pVar = (com.tencent.pb.common.b.a.a.p) com.google.a.a.e.a(new com.tencent.pb.common.b.a.a.p(), bArr, bArr.length);
        } catch (Exception e) {
            h.Jd(-1601);
            pVar = null;
        }
        if (pVar == null) {
            if (TextUtils.isEmpty(this.nln) && TextUtils.isEmpty(this.Anw)) {
                h.a(this.nJW, this.Anx, new String[]{"notify", "pasrefail"});
            } else {
                this.AnF.Q(new String[]{"notify", "pasrefail"});
            }
            c.m("TalkRoomService", new Object[]{"CLTNOT onVoiceGroupChange groupChg null"});
            return -2;
        }
        Object obj;
        c.m("TalkRoomService", new Object[]{"CLTNOT onVoiceGroupChange", this.nln, Integer.valueOf(this.nJW), Long.valueOf(this.Anx), Long.valueOf(pVar.fqm), Integer.valueOf(pVar.zNq)});
        long j = pVar.fqm;
        if (this.AnS.contains(Long.valueOf(j))) {
            obj = 1;
        } else {
            this.AnS.add(Long.valueOf(j));
            obj = null;
        }
        if (obj != null) {
            c.d("TalkRoomService", new Object[]{"CLTNOT onVoiceGroupChange isMsgDouble error"});
            if (b(pVar.groupId, pVar.slB, pVar.slC, false)) {
                this.AnF.Q(new String[]{"notify", "repeat", String.valueOf(pVar.zNq)});
            } else {
                h.a(pVar.groupId, pVar.slB, pVar.slC, new String[]{"notify", "repeat", String.valueOf(pVar.zNq)});
            }
            return -3;
        }
        if (b(pVar.groupId, pVar.slB, pVar.slC, false)) {
            this.AnF.Q(new String[]{"notify", "succ", String.valueOf(pVar.zNq)});
        }
        if (pVar.zNq == 4 || pVar.zNq == 2) {
            a(pVar.groupId, null, pVar.zMR, pVar.slB, pVar.slC, pVar.zNs, pVar.zNr, pVar.zMO, true, true);
        } else if (pVar.zNq == 16) {
            a(pVar.groupId, null, pVar.zMR, pVar.slB, pVar.slC, pVar.zNs, pVar.zNr, pVar.zMO, true, false);
        } else if (pVar.zNq == 1) {
            c.m("TalkRoomService", new Object[]{"handlerCreateGroupChange groupChg.groupId: ", pVar.groupId, " roomId: ", Integer.valueOf(pVar.slB), " roomkey: ", Long.valueOf(pVar.slC)});
            if (!com.tencent.pb.a.a.a.cCW()) {
                c.m("TalkRoomService", new Object[]{"CLTNOT handlerCreateGroupChange isAuthed is false"});
            } else if (bGq() && g.equals(pVar.groupId, this.nln)) {
                c.m("TalkRoomService", new Object[]{"CLTNOT handlerCreateGroupChange return is same groupId: ", this.nln});
            } else {
                a(pVar.groupId, null, pVar.zMR, pVar.slB, pVar.slC, pVar.zNs, pVar.zNr, pVar.zMO, false, true);
                Object obj2 = pVar.groupId;
                r3 = pVar.slB;
                long j2 = pVar.slC;
                int i = pVar.zMR;
                int i2 = pVar.zNu;
                if (TextUtils.isEmpty(obj2)) {
                    c.m("TalkRoomService", new Object[]{"CLTNOT ackTalkRoom groupId is null"});
                } else {
                    boolean a = com.tencent.pb.common.b.e.cCE().a(new com.tencent.wecall.talkroom.a.a(obj2, r3, j2, i, i2));
                    c.d("TalkRoomService", new Object[]{"CLTNOT ackTalkRoom groupId: ", obj2, Integer.valueOf(r3), Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(a)});
                }
                c.m("TalkRoomService", new Object[]{"handlerCreateGroupChange start ui"});
            }
        } else if (pVar.zNq == 8) {
            c.m("TalkRoomService", new Object[]{"handleCancelCreateVoiceGroupChange groupChg.groupId: ", pVar.groupId, " mGroupId: ", this.nln});
            if (b(pVar.groupId, pVar.slB, pVar.slC, false)) {
                a(pVar.groupId, null, pVar.zMR, pVar.slB, pVar.slC, pVar.zNs, pVar.zNr, pVar.zMO, true, false);
                a(pVar.groupId, pVar.slB, pVar.slC, false, false, true);
            } else {
                a(pVar.groupId, null, pVar.zMR, pVar.slB, pVar.slC, pVar.zNs, pVar.zNr, pVar.zMO, true, false);
            }
        } else if (pVar.zNq == FileUtils.S_IWUSR) {
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "handleMemberWhisper groupChg.groupChg.groupId: ";
            objArr[1] = pVar.groupId;
            objArr[2] = " mGroupId: ";
            objArr[3] = this.nln;
            objArr[4] = " groupChg.whisperBuf size: ";
            objArr[5] = Integer.valueOf(pVar.zNv == null ? 0 : pVar.zNv.length);
            c.d(str, objArr);
            r0 = this.AnN;
            Runnable 17 = new 17(r0, pVar.groupId, pVar.zNv);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                17.run();
            } else {
                r0.handler.post(17);
            }
        } else if (pVar.zNq == 256) {
            if (!b(pVar.groupId, pVar.slB, pVar.slC, false)) {
                c.m("TalkRoomService", new Object[]{"handleVideoMember is not same room ", pVar.groupId, Integer.valueOf(pVar.slB)});
            } else if (pVar.zNv == null) {
                c.m("TalkRoomService", new Object[]{"handleVideoMember whisperBuf is null", pVar.groupId, Integer.valueOf(pVar.slB)});
            } else {
                r rVar;
                try {
                    r0 = pVar.zNv;
                    rVar = (r) com.google.a.a.e.a(new r(), r0, r0.length);
                } catch (com.google.a.a.d e2) {
                    c.m("TalkRoomService", new Object[]{"handleVideoMember ", e2});
                    rVar = null;
                }
                if (rVar == null || rVar.zNz == null) {
                    c.m("TalkRoomService", new Object[]{"handleVideoMember notify is null", pVar.groupId, Integer.valueOf(pVar.slB)});
                } else {
                    List arrayList = new ArrayList();
                    for (Object obj3 : rVar.zNz) {
                        if (obj3 != null) {
                            arrayList.add(obj3);
                        }
                    }
                    c.d("TalkRoomService", new Object[]{"handleVideoMember groupid: ", this.nln, " roomId: ", Integer.valueOf(this.nJW), " videoUserNames: ", arrayList});
                    r0 = this.AnN;
                    r2 = new 11(r0, arrayList);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        r2.run();
                    } else {
                        r0.handler.post(r2);
                    }
                }
            }
        } else if (pVar.zNq == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            if (!b(pVar.groupId, pVar.slB, pVar.slC, false)) {
                c.m("TalkRoomService", new Object[]{"handleOtherDevice is not same room ", pVar.groupId, Integer.valueOf(pVar.slB)});
            } else if (!(this.state == 3 || this.state == 4)) {
                b(pVar.groupId, pVar.slB, pVar.slC, 1);
                this.AnN.g(-1400, null);
            }
        } else if (pVar.zNq == WXMediaMessage.TITLE_LENGTH_LIMIT) {
            if (!b(pVar.groupId, pVar.slB, pVar.slC, false)) {
                c.m("TalkRoomService", new Object[]{"handleVideoSubscribes is not same room ", pVar.groupId, Integer.valueOf(pVar.slB)});
            } else if (pVar.zNv == null) {
                c.m("TalkRoomService", new Object[]{"handleVideoSubscribes whisperBuf is null", pVar.groupId, Integer.valueOf(pVar.slB)});
            } else {
                q qVar;
                try {
                    r0 = pVar.zNv;
                    qVar = (q) com.google.a.a.e.a(new q(), r0, r0.length);
                } catch (com.google.a.a.d e22) {
                    c.m("TalkRoomService", new Object[]{"handleVideoSubscribes ", e22});
                    qVar = null;
                }
                if (qVar == null) {
                    c.m("TalkRoomService", new Object[]{"handleVideoMember notify is null", pVar.groupId, Integer.valueOf(pVar.slB)});
                } else {
                    g gVar = this.AnN;
                    r2 = new 1(gVar, qVar.zNy);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        r2.run();
                    } else {
                        gVar.handler.post(r2);
                    }
                }
            }
        }
        return 0;
    }

    public final void cHT() {
        h hVar = this.AnF;
        c.d(h.TAG, new Object[]{"reset"});
        hVar.Apg = 0;
        hVar.Apf = 0;
        hVar.Ape = 0;
        hVar.groupId = "";
        hVar.zMM = "";
        hVar.soo = 1;
        hVar.nDx = 0;
        hVar.nDy = 0;
        hVar.nEd = -1;
        hVar.swo = 0;
        hVar.swv = 0;
        hVar.swr = 0;
        hVar.nEU = 0;
        hVar.AoR = 0;
        hVar.AoS = 0;
        hVar.AoT = 0;
        hVar.AoU = 0;
        hVar.AoV = 0;
        hVar.AoW = 0;
        hVar.AoX = 0;
        hVar.AoY = 0;
        hVar.sww = 0;
        hVar.nET = 0;
        hVar.swB = 0;
        hVar.swC = 0;
        hVar.netType = -1;
        hVar.AoZ = 0;
        hVar.Apa = 0;
        hVar.Apb = "";
        hVar.deviceModel = "";
        hVar.Apc = -1;
        hVar.swH = "";
        hVar.Apd.setLength(0);
        hVar.soC = -1;
        hVar.sov = 0;
        hVar.sor = 0;
        hVar.sos = 0;
    }

    private void a(String str, int i, long j, boolean z) {
        a(str, i, j, z, true, true);
    }

    public final void a(String str, int i, long j, boolean z, boolean z2, boolean z3) {
        c.m("TalkRoomService", new Object[]{"closeVoiceGroup groupId: ", str, " mGroupId: ", this.nln, " roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.nJW), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.Anx)});
        try {
            TalkRoom abU = c.cHH().abU(str);
            if (abU == null) {
                c.m("TalkRoomManager", new Object[]{"handleRoomExit assert failed: current TalkRoom MUST exists"});
            } else {
                d abT = abU.abT(com.tencent.pb.a.a.a.cCV());
                if (abT != null) {
                    abT.Ane.status = 20;
                    abT.Ane.nEd = -1;
                }
                String str2 = "tagorewang:TalkRoom";
                Object[] objArr = new Object[2];
                objArr[0] = "resetRoomTempInfo groupId: ";
                objArr[1] = abU.zQq == null ? "" : abU.zQq;
                c.d(str2, objArr);
                c.cHI();
            }
        } catch (Throwable th) {
            c.m("TalkRoomManager", new Object[]{"handleRoomExit: ", th});
        }
        if (z) {
            h(str, i, j);
        }
        this.Ann.remove(str);
        if (b(str, i, j, false)) {
            c.d("TalkRoomService", new Object[]{"closeVoiceGroup isCurrentRoom groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j)});
            nY(true);
            g gVar = this.AnN;
            Runnable 8 = new 8(gVar, str, z2);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                8.run();
            } else {
                gVar.handler.post(8);
            }
        }
        if (z3) {
            MultiTalkGroup abZ = c.cHH().abZ(str);
            if (abZ != null) {
                this.AnN.g(abZ);
            }
        }
    }

    public final boolean bGq() {
        c.m("TalkRoomService", new Object[]{"state: ", Integer.valueOf(this.state)});
        if (this.state != 0) {
            return true;
        }
        return false;
    }

    public final e aca(String str) {
        return (e) this.Ann.get(str);
    }

    public final boolean acb(String str) {
        return ((e) this.Ann.get(str)) != null;
    }

    private void cHU() {
        c.m("TalkRoomService", new Object[]{"hello timer start~~"});
        if (this.AnI != null) {
            c.m("TalkRoomService", new Object[]{"dealWithInit enter talkroom not first time"});
            return;
        }
        try {
            this.AnI = new TimerTask(this) {
                final /* synthetic */ f Aog;

                {
                    this.Aog = r1;
                }

                public final void run() {
                    if (this.Aog.nJW == 0 || this.Aog.nln == null) {
                        c.m("TalkRoomService", new Object[]{"talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(this.Aog.nJW), this.Aog.nln});
                        this.Aog.cHW();
                        return;
                    }
                    f.a(this.Aog, f.j(this.Aog));
                }
            };
            this.AnK.schedule(this.AnI, 0, (long) Ant);
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"startNooper: ", e});
        }
    }

    private void cHV() {
        try {
            c.m("TalkRoomService", new Object[]{"cancelHelloTimeOutTask"});
            if (this.AnJ != null) {
                this.AnJ.cancel();
            }
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"cancelHelloTimeOutTask: ", e});
        }
        this.AnJ = null;
    }

    private void cHW() {
        try {
            c.m("TalkRoomService", new Object[]{"cancelHelloTimerTask"});
            if (this.AnI != null) {
                this.AnI.cancel();
            }
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"cancelHelloTimerTask: ", e});
        }
        this.AnI = null;
    }

    private void a(int i, av[] avVarArr, as asVar, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2) {
        boolean z2;
        Exception e;
        c.d("TalkRoomService", new Object[]{"dealWithInit", Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(this.state)});
        if (this.AnG != null) {
            try {
                if (this.state != 4) {
                    c.m("TalkRoomService", new Object[]{"dealWithInit state is error: ", Integer.valueOf(this.state)});
                    z2 = false;
                } else {
                    z2 = a(avVarArr, asVar, bArr, z, i2, j, i3, i4, bArr2);
                }
                try {
                    c.m("TalkRoomService", new Object[]{"dealWithInit ret: ", Boolean.valueOf(z2)});
                } catch (Exception e2) {
                    e = e2;
                    c.m("TalkRoomService", new Object[]{"dealWithInit ", e});
                    if (z2) {
                        return;
                    }
                    if (i <= 0) {
                        this.AnF.Jh(202);
                        c.m("TalkRoomService", new Object[]{"exitTalkRoom dealWithInit fail"});
                        a(str, i2, j, 102, true);
                        this.AnN.g(-400, null);
                        return;
                    }
                    this.mHandler.postDelayed(new 4(this, i, avVarArr, asVar, bArr, z, str, i2, j, i3, i4, bArr2), 50);
                }
            } catch (Exception e3) {
                e = e3;
                z2 = false;
                c.m("TalkRoomService", new Object[]{"dealWithInit ", e});
                if (z2) {
                    return;
                }
                if (i <= 0) {
                    this.mHandler.postDelayed(new 4(this, i, avVarArr, asVar, bArr, z, str, i2, j, i3, i4, bArr2), 50);
                }
                this.AnF.Jh(202);
                c.m("TalkRoomService", new Object[]{"exitTalkRoom dealWithInit fail"});
                a(str, i2, j, 102, true);
                this.AnN.g(-400, null);
                return;
            }
            if (z2) {
                return;
            }
        }
        if (i <= 0) {
            this.AnF.Jh(202);
            c.m("TalkRoomService", new Object[]{"exitTalkRoom dealWithInit fail"});
            a(str, i2, j, 102, true);
            this.AnN.g(-400, null);
            return;
        }
        this.mHandler.postDelayed(new 4(this, i, avVarArr, asVar, bArr, z, str, i2, j, i3, i4, bArr2), 50);
    }

    final boolean bES() {
        int yp;
        c.d("TalkRoomService", new Object[]{"initEngine", this.nln, Integer.valueOf(this.nJW), Long.valueOf(this.Anx), Integer.valueOf(this.state)});
        try {
            b bVar = this.AnG;
            if (com.tencent.pb.common.a.a.zLH) {
                int i;
                String absolutePath = com.tencent.pb.common.c.d.ssG.getDir("lib", 0).getAbsolutePath();
                e eVar = zMs;
                if (eVar != null) {
                    yp = eVar.yp();
                } else {
                    yp = 0;
                }
                c.d("simon:TalkRoomContext", new Object[]{"protocalInit netType:", Integer.valueOf(k.iM(com.tencent.pb.common.c.d.ssG)), " cpuFlag:", Integer.valueOf(yp), "libPath:", absolutePath});
                yp = bVar.AmY.init(r6, yp, absolutePath + "/");
                absolutePath = "simon:TalkRoomContext";
                Object[] objArr = new Object[4];
                objArr[0] = "protocalInit";
                objArr[1] = Integer.valueOf(yp);
                objArr[2] = "field_capInfo length: ";
                if (bVar.AmY.field_capInfo == null) {
                    i = 0;
                } else {
                    i = bVar.AmY.field_capInfo.length;
                }
                objArr[3] = Integer.valueOf(i);
                c.d(absolutePath, objArr);
            } else {
                yp = 0;
            }
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"initEngine", e});
            yp = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (yp >= 0) {
            return true;
        }
        h.Jg(-3001);
        this.AnF.Jh(201);
        this.AnG = null;
        c.m("TalkRoomService", new Object[]{"initEngine engine.protocalInit error", Integer.valueOf(yp)});
        return false;
    }

    public final void nZ(boolean z) {
        try {
            vi();
            cHS();
            if (z) {
                cHX();
                aTQ();
            }
            c.m("TalkRoomService", new Object[]{"setRecordDevActive active: ", Boolean.valueOf(z)});
        } catch (Throwable th) {
            c.m("TalkRoomService", new Object[]{"setRecordDevActive active: ", Boolean.valueOf(z), th});
        }
    }

    private void aTQ() {
        vi();
        int b = b(talk.oFK, talk.oFL, new 5(this));
        if (b <= 0) {
            this.AnF.Jh(101);
            h.Je(-2001);
            this.AnN.g(-500, null);
        }
        h hVar;
        if (b > 0) {
            hVar = this.AnF;
            hVar.AoR &= -2;
        } else {
            hVar = this.AnF;
            hVar.AoR |= 1;
        }
        c.m("TalkRoomService", new Object[]{"audioAdapter startRecord ret: ", Integer.valueOf(b)});
    }

    private void cHX() {
        cHS();
        if (b(talk.oFK, talk.oFL, new 6(this, new AtomicInteger(), new AtomicInteger())) <= 0) {
            this.AnF.Jh(101);
            h.Je(-2001);
            h hVar = this.AnF;
            hVar.AoR |= 1;
            this.AnN.g(-500, null);
        }
        c.m("TalkRoomService", new Object[]{"audioAdapter startPlayer ret: ", Integer.valueOf(r0)});
    }

    private boolean a(av[] avVarArr, as asVar, byte[] bArr, boolean z, int i, long j, int i2, int i3, byte[] bArr2) {
        int[] iArr;
        int i4;
        int i5;
        c.d("TalkRoomService", new Object[]{"connectToCompenent myRoomMemId roomid:", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " groupId: ", this.nln, " ip: ", Arrays.toString(this.AnX), " ports: ", Arrays.toString(this.AnW), " tcpIp: ", Arrays.toString(this.AnZ), " tcpPorts: ", Arrays.toString(this.AnY), " tcpStartTime: ", Integer.valueOf(this.Aoa)});
        String cCV = com.tencent.pb.a.a.a.cCV();
        int i6 = -1;
        if (avVarArr == null || avVarArr.length <= 0) {
            iArr = null;
            i4 = -1;
        } else {
            int[] iArr2 = new int[avVarArr.length];
            for (i5 = 0; i5 < avVarArr.length; i5++) {
                iArr2[i5] = avVarArr[i5].nEd;
                if (g.equals(avVarArr[i5].zOC, cCV)) {
                    i6 = avVarArr[i5].nEd;
                }
            }
            iArr = iArr2;
            i4 = i6;
        }
        int abV = c.cHH().abV(this.nln);
        this.AnF.nEd = i4;
        try {
            int i7;
            b bVar = this.AnG;
            talk.a aVar = this.AnH;
            TalkRoom abU = c.cHH().abU(this.nln);
            if (abU == null) {
                c.m("TalkRoomManager", new Object[]{"getMyUuid TalkRoom is null  groupId: ", r3});
                i7 = 0;
            } else {
                d abT = abU.abT(com.tencent.pb.a.a.a.cCV());
                if (abT == null) {
                    c.m("TalkRoomManager", new Object[]{"getMyUuid talkRoomMember is null  groupId: ", r3});
                    i7 = 0;
                } else {
                    av avVar = abT.Ane;
                    if (avVar == null) {
                        c.m("TalkRoomManager", new Object[]{"getMyUuid voiceGroupMem is null  groupId: ", r3});
                        i7 = 0;
                    } else {
                        c.d("TalkRoomManager", new Object[]{"getMyUuid groupId: ", r3, " uuid: ", Integer.valueOf(avVar.vCD)});
                        i7 = avVar.vCD;
                    }
                }
            }
            int[] iArr3 = this.AnX;
            short[] sArr = this.AnW;
            int[] iArr4 = this.AnZ;
            short[] sArr2 = this.AnY;
            int i8 = this.Aoa;
            c.d("simon:TalkRoomContext", new Object[]{"Open"});
            i iVar = null;
            if (asVar != null) {
                iVar = new i(asVar.zON, asVar.huk, asVar.hul, asVar.zOO, asVar.zOP, asVar.zOQ, asVar.zOR, asVar.zOS, asVar.zOT, asVar.zOU, asVar.zOV, asVar.zOW);
            } else {
                c.m("simon:TalkRoomContext", new Object[]{"voiceConf is null"});
            }
            i5 = bVar.AmY.Open(aVar, iVar, i7, i4, i, j, iArr3, sArr, 0, iArr, bArr, z, k.iM(com.tencent.pb.common.c.d.ssG), iArr4, sArr2, i8, i2, i3, bArr2);
        } catch (Throwable th) {
            c.m("TalkRoomService", new Object[]{"connectToCompenent", th});
            i5 = QbSdk.EXTENSION_INIT_FAILURE;
        }
        g gVar = this.AnN;
        Runnable com_tencent_wecall_talkroom_model_g_2 = new g$2(gVar, i5);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com_tencent_wecall_talkroom_model_g_2.run();
        } else {
            gVar.handler.post(com_tencent_wecall_talkroom_model_g_2);
        }
        c.d("TalkRoomService", new Object[]{"connectToCompenent ret =", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(abV)});
        if (i5 < 0) {
            h.Jg(-3002);
        }
        if (i5 == 0) {
            this.AnF.swr = 1;
        }
        if (i5 == 0) {
            return true;
        }
        return false;
    }

    private boolean b(String str, int i, long j, boolean z) {
        if (z) {
            return g.fU(str, this.nln);
        }
        c.m("TalkRoomService", new Object[]{"isCurrentRoom groupId: ", str, " mGroupId: ", this.nln, "roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.nJW), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.Anx)});
        if (g.fU(str, this.nln) && i == this.nJW && j == this.Anx) {
            return true;
        }
        return false;
    }

    private void h(String str, int i, long j) {
        String str2 = null;
        try {
            c cHH = c.cHH();
            if (i == 0 && j == 0) {
                c.m("TalkRoomManager", new Object[]{"getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", str});
            } else {
                TalkRoom abU = cHH.abU(str);
                if (abU == null) {
                    c.m("TalkRoomManager", new Object[]{"getMsgKeyByGroupId talkRoom is null,groupId: ", str});
                } else {
                    d abT = abU.abT(com.tencent.pb.a.a.a.cCV());
                    if (abT == null) {
                        c.m("TalkRoomManager", new Object[]{"getMsgKeyByGroupId talkRoomMember is null,groupId: ", str});
                    } else {
                        av avVar = abT.Ane;
                        if (avVar == null) {
                            c.m("TalkRoomManager", new Object[]{"getMsgKeyByGroupId voiceGroupMem is null,groupId: ", str});
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(",");
                            stringBuffer.append(i);
                            stringBuffer.append(",");
                            stringBuffer.append(j);
                            stringBuffer.append(",");
                            stringBuffer.append(avVar.zPx);
                            c.m("TalkRoomManager", new Object[]{"getMsgKeyByGroupId msgKey is", stringBuffer.toString()});
                            str2 = stringBuffer.toString();
                        }
                    }
                }
            }
            c.m("TalkRoomService", new Object[]{"addCallLog groupId: ", str, " mIsOutCall: ", Boolean.valueOf(this.slT), " mTalkDuration: ", Integer.valueOf(this.Any), " msgKey: ", str2});
        } catch (Throwable th) {
            c.m("TalkRoomService", new Object[]{"handleRoomExit: ", th});
        }
    }

    public final boolean ah(String str, int i, int i2) {
        c.m("TalkRoomService", new Object[]{"finishCurrentTalk groupId: ", str, " rejectReason: ", Integer.valueOf(i), " exitReason: ", Integer.valueOf(i2)});
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i == 1 || i2 == 100) {
            h hVar = this.AnF;
            c.d(h.TAG, new Object[]{"endCancelCreate", Long.valueOf(System.currentTimeMillis() - hVar.Ape), Long.valueOf(hVar.AoT)});
            if (hVar.AoT <= 0) {
                hVar.swv = 1;
                if (hVar.Ape == 0) {
                    hVar.sww = 0;
                } else {
                    hVar.sww = System.currentTimeMillis() - hVar.Ape;
                }
            }
        }
        int i3 = this.nJW;
        long j = this.Anx;
        int i4 = a.cHv().state;
        if (j.acg(str)) {
            this.AnF.Jh(327);
            return a.cHv().dL(str, 1000);
        } else if (i4 == 2) {
            return a.cHv().b(str, i3, j, i);
        } else {
            Integer[] numArr = new Integer[]{Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108)};
            List arrayList = new ArrayList();
            for (i4 = 0; i4 < 7; i4++) {
                arrayList.add(numArr[i4]);
            }
            arrayList.contains(Integer.valueOf(i2));
            return a.cHv().a(str, i3, j, i2, true);
        }
    }

    public final void dJ(String str, int i) {
        if (!g.equals("GLOBAL_TOPIC_NETWORK_CHANGE", str) || !bGq()) {
            return;
        }
        if (this.nTK || this.Anv) {
            switch (i) {
                case 21:
                    switch (k.iM(com.tencent.pb.common.c.d.ssG)) {
                        case 4:
                            this.AnP = true;
                            break;
                        default:
                            this.AnP = false;
                            break;
                    }
                    if (this.nJW == 0 || this.Anx == 0) {
                        c.m("TalkRoomService", new Object[]{"sendRedirect mRoomId valid(session ended)"});
                        return;
                    }
                    c.m("TalkRoomService", new Object[]{"sendRedirect", this.nln, Integer.valueOf(this.nJW)});
                    this.AnF.cIb();
                    boolean a = com.tencent.pb.common.b.e.cCE().a(new com.tencent.wecall.talkroom.a.h(this.nln, this.nJW, this.Anx, c.cHH().abV(this.nln)));
                    this.AnF.Q(new String[]{"redirect", "req", String.valueOf(a), String.valueOf(this.state)});
                    c.m("TalkRoomService", new Object[]{"sendRedirect ret: ", Boolean.valueOf(a)});
                    return;
                case 33:
                    b bVar = this.AnG;
                    int iM = k.iM(com.tencent.pb.common.c.d.ssG);
                    if (com.tencent.pb.common.a.a.zLH) {
                        bVar.AmY.onNetworkChange(iM);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean Jb(int i) {
        return i != 1;
    }

    private void a(String str, int i, long j, String str2) {
        this.nJW = i;
        this.Anx = j;
        this.nln = str2;
        this.Anw = str;
    }

    public static boolean xQ() {
        boolean isSpeakerphoneOn;
        try {
            isSpeakerphoneOn = ((AudioManager) com.tencent.pb.common.c.d.ssG.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isSpeakerphoneOn();
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"isSpeakerOn ", e});
            isSpeakerphoneOn = false;
        }
        c.d("TalkRoomService", new Object[]{"isSpeakerOn ret: ", Boolean.valueOf(isSpeakerphoneOn)});
        return isSpeakerphoneOn;
    }

    public static void a(e eVar) {
        zMs = eVar;
    }

    public static e cHY() {
        return zMs;
    }
}
