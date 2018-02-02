package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import java.util.LinkedList;
import java.util.List;

public final class ah {
    static /* synthetic */ void a(String str, au auVar, String str2) {
        int i = 1;
        a fT = a.fT(bh.VH(str2));
        if (fT == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
            return;
        }
        byte[] d;
        b bVar;
        long j;
        String str3;
        a a;
        if (!(auVar.field_imgPath == null || auVar.field_imgPath.equals(""))) {
            String B = o.Pw().B(auVar.field_imgPath, i);
            try {
                d = e.d(B, 0, e.bN(B));
            } catch (Exception e) {
                x.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[]{str, e.getLocalizedMessage()});
            }
            bVar = new b();
            if (!bh.ov(fT.fny)) {
                j = bh.getLong(fT.fny, -1);
                if (j == -1) {
                    an.aqd().b(j, bVar);
                    if (bVar.xjy != j) {
                        bVar = an.aqd().Rz(fT.fny);
                        if (bVar == null || !bVar.field_mediaSvrId.equals(fT.fny)) {
                            bVar = null;
                        }
                    }
                } else {
                    bVar = an.aqd().Rz(fT.fny);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(fT.fny)) {
                        bVar = null;
                    }
                }
            }
            str3 = "";
            if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
                ar.Hg();
                str3 = l.ac(c.Fu(), fT.title, fT.hbc);
                k.q(bVar.field_fileFullPath, str3, false);
            }
            a = a.a(fT);
            a.hbe = 3;
            l.a(a, fT.appId, fT.appName, str, str3, d, null);
        }
        d = null;
        bVar = new b();
        if (bh.ov(fT.fny)) {
            j = bh.getLong(fT.fny, -1);
            if (j == -1) {
                bVar = an.aqd().Rz(fT.fny);
                bVar = null;
            } else {
                an.aqd().b(j, bVar);
                if (bVar.xjy != j) {
                    bVar = an.aqd().Rz(fT.fny);
                    bVar = null;
                }
            }
        }
        str3 = "";
        ar.Hg();
        str3 = l.ac(c.Fu(), fT.title, fT.hbc);
        k.q(bVar.field_fileFullPath, str3, false);
        a = a.a(fT);
        a.hbe = 3;
        l.a(a, fT.appId, fT.appName, str, str3, d, null);
    }

    public static void k(final String str, final Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
        } else if (bh.ov(str)) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
        } else {
            a(dj(y.Mf().hq(1)), context, new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    String str = menuItem.getTitle();
                    x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[]{str, str});
                    ar.CG().a(new j(str, str, s.hp(str)), 0);
                    g.pQN.h(10424, new Object[]{Integer.valueOf(1), Integer.valueOf(1), str});
                    h.bu(context, context.getString(R.l.dGy));
                }
            });
        }
    }

    public static void a(au auVar, Context context, String str, boolean z) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
        } else {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                a(dj(y.Mf().hq(4)), context, new 5(auVar, context, z, str));
                return;
            }
            u.fI(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
        }
    }

    public static void a(au auVar, Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
        } else {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                a(dj(y.Mf().hq(8)), context, new 6(auVar, context));
                return;
            }
            u.fI(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
        }
    }

    public static void b(au auVar, Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
        } else {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                a(dj(y.Mf().hq(64)), context, new 9(auVar, context));
                return;
            }
            u.fI(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
        }
    }

    public static void a(au auVar, String str, Context context) {
        a(auVar, str, context, (int) WXMediaMessage.TITLE_LENGTH_LIMIT);
    }

    public static void b(au auVar, String str, Context context) {
        a(auVar, str, context, 256);
    }

    public static void c(au auVar, String str, Context context) {
        a(auVar, str, context, (int) FileUtils.S_IWUSR);
    }

    private static void a(au auVar, String str, Context context, int i) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
        } else {
            List list = null;
            switch (i) {
                case FileUtils.S_IWUSR /*128*/:
                    list = dj(f.LT());
                    break;
                case 256:
                    list = dj(y.Mf().hq(256));
                    break;
                case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                    list = dj(y.Mf().hq(WXMediaMessage.TITLE_LENGTH_LIMIT));
                    break;
            }
            a(list, context, new 10(auVar, str, i, context));
        }
    }

    public static List<String> dj(List<String> list) {
        List<String> linkedList = new LinkedList();
        for (String str : list) {
            if (!f.jV(str)) {
                linkedList.add(str);
            }
        }
        x.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public static void a(List<String> list, Context context, d dVar) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
            return;
        }
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(context);
        lVar.zlt = new 11();
        lVar.zlu = new 2(context);
        lVar.rKC = new 3(list);
        lVar.rKD = dVar;
        lVar.bBX();
    }
}
