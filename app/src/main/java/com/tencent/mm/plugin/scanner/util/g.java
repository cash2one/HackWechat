package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.licence.model.BankCardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class g extends b {
    private int mCount = 0;
    private boolean qag = false;
    public boolean qah;
    private boolean qai;
    public boolean[] qaj = new boolean[4];
    private boolean qak;
    private boolean qal;
    private boolean qam;
    private Bitmap qan;
    private final Object qao = new Object();

    public g(a aVar, boolean z, boolean z2) {
        super(aVar);
        this.qah = z;
        this.qai = z2;
        x.d("MicroMsg.ScanBankCardDecoder", "isPortrait:%s, needRotate:%s", new Object[]{Boolean.valueOf(false), Boolean.valueOf(z)});
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        int focusedEngineForBankcardInit;
        int i;
        FileOutputStream fileOutputStream;
        Throwable e;
        long currentTimeMillis;
        BankCardInfo bankCardInfo;
        int recognizeBankCardProcess;
        boolean z2;
        Options options;
        int[] rectX;
        int[] rectY;
        int i2;
        int i3;
        synchronized (this.qao) {
            long currentTimeMillis2 = System.currentTimeMillis();
            x.d("MicroMsg.ScanBankCardDecoder", "resolution:%s, coverage:%s", new Object[]{point, rect});
            if (true == this.qak) {
                x.d("MicroMsg.ScanBankCardDecoder", "recognize bank succeed, no need more handle");
                z = false;
            } else {
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.15f);
                int width = (((int) (((float) rect.width()) * (1.0f + ((min - 1.0f) * 1.6f)))) / 4) * 4;
                int height = (((int) (((float) rect.height()) * min)) / 4) * 4;
                x.d("MicroMsg.ScanBankCardDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[]{Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height)});
                if (!this.qal) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    focusedEngineForBankcardInit = QbarNative.focusedEngineForBankcardInit(width, height, 8, this.qag);
                    x.d("MicroMsg.ScanBankCardDecoder", "focusedEngineForBankcardInit, cost: " + (System.currentTimeMillis() - currentTimeMillis3));
                    if (focusedEngineForBankcardInit != 0) {
                        x.e("MicroMsg.ScanBankCardDecoder", "init failed on init focusedEngine:" + focusedEngineForBankcardInit);
                        z = false;
                    } else {
                        this.qal = true;
                    }
                }
                if (!this.qam && true == this.qal) {
                    x.d("MicroMsg.ScanBankCardDecoder", "init param:%d, %d, %d, %d, %s", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()), Boolean.valueOf(this.qag)});
                    this.qam = LibCardRecog.recognizeBankCardInit(width, height, this.qag) == 0;
                }
                x.d("MicroMsg.ScanBankCardDecoder", "crop image start:%d, %d, dataLen:%d", new Object[]{Integer.valueOf(rect.left - ((width - rect.width()) / 2)), Integer.valueOf(rect.top - ((height - rect.height()) / 2)), Integer.valueOf(bArr.length)});
                String value = com.tencent.mm.k.g.zY().getValue("debug_scan_bank");
                if (value != null && value.equals("true")) {
                    this.mCount++;
                    i = point.x;
                    int i4 = point.y;
                    int i5 = this.mCount;
                    String str = "_scanImage_org.jpeg";
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i4, null);
                    x.d("MicroMsg.ScanBankCardDecoder", "decode() compress jpeg by YuvImage");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i, i4), 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        fileOutputStream = new FileOutputStream(new File(h.getExternalStorageDirectory().getAbsolutePath() + "/test/" + String.valueOf(i5) + str));
                        try {
                            fileOutputStream.write(toByteArray);
                            fileOutputStream.flush();
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2, "", new Object[0]);
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                            }
                        } catch (IOException e3) {
                            e22 = e3;
                            try {
                                x.e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e22.getMessage()});
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable e222) {
                                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e222, "", new Object[0]);
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
                                }
                                currentTimeMillis = System.currentTimeMillis();
                                bankCardInfo = new BankCardInfo(point.x, point.y);
                                recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qaj);
                                x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                                if (!this.qah) {
                                    z2 = this.qaj[0];
                                    this.qaj[0] = this.qaj[2];
                                    this.qaj[2] = z2;
                                    z2 = this.qaj[1];
                                    this.qaj[1] = this.qaj[3];
                                    this.qaj[3] = z2;
                                }
                                x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                                if (recognizeBankCardProcess != 1) {
                                    x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                                    z = false;
                                } else {
                                    options = new Options();
                                    options.inSampleSize = 1;
                                    this.qan = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options).copy(Config.ARGB_8888, true);
                                    if (this.qan == null) {
                                        z = false;
                                    } else {
                                        rectX = bankCardInfo.getRectX();
                                        rectY = bankCardInfo.getRectY();
                                        i2 = (rectX[bankCardInfo.getCardNumLen() - 1] - rectX[0]) + (rectX[1] - rectX[0]);
                                        recognizeBankCardProcess = (int) (((float) i2) * 0.21319798f);
                                        i3 = (int) (((float) rectX[0]) - (((float) i2) * 0.04568528f));
                                        i = i3 > 0 ? i3 : 0;
                                        i3 = ((int) (((float) (i2 * 2)) * 0.04568528f)) + i2;
                                        focusedEngineForBankcardInit = (int) ((((float) rectY[0]) + ((((float) (rectX[1] - rectX[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                                        if (focusedEngineForBankcardInit <= 0) {
                                            focusedEngineForBankcardInit = 0;
                                        }
                                        if (i + i3 > bankCardInfo.width) {
                                            i3 = bankCardInfo.width - i;
                                        }
                                        if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                                            recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                                        }
                                        this.qan = Bitmap.createBitmap(this.qan, i, focusedEngineForBankcardInit, i3, recognizeBankCardProcess);
                                        pZH = 3;
                                        if (this.qai) {
                                            this.pZG = bankCardInfo.getCardNum();
                                        } else {
                                            this.pZG = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX);
                                        }
                                        this.qak = true;
                                        x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                                        z = true;
                                    }
                                }
                                return z;
                            } catch (Throwable th) {
                                e2222 = th;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Throwable e4) {
                                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e4, "", new Object[0]);
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable e42) {
                                    x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e42, "", new Object[0]);
                                }
                                throw e2222;
                            }
                        }
                    } catch (IOException e5) {
                        e2222 = e5;
                        fileOutputStream = null;
                        x.e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e2222.getMessage()});
                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        byteArrayOutputStream.close();
                        currentTimeMillis = System.currentTimeMillis();
                        bankCardInfo = new BankCardInfo(point.x, point.y);
                        recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qaj);
                        x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                        if (this.qah) {
                            z2 = this.qaj[0];
                            this.qaj[0] = this.qaj[2];
                            this.qaj[2] = z2;
                            z2 = this.qaj[1];
                            this.qaj[1] = this.qaj[3];
                            this.qaj[3] = z2;
                        }
                        x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                        if (recognizeBankCardProcess != 1) {
                            options = new Options();
                            options.inSampleSize = 1;
                            this.qan = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options).copy(Config.ARGB_8888, true);
                            if (this.qan == null) {
                                rectX = bankCardInfo.getRectX();
                                rectY = bankCardInfo.getRectY();
                                i2 = (rectX[bankCardInfo.getCardNumLen() - 1] - rectX[0]) + (rectX[1] - rectX[0]);
                                recognizeBankCardProcess = (int) (((float) i2) * 0.21319798f);
                                i3 = (int) (((float) rectX[0]) - (((float) i2) * 0.04568528f));
                                if (i3 > 0) {
                                }
                                i3 = ((int) (((float) (i2 * 2)) * 0.04568528f)) + i2;
                                focusedEngineForBankcardInit = (int) ((((float) rectY[0]) + ((((float) (rectX[1] - rectX[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                                if (focusedEngineForBankcardInit <= 0) {
                                    focusedEngineForBankcardInit = 0;
                                }
                                if (i + i3 > bankCardInfo.width) {
                                    i3 = bankCardInfo.width - i;
                                }
                                if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                                    recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                                }
                                this.qan = Bitmap.createBitmap(this.qan, i, focusedEngineForBankcardInit, i3, recognizeBankCardProcess);
                                pZH = 3;
                                if (this.qai) {
                                    this.pZG = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX);
                                } else {
                                    this.pZG = bankCardInfo.getCardNum();
                                }
                                this.qak = true;
                                x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                            z = false;
                        }
                        return z;
                    } catch (Throwable th2) {
                        e2222 = th2;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        byteArrayOutputStream.close();
                        throw e2222;
                    }
                }
                currentTimeMillis = System.currentTimeMillis();
                bankCardInfo = new BankCardInfo(point.x, point.y);
                recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qaj);
                x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (this.qah) {
                    z2 = this.qaj[0];
                    this.qaj[0] = this.qaj[2];
                    this.qaj[2] = z2;
                    z2 = this.qaj[1];
                    this.qaj[1] = this.qaj[3];
                    this.qaj[3] = z2;
                }
                x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                if (recognizeBankCardProcess != 1) {
                    x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                    z = false;
                } else {
                    options = new Options();
                    options.inSampleSize = 1;
                    this.qan = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options).copy(Config.ARGB_8888, true);
                    if (this.qan == null) {
                        z = false;
                    } else {
                        rectX = bankCardInfo.getRectX();
                        rectY = bankCardInfo.getRectY();
                        i2 = (rectX[bankCardInfo.getCardNumLen() - 1] - rectX[0]) + (rectX[1] - rectX[0]);
                        recognizeBankCardProcess = (int) (((float) i2) * 0.21319798f);
                        i3 = (int) (((float) rectX[0]) - (((float) i2) * 0.04568528f));
                        if (i3 > 0) {
                        }
                        i3 = ((int) (((float) (i2 * 2)) * 0.04568528f)) + i2;
                        focusedEngineForBankcardInit = (int) ((((float) rectY[0]) + ((((float) (rectX[1] - rectX[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                        if (focusedEngineForBankcardInit <= 0) {
                            focusedEngineForBankcardInit = 0;
                        }
                        if (i + i3 > bankCardInfo.width) {
                            i3 = bankCardInfo.width - i;
                        }
                        if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                            recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                        }
                        this.qan = Bitmap.createBitmap(this.qan, i, focusedEngineForBankcardInit, i3, recognizeBankCardProcess);
                        pZH = 3;
                        if (this.qai) {
                            this.pZG = bankCardInfo.getCardNum();
                        } else {
                            this.pZG = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX);
                        }
                        this.qak = true;
                        x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public final void kL() {
        synchronized (this.qao) {
            if (true == this.qal) {
                QbarNative.focusedEngineRelease();
                this.qal = false;
            }
            if (true == this.qam) {
                LibCardRecog.recognizeBankCardRelease();
            }
            this.qan = null;
        }
    }

    public final void bpv() {
        kL();
    }

    public final Bitmap bpB() {
        Bitmap bitmap;
        synchronized (this.qao) {
            bitmap = this.qan;
        }
        return bitmap;
    }
}
