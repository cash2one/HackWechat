package com.tencent.mm.ui.conversation.a;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class m extends b implements OnClickListener {
    public final int getLayoutId() {
        return R.i.dmX;
    }

    public final void onClick(View view) {
        fW((Context) this.voC.get());
        g.Dk();
        g.Dj().CU().a(a.xwZ, Boolean.valueOf(false));
        if (this.view != null) {
            this.view.setVisibility(8);
        }
    }

    private static int cwQ() {
        if (VERSION.SDK_INT < 23) {
            return 1;
        }
        PowerManager powerManager = (PowerManager) ac.getContext().getSystemService("power");
        try {
            boolean isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(ac.getContext().getPackageName());
            x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:" + isIgnoringBatteryOptimizations);
            x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + powerManager.isDeviceIdleMode());
            return !isIgnoringBatteryOptimizations ? 2 : 3;
        } catch (Exception e) {
            x.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
            return 3;
        }
    }

    public static void fW(Context context) {
        if (context != null) {
            switch (cwQ()) {
                case 1:
                case 3:
                    int i;
                    String str = Build.BRAND;
                    if (str != null) {
                        if (str.toLowerCase().startsWith("samsung")) {
                            i = R.l.evI;
                        } else if (!str.toLowerCase().equalsIgnoreCase("huawei")) {
                            i = R.l.evH;
                        } else if (VERSION.SDK_INT == 21 || VERSION.SDK_INT == 22 || VERSION.SDK_INT == 23) {
                            i = R.l.evF;
                        } else if (VERSION.SDK_INT == 24) {
                            i = R.l.evG;
                        }
                        if (i <= 0) {
                            h.a(context, context.getString(i), "", new 1());
                            return;
                        } else {
                            x.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
                            return;
                        }
                    }
                    i = R.l.evH;
                    if (i <= 0) {
                        x.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
                        return;
                    } else {
                        h.a(context, context.getString(i), "", new 1());
                        return;
                    }
                case 2:
                    x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
                    Intent data = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + ac.getContext().getPackageName()));
                    data.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    context.startActivity(data);
                    return;
                default:
                    return;
            }
        }
    }

    public static void fX(Context context) {
        OutputStream fileOutputStream;
        Exception e;
        String absolutePath;
        cf auVar;
        long currentTimeMillis;
        Throwable th;
        context.getString(R.l.dGO);
        Dialog a = h.a(context, context.getString(R.l.dHc), true, new 2());
        List<com.tencent.mm.aj.a.a> Nf = com.tencent.mm.aj.a.Nf();
        StringBuilder stringBuilder = new StringBuilder();
        if (Nf != null) {
            for (com.tencent.mm.aj.a.a aVar : Nf) {
                stringBuilder.append(aVar.toString());
                x.i("MicroMsg.MsgDelayTipsBanner", aVar.toString());
            }
        }
        if (a != null) {
            a.dismiss();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        ar.Hg();
        e.c(new String[]{stringBuilder2.append(c.ER()).append("/delayedMsg").toString()});
        File file = new File(r0, "data.txt");
        String stringBuilder3 = stringBuilder.toString();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e2) {
                x.i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + e2.getMessage());
            }
        }
        try {
            fileOutputStream = new FileOutputStream(file, false);
            try {
                fileOutputStream.write((stringBuilder3 + "\n").getBytes("UTF-8"));
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Exception e3) {
                    x.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e3.getMessage());
                }
            } catch (Exception e4) {
                e3 = e4;
                try {
                    x.i("MicroMsg.MsgDelayTipsBanner", "exception:" + e3.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e32) {
                            x.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e32.getMessage());
                        }
                    }
                    Toast.makeText(context, file.getAbsolutePath(), 1).show();
                    absolutePath = file.getAbsolutePath();
                    auVar = new au();
                    auVar.dS("weixin");
                    auVar.setContent(absolutePath);
                    auVar.setType(1);
                    auVar.eR(0);
                    if (auVar.field_isSend == 1) {
                        auVar.eQ(4);
                    } else {
                        auVar.eQ(3);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    auVar.ap(currentTimeMillis);
                    auVar.aq(currentTimeMillis);
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().Q(auVar);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e22) {
                            x.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e22.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e32 = e5;
            fileOutputStream = null;
            x.i("MicroMsg.MsgDelayTipsBanner", "exception:" + e32.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            Toast.makeText(context, file.getAbsolutePath(), 1).show();
            absolutePath = file.getAbsolutePath();
            auVar = new au();
            auVar.dS("weixin");
            auVar.setContent(absolutePath);
            auVar.setType(1);
            auVar.eR(0);
            if (auVar.field_isSend == 1) {
                auVar.eQ(3);
            } else {
                auVar.eQ(4);
            }
            currentTimeMillis = System.currentTimeMillis();
            auVar.ap(currentTimeMillis);
            auVar.aq(currentTimeMillis);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().Q(auVar);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        Toast.makeText(context, file.getAbsolutePath(), 1).show();
        absolutePath = file.getAbsolutePath();
        auVar = new au();
        auVar.dS("weixin");
        auVar.setContent(absolutePath);
        auVar.setType(1);
        auVar.eR(0);
        if (auVar.field_isSend == 1) {
            auVar.eQ(4);
        } else {
            auVar.eQ(3);
        }
        currentTimeMillis = System.currentTimeMillis();
        auVar.ap(currentTimeMillis);
        auVar.aq(currentTimeMillis);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().Q(auVar);
    }

    public final boolean alg() {
        x.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
        g.Dk();
        x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", new Object[]{Boolean.valueOf(g.Dj().CU().getBoolean(a.xwZ, false))});
        if (g.Dj().CU().getBoolean(a.xwZ, false)) {
            if (this.view != null) {
                this.view.setVisibility(0);
            }
        } else if (this.view != null) {
            this.view.setVisibility(8);
        }
        return super.alg();
    }

    public final void destroy() {
    }
}
