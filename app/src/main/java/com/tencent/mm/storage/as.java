package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface as extends g {

    public interface a {
        void a(ae aeVar, as asVar);
    }

    public interface b {
        String a(int i, String str, String str2, int i2, Context context);

        void a(au auVar, PString pString, PString pString2, PInt pInt, boolean z);
    }

    boolean AX(String str);

    boolean EE(String str);

    void WX(String str);

    ae WY(String str);

    void WZ(String str);

    boolean Xa(String str);

    boolean Xb(String str);

    boolean Xc(String str);

    boolean Xd(String str);

    boolean Xe(String str);

    boolean Xf(String str);

    Cursor Xg(String str);

    Cursor Xh(String str);

    int Xi(String str);

    String Xj(String str);

    ae Xk(String str);

    int Xl(String str);

    void Xm(String str);

    void Xn(String str);

    int Xo(String str);

    int a(ae aeVar, String str);

    int a(ae aeVar, String str, boolean z);

    Cursor a(String str, List<String> list, String str2, boolean z);

    Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2);

    com.tencent.mm.vending.b.b a(e eVar);

    void a(d dVar);

    void a(ae aeVar, int i, int i2);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    boolean a(String str, int i, boolean z, int i2);

    String aS(int i, String str);

    void ad(au auVar);

    void aw(LinkedList<String> linkedList);

    Cursor b(String str, List<String> list, boolean z, String str2);

    void b(c cVar, c.c cVar2);

    void b(a aVar);

    Cursor c(String str, List<String> list, String str2);

    void c(a aVar);

    boolean ciA();

    HashMap<String, Long> ciB();

    void ciC();

    List<String> ciE();

    List<String> ciF();

    Cursor ciG();

    int ciH();

    String ciI();

    Cursor ciJ();

    ae ciK();

    boolean ciz();

    long d(ae aeVar);

    void d(String[] strArr, String str);

    Cursor db(String str, int i);

    boolean f(ae aeVar);

    Cursor fD(String str, String str2);

    boolean g(ae aeVar);

    int hv(String str);

    Cursor j(List<String> list, int i);

    Cursor r(String str, List<String> list);

    Cursor s(String str, List<String> list);

    b uw();
}
