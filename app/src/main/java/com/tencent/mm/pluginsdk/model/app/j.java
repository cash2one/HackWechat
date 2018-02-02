package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.br;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g;
import com.tencent.mm.y.k;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Map;

public final class j implements d {
    a ves = null;

    public static String c(bw bwVar) {
        String a = n.a(bwVar.vGX);
        String a2 = n.a(bwVar.vGY);
        if (!bh.ov(a) && !bh.ov(a2)) {
            return fe(a, n.a(bwVar.vGZ));
        }
        x.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
        return null;
    }

    public static String fe(String str, String str2) {
        if (bh.ov(str2)) {
            return null;
        }
        if (s.eV(str)) {
            int hO = ba.hO(str2);
            if (hO != -1) {
                str2 = (str2 + " ").substring(hO + 2).trim();
            }
        }
        return bh.VH(str2);
    }

    public final b b(a aVar) {
        x.d("MicroMsg.AppMessageExtension", "process add app message");
        bw bwVar = aVar.hmq;
        String c = c(bwVar);
        g.a fT = g.a.fT(c);
        if (fT == null) {
            x.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
            return null;
        } else if (fT.hcN) {
            ar.Hg();
            c.CU().set(352273, c);
            ar.Hg();
            c.CU().set(352274, Long.valueOf(System.currentTimeMillis()));
            new a(c).bYC();
            return null;
        } else {
            String str;
            f RF = an.bin().RF(fT.appId);
            String str2 = "MicroMsg.AppMessageExtension";
            String str3 = "check version appid:%s, msgVer:%d, appVer:%s";
            Object[] objArr = new Object[3];
            objArr[0] = fT.appId;
            objArr[1] = Integer.valueOf(fT.fIm);
            if (RF == null) {
                str = "null";
            } else {
                str = Integer.valueOf(RF.field_appVersion);
            }
            objArr[2] = str;
            x.i(str2, str3, objArr);
            if (RF == null || RF.field_appVersion < fT.fIm) {
                an.bim().RD(fT.appId);
            }
            b a = a(aVar, n.a(bwVar.vGZ), fT);
            if (a.fnB == null) {
                return null;
            }
            cf cfVar = a.fnB;
            if (cfVar.ciV()) {
                if (!bh.ov(fT.hdH)) {
                    com.tencent.mm.sdk.b.b tqVar = new tq();
                    tqVar.fMl.fCs = fT.hdH;
                    com.tencent.mm.sdk.b.a.xef.m(tqVar);
                }
                return a;
            } else if (cfVar.getType() == 301989937) {
                return a;
            } else {
                com.tencent.mm.sdk.b.b smVar;
                if (cfVar.getType() == -1879048190) {
                    smVar = new sm();
                    smVar.fKi.fCs = c;
                    smVar.fKi.description = fT.description;
                    smVar.fKi.fnB = cfVar;
                    com.tencent.mm.sdk.b.a.xef.m(smVar);
                }
                if (cfVar.getType() == 49 && !bh.ov(fT.canvasPageXml)) {
                    smVar = new com.tencent.mm.g.a.g();
                    smVar.fmT.fmU = fT.canvasPageXml;
                    com.tencent.mm.sdk.b.a.xef.m(smVar);
                }
                com.tencent.mm.sdk.e.c gVar = new g();
                fT.a(gVar);
                gVar.field_msgId = cfVar.field_msgId;
                if (!an.bYS().b(gVar)) {
                    return null;
                }
                if (fT.type == 40) {
                    b fo = an.aqd().fo(cfVar.field_msgId);
                    k fX = k.fX(c);
                    if (fo == null) {
                        l.a(null, cfVar.field_msgId, 0, null, null, fX.hdZ, fT.type, 0);
                    }
                    ar.CG().a(new ab(cfVar.field_msgId, cfVar.field_msgSvrId, null), 0);
                }
                return a;
            }
        }
    }

    static String a(byte[] bArr, boolean z, boolean z2) {
        return o.Pw().a(9, bArr, z, CompressFormat.PNG, z2);
    }

