package com.s.thrillo.controllers;

import com.s.thrillo.constants.KidFriendlyStatus;
import com.s.thrillo.entities.Bookmark;
import com.s.thrillo.entities.User;
import com.s.thrillo.managers.BookmarkManager;

public class BookmarkController {
private static BookmarkController instance = new BookmarkController();	
private BookmarkController() {}
public static BookmarkController getInstance() {
	 return instance;
}
public void saveBookmark(User user, Bookmark bookmark) {
	BookmarkManager.getInstance().saveBookmark(user,bookmark);
	
}
public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
	BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
	
}
public void share(User user, Bookmark bookmark) {
	BookmarkManager.getInstance().share(user, bookmark);
	
}

}
