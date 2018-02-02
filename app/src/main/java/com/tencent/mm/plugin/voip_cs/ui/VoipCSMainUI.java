package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.g.g;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver$a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.b.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.Arrays;

@a(3)
public class VoipCSMainUI extends MMActivity implements com.tencent.mm.plugin.voip_cs.b.a, com.tencent.mm.plugin.voip_cs.b.b.a.a {
    private String appId = "";
    public String fKC = "";
    private b flu;
    public String fyY = ac.getContext().getString(R.l.eUP);
    private af hae;
    public String jiK = "";
    private TelephonyManager nCb;
    PhoneStateListener nCc = new 5(this);
    private n pUH = new 10(this);
    private HeadsetPlugReceiver slL = null;
    private BroadcastReceiver smr = new 4(this);
    private HeadsetPlugReceiver$a sms = new 3(this);
    public String swW = "";
    private com.tencent.mm.plugin.voip_cs.b.a.b sxG;
    private c sxH;
    private boolean sxI = false;
    public String sxJ = "";
    public String sxK = "";
    public String sxL = "";
    public boolean sxM = false;
    private ak sxN = new ak(Looper.getMainLooper(), new 18(this), true);
    f.a sxO = new 2(this);
    private com.tencent.mm.plugin.voip_cs.b.a.a sxc;
    public CharSequence tickerText = ac.getContext().getString(R.l.eUP);
    public CharSequence title = ac.getContext().getString(R.l.eUJ);
    public String type = "";

