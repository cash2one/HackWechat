package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr) {
        if (((e) g.h(e.class)).IX().Ja() && "//widget".equals(strArr[0]) && strArr.length >= 2) {
            boolean z;
            String toLowerCase = strArr[1].toLowerCase();
            switch (toLowerCase.hashCode()) {
                case -1408208058:
                    if (toLowerCase.equals("assert")) {
                        z = false;
                        break;
                    }
                case 547812385:
                    if (toLowerCase.equals("debugger")) {
                        z = true;
                        break;
                    }
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    com.tencent.mm.bz.a.post(new 1(this, strArr));
                    break;
                case true:
                    if (strArr.length > 2 && !TextUtils.isEmpty(strArr[2])) {
                        toLowerCase = strArr[2];
                        switch (toLowerCase.hashCode()) {
                            case 46428:
                                if (toLowerCase.equals("-cr")) {
                                    z = true;
                                    break;
                                }
                            case 46800:
                                if (toLowerCase.equals("-or")) {
                                    z = false;
                                    break;
                                }
                            case 1450433:
                                if (toLowerCase.equals("-ocb")) {
                                    z = true;
                                    break;
                                }
                            default:
                                z = true;
                                break;
                        }
                        switch (z) {
                            case false:
                                ((e) g.h(e.class)).IX().bz(true);
                                break;
                            case true:
                                ((e) g.h(e.class)).IX().bz(false);
                                break;
                            case true:
                                ((e) g.h(e.class)).IX().bf(context);
                                break;
                            default:
                                break;
                        }
                    }
                default:
                    break;
            }
        }
        return true;
    }
}
