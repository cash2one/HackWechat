package com.tencent.mm.sandbox.updater;

import com.tencent.mm.c.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sandbox.b$a;
import com.tencent.mm.sandbox.updater.f.2;
import com.tencent.mm.sandbox.updater.f.3;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class j$2 implements b$a {
    final /* synthetic */ j xdK;

    j$2(j jVar) {
        this.xdK = jVar;
    }

    public final void cj(int i, int i2) {
        x.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.xdK.ruR != 2) {
            j.a(this.xdK, i2, i);
        }
        this.xdK.cj(i, i2);
    }

    public final void a(int i, int i2, bdf com_tencent_mm_protocal_c_bdf) {
        this.xdK.xdE = false;
        this.xdK.xdG.stop();
        this.xdK.xdF = System.currentTimeMillis();
        if (this.xdK.xdt == null) {
            this.xdK.ac(2, true);
        } else if (i == 200 && i2 == 0) {
            x.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
            if (this.xdK.ruR != 2) {
                j.a(this.xdK, 100, 100);
            }
            if (this.xdK.xdz) {
                i.ae(this.xdK.mContext, 0);
            } else {
                i.ae(this.xdK.mContext, 9);
            }
            this.xdK.xdw = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "yyb_pkg_sig_prefs", 4).getString(ac.getPackageName(), "");
            x.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[]{this.xdK.xdw, this.xdK.xdt.ceg()});
            if (bh.ov(this.xdK.xdw)) {
                g.pQN.a(322, 8, 1, false);
                g.pQN.h(11098, new Object[]{Integer.valueOf(4008)});
            } else {
                try {
                    c.b(new File(this.xdK.xdt.ceg()), this.xdK.xdw);
                    x.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
                    g.pQN.a(322, 6, 1, false);
                    g.pQN.h(11098, new Object[]{Integer.valueOf(4006), this.xdK.xdw});
                } catch (Exception e) {
                    x.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + e.getMessage());
                    g.pQN.a(322, 7, 1, false);
                    g.pQN.h(11098, new Object[]{Integer.valueOf(4007), e.getMessage()});
                }
            }
            if (this.xdK.ruR == 1) {
                i.af(this.xdK.mContext, 8);
                j.a(this.xdK);
                this.xdK.KY(this.xdK.xdt.ceg());
                if (this.xdK.xdD) {
                    g.pQN.a(614, 58, 1, false);
                    x.d("MicroMsg.UpdaterManager", "boots download success.");
                }
            } else if (this.xdK.ruR == 0) {
                this.xdK.KY(this.xdK.xdt.ceg());
            } else if (this.xdK.ruR == 2) {
                i.af(this.xdK.mContext, 1);
                j.a(this.xdK);
            }
            i.ceA();
        } else if (i2 == -13) {
            x.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
            UpdaterService.cl();
            AppUpdaterUI.cek();
            i.cez();
        } else {
            if (!(this.xdK.xdt instanceof c) || this.xdK.xcb == 4) {
                x.e("MicroMsg.UpdaterManager", "update failed");
                i.ae(this.xdK.mContext, 10);
                if (this.xdK.ruR == 1) {
                    j.e(this.xdK);
                } else if (this.xdK.ruR == 0) {
                    this.xdK.ac(1, true);
                }
            } else {
                x.e("MicroMsg.UpdaterManager", "download package from cdn error.");
                if (this.xdK.xdz) {
                    if (i == 3 || i == 4 || i == 2 || i == 1 || i == 13) {
                        i.ae(this.xdK.mContext, i);
                    }
                    this.xdK.xdz = false;
                    if (this.xdK.ruR == 1) {
                        if (this.xdK.xdD) {
                            x.d("MicroMsg.UpdaterManager", "boots download failed. %d", new Object[]{Integer.valueOf(i)});
                            switch (i) {
                                case 1:
                                    g.pQN.a(614, 51, 1, false);
                                    break;
                                case 2:
                                    g.pQN.a(614, 54, 1, false);
                                    break;
                                case 3:
                                    g.pQN.a(614, 52, 1, false);
                                    break;
                                case 4:
                                    g.pQN.a(614, 53, 1, false);
                                    break;
                                case 13:
                                    g.pQN.a(614, 55, 1, false);
                                    break;
                            }
                        }
                        j.b(this.xdK);
                    } else if (this.xdK.ruR == 0) {
                        this.xdK.ac(1, true);
                    } else if (this.xdK.ruR == 2) {
                        j.c(this.xdK);
                    }
                } else {
                    this.xdK.xdt = new b(this.xdK.size, this.xdK.fqR, this.xdK.xcb, this.xdK.uin, this.xdK.hZs, this.xdK.hnJ, this.xdK.xdv, this.xdK.ruR == 2);
                    j.d(this.xdK);
                }
            }
            this.xdK.a(this.xdK.xdt);
        }
    }

    public final void fD(long j) {
        f fVar = this.xdK.xdG;
        fVar.fhK.post(new 2(fVar, j));
    }

    public final void fE(long j) {
        f fVar = this.xdK.xdG;
        fVar.fhK.post(new 3(fVar, j));
    }
}
