package com.s.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.s.thrillo.constants.MovieGenre;
import com.s.thrillo.managers.BookmarkManager;

public class MovieTest {

	@Test
	public void testIsKidFriendlyEligible() {
		// Test1:
		Movie movie=BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.HORROR,8.5);
            boolean isKidFriendlyEligible= movie.isKidFriendlyEligible();
        assertFalse("For Horror in movie -- isKidFriendlyEligible() must return false",isKidFriendlyEligible);  
        
        //Test2:
    	movie=BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.THRILLERS,8.5);
            isKidFriendlyEligible= movie.isKidFriendlyEligible();
            assertFalse("For Thrillers in movie-- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
	}

}
