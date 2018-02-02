package com.tencent.mm.bm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.z.ap;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d {
    private static final Map<String, String> vzQ;
    private static HashMap<String, c> vzR = new HashMap();
    private static final HashSet<String> vzS = new 11();

    static {
        Map hashMap = new HashMap();
        vzQ = hashMap;
        hashMap.put("location", "talkroom");
        vzQ.put("talkroom", "voip");
    }

    public static void a(Context context, String str, String str2, Intent intent) {
        a(str, new 1(intent, str, str2, context), new 4(str));
    }

    public static void a(Context context, String str, String str2, Intent intent, Intent intent2) {
        final Intent intent3 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final Intent intent4 = intent2;
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent3 == null ? new Intent() : intent3;
                intent.setClassName(ac.getPackageName(), str4.startsWith(".") ? (ac.cfr() + ".plugin." + str3) + str4 : str4);
                MMWizardActivity.b(context2, intent, intent4);
            }
        }, new 6(str));
    }

    public static void y(Context context, String str, String str2) {
        a(context, str, str2, null, true);
    }

    public static void b(Context context, String str, String str2, Intent intent) {
        if (!f.fN(21)) {
            try {
                if (context.getSharedPreferences(ac.cfs(), 0).getBoolean("settings_multi_webview", false) && ".ui.tools.WebViewUI".endsWith(str2)) {
                    x.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
                    intent.addFlags(134217728);
                    intent.addFlags(SQLiteGlobal.journalSizeLimit);
                }
            } catch (Exception e) {
                x.e("MicroMsg.PluginHelper", "%s", new Object[]{e.getMessage()});
            }
        }
        a(context, str, str2, intent, true);
    }

    public static void a(final Context context, final String str, final String str2, final Intent intent, boolean z) {
        x.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", new Object[]{Boolean.valueOf(z)});
        a anonymousClass7 = new a() {
            public final void onDone() {
                x.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s", new Object[]{str});
                try {
                    Intent intent = intent == null ? new Intent() : intent;
                    String str = str2.startsWith(".") ? (ac.cfr() + ".plugin." + str) + str2 : str2;
                    intent.setClassName(ac.getPackageName(), str);
                    Class.forName(str, false, context.getClassLoader());
                    if (context instanceof Activity) {
                        context.startActivity(intent);
                        return;
                    }
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    context.startActivity(intent);
                } catch (ClassNotFoundException e) {
                    x.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", new Object[]{e});
                }
            }
        };
        b 8 = new 8(str);
        if (z) {
            a(str, anonymousClass7, 8);
        } else {
            anonymousClass7.onDone();
        }
    }

    public static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        String cfr = ac.cfr();
        if (str.startsWith(".")) {
            str = cfr + str;
        }
        intent.setClassName(ac.getPackageName(), str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }

    public static void c(Context context, String str, String str2, int i) {
        a(context, str, str2, null, i, true);
    }

    public static void b(Context context, String str, String str2, Intent intent, int i) {
        a(context, str, str2, intent, i, true);
    }

    public static void a(Context context, String str, String str2, Intent intent, int i, boolean z) {
        x.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[]{Boolean.valueOf(z)});
        a(str, new 9(intent, str, str2, context, i), new 10(str));
    }

    public static void a(Fragment fragment, String str, String str2, Intent intent, int i) {
        x.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[]{Boolean.valueOf(true)});
        a(str, new 2(intent, str, str2, fragment, i), new 3(str));
    }

    public static void b(Context context, String str, Intent intent) {
        if (intent != null && vzS.contains(str)) {
            intent.putExtra("animation_pop_in", true);
            b.B(context, intent);
        }
    }

    public static void a(Context context, String str, Intent intent, int i) {
        intent.setClassName(ac.getPackageName(), str.startsWith(".") ? ac.cfr() + str : str);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            b(context, str, intent);
            return;
        }
        x.f("MicroMsg.PluginHelper", "context not activity, skipped");
    }

    public static void a(MMActivity mMActivity, String str, Intent intent, int i, a aVar) {
        String cfr = ac.cfr();
        if (str.startsWith(".")) {
            cfr = cfr + str;
        } else {
            cfr = str;
        }
        intent.setClassName(ac.getPackageName(), cfr);
        mMActivity.b(aVar, intent, i);
        b(mMActivity, str, intent);
    }

    public static void a(Fragment fragment, String str, Intent intent, int i) {
        intent.setClassName(ac.getPackageName(), str.startsWith(".") ? ac.cfr() + str : str);
        if (fragment instanceof Fragment) {
            fragment.startActivityForResult(intent, i);
            b(fragment.getActivity(), str, intent);
            return;
        }
        x.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
    }

    public static void Td(String str) {
        x.d("MicroMsg.PluginHelper", "-->createSubCore: %s", new Object[]{str});
        c Tf = Tf(str);
        if (Tf == null) {
            x.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[]{str});
        } else if (Tf.createSubCore() == null) {
            x.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[]{str});
        } else {
            x.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[]{str});
        }
    }

    public static ap Te(String str) {
        x.d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", new Object[]{str});
        c Tf = Tf(str);
        if (Tf == null) {
            x.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[]{str});
            return null;
        }
        ap createSubCore = Tf.createSubCore();
        if (createSubCore == null) {
            x.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[]{str});
            return null;
        }
        x.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[]{str});
        return createSubCore;
    }

    public static void a(String str, n nVar, m mVar) {
        x.d("MicroMsg.PluginHelper", "--> registerApplication: %s", new Object[]{str});
        c Tf = Tf(str);
        if (Tf == null) {
            x.f("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[]{str});
            return;
        }
        p createApplication = Tf.createApplication();
        if (createApplication == null) {
            x.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[]{str});
            return;
        }
        createApplication.a(mVar);
        createApplication.a(nVar);
        x.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", new Object[]{str, nVar, mVar});
    }

    public static com.tencent.mm.pluginsdk.c.a Q(Context context, String str) {
        return z(context, str, null);
    }

    public static com.tencent.mm.pluginsdk.c.a z(Context context, String str, String str2) {
        c Tf = Tf(str);
        if (Tf == null) {
            x.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", new Object[]{str, str2});
            return null;
        }
        com.tencent.mm.pluginsdk.c.b contactWidgetFactory = Tf.getContactWidgetFactory();
        if (contactWidgetFactory != null) {
            return contactWidgetFactory.Q(context, str2);
        }
        x.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", new Object[]{str, str2});
        return null;
    }

    public static boolean ccW() {
        return false;
    }

    public static synchronized boolean OQ(String str) {
        boolean z;
        synchronized (d.class) {
            z = vzR.get(str) != null;
        }
        return z;
    }

    private static synchronized c Tf(String str) {
        c Tg;
        synchronized (d.class) {
            try {
                Tg = Tg(str);
            } catch (ClassNotFoundException e) {
                x.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s, e:%s", new Object[]{str, e.toString()});
                Tg = null;
                return Tg;
            } catch (InstantiationException e2) {
                x.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", new Object[]{str, e2.toString()});
                Tg = null;
                return Tg;
            } catch (IllegalAccessException e3) {
                x.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", new Object[]{str, e3.toString()});
                Tg = null;
                return Tg;
            }
        }
        return Tg;
    }

    public static synchronized c a(String str, a aVar, b bVar) {
        c cVar;
        synchronized (d.class) {
            if (((String) vzQ.get(str)) != null) {
                x.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[]{str, (String) vzQ.get(str)});
            }
            cVar = (c) vzR.get(str);
            if (cVar != null) {
                aVar.onDone();
            } else {
                try {
                    cVar = Tg(str);
                    if (cVar != null) {
                        aVar.onDone();
                    }
                } catch (Exception e) {
                    try {
                        cVar = Tg(str);
                        if (cVar != null) {
                            aVar.onDone();
                        }
                    } catch (ClassNotFoundException e2) {
                        x.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", new Object[]{str, e2.toString()});
                        x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                        bVar.c(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    } catch (InstantiationException e3) {
                        x.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", new Object[]{str, e3.toString()});
                        x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                        bVar.c(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    } catch (IllegalAccessException e4) {
                        x.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", new Object[]{str, e4.toString()});
                        x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                        bVar.c(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    }
                }
            }
        }
        return cVar;
    }

    private static c Tg(String str) {
        c cVar = (c) vzR.get(str);
        if (cVar != null) {
            return cVar;
        }
        cVar = (c) ac.getContext().getClassLoader().loadClass(ac.cfr() + ".plugin." + str + ".Plugin").newInstance();
        vzR.put(str, cVar);
        return cVar;
    }

    public static synchronized Class<?> fk(String str, String str2) {
        Class<?> loadClass;
        synchronized (d.class) {
            if (((String) vzQ.get(str)) != null) {
                x.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[]{str, (String) vzQ.get(str)});
            }
            if (Th(str)) {
                String str3 = ac.cfr() + ".plugin." + str;
                if (str2.startsWith(".")) {
                    str2 = str3 + str2;
                }
                try {
                    loadClass = ac.getContext().getClassLoader().loadClass(str2);
                } catch (Exception e) {
                    x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                    loadClass = null;
                }
            } else {
                x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                loadClass = null;
            }
        }
        return loadClass;
    }

    public static synchronized boolean Th(String str) {
        boolean z;
        synchronized (d.class) {
            z = Tf(str) != null;
        }
        return z;
    }
}
