package com.tencent.mm.bw;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Picture;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class a extends Resources {
    private static Method xbv = null;
    private static Method xbw = null;
    private Resources mResources;
    private e xbs;
    private c xbt;
    private boolean xbu;

    public static class a<E> extends ArrayList<E> {
        public final boolean add(E e) {
            x.i("InterceptArrayList", "InterceptArrayList.add");
            return true;
        }

        public final void add(int i, E e) {
            x.i("InterceptArrayList", "InterceptArrayList.add index object");
        }
    }

    private a(Resources resources, e eVar, c cVar) {
        c cVar2;
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.xbs = eVar;
        this.mResources = resources;
        this.xbt = cVar;
        try {
            Field declaredField;
            Class cls = Class.forName("android.content.res.MiuiResources");
            if (cls != null) {
                x.i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
                declaredField = cls.getDeclaredField("sMiuiThemeEnabled");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.set(null, Boolean.valueOf(false));
                    cVar2 = new c(getAssets(), "mThemeCookies", null);
                    if (cVar2.yW()) {
                        cVar2.set(new a());
                    }
                    this.xbu = ac.cft().getBoolean("ShowStringName", false);
                }
            }
            declaredField = null;
            x.e("MicroMsg.MMResources", "some thing wrong. %s %s", cls, declaredField);
        } catch (ClassNotFoundException e) {
            x.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
        } catch (NoSuchFieldException e2) {
            x.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
        } catch (IllegalAccessException e3) {
            x.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
        } catch (IllegalArgumentException e4) {
            x.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
        }
        cVar2 = new c(getAssets(), "mThemeCookies", null);
        try {
            if (cVar2.yW()) {
                cVar2.set(new a());
            }
        } catch (Throwable e5) {
            x.printErrStackTrace("MicroMsg.MMResources", e5, "", new Object[0]);
        } catch (Throwable e52) {
            x.printErrStackTrace("MicroMsg.MMResources", e52, "", new Object[0]);
        } catch (Throwable e522) {
            x.printErrStackTrace("MicroMsg.MMResources", e522, "", new Object[0]);
        }
        try {
            this.xbu = ac.cft().getBoolean("ShowStringName", false);
        } catch (Exception e6) {
            x.e("MicroMsg.MMResources", e6.getMessage());
        }
    }

    public final void cdY() {
        updateConfiguration(this.mResources.getConfiguration(), this.mResources.getDisplayMetrics());
    }

    public static Resources a(Resources resources, Context context) {
        return new a(resources, e.eC(context), new c());
    }

    public static Resources a(Resources resources, Context context, String str) {
        return new a(resources, e.bg(context, str), new c());
    }

    private boolean cdZ() {
        return this.xbs != null && e.cdZ();
    }

    public final CharSequence getText(int i) {
        if (this.xbu) {
            return this.mResources.getResourceEntryName(i);
        }
        CharSequence e;
        if (cdZ()) {
            e = e.e(i, e.getString(i));
            if (e != null) {
                return e;
            }
        }
        e = e.e(i, this.mResources.getString(i));
        if (e != null) {
            return e.toString();
        }
        return this.mResources.getString(i);
    }

    public final CharSequence getText(int i, CharSequence charSequence) {
        if (this.xbu) {
            return this.mResources.getResourceEntryName(i);
        }
        CharSequence e;
        if (cdZ()) {
            e = e.e(i, e.getString(i));
            if (e != null) {
                return e;
            }
        }
        e = e.e(i, this.mResources.getString(i));
        if (e != null) {
            return e.toString();
        }
        return this.mResources.getString(i);
    }

    public final String getString(int i) {
        if (this.xbu) {
            return this.mResources.getResourceEntryName(i);
        }
        CharSequence string;
        if (cdZ()) {
            string = e.getString(i);
            if (string != null) {
                return e.e(i, string.toString()).toString();
            }
        }
        try {
            string = e.e(i, this.mResources.getString(i));
            if (string != null) {
                return string.toString();
            }
            return this.mResources.getString(i);
        } catch (Exception e) {
            return "";
        }
    }

    public final String getQuantityString(int i, int i2) {
        if (this.xbu) {
            return this.mResources.getResourceEntryName(i);
        }
        if (cdZ()) {
            CharSequence quantityString = e.getQuantityString(i, i2);
            if (quantityString != null) {
                return quantityString.toString();
            }
        }
        return this.mResources.getQuantityString(i, i2);
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        if (this.xbu) {
            return this.mResources.getResourceEntryName(i);
        }
        if (cdZ()) {
            CharSequence quantityString = e.getQuantityString(i, i2, objArr);
            if (quantityString != null) {
                return quantityString.toString();
            }
        }
        return this.mResources.getQuantityString(i, i2, objArr);
    }

    public final CharSequence getQuantityText(int i, int i2) {
        if (this.xbu) {
            return this.mResources.getResourceEntryName(i);
        }
        if (cdZ()) {
            CharSequence quantityString = e.getQuantityString(i, i2);
            if (quantityString != null) {
                return quantityString.toString();
            }
        }
        return this.mResources.getQuantityString(i, i2);
    }

    public final String[] getStringArray(int i) {
        if (cdZ()) {
            String[] stringArray = e.getStringArray(i);
            if (stringArray != null) {
                return stringArray;
            }
        }
        return super.getStringArray(i);
    }

    public final CharSequence[] getTextArray(int i) {
        CharSequence[] stringArray = getStringArray(i);
        return stringArray != null ? stringArray : super.getTextArray(i);
    }

    public final TypedArray obtainTypedArray(int i) {
        return this.mResources.obtainTypedArray(i);
    }

    public final Drawable getDrawable(int i) {
        if (i != 0) {
            Drawable c = this.xbt.c(this.mResources, i);
            if (c != null) {
                return c;
            }
        }
        return d(super.getDrawable(i), i);
    }

    @TargetApi(21)
    public final Drawable getDrawable(int i, Theme theme) {
        if (i != 0) {
            Drawable c = this.xbt.c(this.mResources, i);
            if (c != null) {
                return c;
            }
        }
        return d(super.getDrawable(i, theme), i);
    }

    public final Drawable getDrawableForDensity(int i, int i2) {
        if (i != 0) {
            Drawable c = this.xbt.c(this.mResources, i);
            if (c != null) {
                return c;
            }
        }
        return d(super.getDrawableForDensity(i, i2), i);
    }

    @TargetApi(22)
    public final Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        if (i != 0) {
            Drawable c = this.xbt.c(this.mResources, i);
            if (c != null) {
                return c;
            }
        }
        return d(super.getDrawableForDensity(i, i2, theme), i);
    }

    private Drawable d(Drawable drawable, int i) {
        if (drawable != null) {
            return drawable;
        }
        x.k("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
        try {
            if (this.xbt.xbB.d(this, i)) {
                x.e("MicroMsg.MMResources", "resources name = %s, this resource %s", getResourceName(i), this);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMResources", e, "WTF", new Object[0]);
        }
        return new com.tencent.mm.svg.a.c(new Picture(), 0);
    }

    public static Drawable b(Resources resources, int i) {
        Drawable colorDrawable;
        NotFoundException notFoundException;
        boolean z = true;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        }
        if (z) {
            colorDrawable = new ColorDrawable(typedValue.data);
        } else {
            colorDrawable = null;
        }
        if (xbv == null) {
            try {
                Method declaredMethod = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[]{String.class, Integer.TYPE, Integer.TYPE, String.class});
                xbv = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMResources", e, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.MMResources", e, "", new Object[0]);
                return null;
            }
        }
        if (xbw == null) {
            try {
                declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[]{Integer.TYPE, String.class, Integer.TYPE});
                xbw = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
                return null;
            }
        }
        if (colorDrawable == null) {
            if (typedValue.string == null) {
                throw new NotFoundException("Resource is not a Drawable (color or path): " + typedValue);
            }
            String charSequence = typedValue.string.toString();
            Drawable createFromXml;
            if (charSequence.endsWith(".xml")) {
                try {
                    XmlResourceParser xmlResourceParser = (XmlResourceParser) xbv.invoke(resources, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(typedValue.assetCookie), "drawable"});
                    createFromXml = Drawable.createFromXml(resources, xmlResourceParser);
                    xmlResourceParser.close();
                    colorDrawable = createFromXml;
                } catch (Throwable e22) {
                    notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e22);
                    throw notFoundException;
                }
            }
            try {
                InputStream inputStream = (InputStream) xbw.invoke(resources.getAssets(), new Object[]{Integer.valueOf(typedValue.assetCookie), charSequence, Integer.valueOf(2)});
                createFromXml = Drawable.createFromResourceStream(resources, typedValue, inputStream, charSequence, null);
                inputStream.close();
                colorDrawable = createFromXml;
            } catch (Throwable e222) {
                notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e222);
                throw notFoundException;
            }
        }
        return colorDrawable;
    }
}
