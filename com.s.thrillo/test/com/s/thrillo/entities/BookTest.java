package com.s.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.s.thrillo.constants.BookGenre;
import com.s.thrillo.managers.BookmarkManager;

public class BookTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test1:
		Book book=BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
          boolean isKidFriendlyEligible= book.isKidFriendlyEligible();
          assertFalse("For Philosophy in book -- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
          
          //Test2:
      	book=BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.SELF_HELP,4.3);
            isKidFriendlyEligible= book.isKidFriendlyEligible();
            assertFalse("For SelfHelp in book -- isKidFriendlyElgible must return false",isKidFriendlyEligible);
	}

}
