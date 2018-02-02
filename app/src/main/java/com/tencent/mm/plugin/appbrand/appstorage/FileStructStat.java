package com.tencent.mm.plugin.appbrand.appstorage;

public final class FileStructStat {
    public long st_atime;
    public long st_ctime;
    public int st_mode;
    public long st_mtime;
    public long st_size;

    public final void fillAnother(FileStructStat fileStructStat) {
        if (fileStructStat != null) {
            fileStructStat.st_mode = this.st_mode;
            fileStructStat.st_size = this.st_size;
            fileStructStat.st_atime = this.st_atime;
            fileStructStat.st_mtime = this.st_mtime;
            fileStructStat.st_ctime = this.st_ctime;
        }
    }
}
