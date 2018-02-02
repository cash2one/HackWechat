package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class d extends DataSetObservable {
    private static final String Ef = d.class.getSimpleName();
    private static final Object Oe = new Object();
    private static final Map<String, d> Of = new HashMap();
    private Intent Ks;
    final Object Og;
    final List<a> Oh;
    private final List<c> Oi;
    private final String Oj;
    private b Ok;
    private int Ol;
    private boolean Om;
    private boolean On;
    private boolean Oo;
    private boolean Op;
    private d Oq;
    private final Context mContext;

    public final int ef() {
        int size;
        synchronized (this.Og) {
            eh();
            size = this.Oh.size();
        }
        return size;
    }

    public final ResolveInfo aJ(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.Og) {
            eh();
            resolveInfo = ((a) this.Oh.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.Og) {
            eh();
            List list = this.Oh;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent aK(int i) {
        synchronized (this.Og) {
            if (this.Ks == null) {
                return null;
            }
            eh();
            a aVar = (a) this.Oh.get(i);
            ComponentName componentName = new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.Ks);
            intent.setComponent(componentName);
            if (this.Oq != null) {
                Intent intent2 = new Intent(intent);
                if (this.Oq.em()) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo eg() {
        synchronized (this.Og) {
            eh();
            if (this.Oh.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.Oh.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.Og) {
            eh();
            size = this.Oi.size();
        }
        return size;
    }

    final void eh() {
        int i;
        int i2 = 1;
        if (!this.Op || this.Ks == null) {
            i = 0;
        } else {
            this.Op = false;
            this.Oh.clear();
            List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.Ks, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.Oh.add(new a(this, (ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.Om && this.Oo && !TextUtils.isEmpty(this.Oj)) {
            this.Om = false;
            this.On = true;
            ek();
        } else {
            i2 = 0;
        }
        i |= i2;
        ej();
        if (i != 0) {
            ei();
            notifyChanged();
        }
    }

    private boolean ei() {
        if (this.Ok == null || this.Ks == null || this.Oh.isEmpty() || this.Oi.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.Oi);
        return true;
    }

    final boolean a(c cVar) {
        boolean add = this.Oi.add(cVar);
        if (add) {
            this.Oo = true;
            ej();
            if (this.On) {
                if (this.Oo) {
                    this.Oo = false;
                    if (!TextUtils.isEmpty(this.Oj)) {
                        AsyncTask eVar = new e(this, (byte) 0);
                        Object[] objArr = new Object[]{new ArrayList(this.Oi), this.Oj};
                        if (VERSION.SDK_INT >= 11) {
                            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
                        } else {
                            eVar.execute(objArr);
                        }
                    }
                }
                ei();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    private void ej() {
        int size = this.Oi.size() - this.Ol;
        if (size > 0) {
            this.Oo = true;
            for (int i = 0; i < size; i++) {
                this.Oi.remove(0);
            }
        }
    }

    private void ek() {
        try {
            InputStream openFileInput = this.mContext.openFileInput(this.Oj);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.Oi;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (XmlPullParserException e2) {
                new StringBuilder("Error reading historical recrod file: ").append(this.Oj);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                new StringBuilder("Error reading historical recrod file: ").append(this.Oj);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (FileNotFoundException e7) {
        }
    }
}
