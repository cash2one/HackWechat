package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkUpdater;

public final class o {
    private static o zXk;
    private Context tI;
    Map<String, Object> zXl = new HashMap();
    public SharedPreferences zXm;

    private o(Context context) {
        this.zXm = context.getSharedPreferences("tbs_download_config", 4);
        this.tI = context.getApplicationContext();
        if (this.tI == null) {
            this.tI = context;
        }
    }

    public static synchronized o cEi() {
        o oVar;
        synchronized (o.class) {
            oVar = zXk;
        }
        return oVar;
    }

    public static synchronized o gG(Context context) {
        o oVar;
        synchronized (o.class) {
            if (zXk == null) {
                zXk = new o(context);
            }
            oVar = zXk;
        }
        return oVar;
    }

    public final synchronized void HU(int i) {
        try {
            Editor edit = this.zXm.edit();
            edit.putInt("tbs_download_interrupt_code", i);
            edit.putLong("tbs_download_interrupt_time", System.currentTimeMillis());
            edit.commit();
        } catch (Exception e) {
        }
    }

    public final synchronized void HV(int i) {
        Editor edit = this.zXm.edit();
        edit.putInt("tbs_install_interrupt_code", i);
        edit.commit();
    }

    public final synchronized long cEj() {
        int i;
        i = this.zXm.getInt("tbs_download_maxflow", 0);
        if (i == 0) {
            i = 20;
        }
        return ((long) (i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) * 1024;
    }

    public final synchronized long cEk() {
        return p.cEw() >= 0 ? p.cEw() : this.zXm.getLong("retry_interval", 86400);
    }

    public final synchronized long cEl() {
        long j;
        int i = 0;
        synchronized (this) {
            int i2 = this.zXm.getInt("tbs_download_min_free_space", 0);
            if (i2 != 0) {
                i = i2;
            }
            j = ((long) (i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) * 1024;
        }
        return j;
    }

    public final synchronized int cEm() {
        int i;
        i = this.zXm.getInt("tbs_download_success_max_retrytimes", 0);
        if (i == 0) {
            i = 3;
        }
        return i;
    }

    public final synchronized int cEn() {
        int i;
        i = this.zXm.getInt("tbs_download_failed_max_retrytimes", 0);
        if (i == 0) {
            i = 100;
        }
        return i;
    }

    public final synchronized boolean cEo() {
        boolean z = true;
        synchronized (this) {
            try {
                z = this.zXm.getBoolean("tbs_core_load_rename_file_lock_enable", true);
            } catch (Exception e) {
            }
        }
        return z;
    }

    public final synchronized int cEp() {
        int i;
        if (this.zXm.contains("tbs_download_interrupt_code")) {
            i = this.zXm.getInt("tbs_download_interrupt_code", -99);
            if (i == -119 || i == -121) {
                i = this.zXm.getInt("tbs_download_interrupt_code_reason", -119);
            }
            if (System.currentTimeMillis() - this.zXm.getLong("tbs_download_interrupt_time", 0) > 86400000) {
                i -= 98000;
            }
        } else {
            try {
                i = !new File(new File(this.tI.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.zXm.contains("tbs_needdownload") ? -96 : XWalkUpdater.ERROR_SET_VERNUM;
            } catch (Throwable th) {
                i = -95;
            }
        }
        i = (this.tI == null || !"com.tencent.mobileqq".equals(this.tI.getApplicationInfo().packageName) || "CN".equals(Locale.getDefault().getCountry())) ? (i * 1000) + this.zXm.getInt("tbs_install_interrupt_code", -1) : -320;
        return i;
    }

    public final synchronized void commit() {
        Editor edit = this.zXm.edit();
        for (String str : this.zXl.keySet()) {
            Object obj = this.zXl.get(str);
            if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else {
                try {
                    if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    }
                } catch (Exception e) {
                }
            }
        }
        edit.commit();
        this.zXl.clear();
    }

    public final synchronized void nS(boolean z) {
        try {
            Editor edit = this.zXm.edit();
            edit.putBoolean("tbs_core_load_rename_file_lock_enable", z);
            edit.commit();
        } catch (Exception e) {
        }
    }
}
