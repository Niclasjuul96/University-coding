
import java.text.DecimalFormat;

//I define my class
public class AshCloud {
	int n;
	double f;
	double[][] grid;
//I use a constructor to define and import the values from the test class. I also import the grid from the last win direction change, if there was one 
public AshCloud(int n, double f) {
	this.n = n;
	this.f = f;

//The new array with empty spaces "0.00"
	grid=new double [n][n];
}
public double[][]runSimulation(char dir, int steps ){
//I define the volcanos center to be 1.00
	double Volcenter=1.00;
	grid[n/2][n/2]=Volcenter;
//This s value defines the ash values which is put in the diagonal grid places from the volcano.
double s=(1.00-f)/2;
//This loop will run all the steps 
for (int u=1;u<=steps;u++) {
//I make a "newGrid" which will temporarily carry all the values from the grid
	double newGrid[][]=new double[n][n];
/*I make a loop for the different wind directions.
The loop will run through the whole grid and shift the values from the volcano in the direction of the wind. 
The direction of the wind is defined by the changing of the j and i values and what is added or subtracted. 
The amount of ash is defined by f which in turn defines s.
*/
if (dir=='N') {
	for(int i=1; i<n-1;i++) {
		for(int j=1; j<n-1;j++) {	
			newGrid[i+1][j]+=grid[i][j]*f;
			newGrid[i+1][j+1]+=grid[i][j]*s;
			newGrid[i+1][j-1]+=grid[i][j]*s;
		}
	}
}
if (dir=='S') {
	for(int i=1;i<n-1;i++) {
		for(int j=1; j<n-1;j++) {
			newGrid[i-1][j]+=grid[i][j]*f;
			newGrid[i-1][j+1]+=grid[i][j]*s;
			newGrid[i-1][j-1]+=grid[i][j]*s;
		}
	}
}
if (dir=='W') {
	for(int i=1;i<n-1;i++) {
		for(int j=1;j<n-1;j++) {
			newGrid[i][j+1]+=grid[i][j]*f;
			newGrid[i+1][j+1]+=grid[i][j]*s;
			newGrid[i-1][j+1]+=grid[i][j]*s;
		}
	}
}
if(dir=='E'){
	for(int i=1; i<n-1;i++){
		for(int j=1; j<n-1;j++){
			newGrid[i][j-1]+=grid[i][j]*f;
			newGrid[i+1][j-1]+=grid[i][j]*s;
			newGrid[i-1][j-1]+=grid[i][j]*s;
		}
	}
}
//This loop will run through the newGrid and ad the add the values to the original grid 
for(int i=1; i<n-1;i++) {
	for(int j=1;j<n-1;j++) {
grid[i][j]=newGrid[i][j];
	}}
grid[n/2][n/2]+=Volcenter;
}
//Now i make a return grid statement
return grid;
}
}
