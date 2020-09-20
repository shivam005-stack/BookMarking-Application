package com.s.thrill;

import java.util.List;

import com.s.thrillo.constants.KidFriendlyStatus;
import com.s.thrillo.constants.UserType;
import com.s.thrillo.controllers.BookmarkController;
import com.s.thrillo.entities.Bookmark;
import com.s.thrillo.entities.User;
import com.s.thrillo.managers.BookmarkManager;
import com.s.thrillo.partner.Shareable;

public class View {
	 public static void browse(User user,List<List<Bookmark>> bookmarks) {
		 System.out.println("\n"+ user.getEmail() + "is browsing items");
		     int bookmarkCount=0;
		     
		     for(List<Bookmark> bookmarkList:bookmarks) {
		    	 for(Bookmark bookmark: bookmarkList) {
		    		  // BookmarKing!!
		    		      //if(bookmarkCount< DataStore.USER_BOOKMARK_LIMIT) {
		    		    	  boolean isBookmarked= getBookmarkDecision(bookmark);
		    		    	 if(isBookmarked) {
		    		    		 bookmarkCount++;
		    		    		 BookmarkController.getInstance().saveBookmark(user, bookmark);
		    		    		 System.out.println("New Item Bookmarked..." + bookmark);
		    		    	 }
		    		      //}
		    		      
		  		        if(user.getUserType().equals(UserType.EDITOR)|| user.getUserType().equals(UserType.CHIEF_EDITOR)) {
		  		        	 // Mark as KidFriendly
		  		        	 if(bookmark.isKidFriendlyEligible() &&
		  		        			 bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
		  		        		 KidFriendlyStatus KidFriendlyStatus= getKidFriendlyStatusDecision(bookmark);
		  		        		  if(!KidFriendlyStatus.equals(com.s.thrillo.constants.KidFriendlyStatus.UNKNOWN)) {
		  		        			  BookmarkManager.getInstance().setKidFriendlyStatus(user, KidFriendlyStatus, bookmark);
		  		        			  
		  		        		  }
		  		        	 }
		  		        	    //Sharing!!
		  		        	   if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
		  		        			   && bookmark instanceof Shareable) {
		  		        		   boolean isShared= getShareDecision();
		  		        		   if(isShared) {
		  		        			   BookmarkController.getInstance().share(user, bookmark);
		  		        		   }
		  		        	   }
		  		        }
		    	 }
		     }
	 }
 private static boolean getShareDecision() {
		// TODO Auto-generated method stub
	 return Math.random() < 0.5 ? true:false;
	}
private static KidFriendlyStatus getKidFriendlyStatusDecision(Bookmark bookmark) {
		 return Math.random() <0.4 ? KidFriendlyStatus.APPROVED:
			 (Math.random() >=0.4 && Math.random() <0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
		
	}
private static boolean getBookmarkDecision(Bookmark bookmark) {
		   return Math.random() < 0.5 ? true:false;
		 
	}

	
}
