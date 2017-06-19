/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamatest;

import Jama.*;
import java.io.*;
import java.util.*;
import java.math.*;

/**
 *
 * @author alun
 */
public class SecureIOTest {
    private File url;
    String directory;
    
    
    SecureIOTest()
    {
        this.url=new File("./TempFingerPrint");
        if(!this.url.exists())
        {
            // TODO Auto-generated catch block
            
            this.url.mkdir();  
        }
        this.directory="./TempFingerPrint/";
        
    }
    
    SecureIOTest(String url)
    {
        this.url=new File(url);
        if(!this.url.exists())
        {
            // TODO Auto-generated catch block
            
            this.url.mkdir();  
        }
        this.directory=url+"/";
    }
    
    public double[] RandomArray(int len)
    {
        double[] res = new double[len];
        for(int i=0;i<len;i++)
        {
            res[i]=Math.random()*233*Math.random();
        }
        return res;
    }
    
    public void LoadFingerTest(String filename,double[][] mm) throws IOException
    {
        try (FileWriter writer = new FileWriter(this.directory+filename)) {
            for (double[] mm1 : mm) {
                for (int j = 0; j < mm1.length; j++) {
                    writer.write(mm1[j] + " ");
                }
                writer.write("\r\n");
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
