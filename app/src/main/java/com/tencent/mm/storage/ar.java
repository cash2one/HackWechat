package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.g;
import java.util.List;

public interface ar extends g {

    public interface a {
        void a(ar arVar, x xVar);
    }

    String LI();

    void O(x xVar);

    boolean P(x xVar);

    boolean Q(x xVar);

    boolean R(x xVar);

    int S(x xVar);

    x WJ(String str);

    boolean WK(String str);

    x WL(String str);

    x WM(String str);

    x WN(String str);

    x WO(String str);

    long WP(String str);

    boolean WQ(String str);

    boolean WR(String str);

    byte[] WS(String str);

    int WT(String str);

    int WU(String str);

    String WV(String str);

    int a(String str, x xVar);

    Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    Cursor a(String str, String str2, List<String> list, boolean z, boolean z2);

    Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2);

    Cursor a(String[] strArr, String str, List<String> list);

    void a(a aVar);

    Cursor aZs();

    int b(String str, x xVar);

    int b(String[] strArr, String... strArr2);

    Cursor b(String str, String str2, List<String> list);

    Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    void b(a aVar);

    int[] b(String str, String str2, String str3, List<String> list);

    int[] b(String str, String str2, String[] strArr, List<String> list);

    int c(String[] strArr, String... strArr2);

    Cursor c(String str, String str2, List<String> list);

    void c(String str, x xVar);

    int[] c(String str, String str2, String str3, List<String> list);

    int[] c(String str, String str2, String[] strArr, List<String> list);

    Cursor cI(List<String> list);

    Cursor cJ(List<String> list);

    Cursor cK(List<String> list);

    Cursor cL(List<String> list);

    Cursor cO(List<String> list);

    Cursor cP(List<String> list);

    List<String> cQ(List<String> list);

    int[] cR(List<String> list);

    int[] cS(List<String> list);

    List<String> cim();

    Cursor cin();

    Cursor cio();

    Cursor cip();

    Cursor ciq();

    int cir();

    Cursor cix();

    String d(String str, String str2, List<String> list);

    x fO(long j);

    Cursor j(List<String> list, boolean z);

    int w(String str, byte[] bArr);
}
