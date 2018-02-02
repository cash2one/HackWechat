package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiManager;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.buc;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.bve;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class e$3 extends af {
    final /* synthetic */ e skv;

    e$3(e eVar, Looper looper) {
        this.skv = eVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message == null || message.what != 59998) {
            super.handleMessage(message);
        } else if (message.arg1 == 1) {
            if (this.skv.ske.nDx == 0) {
                a.es("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
                return;
            }
            a.et("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
            r0 = (byte[]) message.obj;
            o oVar = this.skv.skh;
            r2 = message.arg2;
            but com_tencent_mm_protocal_c_but = new but();
            com_tencent_mm_protocal_c_but.ktN = 1;
            bdn com_tencent_mm_protocal_c_bdn = new bdn();
            com_tencent_mm_protocal_c_bdn.bj(r0);
            com_tencent_mm_protocal_c_but.vKf = com_tencent_mm_protocal_c_bdn;
            bdn com_tencent_mm_protocal_c_bdn2 = new bdn();
            try {
                com_tencent_mm_protocal_c_bdn2.bj(com_tencent_mm_protocal_c_but.toByteArray());
                buc com_tencent_mm_protocal_c_buc = new buc();
                com_tencent_mm_protocal_c_buc.vXp = r2;
                com_tencent_mm_protocal_c_buc.vXq = com_tencent_mm_protocal_c_bdn2;
                com_tencent_mm_protocal_c_buc.nkp = q.FS();
                bud com_tencent_mm_protocal_c_bud = new bud();
                com_tencent_mm_protocal_c_bud.ksO = 1;
                com_tencent_mm_protocal_c_bud.ksP.add(com_tencent_mm_protocal_c_buc);
                oVar.a(com_tencent_mm_protocal_c_bud, true, 2);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
            }
        } else if (message.arg1 == 4) {
            if (this.skv.ske.nDx == 0) {
                a.es("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
                return;
            }
            a.et("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
            this.skv.ske.spH.skR = 107;
            this.skv.p(1, -9004, "");
        } else if (message.arg1 == 6) {
            a.et("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
            if (this.skv.ske.nDx == 0) {
                a.et("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
                return;
            }
            this.skv.sjC = true;
            this.skv.ske.spH.slh = 1;
            if (this.skv.fDV || this.skv.sjD) {
                this.skv.ske.soG = 0;
            } else {
                this.skv.ske.soG = 1;
            }
            this.skv.ske.setInactive();
            a.et("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            this.skv.bGu();
        } else if (message.arg1 == 3) {
            this.skv.mStatus = 5;
        } else if (message.arg1 == 5) {
            a.et("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + message.arg2);
            if (this.skv.mStatus >= 5) {
                this.skv.ske.spH.skR = 108;
            } else {
                this.skv.ske.spH.skR = 106;
            }
            if (message.arg2 == 4) {
                this.skv.ske.spH.slj = 1;
                a.et("MicroMsg.Voip.VoipContext", "channel broken...");
            } else if (message.arg2 == 1) {
                if (this.skv.sjG) {
                    a.et("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                    this.skv.sjF = true;
                    return;
                }
                a.et("MicroMsg.Voip.VoipContext", "channel connect fail...");
                this.skv.sjC = false;
                this.skv.ske.spH.slj = 5;
            } else if (message.arg2 == 5) {
                if (this.skv.sjF) {
                    this.skv.ske.spH.slj = 6;
                    a.et("MicroMsg.Voip.VoipContext", "channel network fail while pre-connect...");
                    this.skv.sjF = true;
                    return;
                }
                a.et("MicroMsg.Voip.VoipContext", "channel network fail");
                this.skv.ske.spH.slj = 6;
            }
            this.skv.p(1, -9000, "");
        } else if (message.arg1 == 100) {
            a.b((byte[]) message.obj, "MicroMsg.Voip.VoipContext", message.arg2);
        } else if (message.arg1 == 101) {
            a.b((byte[]) message.obj, "MicroMsg.v2Core", message.arg2);
        } else if (message.arg1 == 7) {
            int[] iArr = (int[]) message.obj;
            int i = message.arg2;
            String str = null;
            try {
                str = ((WifiManager) ac.getContext().getSystemService("wifi")).getConnectionInfo().getSSID();
            } catch (Exception e2) {
                a.et("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
            }
            String str2 = null;
            try {
                str2 = ((TelephonyManager) ac.getContext().getSystemService("phone")).getSimOperatorName();
            } catch (Exception e3) {
                a.et("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
            new j(this.skv.sjL, this.skv.sjK, this.skv.sjM, str2, str, this.skv.sjN, i, iArr).bHM();
        } else if (message.arg1 == 8) {
            r0 = (byte[]) message.obj;
            e eVar = this.skv;
            try {
                brt com_tencent_mm_protocal_c_brt = (brt) new brt().aF(r0);
                a.et("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + com_tencent_mm_protocal_c_brt.wTq);
                switch (com_tencent_mm_protocal_c_brt.wTq) {
                    case 3:
                        if (com_tencent_mm_protocal_c_brt.wTr != null) {
                            Object obj = com_tencent_mm_protocal_c_brt.wTr.oz;
                            a.et("MicroMsg.Voip.VoipContext", "steve: remote new network type:" + obj);
                            r2 = eVar.ske.setAppCmd(HardCoderJNI.SCENE_QUIT_CHATTING, obj, 4);
                            if (r2 < 0) {
                                a.et("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + r2 + ", [roomid=" + eVar.ske.nDF + ", roomkey=" + eVar.ske.nDy + "]");
                                return;
                            }
                            return;
                        }
                        a.et("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                        return;
                    case 4:
                        if (com_tencent_mm_protocal_c_brt.wTr != null) {
                            btk com_tencent_mm_protocal_c_btk = (btk) new btk().aF(com_tencent_mm_protocal_c_brt.wTr.oz);
                            a.et("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + com_tencent_mm_protocal_c_btk.wUR);
                            byte[] bArr = new byte[4];
                            bArr[0] = (byte) com_tencent_mm_protocal_c_btk.wUR;
                            eVar.ske.setJNIAppCmd(2, bArr, 4);
                            return;
                        }
                        a.et("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
                        return;
                    default:
                        return;
                }
            } catch (Exception e4) {
                a.et("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
            }
            a.et("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
        } else if (message.arg1 == 9) {
            h hVar = this.skv.ske.spH;
            if (0 == hVar.slv) {
                hVar.slv = System.currentTimeMillis();
                a.et("MicroMsg.VoipDailReport", "first pkt received timestamp:" + hVar.slv);
            }
            a.et("MicroMsg.Voip.VoipContext", "get first pkt for voip");
            if (1 == this.skv.ske.spm) {
                bve com_tencent_mm_protocal_c_bve = new bve();
                com_tencent_mm_protocal_c_bve.ktm = 1;
                this.skv.skh.a(com_tencent_mm_protocal_c_bve, 2);
            }
        } else if (message.arg1 == 11) {
            this.skv.skp = 2;
        } else if (message.arg1 == 12) {
            this.skv.skp = 1;
        } else if (message.arg1 == 13) {
            r7 = (int[]) message.obj;
            new h(this.skv.ske.nDx, this.skv.ske.nDy, this.skv.ske.nDF, 1, message.arg2, r7).bHM();
        } else if (message.arg1 == 14) {
            r7 = (int[]) message.obj;
            new h(this.skv.ske.nDx, this.skv.ske.nDy, this.skv.ske.nDF, 2, message.arg2, r7).bHM();
        }
    }
}
