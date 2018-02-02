package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.b;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashSet;
import junit.framework.Assert;

public final class m extends j implements c<Integer, k> {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) "};
    private static final String[] hSs = new String[]{"realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut"};
    private long hSp;
    public au<Integer, k> hSq = new au(this, g.Dm().oAt.getLooper(), 30, 2, 300000, 1000);
    private long hSr;
    public h hhp;

    public m(h hVar) {
        int i = 0;
        this.hhp = hVar;
        HashSet hashSet = new HashSet();
        for (Object add : hSs) {
            hashSet.add(add);
        }
        Cursor a = this.hhp.a("PRAGMA table_info(netstat);", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            hashSet.remove(a.getString(columnIndex));
        }
        a.close();
        String[] strArr = hSs;
        columnIndex = strArr.length;
        while (i < columnIndex) {
            String str = strArr[i];
            if (hashSet.contains(str)) {
                this.hhp.fx("netstat", "ALTER TABLE netstat ADD COLUMN " + str + " INT;");
            }
            i++;
        }
        this.hSr = System.currentTimeMillis();
    }

    public final k iz(int i) {
        k kVar = (k) this.hSq.get(Integer.valueOf(i));
        if (kVar == null) {
            Cursor a = this.hhp.a("netstat", null, "peroid = " + i, null, null, null, null, 2);
            if (a.moveToFirst()) {
                kVar = new k();
                kVar.b(a);
            }
            a.close();
            if (kVar != null) {
                this.hSq.r(Integer.valueOf(i), kVar);
                return kVar;
            }
            au auVar = this.hSq;
            Integer valueOf = Integer.valueOf(i);
            k kVar2 = new k();
            kVar2.fDt = 0;
            kVar2.id = 0;
            kVar2.hRC = 0;
            kVar2.hRD = 0;
            kVar2.hRE = 0;
            kVar2.hRF = 0;
            kVar2.hRG = 0;
            kVar2.hRH = 0;
            kVar2.hRI = 0;
            kVar2.hRJ = 0;
            kVar2.hRK = 0;
            kVar2.hRL = 0;
            kVar2.hRM = 0;
            kVar2.hRN = 0;
            kVar2.hRO = 0;
            kVar2.hRP = 0;
            kVar2.hRQ = 0;
            kVar2.hRR = 0;
            kVar2.hRS = 0;
            kVar2.hRT = 0;
            kVar2.hRU = 0;
            kVar2.hRV = 0;
            kVar2.hRW = 0;
            kVar2.hRX = 0;
            kVar2.hRY = 0;
            kVar2.hRZ = 0;
            kVar2.hSa = 0;
            kVar2.hSb = 0;
            kVar2.hSc = 0;
            kVar2.hSd = 0;
            kVar2.hSe = 0;
            auVar.r(valueOf, kVar2);
            return kVar;
        } else if (kVar.hRC != i) {
            return null;
        } else {
            return kVar;
        }
    }

    public final void a(k kVar) {
        Assert.assertNotNull(kVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (kVar.hRC <= 0) {
            kVar.hRC = (int) (currentTimeMillis / 86400000);
        }
        if (kVar.hRC > 0) {
            k iz = iz(kVar.hRC);
            if (iz == null || kVar.hRC != iz.hRC) {
                kVar.fDt |= 2;
                kVar.id = -1;
                if (iz != null) {
                    x.i("MicroMsg.NetStat", iz.toString());
                } else {
                    x.i("MicroMsg.NetStat", "NetStat started.");
                }
            } else {
                kVar.fDt = iz.fDt | 1;
                kVar.hRD += iz.hRE;
                kVar.hRE += iz.hRE;
                kVar.hRF += iz.hRG;
                kVar.hRG += iz.hRG;
                kVar.hRH += iz.hRH;
                kVar.hRI += iz.hRI;
                kVar.hRJ += iz.hRJ;
                kVar.hRK += iz.hRK;
                kVar.hRL += iz.hRL;
                kVar.hRM += iz.hRM;
                kVar.hRN += iz.hRN;
                kVar.hRO += iz.hRO;
                kVar.hRP += iz.hRQ;
                kVar.hRQ += iz.hRQ;
                kVar.hRR += iz.hRS;
                kVar.hRS += iz.hRS;
                kVar.hRT += iz.hRT;
                kVar.hRU += iz.hRU;
                kVar.hRV += iz.hRV;
                kVar.hRW += iz.hRW;
                kVar.hRX += iz.hRX;
                kVar.hRY += iz.hRY;
                kVar.hRZ += iz.hRZ;
                kVar.hSa += iz.hSa;
                kVar.hSb += iz.hSb;
                kVar.hSc += iz.hSc;
                kVar.hSd += iz.hSd;
                kVar.hSe += iz.hSe;
                if (kVar.hRL <= Downloads.RECV_BUFFER_SIZE && kVar.hRM <= Downloads.RECV_BUFFER_SIZE && kVar.hRX <= Downloads.RECV_BUFFER_SIZE) {
                    int i = kVar.hRY;
                }
                kVar.id = iz.id;
                if (currentTimeMillis - this.hSr > 300000) {
                    x.i("MicroMsg.NetStat", kVar.toString());
                }
                b(kVar);
            }
            this.hSr = currentTimeMillis;
            b(kVar);
        }
    }

    public final boolean b(k kVar) {
        Assert.assertNotNull(kVar);
        Assert.assertTrue(kVar.hRC > 0);
        return this.hSq.r(Integer.valueOf(kVar.hRC), kVar);
    }

    public final long SX() {
        this.hSq.lE(true);
        int cgs = (int) (bh.cgs() / 86400000);
        Cursor a = this.hhp.a("SELECT peroid FROM netstat  WHERE peroid > " + ((int) ((bh.Wp() - 1296000000) / 86400000)) + " order by peroid limit 1", null, 2);
        if (a.moveToFirst()) {
            cgs = a.getInt(a.getColumnIndex("peroid"));
        }
        a.close();
        return ((long) cgs) * 86400000;
    }

    public final k iA(int i) {
        k kVar = null;
        this.hSq.lE(true);
        Cursor a = this.hhp.a("SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= " + i, null, 2);
        if (a.moveToFirst()) {
            kVar = new k();
            kVar.b(a);
        }
        a.close();
        return kVar;
    }

    public final boolean SY() {
        if (this.hhp.inTransaction()) {
            x.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
            return false;
        }
        this.hSp = this.hhp.dz(Thread.currentThread().getId());
        if (this.hSp > 0) {
            return true;
        }
        x.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.hSp + " return false");
        return false;
    }

    public final void a(au<Integer, k> auVar, b<Integer, k> bVar) {
        int i = bVar.xhD;
        k kVar = (k) bVar.values;
        if (kVar != null && i == 1) {
            i = kVar.hRC;
            int i2 = kVar.id;
            if (i > 0) {
                ContentValues contentValues = new ContentValues();
                if ((kVar.fDt & 2) != 0) {
                    contentValues.put("peroid", Integer.valueOf(kVar.hRC));
                }
                if ((kVar.fDt & 4) != 0) {
                    contentValues.put("textCountIn", Integer.valueOf(kVar.hRD));
                }
                if ((kVar.fDt & 8) != 0) {
                    contentValues.put("textBytesIn", Integer.valueOf(kVar.hRE));
                }
                if ((kVar.fDt & 16) != 0) {
                    contentValues.put("imageCountIn", Integer.valueOf(kVar.hRF));
                }
                if ((kVar.fDt & 32) != 0) {
                    contentValues.put("imageBytesIn", Integer.valueOf(kVar.hRG));
                }
                if ((kVar.fDt & 64) != 0) {
                    contentValues.put("voiceCountIn", Integer.valueOf(kVar.hRH));
                }
                if ((kVar.fDt & FileUtils.S_IWUSR) != 0) {
                    contentValues.put("voiceBytesIn", Integer.valueOf(kVar.hRI));
                }
                if ((kVar.fDt & 256) != 0) {
                    contentValues.put("videoCountIn", Integer.valueOf(kVar.hRJ));
                }
                if ((kVar.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                    contentValues.put("videoBytesIn", Integer.valueOf(kVar.hRK));
                }
                if ((kVar.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    contentValues.put("mobileBytesIn", Integer.valueOf(kVar.hRL));
                }
                if ((kVar.fDt & 2048) != 0) {
                    contentValues.put("wifiBytesIn", Integer.valueOf(kVar.hRM));
                }
                if ((kVar.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
                    contentValues.put("sysMobileBytesIn", Integer.valueOf(kVar.hRN));
                }
                if ((kVar.fDt & 8192) != 0) {
                    contentValues.put("sysWifiBytesIn", Integer.valueOf(kVar.hRO));
                }
                if ((kVar.fDt & 16384) != 0) {
                    contentValues.put("textCountOut", Integer.valueOf(kVar.hRP));
                }
                if ((kVar.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                    contentValues.put("textBytesOut", Integer.valueOf(kVar.hRQ));
                }
                if ((kVar.fDt & 65536) != 0) {
                    contentValues.put("imageCountOut", Integer.valueOf(kVar.hRR));
                }
                if ((kVar.fDt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    contentValues.put("imageBytesOut", Integer.valueOf(kVar.hRS));
                }
                if ((kVar.fDt & 262144) != 0) {
                    contentValues.put("voiceCountOut", Integer.valueOf(kVar.hRT));
                }
                if ((kVar.fDt & SQLiteGlobal.journalSizeLimit) != 0) {
                    contentValues.put("voiceBytesOut", Integer.valueOf(kVar.hRU));
                }
                if ((kVar.fDt & 1048576) != 0) {
                    contentValues.put("videoCountOut", Integer.valueOf(kVar.hRV));
                }
                if ((kVar.fDt & 2097152) != 0) {
                    contentValues.put("videoBytesOut", Integer.valueOf(kVar.hRW));
                }
                if ((kVar.fDt & 4194304) != 0) {
                    contentValues.put("mobileBytesOut", Integer.valueOf(kVar.hRX));
                }
                if ((kVar.fDt & 8388608) != 0) {
                    contentValues.put("wifiBytesOut", Integer.valueOf(kVar.hRY));
                }
                if ((kVar.fDt & 16777216) != 0) {
                    contentValues.put("sysMobileBytesOut", Integer.valueOf(kVar.hRZ));
                }
                if ((kVar.fDt & 33554432) != 0) {
                    contentValues.put("sysWifiBytesOut", Integer.valueOf(kVar.hSa));
                }
                if ((kVar.fDt & 67108864) != 0) {
                    contentValues.put("realMobileBytesIn", Integer.valueOf(kVar.hSb));
                }
                if ((kVar.fDt & 134217728) != 0) {
                    contentValues.put("realWifiBytesIn", Integer.valueOf(kVar.hSc));
                }
                if ((kVar.fDt & SQLiteDatabase.CREATE_IF_NECESSARY) != 0) {
                    contentValues.put("realMobileBytesOut", Integer.valueOf(kVar.hSd));
                }
                if ((kVar.fDt & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                    contentValues.put("realWifiBytesOut", Integer.valueOf(kVar.hSe));
                }
                if (i2 < 0) {
                    kVar.id = (int) this.hhp.insert("netstat", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                } else {
                    this.hhp.update("netstat", contentValues, "peroid=" + i, null);
                }
            }
        }
    }

    public final void SZ() {
        if (this.hSp > 0) {
            this.hhp.fS(this.hSp);
        }
    }
}
