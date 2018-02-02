package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends b implements e {
    public static int qpN = 3;
    private float gyA = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gyF = new 1(this);
    private float gyz = -85.0f;
    private c hpO;
    private int pYy = DownloadResult.CODE_UNDEFINED;
    private d qpI;
    public Collection<a> qpJ = null;
    private int qpK = 10001;
    private int qpL = 10002;
    private int qpM = 10003;

    public static final class a {
        public double hLU = 0.0d;
        public int major = 0;
        public int minor = 0;
        public String ned = null;
        public String qpP = "";
        public double qpQ = 0.0d;
        public int qpR = 0;
    }

    public h(com.tencent.mm.plugin.shake.b.l.a aVar) {
        super(aVar);
    }

    public final void init() {
        ar.CG().a(658, (e) this);
        bro();
    }

    public final void reset() {
        if (this.qpI != null) {
            ar.CG().c(this.qpI);
        }
    }

    public final void start() {
        x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
        init();
        reset();
        if (this.hpO == null) {
            bro();
        }
        this.hpO.b(this.gyF, true);
        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
            boolean isProviderEnabled;
            LocationManager locationManager = (LocationManager) ac.getContext().getSystemService("location");
            if (locationManager != null) {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
            } else {
                isProviderEnabled = true;
            }
            if (!isProviderEnabled) {
                new af().postDelayed(new 2(this), 1000);
                return;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
            new af().postDelayed(new Runnable(this) {
                final /* synthetic */ h qpO;

                {
                    this.qpO = r1;
                }

                public final void run() {
                    this.qpO.qnR.d(null, 9);
                }
            }, 1000);
        } else if (defaultAdapter == null) {
            new af().postDelayed(new 4(this), 1000);
        } else {
            int size;
            String str = "MicroMsg.ShakeIbeaconService";
            String str2 = "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d";
            Object[] objArr = new Object[1];
            if (this.qpJ != null) {
                size = this.qpJ.size();
            } else {
                size = 0;
            }
            objArr[0] = Integer.valueOf(size);
            x.i(str, str2, objArr);
            this.qpI = new d(this.qpJ, this.gyz, this.gyA, this.pYy);
            ar.CG().a(this.qpI, 0);
        }
    }

    public final void pause() {
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
    }

    public final void resume() {
        if (this.hpO != null) {
            this.hpO.a(this.gyF, true);
        }
    }

    private void bro() {
        this.hpO = c.OP();
        this.hpO.a(this.gyF, true);
    }

    public final void brp() {
        super.brp();
        ar.CG().b(658, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            d dVar = (d) kVar;
            if (658 == kVar.getType() && dVar.action == 1) {
                aks com_tencent_mm_protocal_c_aks = (aks) dVar.hFi.hmh.hmo;
                if (com_tencent_mm_protocal_c_aks.wrV.vVT == 0) {
                    x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", com_tencent_mm_protocal_c_aks.wrV.nfU, com_tencent_mm_protocal_c_aks.wrV.pew, Integer.valueOf(com_tencent_mm_protocal_c_aks.wrV.vVT));
                    try {
                        JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_aks.wrV.nfU);
                        JSONArray jSONArray = jSONObject.getJSONArray("msgs");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("guide_switch");
                        int i3 = jSONObject2.getInt("channel_open_method");
                        long j = jSONObject2.getLong("channel_open_time");
                        int i4 = jSONObject2.getInt("shake_tab_display");
                        int i5 = jSONObject.getJSONObject("gated_launch_option").getInt("tab_state");
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_METHOD_INT, Integer.valueOf(i3));
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, Long.valueOf(j));
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(i4));
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(i5));
                        x.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + i3 + " ,channel_open_time is " + j + ", shake_tab_display is " + i4);
                        int length = jSONArray.length();
                        List list = null;
                        com.tencent.mm.plugin.shake.b.e brC = m.brC();
                        brC.bru();
                        if (length > 0) {
                            list = new ArrayList();
                            for (i5 = 0; i5 < length; i5++) {
                                d dVar2 = new d();
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                                String string = jSONObject3.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                String string2 = jSONObject3.getString("content");
                                String string3 = jSONObject3.getString("title");
                                String string4 = jSONObject3.getString("picurl");
                                String string5 = jSONObject3.getString("shopid");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("beacon");
                                String string6 = jSONObject4.getString("uuid");
                                String string7 = jSONObject4.getString("major");
                                String string8 = jSONObject4.getString("minor");
                                int i6 = jSONObject3.getInt("guide_state");
                                String string9 = jSONObject3.getString("wxa_username");
                                String string10 = jSONObject3.getString("wxa_path");
                                int i7 = jSONObject3.getInt("wxa_version_type");
                                dVar2.field_type = 11;
                                dVar2.field_username = string3;
                                dVar2.field_nickname = string3;
                                dVar2.field_signature = string2;
                                dVar2.field_province = string4;
                                dVar2.field_city = string;
                                if (i6 == 1) {
                                    dVar2.field_sex = qpN;
                                }
                                dVar2.field_lvbuffer = (String.valueOf(string5) + "," + String.valueOf(string6) + "," + String.valueOf(string7) + "," + String.valueOf(string8)).getBytes(ProtocolPackage.ServerEncoding);
                                dVar2.field_insertBatch = 2;
                                dVar2.field_reserved3 = string9 + "," + string10 + "," + i7;
                                list.add(dVar2);
                                brC.a(dVar2, true);
                                if (dVar2.field_sex == qpN && i3 == 1) {
                                    a(dVar2);
                                }
                            }
                        }
                        this.qnR.d(list, 1);
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", bh.ou(e.getMessage()));
                        this.qnR.d(null, 1);
                        return;
                    }
                } else if (com_tencent_mm_protocal_c_aks.wrV.vVT == this.qpK) {
                    this.qnR.d(null, 6);
                    return;
                } else if (com_tencent_mm_protocal_c_aks.wrV.vVT == this.qpL) {
                    this.qnR.d(null, 7);
                    return;
                } else if (com_tencent_mm_protocal_c_aks.wrV.vVT == this.qpM) {
                    this.qnR.d(null, 8);
                    return;
                } else {
                    this.qnR.d(null, 1);
                    return;
                }
            }
            return;
        }
        this.qnR.d(null, 3);
    }

    public static void a(d dVar) {
        if (dVar != null && dVar.field_sex == qpN) {
            String str;
            ar.Hg();
            com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(true));
            long Wo = bh.Wo();
            ar.Hg();
            com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, Long.valueOf(Wo));
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, Long.valueOf(split[0]));
                }
            }
        }
    }

    public static void b(d dVar) {
        if (dVar != null) {
            String str;
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    String str2 = split[1];
                    String str3 = split[2];
                    str = split[3];
                    a aVar = new a();
                    aVar.ned = str2;
                    aVar.major = bh.getInt(str3, 0);
                    aVar.minor = bh.getInt(str, 0);
                }
            }
        }
    }
}
