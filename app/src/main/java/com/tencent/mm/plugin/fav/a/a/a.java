package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class a {
    public static String aG(List<uq> list) {
        if (list == null || list.size() == 0) {
            x.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
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
                stringBuffer.append(" htmlid='").append(bh.VG(uqVar.wdL)).append("'");
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
                stringBuffer.append("<cdn_thumburl>").append(bh.VG(uqVar.hbj)).append("</cdn_thumburl>");
            }
            if (uqVar.wcH) {
                stringBuffer.append("<thumb_width>").append(uqVar.hbo).append("</thumb_width>");
            }
            if (uqVar.wcI) {
                stringBuffer.append("<thumb_height>").append(uqVar.hbn).append("</thumb_height>");
            }
            if (uqVar.wcK) {
                stringBuffer.append("<cdn_dataurl>").append(bh.VG(uqVar.wcJ)).append("</cdn_dataurl>");
            }
            if (uqVar.wcG) {
                stringBuffer.append("<cdn_thumbkey>").append(bh.VG(uqVar.wcF)).append("</cdn_thumbkey>");
            }
            if (uqVar.wcM) {
                stringBuffer.append("<cdn_datakey>").append(bh.VG(uqVar.wcL)).append("</cdn_datakey>");
            }
            if (uqVar.wcO) {
                stringBuffer.append("<cdn_encryver>").append(uqVar.wcN).append("</cdn_encryver>");
            }
            if (uqVar.wcP) {
                stringBuffer.append("<duration>").append(uqVar.duration).append("</duration>");
            }
            if (uqVar.wcR) {
                stringBuffer.append("<stream_weburl>").append(bh.VG(uqVar.wcQ)).append("</stream_weburl>");
            }
            if (uqVar.wcT) {
                stringBuffer.append("<stream_dataurl>").append(bh.VG(uqVar.wcS)).append("</stream_dataurl>");
            }
            if (uqVar.wcV) {
                stringBuffer.append("<stream_lowbandurl>").append(bh.VG(uqVar.wcU)).append("</stream_lowbandurl>");
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
                stringBuffer.append("<fullsize>").append(uqVar.wde).append("</fullsize>");
            }
            if (uqVar.wdm) {
                stringBuffer.append("<thumbfullmd5>").append(uqVar.wdl).append("</thumbfullmd5>");
            }
            if (uqVar.wdo) {
                stringBuffer.append("<thumbhead256md5>").append(uqVar.wdn).append("</thumbhead256md5>");
            }
            if (uqVar.wdq) {
                stringBuffer.append("<thumbfullsize>").append(uqVar.wdp).append("</thumbfullsize>");
            }
            if (uqVar.wdu) {
                stringBuffer.append("<stream_videoid>").append(bh.VG(uqVar.wdt)).append("</stream_videoid>");
            }
            if (uqVar.wdC) {
                stringBuffer.append("<datasrctitle>").append(bh.VG(uqVar.wdB)).append("</datasrctitle>");
            }
            if (uqVar.wdG) {
                stringBuffer.append("<datasrcname>").append(bh.VG(uqVar.wdF)).append("</datasrcname>");
            }
            if (uqVar.wdI) {
                stringBuffer.append("<datasrctime>").append(bh.VG(uqVar.wdH)).append("</datasrctime>");
            }
            if (uqVar.wdO && (uqVar.wdD == null || uqVar.wdD.web == null || uqVar.wdD.web.bke() == 0)) {
                stringBuffer.append("<canvasPageXml>").append(bh.VG(uqVar.canvasPageXml)).append("</canvasPageXml>");
            }
            if (uqVar.wdN) {
                stringBuffer.append("<statextstr>").append(bh.VG(uqVar.fGG)).append("</statextstr>");
            }
            if (uqVar.wdU) {
                stringBuffer.append("<recordxml>").append(uqVar.wdT).append("</recordxml>");
            }
            ut utVar = uqVar.wdJ;
            if (utVar != null) {
                stringBuffer.append("<streamvideo>");
                stringBuffer.append("<streamvideourl>").append(bh.VG(utVar.hdo)).append("</streamvideourl>");
                stringBuffer.append("<streamvideototaltime>").append(utVar.weC).append("</streamvideototaltime>");
                stringBuffer.append("<streamvideotitle>").append(bh.VG(utVar.hdq)).append("</streamvideotitle>");
                stringBuffer.append("<streamvideowording>").append(bh.VG(utVar.hdr)).append("</streamvideowording>");
                stringBuffer.append("<streamvideoweburl>").append(bh.VG(utVar.hds)).append("</streamvideoweburl>");
                stringBuffer.append("<streamvideoaduxinfo>").append(bh.VG(utVar.hdu)).append("</streamvideoaduxinfo>");
                stringBuffer.append("<streamvideopublishid>").append(bh.VG(utVar.hdv)).append("</streamvideopublishid>");
                stringBuffer.append("</streamvideo>");
            }
            ur urVar = uqVar.wdD;
            if (urVar == null || urVar.wdX == null || urVar.wdX.bke() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
            } else {
                us usVar = urVar.wdX;
                stringBuffer.append("<dataitemsource");
                if (usVar.weo) {
                    stringBuffer.append(" sourcetype='").append(usVar.fqd).append("'");
                }
                if (usVar.wes) {
                    stringBuffer.append(" sourceid='").append(usVar.wer).append("'");
                }
                stringBuffer.append(">");
                if (usVar.wep) {
                    stringBuffer.append("<fromusr>").append(bh.VG(usVar.fzO)).append("</fromusr>");
                }
                if (usVar.weq) {
                    stringBuffer.append("<tousr>").append(bh.VG(usVar.toUser)).append("</tousr>");
                }
                if (usVar.weu) {
                    stringBuffer.append("<realchatname>").append(bh.VG(usVar.wet)).append("</realchatname>");
                }
                if (usVar.wev) {
                    stringBuffer.append("<msgid>").append(usVar.fDJ).append("</msgid>");
                }
                if (usVar.wew) {
                    stringBuffer.append("<eventid>").append(usVar.fIR).append("</eventid>");
                }
                if (usVar.wex) {
                    stringBuffer.append("<appid>").append(usVar.appId).append("</appid>");
                }
                if (usVar.wey) {
                    stringBuffer.append("<link>").append(bh.VG(usVar.hOf)).append("</link>");
                }
                if (usVar.weB) {
                    stringBuffer.append("<brandid>").append(bh.VG(usVar.fnl)).append("</brandid>");
                }
                stringBuffer.append("</dataitemsource>");
            }
            urVar = uqVar.wdD;
            if (urVar == null || urVar.wdZ == null || urVar.wdZ.bke() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
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
                x.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
            } else {
                vt vtVar = urVar.web;
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
                    stringBuffer.append("<canvasPageXml>").append(bh.VG(vtVar.canvasPageXml)).append("</canvasPageXml>");
                }
                stringBuffer.append("</weburlitem>");
            }
            urVar = uqVar.wdD;
            if (urVar == null || urVar.wed == null || urVar.wed.bke() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                vd vdVar = urVar.wed;
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
            }
            ur urVar2 = uqVar.wdD;
            if (urVar2 == null || urVar2.wef == null || urVar2.wef.bke() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                vn vnVar = urVar2.wef;
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
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        return stringBuffer.toString();
    }
}
