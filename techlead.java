public class Cell{
int row;
int col;
char color;

public Cell(int x, int y, char color){
	this.row = x;
	this.col = y;
	this.color = color;
}

public int getRow(){
	return this.row;
}
public int getCol(){
	return this.col;
}

public char getColor(){
	return this.color;
}
}
char[][] m = {{ 'B', 'B', 'W', 'R' },{ 'B', 'W', 'R', 'W' },{ 'R', 'W', 'W', 'W' } };
public int techLeadQ(char[][] matrix){
	int max = 0;
	for(int i = 0; i<matrix.length;i++){
		for(int j = 0; j<matrix[i].length;j++){
			if(matrix[i][j]!='*'){
				System.out.println(matrix[i][j]);
				int curr_max = bfs(matrix,i,j,matrix[i][j]);
				System.out.println(curr_max);
				max = Math.max(max,curr_max);
			}
		}
	}
	return max;
} 

public int bfs(char[][] matrix, int row, int col, char color){
	Queue<Cell> q = new LinkedList<>();
	int size=0;
	q.offer(new Cell(row,col,color));
	matrix[row][col]= '*';
	while(!q.isEmpty()){
		Cell curr = q.poll();
		if(curr.getColor()==color){
			size++;
		}
		for(int i = -1;i<=1;i++){
			for(int j = -1; j<=1;j++){
				if(row+i>=0&&row+i<matrix.length&&col+j>=0&&col+j<matrix[0].length&&matrix[row+i][col+j]==color){
					Cell adj = new Cell(row+i,col+j,color);
					if(matrix[row+i][col+j]!='*'){
						size++;
						q.offer(adj);
						matrix[row+i][col+j]='*';
					}
				}
			}
		}

	}
	return size;
}
public int dfs(char[][] matrix, int row, int col, char color){
	if(row<0||col<0||row>=matrix.length||col>=matrix[0].length||matrix[row][col]!=color){
		return 0;
	}
	matrix[row][col]='*';
	return 1+dfs(matrix,row+1,col,color)+dfs(matrix,row-1,col,color)+dfs(matrix,row,col+1,color)+dfs(matrix,row,col-1,color);
}

