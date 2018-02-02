package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.Random;

class e$26 extends c<ea> {
    final /* synthetic */ e lLO;

    e$26(e eVar) {
        this.lLO = eVar;
        this.xen = ea.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ea eaVar = (ea) bVar;
        e eVar = this.lLO;
        eaVar = eaVar;
        if (bh.ov(eaVar.fsD.frg) || bh.ov(eaVar.fsD.ffq)) {
            eaVar.fsE.fsH = false;
        } else {
            String str;
            Boolean valueOf;
            int i;
            ea.b bVar2 = eaVar.fsE;
            g gVar = eVar.lLK;
            String str2 = eaVar.fsD.frg;
            String str3 = eaVar.fsD.ffq;
            String str4 = eaVar.fsD.fsF;
            long j = eaVar.fsD.fqm;
            String str5 = eaVar.fsD.frH;
            boolean z = eaVar.fsD.fsG;
            gVar.gAc = j;
            gVar.lLU = false;
            gVar.lLV = z;
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "deviceType: %s, deviceId: %s", new Object[]{str2, str3});
            int i2 = 0;
            if (str4 == null || !str4.contains("wechat_to_device") || gVar.lMj.get(str3) == null) {
                if (str4 != null && str4.contains("internet_to_device")) {
                    i2 = 1;
                    if (!z && (g.cp(j).booleanValue() || g.co(j).booleanValue() || g.cr(j).booleanValue() || g.cq(j).booleanValue())) {
                        str4 = "MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice";
                        str5 = "mDeviceMsgForUseCdn %s deviceId %s deviceType %s";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(gVar.lMf == null);
                        objArr[1] = str3;
                        objArr[2] = str2;
                        x.d(str4, str5, objArr);
                        if (gVar.lMf != null) {
                            ar.CG().a(new n(gVar.lMf, str2, str3, 1), 0);
                        } else {
                            gVar.lMe.put(str3, str2);
                            if (!gVar.lMd) {
                                Object obj;
                                str4 = "";
                                str = "";
                                gVar.lMc = true;
                                ar.Hg();
                                cf dH = com.tencent.mm.z.c.Fa().dH(j);
                                Object[] objArr2;
                                i iVar;
                                if (g.cp(j).booleanValue()) {
                                    e n = o.Pw().n(dH);
                                    str4 = o.Pw().m(n.hzQ, "", "");
                                    str = o.Pw().m(n.hzS, "", "");
                                    gVar.gLP = n.hzP;
                                    if (bh.ov(gVar.hBn)) {
                                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[]{Long.valueOf(dH.field_createTime), dH.field_talker, Long.valueOf(dH.field_msgId), Long.valueOf(gVar.gLP), Integer.valueOf(0)});
                                        gVar.hBn = d.a("upimg", dH.field_createTime, dH.field_talker, dH.field_msgId + "_" + gVar.gLP + "_0");
                                    }
                                    g.MJ();
                                    if (!com.tencent.mm.modelcdntran.c.hu(1) && bh.ov(n.hAa)) {
                                        objArr2 = new Object[2];
                                        g.MJ();
                                        objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hu(1));
                                        objArr2[1] = n.hAa;
                                        x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%s", objArr2);
                                        obj = null;
                                    }
                                    if (g.cp(j).booleanValue() || g.cq(j).booleanValue()) {
                                        gVar.lMg = new Random().nextLong();
                                        str4 = g.w(str4, gVar.lMg);
                                        str = g.w(str, gVar.lMg);
                                    }
                                    iVar = new i();
                                    iVar.htt = gVar.hBx;
                                    iVar.field_mediaId = gVar.hBn;
                                    iVar.field_fullpath = str4;
                                    iVar.field_thumbpath = str;
                                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrS;
                                    iVar.field_talker = dH.field_talker;
                                    iVar.field_priority = com.tencent.mm.modelcdntran.b.hrJ;
                                    iVar.field_needStorage = false;
                                    iVar.field_isStreamMedia = false;
                                    iVar.field_appType = 202;
                                    iVar.field_bzScene = 2;
                                    if (!g.co(j).booleanValue()) {
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrS;
                                        iVar.field_appType = 202;
                                    } else if (g.cr(j).booleanValue()) {
                                        iVar.field_appType = 102;
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrO;
                                        iVar.field_bzScene = 1;
                                    }
                                    if (g.MJ().c(iVar)) {
                                        obj = 1;
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 205, 1, false);
                                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.hBn});
                                        gVar.hBn = "";
                                        obj = null;
                                    }
                                } else if (g.co(j).booleanValue() || g.cq(j).booleanValue()) {
                                    com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(a.fT(dH.field_content).fny);
                                    if (Rz != null) {
                                        str4 = Rz.field_fileFullPath;
                                        g.MJ();
                                        if (com.tencent.mm.modelcdntran.c.hu(4) || Rz.field_isUseCdn == 1) {
                                            if (!bh.ov(dH.field_imgPath)) {
                                                str = o.Pw().lm(dH.field_imgPath);
                                            }
                                            int bN = com.tencent.mm.a.e.bN(str);
                                            int bN2 = com.tencent.mm.a.e.bN(Rz.field_fileFullPath);
                                            if (bN >= com.tencent.mm.modelcdntran.b.hsf) {
                                                x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[]{str, Integer.valueOf(bN)});
                                                obj = null;
                                            } else {
                                                gVar.hBn = d.a("upattach", Rz.field_createTime, dH.field_talker, new StringBuilder("0").toString());
                                                if (bh.ov(gVar.hBn)) {
                                                    x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn compressType:%d", new Object[]{Integer.valueOf(0)});
                                                    obj = null;
                                                } else {
                                                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", new Object[]{Long.valueOf(Rz.field_msgInfoId), Rz.field_fileFullPath, Integer.valueOf(bN2), str, Integer.valueOf(bN)});
                                                    gVar.lMg = new Random().nextLong();
                                                    str4 = g.w(str4, gVar.lMg);
                                                    str = g.w(str, gVar.lMg);
                                                    iVar = new i();
                                                    iVar.htt = gVar.hBx;
                                                    iVar.field_mediaId = gVar.hBn;
                                                    iVar.field_fullpath = str4;
                                                    iVar.field_thumbpath = str;
                                                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrS;
                                                    iVar.field_talker = dH.field_talker;
                                                    iVar.field_priority = com.tencent.mm.modelcdntran.b.hrJ;
                                                    iVar.field_needStorage = false;
                                                    iVar.field_isStreamMedia = false;
                                                    iVar.field_appType = 202;
                                                    iVar.field_bzScene = 2;
                                                    if (!g.co(j).booleanValue()) {
                                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrS;
                                                        iVar.field_appType = 202;
                                                    } else if (g.cr(j).booleanValue()) {
                                                        iVar.field_appType = 102;
                                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrO;
                                                        iVar.field_bzScene = 1;
                                                    }
                                                    if (g.MJ().c(iVar)) {
                                                        obj = 1;
                                                    } else {
                                                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 205, 1, false);
                                                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.hBn});
                                                        gVar.hBn = "";
                                                        obj = null;
                                                    }
                                                }
                                            }
                                        } else {
                                            objArr2 = new Object[2];
                                            g.MJ();
                                            objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hu(4));
                                            objArr2[1] = Integer.valueOf(Rz.field_isUseCdn);
                                            x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", objArr2);
                                            obj = null;
                                        }
                                    } else {
                                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                                        obj = null;
                                    }
                                } else {
                                    if (g.cr(j).booleanValue()) {
                                        r nr = com.tencent.mm.modelvideo.o.TU().nr(dH.field_imgPath);
                                        if (nr == null) {
                                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Get info Failed file:" + dH.field_imgPath);
                                            obj = null;
                                        } else {
                                            g.MJ();
                                            if (com.tencent.mm.modelcdntran.c.hu(2) || nr.hVM == 1) {
                                                gVar.hBn = d.a("upvideo", nr.hVE, nr.Ud(), nr.getFileName());
                                                if (bh.ov(gVar.hBn)) {
                                                    x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn file:%s", new Object[]{nr.getFileName()});
                                                    obj = null;
                                                } else {
                                                    com.tencent.mm.modelvideo.o.TU();
                                                    str = s.nu(dH.field_imgPath);
                                                    com.tencent.mm.modelvideo.o.TU();
                                                    str4 = s.nt(dH.field_imgPath);
                                                }
                                            } else {
                                                r5 = new Object[2];
                                                g.MJ();
                                                r5[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hu(2));
                                                r5[1] = Integer.valueOf(nr.hVM);
                                                x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", r5);
                                                obj = null;
                                            }
                                        }
                                    }
                                    gVar.lMg = new Random().nextLong();
                                    str4 = g.w(str4, gVar.lMg);
                                    str = g.w(str, gVar.lMg);
                                    iVar = new i();
                                    iVar.htt = gVar.hBx;
                                    iVar.field_mediaId = gVar.hBn;
                                    iVar.field_fullpath = str4;
                                    iVar.field_thumbpath = str;
                                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrS;
                                    iVar.field_talker = dH.field_talker;
                                    iVar.field_priority = com.tencent.mm.modelcdntran.b.hrJ;
                                    iVar.field_needStorage = false;
                                    iVar.field_isStreamMedia = false;
                                    iVar.field_appType = 202;
                                    iVar.field_bzScene = 2;
                                    if (!g.co(j).booleanValue()) {
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrS;
                                        iVar.field_appType = 202;
                                    } else if (g.cr(j).booleanValue()) {
                                        iVar.field_appType = 102;
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrO;
                                        iVar.field_bzScene = 1;
                                    }
                                    if (g.MJ().c(iVar)) {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 205, 1, false);
                                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.hBn});
                                        gVar.hBn = "";
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                }
                                if (obj == null) {
                                    g.cm(str3, gVar.lMa);
                                    gVar.lMd = false;
                                } else {
                                    gVar.lMd = true;
                                }
                            }
                        }
                        valueOf = Boolean.valueOf(true);
                        bVar2.fsH = valueOf.booleanValue();
                    }
                }
                i = i2;
            } else {
                i = 0;
            }
            akl com_tencent_mm_protocal_c_akl = new akl();
            if (!z) {
                gVar.a(com_tencent_mm_protocal_c_akl, gVar.gAc);
            } else if (gVar.aDZ().wQo.vYc != 1 || i != 0 || gVar.lLX != null) {
                if (str5 != null) {
                    bnp aDZ = gVar.aDZ();
                    switch (aDZ.wQo.vYc) {
                        case 1:
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns photo!");
                            int i3 = -1;
                            String str6 = null;
                            String str7 = null;
                            str = null;
                            String str8 = gVar.lLX;
                            if (str8 != null && str8.length() > 0) {
                                File file = new File(str8);
                                str7 = file.getName();
                                i3 = (int) file.length();
                                str = str7.substring(str7.lastIndexOf(".") + 1, str7.length());
                                str6 = com.tencent.mm.a.g.i(file);
                                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "dataSnsInit filePath %s, fileSize %s, fileMd5 %s", new Object[]{str8, Integer.valueOf(i3), str6});
                            }
                            akm com_tencent_mm_protocal_c_akm = new akm();
                            com_tencent_mm_protocal_c_akm.waP = str;
                            com_tencent_mm_protocal_c_akm.nfp = str7;
                            com_tencent_mm_protocal_c_akm.ktH = i3;
                            com_tencent_mm_protocal_c_akm.vZL = str6;
                            if (i == 1) {
                                r2 = (aqr) aDZ.wQo.vYd.get(gVar.lLY);
                                if (r2 == null) {
                                    x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                                    break;
                                }
                                com_tencent_mm_protocal_c_akm.nfX = r2.nfX;
                                com_tencent_mm_protocal_c_akm.wrL = r2.wxV;
                                if (!bh.ov(com_tencent_mm_protocal_c_akm.wrL)) {
                                    com_tencent_mm_protocal_c_akm.nfX += "?idx=" + r2.wxU + "&token=" + r2.wxT;
                                }
                            }
                            com_tencent_mm_protocal_c_akl.wrH = com_tencent_mm_protocal_c_akm;
                            com_tencent_mm_protocal_c_akl.wrE = 3;
                            break;
                        case 3:
                            r2 = (aqr) aDZ.wQo.vYd.get(0);
                            if (r2 != null) {
                                gVar.lLU = true;
                                akp com_tencent_mm_protocal_c_akp = new akp();
                                com_tencent_mm_protocal_c_akp.nfX = r2.nfX;
                                com_tencent_mm_protocal_c_akp.fon = r2.fon;
                                com_tencent_mm_protocal_c_akp.wrO = r2.nfe;
                                com_tencent_mm_protocal_c_akl.wrJ = com_tencent_mm_protocal_c_akp;
                                com_tencent_mm_protocal_c_akl.wrE = 5;
                                break;
                            }
                            x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObUrl is null");
                            break;
                        case 4:
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns music!");
                            r2 = (aqr) aDZ.wQo.vYd.get(0);
                            if (r2 != null) {
                                gVar.lLU = true;
                                ako com_tencent_mm_protocal_c_ako = new ako();
                                com_tencent_mm_protocal_c_ako.fon = r2.fon;
                                com_tencent_mm_protocal_c_ako.wrO = r2.nfe;
                                com_tencent_mm_protocal_c_ako.nfX = aDZ.wQo.nfX;
                                com_tencent_mm_protocal_c_ako.vWd = r2.nfX;
                                com_tencent_mm_protocal_c_ako.wrQ = r2.wxI;
                                com_tencent_mm_protocal_c_ako.niZ = aDZ.wQn.niZ;
                                com_tencent_mm_protocal_c_akl.wrF = com_tencent_mm_protocal_c_ako;
                                com_tencent_mm_protocal_c_akl.wrE = 1;
                                break;
                            }
                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObj is null");
                            break;
                        case 15:
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns sight!");
                            r2 = (aqr) aDZ.wQo.vYd.get(0);
                            if (r2 != null) {
                                gVar.lLU = true;
                                akq com_tencent_mm_protocal_c_akq = new akq();
                                com_tencent_mm_protocal_c_akq.nfX = r2.nfX;
                                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "videoMsg.url = %s", new Object[]{com_tencent_mm_protocal_c_akq.nfX});
                                com_tencent_mm_protocal_c_akl.wrK = com_tencent_mm_protocal_c_akq;
                                com_tencent_mm_protocal_c_akl.wrE = 6;
                                break;
                            }
                            x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjSight is null");
                            break;
                    }
                }
            } else {
                gVar.lMr = com_tencent_mm_protocal_c_akl;
                gVar.lMs = str2;
                gVar.lMt = str3;
                gVar.lMu = 0;
                r2 = (aqr) gVar.aDZ().wQo.vYd.get(gVar.lLY);
                if (r2 == null) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                    g.cm(str3, gVar.lMa);
                } else {
                    gVar.fzT = r2.nfX;
                    com.tencent.mm.sdk.f.e.post(gVar.lMq, "ExdeviceDownloadImage");
                }
                valueOf = Boolean.valueOf(true);
                bVar2.fsH = valueOf.booleanValue();
            }
            ar.CG().a(new n(com_tencent_mm_protocal_c_akl, str2, str3, i), 0);
            valueOf = Boolean.valueOf(true);
            bVar2.fsH = valueOf.booleanValue();
        }
        return true;
    }
}
