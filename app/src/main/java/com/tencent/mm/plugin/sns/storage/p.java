package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class p extends i<o> {
    public static final String[] gJN = new String[]{i.a(o.gJc, "SnsReportKv")};
    public h hhp;

    public p(h hVar) {
        super(hVar, o.gJc, "SnsReportKv", o.fMK);
        this.hhp = hVar;
    }

    public final int a(bjt com_tencent_mm_protocal_c_bjt) {
        bjt com_tencent_mm_protocal_c_bjt2 = new bjt();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < com_tencent_mm_protocal_c_bjt.vGC.size(); i3++) {
            ano com_tencent_mm_protocal_c_ano = (ano) com_tencent_mm_protocal_c_bjt.vGC.get(i3);
            if (com_tencent_mm_protocal_c_ano.wuv.oz.length + i2 > 51200) {
                a(com_tencent_mm_protocal_c_bjt2, i2);
                i++;
                com_tencent_mm_protocal_c_bjt2.vGC.clear();
                i2 = 0;
            } else {
                i2 += com_tencent_mm_protocal_c_ano.wuv.oz.length;
                com_tencent_mm_protocal_c_bjt2.vGC.add(com_tencent_mm_protocal_c_ano);
            }
        }
        if (com_tencent_mm_protocal_c_bjt2.vGC.size() <= 0) {
            return i;
        }
        i++;
        a(com_tencent_mm_protocal_c_bjt2, i2);
        return i;
    }

    private int a(bjt com_tencent_mm_protocal_c_bjt, int i) {
        try {
            byte[] toByteArray = com_tencent_mm_protocal_c_bjt.toByteArray();
            o oVar = new o();
            oVar.field_value = toByteArray;
            oVar.field_logtime = System.currentTimeMillis();
            oVar.field_logsize = i;
            oVar.field_offset = 0;
            int insert = (int) this.hhp.insert("SnsReportKv", "", oVar.vI());
            x.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result " + insert);
            return insert;
        } catch (Exception e) {
            return 0;
        }
    }

    public final bjt dA(int i, int i2) {
        Throwable th;
        String str = "select rowid, *  from SnsReportKv";
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 > 0) {
            str = str + " where rowid <= " + i2;
        }
        Cursor a = this.hhp.a(str, null, 0);
        bjt com_tencent_mm_protocal_c_bjt = new bjt();
        List<Integer> arrayList = new ArrayList();
        stringBuffer.append("target size " + i + " current maxcolid " + i2);
        if (a.moveToFirst()) {
            int i3 = 0;
            do {
                c oVar = new o();
                oVar.b(a);
                int i4 = oVar.field_offset;
                stringBuffer.append("|offset: " + i4);
                bjt com_tencent_mm_protocal_c_bjt2 = new bjt();
                try {
                    com_tencent_mm_protocal_c_bjt2.aF(oVar.field_value);
                    int i5 = i4;
                    i4 = i3;
                    while (i5 < com_tencent_mm_protocal_c_bjt2.vGC.size()) {
                        try {
                            ano com_tencent_mm_protocal_c_ano = (ano) com_tencent_mm_protocal_c_bjt2.vGC.get(i5);
                            if (com_tencent_mm_protocal_c_ano.wuv.oz.length + i4 > i) {
                                if (i4 == 0) {
                                    arrayList.add(Integer.valueOf(oVar.roJ));
                                    x.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + i + " vlauesize " + com_tencent_mm_protocal_c_ano.wuv.oz.length);
                                }
                                i3 = 1;
                                stringBuffer.append("|read end on " + oVar.roJ + " and get size " + i4);
                                if (i3 != 0 || oVar.field_offset > com_tencent_mm_protocal_c_bjt2.vGC.size()) {
                                    stringBuffer.append("|read full ");
                                    arrayList.add(Integer.valueOf(oVar.roJ));
                                } else {
                                    a((long) oVar.roJ, oVar);
                                    stringBuffer.append("|update new offset " + oVar.field_offset);
                                }
                                if (i3 != 0) {
                                    break;
                                }
                                i3 = i4;
                            } else {
                                oVar.field_offset = i5 + 1;
                                com_tencent_mm_protocal_c_bjt.vGC.add(com_tencent_mm_protocal_c_ano);
                                i4 += com_tencent_mm_protocal_c_ano.wuv.oz.length;
                                i5++;
                            }
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            i3 = i4;
                            th = th2;
                        }
                    }
                    i3 = 0;
                    stringBuffer.append("|read end on " + oVar.roJ + " and get size " + i4);
                    if (i3 != 0) {
                    }
                    stringBuffer.append("|read full ");
                    arrayList.add(Integer.valueOf(oVar.roJ));
                    if (i3 != 0) {
                        break;
                    }
                    i3 = i4;
                } catch (Exception e2) {
                    th = e2;
                    x.printErrStackTrace("MicroMsg.SnsKvReportStg", th, "", new Object[0]);
                    arrayList.add(Integer.valueOf(oVar.roJ));
                    x.i("MicroMsg.SnsKvReportStg", "error paser then delete " + oVar.roJ);
                    if (!a.moveToNext()) {
                        x.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
                        a.close();
                        for (Integer intValue : arrayList) {
                            delete((long) intValue.intValue());
                        }
                        return com_tencent_mm_protocal_c_bjt;
                    }
                }
            } while (a.moveToNext());
            x.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
        }
        a.close();
        while (r1.hasNext()) {
            delete((long) intValue.intValue());
        }
        return com_tencent_mm_protocal_c_bjt;
    }
}
