package Data;

public class Calculations {
	public static int[] calculateFrameWidths(double widths, double heights) {
		int[] result = new int[4];
		int a = (int) widths - 20 - 220;
		result[0] = 20;
		result [1] = a;
		result[2] = 110;
		result[3] = 110;
		return result;
	}
	
	public static int[] calculateFrameHeights(double widths, double heights) {
		int[] result = new int[3];
		int a = (int) widths - 13 - 13;
		result[0] = 13;
		result [1] = a;
		result[2] = 13;
		return result;
	}
//	gbl_panelPerson.columnWidths = new int[]{5, 170, 170, 170, 170, 5, 170, 170, 170, 170};
//	gbl_panelPerson.rowHeights = new int[]{0, 10, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30};
//	gbl_panelPerson.columnWidths = new int[]{12, 207, 207, 207, 207, 12, 207, 207, 207, 207};
//	gbl_panelPerson.rowHeights = new int[]{0, 10, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30};
	public static int[] calculatePanelWidths(double widths, double heights) {
		int[] result = new int[10];
		int width = (int) widths - 20 - 220;
		boolean a = false;
		double temp = width / 8;
		int b;
		while (a = false) {
			temp = temp - 0.1;
			System.out.println(temp);
			if (temp % 5 == 0) {
				a = true;
			}
		}
		for (int i = 0; i<=9; i++) {
		result[i] = (int) temp;
		}
		System.out.println(temp);
		b = (int) width - (int) (temp*8);
		System.out.println(b);
		result[0] = b/2;
		result[5] = b/2;
		return result;
	}
	
	public static int[] calculatePanelHeights(double widths, double heights) {
		int[] result = null;
		
		return result;
	}
}
