package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.protocal.c.bln;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bva;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedOutputStream;
import java.net.InetAddress;

public final class a {
    public static boolean ssC = false;
    static BufferedOutputStream ssD = null;

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 2;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 4;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 5;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 1;
            }
            return 3;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            return 2;
        }
    }

    private static void MG(String str) {
        if (ssD != null) {
            try {
                ssD.write(str.getBytes());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            }
        }
    }

    public static void bIl() {
        if (ssD != null) {
            try {
                ssD.flush();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            }
        }
    }

    public static int aQ(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 |= (bArr[i] & 255) << (i * 8);
            i++;
        }
        return i2;
    }

    public static byte[] yM(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static void es(String str, String str2) {
        x.e(str, "[" + Thread.currentThread().getId() + "]" + str2);
        MG(str + ":" + str2 + " \n");
    }

    public static void et(String str, String str2) {
        x.i(str, "[" + Thread.currentThread().getId() + "]" + str2);
        MG(str + ":" + str2 + " \n");
    }

    public static void eu(String str, String str2) {
        x.d(str, "[" + Thread.currentThread().getId() + "]" + str2);
        MG(str + ":" + str2 + " \n");
    }

    public static void ev(String str, String str2) {
        x.w(str, "[" + Thread.currentThread().getId() + "]" + str2);
        MG(str + ":" + str2 + " \n");
    }

    public static void b(byte[] bArr, String str, int i) {
        if (bh.bw(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            x.e(str, str2);
        } else if (i == 2) {
            x.i(str, str2);
        } else {
            x.d(str, str2);
        }
        if (str.equals("MicroMsg.v2Core")) {
            MG(str + ":" + str2);
        } else {
            MG(str + ":" + str2 + " \n");
        }
    }

    public static void yN(int i) {
        try {
            Thread.sleep((long) i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
        }
    }

    public static int[] a(bth com_tencent_mm_protocal_c_bth) {
        int i;
        x.d("MicroMsg.Voip", "convertSvrAddr: voipAddr.Cnt " + com_tencent_mm_protocal_c_bth.wUx);
        if (3 >= com_tencent_mm_protocal_c_bth.wUx) {
            i = com_tencent_mm_protocal_c_bth.wUx;
        } else {
            i = 3;
        }
        x.d("MicroMsg.Voip", "convertSvrAddr: addrCnt " + i);
        int[] iArr = new int[(i * 2)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 2] = ((btg) com_tencent_mm_protocal_c_bth.wUy.get(i2)).wQd;
            iArr[(i2 * 2) + 1] = ((btg) com_tencent_mm_protocal_c_bth.wUy.get(i2)).wFo;
            x.d("MicroMsg.Voip", "convertSvrAddr: ip " + yO(((btg) com_tencent_mm_protocal_c_bth.wUy.get(i2)).wQd) + " Port: " + ((btg) com_tencent_mm_protocal_c_bth.wUy.get(i2)).wFo);
        }
        return iArr;
    }

    public static int[] a(bva com_tencent_mm_protocal_c_bva) {
        int i;
        x.d("MicroMsg.Voip", "convertSpeedTestPara: testID= " + com_tencent_mm_protocal_c_bva.wWw + " SvrListCnt= " + com_tencent_mm_protocal_c_bva.wWB);
        if (3 >= com_tencent_mm_protocal_c_bva.wWB) {
            i = com_tencent_mm_protocal_c_bva.wWB;
        } else {
            i = 3;
        }
        int[] iArr = new int[(i * 6)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 6] = ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wOE.wQd;
            iArr[(i2 * 6) + 1] = ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wOE.wFo;
            iArr[(i2 * 6) + 2] = ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wOD;
            iArr[(i2 * 6) + 3] = ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wOZ;
            iArr[(i2 * 6) + 4] = ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wPa;
            iArr[(i2 * 6) + 5] = ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wPb;
            x.d("MicroMsg.Voip", "convertSpeedTestPara: ip " + yO(((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wOE.wQd) + " Port: " + ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wOE.wFo + " TestCnt= " + ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wOD + " TestGap= " + ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wOZ + " Timeout= " + ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wPa + " PktSize= " + ((bln) com_tencent_mm_protocal_c_bva.wWC.get(i2)).wPb);
        }
        return iArr;
    }

    private static String yO(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            return null;
        }
    }

    public static int Dl(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                int i2 = 0;
                while (i < address.length) {
                    int i3 = (address[i] & 255) | (i2 << 8);
                    i++;
                    i2 = i3;
                }
                x.d("MicroMsg.Voip", "ipAddressStrToInt, ip: %s, result: %d", new Object[]{str, Integer.valueOf(i2)});
                return i2;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
        }
        return 0;
    }
}
