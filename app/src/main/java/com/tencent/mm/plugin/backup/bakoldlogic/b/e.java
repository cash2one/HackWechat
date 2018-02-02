package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.aq.g;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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

public final class e implements k {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        int i;
        com.tencent.mm.aq.e bi;
        com.tencent.mm.aq.e eVar;
        String B;
        Object obj;
        String m;
        int i2;
        String a;
        if (bh.ov(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        if (auVar.field_isSend == 1) {
            bi = b.aqJ().aqK().aqb().bi(auVar.field_msgId);
            if (bi.hzP != 0) {
                eVar = bi;
                B = b.aqJ().aqK().aqb().B(auVar.field_imgPath, true);
                if (com.tencent.mm.a.e.bO(B)) {
                    return -1;
                }
                i += j.a(new j.a(B, erVar, linkedList, 1, false, "_thumb", false));
                if (auVar.field_isSend == 1) {
                    obj = "";
                    m = b.aqJ().aqK().aqb().m(eVar.hzQ, "", "");
                    if (eVar.Pe()) {
                        eVar = b.aqJ().aqK().aqb().hQ(eVar.hzZ);
                        if (eVar == null) {
                            obj = b.aqJ().aqK().aqb().m(eVar.hzQ, "", "");
                            x.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + obj + " " + com.tencent.mm.a.e.bN(obj));
                            com.tencent.mm.a.e.bN(obj);
                            if (com.tencent.mm.a.e.bO(obj)) {
                                x.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[]{obj});
                            } else {
                                i = j.a(new j.a(obj, erVar, linkedList, 3, false, "_hd", false)) + i;
                            }
                        } else {
                            x.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
                        }
                    }
                    com.tencent.mm.a.e.bN(m);
                    if (!(bh.ov(m) || m.equals(r1))) {
                        x.d("MicroMsg.BakOldItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
                        i += j.a(new j.a(m, erVar, linkedList, 2, false, false, null));
                    }
                } else if (eVar.Pd()) {
                    m = b.aqJ().aqK().aqb().m(eVar.hzQ, "", "");
                    String str2 = "";
                    if (eVar.Pe()) {
                        if (eVar.Pe()) {
                            bi = b.aqJ().aqK().aqb().hQ(eVar.hzZ);
                        }
                        bi = eVar;
                        String str3 = "MicroMsg.BakOldItemImg";
                        String str4 = "packet hdinfo off:%d total:%d path:%s, compressType[%d]";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(bi != null ? -1 : bi.offset);
                        if (bi != null) {
                            i2 = -1;
                        } else {
                            i2 = bi.hlp;
                        }
                        objArr[1] = Integer.valueOf(i2);
                        objArr[2] = bi != null ? "null" : bi.hzQ;
                        objArr[3] = Integer.valueOf(bi != null ? -1 : bi.hzT);
                        x.i(str3, str4, objArr);
                        if (bi != null && bi.hzT == 1) {
                            if (bi.equals(eVar) && bi.offset == bi.hlp) {
                                obj = b.aqJ().aqK().aqb().m(bi.hzQ, "", "");
                                x.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[]{obj, Integer.valueOf(com.tencent.mm.a.e.bN(obj))});
                                if (com.tencent.mm.a.e.bO(obj)) {
                                    i += j.a(new j.a(obj, erVar, linkedList, 3, false, "_hd", false));
                                    com.tencent.mm.a.e.bN(obj);
                                }
                                if (com.tencent.mm.a.e.bO(m)) {
                                    com.tencent.mm.a.e.bN(m);
                                    if (!(bh.ov(m) || m.equals(r1))) {
                                        x.d("MicroMsg.BakOldItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
                                        i += j.a(new j.a(m, erVar, linkedList, 2, false, false, null));
                                    }
                                }
                            } else {
                                bi.equals(eVar);
                            }
                        }
                    }
                    B = str2;
                    if (com.tencent.mm.a.e.bO(m)) {
                        com.tencent.mm.a.e.bN(m);
                        x.d("MicroMsg.BakOldItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
                        i += j.a(new j.a(m, erVar, linkedList, 2, false, false, null));
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
        eVar = b.aqJ().aqK().aqb().bh(auVar.field_msgSvrId);
        B = b.aqJ().aqK().aqb().B(auVar.field_imgPath, true);
        if (com.tencent.mm.a.e.bO(B)) {
            return -1;
        }
        i += j.a(new j.a(B, erVar, linkedList, 1, false, "_thumb", false));
        if (auVar.field_isSend == 1) {
            obj = "";
            m = b.aqJ().aqK().aqb().m(eVar.hzQ, "", "");
            if (eVar.Pe()) {
                eVar = b.aqJ().aqK().aqb().hQ(eVar.hzZ);
                if (eVar == null) {
                    x.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
                } else {
                    obj = b.aqJ().aqK().aqb().m(eVar.hzQ, "", "");
                    x.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + obj + " " + com.tencent.mm.a.e.bN(obj));
                    com.tencent.mm.a.e.bN(obj);
                    if (com.tencent.mm.a.e.bO(obj)) {
                        x.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[]{obj});
                    } else {
                        i = j.a(new j.a(obj, erVar, linkedList, 3, false, "_hd", false)) + i;
                    }
                }
            }
            com.tencent.mm.a.e.bN(m);
            x.d("MicroMsg.BakOldItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
            i += j.a(new j.a(m, erVar, linkedList, 2, false, false, null));
        } else if (eVar.Pd()) {
            m = b.aqJ().aqK().aqb().m(eVar.hzQ, "", "");
            String str22 = "";
            if (eVar.Pe()) {
                if (eVar.Pe()) {
                    bi = b.aqJ().aqK().aqb().hQ(eVar.hzZ);
                }
                bi = eVar;
                String str32 = "MicroMsg.BakOldItemImg";
                String str42 = "packet hdinfo off:%d total:%d path:%s, compressType[%d]";
                Object[] objArr2 = new Object[4];
                if (bi != null) {
                }
                objArr2[0] = Integer.valueOf(bi != null ? -1 : bi.offset);
                if (bi != null) {
                    i2 = bi.hlp;
                } else {
                    i2 = -1;
                }
                objArr2[1] = Integer.valueOf(i2);
                if (bi != null) {
                }
                objArr2[2] = bi != null ? "null" : bi.hzQ;
                if (bi != null) {
                }
                objArr2[3] = Integer.valueOf(bi != null ? -1 : bi.hzT);
                x.i(str32, str42, objArr2);
                if (bi.equals(eVar)) {
                }
                bi.equals(eVar);
            }
            B = str22;
            if (com.tencent.mm.a.e.bO(m)) {
                com.tencent.mm.a.e.bN(m);
                x.d("MicroMsg.BakOldItemImg", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
                i += j.a(new j.a(m, erVar, linkedList, 2, false, false, null));
            }
        }
        a = a(eVar, auVar);
        if (a == null) {
            return i;
        }
        erVar.vGZ = new bdo().UA(a);
        return i + a.length();
    }

    private static String a(com.tencent.mm.aq.e eVar, au auVar) {
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (d.eV(auVar.field_talker)) {
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
                    j = (long) com.tencent.mm.a.e.bN(b.aqJ().aqK().aqb().m(eVar.hzQ, "", ""));
                }
                newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                if (auVar.field_isSend != 1 || eVar.hzT == 1) {
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
            x.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[]{stringWriter.getBuffer().toString()});
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            x.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + e.toString());
            return null;
        }
    }

    public final int a(String str, er erVar, au auVar) {
        if (erVar == null || erVar.vGZ == null) {
            x.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
            return 0;
        }
        int i;
        String str2;
        com.tencent.mm.aq.e bh;
        Object obj;
        String str3;
        String str4;
        String str5 = new String(bh.az(erVar.vGZ.wJF, ""));
        x.d("MicroMsg.BakOldItemImg", "recover msg" + erVar.vHe + " " + str5);
        String str6 = "MicroMsg.BakOldItemImg";
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
        com.tencent.mm.aq.e eVar = null;
        auVar.setContent(str5);
        g aqb = b.aqJ().aqK().aqb();
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
        if (y == null || bh.getLong((String) y.get(".msg.img.$hdlength"), 0) <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        String az = bh.az(com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(erVar, 3), "");
        if (erVar.vKh == 3 && erVar.vKf != null) {
            com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aqi() + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.vn(az), az, erVar.vKf.wJD.oz);
        }
        str2 = bh.az(com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(erVar, 2), "");
        if (erVar.vKh == 2 && erVar.vKf != null) {
            com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aqi() + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.vn(str2), str2, erVar.vKf.wJD.oz);
        }
        x.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[]{az, str2});
        if (bh.ov(str2)) {
            x.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
            str3 = az;
        } else {
            str3 = str2;
        }
        byte[] b = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 1);
        if (b == null) {
            x.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.vA(str3);
            String s = com.tencent.mm.a.g.s((bh.Wp() + " ").getBytes());
            str6 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aqi() + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.vn(s);
            str4 = str6 + s;
            File file = new File(str6);
            if (!file.exists()) {
                file.mkdirs();
            }
            int UM = com.tencent.mm.sdk.platformtools.d.UM(str4);
            if (UM > 0) {
                if (!com.tencent.mm.sdk.platformtools.d.a(str2, CompressFormat.JPEG, str4, UM)) {
                    x.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
                    return -1;
                }
            } else if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                x.d("MicroMsg.BakOldItemImg", "insert: thumbName = " + s);
            } else {
                x.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
                return -1;
            }
            b = com.tencent.mm.a.e.e(str4, 0, -1);
        } else {
            x.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[]{Integer.valueOf(b.length)});
        }
        if (b == null) {
            x.e("MicroMsg.BakOldItemImg", "img buf is null");
            return -1;
        }
        String m = aqb.m(az, "", "");
        String m2 = aqb.m(str3, "", "");
        long j = 0;
        if (bh.hzP == 0) {
            if (obj != null) {
                g gVar = aqb;
                str4 = az;
                j = gVar.a(b, erVar.vHe, true, str4, com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(erVar, 3), str5, new PString(), new PInt(), new PInt());
                if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 3, m)) {
                    x.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[]{m});
                }
            }
            long j2 = j;
            int c = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(erVar, 2);
            if (c <= 0) {
                c = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(erVar, 3);
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            long a = aqb.a(b, erVar.vHe, false, str3, c, str5, pString, pInt, pInt2);
            if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 2, m2)) {
                x.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[]{m});
            }
            if (a <= 0) {
                return -1;
            }
            auVar.dT(pString.value);
            auVar.fc(pInt.value);
            auVar.fd(pInt2.value);
            if (j2 > 0) {
                com.tencent.mm.aq.e b2 = b.aqJ().aqK().aqb().b(Long.valueOf(a));
                b2.hM((int) j2);
                b.aqJ().aqK().aqb().a(Long.valueOf(a), b2);
            }
        } else {
            str2 = bh.hzS;
            if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                auVar.dT("THUMBNAIL://" + bh.hzP);
            } else {
                auVar.dT(str2);
            }
        }
        d.i(auVar);
        return 0;
    }
}
