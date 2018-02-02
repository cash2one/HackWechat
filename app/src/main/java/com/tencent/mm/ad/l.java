package com.tencent.mm.ad;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bqj;
import com.tencent.mm.protocal.c.bqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.IOException;
import java.io.OutputStream;

public final class l extends k implements com.tencent.mm.network.k {
    private String fzs;
    private e gJT;
    private String hlH;
    private String hlI;
    private String hlJ = q.FS();
    private int hlp;
    private int hlq;
    private int hlr;

    private static int ae(String str, String str2) {
        int intValue;
        OutputStream outputStream;
        Options UL = d.UL(str);
        if (UL.outHeight >= 640 || UL.outWidth >= 640) {
            int indexOf;
            int intValue2;
            int i;
            int i2;
            double sqrt;
            Bitmap decodeFile;
            Bitmap createScaledBitmap;
            int i3 = 50;
            try {
                if (an.isWifi(ac.getContext())) {
                    i3 = bh.getInt(((a) g.h(a.class)).zY().getValue("HeadImageCompressPicLevelForWifi"), 50);
                } else if (an.is2G(ac.getContext())) {
                    i3 = bh.getInt(((a) g.h(a.class)).zY().getValue("HeadImageCompressPicLevelFor2G"), 50);
                } else if (an.is3G(ac.getContext())) {
                    i3 = bh.getInt(((a) g.h(a.class)).zY().getValue("HeadImageCompressPicLevelFor3G"), 50);
                } else {
                    i3 = bh.getInt(((a) g.h(a.class)).zY().getValue("HeadImageCompressPicLevelFor4G"), 50);
                }
            } catch (Exception e) {
            }
            try {
                String value;
                if (an.isWifi(ac.getContext())) {
                    value = ((a) g.h(a.class)).zY().getValue("HeadImageCompressResolutionForWifi");
                } else if (an.is2G(ac.getContext())) {
                    value = ((a) g.h(a.class)).zY().getValue("HeadImageCompressResolutionFor2G");
                } else if (an.is3G(ac.getContext())) {
                    value = ((a) g.h(a.class)).zY().getValue("HeadImageCompressResolutionFor3G");
                } else {
                    value = ((a) g.h(a.class)).zY().getValue("HeadImageCompressResolutionFor4G");
                }
                indexOf = value.indexOf("*");
                if (-1 != indexOf) {
                    intValue2 = Integer.valueOf(value.substring(0, indexOf)).intValue();
                    intValue = Integer.valueOf(value.substring(indexOf + 1)).intValue();
                    i = intValue2;
                    if (i > 0 && intValue <= 0) {
                        i = 0;
                        intValue = 1080;
                    } else if (intValue < 2160) {
                        i = 0;
                        intValue = 1080;
                    } else if (intValue <= 0 && i > 3240) {
                        i = 1620;
                        intValue = 0;
                    }
                    intValue2 = UL.outWidth <= UL.outHeight ? UL.outWidth : UL.outHeight;
                    indexOf = UL.outWidth >= UL.outHeight ? UL.outWidth : UL.outHeight;
                    x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(i3), Integer.valueOf(UL.outWidth), Integer.valueOf(UL.outHeight));
                    if (intValue <= 0) {
                        i = indexOf / intValue;
                        intValue2 = (UL.outHeight * intValue) / indexOf;
                        intValue = (intValue * UL.outWidth) / indexOf;
                        indexOf = i;
                        i = intValue;
                        intValue = intValue2;
                    } else {
                        intValue = intValue2 / i;
                        indexOf = (UL.outHeight * i) / intValue2;
                        i = (i * UL.outWidth) / intValue2;
                        i2 = intValue;
                        intValue = indexOf;
                        indexOf = i2;
                    }
                    if (intValue * i > 10240000) {
                        sqrt = Math.sqrt(1.024E7d / ((double) (intValue * i)));
                        intValue = (int) (((double) intValue) / sqrt);
                        i = (int) (((double) i) / sqrt);
                    }
                    UL = new Options();
                    UL.inPreferredConfig = Config.ARGB_8888;
                    if (indexOf >= 2) {
                        UL.inSampleSize = indexOf;
                    }
                    decodeFile = d.decodeFile(str, UL);
                    if (decodeFile != null) {
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(UL.inSampleSize));
                        return 0 - com.tencent.mm.compatible.util.g.getLine();
                    }
                    x.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
                    if (indexOf <= 1) {
                        createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, intValue, true);
                        if (decodeFile != createScaledBitmap) {
                            x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                            decodeFile.recycle();
                        }
                        if (createScaledBitmap == null) {
                            x.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                            return 0 - com.tencent.mm.compatible.util.g.getLine();
                        }
                    }
                    createScaledBitmap = decodeFile;
                    outputStream = null;
                    try {
                        outputStream = FileOp.iE(str2);
                        createScaledBitmap.compress(CompressFormat.JPEG, i3, outputStream);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s, fileSize:%d -> %d", createScaledBitmap.toString(), Long.valueOf(FileOp.me(str)), Long.valueOf(FileOp.me(str2)));
                        createScaledBitmap.recycle();
                        return 0;
                    } catch (Throwable e3) {
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "open FileOutputStream fail");
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "exception:%s", bh.i(e3));
                        x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                        createScaledBitmap.recycle();
                        intValue = 0 - com.tencent.mm.compatible.util.g.getLine();
                        if (outputStream == null) {
                            return intValue;
                        }
                        try {
                            outputStream.close();
                            return intValue;
                        } catch (IOException e4) {
                            return intValue;
                        }
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                    }
                }
            } catch (Exception e6) {
            }
            intValue = 1080;
            i = 0;
            if (i > 0) {
            }
            if (intValue < 2160) {
                i = 1620;
                intValue = 0;
            } else {
                i = 0;
                intValue = 1080;
            }
            if (UL.outWidth <= UL.outHeight) {
            }
            if (UL.outWidth >= UL.outHeight) {
            }
            x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(i3), Integer.valueOf(UL.outWidth), Integer.valueOf(UL.outHeight));
            if (intValue <= 0) {
                intValue = intValue2 / i;
                indexOf = (UL.outHeight * i) / intValue2;
                i = (i * UL.outWidth) / intValue2;
                i2 = intValue;
                intValue = indexOf;
                indexOf = i2;
            } else {
                i = indexOf / intValue;
                intValue2 = (UL.outHeight * intValue) / indexOf;
                intValue = (intValue * UL.outWidth) / indexOf;
                indexOf = i;
                i = intValue;
                intValue = intValue2;
            }
            if (intValue * i > 10240000) {
                sqrt = Math.sqrt(1.024E7d / ((double) (intValue * i)));
                intValue = (int) (((double) intValue) / sqrt);
                i = (int) (((double) i) / sqrt);
            }
            UL = new Options();
            UL.inPreferredConfig = Config.ARGB_8888;
            if (indexOf >= 2) {
                UL.inSampleSize = indexOf;
            }
            decodeFile = d.decodeFile(str, UL);
            if (decodeFile != null) {
                x.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
                if (indexOf <= 1) {
                    createScaledBitmap = decodeFile;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, intValue, true);
                    if (decodeFile != createScaledBitmap) {
                        x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                        decodeFile.recycle();
                    }
                    if (createScaledBitmap == null) {
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                        return 0 - com.tencent.mm.compatible.util.g.getLine();
                    }
                }
                outputStream = null;
                outputStream = FileOp.iE(str2);
                createScaledBitmap.compress(CompressFormat.JPEG, i3, outputStream);
                if (outputStream != null) {
                    outputStream.close();
                }
                x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s, fileSize:%d -> %d", createScaledBitmap.toString(), Long.valueOf(FileOp.me(str)), Long.valueOf(FileOp.me(str2)));
                createScaledBitmap.recycle();
                return 0;
            }
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(UL.inSampleSize));
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
        FileOp.x(str, str2);
        x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG copySrc outHeight and outWidth: %d,%d , do not scale.", Integer.valueOf(UL.outHeight), Integer.valueOf(UL.outWidth));
        return 0;
    }

    public l(int i, String str) {
        if (i == 2) {
            this.hlJ = com.tencent.mm.storage.x.WD(this.hlJ);
        }
        n.Jz();
        this.hlH = d.x(this.hlJ, true);
        String str2 = this.hlH + ".tmp";
        if (ae(str, str2) == 0) {
            this.fzs = str2;
            this.hlr = i;
            n.Jz();
            this.hlI = com.tencent.mm.a.g.s(FileOp.d(d.x(this.hlJ, true), 0, -1));
            this.hlp = 0;
            this.hlq = 0;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (this.fzs == null || this.fzs.length() == 0) {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
            return -1;
        } else if (FileOp.bO(this.fzs)) {
            if (this.hlp == 0) {
                this.hlp = (int) FileOp.me(this.fzs);
            }
            byte[] d = FileOp.d(this.fzs, this.hlq, Math.min(this.hlp - this.hlq, 8192));
            if (d == null) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
                return -1;
            }
            x.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(d.length), Integer.valueOf(this.hlp));
            b.a aVar = new b.a();
            aVar.hmj = new bqj();
            aVar.hmk = new bqk();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
            aVar.hmi = 157;
            aVar.hml = 46;
            aVar.hmm = 1000000046;
            com.tencent.mm.network.q JZ = aVar.JZ();
            bqj com_tencent_mm_protocal_c_bqj = (bqj) JZ.hmg.hmo;
            com_tencent_mm_protocal_c_bqj.vIB = this.hlp;
            com_tencent_mm_protocal_c_bqj.vIC = this.hlq;
            com_tencent_mm_protocal_c_bqj.wln = this.hlr;
            com_tencent_mm_protocal_c_bqj.vXz = new bdn().bj(d);
            com_tencent_mm_protocal_c_bqj.wRP = this.hlI;
            return a(eVar, JZ, this);
        } else {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.fzs);
            return -1;
        }
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        if (this.fzs == null || this.fzs.length() == 0) {
            return b.hmQ;
        }
        return b.hmP;
    }

    protected final int Bh() {
        return 200;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        int i4 = 0;
        bqk com_tencent_mm_protocal_c_bqk = (bqk) ((b) qVar).hmh.hmo;
        x.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 4 || i2 == 5) {
            this.gJT.a(i2, i3, str, this);
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:" + i2);
        } else {
            if (qVar.Hp().vBp == -4) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", Integer.valueOf(qVar.Hp().vBp));
                i4 = 1;
            }
            if (i4 != 0) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
                this.gJT.a(i2, i3, str, this);
                return;
            }
            this.hlq = com_tencent_mm_protocal_c_bqk.vIC;
            if (this.hlq < this.hlp) {
                if (a(this.hmA, this.gJT) < 0) {
                    x.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
                    this.gJT.a(3, -1, "", this);
                }
                x.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
                return;
            }
            try {
                FileOp.at(this.fzs, this.hlH);
                g.Dj().CU().set(12297, com_tencent_mm_protocal_c_bqk.wRQ);
                n.Jz().e(this.hlJ, d.UN(this.hlH));
                String FS = q.FS();
                if (!bh.ov(FS)) {
                    h hVar = new h();
                    hVar.username = FS;
                    hVar.bA(true);
                    hVar.fDt = 32;
                    hVar.fWe = 3;
                    hVar.fDt = 34;
                    n.JQ().a(hVar);
                }
                this.gJT.a(i2, i3, str, this);
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + e.getMessage());
                this.gJT.a(3, -1, "", this);
            }
        }
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 157;
    }
}
