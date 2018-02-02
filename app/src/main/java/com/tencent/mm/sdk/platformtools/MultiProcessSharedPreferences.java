package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {
    private static String AUTHORITY;
    private static volatile Uri AUTHORITY_URI;
    private List<SoftReference<OnSharedPreferenceChangeListener>> eM;
    private BroadcastReceiver jhN;
    private Context mContext;
    private int mMode;
    private String mName;
    private boolean xgJ;
    private UriMatcher xgK;
    private Map<String, Integer> xgL;

    private static final class a extends MatrixCursor {
        private Bundle vf;

        public a(Bundle bundle) {
            super(new String[0], 0);
            this.vf = bundle;
        }

        public final Bundle getExtras() {
            return this.vf;
        }

        public final Bundle respond(Bundle bundle) {
            this.vf = bundle;
            return this.vf;
        }
    }

    public final class b implements Editor {
        final /* synthetic */ MultiProcessSharedPreferences xgM;
        private final Map<String, Object> xgy = new HashMap();
        private boolean xgz = false;

        public b(MultiProcessSharedPreferences multiProcessSharedPreferences) {
            this.xgM = multiProcessSharedPreferences;
        }

        public final Editor putString(String str, String str2) {
            synchronized (this) {
                this.xgy.put(str, str2);
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.xgy.put(str, set == null ? null : new HashSet(set));
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
                this.xgy.put(str, null);
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.xgz = true;
            }
            return this;
        }

        public final void apply() {
            setValue("apply");
        }

        public final boolean commit() {
            return setValue("commit");
        }

        private boolean setValue(String str) {
            if (this.xgM.xgJ) {
                return false;
            }
            boolean z;
            synchronized (this.xgM) {
                this.xgM.eM(this.xgM.mContext);
                String[] strArr = new String[]{String.valueOf(this.xgM.mMode), String.valueOf(this.xgz)};
                synchronized (this) {
                    if (this.xgM.mContext.getContentResolver().update(Uri.withAppendedPath(Uri.withAppendedPath(MultiProcessSharedPreferences.AUTHORITY_URI, this.xgM.mName), str), c.n((HashMap) this.xgy), null, strArr) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    private static class c {
        public static ContentValues n(HashMap<String, Object> hashMap) {
            try {
                Constructor declaredConstructor = ContentValues.class.getDeclaredConstructor(new Class[]{HashMap.class});
                declaredConstructor.setAccessible(true);
                return (ContentValues) declaredConstructor.newInstance(new Object[]{hashMap});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            } catch (Throwable e2222) {
                throw new RuntimeException(e2222);
            }
        }

        public static Editor a(Editor editor, String str, Set<String> set) {
            try {
                return (Editor) editor.getClass().getDeclaredMethod("putStringSet", new Class[]{String.class, Set.class}).invoke(editor, new Object[]{str, set});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            }
        }
    }

    private void eM(Context context) {
        if (AUTHORITY_URI == null) {
            String str = null;
            Uri uri = AUTHORITY_URI;
            synchronized (this) {
                if (uri == null) {
                    str = eN(context);
                    uri = Uri.parse("content://" + str);
                }
                if (str == null) {
                    throw new IllegalArgumentException("'AUTHORITY' initialize failed.");
                }
            }
            AUTHORITY = str;
            AUTHORITY_URI = uri;
        }
    }

    private static String eN(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null || packageInfo.providers == null) {
            return null;
        }
        for (ProviderInfo providerInfo : packageInfo.providers) {
            if (providerInfo.name.equals(MultiProcessSharedPreferences.class.getName())) {
                return providerInfo.authority;
            }
        }
        return null;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        return new MultiProcessSharedPreferences(context, str, i);
    }

    private MultiProcessSharedPreferences(Context context, String str, int i) {
        this.mContext = context;
        this.mName = str;
        this.mMode = i;
        this.xgJ = context.getPackageManager().isSafeMode();
    }

    public Map<String, ?> getAll() {
        return (Map) b("getAll", null, null);
    }

    public String getString(String str, String str2) {
        String str3 = (String) b("getString", str, str2);
        return str3 != null ? str3 : str2;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            set2 = (Set) b("getString", str, set);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public int getInt(String str, int i) {
        Integer num = (Integer) b("getInt", str, Integer.valueOf(i));
        return num != null ? num.intValue() : i;
    }

    public long getLong(String str, long j) {
        Long l = (Long) b("getLong", str, Long.valueOf(j));
        return l != null ? l.longValue() : j;
    }

    public float getFloat(String str, float f) {
        Float f2 = (Float) b("getFloat", str, Float.valueOf(f));
        return f2 != null ? f2.floatValue() : f;
    }

    public boolean getBoolean(String str, boolean z) {
        Boolean bool = (Boolean) b("getBoolean", str, Boolean.valueOf(z));
        return bool != null ? bool.booleanValue() : z;
    }

    public boolean contains(String str) {
        Boolean bool = (Boolean) b("contains", str, null);
        return bool != null ? bool.booleanValue() : false;
    }

    public Editor edit() {
        return new b(this);
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            if (this.eM == null) {
                this.eM = new ArrayList();
            }
            Boolean bool = (Boolean) b("registerOnSharedPreferenceChangeListener", null, Boolean.valueOf(false));
            if (bool != null && bool.booleanValue()) {
                this.eM.add(new SoftReference(onSharedPreferenceChangeListener));
                if (this.jhN == null) {
                    this.jhN = new BroadcastReceiver(this) {
                        final /* synthetic */ MultiProcessSharedPreferences xgM;

                        {
                            this.xgM = r1;
                        }

                        public final void onReceive(Context context, Intent intent) {
                            List list = (List) intent.getSerializableExtra(DownloadSettingTable$Columns.VALUE);
                            if (this.xgM.mName.equals(intent.getStringExtra("name")) && list != null) {
                                Collection b;
                                synchronized (this.xgM) {
                                    b = this.xgM.eM;
                                }
                                List<SoftReference> arrayList = new ArrayList(b);
                                for (int size = list.size() - 1; size >= 0; size--) {
                                    String str = (String) list.get(size);
                                    for (SoftReference softReference : arrayList) {
                                        OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (OnSharedPreferenceChangeListener) softReference.get();
                                        if (onSharedPreferenceChangeListener != null) {
                                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.xgM, str);
                                        }
                                    }
                                }
                            }
                        }
                    };
                    this.mContext.registerReceiver(this.jhN, new IntentFilter(Vi(this.mName)));
                }
            }
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            b("unregisterOnSharedPreferenceChangeListener", null, Boolean.valueOf(false));
            if (this.eM != null) {
                List<SoftReference> arrayList = new ArrayList();
                for (SoftReference softReference : this.eM) {
                    OnSharedPreferenceChangeListener onSharedPreferenceChangeListener2 = (OnSharedPreferenceChangeListener) softReference.get();
                    if (onSharedPreferenceChangeListener2 != null && onSharedPreferenceChangeListener2.equals(onSharedPreferenceChangeListener)) {
                        arrayList.add(softReference);
                    }
                }
                for (SoftReference softReference2 : arrayList) {
                    this.eM.remove(softReference2);
                }
                if (this.eM.isEmpty() && this.jhN != null) {
                    this.mContext.unregisterReceiver(this.jhN);
                    this.jhN = null;
                    this.eM = null;
                }
            }
        }
    }

    private Object b(String str, String str2, Object obj) {
        Object obj2 = null;
        if (this.xgJ) {
            return null;
        }
        eM(this.mContext);
        Uri withAppendedPath = Uri.withAppendedPath(Uri.withAppendedPath(AUTHORITY_URI, this.mName), str);
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(this.mMode);
        strArr[1] = str2;
        strArr[2] = obj == null ? null : String.valueOf(obj);
        Cursor query = this.mContext.getContentResolver().query(withAppendedPath, null, null, strArr, null);
        if (query != null) {
            try {
                Bundle extras = query.getExtras();
                if (extras != null) {
                    obj2 = extras.get(DownloadSettingTable$Columns.VALUE);
                    extras.clear();
                }
            } catch (Exception e) {
            }
            query.close();
        }
        if (obj2 == null) {
            return obj;
        }
        return obj2;
    }

    private static String Vi(String str) {
        return String.format("%1$s_%2$s", new Object[]{MultiProcessSharedPreferences.class.getName(), str});
    }

    public boolean onCreate() {
        eM(getContext());
        this.xgK = new UriMatcher(-1);
        this.xgK.addURI(AUTHORITY, "*/getAll", 1);
        this.xgK.addURI(AUTHORITY, "*/getString", 2);
        this.xgK.addURI(AUTHORITY, "*/getInt", 3);
        this.xgK.addURI(AUTHORITY, "*/getLong", 4);
        this.xgK.addURI(AUTHORITY, "*/getFloat", 5);
        this.xgK.addURI(AUTHORITY, "*/getBoolean", 6);
        this.xgK.addURI(AUTHORITY, "*/contains", 7);
        this.xgK.addURI(AUTHORITY, "*/apply", 8);
        this.xgK.addURI(AUTHORITY, "*/commit", 9);
        this.xgK.addURI(AUTHORITY, "*/registerOnSharedPreferenceChangeListener", 10);
        this.xgK.addURI(AUTHORITY, "*/unregisterOnSharedPreferenceChangeListener", 11);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        boolean z = true;
        boolean z2 = false;
        String str3 = (String) uri.getPathSegments().get(0);
        int parseInt = Integer.parseInt(strArr2[0]);
        String str4 = strArr2[1];
        String str5 = strArr2[2];
        Bundle bundle = new Bundle();
        Integer num;
        Integer num2;
        switch (this.xgK.match(uri)) {
            case 1:
                bundle.putSerializable(DownloadSettingTable$Columns.VALUE, (HashMap) getContext().getSharedPreferences(str3, parseInt).getAll());
                break;
            case 2:
                bundle.putString(DownloadSettingTable$Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getString(str4, str5));
                break;
            case 3:
                bundle.putInt(DownloadSettingTable$Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getInt(str4, Integer.parseInt(str5)));
                break;
            case 4:
                bundle.putLong(DownloadSettingTable$Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getLong(str4, Long.parseLong(str5)));
                break;
            case 5:
                bundle.putFloat(DownloadSettingTable$Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getFloat(str4, Float.parseFloat(str5)));
                break;
            case 6:
                bundle.putBoolean(DownloadSettingTable$Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getBoolean(str4, Boolean.parseBoolean(str5)));
                break;
            case 7:
                bundle.putBoolean(DownloadSettingTable$Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).contains(str4));
                break;
            case 10:
                cfQ();
                num = (Integer) this.xgL.get(str3);
                parseInt = (num == null ? 0 : num.intValue()) + 1;
                this.xgL.put(str3, Integer.valueOf(parseInt));
                num2 = (Integer) this.xgL.get(str3);
                str4 = DownloadSettingTable$Columns.VALUE;
                if (parseInt == (num2 == null ? 0 : num2.intValue())) {
                    z2 = true;
                }
                bundle.putBoolean(str4, z2);
                break;
            case 11:
                cfQ();
                num = (Integer) this.xgL.get(str3);
                parseInt = (num == null ? 0 : num.intValue()) - 1;
                if (parseInt > 0) {
                    this.xgL.put(str3, Integer.valueOf(parseInt));
                    num2 = (Integer) this.xgL.get(str3);
                    str4 = DownloadSettingTable$Columns.VALUE;
                    if (parseInt != (num2 == null ? 0 : num2.intValue())) {
                        z = false;
                    }
                    bundle.putBoolean(str4, z);
                    break;
                }
                this.xgL.remove(str3);
                String str6 = DownloadSettingTable$Columns.VALUE;
                if (this.xgL.containsKey(str3)) {
                    z = false;
                }
                bundle.putBoolean(str6, z);
                break;
            default:
                throw new IllegalArgumentException("This is Unknown Uri：" + uri);
        }
        return new a(bundle);
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException("No external call");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external insert");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external delete");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2 = (String) uri.getPathSegments().get(0);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(str2, Integer.parseInt(strArr[0]));
        int match = this.xgK.match(uri);
        switch (match) {
            case 8:
            case 9:
                Object obj;
                ArrayList arrayList;
                int i;
                if (this.xgL == null || this.xgL.get(str2) == null || ((Integer) this.xgL.get(str2)).intValue() <= 0) {
                    obj = null;
                } else {
                    obj = 1;
                }
                HashMap hashMap = new HashMap();
                if (obj != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Map all = sharedPreferences.getAll();
                    arrayList = arrayList2;
                } else {
                    Object obj2 = hashMap;
                    arrayList = null;
                }
                Editor edit = sharedPreferences.edit();
                if (Boolean.parseBoolean(strArr[1])) {
                    if (!(obj == null || r4 == null || r4.isEmpty())) {
                        for (Entry key : r4.entrySet()) {
                            arrayList.add(key.getKey());
                        }
                    }
                    edit.clear();
                }
                for (Entry key2 : contentValues.valueSet()) {
                    String str3 = (String) key2.getKey();
                    Object value = key2.getValue();
                    if ((value instanceof b) || value == null) {
                        edit.remove(str3);
                        if (!(obj == null || r4 == null || !r4.containsKey(str3))) {
                            arrayList.add(str3);
                        }
                    } else if (!(obj == null || r4 == null || (r4.containsKey(str3) && (!r4.containsKey(str3) || value.equals(r4.get(str3)))))) {
                        arrayList.add(str3);
                    }
                    if (value instanceof String) {
                        edit.putString(str3, (String) value);
                    } else if (value instanceof Set) {
                        c.a(edit, str3, (Set) value);
                    } else if (value instanceof Integer) {
                        edit.putInt(str3, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(str3, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(str3, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(str3, ((Boolean) value).booleanValue());
                    }
                }
                if (obj == null || !arrayList.isEmpty()) {
                    switch (match) {
                        case 8:
                            try {
                                edit.getClass().getDeclaredMethod("apply", new Class[0]).invoke(edit, new Object[0]);
                                j(str2, arrayList);
                                i = 1;
                                break;
                            } catch (Throwable e) {
                                throw new RuntimeException(e);
                            } catch (Throwable e2) {
                                throw new RuntimeException(e2);
                            } catch (Throwable e22) {
                                throw new RuntimeException(e22);
                            } catch (Throwable e222) {
                                throw new RuntimeException(e222);
                            }
                        case 9:
                            if (edit.commit()) {
                                j(str2, arrayList);
                                i = 1;
                                break;
                            }
                        default:
                            i = 0;
                            break;
                    }
                }
                i = 1;
                contentValues.clear();
                return i;
            default:
                throw new IllegalArgumentException("This is Unknown Uri：" + uri);
        }
    }

    public void onLowMemory() {
        if (this.xgL != null) {
            this.xgL.clear();
        }
        super.onLowMemory();
    }

    public void onTrimMemory(int i) {
        if (this.xgL != null) {
            this.xgL.clear();
        }
        super.onTrimMemory(i);
    }

    private void cfQ() {
        if (this.xgL == null) {
            this.xgL = new HashMap();
        }
    }

    private void j(String str, ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Intent intent = new Intent();
            intent.setAction(Vi(str));
            intent.setPackage(getContext().getPackageName());
            intent.putExtra("name", str);
            intent.putExtra(DownloadSettingTable$Columns.VALUE, arrayList);
            getContext().sendBroadcast(intent);
        }
    }
}
