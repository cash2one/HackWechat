package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class g extends MenuInflater {
    private static final Class<?>[] JB;
    private static final Class<?>[] JC;
    private final Object[] JD;
    private final Object[] JE = this.JD;
    private Object JF;
    private Context mContext;

    private static class a implements OnMenuItemClickListener {
        private static final Class<?>[] JG = new Class[]{MenuItem.class};
        private Object JF;
        private Method mMethod;

        public a(Object obj, String str) {
            this.JF = obj;
            Class cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, JG);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.JF, new Object[]{menuItem})).booleanValue();
                }
                this.mMethod.invoke(this.JF, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        Menu JH;
        int JI;
        int JJ;
        int JK;
        int JL;
        boolean JM;
        boolean JN;
        boolean JO;
        int JP;
        int JQ;
        CharSequence JR;
        CharSequence JS;
        int JT;
        char JU;
        char JV;
        int JW;
        boolean JX;
        boolean JY;
        boolean JZ;
        int Ka;
        int Kb;
        String Kc;
        String Kd;
        String Ke;
        d Kf;
        final /* synthetic */ g Kg;

        public b(g gVar, Menu menu) {
            this.Kg = gVar;
            this.JH = menu;
            dj();
        }

        public final void dj() {
            this.JI = 0;
            this.JJ = 0;
            this.JK = 0;
            this.JL = 0;
            this.JM = true;
            this.JN = true;
        }

        static char u(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        final void e(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.JX).setVisible(this.JY).setEnabled(this.JZ).setCheckable(this.JW > 0).setTitleCondensed(this.JS).setIcon(this.JT).setAlphabeticShortcut(this.JU).setNumericShortcut(this.JV);
            if (this.Ka >= 0) {
                m.a(menuItem, this.Ka);
            }
            if (this.Ke != null) {
                if (this.Kg.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.b(this.Kg), this.Ke));
            }
            if (this.JW >= 2) {
                if (menuItem instanceof h) {
                    ((h) menuItem).D(true);
                } else if (menuItem instanceof i) {
                    i iVar = (i) menuItem;
                    try {
                        if (iVar.LQ == null) {
                            iVar.LQ = ((android.support.v4.c.a.b) iVar.KO).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        iVar.LQ.invoke(iVar.KO, new Object[]{Boolean.valueOf(true)});
                    } catch (Exception e) {
                    }
                }
            }
            if (this.Kc != null) {
                m.a(menuItem, (View) newInstance(this.Kc, g.JB, this.Kg.JD));
            } else {
                z = false;
            }
            if (this.Kb > 0 && !r2) {
                m.b(menuItem, this.Kb);
            }
            if (this.Kf != null) {
                m.a(menuItem, this.Kf);
            }
        }

        public final SubMenu dk() {
            this.JO = true;
            SubMenu addSubMenu = this.JH.addSubMenu(this.JI, this.JP, this.JQ, this.JR);
            e(addSubMenu.getItem());
            return addSubMenu;
        }

        final <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.Kg.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static /* synthetic */ Object b(g gVar) {
        if (gVar.JF == null) {
            Object obj = gVar.mContext;
            while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                obj = ((ContextWrapper) obj).getBaseContext();
            }
            gVar.JF = obj;
        }
        return gVar.JF;
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        JB = clsArr;
        JC = clsArr;
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.JD = new Object[]{context};
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof android.support.v4.c.a.a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(this, menu);
        int eventType = xmlPullParser.getEventType();
        Object obj = null;
        Object obj2 = null;
        while (eventType != 2) {
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                break;
            }
        }
        String name = xmlPullParser.getName();
        if (name.equals("menu")) {
            eventType = xmlPullParser.next();
            Object obj3 = null;
            while (obj3 == null) {
                Object obj4;
                Object obj5;
                switch (eventType) {
                    case 1:
                        throw new RuntimeException("Unexpected end of document");
                    case 2:
                        if (obj == null) {
                            name = xmlPullParser.getName();
                            if (!name.equals("group")) {
                                if (!name.equals("item")) {
                                    if (!name.equals("menu")) {
                                        obj2 = 1;
                                        obj4 = obj3;
                                        String str = name;
                                        obj5 = obj4;
                                        break;
                                    }
                                    a(xmlPullParser, attributeSet, bVar.dk());
                                    obj5 = obj3;
                                    obj3 = obj2;
                                    obj2 = obj;
                                    break;
                                }
                                TypedArray obtainStyledAttributes = bVar.Kg.mContext.obtainStyledAttributes(attributeSet, k.MenuItem);
                                bVar.JP = obtainStyledAttributes.getResourceId(k.MenuItem_android_id, 0);
                                bVar.JQ = (obtainStyledAttributes.getInt(k.MenuItem_android_menuCategory, bVar.JJ) & -65536) | (obtainStyledAttributes.getInt(k.MenuItem_android_orderInCategory, bVar.JK) & 65535);
                                bVar.JR = obtainStyledAttributes.getText(k.MenuItem_android_title);
                                bVar.JS = obtainStyledAttributes.getText(k.MenuItem_android_titleCondensed);
                                bVar.JT = obtainStyledAttributes.getResourceId(k.MenuItem_android_icon, 0);
                                bVar.JU = b.u(obtainStyledAttributes.getString(k.MenuItem_android_alphabeticShortcut));
                                bVar.JV = b.u(obtainStyledAttributes.getString(k.MenuItem_android_numericShortcut));
                                if (obtainStyledAttributes.hasValue(k.MenuItem_android_checkable)) {
                                    bVar.JW = obtainStyledAttributes.getBoolean(k.MenuItem_android_checkable, false) ? 1 : 0;
                                } else {
                                    bVar.JW = bVar.JL;
                                }
                                bVar.JX = obtainStyledAttributes.getBoolean(k.MenuItem_android_checked, false);
                                bVar.JY = obtainStyledAttributes.getBoolean(k.MenuItem_android_visible, bVar.JM);
                                bVar.JZ = obtainStyledAttributes.getBoolean(k.MenuItem_android_enabled, bVar.JN);
                                bVar.Ka = obtainStyledAttributes.getInt(k.MenuItem_showAsAction, -1);
                                bVar.Ke = obtainStyledAttributes.getString(k.MenuItem_android_onClick);
                                bVar.Kb = obtainStyledAttributes.getResourceId(k.MenuItem_actionLayout, 0);
                                bVar.Kc = obtainStyledAttributes.getString(k.MenuItem_actionViewClass);
                                bVar.Kd = obtainStyledAttributes.getString(k.MenuItem_actionProviderClass);
                                if ((bVar.Kd != null ? 1 : null) != null && bVar.Kb == 0 && bVar.Kc == null) {
                                    bVar.Kf = (d) bVar.newInstance(bVar.Kd, JC, bVar.Kg.JE);
                                } else {
                                    bVar.Kf = null;
                                }
                                obtainStyledAttributes.recycle();
                                bVar.JO = false;
                                obj5 = obj3;
                                obj3 = obj2;
                                obj2 = obj;
                                break;
                            }
                            TypedArray obtainStyledAttributes2 = bVar.Kg.mContext.obtainStyledAttributes(attributeSet, k.MenuGroup);
                            bVar.JI = obtainStyledAttributes2.getResourceId(k.MenuGroup_android_id, 0);
                            bVar.JJ = obtainStyledAttributes2.getInt(k.MenuGroup_android_menuCategory, 0);
                            bVar.JK = obtainStyledAttributes2.getInt(k.MenuGroup_android_orderInCategory, 0);
                            bVar.JL = obtainStyledAttributes2.getInt(k.MenuGroup_android_checkableBehavior, 0);
                            bVar.JM = obtainStyledAttributes2.getBoolean(k.MenuGroup_android_visible, true);
                            bVar.JN = obtainStyledAttributes2.getBoolean(k.MenuGroup_android_enabled, true);
                            obtainStyledAttributes2.recycle();
                            obj5 = obj3;
                            obj3 = obj2;
                            obj2 = obj;
                            break;
                        }
                        break;
                    case 3:
                        name = xmlPullParser.getName();
                        if (obj == null || !name.equals(obj2)) {
                            if (!name.equals("group")) {
                                if (!name.equals("item")) {
                                    if (name.equals("menu")) {
                                        obj5 = 1;
                                        obj3 = obj2;
                                        obj2 = obj;
                                        break;
                                    }
                                } else if (!bVar.JO) {
                                    if (bVar.Kf != null && bVar.Kf.hasSubMenu()) {
                                        bVar.dk();
                                        obj5 = obj3;
                                        obj3 = obj2;
                                        obj2 = obj;
                                        break;
                                    }
                                    bVar.JO = true;
                                    bVar.e(bVar.JH.add(bVar.JI, bVar.JP, bVar.JQ, bVar.JR));
                                    obj5 = obj3;
                                    obj3 = obj2;
                                    obj2 = obj;
                                    break;
                                }
                            }
                            bVar.dj();
                            obj5 = obj3;
                            obj3 = obj2;
                            obj2 = obj;
                            break;
                        }
                        obj2 = null;
                        obj4 = obj3;
                        obj3 = null;
                        obj5 = obj4;
                        break;
                        break;
                    default:
                        obj5 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        break;
                }
                obj4 = obj5;
                eventType = xmlPullParser.next();
                obj = obj2;
                obj2 = obj3;
                obj3 = obj4;
            }
            return;
        }
        throw new RuntimeException("Expecting menu, got " + name);
    }
}
