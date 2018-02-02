package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class PluginResourceLoader extends Resources {
    public Resources gGR;
    private Method gGS;
    private Method gGT;
    private HashMap<String, ZipFile> gGU;
    private final b<WeakReference<ConstantState>> gGV;

    private XmlResourceParser b(String str, int i, int i2, String str2) {
        try {
            return (XmlResourceParser) this.gGT.invoke(this.gGR, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PluginResourceLoader", e, "", new Object[0]);
            return null;
        }
    }

    Drawable loadDrawable(TypedValue typedValue, int i) {
        return a(typedValue, i);
    }

    Drawable loadDrawable(TypedValue typedValue, int i, boolean z) {
        return a(typedValue, i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        InputStream openRawResource;
        InputStream inputStream = null;
        getValue(i, typedValue, true);
        try {
            openRawResource = super.openRawResource(i, typedValue);
        } catch (Exception e) {
            openRawResource = null;
        }
        if (openRawResource != null) {
            return openRawResource;
        }
        for (Entry value : this.gGU.entrySet()) {
            inputStream = b((ZipFile) value.getValue(), typedValue);
            if (inputStream != null) {
                return inputStream;
            }
        }
        return inputStream;
    }

    private Drawable a(TypedValue typedValue, int i) {
        try {
            return (Drawable) this.gGS.invoke(this.gGR, new Object[]{typedValue, Integer.valueOf(i)});
        } catch (Exception e) {
        } catch (StackOverflowError e2) {
            x.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
        }
        try {
            if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
                Object b = b(typedValue.string.toString(), i, typedValue.assetCookie, "drawable");
                Drawable createFromXml = Drawable.createFromXml(this, b);
                b.close();
                return createFromXml;
            }
        } catch (Exception e3) {
        }
        for (Entry value : this.gGU.entrySet()) {
            createFromXml = a((ZipFile) value.getValue(), typedValue);
            if (createFromXml != null) {
                return createFromXml;
            }
        }
        x.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
        while (r1.hasNext()) {
            createFromXml = a((ZipFile) value.getValue(), typedValue);
            if (createFromXml != null) {
                return createFromXml;
            }
        }
        x.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Drawable a(ZipFile zipFile, TypedValue typedValue) {
        Throwable th;
        InputStream inputStream;
        Throwable th2;
        InputStream inputStream2 = null;
        if (typedValue.string == null) {
            return inputStream2;
        }
        Drawable newDrawable;
        String charSequence;
        ZipEntry entry;
        Drawable drawable;
        long j = ((long) typedValue.data) | (((long) typedValue.assetCookie) << 32);
        b bVar = this.gGV;
        int b = b.b(bVar.wi, bVar.hX, j);
        InputStream inputStream3 = (b < 0 || bVar.wj[b] == b.wg) ? inputStream2 : bVar.wj[b];
        WeakReference weakReference = (WeakReference) inputStream3;
        if (weakReference != null) {
            ConstantState constantState = (ConstantState) weakReference.get();
            if (constantState != null) {
                newDrawable = constantState.newDrawable(this);
                if (newDrawable == null) {
                    x.v("MicroMsg.PluginResourceLoader", "get form cache");
                    return newDrawable;
                }
                charSequence = typedValue.string.toString();
                try {
                    x.v("MicroMsg.PluginResourceLoader", "try load drawable from zip, entry=%s, file=%s", new Object[]{charSequence, zipFile.getName()});
                    entry = zipFile.getEntry(charSequence);
                    try {
                        inputStream2 = zipFile.getInputStream(entry);
                        newDrawable = Drawable.createFromResourceStream(this, typedValue, inputStream2, charSequence);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStream2;
                        th2 = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th2;
                    }
                    if (newDrawable == null) {
                        inputStream2 = zipFile.getInputStream(entry);
                        newDrawable = Drawable.createFromStream(inputStream2, charSequence);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                drawable = newDrawable;
                            } catch (Exception e5) {
                                drawable = newDrawable;
                            }
                            if (drawable == null) {
                                return drawable;
                            }
                            this.gGV.put(j, new WeakReference(drawable.getConstantState()));
                            return drawable;
                        }
                    }
                } catch (Exception e6) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            drawable = newDrawable;
                        } catch (Exception e7) {
                            drawable = newDrawable;
                        }
                    }
                } catch (Exception e8) {
                    drawable = newDrawable;
                } catch (Throwable th32) {
                    th = th32;
                    inputStream = inputStream2;
                    th2 = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e9) {
                        }
                    }
                }
                drawable = newDrawable;
                if (drawable == null) {
                    return drawable;
                }
                this.gGV.put(j, new WeakReference(drawable.getConstantState()));
                return drawable;
            }
            bVar = this.gGV;
            b = b.b(bVar.wi, bVar.hX, j);
            if (b >= 0 && bVar.wj[b] != b.wg) {
                bVar.wj[b] = b.wg;
                bVar.wh = true;
            }
        }
        Object obj = inputStream2;
        if (newDrawable == null) {
            charSequence = typedValue.string.toString();
            x.v("MicroMsg.PluginResourceLoader", "try load drawable from zip, entry=%s, file=%s", new Object[]{charSequence, zipFile.getName()});
            entry = zipFile.getEntry(charSequence);
            inputStream2 = zipFile.getInputStream(entry);
            newDrawable = Drawable.createFromResourceStream(this, typedValue, inputStream2, charSequence);
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (newDrawable == null) {
                inputStream2 = zipFile.getInputStream(entry);
                newDrawable = Drawable.createFromStream(inputStream2, charSequence);
                if (inputStream2 != null) {
                    inputStream2.close();
                    drawable = newDrawable;
                    if (drawable == null) {
                        return drawable;
                    }
                    this.gGV.put(j, new WeakReference(drawable.getConstantState()));
                    return drawable;
                }
            }
            drawable = newDrawable;
            if (drawable == null) {
                return drawable;
            }
            this.gGV.put(j, new WeakReference(drawable.getConstantState()));
            return drawable;
        }
        x.v("MicroMsg.PluginResourceLoader", "get form cache");
        return newDrawable;
    }

    private static InputStream b(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        if (typedValue.string != null) {
            try {
                x.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", new Object[]{typedValue.string.toString(), zipFile.getName()});
                inputStream = zipFile.getInputStream(zipFile.getEntry(r1));
            } catch (Exception e) {
            }
        }
        return inputStream;
    }
}
