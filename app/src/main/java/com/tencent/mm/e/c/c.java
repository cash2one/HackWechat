package com.tencent.mm.e.c;

import com.tencent.mm.compatible.d.m;
import com.tencent.mm.e.b.g;
import com.tencent.mm.e.c.a.a;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c implements a {
    private static a fmw = new a();
    public BlockingQueue<g.a> fmm = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public boolean fmn = false;
    private String fmo;
    private int fmp = 0;
    private byte[] fmq = null;
    private int fmr = 16000;
    private Object fms = new Object();
    public a fmt = null;
    private int fmu;
    private boolean fmv = false;
    private FileOutputStream mFileOutputStream;
    private int mSampleRate = 16000;

    public c(int i, int i2) {
        this.mSampleRate = i;
        this.fmr = i2;
    }

    public final boolean a(String str, FileOutputStream fileOutputStream) {
        this.fmo = str;
        this.mFileOutputStream = fileOutputStream;
        int yp = m.yp();
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            this.fmu = 4;
        } else if ((yp & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            this.fmu = 2;
        } else {
            x.e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
            return false;
        }
        if (MediaRecorder.SilkEncInit(this.mSampleRate, this.fmr, this.fmu) != 0) {
            x.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error:%d", new Object[]{Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.fmr, this.fmu))});
            return false;
        }
        this.fmq = new byte[(((this.mSampleRate * 20) * 2) / 1000)];
        yp = -1;
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100279");
        if (fn.isValid()) {
            yp = bh.getInt((String) fn.chI().get("isVoiceMsgOptOpen"), 0);
        }
        if (1 == yp) {
            this.fmv = true;
        }
        if (yp == 0) {
            this.fmv = false;
        }
        if (this.fmv) {
            MediaRecorder.SetVoiceSilkControl(200, 1);
            x.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
        } else {
            MediaRecorder.SetVoiceSilkControl(200, 0);
            x.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
        }
        return true;
    }

    public final boolean cL(String str) {
        boolean z = false;
        x.i("MicroMsg.SilkWriter", "initWriter path: " + str);
        if (str == null) {
            x.e("MicroMsg.SilkWriter", "path is null");
        } else {
            try {
                z = a(str, new FileOutputStream(str));
            } catch (Exception e) {
                x.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", new Object[]{e.getMessage()});
            }
        }
        return z;
    }

    public final void vE() {
        x.i("MicroMsg.SilkWriter", "waitStop");
        synchronized (this) {
            this.fmn = true;
        }
        if (this.fmt != null) {
            try {
                e.S(this.fmt);
            } catch (Throwable e) {
                x.e("MicroMsg.SilkWriter", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        synchronized (this.fms) {
            MediaRecorder.SilkEncUnInit();
        }
        x.i("MicroMsg.SilkWriter", "finish Thread file:" + this.fmo);
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                x.e("MicroMsg.SilkWriter", "close silk file:" + this.fmo + "msg:" + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final boolean vF() {
        x.i("MicroMsg.SilkWriter", "resetWriter");
        synchronized (this.fms) {
            MediaRecorder.SilkEncUnInit();
        }
        if (MediaRecorder.SilkEncInit(this.mSampleRate, this.fmr, this.fmu) == 0) {
            return true;
        }
        x.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error:%d", new Object[]{Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.fmr, this.fmu))});
        return false;
    }

    public final int a(g.a aVar, int i) {
        return a(aVar, 0, false);
    }

    public final int a(g.a aVar, int i, boolean z) {
        com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
        short s = (short) (((this.mSampleRate * 20) * 2) / 1000);
        short s2 = this.fmp + aVar.flp;
        int i2 = 0;
        Object obj = new byte[s];
        byte[] bArr = new byte[((this.fmv ? 6 : 1) * s)];
        String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("VoiceNoiseSuppression");
        boolean z2 = !bh.ov(value) ? bh.getInt(value, 1) == 1 : true;
        if (z) {
            z2 = false;
        }
        x.d("MicroMsg.SilkWriter", "noise suppression: %b", new Object[]{Boolean.valueOf(z2)});
        int i3 = 0;
        while (s2 >= s) {
            if (this.fmp > 0) {
                try {
                    System.arraycopy(this.fmq, 0, obj, 0, this.fmp);
                    System.arraycopy(aVar.buf, 0, obj, this.fmp, s - this.fmp);
                    i2 += s - this.fmp;
                    this.fmp = 0;
                } catch (Exception e) {
                    x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, leftBufSize:%d copySize:%d error:%s", new Object[]{Integer.valueOf(this.fmp), Integer.valueOf(s - this.fmp), e.getMessage()});
                    return -1;
                }
            }
            try {
                System.arraycopy(aVar.buf, i2, obj, 0, s);
                i2 += s;
            } catch (Exception e2) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d framelen:%d error:%s", new Object[]{Integer.valueOf(i2), Short.valueOf(s), e2.getMessage()});
                return -1;
            }
            short s3 = s2 - s;
            short[] sArr = new short[1];
            synchronized (this.fms) {
                if (this.fmv) {
                    if (s3 >= s || !aVar.flq) {
                        MediaRecorder.SetVoiceSilkControl(201, 0);
                    } else {
                        MediaRecorder.SetVoiceSilkControl(201, 1);
                        x.i("MicroMsg.SilkWriter", "silk do encode mark last frame");
                    }
                }
                int SilkDoEnc = MediaRecorder.SilkDoEnc(obj, s, bArr, sArr, z2);
            }
            Object obj2 = null;
            if (z && sArr[0] >= (short) 10 && bArr[0] == (byte) 2 && bArr[1] == (byte) 35 && bArr[2] == (byte) 33 && bArr[3] == (byte) 83 && bArr[4] == (byte) 73 && bArr[5] == (byte) 76 && bArr[6] == (byte) 75 && bArr[7] == (byte) 95 && bArr[8] == (byte) 86 && bArr[9] == (byte) 51) {
                x.i("MicroMsg.SilkWriter", "writeSilkFile deleteHead & bDeleteHead true");
                obj2 = 1;
            }
            if (SilkDoEnc != 0) {
                this.fmp = 0;
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode failed, ret:%d", new Object[]{Integer.valueOf(SilkDoEnc)});
                return -1;
            }
            x.v("MicroMsg.SilkWriter", "encoutdatalen: %s, framelen: %s, lastframe: %s, byteBuf.len: %s", new Object[]{Short.valueOf(sArr[0]), Short.valueOf(s), Boolean.valueOf(aVar.flq), Integer.valueOf(aVar.flp)});
            try {
                if (sArr[0] < bArr.length && sArr[0] > (short) 0) {
                    if (!z || r5 == null) {
                        this.mFileOutputStream.write(bArr, 0, sArr[0]);
                        i3 += sArr[0];
                    } else {
                        x.i("MicroMsg.SilkWriter", "writeSilkFile bDeleteHead copyOfRange");
                        this.mFileOutputStream.write(Arrays.copyOfRange(bArr, 1, bArr.length), 0, sArr[0] - 1);
                        i3 += sArr[0] - 1;
                        s2 = s3;
                    }
                }
                s2 = s3;
            } catch (IOException e3) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile Write File Error file:%s", new Object[]{this.fmo});
                return -1;
            }
        }
        try {
            this.mFileOutputStream.flush();
            try {
                System.arraycopy(aVar.buf, i2, this.fmq, this.fmp, s2);
                this.fmp += s2;
                long zi = aVar2.zi();
                if (i == 1) {
                    a aVar3 = fmw;
                    aVar3.fmj = ((aVar3.fmj * ((long) aVar3.count)) + zi) / ((long) (aVar3.count + 1));
                    aVar3.count++;
                }
                x.d("MicroMsg.SilkWriter", "writeSilkFile append2silkfile silkTime:" + zi + " useFloat:" + i + " avg:" + fmw.fmj + " cnt:" + fmw.count);
                return i3;
            } catch (Exception e22) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d leftBufSize:%d leftSize:%d error:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.fmp), Integer.valueOf(s2), e22.getMessage()});
                return -1;
            }
        } catch (IOException e4) {
            x.e("MicroMsg.SilkWriter", "writeSilkFile flush File Error file:%s", new Object[]{this.fmo});
            return -1;
        }
    }
}
