package com.s.thrillo.managers;

import java.util.List;

import com.s.thrillo.constants.BookGenre;
import com.s.thrillo.constants.KidFriendlyStatus;
import com.s.thrillo.constants.MovieGenre;
import com.s.thrillo.dao.BookmarkDao;
import com.s.thrillo.entities.Book;
import com.s.thrillo.entities.Bookmark;
import com.s.thrillo.entities.Movie;
import com.s.thrillo.entities.User;
import com.s.thrillo.entities.UserBookmark;
import com.s.thrillo.entities.WebLink;


public class BookmarkManager {
private static BookmarkManager instance = new BookmarkManager();
private static BookmarkDao dao = new BookmarkDao();
private BookmarkManager() {}
public static BookmarkManager getInstance () {
	return instance;
}
  public WebLink createWebLink(long id,String title, String profileUrl, String url, String host) {
	   WebLink webLink = new WebLink();
	   webLink.setId(id);
	   webLink.setTitle(title);
	   webLink.setProfileUrl(profileUrl);
	   webLink.setUrl(url);
	   webLink.setHost(host);
	     return webLink;
  }
 public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, BookGenre genre, double amazonRating) {
	 Book book = new Book();
	 book.setId(id);
	 book.setTitle(title);
	 book.setPublicationYear(publicationYear);
	 book.setPublisher(publisher);
	 book.setAuthors(authors);
	 book.setGenre(genre);
	 book.setAmazonRating(amazonRating);
	   return book;
 }  
  public Movie createMovie(long id,String title ,String profileUrl,int releaseYear, String[] cast, String[] directors, MovieGenre genre, double imdbRating)
  {
	  Movie movie = new Movie();
	  movie.setId(id);
	  movie.setTitle(title);
	  movie.setProfileUrl(profileUrl);
	  movie.setReleaseYear(releaseYear);
	  movie.setCast(cast);
	  movie.setDirectors(directors);
	  movie.setGenre(genre);
	  movie.setImdbRating(imdbRating);
	    return movie;
  }
   public List<List<Bookmark>> getBookmarks(){
	    return dao.getBookmarks();
   }
public void saveBookmark(User user, Bookmark bookmark) {
	UserBookmark userBookmark = new UserBookmark();
	userBookmark.setUser(user);
	userBookmark.setBookmark(bookmark);
	   
	/*if (bookmark instanceof WebLink) {
		try {				
			String url = ((WebLink)bookmark).getUrl();
			if (!url.endsWith(".pdf")) {
				String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
				if (webpage != null) {
					IOUtil.write(webpage, bookmark.getId());
				}
			}				
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	   dao.saveUserBookmark(userBookmark);
}
public void setKidFriendlyStatus(User user,KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
     bookmark.setKidFriendlyStatus(kidFriendlyStatus);
	bookmark.setKidFriendlyMarkedBy(user);
	dao.updateKidFriendlyStatus(bookmark);
	System.out.println("KidFriendlyStatus:" + kidFriendlyStatus + ",Marked By:" + user.getEmail() + "," + bookmark);
	
}
public void share(User user, Bookmark bookmark) {
	bookmark.setSharedBy(user);
	System.out.println("Data to be Shared:");
	if(bookmark instanceof Book) {
		System.out.println(((Book)bookmark).getItemData());
		
	}else if(bookmark instanceof WebLink) {
		System.out.println(((WebLink)bookmark).getItemData());
}

     dao.sharedByInfo(bookmark);

}
}
