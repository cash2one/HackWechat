package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    private static boolean mzg = false;

    public static String getUserId() {
        return ab.UZ(ab.UZ(com.tencent.mm.wallet_core.ui.e.getUsername()) + ab.UZ(q.yF()));
    }

    public static String aKq() {
        return h.bCS();
    }

    public static void aKr() {
        g.Dk();
        g.Dj().CU().a(a.xoC, Boolean.valueOf(true));
    }

    public static boolean aKs() {
        g.Dk();
        Object obj = g.Dj().CU().get(a.xoC, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void aKt() {
        g.Dk();
        g.Dj().CU().a(a.xoD, Boolean.valueOf(true));
    }

    public static void fj(boolean z) {
        g.Dk();
        g.Dj().CU().a(a.xoF, Boolean.valueOf(z));
    }

    public static boolean aKu() {
        g.Dk();
        Object obj = g.Dj().CU().get(a.xoF, Boolean.FALSE);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void fk(boolean z) {
        g.Dk();
        g.Dj().CU().a(a.xoG, Boolean.valueOf(z));
    }

    public static boolean aKv() {
        g.Dk();
        Object obj = g.Dj().CU().get(a.xoG, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void fl(boolean z) {
        mzg = z;
    }

    public static boolean aKw() {
        return mzg;
    }

    public static boolean aKi() {
        return c.aJZ() && aKv() && mzg;
    }

    public static boolean aKx() {
        x.i("MicroMsg.FingerPrintUtil", "isShowFPOpenGuide");
        if (aKu()) {
            x.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.aJZ()) {
            x.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (o.bLq().bLJ() || o.bLq().bLN()) {
            x.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (o.bLq().bLQ().bLF()) {
            com.tencent.mm.plugin.fingerprint.a.aJS();
            com.tencent.mm.plugin.fingerprint.a.aJT();
            if (!c.aKb() || aKs()) {
                return false;
            }
            x.i("MicroMsg.FingerPrintUtil", "will showOpenFingerPrintPayGuide()");
            return true;
        } else {
            x.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static boolean aKy() {
        x.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
        if (aKu()) {
            x.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.aJZ()) {
            x.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (o.bLq().bLJ() || o.bLq().bLN()) {
            x.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (o.bLq().bLQ().bLF()) {
            c cVar = new c();
            if (!c.aKb()) {
                boolean booleanValue;
                g.Dk();
                Object obj = g.Dj().CU().get(a.xoD, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (!booleanValue) {
                    x.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
                    return true;
                }
            }
            return false;
        } else {
            x.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static final String cE(Context context) {
        return context.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    }

    public static int cF(Context context) {
        InputStream open;
        Throwable e;
        int i;
        InputStream open2;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        int read;
        Throwable e2;
        FileOutputStream fileOutputStream2 = null;
        String cE = cE(context);
        File file = new File(cE);
        if (file.exists()) {
            CharSequence i2 = com.tencent.mm.a.g.i(file);
            CharSequence charSequence = "";
            try {
                open = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                if (open != null) {
                    try {
                        charSequence = com.tencent.mm.a.g.a(open, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", e, "", new Object[0]);
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e4, "", new Object[0]);
                                }
                            }
                            if (!!TextUtils.isEmpty(i2)) {
                            }
                            if (!TextUtils.isEmpty(i2)) {
                            }
                            i = 1;
                            if (i != 0) {
                                return 0;
                            }
                            try {
                                open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                        while (true) {
                                            read = open2.read(bArr);
                                            if (read != -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        fileOutputStream.flush();
                                        if (open2 != null) {
                                            try {
                                                open2.close();
                                            } catch (Throwable e22) {
                                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e22, "", new Object[0]);
                                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e22.getMessage());
                                            }
                                        }
                                        try {
                                            fileOutputStream.close();
                                            i = 0;
                                        } catch (Throwable e222) {
                                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", e222, "", new Object[0]);
                                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e222.getMessage());
                                            i = 0;
                                        }
                                    } catch (Exception e5) {
                                        e222 = e5;
                                        fileOutputStream2 = fileOutputStream;
                                        open = open2;
                                        try {
                                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", e222, "", new Object[0]);
                                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e222.getMessage());
                                            if (open != null) {
                                                try {
                                                    open.close();
                                                } catch (Throwable e2222) {
                                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e2222, "", new Object[0]);
                                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e2222.getMessage());
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                    i = -1;
                                                } catch (Throwable e22222) {
                                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e22222.getMessage());
                                                    i = -1;
                                                }
                                            } else {
                                                i = -1;
                                            }
                                            if (Runtime.getRuntime().exec("chmod 777 " + cE).waitFor() != 0) {
                                                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                                return i;
                                            }
                                            x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                            return i;
                                        } catch (Throwable th) {
                                            e22222 = th;
                                            if (open != null) {
                                                try {
                                                    open.close();
                                                } catch (Throwable e6) {
                                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e6, "", new Object[0]);
                                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e6.getMessage());
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Throwable e62) {
                                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e62, "", new Object[0]);
                                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e62.getMessage());
                                                }
                                            }
                                            throw e22222;
                                        }
                                    } catch (Throwable th2) {
                                        e22222 = th2;
                                        fileOutputStream2 = fileOutputStream;
                                        open = open2;
                                        if (open != null) {
                                            open.close();
                                        }
                                        if (fileOutputStream2 != null) {
                                            fileOutputStream2.close();
                                        }
                                        throw e22222;
                                    }
                                } catch (Exception e7) {
                                    e22222 = e7;
                                    open = open2;
                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e22222.getMessage());
                                    if (open != null) {
                                        open.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        i = -1;
                                    } else {
                                        fileOutputStream2.close();
                                        i = -1;
                                    }
                                    if (Runtime.getRuntime().exec("chmod 777 " + cE).waitFor() != 0) {
                                        x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                        return i;
                                    }
                                    x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                } catch (Throwable th3) {
                                    e22222 = th3;
                                    open = open2;
                                    if (open != null) {
                                        open.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    throw e22222;
                                }
                            } catch (Exception e8) {
                                e22222 = e8;
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e22222.getMessage());
                                if (open != null) {
                                    open.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                    i = -1;
                                } else {
                                    i = -1;
                                }
                                if (Runtime.getRuntime().exec("chmod 777 " + cE).waitFor() != 0) {
                                    x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                }
                                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                return i;
                            }
                            try {
                                if (Runtime.getRuntime().exec("chmod 777 " + cE).waitFor() != 0) {
                                    x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                }
                                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                return i;
                            } catch (Exception e9) {
                                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file Exception " + e9.getMessage());
                                return i;
                            }
                        } catch (Throwable th4) {
                            e22222 = th4;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e622) {
                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e622, "", new Object[0]);
                                }
                            }
                            throw e22222;
                        }
                    }
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                    }
                }
            } catch (Throwable e6222) {
                e42 = e6222;
                open = null;
                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                if (open != null) {
                    open.close();
                }
                if (!TextUtils.isEmpty(i2)) {
                }
                if (TextUtils.isEmpty(i2)) {
                }
                i = 1;
                if (i != 0) {
                    return 0;
                }
                open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    read = open2.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                if (open2 != null) {
                    open2.close();
                }
                fileOutputStream.close();
                i = 0;
                if (Runtime.getRuntime().exec("chmod 777 " + cE).waitFor() != 0) {
                    x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                    return i;
                }
                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                return i;
            } catch (Throwable th5) {
                e22222 = th5;
                open = null;
                if (open != null) {
                    open.close();
                }
                throw e22222;
            }
            if (!TextUtils.isEmpty(i2) && !TextUtils.isEmpty(r0) && i2.equals(r0)) {
                i = 0;
            } else if (TextUtils.isEmpty(i2) || !TextUtils.isEmpty(r0)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
            i = 1;
            open = null;
        }
        if (i != 0) {
            return 0;
        }
        open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
        fileOutputStream = new FileOutputStream(file);
        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            read = open2.read(bArr);
            if (read != -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        if (open2 != null) {
            open2.close();
        }
        fileOutputStream.close();
        i = 0;
        if (Runtime.getRuntime().exec("chmod 777 " + cE).waitFor() != 0) {
            x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
            return i;
        }
        x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
        return i;
    }
}
