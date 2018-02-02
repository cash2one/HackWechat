package com.tencent.mm.app;

import android.app.Activity;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.cd.j;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.e;

public final class f extends d {
    private static boolean feZ = true;
    private j feX = new j();
    private volatile boolean feY = false;

    public final void tN() {
        super.tN();
        a.a("Hello WeChat, DefaultBootStep load debugger and init xlog...", new Object[0]);
        ac.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        i.cq(((h) g.Dg().CN()).gOs);
        m.d(com.tencent.mm.boot.a.a.class);
        m.cu("com.tencent.mm.boot");
        m.a(((h) g.Dg().CN()).gSI, ((h) g.Dg().CN()).gSI.getResources());
    }

    public final void tO() {
        g.Df().gQa = com.tencent.mm.plugin.zero.a.d.class;
        d.o(PluginZero.class);
        d.o(PluginMessengerFoundation.class);
        d.o(PluginReport.class);
        d.o(PluginAuth.class);
        d.o(PluginBigBallOfMud.class);
        d.o(PluginRecovery.class);
        d.fP("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
        d.fP("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
        d.fP("com.tencent.mm.plugin.comm.PluginComm");
        d.fP("com.tencent.mm.plugin.audio.PluginVoice");
        d.fP("com.tencent.mm.plugin.biz.PluginBiz");
        d.fP("com.tencent.mm.plugin.notification.PluginNotification");
        d.fP("com.tencent.mm.plugin.messenger.PluginMessenger");
        d.fP("com.tencent.mm.plugin.welab.PluginWelab");
        d.fP("com.tencent.mm.plugin.sport.PluginSport");
        d.fP("com.tencent.mm.plugin.fts.PluginFTS");
        fQ("com.tencent.mm.plugin.performance.PluginPerformance");
        fQ("com.tencent.mm.plugin.chatroom.PluginChatroom");
        fQ("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
        fQ("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
        fQ("com.tencent.mm.plugin.appbrand.compat.PluginAppBrandCompat");
        fQ("com.tencent.mm.plugin.uishow.PluginUIShow");
        fQ("com.tencent.mm.plugin.emoji.PluginEmoji");
        fQ("com.tencent.mm.plugin.video.PluginVideo");
        fQ("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
        fQ("com.tencent.mm.plugin.sns.PluginSns");
        fQ("com.tencent.mm.plugin.downloader.PluginDownloader");
        fQ("com.tencent.mm.plugin.fav.PluginFav");
        fQ("com.tencent.mm.plugin.record.PluginRecord");
        fQ("com.tencent.mm.plugin.music.PluginMusic");
        fQ("com.tencent.mm.plugin.MMPhotoEditPlugin");
        fQ("com.tencent.mm.plugin.facedetect.PluginFace");
        fQ("com.tencent.mm.plugin.soter.PluginSoter");
        fQ("com.tencent.mm.plugin.walletlock.PluginWalletLock");
        fQ("com.tencent.mm.plugin.wxpay.PluginWxPay");
        fQ("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
        fQ("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
        fQ("com.tencent.mm.plugin.radar.PluginRadar");
        fQ("com.tencent.mm.plugin.topstory.PluginTopStory");
        fQ("com.tencent.mm.plugin.mmsight.PluginMMSight");
        fQ("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
        fQ("com.tencent.mm.plugin.normsg.PluginNormsg");
        fQ("com.tencent.mm.plugin.netmock.PluginNetMock");
        com.tencent.mm.kernel.a.b.g gVar = c.Dt().gRn;
        com.tencent.mm.kernel.b.a k = g.k(n.class);
        gVar.gSB.put(com.tencent.mm.kernel.api.c.class, k);
    }

    public final void a(com.tencent.mm.kernel.b.g gVar) {
        if (((h) g.Dg().CN()).DS()) {
            tP();
            new ag("Startup-SideWork").F(new 1(this, gVar));
        }
        super.a(gVar);
    }

    private static void tP() {
        long currentTimeMillis = System.currentTimeMillis();
        m.tZ();
        com.tencent.mm.blink.a.j(4, System.currentTimeMillis() - currentTimeMillis);
        com.tencent.mm.blink.a.j(5, 1);
        x.i("MicroMsg.DefaultBootStep", "SVG init done, spent %s", Long.valueOf(currentTimeMillis));
    }

    public final void b(com.tencent.mm.kernel.b.g gVar) {
        if (((h) g.Dg().CN()).DS()) {
            j jVar = this.feX;
            synchronized (jVar.gOg) {
                try {
                    if (jVar.gOg[0] == (byte) -1) {
                        com.tencent.mm.kernel.j.i("MicroMsg.WxWaitingLock", "waiting %s", jVar);
                        jVar.gOg.wait();
                        com.tencent.mm.kernel.j.i("MicroMsg.WxWaitingLock", "after waiting %s", jVar);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WxWaitingLock", e, "", new Object[0]);
                }
            }
            if (this.feY) {
                x.e("MicroMsg.DefaultBootStep", "SVG still failed!");
            }
        }
        super.b(gVar);
    }

    public final boolean tQ() {
        if (feZ) {
            return true;
        }
        if (!((h) g.Dg().CN()).DS()) {
            return true;
        }
        g.Dh();
        if (!com.tencent.mm.kernel.a.Cx() || !g.Dh().Cy()) {
            return true;
        }
        if (e.xlx.size() == 1) {
            if (ac.cfq().equals(e.U((Activity) e.xlx.get(0)))) {
                x.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
                return false;
            }
        }
        return true;
    }
}
