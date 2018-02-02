package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class g$1 implements Runnable {
    final /* synthetic */ g lMw;

    g$1(g gVar) {
        this.lMw = gVar;
    }

    public final void run() {
        BufferedOutputStream bufferedOutputStream;
        Throwable e;
        akm com_tencent_mm_protocal_c_akm;
        String str;
        int i;
        String str2;
        String str3 = null;
        try {
            String str4 = e.gHt + String.format("%s%d.%s", new Object[]{SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, Integer.valueOf(this.lMw.fzT.hashCode()), "jpg"});
            byte[] yS = g.yS(this.lMw.fzT);
            if (yS != null) {
                String str5;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(yS, 0, yS.length);
                g gVar = this.lMw;
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str4)));
                    try {
                        decodeByteArray.compress(CompressFormat.JPEG, 80, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        try {
                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                            g.cm(gVar.lMt, gVar.lMa);
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            this.lMw.lLX = str4;
                            if (this.lMw.lLX == null) {
                            }
                            com_tencent_mm_protocal_c_akm = new akm();
                            str5 = this.lMw.lLX;
                            if (str5 != null) {
                            }
                            str = null;
                            i = -1;
                            str2 = null;
                            com_tencent_mm_protocal_c_akm.waP = str3;
                            com_tencent_mm_protocal_c_akm.nfp = str2;
                            com_tencent_mm_protocal_c_akm.ktH = i;
                            com_tencent_mm_protocal_c_akm.vZL = str;
                            this.lMw.lMr.wrH = com_tencent_mm_protocal_c_akm;
                            this.lMw.lMr.wrE = 3;
                            ar.CG().a(new n(this.lMw.lMr, this.lMw.lMs, this.lMw.lMt, this.lMw.lMu), 0);
                            return;
                        } catch (Throwable th) {
                            e22 = th;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e4, "", new Object[0]);
                                }
                            }
                            throw e22;
                        }
                    }
                } catch (IOException e5) {
                    e22 = e5;
                    bufferedOutputStream = null;
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                    g.cm(gVar.lMt, gVar.lMa);
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    this.lMw.lLX = str4;
                    if (this.lMw.lLX == null) {
                    }
                    com_tencent_mm_protocal_c_akm = new akm();
                    str5 = this.lMw.lLX;
                    if (str5 != null) {
                    }
                    str = null;
                    i = -1;
                    str2 = null;
                    com_tencent_mm_protocal_c_akm.waP = str3;
                    com_tencent_mm_protocal_c_akm.nfp = str2;
                    com_tencent_mm_protocal_c_akm.ktH = i;
                    com_tencent_mm_protocal_c_akm.vZL = str;
                    this.lMw.lMr.wrH = com_tencent_mm_protocal_c_akm;
                    this.lMw.lMr.wrE = 3;
                    ar.CG().a(new n(this.lMw.lMr, this.lMw.lMs, this.lMw.lMt, this.lMw.lMu), 0);
                    return;
                } catch (Throwable th2) {
                    e22 = th2;
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw e22;
                }
                this.lMw.lLX = str4;
                if (this.lMw.lLX == null || FileOp.bO(this.lMw.lLX)) {
                    com_tencent_mm_protocal_c_akm = new akm();
                    str5 = this.lMw.lLX;
                    if (str5 != null || str5.length() <= 0) {
                        str = null;
                        i = -1;
                        str2 = null;
                    } else {
                        File file = new File(str5);
                        str2 = file.getName();
                        i = (int) file.length();
                        str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
                        str = g.i(file);
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable filePath %s", new Object[]{str5});
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileSize %s", new Object[]{Integer.valueOf(i)});
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileMd5 %s", new Object[]{str});
                    }
                    com_tencent_mm_protocal_c_akm.waP = str3;
                    com_tencent_mm_protocal_c_akm.nfp = str2;
                    com_tencent_mm_protocal_c_akm.ktH = i;
                    com_tencent_mm_protocal_c_akm.vZL = str;
                    this.lMw.lMr.wrH = com_tencent_mm_protocal_c_akm;
                    this.lMw.lMr.wrE = 3;
                    ar.CG().a(new n(this.lMw.lMr, this.lMw.lMs, this.lMw.lMt, this.lMw.lMu), 0);
                    return;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mSnsImagePath is null or file not exist!");
                g.cm(this.lMw.lMt, this.lMw.lMa);
                return;
            }
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get image error !");
            g.cm(this.lMw.lMt, this.lMw.lMa);
        } catch (Throwable e222) {
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
        }
    }
}
