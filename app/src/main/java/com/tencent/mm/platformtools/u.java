package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class u {

    public static class a {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int G(Context context, String str) {
            XmlResourceParser xmlResourceParser = null;
            int i = 0;
            try {
                Context createPackageContext = context.createPackageContext(str, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[i]);
                Object obj = xmlResourceParser;
            }
            if (createPackageContext != null) {
                AssetManager assets = createPackageContext.getAssets();
                Resources resources = new Resources(assets, context.getResources().getDisplayMetrics(), xmlResourceParser);
                xmlResourceParser = a(createPackageContext, assets);
                if (xmlResourceParser != null) {
                    int eventType;
                    try {
                        eventType = xmlResourceParser.getEventType();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.YYBMarketVerify", e2, "", new Object[0]);
                        eventType = i;
                    }
                    while (eventType != 1) {
                        switch (eventType) {
                            case 2:
                                Object name = xmlResourceParser.getName();
                                if (!TextUtils.isEmpty(name) && name.equals("manifest")) {
                                    obj = a(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", DownloadInfoColumns.VERSIONCODE), resources);
                                    if (TextUtils.isEmpty(obj)) {
                                        if (xmlResourceParser != null) {
                                            xmlResourceParser.close();
                                            break;
                                        }
                                    }
                                    i = t.getInt(obj, 0);
                                    if (xmlResourceParser != null) {
                                        xmlResourceParser.close();
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                } else if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
            return i;
        }

        private static XmlResourceParser a(Context context, AssetManager assetManager) {
            int i = 1;
            try {
                String str = (String) Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(context, new Object[0]);
                Method method = AssetManager.class.getMethod("getCookieName", new Class[]{Integer.TYPE});
                if (str == null && context.getPackageName().equals("android")) {
                    str = "/system/framework/framework-res.apk";
                }
                while (i < 20) {
                    if (str != null) {
                        if (str.equals(method.invoke(assetManager, new Object[]{Integer.valueOf(i)}))) {
                            return assetManager.openXmlResourceParser(i, "AndroidManifest.xml");
                        }
                    }
                    i++;
                }
            } catch (Exception e) {
            }
            return assetManager.openXmlResourceParser("AndroidManifest.xml");
        }

        private static String a(String str, Resources resources) {
            if (str != null && str.startsWith("@")) {
                try {
                    str = resources.getString(Integer.parseInt(str.substring(1)));
                } catch (NumberFormatException e) {
                } catch (NotFoundException e2) {
                }
            }
            return str;
        }
    }

    public static class c {
        public final String ffw;
        public final int iew;
        public final String iex;

        public c(String str, int i, String str2) {
            this.ffw = str;
            this.iew = i;
            this.iex = str2;
        }
    }

    public static boolean a(Context context, ArrayList<c> arrayList, boolean z) {
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!TextUtils.isEmpty(cVar.ffw)) {
                String str;
                String replace;
                String str2 = cVar.ffw;
                List<String> arrayList2 = new ArrayList();
                String packageResourcePath = context.getPackageResourcePath();
                int i;
                if (VERSION.SDK_INT >= 21) {
                    String[] split = packageResourcePath.split("/");
                    str = "";
                    if (split != null) {
                        CharSequence charSequence;
                        for (i = 0; i < split.length; i++) {
                            if (split[i].contains(context.getPackageName())) {
                                charSequence = split[i];
                                break;
                            }
                        }
                        Object obj = str;
                        if (!TextUtils.isEmpty(charSequence)) {
                            str = packageResourcePath.replace(charSequence, str2 + "-1");
                            if (new File(str).exists()) {
                                arrayList2.add(str);
                            }
                            replace = packageResourcePath.replace(charSequence, str2 + "-2");
                            if (new File(replace).exists()) {
                                arrayList2.add(replace);
                            }
                        }
                    }
                } else {
                    String[] split2 = packageResourcePath.split("/");
                    if (split2 != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (i = 0; i < split2.length; i++) {
                            if (i != split2.length - 1) {
                                stringBuilder.append(split2[i]);
                                stringBuilder.append("/");
                            }
                        }
                        replace = stringBuilder.toString();
                        str = replace + str2 + "-1.apk";
                        if (new File(str).exists()) {
                            arrayList2.add(str);
                        }
                        replace = replace + str2 + "-2.apk";
                        if (new File(replace).exists()) {
                            arrayList2.add(replace);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    for (String replace2 : arrayList2) {
                        File file = new File(replace2);
                        if (file.exists()) {
                            try {
                                Object obj2;
                                replace2 = "";
                                long currentTimeMillis = System.currentTimeMillis();
                                if (z) {
                                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(cVar.ffw, 64);
                                    if (packageInfo.signatures.length > 0) {
                                        replace2 = ab.UZ(packageInfo.signatures[packageInfo.signatures.length - 1].toCharsString());
                                    }
                                    obj2 = replace2;
                                } else {
                                    str = b.p(file.getAbsoluteFile());
                                }
                                String str3 = "MicroMsg.YYBMarketVerify";
                                String str4 = "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms";
                                Object[] objArr = new Object[6];
                                objArr[0] = Boolean.valueOf(z);
                                objArr[1] = cVar.ffw;
                                objArr[2] = cVar.iex;
                                objArr[3] = obj2;
                                boolean z2 = !TextUtils.isEmpty(obj2) && obj2.equalsIgnoreCase(cVar.iex);
                                objArr[4] = Boolean.valueOf(z2);
                                objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                x.i(str3, str4, objArr);
                                if (!TextUtils.isEmpty(obj2) && obj2.equalsIgnoreCase(cVar.iex)) {
                                    int i2;
                                    currentTimeMillis = System.currentTimeMillis();
                                    if (z) {
                                        i2 = context.getPackageManager().getPackageInfo(cVar.ffw, 0).versionCode;
                                    } else {
                                        i2 = a.G(context, cVar.ffw);
                                    }
                                    str3 = "MicroMsg.YYBMarketVerify";
                                    str4 = "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms";
                                    objArr = new Object[6];
                                    objArr[0] = Boolean.valueOf(z);
                                    objArr[1] = cVar.ffw;
                                    objArr[2] = Integer.valueOf(cVar.iew);
                                    objArr[3] = Integer.valueOf(i2);
                                    objArr[4] = Boolean.valueOf(i2 <= cVar.iew);
                                    objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                    x.i(str3, str4, objArr);
                                    if (i2 <= cVar.iew) {
                                        return true;
                                    }
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[0]);
                            }
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return false;
    }
}
