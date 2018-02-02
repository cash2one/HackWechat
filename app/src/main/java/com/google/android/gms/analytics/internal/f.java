package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.google.android.gms.analytics.internal.i.a;
import com.google.android.gms.common.internal.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class f extends o {
    private static String aFk = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
    private static String aFl = "01VDIWEA?";
    private static f aFm;

    public f(q qVar) {
        super(qVar);
    }

    private static String aa(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        } else {
            if (Math.abs(((Long) l).longValue()) < 100) {
                return String.valueOf(l);
            }
            String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return stringBuilder.toString();
        }
    }

    private synchronized void b(int i, String str, Object obj, Object obj2, Object obj3) {
        w.ag(str);
        int i2 = i < 0 ? 0 : i;
        int length = i2 >= aFl.length() ? aFl.length() - 1 : i2;
        char c = this.aFo.aFW.nu() ? com.google.android.gms.common.internal.f.aNs ? 'P' : 'C' : com.google.android.gms.common.internal.f.aNs ? 'p' : 'c';
        String str2 = aFk + aFl.charAt(length) + c + p.VERSION + ":" + a(str, aa(obj), aa(obj2), aa(obj3));
        if (str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str2 = str2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        q qVar = this.aFo;
        i iVar = (qVar.aGc == null || !qVar.aGc.isInitialized()) ? null : qVar.aGc;
        if (iVar != null) {
            a aVar = iVar.aFA;
            if (aVar.my() == 0) {
                aVar.mx();
            }
            String str3 = str2 == null ? "" : str2;
            synchronized (aVar) {
                long j = aVar.aFC.aFx.getLong(aVar.mA(), 0);
                if (j <= 0) {
                    Editor edit = aVar.aFC.aFx.edit();
                    edit.putString(aVar.mB(), str3);
                    edit.putLong(aVar.mA(), 1);
                    edit.apply();
                } else {
                    Object obj4 = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (1 + j) ? 1 : null;
                    Editor edit2 = aVar.aFC.aFx.edit();
                    if (obj4 != null) {
                        edit2.putString(aVar.mB(), str3);
                    }
                    edit2.putLong(aVar.mA(), j + 1);
                    edit2.apply();
                }
            }
        }
    }

    public static f mn() {
        return aFm;
    }

    public final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = (String) aj.aHu.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, a(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            b(i, str, obj, obj2, obj3);
        }
    }

    public final void a(c cVar, String str) {
        e("Discarding hit. " + str, cVar != null ? cVar.toString() : "no hit data");
    }

    public final void a(Map<String, String> map, String str) {
        Object stringBuilder;
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        e("Discarding hit. " + str, stringBuilder);
    }

    protected final void mf() {
        synchronized (f.class) {
            aFm = this;
        }
    }
}
