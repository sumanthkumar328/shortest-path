
//This is a java program to find the shortest path between source vertex and destination vertex
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Short {
	public static void main(String... arg) {
		int adjacency_matrix[][];
		int number_of_rows;
		int number_of_columns;
		int source = 0, destination = 0;
		boolean traversed = false;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter the number of rows");
			number_of_rows = scan.nextInt();

			System.out.println("Enter the number of columns");
			number_of_columns = scan.nextInt();

			adjacency_matrix = new int[number_of_rows][number_of_columns];

			System.out.println("Enter the Weighted Matrix for the graph");
			for (int i = 0; i < number_of_rows; i++) {
				for (int j = 0; j < number_of_columns; j++) {
					adjacency_matrix[i][j] = scan.nextInt();
				}
			}
			int row = 0;
			int column = 0;
			int current = 1000;
			int total_cost = 0;
			boolean finish = false;
			int top = 1000;
			int middle = 1000;
			int bottom = 1000;

			for (int i = 0; i < number_of_rows; i++) {
				int current1 = adjacency_matrix[i][0];
				
				if (current < current1) {

				} else {
					current = current1;
					//row=i;
				}
			}
			total_cost = total_cost + current;
			if (number_of_columns == 1) {

				System.out.println("total_cost:" + total_cost);
				System.exit(0);
			}
			if (number_of_columns - 1 >= column + 1) {
				middle = adjacency_matrix[row][column + 1];
				// total_cost=total_cost+middle;
			}
			if (number_of_columns - 1 >= column + 1 && number_of_rows - 1 >= row + 1) {
				bottom = adjacency_matrix[row + 1][column + 1];
				// total_cost=total_cost+bottom;
			}
			List<Integer> path = new ArrayList<Integer>();
			List<Integer> numbers = new ArrayList<Integer>();
			path.add(row + 1);

			if (middle < bottom) {
				current = middle;
				column = column + 1;
				path.add(row + 1);
				total_cost = total_cost + middle;
			} else {
				current = bottom;
				column = column + 1;
				row = row + 1;
				path.add(row + 1);
				total_cost = total_cost + bottom;
			}

			while (!finish) {

				if (column + 1 >= number_of_columns) {
					finish = true;
					break;
				}
				/*
				 * if (row + 1 == 1) { finish = true; break; }
				 */
				if (number_of_columns - 1 >= column + 1 && row - 1 >= 0) {
					top = adjacency_matrix[row + 1][column + 1];
					// total_cost=total_cost+top;
				}

				/*
				 * top = adjacency_matrix[row - 1][column + 1]; middle =
				 * adjacency_matrix[row][column + 1]; bottom =
				 * adjacency_matrix[row + 1][column + 1];
				 */

				if (number_of_columns - 1 >= column + 1) {
					middle = adjacency_matrix[row][column + 1];
					// total_cost=total_cost+middle;
				}
				if (number_of_columns - 1 >= column + 1 && number_of_rows - 1 >= row + 1) {
					bottom = adjacency_matrix[row + 1][column + 1];
					// total_cost=total_cost+bottom;
				}

				if (top < middle) {
					if (top < bottom) {
						System.out.println("A is the smallest");
						current = top;
						total_cost = total_cost + top;
						column = column + 1;
						row = row - 1;
					} else {
						current = bottom;
						total_cost = total_cost + bottom;
						column = column + 1;
						row = row + 1;
					}
				} else {
					if (middle < bottom) {
						current = middle;
						total_cost = total_cost + middle;
						column = column + 1;
					} else {
						current = bottom;
						total_cost = total_cost + bottom;
						column = column + 1;
						row = row + 1;
					}
				}
				path.add(row + 1);
			}
			
			
			/*for(int i=1;i<number_of_rows;i++){
				path.get(i);
			}*/
			
			List<Integer> number = IntStream.rangeClosed(1, number_of_rows)
				    .boxed().collect(Collectors.toList());
			
			if(number.containsAll(path)){
				System.out.println("Traversed through all rows: Yes");
			} else { 
				System.out.println("Traversed through all rows: No");
			}
			
			System.out.println("total_cost:" + total_cost);
			System.out.println("Path: "+path);


			scan.close();
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Invalid Matrix.");
			main();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
