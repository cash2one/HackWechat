package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.xweb.xwalk.a.a.a;
import com.tencent.xweb.xwalk.a.f.c;
import java.io.File;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public final class e extends AsyncTask<String, Integer, Integer> {
    static XWalkUpdater Att;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        int i;
        int i2 = 1;
        c.cJb();
        if (c.cJe()) {
            XWalkInitializer.addXWalkInitializeLog("time to update");
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            if (c.cJg()) {
                c.cJb();
                if (!c.cJc()) {
                }
            }
            i2 = 0;
            if (i2 != 0) {
                return Integer.valueOf(2);
            }
        } else if (!cJi()) {
            return Integer.valueOf(1);
        }
        return Integer.valueOf(0);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 1) {
            b(c.cJh());
        } else if (num.intValue() == 2) {
            if (NetworkUtil.isNetworkAvailable()) {
                f$a com_tencent_xweb_xwalk_a_f_a = new f$a();
                com_tencent_xweb_xwalk_a_f_a.mUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
                com_tencent_xweb_xwalk_a_f_a.mFilePath = XWalkEnvironment.getUpdateConfigDir() + File.separator + "updateConfg.xml";
                com_tencent_xweb_xwalk_a_f_a.AtV = true;
                c.cJf();
                com.tencent.xweb.util.e.cIK();
                b anonymousClass1 = new b() {
                    public final void a(c cVar) {
                        a aVar;
                        String str = cVar.mFilePath;
                        if (str == null) {
                            XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
                            aVar = null;
                        } else {
                            File file = new File(str);
                            if (file.exists()) {
                                aVar = a.i(file, a.h(file, (int) file.length()));
                            } else {
                                XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
                                aVar = null;
                            }
                        }
                        if (aVar == null) {
                            com.tencent.xweb.util.e.gB(35);
                            com.tencent.xweb.util.e.cIL();
                            com.tencent.xweb.util.e.be(15123, "0,17," + cVar.AtX + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.AtY + "," + cVar.mTotalSize);
                            XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
                            return;
                        }
                        try {
                            com.tencent.xweb.a.a(aVar.Atx, aVar.Atv);
                        } catch (Exception e) {
                            XWalkEnvironment.addXWalkInitializeLog("apply cmds failed , " + e.getMessage());
                        }
                        com.tencent.xweb.util.e.gG(cVar.AtY);
                        com.tencent.xweb.util.e.be(15123, aVar.Atv + ",17," + cVar.AtX + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.AtY + "," + cVar.mTotalSize);
                        c.cJb();
                        e.c(c.a(aVar));
                    }

                    public final void b(c cVar) {
                        com.tencent.xweb.util.e.gB(35);
                        com.tencent.xweb.util.e.cIL();
                        com.tencent.xweb.util.e.be(15123, "0,17," + cVar.AtX + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.AtY + "," + cVar.mTotalSize);
                        XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
                    }
                };
                f fVar = new f();
                fVar.AtQ = anonymousClass1;
                fVar.AtR = com_tencent_xweb_xwalk_a_f_a;
                fVar.AtS = 0;
                fVar.AtT = System.currentTimeMillis();
                fVar.execute(new f$a[]{fVar.AtR});
            } else {
                XWalkEnvironment.addXWalkInitializeLog("network not available!!");
            }
        }
        super.onPostExecute(num);
    }

    public e(XWalkUpdater xWalkUpdater) {
        Att = xWalkUpdater;
    }

    private static boolean b(c$a com_tencent_xweb_xwalk_a_c_a) {
        if (cJi() || !NetworkUtil.isNetworkAvailable()) {
            return false;
        }
        if (com_tencent_xweb_xwalk_a_c_a.AtA || NetworkUtil.isWifiAvailable()) {
            UpdateConfig updateConfig;
            XWalkUpdater xWalkUpdater = Att;
            if (com_tencent_xweb_xwalk_a_c_a.AtJ) {
                if (com_tencent_xweb_xwalk_a_c_a.Atu != null && !com_tencent_xweb_xwalk_a_c_a.Atu.isEmpty() && com_tencent_xweb_xwalk_a_c_a.fel != null && !com_tencent_xweb_xwalk_a_c_a.fel.isEmpty()) {
                    updateConfig = new UpdateConfig(com_tencent_xweb_xwalk_a_c_a.fel, true, com_tencent_xweb_xwalk_a_c_a.Atu, com_tencent_xweb_xwalk_a_c_a.Atz, com_tencent_xweb_xwalk_a_c_a.AtB);
                } else if (c$a.$assertionsDisabled) {
                    updateConfig = new UpdateConfig(com_tencent_xweb_xwalk_a_c_a.Atz, true, com_tencent_xweb_xwalk_a_c_a.AtB);
                } else {
                    throw new AssertionError("royle:no md5 info, maybe something wrong");
                }
            } else if (com_tencent_xweb_xwalk_a_c_a.Atu != null && !com_tencent_xweb_xwalk_a_c_a.Atu.isEmpty()) {
                updateConfig = new UpdateConfig(com_tencent_xweb_xwalk_a_c_a.Atu, false, null, com_tencent_xweb_xwalk_a_c_a.Atz, com_tencent_xweb_xwalk_a_c_a.AtB);
            } else if (c$a.$assertionsDisabled) {
                updateConfig = new UpdateConfig(com_tencent_xweb_xwalk_a_c_a.Atz, false, com_tencent_xweb_xwalk_a_c_a.AtB);
            } else {
                throw new AssertionError("royle:no md5 info, maybe something wrong");
            }
            updateConfig.versionDetail = com_tencent_xweb_xwalk_a_c_a.AtL;
            updateConfig.bUseCdn = com_tencent_xweb_xwalk_a_c_a.bUseCdn;
            if (!xWalkUpdater.updateXWalkRuntime(updateConfig)) {
                return false;
            }
            cJj();
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
        return false;
    }

    public static boolean cJi() {
        int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("UpdatingProcessId", -1);
        if (i == Process.myPid()) {
            XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
            return true;
        } else if (i < 0) {
            return false;
        } else {
            ActivityManager activityManager = (ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService("activity");
            Process.myPid();
            int myUid = Process.myUid();
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i) {
                    if (runningAppProcessInfo.uid == myUid) {
                        XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
                        return true;
                    }
                    cJk();
                    return false;
                }
            }
            cJk();
            return false;
        }
    }

    public static void cJj() {
        int myPid = Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putInt("UpdatingProcessId", myPid);
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("start updating progress");
    }

    public static void cJk() {
        Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.remove("UpdatingProcessId");
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("finish updating progress");
    }

    public static void cJl() {
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        cJk();
        c.a(null);
    }

    public static void Ji(int i) {
        cJk();
        c.Ji(i);
    }

    static void c(c$a com_tencent_xweb_xwalk_a_c_a) {
        if (com_tencent_xweb_xwalk_a_c_a == null) {
            return;
        }
        if (!XWalkEnvironment.hasAvailableVersion()) {
            XWalkInitializer.addXWalkInitializeLog("no availableversion installed, do start download ");
            b(com_tencent_xweb_xwalk_a_c_a);
        } else if (com_tencent_xweb_xwalk_a_c_a.AtK <= System.currentTimeMillis()) {
            b(com_tencent_xweb_xwalk_a_c_a);
        }
    }
}
