/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamatest;


import java.io.*;
import java.util.*;
import Jama.*;
import java.lang.Math;

/**
 *
 * @author alun
 */
public class ServerCaculate {
    File url;
    String[] files;
    
    ServerCaculate()
    {
        this.url=new File("./EncreptFingerPrint");
        this.files=this.url.list();
    }
    
    ServerCaculate(File fl)
    {
        this.url=fl;
        this.files = fl.list();
    }
    
    public void ShowFile() throws FileNotFoundException, IOException
    {
        ArrayList<Matrix> matbuf = new ArrayList();
        for(String file : this.files)
        {
            File f= new File(this.url,file);
            BufferedReader bf = new BufferedReader(new FileReader(f));
            Matrix temp = Matrix.read(bf);
            matbuf.add(temp);
            System.out.println("filename is :"+file);
            temp.print(3, 0);
            
        }
        
    }
    public ArrayList<ReMatrix> FindDistance(Matrix fd,int k) throws IOException
    {
        ArrayList<ReMatrix> tempres = new ArrayList();
        FindDistanceCore(tempres,k,fd);
        

        return tempres;
    }
    
    
    public void FindDistanceCore(ArrayList<ReMatrix> res,int k,Matrix fd) throws FileNotFoundException, IOException
    {
        
        for(String file : this.files)
        {
            File f= new File(this.url,file);
            BufferedReader bf = new BufferedReader(new FileReader(f));
            Matrix temp = Matrix.read(bf);
            Matrix p1 = temp.times(fd);
            double[] detsum = p1.eig().getRealEigenvalues();
            double det=0;
            for(double i:detsum)
            {
//                det+=Math.abs(i);
                
                det+=i;
            }
            InsertMatrix(res,k,temp,det,file);              
        }
    }
    
    public void InsertMatrix(ArrayList<ReMatrix>res,int k,Matrix tt,double det,String filename)
    {
        int len = res.size();
        ReMatrix temp = new ReMatrix(tt,det,filename);
        if(len <k)
        {
            res.add(temp);
            Collections.sort(res);
            return;
        }else 
        {
            
                res.add(temp);
                Collections.sort(res);
                res.remove(k);
            
        }
    }
    
    
    

    
    
}
