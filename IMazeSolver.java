import java.io.FileNotFoundException;

public interface IMazeSolver {

    public int[][] solveBFS(java.io.File maze) throws FileNotFoundException;
    public int[][] solveDFS(java.io.File maze) throws FileNotFoundException;


}
