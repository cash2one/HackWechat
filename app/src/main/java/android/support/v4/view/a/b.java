package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class b {
    public static final e zW;
    public final Object zX;

    public static class a {
        public static final a Aa = new a(4);
        public static final a Ab = new a(8);
        public static final a Ac = new a(16);
        public static final a Ad = new a(32);
        public static final a Ae = new a(64);
        public static final a Af = new a((int) FileUtils.S_IWUSR);
        public static final a Ag = new a(256);
        public static final a Ah = new a((int) WXMediaMessage.TITLE_LENGTH_LIMIT);
        public static final a Ai = new a((int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        public static final a Aj = new a(2048);
        public static final a Ak = new a((int) Downloads.RECV_BUFFER_SIZE);
        public static final a Al = new a(8192);
        public static final a Am = new a(16384);
        public static final a An = new a((int) WXMediaMessage.THUMB_LENGTH_LIMIT);
        public static final a Ao = new a(65536);
        public static final a Ap = new a((int) WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        public static final a Aq = new a(262144);
        public static final a Ar = new a((int) SQLiteGlobal.journalSizeLimit);
        public static final a As = new a(1048576);
        public static final a At = new a(2097152);
        public static final a zY = new a(1);
        public static final a zZ = new a(2);
        private final Object Au;

        private a(int i) {
            this(b.zW.a(i, null));
        }

        private a(Object obj) {
            this.Au = obj;
        }
    }

    interface e {
        boolean A(Object obj);

        boolean B(Object obj);

        void C(Object obj);

        int D(Object obj);

        boolean E(Object obj);

        boolean F(Object obj);

        String G(Object obj);

        Object a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object a(int i, int i2, boolean z, int i3);

        Object a(int i, CharSequence charSequence);

        void a(Object obj, Rect rect);

        void a(Object obj, CharSequence charSequence);

        void a(Object obj, boolean z);

        void b(Object obj, int i);

        void b(Object obj, Rect rect);

        void b(Object obj, CharSequence charSequence);

        void b(Object obj, boolean z);

        void c(Object obj, int i);

        void c(Object obj, Rect rect);

        void c(Object obj, View view);

        void c(Object obj, CharSequence charSequence);

        void c(Object obj, boolean z);

        void d(Object obj, Rect rect);

        void d(Object obj, View view);

        void d(Object obj, CharSequence charSequence);

        void d(Object obj, boolean z);

        void e(Object obj, View view);

        void e(Object obj, CharSequence charSequence);

        void e(Object obj, boolean z);

        boolean e(Object obj, Object obj2);

        void f(Object obj, View view);

        void f(Object obj, Object obj2);

        void f(Object obj, boolean z);

        void g(Object obj, Object obj2);

        void g(Object obj, boolean z);

        void h(Object obj, boolean z);

        void i(Object obj, boolean z);

        void j(Object obj, boolean z);

        Object m(Object obj);

        int n(Object obj);

        CharSequence o(Object obj);

        CharSequence p(Object obj);

        CharSequence q(Object obj);

        CharSequence r(Object obj);

        boolean s(Object obj);

        boolean t(Object obj);

        boolean u(Object obj);

        boolean v(Object obj);

        boolean w(Object obj);

        boolean x(Object obj);

        boolean y(Object obj);

        boolean z(Object obj);
    }

    public static class k {
        public final Object zX;

        public k(Object obj) {
            this.zX = obj;
        }
    }

    public static class l {
        final Object zX;

        public static l a(int i, int i2, int i3, int i4, boolean z) {
            return new l(b.zW.a(i, i2, i3, i4, z, false));
        }

        private l(Object obj) {
            this.zX = obj;
        }
    }

    static class j implements e {
        j() {
        }

        public Object a(int i, CharSequence charSequence) {
            return null;
        }

        public Object m(Object obj) {
            return null;
        }

        public void b(Object obj, int i) {
        }

        public boolean e(Object obj, Object obj2) {
            return false;
        }

        public void c(Object obj, View view) {
        }

        public int n(Object obj) {
            return 0;
        }

        public void a(Object obj, Rect rect) {
        }

        public void b(Object obj, Rect rect) {
        }

        public CharSequence o(Object obj) {
            return null;
        }

        public CharSequence p(Object obj) {
            return null;
        }

        public CharSequence q(Object obj) {
            return null;
        }

        public CharSequence r(Object obj) {
            return null;
        }

        public boolean s(Object obj) {
            return false;
        }

        public boolean t(Object obj) {
            return false;
        }

        public boolean u(Object obj) {
            return false;
        }

        public boolean v(Object obj) {
            return false;
        }

        public boolean w(Object obj) {
            return false;
        }

        public boolean x(Object obj) {
            return false;
        }

        public boolean E(Object obj) {
            return false;
        }

        public boolean F(Object obj) {
            return false;
        }

        public boolean y(Object obj) {
            return false;
        }

        public boolean z(Object obj) {
            return false;
        }

        public boolean A(Object obj) {
            return false;
        }

        public boolean B(Object obj) {
            return false;
        }

        public void c(Object obj, int i) {
        }

        public int D(Object obj) {
            return 0;
        }

        public void c(Object obj, Rect rect) {
        }

        public void d(Object obj, Rect rect) {
        }

        public void b(Object obj, CharSequence charSequence) {
        }

        public void a(Object obj, boolean z) {
        }

        public void c(Object obj, CharSequence charSequence) {
        }

        public void b(Object obj, boolean z) {
        }

        public void c(Object obj, boolean z) {
        }

        public void d(Object obj, boolean z) {
        }

        public void h(Object obj, boolean z) {
        }

        public void i(Object obj, boolean z) {
        }

        public void e(Object obj, boolean z) {
        }

        public void d(Object obj, CharSequence charSequence) {
        }

        public void d(Object obj, View view) {
        }

        public void f(Object obj, boolean z) {
        }

        public void g(Object obj, boolean z) {
        }

        public void e(Object obj, View view) {
        }

        public void e(Object obj, CharSequence charSequence) {
        }

        public void C(Object obj) {
        }

        public String G(Object obj) {
            return null;
        }

        public void f(Object obj, Object obj2) {
        }

        public void g(Object obj, Object obj2) {
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public void j(Object obj, boolean z) {
        }

        public void a(Object obj, CharSequence charSequence) {
        }

        public void f(Object obj, View view) {
        }
    }

    static class d extends j {
        d() {
        }

        public final Object m(Object obj) {
            return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
        }

        public final void b(Object obj, int i) {
            ((AccessibilityNodeInfo) obj).addAction(i);
        }

        public final void c(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).addChild(view);
        }

        public final int n(Object obj) {
            return ((AccessibilityNodeInfo) obj).getActions();
        }

        public final void a(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
        }

        public final void b(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
        }

        public final CharSequence o(Object obj) {
            return ((AccessibilityNodeInfo) obj).getClassName();
        }

        public final CharSequence p(Object obj) {
            return ((AccessibilityNodeInfo) obj).getContentDescription();
        }

        public final CharSequence q(Object obj) {
            return ((AccessibilityNodeInfo) obj).getPackageName();
        }

        public final CharSequence r(Object obj) {
            return ((AccessibilityNodeInfo) obj).getText();
        }

        public final boolean s(Object obj) {
            return ((AccessibilityNodeInfo) obj).isCheckable();
        }

        public final boolean t(Object obj) {
            return ((AccessibilityNodeInfo) obj).isChecked();
        }

        public final boolean u(Object obj) {
            return ((AccessibilityNodeInfo) obj).isClickable();
        }

        public final boolean v(Object obj) {
            return ((AccessibilityNodeInfo) obj).isEnabled();
        }

        public final boolean w(Object obj) {
            return ((AccessibilityNodeInfo) obj).isFocusable();
        }

        public final boolean x(Object obj) {
            return ((AccessibilityNodeInfo) obj).isFocused();
        }

        public final boolean y(Object obj) {
            return ((AccessibilityNodeInfo) obj).isLongClickable();
        }

        public final boolean z(Object obj) {
            return ((AccessibilityNodeInfo) obj).isPassword();
        }

        public final boolean A(Object obj) {
            return ((AccessibilityNodeInfo) obj).isScrollable();
        }

        public final boolean B(Object obj) {
            return ((AccessibilityNodeInfo) obj).isSelected();
        }

        public final void c(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
        }

        public final void d(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
        }

        public final void b(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setClassName(charSequence);
        }

        public final void a(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setClickable(z);
        }

        public final void c(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
        }

        public final void b(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setEnabled(z);
        }

        public final void c(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setFocusable(z);
        }

        public final void d(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setFocused(z);
        }

        public final void e(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setLongClickable(z);
        }

        public final void d(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
        }

        public final void d(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setParent(view);
        }

        public final void f(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setScrollable(z);
        }

        public final void g(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setSelected(z);
        }

        public final void e(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setSource(view);
        }

        public final void e(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setText(charSequence);
        }

        public final void C(Object obj) {
            ((AccessibilityNodeInfo) obj).recycle();
        }
    }

    static class f extends d {
        f() {
        }

        public final boolean E(Object obj) {
            return ((AccessibilityNodeInfo) obj).isVisibleToUser();
        }

        public final void h(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
        }

        public final boolean F(Object obj) {
            return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
        }

        public final void i(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
        }

        public final void c(Object obj, int i) {
            ((AccessibilityNodeInfo) obj).setMovementGranularities(i);
        }

        public final int D(Object obj) {
            return ((AccessibilityNodeInfo) obj).getMovementGranularities();
        }
    }

    static class g extends f {
        g() {
        }

        public final void f(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setLabelFor(view);
        }
    }

    static class h extends g {
        h() {
        }

        public final String G(Object obj) {
            return ((AccessibilityNodeInfo) obj).getViewIdResourceName();
        }
    }

    static class i extends h {
        i() {
        }

        public final void f(Object obj, Object obj2) {
            ((AccessibilityNodeInfo) obj).setCollectionInfo((CollectionInfo) obj2);
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, false);
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        public final void g(Object obj, Object obj2) {
            ((AccessibilityNodeInfo) obj).setCollectionItemInfo((CollectionItemInfo) obj2);
        }

        public final void j(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setContentInvalid(true);
        }
    }

    static class b extends i {
        b() {
        }

        public final Object a(int i, CharSequence charSequence) {
            return new AccessibilityAction(i, null);
        }

        public final Object a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, false, 0);
        }

        public final boolean e(Object obj, Object obj2) {
            return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityAction) obj2);
        }

        public final Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z, false);
        }

        public final void a(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setError(charSequence);
        }
    }

    static class c extends b {
        c() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 22) {
            zW = new c();
        } else if (VERSION.SDK_INT >= 21) {
            zW = new b();
        } else if (VERSION.SDK_INT >= 19) {
            zW = new i();
        } else if (VERSION.SDK_INT >= 18) {
            zW = new h();
        } else if (VERSION.SDK_INT >= 17) {
            zW = new g();
        } else if (VERSION.SDK_INT >= 16) {
            zW = new f();
        } else if (VERSION.SDK_INT >= 14) {
            zW = new d();
        } else {
            zW = new j();
        }
    }

    public b(Object obj) {
        this.zX = obj;
    }

    public static b a(b bVar) {
        Object m = zW.m(bVar.zX);
        return m != null ? new b(m) : null;
    }

    public final void setSource(View view) {
        zW.e(this.zX, view);
    }

    public final void addChild(View view) {
        zW.c(this.zX, view);
    }

    public final int getActions() {
        return zW.n(this.zX);
    }

    public final void addAction(int i) {
        zW.b(this.zX, i);
    }

    public final boolean a(a aVar) {
        return zW.e(this.zX, aVar.Au);
    }

    public final void setParent(View view) {
        zW.d(this.zX, view);
    }

    public final void getBoundsInParent(Rect rect) {
        zW.a(this.zX, rect);
    }

    public final void setBoundsInParent(Rect rect) {
        zW.c(this.zX, rect);
    }

    public final void getBoundsInScreen(Rect rect) {
        zW.b(this.zX, rect);
    }

    public final void setBoundsInScreen(Rect rect) {
        zW.d(this.zX, rect);
    }

    public final boolean isFocusable() {
        return zW.w(this.zX);
    }

    public final void setFocusable(boolean z) {
        zW.c(this.zX, z);
    }

    public final boolean isFocused() {
        return zW.x(this.zX);
    }

    public final void setFocused(boolean z) {
        zW.d(this.zX, z);
    }

    public final boolean isVisibleToUser() {
        return zW.E(this.zX);
    }

    public final void setVisibleToUser(boolean z) {
        zW.h(this.zX, z);
    }

    public final boolean isAccessibilityFocused() {
        return zW.F(this.zX);
    }

    public final void setAccessibilityFocused(boolean z) {
        zW.i(this.zX, z);
    }

    public final boolean isSelected() {
        return zW.B(this.zX);
    }

    public final void setSelected(boolean z) {
        zW.g(this.zX, z);
    }

    public final boolean isClickable() {
        return zW.u(this.zX);
    }

    public final void setClickable(boolean z) {
        zW.a(this.zX, z);
    }

    public final boolean isLongClickable() {
        return zW.y(this.zX);
    }

    public final void setLongClickable(boolean z) {
        zW.e(this.zX, z);
    }

    public final boolean isEnabled() {
        return zW.v(this.zX);
    }

    public final void setEnabled(boolean z) {
        zW.b(this.zX, z);
    }

    public final void setScrollable(boolean z) {
        zW.f(this.zX, z);
    }

    public final CharSequence getPackageName() {
        return zW.q(this.zX);
    }

    public final void setPackageName(CharSequence charSequence) {
        zW.d(this.zX, charSequence);
    }

    public final CharSequence getClassName() {
        return zW.o(this.zX);
    }

    public final void setClassName(CharSequence charSequence) {
        zW.b(this.zX, charSequence);
    }

    public final void setText(CharSequence charSequence) {
        zW.e(this.zX, charSequence);
    }

    public final CharSequence getContentDescription() {
        return zW.p(this.zX);
    }

    public final void setContentDescription(CharSequence charSequence) {
        zW.c(this.zX, charSequence);
    }

    public final void recycle() {
        zW.C(this.zX);
    }

    public final void l(Object obj) {
        zW.g(this.zX, ((l) obj).zX);
    }

    public final int hashCode() {
        return this.zX == null ? 0 : this.zX.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.zX == null) {
            if (bVar.zX != null) {
                return false;
            }
            return true;
        } else if (this.zX.equals(bVar.zX)) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(getPackageName());
        stringBuilder.append("; className: ").append(getClassName());
        stringBuilder.append("; text: ").append(zW.r(this.zX));
        stringBuilder.append("; contentDescription: ").append(getContentDescription());
        stringBuilder.append("; viewId: ").append(zW.G(this.zX));
        stringBuilder.append("; checkable: ").append(zW.s(this.zX));
        stringBuilder.append("; checked: ").append(zW.t(this.zX));
        stringBuilder.append("; focusable: ").append(isFocusable());
        stringBuilder.append("; focused: ").append(isFocused());
        stringBuilder.append("; selected: ").append(isSelected());
        stringBuilder.append("; clickable: ").append(isClickable());
        stringBuilder.append("; longClickable: ").append(isLongClickable());
        stringBuilder.append("; enabled: ").append(isEnabled());
        stringBuilder.append("; password: ").append(zW.z(this.zX));
        stringBuilder.append("; scrollable: " + zW.A(this.zX));
        stringBuilder.append("; [");
        int actions = getActions();
        while (actions != 0) {
            String str;
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            int i = (numberOfTrailingZeros ^ -1) & actions;
            switch (numberOfTrailingZeros) {
                case 1:
                    str = "ACTION_FOCUS";
                    break;
                case 2:
                    str = "ACTION_CLEAR_FOCUS";
                    break;
                case 4:
                    str = "ACTION_SELECT";
                    break;
                case 8:
                    str = "ACTION_CLEAR_SELECTION";
                    break;
                case 16:
                    str = "ACTION_CLICK";
                    break;
                case 32:
                    str = "ACTION_LONG_CLICK";
                    break;
                case 64:
                    str = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                case FileUtils.S_IWUSR /*128*/:
                    str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                case 256:
                    str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                    str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                    str = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                case 2048:
                    str = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    str = "ACTION_SCROLL_FORWARD";
                    break;
                case 8192:
                    str = "ACTION_SCROLL_BACKWARD";
                    break;
                case 16384:
                    str = "ACTION_COPY";
                    break;
                case WXMediaMessage.THUMB_LENGTH_LIMIT /*32768*/:
                    str = "ACTION_PASTE";
                    break;
                case 65536:
                    str = "ACTION_CUT";
                    break;
                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                    str = "ACTION_SET_SELECTION";
                    break;
                default:
                    str = "ACTION_UNKNOWN";
                    break;
            }
            stringBuilder.append(str);
            if (i != 0) {
                stringBuilder.append(", ");
            }
            actions = i;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
