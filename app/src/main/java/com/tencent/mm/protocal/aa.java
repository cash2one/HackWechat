package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class aa {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public byte[] gPQ;
        public byte[] hFw = new byte[0];
        public int netType;
        public int uin = 0;
        public int vBs;

        public final void eE(int i) {
            this.uin = i;
        }

        public final byte[] Hq() {
            String str = "MicroMsg.MMSyncCheck";
            String str2 = "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.uin);
            objArr[1] = Integer.valueOf(this.hFw == null ? -1 : this.hFw.length);
            objArr[2] = bh.cgy();
            x.d(str, str2, objArr);
            if (this.uin == 0 || bh.bw(this.hFw)) {
                return new byte[0];
            }
            int length = (((this.uin >> 13) & 524287) | (this.hFw.length << 19)) ^ 1442968193;
            int length2 = 1442968193 ^ (((this.hFw.length >> 13) & 524287) | (this.uin << 19));
            Object obj = new byte[(this.hFw.length + 32)];
            x.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", Integer.valueOf(this.uin), Integer.valueOf(length), Integer.valueOf(this.hFw.length), Integer.valueOf(length2), Integer.valueOf(obj.length));
            obj[0] = (byte) ((length >> 24) & 255);
            obj[1] = (byte) ((length >> 16) & 255);
            obj[2] = (byte) ((length >> 8) & 255);
            obj[3] = (byte) (length & 255);
            obj[4] = (byte) ((length2 >> 24) & 255);
            obj[5] = (byte) ((length2 >> 16) & 255);
            obj[6] = (byte) ((length2 >> 8) & 255);
            obj[7] = (byte) (length2 & 255);
            System.arraycopy(this.hFw, 0, obj, 8, this.hFw.length);
            obj[obj.length - 24] = (byte) ((d.vAz >> 24) & 255);
            obj[obj.length - 23] = (byte) ((d.vAz >> 16) & 255);
            obj[obj.length - 22] = (byte) ((d.vAz >> 8) & 255);
            obj[obj.length - 21] = (byte) (d.vAz & 255);
            String locale = Locale.getDefault().toString();
            if (locale.length() > 8) {
                locale = locale.substring(0, 8);
            }
            Object bytes = locale.getBytes();
            System.arraycopy(bytes, 0, obj, obj.length - 20, bytes.length);
            x.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString(bytes));
            obj[obj.length - 12] = null;
            obj[obj.length - 11] = null;
            obj[obj.length - 10] = null;
            obj[obj.length - 9] = 2;
            obj[obj.length - 8] = (byte) ((this.netType >> 24) & 255);
            obj[obj.length - 7] = (byte) ((this.netType >> 16) & 255);
            obj[obj.length - 6] = (byte) ((this.netType >> 8) & 255);
            obj[obj.length - 5] = (byte) (this.netType & 255);
            obj[obj.length - 4] = (byte) ((this.vBs >> 24) & 255);
            obj[obj.length - 3] = (byte) ((this.vBs >> 16) & 255);
            obj[obj.length - 2] = (byte) ((this.vBs >> 8) & 255);
            obj[obj.length - 1] = (byte) (this.vBs & 255);
            x.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(obj));
            this.gPQ = g.t(obj);
            return obj;
        }

        public final int Hr() {
            return 0;
        }

        public final int getCmdId() {
            return com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX;
        }

        public final boolean cdI() {
            return true;
        }

        public final boolean KH() {
            return false;
        }
    }

    public static class b extends e implements c {
        private String fCs = null;
        public byte[] gPQ = null;
        public long vBW = 7;
        private byte[] vBX;

        @TargetApi(9)
        public final String cdK() {
            if (this.gPQ == null) {
                return "";
            }
            if (this.fCs == null) {
                byte[] aesDecrypt = MMProtocalJni.aesDecrypt(this.vBX, this.gPQ);
                if (bh.bw(aesDecrypt)) {
                    return "";
                }
                if (VERSION.SDK_INT >= 9) {
                    this.fCs = new String(aesDecrypt, Charset.forName("UTF-8"));
                } else {
                    this.fCs = new String(aesDecrypt);
                }
            }
            return this.fCs;
        }

        public final int E(byte[] bArr) {
            int i;
            if (bArr == null || bArr.length < 12) {
                String str = "MicroMsg.MMSyncCheck";
                StringBuilder stringBuilder = new StringBuilder("dksynccheck err resp buf:");
                if (bArr == null) {
                    i = -1;
                } else {
                    i = bArr.length;
                }
                x.e(str, stringBuilder.append(i).toString());
                return -1;
            }
            this.vBW = (long) ((((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24));
            i = (((bArr[7] & 255) | ((bArr[6] & 255) << 8)) | ((bArr[5] & 255) << 16)) | ((bArr[4] & 255) << 24);
            int i2 = (((bArr[11] & 255) | ((bArr[10] & 255) << 8)) | ((bArr[9] & 255) << 16)) | ((bArr[8] & 255) << 24);
            x.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", Long.valueOf(this.vBW), Integer.valueOf(i), Integer.valueOf(i2));
            if (i != -3002) {
                this.fCs = "";
                return i;
            } else if (i2 == bArr.length - 12 || i2 == (bArr.length - 12) - 16) {
                if (i2 == (bArr.length - 12) - 16) {
                    this.gPQ = new byte[16];
                    System.arraycopy(bArr, bArr.length - 16, this.gPQ, 0, 16);
                }
                this.vBX = new byte[i2];
                System.arraycopy(bArr, 12, this.vBX, 0, i2);
                return i;
            } else {
                x.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                return -1;
            }
        }

        public final int getCmdId() {
            return 1000000205;
        }

        public final boolean cdI() {
            return true;
        }
    }
}
