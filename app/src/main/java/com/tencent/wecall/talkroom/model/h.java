package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.f;
import com.tencent.pb.common.c.g;
import java.util.ArrayList;

public class h {
    public static h AoQ = new h();
    static final String TAG = h.class.getCanonicalName();
    public int AoR = 0;
    int AoS = 0;
    long AoT = 0;
    long AoU = 0;
    int AoV = 0;
    public int AoW = 0;
    int AoX = 0;
    long AoY = 0;
    int AoZ;
    int Apa = -1;
    String Apb;
    int Apc;
    StringBuffer Apd = new StringBuffer();
    long Ape = 0;
    long Apf = 0;
    long Apg = 0;
    String deviceModel;
    public String groupId = "";
    public int nDx = 0;
    public long nDy = 0;
    long nET = 0;
    int nEU = 0;
    public int nEd = -1;
    public int netType = -1;
    public int soC = -1;
    public int soo = 1;
    public int sor = 0;
    public int sos = 0;
    public int sov = 0;
    int swB = 0;
    public int swC = 0;
    String swH = "";
    int swo = 0;
    int swr = 0;
    int swv = 0;
    long sww = 0;
    public String zMM = "";

    public final String cHZ() {
        int i;
        c.d(TAG, new Object[]{"collectInfo"});
        this.Apb = Build.MANUFACTURER;
        this.deviceModel = Build.MODEL;
        this.Apc = VERSION.SDK_INT;
        this.swH = VERSION.RELEASE;
        this.netType = k.iM(d.ssG);
        this.AoZ = -1;
        this.Apa = -1;
        Iterable arrayList = new ArrayList();
        arrayList.add(this.groupId);
        arrayList.add(this.zMM);
        arrayList.add(Integer.valueOf(this.soo));
        arrayList.add(Integer.valueOf(this.nDx));
        arrayList.add(Long.valueOf(this.nDy));
        arrayList.add(Integer.valueOf(this.nEd));
        arrayList.add(Integer.valueOf(this.swo));
        arrayList.add(Integer.valueOf(this.swv));
        arrayList.add(Integer.valueOf(this.swr));
        arrayList.add(Integer.valueOf(this.nEU));
        arrayList.add(Integer.valueOf(this.AoR));
        arrayList.add(Integer.valueOf(this.AoS));
        arrayList.add(Long.valueOf(this.AoT));
        arrayList.add(Long.valueOf(this.AoU));
        arrayList.add(Integer.valueOf(this.AoV));
        arrayList.add(Integer.valueOf(this.AoW));
        arrayList.add(Integer.valueOf(this.AoX));
        arrayList.add(Long.valueOf(this.AoY));
        arrayList.add(Long.valueOf(this.sww));
        arrayList.add(Long.valueOf(this.nET));
        arrayList.add(Integer.valueOf(this.swB));
        arrayList.add(Integer.valueOf(this.swC));
        arrayList.add(Integer.valueOf(this.netType));
        arrayList.add(Integer.valueOf(this.AoZ));
        arrayList.add(Integer.valueOf(this.Apa));
        arrayList.add(this.Apb);
        arrayList.add(this.deviceModel);
        arrayList.add(Integer.valueOf(this.Apc));
        arrayList.add(this.swH);
        TalkRoom abU = c.cHH().abU(this.groupId);
        if (abU == null) {
            i = 0;
        } else {
            i = abU.AmX.size();
            c.d("TalkRoomManager", new Object[]{"getGroupMemberSize groupid: ", r3, " size: ", Integer.valueOf(i)});
        }
        arrayList.add(Integer.valueOf(i));
        arrayList.add(this.Apd.toString());
        arrayList.add(Integer.valueOf(this.soC));
        arrayList.add(Integer.valueOf(this.sov));
        arrayList.add(Integer.valueOf(this.sor));
        arrayList.add(Integer.valueOf(this.sos));
        String a = g.a(arrayList, ",", "_");
        c.d(TAG, new Object[]{"logBuf: ", this.Apd.toString()});
        c.d(TAG, new Object[]{"statresult", a});
        return a;
    }

