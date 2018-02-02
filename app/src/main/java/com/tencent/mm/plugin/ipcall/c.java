package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.so;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.ipcall.a.c.a.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g$a;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.plugin.voip.video.h.7;
import com.tencent.mm.plugin.voip.video.h.8;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;

public final class c implements a, g$a, k.a {
    public static af hae = new af(Looper.getMainLooper());
    private ak fhK;
    public Object mpv = new Object();
    public e nBY;
    public com.tencent.mm.plugin.ipcall.a.g.k nBZ;
    public boolean nCa = false;
    public TelephonyManager nCb;
    public PhoneStateListener nCc = new 1(this);
    public com.tencent.mm.sdk.b.c nCd = new com.tencent.mm.sdk.b.c<so>(this) {
        final /* synthetic */ c nCj;

        {
            this.nCj = r2;
            this.xen = so.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            so soVar = (so) bVar;
            if (soVar instanceof so) {
                soVar.fKm.fKn = false;
                soVar.fKm.fKo = false;
                soVar.fKm.fKp = true;
                soVar.fKm.talker = "";
            }
            return false;
        }
    };
    public Runnable nCe = new 3(this);
    public Runnable nCf = new Runnable(this) {
        final /* synthetic */ c nCj;

        {
            this.nCj = r1;
        }

        public final void run() {
            int i = 0;
            boolean z = true;
            h aTH = i.aTH();
            int i2 = R.k.dyR;
            aTH.suF = 0;
            if (i2 == 0) {
                aTH.jq(true);
            } else if (3500 != -1) {
                try {
                    ar.Hg();
                    z = ((Boolean) com.tencent.mm.z.c.CU().get(73218, Boolean.valueOf(true))).booleanValue();
                    x.i("MicroMsg.RingPlayer", "startPlayCustomRingWithCustomInterval, voipSound: %s, msgSound: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(com.tencent.mm.k.a.zr())});
                    z = com.tencent.mm.k.a.zr();
                } catch (Exception e) {
                    x.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                }
                if (z && !aTH.fdc) {
                    try {
                        aTH.suG = System.currentTimeMillis();
                        aTH.suE = new j();
                        boolean xL = ar.Hh().xL();
                        z = ar.Hh().xR();
                        x.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(xL), Boolean.valueOf(z)});
                        if (q.gFV.gDm >= 0) {
                            i = q.gFV.gDm;
                        }
                        aTH.jp(false);
                        aTH.a(i2, 3500, true, i);
                        aTH.fdc = true;
                    } catch (Exception e2) {
                        x.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e2.toString());
                    }
                }
            } else {
                aTH.l(i2, 2, true);
            }
        }
    };
    public boolean nCg;
    public com.tencent.mm.plugin.voip.ui.a nCh = new 5(this);
    private long nCi = 0;

    public final void aBM() {
        if (this.nCb != null) {
            this.nCb.listen(this.nCc, 0);
            this.nCb = null;
        }
        com.tencent.mm.sdk.b.a.xef.c(this.nCd);
    }

    private boolean M(int i, int i2, int i3) {
        com.tencent.mm.plugin.ipcall.a.a.c cVar = i.aTx().nCP;
        if (i.aTB().rr(i)) {
            int i4;
            com.tencent.mm.plugin.ipcall.a.b.a aVar;
            boolean zr;
            if (cVar != null) {
                x.i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", new Object[]{Integer.valueOf(cVar.nDA), Integer.valueOf(cVar.nDx), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            x.i("MicroMsg.IPCallManager", "closeDeviceEngine");
            k.bHh().bHj();
            k.bHh().smH = null;
            com.tencent.mm.plugin.ipcall.a.c.b aTz = i.aTz();
            com.tencent.mm.plugin.ipcall.a.b.b aTA = i.aTA();
            if (aTA.nEl != null) {
                com.tencent.mm.plugin.ipcall.a.b.c cVar2 = aTA.nEl;
                i4 = cVar2.nEu != null ? cVar2.nEu.fkp : 0;
            } else {
                i4 = 0;
            }
            if (aTz.nFk == 0) {
                aTz.nFk = i4;
            }
            aTz = i.aTz();
            aTA = i.aTA();
            if (aTA.nEk != null) {
                aVar = aTA.nEk;
                if (aVar.nEe != null) {
                    x.d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + aVar.nEe.bGg());
                    i4 = aVar.nEe.bGg();
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 0;
            }
            if (aTz.nFl == 0) {
                aTz.nFl = i4;
            }
            com.tencent.mm.plugin.ipcall.a.b.b aTA2 = i.aTA();
            com.tencent.mm.plugin.ipcall.a.c.a aTy = i.aTy();
            i4 = 0;
            if (aTA2.nEk != null) {
                aVar = aTA2.nEk;
                i4 = (aVar.nEe == null || !aVar.fAs) ? -1 : aVar.nEe.bGh();
            }
            aTy.nEG.soC = i4 == -1 ? 0 : (int) ((((float) ar.Hh().getStreamVolume(i4)) / ((float) ar.Hh().getStreamMaxVolume(i4))) * 100.0f);
            aTA2.hXN.zd();
            aVar = aTA2.nEk;
            if (aVar.fAs) {
                x.i("MicroMsg.IPCallAudioPlayer", "stopPlay");
                synchronized (aVar.nEf) {
                    e.post(new com.tencent.mm.plugin.ipcall.a.b.a.a(aVar, aVar.nEe), "IPCallAudioPlayer_stop");
                    aVar.fAs = false;
                    aVar.nEe = null;
                }
            }
            aTA2.fmM = null;
            aTA2.nEn.dA(ac.getContext());
            ar.Hh().xJ();
            ar.Hh().b(aTA2);
            aTA2.nEq = null;
            aTA2.nEo = null;
            aTA = i.aTA();
            com.tencent.mm.plugin.ipcall.a.b.c cVar3 = aTA.nEl;
            if (cVar3.fAs) {
                x.i("MicroMsg.IPCallRecorder", "stop record");
                synchronized (cVar3.nEv) {
                    if (cVar3.nEu != null) {
                        e.post(new com.tencent.mm.plugin.ipcall.a.b.c.a(cVar3, cVar3.nEu), "IPCallRecorder_stopRecord");
                        cVar3.nEu = null;
                        cVar3.fAs = false;
                        cVar3.kTc = false;
                    }
                }
            }
            aTA.fmM = null;
            com.tencent.mm.plugin.ipcall.a.c.a aTy2 = i.aTy();
            x.i("MicroMsg.IPCallEngineManager", "close engine");
            aTy2.nEG.jl(true);
            com.tencent.mm.plugin.ipcall.a.c.b aTz2 = i.aTz();
            if (bh.ov(aTz2.nFf) && bh.ov(aTz2.nFe)) {
                com.tencent.mm.plugin.ipcall.a.a.c cVar4 = i.aTx().nCP;
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = i.aTy().nEG;
                Object obj = aTz2.nEU == 1 ? 1 : null;
                com_tencent_mm_plugin_voip_model_v2protocal.getPstnChannelInfo(com_tencent_mm_plugin_voip_model_v2protocal.spB, com_tencent_mm_plugin_voip_model_v2protocal.spB.length, obj != null ? 1 : 0, cVar4.nDT);
                x.d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal.field_pstnChannelInfoLength)});
                aTz2.nFf = new String(com_tencent_mm_plugin_voip_model_v2protocal.spB, 0, com_tencent_mm_plugin_voip_model_v2protocal.field_pstnChannelInfoLength);
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = i.aTy().nEG;
                com_tencent_mm_plugin_voip_model_v2protocal2.getPstnEngineInfo(com_tencent_mm_plugin_voip_model_v2protocal2.spC, com_tencent_mm_plugin_voip_model_v2protocal2.spC.length);
                x.d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal2.field_pstnEngineInfoLength)});
                aTz2.nFe = new String(com_tencent_mm_plugin_voip_model_v2protocal2.spC, 0, com_tencent_mm_plugin_voip_model_v2protocal2.field_pstnEngineInfoLength);
                com_tencent_mm_plugin_voip_model_v2protocal2 = i.aTy().nEG;
                aTz2.nFg = v2protocal.bHP() + "," + com_tencent_mm_plugin_voip_model_v2protocal2.soD + "," + (v2protocal.saT & 255) + com_tencent_mm_plugin_voip_model_v2protocal2.bHU() + "," + com_tencent_mm_plugin_voip_model_v2protocal2.soC;
                x.d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", new Object[]{aTz2.nFf});
                x.d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", new Object[]{aTz2.nFe});
                x.d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", new Object[]{aTz2.nFg});
            }
            aTy2.nEG.reset();
            aTy2.aTU();
            i.aTH().stop();
            h aTH = i.aTH();
            int i5 = R.k.dAl;
            i.aTA();
            boolean isSpeakerphoneOn = ar.Hh().gCe.isSpeakerphoneOn();
            aTH.mContext.getSharedPreferences(ac.cfs(), 0).getBoolean("settings_shake", true);
            ar.Hh().setSpeakerphoneOn(isSpeakerphoneOn);
            if (isSpeakerphoneOn) {
                ar.Hh().setMode(0);
            } else {
                ar.Hh().setMode(2);
            }
            try {
                zr = com.tencent.mm.k.a.zr();
                x.i("MicroMsg.RingPlayer", "playSound, voipSound: %s, msgSound: %s", new Object[]{Boolean.valueOf(true), Boolean.valueOf(zr)});
            } catch (Exception e) {
                x.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                zr = true;
            }
            if (zr) {
                aTH.suH = System.currentTimeMillis();
                MediaPlayer jVar = new j();
                try {
                    jVar.setDataSource(aTH.mContext, Uri.parse("android.resource://" + aTH.mContext.getPackageName() + "/" + i5));
                    jVar.setOnCompletionListener(new 7(aTH));
                    jVar.setOnErrorListener(new 8(aTH));
                    if (ar.Hh().xL() || !isSpeakerphoneOn) {
                        i4 = 0;
                    } else {
                        i4 = 2;
                    }
                    jVar.setAudioStreamType(i4);
                    jVar.prepare();
                    jVar.setLooping(false);
                    jVar.start();
                    if (System.currentTimeMillis() - aTH.suH > 2000) {
                        aTH.suF = 7;
                    }
                } catch (Throwable th) {
                    x.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[]{th});
                    aTH.suF = 6;
                    jVar.stop();
                    jVar.release();
                }
            }
            hae.removeCallbacks(this.nCf);
            hae.removeCallbacks(this.nCe);
            if (this.fhK != null) {
                this.fhK.TG();
                this.fhK = null;
            }
            i.aTz().nEW = i3;
            com.tencent.mm.plugin.ipcall.a.c.b aTz3 = i.aTz();
            x.d("MicroMsg.IPCallReportHelper", "markEndTalk");
            if (aTz3.nFd == 0 && aTz3.nFc != 0) {
                aTz3.nFd = System.currentTimeMillis();
                aTz3.nEV = (aTz3.nFd - aTz3.nFc) / 1000;
                x.d("MicroMsg.IPCallReportHelper", "callTime: %d", new Object[]{Long.valueOf(aTz3.nEV)});
            }
            com.tencent.mm.plugin.ipcall.a.g.k kVar;
            if (i == 8) {
                i.aTx().aTv();
                i.aTz().aTW();
                kVar = this.nBZ;
                if (kVar != null) {
                    x.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[]{Long.valueOf(kVar.xjy)});
                    if (kVar.xjy != -1) {
                        kVar.field_status = 2;
                        i.aTE().a(kVar);
                    }
                }
            } else if (i == 12) {
                i.aTx().aTv();
                i.aTz().aTW();
                if (i2 == 11) {
                    m.b(this.nBZ);
                } else {
                    kVar = this.nBZ;
                    if (kVar != null) {
                        x.d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", new Object[]{Long.valueOf(kVar.xjy)});
                        if (kVar.xjy != -1) {
                            kVar.field_status = 6;
                            i.aTE().a(kVar);
                        }
                    }
                }
            } else if (i == 9) {
                i.aTx().rs(1);
                i.aTz().aTV();
                m.a(this.nBZ, i.aTz().nEV);
            } else if (i == 10) {
                i.aTx().rs(1);
                aTz3 = i.aTz();
                x.i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
                aTz3.nEP = 1;
                kVar = this.nBZ;
                long j = i.aTz().nEV;
                if (kVar != null) {
                    x.d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", new Object[]{Long.valueOf(kVar.xjy), Long.valueOf(j)});
                    if (kVar.xjy != -1) {
                        kVar.field_status = 5;
                        kVar.field_duration = j;
                        i.aTE().a(kVar);
                    }
                }
            } else if (i == 11) {
                if (i2 == 5) {
                    i.aTx().rs(3);
                } else if (i2 == 11) {
                    i.aTx().rs(1);
                } else {
                    i.aTx().rs(2);
                }
                i.aTz().aTV();
                if (i2 == 11) {
                    m.b(this.nBZ);
                } else {
                    m.a(this.nBZ, i.aTz().nEV);
                }
            }
            if (i.aTx().fDV) {
                if (this.nCg || i.aTx().nCP.nDx == 0 || i.aTx().nCP.nDz == 0) {
                    x.e("MicroMsg.IPCallManager", "roomId = 0,ignore feedback");
                } else {
                    Context context = ac.getContext();
                    i5 = i.aTx().nCP.nDx;
                    long j2 = i.aTx().nCP.nDz;
                    x.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
                    if (d.aTd()) {
                        int i6 = g.zY().getInt("WCOMaxTimesForShowFeedback", 0);
                        ar.Hg();
                        int intValue = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xpG, Integer.valueOf(0))).intValue();
                        ar.Hg();
                        long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xpF, Long.valueOf(0))).longValue();
                        long Wo = bh.Wo();
                        if (Wo - longValue > 86400) {
                            i4 = 0;
                            x.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
                        } else {
                            i4 = intValue;
                        }
                        if (i4 >= i6) {
                            x.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time" + i6);
                        } else if (Wo - longValue < 1800) {
                            x.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
                        } else {
                            i4++;
                            ar.Hg();
                            com.tencent.mm.z.c.CU().a(w.a.xpG, Integer.valueOf(i4));
                            ar.Hg();
                            com.tencent.mm.z.c.CU().a(w.a.xpF, Long.valueOf(Wo));
                            Intent intent = new Intent();
                            intent.putExtra("IPCallFeedbackDialogUI_KRoomId", i5);
                            intent.putExtra("IPCallFeedbackDialogUI_KCallseq", j2);
                            d.b(context, "ipcall", ".ui.IPCallFeedbackDialogUI", intent);
                        }
                    }
                }
            }
            i.aTx().nCG = null;
            i.aTy().nEL = null;
            i.aTB().nCz = -1;
            aSZ();
            aBM();
            return true;
        }
        x.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (cVar != null) {
            x.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", new Object[]{Integer.valueOf(cVar.nDA), Integer.valueOf(cVar.nDx), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        return false;
    }

    public static boolean Cz(String str) {
        x.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[]{str});
        if (!i.aTB().aTu()) {
            x.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
            return false;
        } else if (bh.ov(str) || str.length() != 1) {
            return false;
        } else {
            int i;
            com.tencent.mm.plugin.ipcall.a.c.a aTy;
            com.tencent.mm.plugin.ipcall.a.c.b aTz;
            if (!bh.ov(str) && str.length() == 1) {
                char charAt = str.charAt(0);
                if (charAt < '0' || charAt > '9') {
                    if (charAt == '*') {
                        i = 10;
                    } else if (charAt == '#') {
                        i = 11;
                    } else if (charAt >= 'A' && charAt <= 'D') {
                        i = (charAt - 65) + 12;
                    }
                    if (i != -1) {
                        return false;
                    }
                    aTy = i.aTy();
                    x.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
                    aTz = i.aTz();
                    aTz.nFn++;
                    x.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aTz.nFn)});
                    if (aTy.nEG.SendDTMF(i) < 0) {
                        x.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aTy.nEG.SendDTMF(i))});
                    }
                    return true;
                }
                i = charAt - 48;
                if (i != -1) {
                    return false;
                }
                aTy = i.aTy();
                x.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
                aTz = i.aTz();
                aTz.nFn++;
                x.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aTz.nFn)});
                if (aTy.nEG.SendDTMF(i) < 0) {
                    x.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aTy.nEG.SendDTMF(i))});
                }
                return true;
            }
            i = -1;
            if (i != -1) {
                return false;
            }
            aTy = i.aTy();
            x.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
            aTz = i.aTz();
            aTz.nFn++;
            x.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aTz.nFn)});
            if (aTy.nEG.SendDTMF(i) < 0) {
                x.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aTy.nEG.SendDTMF(i))});
            }
            return true;
        }
    }

    public final void aSP() {
        x.i("MicroMsg.IPCallManager", "onInviteSuccess");
        if (i.aTB().rr(3)) {
            com.tencent.mm.plugin.ipcall.a.c.b aTz = i.aTz();
            x.d("MicroMsg.IPCallReportHelper", "markStartInvite");
            if (aTz.nFa == 0) {
                aTz.nFa = System.currentTimeMillis();
            }
            com.tencent.mm.plugin.ipcall.a.a.c cVar = i.aTx().nCP;
            com.tencent.mm.plugin.ipcall.a.c.b aTz2 = i.aTz();
            int i = cVar.nDA;
            String str = cVar.fGJ;
            String str2 = cVar.nDZ;
            int i2 = cVar.nDx;
            long j = cVar.nDy;
            long j2 = cVar.nDz;
            aTz2.nDA = i;
            aTz2.nEZ = str;
            aTz2.ikY = str2;
            aTz2.nDx = i2;
            aTz2.nDy = j;
            aTz2.nEX = j2;
            if (this.nBY != null) {
                this.nBY.aSP();
            }
        }
    }

    public final void u(String str, String str2, int i) {
        x.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (cI(2, 0)) {
            d(2, str, str2, i);
        }
    }

    public final void aSQ() {
        x.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (i.aTB().rr(4)) {
            com.tencent.mm.plugin.ipcall.a.c.b aTz = i.aTz();
            x.d("MicroMsg.IPCallReportHelper", "markStartRing");
            if (aTz.nFb == 0) {
                aTz.nFb = System.currentTimeMillis();
                aTz.nES = aTz.nFb - aTz.nFa;
                x.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[]{Long.valueOf(aTz.nES)});
            }
            i.aTy().aTT();
            aTz = i.aTz();
            x.i("MicroMsg.IPCallReportHelper", "startRing");
            aTz.nEN = 1;
            if (this.nBY != null) {
                this.nBY.aSQ();
            }
        }
    }

    public final void aSR() {
        x.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (i.aTB().rr(5)) {
            com.tencent.mm.plugin.ipcall.a.c.b aTz = i.aTz();
            x.d("MicroMsg.IPCallReportHelper", "markUserAccept");
            if (aTz.nCi == 0) {
                aTz.nCi = System.currentTimeMillis();
                aTz.nET = aTz.nCi - aTz.nFa;
                x.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[]{Long.valueOf(aTz.nET)});
            }
            i.aTy().aTT();
            aTz = i.aTz();
            x.i("MicroMsg.IPCallReportHelper", "userAccept");
            aTz.nEO = 1;
            hae.removeCallbacks(this.nCe);
            i.aTH().stop();
            hae.removeCallbacks(this.nCf);
            i.aTA().aTQ();
            if (i.aTy().nEJ && !this.nCa) {
                i.aTz().aTX();
                i.aTz().aUa();
                this.nCa = true;
                this.nCi = bh.Wo();
                aTb();
                i.aTy().aTS();
                if (this.nBY != null) {
                    this.nBY.aTe();
                }
                i.aTz().aTZ();
                k.bHh().bHi();
                k.bHh().smH = this;
            }
        }
    }

    public final void d(int i, String str, String str2, int i2) {
        if (this.nBY != null) {
            this.nBY.d(i, str, str2, i2);
        } else {
            Toast.makeText(ac.getContext(), str2, 1).show();
        }
    }

    public final void bs(String str, int i) {
        x.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (cI(3, 5)) {
            d(3, null, str, i);
        }
    }

    public final void bt(String str, int i) {
        x.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (cI(1, 4)) {
            d(1, null, str, i);
        }
    }

    public final void aSS() {
        x.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (!M(10, 0, 32)) {
            return;
        }
        if (this.nBY != null) {
            this.nBY.aTf();
        } else {
            Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ert), 1).show();
        }
    }

    public final void bu(String str, int i) {
        x.i("MicroMsg.IPCallManager", "onSyncFailed");
        if (cI(7, 35)) {
            d(7, null, str, i);
        }
    }

    public final void aST() {
        x.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
        if (cI(7, 29)) {
            d(7, null, ac.getContext().getString(R.l.dNj), 1);
        }
    }

    public final void v(String str, String str2, int i) {
        x.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (cI(8, 9)) {
            d(8, str, str2, i);
        }
    }

    public final void w(String str, String str2, int i) {
        x.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (cI(10, 0)) {
            d(10, str, str2, i);
        }
    }

    public final void x(String str, String str2, int i) {
        x.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (cI(11, 0)) {
            d(11, str, str2, i);
        }
    }

    public final void y(String str, String str2, int i) {
        do {
            x.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        } while (cI(12, 0));
    }

    public final void aSU() {
        x.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (cI(6, 0)) {
            d(6, null, ac.getContext().getString(R.l.dNm), 1);
        }
    }

    public final void aSV() {
        x.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        i.aTH().stop();
        hae.removeCallbacks(this.nCf);
        if (i.aTB().aTs()) {
            com.tencent.mm.plugin.ipcall.a.b.b aTA = i.aTA();
            aTA.nEn.a(ac.getContext(), aTA);
            ar.Hh().a(aTA);
            ar.Hh().xI();
            aTA.nEs = ar.Hh().xR();
            aTA.nEr = ar.Hh().xL();
            x.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[]{Boolean.valueOf(aTA.nEs), Boolean.valueOf(aTA.nEr)});
            aTA.hXN.requestFocus();
            com.tencent.mm.plugin.ipcall.a.b.a aVar = aTA.nEk;
            if (aVar.fAs) {
                x.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
            } else {
                x.i("MicroMsg.IPCallAudioPlayer", "startPlay");
                if (aVar.nEe == null) {
                    aVar.nEe = new com.tencent.mm.plugin.voip.model.b();
                    aVar.nEe.Y(v2protocal.oFK, 20, 1);
                }
                aVar.nEg = aVar.nEe.l(ac.getContext(), false);
                aVar.nEe.siT = new a$1(aVar);
                if (aVar.nEe.bGd() <= 0) {
                    i.aTz().aTY();
                }
                aVar.fW(aVar.nEh);
                aVar.fAs = true;
            }
            if (!(!aTA.nEs || aTA.nEr || aTA.nEq == null)) {
                aTA.nEq.fZ(true);
            }
            if (!(!aTA.nEr || aTA.nEs || aTA.nEq == null)) {
                aTA.nEq.ga(true);
            }
        }
        i.aTz().aTX();
        i.aTA().aTQ();
        if (i.aTB().aTu() && !this.nCa) {
            i.aTz().aUa();
            i.aTy().aTS();
            this.nCa = true;
            this.nCi = bh.Wo();
            aTb();
            if (this.nBY != null) {
                this.nBY.aTe();
            }
            com.tencent.mm.plugin.ipcall.a.g.k kVar = this.nBZ;
            if (kVar != null) {
                x.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[]{Long.valueOf(kVar.xjy)});
                if (kVar.xjy != -1) {
                    kVar.field_status = 3;
                    i.aTE().a(kVar);
                }
            }
            i.aTz().aTZ();
            k.bHh().bHi();
            k.bHh().smH = this;
        }
    }

    public final void rp(int i) {
        x.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[]{f.stateToString(i.aTB().nCz)});
        if (i.aTy().nEJ) {
            x.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
            if (cI(5, i)) {
                d(5, null, ac.getContext().getString(R.l.dNj), 1);
                return;
            }
            return;
        }
        x.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
        if (cI(4, i)) {
            d(4, null, ac.getContext().getString(R.l.dNj), 1);
        }
    }

    public final boolean cI(int i, int i2) {
        if (i.aTB().aTu()) {
            if (i == 0) {
                return M(9, i, i2);
            }
            return M(11, i, i2);
        } else if (i == 0) {
            return M(8, i, i2);
        } else {
            return M(12, i, i2);
        }
    }

    public final void aSW() {
        if (i.aTB().nCz != 5) {
            x.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[]{Integer.valueOf(i.aTB().nCz)});
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b aTA = i.aTA();
        x.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
        if (aTA.nEo != null) {
            com.tencent.mm.plugin.ipcall.ui.j jVar = aTA.nEo;
            if (jVar.nNS != null) {
                jVar.nNS.setVisibility(0);
            }
            if (jVar.nNT != null) {
                jVar.nNT.setVisibility(0);
            }
        }
        if (!ar.Hh().gCe.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - aTA.nEt > 30000) {
                aTA.nEt = currentTimeMillis;
                com.tencent.mm.plugin.voip.model.d.bGj().yI(R.k.dBA);
            }
        }
    }

    public final void aSX() {
        if (i.aTB().nCz != 5) {
            x.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[]{Integer.valueOf(i.aTB().nCz)});
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b aTA = i.aTA();
        x.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
        if (aTA.nEo != null) {
            aTA.nEo.aUI();
        }
    }

    public final void aSY() {
        int i;
        CharSequence string;
        if (i.aTB().aTu()) {
            Context context = ac.getContext();
            i = R.l.eqQ;
            Object[] objArr = new Object[1];
            objArr[0] = String.format("%02d:%02d", new Object[]{Long.valueOf(bh.by(this.nCi) / 60), Long.valueOf(bh.by(this.nCi) % 60)});
            string = context.getString(i, objArr);
        } else {
            string = ac.getContext().getString(R.l.eqP);
        }
        Intent intent = new Intent(ac.getContext(), IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        PendingIntent activity = PendingIntent.getActivity(ac.getContext(), 42, intent, 134217728);
        i = R.g.bEq;
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            i = R.g.bEp;
        }
        Notification notification = new Builder(ac.getContext()).setTicker(ac.getContext().getString(R.l.eqP)).setWhen(System.currentTimeMillis()).setContentTitle(ac.getContext().getString(R.l.eqI)).setContentText(string).setContentIntent(activity).getNotification();
        notification.icon = i;
        notification.flags |= 32;
        ar.getNotification().a(42, notification, false);
        if (i.aTB().aTu()) {
            com.tencent.mm.plugin.voip.model.d.bGk().wZ(aTa());
        } else {
            com.tencent.mm.plugin.voip.model.d.bGk().ME(ac.getContext().getString(R.l.ewL));
        }
    }

    public final void aSZ() {
        synchronized (this.mpv) {
            this.nCg = false;
            com.tencent.mm.plugin.voip.model.d.bGk().dismiss();
            ((NotificationManager) ac.getContext().getSystemService("notification")).cancel(42);
        }
    }

    public final int aTa() {
        int by = (int) bh.by(this.nCi);
        return by > 0 ? by : 0;
    }

    private void aTb() {
        x.i("MicroMsg.IPCallManager", "startTimeCount");
        if (this.fhK != null) {
            this.fhK.TG();
            return;
        }
        if (this.fhK == null) {
            this.fhK = new ak(Looper.getMainLooper(), new 6(this), true);
        }
        this.fhK.J(1000, 1000);
    }
}
