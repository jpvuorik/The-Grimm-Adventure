/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;

/**
 *
 * @author John
 */
public class Exit {
	public static final int UP = 0;
        public static final int SOUTHWEST = 1;
	public static final int SOUTH = 2;
        public static final int SOUTHEAST = 3;
        public static final int WEST  = 4;
        public static final int DOWN  = 5;
        public static final int EAST  = 6;
        public static final int NORTHWEST = 7;
        public static final int NORTH = 8;
	public static final int NORTHEAST = 9;

	public static final String[] directionName = 
	{ 
		"UP",
		"SOUTHWEST",
		"SOUTH",
		"SOUTHEAST",
		"WEST",
		"DOWN",
                "EAST",
                "NORTHWEST",
                "NORTH",
		"NORTHEAST",
		
	};

	public static final String[] shortDirectionName = 
	{
		"U",
                "SW",
		"S",
		"SE",
		"W",
		"D",                
                "E",
		"NW",
		"N",
		"NE",	
	};

}
