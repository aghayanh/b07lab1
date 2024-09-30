import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Polynomial
{
    double[] coef;
    int[] power;
    Polynomial()
    {
        coef = new double[]{0};
        power = new int[]{0};
    }
    Polynomial(double[] coef, int[] power)
    {
        this.coef = coef;
        this.power = power;
    }
    // Polynomial(File file)
    // {
    //     file = new File("C:/Users/Hayk/Desktop/file.txt");
    //     BufferedReader reader = new BufferedReader(new FileReader(file));
    //         String eq = reader.readLine();
    //         reader.close();
        
    //     String[] terms = eq.split("+-");
    //     coef = new double[terms.length];
    //     power = new int[terms.length];
    //     int ind = 0;
        
    //     for(int i = 0; i < terms.length; i++)
    //     {
    //         double coefnow;
    //         int powernow;
    //         if(terms[i].contains("x"))
    //         {
    //             coefnow = 1;
    //             powernow = 1;
    //             String[] now = terms[i].split("x");
    //             if(now.length == 0)
    //             {
    //                 powernow = 1;
    //             }
    //             if(now.length == 1)
    //             {
    //                 if(terms[i].charAt(0) == 'x')
    //                 {
    //                     powernow = Integer.parseInt(now[0]);
    //                 }
    //                 else
    //                 {
    //                     coefnow = Double.parseDouble(now[0]);
    //                 }
    //             }
    //             else
    //             {
    //                 powernow = Integer.parseInt(now[1]);
    //                 coefnow = Double.parseDouble(now[0]);
    //             }
    //         }
    //         else
    //         {
    //             coefnow = Integer.parseInt(terms[i]);
    //             powernow = 0;
    //         }
    //         coef[ind] = coefnow;
    //         power[ind] = powernow;
    //     }
    // }
    Polynomial add(Polynomial pol)
    {
        int total = pol.coef.length+this.coef.length;
        Polynomial a = new Polynomial();
        a.coef = new double[total+1];
        a.power = new int[total+1];
        for(int i = 0; i < this.coef.length; i++)
        {
            a.coef[i] = this.coef[i];
            a.power[i] = this.power[i];
        }
        int index = this.coef.length;
        for(int i = 0; i < pol.power.length; i++)
        {
            boolean check = false;
            for(int j = 0; j < a.power.length; j++)
            {
                if(pol.power[i] == a.power[j])
                {
                    check = true;
                    a.coef[j] += pol.coef[i];
                }
            }
            if(!check)
            {
                a.power[index] = pol.power[i];
                a.coef[index] = pol.coef[i];
                index++;
            }
        }
        Polynomial b = new Polynomial();
        b.coef = new double[index];
        b.power = new int[index];
        for(int i = 0; i < index; i++)
        {
            b.coef[i] = a.coef[i];
            b.power[i] = a.power[i];
        }
        return b;
    }
    double evaluate(double x)
    {
        double ans = 0;
        for(int i = 0; i < this.power.length; i++)
        {
            ans += this.coef[i]*Math.pow(x, this.power[i]);
        }
        return ans;
    }
    boolean hasRoot(double x)
    {
        return evaluate(x) == 0;
    }
    Polynomial multiply(Polynomial pol)
    {
        int index = 0;
        Polynomial a = new Polynomial();
        int total = pol.coef.length * this.coef.length;
        a.coef = new double[total+1];
        a.power = new int[total+1];
        index = 0;
        for(int i = 0; i < this.power.length; i++)
        {
            for(int j = 0; j < pol.power.length; j++)
            {
                boolean check = false;
                for(int k = 0; k < index; k++)
                {
                    if(this.power[i]*pol.power[j] == a.power[k])
                    {
                        check = true;
                        a.coef[k] += this.coef[i]*pol.coef[j];
                    }
                }
                if(!check)
                {
                    a.coef[index] = this.coef[i]*pol.coef[j];
                    a.power[index] = this.power[i]*pol.power[j];
                    index++;
                }
            }
        }
        Polynomial b = new Polynomial();
        b.coef = new double[index];
        b.power = new int[index];
        for(int i = 0; i < index; i++)
        {
            b.coef[i] = a.coef[i];
            b.power[i] = a.power[i];
        }
        return b;
    }
    
}