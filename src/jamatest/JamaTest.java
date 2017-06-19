/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamatest;

/**
 *
 * @author alun
 */
import Jama.*;
import java.io.IOException;
import java.util.*;
import java.io.*;






public class JamaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
    

//        SecureIOTest al = new SecureIOTest();
//        MatrixEncrept me = new MatrixEncrept(5);
//        for(int i=0;i<20;i++)
//        {
//            al.LoadFingerTest("Test"+i, me.EncreptPlainText(me.ChangePlainText(al.RandomArray(3))).getArray());
//        }
//      
//        FileWriter wt = new FileWriter("./secretKey/M1");
//        FileWriter wt2 = new FileWriter("./secretKey/M2");
//        
//        double[][] mm = me .getM1().getArray();
//        double [][] nn =me.getM2().getArray();
//        for (double[] mm1 : mm) {
//                for (int j = 0; j < mm1.length; j++) {
//                    wt.write(mm1[j] + " ");
//                }
//                wt.write("\r\n");
//            }
//        wt.close();
//        
//        for (double[] nn1 : nn) {
//                for (int j = 0; j < nn1.length; j++) {
//                    wt2.write(nn1[j] + " ");
//                }
//                wt2.write("\r\n");
//            }
//        wt2.close();
        



        
//       File fl1 = new File("./secretKey","M1");
//       File fl2 = new File("./secretKey","M2");
//        BufferedReader bf1 = new BufferedReader(new FileReader(fl1));
//       BufferedReader bf2 = new BufferedReader(new FileReader(fl2));
//        Matrix m1 = Matrix.read(bf1);
//        Matrix m2 = Matrix.read(bf2);

//        MatrixEncrept alun = new MatrixEncrept(m1,m2);
//       SecureIOTest al = new SecureIOTest();
//               for(int i=0;i<200;i++)
//        {
//            al.LoadFingerTest("Testi"+i, alun.EncreptPlainText(alun.ChangePlainText(al.RandomArray(3))).getArray());
//        }
       
       
       
        
//       double[] test = {1,6,6};
//        al.LoadFingerTest("speciouTest", alun.EncreptPlainText(alun.ChangePlainText(test)).getArray());
        
//        ServerCaculate tt = new ServerCaculate(new File("./TempFingerPrint"));
//        
//        double [] find = {7,107,15};
//        Matrix  ff = alun.EncreptSearchText(alun.ChangeSearchText(find));
//        ArrayList<ReMatrix> res =(ArrayList<ReMatrix>)tt.FindDistance(ff, 4).clone();
//        
//        System.out.println("the search FingerPrint is:");
//        for(double l:find)
//            System.out.print(l+"\t");
//        System.out.print("\n");
//        
//        for(ReMatrix ll:res)
//        {
//            System.out.println("filename is :"+ll.getFilename());
//            System.out.println("distance is :"+ll.getDet());
//            alun.DecreptSecretText(ll.getMatrix()).print(4, 5);
//            
//        }
        
        AutoTest al = new AutoTest();
        al.AutoSampleTest();
        
        


        
    }
    
}
