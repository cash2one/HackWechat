package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import android.util.LruCache;
import android.util.Xml;
import com.tencent.mm.sdk.f.e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class am implements SharedPreferences {
    private static af xgg = null;
    private static final Object xgo = new Object();
    private static final LruCache<String, am> xgq = new LruCache(5);
    private static Class<?> xgr = null;
    private static Method xgs = null;
    private static Method xgt = null;
    private static boolean xgu = false;
    private Map<String, Object> gMU = null;
    private boolean gPF = false;
    private File iFl = null;
    private int mMode = 0;
    private FLock xgh = null;
    private File xgi = null;
    private boolean xgj = false;
    private int xgk = 0;
    private long xgl = 0;
    private long xgm = 0;
    private final Object xgn = new Object();
    private final WeakHashMap<OnSharedPreferenceChangeListener, Object> xgp = new WeakHashMap();

    public static class a {
        private static SharedPreferences mPref = ac.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
        public static String xgw = "pref_key_is_enable_MultiProcSP";
        public static String xgx = "pref_key_is_disabled_MultiProcSP_manually";

        public static void lB(boolean z) {
            setValue(xgx, z);
        }

        public static boolean cfO() {
            return !Vh(xgx) && Vh(xgw);
        }

        private static boolean Vh(String str) {
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
            mPref = sharedPreferences;
            if (sharedPreferences == null) {
                x.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return false;
            }
            x.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", Boolean.valueOf(mPref.getBoolean(str, false)));
            return mPref.getBoolean(str, false);
        }

        public static void setValue(String str, boolean z) {
            if (mPref == null) {
                x.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return;
            }
            Editor edit = mPref.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    private final class b implements Editor {
        final /* synthetic */ am xgv;
        private final Map<String, Object> xgy;
        private boolean xgz;

        private b(am amVar) {
            this.xgv = amVar;
            this.xgy = new HashMap();
            this.xgz = false;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void a(b bVar, c cVar) {
            if (bVar.xgv.xgj) {
                try {
                    bVar.xgv.xgh.ceU();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MultiProcSharedPreferences", e, "", new Object[0]);
                }
            }
            try {
                if (bVar.xgv.iFl.exists()) {
                    synchronized (bVar) {
                        if (!cVar.xgE) {
                            cVar.lC(true);
                        }
                    }
                }
                try {
                    OutputStream F = bVar.F(bVar.xgv.iFl);
                    if (F == null) {
                        cVar.lC(false);
                        if (bVar.xgv.xgj) {
                            try {
                                bVar.xgv.xgh.unlock();
                                return;
                            } catch (Exception e2) {
                                return;
                            }
                        }
                        return;
                    }
                    Map map = cVar.xgG;
                    XmlSerializer newSerializer = Xml.newSerializer();
                    newSerializer.setOutput(F, ProtocolPackage.ServerEncoding);
                    newSerializer.startDocument(null, Boolean.valueOf(true));
                    newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    bj.a(map, null, newSerializer);
                    newSerializer.endDocument();
                    F.getFD().sync();
                    F.close();
                    am.g(bVar.xgv.iFl, bVar.xgv.mMode);
                    synchronized (bVar) {
                        bVar.xgv.xgl = bVar.xgv.iFl.lastModified();
                        bVar.xgv.xgm = bVar.xgv.iFl.length();
                    }
                    bVar.xgv.xgi.delete();
                    cVar.lC(true);
                    if (bVar.xgv.xgj) {
                        try {
                            bVar.xgv.xgh.unlock();
                        } catch (Exception e3) {
                        }
                    }
                } catch (XmlPullParserException e4) {
                    x.w("MicroMsg.MultiProcSharedPreferences", "writeToFile: Got exception:", e4);
                    if (bVar.xgv.iFl.exists() && !bVar.xgv.iFl.delete()) {
                        x.e("MicroMsg.MultiProcSharedPreferences", "Couldn't clean up partially-written file " + bVar.xgv.iFl);
                    }
                    cVar.lC(false);
                    if (bVar.xgv.xgj) {
                        try {
                            bVar.xgv.xgh.unlock();
                        } catch (Exception e5) {
                        }
                    }
                } catch (IOException e6) {
                    x.w("MicroMsg.MultiProcSharedPreferences", "writeToFile: Got exception:", e6);
                    x.e("MicroMsg.MultiProcSharedPreferences", "Couldn't clean up partially-written file " + bVar.xgv.iFl);
                    cVar.lC(false);
                    if (bVar.xgv.xgj) {
                        bVar.xgv.xgh.unlock();
                    }
                }
            } catch (Throwable th) {
                if (bVar.xgv.xgj) {
                    try {
                        bVar.xgv.xgh.unlock();
                    } catch (Exception e7) {
                    }
                }
            }
        }

        public final Editor putString(String str, String str2) {
            synchronized (this) {
                this.xgy.put(str, str2);
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.xgy.put(str, set);
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            synchronized (this) {
                this.xgy.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            synchronized (this) {
                this.xgy.put(str, Long.valueOf(j));
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            synchronized (this) {
                this.xgy.put(str, Float.valueOf(f));
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.xgy.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final Editor remove(String str) {
            synchronized (this) {
                this.xgy.put(str, this);
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.xgz = true;
            }
            return this;
        }

        public final boolean commit() {
            c cfP = cfP();
            a(cfP, null);
            try {
                cfP.xgH.await();
                a(cfP);
                return cfP.xgI;
            } catch (InterruptedException e) {
                return false;
            }
        }

        public final void apply() {
            final c cfP = cfP();
            final Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ b xgB;

                public final void run() {
                    try {
                        cfP.xgH.await();
                    } catch (InterruptedException e) {
                    }
                }
            };
            at.M(anonymousClass1);
            a(cfP, new Runnable(this) {
                final /* synthetic */ b xgB;

                public final void run() {
                    anonymousClass1.run();
                    at.N(anonymousClass1);
                }
            });
            a(cfP);
        }

        private c cfP() {
            c cVar = new c();
            synchronized (this.xgv) {
                if (this.xgv.xgk > 0) {
                    this.xgv.gMU = new HashMap(this.xgv.gMU);
                }
                cVar.xgG = this.xgv.gMU;
                this.xgv.xgk = this.xgv.xgk + 1;
                byte b = this.xgv.xgp.size() > 0 ? (byte) 1 : (byte) 0;
                if (b != (byte) 0) {
                    cVar.xgF = new ArrayList();
                    cVar.gCl = new HashSet(this.xgv.xgp.keySet());
                }
                synchronized (this) {
                    if (this.xgz) {
                        if (!this.xgv.gMU.isEmpty()) {
                            cVar.xgE = true;
                            this.xgv.gMU.clear();
                        }
                        this.xgz = false;
                    }
                    for (Entry entry : this.xgy.entrySet()) {
                        String str = (String) entry.getKey();
                        b value = entry.getValue();
                        if (value != this) {
                            if (this.xgv.gMU.containsKey(str)) {
                                Object obj = this.xgv.gMU.get(str);
                                if (obj != null && obj.equals(value)) {
                                }
                            }
                            this.xgv.gMU.put(str, value);
                        } else if (this.xgv.gMU.containsKey(str)) {
                            this.xgv.gMU.remove(str);
                        }
                        cVar.xgE = true;
                        if (b != (byte) 0) {
                            cVar.xgF.add(str);
                        }
                    }
                    this.xgy.clear();
                }
            }
            return cVar;
        }

        private void a(final c cVar, final Runnable runnable) {
            Object obj = 1;
            Runnable anonymousClass3 = new Runnable(this) {
                final /* synthetic */ b xgB;

                public final void run() {
                    synchronized (this.xgB.xgv.xgn) {
                        b.a(this.xgB, cVar);
                    }
                    synchronized (this.xgB.xgv) {
                        this.xgB.xgv.xgk = this.xgB.xgv.xgk - 1;
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            };
            if ((runnable == null ? 1 : null) != null) {
                synchronized (this.xgv) {
                    if (this.xgv.xgk != 1) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    anonymousClass3.run();
                    return;
                }
            }
            at.cfU().execute(anonymousClass3);
        }

        private FileOutputStream F(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                File parentFile = file.getParentFile();
                if (parentFile.mkdir()) {
                    am.g(parentFile, this.xgv.mMode);
                    try {
                        return new FileOutputStream(file);
                    } catch (FileNotFoundException e2) {
                        x.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file " + file, e2);
                        return null;
                    }
                }
                x.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file " + file);
                return null;
            }
        }

        private void a(final c cVar) {
            if (cVar.gCl != null && cVar.xgF != null && cVar.xgF.size() != 0) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    for (int size = cVar.xgF.size() - 1; size >= 0; size--) {
                        String str = (String) cVar.xgF.get(size);
                        for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : cVar.gCl) {
                            if (onSharedPreferenceChangeListener != null) {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.xgv, str);
                            }
                        }
                    }
                    return;
                }
                am.xgg.post(new Runnable(this) {
                    final /* synthetic */ b xgB;

                    public final void run() {
                        this.xgB.a(cVar);
                    }
                });
            }
        }
    }

    private static class c {
        public Set<OnSharedPreferenceChangeListener> gCl;
        public boolean xgE;
        public List<String> xgF;
        public Map<String, Object> xgG;
        public final CountDownLatch xgH;
        public volatile boolean xgI;

        private c() {
            this.xgE = false;
            this.xgF = null;
            this.gCl = null;
            this.xgG = null;
            this.xgH = new CountDownLatch(1);
            this.xgI = false;
        }

        public final void lC(boolean z) {
            this.xgI = z;
            this.xgH.countDown();
        }
    }

    static /* synthetic */ void a(am amVar) {
        Object obj;
        XmlPullParserException xmlPullParserException;
        FileNotFoundException fileNotFoundException;
        IOException iOException;
        Map map = null;
        if (amVar.xgj) {
            try {
                amVar.xgh.ceS();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MultiProcSharedPreferences", e, "", new Object[0]);
            }
        }
        try {
            if (!amVar.gPF) {
                if (amVar.xgi.exists()) {
                    amVar.iFl.delete();
                    amVar.xgi.renameTo(amVar.iFl);
                }
                if (amVar.iFl.exists() && !amVar.iFl.canRead()) {
                    x.w("MicroMsg.MultiProcSharedPreferences", "Attempt to read preferences file " + amVar.iFl + " without permission");
                }
                if (amVar.iFl.canRead()) {
                    InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(amVar.iFl), 16384);
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(bufferedInputStream, null);
                    HashMap hashMap = (HashMap) bj.a(newPullParser, new String[1]);
                    try {
                        bufferedInputStream.close();
                        map = hashMap;
                    } catch (XmlPullParserException e2) {
                        XmlPullParserException xmlPullParserException2 = e2;
                        obj = hashMap;
                        xmlPullParserException = xmlPullParserException2;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", xmlPullParserException);
                        amVar.gPF = true;
                        if (map != null) {
                            amVar.gMU = new HashMap();
                        } else {
                            amVar.gMU = map;
                            amVar.xgl = amVar.iFl.lastModified();
                            amVar.xgm = amVar.iFl.length();
                        }
                        amVar.notifyAll();
                        if (!amVar.xgj) {
                            try {
                                amVar.xgh.unlock();
                            } catch (Exception e3) {
                                return;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        FileNotFoundException fileNotFoundException2 = e4;
                        obj = hashMap;
                        fileNotFoundException = fileNotFoundException2;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", fileNotFoundException);
                        amVar.gPF = true;
                        if (map != null) {
                            amVar.gMU = map;
                            amVar.xgl = amVar.iFl.lastModified();
                            amVar.xgm = amVar.iFl.length();
                        } else {
                            amVar.gMU = new HashMap();
                        }
                        amVar.notifyAll();
                        if (!amVar.xgj) {
                            amVar.xgh.unlock();
                        }
                    } catch (IOException e5) {
                        IOException iOException2 = e5;
                        obj = hashMap;
                        iOException = iOException2;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", iOException);
                        amVar.gPF = true;
                        if (map != null) {
                            amVar.gMU = new HashMap();
                        } else {
                            amVar.gMU = map;
                            amVar.xgl = amVar.iFl.lastModified();
                            amVar.xgm = amVar.iFl.length();
                        }
                        amVar.notifyAll();
                        if (!amVar.xgj) {
                            amVar.xgh.unlock();
                        }
                    }
                }
                amVar.gPF = true;
                if (map != null) {
                    amVar.gMU = map;
                    amVar.xgl = amVar.iFl.lastModified();
                    amVar.xgm = amVar.iFl.length();
                } else {
                    amVar.gMU = new HashMap();
                }
                amVar.notifyAll();
                if (!amVar.xgj) {
                    amVar.xgh.unlock();
                }
            } else if (amVar.xgj) {
                try {
                    amVar.xgh.unlock();
                } catch (Exception e6) {
                }
            }
        } catch (XmlPullParserException e7) {
            xmlPullParserException = e7;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", xmlPullParserException);
            amVar.gPF = true;
            if (map != null) {
                amVar.gMU = map;
                amVar.xgl = amVar.iFl.lastModified();
                amVar.xgm = amVar.iFl.length();
            } else {
                amVar.gMU = new HashMap();
            }
            amVar.notifyAll();
            if (!amVar.xgj) {
                amVar.xgh.unlock();
            }
        } catch (FileNotFoundException e8) {
            fileNotFoundException = e8;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", fileNotFoundException);
            amVar.gPF = true;
            if (map != null) {
                amVar.gMU = new HashMap();
            } else {
                amVar.gMU = map;
                amVar.xgl = amVar.iFl.lastModified();
                amVar.xgm = amVar.iFl.length();
            }
            amVar.notifyAll();
            if (!amVar.xgj) {
                amVar.xgh.unlock();
            }
        } catch (IOException e9) {
            iOException = e9;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", iOException);
            amVar.gPF = true;
            if (map != null) {
                amVar.gMU = map;
                amVar.xgl = amVar.iFl.lastModified();
                amVar.xgm = amVar.iFl.length();
            } else {
                amVar.gMU = new HashMap();
            }
            amVar.notifyAll();
            if (!amVar.xgj) {
                amVar.xgh.unlock();
            }
        } catch (Throwable th) {
            if (amVar.xgj) {
                try {
                    amVar.xgh.unlock();
                } catch (Exception e10) {
                }
            }
        }
    }

    static /* synthetic */ void g(File file, int i) {
        boolean z = false;
        file.setReadable(true, (i & 1) == 0);
        if ((i & 2) == 0) {
            z = true;
        }
        file.setWritable(true, z);
    }

    public static SharedPreferences bh(Context context, String str) {
        int i = 1;
        if (a.cfO()) {
            x.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", str);
            am amVar = (am) xgq.get(str);
            if (amVar == null) {
                SharedPreferences amVar2 = new am(context, str, 4);
                xgq.put(str, amVar2);
                return amVar2;
            }
            synchronized (amVar) {
                if (amVar.xgk > 0 || (amVar.xgl == amVar.iFl.lastModified() && amVar.xgm == amVar.iFl.length())) {
                    i = 0;
                }
                if (i == 0) {
                    return amVar;
                }
                amVar.cfL();
                return amVar;
            }
        }
        x.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", str);
        return context.getSharedPreferences(str, 4);
    }

    private am() {
        throw new RuntimeException("Not supported.");
    }

    private am(Context context, String str, int i) {
        Context applicationContext = context.getApplicationContext();
        if (xgg == null) {
            xgg = new af(Looper.getMainLooper());
        }
        String str2 = applicationContext.getApplicationInfo().dataDir;
        if (str2 == null || str2.length() == 0) {
            x.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
            str2 = "/data/data/" + applicationContext.getPackageName();
        }
        x.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: " + str2);
        File file = new File(str2, "shared_prefs");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!(file.canRead() && file.canWrite())) {
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
        this.iFl = new File(file, str + ".xml");
        this.xgi = new File(this.iFl.getPath() + ".bak");
        this.mMode = 4;
        this.xgj = true;
        if (this.xgj) {
            this.xgh = new FLock(this.iFl.getPath() + ".lock");
        }
        cfL();
    }

    private void cfL() {
        synchronized (this) {
            this.gPF = false;
        }
        e.b(new Runnable(this) {
            final /* synthetic */ am xgv;

            {
                this.xgv = r1;
            }

            public final void run() {
                synchronized (this.xgv) {
                    am.a(this.xgv);
                }
            }
        }, "MultiProcessSP-LoadThread").start();
    }

    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.xgp.put(onSharedPreferenceChangeListener, xgo);
        }
    }

    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.xgp.remove(onSharedPreferenceChangeListener);
        }
    }

    private void cfM() {
        if (!(this.gPF || xgu)) {
            if (xgr == null) {
                try {
                    xgr = Class.forName("dalvik.system.BlockGuard");
                } catch (Throwable th) {
                    xgu = true;
                }
            }
            if (xgs == null) {
                try {
                    Method declaredMethod = xgr.getDeclaredMethod("getThreadPolicy", new Class[0]);
                    xgs = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Throwable th2) {
                    xgu = true;
                }
            }
            try {
                if (xgs != null) {
                    Object invoke = xgs.invoke(null, new Object[0]);
                    if (xgt == null) {
                        Method declaredMethod2 = invoke.getClass().getDeclaredMethod("onReadFromDisk", new Class[0]);
                        xgt = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    }
                    xgt.invoke(invoke, new Object[0]);
                }
            } catch (Throwable th3) {
                xgu = true;
            }
        }
        while (!this.gPF) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public final Map<String, ?> getAll() {
        Map hashMap;
        synchronized (this) {
            cfM();
            hashMap = new HashMap(this.gMU);
        }
        return hashMap;
    }

    public final String getString(String str, String str2) {
        String str3;
        synchronized (this) {
            cfM();
            str3 = (String) this.gMU.get(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            cfM();
            set2 = (Set) this.gMU.get(str);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        synchronized (this) {
            cfM();
            Integer num = (Integer) this.gMU.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        synchronized (this) {
            cfM();
            Long l = (Long) this.gMU.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        synchronized (this) {
            cfM();
            Float f2 = (Float) this.gMU.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            cfM();
            Boolean bool = (Boolean) this.gMU.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        synchronized (this) {
            cfM();
            containsKey = this.gMU.containsKey(str);
        }
        return containsKey;
    }

    public final Editor edit() {
        synchronized (this) {
            cfM();
        }
        return new b();
    }
}