    public static void a(String str, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            c.m(TAG, new Object[]{"uploadTempReport groupId is null"});
            return;
        }
        c.m(TAG, new Object[]{"uploadTempReport: ", str, Integer.valueOf(i), Long.valueOf(j)});
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.nDx = i;
        hVar.nDy = j;
        hVar.Q(strArr);
        acc(hVar.cHZ());
    }

    public static void a(String str, String str2, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            c.m(TAG, new Object[]{"uploadTempReport groupId and clientGroupId is null"});
            return;
        }
        c.m(TAG, new Object[]{"uploadTempReport: ", str, " clientGroupId: ", str2, " roomid: ", Integer.valueOf(i), Long.valueOf(j)});
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.nDx = i;
        hVar.nDy = j;
        if (str2 == null) {
            str2 = "";
        }
        hVar.zMM = str2;
        hVar.Q(strArr);
        acc(hVar.cHZ());
        f.cCU();
    }

    public static void a(int i, long j, String... strArr) {
        h hVar = new h();
        hVar.groupId = "";
        hVar.nDx = i;
        hVar.nDy = j;
        hVar.zMM = "";
        hVar.Q(strArr);
        acc(hVar.cHZ());
        f.cCU();
    }

    public final void Q(String... strArr) {
        int i = 0;
        if (strArr != null && strArr.length != 0) {
            if (this.Apd.length() > 900) {
                this.Apd.setLength(0);
                this.Apd.append("overmaxsize");
            }
            if (this.Apd.length() != 0) {
                this.Apd.append("-");
            }
            int length = strArr.length;
            while (i < length) {
                this.Apd.append(strArr[i]);
                this.Apd.append("|");
                i++;
            }
        }
    }

    public final void cIa() {
        this.Ape = System.currentTimeMillis();
        c.d(TAG, new Object[]{"beginCreateOrEnter", Long.valueOf(this.Ape)});
    }

    public final void cIb() {
        c.m(TAG, new Object[]{"beginCreateOrNotify"});
        this.Apf = System.currentTimeMillis();
    }

    public static void Jd(int i) {
        c.d(TAG, new Object[]{"sendNetSceneStat", Integer.valueOf(i)});
        f.w(527, 3, String.valueOf(i));
    }

    public static void Je(int i) {
        c.d(TAG, new Object[]{"sendDeviceStat", Integer.valueOf(i)});
        f.w(528, 3, String.valueOf(i));
    }

    public static void Jf(int i) {
        c.d(TAG, new Object[]{"sendtalkRoomDialStat", Integer.valueOf(i)});
        f.w(530, 3, String.valueOf(i));
    }

    public static void cIc() {
        c.d(TAG, new Object[]{"sendTalkRoomOnDialStat", Integer.valueOf(-5001)});
        f.w(531, 3, "-5001");
    }

    public static void Jg(int i) {
        c.d(TAG, new Object[]{"sendEngineStat", Integer.valueOf(i)});
        f.w(529, 3, String.valueOf(i));
    }

    public static void acc(String str) {
        c.d(TAG, new Object[]{"sendSummaryNetScene", str});
        f.w(532, 3, str);
    }

    public static void acd(String str) {
        c.d(TAG, new Object[]{"sendEngineRecv", str});
        f.w(533, 3, str);
    }

    public static void ace(String str) {
        c.d(TAG, new Object[]{"sendEngineSend", str});
        f.w(534, 3, str);
    }

    public static void acf(String str) {
        c.d(TAG, new Object[]{"sendChannelStat", str});
        f.w(535, 3, str);
    }

    public final void Jh(int i) {
        c.d(TAG, new Object[]{"stopStatus", Integer.valueOf(i)});
        this.swo = i;
    }
}
