package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ab;
import java.util.List;

public interface e {
    void KA();

    boolean Kn();

    c Kx();

    i Ky();

    void Kz();

    int a(r rVar, l lVar);

    int a(String str, boolean z, List<String> list);

    void a(int i, String str, int i2, boolean z);

    void a(b bVar);

    void a(h hVar);

    void a(o oVar);

    void a(ab abVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    void bE(boolean z);

    void bF(boolean z);

    void bG(boolean z);

    void bH(boolean z);

    void cancel(int i);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void jq(String str);

    void jr(String str);

    void keepSignalling();

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
