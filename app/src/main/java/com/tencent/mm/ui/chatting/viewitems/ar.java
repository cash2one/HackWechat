package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;

public class ar extends c {
    public String chatroomName;
    public String desc;
    public String designerName;
    public String designerRediretctUrl;
    public int designerUIN;
    public g$a fEt;
    public String fGA;
    public String fGz;
    public String fLC;
    public String fqV;
    public String gjD;
    public String hdm;
    public String iconUrl;
    public int pageType;
    public int position;
    public String secondUrl;
    public int tid;
    public String title;
    public long ttf;
    public int ttg;
    public String userName;
    public boolean yOD;
    public String yOE;
    public boolean yOF;
    public boolean yOG;
    public String yOH;
    public boolean yOI;
    public String yOJ;
    public Bundle yOK;
    public boolean ypn;

    public ar(au auVar, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        this.fEJ = auVar;
        this.ypn = false;
        this.position = i;
        this.userName = str;
        this.yOD = false;
        this.title = str2;
        this.fGz = str3;
        this.fGA = str4;
        this.yOE = str5;
        this.designerUIN = i2;
        this.designerName = str6;
        this.designerRediretctUrl = str7;
        this.gjD = str8;
    }

    public ar(au auVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        this.fEJ = auVar;
        this.ypn = z;
        this.position = i;
        this.userName = str;
        this.yOD = z2;
        this.title = str2;
        this.fGz = str3;
        this.fGA = str4;
        this.yOE = str5;
        this.fqV = str6;
        this.gjD = str7;
        this.yOF = z3;
        this.yOG = z4;
    }

    public ar(au auVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5) {
        this(auVar, z, i, str, z2, str2, str3, str4, str5, null, null, false, false);
    }

    public ar(au auVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4) {
        this(auVar, z, i, str, z2, str2, str3, str4, null);
    }

    private ar(au auVar, boolean z, int i, String str, boolean z2) {
        this(auVar, z, i, str, false, null, null, null);
    }

    private ar(au auVar, boolean z, int i, String str) {
        this(auVar, z, i, str, false);
    }

    public ar(au auVar, boolean z, int i, String str, byte b) {
        this(auVar, z, i, str);
    }

    public ar(au auVar, boolean z, int i, String str, String str2) {
        this(auVar, z, i, str);
        this.chatroomName = str2;
    }

    public ar(au auVar, String str) {
        this(str);
        this.fEJ = auVar;
    }

    private ar(String str) {
        this.userName = str;
    }

    public ar(String str, String str2) {
        this.userName = str;
        this.chatroomName = str2;
    }

    public ar(au auVar, String str, String str2) {
        this.fEJ = auVar;
        this.userName = str;
        this.fEJ = auVar;
        this.yOJ = str2;
    }

    public static ar Zx(String str) {
        ar arVar = new ar();
        arVar.gjD = str;
        return arVar;
    }

    public static ar a(g$a com_tencent_mm_y_g_a, au auVar) {
        ar arVar = new ar();
        arVar.fEt = com_tencent_mm_y_g_a;
        arVar.fEJ = auVar;
        return arVar;
    }

    public static ar b(au auVar, boolean z, int i) {
        ar arVar = new ar();
        arVar.fEJ = auVar;
        arVar.ypn = z;
        arVar.position = i;
        arVar.yOI = false;
        return arVar;
    }
}
