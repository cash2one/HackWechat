package com.tencent.mm.modelgeo;

import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements e {
    public static String TAG = "MicroMsg.LocationAddr";
    private static b hxH;
    private c hxI = null;
    private LinkedList<c> hxJ = new LinkedList();
    private HashMap<String, LinkedList<WeakReference<a>>> hxK = new HashMap();
    private as hxL = new as(1, "addr_worker");
    private boolean hxM = true;

    public interface a {
        void b(Addr addr);
    }

    private class b implements com.tencent.mm.sdk.platformtools.as.a {
        private Addr hxN = null;
        final /* synthetic */ b hxO;

        public b(b bVar) {
            this.hxO = bVar;
        }

        public final boolean JB() {
            if (this.hxO.hxI == null) {
                return false;
            }
            if (this.hxN == null || this.hxN.hxu == null || this.hxN.hxu.equals("")) {
                this.hxN = b.a(this.hxO.hxI.lat, this.hxO.hxI.lng, this.hxO.hxM);
            }
            return true;
        }

        public final boolean JC() {
            this.hxO.hxM = true;
            this.hxO.a(this.hxN);
            return true;
        }
    }

    class c {
        final /* synthetic */ b hxO;
        double lat;
        double lng;
        Object tag = "";

        public c(b bVar, double d, double d2, Object obj) {
            this.hxO = bVar;
            this.lat = d;
            this.lng = d2;
            this.tag = obj;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder().append((int) (this.lat * 1000000.0d)).append((int) (this.lng * 1000000.0d));
            String obj = this.tag == null ? "" : ((this.tag instanceof Integer) || (this.tag instanceof Long) || (this.tag instanceof Double) || (this.tag instanceof Float) || (this.tag instanceof String)) ? this.tag : this.tag.toString();
            return append.append(obj).toString();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return ((c) obj).toString().equals(toString());
        }
    }

    private b() {
    }

    public static b ON() {
        if (hxH == null) {
            hxH = new b();
        }
        return hxH;
    }

    public final boolean a(a aVar) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str : this.hxK.keySet()) {
            LinkedList linkedList3 = (LinkedList) this.hxK.get(str);
            b(linkedList3, aVar);
            this.hxK.put(str, linkedList3);
            if (linkedList3 == null || linkedList3.size() == 0) {
                linkedList2.add(str);
            }
        }
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            this.hxK.remove((String) it.next());
        }
        Iterator it2 = this.hxJ.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            linkedList3 = (LinkedList) this.hxK.get(cVar.toString());
            if (linkedList3 == null || linkedList3.size() == 0) {
                linkedList.add(cVar);
                this.hxK.remove(cVar.toString());
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            this.hxJ.remove((c) it.next());
        }
        x.i(TAG, "remove taskLists %d listeners size %d", new Object[]{Integer.valueOf(this.hxJ.size()), Integer.valueOf(this.hxK.size())});
        return true;
    }

    private static boolean a(LinkedList<WeakReference<a>> linkedList, a aVar) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(LinkedList<WeakReference<a>> linkedList, a aVar) {
        if (linkedList == null) {
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                linkedList.remove(weakReference);
                return true;
            }
        }
        return false;
    }

    public final boolean a(double d, double d2, a aVar, Object obj) {
        c cVar;
        if (obj != null) {
            Iterator it = this.hxJ.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                if (cVar != null && cVar.tag != null && cVar.tag.equals(obj)) {
                    this.hxJ.remove(cVar);
                    break;
                }
            }
        }
        cVar = new c(this, d, d2, obj);
        LinkedList linkedList = (LinkedList) this.hxK.get(cVar.toString());
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        if (!a(linkedList, aVar)) {
            linkedList.add(new WeakReference(aVar));
        }
        this.hxK.put(cVar.toString(), linkedList);
        Iterator it2 = this.hxJ.iterator();
        while (it2.hasNext()) {
            if (((c) it2.next()).equals(cVar)) {
                OO();
                return false;
            }
        }
        if (this.hxI != null && cVar.equals(this.hxI)) {
            return false;
        }
        this.hxJ.add(cVar);
        x.i(TAG, "push task size %d listeners %d", new Object[]{Integer.valueOf(this.hxJ.size()), Integer.valueOf(this.hxK.size())});
        while (this.hxJ.size() > 30) {
            x.i(TAG, "force remove task");
            cVar = (c) this.hxJ.removeFirst();
            if (cVar != null) {
                this.hxK.remove(cVar.toString());
            }
        }
        OO();
        return true;
    }

    public final boolean a(double d, double d2, a aVar) {
        return a(d, d2, aVar, null);
    }

    private void OO() {
        if (this.hxI == null && this.hxJ != null && this.hxJ.size() > 0) {
            this.hxI = (c) this.hxJ.removeFirst();
            if (bh.PT()) {
                this.hxL.c(new b(this));
                return;
            }
            g.CG().a(655, this);
            g.CG().a(new d(this.hxI.lat, this.hxI.lng), 0);
        }
    }

    private void a(Addr addr) {
        if (this.hxI != null) {
            if (addr == null) {
                addr = new Addr();
            }
            addr.tag = this.hxI.tag == null ? new Object() : this.hxI.tag;
            addr.hxF = (float) this.hxI.lat;
            addr.hxG = (float) this.hxI.lng;
            if (!bh.ov(addr.hxw)) {
                String string = ac.getContext().getResources().getString(h.loy);
                x.d(TAG, "city %s", new Object[]{string});
                if (!bh.PT() && !bh.ov(string) && addr.hxw.endsWith(string)) {
                    addr.hxx = addr.hxw;
                    addr.hxw = addr.hxw.substring(0, addr.hxw.length() - string.length());
                } else if (bh.PT() || bh.ov(string) || addr.hxu.indexOf(string) < 0) {
                    addr.hxx = addr.hxw;
                } else {
                    addr.hxx = addr.hxw + string;
                }
            }
            LinkedList linkedList = (LinkedList) this.hxK.get(this.hxI.toString());
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((a) weakReference.get()).b(addr);
                    }
                }
            }
            this.hxK.remove(this.hxI.toString());
            x.d(TAG, "postexecute2 listeners %d", new Object[]{Integer.valueOf(this.hxK.size())});
            this.hxI = null;
            OO();
            if (this.hxI == null && this.hxJ.size() > 0) {
                g.CG().b(655, this);
            }
        }
    }

    private static Addr a(double d, double d2, boolean z) {
        String format;
        InputStreamReader inputStreamReader;
        Throwable e;
        u uVar;
        String cfi = w.cfi();
        Addr addr = new Addr();
        if (z) {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), cfi});
        } else {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), "zh_CN"});
        }
        x.d(TAG, "url " + format);
        u a;
        try {
            a = com.tencent.mm.network.b.a(format, null);
            try {
                a.setConnectTimeout(10000);
                a.setRequestMethod("GET");
                x.d(TAG, "conn " + a.getResponseCode());
                inputStreamReader = new InputStreamReader(a.getInputStream());
                try {
                    String readLine;
                    String string;
                    String string2;
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    x.d(TAG, "sb " + stringBuffer.toString());
                    JSONArray jSONArray = new JSONObject(stringBuffer.toString()).getJSONArray("results");
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    addr.hxu = jSONObject.getString("formatted_address");
                    JSONArray jSONArray2 = jSONArray.getJSONObject(0).getJSONArray("address_components");
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                        try {
                            string = jSONObject2.getString("long_name");
                            string2 = jSONObject2.getJSONArray("types").getString(0);
                            if (string2.equals("administrative_area_level_1")) {
                                addr.hxv = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_LOCALITY)) {
                                addr.hxw = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_SUBLOCALITY)) {
                                addr.hxy = string;
                            } else if (string2.equals("neighborhood")) {
                                addr.hxz = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_ROUTE)) {
                                addr.hxA = string;
                            } else if (string2.equals("street_number")) {
                                addr.hxB = string;
                            } else if (string2.equals("country")) {
                                addr.country = string;
                            }
                        } catch (Exception e2) {
                        } catch (IOException e3) {
                            e = e3;
                            uVar = a;
                        }
                    }
                    format = ProtocolPackage.ServerEncoding;
                    string2 = URLEncoder.encode(addr.hxu, format);
                    readLine = URLEncoder.encode(jSONArray2.toString(), format);
                    string = URLEncoder.encode(jSONObject.getJSONObject("geometry").toString(), format);
                    String encode = URLEncoder.encode(jSONObject.getString("place_id"), format);
                    String encode2 = URLEncoder.encode(jSONObject.getJSONArray("types").toString(), format);
                    format = URLEncoder.encode(String.format("[%f,%f]", new Object[]{Double.valueOf(d), Double.valueOf(d2)}), format);
                    x.d(TAG, "google report, formattedaddr: %s, componentaddr: %s, geometry: %s, placeId: %s, types: %s, location: %s, curLanguage: %s", new Object[]{string2, readLine, string, encode, encode2, format, cfi});
                    com.tencent.mm.plugin.report.service.g.pQN.h(12886, new Object[]{readLine, string2, string, encode, encode2, format, cfi});
                    a.aBw.disconnect();
                } catch (IOException e32) {
                    e = e32;
                    uVar = a;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        x.d(TAG, "error Exception");
                        x.e(TAG, "exception:%s", new Object[]{bh.i(e)});
                        if (a != null) {
                            a.aBw.disconnect();
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable e5) {
                                x.e(TAG, "exception:%s", new Object[]{bh.i(e5)});
                            }
                        }
                        return addr;
                    } catch (Throwable th) {
                        e5 = th;
                        if (a != null) {
                            a.aBw.disconnect();
                        }
                        throw e5;
                    }
                }
            } catch (IOException e6) {
                e5 = e6;
                inputStreamReader = null;
                uVar = a;
                try {
                    x.d(TAG, "error e");
                    x.e(TAG, "exception:%s", new Object[]{bh.i(e5)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return addr;
                } catch (Throwable th2) {
                    e5 = th2;
                    a = uVar;
                    if (a != null) {
                        a.aBw.disconnect();
                    }
                    throw e5;
                }
            } catch (Exception e7) {
                e5 = e7;
                inputStreamReader = null;
                x.d(TAG, "error Exception");
                x.e(TAG, "exception:%s", new Object[]{bh.i(e5)});
                if (a != null) {
                    a.aBw.disconnect();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                return addr;
            }
        } catch (IOException e8) {
            e5 = e8;
            uVar = null;
            inputStreamReader = null;
            x.d(TAG, "error e");
            x.e(TAG, "exception:%s", new Object[]{bh.i(e5)});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return addr;
        } catch (Exception e9) {
            e5 = e9;
            a = null;
            inputStreamReader = null;
            x.d(TAG, "error Exception");
            x.e(TAG, "exception:%s", new Object[]{bh.i(e5)});
            if (a != null) {
                a.aBw.disconnect();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return addr;
        } catch (Throwable th3) {
            e5 = th3;
            a = null;
            if (a != null) {
                a.aBw.disconnect();
            }
            throw e5;
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        return addr;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 655) {
            Addr OS = ((d) kVar).OS();
            if (OS == null || OS.hxu == null || OS.hxu.equals("")) {
                this.hxL.c(new b(this));
            } else {
                a(OS);
            }
        }
    }
}
