package org.mariotaku.twidere;

interface ITwidereService {
	int getHomeTimeline(in long[] account_ids, in long[] max_ids);
	int getMentions(in long[] account_ids, in long[] max_ids);
	int getMessages(in long account_id, in long max_id);
	int updateStatus(in long[] account_ids, String content, in Location location, in Uri image_uri, long in_reply_to);
	int destroyStatus(long account_id, long status_id);
	int retweetStatus(long account_ids, long status_id);
	int cancelRetweet(long account_id, long status_id);
	int createFavorite(long account_ids, long status_id);
	int destroyFavorite(long account_id, long status_id);
	int createFriendship(long account_id, long user_id);
	int destroyFriendship(long account_id, long user_id);
	int updateProfile(long account_id, String name, String url, String location, String description);
	int updateProfileImage(long account_id, in Uri image_uri);
	boolean isHomeTimelineRefreshing();
	boolean isMentionsRefreshing();
	boolean hasActivatedTask();
	boolean test();
}