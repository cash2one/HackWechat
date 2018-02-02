package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.regex.Pattern;

public class d {
    public static d lvC;
    public boolean lvD = false;
    private Pattern lvE = Pattern.compile("_\\d");

    public static d aAQ() {
        if (lvC == null) {
            synchronized (d.class) {
                lvC = new d();
            }
        }
        return lvC;
    }

    public final void ya(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (this.lvD) {
                        if (file2.isDirectory()) {
                            ya(file2.getPath());
                        } else {
                            Object name = file2.getName();
                            if (this.lvE.matcher(name).find() || name.startsWith("temp")) {
                                file2.delete();
                            }
                        }
                        i++;
                    } else {
                        x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
                        return;
                    }
                }
            }
        }
    }

    public final void yb(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        yb(file2.getPath());
                    } else {
                        file2.getName();
                        file2.delete();
                    }
                }
            }
        }
    }
}
