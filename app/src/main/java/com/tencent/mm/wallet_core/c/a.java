package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.MessageDigestUtil;

public final class a {
    static boolean isInit = false;
    private static a zHf = null;
    private boolean zHg = false;

    public static a cBn() {
        if (zHf == null) {
            zHf = new a();
        }
        return zHf;
    }

    public static void init(Context context) {
        if (!isInit) {
            x.d("MicroMsg.CertUtilWx", "init  %s", new Object[]{bh.cgy().toString()});
            CertUtil.getInstance().init(context);
            isInit = true;
        }
    }

    public final String dB(String str, int i) {
        String str2;
        x.d("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s %s", new Object[]{bh.cgy().toString(), Integer.valueOf(i)});
        synchronized (this) {
            if (this.zHg) {
                x.i("MicroMsg.CertUtilWx", "isCert_Wating");
                str2 = "";
            } else {
                this.zHg = true;
                str2 = CertUtil.getInstance().getCertApplyCSR(str, i);
            }
        }
        return str2;
    }

    public final boolean importCert(String str, String str2) {
        boolean importCert;
        x.d("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", new Object[]{str, str2, bh.cgy().toString()});
        synchronized (this) {
            this.zHg = false;
            importCert = CertUtil.getInstance().importCert(str, str2);
        }
        return importCert;
    }

    public final boolean cBo() {
        x.d("MicroMsg.CertUtilWx", "importCertNone");
        synchronized (this) {
            this.zHg = false;
        }
        return false;
    }

    public static boolean isCertExist(String str) {
        x.d("MicroMsg.CertUtilWx", "isCertExist stack %s", new Object[]{bh.cgy().toString()});
        g.pQN.a(414, 5, 1, true);
        boolean isCertExist = CertUtil.getInstance().isCertExist(str);
        g.pQN.a(414, 6, 1, true);
        return isCertExist;
    }

    public static String genUserSig(String str, String str2) {
        x.d("MicroMsg.CertUtilWx", "genUserSig stack %s", new Object[]{bh.cgy().toString()});
        return CertUtil.getInstance().genUserSig(str, str2);
    }

    public static boolean t(String str, String str2, boolean z) {
        String str3 = "";
        if (z) {
            MessageDigestUtil messageDigestUtil = new MessageDigestUtil();
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dh();
            byte[] bArr = new byte[16];
            byte[] bytes = messageDigestUtil.getSHA256Hex((o.getString(com.tencent.mm.kernel.a.Cg()) + "_pUI6cNqzLt2Z3mQSrYuF09XSGsBtTIcUgp9jcWZ7F7BBs8/DFVFMKiwbtaRPOiLE").getBytes()).getBytes();
            int i = 0;
            while (i < 16 && i < bytes.length) {
                bArr[i] = bytes[i];
                i++;
            }
            str3 = new String(bArr);
        }
        x.d("MicroMsg.CertUtilWx", "setTokens stack v2 useSm4 %s sm4Key %s %s", new Object[]{Boolean.valueOf(z), str3, bh.cgy().toString()});
        x.d("MicroMsg.CertUtilWx", "setTokens result ret:%s", new Object[]{Boolean.valueOf(CertUtil.getInstance().setTokens(str, str2, z, str3))});
        return CertUtil.getInstance().setTokens(str, str2, z, str3);
    }

    public static String getToken(String str) {
        x.d("MicroMsg.CertUtilWx", "getToken stack %s", new Object[]{bh.cgy().toString()});
        return CertUtil.getInstance().getToken(str);
    }

    public static void clearToken(String str) {
        x.d("MicroMsg.CertUtilWx", "clearToken stack %s", new Object[]{bh.cgy().toString()});
        CertUtil.getInstance().clearToken(str);
    }

    public static int aau(String str) {
        x.d("MicroMsg.CertUtilWx", "getTokenCount ret: %d stack %s", new Object[]{Integer.valueOf(CertUtil.getInstance().getTokenCount(str)), bh.cgy().toString()});
        return CertUtil.getInstance().getTokenCount(str);
    }

    public static int getLastError() {
        x.d("MicroMsg.CertUtilWx", "getLastError stack %s", new Object[]{bh.cgy().toString()});
        return CertUtil.getInstance().getLastError();
    }

    public static void clearCert(String str) {
        x.d("MicroMsg.CertUtilWx", "clearCert stack %s", new Object[]{bh.cgy().toString()});
        CertUtil.getInstance().clearCert(str);
    }

    public static void clean() {
        x.d("MicroMsg.CertUtilWx", "clean allcrt stack %s", new Object[]{bh.cgy().toString()});
        CertUtil.getInstance().clearAllCert();
    }
}