    public void onCreate(Bundle bundle) {
        boolean z;
        x.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.swW = getIntent().getStringExtra("voipCSBizId");
        this.appId = getIntent().getStringExtra("voipCSAppId");
        this.fKC = bh.ou(getIntent().getStringExtra("voipCSScene"));
        this.type = bh.ou(getIntent().getStringExtra("voipCSType"));
        this.sxJ = getIntent().getStringExtra("voipCSAllowBackCamera");
        this.sxK = getIntent().getStringExtra("voipCSShowOther");
        this.jiK = getIntent().getStringExtra("voipCSAvatarUrl");
        this.sxL = getIntent().getStringExtra("voipCSContext");
        this.sxM = getIntent().getBooleanExtra("launch_from_appbrand", false);
        getWindow().addFlags(6946944);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        this.hae = new af();
        com.tencent.mm.plugin.voip_cs.b.c bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        x.d("MicroMsg.VoipCSReportHelper", "reset");
        bIU.bjS = 0;
        bIU.svX = 0;
        bIU.svY = 0;
        bIU.svZ = 0;
        bIU.videoFps = 0;
        bIU.swa = 0;
        bIU.swb = 0;
        bIU.swc = 0;
        bIU.swd = 0;
        bIU.swe = 0;
        bIU.swf = 0;
        bIU.networkType = 0;
        bIU.swg = 0;
        bIU.swh = com.tencent.mm.plugin.voip_cs.b.c.svU;
        bIU.swi = 0;
        bIU.swj = 0;
        bIU.nDy = 0;
        bIU.swk = "";
        bIU.sob = 0;
        bIU.swn = 0;
        bIU.swo = 0;
        bIU.swp = 0;
        bIU.sou = 0;
        bIU.sot = 0;
        bIU.swq = 0;
        bIU.swr = 0;
        bIU.sws = 0;
        bIU.swt = 0;
        bIU.swu = 0;
        bIU.swv = 0;
        bIU.sww = 0;
        bIU.swx = 0;
        bIU.swy = 0;
        bIU.swz = 0;
        bIU.swA = 0;
        bIU.nEV = 0;
        bIU.swB = 0;
        bIU.swC = 0;
        bIU.channelStrategy = 1;
        bIU.spG = 0;
        bIU.sov = 0;
        bIU.swD = 0;
        bIU.swE = 0;
        bIU.nFf = "";
        bIU.nFe = "";
        bIU.swI = 0;
        bIU.swJ = 0;
        bIU.swK = 0;
        bIU.swL = 0;
        bIU.swM = 0;
        this.nCb = (TelephonyManager) ac.getContext().getSystemService("phone");
        com.tencent.mm.plugin.voip_cs.b.b.bIT().swW = this.swW;
        this.sxG = new com.tencent.mm.plugin.voip_cs.b.a.b(this);
        this.sxH = new c();
        this.flu = new b(ac.getContext());
        this.sxc = com.tencent.mm.plugin.voip_cs.b.a.a.bIZ();
        com.tencent.mm.plugin.voip_cs.b.b.bIS().sxE = this;
        com.tencent.mm.plugin.voip_cs.b.b.bIT().swO = this;
        if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV == 0 || com.tencent.mm.plugin.voip_cs.b.b.bIT().swV == 3) {
            com.tencent.mm.plugin.voip_cs.b.b.bIT().swV = 0;
        }
        ar.ux().wB();
        this.flu.requestFocus();
        ar.Hh().xI();
        ar.Hh().a(this.sxO);
        this.slL = new HeadsetPlugReceiver();
        this.slL.a(ac.getContext(), this.sms);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        ac.getContext().registerReceiver(this.smr, intentFilter);
        ar.a(this.pUH);
        if (this.sxM) {
            if (this.fKC.equals("1")) {
                if (this.type.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                    this.title = ac.getContext().getString(R.l.eUH);
                    this.tickerText = ac.getContext().getString(R.l.eUL);
                    this.fyY = ac.getContext().getString(R.l.eUL);
                } else {
                    this.title = ac.getContext().getString(R.l.eUI);
                    this.tickerText = ac.getContext().getString(R.l.eUM);
                    this.fyY = ac.getContext().getString(R.l.eUM);
                }
            } else if (this.type.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                this.title = ac.getContext().getString(R.l.eUJ);
                this.tickerText = ac.getContext().getString(R.l.eUN);
                this.fyY = ac.getContext().getString(R.l.eUN);
            } else {
                this.title = ac.getContext().getString(R.l.eUI);
                this.tickerText = ac.getContext().getString(R.l.eUM);
                this.fyY = ac.getContext().getString(R.l.eUM);
            }
        } else if (this.fKC.equals("1")) {
            if (this.type.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                this.title = ac.getContext().getString(R.l.eUH);
                this.tickerText = ac.getContext().getString(R.l.eUL);
                this.fyY = ac.getContext().getString(R.l.eUL);
            } else {
                this.title = ac.getContext().getString(R.l.eUI);
                this.tickerText = ac.getContext().getString(R.l.eUP);
                this.fyY = ac.getContext().getString(R.l.eUP);
            }
        } else if (this.type.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            this.title = ac.getContext().getString(R.l.eUJ);
            this.tickerText = ac.getContext().getString(R.l.eUP);
            this.fyY = ac.getContext().getString(R.l.eUP);
        } else {
            this.title = ac.getContext().getString(R.l.eUI);
            this.tickerText = ac.getContext().getString(R.l.eUO);
            this.fyY = ac.getContext().getString(R.l.eUO);
        }
        int callState = this.nCb.getCallState();
        if (callState == 2 || callState == 1) {
            x.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[]{Integer.valueOf(callState)});
            h.a((Context) this, R.l.eUV, R.l.dGO, new 1(this));
            z = true;
        } else {
            z = false;
        }
        if (z) {
            x.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
            return;
        }
        this.nCb.listen(this.nCc, 32);
        if (!an.isNetworkConnected(this)) {
            x.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
            h.a((Context) this, R.l.eUR, R.l.eVD, new 15(this));
            z = false;
        } else if (an.isWifi(this) || l.bHl()) {
            z = true;
        } else {
            x.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
            h.a((Context) this, R.l.eUS, R.l.eVD, new OnClickListener(this) {
                final /* synthetic */ VoipCSMainUI sxP;

                {
                    this.sxP = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
                    l.bHk();
                    if (this.sxP.bJk()) {
                        this.sxP.bJj();
                    }
                }
            }, new 17(this));
            z = false;
        }
        if (z) {
            if (d.bIq()) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
                h.a((Context) this, R.l.epw, R.l.dGO, new 11(this));
                callState = 1;
            } else if (d.bIp()) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
                h.a((Context) this, R.l.epx, R.l.dGO, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI sxP;

                    {
                        this.sxP = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.sxP.yX(0);
                    }
                });
                callState = 1;
            } else if (com.tencent.mm.p.a.AW()) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
                h.a((Context) this, R.l.epr, R.l.dGO, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI sxP;

                    {
                        this.sxP = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.sxP.yX(0);
                    }
                });
                callState = 1;
            } else if (com.tencent.mm.au.a.Qk()) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
                h.a((Context) this, R.l.eps, R.l.dGO, new OnClickListener(this) {
                    final /* synthetic */ VoipCSMainUI sxP;

                    {
                        this.sxP = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.sxP.yX(0);
                    }
                });
                callState = 1;
            } else {
                z = false;
            }
            if (callState != 0) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
                return;
            } else if (bJk()) {
                bJj();
                return;
            } else {
                return;
            }
        }
        x.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
    }

    private void bJj() {
        if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV <= 0) {
            long j;
            int init;
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.sxG;
            if (bVar.sxu.cfK()) {
                j = (long) bVar.sxp;
                bVar.sxu.J(j, j);
            }
            bVar = this.sxG;
            if (bVar.sxv.cfK()) {
                j = (long) bVar.sxq;
                bVar.sxv.J(j, j);
            }
            com.tencent.mm.plugin.voip_cs.b.b.a bIS = com.tencent.mm.plugin.voip_cs.b.b.bIS();
            bIS.nEJ = false;
            bIS.nEI = false;
            if (bIS.nEG.oxo) {
                x.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
                bIS.nEG.jl(false);
                bIS.nEG.reset();
            }
            bIS.nEG.soc = 1;
            long currentTimeMillis = System.currentTimeMillis();
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = bIS.nEG;
            com_tencent_mm_plugin_voip_model_v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext());
            com_tencent_mm_plugin_voip_model_v2protocal.sob = com_tencent_mm_plugin_voip_model_v2protocal.netType;
            com.tencent.mm.plugin.voip_cs.b.b.bIU().sob = com_tencent_mm_plugin_voip_model_v2protocal.netType;
            if (com_tencent_mm_plugin_voip_model_v2protocal.netType == 5) {
                com_tencent_mm_plugin_voip_model_v2protocal.netType = 4;
            }
            boolean z = com_tencent_mm_plugin_voip_model_v2protocal.sob >= 4 && (v2protocal.saT & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 && (v2protocal.saT & 255) >= 30;
            boolean z2 = q.gFU.gEt == 1 && q.gFU.gDV.width >= 480 && q.gFU.gDV.height >= 360 && q.gFU.gDX.width >= 480 && q.gFU.gDX.height >= 360;
            boolean z3 = q.gFU.gEt == 0;
            if ((z || z2) && !z3) {
                com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth = 480;
                com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight = 360;
                v2protocal.snY = true;
                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip", "steve:Set Enable 480! " + com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth + "x" + com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight);
            }
            com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip", "steve: Android CPUFlag:" + (v2protocal.saT & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z + ", bEnable480FromSvr:" + z2 + ", bDisable480FromSvr:" + z3);
            com_tencent_mm_plugin_voip_model_v2protocal.soW = new int[(com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth * com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight)];
            ar.Hg();
            com_tencent_mm_plugin_voip_model_v2protocal.soa = com.tencent.mm.z.c.Cg();
            if ((v2protocal.saT & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                com.tencent.mm.compatible.loader.d.t(ac.getContext(), "libvoipCodec_v7a.so");
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
            } else if ((v2protocal.saT & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                com.tencent.mm.compatible.loader.d.t(ac.getContext(), "libvoipCodec.so");
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
            } else {
                com.tencent.mm.compatible.loader.d.t(ac.getContext(), "libvoipCodec_v5.so");
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
            }
            int i = VERSION.SDK_INT;
            int bID = OpenGlRender.bID();
            Display defaultDisplay = ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay();
            init = com_tencent_mm_plugin_voip_model_v2protocal.init(com_tencent_mm_plugin_voip_model_v2protocal.netType, 2, (com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth << 16) | com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight, (defaultDisplay.getWidth() << 16) | defaultDisplay.getHeight(), com_tencent_mm_plugin_voip_model_v2protocal.soa, ((i << 16) | (bID << 24)) | v2protocal.saT, e.gZJ + "app_lib/", 8);
            com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + com_tencent_mm_plugin_voip_model_v2protocal.soa);
            com_tencent_mm_plugin_voip_model_v2protocal.oxo = true;
            if (init < 0) {
                com_tencent_mm_plugin_voip_model_v2protocal.reset();
            }
            j = System.currentTimeMillis();
            x.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[]{Integer.valueOf(init), Long.valueOf(j - currentTimeMillis)});
            if (init < 0) {
                x.e("MicroMsg.VoipCSEngine", "engine init failed!");
            }
            com.tencent.mm.ae.e bIT = com.tencent.mm.plugin.voip_cs.b.b.bIT();
            String str = this.swW;
            String str2 = this.appId;
            String str3 = this.sxL;
            x.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + str + ",appid:" + str2 + ",voipCSContext:" + str3);
            bIT.swW = str;
            bIT.swV = 1;
            com.tencent.mm.plugin.voip_cs.b.c bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
            x.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
            if (bIU.swI == 0) {
                bIU.swI = (int) (System.currentTimeMillis() / 1000);
            }
            byte[] bArr = null;
            if (!(str3 == null || str3.equals(""))) {
                bArr = str3.getBytes();
            }
            ar.CG().a(823, bIT);
            com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.nDA = (int) (System.currentTimeMillis() / 1000);
            k cVar = new com.tencent.mm.plugin.voip_cs.b.c.c(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.nDA, str, com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.netType, bArr, com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.field_capInfo, str2);
            x.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.field_capInfo));
            ar.CG().a(cVar, 0);
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV < 2) {
            this.sxc.bJb();
        }
        com.tencent.mm.plugin.voip.video.f fVar = this.sxG;
        x.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
        if (fVar.oIR == null) {
            x.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
            fVar.oIR = new ObservableTextureView(fVar.sxd);
            fVar.oIR.setLayoutParams(new LayoutParams(1, 1));
            fVar.sxe.addView(fVar.oIR, new LayoutParams(1, 1));
            fVar.oIR.setVisibility(0);
        }
        if (fVar.oIP == null) {
            init = 320;
            int i2 = 240;
            com.tencent.mm.plugin.voip_cs.b.b.bIS();
            if (v2protocal.snY) {
                init = 640;
                i2 = 480;
            }
            x.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
            fVar.oIP = new com.tencent.mm.plugin.voip.video.a(init, i2);
            fVar.oIP.a(fVar, true);
            fVar.oIP.a(fVar.oIR);
            com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.sop = fVar.oIP.bIA();
            fVar.oIP.bIv();
            fVar.oIP.bIB();
            x.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[]{Boolean.valueOf(fVar.oIP.bIy()), Boolean.valueOf(fVar.oIP.bIz())});
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            ar.Hh().fz(aTR());
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            ar.Hh().fy(aTR());
            return true;
        }
    }

    private int aTR() {
        int i = 2;
        if (ar.Hh().xL()) {
            i = ar.Hh().xX();
        } else if (this.sxc.bHv()) {
            if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV != 2) {
                c cVar = this.sxH;
                if (cVar.sky != null) {
                    i = cVar.sky.bGh();
                }
            }
            i = 0;
        }
        x.d("MicroMsg.voipcs.VoipCSMainUI", "Current StreamType:%d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    protected void onResume() {
        x.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
        super.onResume();
        if (this.sxG != null) {
            this.sxG.fvI = false;
            if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV > 1) {
                bJj();
                if (this.sxK != null && this.sxK.equals("1")) {
                    this.sxG.bJg();
                }
            }
        }
        if (this.sxN != null) {
            this.sxN.TG();
        }
        ar.getNotification().cancel(44);
    }

    protected void onPause() {
        super.onPause();
        if (!this.sxc.bHv()) {
            this.sxc.stopRing();
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV == 1 || com.tencent.mm.plugin.voip_cs.b.b.bIT().swV == 2) {
            Intent intent = new Intent(ac.getContext(), VoipCSMainUI.class);
            intent.putExtra("voipCSBizId", this.swW);
            intent.putExtra("voipCSAppId", this.appId);
            intent.putExtra("voipCSScene", this.fKC);
            intent.putExtra("voipCSType", this.type);
            intent.putExtra("voipCSAllowBackCamera", this.sxJ);
            intent.putExtra("voipCSShowOther", this.sxK);
            intent.putExtra("voipCSAvatarUrl", this.jiK);
            intent.putExtra("voipCSContext", this.sxL);
            intent.putExtra("launch_from_appbrand", this.sxM);
            Notification notification = new Builder(ac.getContext()).setTicker(this.tickerText).setWhen(System.currentTimeMillis()).setContentTitle(this.title).setContentText(this.fyY).setContentIntent(PendingIntent.getActivity(ac.getContext(), 44, intent, 134217728)).setOngoing(true).getNotification();
            notification.icon = com.tencent.mm.bl.a.bXV();
            notification.flags |= 32;
            ar.getNotification().a(44, notification, false);
            if (this.sxN != null && this.sxN.cfK()) {
                this.sxN.J(5000, 5000);
            }
        } else {
            ar.getNotification().cancel(44);
            if (this.sxN != null) {
                this.sxN.TG();
            }
        }
        this.sxG.bJe();
        this.sxG.fvI = true;
    }

    protected void onRestart() {
        x.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
        super.onRestart();
        if (bJk() && com.tencent.mm.plugin.voip_cs.b.b.bIT().swV <= 1) {
            bJj();
        }
        if (this.sxG != null) {
            this.sxG.fvI = false;
        }
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        int i;
        int i2 = 2;
        x.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
        if (this.flu != null) {
            this.flu.zd();
        }
        com.tencent.mm.sdk.b.b qtVar = new qt();
        if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swX == -1) {
            qtVar.fIB.status = 3;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swX == 823) {
            qtVar.fIB.status = 4;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV <= 1) {
            qtVar.fIB.status = 1;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV >= 2) {
            qtVar.fIB.status = 2;
        }
        com.tencent.mm.sdk.b.a.xef.m(qtVar);
        c cVar = this.sxH;
        com.tencent.mm.plugin.voip_cs.b.c bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        if (cVar.sky == null || com.tencent.mm.plugin.voip_cs.b.b.bIU().swu != 1) {
            i = 0;
        } else {
            i = cVar.sky.bGh();
        }
        bIU.swE = (int) ((((float) ar.Hh().getStreamVolume(i)) / ((float) ar.Hh().getStreamMaxVolume(i))) * 100.0f);
        bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        if (cVar.oFS == null || com.tencent.mm.plugin.voip_cs.b.b.bIU().swu != 1) {
            i = 0;
        } else {
            i = cVar.oFS.vt();
        }
        bIU.sov = i;
        if (cVar.oFS != null) {
            cVar.oFS.vi();
        }
        if (cVar.sky != null) {
            cVar.sky.bGf();
        }
        this.sxc.stopRing();
        if (this.sxG != null) {
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.sxG;
            if (com.tencent.mm.plugin.voip_cs.b.b.bIU().bjS == 0) {
                if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV < 2) {
                    com.tencent.mm.plugin.voip_cs.b.b.bIU().bjS = 1;
                } else {
                    com.tencent.mm.plugin.voip_cs.b.b.bIU().bjS = 3;
                }
            }
            bVar.sqB.bIE();
            bVar.sqC.bIE();
            bVar.bJe();
            bVar.bJh();
            com.tencent.mm.plugin.voip_cs.b.d bIT = com.tencent.mm.plugin.voip_cs.b.b.bIT();
            x.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            ar.CG().b(823, bIT);
            ar.CG().b(455, bIT);
            ar.CG().b(818, bIT);
            ar.CG().b(795, bIT);
            ar.CG().b(g.CTRL_INDEX, bIT);
            ar.CG().b(312, bIT);
            bIT.swV = 3;
            if (bIT.swX != 823) {
                ar.CG().a(880, bIT);
                if (bIT.swQ == 0) {
                    i2 = 1;
                } else if (bIT.swQ != 2) {
                    i2 = bIT.swQ == 3 ? 3 : 4;
                }
                x.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + bIT.swW + ",inviteId：" + com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.nDA + ",csroomId:" + com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.sod + ",roomkey:" + com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.nDy + ",reason:" + i2);
                ar.CG().a(new com.tencent.mm.plugin.voip_cs.b.c.a(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.nDA, com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.sod, com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.nDy, bIT.swW, i2), 0);
            }
            bIT.swZ.TG();
            bIT.sxa.TG();
            bIT.swP = 0;
            bIT.swl = 0;
            bIT.swQ = 0;
            bIT.swR = 0;
            bIT.swS = null;
            bIT.nDH = 0;
            bIT.swT = 0;
            bIT.swV = 0;
            bIT.swW = "";
            bIT.swU = 0;
            bIT.swX = 0;
            bIT.swY = 999;
            com.tencent.mm.plugin.voip_cs.b.b.a bIS = com.tencent.mm.plugin.voip_cs.b.b.bIS();
            x.i("MicroMsg.VoipCSEngine", "now stop engine");
            bIS.nEG.jl(true);
            com.tencent.mm.plugin.voip_cs.b.c bIU2 = com.tencent.mm.plugin.voip_cs.b.b.bIU();
            if (bh.ov(bIU2.nFf) && bh.ov(bIU2.nFe)) {
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG;
                com_tencent_mm_plugin_voip_model_v2protocal.getVoipcsChannelInfo(com_tencent_mm_plugin_voip_model_v2protocal.spD, com_tencent_mm_plugin_voip_model_v2protocal.spD.length, bIU2.sws == 1 ? 1 : 0);
                x.d("MicroMsg.Voip", "field_voipcsEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal.field_voipcsChannelInfoLength)});
                bIU2.nFf = new String(com_tencent_mm_plugin_voip_model_v2protocal.spD, 0, com_tencent_mm_plugin_voip_model_v2protocal.field_voipcsChannelInfoLength);
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG;
                com_tencent_mm_plugin_voip_model_v2protocal2.getVoipcsEngineInfo(com_tencent_mm_plugin_voip_model_v2protocal2.spE, com_tencent_mm_plugin_voip_model_v2protocal2.spE.length);
                x.d("MicroMsg.Voip", "field_voipcsEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal2.field_voipcsEngineInfoLength)});
                String str = com_tencent_mm_plugin_voip_model_v2protocal2.nDF + "," + com_tencent_mm_plugin_voip_model_v2protocal2.nDy + "," + com_tencent_mm_plugin_voip_model_v2protocal2.sod + "," + com.tencent.mm.plugin.voip_cs.b.b.bIU().swu + "," + com_tencent_mm_plugin_voip_model_v2protocal2.sop + "," + com_tencent_mm_plugin_voip_model_v2protocal2.soq + com_tencent_mm_plugin_voip_model_v2protocal2.bHR() + new String(com_tencent_mm_plugin_voip_model_v2protocal2.spE, 0, com_tencent_mm_plugin_voip_model_v2protocal2.field_voipcsEngineInfoLength);
                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip", "voipreport:NewEngineString:" + str);
                bIU2.nFe = str;
                x.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[]{bIU2.nFf});
                x.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[]{bIU2.nFe});
            }
            ar.CG().a(312, com.tencent.mm.plugin.voip_cs.b.b.bIT());
            ar.CG().a(new com.tencent.mm.plugin.voip_cs.b.c.e(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.sod, com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.nDy), 0);
            bIS.nEG.reset();
            com.tencent.mm.plugin.voip.model.k.bHh().bHj();
            com.tencent.mm.plugin.voip.model.k.bHh().smH = null;
        }
        this.sxG = null;
        this.sxH = null;
        ar.Hh().setMode(0);
        ac.getContext().unregisterReceiver(this.smr);
        ar.Hh().b(this.sxO);
        ar.Hh().xJ();
        if (this.slL != null) {
            this.slL.dA(ac.getContext());
        }
        ar.b(this.pUH);
        if (this.sxN != null) {
            this.sxN.TG();
        }
        ar.getNotification().cancel(44);
        if (!(this.nCb == null || this.nCc == null)) {
            this.nCb.listen(this.nCc, 0);
            this.nCc = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dtK;
    }

    public final void yX(int i) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + i + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.b.b.bIT().swV);
        if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV == 0) {
            finish();
        } else if (this.sxG != null) {
            this.sxG.za(i);
        }
    }

    public final void onError(int i) {
        if (this.sxG != null) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:" + i);
            this.sxG.za(i);
        }
    }

    public final void ew(String str, String str2) {
        com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.sxG;
        if (!bVar.sxt.equals("") || !com.tencent.pb.common.c.g.isNullOrEmpty(str2)) {
            bVar.MI(str2);
        } else if (bVar.sxd.sxM) {
            bVar.kBH.setText(R.l.eUz);
        } else {
            bVar.kBH.setText(R.l.eUy);
        }
        if (bVar.sxs.equals("") && com.tencent.pb.common.c.g.isNullOrEmpty(str) && (bVar.sxd.jiK == null || bVar.sxd.jiK.equals(""))) {
            bVar.sxj.setImageResource(R.g.bBB);
            return;
        }
        SharedPreferences cft = ac.cft();
        if (!(com.tencent.pb.common.c.g.isNullOrEmpty(str) || bVar.sxs.equals(str))) {
            bVar.MJ(str);
            cft.edit().putString(bVar.bJc(), str).commit();
        }
        if (!com.tencent.pb.common.c.g.isNullOrEmpty(str2) && !bVar.sxt.equals(str2)) {
            bVar.MI(str2);
            cft.edit().putString(bVar.bJd(), str2).commit();
        }
    }

    private boolean bJk() {
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "")), bh.cgy(), this});
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "")) {
                return true;
            }
            x.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
            return false;
        }
        x.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            x.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        x.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    bJj();
                    return;
                } else {
                    h.a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.l.ezM : R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 8(this), new 9(this));
                    return;
                }
            case 82:
                if (iArr[0] == 0) {
                    x.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
                    if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "")) {
                        bJj();
                        return;
                    }
                    return;
                }
                h.a((Context) this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 6(this), new 7(this));
                return;
            default:
                return;
        }
    }

    public final void aSV() {
        int i;
        com.tencent.mm.plugin.voip_cs.b.c bIU;
        this.sxG.aSV();
        if (ar.Hh().xR() || ar.Hh().xL()) {
            this.sxH.jf(false);
        } else {
            this.sxH.jf(true);
        }
        c cVar = this.sxH;
        if (cVar.oFS != null) {
            boolean vr = cVar.oFS.vr();
            com.tencent.mm.plugin.voip_cs.b.b.bIU().swu = 1;
            if (vr) {
                i = 1;
                com.tencent.mm.plugin.voip_cs.b.b.bIU().swN = i;
                cVar = this.sxH;
                if (cVar.sky != null) {
                    com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soq = Math.abs(1);
                } else {
                    cVar.sky.bGd();
                    if (cVar.sky.bGd() <= 0) {
                        com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soq = Math.abs(1);
                    }
                }
                this.sxc.stopRing();
                bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
                if (bIU.swI != 0) {
                    bIU.swx = ((int) (System.currentTimeMillis() / 1000)) - bIU.swI;
                }
                bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
                x.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
                if (bIU.swL == 0) {
                    bIU.swL = (int) (System.currentTimeMillis() / 1000);
                }
                bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
                x.d("MicroMsg.VoipCSReportHelper", "markConnect");
                if (bIU.swK != 0) {
                    bIU.swz = (long) (((int) (System.currentTimeMillis() / 1000)) - bIU.swK);
                }
            }
        }
        i = -1;
        com.tencent.mm.plugin.voip_cs.b.b.bIU().swN = i;
        cVar = this.sxH;
        if (cVar.sky != null) {
            cVar.sky.bGd();
            if (cVar.sky.bGd() <= 0) {
                com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soq = Math.abs(1);
            }
        } else {
            com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soq = Math.abs(1);
        }
        this.sxc.stopRing();
        bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        if (bIU.swI != 0) {
            bIU.swx = ((int) (System.currentTimeMillis() / 1000)) - bIU.swI;
        }
        bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        x.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
        if (bIU.swL == 0) {
            bIU.swL = (int) (System.currentTimeMillis() / 1000);
        }
        bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        x.d("MicroMsg.VoipCSReportHelper", "markConnect");
        if (bIU.swK != 0) {
            bIU.swz = (long) (((int) (System.currentTimeMillis() / 1000)) - bIU.swK);
        }
    }

    public final void bJi() {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
        this.sxG.za(5);
    }
}
