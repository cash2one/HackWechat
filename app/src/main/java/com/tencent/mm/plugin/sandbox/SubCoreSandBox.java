package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.by.h.d;
import com.tencent.mm.pluginsdk.q.s;
import com.tencent.mm.pluginsdk.q.t;
import com.tencent.mm.pluginsdk.q.u;
import com.tencent.mm.sandbox.a.a;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorService;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public class SubCoreSandBox implements u, ap {
    public static boolean pSd = false;
    public static boolean pSe = false;

    public SubCoreSandBox() {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
    }

    public final HashMap<Integer, d> Bn() {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
        return null;
    }

    public final void gd(int i) {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
    }

    public final void br(boolean z) {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
    }

    public final void bow() {
        Updater.CY(16);
    }

    public final s a(Context context, OnCancelListener onCancelListener) {
        return Updater.c(context, onCancelListener);
    }

    public final s b(Context context, OnCancelListener onCancelListener) {
        return Updater.d(context, onCancelListener);
    }

    public final s dr(Context context) {
        return Updater.eE(context);
    }

    public final void ds(Context context) {
        Updater.ds(context);
    }

    public final void c(String str, int i, String str2, String str3) {
        Updater.c(str, i, str2, str3);
    }

    public final t box() {
        return new a(2);
    }

    public final String IB(String str) {
        return c.IB(str);
    }

    public final void r(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, ExceptionMonitorService.class);
            ac.getContext().startService(intent);
        }
    }

    public final void s(Context context, Intent intent) {
        intent.setClass(context, AppUpdaterUI.class);
        context.startActivity(intent);
    }

    public final void hF(boolean z) {
        pSd = true;
        pSe = z;
    }
}
