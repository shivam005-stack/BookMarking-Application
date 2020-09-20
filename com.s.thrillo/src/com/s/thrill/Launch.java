package com.s.thrill;

import java.util.ArrayList;
import java.util.List;

import com.s.thrillo.bgjobs.WebPageDownLoaderTask;
import com.s.thrillo.entities.Bookmark;
import com.s.thrillo.entities.User;
import com.s.thrillo.managers.BookmarkManager;
import com.s.thrillo.managers.UserManager;

public class Launch {
 private static List<User> users;	
 private static List<List<Bookmark>> bookmarks;
 
	private static void loadData() {
		System.out.println("1.Loading Data...");
		DataStore.loadData();
		 
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
		 //System.out.println("Printing Data...");
		 //printUserData();
		 //printBookmarkData();
	}	

	private static void printUserData() {
		 for(User user:users) {
			 System.out.println(user);
		 }
		
	}
	private static void printBookmarkData() {
		   for(List<Bookmark> bookmarkList:bookmarks) {
			   for(Bookmark bookmark: bookmarkList) {
				    System.out.println(bookmark);
			   }
		   }
	}
	 private static void start() {
		 //System.out.println("\n 2.BookMarking...");
		 for(User user:users) {
			 View.browse(user, bookmarks);
		 }
		}
	 
	public static void main(String[] args) {
		loadData();
          start();
          
          //Background Jobs
           runDownLoaderJob();
	}

	private static void runDownLoaderJob() {
		 WebPageDownLoaderTask task = new WebPageDownLoaderTask(true);
		  (new Thread(task)).start();
		  
	}
	
}
