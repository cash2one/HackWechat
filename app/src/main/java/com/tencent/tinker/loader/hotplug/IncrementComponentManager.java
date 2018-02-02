package com.tencent.tinker.loader.hotplug;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Xml;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class IncrementComponentManager {
    private static final Map<String, ActivityInfo> Akb = new HashMap();
    private static final Map<String, IntentFilter> Akc = new HashMap();
    private static final AttrTranslator<ActivityInfo> Akd = new AttrTranslator<ActivityInfo>() {
        final /* synthetic */ void a(Context context, String str, String str2, Object obj) {
            int i = 0;
            ActivityInfo activityInfo = (ActivityInfo) obj;
            if ("name".equals(str)) {
                if (str2.charAt(i) == '.') {
                    activityInfo.name = context.getPackageName() + str2;
                } else {
                    activityInfo.name = str2;
                }
            } else if ("parentActivityName".equals(str)) {
                if (VERSION.SDK_INT < 16) {
                    return;
                }
                if (str2.charAt(i) == '.') {
                    activityInfo.parentActivityName = context.getPackageName() + str2;
                } else {
                    activityInfo.parentActivityName = str2;
                }
            } else if ("exported".equals(str)) {
                activityInfo.exported = "true".equalsIgnoreCase(str2);
            } else if ("launchMode".equals(str)) {
                if (!"standard".equalsIgnoreCase(str2)) {
                    if ("singleTop".equalsIgnoreCase(str2)) {
                        i = 1;
                    } else if ("singleTask".equalsIgnoreCase(str2)) {
                        i = 2;
                    } else if ("singleInstance".equalsIgnoreCase(str2)) {
                        i = 3;
                    }
                }
                activityInfo.launchMode = i;
            } else if ("theme".equals(str)) {
                activityInfo.theme = context.getResources().getIdentifier(str2, "style", context.getPackageName());
            } else if ("uiOptions".equals(str)) {
                if (VERSION.SDK_INT >= 14) {
                    activityInfo.uiOptions = Integer.decode(str2).intValue();
                }
            } else if ("permission".equals(str)) {
                activityInfo.permission = str2;
            } else if ("taskAffinity".equals(str)) {
                activityInfo.taskAffinity = str2;
            } else if ("multiprocess".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 1;
                } else {
                    activityInfo.flags &= -2;
                }
            } else if ("finishOnTaskLaunch".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2;
                } else {
                    activityInfo.flags &= -3;
                }
            } else if ("clearTaskOnLaunch".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4;
                } else {
                    activityInfo.flags &= -5;
                }
            } else if ("noHistory".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= FileUtils.S_IWUSR;
                } else {
                    activityInfo.flags &= -129;
                }
            } else if ("alwaysRetainTaskState".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8;
                } else {
                    activityInfo.flags &= -9;
                }
            } else if ("stateNotNeeded".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16;
                } else {
                    activityInfo.flags &= -17;
                }
            } else if ("excludeFromRecents".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 32;
                } else {
                    activityInfo.flags &= -33;
                }
            } else if ("allowTaskReparenting".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 64;
                } else {
                    activityInfo.flags &= -65;
                }
            } else if ("finishOnCloseSystemDialogs".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 256;
                } else {
                    activityInfo.flags &= -257;
                }
            } else if ("showOnLockScreen".equals(str) || "showForAllUsers".equals(str)) {
                if (VERSION.SDK_INT >= 23) {
                    i = ShareReflectUtil.e(ActivityInfo.class, "FLAG_SHOW_FOR_ALL_USERS");
                    if ("true".equalsIgnoreCase(str2)) {
                        activityInfo.flags = i | activityInfo.flags;
                        return;
                    }
                    activityInfo.flags = (i ^ -1) & activityInfo.flags;
                }
            } else if ("immersive".equals(str)) {
                if (VERSION.SDK_INT < 18) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2048;
                } else {
                    activityInfo.flags &= -2049;
                }
            } else if ("hardwareAccelerated".equals(str)) {
                if (VERSION.SDK_INT < 11) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= WXMediaMessage.TITLE_LENGTH_LIMIT;
                } else {
                    activityInfo.flags &= -513;
                }
            } else if ("documentLaunchMode".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.documentLaunchMode = Integer.decode(str2).intValue();
                }
            } else if ("maxRecents".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.maxRecents = Integer.decode(str2).intValue();
                }
            } else if ("configChanges".equals(str)) {
                activityInfo.configChanges = Integer.decode(str2).intValue();
            } else if ("windowSoftInputMode".equals(str)) {
                activityInfo.softInputMode = Integer.decode(str2).intValue();
            } else if ("persistableMode".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.persistableMode = Integer.decode(str2).intValue();
                }
            } else if ("allowEmbedded".equals(str)) {
                i = ShareReflectUtil.e(ActivityInfo.class, "FLAG_ALLOW_EMBEDDED");
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags = i | activityInfo.flags;
                    return;
                }
                activityInfo.flags = (i ^ -1) & activityInfo.flags;
            } else if ("autoRemoveFromRecents".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8192;
                } else {
                    activityInfo.flags &= -8193;
                }
            } else if ("relinquishTaskIdentity".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= Downloads.RECV_BUFFER_SIZE;
                } else {
                    activityInfo.flags &= -4097;
                }
            } else if ("resumeWhilePausing".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16384;
                } else {
                    activityInfo.flags &= -16385;
                }
            } else if ("screenOrientation".equals(str)) {
                if (!"unspecified".equalsIgnoreCase(str2)) {
                    if ("behind".equalsIgnoreCase(str2)) {
                        i = 3;
                    } else if (!"landscape".equalsIgnoreCase(str2)) {
                        if ("portrait".equalsIgnoreCase(str2)) {
                            i = 1;
                        } else if ("reverseLandscape".equalsIgnoreCase(str2)) {
                            i = 8;
                        } else if ("reversePortrait".equalsIgnoreCase(str2)) {
                            i = 9;
                        } else if ("sensorLandscape".equalsIgnoreCase(str2)) {
                            i = 6;
                        } else if ("sensorPortrait".equalsIgnoreCase(str2)) {
                            i = 7;
                        } else if ("sensor".equalsIgnoreCase(str2)) {
                            i = 4;
                        } else if ("fullSensor".equalsIgnoreCase(str2)) {
                            i = 10;
                        } else if ("nosensor".equalsIgnoreCase(str2)) {
                            i = 5;
                        } else if ("user".equalsIgnoreCase(str2)) {
                            i = 2;
                        } else if (VERSION.SDK_INT >= 18 && "fullUser".equalsIgnoreCase(str2)) {
                            i = 13;
                        } else if (VERSION.SDK_INT >= 18 && "locked".equalsIgnoreCase(str2)) {
                            i = 14;
                        } else if (VERSION.SDK_INT >= 18 && "userLandscape".equalsIgnoreCase(str2)) {
                            i = 11;
                        } else if (VERSION.SDK_INT >= 18 && "userPortrait".equalsIgnoreCase(str2)) {
                            i = 12;
                        }
                    }
                    activityInfo.screenOrientation = i;
                }
                i = -1;
                activityInfo.screenOrientation = i;
            } else if ("label".equals(str)) {
                try {
                    i = context.getResources().getIdentifier(str2, "string", IncrementComponentManager.xCJ);
                } catch (Throwable th) {
                }
                if (i != 0) {
                    activityInfo.labelRes = i;
                } else {
                    activityInfo.nonLocalizedLabel = str2;
                }
            } else if ("icon".equals(str)) {
                try {
                    activityInfo.icon = context.getResources().getIdentifier(str2, null, IncrementComponentManager.xCJ);
                } catch (Throwable th2) {
                }
            } else if ("banner".equals(str)) {
                if (VERSION.SDK_INT >= 20) {
                    try {
                        activityInfo.banner = context.getResources().getIdentifier(str2, null, IncrementComponentManager.xCJ);
                    } catch (Throwable th3) {
                    }
                }
            } else if ("logo".equals(str)) {
                try {
                    activityInfo.logo = context.getResources().getIdentifier(str2, null, IncrementComponentManager.xCJ);
                } catch (Throwable th4) {
                }
            }
        }

        final void a(int i, XmlPullParser xmlPullParser) {
            try {
                if (xmlPullParser.getEventType() != 2 || !"activity".equals(xmlPullParser.getName())) {
                    throw new IllegalStateException("unexpected xml parser state when parsing incremental component manifest.");
                }
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private static Context gMy = null;
    private static volatile boolean gPb = false;
    private static String xCJ = null;

    private static abstract class AttrTranslator<T_RESULT> {
        abstract void a(Context context, String str, String str2, T_RESULT t_result);

        private AttrTranslator() {
        }

        final void a(Context context, XmlPullParser xmlPullParser, T_RESULT t_result) {
            int i = 0;
            a(0, xmlPullParser);
            int attributeCount = xmlPullParser.getAttributeCount();
            while (i < attributeCount) {
                if ("android".equals(xmlPullParser.getAttributePrefix(i))) {
                    a(context, xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i), t_result);
                }
                i++;
            }
        }

        void a(int i, XmlPullParser xmlPullParser) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(Context context, ShareSecurityCheck shareSecurityCheck) {
        boolean z;
        Throwable e;
        XmlPullParser xmlPullParser = null;
        synchronized (IncrementComponentManager.class) {
            if (shareSecurityCheck.AlR.containsKey("assets/inc_component_meta.txt")) {
                Context context2 = context;
                while (context2 instanceof ContextWrapper) {
                    context = ((ContextWrapper) context2).getBaseContext();
                    if (context == null) {
                        break;
                    }
                    context2 = context;
                }
                gMy = context2;
                xCJ = context2.getPackageName();
                Reader stringReader = new StringReader((String) shareSecurityCheck.AlR.get("assets/inc_component_meta.txt"));
                try {
                    xmlPullParser = Xml.newPullParser();
                    xmlPullParser.setInput(stringReader);
                    for (int eventType = xmlPullParser.getEventType(); eventType != 1; eventType = xmlPullParser.next()) {
                        switch (eventType) {
                            case 2:
                                String name = xmlPullParser.getName();
                                if (!"activity".equalsIgnoreCase(name)) {
                                    if (!("service".equalsIgnoreCase(name) || "receiver".equalsIgnoreCase(name))) {
                                        "provider".equalsIgnoreCase(name);
                                        break;
                                    }
                                }
                                ActivityInfo a = a(context2, xmlPullParser);
                                Akb.put(a.name, a);
                                break;
                            default:
                                break;
                        }
                    }
                    gPb = true;
                    if (xmlPullParser != null) {
                        try {
                            xmlPullParser.setInput(null);
                        } catch (Throwable th) {
                        }
                    }
                    SharePatchFileUtil.cy(stringReader);
                    z = true;
                } catch (XmlPullParserException e2) {
                    e = e2;
                    XmlPullParser xmlPullParser2 = xmlPullParser;
                } catch (Throwable th2) {
                    e = th2;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    private static synchronized ActivityInfo a(Context context, XmlPullParser xmlPullParser) {
        ActivityInfo activityInfo;
        synchronized (IncrementComponentManager.class) {
            activityInfo = new ActivityInfo();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            activityInfo.applicationInfo = applicationInfo;
            activityInfo.packageName = xCJ;
            activityInfo.processName = applicationInfo.processName;
            activityInfo.launchMode = 0;
            activityInfo.permission = applicationInfo.permission;
            activityInfo.screenOrientation = -1;
            activityInfo.taskAffinity = applicationInfo.taskAffinity;
            if (VERSION.SDK_INT >= 11 && (applicationInfo.flags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                activityInfo.flags |= WXMediaMessage.TITLE_LENGTH_LIMIT;
            }
            if (VERSION.SDK_INT >= 21) {
                activityInfo.documentLaunchMode = 0;
            }
            if (VERSION.SDK_INT >= 14) {
                activityInfo.uiOptions = applicationInfo.uiOptions;
            }
            Akd.a(context, xmlPullParser, activityInfo);
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                } else if (!(next == 3 || next == 4)) {
                    String name = xmlPullParser.getName();
                    if ("intent-filter".equalsIgnoreCase(name)) {
                        a(activityInfo.name, xmlPullParser);
                    } else if ("meta-data".equalsIgnoreCase(name)) {
                        a(activityInfo, xmlPullParser);
                    }
                }
            }
        }
        return activityInfo;
    }

    private static synchronized void a(String str, XmlPullParser xmlPullParser) {
        synchronized (IncrementComponentManager.class) {
            IntentFilter intentFilter = new IntentFilter();
            Object attributeValue = xmlPullParser.getAttributeValue(null, DownloadInfo.PRIORITY);
            if (!TextUtils.isEmpty(attributeValue)) {
                intentFilter.setPriority(Integer.decode(attributeValue).intValue());
            }
            if (!TextUtils.isEmpty(xmlPullParser.getAttributeValue(null, "autoVerify"))) {
                try {
                    ShareReflectUtil.c(IntentFilter.class, "setAutoVerify", Boolean.TYPE).invoke(intentFilter, new Object[]{Boolean.valueOf("true".equalsIgnoreCase(attributeValue))});
                } catch (Throwable th) {
                }
            }
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                    Akc.put(str, intentFilter);
                } else if (!(next == 3 || next == 4)) {
                    String name = xmlPullParser.getName();
                    if ("action".equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "name");
                        if (name != null) {
                            intentFilter.addAction(name);
                        }
                    } else if ("category".equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "name");
                        if (name != null) {
                            intentFilter.addCategory(name);
                        }
                    } else if (SlookAirButtonFrequentContactAdapter.DATA.equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "mimeType");
                        if (name != null) {
                            try {
                                intentFilter.addDataType(name);
                            } catch (Throwable e) {
                                throw new XmlPullParserException("bad mimeType", xmlPullParser, e);
                            }
                        }
                        name = xmlPullParser.getAttributeValue(null, "scheme");
                        if (name != null) {
                            intentFilter.addDataScheme(name);
                        }
                        if (VERSION.SDK_INT >= 19) {
                            name = xmlPullParser.getAttributeValue(null, "ssp");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 0);
                            }
                            name = xmlPullParser.getAttributeValue(null, "sspPrefix");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 1);
                            }
                            name = xmlPullParser.getAttributeValue(null, "sspPattern");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 2);
                            }
                        }
                        name = xmlPullParser.getAttributeValue(null, "host");
                        String attributeValue2 = xmlPullParser.getAttributeValue(null, "port");
                        if (name != null) {
                            intentFilter.addDataAuthority(name, attributeValue2);
                        }
                        name = xmlPullParser.getAttributeValue(null, "path");
                        if (name != null) {
                            intentFilter.addDataPath(name, 0);
                        }
                        name = xmlPullParser.getAttributeValue(null, "pathPrefix");
                        if (name != null) {
                            intentFilter.addDataPath(name, 1);
                        }
                        name = xmlPullParser.getAttributeValue(null, "pathPattern");
                        if (name != null) {
                            intentFilter.addDataPath(name, 2);
                        }
                    }
                    d(xmlPullParser);
                }
            }
            Akc.put(str, intentFilter);
        }
    }

    private static synchronized void a(ActivityInfo activityInfo, XmlPullParser xmlPullParser) {
        synchronized (IncrementComponentManager.class) {
            ClassLoader classLoader = IncrementComponentManager.class.getClassLoader();
            Object attributeValue = xmlPullParser.getAttributeValue(null, "name");
            String attributeValue2 = xmlPullParser.getAttributeValue(null, DownloadSettingTable$Columns.VALUE);
            if (!TextUtils.isEmpty(attributeValue)) {
                if (activityInfo.metaData == null) {
                    activityInfo.metaData = new Bundle(classLoader);
                }
                activityInfo.metaData.putString(attributeValue, attributeValue2);
            }
        }
    }

    private static void d(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    private static synchronized void El() {
        synchronized (IncrementComponentManager.class) {
            if (gPb) {
            } else {
                throw new IllegalStateException("Not initialized!!");
            }
        }
    }

    public static boolean abF(String str) {
        El();
        return str != null && Akb.containsKey(str);
    }

    public static ActivityInfo abG(String str) {
        El();
        return str != null ? (ActivityInfo) Akb.get(str) : null;
    }

    public static ResolveInfo ap(Intent intent) {
        Object className;
        int i;
        El();
        IntentFilter intentFilter = null;
        int i2 = 0;
        ComponentName component = intent.getComponent();
        int i3;
        if (component != null) {
            className = component.getClassName();
            if (Akb.containsKey(className)) {
                i3 = 0;
            } else {
                className = null;
                i3 = -1;
            }
            i = i3;
        } else {
            String str = null;
            i = -1;
            for (Entry entry : Akc.entrySet()) {
                Object obj;
                int i4;
                IntentFilter intentFilter2;
                String str2 = (String) entry.getKey();
                IntentFilter intentFilter3 = (IntentFilter) entry.getValue();
                i3 = intentFilter3.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "Tinker.IncrementCompMgr");
                if (i3 == -3 || i3 == -4 || i3 == -2 || i3 == -1) {
                    obj = null;
                } else {
                    obj = 1;
                }
                int priority = intentFilter3.getPriority();
                if (obj == null || priority <= i) {
                    i4 = i2;
                    intentFilter2 = intentFilter;
                    str2 = str;
                    priority = i;
                } else {
                    int i5 = i3;
                    intentFilter2 = intentFilter3;
                    i4 = i5;
                }
                i2 = i4;
                intentFilter = intentFilter2;
                str = str2;
                i = priority;
            }
            String str3 = str;
        }
        if (className == null) {
            return null;
        }
        ResolveInfo resolveInfo = new ResolveInfo();
        resolveInfo.activityInfo = (ActivityInfo) Akb.get(className);
        resolveInfo.filter = intentFilter;
        resolveInfo.match = i2;
        resolveInfo.priority = i;
        resolveInfo.resolvePackageName = xCJ;
        resolveInfo.icon = resolveInfo.activityInfo.icon;
        resolveInfo.labelRes = resolveInfo.activityInfo.labelRes;
        return resolveInfo;
    }

    private IncrementComponentManager() {
        throw new UnsupportedOperationException();
    }
}
