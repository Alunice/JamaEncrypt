/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamatest;

import java.util.*;
import Jama.*;
import java.math.*;

/**
 *
 * @author alun
 */
public class ReMatrix implements Comparable<ReMatrix> {
    private Matrix m1;
    private double det;
    private String filename;
    
    ReMatrix()
    {
        
    }
    
    ReMatrix (Matrix m1,double dd,String filename)
    {
        this.m1=(Matrix)m1.clone();
        this.det=dd;
        this.filename=filename;
    }
    
    public Matrix getMatrix()
    {
        return this.m1;
    }
    
    public double getDet()
    {
        return this.det;
    }
    
    public void setMatrix(Matrix m1)
    {
        this.m1=m1.copy();
    }
    
    public void setDet(double det)
    {
        this.det=det;
    }
    
    public void setFilename(String t)
    {
        this.filename=t;
    }
    
    public String getFilename()
    {
        return this.filename;
    }
    
    
    
    
    @Override
    public int compareTo(ReMatrix o) {
       
        if(this.det-o.det>0)
            return -1;
        else if(this.det-o.det<0)
            return 1;
        else return 0;
        
    }
    
}
