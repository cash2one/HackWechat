package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

public class n {
    public final q aFo;

    public n(q qVar) {
        w.ag(qVar);
        this.aFo = qVar;
    }

    protected static String a(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object ab = ab(obj);
        Object ab2 = ab(obj2);
        Object ab3 = ab(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(ab)) {
            stringBuilder.append(str2);
            stringBuilder.append(ab);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(ab2)) {
            stringBuilder.append(str2);
            stringBuilder.append(ab2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(ab3)) {
            stringBuilder.append(str2);
            stringBuilder.append(ab3);
        }
        return stringBuilder.toString();
    }

    private static String ab(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    protected static void mM() {
        if (f.aNs) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    public static boolean mP() {
        return Log.isLoggable((String) aj.aHu.get(), 2);
    }

    public void a(int i, String str, Object obj, Object obj2, Object obj3) {
        f fVar = null;
        if (this.aFo != null) {
            fVar = this.aFo.aFX;
        }
        if (fVar != null) {
            fVar.a(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) aj.aHu.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, a(str, obj, obj2, obj3));
        }
    }

    public final void a(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2, null);
    }

    public final void au(String str) {
        a(2, str, null, null, null);
    }

    public final void av(String str) {
        a(3, str, null, null, null);
    }

    public final void aw(String str) {
        a(4, str, null, null, null);
    }

    public final void ax(String str) {
        a(5, str, null, null, null);
    }

    public final void ay(String str) {
        a(6, str, null, null, null);
    }

    public final void b(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2, null);
    }

    public final void c(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public final void d(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public final void d(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }

    public final void e(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public final void f(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    protected final ag mN() {
        q qVar = this.aFo;
        q.a(qVar.aGa);
        return qVar.aGa;
    }

    protected final i mO() {
        q qVar = this.aFo;
        q.a(qVar.aGc);
        return qVar.aGc;
    }
}
