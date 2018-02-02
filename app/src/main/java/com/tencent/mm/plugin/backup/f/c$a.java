package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.FileInputStream;
import java.util.HashSet;

class c$a {
    private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
    String filePath = null;
    int hlp = 0;
    private HashSet<c> koY = new HashSet();
    byte[] koZ = null;
    private FileInputStream kpa = null;
    int offset = 0;

    static /* synthetic */ boolean a(c$a com_tencent_mm_plugin_backup_f_c_a, c cVar) {
        if (!com_tencent_mm_plugin_backup_f_c_a.koY.contains(cVar) && cVar.koS.ktS == 2) {
            x.e(TAG, "checkSceneAllFinish Error!! media scene not in sceneHashSet");
        }
        com_tencent_mm_plugin_backup_f_c_a.koY.remove(cVar);
        return com_tencent_mm_plugin_backup_f_c_a.koY.isEmpty();
    }

    public c$a(String str) {
        int i;
        this.filePath = str;
        this.koZ = null;
        String str2 = this.filePath;
        ar.Hg();
        if (str2.startsWith(c.Fp())) {
            EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
            if (yc == null) {
                i = 0;
            } else if ((yc.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
                i = 0;
            } else {
                this.koZ = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(yc);
                i = bh.bx(this.koZ) <= 0 ? 0 : 1;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            this.hlp = bh.bx(this.koZ);
        } else {
            this.hlp = e.bN(this.filePath);
        }
        if (this.hlp < 0) {
            this.hlp = 0;
        }
    }

    final boolean b(byte[] bArr, boolean z) {
        try {
            if (this.kpa == null) {
                this.kpa = new FileInputStream(this.filePath);
            }
            if (this.kpa.read(bArr) != bArr.length) {
                return false;
            }
            if (z) {
                this.kpa.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
