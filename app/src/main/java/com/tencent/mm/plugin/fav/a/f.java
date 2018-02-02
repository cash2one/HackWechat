package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.g.b.bb;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Map;

public final class f extends bb {
    public static a gJc = bb.vJ();
    private static a mnT = new 1();
    private static a mnU = new 2();

    public final /* synthetic */ Object clone() {
        return aHQ();
    }

    public f() {
        this.field_flag = -1;
        this.field_fromUser = "";
        this.field_toUser = "";
        this.field_id = -1;
        this.field_realChatName = "";
        this.field_sourceType = -1;
        this.field_updateTime = -1;
        this.field_type = -1;
        this.field_updateSeq = -1;
        this.field_xml = "";
        this.field_itemStatus = 0;
        aHI();
    }

    private void aHI() {
        this.field_favProto = new ve();
        vk vkVar = new vk();
        vkVar.CS(1);
        this.field_favProto.a(vkVar);
        this.field_favProto.b(new vt());
        this.field_favProto.b(new ux());
        this.field_favProto.b(new vd());
        this.field_favProto.b(new vn());
        this.field_favProto.CQ(-1);
        this.field_tagProto = new vr();
        this.field_favProto.a(new uy());
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean aHJ() {
        return (this.field_favProto.wek & 1) != 0;
    }

    public final boolean aHK() {
        return (this.field_favProto.wek & 2) != 0;
    }

    public final boolean aHL() {
        if (this.field_itemStatus == 1 || this.field_itemStatus == 4 || this.field_itemStatus == 9 || this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 15 || this.field_itemStatus == 17) {
            return true;
        }
        return false;
    }

    public final boolean aHM() {
        if (this.field_itemStatus == 3 || this.field_itemStatus == 6 || this.field_itemStatus == 11 || this.field_itemStatus == 14 || this.field_itemStatus == 16 || this.field_itemStatus == 18) {
            return true;
        }
        return false;
    }

    public final boolean isDownloading() {
        return this.field_itemStatus == 7;
    }

    public final boolean aHN() {
        return this.field_itemStatus == 8;
    }

    public final boolean isDone() {
        return this.field_itemStatus == 10;
    }

    public final boolean aHO() {
        if (this.field_itemStatus == 15 || this.field_itemStatus == 16) {
            return true;
        }
        return false;
    }

    public final boolean aHP() {
        if (this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 14) {
            return true;
        }
        return false;
    }

    public final f zQ(String str) {
        if (str == null || str.equals("")) {
            x.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
        } else {
            Map y = bi.y(str, "favitem");
            if (y == null) {
                x.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
            } else {
                try {
                    aHI();
                    ve veVar = this.field_favProto;
                    veVar.Ug((String) y.get(".favitem.title"));
                    veVar.Uh((String) y.get(".favitem.desc"));
                    veVar.Uf((String) y.get(".favitem.remark"));
                    veVar.fA(bh.getLong((String) y.get(".favitem.remark.$time"), 0));
                    String str2 = (String) y.get(".favitem.edittime");
                    veVar.CR(bh.getInt((String) y.get(".favitem.version"), 0));
                    veVar.fB(bh.getLong(str2, 0));
                    veVar.CQ(bh.getInt((String) y.get(".favitem.ctrlflag"), -1));
                    String str3 = ".favitem.source";
                    vk vkVar = veVar.weS;
                    vkVar.CS(bh.getInt((String) y.get(str3 + ".$sourcetype"), 0));
                    vkVar.Uk((String) y.get(str3 + ".$sourceid"));
                    vkVar.Ui((String) y.get(str3 + ".fromusr"));
                    vkVar.Uj((String) y.get(str3 + ".tousr"));
                    vkVar.Ul((String) y.get(str3 + ".realchatname"));
                    vkVar.fC(bh.getLong((String) y.get(str3 + ".createtime"), 0));
                    vkVar.Um((String) y.get(str3 + ".msgid"));
                    vkVar.Un((String) y.get(str3 + ".eventid"));
                    vkVar.Uo((String) y.get(str3 + ".appid"));
                    vkVar.Up((String) y.get(str3 + ".link"));
                    vkVar.Uq((String) y.get(str3 + ".brandid"));
                    b.a(str, veVar);
                    str3 = ".favitem.locitem";
                    ux uxVar = veVar.wdZ;
                    if (!bh.ov((String) y.get(str3 + ".label"))) {
                        uxVar.TZ((String) y.get(str3 + ".label"));
                    }
                    if (!bh.ov((String) y.get(str3 + ".poiname"))) {
                        uxVar.Ua((String) y.get(str3 + ".poiname"));
                    }
                    str2 = (String) y.get(str3 + ".lng");
                    if (!bh.ov(str2)) {
                        uxVar.r(bh.getDouble(str2, 0.0d));
                    }
                    str2 = (String) y.get(str3 + ".lat");
                    if (!bh.ov(str2)) {
                        uxVar.s(bh.getDouble(str2, 0.0d));
                    }
                    str2 = (String) y.get(str3 + ".scale");
                    if (!bh.ov(str2)) {
                        if (str2.indexOf(46) != -1) {
                            uxVar.CO(bh.getInt(str2.substring(0, str2.indexOf(46)), -1));
                        } else {
                            uxVar.CO(bh.getInt(str2, -1));
                        }
                    }
                    str3 = ".favitem.weburlitem";
                    vt vtVar = veVar.web;
                    vtVar.Ux((String) y.get(str3 + ".clean_url"));
                    vtVar.Uw((String) y.get(str3 + ".pagedesc"));
                    vtVar.Uy((String) y.get(str3 + ".pagethumb_url"));
                    vtVar.Uv((String) y.get(str3 + ".pagetitle"));
                    vtVar.CT(bh.getInt((String) y.get(str3 + ".opencache"), 0));
                    vtVar.CU(bh.getInt((String) y.get(str3 + ".contentattr"), 0));
                    vtVar.Uz((String) y.get(str3 + ".canvasPageXml"));
                    str3 = ".favitem.productitem";
                    vd vdVar = veVar.wed;
                    vdVar.Ub((String) y.get(str3 + ".producttitle"));
                    vdVar.Uc((String) y.get(str3 + ".productdesc"));
                    vdVar.Ud((String) y.get(str3 + ".productthumb_url"));
                    vdVar.Ue((String) y.get(str3 + ".productinfo"));
                    vdVar.CP(bh.getInt((String) y.get(str3 + ".$type"), 0));
                    str3 = ".favitem.tvitem";
                    vn vnVar = veVar.wef;
                    vnVar.Ur((String) y.get(str3 + ".tvtitle"));
                    vnVar.Us((String) y.get(str3 + ".tvdesc"));
                    vnVar.Ut((String) y.get(str3 + ".tvthumb_url"));
                    vnVar.Uu((String) y.get(str3 + ".tvinfo"));
                    str3 = ".favitem.noteinfo";
                    uy uyVar = veVar.vCU;
                    uyVar.weL = (String) y.get(str3 + ".noteauthor");
                    uyVar.weM = (String) y.get(str3 + ".noteeditor");
                    if (this.field_favProto.weS != null) {
                        vk vkVar2 = this.field_favProto.weS;
                        this.field_sourceId = vkVar2.wfc;
                        this.field_sourceType = vkVar2.fqd;
                        this.field_fromUser = vkVar2.fzO;
                        this.field_toUser = vkVar2.toUser;
                    }
                    this.field_edittime = this.field_favProto.vCV;
                    c.a(y, this.field_tagProto);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FavItemInfo", e, "", new Object[0]);
                    x.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[]{e.toString()});
                }
            }
        }
        return this;
    }

