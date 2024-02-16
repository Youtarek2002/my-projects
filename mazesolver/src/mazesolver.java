import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class mazesolver implements IMazeSolver {
    public int arraychecker(char element , char [][] array,int rows , int columns)
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (array[i][j] == element) {
                    return 0;
                }
            }
        }
        return -1;  // Element not found
    }


    public int[][] solveBFS(File maze) throws FileNotFoundException {
        Scanner scan = new Scanner(maze);
        String temp=scan.nextLine();
        queue bfsx = new queue();
        queue bfsy = new queue();
        char c = temp.charAt(0);
        char b = temp.charAt(2);
        int row = c-'0';
        int col = b-'0';
        System.out.print("Bfs:");
        int[][] pathx = new int[row][col];
        int[][] pathy = new int[row][col];
        char [][] shape = new char[row][col];
        int i=0;
        int  j=0;
        int x=0;
        int y=0;
        int check=0,check1;
        while(scan.hasNextLine())
        {
            temp=scan.nextLine();
            for( j=0;j<col;j++)
            {
                shape[i][j]=temp.charAt(j);
                if(shape[i][j]=='S')
                {
                    x=i;
                    y=j;
                    bfsx.enqueue(x);
                    bfsy.enqueue(y);
                }
            }
            i++;
        }
        check=arraychecker('S',shape,row,col);
        check1=arraychecker('E',shape,row,col);
        if(check1!=0||check!=0)
        {
            System.out.print("'S' or 'E' may not be there!!");
            System.exit(0);
        }

        while(shape[x][y]!='E') {
            if ((x-1)>=0&&(x-1)<row&&y>=0&&y<col&&(shape[x - 1][y] == '.'||shape[x-1][y]=='E'))
            {
                bfsx.enqueue(x-1);
                bfsy.enqueue(y);
                if(shape[x-1][y]!='E')
                shape[x-1][y]='v';
                pathx[x-1][y]=x;
                pathy[x-1][y]=y;
                if(shape[x-1][y]=='E')
                {
                    x=x-1;
                    break;
            }}
            if((x+1)>=0&&(x+1)<row&&y>=0&&y<col&&(shape[x+1][y]=='.'||shape[x+1][y]=='E'))
            {
                bfsx.enqueue(x+1);
                bfsy.enqueue(y);
                if(shape[x+1][y]!='E')
                shape[x+1][y]='v';
                pathx[x+1][y]=x;
                pathy[x+1][y]=y;
                if(shape[x+1][y]=='E') {
                    x=x+1;
                    break;
                }
            }
            if((x)>=0&&(x)<row&&(y-1)>=0&&(y-1)<col&&(shape[x][y-1]=='.'||shape[x][y-1]=='E'))
            {
                bfsx.enqueue(x);
                bfsy.enqueue(y-1);
                if(shape[x][y-1]!='E')
                shape[x][y-1]='v';
                pathx[x][y-1]=x;
                pathy[x][y-1]=y;
               if(shape[x][y-1]=='E') {
                   y=y-1;
                   break;
               }
            }
            if((x)>=0&&(x)<row&&(y+1)>=0&&(y+1)<col&&(shape[x][y+1]=='.'||shape[x][y+1]=='E'))
            {
                bfsx.enqueue(x);
                bfsy.enqueue(y+1);
                if(shape[x][y+1]!='E')
                shape[x][y+1]='v';
                pathx[x][y+1]=x;
                pathy[x][y+1]=y;
                if(shape[x][y+1]=='E') {
                    y=y+1;
                    break;
                }
            }
            bfsx.dequeue();
            bfsy.dequeue();
            if(bfsx.isEmpty()==false){
                x = bfsx.peek();
                y=bfsy.peek();
            }
        }
        stack stackx = new stack();
        stack stacky = new stack();
        i=0;
        int k=0;
        while(true)
        {
            i++;
            stackx.push(x);
            stacky.push(y);
            j=x;
            k=y;
            x=pathx[j][k];
            y=pathy[j][k];
            if(shape[x][y]=='S') {
               stackx.push(x);
               stacky.push(y);
                break;
            }
        }
      while(i>=0)
      { i--;
          System.out.printf("{%d, %d}",stackx.peek(),stacky.peek());
          if(i>=0)
          {
              System.out.print(",");
          }
          stackx.pop();
          stacky.pop();
      }
        return new int[0][];
    }


    public int[][] solveDFS(File maze) throws FileNotFoundException{
        Scanner scan = new Scanner(maze);
        String temp=scan.nextLine();
        char c = temp.charAt(0);
        char b = temp.charAt(2);
        int row = c-'0';
        int col = b-'0';
        System.out.print("Dfs:");
        int[][] pathx = new int[row][col];
        int[][] pathy = new int[row][col];
        char [][] shape = new char[row][col];
        int i=0;
        int  j=0;
        int x=0;
        int y=0;
        stack dfsx = new stack();
        stack dfsy = new stack();
        while(scan.hasNextLine())
        {
            temp=scan.nextLine();
            for( j=0;j<col;j++)
            {
                shape[i][j]=temp.charAt(j);
                if(shape[i][j]=='S')
                {
                    x=i;
                    y=j;
                    dfsx.push(x);
                    dfsy.push(y);
                }
            }
            i++;
        }

        while(shape[x][y]!='E')
        {

            if ((x-1)>=0&&(x-1)<row&&y>=0&&y<col&&(shape[x - 1][y] == '.'||shape[x-1][y]=='E'))
            {
                dfsx.push(x-1);
                dfsy.push(y);
                if(shape[x-1][y]!='E')
                    shape[x-1][y]='v';
                pathx[x-1][y]=x;
                pathy[x-1][y]=y;
                if(shape[x-1][y]=='E')
                {
                    x=x-1;
                    break;
                }
                x=x-1;
            }
            else if((x+1)>=0&&(x+1)<row&&y>=0&&y<col&&(shape[x+1][y]=='.'||shape[x+1][y]=='E'))
            {
                dfsx.push(x+1);
                dfsy.push(y);
                if(shape[x+1][y]!='E')
                    shape[x+1][y]='v';
                pathx[x+1][y]=x;
                pathy[x+1][y]=y;
                if(shape[x+1][y]=='E') {
                    x=x+1;
                    break;
                }
                x=x+1;
            }
            else if((x)>=0&&(x)<row&&(y-1)>=0&&(y-1)<col&&(shape[x][y-1]=='.'||shape[x][y-1]=='E'))
            {
                dfsx.push(x);
                dfsy.push(y-1);
                if(shape[x][y-1]!='E')
                    shape[x][y-1]='v';
                pathx[x][y-1]=x;
                pathy[x][y-1]=y;
                if(shape[x][y-1]=='E') {
                    y=y-1;
                    break;
                }
                y=y-1;
            }
            else if((x)>=0&&(x)<row&&(y+1)>=0&&(y+1)<col&&(shape[x][y+1]=='.'||shape[x][y+1]=='E'))
            {
                dfsx.push(x);
                dfsy.push(y+1);
                if(shape[x][y+1]!='E')
                    shape[x][y+1]='v';
                pathx[x][y+1]=x;
                pathy[x][y+1]=y;
                if(shape[x][y+1]=='E') {
                    y=y+1;
                    break;
                }
                y=y+1;
            }
            else
            {
                dfsx.pop();
                dfsy.pop();
                x= dfsx.peek();
                y= dfsy.peek();
            }
        }

        stack stackx = new stack();
        stack stacky = new stack();
        int k =0;
        i=0;
        while(true)
        {
            i++;
            stackx.push(x);
            stacky.push(y);
            j=x;
            k=y;
            x=pathx[j][k];
            y=pathy[j][k];
            if(shape[x][y]=='S') {
                stackx.push(x);
                stacky.push(y);
                break;
            }
        }
        while(i>=0)
        { i--;
            System.out.printf("{%d, %d}",stackx.peek(),stacky.peek());
            if(i>=0)
            {
                System.out.print(",");
            }
            stackx.pop();
            stacky.pop();
        }


        return new int[0][];
    }






    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test 7.txt");
        Scanner sc = new Scanner(System.in);
        mazesolver solve = new mazesolver();
        int check=0;
        int path[][];
        char method='q';
        while(check==0)
        {
            method=sc.next().charAt(0);

            if((method=='0'||method=='1'))
                check=1;
            else
                System.out.println("Please enter a valid choice");
        }
        if(method=='0')
    {
            path = solve.solveBFS(file);
        }
        else if (method=='1')
        {
            path= solve.solveDFS(file);
        }

    }

}