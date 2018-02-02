package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class h extends BaseAdapter implements f {
    private final Context context;
    private final SharedPreferences gZO;
    private a yia;
    private final j yjl;
    private final LinkedList<String> yjm = new LinkedList();
    private final HashMap<String, Preference> yjn = new HashMap();
    private final HashSet<String> yjo = new HashSet();
    private final LinkedList<String> yjp = new LinkedList();
    private final HashMap<String, Integer> yjq = new HashMap();
    private final HashMap<String, String> yjr = new HashMap();
    private int[] yjs = new int[0];
    private boolean yjt = false;
    private boolean yju = false;

    public h(Context context, SharedPreferences sharedPreferences) {
        this.yjl = new j(context);
        this.context = context;
        this.gZO = sharedPreferences;
    }

    private static String d(Preference preference) {
        return preference.getClass().getName() + "L" + preference.getLayoutResource() + QLog.TAG_REPORTLEVEL_COLORUSER + preference.yjO;
    }

    private static String e(Preference preference) {
        if (preference.ibD == null || preference.ibD.length() <= 0) {
            return "_anonymous_pref@" + preference.hashCode();
        }
        return preference.ibD;
    }

    public final int indexOf(String str) {
        return this.yjm.indexOf(str);
    }

    public final int YP(String str) {
        if (this.yjp == null) {
            return -1;
        }
        return this.yjp.indexOf(str);
    }

    public final void a(Preference preference) {
        a(preference, -1);
    }

    public final void b(Preference preference) {
        b(preference, -1);
    }

    public final void a(Preference preference, int i) {
        b(preference, i);
        if (!this.yjt) {
            notifyDataSetChanged();
        }
    }

    private void b(Preference preference, int i) {
        String e = e(preference);
        this.yjn.put(e, preference);
        LinkedList linkedList = this.yjm;
        if (i == -1) {
            i = this.yjm.size();
        }
        linkedList.add(i, e);
        if (!(this.yjq.containsKey(d(preference)) || this.yju)) {
            this.yjq.put(d(preference), Integer.valueOf(this.yjq.size()));
        }
        if (preference.yjJ != null) {
            this.yjr.put(preference.yjJ + "|" + preference.ibD, preference.ibD);
        }
    }

    public final Preference YN(String str) {
        return (Preference) this.yjn.get(str);
    }

    public final void bk(String str, boolean z) {
        if (z) {
            if (!this.yjo.contains(str)) {
                this.yjo.add(str);
            } else {
                return;
            }
        } else if (!this.yjo.remove(str)) {
            return;
        }
        notifyDataSetChanged();
    }

    public final boolean c(Preference preference) {
        if (preference == null) {
            return false;
        }
        String e = e(preference);
        this.yjm.remove(e);
        this.yjn.remove(e);
        this.yjo.remove(preference.ibD);
        notifyDataSetChanged();
        return true;
    }

    public final boolean YO(String str) {
        return c(YN(str));
    }

    public final void removeAll() {
        this.yjp.clear();
        this.yjn.clear();
        this.yjm.clear();
        this.yjo.clear();
        notifyDataSetChanged();
    }

    public final void addPreferencesFromResource(int i) {
        InflateException inflateException;
        this.yjt = true;
        j jVar = this.yjl;
        Object xml = jVar.mContext.getResources().getXml(i);
        try {
            synchronized (jVar.HO) {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                jVar.HO[0] = jVar.mContext;
                try {
                    int next = xml.next();
                    while (next != 2 && next != 1) {
                        next = xml.next();
                    }
                    if (next != 2) {
                        throw new InflateException(xml.getPositionDescription() + ": No start tag found!");
                    }
                    jVar.a(xml.getName(), asAttributeSet);
                    jVar.a(xml, this, asAttributeSet);
                } catch (InflateException e) {
                    throw e;
                } catch (Throwable e2) {
                    inflateException = new InflateException(e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (Throwable e22) {
                    inflateException = new InflateException(xml.getPositionDescription() + ": " + e22.getMessage());
                    inflateException.initCause(e22);
                    throw inflateException;
                }
            }
            this.yjt = false;
            notifyDataSetChanged();
        } finally {
            xml.close();
        }
    }

    public final void b(a aVar) {
        this.yia = aVar;
        notifyDataSetChanged();
    }

    private void cqq() {
        Collection hashSet = new HashSet();
        int i = 0;
        while (i < this.yjp.size()) {
            Preference preference = (Preference) this.yjn.get(this.yjp.get(i));
            if ((preference instanceof PreferenceCategory) && bh.ov(preference.ibD) && i != 0) {
                Preference preference2 = (Preference) this.yjn.get(this.yjp.get(i - 1));
                if (preference2 instanceof PreferenceCategory) {
                    if (bh.ov(preference2.ibD) && (preference2.getTitle() == null || preference2.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(e(preference2));
                    } else if (bh.ov(preference.ibD) && (preference.getTitle() == null || preference.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(e(preference));
                    }
                }
            }
            i++;
        }
        this.yjp.removeAll(hashSet);
    }

    private static boolean Ff(int i) {
        return i == com.tencent.mm.w.a.h.dnt || i == com.tencent.mm.w.a.h.gXR || i == com.tencent.mm.w.a.h.gXT;
    }

    public void notifyDataSetChanged() {
        int i = 0;
        this.yjp.clear();
        Iterator it = this.yjm.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.yjo.contains(str)) {
                if (this.yjn.get(str) == null) {
                    x.e("MicroMsg.MMPreferenceAdapter", "not found pref by key " + str);
                } else {
                    this.yjp.add(str);
                }
            }
        }
        if (!this.yjp.isEmpty() && Ff(((Preference) this.yjn.get(this.yjp.get(0))).getLayoutResource())) {
            b(new PreferenceSmallCategory(this.context), 0);
        }
        cqq();
        this.yjs = new int[this.yjp.size()];
        if (this.yjs.length > 0) {
            Preference preference;
            int[] iArr;
            if (this.yjs.length == 1) {
                preference = (Preference) this.yjn.get(this.yjp.get(0));
                if (!Ff(((Preference) this.yjn.get(this.yjp.get(0))).getLayoutResource())) {
                    this.yjs[0] = 4;
                } else if (preference instanceof CheckBoxPreference) {
                    iArr = this.yjs;
                    iArr[0] = iArr[0] | 8;
                } else {
                    this.yjs[0] = 3;
                }
                a((Preference) this.yjn.get(this.yjp.get(0)), this.gZO);
                super.notifyDataSetChanged();
                return;
            }
            while (i < this.yjp.size()) {
                a((Preference) this.yjn.get(this.yjp.get(i)), this.gZO);
                preference = (Preference) this.yjn.get(this.yjp.get(i));
                int layoutResource = preference.getLayoutResource();
                int layoutResource2;
                if (Ff(layoutResource)) {
                    if (preference instanceof CheckBoxPreference) {
                        iArr = this.yjs;
                        iArr[i] = iArr[i] | 8;
                    } else if (i == 0) {
                        iArr = this.yjs;
                        iArr[i] = iArr[i] | 1;
                    } else {
                        if (i == this.yjp.size() - 1) {
                            iArr = this.yjs;
                            iArr[i] = iArr[i] | 2;
                        }
                        layoutResource2 = ((Preference) this.yjn.get(this.yjp.get(i - 1))).getLayoutResource();
                        if (layoutResource2 != com.tencent.mm.w.a.h.dnt || layoutResource2 == com.tencent.mm.w.a.h.gXR || layoutResource2 == com.tencent.mm.w.a.h.gXT) {
                            iArr = this.yjs;
                            iArr[i] = iArr[i] | 1;
                        }
                    }
                } else if (layoutResource != com.tencent.mm.w.a.h.dnW) {
                    iArr = this.yjs;
                    iArr[i] = iArr[i] | 4;
                    if (i != 0) {
                        layoutResource2 = ((Preference) this.yjn.get(this.yjp.get(i - 1))).getLayoutResource();
                        if (Ff(layoutResource2) || layoutResource2 == com.tencent.mm.w.a.h.dnW) {
                            iArr = this.yjs;
                            layoutResource = i - 1;
                            iArr[layoutResource] = iArr[layoutResource] | 2;
                        }
                    }
                } else if (i == 0) {
                    iArr = this.yjs;
                    iArr[i] = iArr[i] | 4;
                } else {
                    iArr = this.yjs;
                    iArr[i] = iArr[i] | 16;
                    layoutResource2 = ((Preference) this.yjn.get(this.yjp.get(i - 1))).getLayoutResource();
                    if (layoutResource2 == com.tencent.mm.w.a.h.dnt || layoutResource2 == com.tencent.mm.w.a.h.gXR || layoutResource2 == com.tencent.mm.w.a.h.gXT) {
                        iArr = this.yjs;
                        layoutResource = i - 1;
                        iArr[layoutResource] = iArr[layoutResource] | 2;
                    }
                }
                i++;
            }
            super.notifyDataSetChanged();
        }
    }

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.yjI) {
                checkBoxPreference.tSw = sharedPreferences.getBoolean(preference.ibD, ((CheckBoxPreference) preference).isChecked());
            }
        }
        if (preference instanceof DialogPreference) {
            DialogPreference dialogPreference = (DialogPreference) preference;
            if (dialogPreference.yjI) {
                dialogPreference.setValue(sharedPreferences.getString(preference.ibD, null));
            }
        }
        if (preference instanceof EditPreference) {
            EditPreference editPreference = (EditPreference) preference;
            if (editPreference.yjI) {
                editPreference.value = sharedPreferences.getString(preference.ibD, null);
                editPreference.setSummary(editPreference.value);
            }
        }
    }

    public int getCount() {
        return this.yjp.size();
    }

    public Object getItem(int i) {
        return this.yjn.get(this.yjp.get(i));
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        if (!this.yju) {
            this.yju = true;
        }
        return Math.max(1, this.yjq.size());
    }

    public int getItemViewType(int i) {
        if (i > this.yjp.size()) {
            return -1;
        }
        Integer num = (Integer) this.yjq.get(d((Preference) this.yjn.get(this.yjp.get(i))));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i <= this.yjp.size()) {
            Preference preference = (Preference) this.yjn.get(this.yjp.get(i));
            if (preference instanceof CheckBoxPreference) {
                preference.a(this.yia);
            }
            if (!this.yjq.containsKey(d(preference))) {
                view = null;
            }
            view = preference.getView(view, viewGroup);
            int i2 = this.yjs[i];
            View findViewById = view.findViewById(g.content);
            if (findViewById == null) {
                x.d("MicroMsg.MMPreferenceAdapter", "find content view error");
            } else {
                View findViewById2 = view.findViewById(16908312);
                if ((i2 & 4) == 0) {
                    int i3 = 0;
                    int paddingLeft = findViewById.getPaddingLeft();
                    int paddingRight = findViewById.getPaddingRight();
                    int paddingTop = findViewById.getPaddingTop();
                    int paddingBottom = findViewById.getPaddingBottom();
                    int i4 = f.gUX;
                    int paddingLeft2 = view.getPaddingLeft();
                    int paddingRight2 = view.getPaddingRight();
                    int paddingTop2 = view.getPaddingTop();
                    int paddingBottom2 = view.getPaddingBottom();
                    if ((i2 & 8) != 0) {
                        if (i == this.yjp.size() - 1 || (i == this.yjp.size() - 2 && (getItem(this.yjp.size() - 1) instanceof PreferenceCategory))) {
                            i4 = f.bDJ;
                        } else if ((i2 & 2) != 0) {
                            i4 = f.bDJ;
                        } else {
                            i4 = f.bDp;
                        }
                        i3 = i4;
                        i4 = d.white;
                    } else if ((i2 & 16) != 0 || (i2 & 2) == 0) {
                        i3 = f.bDp;
                    }
                    findViewById.setBackgroundResource(i3);
                    findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    if (findViewById2 != null) {
                        findViewById2.setBackgroundResource(i3);
                    }
                    view.setBackgroundResource(i4);
                    view.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                }
            }
        }
        return view;
    }
}
