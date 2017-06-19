/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamatest;

import Jama.*;

/**
 *
 * @author alun
 */
public final class MatrixEncrept {
    
    private Matrix M1;
    private Matrix M2;
    private Matrix M1n;
    private Matrix M2n;

    
    MatrixEncrept(double[][]m1,double[][]m2)
    {
        this.M1= new Matrix(m1);
        this.M2=new Matrix(m2);
        getInverse();
    }
    
   MatrixEncrept(Matrix m1,Matrix m2)
    {
        this.M1=(Matrix)m1.copy();
        this.M2=(Matrix)m2.copy();
        
        getInverse();
        
    }
    
    MatrixEncrept(int lenth)
    {
        Matrix m1 = Matrix.random(lenth, lenth).times(1000);
        while (m1.det()==0)
            m1= Matrix.random(lenth, lenth).times(1000);
        Matrix m2 = Matrix.random(lenth, lenth).times(1000);
        while (m2.det()==0)
            m2= Matrix.random(lenth, lenth).times(1000);
        this.M1=(Matrix)m1.clone();
        this.M2=(Matrix)m2.clone();
        getInverse();
    }
    
    MatrixEncrept()
    {
        this(3);
    }
    
    public void ShowMatrix()
    {
        System.out.println("M1 is :");
        this.M1.print(3, 0);
        System.out.println("M2 is :");
        this.M2.print(3, 0);
        
    }
    
    public void getInverse()
    {
        this.M1n=this.M1.inverse();
        this.M2n=this.M2.inverse();
    }
    
    
    public Matrix EncreptPlainText(Matrix plain)
    {
        Matrix res = this.M1.times(plain.times(this.M2));
        return res;
    }
    
    public Matrix EncreptSearchText(Matrix search)
    {
        Matrix res = this.M2n.times(search.times(this.M1n));
        
        return res;
    }
    
    public Matrix DecreptSecretText(Matrix secret)
    {
        Matrix res = this.M1n.times(secret.times(this.M2n));
        return res;
    }
    
    public Matrix ChangePlainText(double[] finger)
    {
        int len = finger.length;
        double[][] matrixfinger = new double[len+2][len+2];
        double count=0;
        for(int i =0;i<len;i++)
        {
            matrixfinger[i][i]=finger[i];
            count+=Math.pow(finger[i], 2);
            
        }
        count=count*(-0.5);
        matrixfinger[len][len]=count;
        matrixfinger[len+1][len+1]=1;
        Matrix res = new Matrix(matrixfinger);
        
        
        return res;
        
        
    }
    
    
    public Matrix ChangeSearchText(double[] finger)
    {
        int len = finger.length;
        double[][] matrixfinger = new double[len+2][len+2];
        for(int i =0;i<len;i++)
        {
            matrixfinger[i][i]=finger[i];
            
        }
        matrixfinger[len][len]=1;
//        matrixfinger[len+1][len+1]=Math.ceil(Math.random()*142);
        matrixfinger[len+1][len+1]=233;
        Matrix res = new Matrix(matrixfinger);
        
        
        return res;
        
        
    }
    
    public Matrix getM1()
    {
        return this.M1;
    }
    
    public Matrix getM2()
    {
        return this.M2;
    }
    
    
    
}
