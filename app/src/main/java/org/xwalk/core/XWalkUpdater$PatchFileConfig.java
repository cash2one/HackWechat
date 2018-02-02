package org.xwalk.core;

public class XWalkUpdater$PatchFileConfig {
    public String originalFileName;
    public int originalFileType;
    public String patchEndFileMd5;
    public String patchFileName;
    public int type;

    public boolean isTypeAdd() {
        return this.type == 1;
    }

    public boolean isTypeModify() {
        return this.type == 2;
    }

    public boolean isTypeRemove() {
        return this.type == 3;
    }

    public boolean isOriginalFileTypeApk() {
        return this.originalFileType == 1;
    }

    public boolean isExtractedFile() {
        return this.originalFileType == 2;
    }

    public String toString() {
        return "PatchFileConfig type:" + this.type + ",originalFileType:" + this.originalFileType + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName + ",patchEndFileMd5:" + this.patchEndFileMd5;
    }
}
