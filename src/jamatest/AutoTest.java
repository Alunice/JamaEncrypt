/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamatest;
import Jama.Matrix;
import java.io.*;
import java.util.*;

/**
 *
 * @author alun
 */
public class AutoTest {
    
    private String url;
    
    AutoTest()
    {
        this.url="./autoTest";
        File fl = new File(this.url);
        if(!fl.exists())
        {
            fl.mkdir();
        }
        
    }
    AutoTest(String t)
    {
        this.url=t;
        File fl = new File(this.url);
        if(!fl.exists())
        {
            fl.mkdir();
        }
    }
    
    public void AutoSampleTest() throws IOException
    {
        SecureIOTest al = new SecureIOTest(this.url+"/data");
        MatrixEncrept me = new MatrixEncrept(6);
        File fl = new File(this.url+"/secretKey");
        if(!fl.exists())
            fl.mkdir();
      
        FileWriter wt = new FileWriter(this.url+"/secretKey/M1");
        FileWriter wt2 = new FileWriter(this.url+"/secretKey/M2");
        
        double[][] mm = me .getM1().getArray();
        double [][] nn =me.getM2().getArray();
        for (double[] mm1 : mm) {
                for (int j = 0; j < mm1.length; j++) {
                    wt.write(mm1[j] + " ");
                }
                wt.write("\r\n");
            }
        wt.close();
        
        for (double[] nn1 : nn) {
                for (int j = 0; j < nn1.length; j++) {
                    wt2.write(nn1[j] + " ");
                }
                wt2.write("\r\n");
            }
        wt2.close();
        
        System.out.println("the M1 is:");
        me.getM1().print(4, 5);
        
        System.out.println("the M2 is:");
        me.getM2().print(4, 5);
        
        System.out.println("creat 200 test fingerprints for test....");
           for(int i=0;i<200;i++)
        {
            al.LoadFingerTest("autoTest"+i, me.EncreptPlainText(me.ChangePlainText(al.RandomArray(4))).getArray());
        }
           
        System.out.println("Creat compelet!");
        
        System.out.println("Creat 1 special FingerPrint....");
        double[] special = {233,666,88,11};
        al.LoadFingerTest("speciouTest", me.EncreptPlainText(me.ChangePlainText(special)).getArray());
        System.out.println("the special one is :233 666 88  11");
        
        ServerCaculate tt = new ServerCaculate(new File(this.url+"/data"));
        
        System.out.println("search test one is :232 656 77 12");
        double[] sc = {232,656,77,12};
        
        Matrix  ff = me.EncreptSearchText(me.ChangeSearchText(sc));
        ArrayList<ReMatrix> res =(ArrayList<ReMatrix>)tt.FindDistance(ff, 4).clone();
        
        System.out.println("the search FingerPrint is:");
        
        for(ReMatrix ll:res)
        {
            System.out.println("filename is :"+ll.getFilename());
            System.out.println("distance is :"+ll.getDet());
            me.DecreptSecretText(ll.getMatrix()).print(4, 5);
            
        }
        
        
        
        
        
        
        
    }
    
}
