package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.y.a.a.a;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import java.util.HashMap;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtContentProviderBase extends ContentProvider {
    protected static boolean kvc = false;
    private static HashMap<String, Long> mai = new HashMap();
    public MatrixCursor kuZ = new MatrixCursor(new String[0]);
    private long mad = bh.Wq();
    private String mae;
    public String maf = "";
    private String[] mag;
    private int mah = 0;

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public final void pp(int i) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[]{aFM(), this.maf, Integer.valueOf(this.mah), Integer.valueOf(i), Integer.valueOf(aFL())});
        g.pQN.h(10505, new Object[]{aFM(), this.maf, Integer.valueOf(this.mah), Integer.valueOf(i), Integer.valueOf(aFL())});
    }

    public final void cs(int i, int i2) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[]{aFM(), this.maf, Integer.valueOf(this.mah), Integer.valueOf(i), Integer.valueOf(aFL())});
        g.pQN.h(10505, new Object[]{aFM(), this.maf, Integer.valueOf(this.mah), Integer.valueOf(i), Integer.valueOf(aFL()), Integer.valueOf(i2)});
    }

    public final void J(int i, int i2, int i3) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[]{aFM(), this.maf, Integer.valueOf(this.mah), Integer.valueOf(i2), Integer.valueOf(aFL())});
        g.pQN.h(10505, new Object[]{aFM(), this.maf, Integer.valueOf(this.mah), Integer.valueOf(i2), Integer.valueOf(aFL()), Integer.valueOf(i3)});
        g.pQN.a(300, (long) i, 1, false);
    }

    private int aFL() {
        return (int) bh.bA(this.mad);
    }

    protected final void a(Uri uri, Context context, UriMatcher uriMatcher) {
        this.maf = g(uri);
        cA(context);
        if (uriMatcher != null) {
            this.mah = uriMatcher.match(uri);
            if (this.mah < 0) {
                this.mah = 0;
            }
        }
        this.mad = bh.Wq();
    }

    protected final void a(Uri uri, Context context, int i) {
        this.maf = g(uri);
        cA(context);
        this.mah = i;
        this.mad = bh.Wq();
    }

    public final void a(Uri uri, Context context, int i, String[] strArr) {
        this.maf = g(uri);
        if (strArr == null) {
            cA(context);
        } else {
            this.mag = strArr;
        }
        this.mah = i;
        this.mad = bh.Wq();
    }

    public final String aFM() {
        if (!bh.ov(this.mae)) {
            return this.mae;
        }
        if (this.mag == null || this.mag.length <= 0) {
            return "";
        }
        return this.mag[0];
    }

    public final boolean aqY() {
        try {
            x.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
            if (!kvc) {
                final b bVar = new b();
                bVar.b(4000, new Runnable(this) {
                    final /* synthetic */ ExtContentProviderBase maj;

                    public final void run() {
                        try {
                            if (ar.Hj()) {
                                ar.CG().a(new bd(new 1(this)), 0);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
                            bVar.countDown();
                        }
                    }
                });
            }
            if (ar.Hj() && ar.Hi() && !ar.Cs()) {
                kvc = true;
            } else {
                kvc = false;
            }
            x.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + kvc);
            return kvc;
        } catch (Throwable e) {
            x.w("MicroMsg.ExtContentProviderBase", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
            return false;
        }
    }

    private static String g(Uri uri) {
        if (uri == null) {
            return "";
        }
        return bh.ou(uri.getQueryParameter("appid"));
    }

    public final boolean cz(Context context) {
        Throwable th;
        boolean z;
        if (context == null) {
            x.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
            return false;
        } else if (bh.ov(this.maf)) {
            x.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return false;
        } else if (this.mag == null || this.mag.length <= 0) {
            x.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return false;
        } else {
            try {
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(this.maf, true);
                if (aZ == null) {
                    x.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return false;
                }
                boolean z2;
                if (aZ.field_status == 3) {
                    x.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[]{aZ.field_packageName});
                    z2 = false;
                } else {
                    for (String str : this.mag) {
                        if (str.equals(aZ.field_packageName) && p.b(ac.getContext(), aZ, str)) {
                            x.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[]{str});
                            try {
                                this.mae = str;
                                z2 = true;
                                break;
                            } catch (Throwable e) {
                                th = e;
                                z = true;
                                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{th.getMessage()});
                                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                                return z;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        Integer num = (Integer) com.tencent.mm.pluginsdk.b.b.vcd.get(Integer.valueOf(this.mah));
                        if (num == null) {
                            num = Integer.valueOf(64);
                        }
                        if (com.tencent.mm.pluginsdk.model.app.g.a(aZ, num.intValue())) {
                            x.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                        } else {
                            z2 = false;
                        }
                    }
                }
                try {
                    x.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[]{Long.valueOf(bh.a((Long) mai.get(this.maf), 0)), Long.valueOf(System.currentTimeMillis())});
                    if (System.currentTimeMillis() - Long.valueOf(bh.a((Long) mai.get(this.maf), 0)).longValue() > 3600000) {
                        x.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[]{this.maf});
                        a.bis().Hh(this.maf);
                        mai.put(this.maf, Long.valueOf(System.currentTimeMillis()));
                    }
                    return z2;
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    z = z2;
                    th = th2;
                    x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{th.getMessage()});
                    x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                    return z;
                }
            } catch (Throwable e22) {
                th = e22;
                z = false;
                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{th.getMessage()});
                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                return z;
            }
        }
    }

    public final int aFN() {
        int i;
        Throwable th;
        if (bh.ov(this.maf)) {
            x.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return 7;
        } else if (this.mag == null || this.mag.length <= 0) {
            x.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return 6;
        } else {
            try {
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(this.maf, true);
                if (aZ == null) {
                    x.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return 13;
                }
                int i2;
                if (aZ.field_status == 3) {
                    x.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[]{aZ.field_packageName});
                    i2 = 10;
                } else {
                    for (String str : this.mag) {
                        if (str.equals(aZ.field_packageName) && p.b(ac.getContext(), aZ, str)) {
                            x.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[]{str});
                            try {
                                this.mae = str;
                                i2 = 1;
                                break;
                            } catch (Throwable e) {
                                th = e;
                                i = 1;
                                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{th.getMessage()});
                                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                                return i;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 == 1) {
                        Integer num = (Integer) com.tencent.mm.pluginsdk.b.b.vcd.get(Integer.valueOf(this.mah));
                        if (num == null) {
                            cs(5, 16);
                            x.i("MicroMsg.ExtContentProviderBase", "api flag = null");
                            num = Integer.valueOf(64);
                        }
                        if (com.tencent.mm.pluginsdk.model.app.g.a(aZ, num.intValue())) {
                            x.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                        } else {
                            i2 = 11;
                        }
                    }
                }
                try {
                    x.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[]{Long.valueOf(bh.a((Long) mai.get(this.maf), 0)), Long.valueOf(System.currentTimeMillis())});
                    if (System.currentTimeMillis() - Long.valueOf(bh.a((Long) mai.get(this.maf), 0)).longValue() > 3600000) {
                        x.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[]{this.maf});
                        a.bis().Hh(this.maf);
                        mai.put(this.maf, Long.valueOf(System.currentTimeMillis()));
                    }
                    return i2;
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    i = i2;
                    th = th2;
                    x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{th.getMessage()});
                    x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                    return i;
                }
            } catch (Throwable e22) {
                th = e22;
                i = 0;
                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{th.getMessage()});
                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                return i;
            }
        }
    }

    private void cA(Context context) {
        if (context == null) {
            x.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
            return;
        }
        x.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
        this.mag = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (this.mag == null) {
            x.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
        }
    }
}
