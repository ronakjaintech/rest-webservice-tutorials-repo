package in.ronak.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.ronak.messenger.database.DatabaseClass;
import in.ronak.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService () {
		profiles.put("vinkrish", new Profile(1L, "vinkrish", "Vinay", "Krishna"));
		profiles.put("krishvin", new Profile(2L, "krishvin", "Krishna", "Vinay"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			System.out.println("null");
			return null;
		} 
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	

}
