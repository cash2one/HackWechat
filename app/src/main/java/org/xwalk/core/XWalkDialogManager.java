package org.xwalk.core;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import java.util.ArrayList;

public class XWalkDialogManager {
    public static final int DIALOG_ARCHITECTURE_MISMATCH = 4;
    public static final int DIALOG_DECOMPRESSING = 11;
    public static final int DIALOG_DOWNLOADING = 12;
    public static final int DIALOG_DOWNLOAD_ERROR = 6;
    public static final int DIALOG_NEWER_VERSION = 3;
    public static final int DIALOG_NOT_FOUND = 1;
    public static final int DIALOG_OLDER_VERSION = 2;
    public static final int DIALOG_SELECT_STORE = 7;
    public static final int DIALOG_SIGNATURE_CHECK_ERROR = 5;
    public static final int DIALOG_UNSUPPORTED_STORE = 8;
    private static final String TAG = "XWalkLib";
    private Dialog mActiveDialog;
    private AlertDialog mArchitectureMismatchDialog;
    private Context mContext;
    private ProgressDialog mDecompressingDialog;
    private AlertDialog mDownloadErrorDialog;
    private ProgressDialog mDownloadingDialog;
    private AlertDialog mNewerVersionDialog;
    private AlertDialog mNotFoundDialog;
    private AlertDialog mOlderVersionDialog;
    private AlertDialog mSelectStoreDialog;
    private AlertDialog mSignatureCheckErrorDialog;
    private AlertDialog mUnsupportedStoreDialog;

    public XWalkDialogManager(Context context) {
        this.mContext = context;
    }

    public void setAlertDialog(int i, AlertDialog alertDialog) {
        if ((alertDialog instanceof ProgressDialog) || (alertDialog instanceof DatePickerDialog) || (alertDialog instanceof TimePickerDialog)) {
            throw new IllegalArgumentException("The type of dialog must be AlertDialog");
        } else if (i == 1) {
            this.mNotFoundDialog = alertDialog;
        } else if (i == 2) {
            this.mOlderVersionDialog = alertDialog;
        } else if (i == 3) {
            this.mNewerVersionDialog = alertDialog;
        } else if (i == 4) {
            this.mArchitectureMismatchDialog = alertDialog;
        } else if (i == 5) {
            this.mSignatureCheckErrorDialog = alertDialog;
        } else if (i == 6) {
            this.mDownloadErrorDialog = alertDialog;
        } else if (i == 7) {
            this.mSelectStoreDialog = alertDialog;
        } else if (i == 8) {
            this.mUnsupportedStoreDialog = alertDialog;
        } else {
            throw new IllegalArgumentException("Invalid dialog id " + i);
        }
    }

    public void setProgressDialog(int i, ProgressDialog progressDialog) {
        if (i == 11) {
            this.mDecompressingDialog = progressDialog;
        } else if (i == 12) {
            this.mDownloadingDialog = progressDialog;
        } else {
            throw new IllegalArgumentException("Invalid dialog id " + i);
        }
    }

