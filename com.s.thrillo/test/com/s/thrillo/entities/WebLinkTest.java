package com.s.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.s.thrillo.managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test1: porn in url-- false
		WebLink webLink = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");
		  boolean isKidFriendlyEligible= webLink.isKidFriendlyEligible();
		  assertFalse(" For porn in url -- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		  
		    //Test2: porn in title-- false
		 webLink= BookmarkManager.getInstance().createWebLink(2000,"Taming porn, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		isKidFriendlyEligible= webLink.isKidFriendlyEligible();
		assertFalse("For porn in title -- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		
		//Test3: adult in host-- false
		webLink =BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.adult.com");
		isKidFriendlyEligible= webLink.isKidFriendlyEligible();
		assertFalse("For adult in host -- isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		 //Test4: adult in url, but not in host -- true
		webLink=BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--adult-2.html","http://www.javaworld.com");
	    isKidFriendlyEligible=	webLink.isKidFriendlyEligible();
	    assertTrue("For adult in url,but not in host -- isKidFriendlyEligible() must return true",isKidFriendlyEligible);
	    
	      //Test5: adult in title -- true
	    webLink=BookmarkManager.getInstance().createWebLink(2000,"Taming adult, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
	       isKidFriendlyEligible= webLink.isKidFriendlyEligible();
	         assertTrue("For adult in title -- isKidFriendlyEligible() must return true ",isKidFriendlyEligible);
	}

}
