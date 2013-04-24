/*
 *				Twidere - Twitter client for Android
 * 
 * Copyright (C) 2012 Mariotaku Lee <mariotaku.lee@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.loader;

import android.content.Context;
import android.os.Bundle;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.mariotaku.jsonserializer.JSONSerializer;
import org.mariotaku.twidere.BuildConfig;
import org.mariotaku.twidere.model.ParcelableStatus;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;

public class UserTimelineLoader extends Twitter4JStatusLoader {

	private final long mUserId;
	private final String mUserScreenName;
	private int mTotalItemsCount;

	public UserTimelineLoader(final Context context, final long account_id, final long user_id, final String screen_name,
			final long max_id, final long since_id, final List<ParcelableStatus> data, final String[] saved_statuses_args, final int tab_position) {
		super(context, account_id, max_id, since_id, data, saved_statuses_args, tab_position);
		mUserId = user_id;
		mUserScreenName = screen_name;
	}

	@Override
	public ResponseList<Status> getStatuses(final Paging paging) throws TwitterException {
		if (mTwitter == null) return null;
		if (mUserId != -1) {
			if (mTotalItemsCount == -1) {
				try {
					mTotalItemsCount = mTwitter.showUser(mUserId).getStatusesCount();
				} catch (final TwitterException e) {
					mTotalItemsCount = -1;
				}
			}
			return mTwitter.getUserTimeline(mUserId, paging);
		} else if (mUserScreenName != null) return mTwitter.getUserTimeline(mUserScreenName, paging);
		return null;
	}

	public int getTotalItemsCount() {
		return mTotalItemsCount;
	}

}