    public final void zR(String str) {
        a aVar = mnT;
        aVar.rE("----dump favitem from[" + str + "] beg----");
        aVar.rE("type: " + this.field_type);
        aVar.rE("favId: " + this.field_id);
        aVar.rE("localId: " + this.field_localId);
        aVar.rE("itemStatus: " + this.field_itemStatus);
        aVar.rE("localSeq: " + this.field_localSeq);
        aVar.rE("updateSeq: " + this.field_updateSeq);
        aVar.rE("ctrlFlag: " + this.field_flag);
        aVar.rE("sourceId: " + this.field_sourceId);
        aVar.rE("sourceType: " + this.field_sourceType);
        aVar.rE("sourceCreateTime: " + this.field_sourceCreateTime);
        aVar.rE("updateTime: " + this.field_updateTime);
        aVar.rE("editTime: " + this.field_edittime);
        aVar.rE("fromuser: " + this.field_fromUser);
        aVar.rE("toUser: " + this.field_toUser);
        aVar.rE("realChatName: " + this.field_realChatName);
        if (this.field_favProto != null) {
            aVar.rE("remarktime: " + this.field_favProto.wei);
            aVar.rE("dataitemCount: " + this.field_favProto.weU.size());
            if (this.field_favProto.weS != null) {
                aVar.rE(" ----source item----");
                vk vkVar = this.field_favProto.weS;
                aVar.rE("  sourceType: " + vkVar.fqd);
                aVar.rE("  fromUser: " + vkVar.fzO);
                aVar.rE("  toUser: " + vkVar.toUser);
                aVar.rE("  sourceId: " + vkVar.wfc);
                aVar.rE("  realChatName: " + vkVar.wet);
                aVar.rE("  createTime: " + vkVar.hVE);
                aVar.rE("  msgId: " + vkVar.fDJ);
                aVar.rE("  eventId: " + vkVar.fIR);
                aVar.rE("  appId: " + vkVar.appId);
                aVar.rE("  link: " + vkVar.hOf);
                aVar.rE("  mediaId: " + vkVar.wez);
                aVar.rE("  brandId: " + vkVar.fnl);
            }
            Iterator it = this.field_favProto.weU.iterator();
            int i = 0;
            while (it.hasNext()) {
                uq uqVar = (uq) it.next();
                int i2 = i + 1;
                aVar.rE(" ----data item " + i + "----");
                aVar.rE("  dataId: " + uqVar.mvG);
                aVar.rE("  dataType: " + uqVar.bjS);
                aVar.rE("  dataSouceId: " + uqVar.wdr);
                aVar.rE("  svrDataStatus: " + uqVar.wdz);
                aVar.rE("  cdnThumbUrl: " + uqVar.hbj);
                aVar.rE("  cdnThumbKey: " + uqVar.wcF);
                aVar.rE("  cdnDataUrl: " + uqVar.wcJ);
                aVar.rE("  cdnDataKey: " + uqVar.wcL);
                aVar.rE("  cdnEncryVer: " + uqVar.wcN);
                aVar.rE("  fullmd5: " + uqVar.wda);
                aVar.rE("  head256md5: " + uqVar.wdc);
                aVar.rE("  fullsize: " + uqVar.wde);
                aVar.rE("  thumbMd5: " + uqVar.wdl);
                aVar.rE("  thumbHead256md5: " + uqVar.wdn);
                aVar.rE("  thumbfullsize: " + uqVar.wdp);
                aVar.rE("  duration: " + uqVar.duration);
                aVar.rE("  datafmt: " + uqVar.wcY);
                aVar.rE("  streamWebUrl: " + uqVar.wcQ);
                aVar.rE("  streamDataUrl: " + uqVar.wcS);
                aVar.rE("  streamLowBandUrl: " + uqVar.wcU);
                aVar.rE("  ext: " + uqVar.fqf);
                if (uqVar.wdD != null) {
                    aVar.rE("  remarktime: " + uqVar.wdD.wei);
                    aVar.rE("  ctrlflag: " + uqVar.wdD.wek);
                    aVar.rE("  edittime: " + uqVar.wdD.vCV);
                    if (uqVar.wdD.wdX != null) {
                        aVar.rE("   ----data source item----");
                        us usVar = uqVar.wdD.wdX;
                        aVar.rE("    sourceType: " + usVar.fqd);
                        aVar.rE("    fromUser: " + usVar.fzO);
                        aVar.rE("    toUser: " + usVar.toUser);
                        aVar.rE("    realChatName: " + usVar.wet);
                        aVar.rE("    createTime: " + usVar.hVE);
                        aVar.rE("    msgId: " + usVar.fDJ);
                        aVar.rE("    eventId: " + usVar.fIR);
                        aVar.rE("    appId: " + usVar.appId);
                        aVar.rE("    link: " + usVar.hOf);
                        aVar.rE("    mediaId: " + usVar.wez);
                        aVar.rE("    brandId: " + usVar.fnl);
                    }
                    a("  ", aVar, uqVar.wdD.wdZ);
                    a("  ", aVar, uqVar.wdD.web);
                    a("  ", aVar, uqVar.wdD.wed);
                    a("  ", aVar, uqVar.wdD.wef);
                    a("  ", aVar, uqVar.wdD.vCU);
                }
                i = i2;
            }
            a("", aVar, this.field_favProto.wdZ);
            a("", aVar, this.field_favProto.web);
            a("", aVar, this.field_favProto.wed);
            a("", aVar, this.field_favProto.wef);
            a("  ", aVar, this.field_favProto.vCU);
        }
        aVar.rE("----dump favitem end----");
    }

