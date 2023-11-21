package Basics;

public class Arrays {
	public static void main(String[] args) {
		int[] od= {5,2,6,8,0};
		for(int i=0;i<od.length;i++) {
			System.out.println(od[i]);
			
		}
        int[][] md = {
                {1, 2, 3, 4, 5},
                {10, 20, 30, 40, 50},
                {13, 24, 35, 46, 57},
                {10, 23, 35, 48, 58}
        };

        for (int i = 0; i < md.length; i++) {
            for (int j = 0; j < md[i].length; j++) {
                System.out.print(md[i][j] + " ");
            }
            System.out.println();
        }

	}

}
