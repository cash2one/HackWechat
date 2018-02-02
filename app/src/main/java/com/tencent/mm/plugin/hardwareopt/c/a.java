package com.tencent.mm.plugin.hardwareopt.c;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.n;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.protocal.c.bmc;
import com.tencent.mm.protocal.c.fc;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.protocal.c.on;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a implements com.tencent.mm.vending.c.a<aka, Context> {
    private Context mContext = null;

    private static java.lang.String Cv(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = 0;
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r2 = 18;	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        if (r0 < r2) goto L_0x0015;	 Catch:{ Exception -> 0x0019, all -> 0x002f }
    L_0x0007:
        r1 = android.media.MediaCodec.createEncoderByType(r5);	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r0 = r1.getName();	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r1.release();
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = "too low version";
        goto L_0x0014;
    L_0x0019:
        r0 = move-exception;
        r2 = "MicroMsg.TaskFindHardwareInfo";	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r3 = "hy: error in handle media codec";	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r4 = 0;	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r0 = "undefined";	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        if (r1 == 0) goto L_0x0014;
    L_0x002b:
        r1.release();
        goto L_0x0014;
    L_0x002f:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0035;
    L_0x0032:
        r1.release();
    L_0x0035:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hardwareopt.c.a.Cv(java.lang.String):java.lang.String");
    }

    public final /* synthetic */ Object call(Object obj) {
        return cU((Context) obj);
    }

    private aka cU(Context context) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        ConfigurationInfo deviceConfigurationInfo;
        vw vwVar;
        aka aSp;
        this.mContext = context;
        long nanoTime = System.nanoTime();
        try {
            fc fcVar = new fc();
            fcVar.imei = bh.eX(this.mContext);
            if (bh.ov(fcVar.imei)) {
                x.w("MicroMsg.TaskFindHardwareInfo", "hy: not got imei. maybe no permission");
                throw new a();
            }
            ActivityManager activityManager;
            MemoryInfo memoryInfo;
            aqx com_tencent_mm_protocal_c_aqx;
            StatFs statFs;
            bmc com_tencent_mm_protocal_c_bmc;
            wm wmVar;
            boolean z;
            Display defaultDisplay;
            Point point;
            int i;
            int i2;
            bed com_tencent_mm_protocal_c_bed;
            on onVar;
            String str;
            String str2;
            Object[] objArr;
            fcVar.vKV = Build.MANUFACTURER;
            fcVar.vKW = Build.MODEL;
            fcVar.vKX = VERSION.INCREMENTAL;
            com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrd = fcVar;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: imei: %s, manufacrtureName: %s, modelName: %s, incremental: %s", new Object[]{fcVar.imei, fcVar.vKV, fcVar.vKW, fcVar.vKX});
            jt jtVar = new jt();
            jtVar.vQH = Build.CPU_ABI;
            Map yt = n.yt();
            jtVar.vQF = bh.az((String) yt.get("Processor"), "");
            jtVar.vKW = (String) yt.get("model name");
            jtVar.vQI = (String) yt.get("Hardware");
            try {
                randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
                try {
                    jtVar.vQG = bh.getInt(randomAccessFile.readLine(), -1) / 1000;
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when close read cpu files", new Object[0]);
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when reading cpu frequency", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22, "hy: error when close read cpu files", new Object[0]);
                            }
                        }
                        com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wre = jtVar;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{jtVar.vQH, jtVar.vQF, Integer.valueOf(jtVar.vQG), jtVar.vKW, jtVar.vQI});
                        activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                        memoryInfo = new MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        com_tencent_mm_protocal_c_aqx = new aqx();
                        com_tencent_mm_protocal_c_aqx.wyK = (int) ((memoryInfo.totalMem / 1024) / 1024);
                        com_tencent_mm_protocal_c_aqx.wyL = (int) ((memoryInfo.threshold / 1024) / 1024);
                        com_tencent_mm_protocal_c_aqx.wyM = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
                        com_tencent_mm_protocal_c_aqx.wyN = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
                        com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrf = com_tencent_mm_protocal_c_aqx;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyK), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyL), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyM), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyN)});
                        statFs = new StatFs(e.bnD);
                        com_tencent_mm_protocal_c_bmc = new bmc();
                        if (VERSION.SDK_INT >= 18) {
                            com_tencent_mm_protocal_c_bmc.wPH = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
                        } else {
                            com_tencent_mm_protocal_c_bmc.wPH = (int) ((statFs.getTotalBytes() / 1024) / 1024);
                        }
                        com_tencent_mm_protocal_c_bmc.wPI = Environment.getExternalStorageState().equals("mounted");
                        com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrg = com_tencent_mm_protocal_c_bmc;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bmc.wPH), Boolean.valueOf(com_tencent_mm_protocal_c_bmc.wPI)});
                        deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
                        wmVar = new wm();
                        if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                            z = false;
                        } else {
                            z = true;
                        }
                        wmVar.wgN = z;
                        wmVar.wgO = deviceConfigurationInfo.reqGlEsVersion < 196608;
                        com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrk = wmVar;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s", new Object[]{Boolean.valueOf(wmVar.wgN), Boolean.valueOf(wmVar.wgO), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion)});
                        defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
                        point = new Point();
                        defaultDisplay.getSize(point);
                        i = point.x;
                        i2 = point.y;
                        com_tencent_mm_protocal_c_bed = new bed();
                        com_tencent_mm_protocal_c_bed.wJR = String.valueOf(i) + "x" + i2;
                        com_tencent_mm_protocal_c_bed.density = (int) this.mContext.getResources().getDisplayMetrics().density;
                        com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrh = com_tencent_mm_protocal_c_bed;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{com_tencent_mm_protocal_c_bed.wJR, Integer.valueOf(com_tencent_mm_protocal_c_bed.density)});
                        onVar = new on();
                        onVar.vXr = Cv("video/avc");
                        onVar.vXs = Cv("video/hevc");
                        onVar.vXt = aSq();
                        com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wri = onVar;
                        str = "MicroMsg.TaskFindHardwareInfo";
                        str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
                        objArr = new Object[3];
                        objArr[0] = onVar.vXr;
                        objArr[1] = onVar.vXs;
                        if (onVar.vXt != null) {
                            i = 0;
                        } else {
                            i = onVar.vXt.size();
                        }
                        objArr[2] = Integer.valueOf(i);
                        x.d(str, str2, objArr);
                        vwVar = new vw();
                        vwVar.wfX = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
                        if (VERSION.SDK_INT >= 18) {
                            vwVar.wfY = false;
                        } else {
                            vwVar.wfY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                        }
                        vwVar.wfZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
                        vwVar.wga = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
                        vwVar.wgb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
                        vwVar.wgc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
                        vwVar.wgd = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                        if (VERSION.SDK_INT >= 19) {
                            vwVar.wgo = false;
                        } else {
                            vwVar.wgo = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
                        }
                        vwVar.wge = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                        if (VERSION.SDK_INT < 23) {
                            vwVar.wgf = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
                        } else if (q.gFY.gGh == 1) {
                            vwVar.wgf = false;
                        } else {
                            vwVar.wgf = true;
                        }
                        vwVar.wgg = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
                        vwVar.wgh = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
                        vwVar.wgi = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
                        vwVar.wgj = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
                        if (VERSION.SDK_INT >= 19) {
                            vwVar.wgk = false;
                        } else {
                            vwVar.wgk = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                        }
                        if (VERSION.SDK_INT >= 19) {
                            vwVar.wgl = false;
                        } else {
                            vwVar.wgl = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                        }
                        vwVar.wgm = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
                        vwVar.wgn = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
                        com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrj = vwVar;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(vwVar.wfX), Boolean.valueOf(vwVar.wfY), Boolean.valueOf(vwVar.wfZ), Boolean.valueOf(vwVar.wga), Boolean.valueOf(vwVar.wgb), Boolean.valueOf(vwVar.wgc), Boolean.valueOf(vwVar.wgd), Boolean.valueOf(vwVar.wgo), Boolean.valueOf(vwVar.wge), Boolean.valueOf(vwVar.wgf), Boolean.valueOf(vwVar.wgg), Boolean.valueOf(vwVar.wgh), Boolean.valueOf(vwVar.wgi), Boolean.valueOf(vwVar.wgj), Boolean.valueOf(vwVar.wgk), Boolean.valueOf(vwVar.wgl), Boolean.valueOf(vwVar.wgm), Boolean.valueOf(vwVar.wgn)});
                        x.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
                        aSp = com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp();
                        if (aSp != null) {
                            if (aSp.wre != null) {
                                g.Dj().CU().a(com.tencent.mm.storage.w.a.xxx, Integer.valueOf(aSp.wre.vQG));
                            }
                            if (aSp.wrf != null) {
                                g.Dj().CU().a(com.tencent.mm.storage.w.a.xxy, Integer.valueOf(aSp.wrf.wyK));
                            }
                        }
                        return com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp();
                    } catch (Throwable th) {
                        e22 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e4, "hy: error when close read cpu files", new Object[0]);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22, "hy: error when reading cpu frequency", new Object[0]);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wre = jtVar;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{jtVar.vQH, jtVar.vQF, Integer.valueOf(jtVar.vQG), jtVar.vKW, jtVar.vQI});
                activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                com_tencent_mm_protocal_c_aqx = new aqx();
                com_tencent_mm_protocal_c_aqx.wyK = (int) ((memoryInfo.totalMem / 1024) / 1024);
                com_tencent_mm_protocal_c_aqx.wyL = (int) ((memoryInfo.threshold / 1024) / 1024);
                com_tencent_mm_protocal_c_aqx.wyM = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
                com_tencent_mm_protocal_c_aqx.wyN = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
                com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrf = com_tencent_mm_protocal_c_aqx;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyK), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyL), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyM), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyN)});
                statFs = new StatFs(e.bnD);
                com_tencent_mm_protocal_c_bmc = new bmc();
                if (VERSION.SDK_INT >= 18) {
                    com_tencent_mm_protocal_c_bmc.wPH = (int) ((statFs.getTotalBytes() / 1024) / 1024);
                } else {
                    com_tencent_mm_protocal_c_bmc.wPH = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
                }
                com_tencent_mm_protocal_c_bmc.wPI = Environment.getExternalStorageState().equals("mounted");
                com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrg = com_tencent_mm_protocal_c_bmc;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bmc.wPH), Boolean.valueOf(com_tencent_mm_protocal_c_bmc.wPI)});
                deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
                wmVar = new wm();
                if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    z = true;
                } else {
                    z = false;
                }
                wmVar.wgN = z;
                if (deviceConfigurationInfo.reqGlEsVersion < 196608) {
                }
                wmVar.wgO = deviceConfigurationInfo.reqGlEsVersion < 196608;
                com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrk = wmVar;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s", new Object[]{Boolean.valueOf(wmVar.wgN), Boolean.valueOf(wmVar.wgO), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion)});
                defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
                point = new Point();
                defaultDisplay.getSize(point);
                i = point.x;
                i2 = point.y;
                com_tencent_mm_protocal_c_bed = new bed();
                com_tencent_mm_protocal_c_bed.wJR = String.valueOf(i) + "x" + i2;
                com_tencent_mm_protocal_c_bed.density = (int) this.mContext.getResources().getDisplayMetrics().density;
                com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrh = com_tencent_mm_protocal_c_bed;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{com_tencent_mm_protocal_c_bed.wJR, Integer.valueOf(com_tencent_mm_protocal_c_bed.density)});
                onVar = new on();
                onVar.vXr = Cv("video/avc");
                onVar.vXs = Cv("video/hevc");
                onVar.vXt = aSq();
                com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wri = onVar;
                str = "MicroMsg.TaskFindHardwareInfo";
                str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
                objArr = new Object[3];
                objArr[0] = onVar.vXr;
                objArr[1] = onVar.vXs;
                if (onVar.vXt != null) {
                    i = onVar.vXt.size();
                } else {
                    i = 0;
                }
                objArr[2] = Integer.valueOf(i);
                x.d(str, str2, objArr);
                vwVar = new vw();
                vwVar.wfX = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
                if (VERSION.SDK_INT >= 18) {
                    vwVar.wfY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                } else {
                    vwVar.wfY = false;
                }
                vwVar.wfZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
                vwVar.wga = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
                vwVar.wgb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
                vwVar.wgc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
                vwVar.wgd = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                if (VERSION.SDK_INT >= 19) {
                    vwVar.wgo = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
                } else {
                    vwVar.wgo = false;
                }
                vwVar.wge = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                if (VERSION.SDK_INT < 23) {
                    vwVar.wgf = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
                } else if (q.gFY.gGh == 1) {
                    vwVar.wgf = true;
                } else {
                    vwVar.wgf = false;
                }
                vwVar.wgg = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
                vwVar.wgh = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
                vwVar.wgi = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
                vwVar.wgj = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
                if (VERSION.SDK_INT >= 19) {
                    vwVar.wgk = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                } else {
                    vwVar.wgk = false;
                }
                if (VERSION.SDK_INT >= 19) {
                    vwVar.wgl = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                } else {
                    vwVar.wgl = false;
                }
                vwVar.wgm = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
                vwVar.wgn = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
                com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrj = vwVar;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(vwVar.wfX), Boolean.valueOf(vwVar.wfY), Boolean.valueOf(vwVar.wfZ), Boolean.valueOf(vwVar.wga), Boolean.valueOf(vwVar.wgb), Boolean.valueOf(vwVar.wgc), Boolean.valueOf(vwVar.wgd), Boolean.valueOf(vwVar.wgo), Boolean.valueOf(vwVar.wge), Boolean.valueOf(vwVar.wgf), Boolean.valueOf(vwVar.wgg), Boolean.valueOf(vwVar.wgh), Boolean.valueOf(vwVar.wgi), Boolean.valueOf(vwVar.wgj), Boolean.valueOf(vwVar.wgk), Boolean.valueOf(vwVar.wgl), Boolean.valueOf(vwVar.wgm), Boolean.valueOf(vwVar.wgn)});
                x.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
                aSp = com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp();
                if (aSp != null) {
                    if (aSp.wre != null) {
                        g.Dj().CU().a(com.tencent.mm.storage.w.a.xxx, Integer.valueOf(aSp.wre.vQG));
                    }
                    if (aSp.wrf != null) {
                        g.Dj().CU().a(com.tencent.mm.storage.w.a.xxy, Integer.valueOf(aSp.wrf.wyK));
                    }
                }
                return com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp();
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e22;
            }
            com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wre = jtVar;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{jtVar.vQH, jtVar.vQF, Integer.valueOf(jtVar.vQG), jtVar.vKW, jtVar.vQI});
            activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            com_tencent_mm_protocal_c_aqx = new aqx();
            com_tencent_mm_protocal_c_aqx.wyK = (int) ((memoryInfo.totalMem / 1024) / 1024);
            com_tencent_mm_protocal_c_aqx.wyL = (int) ((memoryInfo.threshold / 1024) / 1024);
            com_tencent_mm_protocal_c_aqx.wyM = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
            com_tencent_mm_protocal_c_aqx.wyN = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
            com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrf = com_tencent_mm_protocal_c_aqx;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyK), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyL), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyM), Integer.valueOf(com_tencent_mm_protocal_c_aqx.wyN)});
            statFs = new StatFs(e.bnD);
            com_tencent_mm_protocal_c_bmc = new bmc();
            if (VERSION.SDK_INT >= 18) {
                com_tencent_mm_protocal_c_bmc.wPH = (int) ((statFs.getTotalBytes() / 1024) / 1024);
            } else {
                com_tencent_mm_protocal_c_bmc.wPH = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
            }
            com_tencent_mm_protocal_c_bmc.wPI = Environment.getExternalStorageState().equals("mounted");
            com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrg = com_tencent_mm_protocal_c_bmc;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bmc.wPH), Boolean.valueOf(com_tencent_mm_protocal_c_bmc.wPI)});
            deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
            wmVar = new wm();
            if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                z = true;
            } else {
                z = false;
            }
            wmVar.wgN = z;
            if (deviceConfigurationInfo.reqGlEsVersion < 196608) {
            }
            wmVar.wgO = deviceConfigurationInfo.reqGlEsVersion < 196608;
            com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrk = wmVar;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s", new Object[]{Boolean.valueOf(wmVar.wgN), Boolean.valueOf(wmVar.wgO), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion)});
            defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            point = new Point();
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
            com_tencent_mm_protocal_c_bed = new bed();
            com_tencent_mm_protocal_c_bed.wJR = String.valueOf(i) + "x" + i2;
            com_tencent_mm_protocal_c_bed.density = (int) this.mContext.getResources().getDisplayMetrics().density;
            com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrh = com_tencent_mm_protocal_c_bed;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{com_tencent_mm_protocal_c_bed.wJR, Integer.valueOf(com_tencent_mm_protocal_c_bed.density)});
            onVar = new on();
            onVar.vXr = Cv("video/avc");
            onVar.vXs = Cv("video/hevc");
            onVar.vXt = aSq();
            com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wri = onVar;
            str = "MicroMsg.TaskFindHardwareInfo";
            str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
            objArr = new Object[3];
            objArr[0] = onVar.vXr;
            objArr[1] = onVar.vXs;
            if (onVar.vXt != null) {
                i = onVar.vXt.size();
            } else {
                i = 0;
            }
            objArr[2] = Integer.valueOf(i);
            x.d(str, str2, objArr);
            vwVar = new vw();
            vwVar.wfX = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
            if (VERSION.SDK_INT >= 18) {
                vwVar.wfY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            } else {
                vwVar.wfY = false;
            }
            vwVar.wfZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
            vwVar.wga = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            vwVar.wgb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
            vwVar.wgc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
            vwVar.wgd = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT >= 19) {
                vwVar.wgo = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
            } else {
                vwVar.wgo = false;
            }
            vwVar.wge = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT < 23) {
                vwVar.wgf = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
            } else if (q.gFY.gGh == 1) {
                vwVar.wgf = true;
            } else {
                vwVar.wgf = false;
            }
            vwVar.wgg = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
            vwVar.wgh = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
            vwVar.wgi = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
            vwVar.wgj = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
            if (VERSION.SDK_INT >= 19) {
                vwVar.wgk = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
            } else {
                vwVar.wgk = false;
            }
            if (VERSION.SDK_INT >= 19) {
                vwVar.wgl = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
            } else {
                vwVar.wgl = false;
            }
            vwVar.wgm = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
            vwVar.wgn = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
            com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp().wrj = vwVar;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(vwVar.wfX), Boolean.valueOf(vwVar.wfY), Boolean.valueOf(vwVar.wfZ), Boolean.valueOf(vwVar.wga), Boolean.valueOf(vwVar.wgb), Boolean.valueOf(vwVar.wgc), Boolean.valueOf(vwVar.wgd), Boolean.valueOf(vwVar.wgo), Boolean.valueOf(vwVar.wge), Boolean.valueOf(vwVar.wgf), Boolean.valueOf(vwVar.wgg), Boolean.valueOf(vwVar.wgh), Boolean.valueOf(vwVar.wgi), Boolean.valueOf(vwVar.wgj), Boolean.valueOf(vwVar.wgk), Boolean.valueOf(vwVar.wgl), Boolean.valueOf(vwVar.wgm), Boolean.valueOf(vwVar.wgn)});
            x.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
            try {
                aSp = com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp();
                if (aSp != null) {
                    if (aSp.wre != null) {
                        g.Dj().CU().a(com.tencent.mm.storage.w.a.xxx, Integer.valueOf(aSp.wre.vQG));
                    }
                    if (aSp.wrf != null) {
                        g.Dj().CU().a(com.tencent.mm.storage.w.a.xxy, Integer.valueOf(aSp.wrf.wyK));
                    }
                }
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e222, "alvinluo save hardware info to config storage exception", new Object[0]);
            }
            return com.tencent.mm.plugin.hardwareopt.b.a.aSo().aSp();
        } catch (Throwable e2222) {
            x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2222, "hy: exception when find hardware info", new Object[0]);
            b czX = com.tencent.mm.vending.g.g.czX();
            if (czX != null) {
                czX.cl(null);
            }
            return null;
        }
    }

    private static LinkedList<arc> aSq() {
        int codecCount = MediaCodecList.getCodecCount();
        LinkedList<arc> linkedList = new LinkedList();
        Map hashMap = new HashMap();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    Set set = (Set) hashMap.get(str.toLowerCase());
                    if (set == null) {
                        set = new HashSet();
                    }
                    set.add(codecInfoAt.getName());
                    hashMap.put(str.toLowerCase(), set);
                }
            }
        }
        x.i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", new Object[]{hashMap});
        for (Entry entry : hashMap.entrySet()) {
            arc com_tencent_mm_protocal_c_arc = new arc();
            com_tencent_mm_protocal_c_arc.opJ = (String) entry.getKey();
            LinkedList linkedList2 = new LinkedList();
            if (entry.getValue() != null) {
                linkedList2.addAll((Collection) entry.getValue());
            }
            com_tencent_mm_protocal_c_arc.wyW = linkedList2;
            linkedList.add(com_tencent_mm_protocal_c_arc);
        }
        return linkedList;
    }
}
