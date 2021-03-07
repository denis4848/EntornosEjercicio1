import java.util.Date;
public abstract class Tarjeta
{
	public String numero, titular;
	public Date fechaDeCaducidad;
	public Cuenta cuentaAsociada;
	public Tarjeta(String _numero, String _titular, Date _fechaCaducidad)
	{
		numero=_numero;
		titular=_titular;
		fechaDeCaducidad=_fechaCaducidad;
	}
	
	public void setCuenta(Cuenta c)
	{
		cuentaAsociada=c;
	}
	public abstract void retirar(double x) throws Exception;
	public abstract void ingresar(double x) throws Exception;
	public abstract void pagoEnEstablecimiento(String datos, double x) throws Exception;
	public abstract double getSaldo();
}