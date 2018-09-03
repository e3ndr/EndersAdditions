package enders.additions.handlers;

import com.sun.istack.internal.Nullable;

import net.minecraftforge.common.DimensionManager;

public class modDimensions {
    //shadow realm
	 public static final int shadowRealmID = findFreeDimensionID();
	 public static final int shadowRealmType = 1;
	 
	 
	 
	 
	 
	 
	 
	 @Nullable
	 private static Integer findFreeDimensionID() {
	        for (int i=2; i<Integer.MAX_VALUE; i++) {
	            if (!DimensionManager.isDimensionRegistered(i)) {
	                // DEBUG
	                System.out.println("Found free dimension ID = "+i);
	                return i;
	            }
	        }
	        // DEBUG
	        System.out.println("ERROR: Could not find free dimension ID");
	        return null;
        }
	 
	 
	 
	 
    public static final void registerDimensions() {
    	DimensionManager.registerDimension(shadowRealmID, shadowRealmType);
    }
}
