package com.tencent.qqpinyin.voicerecoapi;

public final class c {
    private int hYr;
    private int jBx;
    private TRVADNative zQQ;

    public c(int i) {
        this.zQQ = new TRVADNative();
        this.hYr = i;
        this.jBx = 5000000;
    }

    public c() {
        this.zQQ = new TRVADNative();
        this.hYr = 500000;
        this.jBx = 10000000;
    }

    public final int start() {
        int mfeInit = this.zQQ.mfeInit(this.hYr, this.jBx);
        if (mfeInit == 0) {
            mfeInit = this.zQQ.mfeOpen();
            if (mfeInit == 0) {
                mfeInit = this.zQQ.mfeEnableNoiseDetection(true);
                if (mfeInit == 0) {
                    mfeInit = this.zQQ.mfeStart();
                }
            }
        }
        return mfeInit == 0 ? 0 : -1;
    }

    public final int stop() {
        int mfeStop = this.zQQ.mfeStop();
        if (mfeStop == 0) {
            mfeStop = this.zQQ.mfeClose();
            if (mfeStop == 0) {
                mfeStop = this.zQQ.mfeExit();
            }
        }
        return mfeStop == 0 ? 0 : -1;
    }

    public final synchronized void a(short[] sArr, int i, a aVar) {
        double d = 26.0d;
        int i2 = 0;
        synchronized (this) {
            if (i > 0) {
                switch (this.zQQ.mfeSendData(sArr, i)) {
                    case 1:
                        aVar.zQR = 1;
                        break;
                    case 2:
                        aVar.zQR = 2;
                        break;
                    case 3:
                        aVar.zQR = 3;
                        break;
                    default:
                        aVar.zQR = 0;
                        break;
                }
                int i3 = 0;
                while (i2 < i) {
                    i3 = (int) (((double) i3) + (Math.sqrt((double) (sArr[i2] * sArr[i2])) / ((double) i)));
                    i2++;
                }
                if (i3 < 100) {
                    d = 0.0d;
                } else if (i3 <= 16383) {
                    d = 26.0d * ((((double) i3) - 100.0d) / 32667.0d);
                }
                aVar.zQV = (int) d;
                new StringBuilder("volumn��").append(aVar.zQV);
            }
        }
    }
}
