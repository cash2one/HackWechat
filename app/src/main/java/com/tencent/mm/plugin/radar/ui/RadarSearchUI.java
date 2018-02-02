package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b.b;
import b.c.b.e;
import b.c.b.i;
import b.c.b.j;
import b.c.b.l;
import b.e.d;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.e$e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.q;
import java.util.Arrays;

@a(19)
public final class RadarSearchUI extends MMBaseActivity {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] pxT = new d[]{j.a(new i(j.R(RadarSearchUI.class), "mRadarViewController", "getMRadarViewController()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;"))};
    public static final a pyx = new a((byte) 0);
    private final b pyv;
    private boolean pyw = true;

    private final RadarViewController blK() {
        return (RadarViewController) this.pyv.getValue();
    }

    public RadarSearchUI() {
        int i = c.pvJ;
        e.i(this, "$receiver");
        this.pyv = i.a(new i.a(this, i));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        requestWindowFeature(1);
        setContentView(com.tencent.mm.plugin.radar.a.d.pwa);
        RadarViewController blK = blK();
        View findViewById = blK.findViewById(c.pvB);
        e.h(findViewById, "findViewById(R.id.radar_main_layer)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new b.i("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = blK.getContext();
        if (context == null) {
            throw new b.i("null cannot be cast to non-null type android.app.Activity");
        }
        WindowManager windowManager = ((Activity) context).getWindowManager();
        e.h(windowManager, "(context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams2.width = displayMetrics.widthPixels;
        relativeLayout.setLayoutParams(layoutParams2);
        RadarTipsView bmd = blK.bmd();
        bmd.blU().setOnClickListener(new RadarTipsView.c(bmd));
        RadarTipsView bmd2 = blK.bmd();
        RadarTipsView.a aVar = RadarTipsView.pzz;
        bmd2.pzt = RadarTipsView.blZ();
        d dVar = d.pyu;
        int blJ = d.blJ();
        bmd2.pzl.sendEmptyMessageDelayed(bmd2.pzi, (long) blJ);
        bmd2.pzl.sendEmptyMessageDelayed(bmd2.pzh, (long) (blJ + 8000));
        bmd2 = blK.bmd();
        if (bmd2.pzr != 0) {
            aVar = RadarTipsView.pzz;
            bmd2.pzt = RadarTipsView.blY();
            bmd2.blX();
            bmd2.blW();
            bmd2.blT().setVisibility(8);
            bmd2.blU().setVisibility(8);
            bmd2.setVisibility(8);
        }
        bmd2.pzp = true;
        bmd2.pzr = bh.Wq();
        bmd2.pzs = true;
        bmd2.pzq++;
        blK.bmg().setOnClickListener(blK.pzQ);
        RadarWaveView bma = blK.bma();
        bma.pAs = bma.findViewById(c.pvP);
        bma.pAt = AnimationUtils.loadAnimation(bma.getContext(), com.tencent.mm.plugin.radar.a.a.pvs);
        Animation animation = bma.pAt;
        if (animation == null) {
            e.cJy();
        }
        animation.setInterpolator(new LinearInterpolator());
        b.a aVar2 = b.a.pxS;
        findViewById = blK.findViewById(c.pvX);
        e.h(findViewById, "findViewById(R.id.self_round_avatar)");
        ImageView imageView = (ImageView) findViewById;
        String FS = q.FS();
        e.h(FS, "ConfigStorageLogic.getUsernameFromUserInfo()");
        b.a.a(imageView, FS);
        RadarMemberView bmb = blK.bmb();
        RadarMemberView.b eVar = new RadarViewController.e(blK);
        e.i(eVar, "listener");
        bmb.pyh = eVar;
        RadarSpecialGridView bmc = blK.bmc();
        context = blK.getContext();
        e.h(context, "context");
        blK.pzN = new RadarViewController.c(blK, bmc, context);
        blK.bmc().pyz = new g(blK);
        RadarViewController blK2 = blK();
        com.tencent.mm.plugin.radar.b.c cVar = blK2.pzM;
        com.tencent.mm.kernel.c.a h = com.tencent.mm.kernel.g.h(h.class);
        e.h(h, "service(IMessengerStorage::class.java)");
        ((h) h).EY().a(cVar);
        com.tencent.mm.sdk.b.a.xef.b(cVar.pwz);
        com.tencent.mm.kernel.b.a k = com.tencent.mm.kernel.g.k(n.class);
        e.h(k, "plugin(IPluginMessengerFoundation::class.java)");
        ((n) k).getSysCmdMsgExtension().a("addcontact", cVar.pwA, true);
        com.tencent.mm.plugin.radar.b.e eVar2 = blK2.pzL;
        if (eVar2 == null) {
            e.acv("radarManager");
        }
        com.tencent.mm.kernel.g.CG().a(x.CTRL_INDEX, eVar2);
        com.tencent.mm.kernel.g.CG().a(602, eVar2);
        Object obj = com.tencent.mm.kernel.g.Dj().CU().get(229377, Integer.valueOf(0));
        if (obj == null) {
            throw new b.i("null cannot be cast to non-null type kotlin.Int");
        }
        com.tencent.mm.kernel.g.Dj().CU().set(229377, Integer.valueOf(((Integer) obj).intValue() + 1));
    }

    public final void onResume() {
        super.onResume();
        if (this.pyw) {
            com.tencent.mm.sdk.platformtools.x.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                blL();
            }
        }
    }

    private final void blL() {
        hu(true);
        com.tencent.mm.plugin.radar.b.d dVar = com.tencent.mm.plugin.radar.b.d.pxd;
        com.tencent.mm.plugin.radar.b.d.fzQ = 0;
        com.tencent.mm.plugin.radar.b.d.pwZ = 0;
        com.tencent.mm.plugin.radar.b.d.pwZ = com.tencent.mm.plugin.radar.b.d.bls();
        dVar = com.tencent.mm.plugin.radar.b.d.pxd;
        com.tencent.mm.plugin.radar.b.d.pxa = 0;
        com.tencent.mm.plugin.radar.b.d.pwY = 0;
        com.tencent.mm.plugin.radar.b.d.pwW = 0;
        com.tencent.mm.plugin.radar.b.d.pwX = 0;
        com.tencent.mm.plugin.radar.b.d.pwY = com.tencent.mm.plugin.radar.b.d.bls();
        com.tencent.mm.plugin.report.service.g.pQN.a(com.tencent.mm.plugin.radar.b.d.pxb, com.tencent.mm.plugin.radar.b.d.pxc, 1, false);
        if (blK().pzO == e$e.pxz || blK().pzO == e$e.pxA) {
            com.tencent.mm.plugin.radar.b.e eVar = blK().pzL;
            if (eVar == null) {
                e.acv("radarManager");
            }
            com.tencent.mm.modelgeo.c cVar = eVar.hpO;
            if (cVar != null) {
                cVar.b(eVar.gyF);
            }
            eVar = blK().pzL;
            if (eVar == null) {
                e.acv("radarManager");
            }
            eVar.blt();
            blK().bma().bmk();
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        e.i(strArr, "permissions");
        e.i(iArr, "grantResults");
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iArr[0]);
        Thread currentThread = Thread.currentThread();
        e.h(currentThread, "Thread.currentThread()");
        objArr[2] = Long.valueOf(currentThread.getId());
        com.tencent.mm.sdk.platformtools.x.i(TAG, "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", objArr);
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    blL();
                    return;
                }
                this.pyw = false;
                com.tencent.mm.ui.base.h.a(this, getString(f.ezP), getString(f.ezT), getString(f.est), getString(f.ezN), false, new b(this), new c(this));
                return;
            default:
                return;
        }
    }

    public final void onPause() {
        long bls;
        int i;
        super.onPause();
        hu(false);
        com.tencent.mm.plugin.radar.b.d dVar = com.tencent.mm.plugin.radar.b.d.pxd;
        if (com.tencent.mm.plugin.radar.b.d.pwZ != 0) {
            bls = com.tencent.mm.plugin.radar.b.d.bls() - com.tencent.mm.plugin.radar.b.d.pwZ;
            d dVar2 = d.pyu;
            if (d.dY(bls)) {
                boolean z = false;
            } else {
                i = 1;
            }
            if (i != 0) {
                i = com.tencent.mm.plugin.radar.b.d.fzQ;
                com.tencent.mm.sdk.platformtools.x.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", new Object[]{Integer.valueOf(i)});
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                l lVar = l.AuT;
                String format = String.format("%d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                e.h(format, "java.lang.String.format(format, *args)");
                gVar.k(10679, format);
                com.tencent.mm.plugin.radar.b.d.pwW++;
                com.tencent.mm.plugin.radar.b.d.pwX = bls + com.tencent.mm.plugin.radar.b.d.pwX;
                com.tencent.mm.plugin.radar.b.d.pwZ = 0;
            }
        }
        dVar = com.tencent.mm.plugin.radar.b.d.pxd;
        if (com.tencent.mm.plugin.radar.b.d.pwY != 0) {
            bls = System.currentTimeMillis() - com.tencent.mm.plugin.radar.b.d.pwY;
            i = com.tencent.mm.plugin.radar.b.d.pwW;
            float f = (((float) com.tencent.mm.plugin.radar.b.d.pwX) * 1.0f) / 1000.0f;
            int i2 = com.tencent.mm.plugin.radar.b.d.pxa;
            float f2 = (((float) bls) * 1.0f) / 1000.0f;
            com.tencent.mm.sdk.platformtools.x.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[]{Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Float.valueOf(f2)});
            com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pQN;
            l lVar2 = l.AuT;
            format = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[]{Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Float.valueOf(f2)}, 5));
            e.h(format, "java.lang.String.format(format, *args)");
            gVar2.k(10676, format);
        }
        if (blK().pzO == e$e.pxz || blK().pzO == e$e.pxA) {
            com.tencent.mm.plugin.radar.b.e eVar = blK().pzL;
            if (eVar == null) {
                e.acv("radarManager");
            }
            eVar.blu();
            eVar = blK().pzL;
            if (eVar == null) {
                e.acv("radarManager");
            }
            com.tencent.mm.modelgeo.c cVar = eVar.hpO;
            if (cVar != null) {
                cVar.c(eVar.gyF);
            }
            blK().bma().bml();
        }
    }

    public final void onDestroy() {
        RadarViewController blK = blK();
        com.tencent.mm.plugin.radar.b.c cVar = blK.pzM;
        com.tencent.mm.kernel.c.a h = com.tencent.mm.kernel.g.h(h.class);
        e.h(h, "service(IMessengerStorage::class.java)");
        ((h) h).EY().b(cVar);
        com.tencent.mm.sdk.b.a.xef.c(cVar.pwz);
        com.tencent.mm.kernel.b.a k = com.tencent.mm.kernel.g.k(n.class);
        e.h(k, "plugin(IPluginMessengerFoundation::class.java)");
        ((n) k).getSysCmdMsgExtension().b("addcontact", cVar.pwA, true);
        com.tencent.mm.plugin.radar.b.e eVar = blK.pzL;
        if (eVar == null) {
            e.acv("radarManager");
        }
        com.tencent.mm.kernel.g.CG().b(x.CTRL_INDEX, eVar);
        com.tencent.mm.kernel.g.CG().b(602, eVar);
        eVar.stop();
        com.tencent.mm.modelgeo.c cVar2 = eVar.hpO;
        if (cVar2 != null) {
            cVar2.c(eVar.gyF);
        }
        RadarWaveView bma = blK.bma();
        try {
            MediaPlayer mediaPlayer = bma.pAr;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            bma.pAr = null;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(RadarWaveView.TAG, e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.x.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
            bma.pAr = null;
        }
        super.onDestroy();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        e.i(keyEvent, "event");
        boolean onKeyDown = blK().onKeyDown(i, keyEvent);
        if (onKeyDown) {
            return onKeyDown;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void hu(boolean z) {
        rk rkVar = new rk();
        rkVar.fJk.fJl = z;
        com.tencent.mm.sdk.b.a.xef.m(rkVar);
    }

    public final Object getSystemService(String str) {
        e.i(str, "name");
        Object systemService = super.getSystemService(str);
        if (e.h("layout_inflater", str)) {
            if (systemService == null) {
                throw new b.i("null cannot be cast to non-null type android.view.LayoutInflater");
            }
            systemService = v.b((LayoutInflater) systemService);
        }
        e.h(systemService, "if (Context.LAYOUT_INFLA…r)\n        } else service");
        return systemService;
    }
}
