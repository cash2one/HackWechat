package com.tencent.mm.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.c.a;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class w$a extends p implements e, a {
    private int riW = 0;
    final /* synthetic */ w xKI;
    private AddressUI.a xKJ;
    private final WxViewPager xKK;
    private boolean xKL = false;
    boolean[] xKM = new boolean[]{true, false, false, false};

    public w$a(w wVar, FragmentActivity fragmentActivity, WxViewPager wxViewPager) {
        this.xKI = wVar;
        super(fragmentActivity.getSupportFragmentManager());
        this.xKK = wxViewPager;
        this.xKK.a((u) this);
        this.xKK.b((e) this);
    }

    public final int getCount() {
        return 4;
    }

    public final Fragment R(int i) {
        return this.xKI.DX(i);
    }

    public final void a(final int i, float f, int i2) {
        x a = w.a(this.xKI);
        if (a.xKP != null) {
            a.xKP.h(i, f);
        }
        if (0.0f != f) {
            if (this.xKJ == null) {
                this.xKJ = (AddressUI.a) this.xKI.DX(1);
            }
            this.xKJ.mY(false);
        } else {
            x.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(w.b(this.xKI))});
            if (-1 == w.b(this.xKI)) {
                this.xKI.eL(w.b(this.xKI), w.c(this.xKI));
                this.xKI.DV(i);
            } else {
                ag.y(new Runnable(this) {
                    final /* synthetic */ w$a xKN;

                    public final void run() {
                        this.xKN.xKI.eL(w.b(this.xKN.xKI), w.c(this.xKN.xKI));
                        this.xKN.xKI.DV(i);
                    }
                });
            }
        }
        if (i2 == 0) {
            for (Integer num : w.ali().values()) {
                if (num.intValue() != i) {
                    eM(num.intValue(), 8);
                } else if (!this.xKM[num.intValue()]) {
                    eM(num.intValue(), 0);
                }
            }
            return;
        }
        for (Integer num2 : w.ali().values()) {
            if (!(num2.intValue() == i || this.xKM[num2.intValue()])) {
                eM(num2.intValue(), 0);
            }
        }
    }

    private void eM(int i, int i2) {
        if (this.xKI.DX(i) != null) {
            View findViewById = this.xKI.DX(i).findViewById(R.h.ctz);
            if (findViewById != null) {
                findViewById.setVisibility(i2);
            }
        }
    }

    public final void ae(int i) {
        x.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[]{Integer.valueOf(i)});
        x.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", new Object[]{Integer.valueOf(this.riW), Integer.valueOf(i)});
        if (this.riW <= 0) {
            switch (i) {
                case 0:
                    g.pQN.k(10957, "5");
                    break;
                case 1:
                    g.pQN.k(10957, "6");
                    break;
                case 2:
                    g.pQN.k(10957, "7");
                    break;
                default:
                    break;
            }
        }
        this.riW--;
        switch (i) {
            case 0:
                g.pQN.k(10957, "1");
                break;
            case 1:
                g.pQN.k(10957, "2");
                break;
            case 2:
                g.pQN.k(10957, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                break;
            case 3:
                g.pQN.k(10957, "4");
                break;
        }
        this.xKL = false;
        w.a(this.xKI, w.c(this.xKI));
        w.b(this.xKI, i);
        this.xKI.eL(w.b(this.xKI), w.c(this.xKI));
        w.a(this.xKI).DZ(i);
        w.d(this.xKI).supportInvalidateOptionsMenu();
        if (w.b(this.xKI) == 1 && w.c(this.xKI) != 1) {
            ar.Hg();
            c.CU().set(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (w.c(this.xKI) == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            if (currentTimeMillis - t.d((Long) c.CU().get(340226, null)) >= 180000) {
                ((AddressUI.a) this.xKI.DX(w.c(this.xKI))).cvK();
            }
        }
        if (w.c(this.xKI) == 0) {
            ar.getNotification().aU(true);
        } else {
            ar.getNotification().aU(false);
        }
    }

    public final void af(int i) {
        x.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[]{Integer.valueOf(i)});
        if (i == 0 && this.xKJ != null) {
            this.xKJ.mY(true);
            this.xKJ = null;
        }
    }

    public final void oW(int i) {
        if (i == w.c(this.xKI)) {
            x.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
            u DX = this.xKI.DX(i);
            if (DX instanceof AbstractTabChildActivity.a) {
                ((AbstractTabChildActivity.a) DX).clz();
                return;
            }
            return;
        }
        this.xKL = true;
        this.riW++;
        x.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", new Object[]{Integer.valueOf(this.riW)});
        this.xKK.d(i, false);
        if (i == 3) {
            com.tencent.mm.s.c.Bq().aS(262145, 266241);
            com.tencent.mm.s.c.Bq().aS(262156, 266241);
            com.tencent.mm.s.c.Bq().aS(262147, 266241);
            com.tencent.mm.s.c.Bq().aS(262149, 266241);
            com.tencent.mm.s.c.Bq().b(w.a.xxB, 266241);
            boolean aR = com.tencent.mm.s.c.Bq().aR(262156, 266241);
            g gVar = g.pQN;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            objArr[1] = Integer.valueOf(aR ? 1 : 0);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(0);
            gVar.h(14872, objArr);
        }
    }
}
