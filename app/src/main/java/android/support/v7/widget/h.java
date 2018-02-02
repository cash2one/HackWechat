package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.e.f;
import android.support.v7.a.a.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class h {
    private static final Mode Pp = Mode.SRC_IN;
    private static h Pq;
    private static final b Pr = new b();
    private static final int[] Ps = new int[]{e.abc_textfield_search_default_mtrl_alpha, e.abc_textfield_default_mtrl_alpha, e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] Pt = new int[]{e.abc_ic_ab_back_mtrl_am_alpha, e.abc_ic_go_search_api_mtrl_alpha, e.abc_ic_search_api_mtrl_alpha, e.abc_ic_commit_search_api_mtrl_alpha, e.abc_ic_clear_mtrl_alpha, e.abc_ic_menu_share_mtrl_alpha, e.abc_ic_menu_copy_mtrl_am_alpha, e.abc_ic_menu_cut_mtrl_alpha, e.abc_ic_menu_selectall_mtrl_alpha, e.abc_ic_menu_paste_mtrl_am_alpha, e.abc_ic_menu_moreoverflow_mtrl_alpha, e.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] Pu = new int[]{e.abc_textfield_activated_mtrl_alpha, e.abc_textfield_search_activated_mtrl_alpha, e.abc_cab_background_top_mtrl_alpha, e.abc_text_cursor_material};
    private static final int[] Pv = new int[]{e.abc_popup_background_mtrl_mult, e.abc_cab_background_internal_bg, e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] Pw = new int[]{e.abc_edit_text_material, e.abc_tab_indicator_material, e.abc_textfield_search_material, e.abc_spinner_mtrl_am_alpha, e.abc_spinner_textfield_background_material, e.abc_ratingbar_full_material, e.abc_switch_track_mtrl_alpha, e.abc_switch_thumb_material, e.abc_btn_default_mtrl_shape, e.abc_btn_borderless_material};
    private static final int[] Px = new int[]{e.abc_btn_check_material, e.abc_btn_radio_material};
    private SparseArray<String> PA;
    private final Object PB = new Object();
    private final WeakHashMap<Context, android.support.v4.e.e<WeakReference<ConstantState>>> PC = new WeakHashMap(0);
    private TypedValue PD;
    private WeakHashMap<Context, SparseArray<ColorStateList>> Py;
    private android.support.v4.e.a<String, c> Pz;

    private interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    private static class a implements c {
        private a() {
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.a.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    private static class b extends f<Integer, PorterDuffColorFilter> {
        public b() {
            super(6);
        }

        static int b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    private static class d implements c {
        private d() {
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.a.a.f.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static h ey() {
        if (Pq == null) {
            h hVar = new h();
            Pq = hVar;
            int i = VERSION.SDK_INT;
            if (i < 23) {
                hVar.a("vector", new d());
                if (i >= 11) {
                    hVar.a("animated-vector", new a());
                }
            }
        }
        return Pq;
    }

    public final Drawable a(Context context, int i, boolean z) {
        Drawable e = e(context, i);
        if (e == null) {
            if (this.PD == null) {
                this.PD = new TypedValue();
            }
            TypedValue typedValue = this.PD;
            context.getResources().getValue(i, typedValue, true);
            long a = a(typedValue);
            e = a(context, a);
            if (e == null) {
                if (i == e.abc_cab_background_top_material) {
                    e = new LayerDrawable(new Drawable[]{a(context, e.abc_cab_background_internal_bg, false), a(context, e.abc_cab_background_top_mtrl_alpha, false)});
                }
                if (e != null) {
                    e.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a, e);
                }
            }
        }
        if (e == null) {
            e = android.support.v4.content.a.b(context, i);
        }
        if (e != null) {
            e = a(context, i, z, e);
        }
        if (e != null) {
            w.o(e);
        }
        return e;
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    final Drawable a(Context context, int i, boolean z, Drawable drawable) {
        Mode mode = null;
        ColorStateList f = f(context, i);
        if (f != null) {
            if (w.p(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.b.a.a.h(drawable);
            android.support.v4.b.a.a.a(drawable, f);
            if (i == e.abc_switch_thumb_material) {
                mode = Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawable;
            }
            android.support.v4.b.a.a.a(drawable, mode);
            return drawable;
        } else if (i == e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            a(r0.findDrawableByLayerId(16908288), al.i(context, android.support.v7.a.a.a.colorControlNormal), Pp);
            a(r0.findDrawableByLayerId(16908303), al.i(context, android.support.v7.a.a.a.colorControlNormal), Pp);
            a(r0.findDrawableByLayerId(16908301), al.i(context, android.support.v7.a.a.a.colorControlActivated), Pp);
            return drawable;
        } else if (i == e.abc_ratingbar_indicator_material || i == e.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            a(r0.findDrawableByLayerId(16908288), al.k(context, android.support.v7.a.a.a.colorControlNormal), Pp);
            a(r0.findDrawableByLayerId(16908303), al.i(context, android.support.v7.a.a.a.colorControlActivated), Pp);
            a(r0.findDrawableByLayerId(16908301), al.i(context, android.support.v7.a.a.a.colorControlActivated), Pp);
            return drawable;
        } else if (a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    final Drawable e(Context context, int i) {
        if (this.Pz == null || this.Pz.isEmpty()) {
            return null;
        }
        String str;
        if (this.PA != null) {
            str = (String) this.PA.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.Pz.get(str) == null)) {
                return null;
            }
        }
        this.PA = new SparseArray();
        if (this.PD == null) {
            this.PD = new TypedValue();
        }
        TypedValue typedValue = this.PD;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 != null) {
            return a2;
        }
        Drawable drawable;
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                int next;
                XmlPullParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                str = xml.getName();
                this.PA.append(i, str);
                c cVar = (c) this.Pz.get(str);
                if (cVar != null) {
                    a2 = cVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a2 != null) {
                    a2.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a, a2);
                }
                drawable = a2;
                if (drawable == null) {
                    return drawable;
                }
                this.PA.append(i, "appcompat_skip_skip");
                return drawable;
            } catch (Exception e) {
            }
        }
        drawable = a2;
        if (drawable == null) {
            return drawable;
        }
        this.PA.append(i, "appcompat_skip_skip");
        return drawable;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Drawable a(Context context, long j) {
        synchronized (this.PB) {
            android.support.v4.e.e eVar = (android.support.v4.e.e) this.PC.get(context);
            if (eVar == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) eVar.get(j);
            if (weakReference != null) {
                ConstantState constantState = (ConstantState) weakReference.get();
                if (constantState != null) {
                    Drawable newDrawable = constantState.newDrawable(context.getResources());
                    return newDrawable;
                }
                int a = android.support.v4.e.b.a(eVar.wi, eVar.hX, j);
                if (a >= 0 && eVar.wj[a] != android.support.v4.e.e.wg) {
                    eVar.wj[a] = android.support.v4.e.e.wg;
                    eVar.wh = true;
                }
            }
        }
    }

    private boolean a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.PB) {
            android.support.v4.e.e eVar = (android.support.v4.e.e) this.PC.get(context);
            if (eVar == null) {
                eVar = new android.support.v4.e.e();
                this.PC.put(context, eVar);
            }
            eVar.put(j, new WeakReference(constantState));
        }
        return true;
    }

    static boolean a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = Pp;
        if (a(Ps, i)) {
            i2 = android.support.v7.a.a.a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(Pu, i)) {
            i2 = android.support.v7.a.a.a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(Pv, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (w.p(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(al.i(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void a(String str, c cVar) {
        if (this.Pz == null) {
            this.Pz = new android.support.v4.e.a();
        }
        this.Pz.put(str, cVar);
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final ColorStateList f(Context context, int i) {
        ColorStateList colorStateList;
        if (this.Py != null) {
            SparseArray sparseArray = (SparseArray) this.Py.get(context);
            colorStateList = sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList colorStateList2;
        int[][] iArr;
        int[] iArr2;
        if (i == e.abc_edit_text_material) {
            iArr = new int[3][];
            iArr2 = new int[]{al.iT, al.k(context, android.support.v7.a.a.a.colorControlNormal), al.Zn};
            iArr2[1] = al.i(context, android.support.v7.a.a.a.colorControlNormal);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.i(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.abc_switch_track_mtrl_alpha) {
            iArr = new int[3][];
            iArr2 = new int[]{al.iT, al.a(context, 16842800, 0.1f), al.dX};
            iArr2[1] = al.a(context, android.support.v7.a.a.a.colorControlActivated, 0.3f);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.a(context, 16842800, 0.3f);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.abc_switch_thumb_material) {
            iArr = new int[3][];
            iArr2 = new int[3];
            colorStateList2 = al.j(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
            if (colorStateList2 == null || !colorStateList2.isStateful()) {
                iArr[0] = al.iT;
                iArr2[0] = al.k(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
                iArr[1] = al.dX;
                iArr2[1] = al.i(context, android.support.v7.a.a.a.colorControlActivated);
                iArr[2] = al.EMPTY_STATE_SET;
                iArr2[2] = al.i(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
            } else {
                iArr[0] = al.iT;
                iArr2[0] = colorStateList2.getColorForState(iArr[0], 0);
                iArr[1] = al.dX;
                iArr2[1] = al.i(context, android.support.v7.a.a.a.colorControlActivated);
                iArr[2] = al.EMPTY_STATE_SET;
                iArr2[2] = colorStateList2.getDefaultColor();
            }
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.abc_btn_default_mtrl_shape) {
            colorStateList2 = g(context, al.i(context, android.support.v7.a.a.a.colorButtonNormal));
        } else if (i == e.abc_btn_borderless_material) {
            colorStateList2 = g(context, 0);
        } else if (i == e.abc_btn_colored_material) {
            colorStateList2 = g(context, al.i(context, android.support.v7.a.a.a.colorAccent));
        } else if (i == e.abc_spinner_mtrl_am_alpha || i == e.abc_spinner_textfield_background_material) {
            iArr = new int[3][];
            iArr2 = new int[]{al.iT, al.k(context, android.support.v7.a.a.a.colorControlNormal), al.Zn};
            iArr2[1] = al.i(context, android.support.v7.a.a.a.colorControlNormal);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.i(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (a(Pt, i)) {
            colorStateList2 = al.j(context, android.support.v7.a.a.a.colorControlNormal);
        } else if (a(Pw, i)) {
            int i2 = al.i(context, android.support.v7.a.a.a.colorControlNormal);
            int i3 = al.i(context, android.support.v7.a.a.a.colorControlActivated);
            r2 = new int[7][];
            int[] iArr3 = new int[]{al.iT, al.k(context, android.support.v7.a.a.a.colorControlNormal), al.FOCUSED_STATE_SET, i3, al.Zm, i3, al.PRESSED_STATE_SET};
            iArr3[3] = i3;
            r2[4] = al.dX;
            iArr3[4] = i3;
            r2[5] = al.SELECTED_STATE_SET;
            iArr3[5] = i3;
            r2[6] = al.EMPTY_STATE_SET;
            iArr3[6] = i2;
            colorStateList2 = new ColorStateList(r2, iArr3);
        } else if (a(Px, i)) {
            iArr = new int[3][];
            iArr2 = new int[]{al.iT, al.k(context, android.support.v7.a.a.a.colorControlNormal), al.dX};
            iArr2[1] = al.i(context, android.support.v7.a.a.a.colorControlActivated);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.i(context, android.support.v7.a.a.a.colorControlNormal);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.abc_seekbar_thumb_material) {
            iArr = new int[2][];
            iArr2 = new int[]{al.iT, al.k(context, android.support.v7.a.a.a.colorControlActivated)};
            iArr[1] = al.EMPTY_STATE_SET;
            iArr2[1] = al.i(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else {
            colorStateList2 = colorStateList;
        }
        if (colorStateList2 != null) {
            if (this.Py == null) {
                this.Py = new WeakHashMap();
            }
            sparseArray = (SparseArray) this.Py.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.Py.put(context, sparseArray);
            }
            sparseArray.append(i, colorStateList2);
        }
        return colorStateList2;
    }

    private static ColorStateList g(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int i2 = al.i(context, android.support.v7.a.a.a.colorControlHighlight);
        r0[0] = al.iT;
        r1[0] = al.k(context, android.support.v7.a.a.a.colorButtonNormal);
        r0[1] = al.PRESSED_STATE_SET;
        r1[1] = android.support.v4.b.b.l(i2, i);
        r0[2] = al.FOCUSED_STATE_SET;
        r1[2] = android.support.v4.b.b.l(i2, i);
        r0[3] = al.EMPTY_STATE_SET;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    public static void a(Drawable drawable, an anVar, int[] iArr) {
        ColorFilter colorFilter = null;
        if (!w.p(drawable) || drawable.mutate() == drawable) {
            if (anVar.Zs || anVar.Zr) {
                ColorStateList colorStateList = anVar.Zs ? anVar.Zq : null;
                Mode mode = anVar.Zr ? anVar.np : Pp;
                if (!(colorStateList == null || mode == null)) {
                    colorFilter = a(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(colorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public static PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter) Pr.get(Integer.valueOf(b.b(i, mode)));
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        Pr.put(Integer.valueOf(b.b(i, mode)), porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (w.p(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = Pp;
        }
        drawable.setColorFilter(a(i, mode));
    }
}
