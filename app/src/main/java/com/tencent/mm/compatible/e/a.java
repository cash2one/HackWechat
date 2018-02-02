package com.tencent.mm.compatible.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class a {
    public static Boolean gGY;

    private static class a {
        public String ffw;
        public int gGZ;
        public int gHa;
        public int gHb;
        public SparseArray<String> gHc;

        private a() {
        }

        public final String toString() {
            return String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[]{this.ffw, Integer.valueOf(this.gGZ), Integer.valueOf(this.gHa), this.gHc, Integer.valueOf(this.gHb)});
        }
    }

    public static boolean a(String str, String str2, PInt pInt, PBool pBool) {
        if (str == null) {
            pBool.value = false;
            return false;
        } else if (str2 == null) {
            pBool.value = true;
            return false;
        } else if (str.equals(str2)) {
            pInt.value++;
            pBool.value = true;
            return true;
        } else {
            pBool.value = false;
            return false;
        }
    }

    public static List<PackageInfo> bh(boolean z) {
        Set hashSet = new HashSet();
        if (z) {
            ActivityManager activityManager = (ActivityManager) ac.getContext().getSystemService("activity");
            if (activityManager != null) {
                try {
                    List<RunningServiceInfo> runningServices = activityManager.getRunningServices(32767);
                    if (runningServices != null) {
                        for (RunningServiceInfo runningServiceInfo : runningServices) {
                            hashSet.add(runningServiceInfo.service.getPackageName());
                        }
                    }
                } catch (SecurityException e) {
                    x.e("MicroMsg.PermissionConfig", "getRunningServices failed");
                }
            }
        }
        PackageManager packageManager = ac.getContext().getPackageManager();
        if (packageManager == null) {
            return null;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        if (installedPackages == null || !z) {
            return installedPackages;
        }
        List<PackageInfo> arrayList = new ArrayList();
        for (PackageInfo packageInfo : installedPackages) {
            if (hashSet.contains(packageInfo.packageName)) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public static void a(String str, List<b> list, List<a> list2) {
        BufferedReader bufferedReader;
        Throwable th;
        if (e.bO(str)) {
            String str2 = ".perm.values.";
            String str3 = "";
            String cfi = w.cfi();
            if (cfi.equals("zh_CN")) {
                cfi = "zh_CN";
            } else if (cfi.equals("zh_TW") || cfi.equals("zh_HK")) {
                cfi = str3 + "zh_TW";
            } else {
                cfi = str3 + "en";
            }
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        str3 = bufferedReader.readLine();
                        if (str3 != null) {
                            String trim = str3.trim();
                            if (trim.length() != 0) {
                                Map y = bi.y(trim, "perm");
                                if (y == null) {
                                    x.e("MicroMsg.PermissionConfig", "unable to parse xml, " + trim);
                                } else {
                                    str3 = (String) y.get(".perm.type");
                                    if (str3 == null) {
                                        x.e("MicroMsg.PermissionConfig", "invalid config, " + trim);
                                    } else if (str3.equals("1")) {
                                        b bVar = new b((byte) 0);
                                        bVar.gHc = new SparseArray();
                                        bVar.gHd = (String) y.get(".perm.manufacture");
                                        bVar.model = (String) y.get(".perm.model");
                                        bVar.version = (String) y.get(".perm.version_release");
                                        bVar.gHc.append(1, y.get(str2 + cfi));
                                        bVar.gHc.append(2, y.get(str2 + "camera." + cfi));
                                        bVar.gHb = bh.VI((String) y.get(".perm.check_exception"));
                                        list.add(bVar);
                                    } else if (str3.equals("2")) {
                                        a aVar = new a();
                                        aVar.gHc = new SparseArray();
                                        aVar.ffw = (String) y.get(".perm.package");
                                        aVar.gGZ = bh.VI((String) y.get(".perm.min_versioncode"));
                                        aVar.gHa = bh.VI((String) y.get(".perm.max_versioncode"));
                                        aVar.gHc.append(1, y.get(str2 + cfi));
                                        aVar.gHc.append(2, y.get(str2 + "camera." + cfi));
                                        aVar.gHb = bh.VI((String) y.get(".perm.check_exception"));
                                        list2.add(aVar);
                                    }
                                }
                            }
                        } else {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        bufferedReader2 = bufferedReader;
                    } catch (IOException e3) {
                    }
                }
            } catch (FileNotFoundException e4) {
                try {
                    x.e("MicroMsg.PermissionConfig", "file not found exception");
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            return;
                        } catch (IOException e5) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    bufferedReader = bufferedReader2;
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                bufferedReader = null;
                try {
                    x.e("MicroMsg.PermissionConfig", "read permission config file failed");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e8) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                bufferedReader = null;
                th = th22;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        x.i("MicroMsg.PermissionConfig", "file is not exists");
    }
}
