import java.util.Date;
public class Debito extends Tarjeta
{
	public Debito(String _numero, String _titular, Date _fechaCaducidad)
	{
		super(_numero, _titular, _fechaCaducidad);
	}
	public void retirar(double x) throws Exception
	{
		this.cuentaAsociada.retirar("Retirada en cajero autom�tico", x);
	}
	public void ingresar(double x) throws Exception
	{
		this.cuentaAsociada.retirar("Ingreso en cajero autom�tico", x);
	}
	public void pagoEnEstablecimiento(String datos, double x) throws Exception
	{
		this.cuentaAsociada.retirar("Compra en :" + datos, x);
	}
	public double getSaldo()
	{
		return cuentaAsociada.getSaldo();
	}
}
