package org.xwalk.core;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class XWalkDecompressor$DecompressResourceTask implements Callable<Boolean> {
    File mDestFile;
    ZipEntry mZipEntry;
    ZipFile mZipFile;

    XWalkDecompressor$DecompressResourceTask(ZipFile zipFile, ZipEntry zipEntry, File file) {
        this.mZipFile = zipFile;
        this.mZipEntry = zipEntry;
        this.mDestFile = file;
    }

    public Boolean call() {
        try {
            Log.d("XWalkLib", "Decompressing " + this.mZipEntry.getName());
            XWalkDecompressor.access$000(this.mZipFile.getInputStream(this.mZipEntry), this.mDestFile);
            return Boolean.valueOf(true);
        } catch (IOException e) {
            Log.e("XWalkLib", e.getLocalizedMessage());
            return Boolean.valueOf(false);
        }
    }
}