    private static void a(String str, a aVar, vn vnVar) {
        if (vnVar != null) {
            aVar.rE(str + " ----tv item----");
            aVar.rE(str + "  title: " + vnVar.title);
            aVar.rE(str + "  desc: " + vnVar.desc);
            aVar.rE(str + "  thumbUrl: " + vnVar.thumbUrl);
        }
    }

    private static void a(String str, a aVar, uy uyVar) {
        if (uyVar != null) {
            aVar.rE(str + " ----noteInfoItem item----");
            aVar.rE(str + "  author: " + uyVar.weL);
            aVar.rE(str + "  editor: " + uyVar.weM);
        }
    }

    private static void a(String str, a aVar, vd vdVar) {
        if (vdVar != null) {
            aVar.rE(str + " ----product item----");
            aVar.rE(str + "  title: " + vdVar.title);
            aVar.rE(str + "  desc: " + vdVar.desc);
            aVar.rE(str + "  thumbUrl: " + vdVar.thumbUrl);
            aVar.rE(str + "  type: " + vdVar.type);
        }
    }

    private static void a(String str, a aVar, ux uxVar) {
        if (uxVar != null) {
            aVar.rE(str + " ----loc item----");
            aVar.rE(str + "  lng: " + uxVar.lng);
            aVar.rE(str + "  lat: " + uxVar.lat);
            aVar.rE(str + "  scale: " + uxVar.fzv);
            aVar.rE(str + "  label: " + uxVar.label);
            aVar.rE(str + "  poiname: " + uxVar.fDu);
        }
    }

