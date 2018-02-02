package com.tencent.mm.plugin.favorite.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public final class e {

    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ String fgO;
        final /* synthetic */ Runnable fgd;
        final /* synthetic */ String hAT;
        final /* synthetic */ int jqi;
        final /* synthetic */ String mpF;
        final /* synthetic */ String mpG;
        final /* synthetic */ Context val$context;

        public AnonymousClass5(Context context, String str, String str2, String str3, int i, String str4, Runnable runnable) {
            this.val$context = context;
            this.fgO = str;
            this.mpF = str2;
            this.hAT = str3;
            this.jqi = i;
            this.mpG = str4;
            this.fgd = runnable;
        }

        public final void run() {
            Context context = this.val$context;
            String str = this.fgO;
            String str2 = this.mpF;
            String str3 = this.hAT;
            int i = this.jqi;
            String str4 = this.mpG;
            File file = new File(str2);
            if (file.exists()) {
                File file2 = new File(str3);
                x.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
                f.aZh().a(context, str, file.getAbsolutePath(), str3, 1, i, str4);
            }
            ag.y(this.fgd);
        }

        public final String toString() {
            return super.toString() + "|sendFavVideo";
        }
    }

    static /* synthetic */ void a(Context context, String str, uq uqVar) {
        File file = new File(j.h(uqVar));
        if (file.exists()) {
            String d = d(uqVar);
            x.d("MicroMsg.FavSendLogic", "send fav short Video::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), d});
            bmf com_tencent_mm_protocal_c_bmf = null;
            ut utVar = uqVar.wdJ;
            if (utVar != null) {
                com_tencent_mm_protocal_c_bmf = new bmf();
                com_tencent_mm_protocal_c_bmf.hdt = utVar.hdt;
                com_tencent_mm_protocal_c_bmf.hdq = utVar.hdq;
                com_tencent_mm_protocal_c_bmf.weC = utVar.weC;
                com_tencent_mm_protocal_c_bmf.hdo = utVar.hdo;
                com_tencent_mm_protocal_c_bmf.hdr = utVar.hdr;
                com_tencent_mm_protocal_c_bmf.hdu = utVar.hdu;
                com_tencent_mm_protocal_c_bmf.hdv = utVar.hdv;
                com_tencent_mm_protocal_c_bmf.hds = utVar.hds;
            }
            if (com_tencent_mm_protocal_c_bmf != null) {
                f.aZh().a(context, str, file.getAbsolutePath(), d, 62, uqVar.duration, com_tencent_mm_protocal_c_bmf, false, false, uqVar.fGG);
                return;
            }
            f.aZh().a(context, str, file.getAbsolutePath(), d, 62, uqVar.duration, uqVar.fGG);
            return;
        }
        x.w("MicroMsg.FavSendLogic", "sendShortVideo, error! data not existed");
    }

    static /* synthetic */ void a(String str, com.tencent.mm.plugin.fav.a.f fVar, uq uqVar) {
        String h = j.h(uqVar);
        IMediaObject wXFileObject = new WXFileObject();
        wXFileObject.setFilePath(h);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.title = uqVar.title;
        if (bh.ov(wXMediaMessage.title)) {
            wXMediaMessage.title = fVar.field_favProto.title;
        }
        wXMediaMessage.description = uqVar.desc;
        wXMediaMessage.thumbData = bh.readFromFile(j.i(uqVar));
        l.a(wXMediaMessage, "", "", str, 3, null);
    }

    static /* synthetic */ void b(Context context, String str, uq uqVar) {
        File file = new File(j.h(uqVar));
        if (file.exists()) {
            File file2 = new File(j.i(uqVar));
            String absolutePath = file2.exists() ? file2.getAbsolutePath() : j.aIE() + g.s(bh.az(uqVar.fqf, "").getBytes());
            x.d("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), absolutePath});
            bmf com_tencent_mm_protocal_c_bmf = null;
            ut utVar = uqVar.wdJ;
            if (utVar != null) {
                com_tencent_mm_protocal_c_bmf = new bmf();
                com_tencent_mm_protocal_c_bmf.hdt = utVar.hdt;
                com_tencent_mm_protocal_c_bmf.hdq = utVar.hdq;
                com_tencent_mm_protocal_c_bmf.weC = utVar.weC;
                com_tencent_mm_protocal_c_bmf.hdo = utVar.hdo;
                com_tencent_mm_protocal_c_bmf.hdr = utVar.hdr;
                com_tencent_mm_protocal_c_bmf.hdu = utVar.hdu;
                com_tencent_mm_protocal_c_bmf.hdv = utVar.hdv;
            }
            if (com_tencent_mm_protocal_c_bmf != null) {
                f.aZh().a(context, str, file.getAbsolutePath(), absolutePath, 1, uqVar.duration, com_tencent_mm_protocal_c_bmf, false, false, uqVar.fGG);
                return;
            } else {
                f.aZh().a(context, str, file.getAbsolutePath(), absolutePath, 1, uqVar.duration, uqVar.fGG);
                return;
            }
        }
        String str2 = uqVar.wcQ;
        if (!bh.ov(str2)) {
            IMediaObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = str2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            String az = bh.az(uqVar.title, context.getResources().getString(R.l.egS));
            wXMediaMessage.mediaObject = wXVideoObject;
            wXMediaMessage.title = az;
            wXMediaMessage.description = uqVar.desc;
            wXMediaMessage.thumbData = bh.readFromFile(j.i(uqVar));
            if (wXMediaMessage.thumbData == null) {
                wXMediaMessage.thumbData = bh.readFromFile(j.aIE() + g.s(bh.az(uqVar.fqf, "").getBytes()));
            }
            a aVar = new a();
            aVar.hbe = 3;
            ut utVar2 = uqVar.wdJ;
            if (utVar2 != null) {
                aVar.hdt = utVar2.hdt;
                aVar.hdq = utVar2.hdq;
                aVar.hdp = utVar2.weC;
                aVar.hdo = utVar2.hdo;
                aVar.hdr = utVar2.hdr;
                aVar.hdu = utVar2.hdu;
                aVar.hdv = utVar2.hdv;
            }
            l.a(aVar, wXMediaMessage, str);
        }
    }

    public static void a(Context context, String str, String str2, com.tencent.mm.plugin.fav.a.f fVar, Runnable runnable) {
        List linkedList = new LinkedList();
        linkedList.add(fVar);
        a(context, str, str2, linkedList, runnable);
    }

    public static void a(Context context, String str, String str2, List<com.tencent.mm.plugin.fav.a.f> list, Runnable runnable) {
        if (context == null) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
            ag.y(runnable);
        } else if (bh.ov(str)) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
            ag.y(runnable);
        } else if (list.isEmpty()) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
            ag.y(runnable);
        } else {
            ar.Dm().F(new 1(str, list, context, str2, runnable));
        }
    }

    public static void a(Context context, String str, com.tencent.mm.plugin.fav.a.f fVar, uq uqVar, Runnable runnable) {
        if (context == null) {
            x.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
        } else if (bh.ov(str)) {
            x.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
        } else {
            if (fVar == null) {
                x.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
            }
            if (uqVar == null) {
                x.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
            } else {
                ar.Dm().F(new 4(str, fVar, uqVar, runnable));
            }
        }
    }

    public static String d(uq uqVar) {
        File file = new File(j.i(uqVar));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return j.aIE() + g.s(bh.az(uqVar.fqf, "").getBytes());
    }
}
