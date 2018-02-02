package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public final class j {
    private static HashMap<String, Constructor<?>> yjy = new HashMap();
    private static final Class<?>[] yjz = new Class[]{Context.class, AttributeSet.class};
    final Object[] HO = new Object[2];
    final Context mContext;

    public j(Context context) {
        this.mContext = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Preference a(String str, String str2, AttributeSet attributeSet) {
        Constructor constructor;
        Constructor constructor2 = (Constructor) yjy.get(str);
        if (constructor2 == null) {
            try {
                constructor = this.mContext.getClassLoader().loadClass(str2 != null ? str2 + str : str).getConstructor(yjz);
                yjy.put(str, constructor);
            } catch (Throwable e) {
                StringBuilder append = new StringBuilder().append(attributeSet.getPositionDescription()).append(": Error inflating class ");
                if (str2 != null) {
                    str = str2 + str;
                }
                InflateException inflateException = new InflateException(append.append(str).toString());
                inflateException.initCause(e);
                throw inflateException;
            } catch (ClassNotFoundException e2) {
                throw e2;
            } catch (Exception e3) {
                Throwable e4 = e3;
                String name = attributeSet == null ? new StringBuilder("(null): Error inflating class ").append(r0).toString() == null ? "(null)" : r0.getClass().getName() : attributeSet.getPositionDescription();
                InflateException inflateException2 = new InflateException(name);
                inflateException2.initCause(e4);
                throw inflateException2;
            }
        }
        constructor = constructor2;
        Object[] objArr = this.HO;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    Preference a(String str, AttributeSet attributeSet) {
        InflateException inflateException;
        try {
            if (-1 == str.indexOf(46)) {
                return a(str, "com.tencent.mm.ui.base.preference.", attributeSet);
            }
            return a(str, null, attributeSet);
        } catch (InflateException e) {
            throw e;
        } catch (Throwable e2) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Throwable e22) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e22);
            throw inflateException;
        }
    }

    void a(XmlPullParser xmlPullParser, f fVar, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        int next = xmlPullParser.next();
        while (true) {
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next != 2) {
                next = xmlPullParser.next();
            } else {
                fVar.a(a(xmlPullParser.getName(), attributeSet), -1);
                next = xmlPullParser.next();
            }
        }
    }
}
