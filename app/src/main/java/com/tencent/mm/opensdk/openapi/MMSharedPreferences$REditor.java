package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c$b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MMSharedPreferences$REditor implements Editor {
    private boolean clear = false;
    private ContentResolver cr;
    private Set<String> remove = new HashSet();
    private Map<String, Object> values = new HashMap();

    public MMSharedPreferences$REditor(ContentResolver contentResolver) {
        this.cr = contentResolver;
    }

    public void apply() {
    }

    public Editor clear() {
        this.clear = true;
        return this;
    }

    public boolean commit() {
        ContentValues contentValues = new ContentValues();
        if (this.clear) {
            this.cr.delete(c$b.CONTENT_URI, null, null);
            this.clear = false;
        }
        for (String str : this.remove) {
            this.cr.delete(c$b.CONTENT_URI, "key = ?", new String[]{str});
        }
        for (Entry value : this.values.entrySet()) {
            int i;
            boolean z;
            Object value2 = value.getValue();
            if (value2 == null) {
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                i = 0;
            } else if (value2 instanceof Integer) {
                i = 1;
            } else if (value2 instanceof Long) {
                i = 2;
            } else if (value2 instanceof String) {
                i = 3;
            } else if (value2 instanceof Boolean) {
                i = 4;
            } else if (value2 instanceof Float) {
                i = 5;
            } else if (value2 instanceof Double) {
                i = 6;
            } else {
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + value2.getClass().toString());
                i = 0;
            }
            if (i == 0) {
                z = false;
            } else {
                contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(i));
                contentValues.put(DownloadSettingTable$Columns.VALUE, value2.toString());
                z = true;
            }
            if (z) {
                this.cr.update(c$b.CONTENT_URI, contentValues, "key = ?", new String[]{(String) value.getKey()});
            }
        }
        return true;
    }

    public Editor putBoolean(String str, boolean z) {
        this.values.put(str, Boolean.valueOf(z));
        this.remove.remove(str);
        return this;
    }

    public Editor putFloat(String str, float f) {
        this.values.put(str, Float.valueOf(f));
        this.remove.remove(str);
        return this;
    }

    public Editor putInt(String str, int i) {
        this.values.put(str, Integer.valueOf(i));
        this.remove.remove(str);
        return this;
    }

    public Editor putLong(String str, long j) {
        this.values.put(str, Long.valueOf(j));
        this.remove.remove(str);
        return this;
    }

    public Editor putString(String str, String str2) {
        this.values.put(str, str2);
        this.remove.remove(str);
        return this;
    }

    public Editor putStringSet(String str, Set<String> set) {
        return null;
    }

    public Editor remove(String str) {
        this.remove.add(str);
        return this;
    }
}
