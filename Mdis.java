import java.util.Scanner;

class FindDistace{
    private int x,y,z,d,t1,t2,t3,t,m2[][]=new int[7][4],k;
    void CalcDistance(int[][] m,int n){
        Scanner s =new Scanner(System.in);
        m2[1][0]=m2[2][0]=m2[0][0]=1000;
        System.out.println("enter the present x y and z codinate ");
        x=s.nextInt();
        y=s.nextInt();
        z=s.nextInt();
        for (int i = 0; i < n; i++) {
            d=((x-m[i][0])*(x-m[i][0]))+((y-m[i][1])*(y-m[i][1]))+((z-m[i][2])*(z-m[i][2]));
            System.out.println("distance between present codinate and "+(i+1)+" = "+d );
 
            if (m2[i][0]>d) {
                t=m2[i][0];
                m2[i][0]=d;
                d=t;t1=m2[i][1];t2=m2[i][2];t3=m2[i][3];
                m2[i][1]=m[i][0];
                m[i][0]=t1;
                m2[i][2]=m[i][1];
                m[i][1]=t2;
                m2[i][3]=m[i][2]; 
                m[i][2]=t3;              
            }
        }
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted m2
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (m2[j][0] < m2[min_idx][0])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            for (int k = 0; k < 4; k++) {
            int temp = m2[min_idx][k];
            m2[min_idx][k] = m2[i][k];
            m2[i][k] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(m2[i][j]+" ");
                
            }
            System.out.println();
        }
        // System.out.println("nearest distance = " +n2+" codinates are "+nx+" "+ny+ " "+nz);
    }

}
public class Mdis{
    public static void main(String args[]){
        int n, m[][] = new int[6][3];
        FindDistace d = new FindDistace();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of positions");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter codinate number "+ (j+1));
                m[i][j]=sc.nextInt();
            }
        }
        d.CalcDistance(m, n);
        

    }

}