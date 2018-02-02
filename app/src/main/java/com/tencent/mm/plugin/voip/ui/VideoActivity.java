package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ar.b;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.e;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.j.11;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.ui.d.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMSuperAlert;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity extends MMActivity implements b, d, SensorController.a {
    private String gAb;
    private af jKT;
    private boolean mIsMute = false;
    private int mStatus;
    private boolean mmz = false;
    private CaptureView slO;
    private x slS;
    private boolean slT;
    private boolean slU;
    private int slY = 1;
    private d spM;
    private WeakReference<c> spN;
    private SensorController spO;
    private long spP = -1;
    private long spQ = 0;
    private boolean spR = false;
    private int spS = 1;
    private boolean spT = false;
    private boolean spU = false;
    private c spV = new 1(this);
    private TelephonyManager spW = null;
    private long spX;

    static /* synthetic */ void a(VideoActivity videoActivity, int i) {
        int i2;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = R.l.eVe;
        } else if (i == 233) {
            com.tencent.mm.plugin.voip.model.d.bGj().bHu();
            i2 = R.l.eVd;
        } else {
            i2 = i == bd.CTRL_BYTE ? (!b.PT() || videoActivity.slU) ? R.l.eVf : R.l.eVh : i == JsApiGetSetting.CTRL_INDEX ? R.l.eVr : i == h.CTRL_INDEX ? R.l.eVg : 0;
        }
        if (i2 != 0 || videoActivity.spM == null) {
            if (i2 == 0) {
                i2 = R.l.eVc;
            }
            MMSuperAlert.i(videoActivity, R.l.dGO, i2);
            return;
        }
        videoActivity.spM.co(videoActivity.getString(R.l.eVc), -1);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        boolean a;
        super.onCreate(bundle);
        if (!com.tencent.mm.plugin.voip.b.d.dD(this.mController.xIM)) {
            com.tencent.mm.plugin.voip.b.d.dE(this.mController.xIM);
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(3);
        getWindow().addFlags(6815872);
        if (ar.Hj()) {
            com.tencent.mm.plugin.voip.model.d.bGj().B(false, false);
        }
        this.jKT = new af();
        PBool pBool = new PBool();
        PBool pBool2 = new PBool();
        PString pString = new PString();
        PInt pInt = new PInt();
        pString.value = getIntent().getStringExtra("Voip_User");
        pBool.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        pBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.spX = getIntent().getLongExtra("Voip_LastPage_Hash", 0);
        pInt.value = com.tencent.mm.plugin.voip.b.b.E(pBool.value, pBool2.value);
        if (pBool.value) {
            try {
                if (bcF()) {
                    Toast.makeText(this, R.l.ept, 0).show();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
                    super.finish();
                    return;
                }
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "not ready now!");
            }
        }
        m bGj = com.tencent.mm.plugin.voip.model.d.bGj();
        if (bGj.smT != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
            pString.value = bGj.smT.gAb;
            pBool.value = bGj.smT.slT;
            pBool2.value = bGj.smT.slU;
            pInt.value = bGj.smT.slK.mState;
        } else {
            if (pString.value == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
                obj = null;
            } else if (pBool.value || bGj.smS.bGq()) {
                String str;
                j jVar;
                List F;
                com.tencent.mm.plugin.voip.video.j jVar2;
                IntentFilter intentFilter;
                bGj.smT = new j();
                j jVar3 = bGj.smT;
                String str2 = pString.value;
                boolean z = pBool.value;
                boolean z2 = pBool2.value;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[]{str2, Boolean.valueOf(z), Boolean.valueOf(z2)});
                jVar3.smm = true;
                jVar3.gAb = str2;
                jVar3.slT = z;
                jVar3.slU = z2;
                ar.Hg();
                jVar3.slS = com.tencent.mm.z.c.EY().WO(jVar3.gAb);
                jVar3.jKT = new af();
                jVar3.slV = bh.getInt(g.zY().getValue("VOIPCameraSwitch"), 1) == 0;
                if (!jVar3.slU) {
                    jVar3.slV = false;
                }
                int E = com.tencent.mm.plugin.voip.b.b.E(z, z2);
                if (jVar3.slV) {
                    if (E == 0) {
                        E = 1;
                    } else if (256 == E) {
                        E = 257;
                    }
                }
                if (z) {
                    jVar3.slK = com.tencent.mm.plugin.voip.b.b.yR(E);
                } else {
                    jVar3.slK = com.tencent.mm.plugin.voip.b.b.yQ(E);
                }
                boolean yY = com.tencent.mm.compatible.e.b.yY();
                boolean za = com.tencent.mm.compatible.e.b.za();
                if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                    com.tencent.mm.plugin.report.service.g gVar;
                    Object[] objArr;
                    if (!yY) {
                        gVar = com.tencent.mm.plugin.report.service.g.pQN;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(jVar3.slU ? 0 : 1);
                        objArr[1] = Integer.valueOf(1);
                        gVar.h(11306, objArr);
                    }
                    if (!za) {
                        gVar = com.tencent.mm.plugin.report.service.g.pQN;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(jVar3.slU ? 0 : 1);
                        objArr[1] = Integer.valueOf(0);
                        gVar.h(11306, objArr);
                    }
                }
                if (!(za && yY)) {
                    String str3 = null;
                    str = null;
                    if (!yY && !za) {
                        str3 = getString(R.l.dGK);
                        str = getString(R.l.dFK);
                    } else if (!yY) {
                        str3 = getString(R.l.dGM);
                        str = getString(R.l.dFL);
                    } else if (!za) {
                        str3 = getString(R.l.dGL);
                        str = getString(R.l.dFM);
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, str3, str, getString(R.l.dFN), true, new 11(jVar3, this));
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "initMgr");
                ar.ux().wB();
                ar.Hh().b(jVar3);
                ar.Hh().a(jVar3);
                ar.Hh().xI();
                jVar3.flu = new com.tencent.mm.compatible.util.b(ac.getContext());
                jVar3.flu.requestFocus();
                if (jVar3.slU) {
                    com.tencent.mm.plugin.voip.model.d.bGj().a(true, true, jVar3.gAb);
                } else {
                    com.tencent.mm.plugin.voip.model.d.bGj().a(true, false, jVar3.gAb);
                }
                if (jVar3.slT) {
                    com.tencent.mm.plugin.voip.model.d.bGj().smS.bHC();
                    if ((jVar3.slU ? com.tencent.mm.plugin.voip.model.d.bGj().smS.cn(jVar3.slS.field_username, 0) : com.tencent.mm.plugin.voip.model.d.bGj().smS.cn(jVar3.slS.field_username, 1)) < 0) {
                        jVar3.fz(false);
                    }
                }
                jVar3.slL = new HeadsetPlugReceiver();
                jVar3.slL.a(ac.getContext(), jVar3.sms);
                m bGj2 = com.tencent.mm.plugin.voip.model.d.bGj();
                Context context = ac.getContext();
                n nVar = bGj2.smS;
                nVar.siL.kaK = context;
                nVar.siL.skf = jVar3;
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", "attach ui........");
                jVar3.nCb = (TelephonyManager) ac.getContext().getSystemService("phone");
                jVar3.nCb.listen(jVar3.nCc, 32);
                com.tencent.mm.plugin.voip.model.d.bGj().k(R.k.dAk, jVar3.slU ? 0 : 1, jVar3.slT);
                if (ar.Hh().xR()) {
                    E = 3;
                    jVar = jVar3;
                } else if (ar.Hh().xL()) {
                    E = 4;
                    jVar = jVar3;
                } else if (jVar3.slU) {
                    E = 1;
                    jVar = jVar3;
                } else {
                    E = 2;
                    jVar = jVar3;
                }
                jVar.slY = E;
                if (jVar3.slU) {
                    jVar3.smb = true;
                } else {
                    jVar3.smb = false;
                }
                str2 = "voip_recent_contact" + q.FS();
                SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("voip_plugin_prefs", 0);
                str = sharedPreferences.getString(str2, null);
                if (str != null) {
                    F = bh.F(str.split(";"));
                    if (F != null) {
                        int size = F.size();
                        if (F.contains(jVar3.gAb)) {
                            if (size > 1) {
                                F.remove(jVar3.gAb);
                            }
                            sharedPreferences.edit().putString(str2, bh.d(F, ";")).commit();
                            com.tencent.mm.sdk.b.a.xef.b(jVar3.smt);
                            com.tencent.mm.sdk.b.a.xef.b(jVar3.nCd);
                            jVar2 = jVar3.smf;
                            if (!jVar2.kwZ.contains(jVar3)) {
                                jVar2.kwZ.add(jVar3);
                            }
                            intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.SCREEN_ON");
                            intentFilter.addAction("android.intent.action.SCREEN_OFF");
                            intentFilter.addAction("android.intent.action.USER_PRESENT");
                            ac.getContext().registerReceiver(jVar3.smr, intentFilter);
                        } else if (4 == size) {
                            F.remove(size - 1);
                        }
                        F.add(0, jVar3.gAb);
                        sharedPreferences.edit().putString(str2, bh.d(F, ";")).commit();
                        com.tencent.mm.sdk.b.a.xef.b(jVar3.smt);
                        com.tencent.mm.sdk.b.a.xef.b(jVar3.nCd);
                        jVar2 = jVar3.smf;
                        if (jVar2.kwZ.contains(jVar3)) {
                            jVar2.kwZ.add(jVar3);
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        ac.getContext().registerReceiver(jVar3.smr, intentFilter);
                    }
                }
                F = new ArrayList();
                F.add(0, jVar3.gAb);
                sharedPreferences.edit().putString(str2, bh.d(F, ";")).commit();
                com.tencent.mm.sdk.b.a.xef.b(jVar3.smt);
                com.tencent.mm.sdk.b.a.xef.b(jVar3.nCd);
                jVar2 = jVar3.smf;
                if (jVar2.kwZ.contains(jVar3)) {
                    jVar2.kwZ.add(jVar3);
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                ac.getContext().registerReceiver(jVar3.smr, intentFilter);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
                l.a(pString.value, pBool2.value ? au.xzd : au.xzc, pBool.value ? 1 : 0, 4, ac.getContext().getString(R.l.eUg));
                obj = null;
            }
            if (obj != null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
                super.finish();
            }
            this.spN = new WeakReference(obj);
            this.gAb = pString.value;
            this.slU = pBool2.value;
            this.slT = pBool.value;
            this.mStatus = pInt.value;
            ar.Hg();
            this.slS = com.tencent.mm.z.c.EY().WO(this.gAb);
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_username", this.slS.field_username);
            bundle2.putBoolean("key_isoutcall", this.slT);
            bundle2.putInt("key_status", com.tencent.mm.plugin.voip.b.b.E(this.slT, this.slU));
            if (com.tencent.mm.plugin.voip.b.b.yT(this.mStatus)) {
                this.spM = new f();
            } else {
                this.spM = new e();
            }
            this.spM.setArguments(bundle2);
            getSupportFragmentManager().aS().b(R.h.cXn, this.spM).commit();
            setTitleVisibility(8);
            if (com.tencent.mm.plugin.voip.b.b.yU(this.mStatus) && this.slT) {
                this.jKT.postDelayed(new 4(this), 20000);
            }
            this.spM.a((c) this.spN.get());
            this.spM.a(this);
            this.spM.yL(this.slY);
            this.spM.setMute(this.mIsMute);
            if (com.tencent.mm.plugin.voip.model.d.bGj().smT.smq != null) {
                MD(com.tencent.mm.plugin.voip.model.d.bGj().smT.smq);
            }
            this.spO = new SensorController(this.mController.xIM);
            if (!(this.spN == null || this.spN.get() == null)) {
                ((c) this.spN.get()).a(this, 1);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[]{Boolean.valueOf(this.slT), Boolean.valueOf(this.slU), this.gAb, Integer.valueOf(this.mStatus)});
            if (this.spO != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onCreate setSensorCallBack");
                this.spO.a(this);
            }
            if (com.tencent.mm.plugin.voip.b.b.yT(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bh.cgy(), this});
            } else {
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bh.cgy(), this});
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bh.cgy(), this});
            }
            com.tencent.mm.sdk.b.a.xef.b(this.spV);
            return;
        }
        obj = bGj.smT;
        if (obj != null) {
            this.spN = new WeakReference(obj);
            this.gAb = pString.value;
            this.slU = pBool2.value;
            this.slT = pBool.value;
            this.mStatus = pInt.value;
            ar.Hg();
            this.slS = com.tencent.mm.z.c.EY().WO(this.gAb);
            Bundle bundle22 = new Bundle();
            bundle22.putString("key_username", this.slS.field_username);
            bundle22.putBoolean("key_isoutcall", this.slT);
            bundle22.putInt("key_status", com.tencent.mm.plugin.voip.b.b.E(this.slT, this.slU));
            if (com.tencent.mm.plugin.voip.b.b.yT(this.mStatus)) {
                this.spM = new f();
            } else {
                this.spM = new e();
            }
            this.spM.setArguments(bundle22);
            getSupportFragmentManager().aS().b(R.h.cXn, this.spM).commit();
            setTitleVisibility(8);
            this.jKT.postDelayed(new 4(this), 20000);
            this.spM.a((c) this.spN.get());
            this.spM.a(this);
            this.spM.yL(this.slY);
            this.spM.setMute(this.mIsMute);
            if (com.tencent.mm.plugin.voip.model.d.bGj().smT.smq != null) {
                MD(com.tencent.mm.plugin.voip.model.d.bGj().smT.smq);
            }
            this.spO = new SensorController(this.mController.xIM);
            ((c) this.spN.get()).a(this, 1);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[]{Boolean.valueOf(this.slT), Boolean.valueOf(this.slU), this.gAb, Integer.valueOf(this.mStatus)});
            if (this.spO != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onCreate setSensorCallBack");
                this.spO.a(this);
            }
            if (com.tencent.mm.plugin.voip.b.b.yT(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bh.cgy(), this});
            } else {
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bh.cgy(), this});
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bh.cgy(), this});
            }
            com.tencent.mm.sdk.b.a.xef.b(this.spV);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
        super.finish();
    }

    private static boolean bcF() {
        Exception e;
        boolean z;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ac.getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            switch (telephonyManager.getCallState()) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            try {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[]{Integer.valueOf(r2)});
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[]{e.getLocalizedMessage()});
            return z;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void bGV() {
        this.jKT.postDelayed(new 5(this), 2000);
    }

    public final void dQ(int i, int i2) {
        this.mStatus = i2;
        if (1 != this.spS && i2 != 8 && i2 != 262) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
        } else if (this.spM == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
        } else {
            this.spM.dQ(i, i2);
            switch (i2) {
                case 1:
                case 3:
                case 7:
                case 257:
                case 261:
                    if (this.spM == null || !(this.spM instanceof f)) {
                        if (this.spM != null) {
                            this.spM.uninit();
                            getSupportFragmentManager().aS().a(this.spM).commit();
                            this.spM = null;
                        }
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("key_username", this.slS.field_username);
                        bundle.putBoolean("key_isoutcall", this.slT);
                        bundle.putInt("key_status", this.mStatus);
                        this.spM = new f();
                        this.spM.setArguments(bundle);
                        this.spM.a((c) this.spN.get());
                        this.spM.ff(this.spP);
                        this.spM.a(this);
                        this.spM.yL(this.slY);
                        this.spM.setMute(this.mIsMute);
                        this.spM.b(this.slO);
                        getSupportFragmentManager().aS().b(R.h.cXn, this.spM).commit();
                        return;
                    }
                    return;
                case 8:
                case 262:
                    switch (i) {
                        case 4098:
                            this.jKT.postDelayed(new 6(this), 50);
                            break;
                        case 4099:
                            if (this.slT) {
                                this.spM.co(this.slU ? getString(R.l.eVR) : getString(R.l.eUb), -1);
                            }
                            bGV();
                            break;
                        case 4103:
                        case 4104:
                            bGV();
                            break;
                        case 4106:
                            this.jKT.post(new 9(this));
                            break;
                        case 4107:
                            finish();
                            break;
                        case 4109:
                            this.jKT.post(new 10(this));
                            break;
                    }
                    bGV();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            if (com.tencent.mm.plugin.voip.model.d.bGj().bHv() || this.slT) {
                ar.Hh().fz(ar.Hh().xL() ? ar.Hh().xX() : aTR());
            } else {
                com.tencent.mm.plugin.voip.model.d.bGj().stopRing();
            }
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            if (com.tencent.mm.plugin.voip.model.d.bGj().bHv() || this.slT) {
                ar.Hh().fy(ar.Hh().xL() ? ar.Hh().xX() : aTR());
            } else {
                com.tencent.mm.plugin.voip.model.d.bGj().stopRing();
            }
            return true;
        }
    }

    protected void onDestroy() {
        this.spS = 4;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yP(this.mStatus)});
        if (!this.spU) {
            finish();
        }
        if (this.spO != null && this.spO.xic) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onDestroy removeSensorCallBack");
            setScreenEnable(true);
            this.spO.cgf();
        }
        if (!(this.spN == null || this.spN.get() == null)) {
            ((c) this.spN.get()).a(this);
        }
        com.tencent.mm.sdk.b.a.xef.c(this.spV);
        this.spO = null;
        super.onDestroy();
    }

    protected void onStop() {
        this.spS = 2;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yP(this.mStatus)});
        super.onStop();
        if (262 != this.mStatus && 8 != this.mStatus && this.spT && !this.spU && this.spN != null && this.spN.get() != null && ((c) this.spN.get()).jh(false)) {
            D(false, true);
            if (com.tencent.mm.plugin.voip.b.b.yS(this.mStatus)) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(com.tencent.mm.plugin.voip.b.b.yT(this.mStatus) ? 2 : 3);
                objArr[1] = Integer.valueOf(2);
                gVar.h(11618, objArr);
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.spU) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onStart");
            this.spS = 1;
            dQ(Downloads.RECV_BUFFER_SIZE, this.mStatus);
        }
    }

    public void finish() {
        boolean z;
        this.spS = 3;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[]{Boolean.valueOf(this.spR), com.tencent.mm.plugin.voip.b.b.yP(this.mStatus)});
        if (!(this.spR || !com.tencent.mm.plugin.voip.b.b.yS(this.mStatus) || 4 == this.spS)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.gAb);
            com.tencent.mm.plugin.voip.a.a.ifs.e(intent, (Context) this);
        }
        if (this.spO != null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "removeSensorCallBack");
            setScreenEnable(true);
            this.spO.cgf();
            this.spO = null;
        }
        if (this.spM != null) {
            if (this.spM.sqf == 4105) {
                z = true;
            } else {
                z = false;
            }
            this.spM.uninit();
            this.spM = null;
        } else {
            z = false;
        }
        this.spN = null;
        this.slO = null;
        this.spU = true;
        super.finish();
        if (z) {
            com.tencent.mm.sdk.b.b igVar = new ig();
            igVar.fyJ.fyM = true;
            igVar.fyJ.fyL = this.spX;
            com.tencent.mm.sdk.b.a.xef.m(igVar);
            return;
        }
        igVar = new ig();
        igVar.fyJ.fyM = false;
        igVar.fyJ.fyL = 0;
        com.tencent.mm.sdk.b.a.xef.m(igVar);
    }

    protected void onNewIntent(Intent intent) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onPause() {
        boolean z;
        super.onPause();
        PowerManager powerManager = (PowerManager) ac.getContext().getSystemService("power");
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) ac.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        boolean hasWindowFocus = hasWindowFocus();
        boolean isScreenOn = powerManager.isScreenOn();
        if ((hasWindowFocus || !inKeyguardRestrictedInputMode) && isScreenOn) {
            z = true;
        } else {
            z = false;
        }
        this.spT = z;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yP(this.mStatus), Boolean.valueOf(this.spT), Boolean.valueOf(hasWindowFocus), Boolean.valueOf(inKeyguardRestrictedInputMode), Boolean.valueOf(isScreenOn)});
    }

    public void onResume() {
        int i = 0;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yP(this.mStatus)});
        ar.getNotification().cancel(40);
        e eVar = com.tencent.mm.plugin.voip.model.d.bGj().smS.siL;
        if (eVar.sjQ) {
            eVar.sjQ = false;
        }
        super.onResume();
        setScreenEnable(true);
        this.spQ = bh.Wq();
        if (this.slT && com.tencent.mm.plugin.voip.b.b.yU(this.mStatus) && com.tencent.mm.plugin.voip.model.d.bGj().bHv()) {
            if (!this.slU) {
                i = 1;
            }
            com.tencent.mm.plugin.voip.model.d.bGj().k(R.k.dAk, i, this.slT);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.spM != null) {
            this.spM.a(bArr, j, i, i2, i3, i4, i5, i6);
        }
    }

    public final void aJ(int i, String str) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.slU)});
        this.mmz = true;
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE) {
            com.tencent.mm.ui.base.h.b(this, str, null, true);
        } else {
            this.jKT.post(new 7(this, i));
        }
    }

    public final void MD(String str) {
        if (this.spM != null) {
            this.jKT.post(new 8(this, str));
        }
    }

    protected final int getLayoutId() {
        return R.i.dtL;
    }

    public final void dT(boolean z) {
        if (bh.Wq() - this.spQ < 500) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onSensorEvent time interval too small");
        } else if ((this.slT || com.tencent.mm.plugin.voip.b.b.yS(this.mStatus)) && !com.tencent.mm.plugin.voip.b.b.yT(this.mStatus)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onSensorEvent, isOn: " + z);
            setScreenEnable(z);
        }
    }

    protected final void dealContentView(View view) {
        ae.c(ae.a(getWindow(), null), this.mController.xIy);
        ((ViewGroup) getWindow().getDecorView()).addView(view, 0);
    }

    private int aTR() {
        int bGh;
        if (com.tencent.mm.plugin.voip.b.b.yS(this.mStatus)) {
            bGh = com.tencent.mm.plugin.voip.model.d.bGj().bGh();
        } else {
            bGh = ar.Hh().xL() ? 0 : 2;
            if (this.slT) {
                if (this.slU) {
                    bGh = 3;
                    if (com.tencent.mm.compatible.d.q.gFV.gDj >= 0) {
                        bGh = com.tencent.mm.compatible.d.q.gFV.gDj;
                    }
                } else if (com.tencent.mm.compatible.d.q.gFV.gDm >= 0) {
                    bGh = com.tencent.mm.compatible.d.q.gFV.gDm;
                } else {
                    bGh = 0;
                }
            }
            if (!ar.Hh().xL() && com.tencent.mm.compatible.d.q.gFV.gDo >= 0) {
                bGh = com.tencent.mm.compatible.d.q.gFV.gDo;
            }
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[]{Integer.valueOf(bGh)});
        return bGh;
    }

    public final void yL(int i) {
        this.slY = i;
        if (this.spM != null) {
            this.spM.yL(i);
        }
    }

    public final void setMute(boolean z) {
        this.mIsMute = z;
        if (this.spM != null) {
            this.spM.setMute(z);
        }
    }

    public final void b(int i, int i2, int[] iArr) {
        if (this.spM != null) {
            this.spM.b(i, i2, iArr);
        }
    }

    public final void bGZ() {
        if (this.spM != null) {
            this.spM.bGZ();
        }
    }

    public final Context bIa() {
        return this.mController.xIM;
    }

    public final void uninit() {
        if (this.spM != null) {
            this.spM.uninit();
        }
    }

    public final void fe(long j) {
        this.spP = j;
        if (this.spM != null) {
            this.spM.ff(this.spP);
        }
    }

    public final void bIb() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning");
        if (this.spM != null) {
            this.spM.bIc();
        }
    }

    public final void aUI() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
        if (this.spM != null) {
            this.spM.bId();
        }
    }

    public final void D(boolean z, boolean z2) {
        this.spR = z2;
        if (z) {
            bGV();
        } else {
            finish();
        }
    }

    public final void a(CaptureView captureView) {
        this.slO = captureView;
        if (this.spM != null) {
            this.spM.b(captureView);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.l.ezM : R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ VideoActivity spY;

                        {
                            this.spY = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.spY.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new 2(this));
                    return;
                }
                return;
            case 82:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 3(this), null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
