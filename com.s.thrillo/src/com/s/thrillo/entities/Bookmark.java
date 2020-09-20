package com.s.thrillo.entities;

public abstract class Bookmark {
private long id;
private String title;
private String profileUrl;
private com.s.thrillo.constants.KidFriendlyStatus KidFriendlyStatus=com.s.thrillo.constants.KidFriendlyStatus.UNKNOWN;
private User KidFriendlyMarkedBy;
private User sharedBy;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getProfileUrl() {
	return profileUrl;
}
public void setProfileUrl(String profileUrl) {
	this.profileUrl = profileUrl;
}

public abstract boolean isKidFriendlyEligible();

public com.s.thrillo.constants.KidFriendlyStatus getKidFriendlyStatus() {
	return KidFriendlyStatus;
}
public void setKidFriendlyStatus(com.s.thrillo.constants.KidFriendlyStatus kidFriendlyStatus) {
	KidFriendlyStatus = kidFriendlyStatus;
}

public String getItemData() {
	// TODO Auto-generated method stub
	return getItemData();
}
public User getKidFriendlyMarkedBy() {
	return KidFriendlyMarkedBy;
}
public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
	KidFriendlyMarkedBy = kidFriendlyMarkedBy;
}
public User getSharedBy() {
	return sharedBy;
}
public void setSharedBy(User sharedBy) {
	this.sharedBy = sharedBy;
}

}