    private b a(a aVar, String str, g.a aVar2) {
        String str2;
        cf cfVar;
        String str3;
        int i;
        au auVar;
        cf cfVar2;
        com.tencent.mm.sdk.b.b aiVar;
        String[] split;
        ba.b hT;
        b bVar;
        Map y;
        String ou;
        Map map;
        long currentTimeMillis;
        com.tencent.mm.sdk.b.b brVar;
        int i2;
        String ou2;
        bw bwVar = aVar.hmq;
        ar.Hg();
        com.tencent.mm.plugin.messenger.foundation.a.a.c Fa = c.Fa();
        ar.Hg();
        f Fg = c.Fg();
        String FS = q.FS();
        String a = n.a(bwVar.vGX);
        String a2 = n.a(bwVar.vGY);
        Object obj = (Fg.has(a) || FS.equals(a)) ? 1 : null;
        if (obj != null) {
            str2 = a2;
        } else {
            str2 = a;
        }
        cf F = Fa.F(str2, bwVar.vHe);
        x.d("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId));
        if (F.field_msgId != 0 && F.field_createTime + 604800000 < ba.n(a, (long) bwVar.pbl)) {
            x.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId));
            ba.aK(F.field_msgId);
            F.ao(0);
        }
        if (F.field_msgId == 0) {
            F = new au();
            F.ap(bwVar.vHe);
            F.aq(ba.n(a, (long) bwVar.pbl));
            cfVar = F;
        } else {
            cfVar = F;
        }
        if (aVar2.haY != null) {
            cfVar.ea(aVar2.haY.gjO);
            x.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", cfVar.gjO);
        }
        cfVar.setType(l.d(aVar2));
        cfVar.setContent(cfVar.ciV() ? aVar2.content : str);
        if (cfVar.ciV()) {
            cfVar.dX(aVar2.gjD);
        }
        if (bwVar.vHa == 2 && cfVar.field_msgId == 0) {
            Object obj2;
            switch (cfVar.getType()) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    obj2 = 1;
                    break;
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 == null) {
                boolean z = aVar2.type == 2;
                byte[] a3 = n.a(bwVar.vHb);
                if (r.idz) {
                    x.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a3 = null;
                }
                if (!bh.bw(a3)) {
                    if (aVar2.type == 33 || aVar2.type == 36) {
                        str2 = o.Pw().a(a3, CompressFormat.PNG);
                    } else {
                        str2 = a(a3, z, cfVar.cjk());
                    }
                    if (bh.ov(str2)) {
                        x.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", cfVar.field_content);
                    }
                    if (!bh.ov(str2)) {
                        cfVar.dT(str2);
                        x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path" + str2);
                    }
                } else if (!bh.ov(aVar2.hbj) && !bh.ov(aVar2.hbq)) {
                    long j = cfVar.field_msgSvrId;
                    str2 = aVar2.hbq;
                    String str4 = aVar2.hbj;
                    int i3 = aVar2.hbk;
                    x.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", Long.valueOf(cfVar.field_msgSvrId), str2, Integer.valueOf(i3), str4, a, Boolean.valueOf(z));
                    long Wp = bh.Wp();
                    int i4 = aVar2 != null ? aVar2.type : 0;
                    String m = o.Pw().m(bh.Wp(), "", "");
                    i iVar = new i();
                    iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", cfVar.field_createTime, a, String.valueOf(j));
                    iVar.field_fullpath = m;
                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    iVar.field_totalLen = i3;
                    iVar.field_aesKey = str2;
                    iVar.field_fileId = str4;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.hrL;
                    iVar.field_chattype = s.eV(a) ? 1 : 0;
                    x.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", Integer.valueOf(iVar.field_chattype), a);
                    iVar.htt = new 1(this, j, str4, Wp, i3, a, m, i4, z);
                    com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1);
                } else if (!bh.ov(aVar2.thumburl)) {
                    x.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
                    str2 = com.tencent.mm.a.g.s((bh.Wp()).getBytes());
                    FS = o.Pw().getFullPath(str2);
                    o.Pw();
                    str2 = com.tencent.mm.aq.g.ll(str2);
                    com.tencent.mm.aq.a.a PA = o.PA();
                    str3 = aVar2.thumburl;
                    com.tencent.mm.aq.a.a.c.a aVar3 = new com.tencent.mm.aq.a.a.c.a();
                    aVar3.hDC = FS;
                    aVar3.hDA = true;
                    PA.a(str3, null, aVar3.PK());
                    cfVar.dT(str2);
                    x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + FS);
                }
                if (obj == null) {
                    cfVar.eR(1);
                    cfVar.dS(a2);
                    i = bwVar.ktm;
                    auVar = cfVar;
                } else {
                    cfVar.eR(0);
                    cfVar.dS(a);
                    if (bwVar.ktm <= 3) {
                        i = bwVar.ktm;
                        cfVar2 = cfVar;
                    } else {
                        i = 3;
                        cfVar2 = cfVar;
                    }
                }
                auVar.eQ(i);
                if (aVar2.type == 2001 && aVar2.showType == 1) {
                    if (!TextUtils.isEmpty(aVar2.hcK) || TextUtils.isEmpty(aVar2.hcL) || aVar2.hcM <= 0) {
                        x.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
                    } else {
                        x.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                        aiVar = new ai();
                        aiVar.foq = new ai.a();
                        aiVar.foq.fos = aVar2.hcL;
                        aiVar.foq.for = aVar2.hcK;
                        aiVar.foq.fot = aVar2.hcM;
                        com.tencent.mm.sdk.b.a.xef.m(aiVar);
                    }
                }
                if (aVar2.type == 2001) {
                    try {
                        if (!bh.cA(aVar2.hcW)) {
                            for (String str22 : aVar2.hcW) {
                                split = str22.split(",");
                                if (split != null && split.length > 0) {
                                    str22 = split[0];
                                    if (!bh.ov(str22) && str22.equals(q.FS())) {
                                        cfVar.fa(cfVar.field_flag | 8);
                                        x.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                                        m(true, cfVar.field_talker);
                                    }
                                }
                            }
                        } else if (!"1001".equals(aVar2.hcG)) {
                            aiVar = new th();
                            aiVar.fLK.fDP = str;
                            com.tencent.mm.sdk.b.a.xef.m(aiVar);
                            m(false, cfVar.field_talker);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", e.getMessage());
                    }
                }
                cfVar.dY(bwVar.vHc);
                hT = ba.hT(bwVar.vHc);
                if (hT != null) {
                    cfVar.dZ(hT.hgH);
                    cfVar.dW(hT.hgG);
                }
                ba.a((au) cfVar, aVar);
                if (cfVar.field_msgId != 0) {
                    cfVar.ao(ba.i(cfVar));
                    aiVar = new com.tencent.mm.g.a.r();
                    aiVar.fnA.fnB = cfVar;
                    aiVar.fnA.fnC = aVar2;
                    com.tencent.mm.sdk.b.a.xef.m(aiVar);
                    bVar = new b(cfVar, true);
                } else {
                    Fa.b(bwVar.vHe, (au) cfVar);
                    bVar = new b(cfVar, false);
                }
                if (cfVar.getType() == 301989937 && s.hh(cfVar.field_talker)) {
                    cfVar.ao(0);
                }
                if (cfVar.cjc() && "notifymessage".equals(cfVar.field_talker)) {
                    y = bi.y(cfVar.field_content, "msg");
                    if (y != null) {
                        ou = bh.ou((String) y.get(".msg.fromusername"));
                        if (com.tencent.mm.storage.x.fV(ou)) {
                            ((com.tencent.mm.plugin.appbrand.m.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qL(ou);
                            x.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", ou);
                        }
                    }
                }
                if (!bh.ov(aVar2.hcP) && cfVar.getType() == 436207665) {
                    aiVar = new mi();
                    aiVar.fEk.fEl = cfVar.field_msgId;
                    aiVar.fEk.fDP = str;
                    com.tencent.mm.sdk.b.a.xef.m(aiVar);
                }
                if (cfVar.getType() == 536870961) {
                    com.tencent.mm.y.b bVar2 = (com.tencent.mm.y.b) aVar2.r(com.tencent.mm.y.b.class);
                    com.tencent.mm.sdk.b.b mkVar = new mk();
                    mkVar.fEo.fEl = cfVar.field_msgId;
                    mkVar.fEo.fEp = bVar2.fEn;
                    com.tencent.mm.sdk.b.a.xef.m(mkVar);
                }
                if (aVar2.type == MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN && !bh.ov(aVar2.hcg)) {
                    aiVar = new mm();
                    aiVar.fEr.fEs = aVar2.hcg;
                    aiVar.fEr.fqm = cfVar.field_msgId;
                    aiVar.fEr.fEt = aVar2;
                    com.tencent.mm.sdk.b.a.xef.m(aiVar);
                    m(false, cfVar.field_talker);
                }
                map = aVar2.hdK;
                str3 = bh.az((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
                if ((str3.equals("wx_f2f") || str3.equals("wx_md")) && bVar.hmu) {
                    currentTimeMillis = System.currentTimeMillis() - cfVar.field_createTime;
                    x.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str3, Long.valueOf(cfVar.field_createTime), Long.valueOf(System.currentTimeMillis()));
                    brVar = new br();
                    i2 = bh.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
                    ou2 = bh.ou((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
                    str22 = bh.ou((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
                    if (!(i2 <= 0 || bh.ov(ou2) || bh.ov(str22))) {
                        brVar.fpN.fpO = i2;
                        brVar.fpN.fpP = ou2;
                        brVar.fpN.fpQ = str22;
                        brVar.fpN.fpR = str3;
                        brVar.fpN.fpS = currentTimeMillis;
                        brVar.fpN.cOY = 0;
                        com.tencent.mm.sdk.b.a.xef.m(brVar);
                    }
                }
                return bVar;
            }
        }
        if (!bh.ov(aVar2.thumburl)) {
            x.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
            str22 = com.tencent.mm.a.g.s((bh.Wp()).getBytes());
            if (aVar2.type == 2001) {
                str22 = com.tencent.mm.a.g.s((aVar2.thumburl).getBytes());
            }
            FS = o.Pw().getFullPath(str22);
            o.Pw();
            str22 = com.tencent.mm.aq.g.ll(str22);
            PA = o.PA();
            str3 = aVar2.thumburl;
            aVar3 = new com.tencent.mm.aq.a.a.c.a();
            aVar3.hDC = FS;
            aVar3.hDA = true;
            PA.a(str3, null, aVar3.PK());
            cfVar.dT(str22);
            x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + FS);
        }
        if (obj == null) {
            cfVar.eR(0);
            cfVar.dS(a);
            if (bwVar.ktm <= 3) {
                i = 3;
                cfVar2 = cfVar;
            } else {
                i = bwVar.ktm;
                cfVar2 = cfVar;
            }
        } else {
            cfVar.eR(1);
            cfVar.dS(a2);
            i = bwVar.ktm;
            auVar = cfVar;
        }
        auVar.eQ(i);
        if (TextUtils.isEmpty(aVar2.hcK)) {
        }
        x.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
        if (aVar2.type == 2001) {
            if (!bh.cA(aVar2.hcW)) {
                while (r5.hasNext()) {
                    split = str22.split(",");
                    str22 = split[0];
                    cfVar.fa(cfVar.field_flag | 8);
                    x.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                    m(true, cfVar.field_talker);
                }
            } else if ("1001".equals(aVar2.hcG)) {
                aiVar = new th();
                aiVar.fLK.fDP = str;
                com.tencent.mm.sdk.b.a.xef.m(aiVar);
                m(false, cfVar.field_talker);
            }
        }
        cfVar.dY(bwVar.vHc);
        hT = ba.hT(bwVar.vHc);
        if (hT != null) {
            cfVar.dZ(hT.hgH);
            cfVar.dW(hT.hgG);
        }
        ba.a((au) cfVar, aVar);
        if (cfVar.field_msgId != 0) {
            Fa.b(bwVar.vHe, (au) cfVar);
            bVar = new b(cfVar, false);
        } else {
            cfVar.ao(ba.i(cfVar));
            aiVar = new com.tencent.mm.g.a.r();
            aiVar.fnA.fnB = cfVar;
            aiVar.fnA.fnC = aVar2;
            com.tencent.mm.sdk.b.a.xef.m(aiVar);
            bVar = new b(cfVar, true);
        }
        cfVar.ao(0);
        y = bi.y(cfVar.field_content, "msg");
        if (y != null) {
            ou = bh.ou((String) y.get(".msg.fromusername"));
            if (com.tencent.mm.storage.x.fV(ou)) {
                ((com.tencent.mm.plugin.appbrand.m.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qL(ou);
                x.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", ou);
            }
        }
        aiVar = new mi();
        aiVar.fEk.fEl = cfVar.field_msgId;
        aiVar.fEk.fDP = str;
        com.tencent.mm.sdk.b.a.xef.m(aiVar);
        if (cfVar.getType() == 536870961) {
            com.tencent.mm.y.b bVar22 = (com.tencent.mm.y.b) aVar2.r(com.tencent.mm.y.b.class);
            com.tencent.mm.sdk.b.b mkVar2 = new mk();
            mkVar2.fEo.fEl = cfVar.field_msgId;
            mkVar2.fEo.fEp = bVar22.fEn;
            com.tencent.mm.sdk.b.a.xef.m(mkVar2);
        }
        aiVar = new mm();
        aiVar.fEr.fEs = aVar2.hcg;
        aiVar.fEr.fqm = cfVar.field_msgId;
        aiVar.fEr.fEt = aVar2;
        com.tencent.mm.sdk.b.a.xef.m(aiVar);
        m(false, cfVar.field_talker);
        map = aVar2.hdK;
        str3 = bh.az((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        currentTimeMillis = System.currentTimeMillis() - cfVar.field_createTime;
        x.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str3, Long.valueOf(cfVar.field_createTime), Long.valueOf(System.currentTimeMillis()));
        brVar = new br();
        i2 = bh.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        ou2 = bh.ou((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        str22 = bh.ou((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        brVar.fpN.fpO = i2;
        brVar.fpN.fpP = ou2;
        brVar.fpN.fpQ = str22;
        brVar.fpN.fpR = str3;
        brVar.fpN.fpS = currentTimeMillis;
        brVar.fpN.cOY = 0;
        com.tencent.mm.sdk.b.a.xef.m(brVar);
        return bVar;
    }

    private static void m(boolean z, String str) {
        if (!bh.ov(str)) {
            x.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", Boolean.valueOf(z), str);
            ar.Hg();
            ae WY = c.Fd().WY(str);
            if (WY != null) {
                if (z) {
                    WY.gb(16777216);
                } else {
                    WY.AU();
                }
                ar.Hg();
                c.Fd().a(WY, str);
            }
        }
    }

    public final void h(au auVar) {
        if (auVar == null) {
            x.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
            return;
        }
        x.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + auVar.field_imgPath);
        com.tencent.mm.sdk.b.b slVar = new sl();
        slVar.fKh.path = auVar.field_imgPath;
        com.tencent.mm.sdk.b.a.xef.m(slVar);
        String str = auVar.field_content;
        if (str != null) {
            g.a fT = g.a.fT(str);
            if (fT != null && fT.type == 6) {
                FileOp.deleteFile(e.gHs + fT.title);
                FileOp.deleteFile(e.gHs + fT.title + "_tmp");
            }
        }
    }

    public final boolean a(a aVar, String str, long j, String str2, String str3, int i, String str4) {
        String m = o.Pw().m("Note_" + str, "", "");
        if (FileOp.bO(m)) {
            return false;
        }
        this.ves = aVar;
        i iVar = new i();
        iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", j, str4, str);
        iVar.field_fullpath = m;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        iVar.field_totalLen = i;
        iVar.field_aesKey = str2;
        iVar.field_fileId = str3;
        iVar.field_priority = com.tencent.mm.modelcdntran.b.hrL;
        iVar.field_chattype = s.eV(str4) ? 1 : 0;
        x.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", Integer.valueOf(iVar.field_chattype), str4);
        iVar.htt = new 2(this, str3, aVar);
        com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1);
        return true;
    }
}
