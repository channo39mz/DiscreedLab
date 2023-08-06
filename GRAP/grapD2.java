public class grapD2 {
    public static void main(String[] args) {
        int a[][]={ {1,1,1},
                    {1,1,1},
                    {1,1,1} 
                };    

        int b[][]={ 
                    {1,1,1},
                    {2,2,2},
                    {3,3,3}};    
        powmatrix Matrix = new powmatrix(a, b);
        // Matrix.multiply_matrix(Matrix.getMatrixA(),Matrix.getMatrixB());
        for (int[] i : Matrix.power_matrix(a, 2)){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }       
    }
}

class powmatrix{
    int matrixA[][];
    int matrixB[][];
    public powmatrix(int[][] a, int[][] b){
        this.matrixA = a;
        this.matrixB = b;
    }
    public int[][] getMatrixA() {
        return matrixA;
    }
    public int[][] getMatrixB() {
        return matrixB;
    }
    public void setMatrixA(int[][] matrixA) {
        this.matrixA = matrixA;
    }
    public void setMatrixB(int[][] matrixB) {
        this.matrixB = matrixB;
    }
    public int[][] multiply_matrix(int[][] a, int[][] b){
        int c[][]=new int[a.length][b[0].length];
        if (a[0].length == b.length){
            for(int i=0; i<a.length ;i++){    
                for(int j=0;j< b[0].length;j ++){    
                    c[i][j]=0;      
    
                    for(int k=0;k<a.length;k++)      
                        {      
                            c[i][j] += a[i][k] * b[k][j];      
                        }
                    // System.out.print(c[i][j]+" ");
                }
            // System.out.println();   
            } 
            return(c);
        }
        System.out.println("error");
        return c;
    }
    public int[][] easy_multiply_matrix(int[][] a, int b){
        int c[][] = a;
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < c[0].length; j++){
                c[i][j] = c[i][j] * b;
            }
        }
        return c;
    }
    public int[][] power_matrix(int[][] a, int b){
        int c[][] = a;
        if(b == 1){
            return a;
        }
        for (int u = 0; u < b-1; u++){
            // System.out.println("1");
            c = multiply_matrix(a, c);
      
        }
        return(c);
      
    }
}

