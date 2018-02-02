package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e {
    public static boolean b(avk com_tencent_mm_protocal_c_avk) {
        if (com_tencent_mm_protocal_c_avk == null || com_tencent_mm_protocal_c_avk.wDc == null || com_tencent_mm_protocal_c_avk.wDc.wJD == null) {
            return false;
        }
        byte[] bArr = com_tencent_mm_protocal_c_avk.wDc.wJD.oz;
        if (bArr.length == 0 || (bArr.length & 1) != 0) {
            return false;
        }
        long longValue = new o(com_tencent_mm_protocal_c_avk.uin).longValue();
        bArr = aS(bArr);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com_tencent_mm_protocal_c_avk.version);
        if (com_tencent_mm_protocal_c_avk.wDa.wJE) {
            stringBuilder.append(new String(com_tencent_mm_protocal_c_avk.wDa.wJD.oz));
        }
        stringBuilder.append(longValue);
        x.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[]{Integer.valueOf(UtilsJni.doEcdsaVerify(a.tfQ, stringBuilder.toString().getBytes(), bArr))}));
        if (UtilsJni.doEcdsaVerify(a.tfQ, stringBuilder.toString().getBytes(), bArr) != 1) {
            return false;
        }
        return true;
    }

    public static boolean b(avl com_tencent_mm_protocal_c_avl) {
        if (com_tencent_mm_protocal_c_avl == null || com_tencent_mm_protocal_c_avl.wDe == null || com_tencent_mm_protocal_c_avl.wDe.wJD == null) {
            return false;
        }
        byte[] bArr = com_tencent_mm_protocal_c_avl.wDe.wJD.oz;
        if (bArr.length == 0 || (bArr.length & 1) != 0) {
            return false;
        }
        boolean z;
        bArr = aS(bArr);
        g.Dh();
        long longValue = new o(a.Cg()).longValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com_tencent_mm_protocal_c_avl.wDd);
        stringBuilder.append(longValue);
        int doEcdsaVerify = UtilsJni.doEcdsaVerify(a.tfQ, stringBuilder.toString().getBytes(), bArr);
        if ((doEcdsaVerify == 1 || com_tencent_mm_protocal_c_avl.wDf != 1) && !(doEcdsaVerify == 1 && com_tencent_mm_protocal_c_avl.wDf == 0)) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[]{Integer.valueOf(doEcdsaVerify), Boolean.valueOf(z)}));
        return z;
    }

    private static byte[] aS(byte[] bArr) {
        String str = "0123456789abcdef";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < bArr.length - 1; i += 2) {
            byteArrayOutputStream.write((str.indexOf(Character.toLowerCase(bArr[i])) << 4) | str.indexOf(Character.toLowerCase(bArr[i + 1])));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean bNN() {
        int i = -1;
        if (!g.Dh().Cy() || a.Cs()) {
            x.w("MicroMsg.GestureUtil", "not login !!");
            return false;
        }
        boolean z;
        boolean b;
        avl bNU = d.bNU();
        avk bNT = d.bNT();
        if (bNU == null) {
            int i2 = 1;
        } else {
            z = false;
        }
        if (bNT == null) {
            int i3 = 1;
        } else {
            boolean z2 = false;
        }
        if (i2 == 0) {
            z = b(bNU);
        } else {
            z = false;
        }
        String str = "MicroMsg.GestureUtil";
        String str2 = "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bNU;
        objArr[1] = Integer.valueOf(bNU == null ? -1 : bNU.wDf);
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (i3 == 0) {
            b = b(bNT);
        } else {
            b = false;
        }
        String str3 = "MicroMsg.GestureUtil";
        str = "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = bNT;
        if (bNT != null) {
            i = bNT.wDb;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = Boolean.valueOf(b);
        x.i(str3, str, objArr2);
        if (z) {
            if (b) {
                try {
                    x.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
                    if (bNU.wDd > bNT.version) {
                        x.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[]{Integer.valueOf(bNU.wDd), Integer.valueOf(bNT.version)});
                        if (bNU.wDf == 1) {
                            return true;
                        }
                        return false;
                    } else if (bNU.wDd == bNT.version) {
                        x.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[]{Integer.valueOf(bNU.wDd), Integer.valueOf(bNT.version)});
                        if (bNU.wDf == 1) {
                            return true;
                        }
                        return false;
                    } else {
                        x.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[]{Integer.valueOf(bNU.wDd), Integer.valueOf(bNT.version)});
                        if (bNT.wDb == 1) {
                            return true;
                        }
                        return false;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GestureUtil", e, "isUserSetWalletLock throw an exception.", new Object[0]);
                    return false;
                }
            }
            x.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
            if (bNU.wDf == 1) {
                return true;
            }
            return false;
        } else if (b) {
            x.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
            if (bNT.wDb == 1) {
                return true;
            }
            return false;
        } else {
            x.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
            return false;
        }
    }

    public static byte[] ci(List<f> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            f fVar = (f) list.get(i);
            bArr[i] = (byte) ((fVar.tfS + (fVar.tfR * 3)) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuilder.append(bArr[i2]);
        }
        String stringBuilder2 = stringBuilder.toString();
        return com.tencent.mm.a.g.s((com.tencent.mm.a.g.s((com.tencent.mm.a.g.s(stringBuilder2.getBytes()) + q.FS()).getBytes()) + stringBuilder2).getBytes()).getBytes();
    }

    public static void a(g gVar) {
        if (gVar.tfU != -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < gVar.tfU) {
                gVar.tfU = elapsedRealtime;
                gVar.tfV += elapsedRealtime;
                x.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[]{Long.valueOf(elapsedRealtime), Long.valueOf(gVar.tfV)}));
                return;
            }
            gVar.tfV = (elapsedRealtime - gVar.tfU) + gVar.tfV;
            gVar.tfU = elapsedRealtime;
        }
    }

    public static byte[] NF(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String aT(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }
}
