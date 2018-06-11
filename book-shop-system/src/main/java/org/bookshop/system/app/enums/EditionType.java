package org.bookshop.system.app.enums;

//import java.util.HashMap;
//import java.util.Map;

public enum EditionType {
//	NORMAL("1"),
//	PROMO("2"), 
//	GOLD("3");
//	
//	private final String id;
//
//	private EditionType(String id) {
//		this.id = id;
//	}
//
//	public String getId() {
//		return id;
//	}
	NORMAL,
	PROMO, 
	GOLD;
//	
//	private String type;
//
//	private EditionType(String type) {
//		this.type = type;
//	}
//
//	public String getType() {
//		return type;
//	}
//	
//	//****** Reverse Lookup Implementation************//
//	 
//    //Lookup table
//    private static final Map<String, EditionType> lookup = new HashMap<>();
//  
//    //Populate the lookup table on loading time
//    static
//    {
//        for(EditionType env : EditionType.values())
//        {
//            lookup.put(env.getType(), env);
//        }
//    }
//  
//    //This method can be used for reverse lookup purpose
//    public static EditionType get(String type)
//    {
//        return lookup.get(type);
//    }
}
