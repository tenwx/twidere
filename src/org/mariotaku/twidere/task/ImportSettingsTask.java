package org.mariotaku.twidere.task;

import android.content.Context;

import org.mariotaku.twidere.util.AsyncTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ImportSettingsTask extends AsyncTask<Void, Void, Boolean> {

	private final Context mContext;
	private final File mFile;

	ImportSettingsTask(final Context context, final File file) {
		mContext = context;
		mFile = file;
	}

	@Override
	protected Boolean doInBackground(final Void... params) {
		if (mFile == null || !mFile.exists()) return false;
		try {
			final ZipFile zip = new ZipFile(mFile);
			
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
