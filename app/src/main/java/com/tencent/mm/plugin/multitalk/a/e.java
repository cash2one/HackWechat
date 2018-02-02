package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.k.f;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.am;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.pb.common.b.a.a$aa;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public final class e implements a {
    private long hKV = 0;
    b hXN;
    private Timer jwk;
    public boolean kTc;
    private boolean nCg;
    public h nDg;
    boolean oGc;
    public boolean oGd;
    int oGe;
    public boolean oGf = true;
    public HashSet<String> oGg = new HashSet();
    public com.tencent.mm.plugin.multitalk.ui.widget.e oGh = com.tencent.mm.plugin.multitalk.ui.widget.e.oIw;
    public MultiTalkGroup oGi = null;
    private k oGj;
    public int oGk = 0;
    private int oGl = 0;
    private int oGm = 2;
    private boolean oGn = false;
    private long oGo = 0;
    private long oGp = 30000;
    public a oGq;
    i.a oGr;
    public boolean oGs;
    MultiTalkGroup oGt = null;
    long oGu = 0;
    ak oGv = new ak(Looper.getMainLooper(), new 10(this), true);
    af oGw = new af(Looper.getMainLooper());
    BroadcastReceiver oGx = new 2(this);
    c oGy = new 4(this);

    public e() {
        com.tencent.mm.sdk.b.a.xef.b(this.oGy);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
        intentFilter.addAction("android.intent.action.PHONE_STATE2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
        intentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ac.getContext().registerReceiver(this.oGx, intentFilter);
        this.nDg = new h(ac.getContext());
        this.hXN = new b(ac.getContext());
        this.oGs = false;
    }

    public final boolean bcr() {
        i.bcM();
        return i.th(this.oGe);
    }

    public final boolean bcs() {
        i.bcM();
        return i.ti(this.oGe);
    }

    public final boolean bct() {
        boolean z;
        if (this.oGh == com.tencent.mm.plugin.multitalk.ui.widget.e.oIw || this.oGi == null) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final boolean bcu() {
        boolean z;
        if (this.oGh == com.tencent.mm.plugin.multitalk.ui.widget.e.oIz || this.oGh == com.tencent.mm.plugin.multitalk.ui.widget.e.oIA) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final boolean bcv() {
        boolean z;
        if (this.oGh == com.tencent.mm.plugin.multitalk.ui.widget.e.oIA) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final long bcw() {
        return System.currentTimeMillis() - this.hKV;
    }

    private boolean a(MultiTalkGroup multiTalkGroup) {
        if (!bct()) {
            x.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[]{i.h(multiTalkGroup)});
            this.oGi = multiTalkGroup;
            this.oGk = 0;
            this.oGe = 1;
            this.oGg.clear();
            bcx();
            sort();
            return true;
        } else if (i.a(multiTalkGroup, this.oGi)) {
            x.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[]{i.h(multiTalkGroup)});
            MultiTalkGroup multiTalkGroup2 = this.oGi;
            HashMap hashMap = new HashMap();
            for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.zQu) {
                hashMap.put(multiTalkGroupMember.zQv, multiTalkGroupMember);
            }
            for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup2.zQu) {
                if (!q.FS().equals(multiTalkGroupMember2.zQv) && q.FS().equals(multiTalkGroupMember2.zQw) && multiTalkGroupMember2.status == 1) {
                    if (!hashMap.containsKey(multiTalkGroupMember2.zQv) || ((MultiTalkGroupMember) hashMap.get(multiTalkGroupMember2.zQv)).status == 20) {
                        String str = multiTalkGroupMember2.zQv;
                        Toast.makeText(ac.getContext(), i.a(ac.getContext(), ac.getContext().getString(R.l.ewE, new Object[]{r.gu(str)})), 0).show();
                    }
                }
            }
            this.oGi = multiTalkGroup;
            bcx();
            sort();
            return true;
        } else {
            x.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[]{i.h(this.oGi), i.h(multiTalkGroup)});
            return false;
        }
    }

    private void sort() {
        x.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[]{this.oGi.zQu});
        List linkedList = new LinkedList();
        Object obj = null;
        for (MultiTalkGroupMember multiTalkGroupMember : this.oGi.zQu) {
            if (multiTalkGroupMember.zQv.equals(q.FS())) {
                obj = multiTalkGroupMember;
            } else {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Collections.sort(linkedList, new 1(this));
        Collections.sort(linkedList, new 7(this));
        Collections.sort(linkedList, new 8(this));
        if (obj != null) {
            linkedList.add(obj);
        }
        this.oGi.zQu = linkedList;
        x.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[]{this.oGi.zQu});
    }

    private void bcx() {
        for (MultiTalkGroupMember multiTalkGroupMember : this.oGi.zQu) {
            if (multiTalkGroupMember.status != 10 && this.oGg.remove(multiTalkGroupMember.zQv)) {
                x.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[]{multiTalkGroupMember.zQv});
            }
        }
    }

    public final void a(Activity activity, String str, String str2) {
        String str3 = "MicroMsg.MT.MultiTalkManager";
        String str4 = "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.kTc);
        objArr[1] = Boolean.valueOf(this.oGd);
        objArr[2] = Boolean.valueOf(this.oGf);
        objArr[3] = this.oGh.toString();
        objArr[4] = Boolean.valueOf(this.oGi == null);
        x.i(str3, str4, objArr);
        d.bcf();
        if (bcF()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.ept, R.l.dGO);
        } else if (d.bIp()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.epx, R.l.dGO);
        } else if (d.bIq()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.epw, R.l.dGO);
        } else if (com.tencent.mm.au.a.Qk()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.eps, R.l.dGO);
        } else if (d.bIr()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.epv, R.l.dGO);
        } else if (bct()) {
            com.tencent.mm.au.a.a(activity, R.l.ewo, null);
        } else if (!this.oGn || System.currentTimeMillis() - this.oGo >= this.oGp) {
            this.oGn = false;
            List<String> F = bh.F(str.split(","));
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.zQr = o.bcU().oFQ.cCY();
            multiTalkGroup.zQs = str2;
            for (String str5 : F) {
                MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                multiTalkGroupMember.zQv = str5;
                if (str5.equals(q.FS())) {
                    multiTalkGroupMember.status = 10;
                } else {
                    multiTalkGroupMember.status = 1;
                }
                multiTalkGroup.zQu.add(multiTalkGroupMember);
            }
            o.bcU().oFQ.ba(bh.e((Integer) ar.He().get(1)), q.FS());
            if (o.bcU().oFQ.e(multiTalkGroup.zQr, str2, F)) {
                d.bcd();
            } else {
                d.bce();
            }
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.oIy);
            c(multiTalkGroup);
        } else {
            com.tencent.mm.au.a.a(activity, R.l.ewx, null);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        int i = 4;
        x.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(false), Boolean.valueOf(z3)});
        o.bcV().stopRing();
        if (bct()) {
            com.tencent.mm.sdk.b.b mwVar = new mw();
            mwVar.fEU.type = 2;
            com.tencent.mm.sdk.b.a.xef.m(mwVar);
            String l = i.l(this.oGi);
            d.Fo(l);
            if (this.oGh != com.tencent.mm.plugin.multitalk.ui.widget.e.oIA) {
                boolean k = i.k(this.oGi);
                long bcw = bcw();
                if (!k) {
                    i = z2 ? bcw >= 45 ? 6 : 8 : z ? 7 : z3 ? 10 : 0;
                } else if (!z2) {
                    i = z ? 1 : z3 ? 5 : 2;
                }
                d.a(k, bcw, l, i);
            } else {
                d.te(this.oGk);
                d.m((long) this.oGk, l);
            }
            com.tencent.mm.plugin.multitalk.ui.widget.e eVar = this.oGh;
            if (this.oGq != null) {
                this.oGq.bbQ();
            }
            this.oGh = com.tencent.mm.plugin.multitalk.ui.widget.e.oIw;
            bcE();
            aSZ();
            ajJ();
            o.bcT().reset();
            o.bcW().bcP();
            if (this.oGi != null) {
                a(this.oGi, eVar, z2);
                String str = this.oGi.zQq;
                if (bh.ov(str)) {
                    str = this.oGi.zQr;
                }
                o.bcU().oFQ.Fy(str);
                this.oGi = null;
            }
            this.oGe = 0;
            this.oGd = true;
            this.kTc = false;
            this.oGf = true;
            this.hKV = 0;
            this.oGk = 0;
            this.oGg.clear();
            this.oGl = 0;
            return;
        }
        bcE();
        aSZ();
        ajJ();
        this.oGi = null;
        this.oGe = 0;
        this.hKV = 0;
        this.oGk = 0;
        this.oGg.clear();
        this.oGh = com.tencent.mm.plugin.multitalk.ui.widget.e.oIw;
        this.oGl = 0;
    }

    public final void b(String str, String str2, boolean z, boolean z2) {
        if (!m.gc(str)) {
            x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{str});
            com.tencent.mm.z.ak.a.hfL.a(str, "", new 9(this));
        }
        au auVar = new au();
        auVar.setType(64);
        auVar.aq(System.currentTimeMillis());
        auVar.eQ(6);
        auVar.eR(2);
        String gu = r.gu(str2);
        if (!(gu == null || gu.equals(""))) {
            str2 = gu;
        }
        gu = str2 + ac.getContext().getString(R.l.ewH);
        auVar.setContent(gu);
        if (m.gd(str)) {
            auVar.dS(str);
            ar.Hg();
            com.tencent.mm.z.c.Fa().Q(auVar);
            ar.Hg();
            aj WY = com.tencent.mm.z.c.Fd().WY(str);
            if (WY != null) {
                if (z) {
                    WY.eO(WY.field_unReadCount + 1);
                }
                WY.setContent(gu);
                ar.Hg();
                if (com.tencent.mm.z.c.Fd().a(WY, str) == -1) {
                    x.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :" + str);
                }
                if (z2) {
                    ((am) ar.getNotification()).a(auVar);
                    return;
                }
                return;
            }
            ae aeVar = new ae();
            aeVar.setUsername(str);
            if (z) {
                aeVar.eO(1);
            }
            aeVar.setContent(gu);
            ar.Hg();
            com.tencent.mm.z.c.Fd().d(aeVar);
            if (z2) {
                ((am) ar.getNotification()).a(auVar);
            }
        }
    }

    public static void Fp(String str) {
        x.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        cf auVar = new au();
        auVar.setType(64);
        auVar.aq(System.currentTimeMillis());
        auVar.eQ(6);
        auVar.setContent(ac.getContext().getString(R.l.ewJ));
        if (m.gd(str)) {
            auVar.dS(str);
            auVar.setContent(auVar.field_content);
            ar.Hg();
            com.tencent.mm.z.c.Fa().Q(auVar);
        }
    }

    private static void a(MultiTalkGroup multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e eVar, boolean z) {
        x.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.oIx && z) {
            cf auVar = new au();
            auVar.setType(64);
            auVar.aq(System.currentTimeMillis());
            auVar.eQ(6);
            auVar.setContent(ac.getContext().getString(R.l.ewJ));
            if (m.gd(multiTalkGroup.zQs)) {
                auVar.dS(multiTalkGroup.zQs);
                auVar.setContent(auVar.field_content);
                ar.Hg();
                com.tencent.mm.z.c.Fa().Q(auVar);
            }
        }
    }

    public final void g(int i, Object obj) {
        int i2;
        x.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[]{Integer.valueOf(i)});
        ar.Hg();
        com.tencent.mm.z.c.CU().a(w.a.xxH, Integer.valueOf(-1));
        ar.Hg();
        com.tencent.mm.z.c.CU().a(w.a.xxI, Long.valueOf(-1));
        switch (i) {
            case -14256:
                x.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
                i2 = R.l.ewf;
                if (!(obj == null || ((a$aa) obj) == null)) {
                    com.tencent.wecall.talkroom.model.a.cHv().nY(false);
                    break;
                }
            case -14255:
                String str = "MicroMsg.MT.MultiTalkManager";
                String str2 = "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = this.oGi;
                objArr[2] = this.oGi != null ? this.oGi.zQs : "";
                x.i(str, str2, objArr);
                if (obj != null) {
                    a$aa com_tencent_pb_common_b_a_a_aa = (a$aa) obj;
                    if (com_tencent_pb_common_b_a_a_aa != null) {
                        x.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + com_tencent_pb_common_b_a_a_aa.groupId);
                        if (com_tencent_pb_common_b_a_a_aa.zMO != null) {
                            o.bcX().FA(com_tencent_pb_common_b_a_a_aa.zMO.zPg);
                            x.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + com_tencent_pb_common_b_a_a_aa.zMO.zPg);
                        }
                        if (!o.bcU().oFQ.Fy(com_tencent_pb_common_b_a_a_aa.groupId)) {
                            x.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + com_tencent_pb_common_b_a_a_aa.groupId);
                        }
                    }
                }
                i2 = R.l.ewF;
                break;
            case -1700:
                x.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[]{obj});
                Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.evW), 0).show();
                if (obj != null) {
                    i2 = ((Integer) obj).intValue();
                    if (i2 > 0) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.xxH, Integer.valueOf(i2));
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.xxI, Long.valueOf(bh.Wq()));
                    }
                }
                i2 = R.l.evW;
                break;
            case -1400:
                i2 = R.l.ewe;
                break;
            case -1300:
                i2 = R.l.ewd;
                this.oGn = true;
                this.oGo = System.currentTimeMillis();
                if (obj != null) {
                    z zVar = (z) obj;
                    if (zVar != null) {
                        x.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + zVar.zOk);
                        if (zVar.zOk != 0) {
                            this.oGp = (long) (zVar.zOk * 1000);
                            break;
                        }
                    }
                }
                break;
            case -1200:
                i2 = R.l.ewc;
                break;
            case -1100:
                i2 = R.l.ewb;
                break;
            case DownloadResult.CODE_UNDEFINED /*-1000*/:
                i2 = R.l.ewa;
                break;
            case -900:
                i2 = R.l.ewn;
                break;
            case -800:
                i2 = R.l.ewm;
                break;
            case -700:
                i2 = R.l.ewl;
                break;
            case -600:
                i2 = R.l.ewk;
                break;
            case -500:
                i2 = R.l.ewj;
                break;
            case -400:
                i2 = R.l.ewi;
                break;
            case -300:
                i2 = R.l.ewh;
                break;
            case -200:
                d.gQ(false);
                i2 = R.l.ewg;
                break;
            case -100:
                d.gP(false);
                i2 = R.l.evZ;
                break;
            default:
                i2 = R.l.ewk;
                break;
        }
        if (this.oGq != null) {
            this.oGq.onError(i);
        }
        if (i != -800 && i != -500 && i != -1700) {
            Toast.makeText(ac.getContext(), ac.getContext().getString(i2), 0).show();
            c(false, false, true);
        }
    }

    public final void b(final MultiTalkGroup multiTalkGroup) {
        String str = "MicroMsg.MT.MultiTalkManager";
        String str2 = "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.kTc);
        objArr[1] = Boolean.valueOf(this.oGd);
        objArr[2] = Boolean.valueOf(this.oGf);
        objArr[3] = this.oGh.toString();
        objArr[4] = Boolean.valueOf(this.oGi == null);
        x.i(str, str2, objArr);
        d.bcg();
        if (f.zp() || df(ac.getContext())) {
            int i;
            boolean z;
            str = i.m(multiTalkGroup);
            ar.Hg();
            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str);
            if (g.zY().getInt("MultitalkBlockReceiver", 0) == 0) {
                i = 1;
            } else {
                z = false;
            }
            if (i == 0 || WO.AF()) {
                x.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
                ag.h(new 11(this, multiTalkGroup), 1000);
                d.as(3, i.l(multiTalkGroup));
                return;
            }
            if (!(bct() || d.bIq() || d.bIp() || com.tencent.mm.au.a.Qk())) {
                if (((TelephonyManager) ac.getContext().getSystemService("phone")).getCallState() != 0) {
                    i = 1;
                } else {
                    z = false;
                }
                if (i == 0 && !d.bIr() && com.tencent.mm.l.a.fZ(WO.field_type)) {
                    if (!m.gc(multiTalkGroup.zQs)) {
                        x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{multiTalkGroup.zQs});
                        com.tencent.mm.z.ak.a.hfL.a(multiTalkGroup.zQs, "", null);
                    }
                    x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
                    b(com.tencent.mm.plugin.multitalk.ui.widget.e.oIx);
                    d.as(1, i.l(multiTalkGroup));
                    if (com.tencent.mm.l.a.fZ(WO.field_type)) {
                        x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[]{str, q.FS()});
                        c(multiTalkGroup);
                        return;
                    }
                    x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[]{str, q.FS()});
                    if (a(multiTalkGroup)) {
                        this.oGc = false;
                        bcy();
                        aTb();
                        return;
                    }
                    return;
                }
            }
            x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[]{i.h(multiTalkGroup)});
            if (!m.gc(multiTalkGroup.zQs)) {
                x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{multiTalkGroup.zQs});
                com.tencent.mm.z.ak.a.hfL.a(multiTalkGroup.zQs, "", new 12(this));
            }
            ag.h(new Runnable(this) {
                final /* synthetic */ e oGz;

                public final void run() {
                    String str = multiTalkGroup.zQq;
                    if (bh.ov(str)) {
                        str = multiTalkGroup.zQr;
                    }
                    o.bcU().oFQ.Fy(str);
                }
            }, 1000);
            d.as(3, i.l(multiTalkGroup));
            return;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.oGt == null && this.oGv.cfK()) {
            this.oGt = multiTalkGroup;
            this.oGv.J(2000, 2000);
            this.oGu = System.currentTimeMillis();
            com.tencent.mm.plugin.report.service.g.pQN.a(500, 6, 1, false);
        }
    }

    private void c(MultiTalkGroup multiTalkGroup) {
        x.k("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
        if (a(multiTalkGroup)) {
            this.oGc = false;
            bcy();
            aTb();
            com.tencent.mm.bm.d.b(ac.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        }
    }

    private void bcy() {
        e eVar;
        boolean z;
        e eVar2;
        if (this.oGh == com.tencent.mm.plugin.multitalk.ui.widget.e.oIy) {
            eVar = this;
        } else if (ar.Hh().xR() || ar.Hh().xL()) {
            eVar = this;
        } else {
            z = true;
            eVar2 = this;
            eVar2.oGd = z;
            this.kTc = false;
            this.oGr = i.bcN();
        }
        eVar2 = eVar;
        z = false;
        eVar2.oGd = z;
        this.kTc = false;
        this.oGr = i.bcN();
    }

    public final void d(MultiTalkGroup multiTalkGroup) {
        d.as(2, i.l(multiTalkGroup));
        a(multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e.oIx, true);
    }

    public final void e(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
        d.gP(true);
        if (a(multiTalkGroup)) {
            bcz();
        }
    }

    public final void f(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
        com.tencent.mm.sdk.b.b mwVar = new mw();
        mwVar.fEU.type = 1;
        com.tencent.mm.sdk.b.a.xef.m(mwVar);
        d.gQ(true);
        if (this.oGh != com.tencent.mm.plugin.multitalk.ui.widget.e.oIx) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.oIz);
            c(multiTalkGroup);
        }
        if (bct() && a(multiTalkGroup)) {
            bcz();
        }
    }

    private void bcz() {
        if (i.i(this.oGi)) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.oIA);
        } else {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.oIz);
        }
        if (this.oGq != null) {
            this.oGq.aYX();
            i.a bcN = i.bcN();
            if (bcN != this.oGr) {
                this.oGr = bcN;
                return;
            }
            return;
        }
        com.tencent.mm.bm.d.b(ac.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[]{i.h(multiTalkGroup)});
        if (!bct() || !a(multiTalkGroup)) {
            return;
        }
        if (i.j(this.oGi)) {
            if (this.oGh != com.tencent.mm.plugin.multitalk.ui.widget.e.oIA && i.i(multiTalkGroup)) {
                b(com.tencent.mm.plugin.multitalk.ui.widget.e.oIA);
            }
            if (this.oGq != null && i.c(this.oGh)) {
                this.oGq.bbR();
            }
        } else if (this.oGh == com.tencent.mm.plugin.multitalk.ui.widget.e.oIx) {
            c(false, true, false);
        } else {
            c(false, false, false);
        }
    }

    public final void bcA() {
        x.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    }

    public final void gM(boolean z) {
        this.kTc = z;
        if (this.oGq != null) {
            this.oGq.gM(this.kTc);
        }
    }

    public final void bcB() {
        x.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[]{Integer.valueOf(this.oGe)});
    }

    public final void bcC() {
        x.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    }

    public final void tf(int i) {
        x.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: " + i);
        if (i > 0) {
            this.oGs = true;
        } else {
            this.oGs = false;
        }
    }

    public final void bi(List<com.tencent.pb.common.b.a.a.am> list) {
        if (bct()) {
            this.oGg.clear();
            x.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[]{list});
            for (com.tencent.pb.common.b.a.a.am amVar : list) {
                if (amVar.zOD == 2 || amVar.zOD == 3) {
                    this.oGg.add(amVar.zOC);
                }
            }
            this.oGg.remove(q.FS());
            x.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[]{this.oGg});
            if (this.oGj != null) {
                this.oGj.tj(this.oGg.size());
            }
            if (this.oGq != null) {
                this.oGq.bbS();
            }
        }
    }

    public final void gR(boolean z) {
        if (bct() && !this.nCg) {
            this.nCg = true;
            d.d(i.bcK(), o.bcV().bcr(), z);
            Toast.makeText(ac.getContext(), R.l.ewv, 0).show();
            CharSequence string = ac.getContext().getString(R.l.evT);
            CharSequence string2 = ac.getContext().getString(R.l.ewy);
            Intent intent = new Intent();
            intent.setClass(ac.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(ac.getContext(), 43, intent, 134217728);
            int i = R.g.bEq;
            if (com.tencent.mm.compatible.util.d.fN(19)) {
                i = R.g.bEp;
            }
            Notification a = d.a(new Builder(ac.getContext()).setTicker(string2).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(string2).setContentIntent(activity));
            a.icon = i;
            a.flags |= 32;
            ar.getNotification().a(43, a, false);
            if (this.oGq != null) {
                this.oGq.aTg();
            }
            ag.y(new 14(this));
        }
    }

    public final void aSZ() {
        this.nCg = false;
        com.tencent.mm.plugin.voip.model.d.bGk().dismiss();
        ((NotificationManager) ac.getContext().getSystemService("notification")).cancel(43);
    }

    public final void bcD() {
        x.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
        if (this.oGq == null) {
            x.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
        } else if (this.oGg.size() == 0) {
            x.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
        } else {
            if (this.oGj == null) {
                x.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", new Object[]{Integer.valueOf(this.oGg.size())});
                this.oGj = new k(this.oGq);
                this.oGj.tj(this.oGg.size());
            }
            if (!this.oGj.flS) {
                this.oGj.start();
            }
        }
    }

    public final void bcE() {
        x.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
        if (this.oGj != null) {
            this.oGj.stop();
            this.oGj = null;
        }
    }

    public final void gS(boolean z) {
        o.bcU().oFQ.gS(z);
        x.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[]{Boolean.valueOf(z)});
        this.oGd = z;
        if (this.oGq != null) {
            this.oGq.gN(this.oGd);
        }
    }

    public final boolean tg(int i) {
        if (!bcu()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + i);
        boolean tg = o.bcU().oFQ.tg(i);
        x.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[]{Boolean.valueOf(tg)});
        int i2 = this.oGe;
        this.oGe = i;
        if (bcs()) {
            bcD();
        } else {
            bcE();
        }
        if (this.oGq == null || i2 == this.oGe) {
            return tg;
        }
        this.oGq.cQ(i2, this.oGe);
        return tg;
    }

    public final boolean Fq(String str) {
        if (!bcu()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : " + str);
        boolean Fq = o.bcU().oFQ.Fq(str);
        x.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: " + Fq);
        return Fq;
    }

    private void b(com.tencent.mm.plugin.multitalk.ui.widget.e eVar) {
        boolean z = true;
        com.tencent.mm.plugin.multitalk.ui.widget.e eVar2 = this.oGh;
        this.oGh = eVar;
        if (eVar2 != eVar) {
            if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.oIA) {
                com.tencent.mm.sdk.b.b mwVar = new mw();
                mwVar.fEU.type = 1;
                com.tencent.mm.sdk.b.a.xef.m(mwVar);
                d.a(i.k(this.oGi), bcw(), i.l(this.oGi));
                o.bcV().stopRing();
                if (ar.Hh().xR() || ar.Hh().xL()) {
                    z = false;
                }
                gS(z);
            }
            if (this.oGq != null) {
                this.oGq.a(eVar);
            }
        }
    }

    private void aTb() {
        x.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
        if (this.jwk != null) {
            this.jwk.cancel();
            return;
        }
        this.hKV = System.currentTimeMillis();
        this.oGk = 0;
        this.jwk = new Timer();
        this.jwk.schedule(new 3(this), 1000, 1000);
    }

    private void ajJ() {
        if (this.jwk != null) {
            this.jwk.cancel();
            this.jwk = null;
        }
    }

    public final void gT(boolean z) {
        if (!this.oGc) {
            this.nDg.m(R.k.dAk, 0, z);
            this.hXN.requestFocus();
            this.oGc = true;
        }
    }

    public final void stopRing() {
        com.tencent.mm.sdk.f.e.post(new 5(this), "MultiTalkManager_stop_ring");
    }

    private static boolean bcF() {
        boolean z;
        Exception e;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ac.getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            switch (telephonyManager.getCallState()) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            try {
                x.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[]{Integer.valueOf(r2)});
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            x.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[]{e.getLocalizedMessage()});
            return z;
        }
    }

    static boolean df(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            x.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                x.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ac.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
        return true;
    }
}
