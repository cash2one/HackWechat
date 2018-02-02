package com.tencent.mm.network;

import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.network.z.1;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class af$2 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ af ibo;
    final /* synthetic */ int ibp;
    final /* synthetic */ Object ibq;

    af$2(af afVar, int i, Object obj, int i2, int i3) {
        this.ibo = afVar;
        this.ibp = i;
        this.ibq = obj;
        this.fma = i2;
        this.fmb = i3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        int type;
        int i;
        Throwable e;
        String KM;
        z VR = aa.VR();
        int i2 = this.ibp;
        int i3 = this.fma;
        int i4 = this.fmb;
        int i5 = -1;
        synchronized (VR.iaF) {
            int iS = VR.iS(i2);
            if (-1 == iS) {
                x.e("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                return;
            }
            int KN;
            int i6;
            t VQ;
            h KJ;
            int i7 = 0;
            switch (i3) {
                case 0:
                    i7 = 0;
                    break;
                case 1:
                    i7 = 2;
                    break;
                case 2:
                    i7 = 2;
                    break;
                case 3:
                    i7 = 1;
                    break;
                case 4:
                    i7 = 1;
                    break;
                case 5:
                    i7 = 1;
                    break;
                case 6:
                    i7 = 1;
                    break;
                case 7:
                    if (-3002 != i4 && -3003 != i4) {
                        if (-10001 != i4) {
                            i7 = 5;
                            break;
                        } else {
                            i7 = 6;
                            break;
                        }
                    }
                    i7 = 4;
                    break;
                    break;
                case 8:
                    i7 = 4;
                    break;
                case 9:
                    i7 = 1;
                    break;
                default:
                    x.f("MicroMsg.MMNativeNetTaskAdapter", "c2JavaErrorType not exits c_errType:%d", new Object[]{Integer.valueOf(i3)});
                    break;
            }
            if (i7 == 0) {
                i4 = 0;
            }
            if (i7 == 3) {
                i4 = -1;
            }
            if (!aa.VM().iaX && i7 == 1) {
                x.i("MicroMsg.MMNativeNetTaskAdapter", "network not available");
                i7 = 2;
                i4 = -1;
            }
            r rVar = VR.iaF[iS].iaJ;
            l lVar = VR.iaF[iS].iaK;
            long j = VR.iaF[iS].startTime;
            VR.iaF[iS] = null;
            if (i7 == 0) {
                try {
                    if (rVar.KJ().KN() != 0) {
                        KN = rVar.KJ().KN();
                        i6 = 4;
                        type = rVar.getType();
                        try {
                            VQ = aa.VQ();
                            byte[] Ks = rVar.KJ().Ks();
                            try {
                                x.d("MicroMsg.AutoAuth", "summerauth onGYNetEnd threadId: 0" + " errType: " + i6 + " errCode: " + KN + " errMsg: " + null + " rr: " + rVar + " type: " + rVar.getType() + " netIdGetCertBeforeAutoAuth: " + VQ.hZO);
                                if (KN != 0) {
                                    VQ.hZF++;
                                } else if (rVar.getType() != 10) {
                                    VQ.hZF = 0;
                                }
                                KJ = rVar.KJ();
                                switch (rVar.getType()) {
                                    case 126:
                                    case 701:
                                    case 702:
                                        x.i("MicroMsg.AutoAuth", "summerauth end type: %d, ret:[%d,%d][%s]", new Object[]{Integer.valueOf(rVar.getType()), Integer.valueOf(i6), Integer.valueOf(KN), null});
                                        if (KJ.KN() == 0 || i6 != 0 || KN != 0) {
                                            if (rVar.getType() != 126) {
                                                switch (KN) {
                                                    case -213:
                                                    case -205:
                                                    case -100:
                                                        ac.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
                                                        if (KN == -213) {
                                                            if (KN == -100) {
                                                                if (KN == -205) {
                                                                    d.pPH.a(148, 33, 1, false);
                                                                    break;
                                                                }
                                                            }
                                                            d.pPH.a(148, 32, 1, false);
                                                            break;
                                                        }
                                                        d.pPH.a(148, 31, 1, false);
                                                        break;
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                            x.e("MicroMsg.AutoAuth", "net.end: reg err: type=" + rVar.getType() + " err=" + i6 + "," + KN + " errmsg=" + null);
                                            break;
                                        }
                                        x.i("MicroMsg.AutoAuth", "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d", new Object[]{Integer.valueOf(rVar.getType()), Integer.valueOf(rVar.KK()), Integer.valueOf(VQ.hNB)});
                                        byte[] KO;
                                        if (rVar.KK() == 2) {
                                            if (rVar.getType() == 702) {
                                                d.pPH.a(148, 34, 1, false);
                                                VQ.hNB++;
                                                if (VQ.hNB <= 1) {
                                                    i4 = KJ.Cg();
                                                    KO = KJ.KO();
                                                    if (VQ.g(bh.bw(KO) ? "" : bh.by(KO), bh.bw(Ks) ? "" : bh.by(Ks), i4)) {
                                                        VQ.hZK.hnJ = Ks;
                                                    } else {
                                                        x.w("MicroMsg.AutoAuth", "summerauth save serverid aak failed 1");
                                                    }
                                                    rVar.a(VQ.hZL, 0, 0);
                                                    break;
                                                }
                                                x.w("MicroMsg.AutoAuth", "summerauth loginDecodeFailedTry beyond 1 no more try!");
                                                VQ.d(i6, KN, "auth_decode_failed_" + bh.az(null, ""));
                                                break;
                                            }
                                        }
                                        VQ.hNB = 0;
                                        x.i("MicroMsg.AutoAuth", "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, session:%s, uin:%d", new Object[]{Integer.valueOf(rVar.getType()), rVar.KI().getUserName(), KJ.KS(), bh.VT(bh.bv(KJ.KO())), bh.VT(bh.bv(KJ.CF())), Integer.valueOf(KJ.Cg())});
                                        i7 = KJ.Cg();
                                        KO = KJ.KO();
                                        if (VQ.g(bh.bw(KO) ? "" : bh.by(KO), bh.bw(Ks) ? "" : bh.by(Ks), i7)) {
                                            VQ.hZK.hnJ = Ks;
                                            VQ.hZK.username = r5.getUserName();
                                            VQ.hZK.hZv = KJ.KS();
                                            VQ.hZK.v(KJ.CF(), KJ.Cg());
                                            VQ.hZK.hZu = KJ.Ku();
                                            o.getString(KJ.Cg());
                                        } else {
                                            d.pPH.a(148, 35, 1, false);
                                            x.w("MicroMsg.AutoAuth", "summerauth save serverid aak failed 2");
                                        }
                                        x.i("MicroMsg.AutoAuth", "summerauth decode and save ok!");
                                        break;
                                        break;
                                    case 381:
                                        if (i6 == 0 && KN == 0) {
                                            com.tencent.mm.protocal.ac.F(rVar.KJ().KP(), rVar.KJ().KQ(), rVar.KJ().KR());
                                            VQ.hZN = SystemClock.elapsedRealtime();
                                        }
                                        if (r.idt == 10003 || r.idu <= 0) {
                                            i = KN;
                                            i5 = i6;
                                        } else {
                                            if (r.idu <= 1) {
                                                r.idu = 0;
                                            }
                                            i5 = 4;
                                            i = 0;
                                            com.tencent.mm.protocal.ac.F("", "", 0);
                                        }
                                        if (VQ.hZO != -1) {
                                            if (i5 == 0 && r3 == 0) {
                                                VQ.a(rVar, 0, 0);
                                            }
                                            VQ.hZO = -1;
                                            break;
                                        }
                                        break;
                                }
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.AutoAuth", e2, "summerauth save serverid aak failed 2 cookie:" + bh.by(Ks), new Object[0]);
                                x.cfk();
                                throw e2;
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.AutoAuth", e22, "summerauth save serverid aak failed 1 cookie:" + bh.by(Ks), new Object[0]);
                                x.cfk();
                                throw e22;
                            } catch (Throwable e222) {
                                x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bh.i(e222)});
                            }
                            i = rVar.Kh();
                            i4 = KN;
                            i5 = i6;
                        } catch (RemoteException e3) {
                            e222 = e3;
                            i5 = type;
                            i4 = KN;
                            i7 = i6;
                            x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[]{bh.i(e222), Integer.valueOf(i2)});
                            i = 0;
                            type = i5;
                            i5 = i7;
                            x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", new Object[]{Integer.valueOf(type), Long.valueOf(bh.bz(j)), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i4)});
                            if (4 == i5 && (-1 == i4 || -2 == i4 || -24 == i4 || -34 == i4)) {
                                aa.VO().post(new 1(VR, type, i4));
                            }
                            try {
                                KM = rVar.KJ().KM();
                                if (KM != null || KM.length() <= 0) {
                                    lVar.a(iS, i5, i4, null, rVar, rVar.KJ().Ks());
                                } else {
                                    lVar.a(iS, i5, i4, KM, rVar, rVar.KJ().Ks());
                                    return;
                                }
                            } catch (Throwable e4) {
                                x.e("MicroMsg.MMNativeNetTaskAdapter", "onGYNetEnd cb %s", new Object[]{e4.getMessage()});
                                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[]{bh.i(e4), Integer.valueOf(i2)});
                                return;
                            }
                        }
                    }
                } catch (RemoteException e5) {
                    e222 = e5;
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[]{bh.i(e222), Integer.valueOf(i2)});
                    i = 0;
                    type = i5;
                    i5 = i7;
                    x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", new Object[]{Integer.valueOf(type), Long.valueOf(bh.bz(j)), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i4)});
                    aa.VO().post(new 1(VR, type, i4));
                    KM = rVar.KJ().KM();
                    if (KM != null) {
                    }
                    lVar.a(iS, i5, i4, null, rVar, rVar.KJ().Ks());
                }
            }
            KN = i4;
            i6 = i7;
            try {
                type = rVar.getType();
                VQ = aa.VQ();
                byte[] Ks2 = rVar.KJ().Ks();
                x.d("MicroMsg.AutoAuth", "summerauth onGYNetEnd threadId: 0" + " errType: " + i6 + " errCode: " + KN + " errMsg: " + null + " rr: " + rVar + " type: " + rVar.getType() + " netIdGetCertBeforeAutoAuth: " + VQ.hZO);
                if (KN != 0) {
                    VQ.hZF++;
                } else if (rVar.getType() != 10) {
                    VQ.hZF = 0;
                }
                KJ = rVar.KJ();
                switch (rVar.getType()) {
                    case 126:
                    case 701:
                    case 702:
                        x.i("MicroMsg.AutoAuth", "summerauth end type: %d, ret:[%d,%d][%s]", new Object[]{Integer.valueOf(rVar.getType()), Integer.valueOf(i6), Integer.valueOf(KN), null});
                        if (KJ.KN() == 0) {
                        }
                        if (rVar.getType() != 126) {
                            x.e("MicroMsg.AutoAuth", "net.end: reg err: type=" + rVar.getType() + " err=" + i6 + "," + KN + " errmsg=" + null);
                            break;
                        }
                        switch (KN) {
                            case -213:
                            case -205:
                            case -100:
                                ac.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
                                if (KN == -213) {
                                    if (KN == -100) {
                                        if (KN == -205) {
                                            d.pPH.a(148, 33, 1, false);
                                            break;
                                        }
                                    }
                                    d.pPH.a(148, 32, 1, false);
                                    break;
                                }
                                d.pPH.a(148, 31, 1, false);
                                break;
                                break;
                            default:
                                break;
                        }
                        break;
                    case 381:
                        com.tencent.mm.protocal.ac.F(rVar.KJ().KP(), rVar.KJ().KQ(), rVar.KJ().KR());
                        VQ.hZN = SystemClock.elapsedRealtime();
                        if (r.idt == 10003) {
                            break;
                        }
                        i = KN;
                        i5 = i6;
                        if (VQ.hZO != -1) {
                            VQ.a(rVar, 0, 0);
                            VQ.hZO = -1;
                            break;
                        }
                        break;
                }
                i = rVar.Kh();
                i4 = KN;
                i5 = i6;
            } catch (RemoteException e6) {
                e222 = e6;
                i4 = KN;
                i7 = i6;
                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[]{bh.i(e222), Integer.valueOf(i2)});
                i = 0;
                type = i5;
                i5 = i7;
                x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", new Object[]{Integer.valueOf(type), Long.valueOf(bh.bz(j)), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i4)});
                aa.VO().post(new 1(VR, type, i4));
                KM = rVar.KJ().KM();
                if (KM != null) {
                }
                lVar.a(iS, i5, i4, null, rVar, rVar.KJ().Ks());
            }
        }
    }
}
