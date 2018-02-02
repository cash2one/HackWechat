package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public final class i {
    public static final float[][] oGO;

    static {
        r0 = new float[6][];
        oGO = r0;
        r0[0] = null;
        oGO[1] = new float[]{0.5f, 0.5f};
        oGO[2] = new float[]{0.0f, 0.5f, 1.0f, 0.5f};
        oGO[3] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.5f, 1.0f};
        oGO[4] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        oGO[5] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 2.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 2.0f, 1.0f, 0.0f, 2.0f, 1.0f, 2.0f, 2.0f, 2.0f};
    }

    public static String h(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<MultiTalkGroupMember> list = multiTalkGroup.zQu;
        stringBuffer.append("->[usernamelist]");
        if (list != null) {
            for (MultiTalkGroupMember multiTalkGroupMember : list) {
                stringBuffer.append(multiTalkGroupMember.zQv + "|");
                stringBuffer.append(multiTalkGroupMember.status + ", ");
            }
        }
        stringBuffer.append(" ->createname:" + multiTalkGroup.zQt);
        stringBuffer.append(" ->talkgroupId:" + multiTalkGroup.zQq);
        stringBuffer.append(" ->wxGroupId:" + multiTalkGroup.zQs);
        return stringBuffer.toString();
    }

    public static boolean a(MultiTalkGroup multiTalkGroup, MultiTalkGroup multiTalkGroup2) {
        if (multiTalkGroup == null || multiTalkGroup2 == null) {
            return false;
        }
        if (!bh.ov(multiTalkGroup.zQq) && !bh.ov(multiTalkGroup2.zQq) && multiTalkGroup.zQq.equals(multiTalkGroup2.zQq)) {
            return true;
        }
        if (bh.ov(multiTalkGroup.zQr) || bh.ov(multiTalkGroup2.zQr) || !multiTalkGroup.zQr.equals(multiTalkGroup2.zQr)) {
            return false;
        }
        return true;
    }

    public static boolean i(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.zQu) {
            boolean z3;
            if (multiTalkGroupMember.zQv.equals(q.FS())) {
                if (multiTalkGroupMember.status == 10) {
                    if (z) {
                        return true;
                    }
                    z2 = true;
                }
                z3 = z;
            } else {
                if (multiTalkGroupMember.status == 10) {
                    if (z2) {
                        return true;
                    }
                    z3 = true;
                }
                z3 = z;
            }
            z = z3;
        }
        return false;
    }

    public static boolean j(MultiTalkGroup multiTalkGroup) {
        int i = 0;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.zQu) {
            int i2;
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > 1) {
            return true;
        }
        return false;
    }

    public static boolean c(e eVar) {
        if (eVar == e.Starting || eVar == e.Talking || eVar == e.Inviting) {
            return true;
        }
        return false;
    }

    public static boolean k(MultiTalkGroup multiTalkGroup) {
        return multiTalkGroup.zQt.equals(q.FS());
    }

    public static String l(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return "";
        }
        String str = multiTalkGroup.zQq;
        if (bh.ov(str)) {
            str = multiTalkGroup.zQr;
        }
        return bh.az(str, "");
    }

    public static String bcK() {
        return l(o.bcV().oGi);
    }

    public static String m(MultiTalkGroup multiTalkGroup) {
        String str = null;
        int i = 0;
        while (i < multiTalkGroup.zQu.size()) {
            String str2;
            if (((MultiTalkGroupMember) multiTalkGroup.zQu.get(i)).zQv.equals(q.FS())) {
                str2 = ((MultiTalkGroupMember) multiTalkGroup.zQu.get(i)).zQw;
            } else {
                str2 = str;
            }
            i++;
            str = str2;
        }
        return str;
    }

    public static String bcL() {
        return m(o.bcV().oGi);
    }

    public static boolean bcM() {
        return false;
    }

    public static int q(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("state");
            if (stringExtra != null) {
                if (stringExtra.equals("IDLE")) {
                    return 0;
                }
                if (stringExtra.equals("RINGING")) {
                    return 1;
                }
                if (stringExtra.equals("OFFHOOK")) {
                    return 2;
                }
            }
        }
        return ((TelephonyManager) context.getSystemService("phone")).getCallState();
    }

    public static boolean th(int i) {
        return i == 2 || i == 3;
    }

    public static boolean ti(int i) {
        return i == 1 || i == 3;
    }

    public static a bcN() {
        if (an.isWifi(ac.getContext())) {
            return a.oGP;
        }
        if (an.is4G(ac.getContext())) {
            return a.oGQ;
        }
        if (an.is3G(ac.getContext()) || an.is2G(ac.getContext())) {
            return a.oGR;
        }
        return a.oGS;
    }

    public static boolean bcO() {
        ar.Hg();
        int intValue = ((Integer) c.CU().get(a.xxH, Integer.valueOf(-1))).intValue();
        ar.Hg();
        long longValue = ((Long) c.CU().get(a.xxI, Long.valueOf(-1))).longValue();
        if (intValue <= 0 || longValue <= 0) {
            ar.Hg();
            c.CU().a(a.xxH, Integer.valueOf(-1));
            ar.Hg();
            c.CU().a(a.xxI, Long.valueOf(-1));
            return true;
        }
        x.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[]{Integer.valueOf(intValue), Long.valueOf(longValue)});
        if (bh.bA(longValue) <= ((long) (intValue * 1000))) {
            return false;
        }
        ar.Hg();
        c.CU().a(a.xxH, Integer.valueOf(-1));
        ar.Hg();
        c.CU().a(a.xxI, Long.valueOf(-1));
        return true;
    }
}
