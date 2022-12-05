package pos;

import java.awt.Color;

public final class final_Layout {
	//  public 
	public static final int PAGE_WIDTH=1200;
	public static final int PAGE_HEIGHT=900;
	public static final int PAGE_BORDER=5;
	public static final int PANEL_BORDER=5;
	
	//  header
	public static final int HEADER_WIDTH=1200;
	public static final int HEADER_HEIGHT=30;
	public static final Color HEADER_BACKGROUND= Color.CYAN;
	
	
	
	//order menu
	public static final int PENEL_WEST = 500;
	public static final int PENEL_CENTER = 400;
	public static final int PENEL_EAST = 300;
	
	public static final int PENEL_HEIGHT = PAGE_HEIGHT-HEADER_HEIGHT;
	
	public static final int PENEL_WEST_UI_WIDTH = PENEL_WEST-PAGE_BORDER;
	public static final int PENEL_CENTER_UI_WIDTH = PENEL_CENTER-PAGE_BORDER;
	public static final int PENEL_EAST_UI_WIDTH = PENEL_CENTER-PAGE_BORDER;
	
	public static final Color ORDERMENU_BACKGROUND = Color.BLACK;
	public static final Color ORDERMENU_PANELCOLOR = Color.GRAY;
	
}
