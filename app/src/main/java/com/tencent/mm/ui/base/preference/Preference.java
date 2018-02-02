package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.v;
import com.tencent.mm.w.a.c;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;
import java.util.List;

public class Preference implements Comparable<Preference> {
    private boolean AW;
    public int Kw;
    public String ibD;
    public Drawable jY;
    public int kXT;
    public final Context mContext;
    private Bundle mExtras;
    private CharSequence pkW;
    private CharSequence uU;
    private int[] yd;
    private a yjB;
    private int yjC;
    private int yjD;
    private int yjE;
    private String yjF;
    boolean yjG;
    private boolean yjH;
    public boolean yjI;
    String yjJ;
    private Object yjK;
    private boolean yjL;
    private boolean yjM;
    private int yjN;
    int yjO;
    private boolean yjP;
    private List<Preference> yjQ;

    public interface a {
        boolean a(Preference preference, Object obj);
    }

    public /* synthetic */ int compareTo(Object obj) {
        int i = 0;
        Preference preference = (Preference) obj;
        if (this.yjC != Integer.MAX_VALUE || (this.yjC == Integer.MAX_VALUE && preference.yjC != Integer.MAX_VALUE)) {
            return this.yjC - preference.yjC;
        }
        if (this.uU == null) {
            return 1;
        }
        if (preference.uU == null) {
            return -1;
        }
        CharSequence charSequence = this.uU;
        CharSequence charSequence2 = preference.uU;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = length < length2 ? length : length2;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            char toLowerCase = Character.toLowerCase(charSequence.charAt(i3));
            i3 = i + 1;
            i = toLowerCase - Character.toLowerCase(charSequence2.charAt(i));
            if (i != 0) {
                return i;
            }
            i = i3;
            i3 = i4;
        }
        return length - length2;
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.yd = new int[]{c.title, c.summary};
        this.yjC = Integer.MAX_VALUE;
        this.AW = true;
        this.yjG = true;
        this.yjI = true;
        this.yjL = true;
        this.kXT = -1;
        this.yjM = true;
        this.yjN = h.dnt;
        this.yjP = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faP, i, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == m.gZu) {
                this.Kw = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == m.gZv) {
                this.ibD = obtainStyledAttributes.getString(index);
            } else if (index == m.gZt) {
                this.yjD = obtainStyledAttributes.getResourceId(index, 0);
                this.uU = obtainStyledAttributes.getString(index);
                if (this.yjD != 0) {
                    this.uU = context.getString(this.yjD);
                }
            } else if (index == m.gZs) {
                this.pkW = obtainStyledAttributes.getString(index);
                this.yjE = obtainStyledAttributes.getResourceId(index, 0);
                if (this.yjE != 0) {
                    this.pkW = context.getString(this.yjE);
                }
            } else if (index == m.gZw) {
                this.yjC = obtainStyledAttributes.getInt(index, this.yjC);
            } else if (index == m.gZq) {
                this.yjF = obtainStyledAttributes.getString(index);
            } else if (index == m.gZC) {
                this.yjN = obtainStyledAttributes.getResourceId(index, this.yjN);
            } else if (index == m.gZx) {
                this.yjO = obtainStyledAttributes.getResourceId(index, this.yjO);
            } else if (index == m.gZp) {
                this.AW = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == m.gZy) {
                this.yjG = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == m.gZr) {
                this.yjI = obtainStyledAttributes.getBoolean(index, this.yjI);
            } else if (index == m.gZz) {
                this.yjJ = obtainStyledAttributes.getString(index);
            } else if (index == m.gZA) {
                this.yjK = null;
            } else if (index == m.gZB) {
                this.yjM = obtainStyledAttributes.getBoolean(index, this.yjM);
            }
        }
        obtainStyledAttributes.recycle();
        if (!getClass().getName().startsWith("android.preference")) {
            this.yjP = true;
        }
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842894);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public final Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    public final void setLayoutResource(int i) {
        if (i != this.yjN) {
            this.yjP = true;
        }
        this.yjN = i;
    }

    public int getLayoutResource() {
        return this.yjN;
    }

    public final void setWidgetLayoutResource(int i) {
        if (i != this.yjO) {
            this.yjP = true;
        }
        this.yjO = i;
    }

    public View getView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        return view;
    }

    public View onCreateView(ViewGroup viewGroup) {
        LayoutInflater fv = v.fv(this.mContext);
        View inflate = fv.inflate(this.yjN, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.yjO != 0) {
                fv.inflate(this.yjO, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return inflate;
    }

    public void onBindView(View view) {
        int i = 0;
        View findViewById = view.findViewById(g.content);
        if (findViewById != null) {
            findViewById.setMinimumHeight((int) (((float) view.getResources().getDimensionPixelSize(e.bvR)) * com.tencent.mm.bv.a.ex(this.mContext)));
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
        }
        textView = (TextView) view.findViewById(16908304);
        if (textView != null) {
            if (!TextUtils.isEmpty(getSummary())) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(getSummary());
                if (this.kXT != -1) {
                    textView.setTextColor(this.kXT);
                }
            } else if (textView.getVisibility() != 8) {
                textView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (imageView != null) {
            if (!(this.Kw == 0 && this.jY == null)) {
                if (this.jY == null) {
                    this.jY = this.mContext.getResources().getDrawable(this.Kw);
                }
                if (this.jY != null) {
                    imageView.setImageDrawable(this.jY);
                }
            }
            if (this.jY == null) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        if (this.yjM) {
            m(view, isEnabled());
        }
    }

    private void m(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.uU != null) || (charSequence != null && !charSequence.equals(this.uU))) {
            this.yjD = 0;
            this.uU = charSequence;
            notifyChanged();
        }
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
        this.yjD = i;
    }

    public CharSequence getTitle() {
        return this.uU;
    }

    public CharSequence getSummary() {
        return this.pkW;
    }

    public void setSummary(CharSequence charSequence) {
        if ((charSequence == null && this.pkW != null) || (charSequence != null && !charSequence.equals(this.pkW))) {
            this.pkW = charSequence;
            notifyChanged();
        }
    }

    public void setSummary(int i) {
        setSummary(this.mContext.getString(i));
    }

    public final void setEnabled(boolean z) {
        if (this.AW != z) {
            this.AW = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public final boolean isEnabled() {
        return this.AW && this.yjL;
    }

    public final void setSelectable(boolean z) {
        if (this.yjG != z) {
            this.yjG = z;
            notifyChanged();
        }
    }

    public final void setKey(String str) {
        this.ibD = str;
        if (this.yjH) {
            if (!(!TextUtils.isEmpty(this.ibD))) {
                if (this.ibD == null) {
                    throw new IllegalStateException("Preference does not have a key assigned.");
                }
                this.yjH = true;
            }
        }
    }

    public final boolean callChangeListener(Object obj) {
        return this.yjB == null ? true : this.yjB.a(this, obj);
    }

    public void a(a aVar) {
        this.yjB = aVar;
    }

    public void notifyChanged() {
    }

    private void notifyDependencyChange(boolean z) {
        List list = this.yjQ;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Preference preference = (Preference) list.get(i);
                if (preference.yjL == z) {
                    boolean z2;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    preference.yjL = z2;
                    preference.notifyDependencyChange(preference.shouldDisableDependents());
                    preference.notifyChanged();
                }
            }
        }
    }

    private boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        title = getSummary();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
