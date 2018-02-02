package oicq.wlogin_sdk.request;

import android.content.Context;
import java.security.SecureRandom;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class i {
    public static byte[] Aww = new byte[0];
    byte[] AwA = new byte[0];
    byte[] AwB = new byte[0];
    byte[] AwC = new byte[0];
    byte[] AwD = new byte[0];
    byte[] AwE = new byte[0];
    int AwF = 0;
    int AwG = 0;
    int AwH = 0;
    int AwI = 0;
    byte[] AwJ = new byte[0];
    ErrMsg AwK = new ErrMsg();
    byte[] AwL = new byte[0];
    byte[] AwM = new byte[4];
    byte[] AwN = new byte[0];
    c AwO = null;
    public SecureRandom Awl = new SecureRandom();
    public byte[] Awm = util.cJX();
    public byte[] Awn = null;
    public byte[] Awo = new byte[16];
    public f Awp = new f();
    public g Awq = new g();
    public long Awr = 0;
    public int Aws = 0;
    public long Awt = -1;
    public int Awu = 0;
    byte[] Awv = new byte[0];
    byte[] Awx = new byte[0];
    int Awy = 0;
    byte[] Awz = new byte[0];
    public Context _context = null;
    public long _uin = 0;

    public static long cJO() {
        return System.currentTimeMillis() / 1000;
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        util.acy("put siginfo:" + j + "," + j2 + "," + j3 + "," + j4 + "," + j5 + "," + j6 + "," + util.cg(bArr) + "," + util.cg(bArr2) + "," + util.cg(bArr3) + "," + util.cg(bArr4) + "," + util.cg(bArr5) + "," + util.cg(bArr6) + "," + util.cg(bArr7) + "," + util.cg(bArr8) + "," + util.cg(bArr9) + "," + util.cg(bArr10) + "," + util.cg(bArr11) + "," + util.cg(bArr12) + "," + util.cg(bArr13) + "," + util.cg(bArr14) + "," + util.cg(bArr15) + "," + util.cg(bArr16));
        String str = "";
        for (int i = 0; i < bArr17.length; i++) {
            str = new StringBuilder(String.valueOf(str)).append(String.format("reserve[%d]: %d ", new Object[]{Integer.valueOf(i), Long.valueOf(util.cg(bArr17[i]))})).toString();
        }
        util.acy("reserve:" + str);
        return this.AwO.a(j, j2, j3, j4, j5, j6, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
    }

    public final synchronized WloginSigInfo M(long j, long j2) {
        WloginSigInfo M;
        util.gj("get_siginfo", "uin=" + j + "appid=522017402");
        M = this.AwO.M(j, 522017402);
        if (M != null) {
        }
        return M;
    }

    public final synchronized void h(Long l) {
        this.AwO.h(l);
    }
}
