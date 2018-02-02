package com.tencent.mm.plugin.clean.c;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.clean.c.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class c$b extends a {
    private String filePath;
    private long fileSize;
    final /* synthetic */ c lfu;
    int lfv = 0;

    public c$b(c cVar, String str) {
        this.lfu = cVar;
        super(cVar);
        this.filePath = str;
        this.fileSize = 0;
    }

    public final String TL() {
        return "filePath[" + this.filePath + "] scanCount[" + this.lfv + "]" + super.TL();
    }

    public final void execute() {
        String str;
        int[] l;
        if (xn(this.filePath) && c.k(this.lfu)) {
            x.i("MicroMsg.CleanController", "Delete[%b] temp folder: %s ", new Object[]{Boolean.valueOf(c.k(this.lfu)), this.filePath});
            deleteFile(this.filePath);
            File parentFile = new File(this.filePath).getParentFile();
            if (parentFile.list() == null || parentFile.list().length == 0) {
                parentFile.delete();
            }
        } else {
            xo(this.filePath);
        }
        if (c.a(this.lfu, this.filePath)) {
            c.a(this.lfu, c.d(this.lfu) + this.fileSize);
        } else {
            str = this.filePath;
            ar.Hg();
            if (str.startsWith(c.FC())) {
                c.b(this.lfu, c.c(this.lfu) + this.fileSize);
            }
        }
        if (xn(this.filePath)) {
            l = c.l(this.lfu);
            l[1] = (int) (((long) l[1]) + this.fileSize);
        } else {
            str = this.filePath;
            ar.Hg();
            if (str.startsWith(c.FC())) {
                l = c.l(this.lfu);
                l[0] = (int) (((long) l[0]) + this.fileSize);
            } else {
                l = c.l(this.lfu);
                l[2] = (int) (((long) l[2]) + this.fileSize);
            }
        }
        if (this.filePath.endsWith(File.separator + "image2")) {
            l = c.l(this.lfu);
            l[3] = (int) (((long) l[3]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            l = c.l(this.lfu);
            l[4] = (int) (((long) l[4]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            l = c.l(this.lfu);
            l[5] = (int) (((long) l[5]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "voice2")) {
            l = c.l(this.lfu);
            l[6] = (int) (((long) l[6]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "WeiXin")) {
            l = c.l(this.lfu);
            l[7] = (int) (((long) l[7]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "WeChat")) {
            l = c.l(this.lfu);
            l[8] = (int) (((long) l[8]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "xlog")) {
            l = c.l(this.lfu);
            l[9] = (int) (((long) l[9]) + this.fileSize);
        }
    }

    private void deleteFile(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    deleteFile(str + File.separator + str2);
                }
            }
            x.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[]{str});
            file.delete();
            return;
        }
        x.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[]{str});
        c.c(this.lfu, c.a(this.lfu) + file.length());
        file.delete();
    }

    private static boolean xn(String str) {
        if (str.length() <= c.ayf() || str.substring(c.ayf()).indexOf("temp") != 0) {
            return false;
        }
        return true;
    }

    private void xo(String str) {
        int i = 0;
        this.lfv++;
        if (str.endsWith(File.separator + "sns")) {
            x.i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", new Object[]{str});
            xp(str);
        } else if (str.endsWith(File.separator + "music")) {
            x.i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", new Object[]{str});
            xq(str);
        } else {
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        xo(str + "/" + list[i]);
                        i++;
                    }
                    return;
                }
                return;
            }
            i = e.bN(str);
            c.d(this.lfu, (long) i);
            this.fileSize = ((long) i) + this.fileSize;
        }
    }

    private void xp(String str) {
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    xp(str + "/" + list[i]);
                    i++;
                }
            }
        } else if (System.currentTimeMillis() - file.lastModified() <= c.ayg().longValue() || !c.k(this.lfu)) {
            i = e.bN(str);
            c.d(this.lfu, (long) i);
            this.fileSize = ((long) i) + this.fileSize;
        } else {
            x.v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", new Object[]{str});
            file.delete();
        }
    }

    private void xq(String str) {
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    xq(str + "/" + list[i]);
                    i++;
                }
            }
        } else if (System.currentTimeMillis() - file.lastModified() <= c.ayh().longValue() || !c.k(this.lfu)) {
            i = e.bN(str);
            c.d(this.lfu, (long) i);
            this.fileSize = ((long) i) + this.fileSize;
        } else {
            x.v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", new Object[]{str});
            file.delete();
        }
    }
}
