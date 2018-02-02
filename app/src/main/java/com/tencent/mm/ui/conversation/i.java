package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.il;
import com.tencent.mm.modelmulti.g;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.ui.t;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.FileUtils;

public final class i implements e, f {
    private static boolean yZs = false;
    Activity fAF;
    ProgressDialog iln = null;
    WakeLock wakeLock = null;
    private com.tencent.mm.ui.base.i yZm = null;
    private com.tencent.mm.ui.base.i yZn = null;
    private boolean yZo = false;
    private a yZp = new a();
    boolean yZq = false;
    private g yZr = null;
    a yZt;
    a yZu;
    c yZv = new 1(this);
    c yZw = new 5(this);
    FLock yZx;

    static /* synthetic */ boolean d(i iVar) {
        final bns bZc = p.bZc();
        if (p.bZd() && bZc != null) {
            ar.Dm().F(new Runnable(iVar) {
                final /* synthetic */ i yZy;

                public final void run() {
                    if (bZc != null && bZc.nBs.equalsIgnoreCase(p.ek(ac.getContext()))) {
                        if (com.tencent.mm.a.e.bO(bZc.wQA) && com.tencent.mm.c.a.ch(bZc.wQA)) {
                            ag.y(new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 yZA;

                                {
                                    this.yZA = r1;
                                }

                                public final void run() {
                                    if (this.yZA.yZy.yZm == null || !this.yZA.yZy.yZm.isShowing()) {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(614, 60, 1, false);
                                        this.yZA.yZy.yZm = h.a(this.yZA.yZy.fAF, bZc.fpb, bZc.title, bZc.wQB, bZc.nwc, false, new 1(this), new OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 yZB;

                                            {
                                                this.yZB = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(614, 57, 1, false);
                                                dialogInterface.dismiss();
                                            }
                                        });
                                        p.bZe();
                                        return;
                                    }
                                    x.i("MicroMsg.InitHelper", "update dialog is showing.");
                                }
                            });
                        } else {
                            ag.y(new 2(this));
                        }
                    }
                }
            });
            x.i("MicroMsg.InitHelper", "have tinker update.");
            return true;
        } else if (t.fu(iVar.fAF)) {
            com.tencent.mm.plugin.report.service.g.pQN.a(405, 41, 1, true);
            x.d("MicroMsg.InitHelper", "we got a install");
            return true;
        } else if (!t.X(iVar.fAF)) {
            return false;
        } else {
            x.d("MicroMsg.InitHelper", "we got an unfinished silence download");
            return true;
        }
    }

    final boolean cwF() {
        if (!m.PZ()) {
            return false;
        }
        if (this.yZn != null && this.yZn.isShowing()) {
            return false;
        }
        boolean z;
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.e Dj = com.tencent.mm.kernel.g.Dj();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dh().Ct();
        int e = bh.e((Integer) Dj.gQl.get(89, null));
        if (e != 0) {
            x.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: " + e);
            z = false;
        } else {
            z = bh.ou((String) Dj.gQl.get(8195, null)).length() <= 0 || bh.e((Integer) Dj.gQl.get(15, null)) == 0;
            if (!z || Dj.CQ() == null) {
                Dj.gQl.set(89, Integer.valueOf(1));
                Dj.gQl.lH(false);
                x.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: " + z);
                z = false;
            } else {
                x.i("MMKernel.CoreStorage", "isDBCorrupted: true");
                z = true;
            }
        }
        if (z) {
            this.yZn = new i$a(this.fAF).Ez(R.l.dYg).YG(this.fAF.getString(R.l.dYf)).mi(false).EC(R.l.dYh).a(new 8(this)).ED(R.l.dYe).b(new 7(this)).akx();
            this.yZn.show();
        } else {
            YY();
        }
        return true;
    }

    private void YY() {
        if (this.yZo) {
            x.i("MicroMsg.InitHelper", "summerinit doInit but hasTryDoInitButFailed true ret");
            return;
        }
        if (!this.wakeLock.isHeld()) {
            x.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
            this.wakeLock.acquire();
        }
        this.yZu.cwI();
        if (this.yZr == null) {
            if (n.qQz != null) {
                n.qQz.bue();
            }
            this.yZr = new g(this);
            x.d("MicroMsg.InitHelper", "dkinit doInit t:%d initScene:%d", new Object[]{Long.valueOf(this.yZp.zi()), Integer.valueOf(this.yZr.hashCode())});
            this.yZp.gHJ = SystemClock.elapsedRealtime();
            ar.CG().a(this.yZr, 0);
        }
        ag.y(new Runnable(this) {
            final /* synthetic */ i yZy;

            {
                this.yZy = r1;
            }

            public final void run() {
                String str = "MicroMsg.InitHelper";
                String str2 = "dkinit showProgressDlg t:%d initScene:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(this.yZy.yZp.zi());
                objArr[1] = Integer.valueOf(this.yZy.yZr == null ? -2 : this.yZy.yZr.hashCode());
                x.d(str, str2, objArr);
                if (this.yZy.iln != null && this.yZy.iln.isShowing()) {
                    this.yZy.iln.dismiss();
                }
                i iVar = this.yZy;
                Context a = this.yZy.fAF;
                this.yZy.fAF.getString(R.l.dGO);
                iVar.iln = h.a(a, this.yZy.fAF.getString(R.l.dFy), false, new 1(this));
                ar.Dm().tS();
            }
        });
    }

    public final void a(int i, int i2, k kVar) {
        if (kVar != null && kVar.getType() == v.CTRL_INDEX) {
            final int i3 = (int) (i2 != 0 ? (((long) i) * 100) / ((long) i2) : 0);
            ag.y(new Runnable(this) {
                final /* synthetic */ i yZy;

                public final void run() {
                    if (this.yZy.iln != null) {
                        this.yZy.iln.setMessage(this.yZy.fAF.getString(R.l.dFy) + i3 + "%");
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 138 || kVar.getType() == v.CTRL_INDEX) {
            int i3;
            String str2 = "MicroMsg.InitHelper";
            String str3 = "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str;
            objArr[3] = Integer.valueOf(kVar.getType());
            objArr[4] = Integer.valueOf(hashCode());
            if (this.yZr == null) {
                i3 = -2;
            } else {
                i3 = this.yZr.hashCode();
            }
            objArr[5] = Integer.valueOf(i3);
            x.i(str2, str3, objArr);
            if (this.yZr != null && kVar.getType() == v.CTRL_INDEX) {
                this.yZr = null;
                x.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[]{Long.valueOf(this.yZp.zi())});
                ak.a.hfL.a(null, null, null);
                if (n.qQz != null) {
                    n.qQz.buf();
                }
                this.yZu.cwJ();
                if (this.wakeLock.isHeld()) {
                    x.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
                    this.wakeLock.release();
                }
                ar.Dm().cfE();
                if (this.iln != null) {
                    this.iln.dismiss();
                    this.iln = null;
                }
            }
            if (t.a(this.fAF, i, i2, new Intent().setClass(this.fAF, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                x.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
            } else if (ar.Hj()) {
                if (!this.yZq) {
                    this.yZq = true;
                    ar.Hg();
                    str2 = (String) com.tencent.mm.z.c.CU().get(5, null);
                    ar.Hg();
                    if ((((Integer) com.tencent.mm.z.c.CU().get(57, Integer.valueOf(0))).intValue() != 0) && str2 != null) {
                        h.a(this.fAF, this.fAF.getString(R.l.eDy, new Object[]{str2}), this.fAF.getString(R.l.dGO), this.fAF.getString(R.l.eDA), this.fAF.getString(R.l.eDz), new OnClickListener(this) {
                            final /* synthetic */ i yZy;

                            {
                                this.yZy = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.setClassName(this.yZy.fAF, "com.tencent.mm.ui.account.RegByFacebookSetPwdUI");
                                this.yZy.fAF.startActivity(intent);
                            }
                        }, new 3(this));
                    }
                }
                if (i == 4 && i2 == -17 && !yZs) {
                    q.Qc().id(7);
                    yZs = true;
                }
                if (aj(i, i2, kVar.getType())) {
                    x.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
                    return;
                }
                if (kVar.getType() == v.CTRL_INDEX) {
                    b ilVar = new il();
                    if (i == 3 && i2 == -1) {
                        this.yZo = true;
                        ilVar.fyT.fxw = false;
                        com.tencent.mm.sdk.b.a.xef.m(ilVar);
                        this.yZt.cwo();
                    } else {
                        ilVar.fyT.fxw = true;
                        com.tencent.mm.sdk.b.a.xef.m(ilVar);
                    }
                }
                if (!t.a.a(this.fAF, i, i2, str, 4)) {
                    if (kVar.getType() == v.CTRL_INDEX) {
                        new af().post(new 11(this));
                        if ((com.tencent.mm.z.q.FY() & FileUtils.S_IWUSR) != 0) {
                            ar.Hg();
                            if (com.tencent.mm.z.c.Fd().WY("masssendapp") == null) {
                                ae aeVar = new ae();
                                aeVar.setUsername("masssendapp");
                                aeVar.setContent(ac.getContext().getResources().getString(R.l.dVA));
                                aeVar.aj(com.tencent.mm.platformtools.t.Wp() + 2000);
                                aeVar.eR(0);
                                aeVar.eO(0);
                                ar.Hg();
                                com.tencent.mm.z.c.Fd().d(aeVar);
                                i3 = com.tencent.mm.z.q.FY() & -129;
                                ar.Hg();
                                com.tencent.mm.z.c.CU().set(40, Integer.valueOf(i3));
                            }
                        }
                    }
                    if (kVar.getType() == 138 || kVar.getType() == v.CTRL_INDEX) {
                        ag.y(new Runnable(this) {
                            final /* synthetic */ i yZy;

                            {
                                this.yZy = r1;
                            }

                            public final void run() {
                                b ggVar = new gg();
                                ggVar.fwr.data = "MAIN_UI_EVENT_INIT_FINALLY";
                                com.tencent.mm.sdk.b.a.xef.m(ggVar);
                            }
                        });
                        this.yZt.cwo();
                    }
                }
            } else {
                x.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
            }
        } else if (kVar.getType() == 113 || kVar.getType() == 0) {
            x.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
        } else {
            aj(i, i2, kVar.getType());
        }
    }

    private boolean aj(int i, int i2, int i3) {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            ar.Hg();
            long d = com.tencent.mm.platformtools.t.d((Long) com.tencent.mm.z.c.CU().get(w.a.xmL, null));
            ar.Hg();
            long d2 = com.tencent.mm.platformtools.t.d((Long) com.tencent.mm.z.c.CU().get(w.a.xmN, null));
            ar.Hg();
            long d3 = com.tencent.mm.platformtools.t.d((Long) com.tencent.mm.z.c.CU().get(w.a.xmM, null));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xmL, Long.valueOf(0));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xmM, Long.valueOf(0));
            if (d3 == ((long) d.vAz) && com.tencent.mm.platformtools.t.by(d2) < 3600) {
                if (d == 1) {
                    if (t.c(this.fAF, 4, -17)) {
                        return true;
                    }
                } else if (d == 2 && t.c(this.fAF, 4, -16)) {
                    return true;
                }
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                x.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                if (r.idg) {
                    ac.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", (com.tencent.mm.platformtools.t.Wo() - 86400) - 1).commit();
                }
                if (t.c(this.fAF, i, i2)) {
                    return true;
                }
            }
            return false;
        }
        x.w("MicroMsg.InitHelper", "account not ready");
        return false;
    }

    final int cwG() {
        return this.yZr == null ? -2 : this.yZr.hashCode();
    }

    public final boolean cwH() {
        return this.yZr != null;
    }
}
