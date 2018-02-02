package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public class j$a {
    String filePath;
    int ftE;
    u knb;
    er kne;
    LinkedList<u> knf;
    boolean kng = true;
    String knh;
    boolean kni;
    EmojiInfo kqm;

    public j$a(String str, er erVar, LinkedList<u> linkedList, int i, boolean z, boolean z2, u uVar) {
        this.filePath = str;
        this.kne = erVar;
        this.knf = linkedList;
        this.ftE = i;
        this.kng = z;
        this.kni = z2;
        this.knb = uVar;
    }

    public j$a(String str, er erVar, LinkedList<u> linkedList, int i, boolean z, String str2, boolean z2) {
        this.filePath = str;
        this.kne = erVar;
        this.knf = linkedList;
        this.ftE = i;
        this.kng = z;
        this.knh = str2;
        this.kni = z2;
        this.knb = null;
    }

    public j$a(String str, er erVar, LinkedList<u> linkedList, boolean z, boolean z2, EmojiInfo emojiInfo) {
        this.filePath = str;
        this.kne = erVar;
        this.knf = linkedList;
        this.ftE = 5;
        this.kng = z;
        this.kni = z2;
        this.knb = null;
        this.kqm = emojiInfo;
    }
}
