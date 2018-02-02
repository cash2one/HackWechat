package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static void a(String str, ve veVar) {
        veVar.weU.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map y;
                        Node item = childNodes.item(i);
                        String b = bi.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = bi.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            y = bi.y(b, "dataitem");
                        } else {
                            y = null;
                        }
                        if (y != null) {
                            uq uqVar = new uq();
                            String str3 = ".dataitem";
                            uqVar.CJ(bh.getInt((String) y.get(str3 + ".$datatype"), 0));
                            uqVar.TI((String) y.get(str3 + ".$datasourceid"));
                            uqVar.CK(bh.getInt((String) y.get(str3 + ".$datastatus"), 0));
                            uqVar.TA((String) y.get(str3 + ".datafmt"));
                            uqVar.Tq((String) y.get(str3 + ".datatitle"));
                            uqVar.Tr((String) y.get(str3 + ".datadesc"));
                            uqVar.Ts((String) y.get(str3 + ".cdn_thumburl"));
                            uqVar.Tt((String) y.get(str3 + ".cdn_thumbkey"));
                            uqVar.CG(bh.getInt((String) y.get(str3 + ".thumb_width"), 0));
                            uqVar.CH(bh.getInt((String) y.get(str3 + ".thumb_height"), 0));
                            uqVar.Tu((String) y.get(str3 + ".cdn_dataurl"));
                            uqVar.Tv((String) y.get(str3 + ".cdn_datakey"));
                            String str4 = (String) y.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                uqVar.CI(bh.getInt(str4, 0));
                            }
                            uqVar.Tx((String) y.get(str3 + ".stream_dataurl"));
                            uqVar.Ty((String) y.get(str3 + ".stream_lowbandurl"));
                            uqVar.Tw((String) y.get(str3 + ".stream_weburl"));
                            uqVar.TP((String) y.get(str3 + ".canvasPageXml"));
                            uqVar.TB((String) y.get(str3 + ".fullmd5"));
                            uqVar.TC((String) y.get(str3 + ".head256md5"));
                            str4 = (String) y.get(str3 + ".fullsize");
                            if (!bh.ov(str4)) {
                                uqVar.fw((long) bh.getInt(str4, 0));
                            }
                            uqVar.Tz((String) y.get(str3 + ".dataext"));
                            uqVar.TG((String) y.get(str3 + ".thumbfullmd5"));
                            uqVar.TH((String) y.get(str3 + ".thumbhead256md5"));
                            str4 = (String) y.get(str3 + ".thumbfullsize");
                            if (!bh.ov(str4)) {
                                uqVar.fx((long) bh.getInt(str4, 0));
                            }
                            uqVar.TJ((String) y.get(str3 + ".stream_videoid"));
                            str4 = (String) y.get(str3 + ".$dataid");
                            if (bh.ov(str4) || str4.length() < 32) {
                                str4 = uqVar.toString();
                                str4 = g.s((str4 + uqVar.bjS + System.currentTimeMillis()).getBytes());
                            }
                            uqVar.TD(str4);
                            uqVar.TK((String) y.get(str3 + ".datasrctitle"));
                            uqVar.TL((String) y.get(str3 + ".datasrcname"));
                            uqVar.TM((String) y.get(str3 + ".datasrctime"));
                            uqVar.TO((String) y.get(str3 + ".statextstr"));
                            uqVar.TN((String) y.get(str3 + ".$htmlid"));
                            uqVar.CL(bh.getInt((String) y.get(str3 + ".$dataillegaltype"), 0));
                            if (str2 != null) {
                                uqVar.TQ(str2);
                            }
                            ut utVar = new ut();
                            utVar.hdo = bh.az((String) y.get(str3 + ".streamvideo.streamvideourl"), "");
                            utVar.weC = bh.VI((String) y.get(str3 + ".streamvideo.streamvideototaltime"));
                            utVar.hdq = bh.az((String) y.get(str3 + ".streamvideo.streamvideotitle"), "");
                            utVar.hdr = bh.az((String) y.get(str3 + ".streamvideo.streamvideowording"), "");
                            utVar.hds = bh.az((String) y.get(str3 + ".streamvideo.streamvideoweburl"), "");
                            utVar.hdu = bh.az((String) y.get(str3 + ".streamvideo.streamvideoaduxinfo"), "");
                            utVar.hdv = bh.az((String) y.get(str3 + ".streamvideo.streamvideopublishid"), "");
                            uqVar.a(utVar);
                            ur urVar = new ur();
                            String str5 = str3 + ".dataitemsource";
                            if (y.containsKey(str5)) {
                                us usVar = new us();
                                usVar.CN(bh.getInt((String) y.get(str5 + ".$sourcetype"), 0));
                                usVar.TT((String) y.get(str5 + ".$sourceid"));
                                usVar.TR((String) y.get(str5 + ".fromusr"));
                                usVar.TS((String) y.get(str5 + ".tousr"));
                                usVar.TU((String) y.get(str5 + ".realchatname"));
                                usVar.fz(bh.getLong((String) y.get(str5 + ".createtime"), 0));
                                usVar.TV((String) y.get(str5 + ".msgid"));
                                usVar.fIR = (String) y.get(str5 + ".eventid");
                                usVar.wew = true;
                                usVar.TW((String) y.get(str5 + ".appid"));
                                usVar.TX((String) y.get(str5 + ".link"));
                                usVar.TY((String) y.get(str5 + ".brandid"));
                                urVar.c(usVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".locitem";
                            if (y.containsKey(str5)) {
                                ux uxVar = new ux();
                                if (!bh.ov((String) y.get(str5 + ".label"))) {
                                    uxVar.TZ((String) y.get(str5 + ".label"));
                                }
                                if (!bh.ov((String) y.get(str5 + ".poiname"))) {
                                    uxVar.Ua((String) y.get(str5 + ".poiname"));
                                }
                                str4 = (String) y.get(str5 + ".lng");
                                if (!bh.ov(str4)) {
                                    uxVar.r(bh.getDouble(str4, 0.0d));
                                }
                                str4 = (String) y.get(str5 + ".lat");
                                if (!bh.ov(str4)) {
                                    uxVar.s(bh.getDouble(str4, 0.0d));
                                }
                                str4 = (String) y.get(str5 + ".scale");
                                if (!bh.ov(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        uxVar.CO(bh.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        uxVar.CO(bh.getInt(str4, -1));
                                    }
                                }
                                urVar.a(uxVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".weburlitem";
                            if (y.containsKey(str5)) {
                                vt vtVar = new vt();
                                vtVar.Ux((String) y.get(str5 + ".clean_url"));
                                vtVar.Uw((String) y.get(str5 + ".pagedesc"));
                                vtVar.Uy((String) y.get(str5 + ".pagethumb_url"));
                                vtVar.Uv((String) y.get(str5 + ".pagetitle"));
                                vtVar.CT(bh.getInt((String) y.get(str5 + ".opencache"), 0));
                                vtVar.CU(bh.getInt((String) y.get(str5 + ".contentattr"), 0));
                                vtVar.Uz((String) y.get(str5 + ".canvasPageXml"));
                                urVar.a(vtVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".productitem";
                            if (y.containsKey(str5)) {
                                vd vdVar = new vd();
                                vdVar.Ub((String) y.get(str5 + ".producttitle"));
                                vdVar.Uc((String) y.get(str5 + ".productdesc"));
                                vdVar.Ud((String) y.get(str5 + ".productthumb_url"));
                                vdVar.Ue((String) y.get(str5 + ".productinfo"));
                                vdVar.CP(bh.getInt((String) y.get(str5 + ".$type"), 0));
                                urVar.a(vdVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str3 = str3 + ".tvitem";
                            if (y.containsKey(str3)) {
                                vn vnVar = new vn();
                                vnVar.Ur((String) y.get(str3 + ".tvtitle"));
                                vnVar.Us((String) y.get(str3 + ".tvdesc"));
                                vnVar.Ut((String) y.get(str3 + ".tvthumb_url"));
                                vnVar.Uu((String) y.get(str3 + ".tvinfo"));
                                urVar.a(vnVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str3});
                            }
                            uqVar.a(urVar);
                            veVar.weU.add(uqVar);
                        }
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
        }
    }
}
