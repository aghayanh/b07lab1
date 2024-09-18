class Polynomial
{
    double[] coef;
    Polynomial()
    {
        coef = new double[]{0};
    }
    Polynomial(double[] coef)
    {
        this.coef = coef;
    }
    Polynomial add(Polynomial pol)
    {
        Polynomial a;
        boolean check = false;
        if(this.coef.length >= pol.coef.length)
        {
            a = new Polynomial(this.coef);
        }
        else
        {
            check = true;
            a = new Polynomial(pol.coef);
        }
        for(int i = 0; i < Math.min(this.coef.length, pol.coef.length); i++)
        {
            if(!check)
            {
                a.coef[i]+=pol.coef[i];
            }
            else
            {
                a.coef[i]+=this.coef[i];
            }
        }
        return a;
    }
    double evaluate(double x)
    {
        double quant = 1;
        double ans = 0;
        for(int i = 0; i < this.coef.length; i++)
        {
            ans+=quant*this.coef[i];
            quant*=x;
        }
        return ans;
    }
    boolean hasRoot(double x)
    {
        return evaluate(x) == 0;
    }
}