    private static void a(String str, a aVar, vt vtVar) {
        if (vtVar != null) {
            aVar.rE(str + " ----url item----");
            aVar.rE(str + "  title: " + vtVar.title);
            aVar.rE(str + "  desc: " + vtVar.desc);
            aVar.rE(str + "  cleanUrl: " + vtVar.wfz);
            aVar.rE(str + "  thumbUrl: " + vtVar.thumbUrl);
            aVar.rE(str + "  opencache: " + vtVar.wfB);
        }
    }

    public final boolean zS(String str) {
        if (bh.ov(str)) {
            return false;
        }
        Iterator it = this.field_tagProto.wfj.iterator();
        while (it.hasNext()) {
            if (str.equals((String) it.next())) {
                return false;
            }
        }
        this.field_tagProto.wfj.add(str);
        return true;
    }

    public static String c(f fVar) {
        String str;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("<favitem");
        stringBuffer2.append(" type='").append(fVar.field_type).append("'");
        stringBuffer2.append(">");
        ve veVar = fVar.field_favProto;
        StringBuilder stringBuilder = new StringBuilder();
        if (!bh.ov(veVar.title)) {
            stringBuilder.append("<title>").append(bh.VG(veVar.title)).append("</title>");
        }
        if (!bh.ov(veVar.desc)) {
            stringBuilder.append("<desc>").append(bh.VG(veVar.desc)).append("</desc>");
        }
        if (veVar.vCV > 0) {
            stringBuilder.append("<edittime>").append(veVar.vCV).append("</edittime>");
        }
        if (!bh.ov(veVar.iIj)) {
            stringBuilder.append("<remark ");
            if (veVar.wei > 0) {
                stringBuilder.append(" time ='").append(veVar.wei).append("'");
            }
            stringBuilder.append(">").append(bh.VG(veVar.iIj)).append("</remark>");
        }
        if (veVar.wel) {
            stringBuilder.append("<ctrlflag>").append(veVar.wek).append("</ctrlflag>");
        }
        if (veVar.weW) {
            stringBuilder.append("<version>").append(veVar.version).append("</version>");
        } else if (fVar.field_type == 18) {
            stringBuilder.append("<version>1</version>");
        }
        vk vkVar = veVar.weS;
        if (vkVar == null || vkVar.bke() == 0) {
            x.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<source");
            if (vkVar.weo) {
                stringBuffer.append(" sourcetype='").append(vkVar.fqd).append("'");
            }
            if (vkVar.wfd) {
                stringBuffer.append(" sourceid='").append(vkVar.wfc).append("'");
            }
            stringBuffer.append(">");
            if (vkVar.wep) {
                stringBuffer.append("<fromusr>").append(bh.VG(vkVar.fzO)).append("</fromusr>");
            }
            if (vkVar.weq) {
                stringBuffer.append("<tousr>").append(bh.VG(vkVar.toUser)).append("</tousr>");
            }
            if (vkVar.weu) {
                stringBuffer.append("<realchatname>").append(bh.VG(vkVar.wet)).append("</realchatname>");
            }
            if (vkVar.wev) {
                stringBuffer.append("<msgid>").append(vkVar.fDJ).append("</msgid>");
            }
            if (vkVar.wew) {
                stringBuffer.append("<eventid>").append(vkVar.fIR).append("</eventid>");
            }
            if (vkVar.wex) {
                stringBuffer.append("<appid>").append(vkVar.appId).append("</appid>");
            }
            if (vkVar.wey) {
                stringBuffer.append("<link>").append(bh.VG(vkVar.hOf)).append("</link>");
            }
            if (vkVar.weB) {
                stringBuffer.append("<brandid>").append(bh.VG(vkVar.fnl)).append("</brandid>");
            }
            stringBuffer.append("</source>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.aG(veVar.weU));
        ux uxVar = fVar.field_favProto.wdZ;
        if (uxVar == null || uxVar.bke() == 0) {
            x.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<locitem>");
            if (uxVar.weJ) {
                stringBuffer.append("<label>").append(bh.VG(uxVar.label)).append("</label>");
            }
            if (uxVar.weH) {
                stringBuffer.append("<lat>").append(uxVar.lat).append("</lat>");
            }
            if (uxVar.weG) {
                stringBuffer.append("<lng>").append(uxVar.lng).append("</lng>");
            }
            if (uxVar.weI) {
                stringBuffer.append("<scale>").append(uxVar.fzv).append("</scale>");
            }
            if (uxVar.weK) {
                stringBuffer.append("<poiname>").append(uxVar.fDu).append("</poiname>");
            }
            stringBuffer.append("</locitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        vt vtVar = fVar.field_favProto.web;
        if (vtVar == null || vtVar.bke() == 0) {
            x.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<weburlitem>");
            if (vtVar.wfA) {
                stringBuffer.append("<clean_url>").append(bh.VG(vtVar.wfz)).append("</clean_url>");
            }
            if (vtVar.wcD) {
                stringBuffer.append("<pagedesc>").append(bh.VG(vtVar.desc)).append("</pagedesc>");
            }
            if (vtVar.weP) {
                stringBuffer.append("<pagethumb_url>").append(bh.VG(vtVar.thumbUrl)).append("</pagethumb_url>");
            }
            if (vtVar.wcC) {
                stringBuffer.append("<pagetitle>").append(bh.VG(vtVar.title)).append("</pagetitle>");
            }
            if (vtVar.wfC) {
                stringBuffer.append("<opencache>").append(vtVar.wfB).append("</opencache>");
            }
            if (vtVar.wfD) {
                stringBuffer.append("<contentattr>").append(vtVar.hbg).append("</contentattr>");
            }
            if (vtVar.wdO) {
                stringBuffer.append("<canvasPageXml>").append(vtVar.canvasPageXml).append("</canvasPageXml>");
            }
            stringBuffer.append("</weburlitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        vd vdVar = fVar.field_favProto.wed;
        if (vdVar == null || vdVar.bke() == 0) {
            x.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<productitem");
            if (vdVar.weR) {
                stringBuffer.append(" type='").append(vdVar.type).append("'");
            }
            stringBuffer.append(">");
            if (vdVar.wcC) {
                stringBuffer.append("<producttitle>").append(bh.VG(vdVar.title)).append("</producttitle>");
            }
            if (vdVar.wcD) {
                stringBuffer.append("<productdesc>").append(bh.VG(vdVar.desc)).append("</productdesc>");
            }
            if (vdVar.weP) {
                stringBuffer.append("<productthumb_url>").append(bh.VG(vdVar.thumbUrl)).append("</productthumb_url>");
            }
            if (vdVar.weQ) {
                stringBuffer.append("<productinfo>").append(bh.VG(vdVar.info)).append("</productinfo>");
            }
            stringBuffer.append("</productitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        vn vnVar = fVar.field_favProto.wef;
        if (vnVar == null || vnVar.bke() == 0) {
            x.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<tvitem>");
            if (vnVar.wcC) {
                stringBuffer.append("<tvtitle>").append(bh.VG(vnVar.title)).append("</tvtitle>");
            }
            if (vnVar.wcD) {
                stringBuffer.append("<tvdesc>").append(bh.VG(vnVar.desc)).append("</tvdesc>");
            }
            if (vnVar.weP) {
                stringBuffer.append("<tvthumb_url>").append(bh.VG(vnVar.thumbUrl)).append("</tvthumb_url>");
            }
            if (vnVar.weQ) {
                stringBuffer.append("<tvinfo>").append(bh.VG(vnVar.info)).append("</tvinfo>");
            }
            stringBuffer.append("</tvitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        uy uyVar = veVar.vCU;
        if (uyVar == null || uyVar.bke() == 0) {
            x.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("<noteinfo>");
            stringBuffer3.append("<noteauthor>").append(bh.VG(uyVar.weL)).append("</noteauthor>");
            stringBuffer3.append("<noteeditor>").append(bh.VG(uyVar.weM)).append("</noteeditor>");
            stringBuffer3.append("</noteinfo>");
            str = stringBuffer3.toString();
        }
        stringBuilder.append(str);
        stringBuffer2.append(stringBuilder.toString());
        stringBuffer2.append(c.a(fVar.field_tagProto));
        stringBuffer2.append("</favitem>");
        return stringBuffer2.toString();
    }

    public final f aHQ() {
        f fVar = new f();
        fVar.field_favProto = this.field_favProto;
        fVar.field_sourceId = this.field_sourceId;
        fVar.field_edittime = this.field_edittime;
        fVar.field_ext = this.field_ext;
        fVar.field_flag = this.field_flag;
        fVar.field_fromUser = this.field_fromUser;
        fVar.field_id = this.field_id;
        fVar.field_itemStatus = this.field_itemStatus;
        fVar.field_localId = this.field_localId;
        fVar.field_localSeq = this.field_localSeq;
        fVar.field_realChatName = this.field_realChatName;
        fVar.field_tagProto = this.field_tagProto;
        fVar.field_sourceCreateTime = this.field_sourceCreateTime;
        fVar.field_updateSeq = this.field_updateSeq;
        fVar.field_toUser = this.field_toUser;
        fVar.field_updateTime = this.field_updateTime;
        fVar.field_type = this.field_type;
        fVar.field_xml = this.field_xml;
        fVar.field_datatotalsize = this.field_datatotalsize;
        return fVar;
    }

    public final boolean aHR() {
        Iterator it = this.field_favProto.weU.iterator();
        while (it.hasNext()) {
            if (((uq) it.next()).wdV != 0) {
                return true;
            }
        }
        return false;
    }
}
