package com.general;

import java.security.SecureRandom;

public class Session {
	
	private byte[] mSessionID = new byte[16];
	
	public Session() {
			new SecureRandom().nextBytes(mSessionID);
	}

	public byte[] getSessionID() {
		return mSessionID;
	}
	
}
