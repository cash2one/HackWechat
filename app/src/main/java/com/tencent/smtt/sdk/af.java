package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.nio.channels.FileLock;

class af {
    private static af zZH;
    private static FileLock zZK = null;
    boolean zWo;
    ag zZI;
    private boolean zZJ;

    private af() {
    }

    public static af cFg() {
        if (zZH == null) {
            synchronized (af.class) {
                if (zZH == null) {
                    zZH = new af();
                }
            }
        }
        return zZH;
    }

    public final synchronized void b(Context context, s sVar) {
        Object obj;
        Object obj2 = null;
        synchronized (this) {
            if (sVar != null) {
                sVar.b("x5_core_engine_init_sync", (byte) 2);
            }
            h nO = h.nO(true);
            nO.a(context, sVar);
            StringBuilder stringBuilder = new StringBuilder();
            if (sVar != null) {
                sVar.b("init_x5_core", (byte) 1);
            }
            aa cDV = nO.cDV();
            if (!nO.zWn || cDV == null) {
                this.zZJ = false;
                stringBuilder.append("can not use X5 by !tbs available");
                obj = null;
            } else {
                if (!this.zWo) {
                    if (sVar != null) {
                        sVar.zXE = true;
                    }
                    this.zZI = new ag(cDV.zZb);
                    try {
                        this.zZJ = this.zZI.cFj();
                        if (!this.zZJ) {
                            stringBuilder.append("can not use X5 by x5corewizard return false");
                        }
                        obj = null;
                    } catch (NoSuchMethodException e) {
                        this.zZJ = true;
                        obj = null;
                    } catch (Throwable th) {
                        obj = th;
                        this.zZJ = false;
                        stringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(obj));
                    }
                    if (this.zZJ) {
                        CookieManager.getInstance().p(context, true);
                        CookieManager.getInstance().cDN();
                    }
                }
                obj = null;
            }
            if (!this.zZJ) {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (nO.zWn && cDV != null && obj == null) {
                    try {
                        DexLoader dexLoader = cDV.zZb;
                        if (dexLoader != null) {
                            obj2 = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj2 instanceof Throwable) {
                            Throwable th2 = (Throwable) obj2;
                            stringBuilder.append("#" + th2.getMessage() + "; cause: " + th2.getCause() + "; th: " + th2);
                        }
                        if (obj2 instanceof String) {
                            stringBuilder.append("failure detail:" + obj2);
                        }
                    } catch (Throwable th3) {
                    }
                    if (stringBuilder.toString().contains("isPreloadX5Disabled:-10000")) {
                        m.cEf().a(context, av.CTRL_INDEX, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    } else {
                        m.cEf().a(context, JsApiPrivateAddContact.CTRL_INDEX, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    }
                } else if (nO.zWn) {
                    m.cEf().a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + obj));
                } else {
                    m.cEf().a(context, JsApiBatchGetContact.CTRL_INDEX, new Throwable("mCanUseX5=false, available false, reason: " + obj));
                }
            } else if (zZK == null) {
                hC(context);
            }
            this.zWo = true;
            if (sVar != null) {
                sVar.b("init_x5_core", (byte) 2);
            }
        }
    }

    public final boolean cFh() {
        return QbSdk.zVJ ? false : this.zZJ;
    }

    public final ag cFi() {
        return QbSdk.zVJ ? null : this.zZI;
    }

    public final synchronized FileLock hC(Context context) {
        FileLock fileLock;
        if (zZK != null) {
            fileLock = zZK;
        } else {
            fileLock = f.hT(context);
            zZK = fileLock;
        }
        return fileLock;
    }
}
