package com.tencent.smtt.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class v$c {
    private final String zYC;
    private final String zYD;

    public v$c(String str, String str2) {
        this.zYC = str;
        this.zYD = str2;
    }

    public final void cEP() {
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        RandomAccessFile randomAccessFile;
        int parseInt;
        int read;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        Throwable th2;
        ZipOutputStream zipOutputStream2;
        FileOutputStream fileOutputStream2;
        RandomAccessFile randomAccessFile2 = null;
        try {
            fileOutputStream = new FileOutputStream(this.zYD);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                try {
                    byte[] bArr = new byte[2048];
                    String str = this.zYC;
                    try {
                        fileInputStream = new FileInputStream(str);
                        try {
                            bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                        } catch (Exception e) {
                            bufferedInputStream = null;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            randomAccessFile = new RandomAccessFile(new File(this.zYD), "rw");
                            parseInt = Integer.parseInt("00001000", 2);
                            randomAccessFile.seek(7);
                            read = randomAccessFile.read();
                            if ((read & parseInt) > 0) {
                                randomAccessFile.seek(7);
                                randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                            }
                            try {
                                randomAccessFile.close();
                            } catch (IOException e4) {
                            }
                            zipOutputStream.close();
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e5) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e6) {
                                }
                            }
                            throw th;
                        }
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                            while (true) {
                                int read2 = bufferedInputStream.read(bArr, 0, 2048);
                                if (read2 == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read2);
                            }
                            zipOutputStream.flush();
                            zipOutputStream.closeEntry();
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e7) {
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException e8) {
                            }
                        } catch (Exception e9) {
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            randomAccessFile = new RandomAccessFile(new File(this.zYD), "rw");
                            parseInt = Integer.parseInt("00001000", 2);
                            randomAccessFile.seek(7);
                            read = randomAccessFile.read();
                            if ((read & parseInt) > 0) {
                                randomAccessFile.seek(7);
                                randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                            }
                            randomAccessFile.close();
                            zipOutputStream.close();
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                            th2 = th4;
                            bufferedInputStream2 = bufferedInputStream;
                            th = th2;
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e10) {
                        bufferedInputStream = null;
                        fileInputStream = null;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        randomAccessFile = new RandomAccessFile(new File(this.zYD), "rw");
                        parseInt = Integer.parseInt("00001000", 2);
                        randomAccessFile.seek(7);
                        read = randomAccessFile.read();
                        if ((read & parseInt) > 0) {
                            randomAccessFile.seek(7);
                            randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                        }
                        randomAccessFile.close();
                        zipOutputStream.close();
                        fileOutputStream.close();
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                    try {
                        randomAccessFile = new RandomAccessFile(new File(this.zYD), "rw");
                        try {
                            parseInt = Integer.parseInt("00001000", 2);
                            randomAccessFile.seek(7);
                            read = randomAccessFile.read();
                            if ((read & parseInt) > 0) {
                                randomAccessFile.seek(7);
                                randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                            }
                            randomAccessFile.close();
                        } catch (Exception e11) {
                            randomAccessFile2 = randomAccessFile;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e12) {
                                }
                            }
                            zipOutputStream.close();
                            fileOutputStream.close();
                        } catch (Throwable th42) {
                            th2 = th42;
                            randomAccessFile2 = randomAccessFile;
                            th = th2;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e13) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e14) {
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        zipOutputStream.close();
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                        th = th6;
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        throw th;
                    }
                    try {
                        zipOutputStream.close();
                    } catch (IOException e15) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e16) {
                    }
                } catch (Exception e17) {
                    zipOutputStream2 = zipOutputStream;
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th7) {
                    th = th7;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e18) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e20) {
                fileOutputStream2 = fileOutputStream;
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e21) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e22) {
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                zipOutputStream = null;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e23) {
            fileOutputStream2 = null;
            if (zipOutputStream2 != null) {
                zipOutputStream2.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th9) {
            th = th9;
            zipOutputStream = null;
            fileOutputStream = null;
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
