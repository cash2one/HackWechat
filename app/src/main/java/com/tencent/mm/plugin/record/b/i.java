package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ag.a.e;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;
import java.util.List;

public final class i {
    public static String aG(List<uq> list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
            return "";
        }
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datalist count='").append(size).append("'>");
        for (int i = 0; i < size; i++) {
            uq uqVar = (uq) list.get(i);
            stringBuffer.append("<dataitem ");
            if (uqVar.wcX) {
                stringBuffer.append("datatype='").append(uqVar.bjS).append("'");
            }
            if (uqVar.wdA) {
                stringBuffer.append(" datastatus='").append(uqVar.wdz).append("'");
            }
            if (uqVar.wdg) {
                stringBuffer.append(" dataid='").append(uqVar.mvG).append("'");
            }
            if (uqVar.wdM) {
                stringBuffer.append(" htmlid='").append(uqVar.wdL).append("'");
            }
            if (uqVar.wdS) {
                stringBuffer.append(" dataillegaltype='").append(uqVar.wdR).append("'");
            }
            if (uqVar.wds) {
                stringBuffer.append(" datasourceid='").append(uqVar.wdr).append("'");
            }
            stringBuffer.append(">");
            if (uqVar.wcZ) {
                stringBuffer.append("<datafmt>").append(uqVar.wcY).append("</datafmt>");
            }
            if (uqVar.wcC) {
                stringBuffer.append("<datatitle>").append(bh.VG(uqVar.title)).append("</datatitle>");
            }
            if (uqVar.wcD) {
                stringBuffer.append("<datadesc>").append(bh.VG(uqVar.desc)).append("</datadesc>");
            }
            if (uqVar.wcE) {
                stringBuffer.append("<cdnthumburl>").append(bh.VG(uqVar.hbj)).append("</cdnthumburl>");
            }
            if (uqVar.wcH) {
                stringBuffer.append("<thumbwidth>").append(uqVar.hbo).append("</thumbwidth>");
            }
            if (uqVar.wcI) {
                stringBuffer.append("<thumbheight>").append(uqVar.hbn).append("</thumbheight>");
            }
            if (uqVar.wcK) {
                stringBuffer.append("<cdndataurl>").append(bh.VG(uqVar.wcJ)).append("</cdndataurl>");
            }
            if (uqVar.wcG) {
                stringBuffer.append("<cdnthumbkey>").append(bh.VG(uqVar.wcF)).append("</cdnthumbkey>");
            }
            if (uqVar.wcM) {
                stringBuffer.append("<cdndatakey>").append(bh.VG(uqVar.wcL)).append("</cdndatakey>");
            }
            if (uqVar.wcO) {
                stringBuffer.append("<cdnencryver>").append(uqVar.wcN).append("</cdnencryver>");
            }
            if (uqVar.wcP) {
                stringBuffer.append("<duration>").append(uqVar.duration).append("</duration>");
            }
            if (uqVar.wcR) {
                stringBuffer.append("<streamweburl>").append(bh.VG(uqVar.wcQ)).append("</streamweburl>");
            }
            if (uqVar.wcT) {
                stringBuffer.append("<streamdataurl>").append(bh.VG(uqVar.wcS)).append("</streamdataurl>");
            }
            if (uqVar.wcV) {
                stringBuffer.append("<streamlowbandurl>").append(bh.VG(uqVar.wcU)).append("</streamlowbandurl>");
            }
            if (uqVar.wcW) {
                stringBuffer.append("<dataext>").append(bh.VG(uqVar.fqf)).append("</dataext>");
            }
            if (uqVar.wdb) {
                stringBuffer.append("<fullmd5>").append(uqVar.wda).append("</fullmd5>");
            }
            if (uqVar.wdd) {
                stringBuffer.append("<head256md5>").append(uqVar.wdc).append("</head256md5>");
            }
            if (uqVar.wdf) {
                stringBuffer.append("<datasize>").append(uqVar.wde).append("</datasize>");
            }
            if (uqVar.wdm) {
                stringBuffer.append("<thumbfullmd5>").append(uqVar.wdl).append("</thumbfullmd5>");
            }
            if (uqVar.wdo) {
                stringBuffer.append("<thumbhead256md5>").append(uqVar.wdn).append("</thumbhead256md5>");
            }
            if (uqVar.wdq) {
                stringBuffer.append("<thumbsize>").append(uqVar.wdp).append("</thumbsize>");
            }
            if (uqVar.wdu) {
                stringBuffer.append("<streamvideoid>").append(bh.VG(uqVar.wdt)).append("</streamvideoid>");
            }
            if (uqVar.wdC) {
                stringBuffer.append("<sourcetitle>").append(bh.VG(uqVar.wdB)).append("</sourcetitle>");
            }
            if (uqVar.wdG) {
                stringBuffer.append("<sourcename>").append(bh.VG(uqVar.wdF)).append("</sourcename>");
            }
            if (uqVar.wdI) {
                stringBuffer.append("<sourcetime>").append(bh.VG(uqVar.wdH)).append("</sourcetime>");
            }
            if (uqVar.wdN) {
                stringBuffer.append("<statextstr>").append(bh.VG(uqVar.fGG)).append("</statextstr>");
            }
            if (uqVar.wdU) {
                stringBuffer.append("<recordxml>").append(uqVar.wdT).append("</recordxml>");
            }
            ur urVar = uqVar.wdD;
            if (urVar == null || urVar.wdX == null || urVar.wdX.bke() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
            } else {
                us usVar = urVar.wdX;
                if (usVar.wex) {
                    stringBuffer.append("<appid>").append(usVar.appId).append("</appid>");
                }
                if (usVar.wey) {
                    stringBuffer.append("<link>").append(bh.VG(usVar.hOf)).append("</link>");
                }
                if (usVar.weB) {
                    stringBuffer.append("<brandid>").append(bh.VG(usVar.fnl)).append("</brandid>");
                }
                if (usVar.wep && usVar.weu) {
                    if (usVar.fzO.equals(usVar.wet)) {
                        stringBuffer.append("<dataitemsource><fromusr>").append(bh.VG(usVar.fzO)).append("</fromusr></dataitemsource>");
                    } else if (s.eV(usVar.fzO) || e.km(usVar.wet)) {
                        stringBuffer.append("<dataitemsource><realchatname>").append(bh.VG(usVar.wet)).append("</realchatname></dataitemsource>");
                    }
                } else if (usVar.wep) {
                    stringBuffer.append("<dataitemsource><fromusr>").append(bh.VG(usVar.fzO)).append("</fromusr></dataitemsource>");
                } else if (usVar.weu) {
                    stringBuffer.append("<dataitemsource><realchatname>").append(bh.VG(usVar.wet)).append("</realchatname></dataitemsource>");
                }
            }
            urVar = uqVar.wdD;
            if (urVar == null || urVar.wdZ == null || urVar.wdZ.bke() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
            } else {
                ux uxVar = urVar.wdZ;
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
            }
            urVar = uqVar.wdD;
            if (urVar == null || urVar.web == null || urVar.web.bke() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
            } else {
                vt vtVar = urVar.web;
                stringBuffer.append("<weburlitem>");
                if (vtVar.wfA) {
                    stringBuffer.append("<link>").append(bh.VG(vtVar.wfz)).append("</link>");
                }
                if (vtVar.wcD) {
                    stringBuffer.append("<desc>").append(bh.VG(vtVar.desc)).append("</desc>");
                }
                if (vtVar.weP) {
                    stringBuffer.append("<thumburl>").append(bh.VG(vtVar.thumbUrl)).append("</thumburl>");
                }
                if (vtVar.wcC) {
                    stringBuffer.append("<title>").append(bh.VG(vtVar.title)).append("</title>");
                }
                if (vtVar.wfC) {
                    stringBuffer.append("<opencache>").append(vtVar.wfB).append("</opencache>");
                }
                if (vtVar.wfD) {
                    stringBuffer.append("<contentattr>").append(vtVar.hbg).append("</contentattr>");
                }
                stringBuffer.append("</weburlitem>");
            }
            urVar = uqVar.wdD;
            if (urVar == null || urVar.wed == null || urVar.wed.bke() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                vd vdVar = urVar.wed;
                stringBuffer.append("<productitem");
                if (vdVar.weR) {
                    stringBuffer.append(" type='").append(vdVar.type).append("'");
                }
                stringBuffer.append(">");
                if (vdVar.wcC) {
                    stringBuffer.append("<title>").append(bh.VG(vdVar.title)).append("</title>");
                }
                if (vdVar.wcD) {
                    stringBuffer.append("<desc>").append(bh.VG(vdVar.desc)).append("</desc>");
                }
                if (vdVar.weP) {
                    stringBuffer.append("<thumburl>").append(bh.VG(vdVar.thumbUrl)).append("</thumburl>");
                }
                if (vdVar.weQ) {
                    stringBuffer.append("<productinfo>").append(bh.VG(vdVar.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            ur urVar2 = uqVar.wdD;
            if (urVar2 == null || urVar2.wef == null || urVar2.wef.bke() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                vn vnVar = urVar2.wef;
                stringBuffer.append("<tvitem>");
                if (vnVar.wcC) {
                    stringBuffer.append("<title>").append(bh.VG(vnVar.title)).append("</title>");
                }
                if (vnVar.wcD) {
                    stringBuffer.append("<desc>").append(bh.VG(vnVar.desc)).append("</desc>");
                }
                if (vnVar.weP) {
                    stringBuffer.append("<thumburl>").append(bh.VG(vnVar.thumbUrl)).append("</thumburl>");
                }
                if (vnVar.weQ) {
                    stringBuffer.append("<tvinfo>").append(bh.VG(vnVar.info)).append("</tvinfo>");
                }
                stringBuffer.append("</tvitem>");
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        return stringBuffer.toString();
    }
}
