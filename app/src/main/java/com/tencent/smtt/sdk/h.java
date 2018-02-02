package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.m.a;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

class h {
    private static h zWm = null;
    private static int zWp = 0;
    private static int zWq = 0;
    static boolean zWr = false;
    private static int zWs = 3;
    private static String zWu = null;
    aa zWl = null;
    boolean zWn = false;
    boolean zWo = false;
    private File zWt = null;

    private h() {
    }

    static void HR(int i) {
        zWp = i;
    }

    private void HS(int i) {
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(zWu, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.zWt, "count.prop")), null);
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }

    static void abd(String str) {
        zWu = str;
    }

    public static int cDW() {
        return zWp;
    }

    static boolean cDX() {
        zWr = true;
        return true;
    }

    private int cDY() {
        BufferedInputStream bufferedInputStream;
        int i = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(this.zWt, "count.prop");
            if (file.exists()) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    i = Integer.valueOf(properties.getProperty(zWu, "1")).intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Exception e2) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return i;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e5) {
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return i;
        } catch (Throwable th3) {
            th2 = th3;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th2;
        }
        return i;
    }

    public static h nO(boolean z) {
        if (zWm == null && z) {
            synchronized (h.class) {
                if (zWm == null) {
                    zWm = new h();
                }
            }
        }
        return zWm;
    }

    public static boolean useSoftWare() {
        return QbSdk.useSoftWare();
    }

    public final synchronized void a(Context context, s sVar) {
        Object obj = null;
        synchronized (this) {
            TbsLog.addLog(999, null, new Object[0]);
            TbsLog.initIfNeed(context);
            zWq++;
            if (sVar != null) {
                sVar.zXF = zWq == 1;
            }
            m cEf = m.cEf();
            if (cEf.zXb != null) {
                a aVar = cEf.zXb;
                Arrays.fill(aVar.zXg, 0);
                aVar.zXh = 0;
                aVar.zXi = 0;
            }
            cEf.zXc = false;
            if (sVar != null) {
                sVar.b("tbs_rename_task", (byte) 1);
            }
            t.cEF().x(context, zWq == 1);
            if (sVar != null) {
                sVar.b("tbs_rename_task", (byte) 2);
            }
            x.z(context, true);
            if (sVar != null) {
                sVar.b("can_load_x5", (byte) 1);
            }
            boolean r = QbSdk.r(context, false);
            if (sVar != null) {
                sVar.b("can_load_x5", (byte) 2);
            }
            boolean z = VERSION.SDK_INT >= 7;
            Object obj2 = (r && z) ? 1 : null;
            if (obj2 == null) {
                String str = "can_load_x5=" + r + "; is_compatible=" + z;
                TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + str);
                if (!(QbSdk.zVJ && this.zWn)) {
                    this.zWn = false;
                    m.cEf().a(context, 405, new Throwable(str));
                }
                this.zWt = t.hi(context);
                this.zWo = true;
            } else if (!this.zWn) {
                try {
                    if (x.hq(context)) {
                        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new Object[0]);
                        if (sVar != null) {
                            sVar.b("read_core_info", (byte) 1);
                        }
                        if (sVar != null) {
                            sVar.b("read_core_info", (byte) 2);
                        }
                        this.zWn = false;
                        QbSdk.bG(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                    } else {
                        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new Object[0]);
                        t.cEF();
                        File hg = t.hg(context);
                        if (zWp == 25436 || zWp == 25437) {
                            obj = 1;
                        }
                        Context applicationContext = obj != null ? context.getApplicationContext() : context;
                        if (hg == null) {
                            this.zWn = false;
                            QbSdk.bG(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        } else {
                            String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, applicationContext, hg.getAbsolutePath());
                            String cEQ = x.cEQ() != null ? x.cEQ() : hg.getAbsolutePath();
                            TbsLog.i("SDKEngine", "SDKEngine init optDir is " + cEQ);
                            this.zWl = new aa(context, applicationContext, hg.getAbsolutePath(), cEQ, dexLoaderFileList, QbSdk.zVQ, sVar);
                            this.zWn = true;
                            this.zWt = t.hi(context);
                            this.zWo = true;
                        }
                    }
                } catch (Throwable th) {
                    TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th);
                    m.cEf().a(context, 327, th);
                    this.zWn = false;
                    QbSdk.bG(context, "SDKEngine::useSystemWebView by exception: " + th);
                }
            }
        }
    }

    public final aa cDV() {
        return this.zWn ? this.zWl : null;
    }

    final boolean getTbsNeedReboot() {
        if (zWr) {
            if (zWu == null) {
                return false;
            }
            int cDY = cDY();
            if (cDY == 0) {
                HS(1);
            } else if (cDY + 1 > zWs) {
                return false;
            } else {
                HS(cDY + 1);
            }
        }
        return zWr;
    }
}
