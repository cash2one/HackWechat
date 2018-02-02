package com.tencent.mm.plugin.normsg.utils;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Set;
import java.util.TreeSet;

public enum NativeLogic$a implements a {
    ;

    private NativeLogic$a(String str) {
    }

    public final void tZ(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            NativeLogic.ya();
        }
    }

    public final void ua(int i) {
        String str = ac.getContext().getApplicationInfo().sourceDir;
        g.Dh();
        int Cg = com.tencent.mm.kernel.a.Cg();
        for (int i2 = 0; i2 < i; i2++) {
            NativeLogic.bP(str, Cg);
        }
    }

    public final void ub(int i) {
        Context context = ac.getContext();
        String str = context.getApplicationInfo().sourceDir;
        g.Dh();
        int Cg = com.tencent.mm.kernel.a.Cg();
        for (int i2 = 0; i2 < i; i2++) {
            NativeLogic.i(context, str, Cg);
        }
    }

    public final void uc(int i) {
        Context context = ac.getContext();
        for (int i2 = 0; i2 < i; i2++) {
            NativeLogic.dl(context);
        }
    }

    public final void ud(int i) {
        int i2 = 0;
        Context context = ac.getContext();
        Set treeSet = new TreeSet();
        for (int i3 = 0; i3 < i; i3++) {
            treeSet.clear();
            NativeLogic.b(context, treeSet, false);
        }
        Toast.makeText(context, treeSet.toString(), 1).show();
        while (i2 < i) {
            treeSet.clear();
            NativeLogic.b(context, treeSet, true);
            i2++;
        }
        Toast.makeText(context, treeSet.toString(), 1).show();
    }

    public final void ue(int i) {
        Context context = ac.getContext();
        for (int i2 = 0; i2 < i; i2++) {
            Toast.makeText(context, String.valueOf(NativeLogic.bgi()), 1).show();
        }
    }

    public final void uf(int i) {
        Context context = ac.getContext();
        for (int i2 = 0; i2 < i; i2++) {
            Toast.makeText(context, String.valueOf(NativeLogic.GK(",")), 1).show();
        }
    }

    public final void ug(int i) {
        Context context = ac.getContext();
        for (int i2 = 0; i2 < i; i2++) {
            Toast.makeText(context, String.valueOf(NativeLogic.apF()), 1).show();
        }
    }
}
