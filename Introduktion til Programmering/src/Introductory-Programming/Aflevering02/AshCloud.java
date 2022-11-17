import java.text.DecimalFormat;

//I define my class
public class AshCloud {
	int n;
	double f;
	double[][] grid;
//I use a constructor to define and import the values from the test class. 
public AshCloud(int n, double f) {
	this.n = n;
	this.f = f;

	grid=new double [n][n];
}
public double[][]runSimulation(char dir, int steps ){

	
	double Volcenter=1.00;
	grid[n/2][n/2]=Volcenter;

	int startPos=n/2;
 
double s=(1.00-f)/2;


for (int u=1;u<=steps;u++) {

	double newGrid[][]=new double[n][n];

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
	for(int i=1; i<n-1;i++) {
		for(int j=1; j<n-1;j++) {
			newGrid[i-1][j]+=grid[i][j]*f;
			newGrid[i-1][j+1]+=grid[i][j]*s;
			newGrid[i-1][j-1]+=grid[i][j]*s;
		}
	}
}
if (dir=='W') {
	for(int i=1; i<n-1;i++) {
		for(int j=1; j<n-1;j++) {
			newGrid[i][j+1]+=grid[i][j]*f;
			newGrid[i+1][j+1]+=grid[i][j]*s;
			newGrid[i-1][j+1]+=grid[i][j]*s;
		}
	}
}
if (dir=='E') {
	for(int i=1; i<n-1;i++) {
		for(int j=1; j<n-1;j++) {
			newGrid[i][j-1]+=grid[i][j]*f;
			newGrid[i+1][j-1]+=grid[i][j]*s;
			newGrid[i-1][j-1]+=grid[i][j]*s;
		}
	}
}

for(int i=1; i<n-1;i++) {
	for(int j=1; j<n-1;j++) {
grid[i][j]=newGrid[i][j];
	}}
grid[n/2][n/2]+=Volcenter;
}

return grid;

}
}
