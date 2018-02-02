package c.t.m.g;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

public class cl implements Observer {
    protected static String a = "";
    protected static String b = "";
    protected static String c = "";
    private static final HashMap<String, String> e = new HashMap();
    private static cl f = null;
    volatile ConcurrentHashMap<String, List<d>> d;
    private HashMap<Class<?>, Object> g;
    private volatile ConcurrentHashMap<String, String> h;
    private volatile boolean i;

    protected static void a(String str, String str2) {
        a = str;
        c = str2;
        b("app_version", str2);
    }

    protected static void a(HashMap<String, String> hashMap) {
        b("cc_version", "-1");
        b("cc_req_interval", "10800000");
        b("last_pull_time", "0");
        for (String str : hashMap.keySet()) {
            b(str, (String) hashMap.get(str));
        }
    }

    protected static void a(String str) {
        b = str;
    }

    private static void b(String str, String str2) {
        e.put(str, str2);
    }

    public static synchronized cl a() {
        cl clVar;
        synchronized (cl.class) {
            if (f == null) {
                synchronized (cl.class) {
                    f = new cl();
                }
            }
            clVar = f;
        }
        return clVar;
    }

    private cl() {
        this.g = new HashMap();
        this.h = null;
        this.d = null;
        this.i = false;
        this.h = new ConcurrentHashMap(((e.size() << 2) / 3) + 1);
        this.d = new ConcurrentHashMap(((e.size() << 2) / 3) + 1);
        this.g.put(String.class, "");
        this.g.put(Integer.class, Integer.valueOf(Integer.MIN_VALUE));
        this.g.put(Float.class, Float.valueOf(Float.MIN_VALUE));
        this.g.put(Double.class, Double.valueOf(Double.MIN_VALUE));
        this.g.put(Long.class, Long.valueOf(Long.MIN_VALUE));
        this.g.put(Boolean.class, Boolean.FALSE);
        c();
    }

    protected final void b() {
        if (cm.a().b() == null) {
            ch.a("CC_Set", "---> read xml: failed,not init finish!");
            return;
        }
        for (String f : e.keySet()) {
            f(f);
        }
        this.i = true;
        ch.a("CC_Set", "---> read xml:" + this.h.toString());
    }

    public final int b(String str) {
        return ((Integer) a(str, Integer.class)).intValue();
    }

    public final long c(String str) {
        return ((Long) a(str, Long.class)).longValue();
    }

    public final boolean d(String str) {
        return ((Boolean) a(str, Boolean.class)).booleanValue();
    }

    public final String e(String str) {
        return (String) a(str, String.class);
    }

    private final Object a(String str, Class<?> cls) {
        if (!this.i) {
            c();
        }
        if (this.g.containsKey(cls)) {
            String str2 = (String) this.h.get(str);
            if (str2 == null || str2.length() == 0) {
                str2 = (String) e.get(str);
            }
            if (str2 == null) {
                str2 = "";
            }
            try {
                return b(str2, (Class) cls);
            } catch (Throwable th) {
                return this.g.get(cls);
            }
        }
        throw new IllegalStateException("The property \"" + str + "\" don't support class type \"" + cls.toString() + "\"");
    }

    private static Object b(String str, Class<?> cls) {
        if (cls == Integer.class) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (cls == Long.class) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (cls == Boolean.class) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (cls == Float.class) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (cls == Double.class) {
            return Double.valueOf(Double.parseDouble(str));
        }
        return str;
    }

    public void update(Observable observable, Object obj) {
        if (obj == null) {
            obj = null;
        } else {
            String str = (String) obj;
        }
        if (obj != null && obj.length() != 0) {
            String str2 = "update [" + obj + "] : " + ((String) this.h.get(obj)) + " --> ";
            f(obj);
            ch.a("CC_Set", str2 + ((String) this.h.get(obj)));
            List list = (List) this.d.get(obj);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    private void f(String str) {
        if (e.get(str) != null) {
            try {
                SharedPreferences b = cm.a().b();
                if (b != null) {
                    ConcurrentHashMap concurrentHashMap = this.h;
                    if (e.containsKey(str)) {
                        concurrentHashMap.put(str, b.getString(str, (String) e.get(str)));
                        return;
                    }
                    throw new NullPointerException("Not exists property name \"" + str + "\"");
                }
            } catch (Throwable th) {
                ch.b("CC_Set", th.toString());
            }
        }
    }

    private void c() {
        try {
            SharedPreferences b = cm.a().b();
            if (b != null) {
                String string = b.getString("app_version", "");
                if (c.length() > 0 && !c.equals(string)) {
                    ch.a("CC_Set", "clear sp > pre:" + string + ",now:" + c);
                    b.edit().clear().apply();
                    b.edit().putString("app_version", c).apply();
                }
            }
            b();
        } catch (Throwable th) {
            ch.a("CC_Set", th.getMessage(), th);
        }
    }
}
