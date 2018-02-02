package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.mm.bi.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f {
    public static ArrayList<b> jMd;
    private static String tTg;

    public static void c(Context context, ArrayList<b> arrayList) {
        if (jMd != null) {
            jMd.clear();
        }
        jMd = arrayList;
        Set hashSet = new HashSet();
        if (jMd != null) {
            Iterator it = jMd.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                String d = c.d(bVar);
                if (!bh.ov(d)) {
                    hashSet.add(d);
                }
                String e = c.e(bVar);
                if (!bh.ov(e)) {
                    hashSet.add(e);
                }
            }
        }
        a.hZq = hashSet;
        StringBuilder stringBuilder = new StringBuilder("");
        if (jMd != null) {
            for (int i = 0; i < jMd.size(); i++) {
                if (i != jMd.size() - 1) {
                    stringBuilder.append(c.a(context, (b) jMd.get(i))).append("<br/>");
                } else {
                    stringBuilder.append(c.a(context, (b) jMd.get(i)));
                }
            }
        }
        tTg = c.QY(stringBuilder.toString());
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setText(com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(tTg));
        }
    }

    public static ArrayList<b> bWE() {
        ArrayList<b> arrayList = new ArrayList();
        if (jMd == null) {
            return arrayList;
        }
        Iterator it = jMd.iterator();
        while (it.hasNext()) {
            Object obj;
            b c = c.c((b) it.next());
            if (c == null) {
                obj = null;
            } else {
                obj = 1;
                int type = c.getType();
                if (type == 2 || type == 6 || type == 4 || type == 5) {
                    String d = c.d(c);
                    if (bh.ov(d) || !FileOp.bO(d)) {
                        obj = null;
                    }
                }
                if (type == 2 || type == 6) {
                    String e = c.e(c);
                    if (bh.ov(e) || !FileOp.bO(e)) {
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    public static void aaS() {
        if (jMd != null) {
            jMd.clear();
        }
        tTg = "";
        a.hZq = null;
    }

    public static boolean dT(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager.getText().length() >= 16384) {
            return true;
        }
        if (c.QW(clipboardManager.getText().toString()) >= 16384) {
            return true;
        }
        return false;
    }

    public static int dU(Context context) {
        int i;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null || clipboardManager.getText() == null || clipboardManager.getText().length() <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        int i2;
        if (jMd == null || jMd.size() <= 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i != 0 && r6 != 0) {
            return 1;
        }
        if (i == 0 && r6 != 0) {
            return 2;
        }
        if (i != 0) {
            return 3;
        }
        String a;
        String str = "";
        try {
            CharSequence text = clipboardManager.getText();
            if (text instanceof Spanned) {
                a = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) text);
            } else {
                a = text.toString();
            }
        } catch (Exception e) {
            x.e("WNNoteClipboardManager", "get clipboard data error : ", new Object[]{e});
            a = str;
        }
        if (a.equals(tTg)) {
            return 3;
        }
        return 2;
    }
}
