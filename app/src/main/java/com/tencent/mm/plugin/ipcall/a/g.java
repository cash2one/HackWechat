package com.tencent.mm.plugin.ipcall.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAdDataReport;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.f.c;
import com.tencent.mm.plugin.ipcall.a.f.d;
import com.tencent.mm.plugin.ipcall.a.f.e;
import com.tencent.mm.plugin.ipcall.a.f.f;
import com.tencent.mm.plugin.ipcall.a.f.h;
import com.tencent.mm.plugin.ipcall.a.f.i;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;

public final class g implements a, b.a {
    public boolean fDV = false;
    public int nCB = 0;
    public int nCC = 0;
    public int nCD = 0;
    public boolean nCE = false;
    public boolean nCF = false;
    public a nCG;
    public d nCH = new d();
    i nCI = new i();
    com.tencent.mm.plugin.ipcall.a.f.a nCJ = new com.tencent.mm.plugin.ipcall.a.f.a();
    h nCK = new h();
    c nCL = new c();
    public e nCM = new e();
    com.tencent.mm.plugin.ipcall.a.f.g nCN = new com.tencent.mm.plugin.ipcall.a.f.g();
    f nCO = new f();
    public com.tencent.mm.plugin.ipcall.a.a.c nCP;
    public boolean nCQ = false;
    public boolean nCR = false;
    n nCS = new 1(this);

