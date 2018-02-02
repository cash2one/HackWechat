package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class c {
    private static volatile c tSD = null;
    public ArrayList<b> jRt = null;
    public a tSE = null;
    public uq tSF = null;
    public int tSG = 0;
    public int tSH = 0;
    public int tSI = 0;
    public boolean tSJ = false;

    private c() {
    }

    public static c bWp() {
        if (tSD == null) {
            synchronized (c.class) {
                if (tSD == null) {
                    tSD = new c();
                }
            }
        }
        return tSD;
    }

    public final int size() {
        return this.jRt != null ? this.jRt.size() : 0;
    }

    public final b Bt(int i) {
        if (this.jRt == null || i < 0 || i >= this.jRt.size()) {
            return null;
        }
        return (b) this.jRt.get(i);
    }

    public final boolean a(b bVar) {
        boolean z = true;
        synchronized (this) {
            if (bVar != null) {
                if (this.jRt != null) {
                    this.jRt.add(bVar);
                    a(bVar, true);
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean a(int i, ArrayList<b> arrayList) {
        boolean z = false;
        if (arrayList != null && arrayList.size() > 0) {
            int i2;
            int i3;
            synchronized (this) {
                if (this.jRt != null) {
                    int i4 = 0;
                    i2 = 0;
                    i3 = i;
                    while (i4 < arrayList.size() && i3 >= 0 && i3 <= this.jRt.size()) {
                        b bVar = (b) arrayList.get(i4);
                        if (bVar != null) {
                            b(bVar);
                            this.jRt.add(i3, bVar);
                            i2++;
                            i3++;
                            a(bVar, true);
                        }
                        int i5 = i2;
                        i4++;
                        i3 = i3;
                        i2 = i5;
                    }
                    z = true;
                } else {
                    i2 = 0;
                    i3 = i;
                }
            }
            if (z && this.tSE != null) {
                this.tSE.en(i3 - i2, i2);
            }
        }
        return z;
    }

    public final boolean a(int i, b bVar) {
        boolean z = true;
        synchronized (this) {
            if (this.jRt == null || i < 0 || i > this.jRt.size()) {
                z = false;
            } else {
                this.jRt.add(i, bVar);
                a(bVar, true);
            }
        }
        if (z && this.tSE != null) {
            this.tSE.Bn(i);
            if (i > 0) {
                this.tSE.eo(i - 1, this.jRt.size() - (i - 1));
            } else {
                this.tSE.eo(i, this.jRt.size() - i);
            }
        }
        return z;
    }

    private boolean b(int i, b bVar) {
        if (bVar == null || this.jRt == null || i < 0 || i > this.jRt.size()) {
            return false;
        }
        this.jRt.add(i, bVar);
        a(bVar, true);
        return true;
    }

    public final boolean V(int i, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.jRt != null && i >= 0 && i < this.jRt.size()) {
                a((b) this.jRt.get(i), false);
                this.jRt.remove(i);
                z2 = true;
            }
        }
        if (z2 && z && this.tSE != null) {
            this.tSE.Bo(i);
            if (i > 0) {
                this.tSE.eo(i - 1, this.jRt.size() - (i - 1));
            } else {
                this.tSE.eo(i, this.jRt.size() - i);
            }
        }
        return z2;
    }

    private boolean Bu(int i) {
        if (this.jRt == null || i < 0 || i >= this.jRt.size()) {
            return false;
        }
        a((b) this.jRt.get(i), false);
        this.jRt.remove(i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(String str, b bVar) {
        synchronized (this) {
            if (this.jRt == null) {
                return;
            }
            int i;
            for (int i2 = 0; i2 < this.jRt.size(); i2++) {
                if (((b) this.jRt.get(i2)).bVS().equals(str)) {
                    a((b) this.jRt.get(i2), false);
                    this.jRt.set(i2, bVar);
                    a(bVar, true);
                    i = i2;
                    break;
                }
            }
            i = -1;
        }
    }

    public final void bWq() {
        String str = "MicroMsg.Note.NoteDataManager";
        String str2 = "clear mDataList, size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.jRt != null ? this.jRt.size() : 0);
        x.i(str, str2, objArr);
        synchronized (this) {
            if (this.jRt != null) {
                this.jRt.clear();
            }
        }
        this.tSI = 0;
        this.tSH = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void W(int i, boolean z) {
        synchronized (this) {
            if (this.jRt == null) {
            } else if (i >= 0 && i < this.jRt.size()) {
                r0 = (b) this.jRt.get(i);
                if (!(r0 == null || r0.tRA == z)) {
                    r0.tRA = z;
                    if (this.tSE != null) {
                        this.tSE.Bm(i);
                    }
                }
            } else if (i == -1) {
                for (int i2 = 0; i2 < this.jRt.size(); i2++) {
                    r0 = (b) this.jRt.get(i2);
                    if (!(r0 == null || r0.tRA == z)) {
                        r0.tRA = z;
                        if (this.tSE != null) {
                            this.tSE.Bm(i2);
                        }
                    }
                }
            }
        }
    }

    public final int bWr() {
        int i;
        synchronized (this) {
            if (this.jRt != null) {
                for (int i2 = 0; i2 < this.jRt.size(); i2++) {
                    if (((b) this.jRt.get(i2)).tRt) {
                        i = i2;
                        break;
                    }
                }
            }
            i = -1;
        }
        return i;
    }

    public final void bWs() {
        synchronized (this) {
            if (this.jRt != null) {
                Iterator it = this.jRt.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    bVar.tRt = false;
                    bVar.tRz = false;
                }
            }
        }
    }

    private void bWt() {
        if (this.jRt != null) {
            Iterator it = this.jRt.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                bVar.tRt = false;
                bVar.tRz = false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void X(int i, boolean z) {
        synchronized (this) {
            if (this.jRt == null || i < 0 || i >= this.jRt.size()) {
            } else {
                for (int i2 = 0; i2 < this.jRt.size(); i2++) {
                    if (i2 == i) {
                        ((b) this.jRt.get(i2)).tRt = true;
                        ((b) this.jRt.get(i2)).tRz = z;
                    } else {
                        ((b) this.jRt.get(i2)).tRt = false;
                        ((b) this.jRt.get(i2)).tRz = false;
                    }
                }
            }
        }
    }

    public final int bWu() {
        int i;
        synchronized (this) {
            if (this.jRt != null) {
                int i2 = 0;
                while (i2 < this.jRt.size()) {
                    if (((b) this.jRt.get(i2)).getType() == 4 && ((k) this.jRt.get(i2)).tRH.booleanValue()) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            i = -1;
        }
        return i;
    }

    public final String bWv() {
        String stringBuilder;
        synchronized (this) {
            if (this.tSG == 0 && this.jRt != null) {
                Iterator it = this.jRt.iterator();
                while (it.hasNext()) {
                    n nVar = (n) ((b) it.next());
                    if (nVar.tRP.startsWith("WeNote_")) {
                        int i = bh.getInt(nVar.tRP.substring(7), -1);
                        if (i <= this.tSG) {
                            i = this.tSG;
                        }
                        this.tSG = i;
                    }
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("WeNote_");
            int i2 = this.tSG + 1;
            this.tSG = i2;
            stringBuilder = stringBuilder2.append(i2).toString();
        }
        return stringBuilder;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String bWw() {
        String str;
        String str2 = "";
        synchronized (this) {
            if (this.jRt == null || this.jRt.size() <= 0) {
                str = "";
            } else {
                int i = 0;
                while (i < this.jRt.size()) {
                    b bVar = (b) this.jRt.get(i);
                    switch (bVar.getType()) {
                        case -1:
                            str = str2 + "<hr/>";
                            break;
                        case 1:
                            h hVar = (h) bVar;
                            if (!bh.ov(hVar.content)) {
                                str2 = str2 + hVar.content;
                                if (i + 1 < this.jRt.size() && ((b) this.jRt.get(i + 1)).getType() == 1 && !bh.ov(((h) this.jRt.get(i + 1)).content)) {
                                    str = str2 + "<br/>";
                                    break;
                                }
                            }
                            str = str2 + "<br/>";
                            break;
                        case 2:
                            str = str2 + cL(((e) bVar).tRP, 2);
                            break;
                        case 3:
                            str = str2 + cL(((f) bVar).tRP, 3);
                            break;
                        case 4:
                            str = str2 + cL(((k) bVar).tRP, 4);
                            break;
                        case 5:
                            str = str2 + cL(((com.tencent.mm.plugin.wenote.model.a.c) bVar).tRP, 5);
                            break;
                        case 6:
                            str = str2 + cL(((j) bVar).tRP, 6);
                            break;
                        default:
                            str = str2;
                            break;
                    }
                    i++;
                    str2 = str;
                }
                str = str2.replaceAll("\n", "<br/>");
            }
        }
        return str;
    }

    private static String cL(String str, int i) {
        return String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[]{Integer.valueOf(i), str, str});
    }

    public final ve QP(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
            return null;
        }
        String o;
        List arrayList = new ArrayList();
        synchronized (this) {
            int i = 0;
            while (i < this.jRt.size()) {
                b bVar = (b) this.jRt.get(i);
                if (bh.ov(bVar.mvG)) {
                    bVar.mvG = com.tencent.mm.plugin.wenote.model.f.QI(bVar.toString());
                }
                h hVar;
                h hVar2;
                if (bVar.getType() == -1) {
                    if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).type != 1) {
                        hVar = new h();
                        hVar.content = "\n";
                        hVar.mvG = bVar.mvG;
                        hVar.tRP = "-1";
                        hVar.type = 1;
                        hVar.tRO = null;
                        arrayList.add(hVar);
                    } else {
                        hVar2 = (h) arrayList.get(arrayList.size() - 1);
                        hVar2.content += "\n";
                    }
                } else if (bVar.getType() >= -1) {
                    if ((bVar.getType() == 6 || bVar.getType() == 4) && bh.ov(((n) bVar).fCa)) {
                        uq uqVar = new uq();
                        uqVar.TD(bVar.mvG);
                        uqVar.TA(bVar.bVT());
                        o = com.tencent.mm.plugin.wenote.model.f.o(uqVar);
                        if (FileOp.bO(o)) {
                            x.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", new Object[]{Integer.valueOf(bVar.getType())});
                            ((n) bVar).fCa = o;
                        }
                    }
                    if (bVar.getType() != 1) {
                        arrayList.add((n) bVar);
                    } else {
                        hVar2 = (h) bVar;
                        if (!bh.ov(hVar2.content)) {
                            if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                hVar = new h();
                                hVar.content = hVar2.content;
                                hVar.mvG = hVar2.mvG;
                                hVar.tRP = hVar2.tRP;
                                hVar.type = hVar2.type;
                                hVar.tRO = null;
                                arrayList.add(hVar);
                            } else {
                                hVar = (h) arrayList.get(arrayList.size() - 1);
                                hVar.content += hVar2.content;
                            }
                            if (i + 1 < this.jRt.size() && ((b) this.jRt.get(i + 1)).getType() == 1 && !bh.ov(((h) this.jRt.get(i + 1)).content)) {
                                hVar2 = (h) arrayList.get(arrayList.size() - 1);
                                hVar2.content += "<br/>";
                            }
                        } else if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                            hVar = new h();
                            hVar.content = "<br/>";
                            hVar.mvG = hVar2.mvG;
                            hVar.tRP = hVar2.tRP;
                            hVar.type = hVar2.type;
                            hVar.tRO = null;
                            arrayList.add(hVar);
                        } else {
                            hVar2 = (h) arrayList.get(arrayList.size() - 1);
                            hVar2.content += "<br/>";
                        }
                    }
                }
                i++;
            }
        }
        String replaceAll = Pattern.compile("</wx-", 2).matcher(Pattern.compile("<wx-", 2).matcher(str).replaceAll("<")).replaceAll("</");
        byte[] bytes;
        try {
            bytes = replaceAll.getBytes("UTF-8");
            int i2 = 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteDataManager", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
            boolean z = true;
            bytes = null;
        }
        this.tSF.CJ(8);
        this.tSF.TN("WeNoteHtmlFile");
        this.tSF.lt(true);
        this.tSF.TA(".htm");
        this.tSF.TD(com.tencent.mm.plugin.wenote.model.f.QI(this.tSF.toString()));
        o = com.tencent.mm.plugin.wenote.model.f.o(this.tSF);
        x.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", new Object[]{o});
        File file = new File(o);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Note.NoteDataManager", e2, "", new Object[0]);
                return null;
            }
        }
        if (i2 == 0 && com.tencent.mm.a.e.b(o, r2, r2.length) == 0) {
            this.tSF.TE(o);
            x.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
            return d.a(replaceAll, arrayList, this.tSF);
        }
        x.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
        Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.egt), 1).show();
        return null;
    }

    public final int a(b bVar, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3) {
        if (bVar == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        return a(arrayList, wXRTEditText, true, true, z, z2, z3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(ArrayList<b> arrayList, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (arrayList == null || arrayList.size() <= 0 || this.jRt == null) {
            x.e("MicroMsg.Note.NoteDataManager", "insertItemList,error,return");
            return -1;
        } else if (com.tencent.mm.plugin.wenote.model.c.bVN().tQn == null) {
            x.e("MicroMsg.Note.NoteDataManager", "insertItemList, but get wnnote base is null, return");
            return -1;
        } else if (z3 && ab(arrayList) && this.tSE != null) {
            this.tSE.bVZ();
            return -1;
        } else {
            b bVar;
            int type;
            h hVar;
            if (z) {
                bVar = (b) arrayList.get(arrayList.size() - 1);
                bVar.tRv = -1;
                bVar.tRt = true;
                bVar.tRz = false;
                if (wXRTEditText != null && wXRTEditText.tTI) {
                    if (wXRTEditText.tTw == 2) {
                        bVar.tRC = 2;
                    } else if (wXRTEditText.tTw == 1) {
                        bVar.tRC = 1;
                    }
                    wXRTEditText.tTI = false;
                    bVar.tRD = wXRTEditText.tRD;
                    wXRTEditText.tRD = 0;
                }
            }
            if (wXRTEditText != null && wXRTEditText.bWO() == 0 && wXRTEditText.tTw != 2 && wXRTEditText.getSelectionStart() == 0 && arrayList != null && arrayList.size() > 0) {
                type = ((b) arrayList.get(0)).getType();
                if (type == 2 || type == 6 || type == 5 || type == 3 || type == 4) {
                    hVar = new h();
                    hVar.content = "";
                    hVar.tRt = false;
                    hVar.tRz = false;
                    arrayList.add(0, hVar);
                }
            }
            synchronized (this) {
                int size;
                Iterator it;
                int i;
                boolean z6;
                if (wXRTEditText == null) {
                    size = size();
                    bWt();
                    it = arrayList.iterator();
                    i = size;
                    while (it.hasNext()) {
                        boolean z7;
                        bVar = (b) it.next();
                        b(bVar);
                        if (bVar == null || this.jRt == null) {
                            z7 = false;
                        } else {
                            this.jRt.add(bVar);
                            a(bVar, true);
                            z7 = true;
                        }
                        if (z7) {
                            type = i + 1;
                        } else {
                            type = i;
                        }
                        i = type;
                    }
                    z6 = false;
                } else {
                    int bWO = wXRTEditText.bWO();
                    b Bt = Bt(bWO);
                    if (Bt == null) {
                        return -1;
                    }
                    bWt();
                    if (wXRTEditText.tTw == 0 && Bt.getType() == 1) {
                        e bWN = wXRTEditText.bWN();
                        Editable text = wXRTEditText.getText();
                        CharSequence subSequence = text.subSequence(0, bWN.Ww);
                        CharSequence subSequence2 = text.subSequence(bWN.wq, text.length());
                        String a = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) subSequence);
                        String a2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) subSequence2);
                        hVar = (h) Bt;
                        if (!bh.ov(a)) {
                            hVar.content = a.endsWith("<br/>") ? a.substring(0, a.length() - 5) : a;
                            bWO++;
                            if (!bh.ov(a2)) {
                                bVar = new h();
                                bVar.type = 1;
                                if (a2.startsWith("<br/>")) {
                                    a2 = a2.substring(5, a2.length());
                                }
                                bVar.content = a2;
                                bVar.tRv = 0;
                                bVar.tRt = false;
                                bVar.tRz = false;
                                b(bWO, bVar);
                                size = bWO;
                                i = bWO;
                                z6 = true;
                            }
                            size = bWO;
                            i = bWO;
                            z6 = false;
                        } else if (bh.ov(a2)) {
                            Bu(bWO);
                            if (this.tSE != null) {
                                this.tSE.Bo(bWO);
                            }
                            size = bWO;
                            i = bWO;
                            z6 = false;
                        } else {
                            if (a2.startsWith("<br/>")) {
                                a2 = a2.substring(5, a2.length());
                            }
                            hVar.content = a2;
                            size = bWO;
                            i = bWO;
                            z6 = false;
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            bVar = (b) it2.next();
                            b(bVar);
                            if (b(i, bVar)) {
                                type = i + 1;
                            } else {
                                type = i;
                            }
                            i = type;
                        }
                    } else {
                        if (wXRTEditText.tTw != 1) {
                            size = bWO + 1;
                        } else {
                            size = bWO;
                        }
                        it = arrayList.iterator();
                        i = size;
                        while (it.hasNext()) {
                            bVar = (b) it.next();
                            b(bVar);
                            if (b(i, bVar)) {
                                type = i + 1;
                            } else {
                                type = i;
                            }
                            i = type;
                        }
                        z6 = false;
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(ArrayList<b> arrayList, int i, int i2, int i3, int i4) {
        if (arrayList == null || arrayList.size() <= 0 || this.jRt == null || i2 < 0 || i3 < 0 || i4 < 0 || i4 < i3) {
            x.e("MicroMsg.Note.NoteDataManager", "pasteItemList,error,return");
            return -1;
        } else if (com.tencent.mm.plugin.wenote.model.c.bVN().tQn == null) {
            x.e("MicroMsg.Note.NoteDataManager", "pasteItemList, but get wnnote base is null, return");
            return -1;
        } else {
            b bVar = (b) arrayList.get(arrayList.size() - 1);
            if (bVar == null) {
                x.e("MicroMsg.Note.NoteDataManager", "pasteItemList, lastInsertItem is null");
                return -1;
            }
            bVar.tRv = -1;
            bVar.tRt = true;
            bVar.tRz = false;
            b Bt = Bt(i2);
            if (Bt == null) {
                x.e("MicroMsg.Note.NoteDataManager", "pasteItemList, item is null");
                return -1;
            }
            synchronized (this) {
                bWt();
                boolean z;
                int i5;
                int i6;
                Iterator it;
                int i7;
                if (i == 0 && Bt.getType() == 1) {
                    Spanned QN = com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(((h) Bt).content);
                    if (QN == null || i3 > QN.length() || i4 > QN.length()) {
                        String str = "MicroMsg.Note.NoteDataManager";
                        String str2 = "pasteItemList error, oriText:%d  startOff:%d  endOff:%d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(QN == null ? -1 : QN.length());
                        objArr[1] = Integer.valueOf(i3);
                        objArr[2] = Integer.valueOf(i4);
                        x.e(str, str2, objArr);
                        return -1;
                    }
                    CharSequence subSequence = QN.subSequence(0, i3);
                    CharSequence subSequence2 = QN.subSequence(i4, QN.length());
                    String a = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) subSequence);
                    String a2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) subSequence2);
                    h hVar = (h) Bt;
                    if (!bh.ov(a)) {
                        hVar.content = a.endsWith("<br/>") ? a.substring(0, a.length() - 5) : a;
                        i2++;
                        if (!bh.ov(a2)) {
                            Bt = new h();
                            Bt.type = 1;
                            if (a2.startsWith("<br/>")) {
                                a2 = a2.substring(5, a2.length());
                            }
                            Bt.content = a2;
                            Bt.tRv = 0;
                            Bt.tRt = false;
                            Bt.tRz = false;
                            b(i2, Bt);
                            z = true;
                            i5 = i2;
                            i6 = i2;
                        }
                        z = false;
                        i6 = i2;
                        i5 = i2;
                    } else if (bh.ov(a2)) {
                        Bu(i2);
                        if (this.tSE != null) {
                            this.tSE.Bo(i2);
                        }
                        z = false;
                        i6 = i2;
                        i5 = i2;
                    } else {
                        if (a2.startsWith("<br/>")) {
                            a2 = a2.substring(5, a2.length());
                        }
                        hVar.content = a2;
                        z = false;
                        i6 = i2;
                        i5 = i2;
                    }
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        bVar = (b) it.next();
                        b(bVar);
                        if (b(i6, bVar)) {
                            i7 = i6 + 1;
                        } else {
                            i7 = i6;
                        }
                        i6 = i7;
                    }
                } else {
                    int i8;
                    if (i != 1) {
                        i8 = i2 + 1;
                    } else {
                        i8 = i2;
                    }
                    it = arrayList.iterator();
                    i6 = i8;
                    while (it.hasNext()) {
                        bVar = (b) it.next();
                        b(bVar);
                        if (b(i6, bVar)) {
                            i7 = i6 + 1;
                        } else {
                            i7 = i6;
                        }
                        i6 = i7;
                    }
                    i5 = i8;
                    z = false;
                }
            }
        }
    }

    private void b(b bVar) {
        if (bVar != null) {
            n nVar = (n) bVar;
            if (nVar.getType() > 1) {
                if (bh.ov(nVar.tRP)) {
                    if (this.tSG == 0 && this.jRt != null) {
                        Iterator it = this.jRt.iterator();
                        while (it.hasNext()) {
                            n nVar2 = (n) ((b) it.next());
                            if (nVar2.tRP.startsWith("WeNote_")) {
                                int i = bh.getInt(nVar2.tRP.substring(7), -1);
                                if (i <= this.tSG) {
                                    i = this.tSG;
                                }
                                this.tSG = i;
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("WeNote_");
                    int i2 = this.tSG + 1;
                    this.tSG = i2;
                    nVar.tRP = stringBuilder.append(i2).toString();
                }
                d dVar = com.tencent.mm.plugin.wenote.model.c.bVN().tQn;
                if (dVar == null) {
                    x.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", new Object[]{bVar.toString()});
                } else if (dVar.tQt == null) {
                    x.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", new Object[]{bVar.toString()});
                } else {
                    dVar.tQt.put(nVar.tRP, nVar);
                }
            }
            if (bh.ov(bVar.mvG)) {
                bVar.mvG = com.tencent.mm.plugin.wenote.model.f.QI(bVar.toString());
            }
        }
    }

    public final ArrayList<b> bWx() {
        if (this.jRt == null) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.jRt.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mm.plugin.wenote.b.c.c((b) it.next()));
            }
        }
        return arrayList;
    }

    public final boolean ab(ArrayList<b> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.getType() != 1) {
                i++;
            } else {
                stringBuilder.append(((h) bVar).content);
            }
        }
        return eq(com.tencent.mm.plugin.wenote.b.c.QV(stringBuilder.toString()), i);
    }

    public final boolean eq(int i, int i2) {
        boolean z;
        boolean z2;
        if (i < 0) {
            z = false;
        } else {
            z = true;
        }
        if (i2 < 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && this.tSH + i > 16384) {
            return true;
        }
        if (!z2 || this.tSI + i2 <= 30) {
            return false;
        }
        return true;
    }

    public final void bWy() {
        ar.Dm().F(new 3(this));
    }

    private void a(b bVar, boolean z) {
        if (bVar != null) {
            if (bVar.getType() == 1) {
                int QV = com.tencent.mm.plugin.wenote.b.c.QV(((h) bVar).content);
                if (z) {
                    this.tSH = QV + this.tSH;
                } else {
                    this.tSH -= QV;
                }
            } else if (z) {
                this.tSI++;
            } else {
                this.tSI--;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void er(int i, int i2) {
        x.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(true)});
        synchronized (this) {
            if (this.jRt == null) {
                return;
            }
            int i3;
            if (i <= 0) {
                i = 0;
            }
            if (i2 >= this.jRt.size()) {
                i2 = this.jRt.size() - 1;
                i3 = -1;
            } else {
                i3 = -1;
            }
            while (i2 > i) {
                b bVar = (b) this.jRt.get(i2);
                b bVar2 = (b) this.jRt.get(i2 - 1);
                if (bVar != null && bVar.getType() == 1 && bVar2 != null && bVar2.getType() == 1) {
                    i3 = i2 - 1;
                    h hVar = (h) bVar;
                    h hVar2 = (h) bVar2;
                    if (!bh.ov(hVar.content)) {
                        Spanned QN = com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(hVar.content);
                        Spanned QN2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(hVar2.content);
                        hVar2.content += "<br/>" + hVar.content;
                        if (hVar.tRt) {
                            hVar2.tRt = true;
                            hVar2.tRz = false;
                            if (hVar.tRv == -1 || hVar.tRv >= QN.length()) {
                                hVar2.tRv = -1;
                            } else {
                                hVar2.tRv = hVar.tRv + (QN2.length() + 1);
                            }
                        } else if (hVar2.tRt && hVar2.tRv == -1) {
                            hVar2.tRv = QN2.length();
                        }
                    } else if (hVar.tRt) {
                        hVar2.tRt = true;
                        hVar2.tRz = false;
                        hVar2.tRv = -1;
                    }
                    x.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem remove position: %d", new Object[]{Integer.valueOf(i2)});
                    Bu(i2);
                    if (this.tSE != null) {
                        this.tSE.Bo(i2);
                    }
                }
                i2--;
                i3 = i3;
            }
        }
    }

    public final String QQ(String str) {
        synchronized (this) {
            String replace;
            if (this.jRt != null) {
                int i = 0;
                String str2 = str;
                while (i < this.jRt.size()) {
                    if (((b) this.jRt.get(i)).getType() == 1) {
                        replace = com.tencent.mm.plugin.wenote.b.b.QT(((h) this.jRt.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
                        if (!bh.ov(replace)) {
                            int i2;
                            String[] split = replace.split("\n");
                            for (int i3 = 0; i3 < split.length; i3++) {
                                if (!bh.ov(split[i3].trim())) {
                                    replace = split[i3];
                                    i2 = 1;
                                    break;
                                }
                            }
                            replace = str2;
                            i2 = 0;
                            if (i2 != 0) {
                                break;
                            }
                            i++;
                            str2 = replace;
                        }
                    }
                    replace = str2;
                    i++;
                    str2 = replace;
                }
                replace = str2;
            } else {
                replace = str;
            }
        }
        if (replace.length() > 1000) {
            return replace.substring(0, 1000);
        }
        return replace;
    }

    public final int bWz() {
        synchronized (this) {
            if (this.jRt == null) {
                return -1;
            }
            int i = 0;
            while (i < this.jRt.size()) {
                b bVar = (b) this.jRt.get(i);
                if (bVar == null || bVar.getType() == -3 || bVar.getType() == -2) {
                    i++;
                } else {
                    return i;
                }
            }
            return -1;
        }
    }

    public final int bWA() {
        synchronized (this) {
            if (this.jRt == null) {
                return -1;
            }
            int size = this.jRt.size() - 1;
            while (size >= 0) {
                b bVar = (b) this.jRt.get(size);
                if (bVar == null || bVar.getType() == -3 || bVar.getType() == -2) {
                    size--;
                } else {
                    return size;
                }
            }
            return -1;
        }
    }
}