    public AlertDialog getAlertDialog(int i) {
        if (i == 1) {
            if (this.mNotFoundDialog == null) {
                this.mNotFoundDialog = buildAlertDialog();
                setTitle(this.mNotFoundDialog, R$string.startup_not_found_title);
                setMessage(this.mNotFoundDialog, R$string.startup_not_found_message);
                setPositiveButton(this.mNotFoundDialog, R$string.xwalk_get_crosswalk);
                setNegativeButton(this.mNotFoundDialog, R$string.xwalk_close);
            }
            return this.mNotFoundDialog;
        } else if (i == 2) {
            if (this.mOlderVersionDialog == null) {
                this.mOlderVersionDialog = buildAlertDialog();
                setTitle(this.mOlderVersionDialog, R$string.startup_older_version_title);
                setMessage(this.mOlderVersionDialog, R$string.startup_older_version_message);
                setPositiveButton(this.mOlderVersionDialog, R$string.xwalk_get_crosswalk);
                setNegativeButton(this.mOlderVersionDialog, R$string.xwalk_close);
            }
            return this.mOlderVersionDialog;
        } else if (i == 3) {
            if (this.mNewerVersionDialog == null) {
                this.mNewerVersionDialog = buildAlertDialog();
                setTitle(this.mNewerVersionDialog, R$string.startup_newer_version_title);
                setMessage(this.mNewerVersionDialog, R$string.startup_newer_version_message);
                setNegativeButton(this.mNewerVersionDialog, R$string.xwalk_close);
            }
            return this.mNewerVersionDialog;
        } else if (i == 4) {
            if (this.mArchitectureMismatchDialog == null) {
                this.mArchitectureMismatchDialog = buildAlertDialog();
                setTitle(this.mArchitectureMismatchDialog, R$string.startup_architecture_mismatch_title);
                setMessage(this.mArchitectureMismatchDialog, R$string.startup_architecture_mismatch_message);
                setPositiveButton(this.mArchitectureMismatchDialog, R$string.xwalk_get_crosswalk);
                setNegativeButton(this.mArchitectureMismatchDialog, R$string.xwalk_close);
            }
            return this.mArchitectureMismatchDialog;
        } else if (i == 5) {
            if (this.mSignatureCheckErrorDialog == null) {
                this.mSignatureCheckErrorDialog = buildAlertDialog();
                setTitle(this.mSignatureCheckErrorDialog, R$string.startup_signature_check_error_title);
                setMessage(this.mSignatureCheckErrorDialog, R$string.startup_signature_check_error_message);
                setNegativeButton(this.mSignatureCheckErrorDialog, R$string.xwalk_close);
            }
            return this.mSignatureCheckErrorDialog;
        } else if (i == 6) {
            if (this.mDownloadErrorDialog == null) {
                this.mDownloadErrorDialog = buildAlertDialog();
                setTitle(this.mDownloadErrorDialog, R$string.crosswalk_install_title);
                setMessage(this.mDownloadErrorDialog, R$string.download_failed_message);
                setPositiveButton(this.mDownloadErrorDialog, R$string.xwalk_retry);
                setNegativeButton(this.mDownloadErrorDialog, R$string.xwalk_cancel);
            }
            return this.mDownloadErrorDialog;
        } else if (i == 7) {
            if (this.mSelectStoreDialog == null) {
                this.mSelectStoreDialog = buildAlertDialog();
                setTitle(this.mSelectStoreDialog, R$string.crosswalk_install_title);
                setPositiveButton(this.mSelectStoreDialog, R$string.xwalk_continue);
            }
            return this.mSelectStoreDialog;
        } else if (i == 8) {
            if (this.mUnsupportedStoreDialog == null) {
                this.mUnsupportedStoreDialog = buildAlertDialog();
                setTitle(this.mUnsupportedStoreDialog, R$string.crosswalk_install_title);
                setMessage(this.mUnsupportedStoreDialog, R$string.unsupported_store_message);
                setNegativeButton(this.mUnsupportedStoreDialog, R$string.xwalk_close);
            }
            return this.mUnsupportedStoreDialog;
        } else {
            throw new IllegalArgumentException("Invalid dialog id " + i);
        }
    }

    public ProgressDialog getProgressDialog(int i) {
        if (i == 11) {
            if (this.mDecompressingDialog == null) {
                this.mDecompressingDialog = buildProgressDialog();
                setTitle(this.mDecompressingDialog, R$string.crosswalk_install_title);
                setMessage(this.mDecompressingDialog, R$string.decompression_progress_message);
                setNegativeButton(this.mDecompressingDialog, R$string.xwalk_cancel);
                this.mDecompressingDialog.setProgressStyle(0);
            }
            return this.mDecompressingDialog;
        } else if (i == 12) {
            if (this.mDownloadingDialog == null) {
                this.mDownloadingDialog = buildProgressDialog();
                setTitle(this.mDownloadingDialog, R$string.crosswalk_install_title);
                setMessage(this.mDownloadingDialog, R$string.download_progress_message);
                setNegativeButton(this.mDownloadingDialog, R$string.xwalk_cancel);
                this.mDownloadingDialog.setProgressStyle(1);
            }
            return this.mDownloadingDialog;
        } else {
            throw new IllegalArgumentException("Invalid dialog id " + i);
        }
    }