    public final void aTv() {
        if (this.nCP.nEc) {
            x.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
        }
        this.nCE = true;
        x.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(this.nCP.nDx), Integer.valueOf(this.nCP.nDA)});
        this.nCL.stop();
        this.nCI.stop();
        this.nCJ.a(this.nCP);
        this.nCN.a(this.nCP);
    }

    public final void rs(int i) {
        if (!this.nCP.nEc) {
            x.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
        }
        x.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(this.nCP.nDx), Integer.valueOf(this.nCP.nDA)});
        this.nCF = true;
        this.nCL.stop();
        this.nCI.stop();
        this.nCK.nGB = false;
        this.nCK.nGA = i;
        this.nCK.a(this.nCP);
        this.nCN.a(this.nCP);
    }

    private void fR(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.nCE), Boolean.valueOf(this.nCF)});
        if (this.nCE || this.nCF) {
            x.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
        } else if (z) {
            if (this.nCG != null) {
                if (this.nCP.nDM) {
                    this.nCG.aSP();
                } else {
                    this.nCG.y(this.nCP.nDE, this.nCP.lOs, this.nCP.nDD);
                }
            }
            x.i("MicroMsg.IPCallSvrLogic", "start sync");
            this.nCI.a(this.nCP);
        } else if (this.nCG == null) {
        } else {
            if (this.nCP.nDJ) {
                this.nCG.v(this.nCP.nDE, this.nCP.lOs, this.nCP.nDD);
            } else if (this.nCP.nDK) {
                this.nCG.w(this.nCP.nDE, this.nCP.lOs, this.nCP.nDD);
            } else if (this.nCP.nDL) {
                this.nCG.x(this.nCP.nDE, this.nCP.lOs, this.nCP.nDD);
            } else if (this.nCP.nDM) {
                this.nCG.u(this.nCP.nDE, this.nCP.lOs, this.nCP.nDD);
            } else {
                this.nCG.y(this.nCP.nDE, this.nCP.lOs, this.nCP.nDD);
            }
        }
    }

    private void fS(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.nCB = 0;
            return;
        }
        this.nCB++;
        if (this.nCB >= 2) {
            x.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
            this.nCL.stop();
            if (i.aTB().aTu() && this.nCG != null) {
                this.nCG.aST();
            }
        }
    }

    private void l(boolean z, int i) {
        x.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[]{Boolean.valueOf(z)});
        if (!z && i < 0 && this.nCD <= 0) {
            this.nCD++;
            x.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[]{Integer.valueOf(this.nCD)});
            this.nCJ.a(this.nCP);
        }
    }

    private void m(boolean z, int i) {
        x.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.nCK.nGB)});
        if (!z && i < 0 && this.nCC <= 0) {
            this.nCC++;
            x.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[]{Integer.valueOf(this.nCC), Boolean.valueOf(this.nCK.nGB)});
            this.nCK.a(this.nCP);
        }
    }

    private void fT(boolean z) {
        int i = 1;
        x.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z && i.aTy().nEJ) {
            i.aTy().ru(this.nCP.nDS);
        }
        if (!z) {
            x.e("MicroMsg.IPCallSvrLogic", "sync failed!");
            this.nCI.stop();
            if (i.aTB().nCz != 3) {
                i = 0;
            }
            if (i != 0 && this.nCG != null) {
                this.nCG.bu(this.nCP.lOs, this.nCP.nDD);
            }
        } else if (this.nCP != null && z) {
            rt(this.nCP.aTP());
        }
    }

    private void fU(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z && i.aTy().nEJ) {
            i.aTy().ru(this.nCP.nDS);
        }
        if (this.nCP != null && z) {
            int aTP = this.nCP.aTP();
            if (aTP == 2 || aTP == 1) {
                if (this.nCR) {
                    x.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
                    return;
                } else {
                    ar.CG().a(new o(this.nCP.nDx, this.nCP.nDy, this.nCP.aTO(), this.nCP.nDz, false), 0);
                }
            }
            rt(this.nCP.aTP());
        }
    }

    public final boolean rt(int i) {
        switch (i) {
            case 1:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                if (this.nCQ) {
                    return true;
                }
                this.nCQ = true;
                if (this.nCG == null) {
                    return true;
                }
                this.nCG.aSQ();
                return true;
            case 2:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[]{Boolean.valueOf(this.nCE), Boolean.valueOf(this.nCF)});
                if (this.nCE || this.nCF) {
                    return true;
                }
                this.nCI.stop();
                if (this.fDV) {
                    return true;
                }
                this.fDV = true;
                if (this.nCP != null) {
                    this.nCP.nEc = true;
                }
                if (this.nCG != null) {
                    this.nCG.aSR();
                }
                this.nCL.a(this.nCP);
                return true;
            case 3:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                this.nCI.stop();
                this.nCL.stop();
                if (this.nCG == null) {
                    return true;
                }
                this.nCG.bt(this.nCP.lOs, this.nCP.nDD);
                return true;
            case 4:
            case 7:
            case 8:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
                if (this.nCP.nDL) {
                    if (this.nCG == null) {
                        return true;
                    }
                    this.nCG.x(this.nCP.nDE, this.nCP.lOs, this.nCP.nDD);
                    return true;
                } else if (this.nCG == null) {
                    return true;
                } else {
                    this.nCG.bs(this.nCP.lOs, this.nCP.nDD);
                    return true;
                }
            case 5:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
                if (this.nCG == null) {
                    return true;
                }
                this.nCG.aSS();
                return true;
            case 6:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
                this.nCP.nDJ = true;
                if (this.nCG == null) {
                    return true;
                }
                this.nCG.v(this.nCP.nDE, this.nCP.lOs, this.nCP.nDD);
                return true;
            default:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[]{Integer.valueOf(i)});
                return false;
        }
    }

    private void fV(boolean z) {
        bth com_tencent_mm_protocal_c_bth = null;
        x.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            bth com_tencent_mm_protocal_c_bth2;
            com.tencent.mm.plugin.ipcall.a.c.a aTy = i.aTy();
            com.tencent.mm.plugin.ipcall.a.a.c cVar = this.nCP;
            x.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
            if (cVar == null || cVar.klN == null || cVar.klN.size() <= 0) {
                com_tencent_mm_protocal_c_bth2 = null;
            } else {
                com_tencent_mm_protocal_c_bth2 = com.tencent.mm.plugin.ipcall.b.c.X(cVar.klN);
            }
            if (!(cVar == null || cVar.nDV == null || cVar.nDV.size() <= 0)) {
                com_tencent_mm_protocal_c_bth = com.tencent.mm.plugin.ipcall.b.c.X(cVar.nDV);
            }
            aTy.nEG.a(com_tencent_mm_protocal_c_bth2, com_tencent_mm_protocal_c_bth2, com_tencent_mm_protocal_c_bth, 0, 0);
        }
    }

    public final void a(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
            return;
        }
        switch (i) {
            case 1:
                fR(true);
                return;
            case 3:
                l(true, i3);
                return;
            case 4:
                m(true, i3);
                return;
            case 6:
                fV(true);
                return;
            case 8:
                fU(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
            return;
        }
        switch (i) {
            case 1:
                fR(false);
                return;
            case 3:
                l(false, i3);
                return;
            case 4:
                m(false, i3);
                return;
            case 6:
                fV(false);
                return;
            case 8:
                fU(false);
                return;
            default:
                return;
        }
    }

    public final void a(int i, k kVar, int i2, int i3) {
        if (c(i, kVar, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
            return;
        }
        switch (i) {
            case 2:
                fT(true);
                return;
            case 5:
                fS(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, k kVar, int i2, int i3) {
        if (c(i, kVar, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
            return;
        }
        switch (i) {
            case 2:
                fT(false);
                return;
            case 5:
                fS(false);
                return;
            default:
                return;
        }
    }

    private boolean c(int i, Object obj, int i2, int i3) {
        if (this.nCP == null || obj == null) {
            x.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
            return true;
        }
        Iterator it;
        com.tencent.mm.plugin.ipcall.a.a.d dVar;
        Object obj2;
        switch (i) {
            case 1:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.i) {
                    com.tencent.mm.plugin.ipcall.a.d.i iVar = (com.tencent.mm.plugin.ipcall.a.d.i) obj;
                    bdf com_tencent_mm_protocal_c_bdf = iVar.nFG;
                    if (this.nCP.nDA == iVar.nFF.wFq) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[]{Integer.valueOf(this.nCP.nDA)});
                        com.tencent.mm.plugin.ipcall.a.c.b aTz = i.aTz();
                        if (aTz.nDA == this.nCP.nDA) {
                            x.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[]{Integer.valueOf(i3)});
                            aTz.nEY = i3;
                        }
                        if (i2 == 0 && i3 == 0) {
                            if (this.nCP != null) {
                                this.nCP.nDx = com_tencent_mm_protocal_c_bdf.wbh;
                                this.nCP.nDy = com_tencent_mm_protocal_c_bdf.wbi;
                                this.nCP.nDz = com_tencent_mm_protocal_c_bdf.wFs;
                                this.nCP.nDF = com_tencent_mm_protocal_c_bdf.wFB;
                                this.nCP.nDH = com_tencent_mm_protocal_c_bdf.wFC * 1000;
                                this.nCP.nDO = com_tencent_mm_protocal_c_bdf.nDO;
                                this.nCP.nDP = com_tencent_mm_protocal_c_bdf.nDP;
                                this.nCP.klN = com_tencent_mm_protocal_c_bdf.vJP;
                                this.nCP.nDV = com_tencent_mm_protocal_c_bdf.wFD;
                                this.nCP.nEa = com_tencent_mm_protocal_c_bdf.wFE;
                                if (com_tencent_mm_protocal_c_bdf.nDW > 0) {
                                    this.nCP.nDW = com_tencent_mm_protocal_c_bdf.nDW;
                                }
                                this.nCP.nDQ = com_tencent_mm_protocal_c_bdf.nDQ;
                                this.nCP.nDR = com_tencent_mm_protocal_c_bdf.nDR;
                                this.nCP.nDN = com_tencent_mm_protocal_c_bdf.wFG;
                                if (com_tencent_mm_protocal_c_bdf.nDT > 0) {
                                    this.nCP.nDT = com_tencent_mm_protocal_c_bdf.nDT - 1;
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.nCP.nDT + "] from Invite resp");
                                } else {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                                    this.nCP.nDT = 2;
                                }
                                this.nCP.nDU = com_tencent_mm_protocal_c_bdf.wFF;
                                x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdf.nDI)});
                                if (com_tencent_mm_protocal_c_bdf.nDI > 0) {
                                    this.nCP.nDM = false;
                                    this.nCP.nDI = com_tencent_mm_protocal_c_bdf.nDI;
                                } else {
                                    this.nCP.nDM = true;
                                    this.nCP.nDI = 0;
                                }
                                this.nCP.nDE = com_tencent_mm_protocal_c_bdf.nDE;
                                this.nCP.nDD = com_tencent_mm_protocal_c_bdf.nDD;
                                this.nCP.lOr = i3;
                                this.nCP.lOs = bh.ou(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_bdf.wJr.vLc));
                                break;
                            }
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
                        if (com_tencent_mm_protocal_c_bdf.wJr == null) {
                            this.nCP.nDE = "";
                            this.nCP.nDD = 2;
                            this.nCP.lOs = ac.getContext().getString(R.l.dNm);
                            this.nCP.lOr = i3;
                            break;
                        }
                        if (i3 == 433) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                            this.nCP.nDJ = true;
                        } else if (i3 == aq.CTRL_INDEX) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                            this.nCP.nDK = true;
                        } else if (i3 == JsApiAdDataReport.CTRL_INDEX) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                            this.nCP.nDL = true;
                        }
                        if (com_tencent_mm_protocal_c_bdf.nDI > 0) {
                            this.nCP.nDM = false;
                            this.nCP.nDI = com_tencent_mm_protocal_c_bdf.nDI;
                        } else {
                            this.nCP.nDM = true;
                            this.nCP.nDI = 0;
                        }
                        this.nCP.nDE = com_tencent_mm_protocal_c_bdf.nDE;
                        this.nCP.nDD = com_tencent_mm_protocal_c_bdf.nDD;
                        this.nCP.lOr = i3;
                        if (com_tencent_mm_protocal_c_bdf.wJr != null) {
                            this.nCP.lOs = bh.ou(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_bdf.wJr.vLc));
                            x.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdf.nDD), Integer.valueOf(i3), this.nCP.lOs});
                            break;
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[]{Integer.valueOf(this.nCP.nDA), Integer.valueOf(iVar.nFF.wFq)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
                return true;
                break;
            case 2:
                if (obj instanceof o) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    o oVar = (o) obj;
                    ayt com_tencent_mm_protocal_c_ayt = oVar.nFS;
                    if (this.nCP.nDx == oVar.nFR.wbh) {
                        if (i2 == 0 && i3 == 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayt.wbh), Integer.valueOf(com_tencent_mm_protocal_c_ayt.wFP), Integer.valueOf(com_tencent_mm_protocal_c_ayt.wFQ), Integer.valueOf(com_tencent_mm_protocal_c_ayt.wFN)});
                            if (com_tencent_mm_protocal_c_ayt.wbh == this.nCP.nDx && com_tencent_mm_protocal_c_ayt.wbi == this.nCP.nDy) {
                                if (com_tencent_mm_protocal_c_ayt.wFQ == this.nCP.nDF) {
                                    x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
                                    if (com_tencent_mm_protocal_c_ayt.wFN > this.nCP.nDG) {
                                        this.nCP.nDG = com_tencent_mm_protocal_c_ayt.wFN;
                                        if (com_tencent_mm_protocal_c_ayt.wFP != 0) {
                                            this.nCP.jir = com_tencent_mm_protocal_c_ayt.wFP;
                                        }
                                    }
                                } else {
                                    x.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
                                    it = this.nCP.nDX.iterator();
                                    Object obj3 = null;
                                    while (it.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it.next();
                                        if (dVar.nEd == com_tencent_mm_protocal_c_ayt.wFQ) {
                                            if (com_tencent_mm_protocal_c_ayt.wFN > dVar.nDG) {
                                                dVar.nDG = com_tencent_mm_protocal_c_ayt.wFN;
                                                if (com_tencent_mm_protocal_c_ayt.wFP != 0) {
                                                    dVar.gPs = com_tencent_mm_protocal_c_ayt.wFP;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj3;
                                        }
                                        obj3 = obj2;
                                    }
                                    if (obj3 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.nEd = com_tencent_mm_protocal_c_ayt.wFQ;
                                        dVar.gPs = com_tencent_mm_protocal_c_ayt.wFP;
                                        dVar.nDG = com_tencent_mm_protocal_c_ayt.wFN;
                                        this.nCP.nDX.add(dVar);
                                    }
                                }
                                if (com_tencent_mm_protocal_c_ayt.lOr == TencentLocation.ERROR_UNKNOWN || com_tencent_mm_protocal_c_ayt.lOr == 484) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
                                    this.nCP.nDL = true;
                                }
                                this.nCP.lOs = com_tencent_mm_protocal_c_ayt.lOs;
                                this.nCP.lOr = com_tencent_mm_protocal_c_ayt.lOr;
                                this.nCP.nDD = com_tencent_mm_protocal_c_ayt.nDD;
                                this.nCP.nDE = com_tencent_mm_protocal_c_ayt.nDE;
                                this.nCP.nDS = com_tencent_mm_protocal_c_ayt.nDS;
                                break;
                            }
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.nCP.nDx), Integer.valueOf(oVar.nFR.wbh)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
                return true;
            case 3:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.a) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (this.nCP.nDA != ((com.tencent.mm.plugin.ipcall.a.d.a) obj).nFo.wFq) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[]{Integer.valueOf(this.nCP.nDA), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.a) obj).nFo.wFq)});
                        return true;
                    }
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
                return true;
                break;
            case 4:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.n) {
                    if (this.nCP.nDx == ((com.tencent.mm.plugin.ipcall.a.d.n) obj).nFP.wbh) {
                        if (i2 != 0 || i3 != 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
                            break;
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                        this.nCP.jir = 5;
                        break;
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.nCP.nDx), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.n) obj).nFP.wbh)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                return true;
                break;
            case 5:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.h) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (this.nCP.nDx != ((com.tencent.mm.plugin.ipcall.a.d.h) obj).nFD.wbh) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.nCP.nDx), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.h) obj).nFD.wbh)});
                        return true;
                    }
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
                return true;
                break;
            case 6:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.k) {
                    com.tencent.mm.plugin.ipcall.a.d.k kVar = (com.tencent.mm.plugin.ipcall.a.d.k) obj;
                    ayn com_tencent_mm_protocal_c_ayn = kVar.nFK;
                    if (this.nCP.nDx == kVar.nFJ.wbh) {
                        if (i2 != 0 || i3 != 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
                            break;
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
                        this.nCP.klN = com_tencent_mm_protocal_c_ayn.vJP;
                        this.nCP.nDV = com_tencent_mm_protocal_c_ayn.wFD;
                        break;
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.nCP.nDx), Integer.valueOf(kVar.nFJ.wbh)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
                return true;
                break;
            case 8:
                if (obj instanceof ayl) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
                    ayl com_tencent_mm_protocal_c_ayl = (ayl) obj;
                    if (this.nCP.nDx == com_tencent_mm_protocal_c_ayl.wbh) {
                        if (i2 == 0 && i3 == 0) {
                            this.nCP.nDS = com_tencent_mm_protocal_c_ayl.nDS;
                            x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayl.wFH.size())});
                            it = com_tencent_mm_protocal_c_ayl.wFH.iterator();
                            while (it.hasNext()) {
                                ayu com_tencent_mm_protocal_c_ayu = (ayu) it.next();
                                if (this.nCP.nDF == com_tencent_mm_protocal_c_ayu.wFQ) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[]{Integer.valueOf(this.nCP.nDF), Integer.valueOf(com_tencent_mm_protocal_c_ayu.wEr), Integer.valueOf(com_tencent_mm_protocal_c_ayu.wFR)});
                                    if (com_tencent_mm_protocal_c_ayu.wFR > this.nCP.nDG) {
                                        this.nCP.nDG = com_tencent_mm_protocal_c_ayu.wFR;
                                        if (com_tencent_mm_protocal_c_ayu.wEr != 0) {
                                            this.nCP.jir = com_tencent_mm_protocal_c_ayu.wEr;
                                        }
                                    }
                                } else {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayu.wFQ), Integer.valueOf(com_tencent_mm_protocal_c_ayu.wEr), Integer.valueOf(com_tencent_mm_protocal_c_ayu.wFR)});
                                    Object obj4 = null;
                                    Iterator it2 = this.nCP.nDX.iterator();
                                    while (it2.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it2.next();
                                        if (dVar.nEd == com_tencent_mm_protocal_c_ayu.wFQ) {
                                            if (com_tencent_mm_protocal_c_ayu.wFR > dVar.nDG) {
                                                dVar.nDG = com_tencent_mm_protocal_c_ayu.wFR;
                                                if (com_tencent_mm_protocal_c_ayu.wEr != 0) {
                                                    dVar.gPs = com_tencent_mm_protocal_c_ayu.wEr;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj4;
                                        }
                                        obj4 = obj2;
                                    }
                                    if (obj4 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.nEd = com_tencent_mm_protocal_c_ayu.wFQ;
                                        dVar.gPs = com_tencent_mm_protocal_c_ayu.wEr;
                                        dVar.nDG = com_tencent_mm_protocal_c_ayu.wFR;
                                        this.nCP.nDX.add(dVar);
                                    }
                                }
                                if (com_tencent_mm_protocal_c_ayu.lOr == TencentLocation.ERROR_UNKNOWN || com_tencent_mm_protocal_c_ayu.lOr == 484) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
                                    this.nCP.nDL = true;
                                }
                                this.nCP.lOs = com_tencent_mm_protocal_c_ayu.lOs;
                                this.nCP.lOr = com_tencent_mm_protocal_c_ayu.lOr;
                                this.nCP.nDD = com_tencent_mm_protocal_c_ayu.nDD;
                                this.nCP.nDE = com_tencent_mm_protocal_c_ayu.nDE;
                            }
                            break;
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.nCP.nDx), Integer.valueOf(com_tencent_mm_protocal_c_ayl.wbh)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
                return true;
                break;
        }
        return false;
    }
}
