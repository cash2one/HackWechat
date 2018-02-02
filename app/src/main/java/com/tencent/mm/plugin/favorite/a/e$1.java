package com.tencent.mm.plugin.favorite.a;

import android.content.Context;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ab;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import java.util.Iterator;
import java.util.List;

class e$1 implements Runnable {
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ String mpA;
    final /* synthetic */ List mpB;
    final /* synthetic */ String mpC;
    final /* synthetic */ Context val$context;

    e$1(String str, List list, Context context, String str2, Runnable runnable) {
        this.mpA = str;
        this.mpB = list;
        this.val$context = context;
        this.mpC = str2;
        this.fgd = runnable;
    }

    public final void run() {
        for (String str : bh.F(this.mpA.split(","))) {
            for (f fVar : this.mpB) {
                if (fVar != null) {
                    g.pQN.h(10925, new Object[]{Integer.valueOf(fVar.field_type), Integer.valueOf(fVar.field_id)});
                    byte[] readFromFile;
                    String hz;
                    Context context;
                    vd vdVar;
                    b lwVar;
                    byte[] readFromFile2;
                    switch (fVar.field_type) {
                        case 1:
                            com.tencent.mm.plugin.messenger.a.f.aZh().A(str, fVar.field_favProto.desc, s.hp(str));
                            break;
                        case 2:
                            Iterator it = fVar.field_favProto.weU.iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.messenger.a.f.aZh().a(this.val$context, str, j.h((uq) it.next()), 0, "", "");
                            }
                            break;
                        case 4:
                            e.b(this.val$context, str, j.p(fVar));
                            break;
                        case 5:
                            if (fVar != null) {
                                String str2;
                                uq p = j.p(fVar);
                                vt vtVar = fVar.field_favProto.web;
                                vk vkVar = fVar.field_favProto.weS;
                                a aVar = new a();
                                if (vtVar != null) {
                                    aVar.title = vtVar.title;
                                    str2 = vtVar.thumbUrl;
                                    if (bh.ov(str2)) {
                                        str2 = bh.az(p.fqf, "");
                                    }
                                    aVar.thumburl = str2;
                                }
                                if (bh.ov(aVar.title) && p != null) {
                                    aVar.title = p.title;
                                }
                                if (vtVar != null) {
                                    aVar.description = vtVar.desc;
                                }
                                if (bh.ov(aVar.description) && p != null) {
                                    aVar.description = p.desc;
                                }
                                if (fVar.field_favProto.web != null) {
                                    aVar.url = fVar.field_favProto.web.wfz;
                                }
                                if (vkVar != null && bh.ov(aVar.url)) {
                                    aVar.url = vkVar.hOf;
                                }
                                if (!(p == null || bh.ov(p.canvasPageXml))) {
                                    aVar.canvasPageXml = p.canvasPageXml;
                                }
                                aVar.action = "view";
                                aVar.type = 5;
                                aVar.fGG = p.fGG;
                                readFromFile = bh.readFromFile(j.i(p));
                                if (readFromFile == null) {
                                    str2 = vtVar == null ? null : vtVar.thumbUrl;
                                    if (bh.ov(str2)) {
                                        str2 = bh.az(p.fqf, "");
                                    }
                                    readFromFile = bh.readFromFile(j.aIE() + com.tencent.mm.a.g.s(str2.getBytes()));
                                }
                                String str3 = "fav_" + q.FS() + "_" + fVar.field_id;
                                hz = u.hz(str3);
                                u.b t = u.GK().t(hz, true);
                                t.o("prePublishId", str3);
                                t.o("preUsername", fVar.field_fromUser);
                                t.o("sendAppMsgScene", Integer.valueOf(1));
                                t.o("adExtStr", p.fGG);
                                com.tencent.mm.plugin.messenger.a.f.aZh().a(str, readFromFile, a.a(aVar, null, null), hz);
                                break;
                            }
                            x.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                            break;
                        case 6:
                            ux uxVar = fVar.field_favProto.wdZ;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("<msg>");
                            stringBuilder.append("<location ");
                            stringBuilder.append("x=\"").append(uxVar.lat).append("\" ");
                            stringBuilder.append("y=\"").append(uxVar.lng).append("\" ");
                            stringBuilder.append("scale=\"").append(uxVar.fzv).append("\" ");
                            stringBuilder.append("label=\"").append(bh.az(uxVar.label, "")).append("\" ");
                            stringBuilder.append("maptype=\"0\" ");
                            stringBuilder.append("poiname=\"").append(bh.az(uxVar.fDu, "")).append("\" ");
                            stringBuilder.append("/>");
                            stringBuilder.append("</msg>");
                            com.tencent.mm.plugin.messenger.a.f.aZh().A(str, stringBuilder.toString(), 48);
                            break;
                        case 7:
                            Context context2 = this.val$context;
                            uq p2 = j.p(fVar);
                            IMediaObject wXMusicObject = new WXMusicObject();
                            wXMusicObject.musicUrl = p2.wcQ;
                            wXMusicObject.musicDataUrl = p2.wcS;
                            wXMusicObject.musicLowBandUrl = p2.wcU;
                            wXMusicObject.musicLowBandDataUrl = p2.wcU;
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.mediaObject = wXMusicObject;
                            wXMediaMessage.title = p2.title;
                            wXMediaMessage.description = p2.desc;
                            readFromFile = bh.readFromFile(j.i(p2));
                            if (readFromFile == null) {
                                readFromFile = bh.readFromFile(j.aIE() + com.tencent.mm.a.g.s(bh.az(p2.fqf, "").getBytes()));
                            }
                            wXMediaMessage.thumbData = readFromFile;
                            hz = fVar.field_favProto.weS.appId;
                            l.a(wXMediaMessage, hz, ab.a.hfJ.l(context2, hz), str, 3, null);
                            break;
                        case 8:
                            e.a(str, fVar, j.p(fVar));
                            break;
                        case 10:
                            context = this.val$context;
                            vdVar = fVar.field_favProto.wed;
                            lwVar = new lw();
                            lwVar.fDn.opType = 0;
                            lwVar.fDn.fDp = vdVar.info;
                            lwVar.fDn.context = context;
                            com.tencent.mm.sdk.b.a.xef.m(lwVar);
                            if (!lwVar.fDo.fpW) {
                                break;
                            }
                            readFromFile2 = bh.readFromFile(j.aIE() + com.tencent.mm.a.g.s(bh.az(vdVar.thumbUrl, "").getBytes()));
                            if (readFromFile2 == null) {
                                readFromFile2 = bh.readFromFile(lwVar.fDo.fvC);
                            }
                            com.tencent.mm.plugin.messenger.a.f.aZh().a(str, readFromFile2, lwVar.fDo.fDq, null);
                            break;
                        case 11:
                            context = this.val$context;
                            vdVar = fVar.field_favProto.wed;
                            lwVar = new lw();
                            lwVar.fDn.opType = 1;
                            lwVar.fDn.fDp = vdVar.info;
                            lwVar.fDn.context = context;
                            com.tencent.mm.sdk.b.a.xef.m(lwVar);
                            if (!lwVar.fDo.fpW) {
                                break;
                            }
                            readFromFile2 = bh.readFromFile(j.aIE() + com.tencent.mm.a.g.s(bh.az(vdVar.thumbUrl, "").getBytes()));
                            if (readFromFile2 == null) {
                                readFromFile2 = bh.readFromFile(lwVar.fDo.fvC);
                            }
                            com.tencent.mm.plugin.messenger.a.f.aZh().a(str, readFromFile2, lwVar.fDo.fDq, null);
                            break;
                        case 14:
                        case 18:
                            x.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[]{Integer.valueOf(fVar.field_id)});
                            if (fVar.field_id <= 0 && !c.vdg) {
                                break;
                            }
                            e$a a = e$a.a(this.val$context, fVar);
                            ve veVar = new ve();
                            try {
                                x.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                                veVar.aF(fVar.field_favProto.toByteArray());
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.FavSendLogic", e, "", new Object[0]);
                                x.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[]{e.getMessage()});
                            }
                            b mtVar = new mt();
                            mtVar.fEE.type = 2;
                            mtVar.fEE.toUser = str;
                            mtVar.fEE.fEH = veVar;
                            mtVar.fEE.title = a.title;
                            mtVar.fEE.desc = a.desc;
                            mtVar.fEE.fvC = a.fvC;
                            mtVar.fEE.fEM = a.mpH;
                            com.tencent.mm.sdk.b.a.xef.m(mtVar);
                            break;
                            break;
                        case 15:
                            context = this.val$context;
                            vn vnVar = fVar.field_favProto.wef;
                            lwVar = new rg();
                            lwVar.fIX.opType = 0;
                            lwVar.fIX.fIZ = vnVar.info;
                            lwVar.fIX.context = context;
                            com.tencent.mm.sdk.b.a.xef.m(lwVar);
                            x.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[]{Boolean.valueOf(lwVar.fIY.fpW), vnVar.thumbUrl});
                            if (!lwVar.fIY.fpW) {
                                break;
                            }
                            readFromFile2 = bh.readFromFile(j.aIE() + com.tencent.mm.a.g.s(bh.az(vnVar.thumbUrl, "").getBytes()));
                            if (readFromFile2 == null) {
                                readFromFile2 = bh.readFromFile(lwVar.fIY.fvC);
                            }
                            com.tencent.mm.plugin.messenger.a.f.aZh().a(str, readFromFile2, lwVar.fIY.fDq, null);
                            break;
                        case 16:
                            e.a(this.val$context, str, j.p(fVar));
                            break;
                        case 17:
                            com.tencent.mm.plugin.messenger.a.f.aZh().A(str, j.p(fVar).desc, 42);
                            break;
                        default:
                            break;
                    }
                }
                x.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[]{Integer.valueOf(this.mpB.size())});
            }
            if (!bh.ov(this.mpC)) {
                com.tencent.mm.plugin.messenger.a.f.aZh().A(str, this.mpC, s.hp(str));
            }
        }
        ag.y(this.fgd);
    }

    public final String toString() {
        return super.toString() + "|sendFavMsg";
    }
}
