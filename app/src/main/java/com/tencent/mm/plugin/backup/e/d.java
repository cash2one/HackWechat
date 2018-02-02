package com.tencent.mm.plugin.backup.e;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.g;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class d implements l {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        int i;
        e bi;
        e eVar;
        String B;
        Object obj;
        String m;
        String a;
        if (bh.ov(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        if (auVar.field_isSend == 1) {
            bi = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().bi(auVar.field_msgId);
            if (bi.hzP != 0) {
                eVar = bi;
                B = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().B(auVar.field_imgPath, true);
                if (com.tencent.mm.a.e.bO(B)) {
                    return -1;
                }
                i += i.a(new i$a(B, erVar, (LinkedList) linkedList, 1, z, "_thumb", z2));
                if (auVar.field_isSend == 1) {
                    obj = "";
                    m = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().m(eVar.hzQ, "", "");
                    if (eVar.Pe()) {
                        eVar = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().hQ(eVar.hzZ);
                        if (eVar == null) {
                            obj = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().m(eVar.hzQ, "", "");
                            x.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + obj + " " + com.tencent.mm.a.e.bN(obj));
                            com.tencent.mm.a.e.bN(obj);
                            if (com.tencent.mm.a.e.bO(obj)) {
                                x.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[]{obj});
                            } else {
                                i = i.a(new i$a((String) obj, erVar, (LinkedList) linkedList, 3, z, "_hd", z2)) + i;
                            }
                        } else {
                            x.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
                        }
                    }
                    com.tencent.mm.a.e.bN(m);
                    if (!(bh.ov(m) || m.equals(r1))) {
                        x.d("MicroMsg.BackupItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
                        i += i.a(new i$a(m, erVar, (LinkedList) linkedList, 2, z, z2, null));
                    }
                } else if (eVar.Pd()) {
                    m = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().m(eVar.hzQ, "", "");
                    obj = "";
                    if (eVar.Pe()) {
                        bi = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().hQ(eVar.hzZ);
                    }
                    bi = null;
                    if (bi != null) {
                        x.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[]{Integer.valueOf(bi.offset), Integer.valueOf(bi.hlp), Integer.valueOf(bi.hzT), bi.hzQ});
                    }
                    if (bi != null && bi.hzT == 1) {
                        if (bi.equals(eVar) && bi.offset == bi.hlp) {
                            obj = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().m(bi.hzQ, "", "");
                            x.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[]{obj, Integer.valueOf(com.tencent.mm.a.e.bN(obj))});
                            if (com.tencent.mm.a.e.bO(obj)) {
                                i += i.a(new i$a((String) obj, erVar, (LinkedList) linkedList, 3, z, "_hd", z2));
                                com.tencent.mm.a.e.bN(obj);
                            }
                        } else {
                            bi.equals(eVar);
                        }
                    }
                    if (com.tencent.mm.a.e.bO(m)) {
                        com.tencent.mm.a.e.bN(m);
                        if (!(bh.ov(m) || m.equals(r1))) {
                            x.d("MicroMsg.BackupItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
                            i += i.a(new i$a(m, erVar, (LinkedList) linkedList, 2, z, z2, null));
                        }
                    }
                }
                a = a(eVar, auVar);
                if (a == null) {
                    return i;
                }
                erVar.vGZ = new bdo().UA(a);
                return i + a.length();
            }
        }
        eVar = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().bh(auVar.field_msgSvrId);
        B = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().B(auVar.field_imgPath, true);
        if (com.tencent.mm.a.e.bO(B)) {
            return -1;
        }
        i += i.a(new i$a(B, erVar, (LinkedList) linkedList, 1, z, "_thumb", z2));
        if (auVar.field_isSend == 1) {
            obj = "";
            m = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().m(eVar.hzQ, "", "");
            if (eVar.Pe()) {
                eVar = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().hQ(eVar.hzZ);
                if (eVar == null) {
                    x.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
                } else {
                    obj = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().m(eVar.hzQ, "", "");
                    x.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + obj + " " + com.tencent.mm.a.e.bN(obj));
                    com.tencent.mm.a.e.bN(obj);
                    if (com.tencent.mm.a.e.bO(obj)) {
                        x.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[]{obj});
                    } else {
                        i = i.a(new i$a((String) obj, erVar, (LinkedList) linkedList, 3, z, "_hd", z2)) + i;
                    }
                }
            }
            com.tencent.mm.a.e.bN(m);
            x.d("MicroMsg.BackupItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
            i += i.a(new i$a(m, erVar, (LinkedList) linkedList, 2, z, z2, null));
        } else if (eVar.Pd()) {
            m = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().m(eVar.hzQ, "", "");
            obj = "";
            if (eVar.Pe()) {
                bi = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().hQ(eVar.hzZ);
            }
            bi = null;
            if (bi != null) {
                x.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[]{Integer.valueOf(bi.offset), Integer.valueOf(bi.hlp), Integer.valueOf(bi.hzT), bi.hzQ});
            }
            if (bi.equals(eVar)) {
            }
            bi.equals(eVar);
            if (com.tencent.mm.a.e.bO(m)) {
                com.tencent.mm.a.e.bN(m);
                x.d("MicroMsg.BackupItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
                i += i.a(new i$a(m, erVar, (LinkedList) linkedList, 2, z, z2, null));
            }
        }
        a = a(eVar, auVar);
        if (a == null) {
            return i;
        }
        erVar.vGZ = new bdo().UA(a);
        return i + a.length();
    }

    private static String a(e eVar, au auVar) {
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (c.eV(auVar.field_talker)) {
                stringWriter.write(ba.hP(auVar.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map y = bi.y(eVar.hAa, "msg");
            if (y != null) {
                newSerializer.attribute(null, "aeskey", ((String) y.get(".msg.img.$aeskey")));
                newSerializer.attribute(null, "encryver", ((String) y.get(".msg.img.$encryver")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) y.get(".msg.img.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnthumburl", ((String) y.get(".msg.img.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", bh.getLong((String) y.get(".msg.img.$cdnthumblength"), 10240));
                newSerializer.attribute(null, "cdnthumbheight", bh.getInt((String) y.get(".msg.img.$cdnthumbheight"), 0));
                newSerializer.attribute(null, "cdnthumbwidth", bh.getInt((String) y.get(".msg.img.$cdnthumbwidth"), 0));
                newSerializer.attribute(null, "cdnmidheight", bh.getInt((String) y.get(".msg.img.$cdnmidheight"), 0));
                newSerializer.attribute(null, "cdnmidwidth", bh.getInt((String) y.get(".msg.img.$cdnmidwidth"), 0));
                newSerializer.attribute(null, "cdnhdheight", bh.getInt((String) y.get(".msg.img.$cdnhdheight"), 0));
                newSerializer.attribute(null, "cdnhdwidth", bh.getInt((String) y.get(".msg.img.$cdnhdwidth"), 0));
                newSerializer.attribute(null, "cdnmidimgurl", ((String) y.get(".msg.img.$cdnmidimgurl")));
                long j = bh.getLong((String) y.get(".msg.img.$length"), 0);
                String str = "length";
                StringBuilder stringBuilder = new StringBuilder();
                if (j == 0) {
                    j = (long) com.tencent.mm.a.e.bN(com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().m(eVar.hzQ, "", ""));
                }
                newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                if (!(auVar.field_isSend == 1 && eVar.hzT != 1 && bh.getLong((String) y.get(".msg.img.$hdlength"), 0) == 0)) {
                    newSerializer.attribute(null, "cdnbigimgurl", ((String) y.get(".msg.img.$cdnbigimgurl")));
                    newSerializer.attribute(null, "hdlength", bh.getLong((String) y.get(".msg.img.$hdlength"), 0));
                }
                newSerializer.attribute(null, "md5", ((String) y.get(".msg.img.$md5")));
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            x.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[]{stringWriter.getBuffer().toString()});
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            x.e("MicroMsg.BackupItemImg", "packetImg xml error: " + e.toString());
            return null;
        }
    }

    public final int a(String str, er erVar, au auVar) {
        if (erVar == null || erVar.vGZ == null) {
            x.e("MicroMsg.BackupItemImg", "recover bakitem or bakitem content is null");
            return 0;
        }
        int i;
        String str2;
        e bh;
        long j;
        Object obj;
        String az;
        String str3;
        byte[] b;
        String s;
        String str4;
        File file;
        int UM;
        String m;
        String m2;
        long j2;
        int c;
        int c2;
        PString pString;
        PInt pInt;
        PInt pInt2;
        e b2;
        String str5 = new String(bh.az(erVar.vGZ.wJF, ""));
        x.d("MicroMsg.BackupItemImg", "recover msg" + erVar.vHe + " " + str5);
        String str6 = "MicroMsg.BackupItemImg";
        String str7 = "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
        Object[] objArr = new Object[4];
        if (erVar.vKf == null) {
            i = 0;
        } else {
            i = erVar.vKf.wJB;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(erVar.vKh);
        if (erVar.vKe == null) {
            str2 = "";
        } else {
            str2 = erVar.vKe.toString();
        }
        objArr[2] = str2;
        if (erVar.vKd == null) {
            str2 = "";
        } else {
            str2 = erVar.vKd.toString();
        }
        objArr[3] = str2;
        x.d(str6, str7, objArr);
        e eVar = null;
        auVar.setContent(str5);
        g aqb = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb();
        if (auVar.field_isSend == 1) {
            if (auVar.field_msgId != 0) {
                eVar = aqb.bi(auVar.field_msgId);
            }
            if (eVar == null || eVar.hzP == 0) {
                bh = aqb.bh(auVar.field_msgSvrId);
            } else {
                bh = eVar;
            }
        } else {
            bh = aqb.bh(auVar.field_msgSvrId);
        }
        Map y = bi.y(str5, "msg");
        long j3 = 0;
        if (y != null) {
            j3 = bh.getLong((String) y.get(".msg.img.$hdlength"), 0);
            if (j3 > 0) {
                j = j3;
                obj = 1;
                az = bh.az(com.tencent.mm.plugin.backup.a.g.a(erVar, 3), "");
                if (erVar.vKh == 3 && erVar.vKf != null) {
                    com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.a.g.vm(az), az, erVar.vKf.wJD.oz);
                }
                str2 = bh.az(com.tencent.mm.plugin.backup.a.g.a(erVar, 2), "");
                if (erVar.vKh == 2 && erVar.vKf != null) {
                    com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.a.g.vm(str2), str2, erVar.vKf.wJD.oz);
                }
                x.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", new Object[]{az, str2});
                if (bh.ov(str2)) {
                    str3 = str2;
                } else {
                    x.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
                    str3 = az;
                }
                b = com.tencent.mm.plugin.backup.a.g.b(erVar, 1);
                if (b != null) {
                    x.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
                    str2 = com.tencent.mm.plugin.backup.a.g.vm(str3) + str3;
                    s = com.tencent.mm.a.g.s((bh.Wp() + " ").getBytes());
                    str6 = com.tencent.mm.plugin.backup.a.g.vm(s);
                    str4 = str6 + s;
                    file = new File(str6);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    UM = com.tencent.mm.sdk.platformtools.d.UM(str4);
                    if (UM <= 0) {
                        if (!com.tencent.mm.sdk.platformtools.d.a(str2, CompressFormat.JPEG, str4, UM)) {
                            x.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
                            return -1;
                        }
                    } else if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                        x.e("MicroMsg.BackupItemImg", "createThumbNail failed");
                        return -1;
                    } else {
                        x.d("MicroMsg.BackupItemImg", "insert: thumbName = " + s);
                    }
                    b = com.tencent.mm.a.e.e(str4, 0, -1);
                } else {
                    x.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[]{Integer.valueOf(b.length)});
                }
                if (b != null) {
                    x.e("MicroMsg.BackupItemImg", "img buf is null");
                    return -1;
                }
                m = aqb.m(az, "", "");
                m2 = aqb.m(str3, "", "");
                j2 = 0;
                if (bh.hzP != 0) {
                    c = com.tencent.mm.plugin.backup.a.g.c(erVar, 2);
                    if (obj != null) {
                        g gVar = aqb;
                        str4 = az;
                        j2 = gVar.a(b, erVar.vHe, true, str4, com.tencent.mm.plugin.backup.a.g.c(erVar, 3), str5, new PString(), new PInt(), new PInt());
                        if (!com.tencent.mm.plugin.backup.a.g.b(erVar, 3, m)) {
                            x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[]{m});
                            if (((long) c) == j) {
                                if (com.tencent.mm.plugin.backup.a.g.b(erVar, 3, m2)) {
                                    x.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[]{m2});
                                } else {
                                    x.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[]{m2});
                                    j = j2;
                                    Object obj2 = null;
                                    if (c > 0) {
                                        c2 = com.tencent.mm.plugin.backup.a.g.c(erVar, 3);
                                    } else {
                                        c2 = c;
                                    }
                                    pString = new PString();
                                    pInt = new PInt();
                                    pInt2 = new PInt();
                                    j3 = aqb.a(b, erVar.vHe, false, str3, c2, str5, pString, pInt, pInt2);
                                    if (!(obj2 == null || com.tencent.mm.plugin.backup.a.g.b(erVar, 2, m2))) {
                                        x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[]{m});
                                    }
                                    if (j3 <= 0) {
                                        return -1;
                                    }
                                    auVar.dT(pString.value);
                                    auVar.fc(pInt.value);
                                    auVar.fd(pInt2.value);
                                    if (j > 0) {
                                        b2 = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().b(Long.valueOf(j3));
                                        b2.hM((int) j);
                                        com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().a(Long.valueOf(j3), b2);
                                    }
                                }
                            }
                        }
                    }
                    j = j2;
                    int i2 = 1;
                    if (c > 0) {
                        c2 = c;
                    } else {
                        c2 = com.tencent.mm.plugin.backup.a.g.c(erVar, 3);
                    }
                    pString = new PString();
                    pInt = new PInt();
                    pInt2 = new PInt();
                    j3 = aqb.a(b, erVar.vHe, false, str3, c2, str5, pString, pInt, pInt2);
                    x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[]{m});
                    if (j3 <= 0) {
                        return -1;
                    }
                    auVar.dT(pString.value);
                    auVar.fc(pInt.value);
                    auVar.fd(pInt2.value);
                    if (j > 0) {
                        b2 = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().b(Long.valueOf(j3));
                        b2.hM((int) j);
                        com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().a(Long.valueOf(j3), b2);
                    }
                } else {
                    str2 = bh.hzS;
                    if (str2 == null && str2.startsWith("THUMBNAIL_DIRPATH://")) {
                        auVar.dT(str2);
                    } else {
                        auVar.dT("THUMBNAIL://" + bh.hzP);
                    }
                }
                c.i(auVar);
                return 0;
            }
        }
        j = j3;
        obj = null;
        az = bh.az(com.tencent.mm.plugin.backup.a.g.a(erVar, 3), "");
        com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.a.g.vm(az), az, erVar.vKf.wJD.oz);
        str2 = bh.az(com.tencent.mm.plugin.backup.a.g.a(erVar, 2), "");
        com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.a.g.vm(str2), str2, erVar.vKf.wJD.oz);
        x.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", new Object[]{az, str2});
        if (bh.ov(str2)) {
            str3 = str2;
        } else {
            x.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
            str3 = az;
        }
        b = com.tencent.mm.plugin.backup.a.g.b(erVar, 1);
        if (b != null) {
            x.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[]{Integer.valueOf(b.length)});
        } else {
            x.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            str2 = com.tencent.mm.plugin.backup.a.g.vm(str3) + str3;
            s = com.tencent.mm.a.g.s((bh.Wp() + " ").getBytes());
            str6 = com.tencent.mm.plugin.backup.a.g.vm(s);
            str4 = str6 + s;
            file = new File(str6);
            if (file.exists()) {
                file.mkdirs();
            }
            UM = com.tencent.mm.sdk.platformtools.d.UM(str4);
            if (UM <= 0) {
                if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                    x.d("MicroMsg.BackupItemImg", "insert: thumbName = " + s);
                } else {
                    x.e("MicroMsg.BackupItemImg", "createThumbNail failed");
                    return -1;
                }
            } else if (com.tencent.mm.sdk.platformtools.d.a(str2, CompressFormat.JPEG, str4, UM)) {
                x.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
                return -1;
            }
            b = com.tencent.mm.a.e.e(str4, 0, -1);
        }
        if (b != null) {
            m = aqb.m(az, "", "");
            m2 = aqb.m(str3, "", "");
            j2 = 0;
            if (bh.hzP != 0) {
                str2 = bh.hzS;
                if (str2 == null) {
                }
                auVar.dT("THUMBNAIL://" + bh.hzP);
            } else {
                c = com.tencent.mm.plugin.backup.a.g.c(erVar, 2);
                if (obj != null) {
                    g gVar2 = aqb;
                    str4 = az;
                    j2 = gVar2.a(b, erVar.vHe, true, str4, com.tencent.mm.plugin.backup.a.g.c(erVar, 3), str5, new PString(), new PInt(), new PInt());
                    if (com.tencent.mm.plugin.backup.a.g.b(erVar, 3, m)) {
                        x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[]{m});
                        if (((long) c) == j) {
                            if (com.tencent.mm.plugin.backup.a.g.b(erVar, 3, m2)) {
                                x.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[]{m2});
                            } else {
                                x.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[]{m2});
                                j = j2;
                                Object obj22 = null;
                                if (c > 0) {
                                    c2 = com.tencent.mm.plugin.backup.a.g.c(erVar, 3);
                                } else {
                                    c2 = c;
                                }
                                pString = new PString();
                                pInt = new PInt();
                                pInt2 = new PInt();
                                j3 = aqb.a(b, erVar.vHe, false, str3, c2, str5, pString, pInt, pInt2);
                                x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[]{m});
                                if (j3 <= 0) {
                                    return -1;
                                }
                                auVar.dT(pString.value);
                                auVar.fc(pInt.value);
                                auVar.fd(pInt2.value);
                                if (j > 0) {
                                    b2 = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().b(Long.valueOf(j3));
                                    b2.hM((int) j);
                                    com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().a(Long.valueOf(j3), b2);
                                }
                            }
                        }
                    }
                }
                j = j2;
                int i22 = 1;
                if (c > 0) {
                    c2 = c;
                } else {
                    c2 = com.tencent.mm.plugin.backup.a.g.c(erVar, 3);
                }
                pString = new PString();
                pInt = new PInt();
                pInt2 = new PInt();
                j3 = aqb.a(b, erVar.vHe, false, str3, c2, str5, pString, pInt, pInt2);
                x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[]{m});
                if (j3 <= 0) {
                    return -1;
                }
                auVar.dT(pString.value);
                auVar.fc(pInt.value);
                auVar.fd(pInt2.value);
                if (j > 0) {
                    b2 = com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().b(Long.valueOf(j3));
                    b2.hM((int) j);
                    com.tencent.mm.plugin.backup.g.d.aqe().aqf().aqb().a(Long.valueOf(j3), b2);
                }
            }
            c.i(auVar);
            return 0;
        }
        x.e("MicroMsg.BackupItemImg", "img buf is null");
        return -1;
    }
}
