package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class a {
    public static int MAX_FRAME_SIZE = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    private byte[] zQL = null;
    public byte[] zQM = null;
    private int zQN = 0;
    public int zQO = 0;
    public TRSpeexNative zQP = new TRSpeexNative();

    public final int cCZ() {
        if (this.zQN != 0) {
            return -103;
        }
        int nativeTRSpeexInit = this.zQP.nativeTRSpeexInit();
        if (nativeTRSpeexInit == -1) {
            return nativeTRSpeexInit;
        }
        this.zQN = nativeTRSpeexInit;
        this.zQL = new byte[(MAX_FRAME_SIZE * 10)];
        return 0;
    }

    public final byte[] R(byte[] bArr, int i) {
        if (this.zQN == 0) {
            throw new b(-102);
        } else if (bArr == null || bArr.length == 0) {
            throw new b(-104);
        } else {
            int nativeTRSpeexEncode = this.zQP.nativeTRSpeexEncode(this.zQN, bArr, 0, i, this.zQL);
            if (nativeTRSpeexEncode < 0) {
                throw new b(nativeTRSpeexEncode);
            } else if (nativeTRSpeexEncode == 0) {
                return null;
            } else {
                byte[] bArr2 = new byte[nativeTRSpeexEncode];
                System.arraycopy(this.zQL, 0, bArr2, 0, nativeTRSpeexEncode);
                return bArr2;
            }
        }
    }

    public final int cDa() {
        if (this.zQN == 0) {
            return -102;
        }
        this.zQL = null;
        int nativeTRSpeexRelease = this.zQP.nativeTRSpeexRelease(this.zQN);
        this.zQN = 0;
        return nativeTRSpeexRelease;
    }
}