    void showInitializationError(int i, Runnable runnable, Runnable runnable2) {
        AlertDialog alertDialog;
        ArrayList arrayList = new ArrayList();
        if (i == 2) {
            alertDialog = getAlertDialog(1);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 3) {
            alertDialog = getAlertDialog(2);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 4) {
            alertDialog = getAlertDialog(3);
            arrayList.add(new ButtonAction(-2, runnable, true));
        } else if (i == 6) {
            alertDialog = getAlertDialog(4);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 7) {
            alertDialog = getAlertDialog(5);
            arrayList.add(new ButtonAction(-2, runnable, true));
        } else {
            throw new IllegalArgumentException("Invalid status " + i);
        }
        showDialog(alertDialog, arrayList);
    }

    void showDownloadError(Runnable runnable, Runnable runnable2) {
        AlertDialog alertDialog = getAlertDialog(6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-1, runnable2, true));
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(alertDialog, arrayList);
    }

    void showSelectStore(Runnable runnable, String str) {
        AlertDialog alertDialog = getAlertDialog(7);
        setMessage(alertDialog, this.mContext.getString(R$string.select_store_message).replace("STORE_NAME", str));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-1, runnable, true));
        showDialog(alertDialog, arrayList);
    }

    void showUnsupportedStore(Runnable runnable) {
        AlertDialog alertDialog = getAlertDialog(8);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, true));
        showDialog(alertDialog, arrayList);
    }

    void showDecompressProgress(Runnable runnable) {
        AlertDialog progressDialog = getProgressDialog(11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(progressDialog, arrayList);
    }

    void showDownloadProgress(Runnable runnable) {
        AlertDialog progressDialog = getProgressDialog(12);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(progressDialog, arrayList);
    }

    void dismissDialog() {
        this.mActiveDialog.dismiss();
        this.mActiveDialog = null;
    }

    void setProgress(int i, int i2) {
        ProgressDialog progressDialog = (ProgressDialog) this.mActiveDialog;
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(i2);
        progressDialog.setProgress(i);
    }

    boolean isShowingDialog() {
        return this.mActiveDialog != null && this.mActiveDialog.isShowing();
    }

    private AlertDialog buildAlertDialog() {
        AlertDialog create = new Builder(this.mContext).create();
        create.setIcon(17301543);
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    private ProgressDialog buildProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this.mContext);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    private void setTitle(AlertDialog alertDialog, int i) {
        alertDialog.setTitle(this.mContext.getString(i));
    }

    private void setMessage(AlertDialog alertDialog, int i) {
        setMessage(alertDialog, this.mContext.getString(i));
    }

    private void setMessage(AlertDialog alertDialog, String str) {
        CharSequence replaceAll = str.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
        if (replaceAll.startsWith("this")) {
            replaceAll = replaceAll.replaceFirst("this", "This");
        }
        alertDialog.setMessage(replaceAll);
    }

    private void setPositiveButton(AlertDialog alertDialog, int i) {
        alertDialog.setButton(-1, this.mContext.getString(i), null);
    }

    private void setNegativeButton(AlertDialog alertDialog, int i) {
        alertDialog.setButton(-2, this.mContext.getString(i), null);
    }

    private void showDialog(AlertDialog alertDialog, ArrayList<ButtonAction> arrayList) {
        alertDialog.setOnShowListener(new 1(this, arrayList, alertDialog));
        this.mActiveDialog = alertDialog;
        this.mActiveDialog.show();
    }
}
