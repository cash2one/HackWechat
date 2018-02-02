package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.ipcall.ui.j.1;
import com.tencent.mm.plugin.ipcall.ui.j.5;
import com.tencent.mm.plugin.ipcall.ui.j.6;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

@a(3)
public class IPCallTalkUI extends MMActivity implements j.a {
    private String nJA;
    private String nJB;
    private String nJC;
    private int nJD;
    private int nJE;
    private String nJz;
    private j nNo;
    private String nlp;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getWindow().addFlags(6946944);
        this.nlp = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.nJz = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.nJA = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.nJB = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.nJC = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.nJD = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        this.nJE = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
        x.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[]{this.nlp, this.nJz, this.nJA, this.nJB, this.nJC, Integer.valueOf(this.nJD), Integer.valueOf(this.nJE)});
        x.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bh.cgy()});
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            init();
        }
    }

    private void init() {
        this.nNo = new j(this);
        this.nNo.nNZ = this;
        j jVar = this.nNo;
        String str = this.nlp;
        String str2 = this.nJz;
        String str3 = this.nJA;
        String str4 = this.nJB;
        String str5 = this.nJC;
        int i = this.nJD;
        int i2 = this.nJE;
        jVar.nOf = jVar.nNX.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
        x.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(jVar.nOf)});
        jVar.nNN = (ImageView) jVar.nNX.findViewById(R.h.cQl);
        jVar.ihQ = (ImageView) jVar.nNX.findViewById(R.h.cQk);
        jVar.nNL = (EditText) jVar.nNX.findViewById(R.h.cQp);
        jVar.ihV = (TextView) jVar.nNX.findViewById(R.h.cQs);
        jVar.nNM = (TextView) jVar.nNX.findViewById(R.h.cQq);
        jVar.nNO = (IPCallFuncButton) jVar.nNX.findViewById(R.h.cQo);
        jVar.nNP = (IPCallFuncButton) jVar.nNX.findViewById(R.h.cQm);
        jVar.nNQ = (IPCallFuncButton) jVar.nNX.findViewById(R.h.cQr);
        jVar.nNR = (ImageButton) jVar.nNX.findViewById(R.h.cQn);
        jVar.nNU = (ImageButton) jVar.nNX.findViewById(R.h.crg);
        jVar.nNS = (TextView) jVar.nNX.findViewById(R.h.cXE);
        jVar.nNT = jVar.nNX.findViewById(R.h.cXF);
        jVar.nHd = (DialPad) jVar.nNX.findViewById(R.h.cbT);
        String str6;
        if (jVar.nOf) {
            jVar.nlp = i.aTx().nCP.fpL;
            jVar.nNW = i.aTx().nCP.nDZ;
            jVar.nJC = i.aTx().nCP.fGJ;
            jVar.nJA = i.aTx().nCP.fIy;
            jVar.nJz = i.aTx().nCP.nDY;
            jVar.nNV = i.aTx().nCP.nEb;
            x.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[]{jVar.nlp, jVar.nNW, jVar.nJC, jVar.nJA, jVar.nJz, Integer.valueOf(jVar.nNV)});
            jVar.aUG();
            jVar.aUH();
            i.aTB();
            x.i("MicroMsg.TalkUIController", f.stateToString(i.aTB().nCz));
            jVar.rG(i.aTB().nCz);
            str6 = i.aTx().nCP.nDZ;
            str = i.aTx().nCP.nEa;
            if (!bh.ov(str)) {
                jVar.CY(str);
                jVar.nNM.setText(com.tencent.mm.plugin.ipcall.b.a.Di(str));
            } else if (!bh.ov(str6)) {
                jVar.CY(str6);
                jVar.nNM.setText(com.tencent.mm.plugin.ipcall.b.a.Di(str6));
            }
            if (i.aTB().aTs()) {
                IPCallFuncButton iPCallFuncButton = jVar.nNQ;
                i.aTA();
                iPCallFuncButton.setChecked(com.tencent.mm.plugin.ipcall.a.b.a.xQ());
                jVar.nNO.setChecked(i.aTA().nEl.kTc);
            }
        } else if (i.aTB().aTr()) {
            h.a(jVar.nNX, R.l.epx, R.l.dGO, false, new 1(jVar));
        } else {
            jVar.aUG();
            jVar.nlp = str;
            jVar.nJz = str2;
            jVar.nJA = str3;
            jVar.nJB = str4;
            jVar.nJD = i;
            jVar.nJE = i2;
            if (!bh.ov(jVar.nJz)) {
                jVar.nJz = c.Dm(jVar.nJz);
            }
            if (bh.ov(jVar.nJB)) {
                if (com.tencent.mm.plugin.ipcall.b.a.Dg(jVar.nJz)) {
                    str6 = com.tencent.mm.plugin.ipcall.b.a.De(jVar.nJz);
                    if (bh.ov(str6)) {
                        jVar.nJz = com.tencent.mm.plugin.ipcall.b.a.Dh(jVar.nJz);
                    } else {
                        jVar.nJz = com.tencent.mm.plugin.ipcall.b.a.Dj(jVar.nJz);
                        jVar.nJB = str6;
                    }
                }
                jVar.nJB = c.aUO();
            }
            x.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[]{jVar.nJB});
            com.tencent.mm.plugin.ipcall.a.c aTj = com.tencent.mm.plugin.ipcall.a.c.aTj();
            str = jVar.nJB;
            if (!aTj.isInit) {
                aTj.fP(false);
            }
            if (!bh.ov(str)) {
                i.aTF().x(bh.getInt(str.replace("+", ""), 0), bh.Wp());
                aTj.aTl();
            }
            if (bh.ov(jVar.nlp)) {
                jVar.nlp = com.tencent.mm.plugin.ipcall.b.a.al(jVar.nNX, jVar.nJz);
            }
            jVar.nJC = str5;
            if (bh.ov(jVar.nJB) || com.tencent.mm.plugin.ipcall.b.a.Dg(jVar.nJz)) {
                jVar.nNW = jVar.nJz;
            } else {
                jVar.nNW = jVar.nJB + jVar.nJz;
                if (!jVar.nNW.startsWith("+")) {
                    jVar.nNW = "+" + jVar.nNW;
                }
            }
            x.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[]{jVar.nNW});
            if (com.tencent.mm.plugin.ipcall.a.c.aTj().rq(bh.getInt(jVar.nJB, -1))) {
                g.pQN.k(12058, jVar.nJB);
                h.a(jVar.nNX, jVar.nNX.getString(R.l.dNk), jVar.nNX.getString(R.l.dNl), false, new 6(jVar));
            } else if (an.isNetworkConnected(jVar.nNX)) {
                long j = jVar.nNX.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1);
                if (j <= System.currentTimeMillis() || j == -1) {
                    jVar.aUH();
                    if (!(jVar.nOf && i.aTB().aTr())) {
                        b aTz;
                        jVar.nNV = com.tencent.mm.plugin.ipcall.b.a.cZ(jVar.nJA, jVar.nJz);
                        jVar.rG(1);
                        com.tencent.mm.plugin.ipcall.c cVar = jVar.nNY;
                        str = jVar.nlp;
                        str2 = jVar.nJz;
                        str3 = jVar.nJC;
                        str4 = jVar.nNW;
                        str5 = jVar.nJA;
                        i = jVar.nNV;
                        i2 = jVar.nJD;
                        int i3 = jVar.nJE;
                        if (i.aTB().aTr()) {
                            x.i("MicroMsg.IPCallManager", "startIPCall, already start!");
                        } else {
                            x.i("MicroMsg.IPCallManager", "startIPCall");
                            i.aTx().nCG = cVar;
                            i.aTy().nEL = cVar;
                            i.aTB().nCz = -1;
                            cVar.aBM();
                            cVar.nCb = (TelephonyManager) ac.getContext().getSystemService("phone");
                            cVar.nCb.listen(cVar.nCc, 32);
                            com.tencent.mm.sdk.b.a.xef.b(cVar.nCd);
                            x.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[]{str4, str5});
                            k kVar = new k();
                            kVar.field_phonenumber = str4;
                            if (bh.ov(str5)) {
                                kVar.field_addressId = -1;
                            } else {
                                com.tencent.mm.plugin.ipcall.a.g.c CD = i.aTD().CD(str5);
                                if (CD == null || CD.xjy == -1) {
                                    kVar.field_addressId = -1;
                                } else {
                                    kVar.field_addressId = CD.xjy;
                                }
                            }
                            if (i != -1) {
                                kVar.field_phoneType = i;
                            } else {
                                kVar.field_phoneType = -1;
                            }
                            kVar.field_calltime = bh.Wp();
                            kVar.field_status = 1;
                            if (!i.aTE().b(kVar)) {
                                kVar = null;
                            }
                            cVar.nBZ = kVar;
                            com.tencent.mm.plugin.ipcall.c.hae.postDelayed(cVar.nCf, 1754);
                            cVar.nCa = false;
                            aTz = i.aTz();
                            x.d("MicroMsg.IPCallReportHelper", "reset");
                            aTz.nEN = 0;
                            aTz.nEO = 0;
                            aTz.nEP = 0;
                            aTz.nEQ = 0;
                            aTz.nER = 0;
                            aTz.nES = 0;
                            aTz.nET = 0;
                            aTz.nEU = 0;
                            aTz.nEV = 0;
                            aTz.nEW = 0;
                            aTz.nDx = 0;
                            aTz.nDy = 0;
                            aTz.nEX = 0;
                            aTz.ikY = "";
                            aTz.nEY = 0;
                            aTz.nEZ = "";
                            aTz.nFb = 0;
                            aTz.nFa = 0;
                            aTz.nCi = 0;
                            aTz.nFc = 0;
                            aTz.nFd = 0;
                            aTz.nFi = 0;
                            aTz.nFh = 0;
                            aTz.nFe = "";
                            aTz.nFf = "";
                            aTz.countryCode = "";
                            aTz.nFj = 0;
                            aTz.nFk = 0;
                            aTz.nFl = 0;
                            aTz.nFm = 0;
                            aTz.nFn = 0;
                            i.aTB().nCz = -1;
                            x.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[]{str3, str4});
                            com.tencent.mm.plugin.ipcall.a.g aTx = i.aTx();
                            x.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[]{str3, str4});
                            aTx.fDV = false;
                            aTx.nCQ = false;
                            aTx.nCB = 0;
                            aTx.nCC = 0;
                            aTx.nCD = 0;
                            aTx.nCE = false;
                            aTx.nCF = false;
                            aTx.nCR = false;
                            aTx.nCP = new com.tencent.mm.plugin.ipcall.a.a.c();
                            aTx.nCP.fpL = str;
                            aTx.nCP.nDY = str2;
                            aTx.nCP.fIy = str5;
                            aTx.nCP.nDZ = str4;
                            aTx.nCP.fGJ = str3;
                            aTx.nCP.nDA = (int) System.currentTimeMillis();
                            aTx.nCP.nDB = i2;
                            aTx.nCP.nDC = i3;
                            aTx.nCP.nEb = i;
                            aTx.nCH.a(aTx.nCP);
                            aTx.nCM.a(aTx.nCP);
                            x.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[]{Integer.valueOf(aTx.nCP.nDA)});
                            i.aTB().rr(1);
                            com.tencent.mm.plugin.ipcall.a.c.a aTy = i.aTy();
                            if (aTy.nEK) {
                                x.d("MicroMsg.IPCallEngineManager", "already start engine");
                            } else {
                                aTy.aTU();
                                x.i("MicroMsg.IPCallEngineManager", "start engine");
                                if (aTy.nEG.oxo) {
                                    aTy.nEG.jl(false);
                                    aTy.nEG.reset();
                                }
                                aTy.nEG.soc = 1;
                                long currentTimeMillis = System.currentTimeMillis();
                                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = aTy.nEG;
                                com_tencent_mm_plugin_voip_model_v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext());
                                if (com_tencent_mm_plugin_voip_model_v2protocal.netType == 5) {
                                    com_tencent_mm_plugin_voip_model_v2protocal.netType = 4;
                                }
                                com_tencent_mm_plugin_voip_model_v2protocal.soW = new int[(com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth * com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight)];
                                ar.Hg();
                                com_tencent_mm_plugin_voip_model_v2protocal.soa = com.tencent.mm.z.c.Cg();
                                i = m.yp();
                                if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                                    d.t(ac.getContext(), "libvoipCodec_v7a.so");
                                    com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
                                } else if ((i & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                                    d.t(ac.getContext(), "libvoipCodec.so");
                                    com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
                                } else {
                                    d.t(ac.getContext(), "libvoipCodec_v5.so");
                                    com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
                                }
                                i2 = VERSION.SDK_INT;
                                i3 = OpenGlRender.bID();
                                Display defaultDisplay = ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay();
                                int width = defaultDisplay.getWidth();
                                int init = com_tencent_mm_plugin_voip_model_v2protocal.init(com_tencent_mm_plugin_voip_model_v2protocal.netType, 65538, (com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth << 16) | com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight, (width << 16) | defaultDisplay.getHeight(), com_tencent_mm_plugin_voip_model_v2protocal.soa, i | ((i2 << 16) | (i3 << 24)), e.gZJ + "app_lib/", 4);
                                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + com_tencent_mm_plugin_voip_model_v2protocal.soa);
                                com_tencent_mm_plugin_voip_model_v2protocal.oxo = true;
                                if (init < 0) {
                                    com_tencent_mm_plugin_voip_model_v2protocal.reset();
                                }
                                j = System.currentTimeMillis();
                                x.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[]{Integer.valueOf(init), Long.valueOf(j - currentTimeMillis)});
                                if (aTy.nEG.field_capInfo != null && aTy.nEG.exchangeCabInfo(aTy.nEG.field_capInfo, aTy.nEG.field_capInfo.length) < 0) {
                                    x.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
                                    i.aTz().nEW = 24;
                                }
                                if (init < 0) {
                                    x.e("MicroMsg.IPCallEngineManager", "engine init failed!");
                                }
                                aTy.nEG.soc = 1;
                                aTy.nEK = true;
                            }
                            com.tencent.mm.plugin.ipcall.c.hae.removeCallbacks(cVar.nCe);
                            com.tencent.mm.plugin.ipcall.c.hae.postDelayed(cVar.nCe, 60000);
                        }
                        x.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[]{jVar.nNW});
                        aTz = i.aTz();
                        str = jVar.nJB;
                        x.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[]{str});
                        if (!bh.ov(str)) {
                            aTz.countryCode = str;
                        }
                    }
                    jVar.nOh = false;
                    return;
                }
                x.i("MicroMsg.TalkUIController", "onDisasterHappen");
                h.a(jVar.nNX, jVar.nNX.getString(R.l.eqC, new Object[]{String.valueOf(((j - r6) / 1000) + 1)}), jVar.nNX.getString(R.l.eqx), jVar.nNX.getString(R.l.eqy), false, new 5(jVar));
            } else {
                Toast.makeText(jVar.nNX, R.l.eVz, 1).show();
                jVar.nNX.finish();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        setScreenEnable(true);
        if (this.nNo != null) {
            j jVar = this.nNo;
            x.i("MicroMsg.TalkUIController", "onDestroy");
            jVar.nNY.nBY = null;
            i.aTA().fmM = null;
            i.aTA().nEq = null;
            i.aTA().a(null);
            com.tencent.mm.plugin.ipcall.a.b.b aTA = i.aTA();
            aTA.nEm.nED = null;
            com.tencent.mm.plugin.ipcall.a.b.d dVar = aTA.nEm;
            dVar.kCP.cgf();
            dVar.kCT.cgg();
            jVar.nNX = null;
            jVar.nNZ = null;
        }
    }

    protected final int getLayoutId() {
        return R.i.dmd;
    }

    public final void gh(boolean z) {
        if (z) {
            ag.h(new Runnable(this) {
                final /* synthetic */ IPCallTalkUI nNp;

                {
                    this.nNp = r1;
                }

                public final void run() {
                    this.nNp.setResult(-1, new Intent());
                    this.nNp.finish();
                }
            }, 3000);
        }
    }

    public void onBackPressed() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.nNo != null) {
            boolean z;
            if (i.aTB().aTs()) {
                int aTR;
                if (i == 25) {
                    aTR = i.aTA().aTR();
                    if (aTR != -1) {
                        ar.Hh().fz(aTR);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                } else if (i == 24) {
                    aTR = i.aTA().aTR();
                    if (aTR != -1) {
                        ar.Hh().fy(aTR);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        x.d("MicroMsg.IPCallTalkUI", "onPause");
        super.onPause();
        if (this.nNo != null) {
            x.d("MicroMsg.TalkUIController", "onPause");
        }
    }

    protected void onResume() {
        x.d("MicroMsg.IPCallTalkUI", "onResume");
        super.onResume();
        if (this.nNo != null) {
            x.d("MicroMsg.TalkUIController", "onResume");
            ar.getNotification().cancel(42);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallTalkUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    h.a(this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
