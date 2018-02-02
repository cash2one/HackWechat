package com.tencent.mm.network;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.f.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class t extends a implements a$a, e {
    byte[] gPQ;
    int hNB = 0;
    int hZF = 0;
    private long hZG = 0;
    private long hZH = 0;
    private long hZI = 0;
    private WakerLock hZJ = null;
    public a hZK;
    a hZL;
    b hZM;
    long hZN = 0;
    int hZO = -1;
    private s hZP;
    private s hZQ;
    g hZR;
    h hZS;
    public af handler;

    class AnonymousClass12 extends bc<Object> {
        final /* synthetic */ t hZT;
        final /* synthetic */ String ial;
        final /* synthetic */ String ian;

        public AnonymousClass12(t tVar, String str, String str2) {
            this.hZT = tVar;
            this.ian = str;
            this.ial = str2;
            super(1000, null);
        }

        protected final Object run() {
            StnLogic.setDebugIP(this.ian, this.ial);
            return null;
        }
    }

    static /* synthetic */ int a(t tVar, r rVar, l lVar) {
        int i = 1;
        x.i("MicroMsg.AutoAuth", "dkcgi sendImp rr.type:%d callback:%d", new Object[]{Integer.valueOf(rVar.getType()), Integer.valueOf(lVar.hashCode())});
        switch (rVar.getType()) {
            case 126:
                rVar.getType();
                c aVar = new a(tVar);
                aVar.setUsername(rVar.KI().getUserName());
                i = aa.VR().a(rVar, lVar, aVar, 0);
                if (i < 0) {
                    x.e("MicroMsg.AutoAuth", "register: net.send err");
                    return i;
                }
                x.i("MicroMsg.AutoAuth", "register: netid=" + i);
                return i;
            case 701:
                if (aa.VR().VE()) {
                    return -1;
                }
                g KI = rVar.KI();
                c aVar2 = new a(tVar);
                aVar2.setUsername(KI.getUserName());
                i = aa.VR().a(rVar, lVar, aVar2, 0);
                if (i < 0) {
                    x.e("MicroMsg.AutoAuth", "auth: net.send err");
                    return i;
                }
                x.i("MicroMsg.AutoAuth", "auth: netid=" + i);
                return i;
            default:
                rVar.KI().eE(tVar.hZK.Cg());
                z VR = aa.VR();
                c cVar = tVar.hZK;
                if (!rVar.Kc()) {
                    i = 0;
                }
                i = VR.a(rVar, lVar, cVar, i);
                if (i >= 0) {
                    return i;
                }
                x.e("MicroMsg.AutoAuth", "nonauth: in queue err");
                return i;
        }
    }

    static /* synthetic */ void a(t tVar) {
        tVar.hZF = 0;
        tVar.hZG = 0;
        tVar.hZH = 0;
        aa.VR().reset();
    }

    static /* synthetic */ void a(t tVar, r rVar) {
        x.d("MicroMsg.AutoAuth", "dkcert doGetCert");
        if (60000 >= SystemClock.elapsedRealtime() - tVar.hZN) {
            x.w("MicroMsg.AutoAuth", "getcert lastGetCertSucTime=%d, curtime=%d", new Object[]{Long.valueOf(tVar.hZN), Long.valueOf(SystemClock.elapsedRealtime())});
            tVar.d(3, -1, "");
        } else if (aa.VR().a(rVar, tVar.hZM, tVar.hZK, 0) < 0) {
            tVar.d(3, -1, "");
        }
    }

    static /* synthetic */ void a(t tVar, r rVar, String str) {
        x.d("MicroMsg.AutoAuth", "account info updated:" + tVar.hZK);
        x.i("MicroMsg.AutoAuth", "oreh doAutoAuth ticket:%s, login:%b", new Object[]{str, Boolean.valueOf(tVar.hZK.Kt())});
        x.cfk();
        if (!tVar.hZK.Kt() && !aa.VR().VE() && aa.VR().a(rVar, tVar.hZL, tVar.hZK, 1) < 0) {
            tVar.d(3, -1, "");
        }
    }

    static /* synthetic */ void iQ(int i) {
        int i2 = 0;
        x.i("MicroMsg.AutoAuth", "cancel: netid=" + i);
        if (i < 0) {
            x.e("MicroMsg.AutoAuth", "error netid < 0, " + i);
            return;
        }
        z VR = aa.VR();
        x.i("MicroMsg.MMNativeNetTaskAdapter", "stopTask netId=" + i);
        if (i >= 0 && i < 100) {
            synchronized (VR.iaF) {
                if (VR.iaF[i] != null) {
                    i2 = VR.iaF[i].taskId;
                }
            }
            if (i2 != 0) {
                StnLogic.stopTask(i2);
            }
            synchronized (VR.iaF) {
                if (VR.iaF[i] != null) {
                    try {
                        x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi stopTask outQueue: netId:%d hash:%d type:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(VR.iaF[i].iaJ.getType()), Integer.valueOf(VR.iaF[i].iaJ.Kh())});
                        VR.iaF[i] = null;
                    } catch (Throwable e) {
                        x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                    }
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ c Kx() {
        return this.hZK;
    }

    public final /* bridge */ /* synthetic */ d Vo() {
        return this.hZK;
    }

    public t(af afVar) {
        if (afVar == null) {
            afVar = new af();
        }
        this.handler = afVar;
        this.hZK = new a(this);
        this.hZJ = new WakerLock(aa.getContext());
        this.hZL = new a(this, this.hZJ);
        this.hZM = new b(this, this.hZJ);
        this.hZP = new s(w.gZK + "autoauth.cfg");
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    public final void cancel(int i) {
        this.hZJ.lock(1000, String.format("MMAutoAuth.cancel,%d", new Object[]{Integer.valueOf(i)}));
        new 1(this, i).b(this.handler);
    }

    public final boolean Kn() {
        return this.hZF < 5;
    }

    public final String getNetworkServerIp() {
        return MMLogic.getNetworkServerIp();
    }

    public final String[] getIPsString(boolean z) {
        return MMLogic.getIPsString(z);
    }

    public final void reset() {
        this.hZJ.lock(1000, "MMAutoAuth.reset");
        new 6(this).b(this.handler);
    }

    public final synchronized int a(r rVar, l lVar) {
        this.hZJ.lock(1000, "MMAutoAuth.send");
        return ((Integer) new 7(this, Integer.valueOf(-1), rVar, lVar).b(this.handler)).intValue();
    }

    public final boolean Vu() {
        if (90000 >= SystemClock.elapsedRealtime() - this.hZH) {
            x.w("MicroMsg.AutoAuth", "auto limit lastSessionTimeout=%d, curtime=%d", new Object[]{Long.valueOf(this.hZH), Long.valueOf(SystemClock.elapsedRealtime())});
            return false;
        }
        this.hZH = SystemClock.elapsedRealtime();
        this.hZK.v(new byte[0], this.hZK.Cg());
        return true;
    }

    public final void bE(boolean z) {
        new 8(this, Integer.valueOf(-1), z).b(this.handler);
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        this.hZJ.lock(1000, "MMAutoAuth.setIDCHostInfo");
        List<n> To = n.To(str2);
        List<n> To2 = n.To(str);
        String str5 = "MicroMsg.AutoAuth";
        String str6 = "dkidc setIDCHostInfo short:[%s][%s](%d) long:[%s][%s](%d) reset:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str3;
        objArr[1] = str;
        objArr[2] = Integer.valueOf(To2.size());
        objArr[3] = str4;
        objArr[4] = str2;
        objArr[5] = Integer.valueOf(To.size());
        objArr[6] = z ? "!!!!!CHANGE IDC NOW" : "false";
        x.d(str5, str6, objArr);
        Map hashMap = new HashMap();
        for (n nVar : To) {
            ArrayList arrayList = (ArrayList) hashMap.get(nVar.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(nVar.host, arrayList);
            }
            arrayList.add(nVar.nQt);
        }
        Map hashMap2 = new HashMap();
        for (n nVar2 : To2) {
            arrayList = (ArrayList) hashMap2.get(nVar2.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap2.put(nVar2.host, arrayList);
            }
            arrayList.add(nVar2.nQt);
        }
        new 9(this, Integer.valueOf(-1), hashMap, hashMap2, iArr2, iArr).b(this.handler);
    }

    public final void e(String str, String str2, String str3, String str4) {
        this.hZJ.lock(1000, "MMAutoAuth.setFixedHost");
        x.i("MicroMsg.AutoAuth", "dkidc setFixedHost debug short:%s:%s long:%s:%s", new Object[]{str, str2, str3, str4});
        if (bh.ov(str) || bh.ov(str3)) {
            x.w("MicroMsg.AutoAuth", "dkidc setFixedHost FAILED ! check assist");
        } else {
            new 10(this, Integer.valueOf(-1), str, str2, str3, str4).b(this.handler);
        }
    }

    public final void setNewDnsDebugHost(String str, String str2) {
        if (bh.ov(str) && bh.ov(str2)) {
            x.d("MicroMsg.AutoAuth", "setNewDnsDebugHost FAILED ! check assist");
        } else {
            new 11(this, str, str2).b(this.handler);
        }
    }

    public final void Vp() {
        this.hZJ.lock(1000, "MMAutoAuth.forceUpdateHostCache");
        new 13(this, Integer.valueOf(-1)).b(this.handler);
    }

    public final void jq(String str) {
        this.hZJ.lock(1000, "MMAutoAuth.ipxxStatistics");
        new 2(this, str).b(this.handler);
    }

    public final void a(b bVar) {
        aa.VM().iaW = bVar;
    }

    public final i Vq() {
        return aa.VN();
    }

    final boolean Vv() {
        if (10001 == r.idt && r.idu > 0) {
            r.idu = 0;
            Vu();
        }
        if (this.hZK.Kt()) {
            return true;
        }
        if (aa.VR().VE()) {
            x.i("MicroMsg.AutoAuth", "makeSureAuth hasAuthCmd ret false");
            return false;
        } else if (this.hZO != -1) {
            x.w("MicroMsg.AutoAuth", "makeSureAuth auto limit now is getting cert, ret false");
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (60000 >= elapsedRealtime - this.hZG && this.hZG > 0) {
                x.w("MicroMsg.AutoAuth", "makeSureAuth auto limit lastAutoAuthtime=%d, curtime=%d, return false", new Object[]{Long.valueOf(this.hZG), Long.valueOf(elapsedRealtime)});
                return false;
            } else if (ac.getContext().getSharedPreferences("auth_hold_prefs", 0).getBoolean("auth_ishold", false)) {
                x.i("MicroMsg.AutoAuth", "makeSureAuth AUTH_HOLD_KEY hold ret false");
                if (!aa.VR().VF()) {
                    x.e("MicroMsg.AutoAuth", "sendImp hit push hold, pid:%d, stack[%s]", new Object[]{Integer.valueOf(Process.myPid()), bh.cgy()});
                    aa.VO().post(new 3(this));
                }
                return false;
            } else {
                r ce = aa.VR().ce(Vx());
                if (ce != null) {
                    try {
                        if (!(ce instanceof r.a)) {
                            this.hZG = SystemClock.elapsedRealtime();
                            x.i("MicroMsg.AutoAuth", "makeSureAuth rest lastAutoAuthTime[%d]", new Object[]{Long.valueOf(this.hZG)});
                            a(ce, 3, 3);
                        } else if (30000 < elapsedRealtime - this.hZI || this.hZI <= 0) {
                            x.i("MicroMsg.AutoAuth", "makeSureAuth session time out in push_notify mode, send broast to mm");
                            this.hZI = SystemClock.elapsedRealtime();
                            aa.VS().onPush(5, null);
                        } else {
                            x.i("MicroMsg.AutoAuth", "makeSureAuth session time out in push_notify mode, but hit limit");
                            return false;
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.AutoAuth", "makeSureAuth exception:%s", new Object[]{bh.i(e)});
                    }
                } else {
                    x.i("MicroMsg.AutoAuth", "makeSureAuth getAutoAuthRR is null");
                }
                x.i("MicroMsg.AutoAuth", "makeSureAuth at last ret false");
                return false;
            }
        }
    }

    final void d(int i, int i2, String str) {
        int i3;
        x.i("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail inErrType=" + i + ", inErrCode=" + i2 + ", errMsg=" + str + " stack=" + bh.cgy());
        if (i == 4 && i2 == -106) {
            x.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_BLOCK_BY_SPAM trans to MM_ERR_AUTH_ANOTHERPLACE");
            i3 = -100;
        } else {
            i3 = i2;
        }
        if (i == 5 && i2 == -13) {
            x.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_SESSIONTIMEOUT trans to MM_ERR_PASSWORD");
            i = 4;
            i3 = -3;
            d.pPH.a(148, 42, 1, false);
        }
        int i4 = i;
        if ((i4 == 6 && i2 == -10001) || (i4 == 5 && i2 != -13)) {
            x.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp");
            SharedPreferences Hn = at.Hn();
            String string = Hn.getString("_auth_key", "");
            String string2 = Hn.getString("server_id", "");
            if (bh.ov(string) && bh.ov(string2)) {
                x.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp aak and cookie null logout");
                i3 = -104;
                d.pPH.a(148, 52, 1, false);
                i4 = 4;
            }
        }
        aa.VR().e(i4, i3, str);
        if (i4 != 4) {
            return;
        }
        if (i3 == -100 || i3 == -205 || i3 == -213) {
            ac.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
            reset();
        }
    }

    final boolean g(String str, String str2, int i) {
        boolean z;
        int i2;
        int i3;
        String string;
        ac.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().remove("auth_ishold").commit();
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("auth_info_key_prefs", 4);
        boolean z2 = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        int i4 = sharedPreferences.getInt("key_auth_update_version", 0);
        int i5 = sharedPreferences.getInt("_auth_uin", 0);
        String string2 = sharedPreferences.getString("_auth_key", "");
        String string3 = sharedPreferences.getString("server_id", "");
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("key_auth_info_prefs_created", true);
        edit.putInt("key_auth_update_version", com.tencent.mm.protocal.d.vAz);
        edit.putInt("_auth_uin", i);
        edit.putString("_auth_key", str);
        edit.putString("server_id", str2);
        if (!edit.commit()) {
            x.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 1th!");
            d.pPH.a(148, 36, 1, false);
            if (!edit.commit()) {
                x.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2nd!");
                d.pPH.a(148, 37, 1, false);
                z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
                i2 = sharedPreferences.getInt("key_auth_update_version", 0);
                i3 = sharedPreferences.getInt("_auth_uin", 0);
                string = sharedPreferences.getString("_auth_key", "");
                String string4 = sharedPreferences.getString("server_id", "");
                x.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2th so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.vAz), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string4, str2});
                x.cfk();
                return false;
            }
        }
        z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        i2 = sharedPreferences.getInt("key_auth_update_version", 0);
        i3 = sharedPreferences.getInt("_auth_uin", 0);
        string = sharedPreferences.getString("_auth_key", "");
        String string5 = sharedPreferences.getString("server_id", "");
        if (z && i2 == com.tencent.mm.protocal.d.vAz && i3 == i && string.equals(str) && string5.equals(str2)) {
            this.hZP.ceU();
            this.hZP.set(1, Integer.valueOf(com.tencent.mm.protocal.d.vAz));
            this.hZP.set(2, Integer.valueOf(i));
            this.hZP.set(3, str);
            this.hZP.set(4, str2);
            this.hZP.chX();
            String str3 = "MicroMsg.AutoAuth";
            String str4 = "summerauth save aak & id ok old vs new vs input[%b, %b, %b, %b] version[%d, %d, %d. %d], uin[%d, %d, %d, %d], aak[%s, %s, %s, %s], cookie[%s, %s, %s, %s]";
            Object[] objArr = new Object[20];
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(true);
            objArr[3] = Boolean.valueOf(!this.hZP.xmB);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i2);
            objArr[6] = Integer.valueOf(com.tencent.mm.protocal.d.vAz);
            objArr[7] = (Integer) this.hZP.get(1);
            objArr[8] = Integer.valueOf(i5);
            objArr[9] = Integer.valueOf(i3);
            objArr[10] = Integer.valueOf(i);
            objArr[11] = (Integer) this.hZP.get(2);
            objArr[12] = string2;
            objArr[13] = string;
            objArr[14] = str;
            objArr[15] = (String) this.hZP.get(3);
            objArr[16] = string3;
            objArr[17] = string5;
            objArr[18] = str2;
            objArr[19] = (String) this.hZP.get(4);
            x.i(str3, str4, objArr);
            return true;
        }
        x.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed check not equal so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.vAz), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string5, str2});
        x.cfk();
        return false;
    }

    final void a(r rVar, int i, int i2) {
        rVar.a(this.hZL, i, i2);
    }

    public final void a(ab abVar) {
        aa.VR().VG();
    }

    public final byte[] Vw() {
        if (!this.hZK.Kt()) {
            return null;
        }
        aa.a aVar = new aa.a();
        aVar.uin = this.hZK.Cg();
        aVar.hFw = bh.VD(ac.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
        aVar.netType = com.tencent.mm.protocal.a.getNetType(ac.getContext());
        aVar.vBs = com.tencent.mm.protocal.a.cdq();
        try {
            byte[] Hq = aVar.Hq();
            this.gPQ = aVar.gPQ;
            return Hq;
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final int getHostByName(String str, List<String> list) {
        return MMLogic.getHostByName(str, list);
    }

    public final int a(boolean z, List<String> list) {
        return MMLogic.getSnsIpsForScene(list, z);
    }

    public final int a(String str, boolean z, List<String> list) {
        return MMLogic.getSnsIpsForSceneWithHostName(list, str, z);
    }

    public final String getIspId() {
        return MMLogic.getIspId();
    }

    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        this.hZJ.lock(1000, "MMAutoAuth.setHostInfo");
        new 4(this, strArr, strArr2, iArr).b(this.handler);
    }

    public final int g(int i, byte[] bArr) {
        return ae.VX().h(i, bArr);
    }

    public final void a(int i, String str, int i2, boolean z) {
        this.hZJ.lock(1000, "MMAutoAuth.logUtil");
        new 5(this, i, i2, str, z).b(this.handler);
    }

    public final void setSignallingStrategy(long j, long j2) {
        StnLogic.setSignallingStrategy(j, j2);
    }

    public final void keepSignalling() {
        StnLogic.keepSignalling();
    }

    public final void stopSignalling() {
        StnLogic.stopSignalling();
    }

    public final void a(o oVar) {
        aa.VU().iax = oVar;
    }

    public final void a(s sVar) {
        this.hZQ = sVar;
    }

    public final boolean Vx() {
        boolean z = false;
        if (this.hZQ != null) {
            try {
                z = this.hZQ.tM();
            } catch (RemoteException e) {
            }
        }
        return z;
    }

    public final void a(g gVar) {
        this.hZR = gVar;
    }

    public final void reportFailIp(String str) {
        MMLogic.reportFailIp(str);
    }

    public final void jr(String str) {
        x.e("MicroMsg.AutoAuth", "killPush %s", new Object[]{str});
    }

    public final void bF(boolean z) {
        if (com.tencent.mm.sdk.b.a.xef == null) {
            x.w("MicroMsg.AutoAuth", "loginevent but eventpool null, event:" + z);
        } else if (z) {
            com.tencent.mm.sdk.b.a.xef.m(new av());
        } else {
            com.tencent.mm.sdk.b.a.xef.m(new gu());
        }
    }

    public final i Ky() {
        return null;
    }

    public final void bG(boolean z) {
        bh.initLanguage(ac.getContext());
    }

    public final void bH(boolean z) {
        x.d("MicroMsg.AutoAuth", "summer setMMTLS enable[%b]", new Object[]{Boolean.valueOf(z)});
        MMLogic.setMmtlsCtrlInfo(false);
    }

    public final void Kz() {
        StnLogic.makesureLongLinkConnected();
    }

    public final void KA() {
        StnLogic.startNetworkAnalysis();
    }

    public final void a(h hVar) {
        this.hZS = hVar;
    }
}
