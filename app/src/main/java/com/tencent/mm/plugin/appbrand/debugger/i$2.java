package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.debugger.k.3;
import com.tencent.mm.plugin.appbrand.debugger.p.6;
import com.tencent.mm.plugin.appbrand.j.j.a;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvt;
import com.tencent.mm.protocal.c.bvu;
import com.tencent.mm.protocal.c.bvx;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.protocal.c.bwd;
import com.tencent.mm.protocal.c.bwe;
import com.tencent.mm.protocal.c.bwf;
import com.tencent.mm.protocal.c.bwh;
import com.tencent.mm.protocal.c.bwk;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Timer;

class i$2 implements a {
    final /* synthetic */ i iQE;

    i$2(i iVar) {
        this.iQE = iVar;
    }

    public final void a(h hVar) {
        x.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        this.iQE.iQx.iQd = System.currentTimeMillis();
        this.iQE.iQx.iQp = 0;
        if (!bh.ov(this.iQE.iQx.aci())) {
            i.a(this.iQE);
        }
        k kVar = this.iQE.iQB;
        kVar.act();
        kVar.bnp = new Timer();
        kVar.bnp.schedule(new 3(kVar), 100, 1000);
    }

    public final void re(String str) {
        x.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[]{str});
        this.iQE.iQC.rk(str);
    }

    public final void rf(String str) {
        this.iQE.iQx.iQd = System.currentTimeMillis();
    }

    public final void e(ByteBuffer byteBuffer) {
        this.iQE.iQx.iQd = System.currentTimeMillis();
        try {
            bvm com_tencent_mm_protocal_c_bvm = (bvm) new bvm().aF(c.j(byteBuffer));
            if (com_tencent_mm_protocal_c_bvm.vZC == null) {
                x.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
                return;
            }
            byte[] bArr = com_tencent_mm_protocal_c_bvm.vZC.oz;
            k kVar;
            switch (com_tencent_mm_protocal_c_bvm.pK) {
                case 1001:
                    o.a(this.iQE.iQx, com_tencent_mm_protocal_c_bvm.pK, ((bwd) new bwd().aF(bArr)).wXl, this.iQE.iQC, this.iQE.iQB);
                    this.iQE.iQx.iQd = System.currentTimeMillis();
                    break;
                case 1002:
                    bwh com_tencent_mm_protocal_c_bwh = (bwh) new bwh().aF(bArr);
                    i iVar = this.iQE;
                    if (o.a(iVar.iQx, 1002, com_tencent_mm_protocal_c_bwh.wXl, iVar.iQC, iVar.iQB)) {
                        x.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
                        if (com_tencent_mm_protocal_c_bwh.wXu != null) {
                            if (!com_tencent_mm_protocal_c_bwh.wXu.wXd) {
                                x.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
                                iVar.iQx.eQ(2);
                                com.tencent.mm.bq.a com_tencent_mm_protocal_c_bwe = new bwe();
                                com_tencent_mm_protocal_c_bwe.wXj = iVar.iQx.iPU;
                                com_tencent_mm_protocal_c_bwe.wXe = iVar.iQx.iPZ.iQs;
                                com_tencent_mm_protocal_c_bwe.username = "";
                                com_tencent_mm_protocal_c_bwe.wXt = iVar.iQx.iPZ.iQt;
                                iVar.iQA.a(o.a(1003, com_tencent_mm_protocal_c_bwe));
                                break;
                            }
                            iVar.iQx.iPY = com_tencent_mm_protocal_c_bwh.wXu;
                            iVar.onReady();
                            break;
                        }
                        x.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
                        break;
                    }
                    break;
                case 1003:
                    if (o.a(this.iQE.iQx, com_tencent_mm_protocal_c_bvm.pK, ((bwf) new bwf().aF(bArr)).wXl, this.iQE.iQC, this.iQE.iQB)) {
                        i iVar2 = this.iQE;
                        WxaPkgWrappingInfo ZP = v.ZP();
                        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bwb = new bwb();
                        bvo com_tencent_mm_protocal_c_bvo = new bvo();
                        com_tencent_mm_protocal_c_bwb.wXp = com_tencent_mm_protocal_c_bvo;
                        com_tencent_mm_protocal_c_bwb.wXq = iVar2.iqB.acw();
                        com_tencent_mm_protocal_c_bwb.wXs = iVar2.iqB.irP.iqx.iOI.fqR;
                        String pE = v.pE("WAService.js");
                        if (!bh.ov(pE)) {
                            com_tencent_mm_protocal_c_bwb.wXr = g.s(pE.getBytes());
                        }
                        com_tencent_mm_protocal_c_bvo.wWT = ZP.iGL;
                        com_tencent_mm_protocal_c_bvo.wWQ = d.vAt;
                        com_tencent_mm_protocal_c_bvo.wWP = d.vAx;
                        com_tencent_mm_protocal_c_bvo.wWS = f.ag(iVar2.iQz, d.vAz);
                        com_tencent_mm_protocal_c_bvo.wWR = d.vAw;
                        com_tencent_mm_protocal_c_bvo.wWV = iVar2.iQz.getResources().getDisplayMetrics().density;
                        com_tencent_mm_protocal_c_bvo.wWU = ((float) iVar2.iQz.getResources().getDisplayMetrics().widthPixels) / com_tencent_mm_protocal_c_bvo.wWV;
                        bvx com_tencent_mm_protocal_c_bvx = new bvx();
                        k kVar2 = iVar2.iQB;
                        com_tencent_mm_protocal_c_bvx.wWK = "WeixinJSCore";
                        kVar2.iQx.iQj.clear();
                        for (Method method : kVar2.irQ.getClass().getMethods()) {
                            if (method.isAnnotationPresent(JavascriptInterface.class)) {
                                Class[] parameterTypes = method.getParameterTypes();
                                if (parameterTypes.length > 5) {
                                    x.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
                                } else {
                                    bvu com_tencent_mm_protocal_c_bvu = new bvu();
                                    com_tencent_mm_protocal_c_bvu.wWL = method.getName();
                                    for (Class cls : parameterTypes) {
                                        if (cls == String.class) {
                                            com_tencent_mm_protocal_c_bvu.wWM.add("String");
                                        } else if (cls == Integer.TYPE || cls == Integer.class) {
                                            com_tencent_mm_protocal_c_bvu.wWM.add("Number");
                                        } else if (cls == Boolean.TYPE || cls == Boolean.class) {
                                            com_tencent_mm_protocal_c_bvu.wWM.add("Boolean");
                                        } else {
                                            com_tencent_mm_protocal_c_bvu.wWM.add("Unknown");
                                        }
                                    }
                                    com_tencent_mm_protocal_c_bvx.wXc.add(com_tencent_mm_protocal_c_bvu);
                                    kVar2.iQx.iQj.put(com_tencent_mm_protocal_c_bvu.wWL, com_tencent_mm_protocal_c_bvu);
                                    kVar2.iQx.iQi.put(method.getName(), method);
                                }
                            }
                        }
                        com_tencent_mm_protocal_c_bwb.wXo = com_tencent_mm_protocal_c_bvx;
                        iVar2.iQB.a(o.a(com_tencent_mm_protocal_c_bwb, iVar2.iQx, "setupContext"));
                        x.d("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d", new Object[]{com_tencent_mm_protocal_c_bwb.wXr, com_tencent_mm_protocal_c_bwb.wXs, Integer.valueOf(com_tencent_mm_protocal_c_bvo.wWT)});
                        break;
                    }
                    break;
                case 1004:
                    k kVar3 = this.iQE.iQB;
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                    kVar3.iQx.eQ(4);
                    n nVar = kVar3.iQA;
                    String str = "quit";
                    if (nVar.iQY == null) {
                        x.w("MicroMsg.RemoteDebugSocket", "client is null");
                    } else {
                        nVar.iQY.P(1000, str);
                        x.d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", new Object[]{Integer.valueOf(1000), str});
                    }
                    p pVar = kVar3.iQC;
                    pVar.acB();
                    ag.y(new 6(pVar));
                    break;
                case 1005:
                    bwk com_tencent_mm_protocal_c_bwk = (bwk) new bwk().aF(bArr);
                    kVar = this.iQE.iQB;
                    x.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                    if (o.a(kVar.iQx, 1005, com_tencent_mm_protocal_c_bwk.wXl, kVar.iQC, kVar)) {
                        kVar.q(com_tencent_mm_protocal_c_bwk.wWZ);
                        kVar.iQx.jS(com_tencent_mm_protocal_c_bwk.wXx);
                        kVar.acs();
                        break;
                    }
                    break;
                case 1006:
                    bwa com_tencent_mm_protocal_c_bwa = (bwa) new bwa().aF(bArr);
                    kVar = this.iQE.iQB;
                    if (o.a(kVar.iQx, 1006, com_tencent_mm_protocal_c_bwa.wXl, kVar.iQC, kVar)) {
                        x.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bwa.wXm), Integer.valueOf(com_tencent_mm_protocal_c_bwa.wXn)});
                        kVar.iQx.bA(com_tencent_mm_protocal_c_bwa.wXm, com_tencent_mm_protocal_c_bwa.wXn);
                        kVar.bC(com_tencent_mm_protocal_c_bwa.wXm, com_tencent_mm_protocal_c_bwa.wXn);
                    }
                    l.a(com_tencent_mm_protocal_c_bvm, (f) this.iQE.iQx.iQm.get(com_tencent_mm_protocal_c_bvm.ned));
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                    this.iQE.iQB.q(((bvt) new bvt().aF(bArr)).wWZ);
                    break;
                case 3001:
                    this.iQE.onReady();
                    break;
                case 3002:
                    this.iQE.iQx.eQ(4);
                    this.iQE.iQB.quit();
                    break;
            }
            x.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bvm.pK)});
        } catch (Throwable th) {
            x.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[]{Log.getStackTraceString(th)});
        }
    }

    public final void C(int i, String str) {
        int i2 = 1;
        x.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[]{Integer.valueOf(i), str});
        g gVar = this.iQE.iQx;
        if (gVar.acm() || ((long) gVar.iQp) >= 10) {
            i2 = 0;
        }
        if (i2 != 0) {
            com.tencent.mm.plugin.appbrand.q.c.Dm().g(new Runnable(this) {
                final /* synthetic */ i$2 iQF;

                {
                    this.iQF = r1;
                }

                public final void run() {
                    this.iQF.iQE.connect();
                }
            }, 1000);
            g gVar2 = this.iQE.iQx;
            gVar2.iQp++;
        }
        this.iQE.iQB.act();
        this.iQE.iQx.iQd = System.currentTimeMillis();
        this.iQE.iQC.acB();
        this.iQE.iQx.eQ(5);
        this.iQE.iQC.rk(str);
    }

    public final void rg(String str) {
        x.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[]{str});
    }
}
