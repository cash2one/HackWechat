package com.tencent.mm.modelmulti;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build;
import android.os.Debug.MemoryInfo;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import com.tencent.mm.a.h;
import com.tencent.mm.ae.e;
import com.tencent.mm.be.b;
import com.tencent.mm.by.h.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.c.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo;
import com.tencent.mm.plugin.report.kvdata.SDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.SubDirInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.WeChatSDInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class p implements ap {
    private static final long startTime = System.currentTimeMillis();
    private long hGA = 1440;
    private long hGB = 20;
    private long hGC = 1440;
    private BroadcastReceiver hGD;
    private boolean hGE = false;
    private boolean hGF = true;
    private long hGG = 0;
    private Runnable hGH;
    private a hGI;
    private long hGJ = 0;
    private e hGK = new 1(this);
    private Runnable hGL = new 9(this);
    private Runnable hGM = new 10(this);
    private c hGN = new 11(this);
    private ak hGO = new ak(ar.Dm().oAt.getLooper(), new ak.a(this) {
        final /* synthetic */ p hGP;

        {
            this.hGP = r1;
        }

        public final boolean uF() {
            p.e(this.hGP);
            return true;
        }
    }, true);
    private long hGs = 1024;
    private long hGt = 10;
    private long hGu = 1800;
    private long hGv = 3000000;
    private long hGw = 15000;
    private long hGx = 100000;
    private long hGy = 10000;
    private long hGz = 1024;
    private j.a hiB = new 8(this);

    static /* synthetic */ void Qb() {
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100282");
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg  abTest[%s][%b][%s]", new Object[]{fn, Boolean.valueOf(fn.isValid()), fn.chI()});
        if (fn.isValid()) {
            boolean z;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg abTest valid!");
            Editor edit = ac.getContext().getSharedPreferences(HardCoderJNI.SETTING_SP_FILE, 0).edit();
            Map chI = fn.chI();
            boolean z2 = bh.getInt((String) chI.get("enable"), HardCoderJNI.hcEnable ? 1 : 0) > 0;
            boolean z3 = z2 && !HardCoderJNI.hcEnable;
            edit.putBoolean(HardCoderJNI.KEY_HC_ENABLE, z2);
            edit.putBoolean(HardCoderJNI.KEY_HC_BG_ENABLE, bh.getInt((String) chI.get("bgenable"), HardCoderJNI.hcBgEnable ? 1 : 0) > 0);
            edit.putBoolean(HardCoderJNI.KEY_HC_DEBUG, bh.getInt((String) chI.get("debug"), HardCoderJNI.hcDebug ? 1 : 0) > 0);
            edit.putBoolean(HardCoderJNI.KEY_HC_SWITCH_ENABLE, bh.getInt((String) chI.get("switch"), HardCoderJNI.hcSwitchEnable ? 1 : 0) > 0);
            edit.putInt(HardCoderJNI.KEY_HC_KV_PER, bh.getInt((String) chI.get("kvper"), HardCoderJNI.hcUinHash));
            edit.putInt(HardCoderJNI.KEY_HC_KV_FT, bh.getInt((String) chI.get("kvft"), HardCoderJNI.hcUinHash));
            g.Dk();
            g.Dh();
            edit.putInt(HardCoderJNI.KEY_HC_UIN_HASH, h.aJ(com.tencent.mm.kernel.a.Cg(), 100));
            long j = bh.getLong((String) chI.get("scene"), -1);
            for (Entry entry : HardCoderJNI.flagKeyMap.entrySet()) {
                edit.putBoolean((String) entry.getValue(), (((Long) entry.getKey()).longValue() & j) != 0);
            }
            edit.putInt(HardCoderJNI.KEY_HC_TIMEOUT_MARGIN, bh.getInt((String) chI.get("margin"), HardCoderJNI.hcTimeoutMargin));
            edit.putInt(HardCoderJNI.KEY_HC_RETRY_INTERVAL, bh.getInt((String) chI.get("retryitv"), HardCoderJNI.hcRetryInterval));
            String az = bh.az((String) chI.get("model"), "");
            CharSequence charSequence = Build.MODEL;
            if (az.length() > 0) {
                z3 = az.contains(charSequence);
                HardCoderJNI.reportIDKey(true, z3 ? 10 : 11, 1, true);
                edit.putBoolean(HardCoderJNI.KEY_HC_ENABLE, z3);
                z = z3 && !HardCoderJNI.hcEnable;
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg check model[%s][%s] enable[%b] init[%b]", new Object[]{charSequence, az, Boolean.valueOf(z3), Boolean.valueOf(z)});
            } else {
                HardCoderJNI.reportIDKey(true, 12, 1, true);
                z = z3;
            }
            edit.apply();
            HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_ABTEST);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] switch[%b] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", new Object[]{Boolean.valueOf(HardCoderJNI.hcEnable), Boolean.valueOf(z), Boolean.valueOf(HardCoderJNI.hcBgEnable), Boolean.valueOf(HardCoderJNI.hcDebug), Integer.valueOf(r5), Boolean.valueOf(HardCoderJNI.hcSwitchEnable), Boolean.valueOf(HardCoderJNI.hcKVPerReport), Boolean.valueOf(HardCoderJNI.hcKVFtReport), Long.valueOf(j), Integer.valueOf(r1), Integer.valueOf(r8), az});
            if (z) {
                HardCoderJNI.initHardCoder();
                HardCoderJNI.initReporter(new f());
            }
        }
    }

    static /* synthetic */ a a(p pVar, c cVar) {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan");
        ar.Hg();
        if (com.tencent.mm.z.c.isSDCardAvailable()) {
            File file = new File(com.tencent.mm.compatible.util.e.bnF);
            String Fl;
            if (file.exists() && file.isDirectory()) {
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan root[%s] exist[%b], diretory[%b]", new Object[]{Fl, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory())});
                Map hashMap = new HashMap(26);
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fl();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fl().length() - 1), Integer.valueOf(1));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fm();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fm().length() - 1), Integer.valueOf(2));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fi();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fi().length() - 1), Integer.valueOf(3));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fj();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fj().length() - 1), Integer.valueOf(4));
                ar.Hg();
                hashMap.put(com.tencent.mm.z.c.Fy(), Integer.valueOf(5));
                hashMap.put(com.tencent.mm.plugin.f.a.aoe().substring(0, com.tencent.mm.plugin.f.a.aoe().length() - 1), Integer.valueOf(6));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fp();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fp().length() - 1), Integer.valueOf(7));
                ar.Hg();
                Fl = com.tencent.mm.z.c.getAccVideoPath();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.getAccVideoPath().length() - 1), Integer.valueOf(8));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fs();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fs().length() - 1), Integer.valueOf(9));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fq();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fq().length() - 1), Integer.valueOf(10));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Ft();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Ft().length() - 1), Integer.valueOf(11));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fu();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fu().length() - 1), Integer.valueOf(12));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fv();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fv().length() - 1), Integer.valueOf(13));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fz();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fz().length() - 1), Integer.valueOf(14));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fn();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fn().length() - 1), Integer.valueOf(15));
                hashMap.put(b.SC().substring(0, b.SC().length() - 1), Integer.valueOf(16));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fo();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fo().length() - 1), Integer.valueOf(17));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fx();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fx().length() - 1), Integer.valueOf(18));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fw();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fw().length() - 1), Integer.valueOf(19));
                ar.Hg();
                Fl = com.tencent.mm.z.c.getAccSnsPath();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.getAccSnsPath().length() - 1), Integer.valueOf(20));
                ar.Hg();
                Fl = com.tencent.mm.z.c.FA();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.FA().length() - 1), Integer.valueOf(21));
                ar.Hg();
                Fl = com.tencent.mm.z.c.Fk();
                ar.Hg();
                hashMap.put(Fl.substring(0, com.tencent.mm.z.c.Fk().length() - 1), Integer.valueOf(22));
                hashMap.put(com.tencent.mm.compatible.util.e.gHA, Integer.valueOf(23));
                hashMap.put(com.tencent.mm.compatible.util.e.gHs.substring(0, com.tencent.mm.compatible.util.e.gHs.length() - 1), Integer.valueOf(24));
                hashMap.put(com.tencent.mm.compatible.util.e.gHw.substring(0, com.tencent.mm.compatible.util.e.gHw.length() - 1), Integer.valueOf(25));
                hashMap.put(com.tencent.mm.compatible.util.e.gHu.substring(0, com.tencent.mm.compatible.util.e.gHu.length() - 1), Integer.valueOf(26));
                a aVar = new a(file.getAbsolutePath());
                com.tencent.mm.sdk.f.e.post(new 14(pVar, hashMap, aVar, file, cVar), "summerhv_scanFile");
                return aVar;
            }
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as path not exists[%s]", new Object[]{Fl});
            cVar.a(-1, null);
            return null;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as sdcard not available");
        cVar.a(-1, null);
        return null;
    }

    static /* synthetic */ void b(p pVar) {
        ar.Hg();
        long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xsk, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xsk, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new 5(pVar), "reportSDStatus");
        }
    }

    static /* synthetic */ void b(p pVar, a aVar) {
        String str;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        int i;
        com.tencent.mm.bq.a com_tencent_mm_plugin_report_kvdata_log_14375 = new log_14375();
        com_tencent_mm_plugin_report_kvdata_log_14375.type_ = 2;
        SDStatusInfo sDStatusInfo = new SDStatusInfo();
        com_tencent_mm_plugin_report_kvdata_log_14375.sdStatusInfo_ = sDStatusInfo;
        c.c cVar = new c.c("total/temp/acc/");
        Iterator it = aVar.hEV.iterator();
        while (it.hasNext()) {
            c.c cVar2 = (c.c) it.next();
            cVar.hER += cVar2.hER;
            cVar.hES += cVar2.hES;
            cVar.fwg += cVar2.fwg;
            cVar.hEX += cVar2.hEX;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo total tempAccDirResult[%d][%s]", new Object[]{Integer.valueOf(aVar.hEV.size()), cVar});
        Collections.sort(aVar.hEU, new 15(pVar));
        it = aVar.hEU.iterator();
        while (it.hasNext()) {
            x.d("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo subDirResult[%s]", new Object[]{(c.b) it.next()});
            if (!((c.b) it.next()).hEW) {
                c.b bVar;
                com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(6), Integer.valueOf(bVar.tag), Long.valueOf(bVar.fwg)});
            }
        }
        String str2 = aVar.fwg + ":" + aVar.hER + ":" + aVar.hES + ":" + aVar.fileLenInvalidCount + ":" + aVar.hEU.size() + ":" + aVar.hET + ":" + aVar.axZ + "|" + aVar.hEV.size() + ":" + cVar.fwg + ":" + cVar.hER + ":" + cVar.hES + ":" + cVar.hEX;
        WeChatSDInfo weChatSDInfo = new WeChatSDInfo();
        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
        weChatSDInfo.totalSize_ = aVar.fwg;
        weChatSDInfo.fileCount_ = aVar.hES;
        weChatSDInfo.fileLenInvalidCount_ = aVar.fileLenInvalidCount;
        weChatSDInfo.subDirResultsSize_ = aVar.hEU.size();
        weChatSDInfo.totalTime_ = aVar.hET;
        weChatSDInfo.depth_ = aVar.axZ;
        weChatSDInfo.tempAccTotalSize_ = cVar.fwg;
        weChatSDInfo.tempAccDirResultsSize_ = aVar.hEV.size();
        weChatSDInfo.tempAccDirCount_ = cVar.hER;
        weChatSDInfo.tempAccFileCount_ = cVar.hES;
        weChatSDInfo.tempAccFileLenInvalidCount_ = cVar.hEX;
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(6), Integer.valueOf(1000), Long.valueOf(weChatSDInfo.totalSize_)});
        LinkedList linkedList = new LinkedList();
        weChatSDInfo.subDirList_ = linkedList;
        it = aVar.hEU.iterator();
        String str3 = str2;
        while (it.hasNext()) {
            bVar = (c.b) it.next();
            str = str3 + "|" + bVar.tag + ":" + bVar.fwg + ":" + bVar.hER + ":" + bVar.hES + ":" + bVar.fileLenInvalidCount;
            SubDirInfo subDirInfo = new SubDirInfo();
            linkedList.add(subDirInfo);
            subDirInfo.tag_ = bVar.tag;
            subDirInfo.totalSize_ = bVar.fwg;
            subDirInfo.dirCount_ = bVar.hER;
            subDirInfo.fileCount_ = bVar.hES;
            subDirInfo.fileLenInvalidCount = bVar.fileLenInvalidCount;
            str3 = str;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo wechatResult[%d][%s]", new Object[]{Integer.valueOf(str3.length()), str3});
        String path = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getPath();
        boolean cge = aw.cge();
        String Vn = aw.Vn(com.tencent.mm.compatible.util.e.bnD);
        StatFs statFs = new StatFs(path);
        long blockSize = (long) statFs.getBlockSize();
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        long j6 = blockSize * blockCount;
        long j7 = blockSize * availableBlocks;
        int round = blockCount > 0 ? Math.round((((float) availableBlocks) * 100.0f) / ((float) blockCount)) : -1;
        boolean equals = com.tencent.mm.compatible.util.e.bnD.equals(path);
        if (equals) {
            j = j7;
            j2 = j6;
            j3 = availableBlocks;
            j4 = blockCount;
            j5 = blockSize;
            i = round;
        } else {
            statFs = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getBlockCount();
            long availableBlocks2 = (long) statFs.getAvailableBlocks();
            long j8 = j2 * j;
            long j9 = j2 * availableBlocks2;
            if (j > 0) {
                j4 = j;
                j5 = j2;
                i = Math.round((((float) availableBlocks2) * 100.0f) / ((float) j));
                j = j9;
                j2 = j8;
                j3 = availableBlocks2;
            } else {
                j3 = availableBlocks2;
                j4 = j;
                j5 = j2;
                i = round;
                j = j9;
                j2 = j8;
            }
        }
        int round2 = Math.round((((float) aVar.fwg) * 100.0f) / ((float) j2));
        sDStatusInfo.weChatPer_ = round2;
        pVar.e(1, aVar.fwg, (pVar.hGs * 1024) * 1024);
        sDStatusInfo.sizeHeavy_ = aVar.fwg > (pVar.hGs * 1024) * 1024 ? 1 : 0;
        pVar.e(2, (long) round2, pVar.hGt);
        sDStatusInfo.ratioHeavy_ = ((long) round2) > pVar.hGt ? 1 : 0;
        str = round2 + ";" + (equals ? 1 : 0) + ";" + (cge ? 1 : 0) + ";" + j5 + ":" + j4 + ":" + j3 + ":" + j2 + ":" + j + ":" + i + "|" + blockSize + ":" + blockCount + ":" + availableBlocks + ":" + j6 + ":" + j7 + ":" + round + ";" + path + ";" + com.tencent.mm.compatible.util.e.bnD + ";" + Vn;
        sDStatusInfo.sBlockSize_ = j5;
        sDStatusInfo.sBlockCount_ = j4;
        sDStatusInfo.sAvailableBlockCount_ = j3;
        sDStatusInfo.sTotalSize_ = j2;
        sDStatusInfo.sAvailableSize_ = j;
        sDStatusInfo.sAvailablePer_ = i;
        sDStatusInfo.eBlockSize_ = blockSize;
        sDStatusInfo.eBlockCount_ = blockCount;
        sDStatusInfo.eAvailableBlockCount_ = availableBlocks;
        sDStatusInfo.eTotalSize_ = j6;
        sDStatusInfo.eAvailableSize_ = j7;
        sDStatusInfo.eAvailablePer_ = round;
        sDStatusInfo.ePath_ = path;
        sDStatusInfo.root_ = com.tencent.mm.compatible.util.e.bnD;
        sDStatusInfo.fSystem_ = Vn;
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(3), path});
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(4), com.tencent.mm.compatible.util.e.bnD});
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(5);
        objArr[2] = Integer.valueOf(equals ? 1 : 0);
        gVar.h(13778, objArr);
        gVar = com.tencent.mm.plugin.report.service.g.pQN;
        objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(6);
        objArr[2] = Integer.valueOf(cge ? 1 : 0);
        gVar.h(13778, objArr);
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(7), Vn});
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(8), Long.valueOf(sDStatusInfo.sTotalSize_)});
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(9), Long.valueOf(sDStatusInfo.sAvailableSize_)});
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(sDStatusInfo.sAvailablePer_)});
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(6), Integer.valueOf(1001), Integer.valueOf(round2)});
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo phoneResult[%d][%s]", new Object[]{Integer.valueOf(str.length()), str});
        str2 = str3 + ";" + str;
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo totalResult[%d][%s]", new Object[]{Integer.valueOf(str2.length()), str2});
        com.tencent.mm.plugin.report.service.g.pQN.a(418, 5, 1, true);
        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(1), str2});
        com.tencent.mm.plugin.report.service.g.pQN.c(14375, com_tencent_mm_plugin_report_kvdata_log_14375);
    }

    static /* synthetic */ void c(p pVar) {
        ar.Hg();
        long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xsT, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > pVar.hGC * 60000 || longValue > currentTimeMillis) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xsT, Long.valueOf(currentTimeMillis));
            currentTimeMillis = (pVar.hGu * 1024) * 1024;
            final long j = pVar.hGv;
            final long j2 = (pVar.hGz * 1024) * 1024;
            final long j3 = pVar.hGw;
            final long j4 = pVar.hGx;
            final long j5 = pVar.hGy;
            com.tencent.mm.sdk.f.e.post(new Runnable(pVar) {
                final /* synthetic */ p hGP;

                public final void run() {
                    try {
                        com.tencent.mm.bq.a com_tencent_mm_plugin_report_kvdata_log_14375 = new log_14375();
                        com_tencent_mm_plugin_report_kvdata_log_14375.type_ = 1;
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        com_tencent_mm_plugin_report_kvdata_log_14375.dbStatusInfo_ = bDStatusInfo;
                        ar.Hg();
                        long length = new File(com.tencent.mm.z.c.CS()).length();
                        bDStatusInfo.mmDBSize_ = length;
                        StringBuilder stringBuilder = new StringBuilder();
                        ar.Hg();
                        long length2 = new File(stringBuilder.append(com.tencent.mm.z.c.FB()).append("SnsMicroMsg.db").toString()).length();
                        bDStatusInfo.snsDBSize_ = length2;
                        stringBuilder = new StringBuilder();
                        ar.Hg();
                        long length3 = new File(stringBuilder.append(com.tencent.mm.z.c.FB()).append("enFavorite.db").toString()).length();
                        bDStatusInfo.favDBSize_ = length3;
                        this.hGP.e(4, length, currentTimeMillis);
                        this.hGP.e(FileUtils.S_IWUSR, length3, j2);
                        String str = length + ";" + length2 + ";" + length3;
                        ar.Hg();
                        com.tencent.mm.by.h EW = com.tencent.mm.z.c.EW();
                        if (EW == null || !EW.isOpen()) {
                            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ArrayList arrayList = new ArrayList();
                            Cursor a = EW.a("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
                            if (a != null) {
                                int columnIndex = a.getColumnIndex("name");
                                while (a.moveToNext()) {
                                    arrayList.add(a.getString(columnIndex));
                                }
                                a.close();
                            }
                            String str2 = str + ";" + arrayList.size();
                            bDStatusInfo.mmDBTableCount_ = arrayList.size();
                            LinkedList linkedList = new LinkedList();
                            bDStatusInfo.tableList_ = linkedList;
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                Cursor a2 = EW.a("select count(*) from " + str, null, 2);
                                length = 0;
                                if (a2 != null) {
                                    if (a2.moveToFirst()) {
                                        length = a2.getLong(0);
                                    }
                                    a2.close();
                                }
                                String str3 = str2 + ";" + str + ":" + length;
                                TableInfo tableInfo = new TableInfo();
                                tableInfo.name_ = str;
                                tableInfo.count_ = length;
                                linkedList.add(tableInfo);
                                if ("message".equals(str)) {
                                    this.hGP.e(8, length, j);
                                    str2 = str3;
                                } else if ("rconversation".equals(str)) {
                                    this.hGP.e(16, length, j3);
                                    str2 = str3;
                                } else if ("rcontact".equals(str)) {
                                    this.hGP.e(32, length, j4);
                                    str2 = str3;
                                } else {
                                    if ("chatroom".equals(str)) {
                                        this.hGP.e(64, length, j5);
                                    }
                                    str2 = str3;
                                }
                            }
                            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            str = str2;
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(1), Integer.valueOf(1), str});
                        com.tencent.mm.plugin.report.service.g.pQN.c(14375, com_tencent_mm_plugin_report_kvdata_log_14375);
                        com.tencent.mm.plugin.report.service.g.pQN.a(418, 3, 1, true);
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", new Object[]{str});
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportDBInfo err!", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.pQN.a(418, 4, 1, true);
                    }
                }
            }, "reportDBInfo");
        }
    }

    static /* synthetic */ void d(p pVar) {
        ar.Hg();
        long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xta, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xta, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new 3(pVar), "reportVersion");
        }
    }

    static /* synthetic */ void e(p pVar) {
        ar.Hg();
        int intValue = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xud, Integer.valueOf(0))).intValue();
        ar.Hg();
        long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xue, Long.valueOf(0))).longValue();
        ar.Hg();
        int intValue2 = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xuf, Integer.valueOf(0))).intValue();
        int myPid = Process.myPid();
        MemoryInfo[] processMemoryInfo = ((ActivityManager) ac.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{myPid});
        int totalPss = (processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) ? -1 : processMemoryInfo[0].getTotalPss();
        if (intValue == 0) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xud, Integer.valueOf(myPid));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xue, Long.valueOf(System.currentTimeMillis() - startTime));
            ar.Hg();
            t CU = com.tencent.mm.z.c.CU();
            w.a aVar = w.a.xuf;
            if (totalPss <= 0) {
                totalPss = 0;
            }
            CU.a(aVar, Integer.valueOf(totalPss));
        } else if (intValue != myPid) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(5), Integer.valueOf(1), Long.valueOf(longValue)});
            com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(intValue2)});
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xud, Integer.valueOf(myPid));
            long currentTimeMillis = System.currentTimeMillis() - startTime;
            if (totalPss <= 0) {
                totalPss = 0;
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xue, Long.valueOf(currentTimeMillis));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xuf, Integer.valueOf(totalPss));
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportLifeTime lifeTime[%d -> %d]ms,  pss[%d -> %d], pid[%d -> %d]", new Object[]{Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Integer.valueOf(intValue2), Integer.valueOf(totalPss), Integer.valueOf(intValue), Integer.valueOf(myPid)});
        } else {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xue, Long.valueOf(System.currentTimeMillis() - startTime));
            if (totalPss > intValue2) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xuf, Integer.valueOf(totalPss));
            }
        }
        pVar.hGO.J(180000, 180000);
    }

    static /* synthetic */ void f(p pVar) {
        ar.Hg();
        long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xsl, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xsl, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new 7(pVar), "reportHardCoder");
        }
    }

    static /* synthetic */ void h(p pVar) {
        if (pVar.hGJ != 0) {
            ar.Hg();
            long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xtU, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                com.tencent.mm.plugin.report.service.g.pQN.a(509, 17, 1, true);
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xtU, Long.valueOf(currentTimeMillis));
                ar.Hg();
                longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xtT, Long.valueOf(0))).longValue();
                com.tencent.mm.bq.a com_tencent_mm_plugin_report_kvdata_log_14375 = new log_14375();
                com_tencent_mm_plugin_report_kvdata_log_14375.type_ = 4;
                HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                com_tencent_mm_plugin_report_kvdata_log_14375.heavyDetailInfo_ = heavyDetailInfo;
                heavyDetailInfo.flag_ = longValue;
                String valueOf = String.valueOf(longValue);
                ar.Hg();
                long longValue2 = ((Long) com.tencent.mm.z.c.CU().get(w.a.xtV, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                ar.Hg();
                longValue2 = ((Long) com.tencent.mm.z.c.CU().get(w.a.xtW, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileRatio_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                ar.Hg();
                longValue2 = ((Long) com.tencent.mm.z.c.CU().get(w.a.xtX, Long.valueOf(0))).longValue();
                heavyDetailInfo.dbSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                ar.Hg();
                longValue2 = ((Long) com.tencent.mm.z.c.CU().get(w.a.xtY, Long.valueOf(0))).longValue();
                heavyDetailInfo.message_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                ar.Hg();
                longValue2 = ((Long) com.tencent.mm.z.c.CU().get(w.a.xtZ, Long.valueOf(0))).longValue();
                heavyDetailInfo.conversation_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                ar.Hg();
                longValue2 = ((Long) com.tencent.mm.z.c.CU().get(w.a.xua, Long.valueOf(0))).longValue();
                heavyDetailInfo.contact_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                ar.Hg();
                longValue2 = ((Long) com.tencent.mm.z.c.CU().get(w.a.xub, Long.valueOf(0))).longValue();
                heavyDetailInfo.chatroom_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                ar.Hg();
                longValue2 = ((Long) com.tencent.mm.z.c.CU().get(w.a.xuc, Long.valueOf(0))).longValue();
                heavyDetailInfo.favDbSize_ = longValue2;
                String str = valueOf + ";" + longValue2;
                ac.getContext().getSharedPreferences("heavyDetailInfo", 0).edit().putLong("sdFileSize", heavyDetailInfo.sdFileSize_).putLong("sdFileRatio", heavyDetailInfo.sdFileRatio_).putLong("dbSize", heavyDetailInfo.dbSize_).putLong("message", heavyDetailInfo.message_).putLong("conversation", heavyDetailInfo.conversation_).putLong("contact", heavyDetailInfo.contact_).putLong("chatroom", heavyDetailInfo.chatroom_).putLong("favDbSize", heavyDetailInfo.favDbSize_).putLong("flag", heavyDetailInfo.flag_).apply();
                try {
                    FileOp.j(g.Dj().cachePath + "heavyDetailInfo", new JSONObject().put("sdFileSize", heavyDetailInfo.sdFileSize_).put("sdFileRatio", heavyDetailInfo.sdFileRatio_).put("dbSize", heavyDetailInfo.dbSize_).put("message", heavyDetailInfo.message_).put("conversation", heavyDetailInfo.conversation_).put("contact", heavyDetailInfo.contact_).put("chatroom", heavyDetailInfo.chatroom_).put("favDbSize", heavyDetailInfo.favDbSize_).put("flag", heavyDetailInfo.flag_).toString().getBytes());
                } catch (JSONException e) {
                    x.e("MicroMsg.SubCoreBaseMonitor", "Failed to write heavyDetailInfo");
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(4), Integer.valueOf(1), str});
                com.tencent.mm.plugin.report.service.g.pQN.c(14375, com_tencent_mm_plugin_report_kvdata_log_14375);
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUser report heavy result[%s]", new Object[]{str});
            }
        }
    }

    static /* synthetic */ long q(p pVar) {
        ar.Hg();
        if (com.tencent.mm.z.c.isSDCardAvailable()) {
            File file = new File(com.tencent.mm.compatible.util.e.gHA);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as no files");
                    return 0;
                }
                Arrays.sort(listFiles, new 4(pVar));
                long j = 0;
                for (File name : listFiles) {
                    String name2 = name.getName();
                    if (!bh.ov(name2) && name2.endsWith(".xlog")) {
                        j = bh.getLong(name2.substring(name2.length() - 13, name2.length() - 5), 0);
                        if (j > 0) {
                            return j;
                        }
                    }
                }
                return j;
            }
            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as path not exist");
            return 0;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as sdcard not available");
        return 0;
    }

    private boolean bP(boolean z) {
        boolean z2;
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100212");
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[]{Boolean.valueOf(z), fn, Boolean.valueOf(fn.isValid()), fn.chI(), Long.valueOf(1024), Long.valueOf(10), Long.valueOf(1800), Long.valueOf(3000000), Long.valueOf(15000), Long.valueOf(15000), Long.valueOf(100000), Long.valueOf(10000), Long.valueOf(1440), Long.valueOf(20), Long.valueOf(1440)});
        if (fn.isValid()) {
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
            Map chI = fn.chI();
            long j = bh.getLong((String) chI.get("sdsize"), 1024);
            long j2 = bh.getLong((String) chI.get("sdratio"), 10);
            long j3 = bh.getLong((String) chI.get("dbsize"), 1800);
            long j4 = bh.getLong((String) chI.get("fdbsize"), 1024);
            long j5 = bh.getLong((String) chI.get("msg"), 3000000);
            long j6 = bh.getLong((String) chI.get("conv"), 15000);
            long j7 = bh.getLong((String) chI.get("contact"), 100000);
            long j8 = bh.getLong((String) chI.get("chatroom"), 10000);
            long j9 = bh.getLong((String) chI.get("sditv"), 1440);
            long j10 = bh.getLong((String) chI.get("sdwait"), 20);
            long j11 = bh.getLong((String) chI.get("dbitv"), 1440);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[]{Long.valueOf(this.hGs), Long.valueOf(j), Long.valueOf(this.hGt), Long.valueOf(j2), Long.valueOf(this.hGu), Long.valueOf(j3), Long.valueOf(this.hGz), Long.valueOf(j4), Long.valueOf(this.hGv), Long.valueOf(j5), Long.valueOf(this.hGw), Long.valueOf(j6), Long.valueOf(this.hGx), Long.valueOf(j7), Long.valueOf(this.hGy), Long.valueOf(j8), Long.valueOf(this.hGA), Long.valueOf(j9), Long.valueOf(this.hGB), Long.valueOf(j10), Long.valueOf(this.hGC), Long.valueOf(j11)});
            if (this.hGs != j) {
                this.hGs = j;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.hGt != j2) {
                this.hGt = j2;
                z2 = true;
            }
            if (this.hGu != j3) {
                this.hGu = j3;
                z2 = true;
            }
            if (this.hGz != j4) {
                this.hGz = j4;
                z2 = true;
            }
            if (this.hGv != j5) {
                this.hGv = j5;
                z2 = true;
            }
            if (this.hGw != j6) {
                this.hGw = j6;
                z2 = true;
            }
            if (this.hGx != j7) {
                this.hGx = j7;
                z2 = true;
            }
            if (this.hGy != j8) {
                this.hGy = j8;
                z2 = true;
            }
            if (this.hGA != j9) {
                this.hGA = j9;
                z2 = true;
            }
            if (this.hGB != j10) {
                this.hGB = j10;
                z2 = true;
            }
            if (this.hGC != j11) {
                this.hGC = j11;
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 0, 1, true);
            if (z) {
                com.tencent.mm.plugin.report.service.g.pQN.a(509, 18, 1, true);
            }
        }
        if (this.hGs <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 30, 1, true);
            this.hGs = 1024;
        }
        if (this.hGt <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 31, 1, true);
            this.hGt = 10;
        }
        if (this.hGu <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 32, 1, true);
            this.hGu = 1800;
        }
        if (this.hGv <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 33, 1, true);
            this.hGv = 3000000;
        }
        if (this.hGw <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 34, 1, true);
            this.hGw = 15000;
        }
        if (this.hGx <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 35, 1, true);
            this.hGx = 100000;
        }
        if (this.hGy <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 36, 1, true);
            this.hGy = 10000;
        }
        if (this.hGA <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 37, 1, true);
            this.hGA = 1440;
        }
        if (this.hGB <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 38, 1, true);
            this.hGB = 20;
        }
        if (this.hGC <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 39, 1, true);
            this.hGC = 1440;
        }
        if (this.hGz <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(509, 40, 1, true);
            this.hGz = 1024;
        }
        return z2;
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.sdk.b.a.xef.a(this.hGN);
        com.tencent.mm.z.c.c.IF().c(this.hiB);
        boolean bP = bP(false);
        ar.Hg();
        this.hGJ = ((Long) com.tencent.mm.z.c.CU().get(w.a.xtT, Long.valueOf(0))).longValue();
        com.tencent.mm.plugin.report.service.d.hD(this.hGJ != 0);
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[]{Long.valueOf(this.hGJ), Boolean.valueOf(bP), this.hiB});
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(HardCoderJNI.SETTING_SP_FILE, 0);
        g.Dk();
        g.Dh();
        if (com.tencent.mm.kernel.a.Cg() != 0) {
            g.Dk();
            g.Dh();
            int aJ = h.aJ(com.tencent.mm.kernel.a.Cg(), 100);
            if (aJ != sharedPreferences.getInt(HardCoderJNI.KEY_HC_UIN_HASH, 0)) {
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv hardcoder uin[%d, %d] reloadSPConfig", new Object[]{Integer.valueOf(r3), Integer.valueOf(aJ)});
                sharedPreferences.edit().putInt(HardCoderJNI.KEY_HC_UIN_HASH, aJ).apply();
                HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_POST_RESET);
            }
        }
        ar.CG().a(989, this.hGK);
        ar.CG().a(988, this.hGK);
        ar.CG().a(987, this.hGK);
        ar.CG().a(986, this.hGK);
        ar.Hg();
        this.hGG = ((Long) com.tencent.mm.z.c.CU().get(w.a.xsV, Long.valueOf(0))).longValue();
        Context context = ac.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            boolean z2 = intExtra == 2 || intExtra == 5;
            this.hGE = z2;
        } else {
            this.hGE = false;
        }
        this.hGF = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.hGD = new 13(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        context.registerReceiver(this.hGD, intentFilter);
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].";
        Object[] objArr = new Object[6];
        objArr[0] = this.hGI != null ? "enabled" : "disabled";
        objArr[1] = this.hGF ? "" : " not";
        objArr[2] = this.hGE ? "" : " not";
        objArr[3] = Long.valueOf(this.hGG);
        objArr[4] = Long.valueOf(this.hGA * 60000);
        objArr[5] = Long.valueOf(this.hGB * 60000);
        x.i(str, str2, objArr);
        this.hGO.TG();
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[]{Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis())});
        if (this.hGD != null) {
            ac.getContext().unregisterReceiver(this.hGD);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[]{this.hGD});
            this.hGD = null;
        }
        if (this.hGH != null) {
            ar.Dm().cfF().removeCallbacks(this.hGH);
            this.hGH = null;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[]{this.hGI});
        }
        if (this.hGI != null) {
            this.hGI.hEW = true;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[]{this.hGI});
            this.hGI = null;
        }
        ar.CG().b(989, this.hGK);
        ar.CG().b(988, this.hGK);
        ar.CG().b(987, this.hGK);
        ar.CG().b(986, this.hGK);
        com.tencent.mm.z.c.c.IF().j(this.hiB);
        com.tencent.mm.sdk.b.a.xef.c(this.hGN);
    }

    private a a(File file, a aVar, c.b bVar, c.c cVar, Map<String, Integer> map, boolean z, int i) {
        if (aVar.hEW) {
            x.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[]{aVar, bVar});
        } else {
            if (aVar.axZ < i) {
                aVar.axZ++;
            }
            if (file.isDirectory()) {
                c.b bVar2;
                String absolutePath = file.getAbsolutePath();
                if (bVar != null || map == null || map.size() <= 0 || map.get(absolutePath) == null) {
                    bVar2 = bVar;
                } else {
                    c.b bVar3 = new c.b(absolutePath, ((Integer) map.get(absolutePath)).intValue());
                    map.remove(absolutePath);
                    aVar.hEU.add(bVar3);
                    x.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[]{absolutePath, aVar, bVar3});
                    bVar2 = bVar3;
                }
                aVar.hER++;
                if (bVar2 != null) {
                    bVar2.hER++;
                }
                if (cVar != null) {
                    cVar.hER++;
                }
                if (i > 15) {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[]{Integer.valueOf(i), file.getAbsolutePath(), aVar});
                } else {
                    String[] list = file.list();
                    if (list == null) {
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[]{file.getAbsolutePath()});
                    } else if (z) {
                        c.c cVar2 = cVar;
                        for (String str : list) {
                            if (!bh.ov(str) && Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str)) {
                                cVar2 = new c.c(file.getAbsolutePath() + File.separator + str);
                                aVar.hEV.add(cVar2);
                            }
                            a(new File(file.getAbsolutePath() + File.separator + str), aVar, bVar2, cVar2, map, false, i + 1);
                        }
                    } else {
                        Object obj = 1;
                        int length = list.length;
                        int i2 = 0;
                        while (i2 < length) {
                            Object obj2;
                            a(new File(file.getAbsolutePath() + File.separator + list[i2]), aVar, bVar2, cVar, map, false, i + 1);
                            if (obj == null || aVar.axZ <= 15) {
                                obj2 = obj;
                            } else {
                                com.tencent.mm.plugin.report.service.g.pQN.a(418, 7, 1, true);
                                com.tencent.mm.plugin.report.service.g.pQN.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(2), file.getAbsolutePath() + File.separator + r18});
                                obj2 = null;
                            }
                            i2++;
                            obj = obj2;
                        }
                    }
                }
            } else {
                aVar.hES++;
                if (bVar != null) {
                    bVar.hES++;
                }
                if (cVar != null) {
                    cVar.hES++;
                }
                if (file.exists()) {
                    long length2 = file.length();
                    if (length2 <= 0 || length2 >= 2147483648L) {
                        aVar.fileLenInvalidCount++;
                        if (bVar != null) {
                            bVar.fileLenInvalidCount++;
                        }
                        if (cVar != null) {
                            cVar.hEX++;
                        }
                    } else {
                        aVar.fwg += length2;
                        if (bVar != null) {
                            bVar.fwg += length2;
                        }
                        if (cVar != null) {
                            cVar.fwg = length2 + cVar.fwg;
                        }
                    }
                } else {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[]{file.getAbsolutePath(), Long.valueOf(aVar.hES)});
                }
            }
        }
        return aVar;
    }

    private synchronized void e(int i, long j, long j2) {
        long j3;
        boolean z = j > j2;
        if (z) {
            j3 = this.hGJ | ((long) i);
        } else {
            j3 = this.hGJ & ((long) (i ^ -1));
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(this.hGJ), Long.valueOf(j3), Long.valueOf(Thread.currentThread().getId())});
        if (j3 != this.hGJ) {
            if (this.hGJ == 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(509, 1, 1, true);
            }
            if (j3 == 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(509, 2, 1, true);
            }
        }
        w.a aVar = null;
        w.a aVar2;
        switch (i) {
            case 1:
                aVar2 = w.a.xtV;
                com.tencent.mm.plugin.report.service.g.pQN.a(509, z ? 3 : 4, 1, true);
                aVar = aVar2;
                break;
            case 2:
                aVar2 = w.a.xtW;
                com.tencent.mm.plugin.report.service.g.pQN.a(509, z ? 5 : 6, 1, true);
                aVar = aVar2;
                break;
            case 4:
                aVar2 = w.a.xtX;
                com.tencent.mm.plugin.report.service.g.pQN.a(509, z ? 7 : 8, 1, true);
                aVar = aVar2;
                break;
            case 8:
                aVar2 = w.a.xtY;
                com.tencent.mm.plugin.report.service.g.pQN.a(509, z ? 9 : 10, 1, true);
                aVar = aVar2;
                break;
            case 16:
                aVar2 = w.a.xtZ;
                com.tencent.mm.plugin.report.service.g.pQN.a(509, z ? 11 : 12, 1, true);
                aVar = aVar2;
                break;
            case 32:
                aVar2 = w.a.xua;
                com.tencent.mm.plugin.report.service.g.pQN.a(509, z ? 13 : 14, 1, true);
                aVar = aVar2;
                break;
            case 64:
                aVar2 = w.a.xub;
                com.tencent.mm.plugin.report.service.g.pQN.a(509, z ? 15 : 16, 1, true);
                aVar = aVar2;
                break;
            case FileUtils.S_IWUSR /*128*/:
                aVar2 = w.a.xuc;
                com.tencent.mm.plugin.report.service.g.pQN.a(509, z ? 19 : 20, 1, true);
                aVar = aVar2;
                break;
        }
        this.hGJ = j3;
        com.tencent.mm.plugin.report.service.d.hD(j3 != 0);
        ar.Dm().F(new 6(this, j3, aVar, j));
    }
}
